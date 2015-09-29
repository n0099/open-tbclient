package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ BannerView ajB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.ajB = bannerView;
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
        button = this.ajB.aju;
        if (view != button) {
            str = this.ajB.ajs;
            if (!TextUtils.isEmpty(str)) {
                str8 = this.ajB.ajs;
                TiebaStatic.log(str8);
            }
            aVar = this.ajB.ajz;
            if (aVar == null) {
                str2 = this.ajB.link;
                if (!TextUtils.isEmpty(str2)) {
                    ay uV = ay.uV();
                    tbPageContext = this.ajB.mContext;
                    str3 = this.ajB.link;
                    uV.b(tbPageContext, new String[]{str3});
                    str4 = this.ajB.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.ajB.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.ajB.mContext;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                            return;
                        }
                    }
                    str5 = this.ajB.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.ajB.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.ajB.mContext;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aVar2 = this.ajB.ajz;
            aVar2.yK();
            return;
        }
        str9 = this.ajB.ajt;
        if (!TextUtils.isEmpty(str9)) {
            str10 = this.ajB.ajt;
            TiebaStatic.log(str10);
        }
        this.ajB.ajw = true;
        this.ajB.setVisibility(8);
        aVar3 = this.ajB.ajz;
        if (aVar3 != null) {
            aVar4 = this.ajB.ajz;
            aVar4.yL();
        }
    }
}
