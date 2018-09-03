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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class CreateForumSuccessActivity extends BaseActivity<CreateForumSuccessActivity> {
    private LinearLayout axD;
    private NoDataView dSb;
    private NoNetworkView dit;
    private NavigationBar mNavigationBar;
    private String mForumName = null;
    private TextView mTextView = null;
    private TextView dSn = null;

    public static void ag(Context context, String str) {
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
        setContentView(f.h.create_forum_success_activity);
        initData();
        aDa();
    }

    private void initData() {
        this.mForumName = getIntent().getStringExtra("forumname");
        if (this.mForumName == null) {
            this.mForumName = "";
        }
    }

    private void aDa() {
        this.axD = (LinearLayout) findViewById(f.g.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(f.j.create_bar);
        this.dit = (NoNetworkView) this.axD.findViewById(f.g.view_no_network);
        int f = l.f(getActivity(), f.e.ds100);
        this.dSb = NoDataViewFactory.a(getPageContext().getPageActivity(), (LinearLayout) this.axD.findViewById(f.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, f), null, null);
        this.dSb.setVisibility(0);
        this.mTextView = (TextView) findViewById(f.g.text_suc_tip);
        this.mTextView.setText(getActivity().getString(f.j.noforum_create_suc_tip1) + this.mForumName + getActivity().getString(f.j.noforum_create_suc_tip2));
        this.dSn = (TextView) findViewById(f.g.text_audit_tip);
        String string = getResources().getString(f.j.noforum_create_audit_tip);
        if (!StringUtils.isNull(string) && this.dSn != null) {
            this.dSn.setText(string.replace("%s", this.mForumName));
        }
        findViewById(f.g.text_create_succ).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumSuccessActivity.1
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
        getLayoutMode().onModeChanged(this.axD);
        com.baidu.tbadk.o.a.a(getPageContext(), this.axD);
        if (this.dit != null && this.dit.getVisibility() == 0) {
            this.dit.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dSb != null) {
            this.dSb.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }
}
