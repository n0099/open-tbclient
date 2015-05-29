package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
/* loaded from: classes.dex */
public class TbSettingTextNewDotView extends TbSettingTextTipView {
    public TbSettingTextNewDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TbSettingTextNewDotView(Context context) {
        this(context, null);
    }

    public void refresh() {
        if (PluginPackageManager.lM().lU()) {
            this.agH.setVisibility(0);
            com.baidu.tbadk.core.util.ay.i((View) this.agH, com.baidu.tieba.p.icon_news_head_new);
            return;
        }
        this.agH.setVisibility(4);
    }
}
