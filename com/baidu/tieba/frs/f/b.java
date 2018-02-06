package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> aRR;
    private Animation dUx;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.aRR = tbPageContext;
        this.dUx = AnimationUtils.loadAnimation(this.aRR.getPageActivity(), d.a.frs_like);
    }
}
