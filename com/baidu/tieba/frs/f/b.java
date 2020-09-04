package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> efr;
    private Animation isR;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.efr = tbPageContext;
        this.isR = AnimationUtils.loadAnimation(this.efr.getPageActivity(), R.anim.frs_like);
    }
}
