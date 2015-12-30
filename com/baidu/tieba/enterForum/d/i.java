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
    private ViewEventCenter aUs;
    private int aWk;
    private TextView aWl;
    private a aWm;
    private c aWn;
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
            if (this.aWm == null) {
                Lb();
            }
            if (this.aWm.getParent() == null) {
                addView(this.aWm);
            }
            removeView(this.aWn);
        } else {
            if (this.aWn == null) {
                La();
            }
            if (this.aWn.getParent() == null) {
                addView(this.aWn);
            }
            Lc();
            removeView(this.aWm);
        }
        setStateForDisplayView(i);
    }

    private void La() {
        this.aWn = new c(getContext());
        this.aWn.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aWn.setSelector(new ColorDrawable(0));
        a(this.aWn);
        Lc();
    }

    private void Lb() {
        this.aWm = new a(getContext());
        this.aWm.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aWm.setNumColumns(2);
        this.aWm.setPadding(this.aWk, 0, this.aWk, 0);
        this.aWm.setSelector(new ColorDrawable(0));
        a(this.aWm);
    }

    private void Lc() {
        this.aWn.setDivider(as.getDrawable(n.f.enter_forum_list_divider));
        this.aWn.setDividerHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds1));
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
            if (this.aWm != null) {
                this.aWm.setSelection(i);
            }
        } else if (this.aWn != null) {
            this.aWn.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.mType == 2) {
            if (this.aWm != null) {
                this.aWm.setSelection(i);
                this.aWm.setPadding(this.aWk, i2, this.aWk, 0);
                this.aWm.setOnTouchListener(new j(this));
            }
        } else if (this.aWn != null) {
            this.aWn.setSelectionFromTop(i, i2);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aWn != null && this.aWn.getAdapter() != baseAdapter) {
            this.aWn.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aWm != null && this.aWm.getAdapter() != baseAdapter) {
            this.aWm.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aUs = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.aWl.setText(TbadkCoreApplication.m411getInst().getString(n.j.enter_forum_two_column_display));
            this.aWl.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.aWl.setText(TbadkCoreApplication.m411getInst().getString(n.j.enter_forum_one_column_display));
        this.aWl.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.aWk = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds10);
        LayoutInflater.from(getContext()).inflate(n.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.aWl = (TextView) findViewById(n.g.forum_editor_column_display);
        findViewById(n.g.forum_editor_column_display_layout).setOnClickListener(new k(this));
        findViewById(n.g.forum_editor_sort_by_rank_layout).setOnClickListener(new l(this));
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        setBackgroundColor(as.getColor(n.d.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            Lc();
        }
    }
}
