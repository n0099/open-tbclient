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
    public w bpm;
    private com.baidu.tieba.hottopic.view.e bps;
    private ArrayList<RelateForumItemData> Xt = new ArrayList<>();
    private CustomMessageListener bpn = new j(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener bpo = new k(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private com.baidu.adp.base.g aMc = new l(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.bpm = new w(getPageContext());
        this.bpm.setLoadDataCallBack(this.aMc);
        registerListener();
        initUI();
    }

    private void initUI() {
        this.bps = new com.baidu.tieba.hottopic.view.e((RelateTopicForumActivity) getPageContext().getOrignalPage(), this.Xt);
        Rk();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bps.onChangeSkinType(i);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            if (bundle.getSerializable("data_list") != null && (bundle.getSerializable("data_list") instanceof ArrayList)) {
                try {
                    this.Xt = (ArrayList) bundle.getSerializable("data_list");
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
                this.Xt = (ArrayList) intent.getSerializableExtra("data_list");
            } catch (Exception e2) {
            }
        }
    }

    private void Rk() {
        if (this.bps == null || this.Xt.isEmpty()) {
            this.bps.Ms();
        } else {
            this.bps.Mr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData ax(long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.Xt.size()) {
                if (u.b(this.Xt, i2) != null && (this.Xt.get(i2) instanceof RelateForumItemData)) {
                    RelateForumItemData relateForumItemData = this.Xt.get(i2);
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
        registerListener(this.bpn);
        registerListener(this.bpo);
    }
}
