package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> cVg;
    private Animation gKY;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.cVg = tbPageContext;
        this.gKY = AnimationUtils.loadAnimation(this.cVg.getPageActivity(), R.anim.frs_like);
    }
}
