package com.baidu.tbadk.mutiprocess.history;

import android.text.TextUtils;
import com.baidu.tbadk.mutiprocess.b;
import com.baidu.tieba.card.l;
/* loaded from: classes.dex */
public class a implements b<HistoryEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mutiprocess.b
    public boolean a(HistoryEvent historyEvent) {
        if (historyEvent == null || TextUtils.isEmpty(historyEvent.tid)) {
            return false;
        }
        l.zS(historyEvent.tid);
        return true;
    }
}
