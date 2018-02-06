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
    protected boolean exg = false;

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
        aj.s(aVar.mLine, d.C0140d.cp_bg_line_c);
        aVar.exh.setVisibility(0);
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
        aVar.exj.setText(imMessageCenterShowItemData.getFriendName());
    }

    protected void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.exn.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.exn.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.exn.setVisibility(0);
                    aj.c(aVar.exn, d.f.icon_news_stop);
                } else {
                    aVar.exn.setVisibility(8);
                }
            } else {
                aVar.exn.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.exg) {
            aVar.exp.setVisibility(0);
            if (imMessageCenterShowItemData.isSelected()) {
                aj.s(aVar.exp, d.f.btn_bgb_choice_s);
                aj.t(aVar.exh, d.C0140d.cp_bg_line_e);
                return;
            }
            aj.s(aVar.exp, d.f.btn_bgb_choice_n);
            aj.t(aVar.exh, d.C0140d.cp_bg_line_d);
            return;
        }
        aVar.exp.setVisibility(8);
        aj.s(aVar.exh, d.f.list_selector);
    }

    protected void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.exk.setText("");
        } else {
            aVar.exk.setText(imMessageCenterShowItemData.getMsgContent());
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
            aVar.exl.setText(str);
        }
    }

    protected void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int h;
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Ht() == 0) {
                h = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, unReadCount > 99 ? "..." : String.valueOf(unReadCount));
                h = (a2 == null || a2.getName() == null || a2.getName().length() <= 0) ? unReadCount : com.baidu.adp.lib.g.b.h(a2.getName(), 0);
            }
            aVar.exm.refresh(h);
            aVar.exm.setVisibility(0);
        } else {
            aVar.exm.setVisibility(8);
        }
        aj.e(aVar.exj, d.C0140d.cp_cont_b, 1);
        aj.e(aVar.exk, d.C0140d.cp_cont_d, 1);
        aj.e(aVar.exl, d.C0140d.cp_cont_d, 1);
    }

    public boolean aGe() {
        return this.exg;
    }

    public void hf(boolean z) {
        this.exg = z;
    }

    protected a bY(View view) {
        a aVar = new a();
        aVar.exh = (ViewGroup) view.findViewById(d.g.chat_item);
        aVar.exi = (HeadImageView) view.findViewById(d.g.chat_head);
        aVar.exj = (TextView) view.findViewById(d.g.chat_name);
        aVar.exk = (TextView) view.findViewById(d.g.last_chat_content);
        aVar.exl = (TextView) view.findViewById(d.g.chat_time);
        aVar.mLine = view.findViewById(d.g.line);
        aVar.exm = (MessageRedDotView) view.findViewById(d.g.new_message);
        aVar.exn = (ImageView) view.findViewById(d.g.iv_bell);
        aVar.exo = (ImageView) view.findViewById(d.g.send_status);
        aVar.exp = (ImageView) view.findViewById(d.g.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup exh = null;
        public HeadImageView exi = null;
        public TextView exj = null;
        public TextView exk = null;
        public TextView exl = null;
        public MessageRedDotView exm = null;
        public View mLine = null;
        public ImageView exn = null;
        public ImageView exo = null;
        public ImageView exp = null;

        protected a() {
        }
    }

    protected void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.exo.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    aj.s(aVar.exo, d.f.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    aj.s(aVar.exo, d.f.icon_send_in_information);
                    return;
                } else {
                    aVar.exo.setVisibility(8);
                    return;
                }
            }
            aVar.exo.setVisibility(8);
        }
    }
}
