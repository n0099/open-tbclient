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
    final /* synthetic */ BannerView asE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.asE = bannerView;
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
        if (view != this.asE.asu) {
            str = this.asE.ass;
            if (!TextUtils.isEmpty(str)) {
                str8 = this.asE.ass;
                TiebaStatic.log(str8);
            }
            aVar = this.asE.asC;
            if (aVar == null) {
                str2 = this.asE.link;
                if (!TextUtils.isEmpty(str2)) {
                    bb vQ = bb.vQ();
                    tbPageContext = this.asE.aaI;
                    str3 = this.asE.link;
                    vQ.c(tbPageContext, new String[]{str3});
                    str4 = this.asE.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.asE.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.asE.aaI;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                            return;
                        }
                    }
                    str5 = this.asE.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.asE.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.asE.aaI;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aVar2 = this.asE.asC;
            aVar2.AP();
            return;
        }
        str9 = this.asE.ast;
        if (!TextUtils.isEmpty(str9)) {
            str10 = this.asE.ast;
            TiebaStatic.log(str10);
        }
        this.asE.asy = true;
        this.asE.setVisibility(8);
        aVar3 = this.asE.asC;
        if (aVar3 != null) {
            aVar4 = this.asE.asC;
            aVar4.AQ();
        }
    }
}
