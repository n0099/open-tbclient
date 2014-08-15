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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.forumdetail.ForumDetailData;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
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
        this.b.inflate(v.forum_detail_hot_thread, (ViewGroup) this, true);
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
        k kVar;
        View view;
        if (!this.c.containsKey(String.valueOf(threadInfo.tId))) {
            view = this.b.inflate(v.forum_detail_hot_thread_item, (ViewGroup) this, false);
            kVar = new k(null);
            kVar.a = (TextView) view.findViewById(u.ht_item_title);
            kVar.b = (TextView) view.findViewById(u.ht_item_content);
            kVar.c = (TextView) view.findViewById(u.ht_label_pv);
            kVar.d = (TextView) view.findViewById(u.ht_item_pv);
            kVar.e = (TextView) view.findViewById(u.ht_item_reply);
            kVar.f = (TextView) view.findViewById(u.ht_divider_line);
            view.setTag(kVar);
            this.c.put(String.valueOf(threadInfo.tId), view);
            addView(view);
        } else {
            View view2 = this.c.get(String.valueOf(threadInfo.tId));
            kVar = (k) view2.getTag();
            view = view2;
        }
        kVar.a.setText(threadInfo.title);
        StringBuilder sb = new StringBuilder();
        int length = threadInfo.abstracts.length;
        for (int i = 0; i < length; i++) {
            if (threadInfo.abstracts[i].type == 0) {
                sb.append(threadInfo.abstracts[i].text);
            }
        }
        if (!ba.c(sb.toString().trim())) {
            kVar.b.setText(sb.toString());
            kVar.b.setVisibility(0);
        } else {
            kVar.b.setVisibility(8);
        }
        kVar.d.setText(String.valueOf(threadInfo.viewNum));
        kVar.e.setText(String.valueOf(threadInfo.replyNum));
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            kVar.a.setTextColor(this.a.getResources().getColor(r.forum_detail_htitem_title_color_1));
            kVar.b.setTextColor(this.a.getResources().getColor(r.forum_detail_htitem_txt_color_1));
            kVar.c.setTextColor(this.a.getResources().getColor(r.forum_detail_ht_lbl_1));
            kVar.d.setTextColor(this.a.getResources().getColor(r.forum_detail_ht_lbl_1));
            kVar.e.setTextColor(this.a.getResources().getColor(r.forum_detail_ht_cmt_1));
            BitmapDrawable bitmapDrawable = (BitmapDrawable) this.a.getResources().getDrawable(t.icon_bestlittle_comment_b_1);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            kVar.e.setCompoundDrawables(bitmapDrawable, null, null, null);
            kVar.f.setBackgroundResource(r.forum_detail_sep_line_1);
        } else {
            kVar.a.setTextColor(this.a.getResources().getColor(r.forum_detail_htitem_title_color));
            kVar.b.setTextColor(this.a.getResources().getColor(r.forum_detail_htitem_txt_color));
            kVar.c.setTextColor(this.a.getResources().getColor(r.forum_detail_ht_lbl));
            kVar.d.setTextColor(this.a.getResources().getColor(r.forum_detail_ht_lbl));
            kVar.e.setTextColor(this.a.getResources().getColor(r.forum_detail_ht_cmt));
            BitmapDrawable bitmapDrawable2 = (BitmapDrawable) this.a.getResources().getDrawable(t.icon_bestlittle_comment_b);
            bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), bitmapDrawable2.getIntrinsicHeight());
            kVar.e.setCompoundDrawables(bitmapDrawable2, null, null, null);
            kVar.f.setBackgroundResource(r.forum_detail_sep_line);
        }
        view.setOnClickListener(new j(this, String.valueOf(threadInfo.id)));
    }

    public void a(BaseActivity baseActivity, int i) {
        baseActivity.getLayoutMode().a(i == 1);
        baseActivity.getLayoutMode().a((View) this);
        a();
    }
}
