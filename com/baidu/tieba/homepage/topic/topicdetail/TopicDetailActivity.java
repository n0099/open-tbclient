package com.baidu.tieba.homepage.topic.topicdetail;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.homepage.topic.topicdetail.model.TopicDetailModel;
import com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView;
import java.util.List;
/* loaded from: classes4.dex */
public class TopicDetailActivity extends BaseActivity<TopicDetailActivity> implements a {
    private long bZc;
    private long fCy;
    private TopicDetailModel gmK;
    private TopicDetailView gmL;
    private long gmM = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gmK = new TopicDetailModel(getPageContext());
        this.gmL = new TopicDetailView(getPageContext(), this, bundle);
        setContentView(this.gmL);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gmK.a(this);
        loadData();
        this.gmL.getEditor().bvv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new an("c13350").p("topic_id", this.bZc));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gmL != null && this.gmL.getEditor() != null) {
            this.gmL.getEditor().auQ();
        }
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void loadData() {
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        long longExtra = intent.getLongExtra("topic_id", -1L);
        if (longExtra < 0) {
            finish();
            return;
        }
        this.bZc = longExtra;
        if (!j.isNetworkAvailableForImmediately()) {
            this.gmL.hideLoadingView();
            this.gmL.jm(true);
            return;
        }
        this.gmL.aJm();
        this.gmL.dp(false);
        if (this.gmL != null && this.gmL.getEditor() != null) {
            this.gmL.getEditor().setTopicId(longExtra);
        }
        this.gmK.cU(longExtra);
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        this.gmL.hideLoadingView();
        if (i != 0 || aVar == null || v.isEmpty(aVar.mDataList)) {
            this.gmL.jm(true);
            return;
        }
        this.gmL.aJm();
        this.gmL.setData(aVar);
    }

    public void cT(long j) {
        this.gmM++;
        this.fCy = j;
        this.gmK.c(this.bZc, this.gmM, this.fCy);
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, boolean z, List<m> list) {
        this.gmL.setNextData(i, z, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gmL.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gmL != null && this.gmL.getEditor() != null) {
            this.gmL.getEditor().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a024";
    }
}
