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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class i extends LinearLayout {
    private ViewEventCenter bbj;
    private int bdi;
    private TextView bdj;
    private a bdk;
    private c bdl;
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
            if (this.bdk == null) {
                OH();
            }
            if (this.bdk.getParent() == null) {
                addView(this.bdk);
            }
            removeView(this.bdl);
        } else {
            if (this.bdl == null) {
                OG();
            }
            if (this.bdl.getParent() == null) {
                addView(this.bdl);
            }
            OI();
            removeView(this.bdk);
        }
        setStateForDisplayView(i);
    }

    private void OG() {
        this.bdl = new c(getContext());
        this.bdl.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.bdl.setSelector(new ColorDrawable(0));
        a(this.bdl);
        OI();
    }

    private void OH() {
        this.bdk = new a(getContext());
        this.bdk.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.bdk.setNumColumns(2);
        this.bdk.setPadding(this.bdi, 0, this.bdi, 0);
        this.bdk.setSelector(new ColorDrawable(0));
        a(this.bdk);
    }

    private void OI() {
        this.bdl.setDivider(at.getDrawable(t.f.enter_forum_list_divider));
        this.bdl.setDividerHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds1));
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
            if (this.bdk != null) {
                this.bdk.setSelection(i);
            }
        } else if (this.bdl != null) {
            this.bdl.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.mType == 2) {
            if (this.bdk != null) {
                this.bdk.setSelection(i);
                this.bdk.setPadding(this.bdi, i2, this.bdi, 0);
                this.bdk.setOnTouchListener(new j(this));
            }
        } else if (this.bdl != null) {
            this.bdl.setSelectionFromTop(i, i2);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.bdl != null && this.bdl.getAdapter() != baseAdapter) {
            this.bdl.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.bdk != null && this.bdk.getAdapter() != baseAdapter) {
            this.bdk.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bbj = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.bdj.setText(TbadkCoreApplication.m411getInst().getString(t.j.enter_forum_two_column_display));
            this.bdj.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.bdj.setText(TbadkCoreApplication.m411getInst().getString(t.j.enter_forum_one_column_display));
        this.bdj.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.bdi = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds10);
        LayoutInflater.from(getContext()).inflate(t.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.bdj = (TextView) findViewById(t.g.forum_editor_column_display);
        findViewById(t.g.forum_editor_column_display_layout).setOnClickListener(new k(this));
        findViewById(t.g.forum_editor_sort_by_rank_layout).setOnClickListener(new l(this));
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        setBackgroundColor(at.getColor(t.d.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            OI();
        }
    }
}
