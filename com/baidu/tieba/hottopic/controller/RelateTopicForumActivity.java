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
    public x bDm;
    private com.baidu.tieba.hottopic.view.h bDt;
    private ArrayList<RelateForumItemData> Yg = new ArrayList<>();
    private CustomMessageListener aCo = new t(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener aCn = new u(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private com.baidu.adp.base.g aQL = new v(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.bDm = new x(getPageContext());
        this.bDm.setLoadDataCallBack(this.aQL);
        registerListener();
        initUI();
    }

    private void initUI() {
        this.bDt = new com.baidu.tieba.hottopic.view.h((RelateTopicForumActivity) getPageContext().getOrignalPage(), this.Yg);
        Ur();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bDt.onChangeSkinType(i);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            if (bundle.getSerializable("data_list") != null && (bundle.getSerializable("data_list") instanceof ArrayList)) {
                try {
                    this.Yg = (ArrayList) bundle.getSerializable("data_list");
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
                this.Yg = (ArrayList) intent.getSerializableExtra("data_list");
            } catch (Exception e2) {
            }
        }
    }

    private void Ur() {
        if (this.bDt == null || this.Yg.isEmpty()) {
            this.bDt.NT();
        } else {
            this.bDt.NS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData aL(long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.Yg.size()) {
                if (y.b(this.Yg, i2) != null && (this.Yg.get(i2) instanceof RelateForumItemData)) {
                    RelateForumItemData relateForumItemData = this.Yg.get(i2);
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
        registerListener(this.aCo);
        registerListener(this.aCn);
    }
}
