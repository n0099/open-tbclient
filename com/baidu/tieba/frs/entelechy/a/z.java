package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends ci<bm> {
    final /* synthetic */ y cgX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.cgX = yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, bm bmVar) {
        ci ciVar;
        ci ciVar2;
        if (view != null && bmVar != null) {
            if (view.getId() == w.h.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                com.baidu.tieba.frs.d.b.aho().a(y.cnC, bmVar, 2);
            } else if (view.getId() == w.h.card_divider_tv) {
                com.baidu.tieba.frs.e.o.a(y.cnC, bmVar.rP());
            } else if (view instanceof TbImageView) {
                ciVar = this.cgX.bgf;
                if (ciVar.aRx instanceof Boolean) {
                    ciVar2 = this.cgX.bgf;
                    if (((Boolean) ciVar2.aRx).booleanValue()) {
                        com.baidu.tieba.frs.d.b.aho().a(y.cnC, bmVar, 1);
                    } else {
                        com.baidu.tieba.frs.d.b.aho().a(y.cnC, bmVar, 3);
                    }
                }
            } else if (view.getId() == w.h.card_home_page_normal_thread_abstract_voice) {
                com.baidu.tieba.frs.d.b.aho().a(y.cnC, bmVar, 5);
            } else if (view.getId() == w.h.card_frs_god_reply_layout) {
                com.baidu.tieba.frs.d.b.aho().a(y.cnC, bmVar, 6);
            } else {
                com.baidu.tieba.frs.d.b.aho().a(y.cnC, bmVar, 1);
            }
        }
    }
}
