package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ BannerView aoc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.aoc = bannerView;
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
        if (view != this.aoc.anS) {
            str = this.aoc.anQ;
            if (!TextUtils.isEmpty(str)) {
                str8 = this.aoc.anQ;
                TiebaStatic.log(str8);
            }
            aVar = this.aoc.aoa;
            if (aVar == null) {
                str2 = this.aoc.link;
                if (!TextUtils.isEmpty(str2)) {
                    bc vz = bc.vz();
                    tbPageContext = this.aoc.Gf;
                    str3 = this.aoc.link;
                    vz.c(tbPageContext, new String[]{str3});
                    str4 = this.aoc.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.aoc.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.aoc.Gf;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                            return;
                        }
                    }
                    str5 = this.aoc.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.aoc.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.aoc.Gf;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aVar2 = this.aoc.aoa;
            aVar2.AB();
            return;
        }
        str9 = this.aoc.anR;
        if (!TextUtils.isEmpty(str9)) {
            str10 = this.aoc.anR;
            TiebaStatic.log(str10);
        }
        this.aoc.anW = true;
        this.aoc.setVisibility(8);
        aVar3 = this.aoc.aoa;
        if (aVar3 != null) {
            aVar4 = this.aoc.aoa;
            aVar4.AC();
        }
    }
}
