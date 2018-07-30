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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ForumHeaderView extends LinearLayout {
    private ViewEventCenter cRI;
    private TextView cUI;
    private ImageView cUJ;
    private LinearLayout cUS;

    public ForumHeaderView(Context context) {
        this(context, null);
    }

    public ForumHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cRI = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(d.h.layout_enterforum_search, this);
        setOrientation(1);
        setDescendantFocusability(262144);
        this.cUS = (LinearLayout) findViewById(d.g.search_container);
        this.cUS.setVisibility(0);
        this.cUS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumHeaderView.this.cRI != null) {
                    TiebaStatic.log("c10362");
                    ForumHeaderView.this.cRI.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
                }
            }
        });
        this.cUI = (TextView) findViewById(d.g.search_text);
        this.cUJ = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        am.c(this.cUJ, d.f.icon_input_search);
        am.h(this.cUI, d.C0140d.cp_cont_d);
        am.j(this.cUS, d.C0140d.cp_bg_line_e);
    }

    public void jN(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cUS.getLayoutParams();
        layoutParams.topMargin = i;
        this.cUS.setLayoutParams(layoutParams);
    }

    public void setSearchHint(String str) {
        this.cUI.setText(UtilHelper.getFixedText(str, 20));
    }
}
