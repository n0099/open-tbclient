package com.baidu.tbadk.switchs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes2.dex */
public class BaiduYunPushSdkSwitch extends a {
    public static final String BAIDU_YUN_PUSH_SDK_KEY = "android_baiduyun_push";
    public static final int OFF_TYPE = 0;
    public static final int ON_TYPE = 1;

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected void changeSettingByType(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BAIDU_YUN_PUSH_SWITCH_CHANGE));
    }

    @Override // com.baidu.adp.lib.featureSwitch.a
    protected String getName() {
        return BAIDU_YUN_PUSH_SDK_KEY;
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
