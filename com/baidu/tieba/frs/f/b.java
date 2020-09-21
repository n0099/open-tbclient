package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> ehG;
    private Animation iAh;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.ehG = tbPageContext;
        this.iAh = AnimationUtils.loadAnimation(this.ehG.getPageActivity(), R.anim.frs_like);
    }
}
