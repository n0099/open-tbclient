package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.List;
/* loaded from: classes.dex */
public class FrsEntranceStoryListWrapperView extends LinearLayout {
    private com.baidu.tieba.a.a aEA;
    private HTypeListView aEz;
    private TbPageContext abm;
    private View mRootView;
    private int mSkinType;

    public FrsEntranceStoryListWrapperView(Context context) {
        this(context, null);
    }

    public FrsEntranceStoryListWrapperView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsEntranceStoryListWrapperView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.mRootView = View.inflate(getContext(), d.j.entrance_story_pics_layout, this);
    }

    public void m(TbPageContext tbPageContext) {
        this.abm = tbPageContext;
        if (this.abm != null) {
            this.aEz = (HTypeListView) this.mRootView.findViewById(d.h.listview_story_pic);
            this.aEz.setSelector(d.g.transparent_bg);
            this.aEA = new com.baidu.tieba.a.a(this.abm, this.aEz);
        }
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.aEA != null) {
                this.aEA.notifyDataSetChanged();
            }
            aj.k(this.mRootView, d.e.cp_bg_line_e);
            aj.k(this.aEz, d.e.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void b(List<com.baidu.adp.widget.ListView.f> list, String str, String str2) {
        com.baidu.tieba.story.l.bmR().bmU();
        if (v.u(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (this.aEA != null) {
            this.aEA.a(list, str, str2);
        }
    }

    public void setOnClick(View.OnClickListener onClickListener) {
        this.aEA.setItemOnclickListener(onClickListener);
    }
}
