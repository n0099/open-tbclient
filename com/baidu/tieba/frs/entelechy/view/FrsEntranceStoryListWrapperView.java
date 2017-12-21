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
    private HTypeListView aFZ;
    private com.baidu.tieba.a.a aGa;
    private TbPageContext aca;
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
        this.aca = tbPageContext;
        if (this.aca != null) {
            this.aFZ = (HTypeListView) this.mRootView.findViewById(d.g.listview_story_pic);
            this.aFZ.setSelector(d.f.transparent_bg);
            this.aGa = new com.baidu.tieba.a.a(this.aca, this.aFZ);
        }
    }

    public void changeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.aGa != null) {
                this.aGa.notifyDataSetChanged();
            }
            aj.k(this.mRootView, d.C0095d.cp_bg_line_e);
            aj.k(this.aFZ, d.C0095d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void b(List<com.baidu.adp.widget.ListView.f> list, String str, String str2) {
        com.baidu.tieba.story.l.bsv().bsy();
        if (v.w(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (this.aGa != null) {
            this.aGa.a(list, str, str2);
        }
    }

    public void setOnClick(View.OnClickListener onClickListener) {
        this.aGa.setItemOnclickListener(onClickListener);
    }
}
