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
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.n0.r.f0.f;
import d.a.o0.m0.m;
import d.a.o0.m0.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class FaceShopActivity extends ProxyAdkBaseActivity<FaceShopActivity> {

    /* renamed from: e  reason: collision with root package name */
    public n f14858e;

    /* renamed from: f  reason: collision with root package name */
    public FaceShopModel f14859f;

    /* renamed from: g  reason: collision with root package name */
    public FaceBuyModel f14860g;

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<String, DownloadData> f14861h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public final NoNetworkView.b f14862i = new c();
    public final d.a.c.a.e j = new d();
    public final CustomMessageListener k = new f(0);

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public a() {
        }

        @Override // d.a.n0.r.f0.f.g
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
            if (!z || FaceShopActivity.this.f14858e == null) {
                return;
            }
            FaceShopActivity.this.f14858e.s();
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.a.c.a.e {
        public d() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            FaceShopActivity.this.hideProgressBar();
            if (obj != null && (obj instanceof FaceShopData)) {
                if (FaceShopActivity.this.f14858e != null) {
                    FaceShopData faceShopData = (FaceShopData) obj;
                    if (faceShopData.errno == 0 && faceShopData.usermsg != null) {
                        if (FaceShopActivity.this.f14859f.J()) {
                            FaceShopActivity.this.f14858e.r();
                        } else {
                            FaceShopActivity.this.f14858e.f();
                        }
                        FaceShopActivity.this.f14858e.j(faceShopData);
                        return;
                    }
                    String str = faceShopData.usermsg;
                    if (str != null) {
                        FaceShopActivity.this.showToast(str);
                    } else {
                        FaceShopActivity.this.showToast(R.string.neterror);
                    }
                    FaceShopActivity.this.f14858e.b();
                    return;
                }
                return;
            }
            FaceShopActivity.this.showToast(R.string.neterror);
            FaceShopActivity.this.f14858e.b();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends d.a.c.a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f14867a;

        public e(int i2) {
            this.f14867a = i2;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (obj != null && (obj instanceof FaceBuyQueryData)) {
                FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
                if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                    if (faceBuyQueryData.buy_result.status == 2) {
                        FaceShopActivity.this.p(this.f14867a);
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
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FaceShopData I;
            m c2;
            if (FaceShopActivity.this.f14859f == null || FaceShopActivity.this.f14858e == null || (I = FaceShopActivity.this.f14859f.I()) == null || I.pack_list == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001118) {
                if (customResponsedMessage instanceof DownloadMessage) {
                    FaceShopActivity.this.f14861h.clear();
                    List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                    if (data == null || (c2 = FaceShopActivity.this.f14858e.c()) == null) {
                        return;
                    }
                    for (DownloadData downloadData : data) {
                        FaceShopActivity.this.f14861h.put(downloadData.getId(), downloadData);
                    }
                    Iterator<FacePackageData> it = I.pack_list.iterator();
                    while (it.hasNext()) {
                        FacePackageData next = it.next();
                        DownloadData downloadData2 = (DownloadData) FaceShopActivity.this.f14861h.get(String.valueOf(next.pid));
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
                    c2.n(I);
                }
            } else if (customResponsedMessage.getCmd() == 2001117) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<FacePackageData> it2 = I.pack_list.iterator();
                while (it2.hasNext()) {
                    FacePackageData next2 = it2.next();
                    if (next2.downloaded == 1) {
                        next2.downloaded = 0;
                    }
                    arrayList.add(String.valueOf(next2.pid));
                }
                FaceShopActivity.this.f14858e.i(arrayList);
            }
        }
    }

    public final void k() {
        this.f14858e.a(this.f14862i);
    }

    public final void l(Bundle bundle) {
        String st_type;
        this.f14859f = new FaceShopModel(this);
        if (bundle != null) {
            st_type = FaceShopActivityConfig.getST_TYPE(bundle);
        } else {
            st_type = FaceShopActivityConfig.getST_TYPE(getIntent());
            TiebaStatic.log(st_type);
        }
        this.f14859f.L(st_type);
        this.f14859f.setLoadDataCallBack(this.j);
    }

    public final void m() {
        n nVar = new n(getPageContext());
        this.f14858e = nVar;
        nVar.o(new a());
        this.f14858e.p(new b());
        this.f14858e.m(this);
        k();
        registerListener(2001118, this.k);
        registerListener(2001117, this.k);
        d.a.o0.m0.f.f();
    }

    public final void n() {
        FaceShopModel faceShopModel = this.f14859f;
        if (faceShopModel == null || this.f14858e == null || !faceShopModel.J()) {
            return;
        }
        this.f14858e.n();
        this.f14859f.K(2);
    }

    public void o() {
        this.f14858e.l();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        n nVar;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || (nVar = this.f14858e) == null || nVar.c() == null) {
            return;
        }
        if (i2 == 10000) {
            int intExtra = intent.getIntExtra("tag_position", -1);
            String stringExtra = intent.getStringExtra("tag_order_id");
            FacePackageData facePackageData = (FacePackageData) this.f14858e.c().getItem(intExtra);
            if (facePackageData == null) {
                return;
            }
            if (k.isEmpty(stringExtra)) {
                stringExtra = facePackageData.orderId;
            }
            this.f14858e.q();
            FaceBuyModel faceBuyModel = new FaceBuyModel(getActivity());
            this.f14860g = faceBuyModel;
            faceBuyModel.setLoadDataCallBack(new e(intExtra));
            this.f14860g.E(stringExtra);
        } else if (i2 != 11003) {
            if (i2 == 11037) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902012, new IntentConfig(getActivity())));
            }
        } else {
            m c2 = this.f14858e.c();
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
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        n nVar = this.f14858e;
        if (nVar != null) {
            nVar.g(i2);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        n nVar = this.f14858e;
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
        this.f14858e.s();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        FaceShopModel faceShopModel = this.f14859f;
        if (faceShopModel != null) {
            faceShopModel.cancelLoadData();
        }
        n nVar = this.f14858e;
        if (nVar != null) {
            nVar.c().h();
        }
        FaceBuyModel faceBuyModel = this.f14860g;
        if (faceBuyModel != null) {
            faceBuyModel.cancelLoadData();
        }
        r();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        n nVar;
        m c2;
        FacePackageData facePackageData;
        if (this.f14859f == null || (nVar = this.f14858e) == null || (c2 = nVar.c()) == null) {
            return;
        }
        if (i2 < c2.getCount() && i2 >= 0 && (facePackageData = (FacePackageData) c2.getItem(i2)) != null) {
            sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(getPageContext().getPageActivity(), String.valueOf(facePackageData.pid), facePackageData.downloading == 1, "face_shop")));
        }
        super.onItemClick(adapterView, view, i2, j);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        n nVar = this.f14858e;
        if (nVar != null) {
            nVar.h();
        }
    }

    public void p(int i2) {
        FacePackageData facePackageData;
        n nVar = this.f14858e;
        if (nVar == null || nVar.c() == null || (facePackageData = (FacePackageData) this.f14858e.c().getItem(i2)) == null) {
            return;
        }
        this.f14858e.e();
        facePackageData.buy_status = 1;
        facePackageData.can_download = 1;
        this.f14858e.c().notifyDataSetChanged();
        this.f14858e.c().i(i2);
    }

    public final void q(boolean z) {
        if (j.z()) {
            if (z) {
                showProgressBar();
            }
            this.f14859f.K(1);
            return;
        }
        this.f14858e.b();
    }

    public final void r() {
        this.f14858e.k(this.f14862i);
    }
}
