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
    final /* synthetic */ LiveGroupManager Vu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LiveGroupManager liveGroupManager) {
        this.Vu = liveGroupManager;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.baidu.tbadk.live.service.a aVar;
        com.baidu.tbadk.live.service.d dVar;
        this.Vu.mRemoteService = com.baidu.tbadk.live.service.b.a(iBinder);
        try {
            aVar = this.Vu.mRemoteService;
            dVar = this.Vu.mCallback;
            aVar.a(dVar);
        } catch (RemoteException e) {
            TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), e.getMessage());
            this.Vu.broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        } catch (SecurityException e2) {
            this.Vu.broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.Vu.mRemoteService = null;
        TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_REMOTE_EXCEPTION), LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
        this.Vu.broadcastLiveError(LiveStatusChangeDefinition.ERROR_PROMPT_SERVICE_CRASHED);
    }
}
