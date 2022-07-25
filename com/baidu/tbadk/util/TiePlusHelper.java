package com.baidu.tbadk.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DownloadManagerActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.ProgressButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextTiebaPlusInfo;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.h;
import com.repackage.d15;
import com.repackage.hg5;
import com.repackage.hp8;
import com.repackage.j36;
import com.repackage.ne5;
import com.repackage.pi;
import com.repackage.sl4;
import com.repackage.w05;
import com.repackage.zg5;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbContent;
import tbclient.PluginUser;
import tbclient.TiebaPlusInfo;
/* loaded from: classes3.dex */
public class TiePlusHelper extends CustomMessageListener implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static List<w05> t;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final TbPageContext<?> b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public ItemData i;
    public AlertDialog j;
    public zg5 k;
    public final List<ProgressButton> l;
    public final PermissionJudgePolicy m;
    public final SharedPreferences n;
    public boolean o;
    public TbHttpMessageTask p;
    public HttpMessageListener q;
    public ItemCardHelper.c r;
    public String s;

    /* loaded from: classes3.dex */
    public static class TiebaPlusAppointResponsedMsg extends JsonHttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TiebaPlusAppointResponsedMsg() {
            super(CmdConfigHttp.CMD_TIEBA_PLUS_GAME_ITEM_ORDER);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiePlusHelper a;

        public a(TiePlusHelper tiePlusHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tiePlusHelper;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || StringUtils.isNull(this.a.h) || StringUtils.isNull(this.a.c) || StringUtils.isNull(this.a.d)) {
                return;
            }
            d15.q().A(this.a.c, this.a.h, this.a.d, -1, -1, null, true, false, false);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        public b(TiePlusHelper tiePlusHelper, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusHelper, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                DownloadManagerActivityConfig downloadManagerActivityConfig = new DownloadManagerActivityConfig(this.a, 3);
                downloadManagerActivityConfig.setCurrentTab(3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, downloadManagerActivityConfig));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiePlusHelper a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TiePlusHelper tiePlusHelper, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusHelper, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tiePlusHelper;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003518) {
                int error = httpResponsedMessage.getError();
                int statusCode = httpResponsedMessage.getStatusCode();
                long parseLong = Long.parseLong((String) ((HttpMessage) httpResponsedMessage.getOrginalMessage()).getParams().get("item_id"));
                if (statusCode == 200 && error == 0) {
                    if (this.a.r != null) {
                        this.a.r.a(parseLong);
                    }
                } else if (statusCode != 200 || error != 210018) {
                    if (this.a.r != null) {
                        this.a.r.b();
                    }
                } else if (this.a.r != null) {
                    this.a.r.a(parseLong);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1616364813, "Lcom/baidu/tbadk/util/TiePlusHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1616364813, "Lcom/baidu/tbadk/util/TiePlusHelper;");
                return;
            }
        }
        t = new ArrayList();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TiePlusHelper(@NonNull Context context) {
        super(2001118);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = false;
        this.a = context;
        this.l = new ArrayList();
        this.n = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0);
        this.m = new PermissionJudgePolicy();
        TbadkCoreApplication.getInst().getSkinType();
        this.m.setOnPermissionsGrantedListener(new a(this));
        if (context instanceof TbPageContextSupport) {
            this.b = ((TbPageContextSupport) this.a).getPageContext();
        } else {
            this.b = null;
        }
    }

    public static boolean i(TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbRichTextTiebaPlusInfo)) == null) {
            if (tbRichTextTiebaPlusInfo != null) {
                return j(tbRichTextTiebaPlusInfo.C());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(TiebaPlusInfo tiebaPlusInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, tiebaPlusInfo)) == null) {
            if (tiebaPlusInfo == null) {
                return false;
            }
            switch (tiebaPlusInfo.jump_type.intValue()) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 7:
                    return true;
                case 2:
                    if (!TextUtils.isEmpty(tiebaPlusInfo.app_id) && !TextUtils.isEmpty(tiebaPlusInfo.app_package) && !TextUtils.isEmpty(tiebaPlusInfo.download_url)) {
                        return true;
                    }
                    break;
                case 6:
                    if (!TextUtils.isEmpty(tiebaPlusInfo.item_id) && !TextUtils.isEmpty(tiebaPlusInfo.desc) && !TextUtils.isEmpty(tiebaPlusInfo.title)) {
                        return true;
                    }
                    break;
                default:
                    return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static PbContent o(List<PbContent> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, list)) == null) {
            if (list == null) {
                return null;
            }
            for (PbContent pbContent : list) {
                if (pbContent.type.intValue() == 35 || pbContent.type.intValue() == 36) {
                    TiebaPlusInfo tiebaPlusInfo = pbContent.tiebaplus_info;
                    if (tiebaPlusInfo != null && tiebaPlusInfo.jump_type.intValue() == 5) {
                        return pbContent;
                    }
                }
            }
            return null;
        }
        return (PbContent) invokeL.objValue;
    }

    public static List<PbContent> q(List<PbContent> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, list)) == null) {
            if (list == null) {
                return null;
            }
            for (PbContent pbContent : list) {
                if (pbContent.type.intValue() == 35 || pbContent.type.intValue() == 36) {
                    if (j(pbContent.tiebaplus_info)) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(pbContent);
                        return arrayList;
                    }
                }
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static void u(Activity activity, PluginUser pluginUser) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, activity, pluginUser) == null) || pluginUser == null || activity == null || !ViewHelper.checkUpIsLogin(activity)) {
            return;
        }
        if (UtilHelper.isCurrentAccount(String.valueOf(pluginUser.user_id))) {
            BdTopToast bdTopToast = new BdTopToast(activity, 2000);
            bdTopToast.i(false);
            bdTopToast.h(activity.getString(R.string.obfuscated_res_0x7f0f139c));
            bdTopToast.j((ViewGroup) activity.findViewById(16908290));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(activity, pluginUser.user_id.longValue(), pluginUser.user_name_show, pluginUser.user_photo, pluginUser.user_type.intValue())));
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbHttpMessageTask h = h();
            if (h != null && MessageManager.getInstance().findTask(h.getCmd()) == null) {
                MessageManager.getInstance().registerTask(h);
            }
            HttpMessageListener n = n();
            TbPageContext<?> tbPageContext = this.b;
            if (tbPageContext != null) {
                tbPageContext.registerListener(n);
            }
        }
    }

    public void B(ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, progressButton) == null) || progressButton == null) {
            return;
        }
        this.l.remove(progressButton);
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k = null;
            AlertDialog alertDialog = this.j;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.j = null;
            }
            this.l.clear();
        }
    }

    public void D(long j, String str, ItemCardHelper.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), str, cVar}) == null) || j == 0 || StringUtils.isNull(str)) {
            return;
        }
        if (cVar != null) {
            this.r = cVar;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_TIEBA_PLUS_GAME_ITEM_ORDER);
        httpMessage.addParam("item_id", j);
        httpMessage.addParam("item_name", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public TiePlusHelper E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.d = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.f = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public void G(ItemCardHelper.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.r = cVar;
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.s = str;
        }
    }

    public void I(zg5 zg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zg5Var) == null) {
            this.k = zg5Var;
        }
    }

    public TiePlusHelper J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.h = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper L(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            this.o = z;
            return this;
        }
        return (TiePlusHelper) invokeZ.objValue;
    }

    public void M(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, itemData) == null) {
            this.i = itemData;
        }
    }

    public TiePlusHelper N(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper P(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.g = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || StringUtils.isNull(this.d)) {
            return;
        }
        for (ProgressButton progressButton : this.l) {
            progressButton.setCurProgress(-1);
            Z(this.c, this.d, this.a, progressButton);
        }
    }

    public final void R(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, activity) == null) {
            if (s(activity)) {
                d15.q().A(this.c, this.h, this.d, -1, -1, null, true, false, false);
            } else {
                W(activity);
            }
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            SharedPreferences sharedPreferences = this.n;
            int i = sharedPreferences.getInt(this.c + this.d, 0);
            for (ProgressButton progressButton : this.l) {
                progressButton.setTag((byte) 1);
                progressButton.j(i);
            }
            DownloadData downloadData = new DownloadData(this.c);
            downloadData.setExtra(Integer.valueOf(i));
            downloadData.setName(this.d);
            downloadData.setStatus(5);
            d15.q().w(downloadData);
        }
    }

    public final void T(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, activity) == null) && activity != null && s(activity)) {
            zg5 zg5Var = this.k;
            if (zg5Var != null) {
                zg5Var.dismiss();
            }
            ScreenTopToast screenTopToast = new ScreenTopToast(activity);
            screenTopToast.m(activity.getResources().getString(R.string.obfuscated_res_0x7f0f139b));
            screenTopToast.k(activity.getResources().getString(R.string.obfuscated_res_0x7f0f04de));
            screenTopToast.j(new b(this, activity));
            screenTopToast.n((ViewGroup) activity.findViewById(16908290));
        }
    }

    public void U(TiebaPlusInfo tiebaPlusInfo, final TiePlusStat.RichTextType richTextType, final String str) {
        String string;
        String string2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, tiebaPlusInfo, richTextType, str) == null) {
            int intValue = tiebaPlusInfo.jump_type.intValue();
            String str2 = tiebaPlusInfo.h5_jump_number;
            UtilHelper.copyToClipBoard(str2);
            if (intValue == 7) {
                string = this.a.getString(R.string.obfuscated_res_0x7f0f1398);
                string2 = this.a.getString(R.string.obfuscated_res_0x7f0f139f, str2);
            } else {
                string = this.a.getString(R.string.obfuscated_res_0x7f0f1399);
                string2 = this.a.getString(R.string.obfuscated_res_0x7f0f139e, str2);
            }
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.b.getPageActivity());
            tBAlertBuilder.u(string);
            tBAlertBuilder.p(string2);
            tBAlertBuilder.n(true);
            tBAlertBuilder.i(false);
            tBAlertBuilder.r(new TBAlertConfig.a(this.a.getString(R.string.obfuscated_res_0x7f0f0eff), TBAlertConfig.OperateBtnStyle.SECONDARY, new View.OnClickListener() { // from class: com.repackage.sc5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        TiePlusHelper.this.v(view2);
                    }
                }
            }), new TBAlertConfig.a(this.a.getString(R.string.obfuscated_res_0x7f0f0dcf), TBAlertConfig.OperateBtnStyle.MAIN, new View.OnClickListener() { // from class: com.repackage.rc5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        TiePlusHelper.this.w(richTextType, str, view2);
                    }
                }
            }));
            this.j = tBAlertBuilder.w();
            TiePlusStat.f(TiePlusStat.StatType.WECHAT_DIALOG_EXPOSE, richTextType, TiePlusStat.WechatDialogType.COPY, str);
        }
    }

    public void V(final TiebaPlusInfo tiebaPlusInfo, final TiePlusStat.RichTextType richTextType, final String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048596, this, tiebaPlusInfo, richTextType, str) == null) {
            LinearLayout linearLayout = new LinearLayout(this.a);
            TbImageView tbImageView = new TbImageView(this.a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(pi.f(this.a, R.dimen.tbds562), pi.f(this.a, R.dimen.tbds562));
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080f19);
            } else if (skinType == 4) {
                SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080f17);
            } else {
                SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080f1a);
            }
            tbImageView.setLayoutParams(layoutParams);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            linearLayout.setPadding(pi.f(this.a, R.dimen.M_W_X017), 0, pi.f(this.a, R.dimen.M_W_X017), pi.f(this.a, R.dimen.M_W_X007));
            linearLayout.setGravity(17);
            linearLayout.addView(tbImageView);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.b.getPageActivity());
            tBAlertBuilder.u(this.a.getString(R.string.obfuscated_res_0x7f0f139a));
            tBAlertBuilder.j(linearLayout);
            tBAlertBuilder.i(false);
            tBAlertBuilder.r(new TBAlertConfig.a(this.a.getString(R.string.obfuscated_res_0x7f0f0eff), TBAlertConfig.OperateBtnStyle.SECONDARY, new View.OnClickListener() { // from class: com.repackage.uc5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        TiePlusHelper.this.x(view2);
                    }
                }
            }), new TBAlertConfig.a(this.a.getString(R.string.obfuscated_res_0x7f0f1397), TBAlertConfig.OperateBtnStyle.MAIN, new View.OnClickListener() { // from class: com.repackage.tc5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        TiePlusHelper.this.y(tiebaPlusInfo, richTextType, str, view2);
                    }
                }
            }));
            this.j = tBAlertBuilder.w();
            TiePlusStat.f(TiePlusStat.StatType.WECHAT_DIALOG_EXPOSE, richTextType, TiePlusStat.WechatDialogType.DIRECT, str);
        }
    }

    public final void W(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, activity) == null) || activity == null) {
            return;
        }
        this.m.clearRequestPermissionList();
        this.m.appendRequestPermission(this.b.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        this.m.appendRequestPermission(this.b.getPageActivity(), h.i);
        this.m.startRequestPermission(activity);
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            TbHttpMessageTask h = h();
            if (h != null && MessageManager.getInstance().findTask(h.getCmd()) != null) {
                MessageManager.getInstance().unRegisterTask(h.getCmd());
            }
            HttpMessageListener n = n();
            if (n == null || !MessageManager.getInstance().hasListener(n.getCmd())) {
                return;
            }
            MessageManager.getInstance().unRegisterListener(n());
        }
    }

    public void Y(@NonNull String str, @NonNull Context context, @NonNull TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, str, context, textView) == null) {
            if (!t(context, str) && !d15.q().s(str)) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public void Z(@NonNull String str, @NonNull String str2, @NonNull Context context, @NonNull ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048600, this, str, str2, context, progressButton) == null) {
            boolean h = progressButton.h();
            if (t(context, str)) {
                progressButton.setTag((byte) 4);
                progressButton.setText(context.getString(h ? R.string.obfuscated_res_0x7f0f08cc : R.string.obfuscated_res_0x7f0f0dcf));
            } else if (d15.q().s(str)) {
                progressButton.setTag((byte) 2);
                progressButton.setText(context.getString(h ? R.string.obfuscated_res_0x7f0f08cb : R.string.obfuscated_res_0x7f0f08e8));
            } else if (!d15.q().t(str) && !d15.q().r(str)) {
                File m = d15.q().m(str, str2);
                if (m != null && m.exists()) {
                    SharedPreferences sharedPreferences = this.n;
                    int i = sharedPreferences.getInt(str + str2, -1);
                    progressButton.setTag((byte) 3);
                    progressButton.setCurProgress(i);
                    progressButton.setText(context.getString(h ? R.string.obfuscated_res_0x7f0f07bd : R.string.obfuscated_res_0x7f0f07bc));
                    if (this.o) {
                        e();
                        return;
                    }
                    return;
                }
                progressButton.setCurProgress(-1);
                progressButton.setTag((byte) 0);
                if (h) {
                    progressButton.setText(context.getString(R.string.obfuscated_res_0x7f0f08ea));
                } else if (!StringUtils.isNull(this.s)) {
                    progressButton.setText(this.s);
                } else {
                    progressButton.setText(context.getString(R.string.obfuscated_res_0x7f0f04ef));
                }
            } else {
                SharedPreferences sharedPreferences2 = this.n;
                int i2 = sharedPreferences2.getInt(str + str2, -1);
                progressButton.setTag((byte) 1);
                progressButton.j(i2);
                if (this.o) {
                    e();
                }
            }
        }
    }

    public final void a0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            SharedPreferences sharedPreferences = this.n;
            if (i != sharedPreferences.getInt(this.c + this.d, -1)) {
                SharedPreferences.Editor edit = this.n.edit();
                edit.putInt(this.c + this.d, i);
                edit.apply();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            hg5.c().a(this.c, this.f);
        }
    }

    public void f(ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, progressButton) == null) || progressButton == null || this.l.contains(progressButton)) {
            return;
        }
        this.l.add(progressButton);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(w05 w05Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, w05Var) == null) || w05Var == null) {
            return;
        }
        for (w05 w05Var2 : t) {
            if (TextUtils.isEmpty(w05Var.f) || w05Var.f.equals(w05Var2.f)) {
                return;
            }
            while (r0.hasNext()) {
            }
        }
        t.add(w05Var);
    }

    public final TbHttpMessageTask h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            TbHttpMessageTask tbHttpMessageTask = this.p;
            if (tbHttpMessageTask != null) {
                return tbHttpMessageTask;
            }
            TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_TIEBA_PLUS_GAME_ITEM_ORDER, TbConfig.SERVER_ADDRESS + "c/c/item/subscribeitem");
            this.p = tbHttpMessageTask2;
            tbHttpMessageTask2.setResponsedClass(TiebaPlusAppointResponsedMsg.class);
            return this.p;
        }
        return (TbHttpMessageTask) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            SharedPreferences sharedPreferences = this.n;
            if (sharedPreferences.getInt(this.c + this.d, -1) != -1) {
                SharedPreferences.Editor edit = this.n.edit();
                edit.remove(this.c + this.d);
                edit.apply();
            }
        }
    }

    public void l(String str, int i, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)}) == null) || StringUtils.isNull(str) || this.b == null) {
            return;
        }
        if (i == 1) {
            if (i2 == 0 || i2 == 1) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("need_scheme_blacklist", true);
                hp8.b(this.b, str, bundle);
            } else if (i2 != 2) {
            } else {
                sl4.m(this.a, str, false);
            }
        } else if (i != 4) {
        } else {
            if (!t(this.a, "com.tencent.mm")) {
                BdToast.b(this.a.getApplicationContext(), this.a.getText(R.string.obfuscated_res_0x7f0f13a1)).h();
            } else if (TextUtils.isEmpty(str)) {
            } else {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst().getContext(), TbConfig.WEIXIN_APP_ID);
                WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                req.userName = str;
                if (!TextUtils.isEmpty(str2)) {
                    req.path = str2;
                }
                createWXAPI.sendReq(req);
            }
        }
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public final HttpMessageListener n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            HttpMessageListener httpMessageListener = this.q;
            if (httpMessageListener != null) {
                return httpMessageListener;
            }
            c cVar = new c(this, CmdConfigHttp.CMD_TIEBA_PLUS_GAME_ITEM_ORDER);
            this.q = cVar;
            return cVar;
        }
        return (HttpMessageListener) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        File m;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, view2) == null) && view2 != null && (view2.getTag() instanceof Byte)) {
            if ((view2 instanceof ProgressButton) && (tbPageContext = this.b) != null) {
                r((ProgressButton) view2, tbPageContext.getPageActivity());
                return;
            }
            switch (((Byte) view2.getTag()).byteValue()) {
                case 16:
                    l(this.g, 1, "", 0);
                    return;
                case 17:
                    l(this.e, 1, "", 0);
                    return;
                case 18:
                    if (!StringUtils.isNull(this.c) && !StringUtils.isNull(this.h)) {
                        d15.q().h(this.h, this.c, true);
                        File j = d15.q().j(this.c);
                        if (j != null && j.exists()) {
                            j.delete();
                        }
                        if (!StringUtils.isNull(this.d) && (m = d15.q().m(this.c, this.d)) != null && m.exists()) {
                            m.delete();
                        }
                        k();
                        DownloadData downloadData = new DownloadData(this.c);
                        downloadData.setStatus(4);
                        d15.q().w(downloadData);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921626, this.c));
                    }
                    hg5.c().h(this.c);
                    zg5 zg5Var = this.k;
                    if (zg5Var != null) {
                        zg5Var.dismiss();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public final void r(ProgressButton progressButton, @NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048614, this, progressButton, activity) == null) || progressButton == null || progressButton.getVisibility() != 0 || !(progressButton.getTag() instanceof Byte) || StringUtils.isNull(this.c) || StringUtils.isNull(this.d) || StringUtils.isNull(this.h)) {
            return;
        }
        byte byteValue = ((Byte) progressButton.getTag()).byteValue();
        if (byteValue == 0) {
            if (this.i != null) {
                j36 j36Var = new j36();
                j36Var.a = this.i;
                j36Var.b = 2;
                Context context = this.a;
                if ((context instanceof Activity) && !"DownloadManagerActivity".equals(((Activity) context).getClass().getSimpleName())) {
                    j36Var.c = 1;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921627, j36Var));
            }
            S();
            R(activity);
            if (this.o) {
                e();
                T(activity);
            }
        } else if (byteValue != 1) {
            if (byteValue == 2) {
                R(activity);
            } else if (byteValue == 3) {
                S();
                R(activity);
            } else if (byteValue != 4) {
            } else {
                z(this.a, this.c);
            }
        } else if (s(activity)) {
            if (!d15.q().r(this.c) && !d15.q().t(this.c)) {
                DownloadData downloadData = new DownloadData(this.c);
                downloadData.setStatus(4);
                d15.q().w(downloadData);
                return;
            }
            d15.q().g(this.h, this.c);
        } else {
            W(activity);
        }
    }

    public final boolean s(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, activity)) == null) {
            if (activity == null) {
                return true;
            }
            return this.m.checkPermissionGranted(activity, "android.permission.WRITE_EXTERNAL_STORAGE") && this.m.checkPermissionGranted(activity, h.i);
        }
        return invokeL.booleanValue;
    }

    public final boolean t(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048616, this, context, str)) == null) {
            if (context != null) {
                try {
                    if (context.getPackageManager() != null) {
                        context.getPackageManager().getPackageInfo(str, 64);
                        return true;
                    }
                    return false;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public /* synthetic */ void v(View view2) {
        AlertDialog alertDialog = this.j;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public /* synthetic */ void w(TiePlusStat.RichTextType richTextType, String str, View view2) {
        AlertDialog alertDialog = this.j;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (!t(this.a, "com.tencent.mm")) {
            BdToast.b(this.a.getApplicationContext(), this.a.getText(R.string.obfuscated_res_0x7f0f13a1)).h();
            return;
        }
        ne5.c(this.a);
        TiePlusStat.f(TiePlusStat.StatType.WECHAT_DIALOG_CLICK, richTextType, TiePlusStat.WechatDialogType.COPY, str);
    }

    public /* synthetic */ void x(View view2) {
        AlertDialog alertDialog = this.j;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public /* synthetic */ void y(TiebaPlusInfo tiebaPlusInfo, TiePlusStat.RichTextType richTextType, String str, View view2) {
        AlertDialog alertDialog = this.j;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (!t(this.a, "com.tencent.mm")) {
            BdToast.b(this.a.getApplicationContext(), this.a.getText(R.string.obfuscated_res_0x7f0f13a1)).h();
            return;
        }
        ne5.d(tiebaPlusInfo, this.a.getString(R.string.obfuscated_res_0x7f0f13a0));
        TiePlusStat.f(TiePlusStat.StatType.WECHAT_DIALOG_CLICK, richTextType, TiePlusStat.WechatDialogType.DIRECT, str);
    }

    public final boolean z(Context context, String str) {
        InterceptResult invokeLL;
        ResolveInfo next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048621, this, context, str)) == null) {
            if (TextUtils.isEmpty(str) || context == null) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0 || (next = queryIntentActivities.iterator().next()) == null) {
                return false;
            }
            String str2 = next.activityInfo.name;
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(str, str2));
            intent2.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            try {
                context.startActivity(intent2);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, customResponsedMessage) == null) && (customResponsedMessage instanceof DownloadMessage)) {
            DownloadMessage downloadMessage = (DownloadMessage) customResponsedMessage;
            if (downloadMessage.getData() == null || downloadMessage.getData().size() <= 0 || StringUtils.isNull(this.c)) {
                return;
            }
            for (DownloadData downloadData : downloadMessage.getData()) {
                if (downloadData != null) {
                    if (downloadData.getStatus() == 21 && !StringUtils.isNull(this.d)) {
                        for (ProgressButton progressButton : this.l) {
                            Z(this.c, this.d, this.a, progressButton);
                        }
                    } else if (this.c.equals(downloadData.getId())) {
                        int status = downloadData.getStatus();
                        if (status == 0) {
                            if (!StringUtils.isNull(this.d)) {
                                for (ProgressButton progressButton2 : this.l) {
                                    progressButton2.setCurProgress(100);
                                }
                            }
                            k();
                            return;
                        } else if (status == 1) {
                            int k = (int) (d15.q().k(this.c) * 100.0f);
                            a0(k);
                            for (ProgressButton progressButton3 : this.l) {
                                progressButton3.setTag((byte) 1);
                                progressButton3.j(k);
                            }
                            return;
                        } else if (status == 2) {
                            TbPageContext<?> tbPageContext = this.b;
                            if (tbPageContext != null) {
                                tbPageContext.showToast((int) R.string.obfuscated_res_0x7f0f04f4);
                            }
                            Q();
                            return;
                        } else if (status == 3) {
                            k();
                            return;
                        } else if (status == 4) {
                            Q();
                            return;
                        } else if (status != 5) {
                            return;
                        } else {
                            int i = 0;
                            if (downloadData.getExtra() != null && (downloadData.getExtra() instanceof Integer)) {
                                i = ((Integer) downloadData.getExtra()).intValue();
                                a0(i);
                            }
                            for (ProgressButton progressButton4 : this.l) {
                                progressButton4.setTag((byte) 1);
                                progressButton4.j(i);
                            }
                            return;
                        }
                    }
                }
            }
        }
    }
}
