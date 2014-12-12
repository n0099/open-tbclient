package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ BannerView Tm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.Tm = bannerView;
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
        button = this.Tm.Tg;
        if (view != button) {
            str = this.Tm.Te;
            if (!TextUtils.isEmpty(str)) {
                tbPageContext4 = this.Tm.mContext;
                Context context = tbPageContext4.getContext();
                str8 = this.Tm.Te;
                com.baidu.tbadk.core.i.B(context, str8);
            }
            bVar = this.Tm.Tl;
            if (bVar == null) {
                str2 = this.Tm.link;
                if (!TextUtils.isEmpty(str2)) {
                    bh pK = bh.pK();
                    tbPageContext = this.Tm.mContext;
                    str3 = this.Tm.link;
                    pK.b(tbPageContext, new String[]{str3});
                    str4 = this.Tm.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.Tm.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.Tm.mContext;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601");
                            return;
                        }
                    }
                    str5 = this.Tm.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.Tm.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.Tm.mContext;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            bVar2 = this.Tm.Tl;
            bVar2.tn();
            return;
        }
        str9 = this.Tm.Tf;
        if (!TextUtils.isEmpty(str9)) {
            tbPageContext5 = this.Tm.mContext;
            Context context2 = tbPageContext5.getContext();
            str10 = this.Tm.Tf;
            com.baidu.tbadk.core.i.B(context2, str10);
        }
        this.Tm.Ti = true;
        this.Tm.setVisibility(8);
        bVar3 = this.Tm.Tl;
        if (bVar3 != null) {
            bVar4 = this.Tm.Tl;
            bVar4.to();
        }
    }
}
