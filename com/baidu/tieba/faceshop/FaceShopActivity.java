package com.baidu.tieba.faceshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import d.b.c.e.p.j;
import d.b.c.e.p.k;
import d.b.i0.r.f0.f;
import d.b.j0.l0.m;
import d.b.j0.l0.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class FaceShopActivity extends ProxyAdkBaseActivity<FaceShopActivity> {

    /* renamed from: e  reason: collision with root package name */
    public n f15353e;

    /* renamed from: f  reason: collision with root package name */
    public FaceShopModel f15354f;

    /* renamed from: g  reason: collision with root package name */
    public FaceBuyModel f15355g;

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<String, DownloadData> f15356h = new HashMap<>();
    public final NoNetworkView.b i = new c();
    public final d.b.c.a.e j = new d();
    public final CustomMessageListener k = new f(0);

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public a() {
        }

        @Override // d.b.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            FaceShopActivity.this.q(false);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BdListView.p {
        public b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            FaceShopActivity.this.n();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements NoNetworkView.b {
        public c() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (!z || FaceShopActivity.this.f15353e == null) {
                return;
            }
            FaceShopActivity.this.f15353e.s();
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.b.c.a.e {
        public d() {
        }

        @Override // d.b.c.a.e
        public void c(Object obj) {
            FaceShopActivity.this.hideProgressBar();
            if (obj != null && (obj instanceof FaceShopData)) {
                if (FaceShopActivity.this.f15353e != null) {
                    FaceShopData faceShopData = (FaceShopData) obj;
                    if (faceShopData.errno == 0 && faceShopData.usermsg != null) {
                        if (FaceShopActivity.this.f15354f.F()) {
                            FaceShopActivity.this.f15353e.r();
                        } else {
                            FaceShopActivity.this.f15353e.f();
                        }
                        FaceShopActivity.this.f15353e.j(faceShopData);
                        return;
                    }
                    String str = faceShopData.usermsg;
                    if (str != null) {
                        FaceShopActivity.this.showToast(str);
                    } else {
                        FaceShopActivity.this.showToast(R.string.neterror);
                    }
                    FaceShopActivity.this.f15353e.b();
                    return;
                }
                return;
            }
            FaceShopActivity.this.showToast(R.string.neterror);
            FaceShopActivity.this.f15353e.b();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends d.b.c.a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f15361a;

        public e(int i) {
            this.f15361a = i;
        }

        @Override // d.b.c.a.e
        public void c(Object obj) {
            if (obj != null && (obj instanceof FaceBuyQueryData)) {
                FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
                if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                    if (faceBuyQueryData.buy_result.status == 2) {
                        FaceShopActivity.this.p(this.f15361a);
                        return;
                    } else {
                        FaceShopActivity.this.o();
                        return;
                    }
                }
                FaceShopActivity.this.o();
                return;
            }
            FaceShopActivity.this.o();
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FaceShopData E;
            m c2;
            if (FaceShopActivity.this.f15354f == null || FaceShopActivity.this.f15353e == null || (E = FaceShopActivity.this.f15354f.E()) == null || E.pack_list == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001118) {
                if (customResponsedMessage instanceof DownloadMessage) {
                    FaceShopActivity.this.f15356h.clear();
                    List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                    if (data == null || (c2 = FaceShopActivity.this.f15353e.c()) == null) {
                        return;
                    }
                    for (DownloadData downloadData : data) {
                        FaceShopActivity.this.f15356h.put(downloadData.getId(), downloadData);
                    }
                    Iterator<FacePackageData> it = E.pack_list.iterator();
                    while (it.hasNext()) {
                        FacePackageData next = it.next();
                        DownloadData downloadData2 = (DownloadData) FaceShopActivity.this.f15356h.get(String.valueOf(next.pid));
                        if (downloadData2 != null) {
                            int status = downloadData2.getStatus();
                            if (status == 3 || status == 0) {
                                next.downloaded = 1;
                                next.downloading = 0;
                            } else if (status == 2 || status == 4) {
                                if (!k.isEmpty(downloadData2.getStatusMsg())) {
                                    FaceShopActivity.this.showToast(downloadData2.getStatusMsg());
                                }
                                c2.h();
                                next.downloaded = 0;
                                next.downloading = 0;
                            } else if (status == 1) {
                                next.downloading = 1;
                                next.downloaded = 0;
                                next.downloadTotal = downloadData2.getSize();
                                next.downloadNow = downloadData2.getLength();
                            }
                        }
                    }
                    c2.n(E);
                }
            } else if (customResponsedMessage.getCmd() == 2001117) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<FacePackageData> it2 = E.pack_list.iterator();
                while (it2.hasNext()) {
                    FacePackageData next2 = it2.next();
                    if (next2.downloaded == 1) {
                        next2.downloaded = 0;
                    }
                    arrayList.add(String.valueOf(next2.pid));
                }
                FaceShopActivity.this.f15353e.i(arrayList);
            }
        }
    }

    public final void k() {
        this.f15353e.a(this.i);
    }

    public final void l(Bundle bundle) {
        String st_type;
        this.f15354f = new FaceShopModel(this);
        if (bundle != null) {
            st_type = FaceShopActivityConfig.getST_TYPE(bundle);
        } else {
            st_type = FaceShopActivityConfig.getST_TYPE(getIntent());
            TiebaStatic.log(st_type);
        }
        this.f15354f.H(st_type);
        this.f15354f.setLoadDataCallBack(this.j);
    }

    public final void m() {
        n nVar = new n(getPageContext());
        this.f15353e = nVar;
        nVar.o(new a());
        this.f15353e.p(new b());
        this.f15353e.m(this);
        k();
        registerListener(2001118, this.k);
        registerListener(2001117, this.k);
        d.b.j0.l0.f.f();
    }

    public final void n() {
        FaceShopModel faceShopModel = this.f15354f;
        if (faceShopModel == null || this.f15353e == null || !faceShopModel.F()) {
            return;
        }
        this.f15353e.n();
        this.f15354f.G(2);
    }

    public void o() {
        this.f15353e.l();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        n nVar;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1 || (nVar = this.f15353e) == null || nVar.c() == null) {
            return;
        }
        if (i == 10000) {
            int intExtra = intent.getIntExtra("tag_position", -1);
            String stringExtra = intent.getStringExtra("tag_order_id");
            FacePackageData facePackageData = (FacePackageData) this.f15353e.c().getItem(intExtra);
            if (facePackageData == null) {
                return;
            }
            if (k.isEmpty(stringExtra)) {
                stringExtra = facePackageData.orderId;
            }
            this.f15353e.q();
            FaceBuyModel faceBuyModel = new FaceBuyModel(getActivity());
            this.f15355g = faceBuyModel;
            faceBuyModel.setLoadDataCallBack(new e(intExtra));
            this.f15355g.A(stringExtra);
        } else if (i != 11003) {
            if (i == 11037) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902012, new IntentConfig(getActivity())));
            }
        } else {
            m c2 = this.f15353e.c();
            int e2 = c2.e();
            if (e2 < 0) {
                return;
            }
            if (((FacePackageData) c2.getItem(e2)).can_download == 1) {
                c2.i(e2);
            } else {
                c2.g(e2);
            }
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        n nVar = this.f15353e;
        if (nVar != null) {
            nVar.g(i);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        n nVar = this.f15353e;
        if (nVar == null) {
            return;
        }
        if (view == nVar.d()) {
            if (!TbadkCoreApplication.isLogin()) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getActivity(), true, 11037)));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2902012, new IntentConfig(getActivity())));
        }
        super.onClick(view);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m();
        l(bundle);
        this.f15353e.s();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        FaceShopModel faceShopModel = this.f15354f;
        if (faceShopModel != null) {
            faceShopModel.cancelLoadData();
        }
        n nVar = this.f15353e;
        if (nVar != null) {
            nVar.c().h();
        }
        FaceBuyModel faceBuyModel = this.f15355g;
        if (faceBuyModel != null) {
            faceBuyModel.cancelLoadData();
        }
        r();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        n nVar;
        m c2;
        FacePackageData facePackageData;
        if (this.f15354f == null || (nVar = this.f15353e) == null || (c2 = nVar.c()) == null) {
            return;
        }
        if (i < c2.getCount() && i >= 0 && (facePackageData = (FacePackageData) c2.getItem(i)) != null) {
            sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(getPageContext().getPageActivity(), String.valueOf(facePackageData.pid), facePackageData.downloading == 1, "face_shop")));
        }
        super.onItemClick(adapterView, view, i, j);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        n nVar = this.f15353e;
        if (nVar != null) {
            nVar.h();
        }
    }

    public void p(int i) {
        FacePackageData facePackageData;
        n nVar = this.f15353e;
        if (nVar == null || nVar.c() == null || (facePackageData = (FacePackageData) this.f15353e.c().getItem(i)) == null) {
            return;
        }
        this.f15353e.e();
        facePackageData.buy_status = 1;
        facePackageData.can_download = 1;
        this.f15353e.c().notifyDataSetChanged();
        this.f15353e.c().i(i);
    }

    public final void q(boolean z) {
        if (j.z()) {
            if (z) {
                showProgressBar();
            }
            this.f15354f.G(1);
            return;
        }
        this.f15353e.b();
    }

    public final void r() {
        this.f15353e.k(this.i);
    }
}
