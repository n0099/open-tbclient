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
    public HeadImageViewGroup aFW;
    private f aFX;
    public TextView mName;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public a(View view) {
        super(view);
        this.mSkinType = 3;
        View findViewById = view.findViewById(d.g.add_pic_root);
        this.mName = (TextView) findViewById.findViewById(d.g.name_tv);
        this.aFW = (HeadImageViewGroup) findViewById.findViewById(d.g.img);
    }

    public void c(f fVar) {
        if (fVar instanceof com.baidu.tbadk.data.c) {
            this.aFX = fVar;
            this.aFW.getInnerImg().setIsRound(true);
            this.aFW.getInnerImg().setVisibility(0);
            this.aFW.getInnerImg().setTag(null);
            this.aFW.getInnerImg().setImageResource(d.f.btn_story_release);
            this.aFW.setOuterColor(d.C0095d.cp_link_tip_g);
            this.mName.setText(((com.baidu.tbadk.data.c) fVar).getName());
            this.aFW.setOnClickListener(this.mOnClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.c(this.mName, d.C0095d.cp_cont_f, 1);
            this.aFW.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public void setOnClick(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
