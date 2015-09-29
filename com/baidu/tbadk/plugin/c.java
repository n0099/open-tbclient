package com.baidu.tbadk.plugin;

import android.view.View;
import java.util.HashSet;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ PluginErrorTipView ays;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginErrorTipView pluginErrorTipView) {
        this.ays = pluginErrorTipView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinkedList linkedList;
        HashSet hashSet;
        linkedList = this.ays.ayp;
        hashSet = this.ays.ayq;
        hashSet.add(Integer.valueOf(((com.baidu.adp.plugin.packageManager.a.a) linkedList.getLast()).getErrorCode()));
        this.ays.setVisibility(8);
    }
}
