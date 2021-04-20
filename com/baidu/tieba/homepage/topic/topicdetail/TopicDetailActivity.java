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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.homepage.topic.topicdetail.model.TopicDetailModel;
import com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView;
import d.b.c.e.m.b;
import d.b.c.e.p.j;
import d.b.c.e.p.k;
import d.b.c.j.e.n;
import d.b.h0.a.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TopicDetailActivity extends BaseActivity<TopicDetailActivity> implements d.b.i0.a1.j.a.a {
    public static final String SCHEME_TOPIC_DETAIL = "tbtopicdetail://";
    public static final String TOPIC_ID_PREFFIX = "topic_id=";
    public long mCurPageNum = 1;
    public boolean mIsFromSchema = false;
    public long mLastThreadId;
    public TopicDetailModel mTopicDetailModel;
    public TopicDetailView mTopicDetailView;
    public long topicID;

    /* loaded from: classes4.dex */
    public class a implements f.b {
        public a() {
        }

        @Override // d.b.h0.a.f.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            if (hashMap != null && (hashMap.get(f.u) instanceof String)) {
                String str = (String) hashMap.get(f.u);
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
            StatisticItem statisticItem = new StatisticItem("c10320");
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

    @Override // com.baidu.tbadk.BaseActivity, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a024";
    }

    @Override // d.b.i0.a1.j.a.a
    public void loadData() {
        int i;
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
            if (f.c(uri)) {
                f.b().g(uri, new a());
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
                    if (indexOf < 0 || (i = indexOf + 9) > decode.length()) {
                        return;
                    }
                    substring = decode.substring(i);
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
            this.mTopicDetailView.E(true);
        } else {
            this.mTopicDetailView.s();
            this.mTopicDetailView.B(false);
            TopicDetailView topicDetailView = this.mTopicDetailView;
            if (topicDetailView != null && topicDetailView.getEditor() != null) {
                this.mTopicDetailView.getEditor().J(this.topicID);
            }
            this.mTopicDetailModel.x(this.topicID);
        }
    }

    @Override // d.b.i0.a1.j.a.a
    public void netCallback(int i, d.b.i0.a1.j.a.c.a aVar) {
        this.mTopicDetailView.r();
        if (i == 0 && aVar != null && !ListUtils.isEmpty(aVar.f52928f)) {
            this.mTopicDetailView.s();
            this.mTopicDetailView.setData(aVar);
            return;
        }
        this.mTopicDetailView.E(true);
    }

    @Override // d.b.i0.a1.j.a.a
    public void netThreadCallback(int i, boolean z, List<n> list) {
        this.mTopicDetailView.setNextData(i, z, list);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        TopicDetailView topicDetailView = this.mTopicDetailView;
        if (topicDetailView == null || topicDetailView.getEditor() == null) {
            return;
        }
        this.mTopicDetailView.getEditor().w(i, i2, intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mTopicDetailView.y();
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
        this.mTopicDetailModel.z(this);
        loadData();
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !d.b.c.a.b.f().h("MainTabActivity")) {
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
        this.mTopicDetailModel.y(this.topicID, j2, j);
    }
}
