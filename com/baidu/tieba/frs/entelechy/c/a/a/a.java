package com.baidu.tieba.frs.entelechy.c.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.w;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends b {
    private List<w> mDatas;

    public List<w> bHr() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.core.dialog.b
    public b aEB() {
        View itemView;
        super.aEB();
        if (this.mDatas != null && (itemView = getItemView(this.mDatas.size())) != null && (itemView.findViewById(R.id.dialog_item_btn) instanceof TextView)) {
            am.setViewTextColor((TextView) itemView.findViewById(R.id.dialog_item_btn), (int) R.color.cp_link_tip_a);
        }
        return this;
    }
}
