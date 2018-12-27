package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class ForumHeaderView extends LinearLayout {
    private ViewEventCenter dqs;
    private TextView dtg;
    private ImageView dth;
    private LinearLayout dtp;

    public ForumHeaderView(Context context) {
        this(context, null);
    }

    public ForumHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.dqs = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(e.h.layout_enterforum_search, this);
        setOrientation(1);
        setDescendantFocusability(262144);
        this.dtp = (LinearLayout) findViewById(e.g.search_container);
        this.dtp.setVisibility(0);
        this.dtp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumHeaderView.this.dqs != null) {
                    TiebaStatic.log("c10362");
                    ForumHeaderView.this.dqs.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
                }
            }
        });
        this.dtg = (TextView) findViewById(e.g.search_text);
        this.dth = (ImageView) findViewById(e.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        al.c(this.dth, e.f.icon_input_search);
        al.h(this.dtg, e.d.cp_cont_d);
        al.j(this.dtp, e.d.cp_bg_line_e);
    }

    public void lE(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dtp.getLayoutParams();
        layoutParams.topMargin = i;
        this.dtp.setLayoutParams(layoutParams);
    }

    public void setSearchHint(String str) {
        this.dtg.setText(UtilHelper.getFixedText(str, 20));
    }
}
