package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b {
    private Animation dzI;
    private TbPageContext<BaseFragmentActivity> mContext;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mContext = tbPageContext;
        this.dzI = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), d.a.frs_like);
    }
}
