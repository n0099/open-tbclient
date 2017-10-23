package com.baidu.tbadk.i;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageViewGroup;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends j.a {
    public HeadImageViewGroup aEx;
    private f aEy;
    public TextView mName;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public a(View view) {
        super(view);
        this.mSkinType = 3;
        View findViewById = view.findViewById(d.h.add_pic_root);
        this.mName = (TextView) findViewById.findViewById(d.h.name_tv);
        this.aEx = (HeadImageViewGroup) findViewById.findViewById(d.h.img);
    }

    public void c(f fVar) {
        if (fVar instanceof com.baidu.tbadk.data.c) {
            this.aEy = fVar;
            this.aEx.getInnerImg().setIsRound(true);
            this.aEx.getInnerImg().setVisibility(0);
            this.aEx.getInnerImg().setTag(null);
            this.aEx.getInnerImg().setImageResource(d.g.btn_story_release);
            this.aEx.setOuterColor(d.e.cp_link_tip_g);
            this.mName.setText(((com.baidu.tbadk.data.c) fVar).getName());
            this.aEx.setOnClickListener(this.mOnClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.c(this.mName, d.e.cp_cont_f, 1);
            this.aEx.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public void setOnClick(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
