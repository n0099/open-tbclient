package com.baidu.tieba.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.messageCenter.c;
import com.baidu.tieba.u;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public abstract class b extends BaseAdapter {
    protected Context mContext;
    protected List<ImMessageCenterShowItemData> mList = null;
    protected boolean cGs = false;

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
    /* renamed from: ks */
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
            view = LayoutInflater.from(this.mContext).inflate(u.h.chat_list_item, viewGroup, false);
            aVar = aG(view);
            view.setTag(aVar);
        }
        av.k(view, u.f.list_selector);
        av.k(aVar.aja, u.d.cp_bg_line_b);
        aVar.cGt.setVisibility(0);
        aVar.aja.setVisibility(0);
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
        aVar.Ef.setText(imMessageCenterShowItemData.getFriendName());
    }

    private void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.cGx.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                com.baidu.tieba.im.pushNotify.a groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.cGx.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.cGx.setVisibility(0);
                    av.c(aVar.cGx, u.f.icon_news_stop);
                } else {
                    aVar.cGx.setVisibility(8);
                }
            } else {
                aVar.cGx.setVisibility(8);
            }
        }
    }

    private void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.cGs) {
            aVar.cGz.setVisibility(0);
        } else {
            aVar.cGz.setVisibility(8);
        }
        if (imMessageCenterShowItemData.isSelected()) {
            av.k(aVar.cGz, u.f.btn_bgb_choice_s);
            av.l(aVar.cGt, u.d.cp_bg_line_e);
            return;
        }
        av.k(aVar.cGz, u.f.btn_bgb_choice_n);
        av.l(aVar.cGt, u.d.cp_bg_line_d);
    }

    private void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.cGu.setText("");
        } else {
            aVar.cGu.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    private void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = ba.f(date);
            }
            aVar.cGv.setText(str);
        }
    }

    private void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            aVar.cGw.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (c.xK().xN() == 0) {
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
            aVar.cGw.setText(valueOf);
        } else {
            aVar.cGw.setVisibility(8);
        }
        av.c(aVar.Ef, u.d.cp_cont_b, 1);
        av.c(aVar.cGu, u.d.cp_cont_d, 1);
        av.c(aVar.cGv, u.d.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                av.k(aVar.cGw, u.f.icon_news_down_bar_one);
                aVar.cGw.setWidth(0);
                aVar.cGw.setHeight(0);
            } else {
                av.k(aVar.cGw, u.f.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            av.k(aVar.cGw, u.f.icon_news_head_prompt_two);
        } else {
            av.k(aVar.cGw, u.f.icon_news_head_prompt_more);
            aVar.cGw.setText("");
        }
        av.c(aVar.cGw, u.d.common_color_10225, 1);
    }

    public boolean akP() {
        return this.cGs;
    }

    public void eU(boolean z) {
        this.cGs = z;
    }

    private a aG(View view) {
        a aVar = new a();
        aVar.cGt = (ViewGroup) view.findViewById(u.g.chat_item);
        aVar.Ee = (HeadImageView) view.findViewById(u.g.chat_head);
        aVar.Ef = (TextView) view.findViewById(u.g.chat_name);
        aVar.cGu = (TextView) view.findViewById(u.g.last_chat_content);
        aVar.cGv = (TextView) view.findViewById(u.g.chat_time);
        aVar.aja = view.findViewById(u.g.line);
        aVar.cGw = (TextView) view.findViewById(u.g.new_message);
        aVar.cGx = (ImageView) view.findViewById(u.g.iv_bell);
        aVar.cGy = (ImageView) view.findViewById(u.g.send_status);
        aVar.cGz = (ImageView) view.findViewById(u.g.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup cGt = null;
        public HeadImageView Ee = null;
        public TextView Ef = null;
        public TextView cGu = null;
        public TextView cGv = null;
        public TextView cGw = null;
        public View aja = null;
        public ImageView cGx = null;
        public ImageView cGy = null;
        public ImageView cGz = null;

        protected a() {
        }
    }

    private void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.cGy.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    av.k(aVar.cGy, u.f.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    av.k(aVar.cGy, u.f.icon_send_in_information);
                    return;
                } else {
                    aVar.cGy.setVisibility(8);
                    return;
                }
            }
            aVar.cGy.setVisibility(8);
        }
    }
}
