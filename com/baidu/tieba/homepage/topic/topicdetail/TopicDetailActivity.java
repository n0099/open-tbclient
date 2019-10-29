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
    private long bZT;
    private long fDp;
    private TopicDetailModel gnB;
    private TopicDetailView gnC;
    private long gnD = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gnB = new TopicDetailModel(getPageContext());
        this.gnC = new TopicDetailView(getPageContext(), this, bundle);
        setContentView(this.gnC);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gnB.a(this);
        loadData();
        this.gnC.getEditor().bvx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new an("c13350").p("topic_id", this.bZT));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gnC != null && this.gnC.getEditor() != null) {
            this.gnC.getEditor().auS();
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
        this.bZT = longExtra;
        if (!j.isNetworkAvailableForImmediately()) {
            this.gnC.hideLoadingView();
            this.gnC.jm(true);
            return;
        }
        this.gnC.aJo();
        this.gnC.dp(false);
        if (this.gnC != null && this.gnC.getEditor() != null) {
            this.gnC.getEditor().setTopicId(longExtra);
        }
        this.gnB.cV(longExtra);
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        this.gnC.hideLoadingView();
        if (i != 0 || aVar == null || v.isEmpty(aVar.mDataList)) {
            this.gnC.jm(true);
            return;
        }
        this.gnC.aJo();
        this.gnC.setData(aVar);
    }

    public void cU(long j) {
        this.gnD++;
        this.fDp = j;
        this.gnB.c(this.bZT, this.gnD, this.fDp);
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, boolean z, List<m> list) {
        this.gnC.setNextData(i, z, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gnC.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gnC != null && this.gnC.getEditor() != null) {
            this.gnC.getEditor().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a024";
    }
}
