package com.baidu.tieba.aiapps.apps.m;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends AiAppAction {
    public b(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, "/swan/publishThread");
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        av(context, unitedSchemeEntity.getParam("params"));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private boolean av(Context context, String str) {
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921361, com.baidu.tieba.aiapps.a.t(optString2, "", "")));
                    z = true;
                }
            } else {
                String substring = optString.substring("/pages/frshistory/frshistory?extradata=".length());
                if (StringUtils.isNull(substring)) {
                    z = false;
                } else {
                    JSONObject jSONObject2 = new JSONObject(substring);
                    String optString3 = jSONObject2.optString("third_app_id");
                    String optString4 = jSONObject2.optString("third_app_name");
                    String optString5 = jSONObject2.optString("third_app_pic");
                    String optString6 = jSONObject2.optString("third_app_link");
                    SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(context, 10086);
                    selectForumActivityConfig.setAiAppsParams(optString3, optString4, optString5, null, optString6, null);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectForumActivityConfig));
                    z = true;
                }
            }
            return z;
        } catch (JSONException e) {
            return false;
        }
    }
}
