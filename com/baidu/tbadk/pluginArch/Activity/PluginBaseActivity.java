package com.baidu.tbadk.pluginArch.Activity;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.pluginArch.PluginResourcesManager;
import com.baidu.tbadk.pluginArch.annotation.PluginActivityAnnotation;
/* loaded from: classes.dex */
public class PluginBaseActivity extends BaseActivity {
    private AssetManager mAssetManager;
    private Resources mResources;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        setContentView(LayoutInflater.from(this).inflate(i, (ViewGroup) null));
    }

    protected void loadResources() {
        PluginActivityAnnotation pluginActivityAnnotation = (PluginActivityAnnotation) getClass().getAnnotation(PluginActivityAnnotation.class);
        if (pluginActivityAnnotation != null) {
            this.mResources = PluginResourcesManager.getInstance().getPluginResource(pluginActivityAnnotation.pluginName(), super.getResources());
            if (this.mResources != null) {
                this.mAssetManager = this.mResources.getAssets();
            }
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        if (this.mAssetManager == null) {
            loadResources();
        }
        return this.mAssetManager == null ? super.getAssets() : this.mAssetManager;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.mResources == null) {
            loadResources();
        }
        return this.mResources == null ? super.getResources() : this.mResources;
    }
}
