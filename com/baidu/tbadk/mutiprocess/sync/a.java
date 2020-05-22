package com.baidu.tbadk.mutiprocess.sync;

import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.mutiprocess.b;
/* loaded from: classes.dex */
public class a implements b<SyncDataEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mutiprocess.b
    public boolean a(SyncDataEvent syncDataEvent) {
        if (syncDataEvent == null) {
            return false;
        }
        TbSingleton.getInstance().setSampleId(syncDataEvent.sampleId);
        com.baidu.tbadk.util.a.bgh().a(syncDataEvent.abtestExtraData);
        return true;
    }
}
