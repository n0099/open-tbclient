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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
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
    protected boolean iRP = false;

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
    /* renamed from: ys */
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
            aVar = cr(view);
            view.setTag(aVar);
        }
        ao.setBackgroundResource(view, R.drawable.list_item_selector);
        ao.setBackgroundResource(aVar.mLine, R.color.cp_bg_line_e);
        aVar.iRQ.setVisibility(0);
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
            aVar.iRU.setText(imMessageCenterShowItemData.getFriendNameShow());
        }
    }

    protected void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.iRY.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.iRY.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.iRY.setVisibility(0);
                    SvgManager.baR().a(aVar.iRY, R.drawable.ic_icon_pure_shield_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL);
                } else {
                    aVar.iRY.setVisibility(8);
                }
            } else {
                aVar.iRY.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.iRP) {
            aVar.iSa.setVisibility(0);
            if (imMessageCenterShowItemData.isSelected()) {
                ao.setBackgroundResource(aVar.iSa, R.drawable.btn_bgb_choice_s);
                ao.setBackgroundColor(aVar.iRQ, R.color.cp_bg_line_e);
                return;
            }
            ao.setBackgroundResource(aVar.iSa, R.drawable.btn_bgb_choice_n);
            ao.setBackgroundColor(aVar.iRQ, R.color.cp_bg_line_e);
            return;
        }
        aVar.iSa.setVisibility(8);
        com.baidu.tbadk.core.util.e.a.h(aVar.iRQ, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
    }

    protected void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.iRV.setText("");
        } else {
            aVar.iRV.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    protected void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = as.getChatTimeString(date);
            }
            aVar.iRW.setText(str);
        }
    }

    protected void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            if (d.bfO().bfR() == 0) {
                unReadCount = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, String.valueOf(unReadCount));
                if (a2 != null && a2.getName() != null && a2.getName().length() > 0) {
                    unReadCount = com.baidu.adp.lib.f.b.toInt(a2.getName(), 0);
                }
            }
            aVar.iRX.setThreeDotMode(2);
            aVar.iRX.refresh(unReadCount);
            aVar.iRX.setVisibility(0);
        } else {
            aVar.iRX.setVisibility(8);
        }
        ao.setViewTextColor(aVar.iRU, R.color.cp_cont_b, 1);
        ao.setViewTextColor(aVar.iRV, R.color.cp_cont_d, 1);
        ao.setViewTextColor(aVar.iRW, R.color.cp_cont_d, 1);
    }

    public boolean cri() {
        return this.iRP;
    }

    public void pB(boolean z) {
        this.iRP = z;
    }

    protected a cr(View view) {
        a aVar = new a();
        aVar.iRQ = (ViewGroup) view.findViewById(R.id.chat_item);
        aVar.iRS = (ImageView) view.findViewById(R.id.svg_head);
        aVar.iRR = (HeadImageView) view.findViewById(R.id.chat_head);
        aVar.iRT = (BarImageView) view.findViewById(R.id.forum_head);
        aVar.iRU = (TextView) view.findViewById(R.id.chat_name);
        aVar.iRV = (TextView) view.findViewById(R.id.last_chat_content);
        aVar.iRW = (TextView) view.findViewById(R.id.chat_time);
        aVar.mLine = view.findViewById(R.id.line);
        aVar.iRX = (MessageRedDotView) view.findViewById(R.id.new_message);
        aVar.iRX.setShadowEnabled(false);
        aVar.iRY = (ImageView) view.findViewById(R.id.iv_bell);
        aVar.iRZ = (ImageView) view.findViewById(R.id.send_status);
        aVar.iSa = (ImageView) view.findViewById(R.id.select_status);
        aVar.iRR.setPlaceHolder(1);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ImageView iRS;
        public BarImageView iRT;
        public ViewGroup iRQ = null;
        public HeadImageView iRR = null;
        public TextView iRU = null;
        public TextView iRV = null;
        public TextView iRW = null;
        public MessageRedDotView iRX = null;
        public View mLine = null;
        public ImageView iRY = null;
        public ImageView iRZ = null;
        public ImageView iSa = null;

        protected a() {
        }
    }

    protected void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.iRZ.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    ao.setBackgroundResource(aVar.iRZ, R.drawable.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    ao.setBackgroundResource(aVar.iRZ, R.drawable.icon_send_in_information);
                    return;
                } else {
                    aVar.iRZ.setVisibility(8);
                    return;
                }
            }
            aVar.iRZ.setVisibility(8);
        }
    }
}
