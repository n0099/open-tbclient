package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> acr;
    private Animation cyI;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.acr = tbPageContext;
        this.cyI = AnimationUtils.loadAnimation(this.acr.getPageActivity(), d.a.frs_like);
    }
}
