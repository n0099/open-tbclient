package com.baidu.tieba.frs.d;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> eWx;
    private Animation jKZ;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.eWx = tbPageContext;
        this.jKZ = AnimationUtils.loadAnimation(this.eWx.getPageActivity(), R.anim.frs_like);
    }
}
