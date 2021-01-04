package com.baidu.tieba.aiapps.apps.h;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e extends aa {
    public e(j jVar) {
        super(jVar, "/swan/publishThread");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        aS(context, unitedSchemeEntity.getParam("params"));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public static boolean aS(Context context, String str) {
        boolean z;
        if (StringUtils.isNull(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("path");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("appid");
                if (StringUtils.isNull(optString2)) {
                    z = false;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921361, com.baidu.tieba.aiapps.a.a(optString2, "", "", 0)));
                    z = true;
                }
            } else {
                String substring = optString.substring("/pages/frshistory/frshistory?extradata=".length());
                if (StringUtils.isNull(substring)) {
                    z = false;
                } else {
                    JSONObject jSONObject2 = new JSONObject(k.getUrlDecode(substring));
                    String optString3 = jSONObject2.optString("third_app_id");
                    String optString4 = jSONObject2.optString("third_app_name");
                    String optString5 = jSONObject2.optString("third_app_pic");
                    String optString6 = jSONObject2.optString("third_app_link");
                    SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(context, 10086);
                    selectForumActivityConfig.setAiAppsParams(optString3, optString4, optString5, null, null, optString6);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig));
                    z = true;
                }
            }
            return z;
        } catch (JSONException e) {
            return false;
        }
    }
}
