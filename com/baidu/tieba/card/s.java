package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardHListViewNormalItemData;
import com.baidu.tieba.card.r;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r.c buK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r.c cVar) {
        this.buK = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cf cfVar;
        cf cfVar2;
        cf cfVar3;
        cfVar = this.buK.btq;
        if (cfVar != null) {
            if (view.getId() == w.h.hlistview_item_layout_root) {
                if (view.getTag(w.h.hlistview_item_layout_root) instanceof CardHListViewNormalItemData) {
                    cfVar3 = this.buK.btq;
                    cfVar3.a(view, null, (CardHListViewNormalItemData) view.getTag(w.h.hlistview_item_layout_root));
                }
            } else if (view.getId() == w.h.fourm_name && (view.getTag(w.h.fourm_name) instanceof CardHListViewNormalItemData)) {
                cfVar2 = this.buK.btq;
                cfVar2.a(view, null, (CardHListViewNormalItemData) view.getTag(w.h.fourm_name));
            }
        }
    }
}
