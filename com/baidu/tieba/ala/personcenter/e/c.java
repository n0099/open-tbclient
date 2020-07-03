package com.baidu.tieba.ala.personcenter.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.personcenter.c.b> {
    private TextView gFt;
    private TextView gFu;
    private String gFv;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ag(getView());
    }

    private void ag(View view) {
        this.gFt = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_number_txt);
        this.gFu = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_copy_txt);
        this.gFu.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_person_center_list_qq_group_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.personcenter.c.b bVar) {
    }

    public void DE(String str) {
        this.gFv = str;
        if (this.gFt != null) {
            this.gFt.setText(getContext().getResources().getString(R.string.ala_person_center_qq_group) + str);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        an.setViewTextColor(this.gFt, (int) R.color.common_color_10106);
        an.setViewTextColor(this.gFu, (int) R.color.cp_link_tip_a);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.gFv)) {
            UtilHelper.copyToClipBoard(this.gFv);
        }
        BdToast.b(getContext(), getContext().getResources().getString(R.string.ala_person_center_copy_to_clipboard)).lc(17).aUS();
    }
}
