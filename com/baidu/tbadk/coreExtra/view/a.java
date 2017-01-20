package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ BannerView anj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.anj = bannerView;
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
        if (view != this.anj.amZ) {
            str = this.anj.amX;
            if (!TextUtils.isEmpty(str)) {
                str8 = this.anj.amX;
                TiebaStatic.log(str8);
            }
            aVar = this.anj.anh;
            if (aVar == null) {
                str2 = this.anj.link;
                if (!TextUtils.isEmpty(str2)) {
                    ba vt = ba.vt();
                    tbPageContext = this.anj.Fp;
                    str3 = this.anj.link;
                    vt.c(tbPageContext, new String[]{str3});
                    str4 = this.anj.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.anj.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.anj.Fp;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                            return;
                        }
                    }
                    str5 = this.anj.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.anj.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.anj.Fp;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aVar2 = this.anj.anh;
            aVar2.Aw();
            return;
        }
        str9 = this.anj.amY;
        if (!TextUtils.isEmpty(str9)) {
            str10 = this.anj.amY;
            TiebaStatic.log(str10);
        }
        this.anj.and = true;
        this.anj.setVisibility(8);
        aVar3 = this.anj.anh;
        if (aVar3 != null) {
            aVar4 = this.anj.anh;
            aVar4.Ax();
        }
    }
}
