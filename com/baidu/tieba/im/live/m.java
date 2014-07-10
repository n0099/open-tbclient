package com.baidu.tieba.im.live;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeDefinition;
import com.baidu.tieba.im.live.service.ILiveGroupManagerService;
import com.baidu.tieba.im.live.service.IRemoteCallback;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements ServiceConnection {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(d dVar) {
        this.a = dVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ILiveGroupManagerService iLiveGroupManagerService;
        IRemoteCallback iRemoteCallback;
        this.a.r = ILiveGroupManagerService.Stub.asInterface(iBinder);
        try {
            iLiveGroupManagerService = this.a.r;
            iRemoteCallback = this.a.s;
            iLiveGroupManagerService.registerCallback(iRemoteCallback);
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            this.a.e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a.r = null;
        TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        this.a.e(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
    }
}
