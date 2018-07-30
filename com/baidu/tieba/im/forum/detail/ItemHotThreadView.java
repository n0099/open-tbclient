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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.List;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class ItemHotThreadView extends LinearLayout {
    private HashMap<String, View> ers;
    private List<SimpleThreadInfo> ert;
    private Context mContext;

    public ItemHotThreadView(Context context) {
        super(context);
        this.ers = new HashMap<>();
        init(context);
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ers = new HashMap<>();
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.forum_detail_hot_thread, (ViewGroup) this, true);
        setVisibility(8);
    }

    public void setData(List<SimpleThreadInfo> list) {
        this.ert = list;
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
        setData(this.ert);
    }

    private void a(SimpleThreadInfo simpleThreadInfo, boolean z) {
        a aVar;
        View view;
        if (simpleThreadInfo != null) {
            if (!this.ers.containsKey(String.valueOf(simpleThreadInfo.tid))) {
                view = LayoutInflater.from(this.mContext).inflate(d.h.forum_detail_hot_thread_item, (ViewGroup) this, false);
                aVar = new a();
                aVar.erw = (LinearLayout) view.findViewById(d.g.thread_item_ll);
                aVar.erx = (TextView) view.findViewById(d.g.ht_item_title);
                aVar.ery = (TextView) view.findViewById(d.g.ht_item_content);
                aVar.erz = (TextView) view.findViewById(d.g.ht_item_reply);
                aVar.erA = (TextView) view.findViewById(d.g.ht_divider_line);
                view.setTag(aVar);
                this.ers.put(String.valueOf(simpleThreadInfo.tid), view);
                addView(view);
            } else {
                View view2 = this.ers.get(String.valueOf(simpleThreadInfo.tid));
                aVar = (a) view2.getTag();
                view = view2;
            }
            aVar.erx.setText(simpleThreadInfo.title);
            StringBuilder sb = new StringBuilder();
            if (simpleThreadInfo._abstract != null && simpleThreadInfo._abstract.size() != 0) {
                int size = simpleThreadInfo._abstract.size();
                for (int i = 0; i < size; i++) {
                    if (simpleThreadInfo._abstract.get(i) != null && simpleThreadInfo._abstract.get(i).type.intValue() == 0) {
                        sb.append(simpleThreadInfo._abstract.get(i).text);
                    }
                }
            }
            if (!ap.isEmpty(sb.toString().trim())) {
                aVar.ery.setText(sb.toString());
                aVar.ery.setVisibility(0);
            } else {
                aVar.ery.setVisibility(8);
            }
            aVar.erz.setText(String.valueOf(simpleThreadInfo.reply_num));
            am.i(aVar.erw, d.f.live_frs_list_item_bg);
            am.c(aVar.erx, d.C0140d.cp_cont_b, 1);
            am.c(aVar.ery, d.C0140d.cp_cont_c, 1);
            am.c(aVar.erz, d.C0140d.cp_link_tip_c, 1);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) am.getDrawable(d.f.icon_ba_comment);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            aVar.erz.setCompoundDrawables(bitmapDrawable, null, null, null);
            am.i(aVar.erA, d.C0140d.cp_bg_line_c);
            if (z) {
                aVar.erA.setVisibility(0);
            } else {
                aVar.erA.setVisibility(8);
            }
            final String valueOf = String.valueOf(simpleThreadInfo.tid);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemHotThreadView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    TiebaStatic.eventStat(ItemHotThreadView.this.mContext, "detail_hot_thread", "click", 1, new Object[0]);
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
        TextView erA;
        LinearLayout erw;
        TextView erx;
        TextView ery;
        TextView erz;

        private a() {
        }
    }
}
