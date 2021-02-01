package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
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
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.a(R.drawable.icon_pure_issue16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        bVar.setIconSize(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42));
        bVar.aY(R.color.CAM_X0302, R.color.CAM_X0101);
        setConfig(bVar);
        setTextSize(R.dimen.T_X08);
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
