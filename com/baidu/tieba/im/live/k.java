package com.baidu.tieba.im.live;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeDefinition;
import com.baidu.tieba.im.live.service.ILiveGroupManagerService;
import com.baidu.tieba.im.live.service.IRemoteCallback;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements ServiceConnection {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(b bVar) {
        this.a = bVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ILiveGroupManagerService iLiveGroupManagerService;
        IRemoteCallback iRemoteCallback;
        BdLog.d("onServiceConnected");
        this.a.t = ILiveGroupManagerService.Stub.asInterface(iBinder);
        try {
            iLiveGroupManagerService = this.a.t;
            iRemoteCallback = this.a.u;
            iLiveGroupManagerService.registerCallback(iRemoteCallback);
        } catch (RemoteException e) {
            BdLog.e("LiveGroupManager", "onServiceConnected", e);
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            this.a.e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a.t = null;
        BdLog.e("onServiceDisconnected");
        TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        this.a.e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
    }
}
