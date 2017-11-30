package com.baidu.tbadk.i;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageViewGroup;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends j.a {
    public HeadImageViewGroup aFU;
    public TextView mName;
    public View mRootView;
    private int mSkinType;
    private int mStatus;

    public e(View view) {
        super(view);
        this.mSkinType = 3;
        this.mStatus = 0;
        this.mRootView = view.findViewById(d.g.rootview);
        this.mName = (TextView) view.findViewById(d.g.name_txt);
        this.aFU = (HeadImageViewGroup) view.findViewById(d.g.img_group);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            Ew();
            this.aFU.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public void setStatus(int i) {
        this.mStatus = i;
        Ew();
    }

    private void Ew() {
        switch (this.mStatus) {
            case 0:
                aj.c(this.mName, d.C0082d.cp_cont_f, 1);
                return;
            case 1:
            default:
                aj.c(this.mName, d.C0082d.cp_cont_f, 1);
                return;
            case 2:
                aj.c(this.mName, d.C0082d.cp_cont_d, 1);
                return;
            case 3:
                aj.c(this.mName, d.C0082d.cp_cont_r, 1);
                return;
        }
    }
}
