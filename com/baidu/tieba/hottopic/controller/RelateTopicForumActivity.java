package com.baidu.tieba.hottopic.controller;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RelateTopicForumActivity extends BaseActivity<RelateTopicForumActivity> {
    public w boI;
    private com.baidu.tieba.hottopic.view.e boO;
    private ArrayList<RelateForumItemData> Xq = new ArrayList<>();
    private CustomMessageListener boJ = new j(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener boK = new k(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private com.baidu.adp.base.g aLU = new l(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.boI = new w(getPageContext());
        this.boI.setLoadDataCallBack(this.aLU);
        registerListener();
        initUI();
    }

    private void initUI() {
        this.boO = new com.baidu.tieba.hottopic.view.e((RelateTopicForumActivity) getPageContext().getOrignalPage(), this.Xq);
        QO();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.boO.onChangeSkinType(i);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            if (bundle.getSerializable("data_list") != null && (bundle.getSerializable("data_list") instanceof ArrayList)) {
                try {
                    this.Xq = (ArrayList) bundle.getSerializable("data_list");
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
                this.Xq = (ArrayList) intent.getSerializableExtra("data_list");
            } catch (Exception e2) {
            }
        }
    }

    private void QO() {
        if (this.boO == null || this.Xq.isEmpty()) {
            this.boO.Mc();
        } else {
            this.boO.Mb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData ax(long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.Xq.size()) {
                if (u.b(this.Xq, i2) != null && (this.Xq.get(i2) instanceof RelateForumItemData)) {
                    RelateForumItemData relateForumItemData = this.Xq.get(i2);
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
        registerListener(this.boJ);
        registerListener(this.boK);
    }
}
