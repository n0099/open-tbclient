package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class b {
    private Animation dFC;
    private TbPageContext<BaseFragmentActivity> mContext;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.mContext = tbPageContext;
        this.dFC = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), f.a.frs_like);
    }
}
