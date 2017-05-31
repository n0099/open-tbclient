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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.messageCenter.c;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.tieba.w;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public abstract class b extends BaseAdapter {
    protected Context mContext;
    protected List<ImMessageCenterShowItemData> mList = null;
    protected boolean cQA = false;

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
    /* renamed from: ls */
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
            view = LayoutInflater.from(this.mContext).inflate(w.j.chat_list_item, viewGroup, false);
            aVar = ax(view);
            view.setTag(aVar);
        }
        aq.j(view, w.g.list_selector);
        aq.j(aVar.arA, w.e.cp_bg_line_b);
        aVar.cQB.setVisibility(0);
        aVar.arA.setVisibility(0);
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
        aVar.cQD.setText(imMessageCenterShowItemData.getFriendName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.cQH.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.cQH.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.cQH.setVisibility(0);
                    aq.c(aVar.cQH, w.g.icon_news_stop);
                } else {
                    aVar.cQH.setVisibility(8);
                }
            } else {
                aVar.cQH.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.cQA) {
            aVar.cQJ.setVisibility(0);
        } else {
            aVar.cQJ.setVisibility(8);
        }
        if (imMessageCenterShowItemData.isSelected()) {
            aq.j(aVar.cQJ, w.g.btn_bgb_choice_s);
            aq.k(aVar.cQB, w.e.cp_bg_line_e);
            return;
        }
        aq.j(aVar.cQJ, w.g.btn_bgb_choice_n);
        aq.k(aVar.cQB, w.e.cp_bg_line_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.cQE.setText("");
        } else {
            aVar.cQE.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = au.f(date);
            }
            aVar.cQF.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            aVar.cQG.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (c.yK().yN() == 0) {
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
            aVar.cQG.setText(valueOf);
        } else {
            aVar.cQG.setVisibility(8);
        }
        aq.c(aVar.cQD, w.e.cp_cont_b, 1);
        aq.c(aVar.cQE, w.e.cp_cont_d, 1);
        aq.c(aVar.cQF, w.e.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                aq.j(aVar.cQG, w.g.icon_news_down_bar_one);
                aVar.cQG.setWidth(0);
                aVar.cQG.setHeight(0);
            } else {
                aq.j(aVar.cQG, w.g.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            aq.j(aVar.cQG, w.g.icon_news_head_prompt_two);
        } else {
            aq.j(aVar.cQG, w.g.icon_news_head_prompt_more);
            aVar.cQG.setText("");
        }
        aq.c(aVar.cQG, w.e.common_color_10225, 1);
    }

    public boolean amz() {
        return this.cQA;
    }

    public void fr(boolean z) {
        this.cQA = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a ax(View view) {
        a aVar = new a();
        aVar.cQB = (ViewGroup) view.findViewById(w.h.chat_item);
        aVar.cQC = (HeadImageView) view.findViewById(w.h.chat_head);
        aVar.cQD = (TextView) view.findViewById(w.h.chat_name);
        aVar.cQE = (TextView) view.findViewById(w.h.last_chat_content);
        aVar.cQF = (TextView) view.findViewById(w.h.chat_time);
        aVar.arA = view.findViewById(w.h.line);
        aVar.cQG = (TextView) view.findViewById(w.h.new_message);
        aVar.cQH = (ImageView) view.findViewById(w.h.iv_bell);
        aVar.cQI = (ImageView) view.findViewById(w.h.send_status);
        aVar.cQJ = (ImageView) view.findViewById(w.h.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup cQB = null;
        public HeadImageView cQC = null;
        public TextView cQD = null;
        public TextView cQE = null;
        public TextView cQF = null;
        public TextView cQG = null;
        public View arA = null;
        public ImageView cQH = null;
        public ImageView cQI = null;
        public ImageView cQJ = null;

        protected a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.cQI.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    aq.j(aVar.cQI, w.g.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    aq.j(aVar.cQI, w.g.icon_send_in_information);
                    return;
                } else {
                    aVar.cQI.setVisibility(8);
                    return;
                }
            }
            aVar.cQI.setVisibility(8);
        }
    }
}
