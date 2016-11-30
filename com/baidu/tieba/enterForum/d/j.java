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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private ViewEventCenter aRS;
    private int bLe;
    private TextView bLf;
    private a bLg;
    private c bLh;
    private View bLi;
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
            if (this.bLg == null) {
                ZK();
            }
            if (this.bLg.getParent() == null) {
                addView(this.bLg);
            }
            removeView(this.bLh);
        } else {
            if (this.bLh == null) {
                ZJ();
            }
            if (this.bLh.getParent() == null) {
                addView(this.bLh);
            }
            if (this.bLh.getFooterViewsCount() < 1 && TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                this.bLh.addFooterView(this.bLi);
            }
            ZL();
            removeView(this.bLg);
        }
        setStateForDisplayView(i);
    }

    private void ZJ() {
        this.bLh = new c(getContext());
        this.bLh.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.bLh.setSelector(new ColorDrawable(0));
        a(this.bLh);
        ZL();
    }

    private void ZK() {
        this.bLg = new a(getContext());
        this.bLg.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.bLg.setNumColumns(2);
        this.bLg.setPadding(this.bLe, 0, this.bLe, 0);
        this.bLg.setSelector(new ColorDrawable(0));
        a(this.bLg);
    }

    private void ZL() {
        this.bLh.setDivider(at.getDrawable(r.f.enter_forum_list_divider));
        this.bLh.setDividerHeight(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds1));
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
            if (this.bLg != null) {
                this.bLg.setSelection(i);
            }
        } else if (this.bLh != null) {
            this.bLh.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.mType == 2) {
            if (this.bLg != null) {
                this.bLg.setSelection(i);
                this.bLg.setPadding(this.bLe, 0, this.bLe, 0);
            }
        } else if (this.bLh != null) {
            this.bLh.setSelectionFromTop(i, i2);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.bLh != null && this.bLh.getAdapter() != baseAdapter) {
            this.bLh.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.bLg != null && this.bLg.getAdapter() != baseAdapter) {
            this.bLg.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aRS = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.bLf.setText(TbadkCoreApplication.m9getInst().getString(r.j.enter_forum_two_column_display));
            this.bLf.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.bLf.setText(TbadkCoreApplication.m9getInst().getString(r.j.enter_forum_one_column_display));
        this.bLf.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.bLe = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds10);
        LayoutInflater.from(getContext()).inflate(r.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.bLf = (TextView) findViewById(r.g.forum_editor_column_display);
        findViewById(r.g.forum_editor_column_display_layout).setOnClickListener(new k(this));
        findViewById(r.g.forum_editor_sort_by_rank_layout).setOnClickListener(new l(this));
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.e(getContext(), r.e.ds150));
        this.bLi = new View(getContext());
        this.bLi.setLayoutParams(layoutParams);
    }

    public void r(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        setBackgroundColor(at.getColor(r.d.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            ZL();
        }
    }
}
