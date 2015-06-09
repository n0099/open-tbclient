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
    private ViewEventCenter aEU;
    private TextView aGd;
    private a aGe;
    private c aGf;
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
            if (this.aGe == null) {
                IF();
            }
            if (this.aGe.getParent() == null) {
                addView(this.aGe);
            }
            removeView(this.aGf);
        } else {
            if (this.aGf == null) {
                IE();
            }
            if (this.aGf.getParent() == null) {
                addView(this.aGf);
            }
            IG();
            removeView(this.aGe);
        }
        setStateForDisplayView(i);
    }

    private void IE() {
        this.aGf = new c(getContext());
        this.aGf.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aGf.setSelector(new ColorDrawable(0));
        a(this.aGf);
        IG();
    }

    private void IF() {
        this.aGe = new a(getContext());
        this.aGe.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aGe.setNumColumns(2);
        this.aGe.setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds10), 0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds10), 0);
        this.aGe.setSelector(new ColorDrawable(0));
        a(this.aGe);
    }

    private void IG() {
        this.aGf.setDivider(ay.getDrawable(com.baidu.tieba.p.enter_forum_list_divider));
        this.aGf.setDividerHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds1));
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
            if (this.aGe != null) {
                this.aGe.setSelection(i);
            }
        } else if (this.aGf != null) {
            this.aGf.setSelection(i);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aGf != null && this.aGf.getAdapter() != baseAdapter) {
            this.aGf.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aGe != null && this.aGe.getAdapter() != baseAdapter) {
            this.aGe.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aEU = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.aGd.setText(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.enter_forum_two_column_display));
            this.aGd.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.aGd.setText(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.enter_forum_one_column_display));
        this.aGd.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        com.baidu.adp.lib.g.b.hr().inflate(getContext(), com.baidu.tieba.r.enter_forum_edit_view, this);
        setOrientation(1);
        this.aGd = (TextView) findViewById(com.baidu.tieba.q.forum_editor_column_display);
        findViewById(com.baidu.tieba.q.forum_editor_column_display_layout).setOnClickListener(new j(this));
        findViewById(com.baidu.tieba.q.forum_editor_sort_by_rank_layout).setOnClickListener(new k(this));
    }

    public void d(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        setBackgroundColor(ay.getColor(com.baidu.tieba.n.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            IG();
        }
    }
}
