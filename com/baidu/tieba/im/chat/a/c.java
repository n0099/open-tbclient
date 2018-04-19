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
    protected boolean dRQ = false;

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
        aVar.dRR.setVisibility(0);
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
        aVar.dRT.setText(imMessageCenterShowItemData.getFriendName());
    }

    protected void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.dRX.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.dRX.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.dRX.setVisibility(0);
                    ak.c(aVar.dRX, d.f.icon_news_stop);
                } else {
                    aVar.dRX.setVisibility(8);
                }
            } else {
                aVar.dRX.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.dRQ) {
            aVar.dRZ.setVisibility(0);
            if (imMessageCenterShowItemData.isSelected()) {
                ak.i(aVar.dRZ, d.f.btn_bgb_choice_s);
                ak.j(aVar.dRR, d.C0126d.cp_bg_line_e);
                return;
            }
            ak.i(aVar.dRZ, d.f.btn_bgb_choice_n);
            ak.j(aVar.dRR, d.C0126d.cp_bg_line_d);
            return;
        }
        aVar.dRZ.setVisibility(8);
        ak.i(aVar.dRR, d.f.list_selector);
    }

    protected void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.dRU.setText("");
        } else {
            aVar.dRU.setText(imMessageCenterShowItemData.getMsgContent());
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
            aVar.dRV.setText(str);
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
            aVar.dRW.refresh(g);
            aVar.dRW.setVisibility(0);
        } else {
            aVar.dRW.setVisibility(8);
        }
        ak.c(aVar.dRT, d.C0126d.cp_cont_b, 1);
        ak.c(aVar.dRU, d.C0126d.cp_cont_d, 1);
        ak.c(aVar.dRV, d.C0126d.cp_cont_d, 1);
    }

    public boolean aBe() {
        return this.dRQ;
    }

    public void gK(boolean z) {
        this.dRQ = z;
    }

    protected a aE(View view2) {
        a aVar = new a();
        aVar.dRR = (ViewGroup) view2.findViewById(d.g.chat_item);
        aVar.dRS = (HeadImageView) view2.findViewById(d.g.chat_head);
        aVar.dRT = (TextView) view2.findViewById(d.g.chat_name);
        aVar.dRU = (TextView) view2.findViewById(d.g.last_chat_content);
        aVar.dRV = (TextView) view2.findViewById(d.g.chat_time);
        aVar.mLine = view2.findViewById(d.g.line);
        aVar.dRW = (MessageRedDotView) view2.findViewById(d.g.new_message);
        aVar.dRX = (ImageView) view2.findViewById(d.g.iv_bell);
        aVar.dRY = (ImageView) view2.findViewById(d.g.send_status);
        aVar.dRZ = (ImageView) view2.findViewById(d.g.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup dRR = null;
        public HeadImageView dRS = null;
        public TextView dRT = null;
        public TextView dRU = null;
        public TextView dRV = null;
        public MessageRedDotView dRW = null;
        public View mLine = null;
        public ImageView dRX = null;
        public ImageView dRY = null;
        public ImageView dRZ = null;

        protected a() {
        }
    }

    protected void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.dRY.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    ak.i(aVar.dRY, d.f.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    ak.i(aVar.dRY, d.f.icon_send_in_information);
                    return;
                } else {
                    aVar.dRY.setVisibility(8);
                    return;
                }
            }
            aVar.dRY.setVisibility(8);
        }
    }
}
