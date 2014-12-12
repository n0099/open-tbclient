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
        if (PluginPackageManager.ic().im()) {
            this.UU.setVisibility(0);
            com.baidu.tbadk.core.util.ax.i((View) this.UU, com.baidu.tieba.v.icon_news_head_new);
            return;
        }
        this.UU.setVisibility(4);
    }
}
