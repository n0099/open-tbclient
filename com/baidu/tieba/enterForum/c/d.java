package com.baidu.tieba.enterForum.c;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private ViewEventCenter bWE;
    private int bZb;
    private TextView bZc;
    private LinearLayout bZd;
    private TextView bZe;
    private ImageView bZf;
    private a bZg;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void aci() {
        if (this.bZg == null) {
            acj();
        }
        if (this.bZg.getParent() == null) {
            addView(this.bZg);
        }
    }

    private void acj() {
        this.bZg = new a(getContext());
        this.bZg.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.bZg.setNumColumns(2);
        this.bZg.setPadding(this.bZb, 0, this.bZb, 0);
        this.bZg.setSelector(new ColorDrawable(0));
        this.bZg.setCacheColorHint(0);
        this.bZg.setFadingEdgeLength(0);
        this.bZg.setFocusable(false);
        this.bZg.setFocusableInTouchMode(false);
        this.bZg.setVerticalScrollBarEnabled(false);
    }

    public void setSelection(int i) {
        if (this.bZg != null) {
            this.bZg.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.bZg != null) {
            this.bZg.setSelection(i);
            this.bZg.setPadding(this.bZb, 0, this.bZb, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.bZg != null && this.bZg.getAdapter() != baseAdapter) {
            this.bZg.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bWE = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.bZb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds40);
        LayoutInflater.from(getContext()).inflate(d.j.enter_forum_edit_view, this);
        setOrientation(1);
        this.bZd = (LinearLayout) findViewById(d.h.search_container);
        this.bZd.setVisibility(0);
        this.bZc = (TextView) findViewById(d.h.view_edit_forum_ok);
        this.bZc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bWE != null) {
                    d.this.bWE.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.bZe = (TextView) findViewById(d.h.search_text);
        this.bZf = (ImageView) findViewById(d.h.search_icon);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        setBackgroundColor(ai.getColor(d.e.cp_bg_line_d));
        ai.c(this.bZf, d.g.icon_search);
        ai.i(this.bZe, d.e.enter_forum_search_text_color);
        ai.j(this.bZd, d.g.enter_forum_search_frame);
    }
}
