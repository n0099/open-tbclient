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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
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
    protected boolean cYw = false;

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
    /* renamed from: lD */
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
            aVar = az(view);
            view.setTag(aVar);
        }
        as.j(view, w.g.list_selector);
        as.j(aVar.asD, w.e.cp_bg_line_b);
        aVar.cYx.setVisibility(0);
        aVar.asD.setVisibility(0);
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
        aVar.cYz.setText(imMessageCenterShowItemData.getFriendName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.cYD.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.cYD.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.cYD.setVisibility(0);
                    as.c(aVar.cYD, w.g.icon_news_stop);
                } else {
                    aVar.cYD.setVisibility(8);
                }
            } else {
                aVar.cYD.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.cYw) {
            aVar.cYF.setVisibility(0);
        } else {
            aVar.cYF.setVisibility(8);
        }
        if (imMessageCenterShowItemData.isSelected()) {
            as.j(aVar.cYF, w.g.btn_bgb_choice_s);
            as.k(aVar.cYx, w.e.cp_bg_line_e);
            return;
        }
        as.j(aVar.cYF, w.g.btn_bgb_choice_n);
        as.k(aVar.cYx, w.e.cp_bg_line_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.cYA.setText("");
        } else {
            aVar.cYA.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = aw.f(date);
            }
            aVar.cYB.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            aVar.cYC.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (c.zd().zg() == 0) {
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
            aVar.cYC.setText(valueOf);
        } else {
            aVar.cYC.setVisibility(8);
        }
        as.c(aVar.cYz, w.e.cp_cont_b, 1);
        as.c(aVar.cYA, w.e.cp_cont_d, 1);
        as.c(aVar.cYB, w.e.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                as.j(aVar.cYC, w.g.icon_news_down_bar_one);
                aVar.cYC.setWidth(0);
                aVar.cYC.setHeight(0);
            } else {
                as.j(aVar.cYC, w.g.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            as.j(aVar.cYC, w.g.icon_news_head_prompt_two);
        } else {
            as.j(aVar.cYC, w.g.icon_news_head_prompt_more);
            aVar.cYC.setText("");
        }
        as.c(aVar.cYC, w.e.common_color_10225, 1);
    }

    public boolean aqk() {
        return this.cYw;
    }

    public void fI(boolean z) {
        this.cYw = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a az(View view) {
        a aVar = new a();
        aVar.cYx = (ViewGroup) view.findViewById(w.h.chat_item);
        aVar.cYy = (HeadImageView) view.findViewById(w.h.chat_head);
        aVar.cYz = (TextView) view.findViewById(w.h.chat_name);
        aVar.cYA = (TextView) view.findViewById(w.h.last_chat_content);
        aVar.cYB = (TextView) view.findViewById(w.h.chat_time);
        aVar.asD = view.findViewById(w.h.line);
        aVar.cYC = (TextView) view.findViewById(w.h.new_message);
        aVar.cYD = (ImageView) view.findViewById(w.h.iv_bell);
        aVar.cYE = (ImageView) view.findViewById(w.h.send_status);
        aVar.cYF = (ImageView) view.findViewById(w.h.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup cYx = null;
        public HeadImageView cYy = null;
        public TextView cYz = null;
        public TextView cYA = null;
        public TextView cYB = null;
        public TextView cYC = null;
        public View asD = null;
        public ImageView cYD = null;
        public ImageView cYE = null;
        public ImageView cYF = null;

        protected a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.cYE.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    as.j(aVar.cYE, w.g.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    as.j(aVar.cYE, w.g.icon_send_in_information);
                    return;
                } else {
                    aVar.cYE.setVisibility(8);
                    return;
                }
            }
            aVar.cYE.setVisibility(8);
        }
    }
}
