package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.v;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends b {
    private List<v> mDatas;

    public List<v> bfS() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b abc() {
        View gK;
        super.abc();
        if (this.mDatas != null && (gK = gK(this.mDatas.size())) != null && (gK.findViewById(d.g.dialog_item_btn) instanceof TextView)) {
            al.j((TextView) gK.findViewById(d.g.dialog_item_btn), d.C0277d.cp_link_tip_a);
        }
        return this;
    }
}
