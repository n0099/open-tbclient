package com.baidu.tbadk.plugin;

import android.view.View;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import java.util.HashSet;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ PluginErrorTipView aHS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginErrorTipView pluginErrorTipView) {
        this.aHS = pluginErrorTipView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinkedList linkedList;
        LinkedList linkedList2;
        HashSet hashSet;
        linkedList = this.aHS.aHP;
        if (linkedList.size() > 0) {
            linkedList2 = this.aHS.aHP;
            hashSet = this.aHS.aHQ;
            hashSet.add(Integer.valueOf(((PluginStatus) linkedList2.getLast()).getErrorCode()));
        }
        this.aHS.setVisibility(8);
    }
}
