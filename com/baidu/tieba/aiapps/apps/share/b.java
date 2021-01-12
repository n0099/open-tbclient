package com.baidu.tieba.aiapps.apps.share;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.share.ImplicitShareMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends ActivityDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        return false;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAttachedToWindow() {
        bNb();
        f(getAgent(), this.mParams.getString("options"));
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        bNc();
    }

    private void bNb() {
    }

    private void bNc() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mc(boolean z) {
        this.mResult.putBoolean("share_result", z);
        bNc();
        finish();
    }

    private void f(Activity activity, String str) {
        if (activity == null) {
            mc(false);
            return;
        }
        a aVar = new a();
        try {
            aVar.dB(new JSONObject(str));
            TbadkCoreApplication.getInst().setCurAiAppid(aVar.fsW);
            if (!TextUtils.isEmpty(aVar.getMediaType())) {
                int aM = aM(-1, aVar.getMediaType());
                if (!TextUtils.isEmpty(aVar.bMZ()) && !TextUtils.isEmpty(aVar.bNa())) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE);
                    httpMessage.addParam("scheme", aVar.bMZ());
                    httpMessage.setExtra(new com.baidu.tbadk.core.atomData.a(aVar, activity, aM));
                    MessageManager.getInstance().sendMessage(httpMessage);
                } else {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(activity, aM, aVar, true));
                }
                mc(com.baidu.tbadk.coreExtra.share.a.F(activity, aM));
                return;
            }
            TiebaStatic.log(new aq("c13530").dW("obj_id", aVar.fsW).an("obj_type", aVar.fsX).dW("obj_source", aVar.fsY));
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(activity, aVar, false);
            shareDialogConfig.onCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.aiapps.apps.share.b.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.mc(false);
                }
            };
            shareDialogConfig.onDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.aiapps.apps.share.b.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            };
            JSONArray bMY = aVar.bMY();
            if (bMY != null && !TextUtils.isEmpty(aVar.bMZ()) && !TextUtils.isEmpty(aVar.bNa())) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < bMY.length(); i++) {
                    try {
                        arrayList.add(Integer.valueOf(aM(-1, bMY.getString(i))));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (!x.isEmpty(arrayList)) {
                    aVar.bI(arrayList);
                }
                HttpMessage httpMessage2 = new HttpMessage(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE);
                httpMessage2.addParam("scheme", aVar.bMZ());
                httpMessage2.setExtra(new com.baidu.tbadk.core.atomData.a(aVar, activity, shareDialogConfig.onCancelListener));
                MessageManager.getInstance().sendMessage(httpMessage2);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        } catch (JSONException e2) {
            mc(false);
        }
    }

    private int aM(int i, String str) {
        if (str.equals(LogConfig.LIVE_SHARE_WEIXIN_FRIEND)) {
            return 3;
        }
        if (str.equals(LogConfig.LIVE_SHARE_WEIXIN_TIMELINE)) {
            return 2;
        }
        if (str.equals(LogConfig.LIVE_SHARE_QQ_FRIEND)) {
            return 8;
        }
        if (str.equals("qqdenglu")) {
            return 4;
        }
        if (str.equals(LogConfig.LIVE_SHARE_WEIBO)) {
            return 6;
        }
        return i;
    }
}
