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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public abstract class c extends BaseAdapter {
    protected Context mContext;
    protected List<ImMessageCenterShowItemData> mList = null;
    protected boolean gcL = false;

    protected abstract BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str);

    protected abstract boolean a(ImMessageCenterShowItemData imMessageCenterShowItemData);

    protected abstract boolean b(ImMessageCenterShowItemData imMessageCenterShowItemData);

    protected abstract void g(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData);

    public c(Context context) {
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
    /* renamed from: tB */
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
            aVar = bT(view);
            view.setTag(aVar);
        }
        al.k(view, d.f.list_selector);
        al.k(aVar.mLine, d.C0277d.cp_bg_line_c);
        aVar.gcM.setVisibility(0);
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

    protected void a(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData != null) {
            aVar.gcO.setText(imMessageCenterShowItemData.getFriendNameShow());
        }
    }

    protected void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.gcS.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.gcS.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.gcS.setVisibility(0);
                    al.c(aVar.gcS, d.f.icon_news_stop);
                } else {
                    aVar.gcS.setVisibility(8);
                }
            } else {
                aVar.gcS.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.gcL) {
            aVar.gcU.setVisibility(0);
            if (imMessageCenterShowItemData.isSelected()) {
                al.k(aVar.gcU, d.f.btn_bgb_choice_s);
                al.l(aVar.gcM, d.C0277d.cp_bg_line_e);
                return;
            }
            al.k(aVar.gcU, d.f.btn_bgb_choice_n);
            al.l(aVar.gcM, d.C0277d.cp_bg_line_d);
            return;
        }
        aVar.gcU.setVisibility(8);
        al.k(aVar.gcM, d.f.list_selector);
    }

    protected void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.gcP.setText("");
        } else {
            aVar.gcP.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    protected void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = ap.n(date);
            }
            aVar.gcQ.setText(str);
        }
    }

    protected void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int l;
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().aik() == 0) {
                l = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, unReadCount > 99 ? "..." : String.valueOf(unReadCount));
                l = (a2 == null || a2.getName() == null || a2.getName().length() <= 0) ? unReadCount : com.baidu.adp.lib.g.b.l(a2.getName(), 0);
            }
            aVar.gcR.refresh(l);
            aVar.gcR.setVisibility(0);
        } else {
            aVar.gcR.setVisibility(8);
        }
        al.d(aVar.gcO, d.C0277d.cp_cont_b, 1);
        al.d(aVar.gcP, d.C0277d.cp_cont_d, 1);
        al.d(aVar.gcQ, d.C0277d.cp_cont_d, 1);
    }

    public boolean bqp() {
        return this.gcL;
    }

    public void kJ(boolean z) {
        this.gcL = z;
    }

    protected a bT(View view) {
        a aVar = new a();
        aVar.gcM = (ViewGroup) view.findViewById(d.g.chat_item);
        aVar.gcN = (HeadImageView) view.findViewById(d.g.chat_head);
        aVar.gcO = (TextView) view.findViewById(d.g.chat_name);
        aVar.gcP = (TextView) view.findViewById(d.g.last_chat_content);
        aVar.gcQ = (TextView) view.findViewById(d.g.chat_time);
        aVar.mLine = view.findViewById(d.g.line);
        aVar.gcR = (MessageRedDotView) view.findViewById(d.g.new_message);
        aVar.gcS = (ImageView) view.findViewById(d.g.iv_bell);
        aVar.gcT = (ImageView) view.findViewById(d.g.send_status);
        aVar.gcU = (ImageView) view.findViewById(d.g.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup gcM = null;
        public HeadImageView gcN = null;
        public TextView gcO = null;
        public TextView gcP = null;
        public TextView gcQ = null;
        public MessageRedDotView gcR = null;
        public View mLine = null;
        public ImageView gcS = null;
        public ImageView gcT = null;
        public ImageView gcU = null;

        protected a() {
        }
    }

    protected void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.gcT.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    al.k(aVar.gcT, d.f.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    al.k(aVar.gcT, d.f.icon_send_in_information);
                    return;
                } else {
                    aVar.gcT.setVisibility(8);
                    return;
                }
            }
            aVar.gcT.setVisibility(8);
        }
    }
}
