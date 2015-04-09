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
    private ViewEventCenter aCS;
    private TextView aDZ;
    private a aEa;
    private c aEb;
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
            if (this.aEa == null) {
                HE();
            }
            if (this.aEa.getParent() == null) {
                addView(this.aEa);
            }
            removeView(this.aEb);
        } else {
            if (this.aEb == null) {
                HD();
            }
            if (this.aEb.getParent() == null) {
                addView(this.aEb);
            }
            HF();
            removeView(this.aEa);
        }
        setStateForDisplayView(i);
    }

    private void HD() {
        this.aEb = new c(getContext());
        this.aEb.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aEb.setSelector(new ColorDrawable(0));
        a(this.aEb);
        HF();
    }

    private void HE() {
        this.aEa = new a(getContext());
        this.aEa.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.aEa.setNumColumns(2);
        this.aEa.setPadding(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10), 0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds10), 0);
        this.aEa.setSelector(new ColorDrawable(0));
        a(this.aEa);
    }

    private void HF() {
        this.aEb.setDivider(ba.getDrawable(com.baidu.tieba.u.enter_forum_list_divider));
        this.aEb.setDividerHeight(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds1));
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
            if (this.aEa != null) {
                this.aEa.setSelection(i);
            }
        } else if (this.aEb != null) {
            this.aEb.setSelection(i);
        }
    }

    public void setListAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aEb != null && this.aEb.getAdapter() != baseAdapter) {
            this.aEb.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.aEa != null && this.aEa.getAdapter() != baseAdapter) {
            this.aEa.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aCS = viewEventCenter;
    }

    private void setStateForDisplayView(int i) {
        if (i == 1) {
            this.aDZ.setText(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.enter_forum_two_column_display));
            this.aDZ.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_sort_suolue), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.aDZ.setText(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.enter_forum_one_column_display));
        this.aDZ.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_sort_shitu), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        com.baidu.adp.lib.g.b.hH().inflate(getContext(), com.baidu.tieba.w.enter_forum_edit_view, this);
        setOrientation(1);
        this.aDZ = (TextView) findViewById(com.baidu.tieba.v.forum_editor_column_display);
        findViewById(com.baidu.tieba.v.forum_editor_column_display_layout).setOnClickListener(new j(this));
        findViewById(com.baidu.tieba.v.forum_editor_sort_by_rank_layout).setOnClickListener(new k(this));
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        setBackgroundColor(ba.getColor(com.baidu.tieba.s.cp_bg_line_d));
        setStateForDisplayView(this.mType);
        if (this.mType == 1) {
            HF();
        }
    }
}
