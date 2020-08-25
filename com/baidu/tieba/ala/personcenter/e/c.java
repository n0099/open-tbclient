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
    private TextView gXs;
    private TextView gXt;
    private String gXu;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ak(getView());
    }

    private void ak(View view) {
        this.gXs = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_number_txt);
        this.gXt = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_copy_txt);
        this.gXt.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_person_center_list_qq_group_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.personcenter.c.b bVar) {
    }

    public void GO(String str) {
        this.gXu = str;
        if (this.gXs != null) {
            this.gXs.setText(getContext().getResources().getString(R.string.ala_person_center_qq_group) + str);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.gXs, (int) R.color.common_color_10106);
        ap.setViewTextColor(this.gXt, (int) R.color.cp_link_tip_a);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.gXu)) {
            UtilHelper.copyToClipBoard(this.gXu);
        }
        BdToast.b(getContext(), getContext().getResources().getString(R.string.ala_person_center_copy_to_clipboard)).nC(17).bhm();
    }
}
