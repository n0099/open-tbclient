package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> aca;
    private Animation cZW;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.aca = tbPageContext;
        this.cZW = AnimationUtils.loadAnimation(this.aca.getPageActivity(), d.a.frs_like);
    }
}
