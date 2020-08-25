package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
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
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        aVar.a(R.drawable.ic_icon_pure_send12, 0, TBSpecificationButtonConfig.IconType.SVG);
        aVar.oX(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds27));
        setConfig(aVar);
        setTextSize(R.dimen.tbds36);
        setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_publish_dynamic));
    }
}
