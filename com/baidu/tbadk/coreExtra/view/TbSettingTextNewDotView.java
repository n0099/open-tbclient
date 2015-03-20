package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class TbSettingTextNewDotView extends TbSettingTextTipView {
    public TbSettingTextNewDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TbSettingTextNewDotView(Context context) {
        this(context, null);
    }

    public void refresh() {
        if (PluginPackageManager.ls().lB()) {
            this.afy.setVisibility(0);
            ba.i((View) this.afy, com.baidu.tieba.u.icon_news_head_new);
            return;
        }
        this.afy.setVisibility(4);
    }
}
