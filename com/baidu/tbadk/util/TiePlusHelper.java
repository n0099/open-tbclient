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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.browser.BrowserHelper;
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
import com.baidu.tbadk.widget.ProgressButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextTiebaPlusInfo;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.bw6;
import com.baidu.tieba.e06;
import com.baidu.tieba.eh5;
import com.baidu.tieba.fka;
import com.baidu.tieba.uw5;
import com.baidu.tieba.v06;
import com.baidu.tieba.vg5;
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
    public static List<vg5> t;
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
    public v06 k;
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !StringUtils.isNull(this.a.h) && !StringUtils.isNull(this.a.c) && !StringUtils.isNull(this.a.d)) {
                eh5.q().A(this.a.c, this.a.h, this.a.d, -1, -1, null, true, false, false);
            }
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
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
                } else if (statusCode == 200 && error == 210018) {
                    if (this.a.r != null) {
                        this.a.r.b(parseLong);
                    }
                } else if (this.a.r != null) {
                    this.a.r.a(parseLong);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiePlusHelper a;

        public d(TiePlusHelper tiePlusHelper) {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.j != null) {
                this.a.j.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaPlusInfo a;
        public final /* synthetic */ TiePlusStat.RichTextType b;
        public final /* synthetic */ String c;
        public final /* synthetic */ TiePlusHelper d;

        public e(TiePlusHelper tiePlusHelper, TiebaPlusInfo tiebaPlusInfo, TiePlusStat.RichTextType richTextType, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusHelper, tiebaPlusInfo, richTextType, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = tiePlusHelper;
            this.a = tiebaPlusInfo;
            this.b = richTextType;
            this.c = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.d.j != null) {
                    this.d.j.dismiss();
                }
                TiePlusHelper tiePlusHelper = this.d;
                if (!tiePlusHelper.y(tiePlusHelper.a, "com.tencent.mm")) {
                    BdToast.makeText(this.d.a.getApplicationContext(), this.d.a.getText(R.string.tie_plus_wechat_not_install)).show();
                    return;
                }
                uw5.d(this.a, this.d.a.getString(R.string.tie_plus_wechat_dialog_tip));
                TiePlusStat.f(TiePlusStat.StatType.WECHAT_DIALOG_CLICK, this.b, TiePlusStat.WechatDialogType.DIRECT, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiePlusHelper a;

        public f(TiePlusHelper tiePlusHelper) {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.j != null) {
                this.a.j.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiePlusStat.RichTextType a;
        public final /* synthetic */ String b;
        public final /* synthetic */ TiePlusHelper c;

        public g(TiePlusHelper tiePlusHelper, TiePlusStat.RichTextType richTextType, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusHelper, richTextType, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tiePlusHelper;
            this.a = richTextType;
            this.b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.c.j != null) {
                    this.c.j.dismiss();
                }
                TiePlusHelper tiePlusHelper = this.c;
                if (!tiePlusHelper.y(tiePlusHelper.a, "com.tencent.mm")) {
                    BdToast.makeText(this.c.a.getApplicationContext(), this.c.a.getText(R.string.tie_plus_wechat_not_install)).show();
                    return;
                }
                uw5.c(this.c.a);
                TiePlusStat.f(TiePlusStat.StatType.WECHAT_DIALOG_CLICK, this.a, TiePlusStat.WechatDialogType.COPY, this.b);
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

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k = null;
            AlertDialog alertDialog = this.j;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.j = null;
            }
            this.l.clear();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            e06.c().a(this.c, this.f);
        }
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final HttpMessageListener q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
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

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
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

    public static boolean m(TiebaPlusInfo tiebaPlusInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, tiebaPlusInfo)) == null) {
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

    public static boolean l(TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, tbRichTextTiebaPlusInfo)) == null) {
            if (tbRichTextTiebaPlusInfo != null) {
                return m(tbRichTextTiebaPlusInfo.P());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void C(ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, progressButton) == null) && progressButton != null) {
            this.l.remove(progressButton);
        }
    }

    public TiePlusHelper F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.d = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public void H(ItemCardHelper.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.r = cVar;
        }
    }

    public void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.s = str;
        }
    }

    public void J(v06 v06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, v06Var) == null) {
            this.k = v06Var;
        }
    }

    public TiePlusHelper K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.h = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper M(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.o = z;
            return this;
        }
        return (TiePlusHelper) invokeZ.objValue;
    }

    public void N(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, itemData) == null) {
            this.i = itemData;
        }
    }

    public TiePlusHelper O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper P(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            this.g = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public final void S(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, activity) == null) {
            if (x(activity)) {
                eh5.q().A(this.c, this.h, this.d, -1, -1, null, true, false, false);
            } else {
                X(activity);
            }
        }
    }

    public void i(ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, progressButton) == null) && progressButton != null && !this.l.contains(progressButton)) {
            this.l.add(progressButton);
        }
    }

    public final boolean x(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, activity)) == null) {
            if (activity == null) {
                return true;
            }
            if (this.m.checkPermissionGranted(activity, "android.permission.WRITE_EXTERNAL_STORAGE") && this.m.checkPermissionGranted(activity, h.i)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void Z(@NonNull String str, @NonNull Context context, @NonNull TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048600, this, str, context, textView) == null) {
            if (!y(context, str) && !eh5.q().s(str)) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public static PbContent r(List<PbContent> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, list)) == null) {
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

    public static List<PbContent> t(List<PbContent> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, list)) == null) {
            if (list == null) {
                return null;
            }
            for (PbContent pbContent : list) {
                if (pbContent.type.intValue() == 35 || pbContent.type.intValue() == 36) {
                    if (m(pbContent.tiebaplus_info)) {
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

    public final void U(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, activity) == null) && activity != null && x(activity)) {
            v06 v06Var = this.k;
            if (v06Var != null) {
                v06Var.dismiss();
            }
            ScreenTopToast screenTopToast = new ScreenTopToast(activity);
            screenTopToast.m(activity.getResources().getString(R.string.tie_plus_jump_download_manager_toast));
            screenTopToast.k(activity.getResources().getString(R.string.dialog_confirm_see));
            screenTopToast.j(new b(this, activity));
            screenTopToast.n((ViewGroup) activity.findViewById(16908290));
        }
    }

    public final void b0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            SharedPreferences sharedPreferences = this.n;
            if (i != sharedPreferences.getInt(this.c + this.d, -1)) {
                SharedPreferences.Editor edit = this.n.edit();
                edit.putInt(this.c + this.d, i);
                edit.apply();
            }
        }
    }

    public static void z(Activity activity, PluginUser pluginUser) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65549, null, activity, pluginUser) != null) || pluginUser == null || activity == null || !ViewHelper.checkUpIsLogin(activity)) {
            return;
        }
        if (UtilHelper.isCurrentAccount(String.valueOf(pluginUser.user_id))) {
            new BdTopToast(activity, 2000).setIcon(false).setContent(activity.getString(R.string.tie_plus_message_is_self)).show((ViewGroup) activity.findViewById(16908290));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(activity, pluginUser.user_id.longValue(), pluginUser.user_name_show, pluginUser.user_photo, pluginUser.user_type.intValue())));
    }

    public final boolean A(Context context, String str) {
        InterceptResult invokeLL;
        ResolveInfo next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
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

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TbHttpMessageTask k = k();
            if (k != null && MessageManager.getInstance().findTask(k.getCmd()) == null) {
                MessageManager.getInstance().registerTask(k);
            }
            HttpMessageListener q = q();
            TbPageContext<?> tbPageContext = this.b;
            if (tbPageContext != null) {
                tbPageContext.registerListener(q);
            }
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && !StringUtils.isNull(this.d)) {
            for (ProgressButton progressButton : this.l) {
                progressButton.setCurProgress(-1);
                a0(this.c, this.d, this.a, progressButton);
            }
        }
    }

    public final TbHttpMessageTask k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
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

    public void E(long j, String str, ItemCardHelper.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), str, cVar}) == null) && j != 0 && !StringUtils.isNull(str)) {
            if (cVar != null) {
                this.r = cVar;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_TIEBA_PLUS_GAME_ITEM_ORDER);
            httpMessage.addParam("item_id", j);
            httpMessage.addParam("item_name", str);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
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
            eh5.q().w(downloadData);
        }
    }

    public void V(TiebaPlusInfo tiebaPlusInfo, TiePlusStat.RichTextType richTextType, String str) {
        String string;
        String string2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048596, this, tiebaPlusInfo, richTextType, str) == null) {
            int intValue = tiebaPlusInfo.jump_type.intValue();
            String str2 = tiebaPlusInfo.h5_jump_number;
            UtilHelper.copyToClipBoard(str2);
            if (intValue == 7) {
                string = this.a.getString(R.string.tie_plus_copy_wechat_official_success);
                string2 = this.a.getString(R.string.tie_plus_open_wechat_follow_official, str2);
            } else {
                string = this.a.getString(R.string.tie_plus_copy_wechat_success);
                string2 = this.a.getString(R.string.tie_plus_open_wechat_add_friend, str2);
            }
            this.j = new TBAlertBuilder(this.b.getPageActivity()).setTitleStr(string).setDescStr(string2).setDescLightStyle(true).setCancelable(false).setOperateBtn(new TBAlertConfig.OperateBtnConfig(this.a.getString(R.string.protocol_cancel), TBAlertConfig.OperateBtnStyle.SECONDARY, new f(this)), new TBAlertConfig.OperateBtnConfig(this.a.getString(R.string.pb_video_promotion_mount_open), TBAlertConfig.OperateBtnStyle.MAIN, new g(this, richTextType, str))).show();
            TiePlusStat.f(TiePlusStat.StatType.WECHAT_DIALOG_EXPOSE, richTextType, TiePlusStat.WechatDialogType.COPY, str);
        }
    }

    public void W(TiebaPlusInfo tiebaPlusInfo, TiePlusStat.RichTextType richTextType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, tiebaPlusInfo, richTextType, str) == null) {
            LinearLayout linearLayout = new LinearLayout(this.a);
            TbImageView tbImageView = new TbImageView(this.a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(BdUtilHelper.getDimens(this.a, R.dimen.tbds562), BdUtilHelper.getDimens(this.a, R.dimen.tbds562));
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                SkinManager.setImageResource(tbImageView, R.drawable.pic_wechatguide_dark);
            } else {
                SkinManager.setImageResource(tbImageView, R.drawable.pic_wechatguide_normal);
            }
            tbImageView.setLayoutParams(layoutParams);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            linearLayout.setPadding(BdUtilHelper.getDimens(this.a, R.dimen.M_W_X017), 0, BdUtilHelper.getDimens(this.a, R.dimen.M_W_X017), BdUtilHelper.getDimens(this.a, R.dimen.M_W_X007));
            linearLayout.setGravity(17);
            linearLayout.addView(tbImageView);
            this.j = new TBAlertBuilder(this.b.getPageActivity()).setTitleStr(this.a.getString(R.string.tie_plus_follow_official)).setCustomContentView(linearLayout).setCancelable(false).setOperateBtn(new TBAlertConfig.OperateBtnConfig(this.a.getString(R.string.protocol_cancel), TBAlertConfig.OperateBtnStyle.SECONDARY, new d(this)), new TBAlertConfig.OperateBtnConfig(this.a.getString(R.string.tie_plus_call_wechat), TBAlertConfig.OperateBtnStyle.MAIN, new e(this, tiebaPlusInfo, richTextType, str))).show();
            TiePlusStat.f(TiePlusStat.StatType.WECHAT_DIALOG_EXPOSE, richTextType, TiePlusStat.WechatDialogType.DIRECT, str);
        }
    }

    public final void X(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, activity) != null) || activity == null) {
            return;
        }
        this.m.clearRequestPermissionList();
        this.m.appendRequestPermission(this.b.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        this.m.appendRequestPermission(this.b.getPageActivity(), h.i);
        this.m.startRequestPermission(activity);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j(vg5 vg5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, vg5Var) == null) && vg5Var != null) {
            for (vg5 vg5Var2 : t) {
                if (TextUtils.isEmpty(vg5Var.f) || vg5Var.f.equals(vg5Var2.f)) {
                    return;
                }
                while (r0.hasNext()) {
                }
            }
            t.add(vg5Var);
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            TbHttpMessageTask k = k();
            if (k != null && MessageManager.getInstance().findTask(k.getCmd()) != null) {
                MessageManager.getInstance().unRegisterTask(k.getCmd());
            }
            HttpMessageListener q = q();
            if (q != null && MessageManager.getInstance().hasListener(q.getCmd())) {
                MessageManager.getInstance().unRegisterListener(q());
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            SharedPreferences sharedPreferences = this.n;
            if (sharedPreferences.getInt(this.c + this.d, -1) != -1) {
                SharedPreferences.Editor edit = this.n.edit();
                edit.remove(this.c + this.d);
                edit.apply();
            }
        }
    }

    public void a0(@NonNull String str, @NonNull String str2, @NonNull Context context, @NonNull ProgressButton progressButton) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048601, this, str, str2, context, progressButton) == null) {
            boolean h = progressButton.h();
            if (y(context, str)) {
                progressButton.setTag((byte) 4);
                if (h) {
                    i3 = R.string.immediately_open;
                } else {
                    i3 = R.string.pb_video_promotion_mount_open;
                }
                progressButton.setText(context.getString(i3));
            } else if (eh5.q().s(str)) {
                progressButton.setTag((byte) 2);
                if (h) {
                    i2 = R.string.immediately_install;
                } else {
                    i2 = R.string.obfuscated_res_0x7f0f0a98;
                }
                progressButton.setText(context.getString(i2));
            } else if (!eh5.q().t(str) && !eh5.q().r(str)) {
                File m = eh5.q().m(str, str2);
                if (m != null && m.exists()) {
                    SharedPreferences sharedPreferences = this.n;
                    int i4 = sharedPreferences.getInt(str + str2, -1);
                    progressButton.setTag((byte) 3);
                    progressButton.setCurProgress(i4);
                    if (h) {
                        i = R.string.go_on_download;
                    } else {
                        i = R.string.obfuscated_res_0x7f0f08f3;
                    }
                    progressButton.setText(context.getString(i));
                    if (this.o) {
                        h();
                        return;
                    }
                    return;
                }
                progressButton.setCurProgress(-1);
                progressButton.setTag((byte) 0);
                if (h) {
                    progressButton.setText(context.getString(R.string.install_app));
                } else if (!StringUtils.isNull(this.s)) {
                    progressButton.setText(this.s);
                } else {
                    progressButton.setText(context.getString(R.string.obfuscated_res_0x7f0f05ab));
                }
            } else {
                SharedPreferences sharedPreferences2 = this.n;
                int i5 = sharedPreferences2.getInt(str + str2, -1);
                progressButton.setTag((byte) 1);
                progressButton.j(i5);
                if (this.o) {
                    h();
                }
            }
        }
    }

    public void o(String str, int i, String str2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)}) == null) && !StringUtils.isNull(str) && this.b != null) {
            if (i != 1) {
                if (i == 4) {
                    if (!y(this.a, "com.tencent.mm")) {
                        BdToast.makeText(this.a.getApplicationContext(), this.a.getText(R.string.tie_plus_wechat_not_install)).show();
                    } else if (!TextUtils.isEmpty(str)) {
                        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst().getContext(), TbConfig.WEIXIN_APP_ID);
                        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                        req.userName = str;
                        if (!TextUtils.isEmpty(str2)) {
                            req.path = str2;
                        }
                        createWXAPI.sendReq(req);
                    }
                }
            } else if (i2 != 0 && i2 != 1) {
                if (i2 == 2) {
                    BrowserHelper.startExternWebActivity(this.a, str, false);
                }
            } else {
                Bundle bundle = new Bundle();
                bundle.putBoolean("need_scheme_blacklist", true);
                fka.b(this.b, str, bundle);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        File m;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, view2) == null) && view2 != null && (view2.getTag() instanceof Byte)) {
            if ((view2 instanceof ProgressButton) && (tbPageContext = this.b) != null) {
                u((ProgressButton) view2, tbPageContext.getPageActivity());
                return;
            }
            switch (((Byte) view2.getTag()).byteValue()) {
                case 16:
                    o(this.g, 1, "", 0);
                    return;
                case 17:
                    o(this.e, 1, "", 0);
                    return;
                case 18:
                    if (!StringUtils.isNull(this.c) && !StringUtils.isNull(this.h)) {
                        eh5.q().h(this.h, this.c, true);
                        File j = eh5.q().j(this.c);
                        if (j != null && j.exists()) {
                            j.delete();
                        }
                        if (!StringUtils.isNull(this.d) && (m = eh5.q().m(this.c, this.d)) != null && m.exists()) {
                            m.delete();
                        }
                        n();
                        DownloadData downloadData = new DownloadData(this.c);
                        downloadData.setStatus(4);
                        eh5.q().w(downloadData);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921626, this.c));
                    }
                    e06.c().h(this.c);
                    v06 v06Var = this.k;
                    if (v06Var != null) {
                        v06Var.dismiss();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048610, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof DownloadMessage)) {
            return;
        }
        DownloadMessage downloadMessage = (DownloadMessage) customResponsedMessage;
        if (downloadMessage.getData() == null || downloadMessage.getData().size() <= 0 || StringUtils.isNull(this.c)) {
            return;
        }
        for (DownloadData downloadData : downloadMessage.getData()) {
            if (downloadData != null) {
                if (downloadData.getStatus() == 21 && !StringUtils.isNull(this.d)) {
                    for (ProgressButton progressButton : this.l) {
                        a0(this.c, this.d, this.a, progressButton);
                    }
                } else if (this.c.equals(downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status != 0) {
                        if (status != 1) {
                            if (status != 2) {
                                if (status != 3) {
                                    if (status != 4) {
                                        if (status == 5) {
                                            int i = 0;
                                            if (downloadData.getExtra() != null && (downloadData.getExtra() instanceof Integer)) {
                                                i = ((Integer) downloadData.getExtra()).intValue();
                                                b0(i);
                                            }
                                            for (ProgressButton progressButton2 : this.l) {
                                                progressButton2.setTag((byte) 1);
                                                progressButton2.j(i);
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    R();
                                    return;
                                }
                                n();
                                return;
                            }
                            TbPageContext<?> tbPageContext = this.b;
                            if (tbPageContext != null) {
                                tbPageContext.showToast((int) R.string.download_error_info);
                            }
                            R();
                            return;
                        }
                        int k = (int) (eh5.q().k(this.c) * 100.0f);
                        b0(k);
                        for (ProgressButton progressButton3 : this.l) {
                            progressButton3.setTag((byte) 1);
                            progressButton3.j(k);
                        }
                        return;
                    }
                    if (!StringUtils.isNull(this.d)) {
                        for (ProgressButton progressButton4 : this.l) {
                            progressButton4.setCurProgress(100);
                        }
                    }
                    n();
                    return;
                }
            }
        }
    }

    public final void u(ProgressButton progressButton, @NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048615, this, progressButton, activity) == null) && progressButton != null && progressButton.getVisibility() == 0 && (progressButton.getTag() instanceof Byte) && !StringUtils.isNull(this.c) && !StringUtils.isNull(this.d) && !StringUtils.isNull(this.h)) {
            byte byteValue = ((Byte) progressButton.getTag()).byteValue();
            if (byteValue != 0) {
                if (byteValue != 1) {
                    if (byteValue != 2) {
                        if (byteValue != 3) {
                            if (byteValue == 4) {
                                A(this.a, this.c);
                                return;
                            }
                            return;
                        }
                        T();
                        S(activity);
                        return;
                    }
                    S(activity);
                    return;
                } else if (x(activity)) {
                    if (!eh5.q().r(this.c) && !eh5.q().t(this.c)) {
                        DownloadData downloadData = new DownloadData(this.c);
                        downloadData.setStatus(4);
                        eh5.q().w(downloadData);
                        return;
                    }
                    eh5.q().g(this.h, this.c);
                    return;
                } else {
                    X(activity);
                    return;
                }
            }
            if (this.i != null) {
                bw6 bw6Var = new bw6();
                bw6Var.a = this.i;
                bw6Var.b = 2;
                Context context = this.a;
                if ((context instanceof Activity) && !"DownloadManagerActivity".equals(((Activity) context).getClass().getSimpleName())) {
                    bw6Var.c = 1;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921627, bw6Var));
            }
            T();
            S(activity);
            if (this.o) {
                h();
                U(activity);
            }
        }
    }

    public final boolean y(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048617, this, context, str)) == null) {
            if (context == null) {
                return false;
            }
            try {
                if (context.getPackageManager() == null) {
                    return false;
                }
                context.getPackageManager().getPackageInfo(str, 64);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
