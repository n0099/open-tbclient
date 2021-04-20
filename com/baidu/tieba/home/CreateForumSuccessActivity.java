package com.baidu.tieba.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class CreateForumSuccessActivity extends BaseActivity<CreateForumSuccessActivity> {
    public static final String FORUM_NAME_STRING = "forumname";
    public NoDataView emptyView;
    public NavigationBar mNavigationBar;
    public NoNetworkView mNoNetView;
    public LinearLayout mRootView;
    public String mForumName = null;
    public TextView mTextView = null;
    public TextView mTextAuditTip = null;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CreateForumSuccessActivity.this.finish();
        }
    }

    private void initData() {
        String stringExtra = getIntent().getStringExtra(FORUM_NAME_STRING);
        this.mForumName = stringExtra;
        if (stringExtra == null) {
            this.mForumName = "";
        }
    }

    private void initUi() {
        this.mRootView = (LinearLayout) findViewById(R.id.root_view);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.mNoNetView = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        int g2 = l.g(getActivity(), R.dimen.ds100);
        NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), (LinearLayout) this.mRootView.findViewById(R.id.emotion_layout), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.SINGALL, g2), null, null);
        this.emptyView = a2;
        a2.setVisibility(0);
        this.mTextView = (TextView) findViewById(R.id.text_suc_tip);
        this.mTextView.setText(getActivity().getString(R.string.noforum_create_suc_tip1) + this.mForumName + getActivity().getString(R.string.noforum_create_suc_tip2));
        this.mTextAuditTip = (TextView) findViewById(R.id.text_audit_tip);
        String string = getResources().getString(R.string.noforum_create_audit_tip);
        if (!StringUtils.isNull(string) && this.mTextAuditTip != null) {
            this.mTextAuditTip.setText(string.replace("%s", this.mForumName));
        }
        findViewById(R.id.text_create_succ).setOnClickListener(new a());
    }

    public static void startActivity(Context context, String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        Intent intent = new Intent(context, CreateForumSuccessActivity.class);
        intent.putExtra(FORUM_NAME_STRING, str);
        if (!(context instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        context.startActivity(intent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        super.changeSkinType(i);
        getLayoutMode().j(this.mRootView);
        d.b.h0.s0.a.a(getPageContext(), this.mRootView);
        NoNetworkView noNetworkView = this.mNoNetView;
        if (noNetworkView != null && noNetworkView.getVisibility() == 0) {
            this.mNoNetView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        NoDataView noDataView = this.emptyView;
        if (noDataView != null) {
            noDataView.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        NavigationBar navigationBar = this.mNavigationBar;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_forum_success_activity);
        initData();
        initUi();
    }
}
