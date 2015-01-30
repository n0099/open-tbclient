package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ BannerView TR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.TR = bannerView;
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
        button = this.TR.TK;
        if (view != button) {
            str = this.TR.TI;
            if (!TextUtils.isEmpty(str)) {
                tbPageContext4 = this.TR.mContext;
                Context context = tbPageContext4.getContext();
                str8 = this.TR.TI;
                com.baidu.tbadk.core.i.A(context, str8);
            }
            bVar = this.TR.TP;
            if (bVar == null) {
                str2 = this.TR.link;
                if (!TextUtils.isEmpty(str2)) {
                    bm pV = bm.pV();
                    tbPageContext = this.TR.mContext;
                    str3 = this.TR.link;
                    pV.b(tbPageContext, new String[]{str3});
                    str4 = this.TR.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.TR.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.TR.mContext;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601");
                            return;
                        }
                    }
                    str5 = this.TR.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.TR.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.TR.mContext;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            bVar2 = this.TR.TP;
            bVar2.tE();
            return;
        }
        str9 = this.TR.TJ;
        if (!TextUtils.isEmpty(str9)) {
            tbPageContext5 = this.TR.mContext;
            Context context2 = tbPageContext5.getContext();
            str10 = this.TR.TJ;
            com.baidu.tbadk.core.i.A(context2, str10);
        }
        this.TR.TM = true;
        this.TR.setVisibility(8);
        bVar3 = this.TR.TP;
        if (bVar3 != null) {
            bVar4 = this.TR.TP;
            bVar4.tF();
        }
    }
}
