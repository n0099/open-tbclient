package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardHListViewNormalItemData;
import com.baidu.tieba.card.r;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r.c blG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r.c cVar) {
        this.blG = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cf cfVar;
        cf cfVar2;
        cf cfVar3;
        cfVar = this.blG.bko;
        if (cfVar != null) {
            if (view.getId() == r.h.hlistview_item_layout_root) {
                if (view.getTag(r.h.hlistview_item_layout_root) instanceof CardHListViewNormalItemData) {
                    cfVar3 = this.blG.bko;
                    cfVar3.a(view, null, (CardHListViewNormalItemData) view.getTag(r.h.hlistview_item_layout_root));
                }
            } else if (view.getId() == r.h.fourm_name && (view.getTag(r.h.fourm_name) instanceof CardHListViewNormalItemData)) {
                cfVar2 = this.blG.bko;
                cfVar2.a(view, null, (CardHListViewNormalItemData) view.getTag(r.h.fourm_name));
            }
        }
    }
}
