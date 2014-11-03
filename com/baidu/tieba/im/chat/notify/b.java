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
import com.baidu.tbadk.core.util.az;
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
    protected List<ImMessageCenterShowItemData> WB = null;
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
        if (this.WB == null) {
            this.WB = new LinkedList();
        }
        this.WB = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.WB != null) {
            return this.WB.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: fr */
    public ImMessageCenterShowItemData getItem(int i) {
        if (this.WB == null || this.WB.size() == 0 || i < 0 || i >= getCount()) {
            return null;
        }
        return this.WB.get(i);
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
        aw.h(cVar.ML, s.cp_bg_line_b);
        cVar.aQt.setVisibility(0);
        cVar.ML.setVisibility(0);
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
        cVar.aHA.setText(imMessageCenterShowItemData.getFriendName());
    }

    private void b(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (cVar != null) {
            if (imMessageCenterShowItemData == null) {
                cVar.aQx.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                com.baidu.tieba.im.pushNotify.a groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    cVar.aQx.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    cVar.aQx.setVisibility(0);
                    aw.c(cVar.aQx, u.icon_news_stop);
                } else {
                    cVar.aQx.setVisibility(8);
                }
            } else {
                cVar.aQx.setVisibility(8);
            }
        }
    }

    private void c(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            cVar.aQu.setText("");
        } else {
            cVar.aQu.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    private void d(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (cVar != null) {
        }
        Date date = new Date();
        date.setTime(imMessageCenterShowItemData.getServerTime());
        String str = "";
        if (imMessageCenterShowItemData.getServerTime() != 0) {
            str = az.g(date);
        }
        cVar.aQv.setText(str);
    }

    private void e(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            cVar.aQw.setVisibility(0);
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
            cVar.aQw.setText(valueOf);
        } else {
            cVar.aQw.setVisibility(8);
        }
        aw.b(cVar.aHA, s.cp_cont_b, 1);
        aw.b(cVar.aQu, s.cp_cont_d, 1);
        aw.b(cVar.aQv, s.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                aw.h((View) cVar.aQw, u.icon_news_down_bar_one);
                cVar.aQw.setWidth(0);
                cVar.aQw.setHeight(0);
            } else {
                aw.h((View) cVar.aQw, u.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            aw.h((View) cVar.aQw, u.icon_news_head_prompt_two);
        } else {
            aw.h((View) cVar.aQw, u.icon_news_head_prompt_more);
            cVar.aQw.setText("");
        }
        aw.b(cVar.aQw, s.frs_slidebar_message_text, 1);
    }

    private c I(View view) {
        c cVar = new c(this);
        cVar.aQt = (ViewGroup) view.findViewById(v.list_content);
        cVar.aHz = (HeadImageView) view.findViewById(v.chat_head);
        cVar.aHA = (TextView) view.findViewById(v.chat_name);
        cVar.aQu = (TextView) view.findViewById(v.last_chat_content);
        cVar.aQv = (TextView) view.findViewById(v.chat_time);
        cVar.ML = view.findViewById(v.line);
        cVar.aQw = (TextView) view.findViewById(v.new_message);
        cVar.aQx = (ImageView) view.findViewById(v.iv_bell);
        cVar.aQy = (ImageView) view.findViewById(v.send_status);
        return cVar;
    }

    private void g(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (cVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                cVar.aQy.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    aw.h(cVar.aQy, u.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    aw.h(cVar.aQy, u.icon_send_in_information);
                    return;
                } else {
                    cVar.aQy.setVisibility(8);
                    return;
                }
            }
            cVar.aQy.setVisibility(8);
        }
    }
}
