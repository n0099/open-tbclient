package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ BannerView akc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.akc = bannerView;
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
        if (view != this.akc.ajV) {
            str = this.akc.ajT;
            if (!TextUtils.isEmpty(str)) {
                str8 = this.akc.ajT;
                TiebaStatic.log(str8);
            }
            aVar = this.akc.aka;
            if (aVar == null) {
                str2 = this.akc.link;
                if (!TextUtils.isEmpty(str2)) {
                    bi us = bi.us();
                    tbPageContext = this.akc.Dp;
                    str3 = this.akc.link;
                    us.c(tbPageContext, new String[]{str3});
                    str4 = this.akc.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.akc.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.akc.Dp;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                            return;
                        }
                    }
                    str5 = this.akc.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.akc.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.akc.Dp;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aVar2 = this.akc.aka;
            aVar2.zp();
            return;
        }
        str9 = this.akc.ajU;
        if (!TextUtils.isEmpty(str9)) {
            str10 = this.akc.ajU;
            TiebaStatic.log(str10);
        }
        this.akc.ajX = true;
        this.akc.setVisibility(8);
        aVar3 = this.akc.aka;
        if (aVar3 != null) {
            aVar4 = this.akc.aka;
            aVar4.zq();
        }
    }
}
