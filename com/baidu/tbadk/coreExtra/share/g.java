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
        if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof ShareDialogConfig)) {
            ShareDialogConfig data = customMessage.getData();
            d dVar = new d(data.getContext());
            dVar.a(data.shareItem, data.showLocation);
            if (data.mtjStatistics != null) {
                dVar.a(data.mtjStatistics);
            }
            if (data.isSetCopyLink) {
                dVar.setIsCopyLink(data.isCopyLink);
            }
            if (data.copyLinkListener != null) {
                dVar.setCopyLinkListener(data.copyLinkListener);
            }
            if (data.textViewList != null && data.textViewList.size() > 0) {
                Iterator<Pair<Integer, Pair<Integer, View.OnClickListener>>> it = data.textViewList.iterator();
                while (it.hasNext()) {
                    Pair<Integer, Pair<Integer, View.OnClickListener>> next = it.next();
                    TextView B = dVar.B(((Integer) next.first).intValue(), ((Integer) ((Pair) next.second).first).intValue());
                    if (data.isInsertBack) {
                        dVar.a(B, dVar.AA(), (View.OnClickListener) ((Pair) next.second).second);
                    } else {
                        dVar.a(B, (View.OnClickListener) ((Pair) next.second).second);
                    }
                }
            }
            dVar.show();
        }
        return null;
    }
}
