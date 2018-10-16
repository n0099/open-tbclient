package com.baidu.tieba.aiapps.apps.n;

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
        au(context, unitedSchemeEntity.getParam("params"));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private boolean au(Context context, String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        try {
            String optString = new JSONObject(str).optString("path");
            if (StringUtils.isNull(optString)) {
                return false;
            }
            String substring = optString.substring("/pages/frshistory/frshistory?extradata=".length());
            if (StringUtils.isNull(substring)) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(substring);
            String optString2 = jSONObject.optString("third_app_id");
            String optString3 = jSONObject.optString("third_app_name");
            String optString4 = jSONObject.optString("third_app_pic");
            String optString5 = jSONObject.optString("third_app_link");
            SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(context, 10086);
            selectForumActivityConfig.setAiAppsParams(optString2, optString3, optString4, null, optString5, null);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectForumActivityConfig));
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}
