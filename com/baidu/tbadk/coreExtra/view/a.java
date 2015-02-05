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
    final /* synthetic */ BannerView TO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.TO = bannerView;
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
        button = this.TO.TH;
        if (view != button) {
            str = this.TO.TF;
            if (!TextUtils.isEmpty(str)) {
                tbPageContext4 = this.TO.mContext;
                Context context = tbPageContext4.getContext();
                str8 = this.TO.TF;
                com.baidu.tbadk.core.i.A(context, str8);
            }
            bVar = this.TO.TM;
            if (bVar == null) {
                str2 = this.TO.link;
                if (!TextUtils.isEmpty(str2)) {
                    bm pO = bm.pO();
                    tbPageContext = this.TO.mContext;
                    str3 = this.TO.link;
                    pO.b(tbPageContext, new String[]{str3});
                    str4 = this.TO.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.TO.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.TO.mContext;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601");
                            return;
                        }
                    }
                    str5 = this.TO.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.TO.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.TO.mContext;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            bVar2 = this.TO.TM;
            bVar2.ty();
            return;
        }
        str9 = this.TO.TG;
        if (!TextUtils.isEmpty(str9)) {
            tbPageContext5 = this.TO.mContext;
            Context context2 = tbPageContext5.getContext();
            str10 = this.TO.TG;
            com.baidu.tbadk.core.i.A(context2, str10);
        }
        this.TO.TJ = true;
        this.TO.setVisibility(8);
        bVar3 = this.TO.TM;
        if (bVar3 != null) {
            bVar4 = this.TO.TM;
            bVar4.tz();
        }
    }
}
