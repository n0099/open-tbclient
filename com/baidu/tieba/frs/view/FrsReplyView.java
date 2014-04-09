package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.FrsPostListData;
/* loaded from: classes.dex */
public class FrsReplyView extends LinearLayout {
    private Context a;
    private View b;
    private TextView c;
    private TextView d;
    private FrsPostListData e;

    public FrsReplyView(Context context) {
        this(context, null);
    }

    public FrsReplyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        setOrientation(0);
        this.b = View.inflate(this.a, com.baidu.tieba.a.i.frs_item_reply, this);
        this.d = (TextView) this.b.findViewById(com.baidu.tieba.a.h.frs_item_reply_abstract);
        this.c = (TextView) this.b.findViewById(com.baidu.tieba.a.h.frs_item_reply_author);
        this.c.setOnClickListener(new m(this));
    }

    public void setData(FrsPostListData frsPostListData) {
        if (frsPostListData != null) {
            this.e = frsPostListData;
            this.c.setText(String.valueOf(this.e.getAuthor().getName_show()) + ": ");
            this.d.setText(this.e.getAbstract_text());
        }
    }

    public final void a(int i) {
        if (i == 1) {
            this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.cp_link_tip_c_1));
            this.c.setBackgroundResource(com.baidu.tieba.a.g.frs_item_abstract_more_text_bg_1);
            this.d.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.cp_cont_b_1));
            return;
        }
        this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.cp_link_tip_c));
        this.c.setBackgroundResource(com.baidu.tieba.a.g.frs_item_abstract_more_text_bg);
        this.d.setTextColor(this.a.getResources().getColor(com.baidu.tieba.a.e.cp_cont_b));
    }
}
