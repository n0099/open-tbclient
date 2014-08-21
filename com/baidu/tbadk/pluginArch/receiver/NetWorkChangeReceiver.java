package com.baidu.tbadk.pluginArch.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.util.BdNetUtil;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.pluginArch.d;
/* loaded from: classes.dex */
public class NetWorkChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && BdNetUtil.getNetType() != BdNetUtil.NetTpyeEnum.UNAVAIL && TbadkApplication.m252getInst().isMainProcess(false) && d.a().d() == null) {
            d.a().c();
        }
    }
}
