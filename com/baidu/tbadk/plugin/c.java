package com.baidu.tbadk.plugin;

import android.view.View;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import java.util.HashSet;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ PluginErrorTipView aIX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginErrorTipView pluginErrorTipView) {
        this.aIX = pluginErrorTipView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinkedList linkedList;
        LinkedList linkedList2;
        HashSet hashSet;
        linkedList = this.aIX.aIU;
        if (linkedList.size() > 0) {
            linkedList2 = this.aIX.aIU;
            hashSet = this.aIX.aIV;
            hashSet.add(Integer.valueOf(((PluginStatus) linkedList2.getLast()).getErrorCode()));
        }
        this.aIX.setVisibility(8);
    }
}
