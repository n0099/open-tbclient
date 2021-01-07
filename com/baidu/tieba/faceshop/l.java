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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class l extends ProxyAdkBaseActivity<l> {
    private float cGB;
    private FacePackageDetailModel iTN;
    private m iTO;
    private FacePackageDownloadModel iTP;
    private FaceBuyModel iTQ;
    private float mDownX;
    private boolean iTR = false;
    private final Rect tmpRect = new Rect();
    private final NoNetworkView.a gzW = new NoNetworkView.a() { // from class: com.baidu.tieba.faceshop.l.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                l.this.refresh();
            }
            l.this.iTO.qc(z);
        }
    };
    private final ProxyAdkBaseActivity<l>.LoadDataCallBack iTS = new ProxyAdkBaseActivity<l>.LoadDataCallBack() { // from class: com.baidu.tieba.faceshop.l.2
        @Override // com.baidu.tbadk.ProxyAdkBaseActivity.LoadDataCallBack
        public void callback(Object... objArr) {
            l.this.hideProgressBar();
            Object obj = objArr[0];
            Boolean bool = (Boolean) objArr[1];
            if (obj != null && (obj instanceof FacePackageDetailData)) {
                if (l.this.iTO != null) {
                    FacePackageDetailData facePackageDetailData = (FacePackageDetailData) obj;
                    if (facePackageDetailData.errno == 0 && facePackageDetailData.usermsg != null) {
                        l.this.iTO.g(l.this.iTN);
                        if (!bool.booleanValue()) {
                            l.this.iTR = true;
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
    private final CustomMessageListener eMe = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.faceshop.l.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<DownloadData> data;
            DownloadData downloadData;
            if (l.this.iTN != null && l.this.iTN.cBw() != null && l.this.iTO != null && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null) {
                FacePackageData facePackageData = l.this.iTN.cBw().faces_list;
                if (data.size() >= 1 && (downloadData = data.get(0)) != null && downloadData.getId().equals(l.this.iTN.getPid())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        facePackageData.downloaded = 1;
                        facePackageData.downloading = 0;
                    } else if (status == 2 || status == 4) {
                        if (!at.isEmpty(downloadData.getStatusMsg())) {
                            l.this.showToast(downloadData.getStatusMsg());
                        }
                        if (l.this.iTP != null) {
                            l.this.iTP.cancelLoadData();
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
                l.this.iTN.a(facePackageData);
                l.this.iTO.i(l.this.iTN);
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
        this.iTO = new m(getPageContext());
        cBq();
        registerListener(this.eMe);
        f.cAY();
    }

    private void initData(Bundle bundle) {
        this.iTN = new FacePackageDetailModel(this);
        if (bundle != null) {
            this.iTN.setStType(bundle.getString("st_type"));
            this.iTN.setPid(bundle.getString("pkg_id"));
            this.iTN.qb(bundle.getBoolean("is_downloading"));
        } else {
            this.iTN.setStType(getIntent().getStringExtra("st_type"));
            this.iTN.setPid(getIntent().getStringExtra("pkg_id"));
            this.iTN.qb(getIntent().getBooleanExtra("is_downloading", false));
            TiebaStatic.log(getIntent().getStringExtra("st_type"));
        }
        this.iTN.a(this.iTS);
    }

    public void refresh() {
        showProgressBar();
        this.iTN.loadData();
    }

    private void cBq() {
        this.iTO.c(this.gzW);
    }

    private void cBr() {
        this.iTO.d(this.gzW);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iTN != null && this.iTO != null) {
            if (view == this.iTO.cBK()) {
                if (!TbadkApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
                    return;
                } else if (this.iTR) {
                    switch (this.iTN.cBz()) {
                        case 2:
                        case 3:
                            TiebaStatic.log("emotion_package_detail_free");
                            String cBx = this.iTN.cBx();
                            DownloadData downloadData = new DownloadData(this.iTN.getPid());
                            downloadData.setStatus(1);
                            downloadData.setStatusMsg(null);
                            downloadData.setType(11);
                            f.cAY().b(downloadData);
                            if (!at.isEmpty(cBx)) {
                                if (this.iTN.cBw() != null && this.iTN.cBw().faces_list != null) {
                                    aH(this.iTN.getPid(), this.iTN.cBw().faces_list.pname, cBx);
                                    break;
                                } else {
                                    return;
                                }
                            } else {
                                cBs();
                                break;
                            }
                            break;
                        case 4:
                            TiebaStatic.log("emotion_package_detail_buy");
                            cBt();
                            break;
                    }
                } else {
                    return;
                }
            } else if (view == this.iTO.cBL()) {
                DownloadData downloadData2 = new DownloadData(this.iTN.getPid());
                downloadData2.setStatus(4);
                downloadData2.setStatusMsg(null);
                downloadData2.setType(11);
                f.cAY().b(downloadData2);
                this.iTN.qb(false);
                f.cAY().JY(this.iTN.getPid());
            }
            super.onClick(view);
        }
    }

    private void cBs() {
        this.iTP = new FacePackageDownloadModel(getActivity());
        this.iTP.Kn(this.iTN.getPid());
        final DownloadData downloadData = new DownloadData(this.iTN.getPid());
        downloadData.setType(11);
        downloadData.setStatus(2);
        downloadData.setStatusMsg(getResources().getString(R.string.neterror));
        this.iTP.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.l.3
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj != null && (obj instanceof FacePackageDownloadData)) {
                    FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
                    if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
                        String str = facePackageDownloadData.pack_url;
                        l.this.iTN.Kj(str);
                        if (l.this.iTN.cBw() != null && l.this.iTN.cBw().faces_list != null) {
                            l.this.aH(l.this.iTN.getPid(), l.this.iTN.cBw().faces_list.pname, str);
                            return;
                        }
                        return;
                    } else if (facePackageDownloadData.usermsg != null) {
                        l.this.showToast(facePackageDownloadData.usermsg);
                        return;
                    } else {
                        f.cAY().b(downloadData);
                        return;
                    }
                }
                f.cAY().b(downloadData);
            }
        });
    }

    public void aH(String str, String str2, String str3) {
        f.cAY().aG(str, str2, str3);
    }

    public void cBt() {
        showProgressBar();
        String pid = this.iTN.getPid();
        this.iTQ = new FaceBuyModel(getActivity());
        this.iTQ.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.l.4
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                l.this.hideProgressBar();
                if (obj != null && (obj instanceof FaceBuyData)) {
                    FaceBuyData faceBuyData = (FaceBuyData) obj;
                    if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
                        String str = faceBuyData.buy_info.buy_url;
                        String str2 = faceBuyData.buy_info.return_url;
                        if (faceBuyData.buy_info.buy_status != 2) {
                            l.this.iTN.Kk(String.valueOf(faceBuyData.buy_info.order_id));
                            IntentConfig intentConfig = new IntentConfig(l.this.getActivity());
                            intentConfig.getIntent().putExtra("tag_url", str);
                            intentConfig.getIntent().putExtra("tag_hook_url", str2);
                            intentConfig.getIntent().putExtra("tag_title", l.this.getString(R.string.buy_book));
                            intentConfig.getIntent().putExtra("tag_position", 0);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEBUYWEBVIEW, intentConfig));
                            return;
                        }
                        l.this.showToast(R.string.has_buy_book);
                        FacePackageData facePackageData = l.this.iTN.cBw().faces_list;
                        facePackageData.buy_status = 1;
                        facePackageData.can_download = 1;
                        l.this.iTN.a(facePackageData);
                        l.this.iTO.cBE();
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
        this.iTQ.Kh(pid);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        if (this.iTO != null) {
            this.iTO.cBJ();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.iTN != null) {
            this.iTN.cancelLoadData();
        }
        if (this.iTP != null) {
            this.iTP.cancelLoadData();
        }
        if (this.iTQ != null) {
            this.iTQ.cancelLoadData();
        }
        cBr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iTO != null) {
            this.iTO.onChangeSkinType(i);
        }
    }

    public void cBu() {
        this.iTO.cBI();
        cBs();
    }

    public void cBv() {
        this.iTO.cBH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && this.iTO != null && this.iTN != null && this.iTN.cBw() != null) {
            if (i == 10001) {
                String stringExtra = intent.getStringExtra("tag_order_id");
                if (this.iTN.cBw().faces_list != null) {
                    if (at.isEmpty(stringExtra)) {
                        stringExtra = this.iTN.cBA();
                    }
                    this.iTO.cBG();
                    this.iTQ = new FaceBuyModel(getActivity());
                    this.iTQ.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.l.5
                        @Override // com.baidu.adp.base.e
                        public void callback(Object obj) {
                            if (obj != null && (obj instanceof FaceBuyQueryData)) {
                                FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
                                if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                                    if (faceBuyQueryData.buy_result.status == 2) {
                                        l.this.cBu();
                                        return;
                                    } else {
                                        l.this.cBv();
                                        return;
                                    }
                                }
                                l.this.cBv();
                                return;
                            }
                            l.this.cBv();
                        }
                    });
                    this.iTQ.Ki(stringExtra);
                }
            } else if (i == 11003) {
                if (this.iTN.cBw().faces_list.can_download == 1) {
                    cBs();
                } else {
                    cBt();
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
            if (this.iTN.cBw() != null && (facePackageData = this.iTN.cBw().faces_list) != null) {
                this.iTO.a(i, this.tmpRect, facePackageData);
            }
        }
    }

    private boolean E(float f, float f2) {
        float f3 = f - this.mDownX;
        float f4 = f2 - this.cGB;
        return Math.sqrt((double) ((f3 * f3) + (f4 * f4))) > ((double) getResources().getDimensionPixelSize(R.dimen.ds22));
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mDownX = motionEvent.getX();
            this.cGB = motionEvent.getY();
        }
        if (this.iTO == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.iTO.cBM()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    this.iTO.cBN();
                    break;
                case 2:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.tmpRect.set(x, y, x + 1, y + 1);
                    GridView cBP = this.iTO.cBP();
                    ((ViewGroup) getWindow().getDecorView()).offsetRectIntoDescendantCoords(cBP, this.tmpRect);
                    int pointToPosition = cBP.pointToPosition(this.tmpRect.left, this.tmpRect.top);
                    if (pointToPosition != -1) {
                        View childAt = cBP.getChildAt(pointToPosition - cBP.getFirstVisiblePosition());
                        if (E(x, y)) {
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
        if (this.iTO != null) {
            this.iTO.cBO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.iTN != null) {
            bundle.putString("st_type", this.iTN.getStType());
            bundle.putString("pkg_id", this.iTN.getPid());
            bundle.putBoolean("is_downloading", this.iTN.cBy());
        }
        super.onSaveInstanceState(bundle);
    }
}
