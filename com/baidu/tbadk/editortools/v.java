package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class v extends y {
    public v(Context context) {
        super(context, null, 2, 0);
        this.launcherIcon = t.f.selector_editor_btn_more;
        this.toolView = new s(context);
        this.toolNeedAction = true;
        this.toolPosition = 6;
        this.toolLaunchAction = new int[]{1};
    }
}
