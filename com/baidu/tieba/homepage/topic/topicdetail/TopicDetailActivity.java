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
    private long bHL;
    private long fCl;
    private TopicDetailModel gml;
    private TopicDetailView gmm;
    private long gmn = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gml = new TopicDetailModel(getPageContext());
        this.gmm = new TopicDetailView(getPageContext(), this, bundle);
        setContentView(this.gmm);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gml.a(this);
        loadData();
        this.gmm.getEditor().bxF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new an("c13350").l("topic_id", this.bHL));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gmm != null && this.gmm.getEditor() != null) {
            this.gmm.getEditor().asU();
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
        this.bHL = longExtra;
        if (!j.jQ()) {
            this.gmm.hideLoadingView();
            this.gmm.ju(true);
            return;
        }
        this.gmm.aJj();
        this.gmm.cY(false);
        if (this.gmm != null && this.gmm.getEditor() != null) {
            this.gmm.getEditor().setTopicId(longExtra);
        }
        this.gml.ds(longExtra);
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        this.gmm.hideLoadingView();
        if (i != 0 || aVar == null || v.aa(aVar.mDataList)) {
            this.gmm.ju(true);
            return;
        }
        this.gmm.aJj();
        this.gmm.setData(aVar);
    }

    public void dr(long j) {
        this.gmn++;
        this.fCl = j;
        this.gml.d(this.bHL, this.gmn, this.fCl);
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, boolean z, List<m> list) {
        this.gmm.setNextData(i, z, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gmm.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gmm != null && this.gmm.getEditor() != null) {
            this.gmm.getEditor().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a024";
    }
}
