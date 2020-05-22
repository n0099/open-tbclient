package com.baidu.tieba.homepage.topic.topicdetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.homepage.topic.topicdetail.model.TopicDetailModel;
import com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class TopicDetailActivity extends BaseActivity<TopicDetailActivity> implements a {
    private long dCX;
    private long huU;
    private TopicDetailModel igc;
    private TopicDetailView igd;
    private long ige = 1;
    private boolean mIsFromSchema = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.igc = new TopicDetailModel(getPageContext());
        this.igd = new TopicDetailView(getPageContext(), this, bundle);
        setContentView(this.igd);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.igc.a(this);
        loadData();
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.jm().bi("MainTabActivity")) {
            this.mIsFromSchema = true;
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        this.igd.getEditor().cgM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new an("c13350").s("topic_id", this.dCX));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.igd != null && this.igd.getEditor() != null) {
            this.igd.getEditor().bdS();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        if (this.mIsFromSchema) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void loadData() {
        int length;
        String substring;
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.dCX = -1L;
        if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            if (f.p(uri)) {
                f.aLw().f(uri, new f.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity.1
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void C(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(f.dvy) instanceof String)) {
                            String str = (String) hashMap.get(f.dvy);
                            if (!StringUtils.isNull(str)) {
                                TopicDetailActivity.this.dCX = b.toLong(str, -1L);
                            }
                        }
                    }
                });
            } else if (!StringUtils.isNull(uri2) && uri2.startsWith("tbtopicdetail://")) {
                String decode = Uri.decode(uri.getEncodedPath());
                if (!StringUtils.isNull(decode)) {
                    Fi(decode);
                    Matcher matcher = Pattern.compile(".*fr=(.*)&topic_id=([\\d]+).*").matcher(decode);
                    if (matcher.find()) {
                        substring = matcher.group(2);
                    } else {
                        int indexOf = decode.indexOf("topic_id=");
                        if (indexOf >= 0 && (length = indexOf + "topic_id=".length()) <= decode.length()) {
                            substring = decode.substring(length);
                        } else {
                            return;
                        }
                    }
                    if (!StringUtils.isNull(substring)) {
                        this.dCX = b.toLong(substring, -1L);
                    }
                } else {
                    return;
                }
            }
        } else {
            this.dCX = intent.getLongExtra("topic_id", -1L);
        }
        if (this.dCX < 0) {
            finish();
        } else if (!j.isNetworkAvailableForImmediately()) {
            this.igd.hideLoadingView();
            this.igd.mq(true);
        } else {
            this.igd.bqO();
            this.igd.fV(false);
            if (this.igd != null && this.igd.getEditor() != null) {
                this.igd.getEditor().setTopicId(this.dCX);
            }
            this.igc.eq(this.dCX);
        }
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        this.igd.hideLoadingView();
        if (i != 0 || aVar == null || v.isEmpty(aVar.mDataList)) {
            this.igd.mq(true);
            return;
        }
        this.igd.bqO();
        this.igd.setData(aVar);
    }

    public void ep(long j) {
        this.ige++;
        this.huU = j;
        this.igc.c(this.dCX, this.ige, this.huU);
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, boolean z, List<o> list) {
        this.igd.setNextData(i, z, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.igd.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.igd != null && this.igd.getEditor() != null) {
            this.igd.getEditor().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a024";
    }

    private void Fi(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> paramPair = ba.getParamPair(str);
        if (paramPair != null) {
            an anVar = new an("c10320");
            anVar.dh("obj_locate", paramPair.get("obj_locate"));
            anVar.ag("obj_type", 1);
            anVar.dh("tid", paramPair.get("tid"));
            anVar.dh("obj_source", paramPair.get("obj_source"));
            anVar.dh(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
            anVar.ag(TiebaInitialize.Params.OBJ_TO, 3);
            anVar.dh("obj_id", paramPair.get("bdid"));
            if (!aq.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                try {
                    JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        anVar.dh(next, jSONObject.getString(next));
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(anVar);
        }
    }
}
