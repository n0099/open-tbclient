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
/* loaded from: classes8.dex */
public class l extends ProxyAdkBaseActivity<l> {
    private float cBP;
    private FacePackageDetailModel iPg;
    private m iPh;
    private FacePackageDownloadModel iPi;
    private FaceBuyModel iPj;
    private float mDownX;
    private boolean iPk = false;
    private final Rect tmpRect = new Rect();
    private final NoNetworkView.a gvp = new NoNetworkView.a() { // from class: com.baidu.tieba.faceshop.l.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                l.this.refresh();
            }
            l.this.iPh.pY(z);
        }
    };
    private final ProxyAdkBaseActivity<l>.LoadDataCallBack iPl = new ProxyAdkBaseActivity<l>.LoadDataCallBack() { // from class: com.baidu.tieba.faceshop.l.2
        @Override // com.baidu.tbadk.ProxyAdkBaseActivity.LoadDataCallBack
        public void callback(Object... objArr) {
            l.this.hideProgressBar();
            Object obj = objArr[0];
            Boolean bool = (Boolean) objArr[1];
            if (obj != null && (obj instanceof FacePackageDetailData)) {
                if (l.this.iPh != null) {
                    FacePackageDetailData facePackageDetailData = (FacePackageDetailData) obj;
                    if (facePackageDetailData.errno == 0 && facePackageDetailData.usermsg != null) {
                        l.this.iPh.g(l.this.iPg);
                        if (!bool.booleanValue()) {
                            l.this.iPk = true;
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
    private final CustomMessageListener eHt = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.faceshop.l.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<DownloadData> data;
            DownloadData downloadData;
            if (l.this.iPg != null && l.this.iPg.cxE() != null && l.this.iPh != null && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null) {
                FacePackageData facePackageData = l.this.iPg.cxE().faces_list;
                if (data.size() >= 1 && (downloadData = data.get(0)) != null && downloadData.getId().equals(l.this.iPg.getPid())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        facePackageData.downloaded = 1;
                        facePackageData.downloading = 0;
                    } else if (status == 2 || status == 4) {
                        if (!at.isEmpty(downloadData.getStatusMsg())) {
                            l.this.showToast(downloadData.getStatusMsg());
                        }
                        if (l.this.iPi != null) {
                            l.this.iPi.cancelLoadData();
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
                l.this.iPg.a(facePackageData);
                l.this.iPh.i(l.this.iPg);
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
        this.iPh = new m(getPageContext());
        cxy();
        registerListener(this.eHt);
        f.cxg();
    }

    private void initData(Bundle bundle) {
        this.iPg = new FacePackageDetailModel(this);
        if (bundle != null) {
            this.iPg.setStType(bundle.getString("st_type"));
            this.iPg.setPid(bundle.getString("pkg_id"));
            this.iPg.pX(bundle.getBoolean("is_downloading"));
        } else {
            this.iPg.setStType(getIntent().getStringExtra("st_type"));
            this.iPg.setPid(getIntent().getStringExtra("pkg_id"));
            this.iPg.pX(getIntent().getBooleanExtra("is_downloading", false));
            TiebaStatic.log(getIntent().getStringExtra("st_type"));
        }
        this.iPg.a(this.iPl);
    }

    public void refresh() {
        showProgressBar();
        this.iPg.loadData();
    }

    private void cxy() {
        this.iPh.c(this.gvp);
    }

    private void cxz() {
        this.iPh.d(this.gvp);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iPg != null && this.iPh != null) {
            if (view == this.iPh.cxS()) {
                if (!TbadkApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
                    return;
                } else if (this.iPk) {
                    switch (this.iPg.cxH()) {
                        case 2:
                        case 3:
                            TiebaStatic.log("emotion_package_detail_free");
                            String cxF = this.iPg.cxF();
                            DownloadData downloadData = new DownloadData(this.iPg.getPid());
                            downloadData.setStatus(1);
                            downloadData.setStatusMsg(null);
                            downloadData.setType(11);
                            f.cxg().b(downloadData);
                            if (!at.isEmpty(cxF)) {
                                if (this.iPg.cxE() != null && this.iPg.cxE().faces_list != null) {
                                    aG(this.iPg.getPid(), this.iPg.cxE().faces_list.pname, cxF);
                                    break;
                                } else {
                                    return;
                                }
                            } else {
                                cxA();
                                break;
                            }
                            break;
                        case 4:
                            TiebaStatic.log("emotion_package_detail_buy");
                            cxB();
                            break;
                    }
                } else {
                    return;
                }
            } else if (view == this.iPh.cxT()) {
                DownloadData downloadData2 = new DownloadData(this.iPg.getPid());
                downloadData2.setStatus(4);
                downloadData2.setStatusMsg(null);
                downloadData2.setType(11);
                f.cxg().b(downloadData2);
                this.iPg.pX(false);
                f.cxg().IN(this.iPg.getPid());
            }
            super.onClick(view);
        }
    }

    private void cxA() {
        this.iPi = new FacePackageDownloadModel(getActivity());
        this.iPi.Jc(this.iPg.getPid());
        final DownloadData downloadData = new DownloadData(this.iPg.getPid());
        downloadData.setType(11);
        downloadData.setStatus(2);
        downloadData.setStatusMsg(getResources().getString(R.string.neterror));
        this.iPi.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.l.3
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj != null && (obj instanceof FacePackageDownloadData)) {
                    FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
                    if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
                        String str = facePackageDownloadData.pack_url;
                        l.this.iPg.IY(str);
                        if (l.this.iPg.cxE() != null && l.this.iPg.cxE().faces_list != null) {
                            l.this.aG(l.this.iPg.getPid(), l.this.iPg.cxE().faces_list.pname, str);
                            return;
                        }
                        return;
                    } else if (facePackageDownloadData.usermsg != null) {
                        l.this.showToast(facePackageDownloadData.usermsg);
                        return;
                    } else {
                        f.cxg().b(downloadData);
                        return;
                    }
                }
                f.cxg().b(downloadData);
            }
        });
    }

    public void aG(String str, String str2, String str3) {
        f.cxg().aF(str, str2, str3);
    }

    public void cxB() {
        showProgressBar();
        String pid = this.iPg.getPid();
        this.iPj = new FaceBuyModel(getActivity());
        this.iPj.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.l.4
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                l.this.hideProgressBar();
                if (obj != null && (obj instanceof FaceBuyData)) {
                    FaceBuyData faceBuyData = (FaceBuyData) obj;
                    if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
                        String str = faceBuyData.buy_info.buy_url;
                        String str2 = faceBuyData.buy_info.return_url;
                        if (faceBuyData.buy_info.buy_status != 2) {
                            l.this.iPg.IZ(String.valueOf(faceBuyData.buy_info.order_id));
                            IntentConfig intentConfig = new IntentConfig(l.this.getActivity());
                            intentConfig.getIntent().putExtra("tag_url", str);
                            intentConfig.getIntent().putExtra("tag_hook_url", str2);
                            intentConfig.getIntent().putExtra("tag_title", l.this.getString(R.string.buy_book));
                            intentConfig.getIntent().putExtra("tag_position", 0);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEBUYWEBVIEW, intentConfig));
                            return;
                        }
                        l.this.showToast(R.string.has_buy_book);
                        FacePackageData facePackageData = l.this.iPg.cxE().faces_list;
                        facePackageData.buy_status = 1;
                        facePackageData.can_download = 1;
                        l.this.iPg.a(facePackageData);
                        l.this.iPh.cxM();
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
        this.iPj.IW(pid);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        if (this.iPh != null) {
            this.iPh.cxR();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.iPg != null) {
            this.iPg.cancelLoadData();
        }
        if (this.iPi != null) {
            this.iPi.cancelLoadData();
        }
        if (this.iPj != null) {
            this.iPj.cancelLoadData();
        }
        cxz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iPh != null) {
            this.iPh.onChangeSkinType(i);
        }
    }

    public void cxC() {
        this.iPh.cxQ();
        cxA();
    }

    public void cxD() {
        this.iPh.cxP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && this.iPh != null && this.iPg != null && this.iPg.cxE() != null) {
            if (i == 10001) {
                String stringExtra = intent.getStringExtra("tag_order_id");
                if (this.iPg.cxE().faces_list != null) {
                    if (at.isEmpty(stringExtra)) {
                        stringExtra = this.iPg.cxI();
                    }
                    this.iPh.cxO();
                    this.iPj = new FaceBuyModel(getActivity());
                    this.iPj.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.l.5
                        @Override // com.baidu.adp.base.e
                        public void callback(Object obj) {
                            if (obj != null && (obj instanceof FaceBuyQueryData)) {
                                FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
                                if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                                    if (faceBuyQueryData.buy_result.status == 2) {
                                        l.this.cxC();
                                        return;
                                    } else {
                                        l.this.cxD();
                                        return;
                                    }
                                }
                                l.this.cxD();
                                return;
                            }
                            l.this.cxD();
                        }
                    });
                    this.iPj.IX(stringExtra);
                }
            } else if (i == 11003) {
                if (this.iPg.cxE().faces_list.can_download == 1) {
                    cxA();
                } else {
                    cxB();
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
            if (this.iPg.cxE() != null && (facePackageData = this.iPg.cxE().faces_list) != null) {
                this.iPh.a(i, this.tmpRect, facePackageData);
            }
        }
    }

    private boolean F(float f, float f2) {
        float f3 = f - this.mDownX;
        float f4 = f2 - this.cBP;
        return Math.sqrt((double) ((f3 * f3) + (f4 * f4))) > ((double) getResources().getDimensionPixelSize(R.dimen.ds22));
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mDownX = motionEvent.getX();
            this.cBP = motionEvent.getY();
        }
        if (this.iPh == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.iPh.cxU()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    this.iPh.cxV();
                    break;
                case 2:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.tmpRect.set(x, y, x + 1, y + 1);
                    GridView cxX = this.iPh.cxX();
                    ((ViewGroup) getWindow().getDecorView()).offsetRectIntoDescendantCoords(cxX, this.tmpRect);
                    int pointToPosition = cxX.pointToPosition(this.tmpRect.left, this.tmpRect.top);
                    if (pointToPosition != -1) {
                        View childAt = cxX.getChildAt(pointToPosition - cxX.getFirstVisiblePosition());
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
        if (this.iPh != null) {
            this.iPh.cxW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.iPg != null) {
            bundle.putString("st_type", this.iPg.getStType());
            bundle.putString("pkg_id", this.iPg.getPid());
            bundle.putBoolean("is_downloading", this.iPg.cxG());
        }
        super.onSaveInstanceState(bundle);
    }
}
