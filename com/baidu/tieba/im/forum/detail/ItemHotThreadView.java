package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import java.util.HashMap;
import java.util.List;
import tbclient.SimpleThreadInfo;
/* loaded from: classes.dex */
public class ItemHotThreadView extends LinearLayout {
    private HashMap<String, View> bbe;
    private List<SimpleThreadInfo> bbf;
    private Context mContext;

    public ItemHotThreadView(Context context) {
        super(context);
        this.bbe = new HashMap<>();
        init(context);
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbe = new HashMap<>();
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ei().a(context, com.baidu.tieba.x.forum_detail_hot_thread, this, true);
        setVisibility(8);
    }

    public void setData(List<SimpleThreadInfo> list) {
        int i = 0;
        this.bbf = list;
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
        setData(this.bbf);
    }

    private void b(SimpleThreadInfo simpleThreadInfo) {
        x xVar;
        View view;
        if (simpleThreadInfo != null) {
            if (!this.bbe.containsKey(String.valueOf(simpleThreadInfo.tid))) {
                view = com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.forum_detail_hot_thread_item, this, false);
                xVar = new x(null);
                xVar.bbi = (LinearLayout) view.findViewById(com.baidu.tieba.w.thread_item_ll);
                xVar.bbj = (TextView) view.findViewById(com.baidu.tieba.w.ht_item_title);
                xVar.bbk = (TextView) view.findViewById(com.baidu.tieba.w.ht_item_content);
                xVar.bbl = (TextView) view.findViewById(com.baidu.tieba.w.ht_item_reply);
                xVar.bbm = (TextView) view.findViewById(com.baidu.tieba.w.ht_divider_line);
                view.setTag(xVar);
                this.bbe.put(String.valueOf(simpleThreadInfo.tid), view);
                addView(view);
            } else {
                View view2 = this.bbe.get(String.valueOf(simpleThreadInfo.tid));
                xVar = (x) view2.getTag();
                view = view2;
            }
            xVar.bbj.setText(simpleThreadInfo.title);
            StringBuilder sb = new StringBuilder();
            if (simpleThreadInfo._abstract != null && simpleThreadInfo._abstract.size() != 0) {
                int size = simpleThreadInfo._abstract.size();
                for (int i = 0; i < size; i++) {
                    if (simpleThreadInfo._abstract.get(i) != null && simpleThreadInfo._abstract.get(i).type.intValue() == 0) {
                        sb.append(simpleThreadInfo._abstract.get(i).text);
                    }
                }
            }
            if (!bf.isEmpty(sb.toString().trim())) {
                xVar.bbk.setText(sb.toString());
                xVar.bbk.setVisibility(0);
            } else {
                xVar.bbk.setVisibility(8);
            }
            xVar.bbl.setText(String.valueOf(simpleThreadInfo.reply_num));
            bc.i(xVar.bbi, com.baidu.tieba.v.live_frs_list_item_bg);
            bc.b(xVar.bbj, com.baidu.tieba.t.cp_cont_b, 1);
            bc.b(xVar.bbk, com.baidu.tieba.t.cp_cont_c, 1);
            bc.b(xVar.bbl, com.baidu.tieba.t.cp_link_tip_c, 1);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) bc.getDrawable(com.baidu.tieba.v.icon_ba_comment);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            xVar.bbl.setCompoundDrawables(bitmapDrawable, null, null, null);
            bc.i((View) xVar.bbm, com.baidu.tieba.t.cp_bg_line_c);
            view.setOnClickListener(new w(this, String.valueOf(simpleThreadInfo.tid)));
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().ab(i == 1);
        forumDetailActivity.getLayoutMode().h(this);
        refresh();
    }
}
