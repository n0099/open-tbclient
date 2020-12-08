package com.baidu.tieba.ala.personcenter.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.personcenter.c.b> {
    private TextView hRk;
    private TextView hRl;
    private String hRm;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        an(getView());
    }

    private void an(View view) {
        this.hRk = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_number_txt);
        this.hRl = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_copy_txt);
        this.hRl.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_person_center_list_qq_group_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.personcenter.c.b bVar) {
    }

    public void Jc(String str) {
        this.hRm = str;
        if (this.hRk != null) {
            this.hRk.setText(getContext().getResources().getString(R.string.ala_person_center_qq_group) + str);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.hRk, (int) R.color.common_color_10106);
        ap.setViewTextColor(this.hRl, (int) R.color.CAM_X0302);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.hRm)) {
            UtilHelper.copyToClipBoard(this.hRm);
        }
        BdToast.b(getContext(), getContext().getResources().getString(R.string.ala_person_center_copy_to_clipboard)).pa(17).brB();
    }
}
