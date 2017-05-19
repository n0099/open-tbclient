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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class m extends LinearLayout {
    private ViewEventCenter bGb;
    private int bIe;
    private TextView bIf;
    private LinearLayout bIg;
    private TextView bIh;
    private ImageView bIi;
    private a bIj;

    public m(Context context) {
        this(context, null);
    }

    public m(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void WS() {
        if (this.bIj == null) {
            WT();
        }
        if (this.bIj.getParent() == null) {
            addView(this.bIj);
        }
    }

    private void WT() {
        this.bIj = new a(getContext());
        this.bIj.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.bIj.setNumColumns(2);
        this.bIj.setPadding(this.bIe, 0, this.bIe, 0);
        this.bIj.setSelector(new ColorDrawable(0));
        this.bIj.setCacheColorHint(0);
        this.bIj.setFadingEdgeLength(0);
        this.bIj.setFocusable(false);
        this.bIj.setFocusableInTouchMode(false);
        this.bIj.setVerticalScrollBarEnabled(false);
    }

    public void setSelection(int i) {
        if (this.bIj != null) {
            this.bIj.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.bIj != null) {
            this.bIj.setSelection(i);
            this.bIj.setPadding(this.bIe, 0, this.bIe, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.bIj != null && this.bIj.getAdapter() != baseAdapter) {
            this.bIj.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bGb = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.bIe = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds40);
        LayoutInflater.from(getContext()).inflate(w.j.enter_forum_edit_view, this);
        setOrientation(1);
        this.bIg = (LinearLayout) findViewById(w.h.search_container);
        this.bIg.setVisibility(0);
        this.bIf = (TextView) findViewById(w.h.view_edit_forum_ok);
        this.bIf.setOnClickListener(new n(this));
        this.bIh = (TextView) findViewById(w.h.search_text);
        this.bIi = (ImageView) findViewById(w.h.search_icon);
    }

    public void o(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.m.a.a(tbPageContext, this);
        setBackgroundColor(aq.getColor(w.e.cp_bg_line_d));
        aq.c(this.bIi, w.g.icon_enterforum_search);
        aq.i(this.bIh, w.e.enter_forum_search_text_color);
        aq.j(this.bIg, w.g.enter_forum_search_frame);
    }
}
