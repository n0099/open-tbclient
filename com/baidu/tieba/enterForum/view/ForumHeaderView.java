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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class ForumHeaderView extends LinearLayout {
    private ViewEventCenter cRF;
    private TextView cUE;
    private ImageView cUF;
    private LinearLayout cUO;

    public ForumHeaderView(Context context) {
        this(context, null);
    }

    public ForumHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cRF = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(f.h.layout_enterforum_search, this);
        setOrientation(1);
        setDescendantFocusability(262144);
        this.cUO = (LinearLayout) findViewById(f.g.search_container);
        this.cUO.setVisibility(0);
        this.cUO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumHeaderView.this.cRF != null) {
                    TiebaStatic.log("c10362");
                    ForumHeaderView.this.cRF.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
                }
            }
        });
        this.cUE = (TextView) findViewById(f.g.search_text);
        this.cUF = (ImageView) findViewById(f.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        am.c(this.cUF, f.C0146f.icon_input_search);
        am.h(this.cUE, f.d.cp_cont_d);
        am.j(this.cUO, f.d.cp_bg_line_e);
    }

    public void jM(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cUO.getLayoutParams();
        layoutParams.topMargin = i;
        this.cUO.setLayoutParams(layoutParams);
    }

    public void setSearchHint(String str) {
        this.cUE.setText(UtilHelper.getFixedText(str, 20));
    }
}
