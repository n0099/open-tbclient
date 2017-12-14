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
    public HeadImageViewGroup aFT;
    private f aFU;
    public TextView mName;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public a(View view) {
        super(view);
        this.mSkinType = 3;
        View findViewById = view.findViewById(d.g.add_pic_root);
        this.mName = (TextView) findViewById.findViewById(d.g.name_tv);
        this.aFT = (HeadImageViewGroup) findViewById.findViewById(d.g.img);
    }

    public void c(f fVar) {
        if (fVar instanceof com.baidu.tbadk.data.c) {
            this.aFU = fVar;
            this.aFT.getInnerImg().setIsRound(true);
            this.aFT.getInnerImg().setVisibility(0);
            this.aFT.getInnerImg().setTag(null);
            this.aFT.getInnerImg().setImageResource(d.f.btn_story_release);
            this.aFT.setOuterColor(d.C0096d.cp_link_tip_g);
            this.mName.setText(((com.baidu.tbadk.data.c) fVar).getName());
            this.aFT.setOnClickListener(this.mOnClickListener);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.c(this.mName, d.C0096d.cp_cont_f, 1);
            this.aFT.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public void setOnClick(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
