package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.x;
import java.util.HashMap;
import java.util.List;
import tbclient.SimpleThreadInfo;
/* loaded from: classes.dex */
public class ItemHotThreadView extends LinearLayout {
    private HashMap<String, View> aZH;
    private List<SimpleThreadInfo> aZI;
    private Context mContext;

    public ItemHotThreadView(Context context) {
        super(context);
        this.aZH = new HashMap<>();
        init(context);
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aZH = new HashMap<>();
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ek().a(context, x.forum_detail_hot_thread, this, true);
        setVisibility(8);
    }

    public void setData(List<SimpleThreadInfo> list) {
        int i = 0;
        this.aZI = list;
        if (list != null && list.size() != 0) {
            setVisibility(0);
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    b(list.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void refresh() {
        setData(this.aZI);
    }

    private void b(SimpleThreadInfo simpleThreadInfo) {
        v vVar;
        View view;
        if (simpleThreadInfo != null) {
            if (!this.aZH.containsKey(String.valueOf(simpleThreadInfo.tid))) {
                view = com.baidu.adp.lib.g.b.ek().a(this.mContext, x.forum_detail_hot_thread_item, this, false);
                vVar = new v(null);
                vVar.aZL = (LinearLayout) view.findViewById(com.baidu.tieba.w.thread_item_ll);
                vVar.aZM = (TextView) view.findViewById(com.baidu.tieba.w.ht_item_title);
                vVar.aZN = (TextView) view.findViewById(com.baidu.tieba.w.ht_item_content);
                vVar.aZO = (TextView) view.findViewById(com.baidu.tieba.w.ht_item_reply);
                vVar.aZP = (TextView) view.findViewById(com.baidu.tieba.w.ht_divider_line);
                view.setTag(vVar);
                this.aZH.put(String.valueOf(simpleThreadInfo.tid), view);
                addView(view);
            } else {
                View view2 = this.aZH.get(String.valueOf(simpleThreadInfo.tid));
                vVar = (v) view2.getTag();
                view = view2;
            }
            vVar.aZM.setText(simpleThreadInfo.title);
            StringBuilder sb = new StringBuilder();
            if (simpleThreadInfo._abstract != null && simpleThreadInfo._abstract.size() != 0) {
                int size = simpleThreadInfo._abstract.size();
                for (int i = 0; i < size; i++) {
                    if (simpleThreadInfo._abstract.get(i) != null && simpleThreadInfo._abstract.get(i).type.intValue() == 0) {
                        sb.append(simpleThreadInfo._abstract.get(i).text);
                    }
                }
            }
            if (!ba.isEmpty(sb.toString().trim())) {
                vVar.aZN.setText(sb.toString());
                vVar.aZN.setVisibility(0);
            } else {
                vVar.aZN.setVisibility(8);
            }
            vVar.aZO.setText(String.valueOf(simpleThreadInfo.reply_num));
            ax.i(vVar.aZL, com.baidu.tieba.v.live_frs_list_item_bg);
            ax.b(vVar.aZM, com.baidu.tieba.t.cp_cont_b, 1);
            ax.b(vVar.aZN, com.baidu.tieba.t.cp_cont_c, 1);
            ax.b(vVar.aZO, com.baidu.tieba.t.cp_link_tip_c, 1);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) ax.getDrawable(com.baidu.tieba.v.icon_ba_comment);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            vVar.aZO.setCompoundDrawables(bitmapDrawable, null, null, null);
            ax.i((View) vVar.aZP, com.baidu.tieba.t.cp_bg_line_c);
            view.setOnClickListener(new u(this, String.valueOf(simpleThreadInfo.tid)));
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().ab(i == 1);
        forumDetailActivity.getLayoutMode().h(this);
        refresh();
    }
}
