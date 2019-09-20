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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.coreExtra.messageCenter.d;
import com.baidu.tieba.R;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public abstract class c extends BaseAdapter {
    protected Context mContext;
    protected List<ImMessageCenterShowItemData> mList = null;
    protected boolean gCL = false;

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
    /* renamed from: vl */
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
            view = LayoutInflater.from(this.mContext).inflate(R.layout.chat_list_item, viewGroup, false);
            aVar = ce(view);
            view.setTag(aVar);
        }
        am.k(view, R.drawable.list_selector);
        am.k(aVar.mLine, R.color.cp_bg_line_e);
        aVar.gCM.setVisibility(0);
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
            aVar.gCO.setText(imMessageCenterShowItemData.getFriendNameShow());
        }
    }

    protected void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.gCS.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.gCS.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.gCS.setVisibility(0);
                    am.c(aVar.gCS, (int) R.drawable.icon_news_stop);
                } else {
                    aVar.gCS.setVisibility(8);
                }
            } else {
                aVar.gCS.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.gCL) {
            aVar.gCU.setVisibility(0);
            if (imMessageCenterShowItemData.isSelected()) {
                am.k(aVar.gCU, R.drawable.btn_bgb_choice_s);
                am.l(aVar.gCM, R.color.cp_bg_line_e);
                return;
            }
            am.k(aVar.gCU, R.drawable.btn_bgb_choice_n);
            am.l(aVar.gCM, R.color.cp_bg_line_e);
            return;
        }
        aVar.gCU.setVisibility(8);
        aVar.gCM.setBackgroundDrawable(am.io(R.color.cp_bg_line_e));
    }

    protected void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.gCP.setText("");
        } else {
            aVar.gCP.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    protected void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = aq.n(date);
            }
            aVar.gCQ.setText(str);
        }
    }

    protected void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int f;
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            if (d.aoy().aoB() == 0) {
                f = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, unReadCount > 99 ? "..." : String.valueOf(unReadCount));
                f = (a2 == null || a2.getName() == null || a2.getName().length() <= 0) ? unReadCount : com.baidu.adp.lib.g.b.f(a2.getName(), 0);
            }
            aVar.gCR.refresh(f);
            aVar.gCR.setVisibility(0);
        } else {
            aVar.gCR.setVisibility(8);
        }
        am.f(aVar.gCO, R.color.cp_cont_b, 1);
        am.f(aVar.gCP, R.color.cp_cont_d, 1);
        am.f(aVar.gCQ, R.color.cp_cont_d, 1);
    }

    public boolean bBI() {
        return this.gCL;
    }

    public void lQ(boolean z) {
        this.gCL = z;
    }

    protected a ce(View view) {
        a aVar = new a();
        aVar.gCM = (ViewGroup) view.findViewById(R.id.chat_item);
        aVar.gCN = (HeadImageView) view.findViewById(R.id.chat_head);
        aVar.gCO = (TextView) view.findViewById(R.id.chat_name);
        aVar.gCP = (TextView) view.findViewById(R.id.last_chat_content);
        aVar.gCQ = (TextView) view.findViewById(R.id.chat_time);
        aVar.mLine = view.findViewById(R.id.line);
        aVar.gCR = (MessageRedDotView) view.findViewById(R.id.new_message);
        aVar.gCS = (ImageView) view.findViewById(R.id.iv_bell);
        aVar.gCT = (ImageView) view.findViewById(R.id.send_status);
        aVar.gCU = (ImageView) view.findViewById(R.id.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup gCM = null;
        public HeadImageView gCN = null;
        public TextView gCO = null;
        public TextView gCP = null;
        public TextView gCQ = null;
        public MessageRedDotView gCR = null;
        public View mLine = null;
        public ImageView gCS = null;
        public ImageView gCT = null;
        public ImageView gCU = null;

        protected a() {
        }
    }

    protected void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.gCT.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    am.k(aVar.gCT, R.drawable.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    am.k(aVar.gCT, R.drawable.icon_send_in_information);
                    return;
                } else {
                    aVar.gCT.setVisibility(8);
                    return;
                }
            }
            aVar.gCT.setVisibility(8);
        }
    }
}
