package com.baidu.tieba.enterForum.b;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends LinearLayout {
    private LinearLayout clD;
    private ViewEventCenter doV;
    private int drk;
    private TextView drl;
    private TextView drm;
    private ImageView drn;
    private a dro;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void arh() {
        if (this.dro == null) {
            ari();
        }
        if (this.dro.getParent() == null) {
            addView(this.dro);
        }
    }

    private void ari() {
        this.dro = new a(getContext());
        this.dro.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.dro.setNumColumns(2);
        this.dro.setPadding(this.drk, 0, this.drk, 0);
        this.dro.setSelector(new ColorDrawable(0));
        this.dro.setCacheColorHint(0);
        this.dro.setFadingEdgeLength(0);
        this.dro.setFocusable(false);
        this.dro.setFocusableInTouchMode(false);
        this.dro.setVerticalScrollBarEnabled(false);
    }

    public void setSelectionFromTop(int i, int i2) {
        if (this.dro != null) {
            this.dro.setSelection(i);
            this.dro.setPadding(this.drk, 0, this.drk, 0);
        }
    }

    public void setGridAdapterIfNeeded(BaseAdapter baseAdapter) {
        if (this.dro != null && this.dro.getAdapter() != baseAdapter) {
            this.dro.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.doV = viewEventCenter;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.drk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds44);
        LayoutInflater.from(getContext()).inflate(d.h.enter_forum_edit_view, this);
        setOrientation(1);
        this.clD = (LinearLayout) findViewById(d.g.search_container);
        this.clD.setVisibility(0);
        this.drl = (TextView) findViewById(d.g.view_edit_forum_ok);
        this.drl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.doV != null) {
                    d.this.doV.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
                }
            }
        });
        this.drm = (TextView) findViewById(d.g.search_text);
        this.drn = (ImageView) findViewById(d.g.search_icon);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.n.a.a(tbPageContext, this);
        setBackgroundColor(aj.getColor(d.C0140d.cp_bg_line_d));
        aj.c(this.drn, d.f.icon_input_seach);
        aj.r(this.drm, d.C0140d.enter_forum_search_text_color);
        aj.s(this.clD, d.f.enter_forum_search_frame);
    }
}
