package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> abI;
    private Animation cPX;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.abI = tbPageContext;
        this.cPX = AnimationUtils.loadAnimation(this.abI.getPageActivity(), d.a.frs_like);
    }
}
