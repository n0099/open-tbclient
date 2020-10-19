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
    protected boolean jEx = false;

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
    /* renamed from: BT */
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
            aVar = cH(view);
            view.setTag(aVar);
        }
        ap.setBackgroundResource(view, R.drawable.list_item_selector);
        ap.setBackgroundResource(aVar.mLine, R.color.cp_bg_line_e);
        aVar.jEy.setVisibility(0);
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
            aVar.jEC.setText(imMessageCenterShowItemData.getFriendNameShow());
        }
    }

    protected void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.jEG.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.jEG.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.jEG.setVisibility(0);
                    SvgManager.bmU().a(aVar.jEG, R.drawable.ic_icon_pure_shield_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL);
                } else {
                    aVar.jEG.setVisibility(8);
                }
            } else {
                aVar.jEG.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.jEx) {
            aVar.jEI.setVisibility(0);
            if (imMessageCenterShowItemData.isSelected()) {
                ap.setBackgroundResource(aVar.jEI, R.drawable.btn_bgb_choice_s);
                ap.setBackgroundColor(aVar.jEy, R.color.cp_bg_line_e);
                return;
            }
            ap.setBackgroundResource(aVar.jEI, R.drawable.btn_bgb_choice_n);
            ap.setBackgroundColor(aVar.jEy, R.color.cp_bg_line_e);
            return;
        }
        aVar.jEI.setVisibility(8);
        com.baidu.tbadk.core.util.e.a.g(aVar.jEy, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
    }

    protected void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.jED.setText("");
        } else {
            aVar.jED.setText(imMessageCenterShowItemData.getMsgContent());
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
            aVar.jEE.setText(str);
        }
    }

    protected void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            if (d.bsc().bsf() == 0) {
                unReadCount = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, String.valueOf(unReadCount));
                if (a2 != null && a2.getName() != null && a2.getName().length() > 0) {
                    unReadCount = com.baidu.adp.lib.f.b.toInt(a2.getName(), 0);
                }
            }
            aVar.jEF.setThreeDotMode(2);
            aVar.jEF.refresh(unReadCount);
            aVar.jEF.setVisibility(0);
        } else {
            aVar.jEF.setVisibility(8);
        }
        ap.setViewTextColor(aVar.jEC, R.color.cp_cont_b, 1);
        ap.setViewTextColor(aVar.jED, R.color.cp_cont_d, 1);
        ap.setViewTextColor(aVar.jEE, R.color.cp_cont_d, 1);
    }

    public boolean cJr() {
        return this.jEx;
    }

    public void qX(boolean z) {
        this.jEx = z;
    }

    protected a cH(View view) {
        a aVar = new a();
        aVar.jEy = (ViewGroup) view.findViewById(R.id.chat_item);
        aVar.jEA = (ImageView) view.findViewById(R.id.svg_head);
        aVar.jEz = (HeadImageView) view.findViewById(R.id.chat_head);
        aVar.jEB = (BarImageView) view.findViewById(R.id.forum_head);
        aVar.jEC = (TextView) view.findViewById(R.id.chat_name);
        aVar.jED = (TextView) view.findViewById(R.id.last_chat_content);
        aVar.jEE = (TextView) view.findViewById(R.id.chat_time);
        aVar.mLine = view.findViewById(R.id.line);
        aVar.jEF = (MessageRedDotView) view.findViewById(R.id.new_message);
        aVar.jEF.setShadowEnabled(false);
        aVar.jEG = (ImageView) view.findViewById(R.id.iv_bell);
        aVar.jEH = (ImageView) view.findViewById(R.id.send_status);
        aVar.jEI = (ImageView) view.findViewById(R.id.select_status);
        aVar.jEz.setPlaceHolder(1);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ImageView jEA;
        public BarImageView jEB;
        public ViewGroup jEy = null;
        public HeadImageView jEz = null;
        public TextView jEC = null;
        public TextView jED = null;
        public TextView jEE = null;
        public MessageRedDotView jEF = null;
        public View mLine = null;
        public ImageView jEG = null;
        public ImageView jEH = null;
        public ImageView jEI = null;

        protected a() {
        }
    }

    protected void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.jEH.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    ap.setBackgroundResource(aVar.jEH, R.drawable.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    ap.setBackgroundResource(aVar.jEH, R.drawable.icon_send_in_information);
                    return;
                } else {
                    aVar.jEH.setVisibility(8);
                    return;
                }
            }
            aVar.jEH.setVisibility(8);
        }
    }
}
