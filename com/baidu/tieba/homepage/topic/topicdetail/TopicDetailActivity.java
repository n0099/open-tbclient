package com.baidu.tieba.homepage.topic.topicdetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.m.b;
import b.a.e.e.p.j;
import b.a.e.e.p.k;
import b.a.e.l.e.n;
import b.a.q0.a.g;
import b.a.q0.a.w;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class TopicDetailActivity extends BaseActivity<TopicDetailActivity> implements b.a.r0.h1.k.a.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SCHEME_TOPIC_DETAIL = "tbtopicdetail://";
    public static final String TOPIC_ID_PREFFIX = "topic_id=";
    public transient /* synthetic */ FieldHolder $fh;
    public long mCurPageNum;
    public boolean mIsFromSchema;
    public long mLastThreadId;
    public TopicDetailModel mTopicDetailModel;
    public TopicDetailView mTopicDetailView;
    public long topicID;

    /* loaded from: classes9.dex */
    public class a implements g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopicDetailActivity f49822a;

        public a(TopicDetailActivity topicDetailActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetailActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49822a = topicDetailActivity;
        }

        @Override // b.a.q0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && hashMap != null && (hashMap.get(g.y) instanceof String)) {
                String str = (String) hashMap.get(g.y);
                if (StringUtils.isNull(str)) {
                    return;
                }
                this.f49822a.topicID = b.g(str, -1L);
            }
        }
    }

    public TopicDetailActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCurPageNum = 1L;
        this.mIsFromSchema = false;
    }

    private void logBySchemeCall(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            if (str.startsWith("//")) {
                str = str.substring(2);
            }
            Map<String, String> paramPair = UrlManager.getParamPair(str);
            if (paramPair != null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE);
                w.b(statisticItem, paramPair);
                statisticItem.param("obj_locate", paramPair.get("obj_locate"));
                statisticItem.param("obj_type", 1);
                statisticItem.param("tid", paramPair.get("tid"));
                statisticItem.param("obj_source", paramPair.get("obj_source"));
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, paramPair.get(TiebaStatic.Params.OBJ_PARAM2));
                statisticItem.param(TiebaStatic.Params.OBJ_TO, 3);
                statisticItem.param("obj_id", paramPair.get(TiebaStatic.Params.BDID));
                statisticItem.param("obj_name", TbadkCoreApplication.getInst().getStartType());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, 1);
                if (!k.isEmpty(paramPair.get("ext_log"))) {
                    try {
                        JSONObject jSONObject = new JSONObject(paramPair.get("ext_log"));
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            statisticItem.param(next, jSONObject.getString(next));
                        }
                    } catch (JSONException e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.mIsFromSchema) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.mIsFromSchema) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            super.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, b.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a024" : (String) invokeV.objValue;
    }

    @Override // b.a.r0.h1.k.a.a
    public void loadData() {
        int i2;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Intent intent = getIntent();
            if (intent == null) {
                finish();
                return;
            }
            this.topicID = -1L;
            if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
                Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
                String uri2 = uri.toString();
                if (g.c(uri)) {
                    g.b().g(uri, new a(this));
                } else if (!StringUtils.isNull(uri2) && uri2.startsWith("tbtopicdetail://")) {
                    String decode = Uri.decode(uri.getEncodedPath());
                    if (StringUtils.isNull(decode)) {
                        return;
                    }
                    logBySchemeCall(decode);
                    Matcher matcher = Pattern.compile(".*fr=(.*)&topic_id=([\\d]+).*").matcher(decode);
                    if (matcher.find()) {
                        substring = matcher.group(2);
                    } else {
                        int indexOf = decode.indexOf("topic_id=");
                        if (indexOf < 0 || (i2 = indexOf + 9) > decode.length()) {
                            return;
                        }
                        substring = decode.substring(i2);
                    }
                    if (!StringUtils.isNull(substring)) {
                        this.topicID = b.g(substring, -1L);
                    }
                }
            } else {
                this.topicID = intent.getLongExtra("topic_id", -1L);
            }
            if (this.topicID < 0) {
                finish();
            } else if (!j.A()) {
                this.mTopicDetailView.hideLoadingView();
                this.mTopicDetailView.showNetRefreshView(true);
            } else {
                this.mTopicDetailView.hideNetRefreshView();
                this.mTopicDetailView.showLoadingView(false);
                TopicDetailView topicDetailView = this.mTopicDetailView;
                if (topicDetailView != null && topicDetailView.getEditor() != null) {
                    this.mTopicDetailView.getEditor().I(this.topicID);
                }
                this.mTopicDetailModel.B(this.topicID);
            }
        }
    }

    @Override // b.a.r0.h1.k.a.a
    public void netCallback(int i2, b.a.r0.h1.k.a.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, aVar) == null) {
            this.mTopicDetailView.hideLoadingView();
            if (i2 == 0 && aVar != null && !ListUtils.isEmpty(aVar.f17586f)) {
                this.mTopicDetailView.hideNetRefreshView();
                this.mTopicDetailView.setData(aVar);
                return;
            }
            this.mTopicDetailView.showNetRefreshView(true);
        }
    }

    @Override // b.a.r0.h1.k.a.a
    public void netThreadCallback(int i2, boolean z, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), list}) == null) {
            this.mTopicDetailView.setNextData(i2, z, list);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            TopicDetailView topicDetailView = this.mTopicDetailView;
            if (topicDetailView == null || topicDetailView.getEditor() == null) {
                return;
            }
            this.mTopicDetailView.getEditor().v(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mTopicDetailView.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            this.mTopicDetailModel = new TopicDetailModel(getPageContext());
            TopicDetailView topicDetailView = new TopicDetailView(getPageContext(), this, bundle);
            this.mTopicDetailView = topicDetailView;
            setContentView(topicDetailView);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.mTopicDetailModel.D(this);
            loadData();
            if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !b.a.e.a.b.g().i("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
            if (this.mIsFromSchema) {
                setIsAddSwipeBackLayout(false);
            }
            this.mTopicDetailView.getEditor().m();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            TopicDetailView topicDetailView = this.mTopicDetailView;
            if (topicDetailView == null || topicDetailView.getEditor() == null) {
                return;
            }
            this.mTopicDetailView.getEditor().y();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            TiebaStatic.log(new StatisticItem("c13350").param("topic_id", this.topicID));
        }
    }

    public void requestNextPageThreadData(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            long j2 = this.mCurPageNum + 1;
            this.mCurPageNum = j2;
            this.mLastThreadId = j;
            this.mTopicDetailModel.C(this.topicID, j2, j);
        }
    }
}
