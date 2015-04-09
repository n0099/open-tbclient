package com.baidu.tbadk.coreExtra.share;

import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import java.util.Iterator;
/* loaded from: classes.dex */
class g implements CustomMessageTask.CustomRunnable<ShareDialogConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<ShareDialogConfig> customMessage) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        d dVar5;
        d dVar6;
        d dVar7;
        if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof ShareDialogConfig)) {
            ShareDialogConfig data = customMessage.getData();
            ShareStatic.adB = new d(data.getContext());
            dVar = ShareStatic.adB;
            dVar.a(data.shareItem, data.showLocation);
            if (data.mtjStatistics != null) {
                dVar7 = ShareStatic.adB;
                dVar7.a(data.mtjStatistics);
            }
            if (data.isSetCopyLink) {
                dVar6 = ShareStatic.adB;
                dVar6.setIsCopyLink(data.isCopyLink);
            }
            if (data.copyLinkListener != null) {
                dVar5 = ShareStatic.adB;
                dVar5.setCopyLinkListener(data.copyLinkListener);
            }
            if (data.textViewList != null && data.textViewList.size() > 0) {
                Iterator<Pair<Integer, Pair<Integer, View.OnClickListener>>> it = data.textViewList.iterator();
                while (it.hasNext()) {
                    Pair<Integer, Pair<Integer, View.OnClickListener>> next = it.next();
                    dVar3 = ShareStatic.adB;
                    TextView u = dVar3.u(((Integer) next.first).intValue(), ((Integer) ((Pair) next.second).first).intValue());
                    dVar4 = ShareStatic.adB;
                    dVar4.a(u);
                    if (((Pair) next.second).second != null) {
                        u.setOnClickListener((View.OnClickListener) ((Pair) next.second).second);
                    }
                }
            }
            dVar2 = ShareStatic.adB;
            dVar2.show();
        }
        return null;
    }
}
