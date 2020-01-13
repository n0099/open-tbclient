package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> cRe;
    private Animation gIZ;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.cRe = tbPageContext;
        this.gIZ = AnimationUtils.loadAnimation(this.cRe.getPageActivity(), R.anim.frs_like);
    }
}
