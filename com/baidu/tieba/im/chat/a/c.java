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
    protected boolean jQW = false;

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
    /* renamed from: Cm */
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
            aVar = cL(view);
            view.setTag(aVar);
        }
        ap.setBackgroundResource(view, R.drawable.list_item_selector);
        ap.setBackgroundResource(aVar.mLine, R.color.cp_bg_line_e);
        aVar.jQX.setVisibility(0);
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
            aVar.jRb.setText(imMessageCenterShowItemData.getFriendNameShow());
        }
    }

    protected void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.jRf.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.jRf.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.jRf.setVisibility(0);
                    SvgManager.boN().a(aVar.jRf, R.drawable.ic_icon_pure_shield_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL);
                } else {
                    aVar.jRf.setVisibility(8);
                }
            } else {
                aVar.jRf.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.jQW) {
            aVar.jRh.setVisibility(0);
            if (imMessageCenterShowItemData.isSelected()) {
                ap.setBackgroundResource(aVar.jRh, R.drawable.btn_bgb_choice_s);
                ap.setBackgroundColor(aVar.jQX, R.color.cp_bg_line_e);
                return;
            }
            ap.setBackgroundResource(aVar.jRh, R.drawable.btn_bgb_choice_n);
            ap.setBackgroundColor(aVar.jQX, R.color.cp_bg_line_e);
            return;
        }
        aVar.jRh.setVisibility(8);
        com.baidu.tbadk.core.util.e.a.g(aVar.jQX, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
    }

    protected void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.jRc.setText("");
        } else {
            aVar.jRc.setText(imMessageCenterShowItemData.getMsgContent());
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
            aVar.jRd.setText(str);
        }
    }

    protected void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            if (d.btV().btY() == 0) {
                unReadCount = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, String.valueOf(unReadCount));
                if (a2 != null && a2.getName() != null && a2.getName().length() > 0) {
                    unReadCount = com.baidu.adp.lib.f.b.toInt(a2.getName(), 0);
                }
            }
            aVar.jRe.setThreeDotMode(2);
            aVar.jRe.refresh(unReadCount);
            aVar.jRe.setVisibility(0);
        } else {
            aVar.jRe.setVisibility(8);
        }
        ap.setViewTextColor(aVar.jRb, R.color.cp_cont_b, 1);
        ap.setViewTextColor(aVar.jRc, R.color.cp_cont_d, 1);
        ap.setViewTextColor(aVar.jRd, R.color.cp_cont_d, 1);
    }

    public boolean cMy() {
        return this.jQW;
    }

    public void rp(boolean z) {
        this.jQW = z;
    }

    protected a cL(View view) {
        a aVar = new a();
        aVar.jQX = (ViewGroup) view.findViewById(R.id.chat_item);
        aVar.jQZ = (ImageView) view.findViewById(R.id.svg_head);
        aVar.jQY = (HeadImageView) view.findViewById(R.id.chat_head);
        aVar.jRa = (BarImageView) view.findViewById(R.id.forum_head);
        aVar.jRb = (TextView) view.findViewById(R.id.chat_name);
        aVar.jRc = (TextView) view.findViewById(R.id.last_chat_content);
        aVar.jRd = (TextView) view.findViewById(R.id.chat_time);
        aVar.mLine = view.findViewById(R.id.line);
        aVar.jRe = (MessageRedDotView) view.findViewById(R.id.new_message);
        aVar.jRe.setShadowEnabled(false);
        aVar.jRf = (ImageView) view.findViewById(R.id.iv_bell);
        aVar.jRg = (ImageView) view.findViewById(R.id.send_status);
        aVar.jRh = (ImageView) view.findViewById(R.id.select_status);
        aVar.jQY.setPlaceHolder(1);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ImageView jQZ;
        public BarImageView jRa;
        public ViewGroup jQX = null;
        public HeadImageView jQY = null;
        public TextView jRb = null;
        public TextView jRc = null;
        public TextView jRd = null;
        public MessageRedDotView jRe = null;
        public View mLine = null;
        public ImageView jRf = null;
        public ImageView jRg = null;
        public ImageView jRh = null;

        protected a() {
        }
    }

    protected void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.jRg.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    ap.setBackgroundResource(aVar.jRg, R.drawable.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    ap.setBackgroundResource(aVar.jRg, R.drawable.icon_send_in_information);
                    return;
                } else {
                    aVar.jRg.setVisibility(8);
                    return;
                }
            }
            aVar.jRg.setVisibility(8);
        }
    }
}
