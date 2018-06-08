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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ForumHeaderView extends LinearLayout {
    private ViewEventCenter cRe;
    private TextView cTV;
    private ImageView cTW;
    private LinearLayout cUe;

    public ForumHeaderView(Context context) {
        this(context, null);
    }

    public ForumHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cRe = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(d.i.layout_enterforum_search, this);
        setOrientation(1);
        setDescendantFocusability(262144);
        this.cUe = (LinearLayout) findViewById(d.g.search_container);
        this.cUe.setVisibility(0);
        this.cUe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumHeaderView.this.cRe != null) {
                    TiebaStatic.log("c10362");
                    ForumHeaderView.this.cRe.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
                }
            }
        });
        this.cTV = (TextView) findViewById(d.g.search_text);
        this.cTW = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        al.c(this.cTW, d.f.icon_input_search);
        al.h(this.cTV, d.C0141d.cp_cont_d);
        al.j(this.cUe, d.C0141d.cp_bg_line_e);
    }

    public void jD(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cUe.getLayoutParams();
        layoutParams.topMargin = i;
        this.cUe.setLayoutParams(layoutParams);
    }

    public void setSearchHint(String str) {
        this.cTV.setText(UtilHelper.getFixedText(str, 20));
    }
}
