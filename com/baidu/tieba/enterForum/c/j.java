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
    private ViewEventCenter bEQ;
    private int bFZ;
    private TextView bGa;
    private a bGb;
    private c bGc;
    private View bGd;
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
            if (this.bGb == null) {
                Wq();
            }
            if (this.bGb.getParent() == null) {
                addView(this.bGb);
            }
            removeView(this.bGc);
        } else {
            if (this.bGc == null) {
                Wp();
            }
            if (this.bGc.getParent() == null) {
                addView(this.bGc);
            }
            if (this.bGc.getFooterViewsCount() < 1 && TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                this.bGc.addFooterView(this.bGd);
            }
            Wr();
            removeView(this.bGb);
        }
        setStateForDisplayView(i);
    }

    private void Wp() {
        this.bGc = new c(getContext());
        this.bGc.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.bGc.setSelector(new ColorDrawable(0));
        a(this.bGc);
        Wr();
    }

    private void Wq() {
        this.bGb = new a(getContext());
        this.bGb.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.bGb.setNumColumns(2);
        this.bGb.setPadding(this.bFZ, 0, this.bFZ, 0);
        this.bGb.setSelector(new ColorDrawable(0));
        a(this.bGb);
    }

    private void Wr() {
        this.bGc.setDivider(aq.getDrawable(w.g.enter_forum_list_divider));
        this.bGc.setDividerHeight(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1));
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
            if (this.bGb != null) {
                this.bGb.setSelection(i);
            }
        } else if (this.bGc != null) {
            this.bGc.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.mType == 2) {
            if (this.bGb != null) {
                this.bGb.setSelection(i);
                this.bGb.setPadding(this.bFZ, 0, this.bFZ, 0);
            }
        } else if (this.bGc != null) {
            this.bGc.setSelectionFromTop(i, i2);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.bGc != null && this.bGc.getAdapter() != baseAdapter) {
            this.bGc.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.bGb != null && this.bGb.getAdapter() != baseAdapter) {
            this.bGb.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bEQ = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.bGa.setText(TbadkCoreApplication.m9getInst().getString(w.l.enter_forum_two_column_display));
            this.bGa.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.bGa.setText(TbadkCoreApplication.m9getInst().getString(w.l.enter_forum_one_column_display));
        this.bGa.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.bFZ = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds10);
        LayoutInflater.from(getContext()).inflate(w.j.enter_forum_edit_view, this);
        setOrientation(1);
        this.bGa = (TextView) findViewById(w.h.forum_editor_column_display);
        findViewById(w.h.forum_editor_column_display_layout).setOnClickListener(new k(this));
        findViewById(w.h.forum_editor_sort_by_rank_layout).setOnClickListener(new l(this));
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds150));
        this.bGd = new View(getContext());
        this.bGd.setLayoutParams(layoutParams);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        setBackgroundColor(aq.getColor(w.e.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            Wr();
        }
    }
}
