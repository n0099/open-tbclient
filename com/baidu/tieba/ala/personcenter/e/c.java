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
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.personcenter.c.b> {
    private TextView gsF;
    private TextView gsG;
    private String gsH;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ag(getView());
    }

    private void ag(View view) {
        this.gsF = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_number_txt);
        this.gsG = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_copy_txt);
        this.gsG.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_person_center_list_qq_group_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.personcenter.c.b bVar) {
    }

    public void Dd(String str) {
        this.gsH = str;
        if (this.gsF != null) {
            this.gsF.setText(getContext().getResources().getString(R.string.ala_person_center_qq_group) + str);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.gsF, (int) R.color.common_color_10106);
        am.setViewTextColor(this.gsG, (int) R.color.cp_link_tip_a);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.gsH)) {
            UtilHelper.copyToClipBoard(this.gsH);
        }
        BdToast.b(getContext(), getContext().getResources().getString(R.string.ala_person_center_copy_to_clipboard)).kO(17).aSY();
    }
}
