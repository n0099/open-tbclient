package com.baidu.tbadk.gift;

import android.content.Context;
/* loaded from: classes.dex */
public class BuyGiftActivityConfig extends com.baidu.tbadk.core.frameworkData.a {
    public static final String GIFT_RECEIVER_ID = "gift_receiver_id";

    public BuyGiftActivityConfig(Context context, long j) {
        super(context);
        getIntent().putExtra(GIFT_RECEIVER_ID, j);
    }
}
