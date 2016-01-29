package com.baidu.tieba.hottopic.controller;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RelateTopicForumActivity extends BaseActivity<RelateTopicForumActivity> {
    public com.baidu.tieba.tbadkCore.w bKp;
    private com.baidu.tieba.hottopic.view.p bKx;
    private ArrayList<RelateForumItemData> Zg = new ArrayList<>();
    private CustomMessageListener aEM = new x(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener aEL = new y(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private com.baidu.adp.base.g aWL = new z(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.bKp = new com.baidu.tieba.tbadkCore.w(getPageContext());
        this.bKp.setLoadDataCallBack(this.aWL);
        registerListener();
        qD();
    }

    private void qD() {
        this.bKx = new com.baidu.tieba.hottopic.view.p((RelateTopicForumActivity) getPageContext().getOrignalPage(), this.Zg);
        XH();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bKx.onChangeSkinType(i);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            if (bundle.getSerializable("data_list") != null && (bundle.getSerializable("data_list") instanceof ArrayList)) {
                try {
                    this.Zg = (ArrayList) bundle.getSerializable("data_list");
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            return;
        }
        Intent intent = getIntent();
        if (intent != null && intent.getSerializableExtra("data_list") != null && (intent.getSerializableExtra("data_list") instanceof ArrayList)) {
            try {
                this.Zg = (ArrayList) intent.getSerializableExtra("data_list");
            } catch (Exception e2) {
            }
        }
    }

    private void XH() {
        if (this.bKx == null || this.Zg.isEmpty()) {
            this.bKx.Qp();
        } else {
            this.bKx.Qo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData aN(long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.Zg.size()) {
                if (com.baidu.tbadk.core.util.x.b(this.Zg, i2) != null && (this.Zg.get(i2) instanceof RelateForumItemData)) {
                    RelateForumItemData relateForumItemData = this.Zg.get(i2);
                    if (j == relateForumItemData.forumId) {
                        return relateForumItemData;
                    }
                }
                i = i2 + 1;
            } else {
                return null;
            }
        }
    }

    private void registerListener() {
        registerListener(this.aEM);
        registerListener(this.aEL);
    }
}
