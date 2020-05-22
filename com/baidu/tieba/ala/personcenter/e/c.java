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
    private TextView gsu;
    private TextView gsv;
    private String gsw;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ag(getView());
    }

    private void ag(View view) {
        this.gsu = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_number_txt);
        this.gsv = (TextView) view.findViewById(R.id.ala_person_center_qq_group_item_copy_txt);
        this.gsv.setOnClickListener(this);
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
        this.gsw = str;
        if (this.gsu != null) {
            this.gsu.setText(getContext().getResources().getString(R.string.ala_person_center_qq_group) + str);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.gsu, (int) R.color.common_color_10106);
        am.setViewTextColor(this.gsv, (int) R.color.cp_link_tip_a);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.gsw)) {
            UtilHelper.copyToClipBoard(this.gsw);
        }
        BdToast.b(getContext(), getContext().getResources().getString(R.string.ala_person_center_copy_to_clipboard)).kM(17).aSY();
    }
}
