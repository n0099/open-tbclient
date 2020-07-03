package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PublishButton extends TBSpecificationBtn {
    public PublishButton(Context context) {
        super(context);
        init();
    }

    public PublishButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PublishButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.k(R.drawable.ic_icon_pure_send12, 0, true);
        bVar.my(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds27));
        setConfig(bVar);
        setTextSize(R.dimen.tbds36);
        setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_publish_dynamic));
    }
}
