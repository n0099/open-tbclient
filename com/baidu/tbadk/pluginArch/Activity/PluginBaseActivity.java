package com.baidu.tbadk.pluginArch.Activity;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import com.baidu.tbadk.pluginArch.a.a;
import com.baidu.tbadk.pluginArch.x;
/* loaded from: classes.dex */
public class PluginBaseActivity extends Activity {
    private AssetManager a;
    private Resources b;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    protected void a() {
        a aVar = (a) getClass().getAnnotation(a.class);
        if (aVar != null) {
            this.b = x.a().a(aVar.a(), super.getResources());
            if (this.b != null) {
                this.a = this.b.getAssets();
            }
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.a == null ? super.getAssets() : this.a;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.b == null ? super.getResources() : this.b;
    }
}
