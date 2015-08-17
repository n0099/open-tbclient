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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class i extends LinearLayout {
    private ViewEventCenter aMt;
    private TextView aND;
    private a aNE;
    private c aNF;
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
            if (this.aNE == null) {
                Jt();
            }
            if (this.aNE.getParent() == null) {
                addView(this.aNE);
            }
            removeView(this.aNF);
        } else {
            if (this.aNF == null) {
                Js();
            }
            if (this.aNF.getParent() == null) {
                addView(this.aNF);
            }
            Ju();
            removeView(this.aNE);
        }
        setStateForDisplayView(i);
    }

    private void Js() {
        this.aNF = new c(getContext());
        this.aNF.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aNF.setSelector(new ColorDrawable(0));
        a(this.aNF);
        Ju();
    }

    private void Jt() {
        this.aNE = new a(getContext());
        this.aNE.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aNE.setNumColumns(2);
        this.aNE.setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds10), 0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds10), 0);
        this.aNE.setSelector(new ColorDrawable(0));
        a(this.aNE);
    }

    private void Ju() {
        this.aNF.setDivider(al.getDrawable(i.e.enter_forum_list_divider));
        this.aNF.setDividerHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds1));
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
            if (this.aNE != null) {
                this.aNE.setSelection(i);
            }
        } else if (this.aNF != null) {
            this.aNF.setSelection(i);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aNF != null && this.aNF.getAdapter() != baseAdapter) {
            this.aNF.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aNE != null && this.aNE.getAdapter() != baseAdapter) {
            this.aNE.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aMt = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.aND.setText(TbadkCoreApplication.m411getInst().getString(i.C0057i.enter_forum_two_column_display));
            this.aND.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.aND.setText(TbadkCoreApplication.m411getInst().getString(i.C0057i.enter_forum_one_column_display));
        this.aND.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(i.g.enter_forum_edit_view, this);
        setOrientation(1);
        this.aND = (TextView) findViewById(i.f.forum_editor_column_display);
        findViewById(i.f.forum_editor_column_display_layout).setOnClickListener(new j(this));
        findViewById(i.f.forum_editor_sort_by_rank_layout).setOnClickListener(new k(this));
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        setBackgroundColor(al.getColor(i.c.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            Ju();
        }
    }
}
