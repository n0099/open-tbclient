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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.messageCenter.c;
import com.baidu.tieba.r;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public abstract class b extends BaseAdapter {
    protected Context mContext;
    protected List<ImMessageCenterShowItemData> mList = null;
    protected boolean cGP = false;

    protected abstract BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str);

    protected abstract boolean a(ImMessageCenterShowItemData imMessageCenterShowItemData);

    protected abstract boolean b(ImMessageCenterShowItemData imMessageCenterShowItemData);

    protected abstract void g(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData);

    public b(Context context) {
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
    /* renamed from: kB */
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
            view = LayoutInflater.from(this.mContext).inflate(r.h.chat_list_item, viewGroup, false);
            aVar = aC(view);
            view.setTag(aVar);
        }
        ar.k(view, r.f.list_selector);
        ar.k(aVar.amY, r.d.cp_bg_line_b);
        aVar.cGQ.setVisibility(0);
        aVar.amY.setVisibility(0);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.GT.setText(imMessageCenterShowItemData.getFriendName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.cGU.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                com.baidu.tieba.im.pushNotify.a groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.cGU.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.cGU.setVisibility(0);
                    ar.c(aVar.cGU, r.f.icon_news_stop);
                } else {
                    aVar.cGU.setVisibility(8);
                }
            } else {
                aVar.cGU.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.cGP) {
            aVar.cGW.setVisibility(0);
        } else {
            aVar.cGW.setVisibility(8);
        }
        if (imMessageCenterShowItemData.isSelected()) {
            ar.k(aVar.cGW, r.f.btn_bgb_choice_s);
            ar.l(aVar.cGQ, r.d.cp_bg_line_e);
            return;
        }
        ar.k(aVar.cGW, r.f.btn_bgb_choice_n);
        ar.l(aVar.cGQ, r.d.cp_bg_line_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.cGR.setText("");
        } else {
            aVar.cGR.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = av.f(date);
            }
            aVar.cGS.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            aVar.cGT.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (c.yV().yY() == 0) {
                valueOf = "";
                unReadCount = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, valueOf);
                if (a2 != null && a2.getName() != null && a2.getName().length() > 0) {
                    unReadCount = com.baidu.adp.lib.h.b.g(a2.getName(), 0);
                    valueOf = a2.getValue();
                    if (unReadCount == 0) {
                        valueOf = "";
                    }
                }
            }
            aVar.cGT.setText(valueOf);
        } else {
            aVar.cGT.setVisibility(8);
        }
        ar.c(aVar.GT, r.d.cp_cont_b, 1);
        ar.c(aVar.cGR, r.d.cp_cont_d, 1);
        ar.c(aVar.cGS, r.d.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                ar.k(aVar.cGT, r.f.icon_news_down_bar_one);
                aVar.cGT.setWidth(0);
                aVar.cGT.setHeight(0);
            } else {
                ar.k(aVar.cGT, r.f.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            ar.k(aVar.cGT, r.f.icon_news_head_prompt_two);
        } else {
            ar.k(aVar.cGT, r.f.icon_news_head_prompt_more);
            aVar.cGT.setText("");
        }
        ar.c(aVar.cGT, r.d.common_color_10225, 1);
    }

    public boolean anj() {
        return this.cGP;
    }

    public void fz(boolean z) {
        this.cGP = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a aC(View view) {
        a aVar = new a();
        aVar.cGQ = (ViewGroup) view.findViewById(r.g.chat_item);
        aVar.GS = (HeadImageView) view.findViewById(r.g.chat_head);
        aVar.GT = (TextView) view.findViewById(r.g.chat_name);
        aVar.cGR = (TextView) view.findViewById(r.g.last_chat_content);
        aVar.cGS = (TextView) view.findViewById(r.g.chat_time);
        aVar.amY = view.findViewById(r.g.line);
        aVar.cGT = (TextView) view.findViewById(r.g.new_message);
        aVar.cGU = (ImageView) view.findViewById(r.g.iv_bell);
        aVar.cGV = (ImageView) view.findViewById(r.g.send_status);
        aVar.cGW = (ImageView) view.findViewById(r.g.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup cGQ = null;
        public HeadImageView GS = null;
        public TextView GT = null;
        public TextView cGR = null;
        public TextView cGS = null;
        public TextView cGT = null;
        public View amY = null;
        public ImageView cGU = null;
        public ImageView cGV = null;
        public ImageView cGW = null;

        protected a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.cGV.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    ar.k(aVar.cGV, r.f.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    ar.k(aVar.cGV, r.f.icon_send_in_information);
                    return;
                } else {
                    aVar.cGV.setVisibility(8);
                    return;
                }
            }
            aVar.cGV.setVisibility(8);
        }
    }
}
