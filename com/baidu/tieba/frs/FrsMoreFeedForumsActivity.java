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
    private List<FeedForumData> bnh;
    private View bow;
    private dd bpf;
    private ListView bpg;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = new db(this);
    private CustomMessageListener bhF = new dc(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.frs_more_feed_forums_activity);
        Intent intent = getIntent();
        if (intent != null) {
            this.bnh = (ArrayList) intent.getSerializableExtra(FrsMoreFeedForumsConfig.KEY_FEED_DATA_LIST);
        }
        this.mNavigationBar = (NavigationBar) getPageContext().getPageActivity().findViewById(t.g.view_navigation_bar);
        this.bow = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bow.setOnClickListener(this.mOnClickListener);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.maybe_your_intrested_forums));
        this.bpg = (ListView) getPageContext().getPageActivity().findViewById(t.g.listView_feed_forum);
        registerListener(this.bhF);
        this.bpf = new dd(getPageContext());
        this.bpf.setData(this.bnh);
        this.bpg.addHeaderView(LayoutInflater.from(getPageContext().getPageActivity()).inflate(t.h.frs_more_feed_forums_header, (ViewGroup) null));
        this.bpg.setAdapter((ListAdapter) this.bpf);
        this.bpf.notifyDataSetChanged();
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
        this.bpf.notifyDataSetChanged();
    }
}
