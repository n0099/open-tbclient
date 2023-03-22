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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public z68 b;
    public i68 c;
    public BaseActivity d;
    public List<String> e;
    public boolean f;
    public CustomMessageListener g;
    public CustomMessageListener h;
    public CustomMessageListener i;
    public CustomMessageListener j;

    /* loaded from: classes4.dex */
    public class a implements BaseWebView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h68 a;

        public a(h68 h68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h68Var;
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

    /* loaded from: classes4.dex */
    public class b implements BaseWebView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h68 a;

        public b(h68 h68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h68Var;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                if (this.a.o(str)) {
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

    /* loaded from: classes4.dex */
    public class c extends wp5<List<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(h68 h68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h68Var};
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
        @Override // com.baidu.tieba.wp5
        /* renamed from: a */
        public List<String> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return ad9.k();
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements zo5<List<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h68 a;

        public d(h68 h68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zo5
        /* renamed from: a */
        public void onReturnDataInUI(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.a.e = list;
            nu4.c().d(this.a.e);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(h68 h68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h68Var, Integer.valueOf(i)};
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
            this.a = h68Var;
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

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(h68 h68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h68Var, Integer.valueOf(i)};
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
            this.a = h68Var;
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

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(h68 h68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h68Var, Integer.valueOf(i)};
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
            this.a = h68Var;
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

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(h68 h68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h68Var, Integer.valueOf(i)};
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
            this.a = h68Var;
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

    public h68(BaseActivity baseActivity, z68 z68Var, i68 i68Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, z68Var, i68Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new ArrayList();
        this.d = baseActivity;
        this.a = baseActivity.getPageContext();
        this.b = z68Var;
        this.c = i68Var;
        m();
        n();
        k();
    }

    public void j(String str) {
        List<String> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !StringUtils.isNull(str) && (list = this.e) != null) {
            list.remove(str);
            this.e.add(0, str);
        }
    }

    public final void p(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, webView, str) == null) && !StringUtils.isNull(str)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("data", str);
            kd6.a().a(webView, SearchJsBridge.METHOD_SET_SEARCH_HISTORY, linkedHashMap);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            aq5.b(new c(this), new d(this));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a aVar = new a(this);
            b bVar = new b(this);
            nu4.c().d(this.e);
            this.c.z(bVar, null, aVar, null);
        }
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int count = ListUtils.getCount(this.e);
            if (count == 0) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < count; i++) {
                jSONArray.put(this.e.get(i));
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.g);
            MessageManager.getInstance().unRegisterListener(this.h);
            MessageManager.getInstance().unRegisterListener(this.i);
            MessageManager.getInstance().unRegisterListener(this.j);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g = new e(this, 2921556);
            this.h = new f(this, 2921557);
            this.i = new g(this, 2921558);
            this.j = new h(this, 2921559);
            MessageManager.getInstance().registerListener(this.g);
            MessageManager.getInstance().registerListener(this.h);
            MessageManager.getInstance().registerListener(this.i);
            MessageManager.getInstance().registerListener(this.j);
        }
    }

    public final boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (!str.contains(UrlSchemaHelper.JUMP_TO_HOT_TOPIC) && !str.contains(UrlSchemaHelper.JUMP_TO_HOT_TOPIC_NEW)) {
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_HOT_TOPIC_LIST_NEW)) {
                    vj9.b();
                    return true;
                }
                return false;
            }
            String c2 = oq5.c(str, "topic_id=");
            String c3 = oq5.c(str, "topic_name=");
            String c4 = oq5.c(str, "is_video_topic=");
            if (!yo5.b(this.a) && !StringUtils.isNull(c2) && !StringUtils.isNull(c3, true)) {
                if (!StringHelper.equals(c4, "1") && NewWebHotTopicPageSwitch.isOn()) {
                    mp5.e(this.a, c2, c3);
                } else {
                    this.a.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.a.getPageActivity()).createNormalConfig(c2, c3, "4")));
                }
            }
            TiebaStatic.log(new StatisticItem("c10363").param("obj_name", c3));
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void q(boolean z) {
        NoDataViewFactory.e a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (!z) {
                this.c.x();
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    a2 = NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f14ad);
                } else {
                    a2 = NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0d1f);
                }
                this.c.w(a2);
                return;
            }
            this.c.v();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.c.v();
            String l = l();
            if (this.f) {
                if (!StringUtils.isNull(l)) {
                    i68 i68Var = this.c;
                    i68Var.o("javascript:setSearchHistory('" + l + "')");
                }
            } else {
                i68 i68Var2 = this.c;
                i68Var2.o(TbConfig.HTTPS_QUICK_WEBVIEW_PREFIX + "mo/q/hybrid/searchHistory");
            }
            if (this.c.e() != null && !StringUtils.isNull(l)) {
                p(this.c.e(), l());
            }
        }
    }
}
