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
    private com.baidu.tieba.hottopic.view.e boD;
    public w box;
    private ArrayList<RelateForumItemData> Xo = new ArrayList<>();
    private CustomMessageListener boy = new j(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener boz = new k(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private com.baidu.adp.base.g aLJ = new l(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.box = new w(getPageContext());
        this.box.setLoadDataCallBack(this.aLJ);
        registerListener();
        initUI();
    }

    private void initUI() {
        this.boD = new com.baidu.tieba.hottopic.view.e((RelateTopicForumActivity) getPageContext().getOrignalPage(), this.Xo);
        QS();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.boD.onChangeSkinType(i);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            if (bundle.getSerializable("data_list") != null && (bundle.getSerializable("data_list") instanceof ArrayList)) {
                try {
                    this.Xo = (ArrayList) bundle.getSerializable("data_list");
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
                this.Xo = (ArrayList) intent.getSerializableExtra("data_list");
            } catch (Exception e2) {
            }
        }
    }

    private void QS() {
        if (this.boD == null || this.Xo.isEmpty()) {
            this.boD.Mg();
        } else {
            this.boD.Mf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData ap(long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.Xo.size()) {
                if (u.b(this.Xo, i2) != null && (this.Xo.get(i2) instanceof RelateForumItemData)) {
                    RelateForumItemData relateForumItemData = this.Xo.get(i2);
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
        registerListener(this.boy);
        registerListener(this.boz);
    }
}
