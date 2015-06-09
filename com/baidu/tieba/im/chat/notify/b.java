package com.baidu.tieba.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public abstract class b extends BaseAdapter {
    protected Context mContext;
    protected List<ImMessageCenterShowItemData> mList = null;

    protected abstract BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str);

    protected abstract boolean a(ImMessageCenterShowItemData imMessageCenterShowItemData);

    protected abstract boolean b(ImMessageCenterShowItemData imMessageCenterShowItemData);

    protected abstract void f(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData);

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
    /* renamed from: fT */
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
        c cVar = null;
        if (view != null) {
            cVar = (c) view.getTag();
        }
        if (cVar == null) {
            view = com.baidu.adp.lib.g.b.hr().a(this.mContext, r.chat_list_item, viewGroup, false);
            cVar = C(view);
            view.setTag(cVar);
        }
        ay.i(view, p.list_selector);
        ay.i(cVar.mLine, n.cp_bg_line_b);
        cVar.bbd.setVisibility(0);
        cVar.mLine.setVisibility(0);
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
        cVar.Mj.setText(imMessageCenterShowItemData.getFriendName());
    }

    private void b(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (cVar != null) {
            if (imMessageCenterShowItemData == null) {
                cVar.bbh.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                com.baidu.tieba.im.pushNotify.a groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    cVar.bbh.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    cVar.bbh.setVisibility(0);
                    ay.c(cVar.bbh, p.icon_news_stop);
                } else {
                    cVar.bbh.setVisibility(8);
                }
            } else {
                cVar.bbh.setVisibility(8);
            }
        }
    }

    private void c(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            cVar.bbe.setText("");
        } else {
            cVar.bbe.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    private void d(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (cVar != null) {
        }
        Date date = new Date();
        date.setTime(imMessageCenterShowItemData.getServerTime());
        String str = "";
        if (imMessageCenterShowItemData.getServerTime() != 0) {
            str = bb.f(date);
        }
        cVar.bbf.setText(str);
    }

    private void e(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            cVar.bbg.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wj() == 0) {
                valueOf = "";
                unReadCount = 0;
            } else {
                BasicNameValuePair a = a(imMessageCenterShowItemData, unReadCount, valueOf);
                if (a != null && a.getName() != null && a.getName().length() > 0) {
                    unReadCount = com.baidu.adp.lib.g.c.toInt(a.getName(), 0);
                    valueOf = a.getValue();
                    if (unReadCount == 0) {
                        valueOf = "";
                    }
                }
            }
            cVar.bbg.setText(valueOf);
        } else {
            cVar.bbg.setVisibility(8);
        }
        ay.b(cVar.Mj, n.cp_cont_b, 1);
        ay.b(cVar.bbe, n.cp_cont_d, 1);
        ay.b(cVar.bbf, n.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                ay.i((View) cVar.bbg, p.icon_news_down_bar_one);
                cVar.bbg.setWidth(0);
                cVar.bbg.setHeight(0);
            } else {
                ay.i((View) cVar.bbg, p.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            ay.i((View) cVar.bbg, p.icon_news_head_prompt_two);
        } else {
            ay.i((View) cVar.bbg, p.icon_news_head_prompt_more);
            cVar.bbg.setText("");
        }
        ay.b(cVar.bbg, n.frs_slidebar_message_text, 1);
    }

    private c C(View view) {
        c cVar = new c(this);
        cVar.bbd = (ViewGroup) view.findViewById(q.list_content);
        cVar.Mi = (HeadImageView) view.findViewById(q.chat_head);
        cVar.Mj = (TextView) view.findViewById(q.chat_name);
        cVar.bbe = (TextView) view.findViewById(q.last_chat_content);
        cVar.bbf = (TextView) view.findViewById(q.chat_time);
        cVar.mLine = view.findViewById(q.line);
        cVar.bbg = (TextView) view.findViewById(q.new_message);
        cVar.bbh = (ImageView) view.findViewById(q.iv_bell);
        cVar.bbi = (ImageView) view.findViewById(q.send_status);
        return cVar;
    }

    private void g(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (cVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                cVar.bbi.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    ay.i(cVar.bbi, p.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    ay.i(cVar.bbi, p.icon_send_in_information);
                    return;
                } else {
                    cVar.bbi.setVisibility(8);
                    return;
                }
            }
            cVar.bbi.setVisibility(8);
        }
    }
}
