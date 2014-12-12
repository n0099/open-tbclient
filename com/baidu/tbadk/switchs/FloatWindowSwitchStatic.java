package com.baidu.tbadk.switchs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.b.a;
import com.baidu.adp.lib.b.f;
import com.baidu.tieba.im.chat.notify.WindowSwitchResponse;
/* loaded from: classes.dex */
public class FloatWindowSwitchStatic extends a {
    static {
        f.dc().l(FloatWindowSwitchStatic.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public void changeSettingByType(int i) {
        WindowSwitchResponse windowSwitchResponse = new WindowSwitchResponse();
        windowSwitchResponse.setSwitchType(4);
        if (i == 1) {
            windowSwitchResponse.setIsOpen(true);
        } else {
            windowSwitchResponse.setIsOpen(false);
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(windowSwitchResponse);
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] getCrashKeys() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getDefaultType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getMaxCrashTimes() {
        return 10;
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_im_bubble_open";
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getOffType() {
        return 0;
    }
}
