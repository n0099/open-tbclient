package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class aa {
    private Context context;
    public int id;
    public int launcherIcon;
    public int launcherPriority;
    public String name;
    public int[] toolLaunchAction;
    public int toolPosition;
    public ab toolView;
    public boolean isLauncherCanSelect = true;
    public boolean toolNeedAction = false;

    public aa(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.launcherPriority = i2;
    }

    public aa(Context context, String str, int i) {
        this.name = str;
        this.id = i;
        this.context = context;
    }

    public aa(Context context, String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.context = context;
        this.launcherPriority = i2;
    }

    protected Context getContext() {
        return this.context;
    }
}
