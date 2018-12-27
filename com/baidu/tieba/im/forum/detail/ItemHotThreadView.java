package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import java.util.HashMap;
import java.util.List;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class ItemHotThreadView extends LinearLayout {
    private HashMap<String, View> eRs;
    private List<SimpleThreadInfo> eRt;
    private Context mContext;

    public ItemHotThreadView(Context context) {
        super(context);
        this.eRs = new HashMap<>();
        init(context);
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eRs = new HashMap<>();
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.forum_detail_hot_thread, (ViewGroup) this, true);
        setVisibility(8);
    }

    public void setData(List<SimpleThreadInfo> list) {
        this.eRt = list;
        if (list != null && list.size() != 0) {
            setVisibility(0);
            int i = 0;
            while (i < list.size()) {
                a(list.get(i), i != list.size() + (-1));
                i++;
            }
        }
    }

    private void refresh() {
        setData(this.eRt);
    }

    private void a(SimpleThreadInfo simpleThreadInfo, boolean z) {
        a aVar;
        View view;
        if (simpleThreadInfo != null) {
            if (!this.eRs.containsKey(String.valueOf(simpleThreadInfo.tid))) {
                view = LayoutInflater.from(this.mContext).inflate(e.h.forum_detail_hot_thread_item, (ViewGroup) this, false);
                aVar = new a();
                aVar.eRv = (LinearLayout) view.findViewById(e.g.thread_item_ll);
                aVar.eRw = (TextView) view.findViewById(e.g.ht_item_title);
                aVar.eRx = (TextView) view.findViewById(e.g.ht_item_content);
                aVar.eRy = (TextView) view.findViewById(e.g.ht_item_reply);
                aVar.eRz = (TextView) view.findViewById(e.g.ht_divider_line);
                view.setTag(aVar);
                this.eRs.put(String.valueOf(simpleThreadInfo.tid), view);
                addView(view);
            } else {
                View view2 = this.eRs.get(String.valueOf(simpleThreadInfo.tid));
                aVar = (a) view2.getTag();
                view = view2;
            }
            aVar.eRw.setText(simpleThreadInfo.title);
            StringBuilder sb = new StringBuilder();
            if (simpleThreadInfo._abstract != null && simpleThreadInfo._abstract.size() != 0) {
                int size = simpleThreadInfo._abstract.size();
                for (int i = 0; i < size; i++) {
                    if (simpleThreadInfo._abstract.get(i) != null && simpleThreadInfo._abstract.get(i).type.intValue() == 0) {
                        sb.append(simpleThreadInfo._abstract.get(i).text);
                    }
                }
            }
            if (!ao.isEmpty(sb.toString().trim())) {
                aVar.eRx.setText(sb.toString());
                aVar.eRx.setVisibility(0);
            } else {
                aVar.eRx.setVisibility(8);
            }
            aVar.eRy.setText(String.valueOf(simpleThreadInfo.reply_num));
            al.i(aVar.eRv, e.f.live_frs_list_item_bg);
            al.c(aVar.eRw, e.d.cp_cont_b, 1);
            al.c(aVar.eRx, e.d.cp_cont_c, 1);
            al.c(aVar.eRy, e.d.cp_link_tip_c, 1);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) al.getDrawable(e.f.icon_ba_comment);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            aVar.eRy.setCompoundDrawables(bitmapDrawable, null, null, null);
            al.i(aVar.eRz, e.d.cp_bg_line_c);
            if (z) {
                aVar.eRz.setVisibility(0);
            } else {
                aVar.eRz.setVisibility(8);
            }
            final String valueOf = String.valueOf(simpleThreadInfo.tid);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemHotThreadView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    TiebaStatic.eventStat(ItemHotThreadView.this.mContext, "detail_hot_thread", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(ItemHotThreadView.this.mContext).createNormalCfg(valueOf, "", "")));
                }
            });
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        LinearLayout eRv;
        TextView eRw;
        TextView eRx;
        TextView eRy;
        TextView eRz;

        private a() {
        }
    }
}
