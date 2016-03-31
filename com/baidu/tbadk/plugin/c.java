package com.baidu.tbadk.plugin;

import android.view.View;
import java.util.HashSet;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ PluginErrorTipView aCN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginErrorTipView pluginErrorTipView) {
        this.aCN = pluginErrorTipView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinkedList linkedList;
        LinkedList linkedList2;
        HashSet hashSet;
        linkedList = this.aCN.aCK;
        if (linkedList.size() > 0) {
            linkedList2 = this.aCN.aCK;
            hashSet = this.aCN.aCL;
            hashSet.add(Integer.valueOf(((com.baidu.adp.plugin.packageManager.a.a) linkedList2.getLast()).getErrorCode()));
        }
        this.aCN.setVisibility(8);
    }
}
