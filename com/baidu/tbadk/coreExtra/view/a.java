package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ BannerView ajw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.ajw = bannerView;
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
        if (view != this.ajw.ajp) {
            str = this.ajw.ajn;
            if (!TextUtils.isEmpty(str)) {
                str8 = this.ajw.ajn;
                TiebaStatic.log(str8);
            }
            aVar = this.ajw.aju;
            if (aVar == null) {
                str2 = this.ajw.link;
                if (!TextUtils.isEmpty(str2)) {
                    bg us = bg.us();
                    tbPageContext = this.ajw.Do;
                    str3 = this.ajw.link;
                    us.c(tbPageContext, new String[]{str3});
                    str4 = this.ajw.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.ajw.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.ajw.Do;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                            return;
                        }
                    }
                    str5 = this.ajw.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.ajw.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.ajw.Do;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aVar2 = this.ajw.aju;
            aVar2.zj();
            return;
        }
        str9 = this.ajw.ajo;
        if (!TextUtils.isEmpty(str9)) {
            str10 = this.ajw.ajo;
            TiebaStatic.log(str10);
        }
        this.ajw.ajr = true;
        this.ajw.setVisibility(8);
        aVar3 = this.ajw.aju;
        if (aVar3 != null) {
            aVar4 = this.ajw.aju;
            aVar4.zk();
        }
    }
}
