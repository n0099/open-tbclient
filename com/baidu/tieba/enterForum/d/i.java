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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class i extends LinearLayout {
    private ViewEventCenter aQB;
    private int aSi;
    private TextView aSj;
    private a aSk;
    private c aSl;
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
            if (this.aSk == null) {
                KI();
            }
            if (this.aSk.getParent() == null) {
                addView(this.aSk);
            }
            removeView(this.aSl);
        } else {
            if (this.aSl == null) {
                KH();
            }
            if (this.aSl.getParent() == null) {
                addView(this.aSl);
            }
            KJ();
            removeView(this.aSk);
        }
        setStateForDisplayView(i);
    }

    private void KH() {
        this.aSl = new c(getContext());
        this.aSl.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aSl.setSelector(new ColorDrawable(0));
        a(this.aSl);
        KJ();
    }

    private void KI() {
        this.aSk = new a(getContext());
        this.aSk.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aSk.setNumColumns(2);
        this.aSk.setPadding(this.aSi, 0, this.aSi, 0);
        this.aSk.setSelector(new ColorDrawable(0));
        a(this.aSk);
    }

    private void KJ() {
        this.aSl.setDivider(as.getDrawable(n.e.enter_forum_list_divider));
        this.aSl.setDividerHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds1));
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
            if (this.aSk != null) {
                this.aSk.setSelection(i);
            }
        } else if (this.aSl != null) {
            this.aSl.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.mType == 2) {
            if (this.aSk != null) {
                this.aSk.setSelection(i);
                this.aSk.setPadding(this.aSi, i2, this.aSi, 0);
                this.aSk.setOnTouchListener(new j(this));
            }
        } else if (this.aSl != null) {
            this.aSl.setSelectionFromTop(i, i2);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aSl != null && this.aSl.getAdapter() != baseAdapter) {
            this.aSl.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aSk != null && this.aSk.getAdapter() != baseAdapter) {
            this.aSk.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aQB = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.aSj.setText(TbadkCoreApplication.m411getInst().getString(n.i.enter_forum_two_column_display));
            this.aSj.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.aSj.setText(TbadkCoreApplication.m411getInst().getString(n.i.enter_forum_one_column_display));
        this.aSj.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.aSi = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds10);
        LayoutInflater.from(getContext()).inflate(n.g.enter_forum_edit_view, this);
        setOrientation(1);
        this.aSj = (TextView) findViewById(n.f.forum_editor_column_display);
        findViewById(n.f.forum_editor_column_display_layout).setOnClickListener(new k(this));
        findViewById(n.f.forum_editor_sort_by_rank_layout).setOnClickListener(new l(this));
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        setBackgroundColor(as.getColor(n.c.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            KJ();
        }
    }
}
