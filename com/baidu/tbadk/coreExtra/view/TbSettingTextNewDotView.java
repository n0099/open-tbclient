package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class TbSettingTextNewDotView extends TbSettingTextTipView {
    public TbSettingTextNewDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TbSettingTextNewDotView(Context context) {
        this(context, null);
    }

    public void a() {
        boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
        if (com.baidu.tbadk.pluginArch.d.a().g()) {
            this.d.setVisibility(0);
            this.d.setBackgroundResource(z ? com.baidu.tieba.t.icon_news_head_new_1 : com.baidu.tieba.t.icon_news_head_new);
            return;
        }
        this.d.setVisibility(4);
    }
}
