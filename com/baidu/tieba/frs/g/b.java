package com.baidu.tieba.frs.g;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> aby;
    private Animation cFl;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.aby = tbPageContext;
        this.cFl = AnimationUtils.loadAnimation(this.aby.getPageActivity(), d.a.frs_like);
    }
}
