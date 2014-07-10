package com.baidu.tieba.im.live;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeDefinition;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeMessage;
import com.baidu.tieba.im.live.service.LiveStatusParcelable;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends Handler {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar) {
        this.a = dVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        boolean z;
        Handler handler;
        Runnable runnable;
        n nVar;
        n nVar2;
        int i2;
        switch (message.what) {
            case 1:
                LiveStatusParcelable liveStatusParcelable = (LiveStatusParcelable) message.obj;
                if (liveStatusParcelable != null) {
                    LiveStatusChangeMessage.LiveStatusData liveStatusData = new LiveStatusChangeMessage.LiveStatusData();
                    liveStatusData.status = liveStatusParcelable.status;
                    liveStatusData.groupId = liveStatusParcelable.groupId;
                    liveStatusData.url = liveStatusParcelable.url;
                    liveStatusData.errorString = liveStatusParcelable.errorString;
                    this.a.a(liveStatusData);
                    if (liveStatusParcelable.status == 3) {
                        i2 = this.a.h;
                        if (i2 == 2) {
                            TiebaStatic.eventStat(TbadkApplication.m252getInst().getApp(), "has_live_bhv", "", 1, com.baidu.tbadk.core.frameworkData.a.GROUP_ID, liveStatusParcelable.groupId);
                        }
                    }
                    this.a.h = liveStatusParcelable.status;
                    return;
                }
                return;
            case 2:
                String str = (String) message.obj;
                if (!StringUtils.isNull(str)) {
                    if (str.equals(LiveStatusChangeDefinition.ERROR_PROMPT_NOT_SUPPORT)) {
                        TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_NOT_SUPPORT, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_NOT_SUPPORT), "");
                        UtilHelper.showToast(TbadkApplication.m252getInst().getApp(), y.live_error_system_not_support);
                    } else if (str.equals(LiveStatusChangeDefinition.ERROR_PROMPT_CONNECT_PREPARE)) {
                        TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_SDK_INIT_FAILED, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_SDK_INIT_FAILED), "");
                        UtilHelper.showToast(TbadkApplication.m252getInst().getApp(), y.live_error_init_failed);
                    } else if (str.equals(LiveStatusChangeDefinition.ERROR_PROMPT_START_PUB)) {
                        TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_SDK_PUB_FAILED, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_SDK_PUB_FAILED), "");
                        UtilHelper.showToast(TbadkApplication.m252getInst().getApp(), y.live_error_publish_failed);
                    } else if (str.equals(LiveStatusChangeDefinition.ERROR_PROMPT_CREATE_ENGINE_FAILED)) {
                        TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_MM_MODULE_FAILED, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_MM_MODULE_FAILED), "");
                        UtilHelper.showToast(TbadkApplication.m252getInst().getApp(), y.live_error_create_engine_failed);
                    } else if (str.equals(LiveStatusChangeDefinition.ERROR_PROMPT_TOKEN_EXPIRED)) {
                        TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_TOKEN_EXPIRED, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_TOKEN_EXPIRED), "");
                        UtilHelper.showToast(TbadkApplication.m252getInst().getApp(), y.live_error_accesstoken_null_or_expire);
                    } else if (str.equals(LiveStatusChangeDefinition.ERROR_PROMPT_CONNECTION_CLOSED)) {
                        TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_CONNECTION_KICKED, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_CONNECTION_KICKED), "");
                        UtilHelper.showToast(TbadkApplication.m252getInst().getApp(), y.live_error_connection_closed);
                    } else if (str.equals(LiveStatusChangeDefinition.ERROR_PROMPT_PLAY_FILE_ERROR)) {
                        TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_PLAY_FILE, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_PLAY_FILE), "");
                        UtilHelper.showToast(TbadkApplication.m252getInst().getApp(), y.live_error_play_file);
                    } else if (str.equals(LiveStatusChangeDefinition.ERROR_PROMPT_PLAY_NET_ERROR)) {
                        TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_PLAY_NETWORK, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_PLAY_NETWORK), "");
                        UtilHelper.showToast(TbadkApplication.m252getInst().getApp(), y.live_error_play_network);
                    } else if (str.equals(LiveStatusChangeDefinition.ERROR_PROMPT_PLAY_INVALID_CODEC)) {
                        TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_PLAY_INVALID_CODEC, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_PLAY_INVALID_CODEC), "");
                        UtilHelper.showToast(TbadkApplication.m252getInst().getApp(), y.live_error_play_invalid_codec);
                    }
                    this.a.e(str);
                    return;
                }
                return;
            case 3:
                this.a.a((String) message.obj, message.arg1, message.arg2);
                return;
            case 4:
                int i3 = message.arg1;
                nVar = this.a.l;
                if (nVar != null) {
                    nVar2 = this.a.l;
                    nVar2.a(i3);
                    return;
                }
                return;
            case 5:
                TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_PLAY_INVALID_CODEC, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_PLAY_INVALID_CODEC), "");
                d dVar = this.a;
                i = dVar.e;
                dVar.e = i + 1;
                z = this.a.g;
                if (!z) {
                    this.a.g = true;
                    handler = this.a.t;
                    runnable = this.a.u;
                    handler.postDelayed(runnable, 20000L);
                    return;
                }
                return;
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                super.handleMessage(message);
                return;
            case 10:
                this.a.h();
                return;
        }
    }
}
