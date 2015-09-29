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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class i extends LinearLayout {
    private ViewEventCenter aLB;
    private int aMK;
    private TextView aML;
    private a aMM;
    private c aMN;
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
            if (this.aMM == null) {
                Jc();
            }
            if (this.aMM.getParent() == null) {
                addView(this.aMM);
            }
            removeView(this.aMN);
        } else {
            if (this.aMN == null) {
                Jb();
            }
            if (this.aMN.getParent() == null) {
                addView(this.aMN);
            }
            Jd();
            removeView(this.aMM);
        }
        setStateForDisplayView(i);
    }

    private void Jb() {
        this.aMN = new c(getContext());
        this.aMN.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aMN.setSelector(new ColorDrawable(0));
        a(this.aMN);
        Jd();
    }

    private void Jc() {
        this.aMM = new a(getContext());
        this.aMM.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aMM.setNumColumns(2);
        this.aMM.setPadding(this.aMK, 0, this.aMK, 0);
        this.aMM.setSelector(new ColorDrawable(0));
        a(this.aMM);
    }

    private void Jd() {
        this.aMN.setDivider(am.getDrawable(i.e.enter_forum_list_divider));
        this.aMN.setDividerHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds1));
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
            if (this.aMM != null) {
                this.aMM.setSelection(i);
            }
        } else if (this.aMN != null) {
            this.aMN.setSelection(i);
        }
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.mType == 2) {
            if (this.aMM != null) {
                this.aMM.setSelection(i);
                this.aMM.setPadding(this.aMK, i2, this.aMK, 0);
                this.aMM.setOnTouchListener(new j(this));
            }
        } else if (this.aMN != null) {
            this.aMN.setSelectionFromTop(i, i2);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aMN != null && this.aMN.getAdapter() != baseAdapter) {
            this.aMN.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aMM != null && this.aMM.getAdapter() != baseAdapter) {
            this.aMM.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aLB = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.aML.setText(TbadkCoreApplication.m411getInst().getString(i.h.enter_forum_two_column_display));
            this.aML.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.aML.setText(TbadkCoreApplication.m411getInst().getString(i.h.enter_forum_one_column_display));
        this.aML.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.aMK = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds10);
        LayoutInflater.from(getContext()).inflate(i.g.enter_forum_edit_view, this);
        setOrientation(1);
        this.aML = (TextView) findViewById(i.f.forum_editor_column_display);
        findViewById(i.f.forum_editor_column_display_layout).setOnClickListener(new k(this));
        findViewById(i.f.forum_editor_sort_by_rank_layout).setOnClickListener(new l(this));
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.h.a.a(tbPageContext, this);
        setBackgroundColor(am.getColor(i.c.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            Jd();
        }
    }
}
