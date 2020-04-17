package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.special_forum.data.e> {
    private View cTp;
    private View dvs;
    private TextView eRE;
    private ImageView eRF;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.cTp = getView();
        this.eRE = (TextView) getView().findViewById(R.id.tv_empty);
        this.eRF = (ImageView) getView().findViewById(R.id.iv_empty);
        this.dvs = getView().findViewById(R.id.id_tab_live_sub_empty_divider);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.cTp, R.color.cp_bg_line_d);
        am.setViewTextColor(this.eRE, (int) R.color.cp_cont_d);
        am.setImageResource(this.eRF, R.drawable.new_pic_emotion_08);
        am.setBackgroundResource(this.dvs, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_sub_concern_empty;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.e eVar) {
        if (eVar.followStatus == 1) {
            this.eRE.setText(this.mTbPageContext.getResources().getString(R.string.live_sub_tab_no_attention_txt));
            am.setImageResource(this.eRF, R.drawable.new_pic_emotion_07);
            return;
        }
        this.eRE.setText(this.mTbPageContext.getResources().getString(R.string.live_sub_tab_empty_txt));
        am.setImageResource(this.eRF, R.drawable.new_pic_emotion_06);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
