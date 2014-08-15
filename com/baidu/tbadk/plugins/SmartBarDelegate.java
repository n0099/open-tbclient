package com.baidu.tbadk.plugins;

import android.app.Activity;
import android.view.MenuItem;
/* loaded from: classes.dex */
public interface SmartBarDelegate {
    void fixMenuItem(MenuItem menuItem);

    boolean hasSmartBar();

    void initActionBar(Activity activity);

    void invalidateOptionsMenu(Activity activity);

    void setActionBarTabsShowAtBottom(Activity activity, boolean z);

    void setActionBarViewCollapsable(Activity activity, boolean z);
}
