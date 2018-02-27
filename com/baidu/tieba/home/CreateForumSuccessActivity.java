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
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class CreateForumSuccessActivity extends BaseActivity<CreateForumSuccessActivity> {
    private LinearLayout bCr;
    private NoNetworkView dAL;
    private h eeS;
    private NavigationBar mNavigationBar;
    private String mForumName = null;
    private TextView ry = null;
    private TextView eff = null;

    public static void ah(Context context, String str) {
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
        setContentView(d.h.create_forum_success_activity);
        initData();
        aCa();
    }

    private void initData() {
        this.mForumName = getIntent().getStringExtra("forumname");
        if (this.mForumName == null) {
            this.mForumName = "";
        }
    }

    private void aCa() {
        this.bCr = (LinearLayout) findViewById(d.g.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.create_bar);
        this.dAL = (NoNetworkView) this.bCr.findViewById(d.g.view_no_network);
        int t = l.t(getActivity(), d.e.ds100);
        this.eeS = NoDataViewFactory.a(getPageContext().getPageActivity(), (LinearLayout) this.bCr.findViewById(d.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, t), null, null);
        this.eeS.setVisibility(0);
        this.ry = (TextView) findViewById(d.g.text_suc_tip);
        this.ry.setText(getActivity().getString(d.j.noforum_create_suc_tip1) + this.mForumName + getActivity().getString(d.j.noforum_create_suc_tip2));
        this.eff = (TextView) findViewById(d.g.text_audit_tip);
        String string = getResources().getString(d.j.noforum_create_audit_tip);
        if (!StringUtils.isNull(string) && this.eff != null) {
            this.eff.setText(string.replace("%s", this.mForumName));
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
        getLayoutMode().aM(this.bCr);
        com.baidu.tbadk.n.a.a(getPageContext(), this.bCr);
        if (this.dAL != null && this.dAL.getVisibility() == 0) {
            this.dAL.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.eeS != null) {
            this.eeS.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }
}
