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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class CreateForumSuccessActivity extends BaseActivity<CreateForumSuccessActivity> {
    private LinearLayout aGg;
    private NoNetworkView dxG;
    private NoDataView eiG;
    private NavigationBar mNavigationBar;
    private String mForumName = null;
    private TextView mTextView = null;
    private TextView eiS = null;

    public static void av(Context context, String str) {
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
        setContentView(e.h.create_forum_success_activity);
        initData();
        aId();
    }

    private void initData() {
        this.mForumName = getIntent().getStringExtra("forumname");
        if (this.mForumName == null) {
            this.mForumName = "";
        }
    }

    private void aId() {
        this.aGg = (LinearLayout) findViewById(e.g.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.create_bar);
        this.dxG = (NoNetworkView) this.aGg.findViewById(e.g.view_no_network);
        int h = l.h(getActivity(), e.C0200e.ds100);
        this.eiG = NoDataViewFactory.a(getPageContext().getPageActivity(), (LinearLayout) this.aGg.findViewById(e.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.SINGALL, h), null, null);
        this.eiG.setVisibility(0);
        this.mTextView = (TextView) findViewById(e.g.text_suc_tip);
        this.mTextView.setText(getActivity().getString(e.j.noforum_create_suc_tip1) + this.mForumName + getActivity().getString(e.j.noforum_create_suc_tip2));
        this.eiS = (TextView) findViewById(e.g.text_audit_tip);
        String string = getResources().getString(e.j.noforum_create_audit_tip);
        if (!StringUtils.isNull(string) && this.eiS != null) {
            this.eiS.setText(string.replace("%s", this.mForumName));
        }
        findViewById(e.g.text_create_succ).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateForumSuccessActivity.1
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
        getLayoutMode().onModeChanged(this.aGg);
        com.baidu.tbadk.o.a.a(getPageContext(), this.aGg);
        if (this.dxG != null && this.dxG.getVisibility() == 0) {
            this.dxG.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.eiG != null) {
            this.eiG.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        }
    }
}
