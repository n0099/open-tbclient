package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.List;
/* loaded from: classes.dex */
public class FrsEntranceStoryListWrapperView extends LinearLayout {
    private HTypeListView aEM;
    private com.baidu.tieba.a.a aEN;
    private TbPageContext aaS;
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

    public void p(TbPageContext tbPageContext) {
        this.aaS = tbPageContext;
        if (this.aaS != null) {
            this.aEM = (HTypeListView) this.mRootView.findViewById(d.h.listview_story_pic);
            this.aEM.setSelector(d.g.transparent_bg);
            this.aEN = new com.baidu.tieba.a.a(this.aaS, this.aEM);
        }
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.aEN != null) {
                this.aEN.notifyDataSetChanged();
            }
            ai.k(this.mRootView, d.e.cp_bg_line_e);
            ai.k(this.aEM, d.e.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void b(List<com.baidu.adp.widget.ListView.f> list, String str, String str2) {
        com.baidu.tieba.story.l.bnY().boa();
        if (u.v(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (this.aEN != null) {
            this.aEN.a(list, str, str2);
        }
    }

    public void setOnClick(View.OnClickListener onClickListener) {
        this.aEN.setItemOnclickListener(onClickListener);
    }
}
