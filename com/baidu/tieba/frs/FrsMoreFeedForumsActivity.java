package com.baidu.tieba.frs;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FrsMoreFeedForumsConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FrsMoreFeedForumsActivity extends BaseActivity<FrsMoreFeedForumsActivity> {
    private List<FeedForumData> bfO;
    private View bgC;
    private cr bhh;
    private ListView bhi;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = new cp(this);
    private CustomMessageListener baJ = new cq(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.h.frs_more_feed_forums_activity);
        Intent intent = getIntent();
        if (intent != null) {
            this.bfO = (ArrayList) intent.getSerializableExtra(FrsMoreFeedForumsConfig.KEY_FEED_DATA_LIST);
        }
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(n.g.view_navigation_bar);
        this.bgC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bgC.setOnClickListener(this.mOnClickListener);
        this.mNavigationBar.setTitleText(getPageContext().getString(n.j.maybe_your_intrested_forums));
        this.bhi = (ListView) getPageContext().getPageActivity().findViewById(n.g.listView_feed_forum);
        registerListener(this.baJ);
        this.bhh = new cr(getPageContext());
        this.bhh.setData(this.bfO);
        this.bhi.addHeaderView(LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.h.frs_more_feed_forums_header, (ViewGroup) null));
        this.bhi.setAdapter((ListAdapter) this.bhh);
        this.bhh.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bhh.notifyDataSetChanged();
    }
}
