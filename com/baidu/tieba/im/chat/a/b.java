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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public abstract class b extends BaseAdapter {
    protected Context mContext;
    protected List<ImMessageCenterShowItemData> mList = null;
    protected boolean diw = false;

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
    /* renamed from: lM */
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
            view = LayoutInflater.from(this.mContext).inflate(d.j.chat_list_item, viewGroup, false);
            aVar = aE(view);
            view.setTag(aVar);
        }
        ai.j(view, d.g.list_selector);
        ai.j(aVar.auM, d.e.cp_bg_line_b);
        aVar.dix.setVisibility(0);
        aVar.auM.setVisibility(0);
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
        aVar.diz.setText(imMessageCenterShowItemData.getFriendName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.diD.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.diD.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.diD.setVisibility(0);
                    ai.c(aVar.diD, d.g.icon_news_stop);
                } else {
                    aVar.diD.setVisibility(8);
                }
            } else {
                aVar.diD.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.diw) {
            aVar.diF.setVisibility(0);
        } else {
            aVar.diF.setVisibility(8);
        }
        if (imMessageCenterShowItemData.isSelected()) {
            ai.j(aVar.diF, d.g.btn_bgb_choice_s);
            ai.k(aVar.dix, d.e.cp_bg_line_e);
            return;
        }
        ai.j(aVar.diF, d.g.btn_bgb_choice_n);
        ai.k(aVar.dix, d.e.cp_bg_line_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.diA.setText("");
        } else {
            aVar.diA.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = al.f(date);
            }
            aVar.diB.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            aVar.diC.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (com.baidu.tbadk.coreExtra.messageCenter.b.zw().zz() == 0) {
                valueOf = "";
                unReadCount = 0;
            } else {
                BasicNameValuePair a2 = a(imMessageCenterShowItemData, unReadCount, valueOf);
                if (a2 != null && a2.getName() != null && a2.getName().length() > 0) {
                    unReadCount = com.baidu.adp.lib.g.b.g(a2.getName(), 0);
                    valueOf = a2.getValue();
                    if (unReadCount == 0) {
                        valueOf = "";
                    }
                }
            }
            aVar.diC.setText(valueOf);
        } else {
            aVar.diC.setVisibility(8);
        }
        ai.c(aVar.diz, d.e.cp_cont_b, 1);
        ai.c(aVar.diA, d.e.cp_cont_d, 1);
        ai.c(aVar.diB, d.e.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                ai.j(aVar.diC, d.g.icon_news_down_bar_one);
                aVar.diC.setWidth(0);
                aVar.diC.setHeight(0);
            } else {
                ai.j(aVar.diC, d.g.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            ai.j(aVar.diC, d.g.icon_news_head_prompt_two);
        } else {
            ai.j(aVar.diC, d.g.icon_news_head_prompt_more);
            aVar.diC.setText("");
        }
        ai.c(aVar.diC, d.e.common_color_10225, 1);
    }

    public boolean asc() {
        return this.diw;
    }

    public void fW(boolean z) {
        this.diw = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a aE(View view) {
        a aVar = new a();
        aVar.dix = (ViewGroup) view.findViewById(d.h.chat_item);
        aVar.diy = (HeadImageView) view.findViewById(d.h.chat_head);
        aVar.diz = (TextView) view.findViewById(d.h.chat_name);
        aVar.diA = (TextView) view.findViewById(d.h.last_chat_content);
        aVar.diB = (TextView) view.findViewById(d.h.chat_time);
        aVar.auM = view.findViewById(d.h.line);
        aVar.diC = (TextView) view.findViewById(d.h.new_message);
        aVar.diD = (ImageView) view.findViewById(d.h.iv_bell);
        aVar.diE = (ImageView) view.findViewById(d.h.send_status);
        aVar.diF = (ImageView) view.findViewById(d.h.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup dix = null;
        public HeadImageView diy = null;
        public TextView diz = null;
        public TextView diA = null;
        public TextView diB = null;
        public TextView diC = null;
        public View auM = null;
        public ImageView diD = null;
        public ImageView diE = null;
        public ImageView diF = null;

        protected a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.diE.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    ai.j(aVar.diE, d.g.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    ai.j(aVar.diE, d.g.icon_send_in_information);
                    return;
                } else {
                    aVar.diE.setVisibility(8);
                    return;
                }
            }
            aVar.diE.setVisibility(8);
        }
    }
}
