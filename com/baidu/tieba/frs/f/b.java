package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> ceu;
    private Animation fRz;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.ceu = tbPageContext;
        this.fRz = AnimationUtils.loadAnimation(this.ceu.getPageActivity(), R.anim.frs_like);
    }
}
