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
import c.a.d.f.p.m;
import c.a.r0.d1.r0;
import c.a.r0.u.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
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
import com.baidu.tbadk.widget.tiejia.TiePlusDownloadDialog;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
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
/* loaded from: classes11.dex */
public class TiePlusHelper extends CustomMessageListener implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static List<l> w;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f42432e;

    /* renamed from: f  reason: collision with root package name */
    public final TbPageContext<?> f42433f;

    /* renamed from: g  reason: collision with root package name */
    public String f42434g;

    /* renamed from: h  reason: collision with root package name */
    public String f42435h;

    /* renamed from: i  reason: collision with root package name */
    public String f42436i;

    /* renamed from: j  reason: collision with root package name */
    public String f42437j;

    /* renamed from: k  reason: collision with root package name */
    public String f42438k;
    public String l;
    public ItemData m;
    public AlertDialog n;
    public TiePlusDownloadDialog o;
    public final List<ProgressButton> p;
    public final PermissionJudgePolicy q;
    public final SharedPreferences r;
    public boolean s;
    public TbHttpMessageTask t;
    public HttpMessageListener u;
    public ItemCardHelper.c v;

    /* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || StringUtils.isNull(this.a.l) || StringUtils.isNull(this.a.f42434g) || StringUtils.isNull(this.a.f42435h)) {
                return;
            }
            c.a.r0.w.c.q().A(this.a.f42434g, this.a.l, this.a.f42435h, -1, -1, null, true, false, false);
        }
    }

    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f42439e;

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
            this.f42439e = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                DownloadManagerActivityConfig downloadManagerActivityConfig = new DownloadManagerActivityConfig(this.f42439e, 3);
                downloadManagerActivityConfig.setCurrentTab(3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, downloadManagerActivityConfig));
            }
        }
    }

    /* loaded from: classes11.dex */
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
                    if (this.a.v != null) {
                        this.a.v.a(parseLong);
                    }
                } else if (statusCode != 200 || error != 210018) {
                    if (this.a.v != null) {
                        this.a.v.b();
                    }
                } else if (this.a.v != null) {
                    this.a.v.a(parseLong);
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
        w = new ArrayList();
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
        this.s = false;
        this.f42432e = context;
        this.p = new ArrayList();
        this.r = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0);
        this.q = new PermissionJudgePolicy();
        TbadkCoreApplication.getInst().getSkinType();
        this.q.setOnPermissionsGrantedListener(new a(this));
        if (context instanceof TbPageContextSupport) {
            this.f42433f = ((TbPageContextSupport) this.f42432e).getPageContext();
        } else {
            this.f42433f = null;
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
            TbHttpMessageTask h2 = h();
            if (h2 != null && MessageManager.getInstance().findTask(h2.getCmd()) == null) {
                MessageManager.getInstance().registerTask(h2);
            }
            HttpMessageListener n = n();
            TbPageContext<?> tbPageContext = this.f42433f;
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
        this.p.remove(progressButton);
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.o = null;
            AlertDialog alertDialog = this.n;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.n = null;
            }
            this.p.clear();
        }
    }

    public void D(long j2, String str, ItemCardHelper.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), str, cVar}) == null) || j2 == 0 || StringUtils.isNull(str)) {
            return;
        }
        if (cVar != null) {
            this.v = cVar;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_TIEBA_PLUS_GAME_ITEM_ORDER);
        httpMessage.addParam("item_id", j2);
        httpMessage.addParam("item_name", str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public TiePlusHelper E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.f42435h = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.f42437j = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public void G(ItemCardHelper.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.v = cVar;
        }
    }

    public void K(TiePlusDownloadDialog tiePlusDownloadDialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, tiePlusDownloadDialog) == null) {
            this.o = tiePlusDownloadDialog;
        }
    }

    public TiePlusHelper L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.l = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper M(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            this.s = z;
            return this;
        }
        return (TiePlusHelper) invokeZ.objValue;
    }

    public void O(ItemData itemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, itemData) == null) {
            this.m = itemData;
        }
    }

    public TiePlusHelper Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.f42434g = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper S(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.f42436i = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public TiePlusHelper T(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            this.f42438k = str;
            return this;
        }
        return (TiePlusHelper) invokeL.objValue;
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || StringUtils.isNull(this.f42435h)) {
            return;
        }
        for (ProgressButton progressButton : this.p) {
            progressButton.setCurProgress(-1);
            e0(this.f42434g, this.f42435h, this.f42432e, progressButton);
        }
    }

    public final void W(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, activity) == null) {
            if (s(activity)) {
                c.a.r0.w.c.q().A(this.f42434g, this.l, this.f42435h, -1, -1, null, true, false, false);
            } else {
                b0(activity);
            }
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            SharedPreferences sharedPreferences = this.r;
            int i2 = sharedPreferences.getInt(this.f42434g + this.f42435h, 0);
            for (ProgressButton progressButton : this.p) {
                progressButton.setTag((byte) 1);
                progressButton.updateProgress(i2);
            }
            DownloadData downloadData = new DownloadData(this.f42434g);
            downloadData.setExtra(Integer.valueOf(i2));
            downloadData.setName(this.f42435h);
            downloadData.setStatus(5);
            c.a.r0.w.c.q().w(downloadData);
        }
    }

    public final void Y(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, activity) == null) && activity != null && s(activity)) {
            TiePlusDownloadDialog tiePlusDownloadDialog = this.o;
            if (tiePlusDownloadDialog != null) {
                tiePlusDownloadDialog.dismiss();
            }
            new ScreenTopToast(activity).setTitle(activity.getResources().getString(R.string.tie_plus_jump_download_manager_toast)).setBtnText(activity.getResources().getString(R.string.dialog_confirm_see)).setBtnClickListener(new b(this, activity)).show((ViewGroup) activity.findViewById(16908290));
        }
    }

    public void Z(TiebaPlusInfo tiebaPlusInfo, final TiePlusStat.RichTextType richTextType, final String str) {
        String string;
        String string2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, tiebaPlusInfo, richTextType, str) == null) {
            int intValue = tiebaPlusInfo.jump_type.intValue();
            String str2 = tiebaPlusInfo.h5_jump_number;
            UtilHelper.copyToClipBoard(str2);
            if (intValue == 7) {
                string = this.f42432e.getString(R.string.tie_plus_copy_wechat_official_success);
                string2 = this.f42432e.getString(R.string.tie_plus_open_wechat_follow_official, str2);
            } else {
                string = this.f42432e.getString(R.string.tie_plus_copy_wechat_success);
                string2 = this.f42432e.getString(R.string.tie_plus_open_wechat_add_friend, str2);
            }
            c.a.r0.s.t.l lVar = new c.a.r0.s.t.l(this.f42433f.getPageActivity());
            lVar.r(string);
            lVar.n(string2);
            lVar.l(true);
            lVar.g(false);
            lVar.p(new TBAlertConfig.a(this.f42432e.getString(R.string.protocol_cancel), TBAlertConfig.OperateBtnStyle.SECONDARY, new View.OnClickListener() { // from class: c.a.r0.d1.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        TiePlusHelper.this.v(view);
                    }
                }
            }), new TBAlertConfig.a(this.f42432e.getString(R.string.pb_video_promotion_mount_open), TBAlertConfig.OperateBtnStyle.MAIN, new View.OnClickListener() { // from class: c.a.r0.d1.a
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
            this.n = lVar.t();
            TiePlusStat.f(TiePlusStat.StatType.WECHAT_DIALOG_EXPOSE, richTextType, TiePlusStat.WechatDialogType.COPY, str);
        }
    }

    public void a0(final TiebaPlusInfo tiebaPlusInfo, final TiePlusStat.RichTextType richTextType, final String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, tiebaPlusInfo, richTextType, str) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f42432e);
            TbImageView tbImageView = new TbImageView(this.f42432e);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(m.f(this.f42432e, R.dimen.tbds562), m.f(this.f42432e, R.dimen.tbds562));
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                SkinManager.setImageResource(tbImageView, R.drawable.pic_wechatguide_night);
            } else if (skinType == 4) {
                SkinManager.setImageResource(tbImageView, R.drawable.pic_wechatguide_dark);
            } else {
                SkinManager.setImageResource(tbImageView, R.drawable.pic_wechatguide_normal);
            }
            tbImageView.setLayoutParams(layoutParams);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            linearLayout.setPadding(m.f(this.f42432e, R.dimen.M_W_X017), 0, m.f(this.f42432e, R.dimen.M_W_X017), m.f(this.f42432e, R.dimen.M_W_X007));
            linearLayout.setGravity(17);
            linearLayout.addView(tbImageView);
            c.a.r0.s.t.l lVar = new c.a.r0.s.t.l(this.f42433f.getPageActivity());
            lVar.r(this.f42432e.getString(R.string.tie_plus_follow_official));
            lVar.h(linearLayout);
            lVar.g(false);
            lVar.p(new TBAlertConfig.a(this.f42432e.getString(R.string.protocol_cancel), TBAlertConfig.OperateBtnStyle.SECONDARY, new View.OnClickListener() { // from class: c.a.r0.d1.d
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        TiePlusHelper.this.x(view);
                    }
                }
            }), new TBAlertConfig.a(this.f42432e.getString(R.string.tie_plus_call_wechat), TBAlertConfig.OperateBtnStyle.MAIN, new View.OnClickListener() { // from class: c.a.r0.d1.c
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
            this.n = lVar.t();
            TiePlusStat.f(TiePlusStat.StatType.WECHAT_DIALOG_EXPOSE, richTextType, TiePlusStat.WechatDialogType.DIRECT, str);
        }
    }

    public final void b0(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, activity) == null) || activity == null) {
            return;
        }
        this.q.clearRequestPermissionList();
        this.q.appendRequestPermission(this.f42433f.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        this.q.appendRequestPermission(this.f42433f.getPageActivity(), s.f57425i);
        this.q.startRequestPermission(activity);
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
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

    public void d0(@NonNull String str, @NonNull Context context, @NonNull TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048598, this, str, context, textView) == null) {
            if (!t(context, str) && !c.a.r0.w.c.q().s(str)) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            c.a.r0.f1.l.a.c().a(this.f42434g, this.f42437j);
        }
    }

    public void e0(@NonNull String str, @NonNull String str2, @NonNull Context context, @NonNull ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048600, this, str, str2, context, progressButton) == null) {
            boolean isUseLongText = progressButton.isUseLongText();
            if (t(context, str)) {
                progressButton.setTag((byte) 4);
                progressButton.setText(context.getString(isUseLongText ? R.string.immediately_open : R.string.pb_video_promotion_mount_open));
            } else if (c.a.r0.w.c.q().s(str)) {
                progressButton.setTag((byte) 2);
                progressButton.setText(context.getString(isUseLongText ? R.string.immediately_install : R.string.install));
            } else if (!c.a.r0.w.c.q().t(str) && !c.a.r0.w.c.q().r(str)) {
                File m = c.a.r0.w.c.q().m(str, str2);
                if (m != null && m.exists()) {
                    SharedPreferences sharedPreferences = this.r;
                    int i2 = sharedPreferences.getInt(str + str2, -1);
                    progressButton.setTag((byte) 3);
                    progressButton.setCurProgress(i2);
                    progressButton.setText(context.getString(isUseLongText ? R.string.go_on_download : R.string.go_on));
                    if (this.s) {
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
                if (this.s) {
                    e();
                }
            }
        }
    }

    public void f(ProgressButton progressButton) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, progressButton) == null) || progressButton == null || this.p.contains(progressButton)) {
            return;
        }
        this.p.add(progressButton);
    }

    public final void f0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            SharedPreferences sharedPreferences = this.r;
            if (i2 != sharedPreferences.getInt(this.f42434g + this.f42435h, -1)) {
                SharedPreferences.Editor edit = this.r.edit();
                edit.putInt(this.f42434g + this.f42435h, i2);
                edit.apply();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(l lVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, lVar) == null) || lVar == null) {
            return;
        }
        for (l lVar2 : w) {
            if (TextUtils.isEmpty(lVar.f13992f) || lVar.f13992f.equals(lVar2.f13992f)) {
                return;
            }
            while (r0.hasNext()) {
            }
        }
        w.add(lVar);
    }

    public final TbHttpMessageTask h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            TbHttpMessageTask tbHttpMessageTask = this.t;
            if (tbHttpMessageTask != null) {
                return tbHttpMessageTask;
            }
            TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_TIEBA_PLUS_GAME_ITEM_ORDER, TbConfig.SERVER_ADDRESS + "c/c/item/subscribeitem");
            this.t = tbHttpMessageTask2;
            tbHttpMessageTask2.setResponsedClass(TiebaPlusAppointResponsedMsg.class);
            return this.t;
        }
        return (TbHttpMessageTask) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            SharedPreferences sharedPreferences = this.r;
            if (sharedPreferences.getInt(this.f42434g + this.f42435h, -1) != -1) {
                SharedPreferences.Editor edit = this.r.edit();
                edit.remove(this.f42434g + this.f42435h);
                edit.apply();
            }
        }
    }

    public void l(String str, int i2, String str2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{str, Integer.valueOf(i2), str2, Integer.valueOf(i3)}) == null) || StringUtils.isNull(str) || this.f42433f == null) {
            return;
        }
        if (i2 == 1) {
            if (i3 == 0 || i3 == 1) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("need_scheme_blacklist", true);
                c.a.s0.h4.a.b(this.f42433f, str, bundle);
            } else if (i3 != 2) {
            } else {
                c.a.r0.m.a.k(this.f42432e, str, false);
            }
        } else if (i2 != 4) {
        } else {
            if (!t(this.f42432e, "com.tencent.mm")) {
                BdToast.c(this.f42432e.getApplicationContext(), this.f42432e.getText(R.string.tie_plus_wechat_not_install)).q();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f42435h : (String) invokeV.objValue;
    }

    public final HttpMessageListener n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            HttpMessageListener httpMessageListener = this.u;
            if (httpMessageListener != null) {
                return httpMessageListener;
            }
            c cVar = new c(this, CmdConfigHttp.CMD_TIEBA_PLUS_GAME_ITEM_ORDER);
            this.u = cVar;
            return cVar;
        }
        return (HttpMessageListener) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        File m;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, view) == null) && view != null && (view.getTag() instanceof Byte)) {
            if ((view instanceof ProgressButton) && (tbPageContext = this.f42433f) != null) {
                r((ProgressButton) view, tbPageContext.getPageActivity());
                return;
            }
            switch (((Byte) view.getTag()).byteValue()) {
                case 16:
                    l(this.f42438k, 1, "", 0);
                    return;
                case 17:
                    l(this.f42436i, 1, "", 0);
                    return;
                case 18:
                    if (!StringUtils.isNull(this.f42434g) && !StringUtils.isNull(this.l)) {
                        c.a.r0.w.c.q().h(this.l, this.f42434g, true);
                        File j2 = c.a.r0.w.c.q().j(this.f42434g);
                        if (j2 != null && j2.exists()) {
                            j2.delete();
                        }
                        if (!StringUtils.isNull(this.f42435h) && (m = c.a.r0.w.c.q().m(this.f42434g, this.f42435h)) != null && m.exists()) {
                            m.delete();
                        }
                        k();
                        DownloadData downloadData = new DownloadData(this.f42434g);
                        downloadData.setStatus(4);
                        c.a.r0.w.c.q().w(downloadData);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921626, this.f42434g));
                    }
                    c.a.r0.f1.l.a.c().h(this.f42434g);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f42434g : (String) invokeV.objValue;
    }

    public final void r(ProgressButton progressButton, @NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048613, this, progressButton, activity) == null) || progressButton == null || progressButton.getVisibility() != 0 || !(progressButton.getTag() instanceof Byte) || StringUtils.isNull(this.f42434g) || StringUtils.isNull(this.f42435h) || StringUtils.isNull(this.l)) {
            return;
        }
        byte byteValue = ((Byte) progressButton.getTag()).byteValue();
        if (byteValue == 0) {
            if (this.m != null) {
                c.a.s0.p0.b.b bVar = new c.a.s0.p0.b.b();
                bVar.f21425e = this.m;
                bVar.f21426f = 2;
                Context context = this.f42432e;
                if ((context instanceof Activity) && !"DownloadManagerActivity".equals(((Activity) context).getClass().getSimpleName())) {
                    bVar.f21427g = 1;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921627, bVar));
            }
            X();
            W(activity);
            if (this.s) {
                e();
                Y(activity);
            }
        } else if (byteValue != 1) {
            if (byteValue == 2) {
                W(activity);
            } else if (byteValue == 3) {
                X();
                W(activity);
            } else if (byteValue != 4) {
            } else {
                z(this.f42432e, this.f42434g);
            }
        } else if (s(activity)) {
            if (!c.a.r0.w.c.q().r(this.f42434g) && !c.a.r0.w.c.q().t(this.f42434g)) {
                DownloadData downloadData = new DownloadData(this.f42434g);
                downloadData.setStatus(4);
                c.a.r0.w.c.q().w(downloadData);
                return;
            }
            c.a.r0.w.c.q().g(this.l, this.f42434g);
        } else {
            b0(activity);
        }
    }

    public final boolean s(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, activity)) == null) {
            if (activity == null) {
                return true;
            }
            return this.q.checkPermissionGranted(activity, "android.permission.WRITE_EXTERNAL_STORAGE") && this.q.checkPermissionGranted(activity, s.f57425i);
        }
        return invokeL.booleanValue;
    }

    public final boolean t(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048615, this, context, str)) == null) {
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

    public /* synthetic */ void w(TiePlusStat.RichTextType richTextType, String str, View view) {
        AlertDialog alertDialog = this.n;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (!t(this.f42432e, "com.tencent.mm")) {
            BdToast.c(this.f42432e.getApplicationContext(), this.f42432e.getText(R.string.tie_plus_wechat_not_install)).q();
            return;
        }
        r0.c(this.f42432e);
        TiePlusStat.f(TiePlusStat.StatType.WECHAT_DIALOG_CLICK, richTextType, TiePlusStat.WechatDialogType.COPY, str);
    }

    public /* synthetic */ void x(View view) {
        AlertDialog alertDialog = this.n;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public /* synthetic */ void y(TiebaPlusInfo tiebaPlusInfo, TiePlusStat.RichTextType richTextType, String str, View view) {
        AlertDialog alertDialog = this.n;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (!t(this.f42432e, "com.tencent.mm")) {
            BdToast.c(this.f42432e.getApplicationContext(), this.f42432e.getText(R.string.tie_plus_wechat_not_install)).q();
            return;
        }
        r0.d(tiebaPlusInfo, this.f42432e.getString(R.string.tie_plus_wechat_dialog_tip));
        TiePlusStat.f(TiePlusStat.StatType.WECHAT_DIALOG_CLICK, richTextType, TiePlusStat.WechatDialogType.DIRECT, str);
    }

    public final boolean z(Context context, String str) {
        InterceptResult invokeLL;
        ResolveInfo next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048620, this, context, str)) == null) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, customResponsedMessage) == null) && (customResponsedMessage instanceof DownloadMessage)) {
            DownloadMessage downloadMessage = (DownloadMessage) customResponsedMessage;
            if (downloadMessage.getData() == null || downloadMessage.getData().size() <= 0 || StringUtils.isNull(this.f42434g)) {
                return;
            }
            for (DownloadData downloadData : downloadMessage.getData()) {
                if (downloadData != null) {
                    if (downloadData.getStatus() == 21 && !StringUtils.isNull(this.f42435h)) {
                        for (ProgressButton progressButton : this.p) {
                            e0(this.f42434g, this.f42435h, this.f42432e, progressButton);
                        }
                    } else if (this.f42434g.equals(downloadData.getId())) {
                        int status = downloadData.getStatus();
                        if (status == 0) {
                            if (!StringUtils.isNull(this.f42435h)) {
                                for (ProgressButton progressButton2 : this.p) {
                                    progressButton2.setCurProgress(100);
                                }
                            }
                            k();
                            return;
                        } else if (status == 1) {
                            int k2 = (int) (c.a.r0.w.c.q().k(this.f42434g) * 100.0f);
                            f0(k2);
                            for (ProgressButton progressButton3 : this.p) {
                                progressButton3.setTag((byte) 1);
                                progressButton3.updateProgress(k2);
                            }
                            return;
                        } else if (status == 2) {
                            TbPageContext<?> tbPageContext = this.f42433f;
                            if (tbPageContext != null) {
                                tbPageContext.showToast(R.string.download_error_info);
                            }
                            V();
                            return;
                        } else if (status == 3) {
                            k();
                            return;
                        } else if (status == 4) {
                            V();
                            return;
                        } else if (status != 5) {
                            return;
                        } else {
                            int i2 = 0;
                            if (downloadData.getExtra() != null && (downloadData.getExtra() instanceof Integer)) {
                                i2 = ((Integer) downloadData.getExtra()).intValue();
                                f0(i2);
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
