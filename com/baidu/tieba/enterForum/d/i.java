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
    private ViewEventCenter aLU;
    private int aNd;
    private TextView aNe;
    private a aNf;
    private c aNg;
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
            if (this.aNf == null) {
                Jo();
            }
            if (this.aNf.getParent() == null) {
                addView(this.aNf);
            }
            removeView(this.aNg);
        } else {
            if (this.aNg == null) {
                Jn();
            }
            if (this.aNg.getParent() == null) {
                addView(this.aNg);
            }
            Jp();
            removeView(this.aNf);
        }
        setStateForDisplayView(i);
    }

    private void Jn() {
        this.aNg = new c(getContext());
        this.aNg.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aNg.setSelector(new ColorDrawable(0));
        a(this.aNg);
        Jp();
    }

    private void Jo() {
        this.aNf = new a(getContext());
        this.aNf.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aNf.setNumColumns(2);
        this.aNf.setPadding(this.aNd, 0, this.aNd, 0);
        this.aNf.setSelector(new ColorDrawable(0));
        a(this.aNf);
    }

    private void Jp() {
        this.aNg.setDivider(an.getDrawable(i.e.enter_forum_list_divider));
        this.aNg.setDividerHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds1));
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
            if (this.aNf != null) {
                this.aNf.setSelection(i);
            }
        } else if (this.aNg != null) {
            this.aNg.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.mType == 2) {
            if (this.aNf != null) {
                this.aNf.setSelection(i);
                this.aNf.setPadding(this.aNd, i2, this.aNd, 0);
                this.aNf.setOnTouchListener(new j(this));
            }
        } else if (this.aNg != null) {
            this.aNg.setSelectionFromTop(i, i2);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aNg != null && this.aNg.getAdapter() != baseAdapter) {
            this.aNg.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aNf != null && this.aNf.getAdapter() != baseAdapter) {
            this.aNf.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aLU = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.aNe.setText(TbadkCoreApplication.m411getInst().getString(i.h.enter_forum_two_column_display));
            this.aNe.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.aNe.setText(TbadkCoreApplication.m411getInst().getString(i.h.enter_forum_one_column_display));
        this.aNe.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.aNd = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds10);
        LayoutInflater.from(getContext()).inflate(i.g.enter_forum_edit_view, this);
        setOrientation(1);
        this.aNe = (TextView) findViewById(i.f.forum_editor_column_display);
        findViewById(i.f.forum_editor_column_display_layout).setOnClickListener(new k(this));
        findViewById(i.f.forum_editor_sort_by_rank_layout).setOnClickListener(new l(this));
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.h.a.a(tbPageContext, this);
        setBackgroundColor(an.getColor(i.c.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            Jp();
        }
    }
}
