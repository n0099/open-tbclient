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
    private long fwB;
    private TopicDetailModel gfd;
    private TopicDetailView gfe;
    private long gff = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gfd = new TopicDetailModel(getPageContext());
        this.gfe = new TopicDetailView(getPageContext(), this, bundle);
        setContentView(this.gfe);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.gfd.a(this);
        loadData();
        this.gfe.getEditor().buM();
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
        if (this.gfe != null && this.gfe.getEditor() != null) {
            this.gfe.getEditor().arM();
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
            this.gfe.hideLoadingView();
            this.gfe.jk(true);
            return;
        }
        this.gfe.aHK();
        this.gfe.cV(false);
        if (this.gfe != null && this.gfe.getEditor() != null) {
            this.gfe.getEditor().setTopicId(longExtra);
        }
        this.gfd.dl(longExtra);
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, com.baidu.tieba.homepage.topic.topicdetail.b.a aVar) {
        this.gfe.hideLoadingView();
        if (i != 0 || aVar == null || v.aa(aVar.mDataList)) {
            this.gfe.jk(true);
            return;
        }
        this.gfe.aHK();
        this.gfe.setData(aVar);
    }

    public void dk(long j) {
        this.gff++;
        this.fwB = j;
        this.gfd.d(this.bGJ, this.gff, this.fwB);
    }

    @Override // com.baidu.tieba.homepage.topic.topicdetail.a
    public void a(int i, boolean z, List<m> list) {
        this.gfe.setNextData(i, z, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gfe.onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gfe != null && this.gfe.getEditor() != null) {
            this.gfe.getEditor().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a024";
    }
}
