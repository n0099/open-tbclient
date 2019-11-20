package com.baidu.tieba.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class CreateForumSuccessActivity extends BaseActivity<CreateForumSuccessActivity> {
    private NoNetworkView fqt;
    private NoDataView gcu;
    private NavigationBar mNavigationBar;
    private LinearLayout mRootView;
    private String mForumName = null;
    private TextView mTextView = null;
    private TextView gcF = null;

    public static void aC(Context context, String str) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent(context, CreateForumSuccessActivity.class);
            intent.putExtra("forumname", str);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_forum_success_activity);
        initData();
        bsP();
    }

    private void initData() {
        this.mForumName = getIntent().getStringExtra("forumname");
        if (this.mForumName == null) {
            this.mForumName = "";
        }
    }

    private void bsP() {
        this.mRootView = (LinearLayout) findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.fqt = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        int dimens = l.getDimens(getActivity(), R.dimen.ds100);
        this.gcu = NoDataViewFactory.a(getPageContext().getPageActivity(), (LinearLayout) this.mRootView.findViewById(R.id.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, dimens), null, null);
        this.gcu.setVisibility(0);
        this.mTextView = (TextView) findViewById(R.id.text_suc_tip);
        this.mTextView.setText(getActivity().getString(R.string.noforum_create_suc_tip1) + this.mForumName + getActivity().getString(R.string.noforum_create_suc_tip2));
        this.gcF = (TextView) findViewById(R.id.text_audit_tip);
        String string = getResources().getString(R.string.noforum_create_audit_tip);
        if (!StringUtils.isNull(string) && this.gcF != null) {
            this.gcF.setText(string.replace("%s", this.mForumName));
        }
        findViewById(R.id.text_create_succ).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumSuccessActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CreateForumSuccessActivity.this.finish();
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        super.changeSkinType(i);
        getLayoutMode().onModeChanged(this.mRootView);
        com.baidu.tbadk.s.a.a(getPageContext(), this.mRootView);
        if (this.fqt != null && this.fqt.getVisibility() == 0) {
            this.fqt.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.gcu != null) {
            this.gcu.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }
}
