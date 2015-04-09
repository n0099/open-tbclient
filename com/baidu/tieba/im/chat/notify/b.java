package com.baidu.tieba.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
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
    /* renamed from: fC */
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
            view = com.baidu.adp.lib.g.b.hH().a(this.mContext, w.chat_list_item, viewGroup, false);
            cVar = z(view);
            view.setTag(cVar);
        }
        ba.i(view, u.list_selector);
        ba.i(cVar.adg, s.cp_bg_line_b);
        cVar.aYv.setVisibility(0);
        cVar.adg.setVisibility(0);
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
        cVar.Mo.setText(imMessageCenterShowItemData.getFriendName());
    }

    private void b(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (cVar != null) {
            if (imMessageCenterShowItemData == null) {
                cVar.aYz.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                com.baidu.tieba.im.pushNotify.a groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    cVar.aYz.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    cVar.aYz.setVisibility(0);
                    ba.c(cVar.aYz, u.icon_news_stop);
                } else {
                    cVar.aYz.setVisibility(8);
                }
            } else {
                cVar.aYz.setVisibility(8);
            }
        }
    }

    private void c(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            cVar.aYw.setText("");
        } else {
            cVar.aYw.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    private void d(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (cVar != null) {
        }
        Date date = new Date();
        date.setTime(imMessageCenterShowItemData.getServerTime());
        String str = "";
        if (imMessageCenterShowItemData.getServerTime() != 0) {
            str = bd.f(date);
        }
        cVar.aYx.setText(str);
    }

    private void e(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            cVar.aYy.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().vz() == 0) {
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
            cVar.aYy.setText(valueOf);
        } else {
            cVar.aYy.setVisibility(8);
        }
        ba.b(cVar.Mo, s.cp_cont_b, 1);
        ba.b(cVar.aYw, s.cp_cont_d, 1);
        ba.b(cVar.aYx, s.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                ba.i((View) cVar.aYy, u.icon_news_down_bar_one);
                cVar.aYy.setWidth(0);
                cVar.aYy.setHeight(0);
            } else {
                ba.i((View) cVar.aYy, u.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            ba.i((View) cVar.aYy, u.icon_news_head_prompt_two);
        } else {
            ba.i((View) cVar.aYy, u.icon_news_head_prompt_more);
            cVar.aYy.setText("");
        }
        ba.b(cVar.aYy, s.frs_slidebar_message_text, 1);
    }

    private c z(View view) {
        c cVar = new c(this);
        cVar.aYv = (ViewGroup) view.findViewById(v.list_content);
        cVar.Mn = (HeadImageView) view.findViewById(v.chat_head);
        cVar.Mo = (TextView) view.findViewById(v.chat_name);
        cVar.aYw = (TextView) view.findViewById(v.last_chat_content);
        cVar.aYx = (TextView) view.findViewById(v.chat_time);
        cVar.adg = view.findViewById(v.line);
        cVar.aYy = (TextView) view.findViewById(v.new_message);
        cVar.aYz = (ImageView) view.findViewById(v.iv_bell);
        cVar.aYA = (ImageView) view.findViewById(v.send_status);
        return cVar;
    }

    private void g(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (cVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                cVar.aYA.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    ba.i(cVar.aYA, u.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    ba.i(cVar.aYA, u.icon_send_in_information);
                    return;
                } else {
                    cVar.aYA.setVisibility(8);
                    return;
                }
            }
            cVar.aYA.setVisibility(8);
        }
    }
}
