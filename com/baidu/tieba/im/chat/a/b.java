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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
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
    protected boolean dkt = false;

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
    /* renamed from: lW */
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
            view = LayoutInflater.from(this.mContext).inflate(d.j.chat_list_item, viewGroup, false);
            aVar = aF(view);
            view.setTag(aVar);
        }
        ai.j(view, d.g.list_selector);
        ai.j(aVar.auO, d.e.cp_bg_line_b);
        aVar.dku.setVisibility(0);
        aVar.auO.setVisibility(0);
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
        aVar.dkw.setText(imMessageCenterShowItemData.getFriendName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.dkA.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.dkA.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.dkA.setVisibility(0);
                    ai.c(aVar.dkA, d.g.icon_news_stop);
                } else {
                    aVar.dkA.setVisibility(8);
                }
            } else {
                aVar.dkA.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.dkt) {
            aVar.dkC.setVisibility(0);
        } else {
            aVar.dkC.setVisibility(8);
        }
        if (imMessageCenterShowItemData.isSelected()) {
            ai.j(aVar.dkC, d.g.btn_bgb_choice_s);
            ai.k(aVar.dku, d.e.cp_bg_line_e);
            return;
        }
        ai.j(aVar.dkC, d.g.btn_bgb_choice_n);
        ai.k(aVar.dku, d.e.cp_bg_line_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.dkx.setText("");
        } else {
            aVar.dkx.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = al.f(date);
            }
            aVar.dky.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            aVar.dkz.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (com.baidu.tbadk.coreExtra.messageCenter.b.zw().zz() == 0) {
                valueOf = "";
                unReadCount = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, valueOf);
                if (a2 != null && a2.getName() != null && a2.getName().length() > 0) {
                    unReadCount = com.baidu.adp.lib.g.b.g(a2.getName(), 0);
                    valueOf = a2.getValue();
                    if (unReadCount == 0) {
                        valueOf = "";
                    }
                }
            }
            aVar.dkz.setText(valueOf);
        } else {
            aVar.dkz.setVisibility(8);
        }
        ai.c(aVar.dkw, d.e.cp_cont_b, 1);
        ai.c(aVar.dkx, d.e.cp_cont_d, 1);
        ai.c(aVar.dky, d.e.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                ai.j(aVar.dkz, d.g.icon_news_down_bar_one);
                aVar.dkz.setWidth(0);
                aVar.dkz.setHeight(0);
            } else {
                ai.j(aVar.dkz, d.g.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            ai.j(aVar.dkz, d.g.icon_news_head_prompt_two);
        } else {
            ai.j(aVar.dkz, d.g.icon_news_head_prompt_more);
            aVar.dkz.setText("");
        }
        ai.c(aVar.dkz, d.e.common_color_10225, 1);
    }

    public boolean asC() {
        return this.dkt;
    }

    public void fZ(boolean z) {
        this.dkt = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a aF(View view) {
        a aVar = new a();
        aVar.dku = (ViewGroup) view.findViewById(d.h.chat_item);
        aVar.dkv = (HeadImageView) view.findViewById(d.h.chat_head);
        aVar.dkw = (TextView) view.findViewById(d.h.chat_name);
        aVar.dkx = (TextView) view.findViewById(d.h.last_chat_content);
        aVar.dky = (TextView) view.findViewById(d.h.chat_time);
        aVar.auO = view.findViewById(d.h.line);
        aVar.dkz = (TextView) view.findViewById(d.h.new_message);
        aVar.dkA = (ImageView) view.findViewById(d.h.iv_bell);
        aVar.dkB = (ImageView) view.findViewById(d.h.send_status);
        aVar.dkC = (ImageView) view.findViewById(d.h.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup dku = null;
        public HeadImageView dkv = null;
        public TextView dkw = null;
        public TextView dkx = null;
        public TextView dky = null;
        public TextView dkz = null;
        public View auO = null;
        public ImageView dkA = null;
        public ImageView dkB = null;
        public ImageView dkC = null;

        protected a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.dkB.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    ai.j(aVar.dkB, d.g.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    ai.j(aVar.dkB, d.g.icon_send_in_information);
                    return;
                } else {
                    aVar.dkB.setVisibility(8);
                    return;
                }
            }
            aVar.dkB.setVisibility(8);
        }
    }
}
