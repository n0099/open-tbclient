package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.forumdetail.ForumDetailData;
import com.baidu.tieba.util.bb;
import com.slidingmenu.lib.R;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ItemHotThreadView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f1323a;
    private TextView b;
    private LayoutInflater c;
    private HashMap<String, View> d;
    private ForumDetailData e;

    public ItemHotThreadView(Context context) {
        super(context);
        this.d = new HashMap<>();
        a(context);
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new HashMap<>();
        a(context);
    }

    public void a(Context context) {
        this.f1323a = context;
        this.c = (LayoutInflater) context.getSystemService("layout_inflater");
        this.c.inflate(R.layout.forum_detail_hot_thread, (ViewGroup) this, true);
        this.b = (TextView) findViewById(R.id.ht_title);
    }

    public boolean a(ForumDetailData forumDetailData) {
        this.e = forumDetailData;
        if (forumDetailData == null || forumDetailData.threads.length == 0) {
            return false;
        }
        for (ForumDetailData.ThreadInfo threadInfo : forumDetailData.threads) {
            a(threadInfo);
        }
        return true;
    }

    private void a() {
        a(this.e);
    }

    private void a(ForumDetailData.ThreadInfo threadInfo) {
        l lVar;
        View view;
        if (!this.d.containsKey(String.valueOf(threadInfo.tId))) {
            view = this.c.inflate(R.layout.forum_detail_hot_thread_item, (ViewGroup) this, false);
            lVar = new l(null);
            lVar.f1335a = (TextView) view.findViewById(R.id.ht_item_title);
            lVar.b = (TextView) view.findViewById(R.id.ht_item_content);
            lVar.c = (TextView) view.findViewById(R.id.ht_label_pv);
            lVar.d = (TextView) view.findViewById(R.id.ht_item_pv);
            lVar.e = (TextView) view.findViewById(R.id.ht_item_reply);
            lVar.f = (TextView) view.findViewById(R.id.ht_divider_line);
            view.setTag(lVar);
            this.d.put(String.valueOf(threadInfo.tId), view);
            addView(view);
        } else {
            View view2 = this.d.get(String.valueOf(threadInfo.tId));
            lVar = (l) view2.getTag();
            view = view2;
        }
        lVar.f1335a.setText(threadInfo.title);
        StringBuilder sb = new StringBuilder();
        int length = threadInfo.abstracts.length;
        for (int i = 0; i < length; i++) {
            if (threadInfo.abstracts[i].type == 0) {
                sb.append(threadInfo.abstracts[i].text);
            }
        }
        if (!bb.c(sb.toString().trim())) {
            lVar.b.setText(sb.toString());
            lVar.b.setVisibility(0);
        } else {
            lVar.b.setVisibility(8);
        }
        lVar.d.setText(String.valueOf(threadInfo.viewNum));
        lVar.e.setText(String.valueOf(threadInfo.replyNum));
        if (TiebaApplication.h().an() == 1) {
            lVar.f1335a.setTextColor(this.f1323a.getResources().getColor(R.color.forum_detail_htitem_title_color_1));
            lVar.b.setTextColor(this.f1323a.getResources().getColor(R.color.forum_detail_htitem_txt_color_1));
            lVar.c.setTextColor(this.f1323a.getResources().getColor(R.color.forum_detail_ht_lbl_1));
            lVar.d.setTextColor(this.f1323a.getResources().getColor(R.color.forum_detail_ht_lbl_1));
            lVar.e.setTextColor(this.f1323a.getResources().getColor(R.color.forum_detail_ht_cmt_1));
            BitmapDrawable bitmapDrawable = (BitmapDrawable) this.f1323a.getResources().getDrawable(R.drawable.icon_bestlittle_comment_b_1);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            lVar.e.setCompoundDrawables(bitmapDrawable, null, null, null);
            lVar.f.setBackgroundResource(R.color.forum_detail_sep_line_1);
        } else {
            lVar.f1335a.setTextColor(this.f1323a.getResources().getColor(R.color.forum_detail_htitem_title_color));
            lVar.b.setTextColor(this.f1323a.getResources().getColor(R.color.forum_detail_htitem_txt_color));
            lVar.c.setTextColor(this.f1323a.getResources().getColor(R.color.forum_detail_ht_lbl));
            lVar.d.setTextColor(this.f1323a.getResources().getColor(R.color.forum_detail_ht_lbl));
            lVar.e.setTextColor(this.f1323a.getResources().getColor(R.color.forum_detail_ht_cmt));
            BitmapDrawable bitmapDrawable2 = (BitmapDrawable) this.f1323a.getResources().getDrawable(R.drawable.icon_bestlittle_comment_b);
            bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), bitmapDrawable2.getIntrinsicHeight());
            lVar.e.setCompoundDrawables(bitmapDrawable2, null, null, null);
            lVar.f.setBackgroundResource(R.color.forum_detail_sep_line);
        }
        view.setOnClickListener(new k(this, String.valueOf(threadInfo.id)));
    }

    public void a(com.baidu.tieba.j jVar, int i) {
        jVar.getLayoutMode().a(i == 1);
        jVar.getLayoutMode().a(this);
        a();
    }
}
