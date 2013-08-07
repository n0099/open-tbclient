package com.baidu.tieba.home;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.Toast;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class af extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ae f1116a;
    private final /* synthetic */ com.baidu.tieba.data.bb b;
    private final /* synthetic */ ImageView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar, com.baidu.tieba.data.bb bbVar, ImageView imageView) {
        this.f1116a = aeVar;
        this.b = bbVar;
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
        if (obj instanceof com.baidu.tieba.data.ak) {
            com.baidu.tieba.data.ak akVar = (com.baidu.tieba.data.ak) obj;
            recommendPagerAdapter2 = this.f1116a.f1115a;
            mVar = recommendPagerAdapter2.h;
            if (mVar != null) {
                com.baidu.tieba.data.ai aiVar = new com.baidu.tieba.data.ai();
                aiVar.c(this.b.f());
                aiVar.a(this.b.d());
                aiVar.a(0);
                aiVar.b(akVar.a());
                aiVar.c(1);
                aiVar.b(this.b.e());
                recommendPagerAdapter4 = this.f1116a.f1115a;
                mVar2 = recommendPagerAdapter4.h;
                mVar2.a(aiVar);
            }
            this.b.a(1);
            recommendPagerAdapter3 = this.f1116a.f1115a;
            activity2 = recommendPagerAdapter3.g;
            Toast.makeText(activity2, "喜欢成功", 0).show();
            return;
        }
        this.c.setImageResource(R.drawable.icon_heart_n_1);
        recommendPagerAdapter = this.f1116a.f1115a;
        activity = recommendPagerAdapter.g;
        Toast.makeText(activity, "喜欢失败", 0).show();
    }
}
