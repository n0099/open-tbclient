package com.baidu.tieba.ala.gamefrslivetab.video;

import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ad;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.gi5;
import com.baidu.tieba.mh6;
import com.baidu.tieba.nh6;
import com.baidu.tieba.oh6;
import com.baidu.tieba.ph6;
import com.baidu.tieba.rh6;
import com.baidu.tieba.sh6;
import com.baidu.tieba.util.TopicListUtil;
import com.baidu.tieba.wr5;
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
public class NewAlaGameFrsLiveTabVideoView implements IGameFrsLiveTabVideoView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;
    public View b;
    public NavigationBar c;
    public TbWebView d;
    public LoadingView e;
    public gi5 f;
    public boolean g;
    public String h;
    public int i;
    public boolean j;
    public boolean k;
    public ShareFromPBMsgData l;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ NewAlaGameFrsLiveTabVideoView b;

        public a(NewAlaGameFrsLiveTabVideoView newAlaGameFrsLiveTabVideoView, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newAlaGameFrsLiveTabVideoView, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = newAlaGameFrsLiveTabVideoView;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AndroidUtils.copyToClipboard(this.a.linkUrl);
                BdUtilHelper.showToast(this.b.a.getActivity(), view2.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewAlaGameFrsLiveTabVideoView a;

        public b(NewAlaGameFrsLiveTabVideoView newAlaGameFrsLiveTabVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newAlaGameFrsLiveTabVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newAlaGameFrsLiveTabVideoView;
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
        public final /* synthetic */ NewAlaGameFrsLiveTabVideoView a;

        public c(NewAlaGameFrsLiveTabVideoView newAlaGameFrsLiveTabVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newAlaGameFrsLiveTabVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newAlaGameFrsLiveTabVideoView;
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
    public class d implements sh6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewAlaGameFrsLiveTabVideoView a;

        @Override // com.baidu.tieba.sh6
        public /* synthetic */ void b(int i, int i2, int i3, int i4) {
            rh6.b(this, i, i2, i3, i4);
        }

        @Override // com.baidu.tieba.sh6
        public /* synthetic */ void c(int i, int i2, int i3, int i4) {
            rh6.a(this, i, i2, i3, i4);
        }

        public d(NewAlaGameFrsLiveTabVideoView newAlaGameFrsLiveTabVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newAlaGameFrsLiveTabVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newAlaGameFrsLiveTabVideoView;
        }

        @Override // com.baidu.tieba.sh6
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4) != null) || Math.abs(i2 - this.a.i) <= 50) {
                return;
            }
            this.a.i = i2;
            if (i2 > i4) {
                this.a.M(false, true);
            } else {
                this.a.M(true, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewAlaGameFrsLiveTabVideoView a;

        public e(NewAlaGameFrsLiveTabVideoView newAlaGameFrsLiveTabVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newAlaGameFrsLiveTabVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newAlaGameFrsLiveTabVideoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.L();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements mh6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewAlaGameFrsLiveTabVideoView a;

        public f(NewAlaGameFrsLiveTabVideoView newAlaGameFrsLiveTabVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newAlaGameFrsLiveTabVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newAlaGameFrsLiveTabVideoView;
        }

        @Override // com.baidu.tieba.mh6
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) != null) {
                return invokeLL.booleanValue;
            }
            this.a.I(str);
            if (StringUtils.isNull(str) || str.contains(UrlSchemaHelper.REDIRECT_JUMP_KEY)) {
                return false;
            }
            if (!this.a.J(str)) {
                UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{str});
            }
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements oh6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewAlaGameFrsLiveTabVideoView a;

        public g(NewAlaGameFrsLiveTabVideoView newAlaGameFrsLiveTabVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newAlaGameFrsLiveTabVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newAlaGameFrsLiveTabVideoView;
        }

        @Override // com.baidu.tieba.oh6
        public void a(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                this.a.N();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements nh6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewAlaGameFrsLiveTabVideoView a;

        public h(NewAlaGameFrsLiveTabVideoView newAlaGameFrsLiveTabVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newAlaGameFrsLiveTabVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newAlaGameFrsLiveTabVideoView;
        }

        @Override // com.baidu.tieba.nh6
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                this.a.hideLoadingView();
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.P();
                    this.a.g = true;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ph6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewAlaGameFrsLiveTabVideoView a;

        public i(NewAlaGameFrsLiveTabVideoView newAlaGameFrsLiveTabVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newAlaGameFrsLiveTabVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newAlaGameFrsLiveTabVideoView;
        }

        @Override // com.baidu.tieba.ph6
        public void a(WebView webView, WebResourceRequest webResourceRequest, int i, CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLIL(1048576, this, webView, webResourceRequest, i, charSequence) == null) {
                this.a.O();
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

        public j(NewAlaGameFrsLiveTabVideoView newAlaGameFrsLiveTabVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newAlaGameFrsLiveTabVideoView};
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

    public NewAlaGameFrsLiveTabVideoView(boolean z) {
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

    public final boolean B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_DRESSUP_CENTER)) {
                return false;
            }
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                BdUtilHelper.showToast(this.a.getActivity(), (int) R.string.plugin_install_fail);
            } else {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{str});
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            boolean z = false;
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SQUARE_FORUM_LIST)) {
                return false;
            }
            if (MessageManager.getInstance().findTask(2902025) != null) {
                z = true;
            }
            if (z) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.a.getActivity(), WebviewHelper.getMatchStringFromURL(str, "menuname="), WebviewHelper.getMatchStringFromURL(str, "menutype="), WebviewHelper.getMatchStringFromURL(str, "menuid="))));
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean E(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!str.contains(UrlSchemaHelper.SCHEMA_TYPE_LEGO)) {
                return false;
            }
            if (MessageManager.getInstance().findTask(2016447) != null) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                BdUtilHelper.showToast(this.a.getActivity(), (int) R.string.plugin_install_fail);
            } else {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{str});
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (StringUtils.isNull(str) || !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_CENTER)) {
                return false;
            }
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MembercenterActivityConfig.class)) {
                BdUtilHelper.showToast(this.a.getActivity(), (int) R.string.plugin_install_fail);
            } else {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{str});
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            if (!str.contains("nohead:url") && !str.contains("booktown")) {
                return false;
            }
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                BdUtilHelper.showToast(this.a.getActivity(), (int) R.string.plugin_install_fail);
            } else {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{str});
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void I(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, str) != null) || StringUtils.isNull(str)) {
        }
    }

    @Override // com.baidu.tieba.ala.gamefrslivetab.video.IGameFrsLiveTabVideoView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.h = str;
            this.d.loadUrl(str);
        }
    }

    @Override // com.baidu.tieba.ala.gamefrslivetab.video.IGameFrsLiveTabVideoView
    public void onChangeSkinType(int i2) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i2) == null) && (navigationBar = this.c) != null) {
            navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.c.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
    }

    @Override // com.baidu.tieba.ala.gamefrslivetab.video.IGameFrsLiveTabVideoView
    public View G(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, layoutInflater, viewGroup)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0101, (ViewGroup) null);
            this.b = inflate;
            inflate.setDrawingCacheEnabled(false);
            return this.b;
        }
        return (View) invokeLL.objValue;
    }

    public final boolean D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!str.contains(UrlSchemaHelper.JUMP_TO_HOT_TOPIC) && !str.contains(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW)) {
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_LIST_NEW)) {
                    TopicListUtil.openWebTopicListPage();
                    return true;
                }
                return false;
            }
            String matchStringFromURL = WebviewHelper.getMatchStringFromURL(str, "topic_id=");
            String matchStringFromURL2 = WebviewHelper.getMatchStringFromURL(str, "topic_name=");
            String matchStringFromURL3 = WebviewHelper.getMatchStringFromURL(str, "is_video_topic=");
            boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            if (!StringUtils.isNull(matchStringFromURL) && !StringUtils.isNull(matchStringFromURL2, true)) {
                if (appResponseToIntentClass) {
                    if (StringHelper.equals(matchStringFromURL3, "1")) {
                        new HotTopicActivityConfig(this.a.getActivity()).createNormalConfig(matchStringFromURL, matchStringFromURL2, matchStringFromURL3, null).start();
                    } else {
                        wr5.f(this.a.getPageContext(), matchStringFromURL, matchStringFromURL2);
                    }
                } else {
                    BrowserHelper.startWebActivity(this.a.getActivity(), matchStringFromURL2, str);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ala.gamefrslivetab.video.IGameFrsLiveTabVideoView
    public void u(BaseFragment baseFragment) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, baseFragment) == null) {
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
            TbWebView tbWebView = (TbWebView) this.b.findViewById(R.id.obfuscated_res_0x7f092a0e);
            this.d = tbWebView;
            tbWebView.setOnScrollChangeListener(new d(this));
            s();
        }
    }

    public final boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
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
                builder.setData(arrayList).setIsCDN(true).setLastId(arrayList.get(0)).setIsReserve(true);
                ImageViewerConfig bulid = builder.bulid(this.a.getActivity());
                bulid.getIntent().putExtra("from", ImageViewerConfig.FROM_DISCOVER_BEAUTY);
                this.a.sendMessage(new CustomMessage(2010000, bulid));
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (this.a.isAdded() && str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE)) {
                String urlDecode = ad.getUrlDecode(str);
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
                        shareItem.title = optString;
                        shareItem.content = format;
                        shareItem.linkUrl = optString3;
                        shareItem.extData = optString4;
                        if (!TextUtils.isEmpty(optString6)) {
                            shareItem.imageUri = Uri.parse(optString6);
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

    public final boolean J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (!E(str) && !w(str) && !D(str) && !C(str) && !F(str) && !B(str) && !v(str) && !H(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.g) {
                this.d.loadUrl("javascript:window.reload_page()");
            } else {
                this.d.loadUrl(this.h);
            }
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            q();
            this.d.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ala.gamefrslivetab.video.IGameFrsLiveTabVideoView
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ala.gamefrslivetab.video.IGameFrsLiveTabVideoView
    public void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.j = false;
            LoadingView loadingView = this.e;
            if (loadingView != null) {
                loadingView.dettachView(this.b);
                this.e = null;
            }
        }
    }

    @Override // com.baidu.tieba.ala.gamefrslivetab.video.IGameFrsLiveTabVideoView
    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && !this.j && BdNetTypeUtil.isNetWorkAvailable()) {
            this.d.loadUrl(this.h);
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            MessageManager.getInstance().unRegisterTask(2921015);
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.release();
            }
            this.d.onDestroy();
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.d.onPause();
        }
    }

    @Override // com.baidu.tieba.browser.lifecycle.WebViewLifeCycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.d.onResume();
        }
    }

    public void q() {
        gi5 gi5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (gi5Var = this.f) != null) {
            gi5Var.dettachView(this.b);
            this.f = null;
        }
    }

    @Override // com.baidu.tieba.ala.gamefrslivetab.video.IGameFrsLiveTabVideoView
    public NavigationBar r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.c;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public final void M(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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

    public void N() {
        BaseFragment baseFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (baseFragment = this.a) != null && this.b != null && baseFragment.isAdded()) {
            this.j = true;
            LoadingView loadingView = new LoadingView(this.a.getActivity(), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703ac));
            this.e = loadingView;
            loadingView.attachView(this.b, false);
            this.e.onChangeSkinType();
        }
    }

    public void O() {
        BaseFragment baseFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (baseFragment = this.a) != null && baseFragment.isAdded()) {
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e4f);
            if (this.f == null) {
                gi5 gi5Var = new gi5(this.a.getActivity(), new e(this));
                this.f = gi5Var;
                gi5Var.onChangeSkinType();
            }
            this.d.setVisibility(8);
            this.f.l(string);
            this.f.attachView(this.b, false);
            this.f.o();
        }
    }

    public final void s() {
        TbWebView tbWebView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048600, this) != null) || (tbWebView = this.d) == null) {
            return;
        }
        tbWebView.setOnLoadUrlListener(new f(this));
        this.d.setOnPageStartedListener(new g(this));
        this.d.setOnPageFinishedListener(new h(this));
        this.d.setOnReceivedErrorListener(new i(this));
    }
}
