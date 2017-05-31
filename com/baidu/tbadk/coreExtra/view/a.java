package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ BannerView asK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.asK = bannerView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        BannerView.a aVar;
        BannerView.a aVar2;
        String str2;
        TbPageContext<?> tbPageContext;
        String str3;
        String str4;
        String str5;
        String str6;
        TbPageContext tbPageContext2;
        String str7;
        TbPageContext tbPageContext3;
        String str8;
        String str9;
        BannerView.a aVar3;
        BannerView.a aVar4;
        String str10;
        if (view != this.asK.asA) {
            str = this.asK.asy;
            if (!TextUtils.isEmpty(str)) {
                str8 = this.asK.asy;
                TiebaStatic.log(str8);
            }
            aVar = this.asK.asI;
            if (aVar == null) {
                str2 = this.asK.link;
                if (!TextUtils.isEmpty(str2)) {
                    bb vy = bb.vy();
                    tbPageContext = this.asK.aas;
                    str3 = this.asK.link;
                    vy.c(tbPageContext, new String[]{str3});
                    str4 = this.asK.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.asK.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.asK.aas;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                            return;
                        }
                    }
                    str5 = this.asK.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.asK.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.asK.aas;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aVar2 = this.asK.asI;
            aVar2.As();
            return;
        }
        str9 = this.asK.asz;
        if (!TextUtils.isEmpty(str9)) {
            str10 = this.asK.asz;
            TiebaStatic.log(str10);
        }
        this.asK.asE = true;
        this.asK.setVisibility(8);
        aVar3 = this.asK.asI;
        if (aVar3 != null) {
            aVar4 = this.asK.asI;
            aVar4.At();
        }
    }
}
