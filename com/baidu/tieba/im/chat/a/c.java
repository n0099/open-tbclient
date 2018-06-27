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
import com.baidu.tbadk.core.util.am;
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
    protected boolean eib = false;

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
    /* renamed from: nA */
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
            view = LayoutInflater.from(this.mContext).inflate(d.i.chat_list_item, viewGroup, false);
            aVar = aI(view);
            view.setTag(aVar);
        }
        am.i(view, d.f.list_selector);
        am.i(aVar.mLine, d.C0142d.cp_bg_line_c);
        aVar.eic.setVisibility(0);
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
            aVar.eie.setText(imMessageCenterShowItemData.getFriendNameShow());
        }
    }

    protected void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.eii.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.eii.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.eii.setVisibility(0);
                    am.c(aVar.eii, d.f.icon_news_stop);
                } else {
                    aVar.eii.setVisibility(8);
                }
            } else {
                aVar.eii.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.eib) {
            aVar.eik.setVisibility(0);
            if (imMessageCenterShowItemData.isSelected()) {
                am.i(aVar.eik, d.f.btn_bgb_choice_s);
                am.j(aVar.eic, d.C0142d.cp_bg_line_e);
                return;
            }
            am.i(aVar.eik, d.f.btn_bgb_choice_n);
            am.j(aVar.eic, d.C0142d.cp_bg_line_d);
            return;
        }
        aVar.eik.setVisibility(8);
        am.i(aVar.eic, d.f.list_selector);
    }

    protected void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.eif.setText("");
        } else {
            aVar.eif.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    protected void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = ap.i(date);
            }
            aVar.eig.setText(str);
        }
    }

    protected void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int g;
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.DW().DZ() == 0) {
                g = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, unReadCount > 99 ? "..." : String.valueOf(unReadCount));
                g = (a2 == null || a2.getName() == null || a2.getName().length() <= 0) ? unReadCount : com.baidu.adp.lib.g.b.g(a2.getName(), 0);
            }
            aVar.eih.refresh(g);
            aVar.eih.setVisibility(0);
        } else {
            aVar.eih.setVisibility(8);
        }
        am.c(aVar.eie, d.C0142d.cp_cont_b, 1);
        am.c(aVar.eif, d.C0142d.cp_cont_d, 1);
        am.c(aVar.eig, d.C0142d.cp_cont_d, 1);
    }

    public boolean aGF() {
        return this.eib;
    }

    public void hb(boolean z) {
        this.eib = z;
    }

    protected a aI(View view) {
        a aVar = new a();
        aVar.eic = (ViewGroup) view.findViewById(d.g.chat_item);
        aVar.eid = (HeadImageView) view.findViewById(d.g.chat_head);
        aVar.eie = (TextView) view.findViewById(d.g.chat_name);
        aVar.eif = (TextView) view.findViewById(d.g.last_chat_content);
        aVar.eig = (TextView) view.findViewById(d.g.chat_time);
        aVar.mLine = view.findViewById(d.g.line);
        aVar.eih = (MessageRedDotView) view.findViewById(d.g.new_message);
        aVar.eii = (ImageView) view.findViewById(d.g.iv_bell);
        aVar.eij = (ImageView) view.findViewById(d.g.send_status);
        aVar.eik = (ImageView) view.findViewById(d.g.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup eic = null;
        public HeadImageView eid = null;
        public TextView eie = null;
        public TextView eif = null;
        public TextView eig = null;
        public MessageRedDotView eih = null;
        public View mLine = null;
        public ImageView eii = null;
        public ImageView eij = null;
        public ImageView eik = null;

        protected a() {
        }
    }

    protected void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.eij.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    am.i(aVar.eij, d.f.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    am.i(aVar.eij, d.f.icon_send_in_information);
                    return;
                } else {
                    aVar.eij.setVisibility(8);
                    return;
                }
            }
            aVar.eij.setVisibility(8);
        }
    }
}
