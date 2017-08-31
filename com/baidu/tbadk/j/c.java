package com.baidu.tbadk.j;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageViewGroup;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends j.a {
    public HeadImageViewGroup aFy;
    public TextView mName;
    public View mRootView;
    private int mSkinType;
    private int mStatus;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.mStatus = 0;
        this.mRootView = view.findViewById(d.h.rootview);
        this.mName = (TextView) view.findViewById(d.h.name_txt);
        this.aFy = (HeadImageViewGroup) view.findViewById(d.h.img_group);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            Et();
            this.aFy.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public void setStatus(int i) {
        this.mStatus = i;
        Et();
    }

    private void Et() {
        switch (this.mStatus) {
            case 0:
                aj.c(this.mName, d.e.cp_cont_f, 1);
                return;
            case 1:
            default:
                aj.c(this.mName, d.e.cp_cont_f, 1);
                return;
            case 2:
                aj.c(this.mName, d.e.cp_cont_d, 1);
                return;
            case 3:
                aj.c(this.mName, d.e.cp_cont_r, 1);
                return;
        }
    }
}
