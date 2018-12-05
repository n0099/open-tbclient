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
    private HashMap<String, View> eOB;
    private List<SimpleThreadInfo> eOC;
    private Context mContext;

    public ItemHotThreadView(Context context) {
        super(context);
        this.eOB = new HashMap<>();
        init(context);
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eOB = new HashMap<>();
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.forum_detail_hot_thread, (ViewGroup) this, true);
        setVisibility(8);
    }

    public void setData(List<SimpleThreadInfo> list) {
        this.eOC = list;
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
        setData(this.eOC);
    }

    private void a(SimpleThreadInfo simpleThreadInfo, boolean z) {
        a aVar;
        View view;
        if (simpleThreadInfo != null) {
            if (!this.eOB.containsKey(String.valueOf(simpleThreadInfo.tid))) {
                view = LayoutInflater.from(this.mContext).inflate(e.h.forum_detail_hot_thread_item, (ViewGroup) this, false);
                aVar = new a();
                aVar.eOE = (LinearLayout) view.findViewById(e.g.thread_item_ll);
                aVar.eOF = (TextView) view.findViewById(e.g.ht_item_title);
                aVar.eOG = (TextView) view.findViewById(e.g.ht_item_content);
                aVar.eOH = (TextView) view.findViewById(e.g.ht_item_reply);
                aVar.eOI = (TextView) view.findViewById(e.g.ht_divider_line);
                view.setTag(aVar);
                this.eOB.put(String.valueOf(simpleThreadInfo.tid), view);
                addView(view);
            } else {
                View view2 = this.eOB.get(String.valueOf(simpleThreadInfo.tid));
                aVar = (a) view2.getTag();
                view = view2;
            }
            aVar.eOF.setText(simpleThreadInfo.title);
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
                aVar.eOG.setText(sb.toString());
                aVar.eOG.setVisibility(0);
            } else {
                aVar.eOG.setVisibility(8);
            }
            aVar.eOH.setText(String.valueOf(simpleThreadInfo.reply_num));
            al.i(aVar.eOE, e.f.live_frs_list_item_bg);
            al.c(aVar.eOF, e.d.cp_cont_b, 1);
            al.c(aVar.eOG, e.d.cp_cont_c, 1);
            al.c(aVar.eOH, e.d.cp_link_tip_c, 1);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) al.getDrawable(e.f.icon_ba_comment);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            aVar.eOH.setCompoundDrawables(bitmapDrawable, null, null, null);
            al.i(aVar.eOI, e.d.cp_bg_line_c);
            if (z) {
                aVar.eOI.setVisibility(0);
            } else {
                aVar.eOI.setVisibility(8);
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
        LinearLayout eOE;
        TextView eOF;
        TextView eOG;
        TextView eOH;
        TextView eOI;

        private a() {
        }
    }
}
