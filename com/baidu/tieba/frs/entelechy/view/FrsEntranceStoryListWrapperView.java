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
    private HTypeListView aFS;
    private com.baidu.tieba.a.a aFT;
    private TbPageContext acd;
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
        this.mRootView = View.inflate(getContext(), d.h.entrance_story_pics_layout, this);
    }

    public void l(TbPageContext tbPageContext) {
        this.acd = tbPageContext;
        if (this.acd != null) {
            this.aFS = (HTypeListView) this.mRootView.findViewById(d.g.listview_story_pic);
            this.aFS.setSelector(d.f.transparent_bg);
            this.aFT = new com.baidu.tieba.a.a(this.acd, this.aFS);
        }
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.aFT != null) {
                this.aFT.notifyDataSetChanged();
            }
            aj.k(this.mRootView, d.C0082d.cp_bg_line_e);
            aj.k(this.aFS, d.C0082d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void b(List<com.baidu.adp.widget.ListView.f> list, String str, String str2) {
        com.baidu.tieba.story.l.brP().brS();
        if (v.w(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (this.aFT != null) {
            this.aFT.a(list, str, str2);
        }
    }

    public void setOnClick(View.OnClickListener onClickListener) {
        this.aFT.setItemOnclickListener(onClickListener);
    }
}
