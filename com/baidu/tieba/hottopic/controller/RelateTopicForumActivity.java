package com.baidu.tieba.hottopic.controller;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class RelateTopicForumActivity extends BaseActivity<RelateTopicForumActivity> {
    public x bGQ;
    private com.baidu.tieba.hottopic.view.h bGX;
    private ArrayList<RelateForumItemData> YJ = new ArrayList<>();
    private CustomMessageListener aDW = new t(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener aDV = new u(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private com.baidu.adp.base.g aUC = new v(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.bGQ = new x(getPageContext());
        this.bGQ.setLoadDataCallBack(this.aUC);
        registerListener();
        initUI();
    }

    private void initUI() {
        this.bGX = new com.baidu.tieba.hottopic.view.h((RelateTopicForumActivity) getPageContext().getOrignalPage(), this.YJ);
        Vu();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bGX.onChangeSkinType(i);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            if (bundle.getSerializable("data_list") != null && (bundle.getSerializable("data_list") instanceof ArrayList)) {
                try {
                    this.YJ = (ArrayList) bundle.getSerializable("data_list");
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
                this.YJ = (ArrayList) intent.getSerializableExtra("data_list");
            } catch (Exception e2) {
            }
        }
    }

    private void Vu() {
        if (this.bGX == null || this.YJ.isEmpty()) {
            this.bGX.Om();
        } else {
            this.bGX.Ol();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData aM(long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.YJ.size()) {
                if (y.b(this.YJ, i2) != null && (this.YJ.get(i2) instanceof RelateForumItemData)) {
                    RelateForumItemData relateForumItemData = this.YJ.get(i2);
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
        registerListener(this.aDW);
        registerListener(this.aDV);
    }
}
