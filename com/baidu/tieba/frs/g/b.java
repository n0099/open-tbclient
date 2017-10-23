package com.baidu.tieba.frs.g;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> abm;
    private Animation cGK;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.abm = tbPageContext;
        this.cGK = AnimationUtils.loadAnimation(this.abm.getPageActivity(), d.a.frs_like);
    }
}
