package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ BannerView aoA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.aoA = bannerView;
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
        if (view != this.aoA.aoq) {
            str = this.aoA.aoo;
            if (!TextUtils.isEmpty(str)) {
                str8 = this.aoA.aoo;
                TiebaStatic.log(str8);
            }
            aVar = this.aoA.aoy;
            if (aVar == null) {
                str2 = this.aoA.link;
                if (!TextUtils.isEmpty(str2)) {
                    bf vP = bf.vP();
                    tbPageContext = this.aoA.Gf;
                    str3 = this.aoA.link;
                    vP.c(tbPageContext, new String[]{str3});
                    str4 = this.aoA.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.aoA.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.aoA.Gf;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                            return;
                        }
                    }
                    str5 = this.aoA.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.aoA.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.aoA.Gf;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aVar2 = this.aoA.aoy;
            aVar2.AO();
            return;
        }
        str9 = this.aoA.aop;
        if (!TextUtils.isEmpty(str9)) {
            str10 = this.aoA.aop;
            TiebaStatic.log(str10);
        }
        this.aoA.aou = true;
        this.aoA.setVisibility(8);
        aVar3 = this.aoA.aoy;
        if (aVar3 != null) {
            aVar4 = this.aoA.aoy;
            aVar4.AP();
        }
    }
}
