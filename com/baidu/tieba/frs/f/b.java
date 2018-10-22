package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class b {
    private Animation dUF;
    private TbPageContext<BaseFragmentActivity> mContext;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mContext = tbPageContext;
        this.dUF = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), e.a.frs_like);
    }
}
