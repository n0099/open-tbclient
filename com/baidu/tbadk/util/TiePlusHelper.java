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
import androidx.annotation.Nullable;
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
import com.baidu.tbadk.core.util.ListUtils;
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
import com.baidu.tieba.ch5;
import com.baidu.tieba.filedownloader.TbDownloadManager;
import com.baidu.tieba.lh5;
import com.baidu.tieba.lx5;
import com.baidu.tieba.n16;
import com.baidu.tieba.ooa;
import com.baidu.tieba.ox6;
import com.baidu.tieba.util.AdApkInstallHelper;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.tieba.w06;
import com.baidu.tieba.zd7;
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
public class TiePlusHelper extends CustomMessageListener implements View.OnClickListener, zd7 {
    public static /* synthetic */ Interceptable $ic;
    public static List<ch5> v;
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
    public DownloadData j;
    public AlertDialog k;
    public n16 l;
    public final List<ProgressButton> m;
    public final PermissionJudgePolicy n;
    public final SharedPreferences o;
    public boolean p;
    public TbHttpMessageTask q;
    public HttpMessageListener r;
    public ItemCardHelper.c s;
    public String t;
    public TbDownloadManager u;

    @Override // com.baidu.tieba.zd7
    public void a(@NonNull DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, downloadData) == null) {
        }
    }

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
                lh5.q().A(this.a.c, this.a.h, this.a.d, -1, -1, null, true, false, false);
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
                    if (this.a.s != null) {
                        this.a.s.b(parseLong);
                    }
                } else if (statusCode == 200 && error == 210018) {
                    if (this.a.s != null) {
                        this.a.s.b(parseLong);
                    }
                } else if (this.a.s != null) {
                    this.a.s.a(parseLong);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.k != null) {
                this.a.k.dismiss();
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
                if (this.d.k != null) {
                    this.d.k.dismiss();
                }
                TiePlusHelper tiePlusHelper = this.d;
                if (!tiePlusHelper.H(tiePlusHelper.a, "com.tencent.mm")) {
                    BdToast.makeText(this.d.a.getApplicationContext(), this.d.a.getText(R.string.tie_plus_wechat_not_install)).show();
                    return;
                }
                lx5.d(this.a, this.d.a.getString(R.string.tie_plus_wechat_dialog_tip));
                TiePlusStat.g(TiePlusStat.StatType.WECHAT_DIALOG_CLICK, this.b, TiePlusStat.WechatDialogType.DIRECT, this.c);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.k != null) {
                this.a.k.dismiss();
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
                if (this.c.k != null) {
                    this.c.k.dismiss();
                }
                TiePlusHelper tiePlusHelper = this.c;
                if (!tiePlusHelper.H(tiePlusHelper.a, "com.tencent.mm")) {
                    BdToast.makeText(this.c.a.getApplicationContext(), this.c.a.getText(R.string.tie_plus_wechat_not_install)).show();
                    return;
                }
                lx5.c(this.c.a);
                TiePlusStat.g(TiePlusStat.StatType.WECHAT_DIALOG_CLICK, this.a, TiePlusStat.WechatDialogType.COPY, this.b);
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
        v = new ArrayList();
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.l = null;
            AlertDialog alertDialog = this.k;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.k = null;
            }
            this.m.clear();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            w06.c().a(this.c, this.f);
        }
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final HttpMessageListener y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            HttpMessageListener httpMessageListener = this.r;
            if (httpMessageListener != null) {
                return httpMessageListener;
            }
            c cVar = new c(this, CmdConfigHttp.CMD_TIEBA_PLUS_GAME_ITEM_ORDER);
            this.r = cVar;
            return cVar;
        }
        return (HttpMessageListener) invokeV.objValue;
    }

    public DownloadData z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.j;
        }
        return (DownloadData) invokeV.objValue;
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
        this.p = false;
        this.a = context;
        this.m = new ArrayList();
        this.o = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0);
        this.n = new PermissionJudgePolicy();
        TbadkCoreApplication.getInst().getSkinType();
        this.n.setOnPermissionsGrantedListener(new a(this));
        if (context instanceof TbPageContextSupport) {
            this.b = ((TbPageContextSupport) this.a).getPageContext();
        } else {
            this.b = null;
        }
    }

    public static boolean s(TiebaPlusInfo tiebaPlusInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, tiebaPlusInfo)) == null) {
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

    public static PbContent A(List<PbContent> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
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

    public static List<PbContent> D(List<PbContent> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            if (list == null) {
                return null;
            }
            for (PbContent pbContent : list) {
                if (pbContent.type.intValue() == 35 || pbContent.type.intValue() == 36) {
                    if (s(pbContent.tiebaplus_info)) {
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

    public TbDownloadManager C(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData)) == null) {
            if (this.u == null) {
                this.u = new TbDownloadManager();
            }
            if (downloadData != null && downloadData.getItemData() != null) {
                if (downloadData.getItemData().isFromTbDownloaderTable) {
                    this.u.w(1);
                } else if (downloadData.getItemData().mTbFileDownloaderType > 0) {
                    this.u.w(downloadData.getItemData().mTbFileDownloaderType);
                }
            }
            return this.u;
        }
        return (TbDownloadManager) invokeL.objValue;
    }

    public final void g0(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, activity) == null) && activity != null && G(activity)) {
            n16 n16Var = this.l;
            if (n16Var != null) {
                n16Var.dismiss();
            }
            ScreenTopToast screenTopToast = new ScreenTopToast(activity);
            screenTopToast.m(activity.getResources().getString(R.string.tie_plus_jump_download_manager_toast));
            screenTopToast.k(activity.getResources().getString(R.string.dialog_confirm_see));
            screenTopToast.j(new b(this, activity));
            screenTopToast.o((ViewGroup) activity.findViewById(16908290));
        }
    }

    public final void q0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
            SharedPreferences sharedPreferences = this.o;
            if (i != sharedPreferences.getInt(this.c + this.d, -1)) {
                SharedPreferences.Editor edit = this.o.edit();
                edit.putInt(this.c + this.d, i);
                edit.apply();
            }
        }
    }

    public static void J(Activity activity, PluginUser pluginUser) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, pluginUser) != null) || pluginUser == null || activity == null || !ViewHelper.checkUpIsLogin(activity)) {
            return;
        }
        if (UtilHelper.isCurrentAccount(String.valueOf(pluginUser.user_id))) {
            new BdTopToast(activity, 2000).setIcon(false).setContent(activity.getString(R.string.tie_plus_message_is_self)).show((ViewGroup) activity.findViewById(16908290));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(activity, pluginUser.user_id.longValue(), pluginUser.user_name_show, pluginUser.user_photo, pluginUser.user_type.intValue())));
    }

    public final boolean L(Context context, String str) {
        InterceptResult invokeLL;
        ResolveInfo next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, str)) == null) {
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

    @NonNull
    public static String K(@Nullable Integer num, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, num, str)) == null) {
            if (num == null) {
                return "";
            }
            return num + "_" + str;
        }
        return (String) invokeLL.objValue;
    }

    public final boolean H(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, context, str)) == null) {
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

    @Override // com.baidu.tieba.zd7
    public void f(@NonNull DownloadData downloadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048607, this, downloadData, i) == null) {
            n0(downloadData);
        }
    }

    public static boolean r(TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, tbRichTextTiebaPlusInfo)) == null) {
            if (tbRichTextTiebaPlusInfo != null) {
                return s(tbRichTextTiebaPlusInfo.P());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean G(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) {
            if (activity == null) {
                return true;
            }
            if (this.n.checkPermissionGranted(activity, "android.permission.WRITE_EXTERNAL_STORAGE") && this.n.checkPermissionGranted(activity, h.i)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean I(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, downloadData)) == null) {
            if (downloadData != null && downloadData.getItemData() != null) {
                return H(this.a, downloadData.getItemData().pkgName);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void N(ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, progressButton) == null) && progressButton != null) {
            this.m.remove(progressButton);
        }
    }

    public TiePlusHelper Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.d = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            this.f = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public void S(ItemCardHelper.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.s = cVar;
        }
    }

    public void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.t = str;
        }
    }

    public void U(n16 n16Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, n16Var) == null) {
            this.l = n16Var;
        }
    }

    public void W(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, downloadData) == null) {
            this.j = downloadData;
        }
    }

    public TiePlusHelper X(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            this.h = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper Y(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
            this.p = z;
            return this;
        }
        return (TiePlusHelper) invokeZ.objValue;
    }

    public void Z(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, itemData) == null) {
            this.i = itemData;
        }
    }

    public TiePlusHelper a0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zd7
    public void b(@NonNull DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, downloadData) == null) {
            n0(downloadData);
        }
    }

    public TiePlusHelper b0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zd7
    public void c(@NonNull DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, downloadData) == null) {
            n0(downloadData);
        }
    }

    public TiePlusHelper c0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            this.g = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zd7
    public void d(@NonNull DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, downloadData) == null) {
            n0(downloadData);
        }
    }

    @Override // com.baidu.tieba.zd7
    public void e(@NonNull DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, downloadData) != null) || downloadData.getStatus() != 1) {
            return;
        }
        n0(downloadData);
    }

    public final void e0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, activity) == null) {
            if (G(activity)) {
                lh5.q().A(this.c, this.h, this.d, -1, -1, null, true, false, false);
            } else {
                j0(activity);
            }
        }
    }

    public void o(ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, progressButton) == null) && progressButton != null && !this.m.contains(progressButton)) {
            this.m.add(progressButton);
        }
    }

    public void m0(@NonNull String str, @NonNull Context context, @NonNull TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048615, this, str, context, textView) == null) {
            if (!H(context, str) && !lh5.q().s(str)) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public final void E(ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, progressButton) == null) && progressButton != null && progressButton.getVisibility() == 0 && this.j.getItemData() != null && !StringUtils.isNull(this.j.getItemData().pkgName)) {
            String str = this.j.getItemData().pkgName;
            Context context = this.a;
            if (context != null && H(context, str)) {
                L(this.a, str);
                return;
            }
            int q = C(this.j).q(this.j);
            if (q != 1) {
                if (q != 2) {
                    if (q != 3) {
                        if (q != 6) {
                            if (q == 7) {
                                C(this.j).z(this.j);
                                return;
                            }
                            return;
                        }
                        C(this.j).z(this.j);
                        return;
                    }
                    AdApkInstallHelper.a(C(this.j).o(this.j), this.j);
                    return;
                }
                C(this.j).h(this.j);
                C(this.j).z(this.j);
                return;
            }
            C(this.j).s(this.j);
        }
    }

    public final void F(ProgressButton progressButton, @NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, progressButton, activity) == null) && progressButton != null && progressButton.getVisibility() == 0 && (progressButton.getTag() instanceof Byte) && !StringUtils.isNull(this.c) && !StringUtils.isNull(this.d) && !StringUtils.isNull(this.h)) {
            byte byteValue = ((Byte) progressButton.getTag()).byteValue();
            if (byteValue != 0) {
                if (byteValue != 1) {
                    if (byteValue != 2) {
                        if (byteValue != 3) {
                            if (byteValue == 4) {
                                L(this.a, this.c);
                                return;
                            }
                            return;
                        }
                        f0();
                        e0(activity);
                        return;
                    }
                    e0(activity);
                    return;
                } else if (G(activity)) {
                    if (!lh5.q().r(this.c) && !lh5.q().t(this.c)) {
                        DownloadData downloadData = new DownloadData(this.c);
                        downloadData.setStatus(4);
                        lh5.q().w(downloadData);
                        return;
                    }
                    lh5.q().g(this.h, this.c);
                    return;
                } else {
                    j0(activity);
                    return;
                }
            }
            if (this.i != null) {
                ox6 ox6Var = new ox6();
                ox6Var.a = this.i;
                ox6Var.b = 2;
                Context context = this.a;
                if ((context instanceof Activity) && !"DownloadManagerActivity".equals(((Activity) context).getClass().getSimpleName())) {
                    ox6Var.c = 1;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921627, ox6Var));
            }
            f0();
            e0(activity);
            if (this.p) {
                n();
                g0(activity);
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TbHttpMessageTask q = q();
            if (q != null && MessageManager.getInstance().findTask(q.getCmd()) == null) {
                MessageManager.getInstance().registerTask(q);
            }
            HttpMessageListener y = y();
            TbPageContext<?> tbPageContext = this.b;
            if (tbPageContext != null) {
                tbPageContext.registerListener(y);
            }
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && !StringUtils.isNull(this.d)) {
            for (ProgressButton progressButton : this.m) {
                progressButton.setCurProgress(-1);
                p0(this.c, this.d, this.a, progressButton);
            }
        }
    }

    public final TbHttpMessageTask q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            TbHttpMessageTask tbHttpMessageTask = this.q;
            if (tbHttpMessageTask != null) {
                return tbHttpMessageTask;
            }
            TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_TIEBA_PLUS_GAME_ITEM_ORDER, TbConfig.SERVER_ADDRESS + "c/c/item/subscribeitem");
            this.q = tbHttpMessageTask2;
            tbHttpMessageTask2.setResponsedClass(TiebaPlusAppointResponsedMsg.class);
            return this.q;
        }
        return (TbHttpMessageTask) invokeV.objValue;
    }

    public void P(long j, String str, ItemCardHelper.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), str, cVar}) == null) && j != 0 && !StringUtils.isNull(str)) {
            if (cVar != null) {
                this.s = cVar;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_TIEBA_PLUS_GAME_ITEM_ORDER);
            httpMessage.addParam("item_id", j);
            httpMessage.addParam("item_name", str);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            SharedPreferences sharedPreferences = this.o;
            int i = sharedPreferences.getInt(this.c + this.d, 0);
            for (ProgressButton progressButton : this.m) {
                progressButton.setTag((byte) 1);
                progressButton.j(i);
            }
            DownloadData downloadData = new DownloadData(this.c);
            downloadData.setExtra(Integer.valueOf(i));
            downloadData.setName(this.d);
            downloadData.setStatus(5);
            lh5.q().w(downloadData);
        }
    }

    public void h0(TiebaPlusInfo tiebaPlusInfo, TiePlusStat.RichTextType richTextType, String str) {
        String string;
        String string2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048610, this, tiebaPlusInfo, richTextType, str) == null) {
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
            this.k = new TBAlertBuilder(this.b.getPageActivity()).setTitleStr(string).setDescStr(string2).setDescLightStyle(true).setCancelable(false).setOperateBtn(new TBAlertConfig.OperateBtnConfig(this.a.getString(R.string.protocol_cancel), TBAlertConfig.OperateBtnStyle.SECONDARY, new f(this)), new TBAlertConfig.OperateBtnConfig(this.a.getString(R.string.pb_video_promotion_mount_open), TBAlertConfig.OperateBtnStyle.MAIN, new g(this, richTextType, str))).show();
            TiePlusStat.g(TiePlusStat.StatType.WECHAT_DIALOG_EXPOSE, richTextType, TiePlusStat.WechatDialogType.COPY, str);
        }
    }

    public void i0(TiebaPlusInfo tiebaPlusInfo, TiePlusStat.RichTextType richTextType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048611, this, tiebaPlusInfo, richTextType, str) == null) {
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
            this.k = new TBAlertBuilder(this.b.getPageActivity()).setTitleStr(this.a.getString(R.string.tie_plus_follow_official)).setCustomContentView(linearLayout).setCancelable(false).setOperateBtn(new TBAlertConfig.OperateBtnConfig(this.a.getString(R.string.protocol_cancel), TBAlertConfig.OperateBtnStyle.SECONDARY, new d(this)), new TBAlertConfig.OperateBtnConfig(this.a.getString(R.string.tie_plus_call_wechat), TBAlertConfig.OperateBtnStyle.MAIN, new e(this, tiebaPlusInfo, richTextType, str))).show();
            TiePlusStat.g(TiePlusStat.StatType.WECHAT_DIALOG_EXPOSE, richTextType, TiePlusStat.WechatDialogType.DIRECT, str);
        }
    }

    public final void j0(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048612, this, activity) != null) || activity == null) {
            return;
        }
        this.n.clearRequestPermissionList();
        this.n.appendRequestPermission(this.b.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        this.n.appendRequestPermission(this.b.getPageActivity(), h.i);
        this.n.startRequestPermission(activity);
    }

    public void l0(@NonNull TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, textView) == null) {
            DownloadData downloadData = this.j;
            if (downloadData != null) {
                int q = C(downloadData).q(this.j);
                if (!I(this.j) && q != 3) {
                    textView.setVisibility(0);
                    return;
                } else {
                    textView.setVisibility(8);
                    return;
                }
            }
            textView.setVisibility(0);
        }
    }

    public final void n0(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, downloadData) == null) && downloadData != null && StringUtils.isNotNull(this.h) && this.h.equals(downloadData.getUrl()) && !ListUtils.isEmpty(this.m)) {
            for (ProgressButton progressButton : this.m) {
                o0(progressButton, downloadData);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void p(ch5 ch5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, ch5Var) == null) && ch5Var != null) {
            for (ch5 ch5Var2 : v) {
                if (TextUtils.isEmpty(ch5Var.f) || ch5Var.f.equals(ch5Var2.f)) {
                    return;
                }
                while (r0.hasNext()) {
                }
            }
            v.add(ch5Var);
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            TbHttpMessageTask q = q();
            if (q != null && MessageManager.getInstance().findTask(q.getCmd()) != null) {
                MessageManager.getInstance().unRegisterTask(q.getCmd());
            }
            HttpMessageListener y = y();
            if (y != null && MessageManager.getInstance().hasListener(y.getCmd())) {
                MessageManager.getInstance().unRegisterListener(y());
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            SharedPreferences sharedPreferences = this.o;
            if (sharedPreferences.getInt(this.c + this.d, -1) != -1) {
                SharedPreferences.Editor edit = this.o.edit();
                edit.remove(this.c + this.d);
                edit.apply();
            }
        }
    }

    public void o0(@NonNull ProgressButton progressButton, DownloadData downloadData) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Context context;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, progressButton, downloadData) == null) {
            boolean h = progressButton.h();
            if (StringUtils.isNotNull(this.c) && (context = this.a) != null && H(context, this.c)) {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                if (h) {
                    i6 = R.string.immediately_open;
                } else {
                    i6 = R.string.pb_video_promotion_mount_open;
                }
                progressButton.setText(inst.getString(i6));
                return;
            }
            int i7 = 6;
            if (downloadData != null) {
                i7 = downloadData.getStatus();
            } else {
                DownloadData downloadData2 = this.j;
                if (downloadData2 != null) {
                    i7 = C(downloadData2).q(this.j);
                }
            }
            switch (i7) {
                case 0:
                case 3:
                    TbadkCoreApplication inst2 = TbadkCoreApplication.getInst();
                    if (h) {
                        i = R.string.immediately_install;
                    } else {
                        i = R.string.obfuscated_res_0x7f0f0aa0;
                    }
                    String string = inst2.getString(i);
                    progressButton.setCurProgress(100);
                    progressButton.setText(string);
                    return;
                case 1:
                    if (downloadData != null) {
                        i2 = downloadData.getProcess();
                    } else {
                        DownloadData downloadData3 = this.j;
                        if (downloadData3 != null) {
                            i2 = C(downloadData3).p(this.j);
                        } else {
                            i2 = 0;
                        }
                    }
                    progressButton.j(Math.max(i2, 0));
                    return;
                case 2:
                case 6:
                    progressButton.setCurProgress(-1);
                    if (h) {
                        progressButton.setText(TbadkCoreApplication.getInst().getString(R.string.install_app));
                        return;
                    } else if (!StringUtils.isNull(this.t)) {
                        progressButton.setText(this.t);
                        return;
                    } else {
                        progressButton.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f05ad));
                        return;
                    }
                case 4:
                case 7:
                    if (downloadData != null) {
                        i3 = downloadData.getProcess();
                    } else {
                        DownloadData downloadData4 = this.j;
                        if (downloadData4 != null) {
                            i3 = C(downloadData4).p(this.j);
                        } else {
                            i3 = 0;
                        }
                    }
                    TbadkCoreApplication inst3 = TbadkCoreApplication.getInst();
                    if (h) {
                        i4 = R.string.go_on_download;
                    } else {
                        i4 = R.string.obfuscated_res_0x7f0f08fb;
                    }
                    String string2 = inst3.getString(i4);
                    progressButton.setCurProgress(Math.max(i3, 0));
                    progressButton.setText(string2);
                    return;
                case 5:
                    DownloadData downloadData5 = this.j;
                    if (downloadData5 != null) {
                        i5 = C(downloadData5).p(this.j);
                    } else {
                        i5 = 0;
                    }
                    progressButton.j(Math.max(i5, 0));
                    return;
                default:
                    progressButton.setCurProgress(-1);
                    if (h) {
                        progressButton.setText(TbadkCoreApplication.getInst().getString(R.string.install_app));
                        return;
                    } else if (!StringUtils.isNull(this.t)) {
                        progressButton.setText(this.t);
                        return;
                    } else {
                        progressButton.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f05ad));
                        return;
                    }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        File m;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, view2) == null) {
            if ((view2 instanceof ProgressButton) && (tbPageContext = this.b) != null) {
                if (this.j != null) {
                    E((ProgressButton) view2);
                } else {
                    F((ProgressButton) view2, tbPageContext.getPageActivity());
                }
            } else if (view2 != null && (view2.getTag() instanceof Byte)) {
                switch (((Byte) view2.getTag()).byteValue()) {
                    case 16:
                        u(this.g, 1, "", 0);
                        return;
                    case 17:
                        u(this.e, 1, "", 0);
                        return;
                    case 18:
                        DownloadData downloadData = this.j;
                        if (downloadData != null) {
                            C(downloadData).h(this.j);
                        } else if (!StringUtils.isNull(this.c) && !StringUtils.isNull(this.h)) {
                            lh5.q().h(this.h, this.c, true);
                            File j = lh5.q().j(this.c);
                            if (j != null && j.exists()) {
                                j.delete();
                            }
                            if (!StringUtils.isNull(this.d) && (m = lh5.q().m(this.c, this.d)) != null && m.exists()) {
                                m.delete();
                            }
                            t();
                            DownloadData downloadData2 = new DownloadData(this.c);
                            downloadData2.setStatus(4);
                            lh5.q().w(downloadData2);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921626, this.c));
                        }
                        w06.c().h(this.c);
                        n16 n16Var = this.l;
                        if (n16Var != null) {
                            n16Var.dismiss();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048621, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof DownloadMessage)) {
            return;
        }
        DownloadMessage downloadMessage = (DownloadMessage) customResponsedMessage;
        if (downloadMessage.getData() == null || downloadMessage.getData().size() <= 0 || StringUtils.isNull(this.c)) {
            return;
        }
        for (DownloadData downloadData : downloadMessage.getData()) {
            if (downloadData != null) {
                if (downloadData.getStatus() == 21 && !StringUtils.isNull(this.d)) {
                    for (ProgressButton progressButton : this.m) {
                        p0(this.c, this.d, this.a, progressButton);
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
                                                q0(i);
                                            }
                                            for (ProgressButton progressButton2 : this.m) {
                                                progressButton2.setTag((byte) 1);
                                                progressButton2.j(i);
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    d0();
                                    return;
                                }
                                t();
                                return;
                            }
                            TbPageContext<?> tbPageContext = this.b;
                            if (tbPageContext != null) {
                                tbPageContext.showToast((int) R.string.download_error_info);
                            }
                            d0();
                            return;
                        }
                        int k = (int) (lh5.q().k(this.c) * 100.0f);
                        q0(k);
                        for (ProgressButton progressButton3 : this.m) {
                            progressButton3.setTag((byte) 1);
                            progressButton3.j(k);
                        }
                        return;
                    }
                    if (!StringUtils.isNull(this.d)) {
                        for (ProgressButton progressButton4 : this.m) {
                            progressButton4.setCurProgress(100);
                        }
                    }
                    t();
                    return;
                }
            }
        }
    }

    public void p0(@NonNull String str, @NonNull String str2, @NonNull Context context, @NonNull ProgressButton progressButton) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048624, this, str, str2, context, progressButton) == null) {
            boolean h = progressButton.h();
            if (H(context, str)) {
                progressButton.setTag((byte) 4);
                if (h) {
                    i3 = R.string.immediately_open;
                } else {
                    i3 = R.string.pb_video_promotion_mount_open;
                }
                progressButton.setText(context.getString(i3));
            } else if (lh5.q().s(str)) {
                progressButton.setTag((byte) 2);
                if (h) {
                    i2 = R.string.immediately_install;
                } else {
                    i2 = R.string.obfuscated_res_0x7f0f0aa0;
                }
                progressButton.setText(context.getString(i2));
            } else if (!lh5.q().t(str) && !lh5.q().r(str)) {
                File m = lh5.q().m(str, str2);
                if (m != null && m.exists()) {
                    SharedPreferences sharedPreferences = this.o;
                    int i4 = sharedPreferences.getInt(str + str2, -1);
                    progressButton.setTag((byte) 3);
                    progressButton.setCurProgress(i4);
                    if (h) {
                        i = R.string.go_on_download;
                    } else {
                        i = R.string.obfuscated_res_0x7f0f08fb;
                    }
                    progressButton.setText(context.getString(i));
                    if (this.p) {
                        n();
                        return;
                    }
                    return;
                }
                progressButton.setCurProgress(-1);
                progressButton.setTag((byte) 0);
                if (h) {
                    progressButton.setText(context.getString(R.string.install_app));
                } else if (!StringUtils.isNull(this.t)) {
                    progressButton.setText(this.t);
                } else {
                    progressButton.setText(context.getString(R.string.obfuscated_res_0x7f0f05ad));
                }
            } else {
                SharedPreferences sharedPreferences2 = this.o;
                int i5 = sharedPreferences2.getInt(str + str2, -1);
                progressButton.setTag((byte) 1);
                progressButton.j(i5);
                if (this.p) {
                    n();
                }
            }
        }
    }

    public void u(String str, int i, String str2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)}) == null) && !StringUtils.isNull(str) && this.b != null) {
            if (i != 1) {
                if (i == 4) {
                    if (!H(this.a, "com.tencent.mm")) {
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
                ooa.b(this.b, str, bundle);
            }
        }
    }
}
