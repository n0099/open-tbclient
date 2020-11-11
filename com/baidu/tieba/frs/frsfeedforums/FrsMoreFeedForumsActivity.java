package com.baidu.tieba.frs.frsfeedforums;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FrsMoreFeedForumsConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class FrsMoreFeedForumsActivity extends BaseActivity<FrsMoreFeedForumsActivity> {
    private View iJO;
    private e iVA;
    private ListView iVB;
    private List<FeedForumData> iVq;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.FrsMoreFeedForumsActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == FrsMoreFeedForumsActivity.this.iJO.getId()) {
                FrsMoreFeedForumsActivity.this.finish();
            }
        }
    };
    private CustomMessageListener iDv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.frsfeedforums.FrsMoreFeedForumsActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v)) {
                FrsMoreFeedForumsActivity.this.iVA.a(FrsMoreFeedForumsActivity.this.iVq, (v) customResponsedMessage.getData());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.frs_more_feed_forums_activity);
        Intent intent = getIntent();
        if (intent != null) {
            this.iVq = (ArrayList) intent.getSerializableExtra(FrsMoreFeedForumsConfig.KEY_FEED_DATA_LIST);
        }
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(R.id.view_navigation_bar);
        this.iJO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iJO.setOnClickListener(this.mOnClickListener);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.group_fourm_content_extend_title));
        this.iVB = (ListView) getPageContext().getPageActivity().findViewById(R.id.listView_feed_forum);
        registerListener(this.iDv);
        this.iVA = new e(getPageContext());
        this.iVA.setData(this.iVq);
        this.iVB.addHeaderView(LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.frs_more_feed_forums_header, (ViewGroup) null));
        this.iVB.setAdapter((ListAdapter) this.iVA);
        this.iVA.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iVA.notifyDataSetChanged();
    }
}
