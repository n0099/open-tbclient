package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.service.DealIntentService;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GuideActivity f1029a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(GuideActivity guideActivity) {
        this.f1029a = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        str = this.f1029a.m;
        if (str.equals(GuideActivity.f1010a)) {
            Intent intent = new Intent(this.f1029a, DealIntentService.class);
            intent.putExtra("class", 2);
            intent.putExtra("fname", this.f1029a.getString(R.string.guide_ten_years));
            intent.putExtra("from", "guide_ten_year");
            intent.putExtra("go_to", 10);
            TiebaApplication.a(intent);
            this.f1029a.setResult(-1, intent);
        } else {
            FrsActivity.a(this.f1029a, this.f1029a.getString(R.string.guide_ten_years), "guide_ten_year");
        }
        this.f1029a.closeActivity();
    }
}
