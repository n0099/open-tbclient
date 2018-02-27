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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
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
    protected boolean ewU = false;

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
    /* renamed from: pJ */
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
            view = LayoutInflater.from(this.mContext).inflate(d.h.chat_list_item, viewGroup, false);
            aVar = bY(view);
            view.setTag(aVar);
        }
        aj.s(view, d.f.list_selector);
        aj.s(aVar.mLine, d.C0141d.cp_bg_line_c);
        aVar.ewV.setVisibility(0);
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
        aVar.ewX.setText(imMessageCenterShowItemData.getFriendName());
    }

    protected void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.exb.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.exb.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.exb.setVisibility(0);
                    aj.c(aVar.exb, d.f.icon_news_stop);
                } else {
                    aVar.exb.setVisibility(8);
                }
            } else {
                aVar.exb.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.ewU) {
            aVar.exd.setVisibility(0);
            if (imMessageCenterShowItemData.isSelected()) {
                aj.s(aVar.exd, d.f.btn_bgb_choice_s);
                aj.t(aVar.ewV, d.C0141d.cp_bg_line_e);
                return;
            }
            aj.s(aVar.exd, d.f.btn_bgb_choice_n);
            aj.t(aVar.ewV, d.C0141d.cp_bg_line_d);
            return;
        }
        aVar.exd.setVisibility(8);
        aj.s(aVar.ewV, d.f.list_selector);
    }

    protected void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.ewY.setText("");
        } else {
            aVar.ewY.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    protected void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = am.f(date);
            }
            aVar.ewZ.setText(str);
        }
    }

    protected void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int h;
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hs() == 0) {
                h = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, unReadCount > 99 ? "..." : String.valueOf(unReadCount));
                h = (a2 == null || a2.getName() == null || a2.getName().length() <= 0) ? unReadCount : com.baidu.adp.lib.g.b.h(a2.getName(), 0);
            }
            aVar.exa.refresh(h);
            aVar.exa.setVisibility(0);
        } else {
            aVar.exa.setVisibility(8);
        }
        aj.e(aVar.ewX, d.C0141d.cp_cont_b, 1);
        aj.e(aVar.ewY, d.C0141d.cp_cont_d, 1);
        aj.e(aVar.ewZ, d.C0141d.cp_cont_d, 1);
    }

    public boolean aGd() {
        return this.ewU;
    }

    public void hf(boolean z) {
        this.ewU = z;
    }

    protected a bY(View view) {
        a aVar = new a();
        aVar.ewV = (ViewGroup) view.findViewById(d.g.chat_item);
        aVar.ewW = (HeadImageView) view.findViewById(d.g.chat_head);
        aVar.ewX = (TextView) view.findViewById(d.g.chat_name);
        aVar.ewY = (TextView) view.findViewById(d.g.last_chat_content);
        aVar.ewZ = (TextView) view.findViewById(d.g.chat_time);
        aVar.mLine = view.findViewById(d.g.line);
        aVar.exa = (MessageRedDotView) view.findViewById(d.g.new_message);
        aVar.exb = (ImageView) view.findViewById(d.g.iv_bell);
        aVar.exc = (ImageView) view.findViewById(d.g.send_status);
        aVar.exd = (ImageView) view.findViewById(d.g.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup ewV = null;
        public HeadImageView ewW = null;
        public TextView ewX = null;
        public TextView ewY = null;
        public TextView ewZ = null;
        public MessageRedDotView exa = null;
        public View mLine = null;
        public ImageView exb = null;
        public ImageView exc = null;
        public ImageView exd = null;

        protected a() {
        }
    }

    protected void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.exc.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    aj.s(aVar.exc, d.f.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    aj.s(aVar.exc, d.f.icon_send_in_information);
                    return;
                } else {
                    aVar.exc.setVisibility(8);
                    return;
                }
            }
            aVar.exc.setVisibility(8);
        }
    }
}
