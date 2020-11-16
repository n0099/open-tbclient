package com.baidu.tieba.ala.personcenter.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.personcenter.c.b> {
    private TextView hHD;
    private TextView hHE;
    private String hHF;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        al(getView());
    }

    private void al(View view) {
        this.hHD = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_number_txt);
        this.hHE = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_copy_txt);
        this.hHE.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_person_center_list_qq_group_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.personcenter.c.b bVar) {
    }

    public void In(String str) {
        this.hHF = str;
        if (this.hHD != null) {
            this.hHD.setText(getContext().getResources().getString(R.string.ala_person_center_qq_group) + str);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.hHD, R.color.common_color_10106);
        ap.setViewTextColor(this.hHE, R.color.CAM_X0302);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.hHF)) {
            UtilHelper.copyToClipBoard(this.hHF);
        }
        BdToast.b(getContext(), getContext().getResources().getString(R.string.ala_person_center_copy_to_clipboard)).oC(17).bom();
    }
}
