package com.baidu.tieba.enterForum.view;

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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private ViewEventCenter bfx;
    private int buH;
    private TextView buI;
    private a buJ;
    private c buK;
    private View buL;
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
            if (this.buJ == null) {
                SZ();
            }
            if (this.buJ.getParent() == null) {
                addView(this.buJ);
            }
            removeView(this.buK);
        } else {
            if (this.buK == null) {
                SY();
            }
            if (this.buK.getParent() == null) {
                addView(this.buK);
            }
            if (this.buK.getFooterViewsCount() < 1 && TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                this.buK.addFooterView(this.buL);
            }
            Ta();
            removeView(this.buJ);
        }
        setStateForDisplayView(i);
    }

    private void SY() {
        this.buK = new c(getContext());
        this.buK.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.buK.setSelector(new ColorDrawable(0));
        a(this.buK);
        Ta();
    }

    private void SZ() {
        this.buJ = new a(getContext());
        this.buJ.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.buJ.setNumColumns(2);
        this.buJ.setPadding(this.buH, 0, this.buH, 0);
        this.buJ.setSelector(new ColorDrawable(0));
        a(this.buJ);
    }

    private void Ta() {
        this.buK.setDivider(av.getDrawable(u.f.enter_forum_list_divider));
        this.buK.setDividerHeight(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds1));
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
            if (this.buJ != null) {
                this.buJ.setSelection(i);
            }
        } else if (this.buK != null) {
            this.buK.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.mType == 2) {
            if (this.buJ != null) {
                this.buJ.setSelection(i);
                this.buJ.setPadding(this.buH, 0, this.buH, 0);
            }
        } else if (this.buK != null) {
            this.buK.setSelectionFromTop(i, i2);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.buK != null && this.buK.getAdapter() != baseAdapter) {
            this.buK.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.buJ != null && this.buJ.getAdapter() != baseAdapter) {
            this.buJ.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bfx = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.buI.setText(TbadkCoreApplication.m9getInst().getString(u.j.enter_forum_two_column_display));
            this.buI.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.buI.setText(TbadkCoreApplication.m9getInst().getString(u.j.enter_forum_one_column_display));
        this.buI.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.buH = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds10);
        LayoutInflater.from(getContext()).inflate(u.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.buI = (TextView) findViewById(u.g.forum_editor_column_display);
        findViewById(u.g.forum_editor_column_display_layout).setOnClickListener(new k(this));
        findViewById(u.g.forum_editor_sort_by_rank_layout).setOnClickListener(new l(this));
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.c(getContext(), u.e.ds150));
        this.buL = new View(getContext());
        this.buL.setLayoutParams(layoutParams);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.j.a.a(tbPageContext, this);
        setBackgroundColor(av.getColor(u.d.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            Ta();
        }
    }
}
