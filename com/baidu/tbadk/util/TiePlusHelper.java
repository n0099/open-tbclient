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
import c.a.d.f.p.n;
import c.a.o0.c1.r0;
import c.a.o0.t.o;
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
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbContent;
import tbclient.PluginUser;
import tbclient.TiebaPlusInfo;
/* loaded from: classes5.dex */
public class TiePlusHelper extends CustomMessageListener implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static List<o> t;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public final TbPageContext<?> f30636b;

    /* renamed from: c  reason: collision with root package name */
    public String f30637c;

    /* renamed from: d  reason: collision with root package name */
    public String f30638d;

    /* renamed from: e  reason: collision with root package name */
    public String f30639e;

    /* renamed from: f  reason: collision with root package name */
    public String f30640f;

    /* renamed from: g  reason: collision with root package name */
    public String f30641g;

    /* renamed from: h  reason: collision with root package name */
    public String f30642h;
    public ItemData i;
    public AlertDialog j;
    public c.a.o0.e1.p.b k;
    public final List<ProgressButton> l;
    public final PermissionJudgePolicy m;
    public final SharedPreferences n;
    public boolean o;
    public TbHttpMessageTask p;
    public HttpMessageListener q;
    public ItemCardHelper.c r;
    public String s;

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || StringUtils.isNull(this.a.f30642h) || StringUtils.isNull(this.a.f30637c) || StringUtils.isNull(this.a.f30638d)) {
                return;
            }
            c.a.o0.v.c.q().A(this.a.f30637c, this.a.f30642h, this.a.f30638d, -1, -1, null, true, false, false);
        }
    }

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                DownloadManagerActivityConfig downloadManagerActivityConfig = new DownloadManagerActivityConfig(this.a, 3);
                downloadManagerActivityConfig.setCurrentTab(3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, downloadManagerActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
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
                        this.a.r.b(parseLong);
                    }
                } else if (statusCode != 200 || error != 210018) {
                    if (this.a.r != null) {
                        this.a.r.a();
                    }
                } else if (this.a.r != null) {
                    this.a.r.b(parseLong);
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
            this.f30636b = ((TbPageContextSupport) this.a).getPageContext();
        } else {
            this.f30636b = null;
        }
    }

    public static boolean i(TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbRichTextTiebaPlusInfo)) == null) {
            if (tbRichTextTiebaPlusInfo != null) {
                return j(tbRichTextTiebaPlusInfo.B());
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
            bdTopToast.h(activity.getString(R.string.obfuscated_res_0x7f0f13a9));
            bdTopToast.j((ViewGroup) activity.findViewById(16908290));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(activity, pluginUser.user_id.longValue(), pluginUser.user_name_show, pluginUser.user_photo, pluginUser.user_type.intValue())));
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbHttpMessageTask h2 = h();
            if (h2 != null && MessageManager.getInstance().findTask(h2.getCmd()) == null) {
                MessageManager.getInstance().registerTask(h2);
            }
            HttpMessageListener n = n();
            TbPageContext<?> tbPageContext = this.f30636b;
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
            this.f30638d = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.f30640f = str;
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

    public void I(c.a.o0.e1.p.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public TiePlusHelper J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.f30642h = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper K(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            this.o = z;
            return this;
        }
        return (TiePlusHelper) invokeZ.objValue;
    }

    public void L(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, itemData) == null) {
            this.i = itemData;
        }
    }

    public TiePlusHelper M(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.f30637c = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper N(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            this.f30639e = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.f30641g = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || StringUtils.isNull(this.f30638d)) {
            return;
        }
        for (ProgressButton progressButton : this.l) {
            progressButton.setCurProgress(-1);
            Y(this.f30637c, this.f30638d, this.a, progressButton);
        }
    }

    public final void Q(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, activity) == null) {
            if (s(activity)) {
                c.a.o0.v.c.q().A(this.f30637c, this.f30642h, this.f30638d, -1, -1, null, true, false, false);
            } else {
                V(activity);
            }
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            SharedPreferences sharedPreferences = this.n;
            int i = sharedPreferences.getInt(this.f30637c + this.f30638d, 0);
            for (ProgressButton progressButton : this.l) {
                progressButton.setTag((byte) 1);
                progressButton.j(i);
            }
            DownloadData downloadData = new DownloadData(this.f30637c);
            downloadData.setExtra(Integer.valueOf(i));
            downloadData.setName(this.f30638d);
            downloadData.setStatus(5);
            c.a.o0.v.c.q().w(downloadData);
        }
    }

    public final void S(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, activity) == null) && activity != null && s(activity)) {
            c.a.o0.e1.p.b bVar = this.k;
            if (bVar != null) {
                bVar.dismiss();
            }
            ScreenTopToast screenTopToast = new ScreenTopToast(activity);
            screenTopToast.m(activity.getResources().getString(R.string.obfuscated_res_0x7f0f13a8));
            screenTopToast.k(activity.getResources().getString(R.string.obfuscated_res_0x7f0f04d3));
            screenTopToast.j(new b(this, activity));
            screenTopToast.n((ViewGroup) activity.findViewById(16908290));
        }
    }

    public void T(TiebaPlusInfo tiebaPlusInfo, final TiePlusStat.RichTextType richTextType, final String str) {
        String string;
        String string2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, tiebaPlusInfo, richTextType, str) == null) {
            int intValue = tiebaPlusInfo.jump_type.intValue();
            String str2 = tiebaPlusInfo.h5_jump_number;
            UtilHelper.copyToClipBoard(str2);
            if (intValue == 7) {
                string = this.a.getString(R.string.obfuscated_res_0x7f0f13a5);
                string2 = this.a.getString(R.string.obfuscated_res_0x7f0f13ac, str2);
            } else {
                string = this.a.getString(R.string.obfuscated_res_0x7f0f13a6);
                string2 = this.a.getString(R.string.obfuscated_res_0x7f0f13ab, str2);
            }
            c.a.o0.r.t.o oVar = new c.a.o0.r.t.o(this.f30636b.getPageActivity());
            oVar.w(string);
            oVar.p(string2);
            oVar.n(true);
            oVar.i(false);
            oVar.r(new TBAlertConfig.a(this.a.getString(R.string.obfuscated_res_0x7f0f0eeb), TBAlertConfig.OperateBtnStyle.SECONDARY, new View.OnClickListener() { // from class: c.a.o0.c1.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        TiePlusHelper.this.v(view);
                    }
                }
            }), new TBAlertConfig.a(this.a.getString(R.string.obfuscated_res_0x7f0f0dcc), TBAlertConfig.OperateBtnStyle.MAIN, new View.OnClickListener() { // from class: c.a.o0.c1.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        TiePlusHelper.this.w(richTextType, str, view);
                    }
                }
            }));
            this.j = oVar.y();
            TiePlusStat.f(TiePlusStat.StatType.WECHAT_DIALOG_EXPOSE, richTextType, TiePlusStat.WechatDialogType.COPY, str);
        }
    }

    public void U(final TiebaPlusInfo tiebaPlusInfo, final TiePlusStat.RichTextType richTextType, final String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048596, this, tiebaPlusInfo, richTextType, str) == null) {
            LinearLayout linearLayout = new LinearLayout(this.a);
            TbImageView tbImageView = new TbImageView(this.a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n.f(this.a, R.dimen.tbds562), n.f(this.a, R.dimen.tbds562));
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080f6e);
            } else if (skinType == 4) {
                SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080f6c);
            } else {
                SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080f6f);
            }
            tbImageView.setLayoutParams(layoutParams);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            linearLayout.setPadding(n.f(this.a, R.dimen.M_W_X017), 0, n.f(this.a, R.dimen.M_W_X017), n.f(this.a, R.dimen.M_W_X007));
            linearLayout.setGravity(17);
            linearLayout.addView(tbImageView);
            c.a.o0.r.t.o oVar = new c.a.o0.r.t.o(this.f30636b.getPageActivity());
            oVar.w(this.a.getString(R.string.obfuscated_res_0x7f0f13a7));
            oVar.j(linearLayout);
            oVar.i(false);
            oVar.r(new TBAlertConfig.a(this.a.getString(R.string.obfuscated_res_0x7f0f0eeb), TBAlertConfig.OperateBtnStyle.SECONDARY, new View.OnClickListener() { // from class: c.a.o0.c1.c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        TiePlusHelper.this.x(view);
                    }
                }
            }), new TBAlertConfig.a(this.a.getString(R.string.obfuscated_res_0x7f0f13a4), TBAlertConfig.OperateBtnStyle.MAIN, new View.OnClickListener() { // from class: c.a.o0.c1.d
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        TiePlusHelper.this.y(tiebaPlusInfo, richTextType, str, view);
                    }
                }
            }));
            this.j = oVar.y();
            TiePlusStat.f(TiePlusStat.StatType.WECHAT_DIALOG_EXPOSE, richTextType, TiePlusStat.WechatDialogType.DIRECT, str);
        }
    }

    public final void V(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, activity) == null) || activity == null) {
            return;
        }
        this.m.clearRequestPermissionList();
        this.m.appendRequestPermission(this.f30636b.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        this.m.appendRequestPermission(this.f30636b.getPageActivity(), "android.permission.READ_EXTERNAL_STORAGE");
        this.m.startRequestPermission(activity);
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            TbHttpMessageTask h2 = h();
            if (h2 != null && MessageManager.getInstance().findTask(h2.getCmd()) != null) {
                MessageManager.getInstance().unRegisterTask(h2.getCmd());
            }
            HttpMessageListener n = n();
            if (n == null || !MessageManager.getInstance().hasListener(n.getCmd())) {
                return;
            }
            MessageManager.getInstance().unRegisterListener(n());
        }
    }

    public void X(@NonNull String str, @NonNull Context context, @NonNull TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, str, context, textView) == null) {
            if (!t(context, str) && !c.a.o0.v.c.q().s(str)) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public void Y(@NonNull String str, @NonNull String str2, @NonNull Context context, @NonNull ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048600, this, str, str2, context, progressButton) == null) {
            boolean h2 = progressButton.h();
            if (t(context, str)) {
                progressButton.setTag((byte) 4);
                progressButton.setText(context.getString(h2 ? R.string.obfuscated_res_0x7f0f08c9 : R.string.obfuscated_res_0x7f0f0dcc));
            } else if (c.a.o0.v.c.q().s(str)) {
                progressButton.setTag((byte) 2);
                progressButton.setText(context.getString(h2 ? R.string.obfuscated_res_0x7f0f08c8 : R.string.obfuscated_res_0x7f0f08e7));
            } else if (!c.a.o0.v.c.q().t(str) && !c.a.o0.v.c.q().r(str)) {
                File m = c.a.o0.v.c.q().m(str, str2);
                if (m != null && m.exists()) {
                    SharedPreferences sharedPreferences = this.n;
                    int i = sharedPreferences.getInt(str + str2, -1);
                    progressButton.setTag((byte) 3);
                    progressButton.setCurProgress(i);
                    progressButton.setText(context.getString(h2 ? R.string.obfuscated_res_0x7f0f07a6 : R.string.obfuscated_res_0x7f0f07a5));
                    if (this.o) {
                        e();
                        return;
                    }
                    return;
                }
                progressButton.setCurProgress(-1);
                progressButton.setTag((byte) 0);
                if (h2) {
                    progressButton.setText(context.getString(R.string.obfuscated_res_0x7f0f08e8));
                } else if (!StringUtils.isNull(this.s)) {
                    progressButton.setText(this.s);
                } else {
                    progressButton.setText(context.getString(R.string.obfuscated_res_0x7f0f04e3));
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

    public final void Z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            SharedPreferences sharedPreferences = this.n;
            if (i != sharedPreferences.getInt(this.f30637c + this.f30638d, -1)) {
                SharedPreferences.Editor edit = this.n.edit();
                edit.putInt(this.f30637c + this.f30638d, i);
                edit.apply();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            c.a.o0.e1.l.a.c().a(this.f30637c, this.f30640f);
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
    public void g(o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, oVar) == null) || oVar == null) {
            return;
        }
        for (o oVar2 : t) {
            if (TextUtils.isEmpty(oVar.f11476f) || oVar.f11476f.equals(oVar2.f11476f)) {
                return;
            }
            while (r0.hasNext()) {
            }
        }
        t.add(oVar);
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
            if (sharedPreferences.getInt(this.f30637c + this.f30638d, -1) != -1) {
                SharedPreferences.Editor edit = this.n.edit();
                edit.remove(this.f30637c + this.f30638d);
                edit.apply();
            }
        }
    }

    public void l(String str, int i, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)}) == null) || StringUtils.isNull(str) || this.f30636b == null) {
            return;
        }
        if (i == 1) {
            if (i2 == 0 || i2 == 1) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("need_scheme_blacklist", true);
                c.a.p0.l4.a.b(this.f30636b, str, bundle);
            } else if (i2 != 2) {
            } else {
                c.a.o0.l.a.k(this.a, str, false);
            }
        } else if (i != 4) {
        } else {
            if (!t(this.a, "com.tencent.mm")) {
                BdToast.c(this.a.getApplicationContext(), this.a.getText(R.string.obfuscated_res_0x7f0f13ae)).q();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f30638d : (String) invokeV.objValue;
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
    public void onClick(View view) {
        File m;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, view) == null) && view != null && (view.getTag() instanceof Byte)) {
            if ((view instanceof ProgressButton) && (tbPageContext = this.f30636b) != null) {
                r((ProgressButton) view, tbPageContext.getPageActivity());
                return;
            }
            switch (((Byte) view.getTag()).byteValue()) {
                case 16:
                    l(this.f30641g, 1, "", 0);
                    return;
                case 17:
                    l(this.f30639e, 1, "", 0);
                    return;
                case 18:
                    if (!StringUtils.isNull(this.f30637c) && !StringUtils.isNull(this.f30642h)) {
                        c.a.o0.v.c.q().h(this.f30642h, this.f30637c, true);
                        File j = c.a.o0.v.c.q().j(this.f30637c);
                        if (j != null && j.exists()) {
                            j.delete();
                        }
                        if (!StringUtils.isNull(this.f30638d) && (m = c.a.o0.v.c.q().m(this.f30637c, this.f30638d)) != null && m.exists()) {
                            m.delete();
                        }
                        k();
                        DownloadData downloadData = new DownloadData(this.f30637c);
                        downloadData.setStatus(4);
                        c.a.o0.v.c.q().w(downloadData);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921626, this.f30637c));
                    }
                    c.a.o0.e1.l.a.c().h(this.f30637c);
                    c.a.o0.e1.p.b bVar = this.k;
                    if (bVar != null) {
                        bVar.dismiss();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f30637c : (String) invokeV.objValue;
    }

    public final void r(ProgressButton progressButton, @NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048614, this, progressButton, activity) == null) || progressButton == null || progressButton.getVisibility() != 0 || !(progressButton.getTag() instanceof Byte) || StringUtils.isNull(this.f30637c) || StringUtils.isNull(this.f30638d) || StringUtils.isNull(this.f30642h)) {
            return;
        }
        byte byteValue = ((Byte) progressButton.getTag()).byteValue();
        if (byteValue == 0) {
            if (this.i != null) {
                c.a.p0.r0.a.b bVar = new c.a.p0.r0.a.b();
                bVar.a = this.i;
                bVar.f17906b = 2;
                Context context = this.a;
                if ((context instanceof Activity) && !"DownloadManagerActivity".equals(((Activity) context).getClass().getSimpleName())) {
                    bVar.f17907c = 1;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921627, bVar));
            }
            R();
            Q(activity);
            if (this.o) {
                e();
                S(activity);
            }
        } else if (byteValue != 1) {
            if (byteValue == 2) {
                Q(activity);
            } else if (byteValue == 3) {
                R();
                Q(activity);
            } else if (byteValue != 4) {
            } else {
                z(this.a, this.f30637c);
            }
        } else if (s(activity)) {
            if (!c.a.o0.v.c.q().r(this.f30637c) && !c.a.o0.v.c.q().t(this.f30637c)) {
                DownloadData downloadData = new DownloadData(this.f30637c);
                downloadData.setStatus(4);
                c.a.o0.v.c.q().w(downloadData);
                return;
            }
            c.a.o0.v.c.q().g(this.f30642h, this.f30637c);
        } else {
            V(activity);
        }
    }

    public final boolean s(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, activity)) == null) {
            if (activity == null) {
                return true;
            }
            return this.m.checkPermissionGranted(activity, "android.permission.WRITE_EXTERNAL_STORAGE") && this.m.checkPermissionGranted(activity, "android.permission.READ_EXTERNAL_STORAGE");
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

    public /* synthetic */ void v(View view) {
        AlertDialog alertDialog = this.j;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public /* synthetic */ void w(TiePlusStat.RichTextType richTextType, String str, View view) {
        AlertDialog alertDialog = this.j;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (!t(this.a, "com.tencent.mm")) {
            BdToast.c(this.a.getApplicationContext(), this.a.getText(R.string.obfuscated_res_0x7f0f13ae)).q();
            return;
        }
        r0.c(this.a);
        TiePlusStat.f(TiePlusStat.StatType.WECHAT_DIALOG_CLICK, richTextType, TiePlusStat.WechatDialogType.COPY, str);
    }

    public /* synthetic */ void x(View view) {
        AlertDialog alertDialog = this.j;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public /* synthetic */ void y(TiebaPlusInfo tiebaPlusInfo, TiePlusStat.RichTextType richTextType, String str, View view) {
        AlertDialog alertDialog = this.j;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (!t(this.a, "com.tencent.mm")) {
            BdToast.c(this.a.getApplicationContext(), this.a.getText(R.string.obfuscated_res_0x7f0f13ae)).q();
            return;
        }
        r0.d(tiebaPlusInfo, this.a.getString(R.string.obfuscated_res_0x7f0f13ad));
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
            if (downloadMessage.getData() == null || downloadMessage.getData().size() <= 0 || StringUtils.isNull(this.f30637c)) {
                return;
            }
            for (DownloadData downloadData : downloadMessage.getData()) {
                if (downloadData != null) {
                    if (downloadData.getStatus() == 21 && !StringUtils.isNull(this.f30638d)) {
                        for (ProgressButton progressButton : this.l) {
                            Y(this.f30637c, this.f30638d, this.a, progressButton);
                        }
                    } else if (this.f30637c.equals(downloadData.getId())) {
                        int status = downloadData.getStatus();
                        if (status == 0) {
                            if (!StringUtils.isNull(this.f30638d)) {
                                for (ProgressButton progressButton2 : this.l) {
                                    progressButton2.setCurProgress(100);
                                }
                            }
                            k();
                            return;
                        } else if (status == 1) {
                            int k = (int) (c.a.o0.v.c.q().k(this.f30637c) * 100.0f);
                            Z(k);
                            for (ProgressButton progressButton3 : this.l) {
                                progressButton3.setTag((byte) 1);
                                progressButton3.j(k);
                            }
                            return;
                        } else if (status == 2) {
                            TbPageContext<?> tbPageContext = this.f30636b;
                            if (tbPageContext != null) {
                                tbPageContext.showToast((int) R.string.obfuscated_res_0x7f0f04e8);
                            }
                            P();
                            return;
                        } else if (status == 3) {
                            k();
                            return;
                        } else if (status == 4) {
                            P();
                            return;
                        } else if (status != 5) {
                            return;
                        } else {
                            int i = 0;
                            if (downloadData.getExtra() != null && (downloadData.getExtra() instanceof Integer)) {
                                i = ((Integer) downloadData.getExtra()).intValue();
                                Z(i);
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
