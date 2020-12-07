package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> eNx;
    private Animation jvH;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.eNx = tbPageContext;
        this.jvH = AnimationUtils.loadAnimation(this.eNx.getPageActivity(), R.anim.frs_like);
    }
}
