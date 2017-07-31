package com.baidu.tbadk.coreExtra.share.implementation;

import android.content.Context;
import com.baidu.tbadk.coreExtra.share.b;
import com.baidu.tbadk.coreExtra.share.c;
/* loaded from: classes.dex */
public class ShareWorkerCreator implements c {
    @Override // com.baidu.tbadk.coreExtra.share.c
    public b createWorker(Context context, com.baidu.tbadk.coreExtra.share.a aVar) {
        return new a(context, aVar);
    }
}
