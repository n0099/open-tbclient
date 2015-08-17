package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class WindowSwitchResponse extends CustomResponsedMessage<Object> {
    public static final int KEY_TYPE_CHAT = 1;
    public static final int KEY_TYPE_FLOAT_WINDOW = 3;
    public static final int KEY_TYPE_MASTER = 0;
    public static final int KEY_TYPE_STRANGER = 2;
    public static final int KEY_TYPE_SYNC_SWITCH = 4;
    private boolean isOpen;
    private int mType;

    public WindowSwitchResponse(int i) {
        super(i);
        this.isOpen = false;
    }

    public WindowSwitchResponse() {
        super(CmdConfigCustom.CMD_FLOAT_WINDOW_SWITCH_CHANGED);
        this.isOpen = false;
    }

    public void setIsOpen(boolean z) {
        this.isOpen = z;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void setSwitchType(int i) {
        this.mType = i;
    }

    public int getSwitchType() {
        return this.mType;
    }
}
