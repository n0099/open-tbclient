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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ForumHeaderView extends LinearLayout {
    private ViewEventCenter cGO;
    private TextView cJG;
    private ImageView cJH;
    private LinearLayout cJP;

    public ForumHeaderView(Context context) {
        this(context, null);
    }

    public ForumHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cGO = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(d.i.layout_enterforum_search, this);
        setOrientation(1);
        setDescendantFocusability(262144);
        this.cJP = (LinearLayout) findViewById(d.g.search_container);
        this.cJP.setVisibility(0);
        this.cJP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ForumHeaderView.this.cGO != null) {
                    TiebaStatic.log("c10362");
                    ForumHeaderView.this.cGO.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
                }
            }
        });
        this.cJG = (TextView) findViewById(d.g.search_text);
        this.cJH = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        ak.c(this.cJH, d.f.icon_input_search);
        ak.h(this.cJG, d.C0126d.cp_cont_d);
        ak.j(this.cJP, d.C0126d.cp_bg_line_e);
    }

    public void jB(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cJP.getLayoutParams();
        layoutParams.topMargin = i;
        this.cJP.setLayoutParams(layoutParams);
    }

    public void setSearchHint(String str) {
        this.cJG.setText(UtilHelper.getFixedText(str, 20));
    }
}
