package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ BannerView anI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.anI = bannerView;
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
        button = this.anI.anB;
        if (view != button) {
            str = this.anI.anz;
            if (!TextUtils.isEmpty(str)) {
                str8 = this.anI.anz;
                TiebaStatic.log(str8);
            }
            aVar = this.anI.anG;
            if (aVar == null) {
                str2 = this.anI.link;
                if (!TextUtils.isEmpty(str2)) {
                    bg wM = bg.wM();
                    tbPageContext = this.anI.MX;
                    str3 = this.anI.link;
                    wM.c(tbPageContext, new String[]{str3});
                    str4 = this.anI.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.anI.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.anI.MX;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                            return;
                        }
                    }
                    str5 = this.anI.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.anI.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.anI.MX;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aVar2 = this.anI.anG;
            aVar2.Bp();
            return;
        }
        str9 = this.anI.anA;
        if (!TextUtils.isEmpty(str9)) {
            str10 = this.anI.anA;
            TiebaStatic.log(str10);
        }
        this.anI.anD = true;
        this.anI.setVisibility(8);
        aVar3 = this.anI.anG;
        if (aVar3 != null) {
            aVar4 = this.anI.anG;
            aVar4.Bq();
        }
    }
}
