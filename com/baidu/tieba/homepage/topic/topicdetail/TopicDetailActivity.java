package com.baidu.tieba.homepage.topic.topicdetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
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
    private long cPO;
    private long gwQ;
    private TopicDetailModel hhC;
    private TopicDetailView hhD;
    private long hhE = 1;
    private boolean mIsFromSchema = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hhC = new TopicDetailModel(getPageContext());
        this.hhD = new TopicDetailView(getPageContext(), this, bundle);
        setContentView(this.hhD);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hhC.a(this);
        loadData();
        if (getIntent() != null && getIntent().getParcelableExtra("key_uri") != null && !com.baidu.adp.base.a.eH().T("MainTabActivity")) {
            this.mIsFromSchema = true;
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        this.hhD.getEditor().bPO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new an("c13350").s("topic_id", this.cPO));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hhD != null && this.hhD.getEditor() != null) {
            this.hhD.getEditor().aPu();
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
        this.cPO = -1L;
        if (intent.getParcelableExtra("key_uri") != null) {
            Uri uri = (Uri) intent.getParcelableExtra("key_uri");
            String uri2 = uri.toString();
            if (f.n(uri)) {
                f.axS().f(uri, new f.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity.1
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void n(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(f.cIB) instanceof String)) {
                            String str = (String) hashMap.get(f.cIB);
                            if (!StringUtils.isNull(str)) {
                                TopicDetailActivity.this.cPO = b.toLong(str, -1L);
                            }
                        }
                    }
                });
            } else if (!StringUtils.isNull(uri2) && uri2.startsWith("tbtopicdetail://")) {
                String decode = Uri.decode(uri.getEncodedPath());
                if (!StringUtils.isNull(decode)) {
                    BN(decode);
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
                        this.cPO = b.toLong(substring, -1L);
                    }
                } else {
                    return;
                }
            }
            if (uri != null) {
                String queryParameter = uri.getQueryParameter("obj_source");
                if ("shoubai".equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                    String queryParameter2 = uri.getQueryParameter("obj_locate");
                    String queryParameter3 = uri.getQueryParameter("obj_type");
                    String queryParameter4 = uri.getQueryParameter("obj_param1");
                    String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                    String queryParameter6 = uri.getQueryParameter("kw");
                    an anVar = new an("c13561");
                    anVar.cx("obj_locate", queryParameter2);
                    anVar.cx("obj_type", queryParameter3);
                    anVar.cx("obj_param1", queryParameter4);
                    anVar.cx(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                    anVar.cx("fname", queryParameter6);
                    anVar.cx("obj_source", queryParameter);
                    TiebaStatic.log(anVar);
                }
            }
        } else {
            this.cPO = intent.getLongExtra("topic_id", -1L);
        }
        if (this.cPO < 0) {
            finish();
        } else if (!j.isNetworkAvailableForImmediately()) {
            this.hhD.hideLoadingView();
            this.hhD.kS(true);
        } else {
            this.hhD.bcC();
            this.hhD.eN(false);
            if (this.hhD != null && this.hhD.getEditor() != null) {
                this.hhD.getEditor().setTopicId(this.cPO);
            }
            this.hhC.dG(this.cPO);
        }
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        this.hhD.hideLoadingView();
        if (i != 0 || aVar == null || v.isEmpty(aVar.mDataList)) {
            this.hhD.kS(true);
            return;
        }
        this.hhD.bcC();
        this.hhD.setData(aVar);
    }

    public void dF(long j) {
        this.hhE++;
        this.gwQ = j;
        this.hhC.c(this.cPO, this.hhE, this.gwQ);
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, boolean z, List<m> list) {
        this.hhD.setNextData(i, z, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hhD.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hhD != null && this.hhD.getEditor() != null) {
            this.hhD.getEditor().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a024";
    }

    private void BN(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> paramPair = ba.getParamPair(str);
        if (paramPair != null) {
            an anVar = new an("c10320");
            anVar.cx("obj_locate", paramPair.get("obj_locate"));
            anVar.X("obj_type", 1);
            anVar.cx("tid", paramPair.get("tid"));
            anVar.cx("obj_source", paramPair.get("obj_source"));
            anVar.cx(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
            anVar.X(TiebaInitialize.Params.OBJ_TO, 3);
            anVar.cx("obj_id", paramPair.get("bdid"));
            if (!aq.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                try {
                    JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        anVar.cx(next, jSONObject.getString(next));
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(anVar);
        }
    }
}
