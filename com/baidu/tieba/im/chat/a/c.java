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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
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
    protected boolean kDI = false;

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
    /* renamed from: CM */
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
            aVar = dk(view);
            view.setTag(aVar);
        }
        ap.setBackgroundResource(view, R.drawable.list_item_selector);
        ap.setBackgroundResource(aVar.mLine, R.color.CAM_X0205);
        aVar.kDJ.setVisibility(0);
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
            aVar.kDN.setText(imMessageCenterShowItemData.getFriendNameShow());
        }
    }

    protected void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.kDR.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.kDR.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.kDR.setVisibility(0);
                    SvgManager.bsU().a(aVar.kDR, R.drawable.ic_icon_pure_shield_svg, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL);
                } else {
                    aVar.kDR.setVisibility(8);
                }
            } else {
                aVar.kDR.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.kDI) {
            aVar.kDT.setVisibility(0);
            if (imMessageCenterShowItemData.isSelected()) {
                ap.setBackgroundResource(aVar.kDT, R.drawable.btn_bgb_choice_s);
                ap.setBackgroundColor(aVar.kDJ, R.color.CAM_X0205);
                return;
            }
            ap.setBackgroundResource(aVar.kDT, R.drawable.btn_bgb_choice_n);
            ap.setBackgroundColor(aVar.kDJ, R.color.CAM_X0205);
            return;
        }
        aVar.kDT.setVisibility(8);
        com.baidu.tbadk.core.util.f.a.m(aVar.kDJ, R.color.CAM_X0205, R.color.CAM_X0204);
    }

    protected void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.kDO.setText("");
        } else {
            aVar.kDO.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    protected void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = au.getChatTimeString(date);
            }
            aVar.kDP.setText(str);
        }
    }

    protected void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            if (d.byh().byk() == 0) {
                unReadCount = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, String.valueOf(unReadCount));
                if (a2 != null && a2.getName() != null && a2.getName().length() > 0) {
                    unReadCount = com.baidu.adp.lib.f.b.toInt(a2.getName(), 0);
                }
            }
            aVar.kDQ.setThreeDotMode(2);
            aVar.kDQ.refresh(unReadCount);
            aVar.kDQ.setVisibility(0);
        } else {
            aVar.kDQ.setVisibility(8);
        }
        ap.setViewTextColor(aVar.kDN, R.color.CAM_X0105, 1);
        ap.setViewTextColor(aVar.kDO, R.color.CAM_X0109, 1);
        ap.setViewTextColor(aVar.kDP, R.color.CAM_X0109, 1);
    }

    public boolean cVb() {
        return this.kDI;
    }

    public void sF(boolean z) {
        this.kDI = z;
    }

    protected a dk(View view) {
        a aVar = new a();
        aVar.kDJ = (ViewGroup) view.findViewById(R.id.chat_item);
        aVar.kDL = (ImageView) view.findViewById(R.id.svg_head);
        aVar.kDK = (HeadImageView) view.findViewById(R.id.chat_head);
        aVar.kDM = (BarImageView) view.findViewById(R.id.forum_head);
        aVar.kDN = (TextView) view.findViewById(R.id.chat_name);
        aVar.kDO = (TextView) view.findViewById(R.id.last_chat_content);
        aVar.kDP = (TextView) view.findViewById(R.id.chat_time);
        aVar.mLine = view.findViewById(R.id.line);
        aVar.kDQ = (MessageRedDotView) view.findViewById(R.id.new_message);
        aVar.kDQ.setShadowEnabled(false);
        aVar.kDR = (ImageView) view.findViewById(R.id.iv_bell);
        aVar.kDS = (ImageView) view.findViewById(R.id.send_status);
        aVar.kDT = (ImageView) view.findViewById(R.id.select_status);
        aVar.kDK.setPlaceHolder(1);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ImageView kDL;
        public BarImageView kDM;
        public ViewGroup kDJ = null;
        public HeadImageView kDK = null;
        public TextView kDN = null;
        public TextView kDO = null;
        public TextView kDP = null;
        public MessageRedDotView kDQ = null;
        public View mLine = null;
        public ImageView kDR = null;
        public ImageView kDS = null;
        public ImageView kDT = null;

        protected a() {
        }
    }

    protected void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.kDS.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    ap.setBackgroundResource(aVar.kDS, R.drawable.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    ap.setBackgroundResource(aVar.kDS, R.drawable.icon_send_in_information);
                    return;
                } else {
                    aVar.kDS.setVisibility(8);
                    return;
                }
            }
            aVar.kDS.setVisibility(8);
        }
    }
}
