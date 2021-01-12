package com.baidu.tieba.ala.personcenter.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.personcenter.c.b> {
    private TextView hZb;
    private TextView hZc;
    private String hZd;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ap(getView());
    }

    private void ap(View view) {
        this.hZb = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_number_txt);
        this.hZc = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_copy_txt);
        this.hZc.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_person_center_list_qq_group_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.personcenter.c.b bVar) {
    }

    public void HO(String str) {
        this.hZd = str;
        if (this.hZb != null) {
            this.hZb.setText(getContext().getResources().getString(R.string.ala_person_center_qq_group) + str);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setViewTextColor(this.hZb, R.color.common_color_10106);
        ao.setViewTextColor(this.hZc, R.color.CAM_X0302);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.hZd)) {
            UtilHelper.copyToClipBoard(this.hZd);
        }
        BdToast.b(getContext(), getContext().getResources().getString(R.string.ala_person_center_copy_to_clipboard)).nE(17).bqk();
    }
}
