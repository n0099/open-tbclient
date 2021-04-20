package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.h0.r.f0.m.b;
/* loaded from: classes4.dex */
public class PublishButton extends TBSpecificationBtn {
    public float s;

    public PublishButton(Context context) {
        super(context);
        this.s = 1.0f;
        m();
    }

    private void m() {
        b bVar = new b();
        bVar.i(R.drawable.icon_pure_issue16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        bVar.g(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42));
        bVar.o(R.color.CAM_X0302, R.color.CAM_X0101);
        setConfig(bVar);
        setTextSize(R.dimen.T_X08);
        setText(TbadkCoreApplication.getInst().getResources().getString(R.string.home_write_thread_publish));
    }

    @Override // com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        setAlpha(this.s);
    }

    public void setScrollAlpha(float f2) {
        this.s = f2;
    }

    public PublishButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = 1.0f;
        m();
    }

    public PublishButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.s = 1.0f;
        m();
    }
}
