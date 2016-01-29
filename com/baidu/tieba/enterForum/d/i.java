package com.baidu.tieba.enterForum.d;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class i extends LinearLayout {
    private ViewEventCenter aWA;
    private a aYA;
    private c aYB;
    private int aYy;
    private TextView aYz;
    private int mType;

    public i(Context context) {
        this(context, null);
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setColumnTypeAndRefeshView(int i) {
        this.mType = i;
        if (i == 2) {
            if (this.aYA == null) {
                MT();
            }
            if (this.aYA.getParent() == null) {
                addView(this.aYA);
            }
            removeView(this.aYB);
        } else {
            if (this.aYB == null) {
                MS();
            }
            if (this.aYB.getParent() == null) {
                addView(this.aYB);
            }
            MU();
            removeView(this.aYA);
        }
        setStateForDisplayView(i);
    }

    private void MS() {
        this.aYB = new c(getContext());
        this.aYB.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aYB.setSelector(new ColorDrawable(0));
        a(this.aYB);
        MU();
    }

    private void MT() {
        this.aYA = new a(getContext());
        this.aYA.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aYA.setNumColumns(2);
        this.aYA.setPadding(this.aYy, 0, this.aYy, 0);
        this.aYA.setSelector(new ColorDrawable(0));
        a(this.aYA);
    }

    private void MU() {
        this.aYB.setDivider(ar.getDrawable(t.f.enter_forum_list_divider));
        this.aYB.setDividerHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds1));
    }

    private void a(AbsListView absListView) {
        if (absListView != null) {
            absListView.setCacheColorHint(0);
            absListView.setFadingEdgeLength(0);
            absListView.setFocusable(false);
            absListView.setFocusableInTouchMode(false);
        }
    }

    public void setSelection(int i) {
        if (this.mType == 2) {
            if (this.aYA != null) {
                this.aYA.setSelection(i);
            }
        } else if (this.aYB != null) {
            this.aYB.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.mType == 2) {
            if (this.aYA != null) {
                this.aYA.setSelection(i);
                this.aYA.setPadding(this.aYy, i2, this.aYy, 0);
                this.aYA.setOnTouchListener(new j(this));
            }
        } else if (this.aYB != null) {
            this.aYB.setSelectionFromTop(i, i2);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aYB != null && this.aYB.getAdapter() != baseAdapter) {
            this.aYB.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aYA != null && this.aYA.getAdapter() != baseAdapter) {
            this.aYA.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aWA = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.aYz.setText(TbadkCoreApplication.m411getInst().getString(t.j.enter_forum_two_column_display));
            this.aYz.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.aYz.setText(TbadkCoreApplication.m411getInst().getString(t.j.enter_forum_one_column_display));
        this.aYz.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.aYy = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds10);
        LayoutInflater.from(getContext()).inflate(t.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.aYz = (TextView) findViewById(t.g.forum_editor_column_display);
        findViewById(t.g.forum_editor_column_display_layout).setOnClickListener(new k(this));
        findViewById(t.g.forum_editor_sort_by_rank_layout).setOnClickListener(new l(this));
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        setBackgroundColor(ar.getColor(t.d.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            MU();
        }
    }
}
