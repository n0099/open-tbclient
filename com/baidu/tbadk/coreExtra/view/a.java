package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ BannerView Nx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.Nx = bannerView;
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
        button = this.Nx.Nq;
        if (view != button) {
            str = this.Nx.No;
            if (!TextUtils.isEmpty(str)) {
                context = this.Nx.mContext;
                str4 = this.Nx.No;
                com.baidu.tbadk.core.i.l(context, str4);
            }
            bVar = this.Nx.Nv;
            if (bVar == null) {
                str2 = this.Nx.link;
                if (!TextUtils.isEmpty(str2)) {
                    bf mR = bf.mR();
                    Context context3 = this.Nx.getContext();
                    str3 = this.Nx.link;
                    mR.b(context3, new String[]{str3});
                    return;
                }
                return;
            }
            bVar2 = this.Nx.Nv;
            bVar2.pT();
            return;
        }
        str5 = this.Nx.Np;
        if (!TextUtils.isEmpty(str5)) {
            context2 = this.Nx.mContext;
            str6 = this.Nx.Np;
            com.baidu.tbadk.core.i.l(context2, str6);
        }
        this.Nx.Ns = true;
        this.Nx.setVisibility(8);
        bVar3 = this.Nx.Nv;
        if (bVar3 != null) {
            bVar4 = this.Nx.Nv;
            bVar4.pU();
        }
    }
}
