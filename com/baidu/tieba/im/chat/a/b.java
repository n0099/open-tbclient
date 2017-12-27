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
    protected boolean erd = false;

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
    /* renamed from: pP */
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
            aVar = bW(view);
            view.setTag(aVar);
        }
        aj.s(view, d.f.list_selector);
        aj.s(aVar.mLine, d.C0108d.cp_bg_line_b);
        aVar.ere.setVisibility(0);
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
        aVar.erg.setText(imMessageCenterShowItemData.getFriendName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.erk.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.erk.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.erk.setVisibility(0);
                    aj.c(aVar.erk, d.f.icon_news_stop);
                } else {
                    aVar.erk.setVisibility(8);
                }
            } else {
                aVar.erk.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.erd) {
            aVar.erm.setVisibility(0);
        } else {
            aVar.erm.setVisibility(8);
        }
        if (imMessageCenterShowItemData.isSelected()) {
            aj.s(aVar.erm, d.f.btn_bgb_choice_s);
            aj.t(aVar.ere, d.C0108d.cp_bg_line_e);
            return;
        }
        aj.s(aVar.erm, d.f.btn_bgb_choice_n);
        aj.t(aVar.ere, d.C0108d.cp_bg_line_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.erh.setText("");
        } else {
            aVar.erh.setText(imMessageCenterShowItemData.getMsgContent());
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
            aVar.eri.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            aVar.erj.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (com.baidu.tbadk.coreExtra.messageCenter.b.GJ().GM() == 0) {
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
            aVar.erj.setText(valueOf);
        } else {
            aVar.erj.setVisibility(8);
        }
        aj.e(aVar.erg, d.C0108d.cp_cont_b, 1);
        aj.e(aVar.erh, d.C0108d.cp_cont_d, 1);
        aj.e(aVar.eri, d.C0108d.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                aj.s(aVar.erj, d.f.icon_news_down_bar_one);
                aVar.erj.setWidth(0);
                aVar.erj.setHeight(0);
            } else {
                aj.s(aVar.erj, d.f.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            aj.s(aVar.erj, d.f.icon_news_head_prompt_two);
        } else {
            aj.s(aVar.erj, d.f.icon_news_head_prompt_more);
            aVar.erj.setText("");
        }
        aj.e(aVar.erj, d.C0108d.common_color_10225, 1);
    }

    public boolean aEA() {
        return this.erd;
    }

    public void gP(boolean z) {
        this.erd = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a bW(View view) {
        a aVar = new a();
        aVar.ere = (ViewGroup) view.findViewById(d.g.chat_item);
        aVar.erf = (HeadImageView) view.findViewById(d.g.chat_head);
        aVar.erg = (TextView) view.findViewById(d.g.chat_name);
        aVar.erh = (TextView) view.findViewById(d.g.last_chat_content);
        aVar.eri = (TextView) view.findViewById(d.g.chat_time);
        aVar.mLine = view.findViewById(d.g.line);
        aVar.erj = (TextView) view.findViewById(d.g.new_message);
        aVar.erk = (ImageView) view.findViewById(d.g.iv_bell);
        aVar.erl = (ImageView) view.findViewById(d.g.send_status);
        aVar.erm = (ImageView) view.findViewById(d.g.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup ere = null;
        public HeadImageView erf = null;
        public TextView erg = null;
        public TextView erh = null;
        public TextView eri = null;
        public TextView erj = null;
        public View mLine = null;
        public ImageView erk = null;
        public ImageView erl = null;
        public ImageView erm = null;

        protected a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.erl.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    aj.s(aVar.erl, d.f.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    aj.s(aVar.erl, d.f.icon_send_in_information);
                    return;
                } else {
                    aVar.erl.setVisibility(8);
                    return;
                }
            }
            aVar.erl.setVisibility(8);
        }
    }
}
