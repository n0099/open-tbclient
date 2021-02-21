package com.baidu.tieba.ala.personcenter.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.personcenter.c.b> {
    private TextView idN;
    private TextView idO;
    private String idP;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        am(getView());
    }

    private void am(View view) {
        this.idN = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_number_txt);
        this.idO = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_copy_txt);
        this.idO.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_person_center_list_qq_group_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.personcenter.c.b bVar) {
    }

    public void It(String str) {
        this.idP = str;
        if (this.idN != null) {
            this.idN.setText(getContext().getResources().getString(R.string.ala_person_center_qq_group) + str);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.idN, R.color.common_color_10106);
        ap.setViewTextColor(this.idO, R.color.CAM_X0302);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.idP)) {
            UtilHelper.copyToClipBoard(this.idP);
        }
        BdToast.b(getContext(), getContext().getResources().getString(R.string.ala_person_center_copy_to_clipboard)).nH(17).bqD();
    }
}
