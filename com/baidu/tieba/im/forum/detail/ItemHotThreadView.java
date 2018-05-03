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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.List;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class ItemHotThreadView extends LinearLayout {
    private HashMap<String, View> dXl;
    private List<SimpleThreadInfo> dXm;
    private Context mContext;

    public ItemHotThreadView(Context context) {
        super(context);
        this.dXl = new HashMap<>();
        init(context);
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dXl = new HashMap<>();
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.i.forum_detail_hot_thread, (ViewGroup) this, true);
        setVisibility(8);
    }

    public void setData(List<SimpleThreadInfo> list) {
        this.dXm = list;
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
        setData(this.dXm);
    }

    private void a(SimpleThreadInfo simpleThreadInfo, boolean z) {
        a aVar;
        View view2;
        if (simpleThreadInfo != null) {
            if (!this.dXl.containsKey(String.valueOf(simpleThreadInfo.tid))) {
                view2 = LayoutInflater.from(this.mContext).inflate(d.i.forum_detail_hot_thread_item, (ViewGroup) this, false);
                aVar = new a();
                aVar.dXp = (LinearLayout) view2.findViewById(d.g.thread_item_ll);
                aVar.dXq = (TextView) view2.findViewById(d.g.ht_item_title);
                aVar.dXr = (TextView) view2.findViewById(d.g.ht_item_content);
                aVar.dXs = (TextView) view2.findViewById(d.g.ht_item_reply);
                aVar.dXt = (TextView) view2.findViewById(d.g.ht_divider_line);
                view2.setTag(aVar);
                this.dXl.put(String.valueOf(simpleThreadInfo.tid), view2);
                addView(view2);
            } else {
                View view3 = this.dXl.get(String.valueOf(simpleThreadInfo.tid));
                aVar = (a) view3.getTag();
                view2 = view3;
            }
            aVar.dXq.setText(simpleThreadInfo.title);
            StringBuilder sb = new StringBuilder();
            if (simpleThreadInfo._abstract != null && simpleThreadInfo._abstract.size() != 0) {
                int size = simpleThreadInfo._abstract.size();
                for (int i = 0; i < size; i++) {
                    if (simpleThreadInfo._abstract.get(i) != null && simpleThreadInfo._abstract.get(i).type.intValue() == 0) {
                        sb.append(simpleThreadInfo._abstract.get(i).text);
                    }
                }
            }
            if (!an.isEmpty(sb.toString().trim())) {
                aVar.dXr.setText(sb.toString());
                aVar.dXr.setVisibility(0);
            } else {
                aVar.dXr.setVisibility(8);
            }
            aVar.dXs.setText(String.valueOf(simpleThreadInfo.reply_num));
            ak.i(aVar.dXp, d.f.live_frs_list_item_bg);
            ak.c(aVar.dXq, d.C0126d.cp_cont_b, 1);
            ak.c(aVar.dXr, d.C0126d.cp_cont_c, 1);
            ak.c(aVar.dXs, d.C0126d.cp_link_tip_c, 1);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) ak.getDrawable(d.f.icon_ba_comment);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            aVar.dXs.setCompoundDrawables(bitmapDrawable, null, null, null);
            ak.i(aVar.dXt, d.C0126d.cp_bg_line_c);
            if (z) {
                aVar.dXt.setVisibility(0);
            } else {
                aVar.dXt.setVisibility(8);
            }
            final String valueOf = String.valueOf(simpleThreadInfo.tid);
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemHotThreadView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view4) {
                    TiebaStatic.eventStat(ItemHotThreadView.this.mContext, "detail_hot_thread", "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(ItemHotThreadView.this.mContext).createNormalCfg(valueOf, "", "")));
                }
            });
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().u(this);
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        LinearLayout dXp;
        TextView dXq;
        TextView dXr;
        TextView dXs;
        TextView dXt;

        private a() {
        }
    }
}
