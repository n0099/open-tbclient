package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.coreExtra.view.BannerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ BannerView amy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BannerView bannerView) {
        this.amy = bannerView;
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
        button = this.amy.amr;
        if (view != button) {
            str = this.amy.amp;
            if (!TextUtils.isEmpty(str)) {
                str8 = this.amy.amp;
                TiebaStatic.log(str8);
            }
            aVar = this.amy.amw;
            if (aVar == null) {
                str2 = this.amy.link;
                if (!TextUtils.isEmpty(str2)) {
                    bf vn = bf.vn();
                    tbPageContext = this.amy.mContext;
                    str3 = this.amy.link;
                    vn.b(tbPageContext, new String[]{str3});
                    str4 = this.amy.link;
                    if (str4.startsWith("game:detail:")) {
                        str7 = this.amy.type;
                        if ("frs_banner".equals(str7)) {
                            tbPageContext3 = this.amy.mContext;
                            TiebaStatic.eventStat(tbPageContext3.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                            return;
                        }
                    }
                    str5 = this.amy.link;
                    if (str5.startsWith("game:detail:")) {
                        str6 = this.amy.type;
                        if ("enterforum_banner".equals(str6)) {
                            tbPageContext2 = this.amy.mContext;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "enterforum_banner", "click", 1, "ref_id", "4000401", "ref_type", "603");
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            aVar2 = this.amy.amw;
            aVar2.zu();
            return;
        }
        str9 = this.amy.amq;
        if (!TextUtils.isEmpty(str9)) {
            str10 = this.amy.amq;
            TiebaStatic.log(str10);
        }
        this.amy.amt = true;
        this.amy.setVisibility(8);
        aVar3 = this.amy.amw;
        if (aVar3 != null) {
            aVar4 = this.amy.amw;
            aVar4.zv();
        }
    }
}
