package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tieba.card.data.CardHListViewNormalItemData;
import com.baidu.tieba.card.r;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r.c bbS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r.c cVar) {
        this.bbS = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cb cbVar;
        cb cbVar2;
        cb cbVar3;
        cbVar = this.bbS.baA;
        if (cbVar != null) {
            if (view.getId() == r.g.hlistview_item_layout_root) {
                if (view.getTag(r.g.hlistview_item_layout_root) instanceof CardHListViewNormalItemData) {
                    cbVar3 = this.bbS.baA;
                    cbVar3.a(view, null, (CardHListViewNormalItemData) view.getTag(r.g.hlistview_item_layout_root));
                }
            } else if (view.getId() == r.g.fourm_name && (view.getTag(r.g.fourm_name) instanceof CardHListViewNormalItemData)) {
                cbVar2 = this.bbS.baA;
                cbVar2.a(view, null, (CardHListViewNormalItemData) view.getTag(r.g.fourm_name));
            }
        }
    }
}
