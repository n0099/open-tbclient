package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.forumdetail.ForumDetailData;
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

    private void a(Context context) {
        this.a = context;
        this.b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.b.inflate(com.baidu.tieba.a.i.forum_detail_hot_thread, (ViewGroup) this, true);
    }

    public final boolean a(ForumDetailData forumDetailData) {
        ForumDetailData.ThreadInfo[] threadInfoArr;
        l lVar;
        View view;
        this.d = forumDetailData;
        if (forumDetailData == null || forumDetailData.threads.length == 0) {
            return false;
        }
        for (ForumDetailData.ThreadInfo threadInfo : forumDetailData.threads) {
            if (this.c.containsKey(String.valueOf(threadInfo.tId))) {
                View view2 = this.c.get(String.valueOf(threadInfo.tId));
                lVar = (l) view2.getTag();
                view = view2;
            } else {
                view = this.b.inflate(com.baidu.tieba.a.i.forum_detail_hot_thread_item, (ViewGroup) this, false);
                lVar = new l((byte) 0);
                lVar.a = (TextView) view.findViewById(com.baidu.tieba.a.h.ht_item_title);
                lVar.b = (TextView) view.findViewById(com.baidu.tieba.a.h.ht_item_content);
                lVar.c = (TextView) view.findViewById(com.baidu.tieba.a.h.ht_label_pv);
                lVar.d = (TextView) view.findViewById(com.baidu.tieba.a.h.ht_item_pv);
                lVar.e = (TextView) view.findViewById(com.baidu.tieba.a.h.ht_item_reply);
                lVar.f = (TextView) view.findViewById(com.baidu.tieba.a.h.ht_divider_line);
                view.setTag(lVar);
                this.c.put(String.valueOf(threadInfo.tId), view);
                addView(view);
            }
            lVar.a.setText(threadInfo.title);
            StringBuilder sb = new StringBuilder();
            int length = threadInfo.abstracts.length;
            for (int i = 0; i < length; i++) {
                if (threadInfo.abstracts[i].type == 0) {
                    sb.append(threadInfo.abstracts[i].text);
                }
            }
            if (bc.c(sb.toString().trim())) {
                lVar.b.setVisibility(8);
            } else {
                lVar.b.setText(sb.toString());
                lVar.b.setVisibility(0);
            }
            lVar.d.setText(String.valueOf(threadInfo.viewNum));
            lVar.e.setText(String.valueOf(threadInfo.replyNum));
            if (TbadkApplication.j().l() == 1) {
                lVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.forum_detail_htitem_title_color_1));
                lVar.b.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.forum_detail_htitem_txt_color_1));
                lVar.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.forum_detail_ht_lbl_1));
                lVar.d.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.forum_detail_ht_lbl_1));
                lVar.e.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.forum_detail_ht_cmt_1));
                BitmapDrawable bitmapDrawable = (BitmapDrawable) this.a.getResources().getDrawable(com.baidu.tieba.a.g.icon_bestlittle_comment_b_1);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                lVar.e.setCompoundDrawables(bitmapDrawable, null, null, null);
                lVar.f.setBackgroundResource(com.baidu.tieba.a.e.forum_detail_sep_line_1);
            } else {
                lVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.forum_detail_htitem_title_color));
                lVar.b.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.forum_detail_htitem_txt_color));
                lVar.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.forum_detail_ht_lbl));
                lVar.d.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.forum_detail_ht_lbl));
                lVar.e.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.forum_detail_ht_cmt));
                BitmapDrawable bitmapDrawable2 = (BitmapDrawable) this.a.getResources().getDrawable(com.baidu.tieba.a.g.icon_bestlittle_comment_b);
                bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), bitmapDrawable2.getIntrinsicHeight());
                lVar.e.setCompoundDrawables(bitmapDrawable2, null, null, null);
                lVar.f.setBackgroundResource(com.baidu.tieba.a.e.forum_detail_sep_line);
            }
            view.setOnClickListener(new k(this, String.valueOf(threadInfo.id)));
        }
        return true;
    }

    public final void a(com.baidu.tbadk.a aVar, int i) {
        aVar.getLayoutMode().a(i == 1);
        aVar.getLayoutMode().a(this);
        a(this.d);
    }
}
