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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class i extends LinearLayout {
    private ViewEventCenter aLM;
    private int aMV;
    private TextView aMW;
    private a aMX;
    private c aMY;
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
            if (this.aMX == null) {
                Jc();
            }
            if (this.aMX.getParent() == null) {
                addView(this.aMX);
            }
            removeView(this.aMY);
        } else {
            if (this.aMY == null) {
                Jb();
            }
            if (this.aMY.getParent() == null) {
                addView(this.aMY);
            }
            Jd();
            removeView(this.aMX);
        }
        setStateForDisplayView(i);
    }

    private void Jb() {
        this.aMY = new c(getContext());
        this.aMY.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aMY.setSelector(new ColorDrawable(0));
        a(this.aMY);
        Jd();
    }

    private void Jc() {
        this.aMX = new a(getContext());
        this.aMX.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aMX.setNumColumns(2);
        this.aMX.setPadding(this.aMV, 0, this.aMV, 0);
        this.aMX.setSelector(new ColorDrawable(0));
        a(this.aMX);
    }

    private void Jd() {
        this.aMY.setDivider(an.getDrawable(i.e.enter_forum_list_divider));
        this.aMY.setDividerHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds1));
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
            if (this.aMX != null) {
                this.aMX.setSelection(i);
            }
        } else if (this.aMY != null) {
            this.aMY.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.mType == 2) {
            if (this.aMX != null) {
                this.aMX.setSelection(i);
                this.aMX.setPadding(this.aMV, i2, this.aMV, 0);
                this.aMX.setOnTouchListener(new j(this));
            }
        } else if (this.aMY != null) {
            this.aMY.setSelectionFromTop(i, i2);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aMY != null && this.aMY.getAdapter() != baseAdapter) {
            this.aMY.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aMX != null && this.aMX.getAdapter() != baseAdapter) {
            this.aMX.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aLM = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.aMW.setText(TbadkCoreApplication.m411getInst().getString(i.h.enter_forum_two_column_display));
            this.aMW.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.aMW.setText(TbadkCoreApplication.m411getInst().getString(i.h.enter_forum_one_column_display));
        this.aMW.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.aMV = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds10);
        LayoutInflater.from(getContext()).inflate(i.g.enter_forum_edit_view, this);
        setOrientation(1);
        this.aMW = (TextView) findViewById(i.f.forum_editor_column_display);
        findViewById(i.f.forum_editor_column_display_layout).setOnClickListener(new k(this));
        findViewById(i.f.forum_editor_sort_by_rank_layout).setOnClickListener(new l(this));
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.h.a.a(tbPageContext, this);
        setBackgroundColor(an.getColor(i.c.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            Jd();
        }
    }
}
