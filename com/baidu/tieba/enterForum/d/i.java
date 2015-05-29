package com.baidu.tieba.enterForum.d;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class i extends LinearLayout {
    private ViewEventCenter aET;
    private TextView aGc;
    private a aGd;
    private c aGe;
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
            if (this.aGd == null) {
                IE();
            }
            if (this.aGd.getParent() == null) {
                addView(this.aGd);
            }
            removeView(this.aGe);
        } else {
            if (this.aGe == null) {
                ID();
            }
            if (this.aGe.getParent() == null) {
                addView(this.aGe);
            }
            IF();
            removeView(this.aGd);
        }
        setStateForDisplayView(i);
    }

    private void ID() {
        this.aGe = new c(getContext());
        this.aGe.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aGe.setSelector(new ColorDrawable(0));
        a(this.aGe);
        IF();
    }

    private void IE() {
        this.aGd = new a(getContext());
        this.aGd.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aGd.setNumColumns(2);
        this.aGd.setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds10), 0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds10), 0);
        this.aGd.setSelector(new ColorDrawable(0));
        a(this.aGd);
    }

    private void IF() {
        this.aGe.setDivider(ay.getDrawable(com.baidu.tieba.p.enter_forum_list_divider));
        this.aGe.setDividerHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds1));
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
            if (this.aGd != null) {
                this.aGd.setSelection(i);
            }
        } else if (this.aGe != null) {
            this.aGe.setSelection(i);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aGe != null && this.aGe.getAdapter() != baseAdapter) {
            this.aGe.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aGd != null && this.aGd.getAdapter() != baseAdapter) {
            this.aGd.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aET = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.aGc.setText(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.enter_forum_two_column_display));
            this.aGc.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.aGc.setText(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.enter_forum_one_column_display));
        this.aGc.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        com.baidu.adp.lib.g.b.hr().inflate(getContext(), com.baidu.tieba.r.enter_forum_edit_view, this);
        setOrientation(1);
        this.aGc = (TextView) findViewById(com.baidu.tieba.q.forum_editor_column_display);
        findViewById(com.baidu.tieba.q.forum_editor_column_display_layout).setOnClickListener(new j(this));
        findViewById(com.baidu.tieba.q.forum_editor_sort_by_rank_layout).setOnClickListener(new k(this));
    }

    public void d(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        setBackgroundColor(ay.getColor(com.baidu.tieba.n.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            IF();
        }
    }
}
