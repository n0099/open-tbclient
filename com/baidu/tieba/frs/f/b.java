package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {
    private Animation fQs;
    private TbPageContext<BaseFragmentActivity> mContext;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mContext = tbPageContext;
        this.fQs = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), R.anim.frs_like);
    }
}
