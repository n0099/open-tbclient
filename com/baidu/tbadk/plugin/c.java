package com.baidu.tbadk.plugin;

import android.view.View;
import java.util.HashSet;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ PluginErrorTipView aBP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginErrorTipView pluginErrorTipView) {
        this.aBP = pluginErrorTipView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinkedList linkedList;
        LinkedList linkedList2;
        HashSet hashSet;
        linkedList = this.aBP.aBM;
        if (linkedList.size() > 0) {
            linkedList2 = this.aBP.aBM;
            hashSet = this.aBP.aBN;
            hashSet.add(Integer.valueOf(((com.baidu.adp.plugin.packageManager.a.a) linkedList2.getLast()).getErrorCode()));
        }
        this.aBP.setVisibility(8);
    }
}
