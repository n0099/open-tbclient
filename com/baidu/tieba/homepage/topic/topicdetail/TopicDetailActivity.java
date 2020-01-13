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
/* loaded from: classes7.dex */
public class TopicDetailActivity extends BaseActivity<TopicDetailActivity> implements a {
    private long cLw;
    private long gtS;
    private TopicDetailModel hdO;
    private TopicDetailView hdP;
    private long hdQ = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hdO = new TopicDetailModel(getPageContext());
        this.hdP = new TopicDetailView(getPageContext(), this, bundle);
        setContentView(this.hdP);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hdO.a(this);
        loadData();
        this.hdP.getEditor().bNR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new an("c13350").s("topic_id", this.cLw));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.hdP != null && this.hdP.getEditor() != null) {
            this.hdP.getEditor().aMR();
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
        this.cLw = longExtra;
        if (!j.isNetworkAvailableForImmediately()) {
            this.hdP.hideLoadingView();
            this.hdP.kJ(true);
            return;
        }
        this.hdP.baf();
        this.hdP.eF(false);
        if (this.hdP != null && this.hdP.getEditor() != null) {
            this.hdP.getEditor().setTopicId(longExtra);
        }
        this.hdO.dF(longExtra);
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        this.hdP.hideLoadingView();
        if (i != 0 || aVar == null || v.isEmpty(aVar.mDataList)) {
            this.hdP.kJ(true);
            return;
        }
        this.hdP.baf();
        this.hdP.setData(aVar);
    }

    public void dE(long j) {
        this.hdQ++;
        this.gtS = j;
        this.hdO.c(this.cLw, this.hdQ, this.gtS);
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, boolean z, List<m> list) {
        this.hdP.setNextData(i, z, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hdP.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hdP != null && this.hdP.getEditor() != null) {
            this.hdP.getEditor().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a024";
    }
}
