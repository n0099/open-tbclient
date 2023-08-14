package com.baidu.tieba;

import android.content.Intent;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.switchs.NewWebHotTopicPageSwitch;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.tieba.quickWebView.QuickWebView;
import com.baidu.tieba.util.TopicListUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public f19 b;
    public h19 c;
    public BaseActivity d;
    public List<String> e;
    public boolean f;
    public SearchJsBridge g;
    public CustomMessageListener h;
    public CustomMessageListener i;
    public CustomMessageListener j;
    public CustomMessageListener k;

    /* loaded from: classes6.dex */
    public class a implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
            }
        }

        public a(g19 g19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g19Var};
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

    /* loaded from: classes6.dex */
    public class b implements BaseWebView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g19 a;

        public b(g19 g19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g19Var;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.g
        public void a(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLILL(1048576, this, webView, i, str, str2) != null) || webView != this.a.c.e()) {
                return;
            }
            this.a.q(false);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements BaseWebView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g19 a;

        public c(g19 g19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g19Var;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                if (this.a.p(str)) {
                    return true;
                }
                if (this.a.a != null && this.a.a.getPageActivity() != null) {
                    if (UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.a.a, new String[]{str}) != 3) {
                        return true;
                    }
                    if (str != null && str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                        UrlManager.getInstance().dealOneLink(this.a.a, new String[]{str}, true);
                        return true;
                    }
                    Intent parseIntentFromUrl = BaseWebViewActivity.parseIntentFromUrl(this.a.a.getPageActivity(), str);
                    if (parseIntentFromUrl != null) {
                        try {
                            ArrayList<String> arrayList = (ArrayList) this.a.d.getCurrentPageSourceKeyList();
                            String currentPageKey = this.a.d.getCurrentPageKey();
                            if (arrayList != null && !StringUtils.isNull(currentPageKey) && !arrayList.contains(currentPageKey)) {
                                arrayList.add(currentPageKey);
                            }
                            if (!ListUtils.isEmpty(arrayList)) {
                                parseIntentFromUrl.putStringArrayListExtra("obj_source", arrayList);
                            }
                            this.a.a.getPageActivity().startActivity(parseIntentFromUrl);
                        } catch (Throwable th) {
                            BdLog.detailException(th);
                        }
                        return true;
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d extends kw5<List<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(g19 g19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kw5
        public List<String> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return sca.k();
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements pv5<List<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g19 a;

        public e(g19 g19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g19Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pv5
        /* renamed from: a */
        public void onReturnDataInUI(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.a.e = list;
            this.a.g.setHistoryDatas(this.a.e);
            bz4.c().d(this.a.e);
        }
    }

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g19 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(g19 g19Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g19Var, Integer.valueOf(i)};
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
            this.a = g19Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.a.f = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g19 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(g19 g19Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g19Var, Integer.valueOf(i)};
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
            this.a = g19Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.e.remove((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g19 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(g19 g19Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g19Var, Integer.valueOf(i)};
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
            this.a = g19Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.e != null) {
                this.a.e.clear();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g19 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(g19 g19Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g19Var, Integer.valueOf(i)};
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
            this.a = g19Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                try {
                    JSONObject jSONObject = new JSONObject((String) customResponsedMessage.getData());
                    String optString = jSONObject.optString("query");
                    int optInt = jSONObject.optInt(AdvisoryMsgBusinessExtra.SUBTYPE_KEY);
                    if (this.a.b != null) {
                        this.a.b.a(optString, true, optInt);
                        TiebaStatic.log(new StatisticItem("c12034"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public g19(BaseActivity baseActivity, f19 f19Var, h19 h19Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, f19Var, h19Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new ArrayList();
        this.d = baseActivity;
        this.a = baseActivity.getPageContext();
        this.b = f19Var;
        this.c = h19Var;
        n();
        o();
        l();
    }

    public void k(String str) {
        List<String> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !StringUtils.isNull(str) && (list = this.e) != null) {
            list.remove(str);
            this.e.add(0, str);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ow5.b(new d(this), new e(this));
        }
    }

    public final String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int count = ListUtils.getCount(this.e);
            if (count == 0) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < count; i2++) {
                jSONArray.put(this.e.get(i2));
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.h);
            MessageManager.getInstance().unRegisterListener(this.i);
            MessageManager.getInstance().unRegisterListener(this.j);
            MessageManager.getInstance().unRegisterListener(this.k);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.h = new f(this, 2921556);
            this.i = new g(this, 2921557);
            this.j = new h(this, 2921558);
            this.k = new i(this, 2921559);
            MessageManager.getInstance().registerListener(this.h);
            MessageManager.getInstance().registerListener(this.i);
            MessageManager.getInstance().registerListener(this.j);
            MessageManager.getInstance().registerListener(this.k);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a aVar = new a(this);
            b bVar = new b(this);
            c cVar = new c(this);
            QuickWebView e2 = this.c.e();
            if (e2 != null) {
                this.g = new SearchJsBridge(this.e);
                bz4.c().d(this.e);
                e2.h(this.g);
                e2.setOnPageFinishedListener(aVar);
                e2.setOnReceivedErrorListener(bVar);
                e2.setOnLoadUrlListener(cVar);
            }
        }
    }

    public final boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
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
            if (!ov5.b(this.a) && !StringUtils.isNull(matchStringFromURL) && !StringUtils.isNull(matchStringFromURL2, true)) {
                if (!StringHelper.equals(matchStringFromURL3, "1") && NewWebHotTopicPageSwitch.isOn()) {
                    aw5.f(this.a, matchStringFromURL, matchStringFromURL2);
                } else {
                    this.a.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.a.getPageActivity()).createNormalConfig(matchStringFromURL, matchStringFromURL2, "4")));
                }
            }
            TiebaStatic.log(new StatisticItem("c10363").param("obj_name", matchStringFromURL2));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void q(boolean z) {
        NoDataViewFactory.e a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (!z) {
                this.c.u();
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    a2 = NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f161e);
                } else {
                    a2 = NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0e21);
                }
                this.c.t(a2);
                return;
            }
            this.c.s();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c.s();
            String m = m();
            if (this.f) {
                if (!StringUtils.isNull(m)) {
                    QuickWebView e2 = this.c.e();
                    e2.loadUrl("javascript:setSearchHistory('" + m + "')");
                }
            } else {
                QuickWebView e3 = this.c.e();
                e3.loadUrl(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "mo/q/hybrid/searchHistory");
            }
            if (this.c.e() != null && !StringUtils.isNull(m)) {
                this.c.e().m(m());
            }
        }
    }
}
