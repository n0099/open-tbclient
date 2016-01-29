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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
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

    protected abstract BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str);

    protected abstract boolean a(ImMessageCenterShowItemData imMessageCenterShowItemData);

    protected abstract boolean b(ImMessageCenterShowItemData imMessageCenterShowItemData);

    protected abstract void f(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData);

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
    /* renamed from: iG */
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
            aVar = aj(view);
            view.setTag(aVar);
        }
        ar.k(view, t.f.list_selector);
        ar.k(aVar.amq, t.d.cp_bg_line_b);
        aVar.bQa.setVisibility(0);
        aVar.amq.setVisibility(0);
        ImMessageCenterShowItemData item = getItem(i);
        if (item != null) {
            a(aVar, item);
            c(aVar, item);
            g(aVar, item);
            d(aVar, item);
            f(aVar, item);
            e(aVar, item);
            b(aVar, item);
        }
        return view;
    }

    protected void a(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.NB.setText(imMessageCenterShowItemData.getFriendName());
    }

    private void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.bQe.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                com.baidu.tieba.im.pushNotify.a groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.bQe.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.bQe.setVisibility(0);
                    ar.c(aVar.bQe, t.f.icon_news_stop);
                } else {
                    aVar.bQe.setVisibility(8);
                }
            } else {
                aVar.bQe.setVisibility(8);
            }
        }
    }

    private void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.bQb.setText("");
        } else {
            aVar.bQb.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    private void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = aw.f(date);
            }
            aVar.bQc.setText(str);
        }
    }

    private void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            aVar.bQd.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (c.zk().zn() == 0) {
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
            aVar.bQd.setText(valueOf);
        } else {
            aVar.bQd.setVisibility(8);
        }
        ar.b(aVar.NB, t.d.cp_cont_b, 1);
        ar.b(aVar.bQb, t.d.cp_cont_d, 1);
        ar.b(aVar.bQc, t.d.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                ar.k(aVar.bQd, t.f.icon_news_down_bar_one);
                aVar.bQd.setWidth(0);
                aVar.bQd.setHeight(0);
            } else {
                ar.k(aVar.bQd, t.f.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            ar.k(aVar.bQd, t.f.icon_news_head_prompt_two);
        } else {
            ar.k(aVar.bQd, t.f.icon_news_head_prompt_more);
            aVar.bQd.setText("");
        }
        ar.b(aVar.bQd, t.d.frs_slidebar_message_text, 1);
    }

    private a aj(View view) {
        a aVar = new a();
        aVar.bQa = (ViewGroup) view.findViewById(t.g.chat_item);
        aVar.NA = (HeadImageView) view.findViewById(t.g.chat_head);
        aVar.NB = (TextView) view.findViewById(t.g.chat_name);
        aVar.bQb = (TextView) view.findViewById(t.g.last_chat_content);
        aVar.bQc = (TextView) view.findViewById(t.g.chat_time);
        aVar.amq = view.findViewById(t.g.line);
        aVar.bQd = (TextView) view.findViewById(t.g.new_message);
        aVar.bQe = (ImageView) view.findViewById(t.g.iv_bell);
        aVar.bQf = (ImageView) view.findViewById(t.g.send_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup bQa = null;
        public HeadImageView NA = null;
        public TextView NB = null;
        public TextView bQb = null;
        public TextView bQc = null;
        public TextView bQd = null;
        public View amq = null;
        public ImageView bQe = null;
        public ImageView bQf = null;

        protected a() {
        }
    }

    private void g(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.bQf.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    ar.k(aVar.bQf, t.f.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    ar.k(aVar.bQf, t.f.icon_send_in_information);
                    return;
                } else {
                    aVar.bQf.setVisibility(8);
                    return;
                }
            }
            aVar.bQf.setVisibility(8);
        }
    }
}
