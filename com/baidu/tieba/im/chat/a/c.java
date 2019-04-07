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
    protected boolean gcz = false;

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
    /* renamed from: tx */
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
        aVar.gcA.setVisibility(0);
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
            aVar.gcC.setText(imMessageCenterShowItemData.getFriendNameShow());
        }
    }

    protected void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.gcG.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.gcG.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.gcG.setVisibility(0);
                    al.c(aVar.gcG, d.f.icon_news_stop);
                } else {
                    aVar.gcG.setVisibility(8);
                }
            } else {
                aVar.gcG.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.gcz) {
            aVar.gcI.setVisibility(0);
            if (imMessageCenterShowItemData.isSelected()) {
                al.k(aVar.gcI, d.f.btn_bgb_choice_s);
                al.l(aVar.gcA, d.C0277d.cp_bg_line_e);
                return;
            }
            al.k(aVar.gcI, d.f.btn_bgb_choice_n);
            al.l(aVar.gcA, d.C0277d.cp_bg_line_d);
            return;
        }
        aVar.gcI.setVisibility(8);
        al.k(aVar.gcA, d.f.list_selector);
    }

    protected void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.gcD.setText("");
        } else {
            aVar.gcD.setText(imMessageCenterShowItemData.getMsgContent());
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
            aVar.gcE.setText(str);
        }
    }

    protected void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int l;
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.d.aie().aih() == 0) {
                l = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, unReadCount > 99 ? "..." : String.valueOf(unReadCount));
                l = (a2 == null || a2.getName() == null || a2.getName().length() <= 0) ? unReadCount : com.baidu.adp.lib.g.b.l(a2.getName(), 0);
            }
            aVar.gcF.refresh(l);
            aVar.gcF.setVisibility(0);
        } else {
            aVar.gcF.setVisibility(8);
        }
        al.d(aVar.gcC, d.C0277d.cp_cont_b, 1);
        al.d(aVar.gcD, d.C0277d.cp_cont_d, 1);
        al.d(aVar.gcE, d.C0277d.cp_cont_d, 1);
    }

    public boolean bqm() {
        return this.gcz;
    }

    public void kJ(boolean z) {
        this.gcz = z;
    }

    protected a bT(View view) {
        a aVar = new a();
        aVar.gcA = (ViewGroup) view.findViewById(d.g.chat_item);
        aVar.gcB = (HeadImageView) view.findViewById(d.g.chat_head);
        aVar.gcC = (TextView) view.findViewById(d.g.chat_name);
        aVar.gcD = (TextView) view.findViewById(d.g.last_chat_content);
        aVar.gcE = (TextView) view.findViewById(d.g.chat_time);
        aVar.mLine = view.findViewById(d.g.line);
        aVar.gcF = (MessageRedDotView) view.findViewById(d.g.new_message);
        aVar.gcG = (ImageView) view.findViewById(d.g.iv_bell);
        aVar.gcH = (ImageView) view.findViewById(d.g.send_status);
        aVar.gcI = (ImageView) view.findViewById(d.g.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup gcA = null;
        public HeadImageView gcB = null;
        public TextView gcC = null;
        public TextView gcD = null;
        public TextView gcE = null;
        public MessageRedDotView gcF = null;
        public View mLine = null;
        public ImageView gcG = null;
        public ImageView gcH = null;
        public ImageView gcI = null;

        protected a() {
        }
    }

    protected void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.gcH.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    al.k(aVar.gcH, d.f.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    al.k(aVar.gcH, d.f.icon_send_in_information);
                    return;
                } else {
                    aVar.gcH.setVisibility(8);
                    return;
                }
            }
            aVar.gcH.setVisibility(8);
        }
    }
}
