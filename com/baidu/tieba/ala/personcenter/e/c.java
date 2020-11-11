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
    private TextView hHW;
    private TextView hHX;
    private String hHY;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        al(getView());
    }

    private void al(View view) {
        this.hHW = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_number_txt);
        this.hHX = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_copy_txt);
        this.hHX.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_person_center_list_qq_group_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.personcenter.c.b bVar) {
    }

    public void IM(String str) {
        this.hHY = str;
        if (this.hHW != null) {
            this.hHW.setText(getContext().getResources().getString(R.string.ala_person_center_qq_group) + str);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.hHW, (int) R.color.common_color_10106);
        ap.setViewTextColor(this.hHX, (int) R.color.cp_link_tip_a);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.hHY)) {
            UtilHelper.copyToClipBoard(this.hHY);
        }
        BdToast.b(getContext(), getContext().getResources().getString(R.string.ala_person_center_copy_to_clipboard)).oG(17).bpi();
    }
}
