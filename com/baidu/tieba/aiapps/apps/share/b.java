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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.share.ImplicitShareMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class b extends ActivityDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        return false;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAttachedToWindow() {
        bIZ();
        f(getAgent(), this.mParams.getString("options"));
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        bJa();
    }

    private void bIZ() {
    }

    private void bJa() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void le(boolean z) {
        this.mResult.putBoolean("share_result", z);
        bJa();
        finish();
    }

    private void f(Activity activity, String str) {
        if (activity == null) {
            le(false);
            return;
        }
        a aVar = new a();
        try {
            aVar.dr(new JSONObject(str));
            TbadkCoreApplication.getInst().setCurAiAppid(aVar.fbw);
            if (!TextUtils.isEmpty(aVar.getMediaType())) {
                int aH = aH(-1, aVar.getMediaType());
                if (!TextUtils.isEmpty(aVar.bIX()) && !TextUtils.isEmpty(aVar.bIY())) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE);
                    httpMessage.addParam("scheme", aVar.bIX());
                    httpMessage.setExtra(new com.baidu.tbadk.core.atomData.a(aVar, activity, aH));
                    MessageManager.getInstance().sendMessage(httpMessage);
                } else {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(activity, aH, aVar, true));
                }
                le(com.baidu.tbadk.coreExtra.share.a.v(activity, aH));
                return;
            }
            TiebaStatic.log(new aq("c13530").dR("obj_id", aVar.fbw).aj("obj_type", aVar.fbx).dR("obj_source", aVar.fby));
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(activity, aVar, false);
            shareDialogConfig.onCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.aiapps.apps.share.b.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.le(false);
                }
            };
            shareDialogConfig.onDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.aiapps.apps.share.b.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            };
            JSONArray bIW = aVar.bIW();
            if (bIW != null && !TextUtils.isEmpty(aVar.bIX()) && !TextUtils.isEmpty(aVar.bIY())) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < bIW.length(); i++) {
                    try {
                        arrayList.add(Integer.valueOf(aH(-1, bIW.getString(i))));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (!y.isEmpty(arrayList)) {
                    aVar.bq(arrayList);
                }
                HttpMessage httpMessage2 = new HttpMessage(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE);
                httpMessage2.addParam("scheme", aVar.bIX());
                httpMessage2.setExtra(new com.baidu.tbadk.core.atomData.a(aVar, activity, shareDialogConfig.onCancelListener));
                MessageManager.getInstance().sendMessage(httpMessage2);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        } catch (JSONException e2) {
            le(false);
        }
    }

    private int aH(int i, String str) {
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
