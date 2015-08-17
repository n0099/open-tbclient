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
    final /* synthetic */ BannerView akj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.akj = bannerView;
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
        button = this.akj.akc;
        if (view != button) {
            str = this.akj.aka;
            if (!TextUtils.isEmpty(str)) {
                str8 = this.akj.aka;
                TiebaStatic.log(str8);
            }
            aVar = this.akj.akh;
            if (aVar == null) {
                str2 = this.akj.link;
                if (!TextUtils.isEmpty(str2)) {
                    ax uR = ax.uR();
                    tbPageContext = this.akj.LS;
                    str3 = this.akj.link;
                    uR.b(tbPageContext, new String[]{str3});
                    str4 = this.akj.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.akj.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.akj.LS;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                            return;
                        }
                    }
                    str5 = this.akj.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.akj.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.akj.LS;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aVar2 = this.akj.akh;
            aVar2.yT();
            return;
        }
        str9 = this.akj.akb;
        if (!TextUtils.isEmpty(str9)) {
            str10 = this.akj.akb;
            TiebaStatic.log(str10);
        }
        this.akj.ake = true;
        this.akj.setVisibility(8);
        aVar3 = this.akj.akh;
        if (aVar3 != null) {
            aVar4 = this.akj.akh;
            aVar4.yU();
        }
    }
}
