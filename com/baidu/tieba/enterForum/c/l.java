package com.baidu.tieba.enterForum.c;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class l extends LinearLayout {
    private ViewEventCenter bSq;
    private int bUN;
    private TextView bUO;
    private LinearLayout bUP;
    private TextView bUQ;
    private ImageView bUR;
    private a bUS;

    public l(Context context) {
        this(context, null);
    }

    public l(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void abw() {
        if (this.bUS == null) {
            abx();
        }
        if (this.bUS.getParent() == null) {
            addView(this.bUS);
        }
    }

    private void abx() {
        this.bUS = new a(getContext());
        this.bUS.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.bUS.setNumColumns(2);
        this.bUS.setPadding(this.bUN, 0, this.bUN, 0);
        this.bUS.setSelector(new ColorDrawable(0));
        this.bUS.setCacheColorHint(0);
        this.bUS.setFadingEdgeLength(0);
        this.bUS.setFocusable(false);
        this.bUS.setFocusableInTouchMode(false);
        this.bUS.setVerticalScrollBarEnabled(false);
    }

    public void setSelection(int i) {
        if (this.bUS != null) {
            this.bUS.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.bUS != null) {
            this.bUS.setSelection(i);
            this.bUS.setPadding(this.bUN, 0, this.bUN, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.bUS != null && this.bUS.getAdapter() != baseAdapter) {
            this.bUS.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bSq = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.bUN = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds40);
        LayoutInflater.from(getContext()).inflate(w.j.enter_forum_edit_view, this);
        setOrientation(1);
        this.bUP = (LinearLayout) findViewById(w.h.search_container);
        this.bUP.setVisibility(0);
        this.bUO = (TextView) findViewById(w.h.view_edit_forum_ok);
        this.bUO.setOnClickListener(new m(this));
        this.bUQ = (TextView) findViewById(w.h.search_text);
        this.bUR = (ImageView) findViewById(w.h.search_icon);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.m.a.a(tbPageContext, this);
        setBackgroundColor(as.getColor(w.e.cp_bg_line_d));
        as.c(this.bUR, w.g.icon_search);
        as.i(this.bUQ, w.e.enter_forum_search_text_color);
        as.j(this.bUP, w.g.enter_forum_search_frame);
    }
}
