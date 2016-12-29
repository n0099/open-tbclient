package com.baidu.tieba.enterForum.d;

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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private ViewEventCenter aRj;
    private int bri;
    private TextView brj;
    private a brk;
    private c brl;
    private View brm;
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
            if (this.brk == null) {
                TX();
            }
            if (this.brk.getParent() == null) {
                addView(this.brk);
            }
            removeView(this.brl);
        } else {
            if (this.brl == null) {
                TW();
            }
            if (this.brl.getParent() == null) {
                addView(this.brl);
            }
            if (this.brl.getFooterViewsCount() < 1 && TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                this.brl.addFooterView(this.brm);
            }
            TY();
            removeView(this.brk);
        }
        setStateForDisplayView(i);
    }

    private void TW() {
        this.brl = new c(getContext());
        this.brl.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.brl.setSelector(new ColorDrawable(0));
        a(this.brl);
        TY();
    }

    private void TX() {
        this.brk = new a(getContext());
        this.brk.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.brk.setNumColumns(2);
        this.brk.setPadding(this.bri, 0, this.bri, 0);
        this.brk.setSelector(new ColorDrawable(0));
        a(this.brk);
    }

    private void TY() {
        this.brl.setDivider(ar.getDrawable(r.f.enter_forum_list_divider));
        this.brl.setDividerHeight(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds1));
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
            if (this.brk != null) {
                this.brk.setSelection(i);
            }
        } else if (this.brl != null) {
            this.brl.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.mType == 2) {
            if (this.brk != null) {
                this.brk.setSelection(i);
                this.brk.setPadding(this.bri, 0, this.bri, 0);
            }
        } else if (this.brl != null) {
            this.brl.setSelectionFromTop(i, i2);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.brl != null && this.brl.getAdapter() != baseAdapter) {
            this.brl.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.brk != null && this.brk.getAdapter() != baseAdapter) {
            this.brk.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aRj = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.brj.setText(TbadkCoreApplication.m9getInst().getString(r.j.enter_forum_two_column_display));
            this.brj.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.brj.setText(TbadkCoreApplication.m9getInst().getString(r.j.enter_forum_one_column_display));
        this.brj.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.bri = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds10);
        LayoutInflater.from(getContext()).inflate(r.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.brj = (TextView) findViewById(r.g.forum_editor_column_display);
        findViewById(r.g.forum_editor_column_display_layout).setOnClickListener(new k(this));
        findViewById(r.g.forum_editor_sort_by_rank_layout).setOnClickListener(new l(this));
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.e(getContext(), r.e.ds150));
        this.brm = new View(getContext());
        this.brm.setLayoutParams(layoutParams);
    }

    public void s(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        setBackgroundColor(ar.getColor(r.d.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            TY();
        }
    }
}
