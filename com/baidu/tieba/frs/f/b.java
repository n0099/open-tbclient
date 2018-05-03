package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> adf;
    private Animation dpo;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.adf = tbPageContext;
        this.dpo = AnimationUtils.loadAnimation(this.adf.getPageActivity(), d.a.frs_like);
    }
}
