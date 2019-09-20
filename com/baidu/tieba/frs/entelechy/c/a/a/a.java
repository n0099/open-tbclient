package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.v;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends b {
    private List<v> mDatas;

    public List<v> bqm() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b agR() {
        View hD;
        super.agR();
        if (this.mDatas != null && (hD = hD(this.mDatas.size())) != null && (hD.findViewById(R.id.dialog_item_btn) instanceof TextView)) {
            am.j((TextView) hD.findViewById(R.id.dialog_item_btn), R.color.cp_link_tip_a);
        }
        return this;
    }
}
