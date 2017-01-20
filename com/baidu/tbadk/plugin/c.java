package com.baidu.tbadk.plugin;

import android.view.View;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import java.util.HashSet;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ PluginErrorTipView aCj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginErrorTipView pluginErrorTipView) {
        this.aCj = pluginErrorTipView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinkedList linkedList;
        LinkedList linkedList2;
        HashSet hashSet;
        linkedList = this.aCj.aCg;
        if (linkedList.size() > 0) {
            linkedList2 = this.aCj.aCg;
            hashSet = this.aCj.aCh;
            hashSet.add(Integer.valueOf(((PluginStatus) linkedList2.getLast()).getErrorCode()));
        }
        this.aCj.setVisibility(8);
    }
}
