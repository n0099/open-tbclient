package com.baidu.tieba.im.randchat;

import com.baidu.tieba.im.randchat.WaitingTipView;
/* loaded from: classes.dex */
/* synthetic */ class m {
    static final /* synthetic */ int[] a = new int[WaitingTipView.Type.values().length];

    static {
        try {
            a[WaitingTipView.Type.TOPIC_UPDATE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[WaitingTipView.Type.ORIGINAL_ENTER.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[WaitingTipView.Type.PERSON_ENTER.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[WaitingTipView.Type.PERSONS_READY.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[WaitingTipView.Type.WAIT_LONG.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            a[WaitingTipView.Type.PERSON_LEAVE.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            a[WaitingTipView.Type.WAIT_TIP.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            a[WaitingTipView.Type.WAIT_TIP_RAND.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
        try {
            a[WaitingTipView.Type.CLEAR.ordinal()] = 9;
        } catch (NoSuchFieldError e9) {
        }
    }
}
