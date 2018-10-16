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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.e;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public abstract class c extends BaseAdapter {
    protected Context mContext;
    protected List<ImMessageCenterShowItemData> mList = null;
    protected boolean eAX = false;

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
    /* renamed from: oQ */
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
            view = LayoutInflater.from(this.mContext).inflate(e.h.chat_list_item, viewGroup, false);
            aVar = aZ(view);
            view.setTag(aVar);
        }
        al.i(view, e.f.list_selector);
        al.i(aVar.mLine, e.d.cp_bg_line_c);
        aVar.eAY.setVisibility(0);
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
            aVar.eBa.setText(imMessageCenterShowItemData.getFriendNameShow());
        }
    }

    protected void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.eBe.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.eBe.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.eBe.setVisibility(0);
                    al.c(aVar.eBe, e.f.icon_news_stop);
                } else {
                    aVar.eBe.setVisibility(8);
                }
            } else {
                aVar.eBe.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.eAX) {
            aVar.eBg.setVisibility(0);
            if (imMessageCenterShowItemData.isSelected()) {
                al.i(aVar.eBg, e.f.btn_bgb_choice_s);
                al.j(aVar.eAY, e.d.cp_bg_line_e);
                return;
            }
            al.i(aVar.eBg, e.f.btn_bgb_choice_n);
            al.j(aVar.eAY, e.d.cp_bg_line_d);
            return;
        }
        aVar.eBg.setVisibility(8);
        al.i(aVar.eAY, e.f.list_selector);
    }

    protected void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.eBb.setText("");
        } else {
            aVar.eBb.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    protected void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = ao.h(date);
            }
            aVar.eBc.setText(str);
        }
    }

    protected void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int l;
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hj() == 0) {
                l = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, unReadCount > 99 ? "..." : String.valueOf(unReadCount));
                l = (a2 == null || a2.getName() == null || a2.getName().length() <= 0) ? unReadCount : com.baidu.adp.lib.g.b.l(a2.getName(), 0);
            }
            aVar.eBd.refresh(l);
            aVar.eBd.setVisibility(0);
        } else {
            aVar.eBd.setVisibility(8);
        }
        al.c(aVar.eBa, e.d.cp_cont_b, 1);
        al.c(aVar.eBb, e.d.cp_cont_d, 1);
        al.c(aVar.eBc, e.d.cp_cont_d, 1);
    }

    public boolean aNh() {
        return this.eAX;
    }

    public void hU(boolean z) {
        this.eAX = z;
    }

    protected a aZ(View view) {
        a aVar = new a();
        aVar.eAY = (ViewGroup) view.findViewById(e.g.chat_item);
        aVar.eAZ = (HeadImageView) view.findViewById(e.g.chat_head);
        aVar.eBa = (TextView) view.findViewById(e.g.chat_name);
        aVar.eBb = (TextView) view.findViewById(e.g.last_chat_content);
        aVar.eBc = (TextView) view.findViewById(e.g.chat_time);
        aVar.mLine = view.findViewById(e.g.line);
        aVar.eBd = (MessageRedDotView) view.findViewById(e.g.new_message);
        aVar.eBe = (ImageView) view.findViewById(e.g.iv_bell);
        aVar.eBf = (ImageView) view.findViewById(e.g.send_status);
        aVar.eBg = (ImageView) view.findViewById(e.g.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup eAY = null;
        public HeadImageView eAZ = null;
        public TextView eBa = null;
        public TextView eBb = null;
        public TextView eBc = null;
        public MessageRedDotView eBd = null;
        public View mLine = null;
        public ImageView eBe = null;
        public ImageView eBf = null;
        public ImageView eBg = null;

        protected a() {
        }
    }

    protected void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.eBf.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    al.i(aVar.eBf, e.f.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    al.i(aVar.eBf, e.f.icon_send_in_information);
                    return;
                } else {
                    aVar.eBf.setVisibility(8);
                    return;
                }
            }
            aVar.eBf.setVisibility(8);
        }
    }
}
