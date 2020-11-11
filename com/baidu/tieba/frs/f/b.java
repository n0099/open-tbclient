package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> eIc;
    private Animation jht;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.eIc = tbPageContext;
        this.jht = AnimationUtils.loadAnimation(this.eIc.getPageActivity(), R.anim.frs_like);
    }
}
