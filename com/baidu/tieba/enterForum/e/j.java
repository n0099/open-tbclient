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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private ViewEventCenter aOw;
    private int bIj;
    private TextView bIk;
    private a bIl;
    private c bIm;
    private View bIn;
    private int mType;

    public j(Context context) {
        this(context, null);
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setColumnTypeAndRefeshView(int i) {
        this.mType = i;
        if (i == 2) {
            if (this.bIl == null) {
                Yr();
            }
            if (this.bIl.getParent() == null) {
                addView(this.bIl);
            }
            removeView(this.bIm);
        } else {
            if (this.bIm == null) {
                Yq();
            }
            if (this.bIm.getParent() == null) {
                addView(this.bIm);
            }
            if (this.bIm.getFooterViewsCount() < 1 && TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                this.bIm.addFooterView(this.bIn);
            }
            Ys();
            removeView(this.bIl);
        }
        setStateForDisplayView(i);
    }

    private void Yq() {
        this.bIm = new c(getContext());
        this.bIm.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.bIm.setSelector(new ColorDrawable(0));
        a(this.bIm);
        Ys();
    }

    private void Yr() {
        this.bIl = new a(getContext());
        this.bIl.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.bIl.setNumColumns(2);
        this.bIl.setPadding(this.bIj, 0, this.bIj, 0);
        this.bIl.setSelector(new ColorDrawable(0));
        a(this.bIl);
    }

    private void Ys() {
        this.bIm.setDivider(av.getDrawable(t.f.enter_forum_list_divider));
        this.bIm.setDividerHeight(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds1));
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
            if (this.bIl != null) {
                this.bIl.setSelection(i);
            }
        } else if (this.bIm != null) {
            this.bIm.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.mType == 2) {
            if (this.bIl != null) {
                this.bIl.setSelection(i);
                this.bIl.setPadding(this.bIj, 0, this.bIj, 0);
            }
        } else if (this.bIm != null) {
            this.bIm.setSelectionFromTop(i, i2);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.bIm != null && this.bIm.getAdapter() != baseAdapter) {
            this.bIm.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.bIl != null && this.bIl.getAdapter() != baseAdapter) {
            this.bIl.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aOw = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.bIk.setText(TbadkCoreApplication.m9getInst().getString(t.j.enter_forum_two_column_display));
            this.bIk.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(t.f.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.bIk.setText(TbadkCoreApplication.m9getInst().getString(t.j.enter_forum_one_column_display));
        this.bIk.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(t.f.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.bIj = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds10);
        LayoutInflater.from(getContext()).inflate(t.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.bIk = (TextView) findViewById(t.g.forum_editor_column_display);
        findViewById(t.g.forum_editor_column_display_layout).setOnClickListener(new k(this));
        findViewById(t.g.forum_editor_sort_by_rank_layout).setOnClickListener(new l(this));
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.e(getContext(), t.e.ds150));
        this.bIn = new View(getContext());
        this.bIn.setLayoutParams(layoutParams);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.j.a.a(tbPageContext, this);
        setBackgroundColor(av.getColor(t.d.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            Ys();
        }
    }
}
