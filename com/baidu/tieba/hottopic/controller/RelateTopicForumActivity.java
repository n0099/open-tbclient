package com.baidu.tieba.hottopic.controller;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.b.b.a.e;
import d.b.b.e.p.l;
import d.b.i0.b1.a.j;
import d.b.i0.b1.f.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class RelateTopicForumActivity extends BaseActivity<RelateTopicForumActivity> {
    public LikeModel likeModel;
    public d mHotTopicMoreView;
    public ArrayList<RelateForumItemData> dataList = new ArrayList<>();
    public String topicId = "";
    public CustomMessageListener likeForumListener = new a(2001335);
    public CustomMessageListener unLikeForumListener = new b(2001336);
    public e mLikeModelCallback = new c();

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || RelateTopicForumActivity.this.dataList.isEmpty()) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Long) {
                RelateForumItemData itemByForumId = RelateTopicForumActivity.this.getItemByForumId(((Long) data).longValue());
                if (itemByForumId != null) {
                    itemByForumId.followNum++;
                    itemByForumId.setIsLiked(true);
                    j f2 = RelateTopicForumActivity.this.mHotTopicMoreView.f();
                    if (f2 != null) {
                        f2.d(RelateTopicForumActivity.this.dataList, RelateTopicForumActivity.this.topicId);
                        f2.notifyDataSetChanged();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || RelateTopicForumActivity.this.dataList.isEmpty()) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Long) {
                RelateForumItemData itemByForumId = RelateTopicForumActivity.this.getItemByForumId(((Long) data).longValue());
                if (itemByForumId != null) {
                    itemByForumId.followNum--;
                    itemByForumId.setIsLiked(false);
                    j f2 = RelateTopicForumActivity.this.mHotTopicMoreView.f();
                    if (f2 != null) {
                        f2.d(RelateTopicForumActivity.this.dataList, RelateTopicForumActivity.this.topicId);
                        f2.notifyDataSetChanged();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends e {
        public c() {
        }

        @Override // d.b.b.a.e
        public void c(Object obj) {
            if (AntiHelper.m(RelateTopicForumActivity.this.likeModel.getErrorCode(), RelateTopicForumActivity.this.likeModel.getErrorString())) {
                AntiHelper.u(RelateTopicForumActivity.this.getActivity(), RelateTopicForumActivity.this.likeModel.getErrorString());
            } else if (StringUtils.isNull(RelateTopicForumActivity.this.likeModel.getErrorString())) {
            } else {
                l.L(TbadkCoreApplication.getInst(), RelateTopicForumActivity.this.likeModel.getErrorString());
            }
        }
    }

    private void dealNoMoreView() {
        if (this.mHotTopicMoreView == null) {
            return;
        }
        if (this.dataList.isEmpty()) {
            this.mHotTopicMoreView.h();
        } else {
            this.mHotTopicMoreView.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData getItemByForumId(long j) {
        for (int i = 0; i < this.dataList.size(); i++) {
            if (ListUtils.getItem(this.dataList, i) != null && (this.dataList.get(i) instanceof RelateForumItemData)) {
                RelateForumItemData relateForumItemData = this.dataList.get(i);
                if (j == relateForumItemData.forumId) {
                    return relateForumItemData;
                }
            }
        }
        return null;
    }

    private void initData(Bundle bundle) {
        String str = "";
        try {
            if (bundle != null) {
                if (bundle.getSerializable("data_list") == null || !(bundle.getSerializable("data_list") instanceof ArrayList)) {
                    return;
                }
                this.dataList = (ArrayList) bundle.getSerializable("data_list");
                if (bundle.getString("topic_id") != null) {
                    str = bundle.getString("topic_id");
                }
                this.topicId = str;
                return;
            }
            Intent intent = getIntent();
            if (intent == null || intent.getSerializableExtra("data_list") == null || !(intent.getSerializableExtra("data_list") instanceof ArrayList)) {
                return;
            }
            this.dataList = (ArrayList) intent.getSerializableExtra("data_list");
            if (intent.getStringExtra("topic_id") != null) {
                str = intent.getStringExtra("topic_id");
            }
            this.topicId = str;
        } catch (Exception unused) {
        }
    }

    private void initUI() {
        this.mHotTopicMoreView = new d(getPageContext().getOrignalPage(), this.dataList);
        dealNoMoreView();
    }

    private void registerListener() {
        registerListener(this.likeForumListener);
        registerListener(this.unLikeForumListener);
    }

    public String getTopicId() {
        return this.topicId;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mHotTopicMoreView.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        LikeModel likeModel = new LikeModel(getPageContext());
        this.likeModel = likeModel;
        likeModel.setLoadDataCallBack(this.mLikeModelCallback);
        registerListener();
        initUI();
        TiebaStatic.log("c10335a");
    }
}
