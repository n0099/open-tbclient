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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.messageCenter.c;
import com.baidu.tieba.n;
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
    /* renamed from: hJ */
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
            view = LayoutInflater.from(this.mContext).inflate(n.g.chat_list_item, viewGroup, false);
            aVar = Q(view);
            view.setTag(aVar);
        }
        as.i(view, n.e.list_selector);
        as.i(aVar.mLine, n.c.cp_bg_line_b);
        aVar.bIr.setVisibility(0);
        aVar.mLine.setVisibility(0);
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
        aVar.MN.setText(imMessageCenterShowItemData.getFriendName());
    }

    private void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.bIv.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                com.baidu.tieba.im.pushNotify.a groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.bIv.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.bIv.setVisibility(0);
                    as.c(aVar.bIv, n.e.icon_news_stop);
                } else {
                    aVar.bIv.setVisibility(8);
                }
            } else {
                aVar.bIv.setVisibility(8);
            }
        }
    }

    private void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.bIs.setText("");
        } else {
            aVar.bIs.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    private void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = ax.f(date);
            }
            aVar.bIt.setText(str);
        }
    }

    private void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            aVar.bIu.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (c.yg().yj() == 0) {
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
            aVar.bIu.setText(valueOf);
        } else {
            aVar.bIu.setVisibility(8);
        }
        as.b(aVar.MN, n.c.cp_cont_b, 1);
        as.b(aVar.bIs, n.c.cp_cont_d, 1);
        as.b(aVar.bIt, n.c.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                as.i((View) aVar.bIu, n.e.icon_news_down_bar_one);
                aVar.bIu.setWidth(0);
                aVar.bIu.setHeight(0);
            } else {
                as.i((View) aVar.bIu, n.e.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            as.i((View) aVar.bIu, n.e.icon_news_head_prompt_two);
        } else {
            as.i((View) aVar.bIu, n.e.icon_news_head_prompt_more);
            aVar.bIu.setText("");
        }
        as.b(aVar.bIu, n.c.frs_slidebar_message_text, 1);
    }

    private a Q(View view) {
        a aVar = new a();
        aVar.bIr = (ViewGroup) view.findViewById(n.f.list_content);
        aVar.MM = (HeadImageView) view.findViewById(n.f.chat_head);
        aVar.MN = (TextView) view.findViewById(n.f.chat_name);
        aVar.bIs = (TextView) view.findViewById(n.f.last_chat_content);
        aVar.bIt = (TextView) view.findViewById(n.f.chat_time);
        aVar.mLine = view.findViewById(n.f.line);
        aVar.bIu = (TextView) view.findViewById(n.f.new_message);
        aVar.bIv = (ImageView) view.findViewById(n.f.iv_bell);
        aVar.bIw = (ImageView) view.findViewById(n.f.send_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup bIr = null;
        public HeadImageView MM = null;
        public TextView MN = null;
        public TextView bIs = null;
        public TextView bIt = null;
        public TextView bIu = null;
        public View mLine = null;
        public ImageView bIv = null;
        public ImageView bIw = null;

        protected a() {
        }
    }

    private void g(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.bIw.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    as.i(aVar.bIw, n.e.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    as.i(aVar.bIw, n.e.icon_send_in_information);
                    return;
                } else {
                    aVar.bIw.setVisibility(8);
                    return;
                }
            }
            aVar.bIw.setVisibility(8);
        }
    }
}
