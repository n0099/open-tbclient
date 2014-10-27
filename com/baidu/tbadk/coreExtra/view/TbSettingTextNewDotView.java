package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.pluginArch.PluginCenter;
/* loaded from: classes.dex */
public class TbSettingTextNewDotView extends TbSettingTextTipView {
    public TbSettingTextNewDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TbSettingTextNewDotView(Context context) {
        this(context, null);
    }

    public void refresh() {
        if (PluginCenter.getInstance().isTipUpdate()) {
            this.Pe.setVisibility(0);
            com.baidu.tbadk.core.util.aw.h((View) this.Pe, com.baidu.tieba.u.icon_news_head_new);
            return;
        }
        this.Pe.setVisibility(4);
    }
}
