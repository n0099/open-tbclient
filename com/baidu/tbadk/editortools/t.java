package com.baidu.tbadk.editortools;

import android.content.Context;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class t extends w {
    public t(Context context) {
        super(context, null, 2, 0);
        this.launcherIcon = i.e.selector_editor_btn_more;
        this.toolView = new q(context);
        this.toolNeedAction = true;
        this.toolPosition = 6;
        this.toolLaunchAction = new int[]{1};
    }
}
