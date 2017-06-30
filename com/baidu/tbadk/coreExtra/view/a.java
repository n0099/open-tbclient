package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ BannerView atN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.atN = bannerView;
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
        if (view != this.atN.atD) {
            str = this.atN.atB;
            if (!TextUtils.isEmpty(str)) {
                str8 = this.atN.atB;
                TiebaStatic.log(str8);
            }
            aVar = this.atN.atL;
            if (aVar == null) {
                str2 = this.atN.link;
                if (!TextUtils.isEmpty(str2)) {
                    be vP = be.vP();
                    tbPageContext = this.atN.aat;
                    str3 = this.atN.link;
                    vP.c(tbPageContext, new String[]{str3});
                    str4 = this.atN.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.atN.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.atN.aat;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                            return;
                        }
                    }
                    str5 = this.atN.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.atN.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.atN.aat;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aVar2 = this.atN.atL;
            aVar2.AN();
            return;
        }
        str9 = this.atN.atC;
        if (!TextUtils.isEmpty(str9)) {
            str10 = this.atN.atC;
            TiebaStatic.log(str10);
        }
        this.atN.atH = true;
        this.atN.setVisibility(8);
        aVar3 = this.atN.atL;
        if (aVar3 != null) {
            aVar4 = this.atN.atL;
            aVar4.AO();
        }
    }
}
