package com.baidu.tbadk.plugins;

import android.app.Activity;
import android.view.MenuItem;
@com.baidu.tbplugin.a.c(a = "smartbar")
@com.baidu.tbplugin.a.a(a = "smartbar.jar", b = "com.baidu.tbplugin.SmartBarImpl")
/* loaded from: classes.dex */
public interface SmartBarDelegate {
    void fixMenuItem(MenuItem menuItem);

    boolean hasSmartBar();

    void initActionBar(Activity activity);

    void invalidateOptionsMenu(Activity activity);

    void setActionBarTabsShowAtBottom(Activity activity, boolean z);

    void setActionBarViewCollapsable(Activity activity, boolean z);
}
