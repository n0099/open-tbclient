package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardHListViewNormalItemData;
import com.baidu.tieba.card.n;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ n.c buH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n.c cVar) {
        this.buH = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cd cdVar;
        cd cdVar2;
        cd cdVar3;
        cdVar = this.buH.btJ;
        if (cdVar != null) {
            if (view.getId() == w.h.hlistview_item_layout_root) {
                if (view.getTag(w.h.hlistview_item_layout_root) instanceof CardHListViewNormalItemData) {
                    cdVar3 = this.buH.btJ;
                    cdVar3.a(view, null, (CardHListViewNormalItemData) view.getTag(w.h.hlistview_item_layout_root));
                }
            } else if (view.getId() == w.h.fourm_name && (view.getTag(w.h.fourm_name) instanceof CardHListViewNormalItemData)) {
                cdVar2 = this.buH.btJ;
                cdVar2.a(view, null, (CardHListViewNormalItemData) view.getTag(w.h.fourm_name));
            }
        }
    }
}
