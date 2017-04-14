package com.baidu.tieba.enterForum.c;

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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private ViewEventCenter bEJ;
    private int bFS;
    private TextView bFT;
    private a bFU;
    private c bFV;
    private View bFW;
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
            if (this.bFU == null) {
                WO();
            }
            if (this.bFU.getParent() == null) {
                addView(this.bFU);
            }
            removeView(this.bFV);
        } else {
            if (this.bFV == null) {
                WN();
            }
            if (this.bFV.getParent() == null) {
                addView(this.bFV);
            }
            if (this.bFV.getFooterViewsCount() < 1 && TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                this.bFV.addFooterView(this.bFW);
            }
            WP();
            removeView(this.bFU);
        }
        setStateForDisplayView(i);
    }

    private void WN() {
        this.bFV = new c(getContext());
        this.bFV.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.bFV.setSelector(new ColorDrawable(0));
        a(this.bFV);
        WP();
    }

    private void WO() {
        this.bFU = new a(getContext());
        this.bFU.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.bFU.setNumColumns(2);
        this.bFU.setPadding(this.bFS, 0, this.bFS, 0);
        this.bFU.setSelector(new ColorDrawable(0));
        a(this.bFU);
    }

    private void WP() {
        this.bFV.setDivider(aq.getDrawable(w.g.enter_forum_list_divider));
        this.bFV.setDividerHeight(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1));
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
            if (this.bFU != null) {
                this.bFU.setSelection(i);
            }
        } else if (this.bFV != null) {
            this.bFV.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.mType == 2) {
            if (this.bFU != null) {
                this.bFU.setSelection(i);
                this.bFU.setPadding(this.bFS, 0, this.bFS, 0);
            }
        } else if (this.bFV != null) {
            this.bFV.setSelectionFromTop(i, i2);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.bFV != null && this.bFV.getAdapter() != baseAdapter) {
            this.bFV.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.bFU != null && this.bFU.getAdapter() != baseAdapter) {
            this.bFU.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bEJ = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.bFT.setText(TbadkCoreApplication.m9getInst().getString(w.l.enter_forum_two_column_display));
            this.bFT.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.bFT.setText(TbadkCoreApplication.m9getInst().getString(w.l.enter_forum_one_column_display));
        this.bFT.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.bFS = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds10);
        LayoutInflater.from(getContext()).inflate(w.j.enter_forum_edit_view, this);
        setOrientation(1);
        this.bFT = (TextView) findViewById(w.h.forum_editor_column_display);
        findViewById(w.h.forum_editor_column_display_layout).setOnClickListener(new k(this));
        findViewById(w.h.forum_editor_sort_by_rank_layout).setOnClickListener(new l(this));
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds150));
        this.bFW = new View(getContext());
        this.bFW.setLayoutParams(layoutParams);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.m.a.a(tbPageContext, this);
        setBackgroundColor(aq.getColor(w.e.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            WP();
        }
    }
}
