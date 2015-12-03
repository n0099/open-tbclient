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
    private List<FeedForumData> bbP;
    private View bcC;
    private co bdh;
    private ListView bdi;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = new cm(this);
    private CustomMessageListener aWI = new cn(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.frs_more_feed_forums_activity);
        Intent intent = getIntent();
        if (intent != null) {
            this.bbP = (ArrayList) intent.getSerializableExtra(FrsMoreFeedForumsConfig.KEY_FEED_DATA_LIST);
        }
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(n.f.view_navigation_bar);
        this.bcC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bcC.setOnClickListener(this.mOnClickListener);
        this.mNavigationBar.setTitleText(getPageContext().getString(n.i.maybe_your_intrested_forums));
        this.bdi = (ListView) getPageContext().getPageActivity().findViewById(n.f.listView_feed_forum);
        registerListener(this.aWI);
        this.bdh = new co(getPageContext());
        this.bdh.setData(this.bbP);
        this.bdi.addHeaderView(LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.g.frs_more_feed_forums_header, (ViewGroup) null));
        this.bdi.setAdapter((ListAdapter) this.bdh);
        this.bdh.notifyDataSetChanged();
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
        this.bdh.notifyDataSetChanged();
    }
}
