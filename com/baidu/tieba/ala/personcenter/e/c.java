package com.baidu.tieba.ala.personcenter.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.personcenter.c.b> {
    private TextView gKQ;
    private TextView gKR;
    private String gKS;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        aj(getView());
    }

    private void aj(View view) {
        this.gKQ = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_number_txt);
        this.gKR = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_copy_txt);
        this.gKR.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_person_center_list_qq_group_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.personcenter.c.b bVar) {
    }

    public void Ep(String str) {
        this.gKS = str;
        if (this.gKQ != null) {
            this.gKQ.setText(getContext().getResources().getString(R.string.ala_person_center_qq_group) + str);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setViewTextColor(this.gKQ, R.color.common_color_10106);
        ao.setViewTextColor(this.gKR, R.color.cp_link_tip_a);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.gKS)) {
            UtilHelper.copyToClipBoard(this.gKS);
        }
        BdToast.b(getContext(), getContext().getResources().getString(R.string.ala_person_center_copy_to_clipboard)).lw(17).aYR();
    }
}
