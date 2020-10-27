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
    private com.baidu.tieba.hottopic.view.d jIL;
    public LikeModel jrr;
    private ArrayList<RelateForumItemData> dataList = new ArrayList<>();
    private String eLl = "";
    private CustomMessageListener fyg = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.controller.RelateTopicForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !RelateTopicForumActivity.this.dataList.isEmpty()) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Long) {
                    RelateForumItemData fA = RelateTopicForumActivity.this.fA(((Long) data).longValue());
                    if (fA != null) {
                        fA.followNum++;
                        fA.setIsLiked(true);
                        l cLd = RelateTopicForumActivity.this.jIL.cLd();
                        if (cLd != null) {
                            cLd.c(RelateTopicForumActivity.this.dataList, RelateTopicForumActivity.this.eLl);
                            cLd.notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fyf = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.controller.RelateTopicForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !RelateTopicForumActivity.this.dataList.isEmpty()) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Long) {
                    RelateForumItemData fA = RelateTopicForumActivity.this.fA(((Long) data).longValue());
                    if (fA != null) {
                        fA.followNum--;
                        fA.setIsLiked(false);
                        l cLd = RelateTopicForumActivity.this.jIL.cLd();
                        if (cLd != null) {
                            cLd.c(RelateTopicForumActivity.this.dataList, RelateTopicForumActivity.this.eLl);
                            cLd.notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private com.baidu.adp.base.d ieb = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.hottopic.controller.RelateTopicForumActivity.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bN(RelateTopicForumActivity.this.jrr.getErrorCode(), RelateTopicForumActivity.this.jrr.getErrorString())) {
                AntiHelper.bm(RelateTopicForumActivity.this.getActivity(), RelateTopicForumActivity.this.jrr.getErrorString());
            } else if (!StringUtils.isNull(RelateTopicForumActivity.this.jrr.getErrorString())) {
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), RelateTopicForumActivity.this.jrr.getErrorString());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.jrr = new LikeModel(getPageContext());
        this.jrr.setLoadDataCallBack(this.ieb);
        registerListener();
        initUI();
        TiebaStatic.log("c10335a");
    }

    private void initUI() {
        this.jIL = new com.baidu.tieba.hottopic.view.d((RelateTopicForumActivity) getPageContext().getOrignalPage(), this.dataList);
        cKo();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jIL.onChangeSkinType(i);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            if (bundle.getSerializable("data_list") != null && (bundle.getSerializable("data_list") instanceof ArrayList)) {
                try {
                    this.dataList = (ArrayList) bundle.getSerializable("data_list");
                    this.eLl = bundle.getString("topic_id") == null ? "" : bundle.getString("topic_id");
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
                this.eLl = intent.getStringExtra("topic_id") == null ? "" : intent.getStringExtra("topic_id");
            } catch (Exception e2) {
            }
        }
    }

    public String getTopicId() {
        return this.eLl;
    }

    private void cKo() {
        if (this.jIL != null) {
            if (this.dataList.isEmpty()) {
                this.jIL.bNw();
            } else {
                this.jIL.TJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData fA(long j) {
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
        registerListener(this.fyg);
        registerListener(this.fyf);
    }
}
