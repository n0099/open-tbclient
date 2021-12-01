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
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.u.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tbadk.widget.richText.TbRichTextTiebaPlusInfo;
import com.baidu.tbadk.widget.tiejia.TiePlusDownloadDialog;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.s;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbContent;
import tbclient.PluginUser;
import tbclient.TiebaPlusInfo;
/* loaded from: classes9.dex */
public class TiePlusHelper extends CustomMessageListener implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static List<l> x;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f41941e;

    /* renamed from: f  reason: collision with root package name */
    public final TbPageContext<?> f41942f;

    /* renamed from: g  reason: collision with root package name */
    public String f41943g;

    /* renamed from: h  reason: collision with root package name */
    public String f41944h;

    /* renamed from: i  reason: collision with root package name */
    public String f41945i;

    /* renamed from: j  reason: collision with root package name */
    public String f41946j;

    /* renamed from: k  reason: collision with root package name */
    public String f41947k;
    public String l;
    public ItemData m;
    public AlertDialog n;
    public TiePlusDownloadDialog o;
    public final List<ProgressButton> p;
    public final PermissionJudgePolicy q;
    public final SharedPreferences r;
    public int s;
    public boolean t;
    public TbHttpMessageTask u;
    public HttpMessageListener v;
    public ItemCardHelper.c w;

    /* loaded from: classes9.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || StringUtils.isNull(this.a.l) || StringUtils.isNull(this.a.f41943g) || StringUtils.isNull(this.a.f41944h)) {
                return;
            }
            c.a.q0.w.c.q().A(this.a.f41943g, this.a.l, this.a.f41944h, -1, -1, null, true, false, false);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f41948e;

        public b(TiePlusHelper tiePlusHelper, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusHelper, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41948e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                DownloadManagerActivityConfig downloadManagerActivityConfig = new DownloadManagerActivityConfig(this.f41948e, 3);
                downloadManagerActivityConfig.setCurrentTab(3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, downloadManagerActivityConfig));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiePlusHelper a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TiePlusHelper tiePlusHelper, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiePlusHelper, Integer.valueOf(i2)};
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
                    if (this.a.w != null) {
                        this.a.w.a(parseLong);
                    }
                } else if (statusCode != 200 || error != 210018) {
                    if (this.a.w != null) {
                        this.a.w.b();
                    }
                } else if (this.a.w != null) {
                    this.a.w.a(parseLong);
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
        x = new ArrayList();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.t = false;
        this.f41941e = context;
        this.p = new ArrayList();
        this.r = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0);
        this.q = new PermissionJudgePolicy();
        this.s = TbadkCoreApplication.getInst().getSkinType();
        this.q.setOnPermissionsGrantedListener(new a(this));
        if (context instanceof TbPageContextSupport) {
            this.f41942f = ((TbPageContextSupport) this.f41941e).getPageContext();
        } else {
            this.f41942f = null;
        }
    }

    public static boolean i(TbRichTextTiebaPlusInfo tbRichTextTiebaPlusInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tbRichTextTiebaPlusInfo)) == null) {
            if (tbRichTextTiebaPlusInfo != null) {
                return j(tbRichTextTiebaPlusInfo.z());
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

    public static void u(Context context, PluginUser pluginUser) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, null, context, pluginUser) == null) && pluginUser != null && ViewHelper.checkUpIsLogin(context)) {
            if (UtilHelper.isCurrentAccount(String.valueOf(pluginUser.user_id))) {
                BdToast.i(context, context.getString(R.string.tie_plus_message_is_self), R.drawable.icon_pure_toast_mistake40_svg, true).q();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(context, pluginUser.user_id.longValue(), pluginUser.user_name_show, pluginUser.user_photo, pluginUser.user_type.intValue())));
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.o = null;
            AlertDialog alertDialog = this.n;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.n = null;
            }
            this.p.clear();
        }
    }

    public void B(long j2, String str, ItemCardHelper.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), str, cVar}) == null) || j2 == 0 || StringUtils.isNull(str)) {
            return;
        }
        if (cVar != null) {
            this.w = cVar;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_TIEBA_PLUS_GAME_ITEM_ORDER);
        httpMessage.addParam("item_id", j2);
        httpMessage.addParam("item_name", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public TiePlusHelper C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f41944h = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f41946j = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public void E(ItemCardHelper.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.w = cVar;
        }
    }

    public void F(TiePlusDownloadDialog tiePlusDownloadDialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tiePlusDownloadDialog) == null) {
            this.o = tiePlusDownloadDialog;
        }
    }

    public TiePlusHelper G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.l = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper K(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.t = z;
            return this;
        }
        return (TiePlusHelper) invokeZ.objValue;
    }

    public void L(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, itemData) == null) {
            this.m = itemData;
        }
    }

    public TiePlusHelper M(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.f41943g = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.f41945i = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.f41947k = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || StringUtils.isNull(this.f41944h)) {
            return;
        }
        for (ProgressButton progressButton : this.p) {
            progressButton.setCurProgress(-1);
            a0(this.f41943g, this.f41944h, this.f41941e, progressButton);
        }
    }

    public final void T(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, activity) == null) {
            if (s(activity)) {
                c.a.q0.w.c.q().A(this.f41943g, this.l, this.f41944h, -1, -1, null, true, false, false);
            } else {
                X(activity);
            }
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            SharedPreferences sharedPreferences = this.r;
            int i2 = sharedPreferences.getInt(this.f41943g + this.f41944h, 0);
            for (ProgressButton progressButton : this.p) {
                progressButton.setTag((byte) 1);
                progressButton.updateProgress(i2);
            }
            DownloadData downloadData = new DownloadData(this.f41943g);
            downloadData.setExtra(Integer.valueOf(i2));
            downloadData.setName(this.f41944h);
            downloadData.setStatus(5);
            c.a.q0.w.c.q().w(downloadData);
        }
    }

    public final void W(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, activity) == null) && activity != null && s(activity)) {
            TiePlusDownloadDialog tiePlusDownloadDialog = this.o;
            if (tiePlusDownloadDialog != null) {
                tiePlusDownloadDialog.dismiss();
            }
            new ScreenTopToast(activity).setTitle(activity.getResources().getString(R.string.tie_plus_jump_download_manager_toast)).setBtnText(activity.getResources().getString(R.string.dialog_confirm_see)).setBtnClickListener(new b(this, activity)).show((ViewGroup) activity.findViewById(16908290));
        }
    }

    public final void X(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, activity) == null) || activity == null) {
            return;
        }
        this.q.clearRequestPermissionList();
        this.q.appendRequestPermission(this.f41942f.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        this.q.appendRequestPermission(this.f41942f.getPageActivity(), s.f56844i);
        this.q.startRequestPermission(activity);
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
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

    public void Z(@NonNull String str, @NonNull Context context, @NonNull TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, str, context, textView) == null) {
            if (!t(context, str) && !c.a.q0.w.c.q().s(str)) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public void a0(@NonNull String str, @NonNull String str2, @NonNull Context context, @NonNull ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048595, this, str, str2, context, progressButton) == null) {
            boolean isUseLongText = progressButton.isUseLongText();
            if (t(context, str)) {
                progressButton.setTag((byte) 4);
                progressButton.setText(context.getString(isUseLongText ? R.string.immediately_open : R.string.pb_video_promotion_mount_open));
            } else if (c.a.q0.w.c.q().s(str)) {
                progressButton.setTag((byte) 2);
                progressButton.setText(context.getString(isUseLongText ? R.string.immediately_install : R.string.install));
            } else if (!c.a.q0.w.c.q().t(str) && !c.a.q0.w.c.q().r(str)) {
                File m = c.a.q0.w.c.q().m(str, str2);
                if (m != null && m.exists()) {
                    SharedPreferences sharedPreferences = this.r;
                    int i2 = sharedPreferences.getInt(str + str2, -1);
                    progressButton.setTag((byte) 3);
                    progressButton.setCurProgress(i2);
                    progressButton.setText(context.getString(isUseLongText ? R.string.go_on_download : R.string.go_on));
                    if (this.t) {
                        e();
                        return;
                    }
                    return;
                }
                progressButton.setCurProgress(-1);
                progressButton.setTag((byte) 0);
                progressButton.setText(context.getString(isUseLongText ? R.string.install_app : R.string.download));
            } else {
                SharedPreferences sharedPreferences2 = this.r;
                int i3 = sharedPreferences2.getInt(str + str2, -1);
                progressButton.setTag((byte) 1);
                progressButton.updateProgress(i3);
                if (this.t) {
                    e();
                }
            }
        }
    }

    public final void b0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            SharedPreferences sharedPreferences = this.r;
            if (i2 != sharedPreferences.getInt(this.f41943g + this.f41944h, -1)) {
                SharedPreferences.Editor edit = this.r.edit();
                edit.putInt(this.f41943g + this.f41944h, i2);
                edit.apply();
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            c.a.q0.f1.l.a.c().a(this.f41943g, this.f41946j);
        }
    }

    public void f(ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, progressButton) == null) || progressButton == null || this.p.contains(progressButton)) {
            return;
        }
        this.p.add(progressButton);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(l lVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, lVar) == null) || lVar == null) {
            return;
        }
        for (l lVar2 : x) {
            if (TextUtils.isEmpty(lVar.f13652f) || lVar.f13652f.equals(lVar2.f13652f)) {
                return;
            }
            while (r0.hasNext()) {
            }
        }
        x.add(lVar);
    }

    public final TbHttpMessageTask h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            TbHttpMessageTask tbHttpMessageTask = this.u;
            if (tbHttpMessageTask != null) {
                return tbHttpMessageTask;
            }
            TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_TIEBA_PLUS_GAME_ITEM_ORDER, TbConfig.SERVER_ADDRESS + "c/c/item/subscribeitem");
            this.u = tbHttpMessageTask2;
            tbHttpMessageTask2.setResponsedClass(TiebaPlusAppointResponsedMsg.class);
            return this.u;
        }
        return (TbHttpMessageTask) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            SharedPreferences sharedPreferences = this.r;
            if (sharedPreferences.getInt(this.f41943g + this.f41944h, -1) != -1) {
                SharedPreferences.Editor edit = this.r.edit();
                edit.remove(this.f41943g + this.f41944h);
                edit.apply();
            }
        }
    }

    public void l(String str, int i2, String str2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{str, Integer.valueOf(i2), str2, Integer.valueOf(i3)}) == null) || StringUtils.isNull(str) || this.f41942f == null) {
            return;
        }
        if (i2 == 1) {
            if (i3 == 0 || i3 == 1) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("need_scheme_blacklist", true);
                c.a.r0.f4.a.b(this.f41942f, str, bundle);
            } else if (i3 != 2) {
            } else {
                c.a.q0.m.a.k(this.f41941e, str, false);
            }
        } else if (i2 != 3) {
            if (i2 != 4) {
                return;
            }
            if (!t(this.f41941e, "com.tencent.mm")) {
                BdToast.c(this.f41941e.getApplicationContext(), this.f41941e.getText(R.string.tie_plus_wechat_not_install)).q();
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
        } else {
            UtilHelper.copyToClipBoard(str);
            if (this.n != null && this.s == TbadkCoreApplication.getInst().getSkinType()) {
                this.n.show();
                return;
            }
            this.s = TbadkCoreApplication.getInst().getSkinType();
            c.a.q0.s.s.l lVar = new c.a.q0.s.s.l(this.f41942f.getPageActivity());
            lVar.r(this.f41941e.getString(R.string.tie_plus_copy_wechat_success));
            lVar.n(this.f41941e.getString(R.string.tie_plus_open_wechat));
            lVar.l(true);
            lVar.g(false);
            lVar.p(new TBAlertConfig.a(this.f41941e.getString(R.string.protocol_cancel), TBAlertConfig.OperateBtnStyle.SECONDARY, new View.OnClickListener() { // from class: c.a.q0.d1.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        TiePlusHelper.this.v(view);
                    }
                }
            }), new TBAlertConfig.a(this.f41941e.getString(R.string.pb_video_promotion_mount_open), TBAlertConfig.OperateBtnStyle.MAIN, new View.OnClickListener() { // from class: c.a.q0.d1.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        TiePlusHelper.this.w(view);
                    }
                }
            }));
            this.n = lVar.t();
        }
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f41944h : (String) invokeV.objValue;
    }

    public final HttpMessageListener n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            HttpMessageListener httpMessageListener = this.v;
            if (httpMessageListener != null) {
                return httpMessageListener;
            }
            c cVar = new c(this, CmdConfigHttp.CMD_TIEBA_PLUS_GAME_ITEM_ORDER);
            this.v = cVar;
            return cVar;
        }
        return (HttpMessageListener) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        File m;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, view) == null) && view != null && (view.getTag() instanceof Byte)) {
            if ((view instanceof ProgressButton) && (tbPageContext = this.f41942f) != null) {
                r((ProgressButton) view, tbPageContext.getPageActivity());
                return;
            }
            switch (((Byte) view.getTag()).byteValue()) {
                case 16:
                    l(this.f41947k, 1, "", 0);
                    return;
                case 17:
                    l(this.f41945i, 1, "", 0);
                    return;
                case 18:
                    if (!StringUtils.isNull(this.f41943g) && !StringUtils.isNull(this.l)) {
                        c.a.q0.w.c.q().h(this.l, this.f41943g, true);
                        File j2 = c.a.q0.w.c.q().j(this.f41943g);
                        if (j2 != null && j2.exists()) {
                            j2.delete();
                        }
                        if (!StringUtils.isNull(this.f41944h) && (m = c.a.q0.w.c.q().m(this.f41943g, this.f41944h)) != null && m.exists()) {
                            m.delete();
                        }
                        k();
                        DownloadData downloadData = new DownloadData(this.f41943g);
                        downloadData.setStatus(4);
                        c.a.q0.w.c.q().w(downloadData);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921626, this.f41943g));
                    }
                    c.a.q0.f1.l.a.c().h(this.f41943g);
                    TiePlusDownloadDialog tiePlusDownloadDialog = this.o;
                    if (tiePlusDownloadDialog != null) {
                        tiePlusDownloadDialog.dismiss();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f41943g : (String) invokeV.objValue;
    }

    public final void r(ProgressButton progressButton, @NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048609, this, progressButton, activity) == null) || progressButton == null || progressButton.getVisibility() != 0 || !(progressButton.getTag() instanceof Byte) || StringUtils.isNull(this.f41943g) || StringUtils.isNull(this.f41944h) || StringUtils.isNull(this.l)) {
            return;
        }
        byte byteValue = ((Byte) progressButton.getTag()).byteValue();
        if (byteValue == 0) {
            if (this.m != null) {
                c.a.r0.p0.b.b bVar = new c.a.r0.p0.b.b();
                bVar.f21006e = this.m;
                bVar.f21007f = 2;
                Context context = this.f41941e;
                if ((context instanceof Activity) && !"DownloadManagerActivity".equals(((Activity) context).getClass().getSimpleName())) {
                    bVar.f21008g = 1;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921627, bVar));
            }
            V();
            T(activity);
            if (this.t) {
                e();
                W(activity);
            }
        } else if (byteValue != 1) {
            if (byteValue == 2) {
                T(activity);
            } else if (byteValue == 3) {
                V();
                T(activity);
            } else if (byteValue != 4) {
            } else {
                x(this.f41941e, this.f41943g);
            }
        } else if (s(activity)) {
            if (!c.a.q0.w.c.q().r(this.f41943g) && !c.a.q0.w.c.q().t(this.f41943g)) {
                DownloadData downloadData = new DownloadData(this.f41943g);
                downloadData.setStatus(4);
                c.a.q0.w.c.q().w(downloadData);
                return;
            }
            c.a.q0.w.c.q().g(this.l, this.f41943g);
        } else {
            X(activity);
        }
    }

    public final boolean s(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, activity)) == null) {
            if (activity == null) {
                return true;
            }
            return this.q.checkPermissionGranted(activity, "android.permission.WRITE_EXTERNAL_STORAGE") && this.q.checkPermissionGranted(activity, s.f56844i);
        }
        return invokeL.booleanValue;
    }

    public final boolean t(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, context, str)) == null) {
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
        AlertDialog alertDialog = this.n;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public /* synthetic */ void w(View view) {
        AlertDialog alertDialog = this.n;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (!t(this.f41941e, "com.tencent.mm")) {
            BdToast.c(this.f41941e.getApplicationContext(), this.f41941e.getText(R.string.tie_plus_wechat_not_install)).q();
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            ComponentName componentName = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(268435456);
            intent.setComponent(componentName);
            this.f41941e.startActivity(intent);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public final boolean x(Context context, String str) {
        InterceptResult invokeLL;
        ResolveInfo next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048614, this, context, str)) == null) {
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
            intent2.setFlags(268435456);
            try {
                context.startActivity(intent2);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            TbHttpMessageTask h2 = h();
            if (h2 != null && MessageManager.getInstance().findTask(h2.getCmd()) == null) {
                MessageManager.getInstance().registerTask(h2);
            }
            HttpMessageListener n = n();
            TbPageContext<?> tbPageContext = this.f41942f;
            if (tbPageContext != null) {
                tbPageContext.registerListener(n);
            }
        }
    }

    public void z(ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, progressButton) == null) || progressButton == null) {
            return;
        }
        this.p.remove(progressButton);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, customResponsedMessage) == null) && (customResponsedMessage instanceof DownloadMessage)) {
            DownloadMessage downloadMessage = (DownloadMessage) customResponsedMessage;
            if (downloadMessage.getData() == null || downloadMessage.getData().size() <= 0 || StringUtils.isNull(this.f41943g)) {
                return;
            }
            for (DownloadData downloadData : downloadMessage.getData()) {
                if (downloadData != null) {
                    if (downloadData.getStatus() == 21 && !StringUtils.isNull(this.f41944h)) {
                        for (ProgressButton progressButton : this.p) {
                            a0(this.f41943g, this.f41944h, this.f41941e, progressButton);
                        }
                    } else if (this.f41943g.equals(downloadData.getId())) {
                        int status = downloadData.getStatus();
                        if (status == 0) {
                            if (!StringUtils.isNull(this.f41944h)) {
                                for (ProgressButton progressButton2 : this.p) {
                                    progressButton2.setCurProgress(100);
                                }
                            }
                            k();
                            return;
                        } else if (status == 1) {
                            int k2 = (int) (c.a.q0.w.c.q().k(this.f41943g) * 100.0f);
                            b0(k2);
                            for (ProgressButton progressButton3 : this.p) {
                                progressButton3.setTag((byte) 1);
                                progressButton3.updateProgress(k2);
                            }
                            return;
                        } else if (status == 2) {
                            TbPageContext<?> tbPageContext = this.f41942f;
                            if (tbPageContext != null) {
                                tbPageContext.showToast(R.string.download_error_info);
                            }
                            S();
                            return;
                        } else if (status == 3) {
                            k();
                            return;
                        } else if (status == 4) {
                            S();
                            return;
                        } else if (status != 5) {
                            return;
                        } else {
                            int i2 = 0;
                            if (downloadData.getExtra() != null && (downloadData.getExtra() instanceof Integer)) {
                                i2 = ((Integer) downloadData.getExtra()).intValue();
                                b0(i2);
                            }
                            for (ProgressButton progressButton4 : this.p) {
                                progressButton4.setTag((byte) 1);
                                progressButton4.updateProgress(i2);
                            }
                            return;
                        }
                    }
                }
            }
        }
    }
}
