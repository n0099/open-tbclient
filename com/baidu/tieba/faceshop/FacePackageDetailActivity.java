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
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.FaceBuyData;
import d.a.c.e.p.k;
import d.a.j0.l0.i;
import java.util.List;
/* loaded from: classes4.dex */
public class FacePackageDetailActivity extends ProxyAdkBaseActivity<FacePackageDetailActivity> {

    /* renamed from: e  reason: collision with root package name */
    public FacePackageDetailModel f15458e;

    /* renamed from: f  reason: collision with root package name */
    public i f15459f;

    /* renamed from: g  reason: collision with root package name */
    public FacePackageDownloadModel f15460g;

    /* renamed from: h  reason: collision with root package name */
    public FaceBuyModel f15461h;

    /* renamed from: i  reason: collision with root package name */
    public float f15462i;
    public float j;
    public boolean k = false;
    public final Rect l = new Rect();
    public final NoNetworkView.b m = new a();
    public final ProxyAdkBaseActivity<FacePackageDetailActivity>.LoadDataCallBack n = new b();
    public final CustomMessageListener o = new f(2001118);

    /* loaded from: classes4.dex */
    public class a implements NoNetworkView.b {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z) {
                FacePackageDetailActivity.this.s();
            }
            FacePackageDetailActivity.this.f15459f.c(z);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ProxyAdkBaseActivity<FacePackageDetailActivity>.LoadDataCallBack {
        public b() {
            super();
        }

        @Override // com.baidu.tbadk.ProxyAdkBaseActivity.LoadDataCallBack
        public void callback(Object... objArr) {
            FacePackageDetailActivity.this.hideProgressBar();
            Object obj = objArr[0];
            Boolean bool = (Boolean) objArr[1];
            if (obj != null && (obj instanceof FacePackageDetailData)) {
                if (FacePackageDetailActivity.this.f15459f != null) {
                    FacePackageDetailData facePackageDetailData = (FacePackageDetailData) obj;
                    if (facePackageDetailData.errno == 0 && facePackageDetailData.usermsg != null) {
                        FacePackageDetailActivity.this.f15459f.o(FacePackageDetailActivity.this.f15458e);
                        if (!bool.booleanValue()) {
                            FacePackageDetailActivity.this.k = true;
                            return;
                        } else {
                            FacePackageDetailActivity.this.showProgressBar();
                            return;
                        }
                    }
                    String str = facePackageDetailData.usermsg;
                    if (str != null) {
                        FacePackageDetailActivity.this.showToast(str);
                        return;
                    } else {
                        FacePackageDetailActivity.this.showToast(R.string.neterror);
                        return;
                    }
                }
                return;
            }
            FacePackageDetailActivity.this.showToast(R.string.neterror);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.c.a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DownloadData f15465a;

        public c(DownloadData downloadData) {
            this.f15465a = downloadData;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (obj != null && (obj instanceof FacePackageDownloadData)) {
                FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
                if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
                    String str = facePackageDownloadData.pack_url;
                    FacePackageDetailActivity.this.f15458e.G(str);
                    if (FacePackageDetailActivity.this.f15458e.A() == null || FacePackageDetailActivity.this.f15458e.A().faces_list == null) {
                        return;
                    }
                    FacePackageDetailActivity facePackageDetailActivity = FacePackageDetailActivity.this;
                    facePackageDetailActivity.l(facePackageDetailActivity.f15458e.getPid(), FacePackageDetailActivity.this.f15458e.A().faces_list.pname, str);
                    return;
                }
                String str2 = facePackageDownloadData.usermsg;
                if (str2 != null) {
                    FacePackageDetailActivity.this.showToast(str2);
                    return;
                } else {
                    d.a.j0.l0.f.f().i(this.f15465a);
                    return;
                }
            }
            d.a.j0.l0.f.f().i(this.f15465a);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.a.c.a.e {
        public d() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            FacePackageDetailActivity.this.hideProgressBar();
            if (obj != null && (obj instanceof FaceBuyData)) {
                FaceBuyData faceBuyData = (FaceBuyData) obj;
                if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
                    FaceBuyData.BuyInfo buyInfo = faceBuyData.buy_info;
                    String str = buyInfo.buy_url;
                    String str2 = buyInfo.return_url;
                    if (buyInfo.buy_status != 2) {
                        FacePackageDetailActivity.this.f15458e.J(String.valueOf(faceBuyData.buy_info.order_id));
                        IntentConfig intentConfig = new IntentConfig(FacePackageDetailActivity.this.getActivity());
                        intentConfig.getIntent().putExtra(WebViewActivityConfig.TAG_URL, str);
                        intentConfig.getIntent().putExtra("tag_hook_url", str2);
                        intentConfig.getIntent().putExtra(WebViewActivityConfig.TAG_TITLE, FacePackageDetailActivity.this.getString(R.string.buy_book));
                        intentConfig.getIntent().putExtra("tag_position", 0);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2902013, intentConfig));
                        return;
                    }
                    FacePackageDetailActivity.this.showToast(R.string.has_buy_book);
                    FacePackageData facePackageData = FacePackageDetailActivity.this.f15458e.A().faces_list;
                    facePackageData.buy_status = 1;
                    facePackageData.can_download = 1;
                    FacePackageDetailActivity.this.f15458e.K(facePackageData);
                    FacePackageDetailActivity.this.f15459f.z();
                    return;
                }
                String str3 = faceBuyData.usermsg;
                if (str3 != null) {
                    FacePackageDetailActivity.this.showToast(str3);
                    return;
                } else {
                    FacePackageDetailActivity.this.showToast(R.string.neterror);
                    return;
                }
            }
            FacePackageDetailActivity.this.showToast(R.string.neterror);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends d.a.c.a.e {
        public e() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (obj != null && (obj instanceof FaceBuyQueryData)) {
                FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
                if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                    if (faceBuyQueryData.buy_result.status == 2) {
                        FacePackageDetailActivity.this.r();
                        return;
                    } else {
                        FacePackageDetailActivity.this.q();
                        return;
                    }
                }
                FacePackageDetailActivity.this.q();
                return;
            }
            FacePackageDetailActivity.this.q();
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<DownloadData> data;
            DownloadData downloadData;
            if (FacePackageDetailActivity.this.f15458e == null || FacePackageDetailActivity.this.f15458e.A() == null || FacePackageDetailActivity.this.f15459f == null || customResponsedMessage.getCmd() != 2001118 || !(customResponsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            FacePackageData facePackageData = FacePackageDetailActivity.this.f15458e.A().faces_list;
            if (data.size() >= 1 && (downloadData = data.get(0)) != null && downloadData.getId().equals(FacePackageDetailActivity.this.f15458e.getPid())) {
                int status = downloadData.getStatus();
                if (status == 3 || status == 0) {
                    facePackageData.downloaded = 1;
                    facePackageData.downloading = 0;
                } else if (status == 2 || status == 4) {
                    if (!k.isEmpty(downloadData.getStatusMsg())) {
                        FacePackageDetailActivity.this.showToast(downloadData.getStatusMsg());
                    }
                    if (FacePackageDetailActivity.this.f15460g != null) {
                        FacePackageDetailActivity.this.f15460g.cancelLoadData();
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
            FacePackageDetailActivity.this.f15458e.K(facePackageData);
            FacePackageDetailActivity.this.f15459f.w(FacePackageDetailActivity.this.f15458e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        if (r0 != 3) goto L17;
     */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f15462i = motionEvent.getX();
            this.j = motionEvent.getY();
        }
        i iVar = this.f15459f;
        if (iVar == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (iVar.j()) {
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.l.set(x, y, x + 1, y + 1);
                    GridView g2 = this.f15459f.g();
                    ((ViewGroup) getWindow().getDecorView()).offsetRectIntoDescendantCoords(g2, this.l);
                    Rect rect = this.l;
                    int pointToPosition = g2.pointToPosition(rect.left, rect.top);
                    if (pointToPosition != -1) {
                        View childAt = g2.getChildAt(pointToPosition - g2.getFirstVisiblePosition());
                        if (p(x, y)) {
                            u(childAt, pointToPosition);
                        }
                    }
                }
                return true;
            }
            this.f15459f.d();
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void j() {
        this.f15459f.b(this.m);
    }

    public void k() {
        showProgressBar();
        String pid = this.f15458e.getPid();
        FaceBuyModel faceBuyModel = new FaceBuyModel(getActivity());
        this.f15461h = faceBuyModel;
        faceBuyModel.setLoadDataCallBack(new d());
        this.f15461h.z(pid);
    }

    public void l(String str, String str2, String str3) {
        d.a.j0.l0.f.f().j(str, str2, str3);
    }

    public final void m() {
        FacePackageDownloadModel facePackageDownloadModel = new FacePackageDownloadModel(getActivity());
        this.f15460g = facePackageDownloadModel;
        facePackageDownloadModel.z(this.f15458e.getPid());
        DownloadData downloadData = new DownloadData(this.f15458e.getPid());
        downloadData.setType(11);
        downloadData.setStatus(2);
        downloadData.setStatusMsg(getResources().getString(R.string.neterror));
        this.f15460g.setLoadDataCallBack(new c(downloadData));
    }

    public final void n(Bundle bundle) {
        FacePackageDetailModel facePackageDetailModel = new FacePackageDetailModel(this);
        this.f15458e = facePackageDetailModel;
        if (bundle != null) {
            facePackageDetailModel.setStType(bundle.getString("st_type"));
            this.f15458e.setPid(bundle.getString(IntentConfig.PKG_ID));
            this.f15458e.H(bundle.getBoolean(IntentConfig.IS_DOWNLOADING));
        } else {
            facePackageDetailModel.setStType(getIntent().getStringExtra("st_type"));
            this.f15458e.setPid(getIntent().getStringExtra(IntentConfig.PKG_ID));
            this.f15458e.H(getIntent().getBooleanExtra(IntentConfig.IS_DOWNLOADING, false));
            TiebaStatic.log(getIntent().getStringExtra("st_type"));
        }
        this.f15458e.I(this.n);
    }

    public final void o() {
        this.f15459f = new i(getPageContext());
        j();
        registerListener(this.o);
        d.a.j0.l0.f.f();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        FacePackageDetailModel facePackageDetailModel;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || this.f15459f == null || (facePackageDetailModel = this.f15458e) == null || facePackageDetailModel.A() == null) {
            return;
        }
        if (i2 != 10001) {
            if (i2 == 11003) {
                if (this.f15458e.A().faces_list.can_download == 1) {
                    m();
                    return;
                } else {
                    k();
                    return;
                }
            }
            return;
        }
        String stringExtra = intent.getStringExtra("tag_order_id");
        if (this.f15458e.A().faces_list == null) {
            return;
        }
        if (k.isEmpty(stringExtra)) {
            stringExtra = this.f15458e.D();
        }
        this.f15459f.y();
        FaceBuyModel faceBuyModel = new FaceBuyModel(getActivity());
        this.f15461h = faceBuyModel;
        faceBuyModel.setLoadDataCallBack(new e());
        this.f15461h.A(stringExtra);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        i iVar = this.f15459f;
        if (iVar != null) {
            iVar.l(i2);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        i iVar;
        if (this.f15458e == null || (iVar = this.f15459f) == null) {
            return;
        }
        if (view == iVar.e()) {
            if (!TbadkCoreApplication.isLogin()) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11003)));
                return;
            } else if (!this.k) {
                return;
            } else {
                int E = this.f15458e.E();
                if (E == 2 || E == 3) {
                    TiebaStatic.log("emotion_package_detail_free");
                    String B = this.f15458e.B();
                    DownloadData downloadData = new DownloadData(this.f15458e.getPid());
                    downloadData.setStatus(1);
                    downloadData.setStatusMsg(null);
                    downloadData.setType(11);
                    d.a.j0.l0.f.f().i(downloadData);
                    if (!k.isEmpty(B)) {
                        if (this.f15458e.A() == null || this.f15458e.A().faces_list == null) {
                            return;
                        }
                        l(this.f15458e.getPid(), this.f15458e.A().faces_list.pname, B);
                    } else {
                        m();
                    }
                } else if (E == 4) {
                    TiebaStatic.log("emotion_package_detail_buy");
                    k();
                }
            }
        } else if (view == this.f15459f.f()) {
            DownloadData downloadData2 = new DownloadData(this.f15458e.getPid());
            downloadData2.setStatus(4);
            downloadData2.setStatusMsg(null);
            downloadData2.setType(11);
            d.a.j0.l0.f.f().i(downloadData2);
            this.f15458e.H(false);
            d.a.j0.l0.f.f().e(this.f15458e.getPid());
        }
        super.onClick(view);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n(bundle);
        o();
        s();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        FacePackageDetailModel facePackageDetailModel = this.f15458e;
        if (facePackageDetailModel != null) {
            facePackageDetailModel.cancelLoadData();
        }
        FacePackageDownloadModel facePackageDownloadModel = this.f15460g;
        if (facePackageDownloadModel != null) {
            facePackageDownloadModel.cancelLoadData();
        }
        FaceBuyModel faceBuyModel = this.f15461h;
        if (faceBuyModel != null) {
            faceBuyModel.cancelLoadData();
        }
        t();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i iVar = this.f15459f;
        if (iVar != null) {
            iVar.p();
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
        u(view, i2);
        return true;
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        i iVar = this.f15459f;
        if (iVar != null) {
            iVar.m();
        }
        super.onResume();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        FacePackageDetailModel facePackageDetailModel = this.f15458e;
        if (facePackageDetailModel != null) {
            bundle.putString("st_type", facePackageDetailModel.getStType());
            bundle.putString(IntentConfig.PKG_ID, this.f15458e.getPid());
            bundle.putBoolean(IntentConfig.IS_DOWNLOADING, this.f15458e.C());
        }
        super.onSaveInstanceState(bundle);
    }

    public final boolean p(float f2, float f3) {
        float f4 = f2 - this.f15462i;
        float f5 = f3 - this.j;
        return Math.sqrt((double) ((f4 * f4) + (f5 * f5))) > ((double) getResources().getDimensionPixelSize(R.dimen.ds22));
    }

    public void q() {
        this.f15459f.r();
    }

    public void r() {
        this.f15459f.h();
        m();
    }

    public void s() {
        showProgressBar();
        this.f15458e.F();
    }

    public final void t() {
        this.f15459f.q(this.m);
    }

    public final void u(View view, int i2) {
        FacePackageData facePackageData;
        if (view == null) {
            return;
        }
        view.getDrawingRect(this.l);
        ((ViewGroup) getWindow().getDecorView()).offsetDescendantRectToMyCoords(view, this.l);
        if (this.f15458e.A() == null || (facePackageData = this.f15458e.A().faces_list) == null) {
            return;
        }
        this.f15459f.C(i2, this.l, facePackageData);
    }
}
