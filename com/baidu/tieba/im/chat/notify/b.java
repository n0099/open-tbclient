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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.messageCenter.c;
import com.baidu.tieba.t;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public abstract class b extends BaseAdapter {
    protected Context mContext;
    protected List<ImMessageCenterShowItemData> mList = null;
    protected boolean caW = false;

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
    /* renamed from: iR */
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
            view = LayoutInflater.from(this.mContext).inflate(t.h.chat_list_item, viewGroup, false);
            aVar = ay(view);
            view.setTag(aVar);
        }
        at.k(view, t.f.list_selector);
        at.k(aVar.aiu, t.d.cp_bg_line_b);
        aVar.caX.setVisibility(0);
        aVar.aiu.setVisibility(0);
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
        aVar.Ea.setText(imMessageCenterShowItemData.getFriendName());
    }

    private void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.cbb.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                com.baidu.tieba.im.pushNotify.a groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.cbb.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.cbb.setVisibility(0);
                    at.c(aVar.cbb, t.f.icon_news_stop);
                } else {
                    aVar.cbb.setVisibility(8);
                }
            } else {
                aVar.cbb.setVisibility(8);
            }
        }
    }

    private void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (this.caW) {
            aVar.cbd.setVisibility(0);
        } else {
            aVar.cbd.setVisibility(8);
        }
        if (imMessageCenterShowItemData.isSelected()) {
            at.k(aVar.cbd, t.f.btn_bgb_choice_s);
            at.l(aVar.caX, t.d.cp_bg_line_e);
            return;
        }
        at.k(aVar.cbd, t.f.btn_bgb_choice_n);
        at.l(aVar.caX, t.d.cp_bg_line_d);
    }

    private void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.caY.setText("");
        } else {
            aVar.caY.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    private void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = ay.f(date);
            }
            aVar.caZ.setText(str);
        }
    }

    private void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            aVar.cba.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (c.xF().xI() == 0) {
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
            aVar.cba.setText(valueOf);
        } else {
            aVar.cba.setVisibility(8);
        }
        at.c(aVar.Ea, t.d.cp_cont_b, 1);
        at.c(aVar.caY, t.d.cp_cont_d, 1);
        at.c(aVar.caZ, t.d.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                at.k(aVar.cba, t.f.icon_news_down_bar_one);
                aVar.cba.setWidth(0);
                aVar.cba.setHeight(0);
            } else {
                at.k(aVar.cba, t.f.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            at.k(aVar.cba, t.f.icon_news_head_prompt_two);
        } else {
            at.k(aVar.cba, t.f.icon_news_head_prompt_more);
            aVar.cba.setText("");
        }
        at.c(aVar.cba, t.d.frs_slidebar_message_text, 1);
    }

    public boolean acA() {
        return this.caW;
    }

    public void eg(boolean z) {
        this.caW = z;
    }

    private a ay(View view) {
        a aVar = new a();
        aVar.caX = (ViewGroup) view.findViewById(t.g.chat_item);
        aVar.DZ = (HeadImageView) view.findViewById(t.g.chat_head);
        aVar.Ea = (TextView) view.findViewById(t.g.chat_name);
        aVar.caY = (TextView) view.findViewById(t.g.last_chat_content);
        aVar.caZ = (TextView) view.findViewById(t.g.chat_time);
        aVar.aiu = view.findViewById(t.g.line);
        aVar.cba = (TextView) view.findViewById(t.g.new_message);
        aVar.cbb = (ImageView) view.findViewById(t.g.iv_bell);
        aVar.cbc = (ImageView) view.findViewById(t.g.send_status);
        aVar.cbd = (ImageView) view.findViewById(t.g.select_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup caX = null;
        public HeadImageView DZ = null;
        public TextView Ea = null;
        public TextView caY = null;
        public TextView caZ = null;
        public TextView cba = null;
        public View aiu = null;
        public ImageView cbb = null;
        public ImageView cbc = null;
        public ImageView cbd = null;

        protected a() {
        }
    }

    private void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.cbc.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    at.k(aVar.cbc, t.f.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    at.k(aVar.cbc, t.f.icon_send_in_information);
                    return;
                } else {
                    aVar.cbc.setVisibility(8);
                    return;
                }
            }
            aVar.cbc.setVisibility(8);
        }
    }
}
