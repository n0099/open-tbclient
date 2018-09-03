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
import com.baidu.tieba.f;
import java.util.HashMap;
import java.util.List;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class ItemHotThreadView extends LinearLayout {
    private HashMap<String, View> ern;
    private List<SimpleThreadInfo> ero;
    private Context mContext;

    public ItemHotThreadView(Context context) {
        super(context);
        this.ern = new HashMap<>();
        init(context);
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ern = new HashMap<>();
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(f.h.forum_detail_hot_thread, (ViewGroup) this, true);
        setVisibility(8);
    }

    public void setData(List<SimpleThreadInfo> list) {
        this.ero = list;
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
        setData(this.ero);
    }

    private void a(SimpleThreadInfo simpleThreadInfo, boolean z) {
        a aVar;
        View view;
        if (simpleThreadInfo != null) {
            if (!this.ern.containsKey(String.valueOf(simpleThreadInfo.tid))) {
                view = LayoutInflater.from(this.mContext).inflate(f.h.forum_detail_hot_thread_item, (ViewGroup) this, false);
                aVar = new a();
                aVar.ers = (LinearLayout) view.findViewById(f.g.thread_item_ll);
                aVar.ert = (TextView) view.findViewById(f.g.ht_item_title);
                aVar.eru = (TextView) view.findViewById(f.g.ht_item_content);
                aVar.erv = (TextView) view.findViewById(f.g.ht_item_reply);
                aVar.erw = (TextView) view.findViewById(f.g.ht_divider_line);
                view.setTag(aVar);
                this.ern.put(String.valueOf(simpleThreadInfo.tid), view);
                addView(view);
            } else {
                View view2 = this.ern.get(String.valueOf(simpleThreadInfo.tid));
                aVar = (a) view2.getTag();
                view = view2;
            }
            aVar.ert.setText(simpleThreadInfo.title);
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
                aVar.eru.setText(sb.toString());
                aVar.eru.setVisibility(0);
            } else {
                aVar.eru.setVisibility(8);
            }
            aVar.erv.setText(String.valueOf(simpleThreadInfo.reply_num));
            am.i(aVar.ers, f.C0146f.live_frs_list_item_bg);
            am.c(aVar.ert, f.d.cp_cont_b, 1);
            am.c(aVar.eru, f.d.cp_cont_c, 1);
            am.c(aVar.erv, f.d.cp_link_tip_c, 1);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) am.getDrawable(f.C0146f.icon_ba_comment);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            aVar.erv.setCompoundDrawables(bitmapDrawable, null, null, null);
            am.i(aVar.erw, f.d.cp_bg_line_c);
            if (z) {
                aVar.erw.setVisibility(0);
            } else {
                aVar.erw.setVisibility(8);
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
        LinearLayout ers;
        TextView ert;
        TextView eru;
        TextView erv;
        TextView erw;

        private a() {
        }
    }
}
