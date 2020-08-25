package com.baidu.tbadk.mutiprocess;

import android.content.Intent;
/* loaded from: classes2.dex */
public class j {
    public void a(Intent intent, a aVar) {
        if (aVar instanceof ParcelableEvent) {
            intent.putExtra("value_type", DataType.PARCELABLE.ordinal());
            intent.putExtra("value", (ParcelableEvent) aVar);
        } else if (aVar instanceof SerializableEvent) {
            intent.putExtra("value_type", DataType.SERIALIZABLE.ordinal());
            intent.putExtra("value", (SerializableEvent) aVar);
        }
    }
}
