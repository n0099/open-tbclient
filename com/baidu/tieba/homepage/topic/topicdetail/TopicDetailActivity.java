package com.baidu.tieba.homepage.topic.topicdetail;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.homepage.topic.topicdetail.model.TopicDetailModel;
import com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView;
import java.util.List;
/* loaded from: classes4.dex */
public class TopicDetailActivity extends BaseActivity<TopicDetailActivity> implements a {
    private long bGJ;
    private long fwA;
    private TopicDetailModel gfc;
    private TopicDetailView gfd;
    private long gfe = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gfc = new TopicDetailModel(getPageContext());
        this.gfd = new TopicDetailView(getPageContext(), this, bundle);
        setContentView(this.gfd);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gfc.a(this);
        loadData();
        this.gfd.getEditor().buJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TiebaStatic.log(new am("c13350").l("topic_id", this.bGJ));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.gfd != null && this.gfd.getEditor() != null) {
            this.gfd.getEditor().arM();
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
        this.bGJ = longExtra;
        if (!j.jG()) {
            this.gfd.hideLoadingView();
            this.gfd.jk(true);
            return;
        }
        this.gfd.aHH();
        this.gfd.cV(false);
        if (this.gfd != null && this.gfd.getEditor() != null) {
            this.gfd.getEditor().setTopicId(longExtra);
        }
        this.gfc.dl(longExtra);
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        this.gfd.hideLoadingView();
        if (i != 0 || aVar == null || v.aa(aVar.mDataList)) {
            this.gfd.jk(true);
            return;
        }
        this.gfd.aHH();
        this.gfd.setData(aVar);
    }

    public void dk(long j) {
        this.gfe++;
        this.fwA = j;
        this.gfc.d(this.bGJ, this.gfe, this.fwA);
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, boolean z, List<m> list) {
        this.gfd.setNextData(i, z, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gfd.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gfd != null && this.gfd.getEditor() != null) {
            this.gfd.getEditor().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a024";
    }
}
