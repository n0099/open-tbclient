package com.baidu.tbadk.mutiprocess;

import android.content.Intent;
/* loaded from: classes.dex */
public class i {
    public a F(Intent intent) {
        int intExtra = intent.getIntExtra("value_type", -1);
        if (intExtra < 0) {
            return null;
        }
        switch (DataType.values()[intExtra]) {
            case PARCELABLE:
                return (ParcelableEvent) intent.getParcelableExtra("value");
            case SERIALIZABLE:
                return (SerializableEvent) intent.getSerializableExtra("value");
            default:
                return null;
        }
    }
}
