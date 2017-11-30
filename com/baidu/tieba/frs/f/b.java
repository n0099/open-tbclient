package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> acd;
    private Animation cZG;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.acd = tbPageContext;
        this.cZG = AnimationUtils.loadAnimation(this.acd.getPageActivity(), d.a.frs_like);
    }
}
