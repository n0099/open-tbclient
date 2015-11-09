package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ BannerView ajH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.ajH = bannerView;
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
        button = this.ajH.ajA;
        if (view != button) {
            str = this.ajH.ajy;
            if (!TextUtils.isEmpty(str)) {
                str8 = this.ajH.ajy;
                TiebaStatic.log(str8);
            }
            aVar = this.ajH.ajF;
            if (aVar == null) {
                str2 = this.ajH.link;
                if (!TextUtils.isEmpty(str2)) {
                    az uX = az.uX();
                    tbPageContext = this.ajH.mContext;
                    str3 = this.ajH.link;
                    uX.b(tbPageContext, new String[]{str3});
                    str4 = this.ajH.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.ajH.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.ajH.mContext;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                            return;
                        }
                    }
                    str5 = this.ajH.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.ajH.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.ajH.mContext;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aVar2 = this.ajH.ajF;
            aVar2.yM();
            return;
        }
        str9 = this.ajH.ajz;
        if (!TextUtils.isEmpty(str9)) {
            str10 = this.ajH.ajz;
            TiebaStatic.log(str10);
        }
        this.ajH.ajC = true;
        this.ajH.setVisibility(8);
        aVar3 = this.ajH.ajF;
        if (aVar3 != null) {
            aVar4 = this.ajH.ajF;
            aVar4.yN();
        }
    }
}
