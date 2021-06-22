package com.baidu.tieba.homepage.topic.topicdetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
import d.a.c.e.m.b;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.k.e.n;
import d.a.n0.a.g;
import d.a.n0.a.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TopicDetailActivity extends BaseActivity<TopicDetailActivity> implements d.a.o0.b1.k.a.a {
    public static final String SCHEME_TOPIC_DETAIL = "tbtopicdetail://";
    public static final String TOPIC_ID_PREFFIX = "topic_id=";
    public long mCurPageNum = 1;
    public boolean mIsFromSchema = false;
    public long mLastThreadId;
    public TopicDetailModel mTopicDetailModel;
    public TopicDetailView mTopicDetailView;
    public long topicID;

    /* loaded from: classes4.dex */
    public class a implements g.b {
        public a() {
        }

        @Override // d.a.n0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            if (hashMap != null && (hashMap.get(g.u) instanceof String)) {
                String str = (String) hashMap.get(g.u);
                if (StringUtils.isNull(str)) {
                    return;
                }
                TopicDetailActivity.this.topicID = b.f(str, -1L);
            }
        }
    }

    private void logBySchemeCall(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> paramPair = UrlManager.getParamPair(str);
        if (paramPair != null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE);
            x.b(statisticItem, paramPair);
            statisticItem.param("obj_locate", paramPair.get("obj_locate"));
            statisticItem.param("obj_type", 1);
            statisticItem.param("tid", paramPair.get("tid"));
            statisticItem.param("obj_source", paramPair.get("obj_source"));
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, paramPair.get(TiebaStatic.Params.OBJ_PARAM2));
            statisticItem.param(TiebaStatic.Params.OBJ_TO, 3);
            statisticItem.param("obj_id", paramPair.get("bdid"));
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

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.mIsFromSchema) {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.n0.k0.a
    public String getCurrentPageKey() {
        return "a024";
    }

    @Override // d.a.o0.b1.k.a.a
    public void loadData() {
        int i2;
        String substring;
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
                g.b().g(uri, new a());
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
                    this.topicID = b.f(substring, -1L);
                }
            }
        } else {
            this.topicID = intent.getLongExtra("topic_id", -1L);
        }
        if (this.topicID < 0) {
            finish();
        } else if (!j.A()) {
            this.mTopicDetailView.r();
            this.mTopicDetailView.B(true);
        } else {
            this.mTopicDetailView.s();
            this.mTopicDetailView.A(false);
            TopicDetailView topicDetailView = this.mTopicDetailView;
            if (topicDetailView != null && topicDetailView.getEditor() != null) {
                this.mTopicDetailView.getEditor().J(this.topicID);
            }
            this.mTopicDetailModel.B(this.topicID);
        }
    }

    @Override // d.a.o0.b1.k.a.a
    public void netCallback(int i2, d.a.o0.b1.k.a.c.a aVar) {
        this.mTopicDetailView.r();
        if (i2 == 0 && aVar != null && !ListUtils.isEmpty(aVar.f55750f)) {
            this.mTopicDetailView.s();
            this.mTopicDetailView.setData(aVar);
            return;
        }
        this.mTopicDetailView.B(true);
    }

    @Override // d.a.o0.b1.k.a.a
    public void netThreadCallback(int i2, boolean z, List<n> list) {
        this.mTopicDetailView.setNextData(i2, z, list);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        TopicDetailView topicDetailView = this.mTopicDetailView;
        if (topicDetailView == null || topicDetailView.getEditor() == null) {
            return;
        }
        this.mTopicDetailView.getEditor().w(i2, i3, intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mTopicDetailView.x();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mTopicDetailModel = new TopicDetailModel(getPageContext());
        TopicDetailView topicDetailView = new TopicDetailView(getPageContext(), this, bundle);
        this.mTopicDetailView = topicDetailView;
        setContentView(topicDetailView);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mTopicDetailModel.D(this);
        loadData();
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !d.a.c.a.b.f().h("MainTabActivity")) {
            this.mIsFromSchema = true;
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        this.mTopicDetailView.getEditor().n();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        TopicDetailView topicDetailView = this.mTopicDetailView;
        if (topicDetailView == null || topicDetailView.getEditor() == null) {
            return;
        }
        this.mTopicDetailView.getEditor().z();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new StatisticItem("c13350").param("topic_id", this.topicID));
    }

    public void requestNextPageThreadData(long j) {
        long j2 = this.mCurPageNum + 1;
        this.mCurPageNum = j2;
        this.mLastThreadId = j;
        this.mTopicDetailModel.C(this.topicID, j2, j);
    }
}
