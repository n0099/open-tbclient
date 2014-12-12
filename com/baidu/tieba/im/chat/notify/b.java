package com.baidu.tieba.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
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
    /* renamed from: fu */
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
            view = com.baidu.adp.lib.g.b.ek().a(this.mContext, x.chat_list_item, viewGroup, false);
            cVar = B(view);
            view.setTag(cVar);
        }
        ax.i(view, v.list_selector);
        ax.i(cVar.mLine, t.cp_bg_line_b);
        cVar.aRX.setVisibility(0);
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
        cVar.zK.setText(imMessageCenterShowItemData.getFriendName());
    }

    private void b(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (cVar != null) {
            if (imMessageCenterShowItemData == null) {
                cVar.aSb.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                com.baidu.tieba.im.pushNotify.a groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    cVar.aSb.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    cVar.aSb.setVisibility(0);
                    ax.c(cVar.aSb, v.icon_news_stop);
                } else {
                    cVar.aSb.setVisibility(8);
                }
            } else {
                cVar.aSb.setVisibility(8);
            }
        }
    }

    private void c(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            cVar.aRY.setText("");
        } else {
            cVar.aRY.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    private void d(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (cVar != null) {
        }
        Date date = new Date();
        date.setTime(imMessageCenterShowItemData.getServerTime());
        String str = "";
        if (imMessageCenterShowItemData.getServerTime() != 0) {
            str = ba.g(date);
        }
        cVar.aRZ.setText(str);
    }

    private void e(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            cVar.aSa.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (TbadkCoreApplication.m255getInst().getMsgFrequency() == 0) {
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
            cVar.aSa.setText(valueOf);
        } else {
            cVar.aSa.setVisibility(8);
        }
        ax.b(cVar.zK, t.cp_cont_b, 1);
        ax.b(cVar.aRY, t.cp_cont_d, 1);
        ax.b(cVar.aRZ, t.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                ax.i((View) cVar.aSa, v.icon_news_down_bar_one);
                cVar.aSa.setWidth(0);
                cVar.aSa.setHeight(0);
            } else {
                ax.i((View) cVar.aSa, v.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            ax.i((View) cVar.aSa, v.icon_news_head_prompt_two);
        } else {
            ax.i((View) cVar.aSa, v.icon_news_head_prompt_more);
            cVar.aSa.setText("");
        }
        ax.b(cVar.aSa, t.frs_slidebar_message_text, 1);
    }

    private c B(View view) {
        c cVar = new c(this);
        cVar.aRX = (ViewGroup) view.findViewById(w.list_content);
        cVar.zJ = (HeadImageView) view.findViewById(w.chat_head);
        cVar.zK = (TextView) view.findViewById(w.chat_name);
        cVar.aRY = (TextView) view.findViewById(w.last_chat_content);
        cVar.aRZ = (TextView) view.findViewById(w.chat_time);
        cVar.mLine = view.findViewById(w.line);
        cVar.aSa = (TextView) view.findViewById(w.new_message);
        cVar.aSb = (ImageView) view.findViewById(w.iv_bell);
        cVar.aSc = (ImageView) view.findViewById(w.send_status);
        return cVar;
    }

    private void g(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (cVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                cVar.aSc.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    ax.i(cVar.aSc, v.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    ax.i(cVar.aSc, v.icon_send_in_information);
                    return;
                } else {
                    cVar.aSc.setVisibility(8);
                    return;
                }
            }
            cVar.aSc.setVisibility(8);
        }
    }
}
