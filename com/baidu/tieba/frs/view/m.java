package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.frs.view.k;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnLongClickListener {
    final /* synthetic */ k crV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.crV = kVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        y yVar;
        List list;
        y yVar2;
        yVar = this.crV.crT;
        if (yVar == null || !(view.getTag() instanceof k.a)) {
            return false;
        }
        k.a aVar = (k.a) view.getTag();
        list = this.crV.aUW;
        yVar2 = this.crV.crT;
        return yVar2.b(view, (bm) z.c(list, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
    }
}
