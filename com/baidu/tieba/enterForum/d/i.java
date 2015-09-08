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
    private ViewEventCenter aMG;
    private TextView aNQ;
    private a aNR;
    private c aNS;
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
            if (this.aNR == null) {
                Jh();
            }
            if (this.aNR.getParent() == null) {
                addView(this.aNR);
            }
            removeView(this.aNS);
        } else {
            if (this.aNS == null) {
                Jg();
            }
            if (this.aNS.getParent() == null) {
                addView(this.aNS);
            }
            Ji();
            removeView(this.aNR);
        }
        setStateForDisplayView(i);
    }

    private void Jg() {
        this.aNS = new c(getContext());
        this.aNS.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aNS.setSelector(new ColorDrawable(0));
        a(this.aNS);
        Ji();
    }

    private void Jh() {
        this.aNR = new a(getContext());
        this.aNR.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aNR.setNumColumns(2);
        this.aNR.setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds10), 0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds10), 0);
        this.aNR.setSelector(new ColorDrawable(0));
        a(this.aNR);
    }

    private void Ji() {
        this.aNS.setDivider(al.getDrawable(i.e.enter_forum_list_divider));
        this.aNS.setDividerHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds1));
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
            if (this.aNR != null) {
                this.aNR.setSelection(i);
            }
        } else if (this.aNS != null) {
            this.aNS.setSelection(i);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aNS != null && this.aNS.getAdapter() != baseAdapter) {
            this.aNS.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aNR != null && this.aNR.getAdapter() != baseAdapter) {
            this.aNR.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aMG = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.aNQ.setText(TbadkCoreApplication.m411getInst().getString(i.h.enter_forum_two_column_display));
            this.aNQ.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.aNQ.setText(TbadkCoreApplication.m411getInst().getString(i.h.enter_forum_one_column_display));
        this.aNQ.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(i.g.enter_forum_edit_view, this);
        setOrientation(1);
        this.aNQ = (TextView) findViewById(i.f.forum_editor_column_display);
        findViewById(i.f.forum_editor_column_display_layout).setOnClickListener(new j(this));
        findViewById(i.f.forum_editor_sort_by_rank_layout).setOnClickListener(new k(this));
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.h.a.a(tbPageContext, this);
        setBackgroundColor(al.getColor(i.c.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            Ji();
        }
    }
}
