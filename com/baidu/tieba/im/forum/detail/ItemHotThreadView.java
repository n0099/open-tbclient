package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import java.util.HashMap;
import java.util.List;
import tbclient.SimpleThreadInfo;
/* loaded from: classes.dex */
public class ItemHotThreadView extends LinearLayout {
    private HashMap<String, View> bdv;
    private List<SimpleThreadInfo> bdw;
    private Context mContext;

    public ItemHotThreadView(Context context) {
        super(context);
        this.bdv = new HashMap<>();
        init(context);
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdv = new HashMap<>();
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.hH().a(context, com.baidu.tieba.w.forum_detail_hot_thread, this, true);
        setVisibility(8);
    }

    public void setData(List<SimpleThreadInfo> list) {
        this.bdw = list;
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
        setData(this.bdw);
    }

    private void a(SimpleThreadInfo simpleThreadInfo, boolean z) {
        x xVar;
        View view;
        if (simpleThreadInfo != null) {
            if (!this.bdv.containsKey(String.valueOf(simpleThreadInfo.tid))) {
                view = com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.forum_detail_hot_thread_item, this, false);
                xVar = new x(null);
                xVar.bdz = (LinearLayout) view.findViewById(com.baidu.tieba.v.thread_item_ll);
                xVar.bdA = (TextView) view.findViewById(com.baidu.tieba.v.ht_item_title);
                xVar.bdB = (TextView) view.findViewById(com.baidu.tieba.v.ht_item_content);
                xVar.bdC = (TextView) view.findViewById(com.baidu.tieba.v.ht_item_reply);
                xVar.bdD = (TextView) view.findViewById(com.baidu.tieba.v.ht_divider_line);
                view.setTag(xVar);
                this.bdv.put(String.valueOf(simpleThreadInfo.tid), view);
                addView(view);
            } else {
                View view2 = this.bdv.get(String.valueOf(simpleThreadInfo.tid));
                xVar = (x) view2.getTag();
                view = view2;
            }
            xVar.bdA.setText(simpleThreadInfo.title);
            StringBuilder sb = new StringBuilder();
            if (simpleThreadInfo._abstract != null && simpleThreadInfo._abstract.size() != 0) {
                int size = simpleThreadInfo._abstract.size();
                for (int i = 0; i < size; i++) {
                    if (simpleThreadInfo._abstract.get(i) != null && simpleThreadInfo._abstract.get(i).type.intValue() == 0) {
                        sb.append(simpleThreadInfo._abstract.get(i).text);
                    }
                }
            }
            if (!bd.isEmpty(sb.toString().trim())) {
                xVar.bdB.setText(sb.toString());
                xVar.bdB.setVisibility(0);
            } else {
                xVar.bdB.setVisibility(8);
            }
            xVar.bdC.setText(String.valueOf(simpleThreadInfo.reply_num));
            ba.i(xVar.bdz, com.baidu.tieba.u.live_frs_list_item_bg);
            ba.b(xVar.bdA, com.baidu.tieba.s.cp_cont_b, 1);
            ba.b(xVar.bdB, com.baidu.tieba.s.cp_cont_c, 1);
            ba.b(xVar.bdC, com.baidu.tieba.s.cp_link_tip_c, 1);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) ba.getDrawable(com.baidu.tieba.u.icon_ba_comment);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            xVar.bdC.setCompoundDrawables(bitmapDrawable, null, null, null);
            ba.i((View) xVar.bdD, com.baidu.tieba.s.cp_bg_line_c);
            if (z) {
                xVar.bdD.setVisibility(0);
            } else {
                xVar.bdD.setVisibility(8);
            }
            view.setOnClickListener(new w(this, String.valueOf(simpleThreadInfo.tid)));
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().X(i == 1);
        forumDetailActivity.getLayoutMode().h(this);
        refresh();
    }
}
