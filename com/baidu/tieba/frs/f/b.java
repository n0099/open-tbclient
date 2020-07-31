package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> dVN;
    private Animation ieF;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.dVN = tbPageContext;
        this.ieF = AnimationUtils.loadAnimation(this.dVN.getPageActivity(), R.anim.frs_like);
    }
}
