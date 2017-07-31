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
    private HTypeListView aGc;
    private com.baidu.tieba.a.a aGd;
    private TbPageContext acp;
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
        this.acp = tbPageContext;
        if (this.acp != null) {
            this.aGc = (HTypeListView) this.mRootView.findViewById(d.h.listview_story_pic);
            this.aGc.setSelector(d.g.transparent_bg);
            this.aGd = new com.baidu.tieba.a.a(this.acp, this.aGc);
        }
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.aGd != null) {
                this.aGd.notifyDataSetChanged();
            }
            ai.k(this.mRootView, d.e.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    public void b(List<com.baidu.adp.widget.ListView.f> list, String str, String str2) {
        com.baidu.tieba.story.l.boh().boj();
        if (u.v(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (this.aGd != null) {
            this.aGd.a(list, str, str2);
        }
    }

    public void setOnClick(View.OnClickListener onClickListener) {
        this.aGd.setItemOnclickListener(onClickListener);
    }
}
