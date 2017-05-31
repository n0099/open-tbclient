package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends ci<bl> {
    final /* synthetic */ v bYK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.bYK = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, bl blVar) {
        if (view != null && blVar != null) {
            if (view.getId() == w.h.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                com.baidu.tieba.frs.d.b.adw().a(v.cfm, blVar, 2);
            } else {
                com.baidu.tieba.frs.d.b.adw().a(v.cfm, blVar, 7);
            }
        }
    }
}
