package com.baidu.tieba.enterForum.e;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class i extends LinearLayout {
    private ViewEventCenter aXs;
    private int aYP;
    private TextView aYQ;
    private a aYR;
    private c aYS;
    private View aYT;
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
            if (this.aYR == null) {
                Ny();
            }
            if (this.aYR.getParent() == null) {
                addView(this.aYR);
            }
            removeView(this.aYS);
        } else {
            if (this.aYS == null) {
                Nx();
            }
            if (this.aYS.getParent() == null) {
                addView(this.aYS);
            }
            if (this.aYS.getFooterViewsCount() < 1 && TbadkCoreApplication.m11getInst().getSkinType() != 2) {
                this.aYS.addFooterView(this.aYT);
            }
            Nz();
            removeView(this.aYR);
        }
        setStateForDisplayView(i);
    }

    private void Nx() {
        this.aYS = new c(getContext());
        this.aYS.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aYS.setSelector(new ColorDrawable(0));
        a(this.aYS);
        Nz();
    }

    private void Ny() {
        this.aYR = new a(getContext());
        this.aYR.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aYR.setNumColumns(2);
        this.aYR.setPadding(this.aYP, 0, this.aYP, 0);
        this.aYR.setSelector(new ColorDrawable(0));
        a(this.aYR);
    }

    private void Nz() {
        this.aYS.setDivider(at.getDrawable(t.f.enter_forum_list_divider));
        this.aYS.setDividerHeight(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds1));
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
            if (this.aYR != null) {
                this.aYR.setSelection(i);
            }
        } else if (this.aYS != null) {
            this.aYS.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.mType == 2) {
            if (this.aYR != null) {
                this.aYR.setSelection(i);
                this.aYR.setPadding(this.aYP, i2, this.aYP, 0);
                this.aYR.setOnTouchListener(new j(this));
            }
        } else if (this.aYS != null) {
            this.aYS.setSelectionFromTop(i, i2);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aYS != null && this.aYS.getAdapter() != baseAdapter) {
            this.aYS.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aYR != null && this.aYR.getAdapter() != baseAdapter) {
            this.aYR.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aXs = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.aYQ.setText(TbadkCoreApplication.m11getInst().getString(t.j.enter_forum_two_column_display));
            this.aYQ.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.aYQ.setText(TbadkCoreApplication.m11getInst().getString(t.j.enter_forum_one_column_display));
        this.aYQ.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.aYP = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds10);
        LayoutInflater.from(getContext()).inflate(t.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.aYQ = (TextView) findViewById(t.g.forum_editor_column_display);
        findViewById(t.g.forum_editor_column_display_layout).setOnClickListener(new k(this));
        findViewById(t.g.forum_editor_sort_by_rank_layout).setOnClickListener(new l(this));
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.c(getContext(), t.e.ds150));
        this.aYT = new View(getContext());
        this.aYT.setLayoutParams(layoutParams);
    }

    public void g(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        setBackgroundColor(at.getColor(t.d.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            Nz();
        }
    }
}
