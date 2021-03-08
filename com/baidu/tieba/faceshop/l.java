package com.baidu.tieba.faceshop;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class l extends ProxyAdkBaseActivity<l> {
    private float cFL;
    private FacePackageDetailModel iWK;
    private m iWL;
    private FacePackageDownloadModel iWM;
    private FaceBuyModel iWN;
    private float mDownX;
    private boolean iWO = false;
    private final Rect tmpRect = new Rect();
    private final NoNetworkView.a gzW = new NoNetworkView.a() { // from class: com.baidu.tieba.faceshop.l.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                l.this.refresh();
            }
            l.this.iWL.qi(z);
        }
    };
    private final ProxyAdkBaseActivity<l>.LoadDataCallBack iWP = new ProxyAdkBaseActivity<l>.LoadDataCallBack() { // from class: com.baidu.tieba.faceshop.l.2
        @Override // com.baidu.tbadk.ProxyAdkBaseActivity.LoadDataCallBack
        public void callback(Object... objArr) {
            l.this.hideProgressBar();
            Object obj = objArr[0];
            Boolean bool = (Boolean) objArr[1];
            if (obj != null && (obj instanceof FacePackageDetailData)) {
                if (l.this.iWL != null) {
                    FacePackageDetailData facePackageDetailData = (FacePackageDetailData) obj;
                    if (facePackageDetailData.errno == 0 && facePackageDetailData.usermsg != null) {
                        l.this.iWL.g(l.this.iWK);
                        if (!bool.booleanValue()) {
                            l.this.iWO = true;
                            return;
                        } else {
                            l.this.showProgressBar();
                            return;
                        }
                    } else if (facePackageDetailData.usermsg != null) {
                        l.this.showToast(facePackageDetailData.usermsg);
                        return;
                    } else {
                        l.this.showToast(R.string.neterror);
                        return;
                    }
                }
                return;
            }
            l.this.showToast(R.string.neterror);
        }
    };
    private final CustomMessageListener eLa = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.faceshop.l.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<DownloadData> data;
            DownloadData downloadData;
            if (l.this.iWK != null && l.this.iWK.czc() != null && l.this.iWL != null && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null) {
                FacePackageData facePackageData = l.this.iWK.czc().faces_list;
                if (data.size() >= 1 && (downloadData = data.get(0)) != null && downloadData.getId().equals(l.this.iWK.getPid())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        facePackageData.downloaded = 1;
                        facePackageData.downloading = 0;
                    } else if (status == 2 || status == 4) {
                        if (!au.isEmpty(downloadData.getStatusMsg())) {
                            l.this.showToast(downloadData.getStatusMsg());
                        }
                        if (l.this.iWM != null) {
                            l.this.iWM.cancelLoadData();
                        }
                        facePackageData.downloaded = 0;
                        facePackageData.downloading = 0;
                    } else if (status == 1) {
                        facePackageData.downloading = 1;
                        facePackageData.downloaded = 0;
                        facePackageData.downloadTotal = downloadData.getSize();
                        facePackageData.downloadNow = downloadData.getLength();
                    }
                }
                l.this.iWK.a(facePackageData);
                l.this.iWL.i(l.this.iWK);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        initUI();
        refresh();
    }

    private void initUI() {
        this.iWL = new m(getPageContext());
        cyW();
        registerListener(this.eLa);
        f.cyE();
    }

    private void initData(Bundle bundle) {
        this.iWK = new FacePackageDetailModel(this);
        if (bundle != null) {
            this.iWK.setStType(bundle.getString("st_type"));
            this.iWK.setPid(bundle.getString("pkg_id"));
            this.iWK.qh(bundle.getBoolean("is_downloading"));
        } else {
            this.iWK.setStType(getIntent().getStringExtra("st_type"));
            this.iWK.setPid(getIntent().getStringExtra("pkg_id"));
            this.iWK.qh(getIntent().getBooleanExtra("is_downloading", false));
            TiebaStatic.log(getIntent().getStringExtra("st_type"));
        }
        this.iWK.a(this.iWP);
    }

    public void refresh() {
        showProgressBar();
        this.iWK.loadData();
    }

    private void cyW() {
        this.iWL.c(this.gzW);
    }

    private void cyX() {
        this.iWL.d(this.gzW);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iWK != null && this.iWL != null) {
            if (view == this.iWL.czq()) {
                if (!TbadkApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
                    return;
                } else if (this.iWO) {
                    switch (this.iWK.czf()) {
                        case 2:
                        case 3:
                            TiebaStatic.log("emotion_package_detail_free");
                            String czd = this.iWK.czd();
                            DownloadData downloadData = new DownloadData(this.iWK.getPid());
                            downloadData.setStatus(1);
                            downloadData.setStatusMsg(null);
                            downloadData.setType(11);
                            f.cyE().b(downloadData);
                            if (!au.isEmpty(czd)) {
                                if (this.iWK.czc() != null && this.iWK.czc().faces_list != null) {
                                    aH(this.iWK.getPid(), this.iWK.czc().faces_list.pname, czd);
                                    break;
                                } else {
                                    return;
                                }
                            } else {
                                cyY();
                                break;
                            }
                            break;
                        case 4:
                            TiebaStatic.log("emotion_package_detail_buy");
                            cyZ();
                            break;
                    }
                } else {
                    return;
                }
            } else if (view == this.iWL.czr()) {
                DownloadData downloadData2 = new DownloadData(this.iWK.getPid());
                downloadData2.setStatus(4);
                downloadData2.setStatusMsg(null);
                downloadData2.setType(11);
                f.cyE().b(downloadData2);
                this.iWK.qh(false);
                f.cyE().JI(this.iWK.getPid());
            }
            super.onClick(view);
        }
    }

    private void cyY() {
        this.iWM = new FacePackageDownloadModel(getActivity());
        this.iWM.JX(this.iWK.getPid());
        final DownloadData downloadData = new DownloadData(this.iWK.getPid());
        downloadData.setType(11);
        downloadData.setStatus(2);
        downloadData.setStatusMsg(getResources().getString(R.string.neterror));
        this.iWM.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.l.3
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj != null && (obj instanceof FacePackageDownloadData)) {
                    FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
                    if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
                        String str = facePackageDownloadData.pack_url;
                        l.this.iWK.JT(str);
                        if (l.this.iWK.czc() != null && l.this.iWK.czc().faces_list != null) {
                            l.this.aH(l.this.iWK.getPid(), l.this.iWK.czc().faces_list.pname, str);
                            return;
                        }
                        return;
                    } else if (facePackageDownloadData.usermsg != null) {
                        l.this.showToast(facePackageDownloadData.usermsg);
                        return;
                    } else {
                        f.cyE().b(downloadData);
                        return;
                    }
                }
                f.cyE().b(downloadData);
            }
        });
    }

    public void aH(String str, String str2, String str3) {
        f.cyE().aG(str, str2, str3);
    }

    public void cyZ() {
        showProgressBar();
        String pid = this.iWK.getPid();
        this.iWN = new FaceBuyModel(getActivity());
        this.iWN.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.l.4
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                l.this.hideProgressBar();
                if (obj != null && (obj instanceof FaceBuyData)) {
                    FaceBuyData faceBuyData = (FaceBuyData) obj;
                    if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
                        String str = faceBuyData.buy_info.buy_url;
                        String str2 = faceBuyData.buy_info.return_url;
                        if (faceBuyData.buy_info.buy_status != 2) {
                            l.this.iWK.JU(String.valueOf(faceBuyData.buy_info.order_id));
                            IntentConfig intentConfig = new IntentConfig(l.this.getActivity());
                            intentConfig.getIntent().putExtra("tag_url", str);
                            intentConfig.getIntent().putExtra("tag_hook_url", str2);
                            intentConfig.getIntent().putExtra("tag_title", l.this.getString(R.string.buy_book));
                            intentConfig.getIntent().putExtra("tag_position", 0);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEBUYWEBVIEW, intentConfig));
                            return;
                        }
                        l.this.showToast(R.string.has_buy_book);
                        FacePackageData facePackageData = l.this.iWK.czc().faces_list;
                        facePackageData.buy_status = 1;
                        facePackageData.can_download = 1;
                        l.this.iWK.a(facePackageData);
                        l.this.iWL.czk();
                        return;
                    } else if (faceBuyData.usermsg != null) {
                        l.this.showToast(faceBuyData.usermsg);
                        return;
                    } else {
                        l.this.showToast(R.string.neterror);
                        return;
                    }
                }
                l.this.showToast(R.string.neterror);
            }
        });
        this.iWN.JR(pid);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        if (this.iWL != null) {
            this.iWL.czp();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.iWK != null) {
            this.iWK.cancelLoadData();
        }
        if (this.iWM != null) {
            this.iWM.cancelLoadData();
        }
        if (this.iWN != null) {
            this.iWN.cancelLoadData();
        }
        cyX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iWL != null) {
            this.iWL.onChangeSkinType(i);
        }
    }

    public void cza() {
        this.iWL.czo();
        cyY();
    }

    public void czb() {
        this.iWL.czn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && this.iWL != null && this.iWK != null && this.iWK.czc() != null) {
            if (i == 10001) {
                String stringExtra = intent.getStringExtra("tag_order_id");
                if (this.iWK.czc().faces_list != null) {
                    if (au.isEmpty(stringExtra)) {
                        stringExtra = this.iWK.czg();
                    }
                    this.iWL.czm();
                    this.iWN = new FaceBuyModel(getActivity());
                    this.iWN.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.l.5
                        @Override // com.baidu.adp.base.e
                        public void callback(Object obj) {
                            if (obj != null && (obj instanceof FaceBuyQueryData)) {
                                FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
                                if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                                    if (faceBuyQueryData.buy_result.status == 2) {
                                        l.this.cza();
                                        return;
                                    } else {
                                        l.this.czb();
                                        return;
                                    }
                                }
                                l.this.czb();
                                return;
                            }
                            l.this.czb();
                        }
                    });
                    this.iWN.JS(stringExtra);
                }
            } else if (i == 11003) {
                if (this.iWK.czc().faces_list.can_download == 1) {
                    cyY();
                } else {
                    cyZ();
                }
            }
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        w(view, i);
        return true;
    }

    private void w(View view, int i) {
        FacePackageData facePackageData;
        if (view != null) {
            view.getDrawingRect(this.tmpRect);
            ((ViewGroup) getWindow().getDecorView()).offsetDescendantRectToMyCoords(view, this.tmpRect);
            if (this.iWK.czc() != null && (facePackageData = this.iWK.czc().faces_list) != null) {
                this.iWL.a(i, this.tmpRect, facePackageData);
            }
        }
    }

    private boolean F(float f, float f2) {
        float f3 = f - this.mDownX;
        float f4 = f2 - this.cFL;
        return Math.sqrt((double) ((f3 * f3) + (f4 * f4))) > ((double) getResources().getDimensionPixelSize(R.dimen.ds22));
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mDownX = motionEvent.getX();
            this.cFL = motionEvent.getY();
        }
        if (this.iWL == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.iWL.czs()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    this.iWL.czt();
                    break;
                case 2:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.tmpRect.set(x, y, x + 1, y + 1);
                    GridView czv = this.iWL.czv();
                    ((ViewGroup) getWindow().getDecorView()).offsetRectIntoDescendantCoords(czv, this.tmpRect);
                    int pointToPosition = czv.pointToPosition(this.tmpRect.left, this.tmpRect.top);
                    if (pointToPosition != -1) {
                        View childAt = czv.getChildAt(pointToPosition - czv.getFirstVisiblePosition());
                        if (F(x, y)) {
                            w(childAt, pointToPosition);
                            break;
                        }
                    }
                    break;
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.iWL != null) {
            this.iWL.czu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.iWK != null) {
            bundle.putString("st_type", this.iWK.getStType());
            bundle.putString("pkg_id", this.iWK.getPid());
            bundle.putBoolean("is_downloading", this.iWK.cze());
        }
        super.onSaveInstanceState(bundle);
    }
}
