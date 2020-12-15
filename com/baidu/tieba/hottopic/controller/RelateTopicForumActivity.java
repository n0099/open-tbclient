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
/* loaded from: classes21.dex */
public class RelateTopicForumActivity extends BaseActivity<RelateTopicForumActivity> {
    public LikeModel jLJ;
    private com.baidu.tieba.hottopic.view.d kcY;
    private ArrayList<RelateForumItemData> dataList = new ArrayList<>();
    private String eXq = "";
    private CustomMessageListener fLl = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.controller.RelateTopicForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !RelateTopicForumActivity.this.dataList.isEmpty()) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Long) {
                    RelateForumItemData gE = RelateTopicForumActivity.this.gE(((Long) data).longValue());
                    if (gE != null) {
                        gE.followNum++;
                        gE.setIsLiked(true);
                        l cSz = RelateTopicForumActivity.this.kcY.cSz();
                        if (cSz != null) {
                            cSz.c(RelateTopicForumActivity.this.dataList, RelateTopicForumActivity.this.eXq);
                            cSz.notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fLk = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.controller.RelateTopicForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !RelateTopicForumActivity.this.dataList.isEmpty()) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Long) {
                    RelateForumItemData gE = RelateTopicForumActivity.this.gE(((Long) data).longValue());
                    if (gE != null) {
                        gE.followNum--;
                        gE.setIsLiked(false);
                        l cSz = RelateTopicForumActivity.this.kcY.cSz();
                        if (cSz != null) {
                            cSz.c(RelateTopicForumActivity.this.dataList, RelateTopicForumActivity.this.eXq);
                            cSz.notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private com.baidu.adp.base.d ivH = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.hottopic.controller.RelateTopicForumActivity.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bP(RelateTopicForumActivity.this.jLJ.getErrorCode(), RelateTopicForumActivity.this.jLJ.getErrorString())) {
                AntiHelper.bn(RelateTopicForumActivity.this.getActivity(), RelateTopicForumActivity.this.jLJ.getErrorString());
            } else if (!StringUtils.isNull(RelateTopicForumActivity.this.jLJ.getErrorString())) {
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), RelateTopicForumActivity.this.jLJ.getErrorString());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.jLJ = new LikeModel(getPageContext());
        this.jLJ.setLoadDataCallBack(this.ivH);
        registerListener();
        initUI();
        TiebaStatic.log("c10335a");
    }

    private void initUI() {
        this.kcY = new com.baidu.tieba.hottopic.view.d((RelateTopicForumActivity) getPageContext().getOrignalPage(), this.dataList);
        cRL();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kcY.onChangeSkinType(i);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            if (bundle.getSerializable("data_list") != null && (bundle.getSerializable("data_list") instanceof ArrayList)) {
                try {
                    this.dataList = (ArrayList) bundle.getSerializable("data_list");
                    this.eXq = bundle.getString("topic_id") == null ? "" : bundle.getString("topic_id");
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
                this.eXq = intent.getStringExtra("topic_id") == null ? "" : intent.getStringExtra("topic_id");
            } catch (Exception e2) {
            }
        }
    }

    public String getTopicId() {
        return this.eXq;
    }

    private void cRL() {
        if (this.kcY != null) {
            if (this.dataList.isEmpty()) {
                this.kcY.bTb();
            } else {
                this.kcY.Ya();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData gE(long j) {
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
        registerListener(this.fLl);
        registerListener(this.fLk);
    }
}
