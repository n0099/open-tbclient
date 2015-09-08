package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ BannerView akB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.akB = bannerView;
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
        button = this.akB.aku;
        if (view != button) {
            str = this.akB.aks;
            if (!TextUtils.isEmpty(str)) {
                str8 = this.akB.aks;
                TiebaStatic.log(str8);
            }
            aVar = this.akB.akz;
            if (aVar == null) {
                str2 = this.akB.link;
                if (!TextUtils.isEmpty(str2)) {
                    ax uX = ax.uX();
                    tbPageContext = this.akB.mContext;
                    str3 = this.akB.link;
                    uX.b(tbPageContext, new String[]{str3});
                    str4 = this.akB.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.akB.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.akB.mContext;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                            return;
                        }
                    }
                    str5 = this.akB.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.akB.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.akB.mContext;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aVar2 = this.akB.akz;
            aVar2.za();
            return;
        }
        str9 = this.akB.akt;
        if (!TextUtils.isEmpty(str9)) {
            str10 = this.akB.akt;
            TiebaStatic.log(str10);
        }
        this.akB.akw = true;
        this.akB.setVisibility(8);
        aVar3 = this.akB.akz;
        if (aVar3 != null) {
            aVar4 = this.akB.akz;
            aVar4.zb();
        }
    }
}
