package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> duG;
    private Animation hvL;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.duG = tbPageContext;
        this.hvL = AnimationUtils.loadAnimation(this.duG.getPageActivity(), R.anim.frs_like);
    }
}
