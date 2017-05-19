package com.baidu.tieba.frs.d;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> aat;
    private Animation bZU;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.aat = tbPageContext;
        this.bZU = AnimationUtils.loadAnimation(this.aat.getPageActivity(), w.a.frs_like);
    }
}
