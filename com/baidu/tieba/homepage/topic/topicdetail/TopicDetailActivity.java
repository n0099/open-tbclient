package com.baidu.tieba.homepage.topic.topicdetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
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
/* loaded from: classes22.dex */
public class TopicDetailActivity extends BaseActivity<TopicDetailActivity> implements a {
    private long eGV;
    private TopicDetailModel jXw;
    private TopicDetailView jXx;
    private long jcl;
    private long jXy = 1;
    private boolean mIsFromSchema = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jXw = new TopicDetailModel(getPageContext());
        this.jXx = new TopicDetailView(getPageContext(), this, bundle);
        setContentView(this.jXx);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.jXw.a(this);
        loadData();
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.lg().bt("MainTabActivity")) {
            this.mIsFromSchema = true;
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        this.jXx.getEditor().cGs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new ar("c13350").w("topic_id", this.eGV));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.jXx != null && this.jXx.getEditor() != null) {
            this.jXx.getEditor().bDs();
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
        this.eGV = -1L;
        if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            if (f.p(uri)) {
                f.biX().e(uri, new f.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity.1
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void onCallBack(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(f.exi) instanceof String)) {
                            String str = (String) hashMap.get(f.exi);
                            if (!StringUtils.isNull(str)) {
                                TopicDetailActivity.this.eGV = b.toLong(str, -1L);
                            }
                        }
                    }
                });
            } else if (!StringUtils.isNull(uri2) && uri2.startsWith("tbtopicdetail://")) {
                String decode = Uri.decode(uri.getEncodedPath());
                if (!StringUtils.isNull(decode)) {
                    LH(decode);
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
                        this.eGV = b.toLong(substring, -1L);
                    }
                } else {
                    return;
                }
            }
        } else {
            this.eGV = intent.getLongExtra("topic_id", -1L);
        }
        if (this.eGV < 0) {
            finish();
        } else if (!j.isNetworkAvailableForImmediately()) {
            this.jXx.hideLoadingView();
            this.jXx.px(true);
        } else {
            this.jXx.Yb();
            this.jXx.ib(false);
            if (this.jXx != null && this.jXx.getEditor() != null) {
                this.jXx.getEditor().setTopicId(this.eGV);
            }
            this.jXw.gD(this.eGV);
        }
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        this.jXx.hideLoadingView();
        if (i != 0 || aVar == null || y.isEmpty(aVar.mDataList)) {
            this.jXx.px(true);
            return;
        }
        this.jXx.Yb();
        this.jXx.setData(aVar);
    }

    public void gC(long j) {
        this.jXy++;
        this.jcl = j;
        this.jXw.f(this.eGV, this.jXy, this.jcl);
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, boolean z, List<q> list) {
        this.jXx.setNextData(i, z, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jXx.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.jXx != null && this.jXx.getEditor() != null) {
            this.jXx.getEditor().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a024";
    }

    private void LH(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> paramPair = bf.getParamPair(str);
        if (paramPair != null) {
            ar arVar = new ar("c10320");
            arVar.dY("obj_locate", paramPair.get("obj_locate"));
            arVar.al("obj_type", 1);
            arVar.dY("tid", paramPair.get("tid"));
            arVar.dY("obj_source", paramPair.get("obj_source"));
            arVar.dY(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
            arVar.al(TiebaInitialize.Params.OBJ_TO, 3);
            arVar.dY("obj_id", paramPair.get("bdid"));
            if (!au.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                try {
                    JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        arVar.dY(next, jSONObject.getString(next));
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(arVar);
        }
    }
}
