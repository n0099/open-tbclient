package com.baidu.tbadk.mutiprocess.history;

import android.text.TextUtils;
import com.baidu.tbadk.mutiprocess.b;
import com.baidu.tieba.card.m;
/* loaded from: classes.dex */
public class a implements b<HistoryEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mutiprocess.b
    public boolean a(HistoryEvent historyEvent) {
        if (historyEvent == null || TextUtils.isEmpty(historyEvent.tid)) {
            return false;
        }
        m.Jo(historyEvent.tid);
        return true;
    }
}
