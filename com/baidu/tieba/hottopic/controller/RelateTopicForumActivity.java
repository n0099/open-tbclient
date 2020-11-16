package com.baidu.tieba.hottopic.controller;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.hottopic.adapter.l;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes20.dex */
public class RelateTopicForumActivity extends BaseActivity<RelateTopicForumActivity> {
    private com.baidu.tieba.hottopic.view.d jPt;
    public LikeModel jyf;
    private ArrayList<RelateForumItemData> dataList = new ArrayList<>();
    private String eQb = "";
    private CustomMessageListener fDz = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.controller.RelateTopicForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !RelateTopicForumActivity.this.dataList.isEmpty()) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Long) {
                    RelateForumItemData fZ = RelateTopicForumActivity.this.fZ(((Long) data).longValue());
                    if (fZ != null) {
                        fZ.followNum++;
                        fZ.setIsLiked(true);
                        l cNk = RelateTopicForumActivity.this.jPt.cNk();
                        if (cNk != null) {
                            cNk.c(RelateTopicForumActivity.this.dataList, RelateTopicForumActivity.this.eQb);
                            cNk.notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fDy = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.controller.RelateTopicForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !RelateTopicForumActivity.this.dataList.isEmpty()) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Long) {
                    RelateForumItemData fZ = RelateTopicForumActivity.this.fZ(((Long) data).longValue());
                    if (fZ != null) {
                        fZ.followNum--;
                        fZ.setIsLiked(false);
                        l cNk = RelateTopicForumActivity.this.jPt.cNk();
                        if (cNk != null) {
                            cNk.c(RelateTopicForumActivity.this.dataList, RelateTopicForumActivity.this.eQb);
                            cNk.notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private com.baidu.adp.base.d ikM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.hottopic.controller.RelateTopicForumActivity.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bP(RelateTopicForumActivity.this.jyf.getErrorCode(), RelateTopicForumActivity.this.jyf.getErrorString())) {
                AntiHelper.bj(RelateTopicForumActivity.this.getActivity(), RelateTopicForumActivity.this.jyf.getErrorString());
            } else if (!StringUtils.isNull(RelateTopicForumActivity.this.jyf.getErrorString())) {
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), RelateTopicForumActivity.this.jyf.getErrorString());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.jyf = new LikeModel(getPageContext());
        this.jyf.setLoadDataCallBack(this.ikM);
        registerListener();
        initUI();
        TiebaStatic.log("c10335a");
    }

    private void initUI() {
        this.jPt = new com.baidu.tieba.hottopic.view.d((RelateTopicForumActivity) getPageContext().getOrignalPage(), this.dataList);
        cMw();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jPt.onChangeSkinType(i);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            if (bundle.getSerializable("data_list") != null && (bundle.getSerializable("data_list") instanceof ArrayList)) {
                try {
                    this.dataList = (ArrayList) bundle.getSerializable("data_list");
                    this.eQb = bundle.getString("topic_id") == null ? "" : bundle.getString("topic_id");
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
                this.dataList = (ArrayList) intent.getSerializableExtra("data_list");
                this.eQb = intent.getStringExtra("topic_id") == null ? "" : intent.getStringExtra("topic_id");
            } catch (Exception e2) {
            }
        }
    }

    public String getTopicId() {
        return this.eQb;
    }

    private void cMw() {
        if (this.jPt != null) {
            if (this.dataList.isEmpty()) {
                this.jPt.bPp();
            } else {
                this.jPt.VA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData fZ(long j) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dataList.size()) {
                if (y.getItem(this.dataList, i2) != null && (this.dataList.get(i2) instanceof RelateForumItemData)) {
                    RelateForumItemData relateForumItemData = this.dataList.get(i2);
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
        registerListener(this.fDz);
        registerListener(this.fDy);
    }
}
