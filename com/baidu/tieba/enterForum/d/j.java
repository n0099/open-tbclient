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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private ViewEventCenter aPL;
    private int bIl;
    private TextView bIm;
    private a bIn;
    private c bIo;
    private View bIp;
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
            if (this.bIn == null) {
                YI();
            }
            if (this.bIn.getParent() == null) {
                addView(this.bIn);
            }
            removeView(this.bIo);
        } else {
            if (this.bIo == null) {
                YH();
            }
            if (this.bIo.getParent() == null) {
                addView(this.bIo);
            }
            if (this.bIo.getFooterViewsCount() < 1 && TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                this.bIo.addFooterView(this.bIp);
            }
            YJ();
            removeView(this.bIn);
        }
        setStateForDisplayView(i);
    }

    private void YH() {
        this.bIo = new c(getContext());
        this.bIo.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.bIo.setSelector(new ColorDrawable(0));
        a(this.bIo);
        YJ();
    }

    private void YI() {
        this.bIn = new a(getContext());
        this.bIn.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.bIn.setNumColumns(2);
        this.bIn.setPadding(this.bIl, 0, this.bIl, 0);
        this.bIn.setSelector(new ColorDrawable(0));
        a(this.bIn);
    }

    private void YJ() {
        this.bIo.setDivider(av.getDrawable(r.f.enter_forum_list_divider));
        this.bIo.setDividerHeight(TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds1));
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
            if (this.bIn != null) {
                this.bIn.setSelection(i);
            }
        } else if (this.bIo != null) {
            this.bIo.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.mType == 2) {
            if (this.bIn != null) {
                this.bIn.setSelection(i);
                this.bIn.setPadding(this.bIl, 0, this.bIl, 0);
            }
        } else if (this.bIo != null) {
            this.bIo.setSelectionFromTop(i, i2);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.bIo != null && this.bIo.getAdapter() != baseAdapter) {
            this.bIo.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.bIn != null && this.bIn.getAdapter() != baseAdapter) {
            this.bIn.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aPL = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.bIm.setText(TbadkCoreApplication.m9getInst().getString(r.j.enter_forum_two_column_display));
            this.bIm.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(r.f.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.bIm.setText(TbadkCoreApplication.m9getInst().getString(r.j.enter_forum_one_column_display));
        this.bIm.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(r.f.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.bIl = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds10);
        LayoutInflater.from(getContext()).inflate(r.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.bIm = (TextView) findViewById(r.g.forum_editor_column_display);
        findViewById(r.g.forum_editor_column_display_layout).setOnClickListener(new k(this));
        findViewById(r.g.forum_editor_sort_by_rank_layout).setOnClickListener(new l(this));
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.e(getContext(), r.e.ds150));
        this.bIp = new View(getContext());
        this.bIp.setLayoutParams(layoutParams);
    }

    public void q(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this);
        setBackgroundColor(av.getColor(r.d.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            YJ();
        }
    }
}
