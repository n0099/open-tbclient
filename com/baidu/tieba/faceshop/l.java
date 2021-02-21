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
/* loaded from: classes9.dex */
public class l extends ProxyAdkBaseActivity<l> {
    private float cEl;
    private FacePackageDetailModel iVb;
    private m iVc;
    private FacePackageDownloadModel iVd;
    private FaceBuyModel iVe;
    private float mDownX;
    private boolean iVf = false;
    private final Rect tmpRect = new Rect();
    private final NoNetworkView.a gyn = new NoNetworkView.a() { // from class: com.baidu.tieba.faceshop.l.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                l.this.refresh();
            }
            l.this.iVc.qi(z);
        }
    };
    private final ProxyAdkBaseActivity<l>.LoadDataCallBack iVg = new ProxyAdkBaseActivity<l>.LoadDataCallBack() { // from class: com.baidu.tieba.faceshop.l.2
        @Override // com.baidu.tbadk.ProxyAdkBaseActivity.LoadDataCallBack
        public void callback(Object... objArr) {
            l.this.hideProgressBar();
            Object obj = objArr[0];
            Boolean bool = (Boolean) objArr[1];
            if (obj != null && (obj instanceof FacePackageDetailData)) {
                if (l.this.iVc != null) {
                    FacePackageDetailData facePackageDetailData = (FacePackageDetailData) obj;
                    if (facePackageDetailData.errno == 0 && facePackageDetailData.usermsg != null) {
                        l.this.iVc.g(l.this.iVb);
                        if (!bool.booleanValue()) {
                            l.this.iVf = true;
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
    private final CustomMessageListener eJz = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.faceshop.l.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<DownloadData> data;
            DownloadData downloadData;
            if (l.this.iVb != null && l.this.iVb.cyW() != null && l.this.iVc != null && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null) {
                FacePackageData facePackageData = l.this.iVb.cyW().faces_list;
                if (data.size() >= 1 && (downloadData = data.get(0)) != null && downloadData.getId().equals(l.this.iVb.getPid())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        facePackageData.downloaded = 1;
                        facePackageData.downloading = 0;
                    } else if (status == 2 || status == 4) {
                        if (!au.isEmpty(downloadData.getStatusMsg())) {
                            l.this.showToast(downloadData.getStatusMsg());
                        }
                        if (l.this.iVd != null) {
                            l.this.iVd.cancelLoadData();
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
                l.this.iVb.a(facePackageData);
                l.this.iVc.i(l.this.iVb);
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
        this.iVc = new m(getPageContext());
        cyQ();
        registerListener(this.eJz);
        f.cyy();
    }

    private void initData(Bundle bundle) {
        this.iVb = new FacePackageDetailModel(this);
        if (bundle != null) {
            this.iVb.setStType(bundle.getString("st_type"));
            this.iVb.setPid(bundle.getString("pkg_id"));
            this.iVb.qh(bundle.getBoolean("is_downloading"));
        } else {
            this.iVb.setStType(getIntent().getStringExtra("st_type"));
            this.iVb.setPid(getIntent().getStringExtra("pkg_id"));
            this.iVb.qh(getIntent().getBooleanExtra("is_downloading", false));
            TiebaStatic.log(getIntent().getStringExtra("st_type"));
        }
        this.iVb.a(this.iVg);
    }

    public void refresh() {
        showProgressBar();
        this.iVb.loadData();
    }

    private void cyQ() {
        this.iVc.c(this.gyn);
    }

    private void cyR() {
        this.iVc.d(this.gyn);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iVb != null && this.iVc != null) {
            if (view == this.iVc.czk()) {
                if (!TbadkApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
                    return;
                } else if (this.iVf) {
                    switch (this.iVb.cyZ()) {
                        case 2:
                        case 3:
                            TiebaStatic.log("emotion_package_detail_free");
                            String cyX = this.iVb.cyX();
                            DownloadData downloadData = new DownloadData(this.iVb.getPid());
                            downloadData.setStatus(1);
                            downloadData.setStatusMsg(null);
                            downloadData.setType(11);
                            f.cyy().b(downloadData);
                            if (!au.isEmpty(cyX)) {
                                if (this.iVb.cyW() != null && this.iVb.cyW().faces_list != null) {
                                    aH(this.iVb.getPid(), this.iVb.cyW().faces_list.pname, cyX);
                                    break;
                                } else {
                                    return;
                                }
                            } else {
                                cyS();
                                break;
                            }
                            break;
                        case 4:
                            TiebaStatic.log("emotion_package_detail_buy");
                            cyT();
                            break;
                    }
                } else {
                    return;
                }
            } else if (view == this.iVc.czl()) {
                DownloadData downloadData2 = new DownloadData(this.iVb.getPid());
                downloadData2.setStatus(4);
                downloadData2.setStatusMsg(null);
                downloadData2.setType(11);
                f.cyy().b(downloadData2);
                this.iVb.qh(false);
                f.cyy().Jz(this.iVb.getPid());
            }
            super.onClick(view);
        }
    }

    private void cyS() {
        this.iVd = new FacePackageDownloadModel(getActivity());
        this.iVd.JO(this.iVb.getPid());
        final DownloadData downloadData = new DownloadData(this.iVb.getPid());
        downloadData.setType(11);
        downloadData.setStatus(2);
        downloadData.setStatusMsg(getResources().getString(R.string.neterror));
        this.iVd.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.l.3
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj != null && (obj instanceof FacePackageDownloadData)) {
                    FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
                    if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
                        String str = facePackageDownloadData.pack_url;
                        l.this.iVb.JK(str);
                        if (l.this.iVb.cyW() != null && l.this.iVb.cyW().faces_list != null) {
                            l.this.aH(l.this.iVb.getPid(), l.this.iVb.cyW().faces_list.pname, str);
                            return;
                        }
                        return;
                    } else if (facePackageDownloadData.usermsg != null) {
                        l.this.showToast(facePackageDownloadData.usermsg);
                        return;
                    } else {
                        f.cyy().b(downloadData);
                        return;
                    }
                }
                f.cyy().b(downloadData);
            }
        });
    }

    public void aH(String str, String str2, String str3) {
        f.cyy().aG(str, str2, str3);
    }

    public void cyT() {
        showProgressBar();
        String pid = this.iVb.getPid();
        this.iVe = new FaceBuyModel(getActivity());
        this.iVe.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.l.4
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                l.this.hideProgressBar();
                if (obj != null && (obj instanceof FaceBuyData)) {
                    FaceBuyData faceBuyData = (FaceBuyData) obj;
                    if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
                        String str = faceBuyData.buy_info.buy_url;
                        String str2 = faceBuyData.buy_info.return_url;
                        if (faceBuyData.buy_info.buy_status != 2) {
                            l.this.iVb.JL(String.valueOf(faceBuyData.buy_info.order_id));
                            IntentConfig intentConfig = new IntentConfig(l.this.getActivity());
                            intentConfig.getIntent().putExtra("tag_url", str);
                            intentConfig.getIntent().putExtra("tag_hook_url", str2);
                            intentConfig.getIntent().putExtra("tag_title", l.this.getString(R.string.buy_book));
                            intentConfig.getIntent().putExtra("tag_position", 0);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEBUYWEBVIEW, intentConfig));
                            return;
                        }
                        l.this.showToast(R.string.has_buy_book);
                        FacePackageData facePackageData = l.this.iVb.cyW().faces_list;
                        facePackageData.buy_status = 1;
                        facePackageData.can_download = 1;
                        l.this.iVb.a(facePackageData);
                        l.this.iVc.cze();
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
        this.iVe.JI(pid);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        if (this.iVc != null) {
            this.iVc.czj();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.iVb != null) {
            this.iVb.cancelLoadData();
        }
        if (this.iVd != null) {
            this.iVd.cancelLoadData();
        }
        if (this.iVe != null) {
            this.iVe.cancelLoadData();
        }
        cyR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iVc != null) {
            this.iVc.onChangeSkinType(i);
        }
    }

    public void cyU() {
        this.iVc.czi();
        cyS();
    }

    public void cyV() {
        this.iVc.czh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && this.iVc != null && this.iVb != null && this.iVb.cyW() != null) {
            if (i == 10001) {
                String stringExtra = intent.getStringExtra("tag_order_id");
                if (this.iVb.cyW().faces_list != null) {
                    if (au.isEmpty(stringExtra)) {
                        stringExtra = this.iVb.cza();
                    }
                    this.iVc.czg();
                    this.iVe = new FaceBuyModel(getActivity());
                    this.iVe.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.l.5
                        @Override // com.baidu.adp.base.e
                        public void callback(Object obj) {
                            if (obj != null && (obj instanceof FaceBuyQueryData)) {
                                FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
                                if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                                    if (faceBuyQueryData.buy_result.status == 2) {
                                        l.this.cyU();
                                        return;
                                    } else {
                                        l.this.cyV();
                                        return;
                                    }
                                }
                                l.this.cyV();
                                return;
                            }
                            l.this.cyV();
                        }
                    });
                    this.iVe.JJ(stringExtra);
                }
            } else if (i == 11003) {
                if (this.iVb.cyW().faces_list.can_download == 1) {
                    cyS();
                } else {
                    cyT();
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
            if (this.iVb.cyW() != null && (facePackageData = this.iVb.cyW().faces_list) != null) {
                this.iVc.a(i, this.tmpRect, facePackageData);
            }
        }
    }

    private boolean F(float f, float f2) {
        float f3 = f - this.mDownX;
        float f4 = f2 - this.cEl;
        return Math.sqrt((double) ((f3 * f3) + (f4 * f4))) > ((double) getResources().getDimensionPixelSize(R.dimen.ds22));
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mDownX = motionEvent.getX();
            this.cEl = motionEvent.getY();
        }
        if (this.iVc == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.iVc.czm()) {
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    this.iVc.czn();
                    break;
                case 2:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.tmpRect.set(x, y, x + 1, y + 1);
                    GridView czp = this.iVc.czp();
                    ((ViewGroup) getWindow().getDecorView()).offsetRectIntoDescendantCoords(czp, this.tmpRect);
                    int pointToPosition = czp.pointToPosition(this.tmpRect.left, this.tmpRect.top);
                    if (pointToPosition != -1) {
                        View childAt = czp.getChildAt(pointToPosition - czp.getFirstVisiblePosition());
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
        if (this.iVc != null) {
            this.iVc.czo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.iVb != null) {
            bundle.putString("st_type", this.iVb.getStType());
            bundle.putString("pkg_id", this.iVb.getPid());
            bundle.putBoolean("is_downloading", this.iVb.cyY());
        }
        super.onSaveInstanceState(bundle);
    }
}
