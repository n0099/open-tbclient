package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardHListViewNormalItemData;
import com.baidu.tieba.card.r;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r.c bAu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r.c cVar) {
        this.bAu = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ci ciVar;
        ci ciVar2;
        ci ciVar3;
        ciVar = this.bAu.bvd;
        if (ciVar != null) {
            if (view.getId() == w.h.hlistview_item_layout_root) {
                if (view.getTag(w.h.hlistview_item_layout_root) instanceof CardHListViewNormalItemData) {
                    ciVar3 = this.bAu.bvd;
                    ciVar3.a(view, null, (CardHListViewNormalItemData) view.getTag(w.h.hlistview_item_layout_root));
                }
            } else if (view.getId() == w.h.fourm_name && (view.getTag(w.h.fourm_name) instanceof CardHListViewNormalItemData)) {
                ciVar2 = this.bAu.bvd;
                ciVar2.a(view, null, (CardHListViewNormalItemData) view.getTag(w.h.fourm_name));
            }
        }
    }
}
