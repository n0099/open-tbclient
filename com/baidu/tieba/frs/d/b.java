package com.baidu.tieba.frs.d;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> eUY;
    private Animation jJq;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.eUY = tbPageContext;
        this.jJq = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.frs_like);
    }
}
