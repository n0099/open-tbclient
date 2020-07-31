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
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.share.ImplicitShareMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class b extends ActivityDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        return false;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAttachedToWindow() {
        bum();
        g(getAgent(), this.mParams.getString("options"));
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        bun();
    }

    private void bum() {
    }

    private void bun() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jS(boolean z) {
        this.mResult.putBoolean("share_result", z);
        bun();
        finish();
    }

    private void g(Activity activity, String str) {
        if (activity == null) {
            jS(false);
            return;
        }
        a aVar = new a();
        try {
            aVar.cX(new JSONObject(str));
            if (!TextUtils.isEmpty(aVar.getMediaType())) {
                int aw = aw(-1, aVar.getMediaType());
                if (!TextUtils.isEmpty(aVar.buk()) && !TextUtils.isEmpty(aVar.bul())) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE);
                    httpMessage.addParam(SuspensionBallEntity.KEY_SCHEME, aVar.buk());
                    httpMessage.setExtra(new com.baidu.tbadk.core.atomData.a(aVar, activity, aw));
                    MessageManager.getInstance().sendMessage(httpMessage);
                } else {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(activity, aw, aVar, true));
                }
                jS(com.baidu.tbadk.coreExtra.share.a.u(activity, aw));
                return;
            }
            TiebaStatic.log(new ap("c13530").dn("obj_id", aVar.euj).ah("obj_type", aVar.euk).dn("obj_source", aVar.eul));
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(activity, aVar, false);
            shareDialogConfig.onCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.aiapps.apps.share.b.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.this.jS(false);
                }
            };
            shareDialogConfig.onDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.aiapps.apps.share.b.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            };
            JSONArray buj = aVar.buj();
            if (buj != null && !TextUtils.isEmpty(aVar.buk()) && !TextUtils.isEmpty(aVar.bul())) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < buj.length(); i++) {
                    try {
                        arrayList.add(Integer.valueOf(aw(-1, buj.getString(i))));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (!x.isEmpty(arrayList)) {
                    aVar.aZ(arrayList);
                }
                HttpMessage httpMessage2 = new HttpMessage(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE);
                httpMessage2.addParam(SuspensionBallEntity.KEY_SCHEME, aVar.buk());
                httpMessage2.setExtra(new com.baidu.tbadk.core.atomData.a(aVar, activity));
                MessageManager.getInstance().sendMessage(httpMessage2);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        } catch (JSONException e2) {
            jS(false);
        }
    }

    private int aw(int i, String str) {
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
