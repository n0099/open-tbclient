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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
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
    protected boolean dRN = false;

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
    /* renamed from: ni */
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar = null;
        if (view2 != null) {
            aVar = (a) view2.getTag();
        }
        if (aVar == null) {
            view2 = LayoutInflater.from(this.mContext).inflate(d.i.chat_list_item, viewGroup, false);
            aVar = aE(view2);
            view2.setTag(aVar);
        }
        ak.i(view2, d.f.list_selector);
        ak.i(aVar.mLine, d.C0126d.cp_bg_line_c);
        aVar.dRO.setVisibility(0);
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
        return view2;
    }

    protected void a(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.dRQ.setText(imMessageCenterShowItemData.getFriendName());
    }

    protected void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.dRU.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.dRU.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.dRU.setVisibility(0);
                    ak.c(aVar.dRU, d.f.icon_news_stop);
                } else {
                    aVar.dRU.setVisibility(8);
                }
            } else {
                aVar.dRU.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.dRN) {
            aVar.dRW.setVisibility(0);
            if (imMessageCenterShowItemData.isSelected()) {
                ak.i(aVar.dRW, d.f.btn_bgb_choice_s);
                ak.j(aVar.dRO, d.C0126d.cp_bg_line_e);
                return;
            }
            ak.i(aVar.dRW, d.f.btn_bgb_choice_n);
            ak.j(aVar.dRO, d.C0126d.cp_bg_line_d);
            return;
        }
        aVar.dRW.setVisibility(8);
        ak.i(aVar.dRO, d.f.list_selector);
    }

    protected void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.dRR.setText("");
        } else {
            aVar.dRR.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    protected void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = an.g(date);
            }
            aVar.dRS.setText(str);
        }
    }

    protected void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int g;
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Ah() == 0) {
                g = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, unReadCount > 99 ? "..." : String.valueOf(unReadCount));
                g = (a2 == null || a2.getName() == null || a2.getName().length() <= 0) ? unReadCount : com.baidu.adp.lib.g.b.g(a2.getName(), 0);
            }
            aVar.dRT.refresh(g);
            aVar.dRT.setVisibility(0);
        } else {
            aVar.dRT.setVisibility(8);
        }
        ak.c(aVar.dRQ, d.C0126d.cp_cont_b, 1);
        ak.c(aVar.dRR, d.C0126d.cp_cont_d, 1);
        ak.c(aVar.dRS, d.C0126d.cp_cont_d, 1);
    }

    public boolean aBe() {
        return this.dRN;
    }

    public void gK(boolean z) {
        this.dRN = z;
    }

    protected a aE(View view2) {
        a aVar = new a();
        aVar.dRO = (ViewGroup) view2.findViewById(d.g.chat_item);
        aVar.dRP = (HeadImageView) view2.findViewById(d.g.chat_head);
        aVar.dRQ = (TextView) view2.findViewById(d.g.chat_name);
        aVar.dRR = (TextView) view2.findViewById(d.g.last_chat_content);
        aVar.dRS = (TextView) view2.findViewById(d.g.chat_time);
        aVar.mLine = view2.findViewById(d.g.line);
        aVar.dRT = (MessageRedDotView) view2.findViewById(d.g.new_message);
        aVar.dRU = (ImageView) view2.findViewById(d.g.iv_bell);
        aVar.dRV = (ImageView) view2.findViewById(d.g.send_status);
        aVar.dRW = (ImageView) view2.findViewById(d.g.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup dRO = null;
        public HeadImageView dRP = null;
        public TextView dRQ = null;
        public TextView dRR = null;
        public TextView dRS = null;
        public MessageRedDotView dRT = null;
        public View mLine = null;
        public ImageView dRU = null;
        public ImageView dRV = null;
        public ImageView dRW = null;

        protected a() {
        }
    }

    protected void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.dRV.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    ak.i(aVar.dRV, d.f.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    ak.i(aVar.dRV, d.f.icon_send_in_information);
                    return;
                } else {
                    aVar.dRV.setVisibility(8);
                    return;
                }
            }
            aVar.dRV.setVisibility(8);
        }
    }
}
