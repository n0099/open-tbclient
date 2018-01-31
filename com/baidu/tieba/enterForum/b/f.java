package com.baidu.tieba.enterForum.b;

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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f extends LinearLayout {
    private ViewEventCenter dme;
    private LinearLayout doC;
    private TextView dot;
    private ImageView dou;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.dme = viewEventCenter;
    }

    public void init() {
        LayoutInflater.from(getContext()).inflate(d.h.layout_enterforum_search, this);
        setOrientation(1);
        setDescendantFocusability(262144);
        this.doC = (LinearLayout) findViewById(d.g.search_container);
        this.doC.setVisibility(0);
        this.doC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dme != null) {
                    TiebaStatic.log("c10362");
                    f.this.dme.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
                }
            }
        });
        this.dot = (TextView) findViewById(d.g.search_text);
        this.dou = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        aj.c(this.dou, d.f.icon_input_seach);
        aj.r(this.dot, d.C0108d.enter_forum_search_text_color);
        aj.s(this.doC, d.f.enter_forum_search_frame);
    }

    public void ms(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.doC.getLayoutParams();
        layoutParams.topMargin = i;
        this.doC.setLayoutParams(layoutParams);
    }

    public void setSearchHint(String str) {
        this.dot.setText(UtilHelper.getFixedText(str, 20));
    }
}
