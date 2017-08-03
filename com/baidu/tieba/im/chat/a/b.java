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
    protected boolean dhe = false;

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
    /* renamed from: lM */
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
            aVar = aE(view);
            view.setTag(aVar);
        }
        ai.j(view, d.g.list_selector);
        ai.j(aVar.atu, d.e.cp_bg_line_b);
        aVar.dhf.setVisibility(0);
        aVar.atu.setVisibility(0);
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
        aVar.dhh.setText(imMessageCenterShowItemData.getFriendName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.dhl.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.dhl.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.dhl.setVisibility(0);
                    ai.c(aVar.dhl, d.g.icon_news_stop);
                } else {
                    aVar.dhl.setVisibility(8);
                }
            } else {
                aVar.dhl.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.dhe) {
            aVar.dhn.setVisibility(0);
        } else {
            aVar.dhn.setVisibility(8);
        }
        if (imMessageCenterShowItemData.isSelected()) {
            ai.j(aVar.dhn, d.g.btn_bgb_choice_s);
            ai.k(aVar.dhf, d.e.cp_bg_line_e);
            return;
        }
        ai.j(aVar.dhn, d.g.btn_bgb_choice_n);
        ai.k(aVar.dhf, d.e.cp_bg_line_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.dhi.setText("");
        } else {
            aVar.dhi.setText(imMessageCenterShowItemData.getMsgContent());
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
            aVar.dhj.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            aVar.dhk.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (com.baidu.tbadk.coreExtra.messageCenter.b.zo().zr() == 0) {
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
            aVar.dhk.setText(valueOf);
        } else {
            aVar.dhk.setVisibility(8);
        }
        ai.c(aVar.dhh, d.e.cp_cont_b, 1);
        ai.c(aVar.dhi, d.e.cp_cont_d, 1);
        ai.c(aVar.dhj, d.e.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                ai.j(aVar.dhk, d.g.icon_news_down_bar_one);
                aVar.dhk.setWidth(0);
                aVar.dhk.setHeight(0);
            } else {
                ai.j(aVar.dhk, d.g.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            ai.j(aVar.dhk, d.g.icon_news_head_prompt_two);
        } else {
            ai.j(aVar.dhk, d.g.icon_news_head_prompt_more);
            aVar.dhk.setText("");
        }
        ai.c(aVar.dhk, d.e.common_color_10225, 1);
    }

    public boolean arQ() {
        return this.dhe;
    }

    public void fW(boolean z) {
        this.dhe = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a aE(View view) {
        a aVar = new a();
        aVar.dhf = (ViewGroup) view.findViewById(d.h.chat_item);
        aVar.dhg = (HeadImageView) view.findViewById(d.h.chat_head);
        aVar.dhh = (TextView) view.findViewById(d.h.chat_name);
        aVar.dhi = (TextView) view.findViewById(d.h.last_chat_content);
        aVar.dhj = (TextView) view.findViewById(d.h.chat_time);
        aVar.atu = view.findViewById(d.h.line);
        aVar.dhk = (TextView) view.findViewById(d.h.new_message);
        aVar.dhl = (ImageView) view.findViewById(d.h.iv_bell);
        aVar.dhm = (ImageView) view.findViewById(d.h.send_status);
        aVar.dhn = (ImageView) view.findViewById(d.h.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup dhf = null;
        public HeadImageView dhg = null;
        public TextView dhh = null;
        public TextView dhi = null;
        public TextView dhj = null;
        public TextView dhk = null;
        public View atu = null;
        public ImageView dhl = null;
        public ImageView dhm = null;
        public ImageView dhn = null;

        protected a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.dhm.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    ai.j(aVar.dhm, d.g.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    ai.j(aVar.dhm, d.g.icon_send_in_information);
                    return;
                } else {
                    aVar.dhm.setVisibility(8);
                    return;
                }
            }
            aVar.dhm.setVisibility(8);
        }
    }
}
