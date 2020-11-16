package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> eGu;
    private Animation jif;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.eGu = tbPageContext;
        this.jif = AnimationUtils.loadAnimation(this.eGu.getPageActivity(), R.anim.frs_like);
    }
}
