package com.baidu.tbadk.mutiprocess.event;

import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.mutiprocess.SerializableEvent;
/* loaded from: classes2.dex */
public class TipEvent extends SerializableEvent {
    public String linkUrl;
    public String message;
    public int pageId;

    public TipEvent(Intent intent, String str, String str2) {
        setType(0);
        parsePageIdFromIntent(intent);
        this.message = str;
        this.linkUrl = str2;
    }

    private void parsePageIdFromIntent(Intent intent) {
        if (intent != null) {
            this.pageId = intent.getIntExtra(IntentConfig.PRE_PAGE_ID, 0);
        }
    }
}
