package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> cfl;
    private Animation fSq;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.cfl = tbPageContext;
        this.fSq = AnimationUtils.loadAnimation(this.cfl.getPageActivity(), R.anim.frs_like);
    }
}
