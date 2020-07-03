package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.special_forum.data.e> {
    private View dQh;
    private View djj;
    private TextView fpN;
    private ImageView fpO;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.djj = getView();
        this.fpN = (TextView) getView().findViewById(R.id.tv_empty);
        this.fpO = (ImageView) getView().findViewById(R.id.iv_empty);
        this.dQh = getView().findViewById(R.id.id_tab_live_sub_empty_divider);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        an.setBackgroundResource(this.djj, R.color.cp_bg_line_d);
        an.setViewTextColor(this.fpN, (int) R.color.cp_cont_d);
        an.setImageResource(this.fpO, R.drawable.new_pic_emotion_08);
        an.setBackgroundResource(this.dQh, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_concern_empty;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.e eVar) {
        if (eVar.followStatus == 1) {
            this.fpN.setText(this.mTbPageContext.getResources().getString(R.string.live_sub_tab_no_attention_txt));
            an.setImageResource(this.fpO, R.drawable.new_pic_emotion_07);
            return;
        }
        this.fpN.setText(this.mTbPageContext.getResources().getString(R.string.live_sub_tab_empty_txt));
        an.setImageResource(this.fpO, R.drawable.new_pic_emotion_06);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
