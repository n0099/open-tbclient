package com.baidu.tbadk.mutiprocess.event;

import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.mutiprocess.SerializableEvent;
/* loaded from: classes3.dex */
public class TipEvent extends SerializableEvent {
    public boolean isCloseCurrentPage;
    public String linkUrl;
    public String message;
    public int pageId;

    public TipEvent(Intent intent, String str, String str2, boolean z) {
        setType(0);
        parsePageIdFromIntent(intent);
        this.message = str;
        this.linkUrl = str2;
        this.isCloseCurrentPage = z;
    }

    private void parsePageIdFromIntent(Intent intent) {
        if (intent != null) {
            this.pageId = intent.getIntExtra(IntentConfig.PRE_PAGE_ID, 0);
        }
    }
}
