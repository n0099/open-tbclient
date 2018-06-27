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
    private ViewEventCenter cOZ;
    private TextView cRV;
    private ImageView cRW;
    private LinearLayout cSf;

    public ForumHeaderView(Context context) {
        this(context, null);
    }

    public ForumHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cOZ = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(d.i.layout_enterforum_search, this);
        setOrientation(1);
        setDescendantFocusability(262144);
        this.cSf = (LinearLayout) findViewById(d.g.search_container);
        this.cSf.setVisibility(0);
        this.cSf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumHeaderView.this.cOZ != null) {
                    TiebaStatic.log("c10362");
                    ForumHeaderView.this.cOZ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
                }
            }
        });
        this.cRV = (TextView) findViewById(d.g.search_text);
        this.cRW = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        am.c(this.cRW, d.f.icon_input_search);
        am.h(this.cRV, d.C0142d.cp_cont_d);
        am.j(this.cSf, d.C0142d.cp_bg_line_e);
    }

    public void jB(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cSf.getLayoutParams();
        layoutParams.topMargin = i;
        this.cSf.setLayoutParams(layoutParams);
    }

    public void setSearchHint(String str) {
        this.cRV.setText(UtilHelper.getFixedText(str, 20));
    }
}
