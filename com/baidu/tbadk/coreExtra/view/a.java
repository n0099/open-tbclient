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
    final /* synthetic */ BannerView ajC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.ajC = bannerView;
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
        button = this.ajC.ajv;
        if (view != button) {
            str = this.ajC.ajt;
            if (!TextUtils.isEmpty(str)) {
                str8 = this.ajC.ajt;
                TiebaStatic.log(str8);
            }
            aVar = this.ajC.ajA;
            if (aVar == null) {
                str2 = this.ajC.link;
                if (!TextUtils.isEmpty(str2)) {
                    az uT = az.uT();
                    tbPageContext = this.ajC.mContext;
                    str3 = this.ajC.link;
                    uT.b(tbPageContext, new String[]{str3});
                    str4 = this.ajC.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.ajC.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.ajC.mContext;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                            return;
                        }
                    }
                    str5 = this.ajC.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.ajC.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.ajC.mContext;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aVar2 = this.ajC.ajA;
            aVar2.yH();
            return;
        }
        str9 = this.ajC.aju;
        if (!TextUtils.isEmpty(str9)) {
            str10 = this.ajC.aju;
            TiebaStatic.log(str10);
        }
        this.ajC.ajx = true;
        this.ajC.setVisibility(8);
        aVar3 = this.ajC.ajA;
        if (aVar3 != null) {
            aVar4 = this.ajC.ajA;
            aVar4.yI();
        }
    }
}
