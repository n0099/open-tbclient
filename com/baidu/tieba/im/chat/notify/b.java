package com.baidu.tieba.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public abstract class b extends BaseAdapter {
    protected List<ImMessageCenterShowItemData> Wx = null;
    protected Context mContext;

    protected abstract BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str);

    protected abstract boolean a(ImMessageCenterShowItemData imMessageCenterShowItemData);

    protected abstract boolean b(ImMessageCenterShowItemData imMessageCenterShowItemData);

    protected abstract void f(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData);

    public b(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        if (this.Wx == null) {
            this.Wx = new LinkedList();
        }
        this.Wx = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Wx != null) {
            return this.Wx.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: fr */
    public ImMessageCenterShowItemData getItem(int i) {
        if (this.Wx == null || this.Wx.size() == 0 || i < 0 || i >= getCount()) {
            return null;
        }
        return this.Wx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar = null;
        if (view != null) {
            cVar = (c) view.getTag();
        }
        if (cVar == null) {
            view = com.baidu.adp.lib.g.b.ek().a(this.mContext, w.chat_list_item, viewGroup, false);
            cVar = I(view);
            view.setTag(cVar);
        }
        aw.h(view, u.list_selector);
        aw.h(cVar.MI, s.cp_bg_line_b);
        cVar.aQf.setVisibility(0);
        cVar.MI.setVisibility(0);
        ImMessageCenterShowItemData item = getItem(i);
        if (item != null) {
            a(cVar, item);
            c(cVar, item);
            g(cVar, item);
            d(cVar, item);
            f(cVar, item);
            e(cVar, item);
            b(cVar, item);
        }
        return view;
    }

    protected void a(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        cVar.aHq.setText(imMessageCenterShowItemData.getFriendName());
    }

    private void b(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (cVar != null) {
            if (imMessageCenterShowItemData == null) {
                cVar.aQj.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                com.baidu.tieba.im.pushNotify.a groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    cVar.aQj.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    cVar.aQj.setVisibility(0);
                    aw.c(cVar.aQj, u.icon_news_stop);
                } else {
                    cVar.aQj.setVisibility(8);
                }
            } else {
                cVar.aQj.setVisibility(8);
            }
        }
    }

    private void c(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            cVar.aQg.setText("");
        } else {
            cVar.aQg.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    private void d(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (cVar != null) {
        }
        Date date = new Date();
        date.setTime(imMessageCenterShowItemData.getServerTime());
        String str = "";
        if (imMessageCenterShowItemData.getServerTime() != 0) {
            str = ay.g(date);
        }
        cVar.aQh.setText(str);
    }

    private void e(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            cVar.aQi.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (TbadkApplication.m251getInst().getMsgFrequency() == 0) {
                valueOf = "";
                unReadCount = 0;
            } else {
                BasicNameValuePair a = a(imMessageCenterShowItemData, unReadCount, valueOf);
                if (a != null && a.getName() != null && a.getName().length() > 0) {
                    unReadCount = com.baidu.adp.lib.g.c.f(a.getName(), 0);
                    valueOf = a.getValue();
                    if (unReadCount == 0) {
                        valueOf = "";
                    }
                }
            }
            cVar.aQi.setText(valueOf);
        } else {
            cVar.aQi.setVisibility(8);
        }
        aw.b(cVar.aHq, s.cp_cont_b, 1);
        aw.b(cVar.aQg, s.cp_cont_d, 1);
        aw.b(cVar.aQh, s.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                aw.h((View) cVar.aQi, u.icon_news_down_bar_one);
                cVar.aQi.setWidth(0);
                cVar.aQi.setHeight(0);
            } else {
                aw.h((View) cVar.aQi, u.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            aw.h((View) cVar.aQi, u.icon_news_head_prompt_two);
        } else {
            aw.h((View) cVar.aQi, u.icon_news_head_prompt_more);
            cVar.aQi.setText("");
        }
        cVar.aQi.setTextColor(this.mContext.getResources().getColor(s.top_msg_num_day));
    }

    private c I(View view) {
        c cVar = new c(this);
        cVar.aQf = (ViewGroup) view.findViewById(v.list_content);
        cVar.aHp = (HeadImageView) view.findViewById(v.chat_head);
        cVar.aHq = (TextView) view.findViewById(v.chat_name);
        cVar.aQg = (TextView) view.findViewById(v.last_chat_content);
        cVar.aQh = (TextView) view.findViewById(v.chat_time);
        cVar.MI = view.findViewById(v.line);
        cVar.aQi = (TextView) view.findViewById(v.new_message);
        cVar.aQj = (ImageView) view.findViewById(v.iv_bell);
        cVar.aQk = (ImageView) view.findViewById(v.send_status);
        return cVar;
    }

    private void g(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (cVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                cVar.aQk.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    aw.h(cVar.aQk, u.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    aw.h(cVar.aQk, u.icon_send_in_information);
                    return;
                } else {
                    cVar.aQk.setVisibility(8);
                    return;
                }
            }
            cVar.aQk.setVisibility(8);
        }
    }
}
