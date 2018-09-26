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
/* loaded from: classes2.dex */
public class ForumHeaderView extends LinearLayout {
    private ViewEventCenter cXw;
    private LinearLayout daH;
    private TextView daw;
    private ImageView dax;

    public ForumHeaderView(Context context) {
        this(context, null);
    }

    public ForumHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cXw = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(e.h.layout_enterforum_search, this);
        setOrientation(1);
        setDescendantFocusability(262144);
        this.daH = (LinearLayout) findViewById(e.g.search_container);
        this.daH.setVisibility(0);
        this.daH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.ForumHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ForumHeaderView.this.cXw != null) {
                    TiebaStatic.log("c10362");
                    ForumHeaderView.this.cXw.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
                }
            }
        });
        this.daw = (TextView) findViewById(e.g.search_text);
        this.dax = (ImageView) findViewById(e.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        al.c(this.dax, e.f.icon_input_search);
        al.h(this.daw, e.d.cp_cont_d);
        al.j(this.daH, e.d.cp_bg_line_e);
    }

    public void kl(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.daH.getLayoutParams();
        layoutParams.topMargin = i;
        this.daH.setLayoutParams(layoutParams);
    }

    public void setSearchHint(String str) {
        this.daw.setText(UtilHelper.getFixedText(str, 20));
    }
}
