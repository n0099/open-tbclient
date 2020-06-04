package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> dIF;
    private Animation hLr;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.dIF = tbPageContext;
        this.hLr = AnimationUtils.loadAnimation(this.dIF.getPageActivity(), R.anim.frs_like);
    }
}
