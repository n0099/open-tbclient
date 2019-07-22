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
    private long bHK;
    private long fBx;
    private TopicDetailModel glt;
    private TopicDetailView glu;
    private long glv = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.glt = new TopicDetailModel(getPageContext());
        this.glu = new TopicDetailView(getPageContext(), this, bundle);
        setContentView(this.glu);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.glt.a(this);
        loadData();
        this.glu.getEditor().bxr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new an("c13350").l("topic_id", this.bHK));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.glu != null && this.glu.getEditor() != null) {
            this.glu.getEditor().asS();
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
        this.bHK = longExtra;
        if (!j.jQ()) {
            this.glu.hideLoadingView();
            this.glu.ju(true);
            return;
        }
        this.glu.aJh();
        this.glu.cY(false);
        if (this.glu != null && this.glu.getEditor() != null) {
            this.glu.getEditor().setTopicId(longExtra);
        }
        this.glt.ds(longExtra);
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        this.glu.hideLoadingView();
        if (i != 0 || aVar == null || v.aa(aVar.mDataList)) {
            this.glu.ju(true);
            return;
        }
        this.glu.aJh();
        this.glu.setData(aVar);
    }

    public void dr(long j) {
        this.glv++;
        this.fBx = j;
        this.glt.d(this.bHK, this.glv, this.fBx);
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, boolean z, List<m> list) {
        this.glu.setNextData(i, z, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.glu.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.glu != null && this.glu.getEditor() != null) {
            this.glu.getEditor().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a024";
    }
}
