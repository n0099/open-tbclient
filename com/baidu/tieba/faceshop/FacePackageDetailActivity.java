package com.baidu.tieba.faceshop;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.download.DownloadData;
/* loaded from: classes.dex */
public class FacePackageDetailActivity extends BaseActivity {
    private ak atj;
    private am atk;
    private ap atl;
    private x atm;
    private float atn;
    private float ato;
    private boolean atp = false;
    private final Rect atq = new Rect();
    private final com.baidu.tbadk.core.view.u atr = new ae(this);
    private final BaseActivity.LoadDataCallBack ats = new af(this, this);
    private final CustomMessageListener Sg = new ag(this, 2001122);

    static {
        TbadkApplication.m251getInst().RegisterIntent(FacePackageDetailActivityConfig.class, FacePackageDetailActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d(bundle);
        initUI();
        refresh();
    }

    private void initUI() {
        this.atk = new am(this);
        CU();
        registerListener(this.Sg);
        g.CJ();
    }

    private void d(Bundle bundle) {
        this.atj = new ak(this);
        if (bundle != null) {
            this.atj.setStType(bundle.getString("st_type"));
            this.atj.setPid(bundle.getString(com.baidu.tbadk.core.frameworkData.a.PKG_ID));
            this.atj.bD(bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_DOWNLOADING));
        } else {
            this.atj.setStType(getIntent().getStringExtra("st_type"));
            this.atj.setPid(getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.PKG_ID));
            this.atj.bD(getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.IS_DOWNLOADING, false));
            com.baidu.tbadk.core.j.l(this, getIntent().getStringExtra("st_type"));
        }
        this.atj.a(this.ats);
    }

    public void refresh() {
        showProgressBar();
        this.atj.yj();
    }

    private void CU() {
        this.atk.c(this.atr);
    }

    private void CV() {
        this.atk.d(this.atr);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.atj != null && this.atk != null) {
            if (view == this.atk.Dp()) {
                if (!TbadkApplication.isLogin()) {
                    LoginActivity.a((Activity) this, (String) null, true, 11003);
                    return;
                } else if (this.atp) {
                    switch (this.atj.Dd()) {
                        case 2:
                        case 3:
                            com.baidu.tbadk.core.j.l(this, "emotion_package_detail_free");
                            String Db = this.atj.Db();
                            DownloadData downloadData = new DownloadData(this.atj.getPid());
                            downloadData.setStatus(1);
                            downloadData.setStatusMsg(null);
                            downloadData.setType(11);
                            g.CJ().a(downloadData);
                            if (!com.baidu.tbadk.core.util.az.aA(Db)) {
                                if (this.atj.Da() != null && this.atj.Da().faces_list != null) {
                                    m(this.atj.getPid(), this.atj.Da().faces_list.pname, Db);
                                    break;
                                } else {
                                    return;
                                }
                            } else {
                                CW();
                                break;
                            }
                            break;
                        case 4:
                            com.baidu.tbadk.core.j.l(this, "emotion_package_detail_buy");
                            CX();
                            break;
                    }
                } else {
                    return;
                }
            } else if (view == this.atk.Dq()) {
                DownloadData downloadData2 = new DownloadData(this.atj.getPid());
                downloadData2.setStatus(4);
                downloadData2.setStatusMsg(null);
                downloadData2.setType(11);
                g.CJ().a(downloadData2);
                this.atj.bD(false);
                g.CJ().eL(this.atj.getPid());
            }
            super.onClick(view);
        }
    }

    private void CW() {
        this.atl = new ap(this);
        this.atl.eU(this.atj.getPid());
        DownloadData downloadData = new DownloadData(this.atj.getPid());
        downloadData.setType(11);
        downloadData.setStatus(2);
        downloadData.setStatusMsg(getResources().getString(cb.neterror));
        this.atl.setLoadDataCallBack(new ah(this, downloadData));
    }

    public void m(String str, String str2, String str3) {
        g.CJ().l(str, str2, str3);
    }

    public void CX() {
        showProgressBar();
        String pid = this.atj.getPid();
        this.atm = new x(this);
        this.atm.setLoadDataCallBack(new ai(this));
        this.atm.eO(pid);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.atk != null) {
            this.atk.Do();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.atj != null) {
            this.atj.cancelLoadData();
        }
        if (this.atl != null) {
            this.atl.cancelLoadData();
        }
        if (this.atm != null) {
            this.atm.cancelLoadData();
        }
        CV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.atk != null) {
            this.atk.onChangeSkinType(i);
        }
        super.onChangeSkinType(i);
    }

    public void CY() {
        this.atk.Dn();
        CW();
    }

    public void CZ() {
        this.atk.Dm();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && this.atk != null && this.atj != null && this.atj.Da() != null) {
            if (i == 10001) {
                String stringExtra = intent.getStringExtra("tag_order_id");
                if (this.atj.Da().faces_list != null) {
                    if (com.baidu.tbadk.core.util.az.aA(stringExtra)) {
                        stringExtra = this.atj.De();
                    }
                    this.atk.Dl();
                    this.atm = new x(this);
                    this.atm.setLoadDataCallBack(new aj(this));
                    this.atm.eP(stringExtra);
                }
            } else if (i == 11003) {
                if (this.atj.Da().faces_list.can_download == 1) {
                    CW();
                } else {
                    CX();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        l(view, i);
        return true;
    }

    private void l(View view, int i) {
        FacePackageData facePackageData;
        if (view != null) {
            view.getDrawingRect(this.atq);
            ((ViewGroup) getWindow().getDecorView()).offsetDescendantRectToMyCoords(view, this.atq);
            if (this.atj.Da() != null && (facePackageData = this.atj.Da().faces_list) != null) {
                this.atk.a(i, this.atq, facePackageData);
            }
        }
    }

    private boolean b(float f, float f2) {
        float f3 = f - this.atn;
        float f4 = f2 - this.ato;
        return Math.sqrt((double) ((f3 * f3) + (f4 * f4))) > ((double) getResources().getDimensionPixelSize(bx.faceshop_package_face_padding));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.atn = motionEvent.getX();
            this.ato = motionEvent.getY();
        }
        if (this.atk.Dr()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    this.atk.Ds();
                    break;
                case 2:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.atq.set(x, y, x + 1, y + 1);
                    GridView Du = this.atk.Du();
                    ((ViewGroup) getWindow().getDecorView()).offsetRectIntoDescendantCoords(Du, this.atq);
                    int pointToPosition = Du.pointToPosition(this.atq.left, this.atq.top);
                    if (pointToPosition != -1) {
                        View childAt = Du.getChildAt(pointToPosition - Du.getFirstVisiblePosition());
                        if (b(x, y)) {
                            l(childAt, pointToPosition);
                            break;
                        }
                    }
                    break;
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.atk.Dt();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.atj != null) {
            bundle.putString("st_type", this.atj.getStType());
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.PKG_ID, this.atj.getPid());
            bundle.putBoolean(com.baidu.tbadk.core.frameworkData.a.IS_DOWNLOADING, this.atj.Dc());
        }
        super.onSaveInstanceState(bundle);
    }
}
