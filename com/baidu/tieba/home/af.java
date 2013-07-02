package com.baidu.tieba.home;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.Toast;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class af extends com.baidu.adp.a.e {
    final /* synthetic */ ae a;
    private final /* synthetic */ com.baidu.tieba.data.as b;
    private final /* synthetic */ ImageView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar, com.baidu.tieba.data.as asVar, ImageView imageView) {
        this.a = aeVar;
        this.b = asVar;
        this.c = imageView;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        RecommendPagerAdapter recommendPagerAdapter;
        Activity activity;
        RecommendPagerAdapter recommendPagerAdapter2;
        m mVar;
        RecommendPagerAdapter recommendPagerAdapter3;
        Activity activity2;
        RecommendPagerAdapter recommendPagerAdapter4;
        m mVar2;
        if (obj instanceof com.baidu.tieba.data.ac) {
            com.baidu.tieba.data.ac acVar = (com.baidu.tieba.data.ac) obj;
            recommendPagerAdapter2 = this.a.a;
            mVar = recommendPagerAdapter2.h;
            if (mVar != null) {
                com.baidu.tieba.data.aa aaVar = new com.baidu.tieba.data.aa();
                aaVar.c(this.b.f());
                aaVar.a(this.b.d());
                aaVar.a(0);
                aaVar.b(acVar.a());
                aaVar.c(1);
                aaVar.b(this.b.e());
                recommendPagerAdapter4 = this.a.a;
                mVar2 = recommendPagerAdapter4.h;
                mVar2.a(aaVar);
            }
            this.b.a(1);
            recommendPagerAdapter3 = this.a.a;
            activity2 = recommendPagerAdapter3.g;
            Toast.makeText(activity2, "喜欢成功", 0).show();
            return;
        }
        this.c.setImageResource(R.drawable.icon_heart_n_1);
        recommendPagerAdapter = this.a.a;
        activity = recommendPagerAdapter.g;
        Toast.makeText(activity, "喜欢失败", 0).show();
    }
}
