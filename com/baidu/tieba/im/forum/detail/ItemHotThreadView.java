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
    private HashMap<String, View> bdf;
    private List<SimpleThreadInfo> bdg;
    private Context mContext;

    public ItemHotThreadView(Context context) {
        super(context);
        this.bdf = new HashMap<>();
        init(context);
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdf = new HashMap<>();
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.hH().a(context, com.baidu.tieba.w.forum_detail_hot_thread, this, true);
        setVisibility(8);
    }

    public void setData(List<SimpleThreadInfo> list) {
        this.bdg = list;
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
        setData(this.bdg);
    }

    private void a(SimpleThreadInfo simpleThreadInfo, boolean z) {
        x xVar;
        View view;
        if (simpleThreadInfo != null) {
            if (!this.bdf.containsKey(String.valueOf(simpleThreadInfo.tid))) {
                view = com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.forum_detail_hot_thread_item, this, false);
                xVar = new x(null);
                xVar.bdj = (LinearLayout) view.findViewById(com.baidu.tieba.v.thread_item_ll);
                xVar.bdk = (TextView) view.findViewById(com.baidu.tieba.v.ht_item_title);
                xVar.bdl = (TextView) view.findViewById(com.baidu.tieba.v.ht_item_content);
                xVar.bdm = (TextView) view.findViewById(com.baidu.tieba.v.ht_item_reply);
                xVar.bdn = (TextView) view.findViewById(com.baidu.tieba.v.ht_divider_line);
                view.setTag(xVar);
                this.bdf.put(String.valueOf(simpleThreadInfo.tid), view);
                addView(view);
            } else {
                View view2 = this.bdf.get(String.valueOf(simpleThreadInfo.tid));
                xVar = (x) view2.getTag();
                view = view2;
            }
            xVar.bdk.setText(simpleThreadInfo.title);
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
                xVar.bdl.setText(sb.toString());
                xVar.bdl.setVisibility(0);
            } else {
                xVar.bdl.setVisibility(8);
            }
            xVar.bdm.setText(String.valueOf(simpleThreadInfo.reply_num));
            ba.i(xVar.bdj, com.baidu.tieba.u.live_frs_list_item_bg);
            ba.b(xVar.bdk, com.baidu.tieba.s.cp_cont_b, 1);
            ba.b(xVar.bdl, com.baidu.tieba.s.cp_cont_c, 1);
            ba.b(xVar.bdm, com.baidu.tieba.s.cp_link_tip_c, 1);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) ba.getDrawable(com.baidu.tieba.u.icon_ba_comment);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            xVar.bdm.setCompoundDrawables(bitmapDrawable, null, null, null);
            ba.i((View) xVar.bdn, com.baidu.tieba.s.cp_bg_line_c);
            if (z) {
                xVar.bdn.setVisibility(0);
            } else {
                xVar.bdn.setVisibility(8);
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
