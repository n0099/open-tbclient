package com.baidu.tieba.frs.d;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> eSJ;
    private Animation jDy;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.eSJ = tbPageContext;
        this.jDy = AnimationUtils.loadAnimation(this.eSJ.getPageActivity(), R.anim.frs_like);
    }
}
