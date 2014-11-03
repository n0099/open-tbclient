package com.baidu.tbadk.live;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeDefinition;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements ServiceConnection {
    final /* synthetic */ LiveGroupManager Vy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LiveGroupManager liveGroupManager) {
        this.Vy = liveGroupManager;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.baidu.tbadk.live.service.a aVar;
        com.baidu.tbadk.live.service.d dVar;
        this.Vy.mRemoteService = com.baidu.tbadk.live.service.b.a(iBinder);
        try {
            aVar = this.Vy.mRemoteService;
            dVar = this.Vy.mCallback;
            aVar.a(dVar);
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            this.Vy.broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        } catch (SecurityException e2) {
            this.Vy.broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.Vy.mRemoteService = null;
        TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        this.Vy.broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
    }
}
