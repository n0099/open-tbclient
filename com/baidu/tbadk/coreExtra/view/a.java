package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ BannerView anr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.anr = bannerView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
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
        button = this.anr.ank;
        if (view != button) {
            str = this.anr.ani;
            if (!TextUtils.isEmpty(str)) {
                str8 = this.anr.ani;
                TiebaStatic.log(str8);
            }
            aVar = this.anr.anp;
            if (aVar == null) {
                str2 = this.anr.link;
                if (!TextUtils.isEmpty(str2)) {
                    be wt = be.wt();
                    tbPageContext = this.anr.MR;
                    str3 = this.anr.link;
                    wt.c(tbPageContext, new String[]{str3});
                    str4 = this.anr.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.anr.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.anr.MR;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                            return;
                        }
                    }
                    str5 = this.anr.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.anr.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.anr.MR;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aVar2 = this.anr.anp;
            aVar2.AM();
            return;
        }
        str9 = this.anr.anj;
        if (!TextUtils.isEmpty(str9)) {
            str10 = this.anr.anj;
            TiebaStatic.log(str10);
        }
        this.anr.anm = true;
        this.anr.setVisibility(8);
        aVar3 = this.anr.anp;
        if (aVar3 != null) {
            aVar4 = this.anr.anp;
            aVar4.AN();
        }
    }
}
