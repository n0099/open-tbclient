package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.impersonal.sprite.SpriteMsgProcessor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class a19<SdkMsg extends ChatMsg, T> implements d19<SdkMsg, ez8<T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract int c();

    public abstract SdkMsg e(T t);

    public abstract T g(SdkMsg sdkmsg);

    public a19() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.d19
    /* renamed from: d */
    public SdkMsg b(ez8<T> msg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, msg)) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            SdkMsg e = e(msg.f());
            e.setSenderUid(BIMManager.getBdUidFromBdUK(String.valueOf(SpriteMsgProcessor.m.a())));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", c());
            jSONObject.put("from", "android");
            e.setContentExtra(jSONObject.toString());
            return e;
        }
        return (SdkMsg) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.d19
    /* renamed from: f */
    public ez8<T> a(SdkMsg msg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, msg)) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            ez8<T> ez8Var = new ez8<>();
            ez8Var.i(g(msg));
            ez8Var.c(msg.getMsgId());
            String msgKey = msg.getMsgKey();
            Intrinsics.checkNotNullExpressionValue(msgKey, "msg.msgKey");
            ez8Var.d(msgKey);
            ez8Var.e().l(msg.getContacterUk());
            ez8Var.e().k(mib.c(msg.getSenderUid(), 0L));
            ez8Var.e().i(msg.getStatus());
            ez8Var.j(msg);
            boolean isSelf = msg.isSelf(TbadkApplication.getInst());
            ez8Var.e().h(isSelf);
            if (!isSelf) {
                ez8Var.e().g(TbSingleton.getInstance().getFunnySpriteAvatar());
                ez8Var.e().f(TbSingleton.getInstance().getFunnySpriteName());
            } else {
                ez8Var.e().g(TbadkCoreApplication.getCurrentPortrait());
                ez8Var.e().f(TbadkCoreApplication.getCurrentAccountNameShow());
            }
            if (!StringUtils.isNull(msg.getContentExtra())) {
                try {
                    JSONObject jSONObject = new JSONObject(msg.getContentExtra());
                    ez8Var.e().j(jSONObject.optInt("type"));
                    ez8Var.e().e(jSONObject.optString("from"));
                } catch (JSONException e) {
                    if (!TbadkApplication.getInst().isDebugMode()) {
                        e.printStackTrace();
                    } else {
                        throw e;
                    }
                }
            }
            String msgContent = msg.getMsgContent();
            if (msgContent == null) {
                msgContent = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(msgContent, "msg.msgContent ?: \"\"");
            }
            if (!ei.isEmpty(msgContent)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(msgContent);
                    dz8 g = ez8Var.g();
                    String optString = jSONObject2.optString("origin_msg_key");
                    Intrinsics.checkNotNullExpressionValue(optString, "msgContentObj.optString(\"origin_msg_key\")");
                    g.b(optString);
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            }
            return ez8Var;
        }
        return (ez8) invokeL.objValue;
    }
}
