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
import com.baidu.tbadk.core.util.at;
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
    protected boolean ktl = false;

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
    /* renamed from: Cr */
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
            aVar = dm(view);
            view.setTag(aVar);
        }
        ao.setBackgroundResource(view, R.drawable.list_item_selector);
        ao.setBackgroundResource(aVar.mLine, R.color.CAM_X0205);
        aVar.ktm.setVisibility(0);
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
            aVar.ktq.setText(imMessageCenterShowItemData.getFriendNameShow());
        }
    }

    protected void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.ktu.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.ktu.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.ktu.setVisibility(0);
                    SvgManager.bsx().a(aVar.ktu, R.drawable.ic_icon_pure_shield_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL);
                } else {
                    aVar.ktu.setVisibility(8);
                }
            } else {
                aVar.ktu.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.ktl) {
            aVar.ktw.setVisibility(0);
            if (imMessageCenterShowItemData.isSelected()) {
                ao.setBackgroundResource(aVar.ktw, R.drawable.btn_bgb_choice_s);
                ao.setBackgroundColor(aVar.ktm, R.color.CAM_X0205);
                return;
            }
            ao.setBackgroundResource(aVar.ktw, R.drawable.btn_bgb_choice_n);
            ao.setBackgroundColor(aVar.ktm, R.color.CAM_X0205);
            return;
        }
        aVar.ktw.setVisibility(8);
        com.baidu.tbadk.core.util.f.a.m(aVar.ktm, R.color.CAM_X0205, R.color.CAM_X0204);
    }

    protected void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.ktr.setText("");
        } else {
            aVar.ktr.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    protected void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = at.getChatTimeString(date);
            }
            aVar.kts.setText(str);
        }
    }

    protected void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            if (d.bxM().bxP() == 0) {
                unReadCount = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, String.valueOf(unReadCount));
                if (a2 != null && a2.getName() != null && a2.getName().length() > 0) {
                    unReadCount = com.baidu.adp.lib.f.b.toInt(a2.getName(), 0);
                }
            }
            aVar.ktt.setThreeDotMode(2);
            aVar.ktt.refresh(unReadCount);
            aVar.ktt.setVisibility(0);
        } else {
            aVar.ktt.setVisibility(8);
        }
        ao.setViewTextColor(aVar.ktq, R.color.CAM_X0105, 1);
        ao.setViewTextColor(aVar.ktr, R.color.CAM_X0109, 1);
        ao.setViewTextColor(aVar.kts, R.color.CAM_X0109, 1);
    }

    public boolean cSP() {
        return this.ktl;
    }

    public void ss(boolean z) {
        this.ktl = z;
    }

    protected a dm(View view) {
        a aVar = new a();
        aVar.ktm = (ViewGroup) view.findViewById(R.id.chat_item);
        aVar.kto = (ImageView) view.findViewById(R.id.svg_head);
        aVar.ktn = (HeadImageView) view.findViewById(R.id.chat_head);
        aVar.ktp = (BarImageView) view.findViewById(R.id.forum_head);
        aVar.ktq = (TextView) view.findViewById(R.id.chat_name);
        aVar.ktr = (TextView) view.findViewById(R.id.last_chat_content);
        aVar.kts = (TextView) view.findViewById(R.id.chat_time);
        aVar.mLine = view.findViewById(R.id.line);
        aVar.ktt = (MessageRedDotView) view.findViewById(R.id.new_message);
        aVar.ktt.setShadowEnabled(false);
        aVar.ktu = (ImageView) view.findViewById(R.id.iv_bell);
        aVar.ktv = (ImageView) view.findViewById(R.id.send_status);
        aVar.ktw = (ImageView) view.findViewById(R.id.select_status);
        aVar.ktn.setPlaceHolder(1);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ImageView kto;
        public BarImageView ktp;
        public ViewGroup ktm = null;
        public HeadImageView ktn = null;
        public TextView ktq = null;
        public TextView ktr = null;
        public TextView kts = null;
        public MessageRedDotView ktt = null;
        public View mLine = null;
        public ImageView ktu = null;
        public ImageView ktv = null;
        public ImageView ktw = null;

        protected a() {
        }
    }

    protected void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.ktv.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    ao.setBackgroundResource(aVar.ktv, R.drawable.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    ao.setBackgroundResource(aVar.ktv, R.drawable.icon_send_in_information);
                    return;
                } else {
                    aVar.ktv.setVisibility(8);
                    return;
                }
            }
            aVar.ktv.setVisibility(8);
        }
    }
}
