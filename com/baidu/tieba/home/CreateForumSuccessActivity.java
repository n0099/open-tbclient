package com.baidu.tieba.home;

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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class CreateForumSuccessActivity extends BaseActivity<CreateForumSuccessActivity> {
    private LinearLayout aya;
    private NoDataView dPt;
    private NoNetworkView dfF;
    private NavigationBar mNavigationBar;
    private String mForumName = null;
    private TextView mTextView = null;
    private TextView dPF = null;

    public static void ae(Context context, String str) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent(context, CreateForumSuccessActivity.class);
            intent.putExtra("forumname", str);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.create_forum_success_activity);
        initData();
        aCu();
    }

    private void initData() {
        this.mForumName = getIntent().getStringExtra("forumname");
        if (this.mForumName == null) {
            this.mForumName = "";
        }
    }

    private void aCu() {
        this.aya = (LinearLayout) findViewById(d.g.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.create_bar);
        this.dfF = (NoNetworkView) this.aya.findViewById(d.g.view_no_network);
        int e = l.e(getActivity(), d.e.ds100);
        this.dPt = NoDataViewFactory.a(getPageContext().getPageActivity(), (LinearLayout) this.aya.findViewById(d.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, e), null, null);
        this.dPt.setVisibility(0);
        this.mTextView = (TextView) findViewById(d.g.text_suc_tip);
        this.mTextView.setText(getActivity().getString(d.k.noforum_create_suc_tip1) + this.mForumName + getActivity().getString(d.k.noforum_create_suc_tip2));
        this.dPF = (TextView) findViewById(d.g.text_audit_tip);
        String string = getResources().getString(d.k.noforum_create_audit_tip);
        if (!StringUtils.isNull(string) && this.dPF != null) {
            this.dPF.setText(string.replace("%s", this.mForumName));
        }
        findViewById(d.g.text_create_succ).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumSuccessActivity.1
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
        getLayoutMode().onModeChanged(this.aya);
        com.baidu.tbadk.n.a.a(getPageContext(), this.aya);
        if (this.dfF != null && this.dfF.getVisibility() == 0) {
            this.dfF.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dPt != null) {
            this.dPt.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }
}
