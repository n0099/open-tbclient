package com.baidu.tieba.faceshop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.by;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FaceShopActivity extends com.baidu.tieba.f implements com.baidu.tieba.im.messageCenter.g {
    private be a;
    private bc b;
    private j c;
    private HashMap<String, com.baidu.tieba.d.a> d = new HashMap<>();
    private by e = new ar(this);
    private com.baidu.adp.a.g f = new as(this);

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, FaceShopActivity.class);
        intent.putExtra("st_type", str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        String stringExtra;
        super.onCreate(bundle);
        this.a = new be(this);
        this.a.a(new at(this));
        this.a.a(new au(this));
        this.a.a(this);
        this.a.a(this.e);
        com.baidu.tieba.im.messageCenter.d.a().a(-122, this);
        com.baidu.tieba.im.messageCenter.d.a().a(-120, this);
        com.baidu.tieba.d.d.a();
        this.b = new bc();
        if (bundle != null) {
            stringExtra = bundle.getString("st_type");
        } else {
            stringExtra = getIntent().getStringExtra("st_type");
            com.baidu.tieba.ai.a(this, stringExtra);
        }
        this.b.a(stringExtra);
        this.b.setLoadDataCallBack(this.f);
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (UtilHelper.b()) {
            if (z) {
                showProgressBar();
            }
            this.b.a(1);
            return;
        }
        this.a.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(FaceShopActivity faceShopActivity) {
        if (faceShopActivity.b == null || faceShopActivity.a == null || !faceShopActivity.b.b()) {
            return;
        }
        faceShopActivity.a.c();
        faceShopActivity.b.a(2);
    }

    @Override // com.baidu.adp.a.a, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        aw a;
        FacePackageData facePackageData;
        if (this.b != null && this.a != null && (a = this.a.a()) != null) {
            if (i < a.getCount() && i >= 0 && (facePackageData = (FacePackageData) a.getItem(i)) != null) {
                FacePackageDetailActivity.a(this, String.valueOf(facePackageData.pid), facePackageData.downloading == 1, "face_shop");
            }
            super.onItemClick(adapterView, view, i, j);
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a != null) {
            if (view == this.a.k()) {
                if (!TiebaApplication.w()) {
                    LoginActivity.a((Activity) this, (String) null, true, 11037);
                    return;
                }
                EmotionManageActivity.a(this);
            }
            super.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b.cancelLoadData();
        }
        if (this.a != null) {
            this.a.g();
            this.a.a().c();
        }
        if (this.c != null) {
            this.c.cancelLoadData();
        }
        this.a.b(this.e);
        com.baidu.tieba.im.messageCenter.d.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        if (this.a != null) {
            this.a.g();
        }
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.a != null) {
            this.a.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.a != null) {
            this.a.a(i);
        }
    }

    public final void a(int i) {
        FacePackageData facePackageData;
        if (this.a != null && this.a.a() != null && (facePackageData = (FacePackageData) this.a.a().getItem(i)) != null) {
            this.a.j();
            facePackageData.buyStatus = 1;
            facePackageData.canDownload = 1;
            this.a.a().notifyDataSetChanged();
            this.a.a().a(i);
        }
    }

    public final void a() {
        this.a.i();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && this.a != null && this.a.a() != null) {
            if (i == 10000) {
                int intExtra = intent.getIntExtra("tag_position", -1);
                String stringExtra = intent.getStringExtra("tag_order_id");
                FacePackageData facePackageData = (FacePackageData) this.a.a().getItem(intExtra);
                if (facePackageData != null) {
                    String str = bs.c(stringExtra) ? facePackageData.orderId : stringExtra;
                    this.a.h();
                    this.c = new j();
                    this.c.setLoadDataCallBack(new av(this, intExtra));
                    this.c.b(str);
                }
            } else if (i == 11003) {
                aw a = this.a.a();
                int a2 = a.a();
                if (a2 >= 0) {
                    if (((FacePackageData) a.getItem(a2)).canDownload == 1) {
                        a.a(a2);
                    } else {
                        a.c(a2);
                    }
                }
            } else if (i == 11037) {
                EmotionManageActivity.a(this);
            }
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        FaceShopData a;
        aw a2;
        if (this.b != null && this.a != null && (a = this.b.a()) != null && a.packList != null) {
            if (sVar.w() == -122) {
                if (sVar instanceof com.baidu.tieba.d.b) {
                    this.d.clear();
                    List<com.baidu.tieba.d.a> a3 = ((com.baidu.tieba.d.b) sVar).a();
                    if (a3 != null && (a2 = this.a.a()) != null) {
                        for (com.baidu.tieba.d.a aVar : a3) {
                            this.d.put(aVar.a(), aVar);
                        }
                        Iterator<FacePackageData> it = a.packList.iterator();
                        while (it.hasNext()) {
                            FacePackageData next = it.next();
                            com.baidu.tieba.d.a aVar2 = this.d.get(String.valueOf(next.pid));
                            if (aVar2 != null) {
                                int f = aVar2.f();
                                if (f == 3 || f == 0) {
                                    next.downloaded = 1;
                                    next.downloading = 0;
                                } else if (f == 2 || f == 4) {
                                    if (!bs.c(aVar2.n())) {
                                        showToast(aVar2.n());
                                    }
                                    a2.c();
                                    next.downloaded = 0;
                                    next.downloading = 0;
                                } else if (f == 1) {
                                    next.downloading = 1;
                                    next.downloaded = 0;
                                    next.downloadTotal = aVar2.i();
                                    next.downloadNow = aVar2.h();
                                }
                            }
                        }
                        a2.a(a);
                    }
                }
            } else if (sVar.w() == -120) {
                ArrayList arrayList = new ArrayList();
                Iterator<FacePackageData> it2 = a.packList.iterator();
                while (it2.hasNext()) {
                    FacePackageData next2 = it2.next();
                    if (next2.downloaded == 1) {
                        next2.downloaded = 0;
                    }
                    arrayList.add(String.valueOf(next2.pid));
                }
                be beVar = this.a;
                be.a(arrayList);
            }
        }
    }
}
