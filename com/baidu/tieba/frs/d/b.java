package com.baidu.tieba.frs.d;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> eXu;
    private Animation jIe;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.eXu = tbPageContext;
        this.jIe = AnimationUtils.loadAnimation(this.eXu.getPageActivity(), R.anim.frs_like);
    }
}
