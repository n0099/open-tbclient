package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ BannerView adQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.adQ = bannerView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        String str;
        b bVar;
        b bVar2;
        String str2;
        TbPageContext<?> tbPageContext;
        String str3;
        String str4;
        String str5;
        String str6;
        TbPageContext tbPageContext2;
        String str7;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        String str8;
        String str9;
        b bVar3;
        b bVar4;
        TbPageContext tbPageContext5;
        String str10;
        button = this.adQ.adJ;
        if (view != button) {
            str = this.adQ.adH;
            if (!TextUtils.isEmpty(str)) {
                tbPageContext4 = this.adQ.LN;
                Context context = tbPageContext4.getContext();
                str8 = this.adQ.adH;
                com.baidu.tbadk.core.k.A(context, str8);
            }
            bVar = this.adQ.adO;
            if (bVar == null) {
                str2 = this.adQ.link;
                if (!TextUtils.isEmpty(str2)) {
                    bk tl = bk.tl();
                    tbPageContext = this.adQ.LN;
                    str3 = this.adQ.link;
                    tl.b(tbPageContext, new String[]{str3});
                    str4 = this.adQ.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.adQ.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.adQ.LN;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                            return;
                        }
                    }
                    str5 = this.adQ.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.adQ.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.adQ.LN;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            bVar2 = this.adQ.adO;
            bVar2.wR();
            return;
        }
        str9 = this.adQ.adI;
        if (!TextUtils.isEmpty(str9)) {
            tbPageContext5 = this.adQ.LN;
            Context context2 = tbPageContext5.getContext();
            str10 = this.adQ.adI;
            com.baidu.tbadk.core.k.A(context2, str10);
        }
        this.adQ.adL = true;
        this.adQ.setVisibility(8);
        bVar3 = this.adQ.adO;
        if (bVar3 != null) {
            bVar4 = this.adQ.adO;
            bVar4.wS();
        }
    }
}
