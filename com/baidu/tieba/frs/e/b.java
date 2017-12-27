package com.baidu.tieba.frs.e;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> aQq;
    private Animation dMo;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.aQq = tbPageContext;
        this.dMo = AnimationUtils.loadAnimation(this.aQq.getPageActivity(), d.a.frs_like);
    }
}
