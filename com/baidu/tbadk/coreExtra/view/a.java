package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ BannerView anG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.anG = bannerView;
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
        if (view != this.anG.anx) {
            str = this.anG.anv;
            if (!TextUtils.isEmpty(str)) {
                str8 = this.anG.anv;
                TiebaStatic.log(str8);
            }
            aVar = this.anG.anE;
            if (aVar == null) {
                str2 = this.anG.link;
                if (!TextUtils.isEmpty(str2)) {
                    bh vL = bh.vL();
                    tbPageContext = this.anG.Gd;
                    str3 = this.anG.link;
                    vL.c(tbPageContext, new String[]{str3});
                    str4 = this.anG.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.anG.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.anG.Gd;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                            return;
                        }
                    }
                    str5 = this.anG.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.anG.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.anG.Gd;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aVar2 = this.anG.anE;
            aVar2.AH();
            return;
        }
        str9 = this.anG.anw;
        if (!TextUtils.isEmpty(str9)) {
            str10 = this.anG.anw;
            TiebaStatic.log(str10);
        }
        this.anG.anA = true;
        this.anG.setVisibility(8);
        aVar3 = this.anG.anE;
        if (aVar3 != null) {
            aVar4 = this.anG.anE;
            aVar4.AI();
        }
    }
}
