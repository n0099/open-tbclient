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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.messageCenter.c;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.tieba.r;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public abstract class b extends BaseAdapter {
    protected Context mContext;
    protected List<ImMessageCenterShowItemData> mList = null;
    protected boolean cNX = false;

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
    /* renamed from: lo */
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
            view = LayoutInflater.from(this.mContext).inflate(r.j.chat_list_item, viewGroup, false);
            aVar = aG(view);
            view.setTag(aVar);
        }
        ap.j(view, r.g.list_selector);
        ap.j(aVar.ame, r.e.cp_bg_line_b);
        aVar.cNY.setVisibility(0);
        aVar.ame.setVisibility(0);
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
        aVar.Gd.setText(imMessageCenterShowItemData.getFriendName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.cOc.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.cOc.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.cOc.setVisibility(0);
                    ap.c(aVar.cOc, r.g.icon_news_stop);
                } else {
                    aVar.cOc.setVisibility(8);
                }
            } else {
                aVar.cOc.setVisibility(8);
            }
        }
    }

    protected void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.cNX) {
            aVar.cOe.setVisibility(0);
        } else {
            aVar.cOe.setVisibility(8);
        }
        if (imMessageCenterShowItemData.isSelected()) {
            ap.j(aVar.cOe, r.g.btn_bgb_choice_s);
            ap.k(aVar.cNY, r.e.cp_bg_line_e);
            return;
        }
        ap.j(aVar.cOe, r.g.btn_bgb_choice_n);
        ap.k(aVar.cNY, r.e.cp_bg_line_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.cNZ.setText("");
        } else {
            aVar.cNZ.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = at.f(date);
            }
            aVar.cOa.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            aVar.cOb.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (c.yQ().yT() == 0) {
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
            aVar.cOb.setText(valueOf);
        } else {
            aVar.cOb.setVisibility(8);
        }
        ap.c(aVar.Gd, r.e.cp_cont_b, 1);
        ap.c(aVar.cNZ, r.e.cp_cont_d, 1);
        ap.c(aVar.cOa, r.e.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                ap.j((View) aVar.cOb, r.g.icon_news_down_bar_one);
                aVar.cOb.setWidth(0);
                aVar.cOb.setHeight(0);
            } else {
                ap.j((View) aVar.cOb, r.g.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            ap.j((View) aVar.cOb, r.g.icon_news_head_prompt_two);
        } else {
            ap.j((View) aVar.cOb, r.g.icon_news_head_prompt_more);
            aVar.cOb.setText("");
        }
        ap.c(aVar.cOb, r.e.common_color_10225, 1);
    }

    public boolean aor() {
        return this.cNX;
    }

    public void fC(boolean z) {
        this.cNX = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a aG(View view) {
        a aVar = new a();
        aVar.cNY = (ViewGroup) view.findViewById(r.h.chat_item);
        aVar.Gc = (HeadImageView) view.findViewById(r.h.chat_head);
        aVar.Gd = (TextView) view.findViewById(r.h.chat_name);
        aVar.cNZ = (TextView) view.findViewById(r.h.last_chat_content);
        aVar.cOa = (TextView) view.findViewById(r.h.chat_time);
        aVar.ame = view.findViewById(r.h.line);
        aVar.cOb = (TextView) view.findViewById(r.h.new_message);
        aVar.cOc = (ImageView) view.findViewById(r.h.iv_bell);
        aVar.cOd = (ImageView) view.findViewById(r.h.send_status);
        aVar.cOe = (ImageView) view.findViewById(r.h.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup cNY = null;
        public HeadImageView Gc = null;
        public TextView Gd = null;
        public TextView cNZ = null;
        public TextView cOa = null;
        public TextView cOb = null;
        public View ame = null;
        public ImageView cOc = null;
        public ImageView cOd = null;
        public ImageView cOe = null;

        protected a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.cOd.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    ap.j(aVar.cOd, r.g.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    ap.j(aVar.cOd, r.g.icon_send_in_information);
                    return;
                } else {
                    aVar.cOd.setVisibility(8);
                    return;
                }
            }
            aVar.cOd.setVisibility(8);
        }
    }
}
