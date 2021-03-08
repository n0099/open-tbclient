package com.baidu.tieba.hottopic.controller;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.hottopic.adapter.j;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class RelateTopicForumActivity extends BaseActivity<RelateTopicForumActivity> {
    public LikeModel kej;
    private com.baidu.tieba.hottopic.view.d kwc;
    private ArrayList<RelateForumItemData> dataList = new ArrayList<>();
    private String ffX = "";
    private CustomMessageListener fTX = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.controller.RelateTopicForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !RelateTopicForumActivity.this.dataList.isEmpty()) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Long) {
                    RelateForumItemData gJ = RelateTopicForumActivity.this.gJ(((Long) data).longValue());
                    if (gJ != null) {
                        gJ.followNum++;
                        gJ.setIsLiked(true);
                        j cUb = RelateTopicForumActivity.this.kwc.cUb();
                        if (cUb != null) {
                            cUb.setData(RelateTopicForumActivity.this.dataList, RelateTopicForumActivity.this.ffX);
                            cUb.notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fTW = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.controller.RelateTopicForumActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !RelateTopicForumActivity.this.dataList.isEmpty()) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Long) {
                    RelateForumItemData gJ = RelateTopicForumActivity.this.gJ(((Long) data).longValue());
                    if (gJ != null) {
                        gJ.followNum--;
                        gJ.setIsLiked(false);
                        j cUb = RelateTopicForumActivity.this.kwc.cUb();
                        if (cUb != null) {
                            cUb.setData(RelateTopicForumActivity.this.dataList, RelateTopicForumActivity.this.ffX);
                            cUb.notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    };
    private e iKU = new e() { // from class: com.baidu.tieba.hottopic.controller.RelateTopicForumActivity.3
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (AntiHelper.bX(RelateTopicForumActivity.this.kej.getErrorCode(), RelateTopicForumActivity.this.kej.getErrorString())) {
                AntiHelper.bq(RelateTopicForumActivity.this.getActivity(), RelateTopicForumActivity.this.kej.getErrorString());
            } else if (!StringUtils.isNull(RelateTopicForumActivity.this.kej.getErrorString())) {
                l.showToast(TbadkCoreApplication.getInst(), RelateTopicForumActivity.this.kej.getErrorString());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.kej = new LikeModel(getPageContext());
        this.kej.setLoadDataCallBack(this.iKU);
        registerListener();
        initUI();
        TiebaStatic.log("c10335a");
    }

    private void initUI() {
        this.kwc = new com.baidu.tieba.hottopic.view.d((RelateTopicForumActivity) getPageContext().getOrignalPage(), this.dataList);
        cTn();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kwc.onChangeSkinType(i);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            if (bundle.getSerializable("data_list") != null && (bundle.getSerializable("data_list") instanceof ArrayList)) {
                try {
                    this.dataList = (ArrayList) bundle.getSerializable("data_list");
                    this.ffX = bundle.getString("topic_id") == null ? "" : bundle.getString("topic_id");
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
                this.ffX = intent.getStringExtra("topic_id") == null ? "" : intent.getStringExtra("topic_id");
            } catch (Exception e2) {
            }
        }
    }

    public String getTopicId() {
        return this.ffX;
    }

    private void cTn() {
        if (this.kwc != null) {
            if (this.dataList.isEmpty()) {
                this.kwc.bSE();
            } else {
                this.kwc.Xb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData gJ(long j) {
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
        registerListener(this.fTX);
        registerListener(this.fTW);
    }
}
