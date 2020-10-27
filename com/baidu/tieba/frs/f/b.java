package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> eCn;
    private Animation jbw;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.eCn = tbPageContext;
        this.jbw = AnimationUtils.loadAnimation(this.eCn.getPageActivity(), R.anim.frs_like);
    }
}
