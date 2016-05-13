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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FrsMoreFeedForumsActivity extends BaseActivity<FrsMoreFeedForumsActivity> {
    private List<FeedForumData> biJ;
    private View bjF;
    private cz bky;
    private ListView bkz;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = new cx(this);
    private CustomMessageListener bdA = new cy(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.frs_more_feed_forums_activity);
        Intent intent = getIntent();
        if (intent != null) {
            this.biJ = (ArrayList) intent.getSerializableExtra(FrsMoreFeedForumsConfig.KEY_FEED_DATA_LIST);
        }
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(t.g.view_navigation_bar);
        this.bjF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bjF.setOnClickListener(this.mOnClickListener);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.maybe_your_intrested_forums));
        this.bkz = (ListView) getPageContext().getPageActivity().findViewById(t.g.listView_feed_forum);
        registerListener(this.bdA);
        this.bky = new cz(getPageContext());
        this.bky.setData(this.biJ);
        this.bkz.addHeaderView(LayoutInflater.from(getPageContext().getPageActivity()).inflate(t.h.frs_more_feed_forums_header, (ViewGroup) null));
        this.bkz.setAdapter((ListAdapter) this.bky);
        this.bky.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bky.notifyDataSetChanged();
    }
}
