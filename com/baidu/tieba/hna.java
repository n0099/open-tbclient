package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.idlehelp.IdleHandlerManager;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.utils.BasicVideoParserKt;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.GrowthStatsUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.mainentrance.MainEntrance;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionManager;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.tieba.tblauncher.SchemaRouteActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.codec.language.bm.ResourceConstants;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hna {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public boolean b;

    /* loaded from: classes6.dex */
    public class a implements BdUniDispatchSchemeController.OnSchemeParsedCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;

        public a(hna hnaVar, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hnaVar, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = intent;
        }

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.OnSchemeParsedCallback
        public void onCallBack(HashMap<String, Object> hashMap) {
            int i;
            String str;
            String str2;
            String str3;
            String str4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && hashMap != null && this.a != null) {
                Object obj = hashMap.get(BdUniDispatchSchemeController.NATIVE_PARAM_MAINTAB_LOCATE);
                if (obj instanceof Integer) {
                    i = ((Integer) obj).intValue();
                } else {
                    i = -1;
                }
                Object obj2 = hashMap.get(BdUniDispatchSchemeController.NATIVE_PARAM_MAINTAB_SUBTAB);
                String str5 = null;
                if (obj2 instanceof String) {
                    str = (String) obj2;
                } else {
                    str = null;
                }
                Object obj3 = hashMap.get(BdUniDispatchSchemeController.PARAM_TAB_NAME);
                if (obj3 instanceof String) {
                    str2 = (String) obj3;
                } else {
                    str2 = null;
                }
                Object obj4 = hashMap.get(BdUniDispatchSchemeController.PARAM_TAB_CODE);
                if (obj4 instanceof String) {
                    str3 = (String) obj4;
                } else {
                    str3 = null;
                }
                if (i != -1) {
                    this.a.putExtra(MainEntrance.KEY_IS_FROM_SCHEME, true);
                    this.a.putExtra(MainEntrance.GOTO_TYPE, i);
                    this.a.putExtra(MainEntrance.GO_SUB_TYPE, str);
                    this.a.putExtra(MainEntrance.GO_SUB_TAB_NAME, str2);
                    this.a.putExtra(MainEntrance.GO_SUB_TAB_CODE, str3);
                    MainEntrance.initMainTabType = i;
                    Object obj5 = hashMap.get(BdUniDispatchSchemeController.PARAM_NEW_GOD_FROM);
                    if (obj5 instanceof String) {
                        str4 = (String) obj5;
                    } else {
                        str4 = null;
                    }
                    Object obj6 = hashMap.get(BdUniDispatchSchemeController.PARAM_FIELD_ID);
                    if (obj6 instanceof String) {
                        str5 = (String) obj6;
                    }
                    this.a.putExtra(BdUniDispatchSchemeController.PARAM_NEW_GOD_FROM, str4);
                    this.a.putExtra(BdUniDispatchSchemeController.PARAM_FIELD_ID, str5);
                }
                mt4.w().M(true);
                if (i == 1 && MainEntrance.GO_TO_FORUM_SQUARE.equals(str)) {
                    MainEntrance.ENTER_BAR_DEFAULT_INDEX = MainEntrance.ENTER_BAR_DEFAULT_INDEX_BAR_SQUARE;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921528));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ hna b;

        public b(hna hnaVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hnaVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hnaVar;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                IdleHandlerManager.getInstance().runIdleTaskImmediately();
                UrlManager.getInstance().dealOneLink(this.b.a.getPageContext(), new String[]{this.a});
            }
        }
    }

    public hna(MainTabActivity mainTabActivity, qma qmaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, qmaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.a = mainTabActivity;
    }

    public void b(Intent intent) {
        long mainTabActJumpOtherDelayTime;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, intent) != null) || intent == null) {
            return;
        }
        String dataString = intent.getDataString();
        UtilHelper.clearClipBoardBySchemaParam(dataString);
        if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmaintab://")) {
            String decode = Uri.decode(intent.getData().getEncodedPath());
            if (StringUtils.isNull(decode)) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE).param("obj_type", 1).param(TiebaStatic.Params.OBJ_TO, 1).param("obj_name", TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, 1);
                cu4.a(param, decode);
                TiebaStatic.log(param);
                return;
            }
            if (decode.startsWith(ResourceConstants.CMT)) {
                decode = decode.substring(2);
            }
            Map<String, String> paramPair = UrlManager.getParamPair(decode);
            if (paramPair == null) {
                return;
            }
            if ("bpush".equals(paramPair.get("fr"))) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE);
                cu4.b(statisticItem, paramPair);
                statisticItem.param("obj_locate", paramPair.get("obj_locate"));
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_source", paramPair.get("obj_source"));
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, paramPair.get(TiebaStatic.Params.OBJ_PARAM2));
                statisticItem.param(TiebaStatic.Params.OBJ_TO, 1);
                statisticItem.param("obj_id", paramPair.get(TiebaStatic.Params.BDID));
                statisticItem.param("obj_name", TbadkCoreApplication.getInst().getStartType());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, 1);
                if (!di.isEmpty(paramPair.get(BasicVideoParserKt.EXT_LOG))) {
                    try {
                        JSONObject jSONObject = new JSONObject(paramPair.get(BasicVideoParserKt.EXT_LOG));
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            statisticItem.param(next, jSONObject.getString(next));
                        }
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                }
                TiebaStatic.log(statisticItem);
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                httpMessage.addParam("call_url", dataString);
                MessageManager.getInstance().sendMessage(httpMessage);
            }
            mt4.w().M(true);
        } else if (!StringUtils.isNull(dataString) && (dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT) || dataString.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_ZM) || dataString.startsWith(UrlSchemaHelper.SCHEMA_LIVE_SDK) || dataString.startsWith(UrlSchemaHelper.SCHEMA_CHUSHOU_LIVE_SDK))) {
            String dataString2 = intent.getDataString();
            if (!StringUtils.isNull(dataString2) && PermissionUtil.isAgreePrivacyPolicy()) {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{dataString2});
                mt4.w().M(true);
            }
        } else if (!StringUtils.isNULL(dataString) && dataString.startsWith(BdUniDispatchSchemeController.SCHEME)) {
            BdUniDispatchSchemeController.getInstance().parseMainTabScheme(intent.getData(), new a(this, intent));
        }
        String stringExtra = intent.getStringExtra("target_scheme");
        if (!StringUtils.isNull(stringExtra)) {
            SafeHandler inst = SafeHandler.getInst();
            b bVar = new b(this, stringExtra);
            if (this.b) {
                mainTabActJumpOtherDelayTime = 0;
            } else {
                mainTabActJumpOtherDelayTime = DeviceInfoUtil.getMainTabActJumpOtherDelayTime();
            }
            inst.postDelayed(bVar, mainTabActJumpOtherDelayTime);
            this.a.getIntent().removeExtra("target_scheme");
            this.a.getIntent().putExtra(MainTabActivityConfig.TARGET_SCHEME_BAK, stringExtra);
            GrowthStatsUtil.statisticChannel("push", stringExtra);
        } else if (!StringUtils.isNull(SchemaRouteActivity.b)) {
            SchemeActionManager.getInstance().doSchemeAction(this.a.getPageContext(), SchemaRouteActivity.b);
            SchemaRouteActivity.b = null;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = true;
        }
    }
}
