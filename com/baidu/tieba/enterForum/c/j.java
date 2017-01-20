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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private ViewEventCenter bxK;
    private int byT;
    private TextView byU;
    private a byV;
    private c byW;
    private View byX;
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
            if (this.byV == null) {
                Vs();
            }
            if (this.byV.getParent() == null) {
                addView(this.byV);
            }
            removeView(this.byW);
        } else {
            if (this.byW == null) {
                Vr();
            }
            if (this.byW.getParent() == null) {
                addView(this.byW);
            }
            if (this.byW.getFooterViewsCount() < 1 && TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                this.byW.addFooterView(this.byX);
            }
            Vt();
            removeView(this.byV);
        }
        setStateForDisplayView(i);
    }

    private void Vr() {
        this.byW = new c(getContext());
        this.byW.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.byW.setSelector(new ColorDrawable(0));
        a(this.byW);
        Vt();
    }

    private void Vs() {
        this.byV = new a(getContext());
        this.byV.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.byV.setNumColumns(2);
        this.byV.setPadding(this.byT, 0, this.byT, 0);
        this.byV.setSelector(new ColorDrawable(0));
        a(this.byV);
    }

    private void Vt() {
        this.byW.setDivider(ap.getDrawable(r.g.enter_forum_list_divider));
        this.byW.setDividerHeight(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds1));
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
            if (this.byV != null) {
                this.byV.setSelection(i);
            }
        } else if (this.byW != null) {
            this.byW.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.mType == 2) {
            if (this.byV != null) {
                this.byV.setSelection(i);
                this.byV.setPadding(this.byT, 0, this.byT, 0);
            }
        } else if (this.byW != null) {
            this.byW.setSelectionFromTop(i, i2);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.byW != null && this.byW.getAdapter() != baseAdapter) {
            this.byW.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.byV != null && this.byV.getAdapter() != baseAdapter) {
            this.byV.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bxK = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.byU.setText(TbadkCoreApplication.m9getInst().getString(r.l.enter_forum_two_column_display));
            this.byU.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.byU.setText(TbadkCoreApplication.m9getInst().getString(r.l.enter_forum_one_column_display));
        this.byU.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.byT = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds10);
        LayoutInflater.from(getContext()).inflate(r.j.enter_forum_edit_view, this);
        setOrientation(1);
        this.byU = (TextView) findViewById(r.h.forum_editor_column_display);
        findViewById(r.h.forum_editor_column_display_layout).setOnClickListener(new k(this));
        findViewById(r.h.forum_editor_sort_by_rank_layout).setOnClickListener(new l(this));
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.e(getContext(), r.f.ds150));
        this.byX = new View(getContext());
        this.byX.setLayoutParams(layoutParams);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        setBackgroundColor(ap.getColor(r.e.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            Vt();
        }
    }
}
