package com.baidu.tieba.ala.gamefrslivetab.video;

import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.hybrid.ScrollBridgeWebview;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.switchs.NewWebHotTopicPageSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.by5;
import com.baidu.tieba.j6a;
import com.baidu.tieba.li;
import com.baidu.tieba.qx4;
import com.baidu.tieba.ui;
import com.baidu.tieba.vi;
import com.baidu.tieba.vm5;
import com.baidu.tieba.wm5;
import com.baidu.tieba.yw5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AlaGameFrsLiveTabVideoView implements IGameFrsLiveTabVideoView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;
    public View b;
    public NavigationBar c;
    public ScrollBridgeWebview d;
    public vm5 e;
    public wm5 f;
    public boolean g;
    public String h;
    public int i;
    public boolean j;
    public boolean k;
    public ShareFromPBMsgData l;

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ AlaGameFrsLiveTabVideoView b;

        public a(AlaGameFrsLiveTabVideoView alaGameFrsLiveTabVideoView, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabVideoView, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = alaGameFrsLiveTabVideoView;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                li.a(this.a.x);
                vi.Q(this.b.a.getActivity(), view2.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveTabVideoView a;

        public b(AlaGameFrsLiveTabVideoView alaGameFrsLiveTabVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaGameFrsLiveTabVideoView;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(2921015, this.a.l);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveTabVideoView a;

        public c(AlaGameFrsLiveTabVideoView alaGameFrsLiveTabVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaGameFrsLiveTabVideoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.a.getPageContext().getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ScrollBridgeWebview.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveTabVideoView a;

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void b(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
            }
        }

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void d(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3, i4) == null) {
            }
        }

        public d(AlaGameFrsLiveTabVideoView alaGameFrsLiveTabVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaGameFrsLiveTabVideoView;
        }

        @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview.a
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4) != null) || Math.abs(i2 - this.a.i) <= 50) {
                return;
            }
            this.a.i = i2;
            if (i2 > i4) {
                this.a.J(false, true);
            } else {
                this.a.J(true, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveTabVideoView a;

        public e(AlaGameFrsLiveTabVideoView alaGameFrsLiveTabVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaGameFrsLiveTabVideoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.I();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements BaseWebView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveTabVideoView a;

        public f(AlaGameFrsLiveTabVideoView alaGameFrsLiveTabVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaGameFrsLiveTabVideoView;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) != null) {
                return invokeLL.booleanValue;
            }
            this.a.G(str);
            if (StringUtils.isNull(str) || str.contains(UrlSchemaHelper.REDIRECT_JUMP_KEY)) {
                return false;
            }
            if (!this.a.H(str)) {
                UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{str});
            }
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveTabVideoView a;

        public g(AlaGameFrsLiveTabVideoView alaGameFrsLiveTabVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaGameFrsLiveTabVideoView;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void d(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                this.a.L();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveTabVideoView a;

        public h(AlaGameFrsLiveTabVideoView alaGameFrsLiveTabVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaGameFrsLiveTabVideoView;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                this.a.hideLoadingView();
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.N();
                    this.a.g = true;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements BaseWebView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameFrsLiveTabVideoView a;

        public i(AlaGameFrsLiveTabVideoView alaGameFrsLiveTabVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaGameFrsLiveTabVideoView;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
        public void a(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i, str, str2) == null) {
                this.a.M();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public j(AlaGameFrsLiveTabVideoView alaGameFrsLiveTabVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameFrsLiveTabVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public AlaGameFrsLiveTabVideoView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 0;
        this.k = false;
        CustomMessageTask customMessageTask = new CustomMessageTask(2921015, new b(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.k = z;
    }

    public final boolean C(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!str.contains(UrlSchemaHelper.SCHEMA_TYPE_LEGO)) {
                return false;
            }
            if (MessageManager.getInstance().findTask(2016447) != null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                vi.P(this.a.getActivity(), R.string.plugin_install_fail);
            } else {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{str});
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_CENTER)) {
                return false;
            }
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MembercenterActivityConfig.class)) {
                vi.P(this.a.getActivity(), R.string.plugin_install_fail);
            } else {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{str});
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            if (!str.contains("nohead:url") && !str.contains("booktown")) {
                return false;
            }
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                vi.P(this.a.getActivity(), R.string.plugin_install_fail);
            } else {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{str});
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_DRESSUP_CENTER)) {
                return false;
            }
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                vi.P(this.a.getActivity(), R.string.plugin_install_fail);
            } else {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{str});
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            boolean z = false;
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SQUARE_FORUM_LIST)) {
                return false;
            }
            if (MessageManager.getInstance().findTask(2902025) != null) {
                z = true;
            }
            if (z) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.a.getActivity(), by5.c(str, "menuname="), by5.c(str, "menutype="), by5.c(str, "menuid="))));
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void G(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || StringUtils.isNull(str)) {
        }
    }

    @Override // com.baidu.tieba.ala.gamefrslivetab.video.IGameFrsLiveTabVideoView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.h = str;
            this.d.loadUrl(str);
        }
    }

    @Override // com.baidu.tieba.ala.gamefrslivetab.video.IGameFrsLiveTabVideoView
    public void onChangeSkinType(int i2) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i2) == null) && (navigationBar = this.c) != null) {
            navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.c.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
    }

    @Override // com.baidu.tieba.ala.gamefrslivetab.video.IGameFrsLiveTabVideoView
    public View K(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, layoutInflater, viewGroup)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00fd, (ViewGroup) null);
            this.b = inflate;
            inflate.setDrawingCacheEnabled(false);
            return this.b;
        }
        return (View) invokeLL.objValue;
    }

    public final boolean E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.a.isAdded() && str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE)) {
                String urlDecode = ui.getUrlDecode(str);
                if (!urlDecode.contains("data=")) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(urlDecode.substring(urlDecode.indexOf("data=") + 5));
                    String optString = jSONObject.optString("title");
                    String optString2 = jSONObject.optString("content");
                    String optString3 = jSONObject.optString("link_url");
                    String optString4 = jSONObject.optString("thread_id");
                    String optString5 = jSONObject.optString("forum_name");
                    String optString6 = jSONObject.optString("pic");
                    if (TextUtils.isEmpty(optString3)) {
                        return false;
                    }
                    if (ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
                        this.l = shareFromPBMsgData;
                        shareFromPBMsgData.setContent(optString2);
                        if (!TextUtils.isEmpty(optString6)) {
                            this.l.setImageUrl(optString6);
                        }
                        this.l.setForumName(optString5);
                        this.l.setThreadId(optString4);
                        this.l.setTitle(optString);
                        String format = MessageFormat.format(this.a.getResources().getString(R.string.share_content_tpl), optString, optString2);
                        ShareItem shareItem = new ShareItem();
                        shareItem.v = optString;
                        shareItem.w = format;
                        shareItem.x = optString3;
                        shareItem.u = optString4;
                        if (!TextUtils.isEmpty(optString6)) {
                            shareItem.z = Uri.parse(optString6);
                        }
                        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.a.getActivity(), shareItem, true);
                        shareDialogConfig.setIsCopyLink(true);
                        shareDialogConfig.addOutsideTextView(R.string.forum_friend, R.drawable.icon_unite_share_baf, new j(this));
                        shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
                        this.a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
                    }
                    return true;
                } catch (JSONException unused) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (!C(str) && !t(str) && !z(str) && !v(str) && !D(str) && !u(str) && !s(str) && !E(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.g) {
                this.d.loadUrl("javascript:window.reload_page()");
            } else {
                this.d.loadUrl(this.h);
            }
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            q();
            this.d.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.gamefrslivetab.video.IGameFrsLiveTabVideoView
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d.getUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ala.gamefrslivetab.video.IGameFrsLiveTabVideoView
    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && !this.j && BdNetTypeUtil.isNetWorkAvailable()) {
            this.d.loadUrl(this.h);
        }
    }

    @Override // com.baidu.tieba.ala.gamefrslivetab.video.IGameFrsLiveTabVideoView
    public void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.j = false;
            vm5 vm5Var = this.e;
            if (vm5Var != null) {
                vm5Var.dettachView(this.b);
                this.e = null;
            }
        }
    }

    @Override // com.baidu.tieba.ala.gamefrslivetab.video.IGameFrsLiveTabVideoView
    public NavigationBar n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.c;
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            MessageManager.getInstance().unRegisterTask(2921015);
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.release();
            }
        }
    }

    public void q() {
        wm5 wm5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (wm5Var = this.f) != null) {
            wm5Var.dettachView(this.b);
            this.f = null;
        }
    }

    public final void J(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                CustomMessage customMessage = new CustomMessage(2001617);
                customMessage.setTag(this.a.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001617, Boolean.valueOf(z2));
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            CustomMessage customMessage2 = new CustomMessage(2001618);
            customMessage2.setTag(this.a.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2001618, Boolean.valueOf(z2));
            customResponsedMessage2.setOrginalMessage(customMessage2);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
        }
    }

    public void L() {
        BaseFragment baseFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (baseFragment = this.a) != null && this.b != null && baseFragment.isAdded()) {
            this.j = true;
            vm5 vm5Var = new vm5(this.a.getActivity(), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a6));
            this.e = vm5Var;
            vm5Var.attachView(this.b, false);
            this.e.onChangeSkinType();
        }
    }

    public void M() {
        BaseFragment baseFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (baseFragment = this.a) != null && baseFragment.isAdded()) {
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0def);
            if (this.f == null) {
                wm5 wm5Var = new wm5(this.a.getActivity(), new e(this));
                this.f = wm5Var;
                wm5Var.onChangeSkinType();
            }
            this.d.setVisibility(8);
            this.f.m(string);
            this.f.attachView(this.b, false);
            this.f.p();
        }
    }

    public final void r() {
        ScrollBridgeWebview scrollBridgeWebview;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || (scrollBridgeWebview = this.d) == null) {
            return;
        }
        scrollBridgeWebview.setOnLoadUrlListener(new f(this));
        this.d.setOnPageStartedListener(new g(this));
        this.d.setOnPageFinishedListener(new h(this));
        this.d.setOnReceivedErrorListener(new i(this));
    }

    public final boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            if (!str.contains(UrlSchemaHelper.SCHEMA_TYPE_BEAUTY_PIC) || !str.contains("data=")) {
                return false;
            }
            String substring = str.substring(str.indexOf("data=") + 5);
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                JSONArray optJSONArray = new JSONObject(substring).optJSONArray("pic");
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    arrayList.add(optJSONArray.getString(i2));
                }
                if (arrayList.size() <= 0) {
                    return false;
                }
                ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                builder.A(arrayList);
                builder.F(true);
                builder.M(arrayList.get(0));
                builder.I(true);
                ImageViewerConfig x = builder.x(this.a.getActivity());
                x.getIntent().putExtra("from", ImageViewerConfig.FROM_DISCOVER_BEAUTY);
                this.a.sendMessage(new CustomMessage(2010000, x));
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ala.gamefrslivetab.video.IGameFrsLiveTabVideoView
    public void x(BaseFragment baseFragment) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, baseFragment) == null) {
            this.a = baseFragment;
            NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.view_navigation_bar);
            this.c = navigationBar;
            if (this.k) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            navigationBar.setVisibility(i2);
            if (this.k) {
                this.c.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                this.c.showBottomLine(true);
                this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
                this.c.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            }
            ScrollBridgeWebview scrollBridgeWebview = (ScrollBridgeWebview) this.b.findViewById(R.id.obfuscated_res_0x7f092924);
            this.d = scrollBridgeWebview;
            scrollBridgeWebview.setOnScrollChangeListener(new d(this));
            r();
        }
    }

    public final boolean z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            if (!str.contains(UrlSchemaHelper.JUMP_TO_HOT_TOPIC) && !str.contains(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW)) {
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_LIST_NEW)) {
                    j6a.b();
                    return true;
                }
                return false;
            }
            String c2 = by5.c(str, "topic_id=");
            String c3 = by5.c(str, "topic_name=");
            String c4 = by5.c(str, "is_video_topic=");
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            if (!StringUtils.isNull(c2) && !StringUtils.isNull(c3, true)) {
                if (appResponseToIntentClass) {
                    if (!StringHelper.equals(c4, "1") && NewWebHotTopicPageSwitch.isOn()) {
                        yw5.e(this.a.getPageContext(), c2, c3);
                    } else {
                        new HotTopicActivityConfig(this.a.getActivity()).createNormalConfig(c2, c3, c4, null).start();
                    }
                } else {
                    qx4.t(this.a.getActivity(), c3, str);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
