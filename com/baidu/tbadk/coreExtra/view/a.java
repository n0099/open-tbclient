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
    final /* synthetic */ BannerView ata;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.ata = bannerView;
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
        if (view != this.ata.asQ) {
            str = this.ata.asO;
            if (!TextUtils.isEmpty(str)) {
                str8 = this.ata.asO;
                TiebaStatic.log(str8);
            }
            aVar = this.ata.asY;
            if (aVar == null) {
                str2 = this.ata.link;
                if (!TextUtils.isEmpty(str2)) {
                    bb vB = bb.vB();
                    tbPageContext = this.ata.aat;
                    str3 = this.ata.link;
                    vB.c(tbPageContext, new String[]{str3});
                    str4 = this.ata.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.ata.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.ata.aat;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                            return;
                        }
                    }
                    str5 = this.ata.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.ata.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.ata.aat;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aVar2 = this.ata.asY;
            aVar2.Az();
            return;
        }
        str9 = this.ata.asP;
        if (!TextUtils.isEmpty(str9)) {
            str10 = this.ata.asP;
            TiebaStatic.log(str10);
        }
        this.ata.asU = true;
        this.ata.setVisibility(8);
        aVar3 = this.ata.asY;
        if (aVar3 != null) {
            aVar4 = this.ata.asY;
            aVar4.AA();
        }
    }
}
