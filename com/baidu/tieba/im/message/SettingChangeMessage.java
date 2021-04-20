package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class SettingChangeMessage extends CustomResponsedMessage<Integer> {
    public static final int TYPE_GROUP = 1;
    public static final int TYPE_OFFICIAL = 2;
    public static final int TYPE_PERSONAL = 3;

    public SettingChangeMessage(int i) {
        super(2016011);
    }
}
