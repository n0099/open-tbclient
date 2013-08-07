package com.baidu.tieba.home;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecommendPagerAdapter f1115a;
    private final /* synthetic */ com.baidu.tieba.data.bb b;
    private final /* synthetic */ ImageView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(RecommendPagerAdapter recommendPagerAdapter, com.baidu.tieba.data.bb bbVar, ImageView imageView) {
        this.f1115a = recommendPagerAdapter;
        this.b = bbVar;
        this.c = imageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        String E = TiebaApplication.E();
        if (E == null || E.length() <= 0) {
            activity = this.f1115a.g;
            activity2 = this.f1115a.g;
            LoginActivity.a(activity, activity2.getResources().getString(R.string.login_to_use), true, 11002);
            return;
        }
        com.baidu.tieba.model.ar arVar = new com.baidu.tieba.model.ar();
        arVar.setLoadDataCallBack(new af(this, this.b, this.c));
        arVar.a(this.b.e(), this.b.d());
        this.c.setImageResource(R.drawable.icon_heart_s_1);
    }
}
