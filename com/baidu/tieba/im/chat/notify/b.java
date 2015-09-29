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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.messageCenter.c;
import com.baidu.tieba.i;
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
    /* renamed from: gK */
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
            view = LayoutInflater.from(this.mContext).inflate(i.g.chat_list_item, viewGroup, false);
            aVar = J(view);
            view.setTag(aVar);
        }
        am.i(view, i.e.list_selector);
        am.i(aVar.mLine, i.c.cp_bg_line_b);
        aVar.bsw.setVisibility(0);
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
        aVar.Mu.setText(imMessageCenterShowItemData.getFriendName());
    }

    private void b(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null) {
            if (imMessageCenterShowItemData == null) {
                aVar.bsA.setVisibility(8);
            } else if (b(imMessageCenterShowItemData)) {
                com.baidu.tieba.im.pushNotify.a groupSetting = imMessageCenterShowItemData.getGroupSetting();
                if (groupSetting == null) {
                    aVar.bsA.setVisibility(8);
                } else if (!groupSetting.isAcceptNotify()) {
                    aVar.bsA.setVisibility(0);
                    am.c(aVar.bsA, i.e.icon_news_stop);
                } else {
                    aVar.bsA.setVisibility(8);
                }
            } else {
                aVar.bsA.setVisibility(8);
            }
        }
    }

    private void c(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
            aVar.bsx.setText("");
        } else {
            aVar.bsx.setText(imMessageCenterShowItemData.getMsgContent());
        }
    }

    private void d(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            String str = "";
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = ar.f(date);
            }
            aVar.bsy.setText(str);
        }
    }

    private void e(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int unReadCount = imMessageCenterShowItemData.getUnReadCount();
        if (unReadCount > 0) {
            aVar.bsz.setVisibility(0);
            String valueOf = unReadCount > 99 ? "..." : String.valueOf(unReadCount);
            if (c.xh().xk() == 0) {
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
            aVar.bsz.setText(valueOf);
        } else {
            aVar.bsz.setVisibility(8);
        }
        am.b(aVar.Mu, i.c.cp_cont_b, 1);
        am.b(aVar.bsx, i.c.cp_cont_d, 1);
        am.b(aVar.bsy, i.c.cp_cont_e, 1);
        if (unReadCount < 10) {
            if (unReadCount == 0) {
                am.i((View) aVar.bsz, i.e.icon_news_down_bar_one);
                aVar.bsz.setWidth(0);
                aVar.bsz.setHeight(0);
            } else {
                am.i((View) aVar.bsz, i.e.icon_news_head_prompt_one);
            }
        } else if (unReadCount < 100) {
            am.i((View) aVar.bsz, i.e.icon_news_head_prompt_two);
        } else {
            am.i((View) aVar.bsz, i.e.icon_news_head_prompt_more);
            aVar.bsz.setText("");
        }
        am.b(aVar.bsz, i.c.frs_slidebar_message_text, 1);
    }

    private a J(View view) {
        a aVar = new a();
        aVar.bsw = (ViewGroup) view.findViewById(i.f.list_content);
        aVar.Mt = (HeadImageView) view.findViewById(i.f.chat_head);
        aVar.Mu = (TextView) view.findViewById(i.f.chat_name);
        aVar.bsx = (TextView) view.findViewById(i.f.last_chat_content);
        aVar.bsy = (TextView) view.findViewById(i.f.chat_time);
        aVar.mLine = view.findViewById(i.f.line);
        aVar.bsz = (TextView) view.findViewById(i.f.new_message);
        aVar.bsA = (ImageView) view.findViewById(i.f.iv_bell);
        aVar.bsB = (ImageView) view.findViewById(i.f.send_status);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class a {
        public ViewGroup bsw = null;
        public HeadImageView Mt = null;
        public TextView Mu = null;
        public TextView bsx = null;
        public TextView bsy = null;
        public TextView bsz = null;
        public View mLine = null;
        public ImageView bsA = null;
        public ImageView bsB = null;

        protected a() {
        }
    }

    private void g(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (a(imMessageCenterShowItemData)) {
                aVar.bsB.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    am.i(aVar.bsB, i.e.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    am.i(aVar.bsB, i.e.icon_send_in_information);
                    return;
                } else {
                    aVar.bsB.setVisibility(8);
                    return;
                }
            }
            aVar.bsB.setVisibility(8);
        }
    }
}
