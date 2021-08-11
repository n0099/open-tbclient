package com.baidu.tieba.funAd.http;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.FunAdServerRecordSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class FunAdRecordHttpMessage extends HttpMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CLICK_AD_RECORD = "c14116";
    public static final String REQUEST_RECORD = "c14114";
    public static final String SHOW_AD_RECORD = "c14115";
    public static final String SKIP_SPLASH_RECORD = "c14117";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdRecordHttpMessage(int i2, String str, String str2, String str3, String str4, String str5) {
        super(CmdConfigHttp.CMD_FUN_AD_RECORD);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, str2, str3, str4, str5};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("obj_source", String.valueOf(i2));
            jSONObject.put("obj_type", str);
            if (!StringUtils.isNull(str2)) {
                jSONObject.put("obj_locate", str2);
            }
            if (!StringUtils.isNull(str3)) {
                jSONObject.put("tid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                jSONObject.put("fid", str4);
            }
            if (!StringUtils.isNull(str5)) {
                jSONObject.put(TiebaStatic.Params.RESOURCE_ID, str5);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(REQUEST_RECORD, jSONObject);
            addParam("ad_str", Uri.encode(jSONObject2.toString()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void uploadRequestRecord(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(65539, null, str, str2, str3, str4, str5) == null) && FunAdServerRecordSwitch.isOpen()) {
            MessageManager.getInstance().sendMessage(new FunAdRecordHttpMessage(6, str, str2, str3, str4, str5));
        }
    }

    public static void uploadShowOrClickRecord(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9, str10}) == null) && FunAdServerRecordSwitch.isOpen()) {
            MessageManager.getInstance().sendMessage(new FunAdRecordHttpMessage(str, 6, str2, str3, str4, str5, str6, str7, str8, str9, str10));
        }
    }

    public static void uploadSplashSkipRecord(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) && FunAdServerRecordSwitch.isOpen()) {
            MessageManager.getInstance().sendMessage(new FunAdRecordHttpMessage(6, str));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdRecordHttpMessage(String str, int i2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        super(CmdConfigHttp.CMD_FUN_AD_RECORD);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {str, Integer.valueOf(i2), str2, str3, str4, str5, str6, str7, str8, str9, str10};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("obj_source", String.valueOf(i2));
            jSONObject.put("obj_type", str2);
            if (!StringUtils.isNull(str4)) {
                jSONObject.put("tid", str4);
            }
            if (!StringUtils.isNull(str3)) {
                jSONObject.put("obj_locate", str3);
            }
            if (!StringUtils.isNull(str5)) {
                jSONObject.put("fid", str5);
            }
            if (!StringUtils.isNull(str6)) {
                jSONObject.put(TiebaStatic.Params.AD_TITLE, str6);
            }
            if (!StringUtils.isNull(str7)) {
                jSONObject.put(TiebaStatic.Params.AD_DESC, str7);
            }
            if (!StringUtils.isNull(str8)) {
                jSONObject.put("ad_pic", str8);
            }
            if (!StringUtils.isNull(str9)) {
                jSONObject.put(TiebaStatic.Params.AD_SOURCE, str9);
            }
            if (!StringUtils.isNull(str10)) {
                jSONObject.put(TiebaStatic.Params.AD_TYPE, str10);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str, jSONObject);
            addParam("ad_str", Uri.encode(jSONObject2.toString()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdRecordHttpMessage(int i2, String str) {
        super(CmdConfigHttp.CMD_FUN_AD_RECORD);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("obj_source", String.valueOf(i2));
            jSONObject.put("obj_type", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(SKIP_SPLASH_RECORD, jSONObject);
            addParam("ad_str", Uri.encode(jSONObject2.toString()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
