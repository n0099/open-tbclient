package com.baidu.tbadk.mutiprocess.sync;

import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
import com.baidu.tbadk.mutiprocess.SerializableEvent;
/* loaded from: classes3.dex */
public class SyncDataEvent extends SerializableEvent {
    public ABTestExtraData abtestExtraData;
    public String sampleId;
    public String ubsABTest;

    public SyncDataEvent() {
        setType(1);
    }
}
