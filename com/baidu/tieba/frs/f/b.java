package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> cQU;
    private Animation gFK;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.cQU = tbPageContext;
        this.gFK = AnimationUtils.loadAnimation(this.cQU.getPageActivity(), R.anim.frs_like);
    }
}
