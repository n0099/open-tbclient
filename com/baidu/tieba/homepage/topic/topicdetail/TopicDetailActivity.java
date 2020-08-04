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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes16.dex */
public class TopicDetailActivity extends BaseActivity<TopicDetailActivity> implements a {
    private long dPD;
    private long hNZ;
    private TopicDetailModel iEa;
    private TopicDetailView iEb;
    private long iEc = 1;
    private boolean mIsFromSchema = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iEa = new TopicDetailModel(getPageContext());
        this.iEb = new TopicDetailView(getPageContext(), this, bundle);
        setContentView(this.iEb);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.iEa.a(this);
        loadData();
        if (getIntent() != null && getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.jC().bj("MainTabActivity")) {
            this.mIsFromSchema = true;
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        this.iEb.getEditor().cfw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new ap("c13350").t("topic_id", this.dPD));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.iEb != null && this.iEb.getEditor() != null) {
            this.iEb.getEditor().bjJ();
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
        this.dPD = -1L;
        if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null) {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            if (f.p(uri)) {
                f.aQv().f(uri, new f.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity.1
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void B(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(f.dGe) instanceof String)) {
                            String str = (String) hashMap.get(f.dGe);
                            if (!StringUtils.isNull(str)) {
                                TopicDetailActivity.this.dPD = b.toLong(str, -1L);
                            }
                        }
                    }
                });
            } else if (!StringUtils.isNull(uri2) && uri2.startsWith("tbtopicdetail://")) {
                String decode = Uri.decode(uri.getEncodedPath());
                if (!StringUtils.isNull(decode)) {
                    Gv(decode);
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
                        this.dPD = b.toLong(substring, -1L);
                    }
                } else {
                    return;
                }
            }
        } else {
            this.dPD = intent.getLongExtra("topic_id", -1L);
        }
        if (this.dPD < 0) {
            finish();
        } else if (!j.isNetworkAvailableForImmediately()) {
            this.iEb.hideLoadingView();
            this.iEb.ng(true);
        } else {
            this.iEb.bwX();
            this.iEb.gw(false);
            if (this.iEb != null && this.iEb.getEditor() != null) {
                this.iEb.getEditor().setTopicId(this.dPD);
            }
            this.iEa.eG(this.dPD);
        }
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        this.iEb.hideLoadingView();
        if (i != 0 || aVar == null || x.isEmpty(aVar.mDataList)) {
            this.iEb.ng(true);
            return;
        }
        this.iEb.bwX();
        this.iEb.setData(aVar);
    }

    public void eF(long j) {
        this.iEc++;
        this.hNZ = j;
        this.iEa.f(this.dPD, this.iEc, this.hNZ);
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, boolean z, List<q> list) {
        this.iEb.setNextData(i, z, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iEb.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.iEb != null && this.iEb.getEditor() != null) {
            this.iEb.getEditor().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a024";
    }

    private void Gv(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> paramPair = bd.getParamPair(str);
        if (paramPair != null) {
            ap apVar = new ap("c10320");
            apVar.dn("obj_locate", paramPair.get("obj_locate"));
            apVar.ah("obj_type", 1);
            apVar.dn("tid", paramPair.get("tid"));
            apVar.dn("obj_source", paramPair.get("obj_source"));
            apVar.dn(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
            apVar.ah(TiebaInitialize.Params.OBJ_TO, 3);
            apVar.dn("obj_id", paramPair.get("bdid"));
            if (!as.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                try {
                    JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        apVar.dn(next, jSONObject.getString(next));
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(apVar);
        }
    }
}
