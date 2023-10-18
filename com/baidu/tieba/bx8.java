package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bx8 extends ww8<TextMsg, bv8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ww8
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public bx8() {
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
    @Override // com.baidu.tieba.ww8
    /* renamed from: h */
    public TextMsg e(bv8 bv8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bv8Var)) == null) {
            TextMsg textMsg = new TextMsg();
            textMsg.setText((bv8Var == null || (r5 = bv8Var.c()) == null) ? "" : "");
            return textMsg;
        }
        return (TextMsg) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ww8
    /* renamed from: i */
    public bv8 g(TextMsg sdkMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sdkMsg)) == null) {
            Intrinsics.checkNotNullParameter(sdkMsg, "sdkMsg");
            bv8 bv8Var = new bv8();
            String msgContent = sdkMsg.getMsgContent();
            if (msgContent == null) {
                msgContent = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(msgContent, "sdkMsg.msgContent ?: \"\"");
            }
            if (!ad.isEmpty(msgContent)) {
                try {
                    bv8Var.e(new JSONObject(msgContent).optJSONArray("struct_data"));
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            }
            if (bv8Var.b() == null) {
                String text = sdkMsg.getText();
                Intrinsics.checkNotNullExpressionValue(text, "sdkMsg.getText()");
                bv8Var.f(text);
            }
            String text2 = sdkMsg.getText();
            Intrinsics.checkNotNullExpressionValue(text2, "sdkMsg.getText()");
            bv8Var.d(text2);
            return bv8Var;
        }
        return (bv8) invokeL.objValue;
    }
}
