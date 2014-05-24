package com.baidu.tieba.im.live;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
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
public class i extends Handler {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar) {
        this.a = bVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        k kVar;
        k kVar2;
        switch (message.what) {
            case 1:
                LiveStatusParcelable liveStatusParcelable = (LiveStatusParcelable) message.obj;
                LiveStatusChangeMessage.LiveStatusData liveStatusData = new LiveStatusChangeMessage.LiveStatusData();
                liveStatusData.status = liveStatusParcelable.status;
                liveStatusData.groupId = liveStatusParcelable.groupId;
                liveStatusData.url = liveStatusParcelable.url;
                liveStatusData.errorString = liveStatusParcelable.errorString;
                this.a.a(liveStatusData);
                BdLog.d("Live status broadcast: " + liveStatusParcelable.toString());
                return;
            case 2:
                String str = (String) message.obj;
                if (!StringUtils.isNull(str)) {
                    BdLog.e("Live error reported: " + str);
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
                int i = message.arg1;
                int i2 = message.arg2;
                String str2 = (String) message.obj;
                BdLog.d("Live player new dur: " + i + ", pos: " + i2 + ", url: " + str2);
                this.a.a(str2, i, i2);
                return;
            case 4:
                int i3 = message.arg1;
                BdLog.d("Live record time: " + i3);
                kVar = this.a.i;
                if (kVar != null) {
                    kVar2 = this.a.i;
                    kVar2.a(i3);
                    return;
                }
                return;
            case 5:
                BdLog.d("Live player warning.");
                TiebaStatic.liveError("", TbErrInfo.ERR_LIVE_PLAY_INVALID_CODEC, TbErrInfo.getErrMsg(TbErrInfo.ERR_LIVE_PLAY_INVALID_CODEC), "");
                UtilHelper.showToast(TbadkApplication.m252getInst().getApp(), y.live_error_play_no_stream);
                this.a.p();
                return;
            case 10:
                BdLog.d("Live status as requested.");
                this.a.h();
                break;
        }
        super.handleMessage(message);
    }
}
