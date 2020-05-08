package com.baidu.tieba.ala.personcenter.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.ala.personcenter.c.b> {
    private TextView gdA;
    private TextView gdB;
    private String gdC;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ag(getView());
    }

    private void ag(View view) {
        this.gdA = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_number_txt);
        this.gdB = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_copy_txt);
        this.gdB.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_person_center_list_qq_group_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.personcenter.c.b bVar) {
    }

    public void Bu(String str) {
        this.gdC = str;
        if (this.gdA != null) {
            this.gdA.setText(getContext().getResources().getString(R.string.ala_person_center_qq_group) + str);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.gdA, (int) R.color.common_color_10106);
        am.setViewTextColor(this.gdB, (int) R.color.cp_link_tip_a);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.gdC)) {
            UtilHelper.copyToClipBoard(this.gdC);
        }
        BdToast.b(getContext(), getContext().getResources().getString(R.string.ala_person_center_copy_to_clipboard)).km(17).aMX();
    }
}
