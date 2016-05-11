package com.baidu.tieba.frs.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.base.l;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b bnP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bnP = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        bc bcVar;
        bc bcVar2;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        bc bcVar3;
        az azVar;
        az azVar2;
        TbPageContext tbPageContext4;
        TbPageContext tbPageContext5;
        az azVar3;
        tbPageContext = this.bnP.Do;
        if (bl.ac(tbPageContext.getPageActivity()) && k.fH()) {
            relativeLayout = this.bnP.bnF;
            if (view != relativeLayout) {
                linearLayout = this.bnP.bnG;
                if (view == linearLayout) {
                    bcVar = this.bnP.news_info;
                    if (bcVar != null) {
                        bcVar2 = this.bnP.news_info;
                        if (!TextUtils.isEmpty(bcVar2.rK())) {
                            tbPageContext2 = this.bnP.Do;
                            TiebaStatic.eventStat(tbPageContext2.getPageActivity(), "info_click", "click", 1, "page", "frs");
                            bg us = bg.us();
                            tbPageContext3 = this.bnP.Do;
                            bcVar3 = this.bnP.news_info;
                            us.c((TbPageContext) l.s(tbPageContext3.getPageActivity()), new String[]{bcVar3.rK()});
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            azVar = this.bnP.top_code;
            if (azVar != null) {
                azVar2 = this.bnP.top_code;
                if (!TextUtils.isEmpty(azVar2.rC())) {
                    tbPageContext4 = this.bnP.Do;
                    TiebaStatic.eventStat(tbPageContext4.getPageActivity(), "num_click", "click", 1, new Object[0]);
                    bg us2 = bg.us();
                    tbPageContext5 = this.bnP.Do;
                    azVar3 = this.bnP.top_code;
                    us2.c((TbPageContext) l.s(tbPageContext5.getPageActivity()), new String[]{azVar3.rC()});
                }
            }
        }
    }
}
