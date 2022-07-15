package com.baidu.tieba.homepage.topic.topicdetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.homepage.topic.topicdetail.model.TopicDetailModel;
import com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c17;
import com.repackage.ej4;
import com.repackage.g17;
import com.repackage.ng;
import com.repackage.ni;
import com.repackage.nn;
import com.repackage.oi;
import com.repackage.z8;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TopicDetailActivity extends BaseActivity<TopicDetailActivity> implements c17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TopicDetailModel a;
    public TopicDetailView b;
    public long c;
    public long d;
    public long e;
    public boolean f;

    /* loaded from: classes3.dex */
    public class a implements BdUniDispatchSchemeController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicDetailActivity a;

        public a(TopicDetailActivity topicDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicDetailActivity;
        }

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.b
        public void a(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && hashMap != null && (hashMap.get(BdUniDispatchSchemeController.PARAM_TOPIC_ID) instanceof String)) {
                String str = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_TOPIC_ID);
                if (StringUtils.isNull(str)) {
                    return;
                }
                this.a.e = ng.g(str, -1L);
            }
        }
    }

    public TopicDetailActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 1L;
        this.f = false;
    }

    public final void B1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (str.startsWith("//")) {
                str = str.substring(2);
            }
            Map<String, String> paramPair = UrlManager.getParamPair(str);
            if (paramPair != null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE);
                ej4.b(statisticItem, paramPair);
                statisticItem.param("obj_locate", paramPair.get("obj_locate"));
                statisticItem.param("obj_type", 1);
                statisticItem.param("tid", paramPair.get("tid"));
                statisticItem.param("obj_source", paramPair.get("obj_source"));
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, paramPair.get(TiebaStatic.Params.OBJ_PARAM2));
                statisticItem.param(TiebaStatic.Params.OBJ_TO, 3);
                statisticItem.param("obj_id", paramPair.get(TiebaStatic.Params.BDID));
                statisticItem.param("obj_name", TbadkCoreApplication.getInst().getStartType());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, 1);
                if (!oi.isEmpty(paramPair.get("ext_log"))) {
                    try {
                        JSONObject jSONObject = new JSONObject(paramPair.get("ext_log"));
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            statisticItem.param(next, jSONObject.getString(next));
                        }
                    } catch (JSONException e) {
                        BdLog.e(e.getMessage());
                    }
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public void C1(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            long j2 = this.c + 1;
            this.c = j2;
            this.d = j;
            this.a.G(this.e, j2, j);
        }
    }

    @Override // com.repackage.c17
    public void N0(int i, boolean z, List<nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), list}) == null) {
            this.b.setNextData(i, z, list);
        }
    }

    @Override // com.repackage.c17
    public void a() {
        int i;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Intent intent = getIntent();
            if (intent == null) {
                finish();
                return;
            }
            this.e = -1L;
            if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
                Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
                String uri2 = uri.toString();
                if (BdUniDispatchSchemeController.isUniScheme(uri)) {
                    BdUniDispatchSchemeController.getInstance().parseTopicDetailScheme(uri, new a(this));
                } else if (!StringUtils.isNull(uri2) && uri2.startsWith("tbtopicdetail://")) {
                    String decode = Uri.decode(uri.getEncodedPath());
                    if (StringUtils.isNull(decode)) {
                        return;
                    }
                    B1(decode);
                    Matcher matcher = Pattern.compile(".*fr=(.*)&topic_id=([\\d]+).*").matcher(decode);
                    if (matcher.find()) {
                        substring = matcher.group(2);
                    } else {
                        int indexOf = decode.indexOf("topic_id=");
                        if (indexOf < 0 || (i = indexOf + 9) > decode.length()) {
                            return;
                        }
                        substring = decode.substring(i);
                    }
                    if (!StringUtils.isNull(substring)) {
                        this.e = ng.g(substring, -1L);
                    }
                }
            } else {
                this.e = intent.getLongExtra("topic_id", -1L);
            }
            if (this.e < 0) {
                finish();
            } else if (!ni.A()) {
                this.b.r();
                this.b.B(true);
            } else {
                this.b.s();
                this.b.A(false);
                TopicDetailView topicDetailView = this.b;
                if (topicDetailView != null && topicDetailView.getEditor() != null) {
                    this.b.getEditor().I(this.e);
                }
                this.a.F(this.e);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.v85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "a024" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            TopicDetailView topicDetailView = this.b;
            if (topicDetailView == null || topicDetailView.getEditor() == null) {
                return;
            }
            this.b.getEditor().v(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            this.b.x();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            this.a = new TopicDetailModel(getPageContext());
            TopicDetailView topicDetailView = new TopicDetailView(getPageContext(), this, bundle);
            this.b = topicDetailView;
            setContentView(topicDetailView);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.a.H(this);
            a();
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !z8.g().i("MainTabActivity")) {
                this.f = true;
            }
            if (this.f) {
                setIsAddSwipeBackLayout(false);
            }
            this.b.getEditor().m();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
            TopicDetailView topicDetailView = this.b;
            if (topicDetailView == null || topicDetailView.getEditor() == null) {
                return;
            }
            this.b.getEditor().y();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            TiebaStatic.log(new StatisticItem("c13350").param("topic_id", this.e));
        }
    }

    @Override // com.repackage.c17
    public void u(int i, g17 g17Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, g17Var) == null) {
            this.b.r();
            if (i == 0 && g17Var != null && !ListUtils.isEmpty(g17Var.f)) {
                this.b.s();
                this.b.setData(g17Var);
                return;
            }
            this.b.B(true);
        }
    }
}
