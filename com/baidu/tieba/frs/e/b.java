package com.baidu.tieba.frs.e;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> aQp;
    private Animation dQQ;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.aQp = tbPageContext;
        this.dQQ = AnimationUtils.loadAnimation(this.aQp.getPageActivity(), d.a.frs_like);
    }
}
