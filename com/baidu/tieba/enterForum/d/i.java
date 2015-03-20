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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class i extends LinearLayout {
    private ViewEventCenter aCK;
    private TextView aDR;
    private a aDS;
    private c aDT;
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
            if (this.aDS == null) {
                Hy();
            }
            if (this.aDS.getParent() == null) {
                addView(this.aDS);
            }
            removeView(this.aDT);
        } else {
            if (this.aDT == null) {
                Hx();
            }
            if (this.aDT.getParent() == null) {
                addView(this.aDT);
            }
            Hz();
            removeView(this.aDS);
        }
        setStateForDisplayView(i);
    }

    private void Hx() {
        this.aDT = new c(getContext());
        this.aDT.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aDT.setSelector(new ColorDrawable(0));
        a(this.aDT);
        Hz();
    }

    private void Hy() {
        this.aDS = new a(getContext());
        this.aDS.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aDS.setNumColumns(2);
        this.aDS.setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10), 0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10), 0);
        this.aDS.setSelector(new ColorDrawable(0));
        a(this.aDS);
    }

    private void Hz() {
        this.aDT.setDivider(ba.getDrawable(com.baidu.tieba.u.enter_forum_list_divider));
        this.aDT.setDividerHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds1));
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
            if (this.aDS != null) {
                this.aDS.setSelection(i);
            }
        } else if (this.aDT != null) {
            this.aDT.setSelection(i);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aDT != null && this.aDT.getAdapter() != baseAdapter) {
            this.aDT.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aDS != null && this.aDS.getAdapter() != baseAdapter) {
            this.aDS.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aCK = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.aDR.setText(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.enter_forum_two_column_display));
            this.aDR.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.aDR.setText(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.enter_forum_one_column_display));
        this.aDR.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        com.baidu.adp.lib.g.b.hH().inflate(getContext(), com.baidu.tieba.w.enter_forum_edit_view, this);
        setOrientation(1);
        this.aDR = (TextView) findViewById(com.baidu.tieba.v.forum_editor_column_display);
        findViewById(com.baidu.tieba.v.forum_editor_column_display_layout).setOnClickListener(new j(this));
        findViewById(com.baidu.tieba.v.forum_editor_sort_by_rank_layout).setOnClickListener(new k(this));
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        setBackgroundColor(ba.getColor(com.baidu.tieba.s.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            Hz();
        }
    }
}
