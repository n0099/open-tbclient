package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.forumdetail.ForumDetailData;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ItemHotThreadView extends LinearLayout {
    private Context a;
    private LayoutInflater b;
    private HashMap<String, View> c;
    private ForumDetailData d;

    public ItemHotThreadView(Context context) {
        super(context);
        this.c = new HashMap<>();
        a(context);
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new HashMap<>();
        a(context);
    }

    public void a(Context context) {
        this.a = context;
        this.b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.b.inflate(w.forum_detail_hot_thread, (ViewGroup) this, true);
    }

    public boolean a(ForumDetailData forumDetailData) {
        this.d = forumDetailData;
        if (forumDetailData == null || forumDetailData.threads.length == 0) {
            return false;
        }
        for (ForumDetailData.ThreadInfo threadInfo : forumDetailData.threads) {
            a(threadInfo);
        }
        return true;
    }

    private void a() {
        a(this.d);
    }

    private void a(ForumDetailData.ThreadInfo threadInfo) {
        l lVar;
        View view;
        if (!this.c.containsKey(String.valueOf(threadInfo.tId))) {
            view = this.b.inflate(w.forum_detail_hot_thread_item, (ViewGroup) this, false);
            lVar = new l(null);
            lVar.a = (TextView) view.findViewById(v.ht_item_title);
            lVar.b = (TextView) view.findViewById(v.ht_item_content);
            lVar.c = (TextView) view.findViewById(v.ht_label_pv);
            lVar.d = (TextView) view.findViewById(v.ht_item_pv);
            lVar.e = (TextView) view.findViewById(v.ht_item_reply);
            lVar.f = (TextView) view.findViewById(v.ht_divider_line);
            view.setTag(lVar);
            this.c.put(String.valueOf(threadInfo.tId), view);
            addView(view);
        } else {
            View view2 = this.c.get(String.valueOf(threadInfo.tId));
            lVar = (l) view2.getTag();
            view = view2;
        }
        lVar.a.setText(threadInfo.title);
        StringBuilder sb = new StringBuilder();
        int length = threadInfo.abstracts.length;
        for (int i = 0; i < length; i++) {
            if (threadInfo.abstracts[i].type == 0) {
                sb.append(threadInfo.abstracts[i].text);
            }
        }
        if (!be.c(sb.toString().trim())) {
            lVar.b.setText(sb.toString());
            lVar.b.setVisibility(0);
        } else {
            lVar.b.setVisibility(8);
        }
        lVar.d.setText(String.valueOf(threadInfo.viewNum));
        lVar.e.setText(String.valueOf(threadInfo.replyNum));
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            lVar.a.setTextColor(this.a.getResources().getColor(s.forum_detail_htitem_title_color_1));
            lVar.b.setTextColor(this.a.getResources().getColor(s.forum_detail_htitem_txt_color_1));
            lVar.c.setTextColor(this.a.getResources().getColor(s.forum_detail_ht_lbl_1));
            lVar.d.setTextColor(this.a.getResources().getColor(s.forum_detail_ht_lbl_1));
            lVar.e.setTextColor(this.a.getResources().getColor(s.forum_detail_ht_cmt_1));
            BitmapDrawable bitmapDrawable = (BitmapDrawable) this.a.getResources().getDrawable(u.icon_bestlittle_comment_b_1);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            lVar.e.setCompoundDrawables(bitmapDrawable, null, null, null);
            lVar.f.setBackgroundResource(s.forum_detail_sep_line_1);
        } else {
            lVar.a.setTextColor(this.a.getResources().getColor(s.forum_detail_htitem_title_color));
            lVar.b.setTextColor(this.a.getResources().getColor(s.forum_detail_htitem_txt_color));
            lVar.c.setTextColor(this.a.getResources().getColor(s.forum_detail_ht_lbl));
            lVar.d.setTextColor(this.a.getResources().getColor(s.forum_detail_ht_lbl));
            lVar.e.setTextColor(this.a.getResources().getColor(s.forum_detail_ht_cmt));
            BitmapDrawable bitmapDrawable2 = (BitmapDrawable) this.a.getResources().getDrawable(u.icon_bestlittle_comment_b);
            bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), bitmapDrawable2.getIntrinsicHeight());
            lVar.e.setCompoundDrawables(bitmapDrawable2, null, null, null);
            lVar.f.setBackgroundResource(s.forum_detail_sep_line);
        }
        view.setOnClickListener(new k(this, String.valueOf(threadInfo.id)));
    }

    public void a(BaseActivity baseActivity, int i) {
        baseActivity.getLayoutMode().a(i == 1);
        baseActivity.getLayoutMode().a((View) this);
        a();
    }
}
