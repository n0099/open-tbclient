package com.baidu.tbadk.system.portrait;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.n;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ChangeSystemPhotoActivity extends BaseActivity<ChangeSystemPhotoActivity> {
    private NavigationBar mNavigationBar = null;
    private TextView arF = null;
    private View arG = null;
    private BdGridView arH = null;
    private LinearLayout mRootView = null;
    private i arI = null;
    private ArrayList<k> arJ = null;
    private int arK = -1;
    private h arL = null;
    private com.baidu.adp.widget.a.a arM = null;
    private String arN = null;
    private com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> arO = new a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.change_system_photo_layout);
        initUI();
        initData();
    }

    public void initUI() {
        this.mRootView = (LinearLayout) findViewById(q.change_system_photo_layout);
        this.mNavigationBar = (NavigationBar) findViewById(q.view_navigation_bar);
        this.arG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.arG.setOnClickListener(new b(this));
        this.mNavigationBar.setTitleText(t.choose_system_photo);
        this.arF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(t.done));
        bm(false);
        this.arF.setOnClickListener(new c(this));
        this.arH = (BdGridView) findViewById(q.recommend_photos_list);
        this.arI = new i(getPageContext());
        this.arH.setAdapter((ListAdapter) this.arI);
        this.arH.setOnItemClickListener(new d(this));
    }

    public void initData() {
        this.arJ = new ArrayList<>();
        DO();
    }

    private void DO() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(new e(this), session.bduss);
        }
    }

    public void a(k kVar) {
        if (kVar != null && !StringUtils.isNull(kVar.getUrl())) {
            this.arN = kVar.getUrl();
            com.baidu.adp.lib.f.d.hl().a(kVar.getUrl(), 10, this.arO, 0, 0, getUniqueId(), new Object[0]);
        }
    }

    public void bm(boolean z) {
        if (z) {
            this.arF.setClickable(true);
            ay.i((View) this.arF, p.blue_btn_down_selector);
            ay.b(this.arF, n.cp_cont_i, 1);
            return;
        }
        this.arF.setClickable(false);
        ay.i((View) this.arF, p.btn_app_download_d);
        ay.b(this.arF, n.white_alpha40, 1);
    }

    public void showDialog() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bu(t.enter_forum_cancel_change_tip);
        aVar.b(t.alert_no_button, new f(this));
        aVar.a(t.alert_yes_btn, new g(this));
        aVar.b(getPageContext()).rL();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.arK != -1) {
                showDialog();
            } else {
                setResult(0);
                finish();
            }
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().j(this.mRootView);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ay.i((View) this.arF, p.btn_app_download_d);
    }
}
