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
    private ViewEventCenter bLQ;
    private int bNS;
    private TextView bNT;
    private LinearLayout bNU;
    private TextView bNV;
    private ImageView bNW;
    private a bNX;

    public m(Context context) {
        this(context, null);
    }

    public m(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void XV() {
        if (this.bNX == null) {
            XW();
        }
        if (this.bNX.getParent() == null) {
            addView(this.bNX);
        }
    }

    private void XW() {
        this.bNX = new a(getContext());
        this.bNX.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.bNX.setNumColumns(2);
        this.bNX.setPadding(this.bNS, 0, this.bNS, 0);
        this.bNX.setSelector(new ColorDrawable(0));
        this.bNX.setCacheColorHint(0);
        this.bNX.setFadingEdgeLength(0);
        this.bNX.setFocusable(false);
        this.bNX.setFocusableInTouchMode(false);
        this.bNX.setVerticalScrollBarEnabled(false);
    }

    public void setSelection(int i) {
        if (this.bNX != null) {
            this.bNX.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.bNX != null) {
            this.bNX.setSelection(i);
            this.bNX.setPadding(this.bNS, 0, this.bNS, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.bNX != null && this.bNX.getAdapter() != baseAdapter) {
            this.bNX.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bLQ = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.bNS = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds40);
        LayoutInflater.from(getContext()).inflate(w.j.enter_forum_edit_view, this);
        setOrientation(1);
        this.bNU = (LinearLayout) findViewById(w.h.search_container);
        this.bNU.setVisibility(0);
        this.bNT = (TextView) findViewById(w.h.view_edit_forum_ok);
        this.bNT.setOnClickListener(new n(this));
        this.bNV = (TextView) findViewById(w.h.search_text);
        this.bNW = (ImageView) findViewById(w.h.search_icon);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.m.a.a(tbPageContext, this);
        setBackgroundColor(aq.getColor(w.e.cp_bg_line_d));
        aq.c(this.bNW, w.g.icon_enterforum_search);
        aq.i(this.bNV, w.e.enter_forum_search_text_color);
        aq.j(this.bNU, w.g.enter_forum_search_frame);
    }
}
