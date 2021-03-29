package com.baidu.tieba.im.chat;

import java.util.Hashtable;
/* loaded from: classes3.dex */
public class TouchType extends Hashtable<Integer, Boolean> {
    public static final int KEY = 0;
    public static final long serialVersionUID = 1;

    public TouchType() {
        put(0, Boolean.FALSE);
    }

    public boolean get() {
        return get(0).booleanValue();
    }

    public void set(boolean z) {
        put(0, Boolean.valueOf(z));
    }
}
