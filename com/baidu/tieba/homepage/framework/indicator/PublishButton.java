package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class PublishButton extends TBSpecificationBtn {
    private float mAlpha;

    public PublishButton(Context context) {
        super(context);
        this.mAlpha = 1.0f;
        init();
    }

    public PublishButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAlpha = 1.0f;
        init();
    }

    public PublishButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAlpha = 1.0f;
        init();
    }

    private void init() {
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        aVar.a(R.drawable.ic_icon_pure_send12, 0, TBSpecificationButtonConfig.IconType.SVG);
        aVar.pj(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds27));
        setConfig(aVar);
        setTextSize(R.dimen.tbds36);
        setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_thread_publish));
    }

    public void setScrollAlpha(float f) {
        this.mAlpha = f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        setAlpha(this.mAlpha);
    }
}
