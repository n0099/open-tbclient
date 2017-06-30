package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends ci<bm> {
    final /* synthetic */ v cgT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.cgT = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, bm bmVar) {
        if (view != null && bmVar != null) {
            if (view.getId() == w.h.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                com.baidu.tieba.frs.d.b.aho().a(v.cnC, bmVar, 2);
            } else {
                com.baidu.tieba.frs.d.b.aho().a(v.cnC, bmVar, 7);
            }
        }
    }
}
