package com.baidu.tieba.ala.personcenter.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.personcenter.c.b> {
    private TextView idM;
    private TextView idN;
    private String idO;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ap(getView());
    }

    private void ap(View view) {
        this.idM = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_number_txt);
        this.idN = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_copy_txt);
        this.idN.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_person_center_list_qq_group_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.personcenter.c.b bVar) {
    }

    public void Ja(String str) {
        this.idO = str;
        if (this.idM != null) {
            this.idM.setText(getContext().getResources().getString(R.string.ala_person_center_qq_group) + str);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setViewTextColor(this.idM, R.color.common_color_10106);
        ao.setViewTextColor(this.idN, R.color.CAM_X0302);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.idO)) {
            UtilHelper.copyToClipBoard(this.idO);
        }
        BdToast.b(getContext(), getContext().getResources().getString(R.string.ala_person_center_copy_to_clipboard)).pk(17).bud();
    }
}
