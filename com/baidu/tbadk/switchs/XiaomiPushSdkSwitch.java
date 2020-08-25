package com.baidu.tbadk.switchs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes2.dex */
public class XiaomiPushSdkSwitch extends a {
    public static final int OFF_TYPE = 0;
    public static final int ON_TYPE = 1;
    public static final String XIAOMIPUSH_SDK_KEY = "switch_xiaomipush_sdk";

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void changeSettingByType(int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_XIAOMI_PUSH_SWITCH_CHANGE));
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return XIAOMIPUSH_SDK_KEY;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String[] getCrashKeys() {
        return null;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getDefaultType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getOffType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected int getMaxCrashTimes() {
        return 10;
    }
}
