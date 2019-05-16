package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.v;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends b {
    private List<v> mDatas;

    public List<v> bnj() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b afJ() {
        View hw;
        super.afJ();
        if (this.mDatas != null && (hw = hw(this.mDatas.size())) != null && (hw.findViewById(R.id.dialog_item_btn) instanceof TextView)) {
            al.j((TextView) hw.findViewById(R.id.dialog_item_btn), R.color.cp_link_tip_a);
        }
        return this;
    }
}
