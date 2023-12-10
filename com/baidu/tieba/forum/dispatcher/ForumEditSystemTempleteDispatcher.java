package com.baidu.tieba.forum.dispatcher;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.pma;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/tieba/forum/dispatcher/ForumEditSystemTempleteDispatcher;", "Lcom/baidu/tieba/schema/SchemaDispatcher;", "()V", "dispatch", "", "params", "Lorg/json/JSONObject;", "context", "Landroid/content/Context;", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ForumEditSystemTempleteDispatcher implements pma {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ForumEditSystemTempleteDispatcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.pma
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) {
            if (context instanceof Activity) {
                PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
                permissionJudgePolicy.clearRequestPermissionList();
                Activity activity = (Activity) context;
                permissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (permissionJudgePolicy.startRequestPermission(activity)) {
                    return;
                }
            } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                throw new IllegalStateException("goto editSystemTemplete context must be Activity!");
            }
            if (jSONObject != null) {
                EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig(context, (int) TaskResponseData.ERROR_NO_TASK_OFFLINE_03, 12009, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), -1, 1.0f);
                String optString = jSONObject.optString("source");
                String optString2 = jSONObject.optString("imgUrl");
                if (Intrinsics.areEqual(optString, "frs_ai_second")) {
                    String optString3 = jSONObject.optString("confirmButtonTitle");
                    editHeadActivityConfig.setEditType(7);
                    editHeadActivityConfig.setCutImageHeightScale(1.0f);
                    editHeadActivityConfig.setConfirmText(optString3);
                    editHeadActivityConfig.setFromWhere(EditHeadActivityConfig.FROM_BOT_PORTRAIT);
                } else {
                    String optString4 = jSONObject.optString("forumId");
                    String optString5 = jSONObject.optString("avatar");
                    String optString6 = jSONObject.optString("name");
                    String optString7 = jSONObject.optString("level_name");
                    String optString8 = jSONObject.optString("level_id");
                    String optString9 = jSONObject.optString("portrait");
                    String optString10 = jSONObject.optString("show_name");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("forumIcon", optString5);
                    jSONObject2.put(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME, optString6);
                    jSONObject2.put("forumId", optString4);
                    jSONObject2.put("levelName", optString7);
                    jSONObject2.put("levelId", optString8);
                    jSONObject2.put("portrait", optString9);
                    jSONObject2.put("showName", optString10);
                    editHeadActivityConfig.getIntent().putExtra("forum_bg_info", jSONObject2.toString());
                    editHeadActivityConfig.setEditType(6);
                    editHeadActivityConfig.setCutImageHeightScale(0.56f);
                    editHeadActivityConfig.setWaterMaskType(3);
                    editHeadActivityConfig.setFromWhere(EditHeadActivityConfig.FROM_FORUM_BACKGROUND);
                    editHeadActivityConfig.setSystemForumBg(true);
                }
                editHeadActivityConfig.setNeedPaste(false);
                editHeadActivityConfig.setImageUrl(optString2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editHeadActivityConfig));
            }
        }
    }
}
