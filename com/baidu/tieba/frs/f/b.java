package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> efn;
    private Animation isL;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.efn = tbPageContext;
        this.isL = AnimationUtils.loadAnimation(this.efn.getPageActivity(), R.anim.frs_like);
    }
}
