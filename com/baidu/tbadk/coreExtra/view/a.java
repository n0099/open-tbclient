package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ BannerView NB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.NB = bannerView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        String str;
        b bVar;
        b bVar2;
        String str2;
        String str3;
        Context context;
        String str4;
        String str5;
        b bVar3;
        b bVar4;
        Context context2;
        String str6;
        button = this.NB.Nu;
        if (view != button) {
            str = this.NB.Ns;
            if (!TextUtils.isEmpty(str)) {
                context = this.NB.mContext;
                str4 = this.NB.Ns;
                com.baidu.tbadk.core.j.l(context, str4);
            }
            bVar = this.NB.Nz;
            if (bVar == null) {
                str2 = this.NB.link;
                if (!TextUtils.isEmpty(str2)) {
                    bg mR = bg.mR();
                    Context context3 = this.NB.getContext();
                    str3 = this.NB.link;
                    mR.b(context3, new String[]{str3});
                    return;
                }
                return;
            }
            bVar2 = this.NB.Nz;
            bVar2.pV();
            return;
        }
        str5 = this.NB.Nt;
        if (!TextUtils.isEmpty(str5)) {
            context2 = this.NB.mContext;
            str6 = this.NB.Nt;
            com.baidu.tbadk.core.j.l(context2, str6);
        }
        this.NB.Nw = true;
        this.NB.setVisibility(8);
        bVar3 = this.NB.Nz;
        if (bVar3 != null) {
            bVar4 = this.NB.Nz;
            bVar4.pW();
        }
    }
}
