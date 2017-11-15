package com.baidu.tieba.enterForum.b;

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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private ViewEventCenter cjP;
    private int cmf;
    private TextView cmg;
    private LinearLayout cmh;
    private TextView cmi;
    private ImageView cmj;
    private a cmk;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void afR() {
        if (this.cmk == null) {
            afS();
        }
        if (this.cmk.getParent() == null) {
            addView(this.cmk);
        }
    }

    private void afS() {
        this.cmk = new a(getContext());
        this.cmk.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.cmk.setNumColumns(2);
        this.cmk.setPadding(this.cmf, 0, this.cmf, 0);
        this.cmk.setSelector(new ColorDrawable(0));
        this.cmk.setCacheColorHint(0);
        this.cmk.setFadingEdgeLength(0);
        this.cmk.setFocusable(false);
        this.cmk.setFocusableInTouchMode(false);
        this.cmk.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.cmk != null) {
            this.cmk.setSelection(i);
            this.cmk.setPadding(this.cmf, 0, this.cmf, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.cmk != null && this.cmk.getAdapter() != baseAdapter) {
            this.cmk.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.cjP = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.cmf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds40);
        LayoutInflater.from(getContext()).inflate(d.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.cmh = (LinearLayout) findViewById(d.g.search_container);
        this.cmh.setVisibility(0);
        this.cmg = (TextView) findViewById(d.g.view_edit_forum_ok);
        this.cmg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.cjP != null) {
                    d.this.cjP.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.cmi = (TextView) findViewById(d.g.search_text);
        this.cmj = (ImageView) findViewById(d.g.search_icon);
    }

    public void k(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.o.a.a(tbPageContext, this);
        setBackgroundColor(aj.getColor(d.C0080d.cp_bg_line_d));
        aj.c(this.cmj, d.f.icon_search);
        aj.i(this.cmi, d.C0080d.enter_forum_search_text_color);
        aj.j(this.cmh, d.f.enter_forum_search_frame);
    }
}
