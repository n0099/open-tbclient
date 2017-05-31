package com.baidu.tieba.frs.e;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> aas;
    private Animation cgg;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.aas = tbPageContext;
        this.cgg = AnimationUtils.loadAnimation(this.aas.getPageActivity(), w.a.frs_like);
    }
}
