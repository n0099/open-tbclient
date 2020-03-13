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
    private long cPB;
    private long gwh;
    private TopicDetailModel hgc;
    private TopicDetailView hgd;
    private long hge = 1;
    private boolean mIsFromSchema = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hgc = new TopicDetailModel(getPageContext());
        this.hgd = new TopicDetailView(getPageContext(), this, bundle);
        setContentView(this.hgd);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hgc.a(this);
        loadData();
        if (getIntent() != null && getIntent().getParcelableExtra("key_uri") != null && !com.baidu.adp.base.a.eH().T("MainTabActivity")) {
            this.mIsFromSchema = true;
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        this.hgd.getEditor().bPw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new an("c13350").s("topic_id", this.cPB));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hgd != null && this.hgd.getEditor() != null) {
            this.hgd.getEditor().aPq();
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
        this.cPB = -1L;
        if (intent.getParcelableExtra("key_uri") != null) {
            Uri uri = (Uri) intent.getParcelableExtra("key_uri");
            String uri2 = uri.toString();
            if (f.n(uri)) {
                f.axP().f(uri, new f.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity.1
                    @Override // com.baidu.tbadk.BdToken.f.a
                    public void n(HashMap<String, Object> hashMap) {
                        if (hashMap != null && (hashMap.get(f.cIq) instanceof String)) {
                            String str = (String) hashMap.get(f.cIq);
                            if (!StringUtils.isNull(str)) {
                                TopicDetailActivity.this.cPB = b.toLong(str, -1L);
                            }
                        }
                    }
                });
            } else if (!StringUtils.isNull(uri2) && uri2.startsWith("tbtopicdetail://")) {
                String decode = Uri.decode(uri.getEncodedPath());
                if (!StringUtils.isNull(decode)) {
                    BO(decode);
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
                        this.cPB = b.toLong(substring, -1L);
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
                    anVar.cy("obj_locate", queryParameter2);
                    anVar.cy("obj_type", queryParameter3);
                    anVar.cy("obj_param1", queryParameter4);
                    anVar.cy(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                    anVar.cy("fname", queryParameter6);
                    anVar.cy("obj_source", queryParameter);
                    TiebaStatic.log(anVar);
                }
            }
        } else {
            this.cPB = intent.getLongExtra("topic_id", -1L);
        }
        if (this.cPB < 0) {
            finish();
        } else if (!j.isNetworkAvailableForImmediately()) {
            this.hgd.hideLoadingView();
            this.hgd.kN(true);
        } else {
            this.hgd.bcy();
            this.hgd.eM(false);
            if (this.hgd != null && this.hgd.getEditor() != null) {
                this.hgd.getEditor().setTopicId(this.cPB);
            }
            this.hgc.dF(this.cPB);
        }
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        this.hgd.hideLoadingView();
        if (i != 0 || aVar == null || v.isEmpty(aVar.mDataList)) {
            this.hgd.kN(true);
            return;
        }
        this.hgd.bcy();
        this.hgd.setData(aVar);
    }

    public void dE(long j) {
        this.hge++;
        this.gwh = j;
        this.hgc.c(this.cPB, this.hge, this.gwh);
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, boolean z, List<m> list) {
        this.hgd.setNextData(i, z, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hgd.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hgd != null && this.hgd.getEditor() != null) {
            this.hgd.getEditor().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a024";
    }

    private void BO(String str) {
        if (str.startsWith("//")) {
            str = str.substring(2);
        }
        Map<String, String> paramPair = ba.getParamPair(str);
        if (paramPair != null) {
            an anVar = new an("c10320");
            anVar.cy("obj_locate", paramPair.get("obj_locate"));
            anVar.X("obj_type", 1);
            anVar.cy("tid", paramPair.get("tid"));
            anVar.cy("obj_source", paramPair.get("obj_source"));
            anVar.cy(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2));
            anVar.X(TiebaInitialize.Params.OBJ_TO, 3);
            anVar.cy("obj_id", paramPair.get("bdid"));
            if (!aq.isEmpty(paramPair.get(LogConfig.LOG_EXT_LOG))) {
                try {
                    JSONObject jSONObject = new JSONObject(paramPair.get(LogConfig.LOG_EXT_LOG));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        anVar.cy(next, jSONObject.getString(next));
                    }
                } catch (JSONException e) {
                    BdLog.e(e.getMessage());
                }
            }
            TiebaStatic.log(anVar);
        }
    }
}
