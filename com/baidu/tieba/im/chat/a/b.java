package com.baidu.tieba.im.chat.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public abstract class b extends BaseAdapter {
    protected Context mContext;
    protected List<ImMessageCenterShowItemData> mList = null;
    protected boolean esW = false;

    protected abstract BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str);

    protected abstract boolean a(ImMessageCenterShowItemData imMessageCenterShowItemData);

    protected abstract boolean b(ImMessageCenterShowItemData imMessageCenterShowItemData);

    protected abstract void g(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData);

    public b(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        if (this.mList == null) {
            this.mList = new LinkedList();
        }
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList != null) {
            return this.mList.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pI */
    public ImMessageCenterShowItemData getItem(int i) {
        if (this.mList == null || this.mList.size() == 0 || i < 0 || i >= getCount()) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar = null;
        if (view != null) {
            aVar = (a) view.getTag();
        }
        if (aVar == null) {
            view = LayoutInflater.from(this.mContext).inflate(d.h.chat_list_item, viewGroup, false);
            aVar = bY(view);
            view.setTag(aVar);
        }
        aj.s(view, d.f.list_selector);
        aj.s(aVar.mLine, d.C0108d.cp_bg_line_b);
        aVar.esX.setVisibility(0);
        aVar.mLine.setVisibility(0);
        ImMessageCenterShowItemData item = getItem(i);
        if (item != null) {
            a(aVar, item);
            d(aVar, item);
            h(aVar, item);
            e(aVar, item);
            g(aVar, item);
            f(aVar, item);
            b(aVar, item);
            c(aVar, item);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.esZ.setText(imMessageCenterShowItemData.getFriendName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.ete.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.ete.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.ete.setVisibility(0);
                    aj.c(aVar.ete, d.f.icon_news_stop);
                } else {
                    aVar.ete.setVisibility(8);
                }
            } else {
                aVar.ete.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.esW) {
            aVar.etg.setVisibility(0);
        } else {
            aVar.etg.setVisibility(8);
        }
        if (imMessageCenterShowItemData.isSelected()) {
            aj.s(aVar.etg, d.f.btn_bgb_choice_s);
            aj.t(aVar.esX, d.C0108d.cp_bg_line_e);
            return;
        }
        aj.s(aVar.etg, d.f.btn_bgb_choice_n);
        aj.t(aVar.esX, d.C0108d.cp_bg_line_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.eta.setText("");
        } else {
            aVar.eta.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = am.f(date);
            }
            aVar.etb.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            aVar.etd.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (com.baidu.tbadk.coreExtra.messageCenter.b.GE().GH() == 0) {
                valueOf = "";
                unReadCount = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, valueOf);
                if (a2 != null && a2.getName() != null && a2.getName().length() > 0) {
                    unReadCount = com.baidu.adp.lib.g.b.h(a2.getName(), 0);
                    valueOf = a2.getValue();
                    if (unReadCount == 0) {
                        valueOf = "";
                    }
                }
            }
            aVar.etd.setText(valueOf);
        } else {
            aVar.etd.setVisibility(8);
        }
        aj.e(aVar.esZ, d.C0108d.cp_cont_b, 1);
        aj.e(aVar.eta, d.C0108d.cp_cont_d, 1);
        aj.e(aVar.etb, d.C0108d.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                aj.s(aVar.etd, d.f.icon_news_down_bar_one);
                aVar.etd.setWidth(0);
                aVar.etd.setHeight(0);
            } else {
                aj.s(aVar.etd, d.f.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            aj.s(aVar.etd, d.f.icon_news_head_prompt_two);
        } else {
            aj.s(aVar.etd, d.f.icon_news_head_prompt_more);
            aVar.etd.setText("");
        }
        aj.e(aVar.etd, d.C0108d.common_color_10225, 1);
    }

    public boolean aEK() {
        return this.esW;
    }

    public void gU(boolean z) {
        this.esW = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a bY(View view) {
        a aVar = new a();
        aVar.esX = (ViewGroup) view.findViewById(d.g.chat_item);
        aVar.esY = (HeadImageView) view.findViewById(d.g.chat_head);
        aVar.esZ = (TextView) view.findViewById(d.g.chat_name);
        aVar.eta = (TextView) view.findViewById(d.g.last_chat_content);
        aVar.etb = (TextView) view.findViewById(d.g.chat_time);
        aVar.mLine = view.findViewById(d.g.line);
        aVar.etd = (TextView) view.findViewById(d.g.new_message);
        aVar.ete = (ImageView) view.findViewById(d.g.iv_bell);
        aVar.etf = (ImageView) view.findViewById(d.g.send_status);
        aVar.etg = (ImageView) view.findViewById(d.g.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup esX = null;
        public HeadImageView esY = null;
        public TextView esZ = null;
        public TextView eta = null;
        public TextView etb = null;
        public TextView etd = null;
        public View mLine = null;
        public ImageView ete = null;
        public ImageView etf = null;
        public ImageView etg = null;

        protected a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.etf.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    aj.s(aVar.etf, d.f.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    aj.s(aVar.etf, d.f.icon_send_in_information);
                    return;
                } else {
                    aVar.etf.setVisibility(8);
                    return;
                }
            }
            aVar.etf.setVisibility(8);
        }
    }
}
