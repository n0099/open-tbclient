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
    private ViewEventCenter drf;
    private TextView dtQ;
    private ImageView dtR;
    private LinearLayout dtZ;

    public ForumHeaderView(Context context) {
        this(context, null);
    }

    public ForumHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.drf = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(e.h.layout_enterforum_search, this);
        setOrientation(1);
        setDescendantFocusability(262144);
        this.dtZ = (LinearLayout) findViewById(e.g.search_container);
        this.dtZ.setVisibility(0);
        this.dtZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumHeaderView.this.drf != null) {
                    TiebaStatic.log("c10362");
                    ForumHeaderView.this.drf.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
                }
            }
        });
        this.dtQ = (TextView) findViewById(e.g.search_text);
        this.dtR = (ImageView) findViewById(e.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        al.c(this.dtR, e.f.icon_input_search);
        al.h(this.dtQ, e.d.cp_cont_d);
        al.j(this.dtZ, e.d.cp_bg_line_e);
    }

    public void lF(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dtZ.getLayoutParams();
        layoutParams.topMargin = i;
        this.dtZ.setLayoutParams(layoutParams);
    }

    public void setSearchHint(String str) {
        this.dtQ.setText(UtilHelper.getFixedText(str, 20));
    }
}
