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

    public List<v> bfQ() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b aaZ() {
        View gJ;
        super.aaZ();
        if (this.mDatas != null && (gJ = gJ(this.mDatas.size())) != null && (gJ.findViewById(d.g.dialog_item_btn) instanceof TextView)) {
            al.j((TextView) gJ.findViewById(d.g.dialog_item_btn), d.C0277d.cp_link_tip_a);
        }
        return this;
    }
}
