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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FrsMoreFeedForumsConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsMoreFeedForumsActivity extends BaseActivity<FrsMoreFeedForumsActivity> {
    private View dJI;
    private List<FeedForumData> dSF;
    private e dSP;
    private ListView dSQ;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.FrsMoreFeedForumsActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == FrsMoreFeedForumsActivity.this.dJI.getId()) {
                FrsMoreFeedForumsActivity.this.finish();
            }
        }
    };
    private CustomMessageListener dEJ = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.frsfeedforums.FrsMoreFeedForumsActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                FrsMoreFeedForumsActivity.this.dSP.a(FrsMoreFeedForumsActivity.this.dSF, (r) customResponsedMessage.getData());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.frs_more_feed_forums_activity);
        Intent intent = getIntent();
        if (intent != null) {
            this.dSF = (ArrayList) intent.getSerializableExtra(FrsMoreFeedForumsConfig.KEY_FEED_DATA_LIST);
        }
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(e.g.view_navigation_bar);
        this.dJI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dJI.setOnClickListener(this.mOnClickListener);
        this.mNavigationBar.setTitleText(getPageContext().getString(e.j.group_fourm_content_extend_title));
        this.dSQ = (ListView) getPageContext().getPageActivity().findViewById(e.g.listView_feed_forum);
        registerListener(this.dEJ);
        this.dSP = new e(getPageContext());
        this.dSP.setData(this.dSF);
        this.dSQ.addHeaderView(LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.frs_more_feed_forums_header, (ViewGroup) null));
        this.dSQ.setAdapter((ListAdapter) this.dSP);
        this.dSP.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dSP.notifyDataSetChanged();
    }
}
