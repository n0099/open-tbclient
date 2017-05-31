package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends ci<bl> {
    final /* synthetic */ y bYO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.bYO = yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, bl blVar) {
        ci ciVar;
        ci ciVar2;
        if (view != null && blVar != null) {
            if (view.getId() == w.h.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                com.baidu.tieba.frs.d.b.adw().a(y.cfm, blVar, 2);
            } else if (view.getId() == w.h.card_divider_tv) {
                com.baidu.tieba.frs.e.o.a(y.cfm, blVar.rS());
            } else if (view instanceof TbImageView) {
                ciVar = this.bYO.bdm;
                if (ciVar.aQf instanceof Boolean) {
                    ciVar2 = this.bYO.bdm;
                    if (((Boolean) ciVar2.aQf).booleanValue()) {
                        com.baidu.tieba.frs.d.b.adw().a(y.cfm, blVar, 1);
                    } else {
                        com.baidu.tieba.frs.d.b.adw().a(y.cfm, blVar, 3);
                    }
                }
            } else if (view.getId() == w.h.card_home_page_normal_thread_abstract_voice) {
                com.baidu.tieba.frs.d.b.adw().a(y.cfm, blVar, 5);
            } else if (view.getId() == w.h.card_frs_god_reply_layout) {
                com.baidu.tieba.frs.d.b.adw().a(y.cfm, blVar, 6);
            } else {
                com.baidu.tieba.frs.d.b.adw().a(y.cfm, blVar, 1);
            }
        }
    }
}
