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
    private ak ata;
    private am atb;
    private ap atc;
    private x atd;
    private float ate;
    private float atf;
    private boolean atg = false;
    private final Rect ath = new Rect();
    private final com.baidu.tbadk.core.view.u ati = new ae(this);
    private final BaseActivity.LoadDataCallBack atj = new af(this, this);
    private final CustomMessageListener Sc = new ag(this, 2001122);

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
        this.atb = new am(this);
        CS();
        registerListener(this.Sc);
        g.CH();
    }

    private void d(Bundle bundle) {
        this.ata = new ak(this);
        if (bundle != null) {
            this.ata.setStType(bundle.getString("st_type"));
            this.ata.setPid(bundle.getString(com.baidu.tbadk.core.frameworkData.a.PKG_ID));
            this.ata.bD(bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_DOWNLOADING));
        } else {
            this.ata.setStType(getIntent().getStringExtra("st_type"));
            this.ata.setPid(getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.PKG_ID));
            this.ata.bD(getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.IS_DOWNLOADING, false));
            com.baidu.tbadk.core.i.l(this, getIntent().getStringExtra("st_type"));
        }
        this.ata.a(this.atj);
    }

    public void refresh() {
        showProgressBar();
        this.ata.yh();
    }

    private void CS() {
        this.atb.c(this.ati);
    }

    private void CT() {
        this.atb.d(this.ati);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ata != null && this.atb != null) {
            if (view == this.atb.Dn()) {
                if (!TbadkApplication.isLogin()) {
                    LoginActivity.a((Activity) this, (String) null, true, 11003);
                    return;
                } else if (this.atg) {
                    switch (this.ata.Db()) {
                        case 2:
                        case 3:
                            com.baidu.tbadk.core.i.l(this, "emotion_package_detail_free");
                            String CZ = this.ata.CZ();
                            DownloadData downloadData = new DownloadData(this.ata.getPid());
                            downloadData.setStatus(1);
                            downloadData.setStatusMsg(null);
                            downloadData.setType(11);
                            g.CH().a(downloadData);
                            if (!com.baidu.tbadk.core.util.ay.aA(CZ)) {
                                if (this.ata.CY() != null && this.ata.CY().faces_list != null) {
                                    m(this.ata.getPid(), this.ata.CY().faces_list.pname, CZ);
                                    break;
                                } else {
                                    return;
                                }
                            } else {
                                CU();
                                break;
                            }
                            break;
                        case 4:
                            com.baidu.tbadk.core.i.l(this, "emotion_package_detail_buy");
                            CV();
                            break;
                    }
                } else {
                    return;
                }
            } else if (view == this.atb.Do()) {
                DownloadData downloadData2 = new DownloadData(this.ata.getPid());
                downloadData2.setStatus(4);
                downloadData2.setStatusMsg(null);
                downloadData2.setType(11);
                g.CH().a(downloadData2);
                this.ata.bD(false);
                g.CH().eL(this.ata.getPid());
            }
            super.onClick(view);
        }
    }

    private void CU() {
        this.atc = new ap(this);
        this.atc.eU(this.ata.getPid());
        DownloadData downloadData = new DownloadData(this.ata.getPid());
        downloadData.setType(11);
        downloadData.setStatus(2);
        downloadData.setStatusMsg(getResources().getString(cb.neterror));
        this.atc.setLoadDataCallBack(new ah(this, downloadData));
    }

    public void m(String str, String str2, String str3) {
        g.CH().l(str, str2, str3);
    }

    public void CV() {
        showProgressBar();
        String pid = this.ata.getPid();
        this.atd = new x(this);
        this.atd.setLoadDataCallBack(new ai(this));
        this.atd.eO(pid);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.atb != null) {
            this.atb.Dm();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ata != null) {
            this.ata.cancelLoadData();
        }
        if (this.atc != null) {
            this.atc.cancelLoadData();
        }
        if (this.atd != null) {
            this.atd.cancelLoadData();
        }
        CT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.atb != null) {
            this.atb.onChangeSkinType(i);
        }
        super.onChangeSkinType(i);
    }

    public void CW() {
        this.atb.Dl();
        CU();
    }

    public void CX() {
        this.atb.Dk();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && this.atb != null && this.ata != null && this.ata.CY() != null) {
            if (i == 10001) {
                String stringExtra = intent.getStringExtra("tag_order_id");
                if (this.ata.CY().faces_list != null) {
                    if (com.baidu.tbadk.core.util.ay.aA(stringExtra)) {
                        stringExtra = this.ata.Dc();
                    }
                    this.atb.Dj();
                    this.atd = new x(this);
                    this.atd.setLoadDataCallBack(new aj(this));
                    this.atd.eP(stringExtra);
                }
            } else if (i == 11003) {
                if (this.ata.CY().faces_list.can_download == 1) {
                    CU();
                } else {
                    CV();
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
            view.getDrawingRect(this.ath);
            ((ViewGroup) getWindow().getDecorView()).offsetDescendantRectToMyCoords(view, this.ath);
            if (this.ata.CY() != null && (facePackageData = this.ata.CY().faces_list) != null) {
                this.atb.a(i, this.ath, facePackageData);
            }
        }
    }

    private boolean b(float f, float f2) {
        float f3 = f - this.ate;
        float f4 = f2 - this.atf;
        return Math.sqrt((double) ((f3 * f3) + (f4 * f4))) > ((double) getResources().getDimensionPixelSize(bx.faceshop_package_face_padding));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.ate = motionEvent.getX();
            this.atf = motionEvent.getY();
        }
        if (this.atb.Dp()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    this.atb.Dq();
                    break;
                case 2:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.ath.set(x, y, x + 1, y + 1);
                    GridView Ds = this.atb.Ds();
                    ((ViewGroup) getWindow().getDecorView()).offsetRectIntoDescendantCoords(Ds, this.ath);
                    int pointToPosition = Ds.pointToPosition(this.ath.left, this.ath.top);
                    if (pointToPosition != -1) {
                        View childAt = Ds.getChildAt(pointToPosition - Ds.getFirstVisiblePosition());
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
        this.atb.Dr();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.ata != null) {
            bundle.putString("st_type", this.ata.getStType());
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.PKG_ID, this.ata.getPid());
            bundle.putBoolean(com.baidu.tbadk.core.frameworkData.a.IS_DOWNLOADING, this.ata.Da());
        }
        super.onSaveInstanceState(bundle);
    }
}
