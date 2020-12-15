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
import com.baidu.tbadk.core.util.ar;
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
        bOA();
        f(getAgent(), this.mParams.getString("options"));
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        bOB();
    }

    private void bOA() {
    }

    private void bOB() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lJ(boolean z) {
        this.mResult.putBoolean("share_result", z);
        bOB();
        finish();
    }

    private void f(Activity activity, String str) {
        if (activity == null) {
            lJ(false);
            return;
        }
        a aVar = new a();
        try {
            aVar.ds(new JSONObject(str));
            TbadkCoreApplication.getInst().setCurAiAppid(aVar.fnV);
            if (!TextUtils.isEmpty(aVar.getMediaType())) {
                int aJ = aJ(-1, aVar.getMediaType());
                if (!TextUtils.isEmpty(aVar.bOy()) && !TextUtils.isEmpty(aVar.bOz())) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE);
                    httpMessage.addParam("scheme", aVar.bOy());
                    httpMessage.setExtra(new com.baidu.tbadk.core.atomData.a(aVar, activity, aJ));
                    MessageManager.getInstance().sendMessage(httpMessage);
                } else {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(activity, aJ, aVar, true));
                }
                lJ(com.baidu.tbadk.coreExtra.share.a.E(activity, aJ));
                return;
            }
            TiebaStatic.log(new ar("c13530").dY("obj_id", aVar.fnV).al("obj_type", aVar.fnW).dY("obj_source", aVar.fnX));
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(activity, aVar, false);
            shareDialogConfig.onCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.aiapps.apps.share.b.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.lJ(false);
                }
            };
            shareDialogConfig.onDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.aiapps.apps.share.b.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            };
            JSONArray bOx = aVar.bOx();
            if (bOx != null && !TextUtils.isEmpty(aVar.bOy()) && !TextUtils.isEmpty(aVar.bOz())) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < bOx.length(); i++) {
                    try {
                        arrayList.add(Integer.valueOf(aJ(-1, bOx.getString(i))));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (!y.isEmpty(arrayList)) {
                    aVar.bB(arrayList);
                }
                HttpMessage httpMessage2 = new HttpMessage(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE);
                httpMessage2.addParam("scheme", aVar.bOy());
                httpMessage2.setExtra(new com.baidu.tbadk.core.atomData.a(aVar, activity, shareDialogConfig.onCancelListener));
                MessageManager.getInstance().sendMessage(httpMessage2);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        } catch (JSONException e2) {
            lJ(false);
        }
    }

    private int aJ(int i, String str) {
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
