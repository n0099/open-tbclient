package com.baidu.tieba.enterForum.view;

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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private ViewEventCenter bgJ;
    private int bwV;
    private TextView bwW;
    private a bwX;
    private c bwY;
    private View bwZ;
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
            if (this.bwX == null) {
                TH();
            }
            if (this.bwX.getParent() == null) {
                addView(this.bwX);
            }
            removeView(this.bwY);
        } else {
            if (this.bwY == null) {
                TG();
            }
            if (this.bwY.getParent() == null) {
                addView(this.bwY);
            }
            if (this.bwY.getFooterViewsCount() < 1 && TbadkCoreApplication.m10getInst().getSkinType() != 2) {
                this.bwY.addFooterView(this.bwZ);
            }
            TI();
            removeView(this.bwX);
        }
        setStateForDisplayView(i);
    }

    private void TG() {
        this.bwY = new c(getContext());
        this.bwY.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.bwY.setSelector(new ColorDrawable(0));
        a(this.bwY);
        TI();
    }

    private void TH() {
        this.bwX = new a(getContext());
        this.bwX.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.bwX.setNumColumns(2);
        this.bwX.setPadding(this.bwV, 0, this.bwV, 0);
        this.bwX.setSelector(new ColorDrawable(0));
        a(this.bwX);
    }

    private void TI() {
        this.bwY.setDivider(av.getDrawable(u.f.enter_forum_list_divider));
        this.bwY.setDividerHeight(TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds1));
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
            if (this.bwX != null) {
                this.bwX.setSelection(i);
            }
        } else if (this.bwY != null) {
            this.bwY.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.mType == 2) {
            if (this.bwX != null) {
                this.bwX.setSelection(i);
                this.bwX.setPadding(this.bwV, 0, this.bwV, 0);
            }
        } else if (this.bwY != null) {
            this.bwY.setSelectionFromTop(i, i2);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.bwY != null && this.bwY.getAdapter() != baseAdapter) {
            this.bwY.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.bwX != null && this.bwX.getAdapter() != baseAdapter) {
            this.bwX.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bgJ = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.bwW.setText(TbadkCoreApplication.m10getInst().getString(u.j.enter_forum_two_column_display));
            this.bwW.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.bwW.setText(TbadkCoreApplication.m10getInst().getString(u.j.enter_forum_one_column_display));
        this.bwW.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.bwV = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds10);
        LayoutInflater.from(getContext()).inflate(u.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.bwW = (TextView) findViewById(u.g.forum_editor_column_display);
        findViewById(u.g.forum_editor_column_display_layout).setOnClickListener(new k(this));
        findViewById(u.g.forum_editor_sort_by_rank_layout).setOnClickListener(new l(this));
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.c(getContext(), u.e.ds150));
        this.bwZ = new View(getContext());
        this.bwZ.setLayoutParams(layoutParams);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.j.a.a(tbPageContext, this);
        setBackgroundColor(av.getColor(u.d.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            TI();
        }
    }
}
