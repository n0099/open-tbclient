package com.baidu.tieba.ala.personcenter.e;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.c.f;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.b<f> {
    private FrameLayout hHA;
    private View hHB;
    private f hHC;
    private TextView hHs;
    private TextView hHt;
    private TextView hHu;
    private TextView hHv;
    private TextView hHw;
    private ImageView hHx;
    private ImageView hHy;
    private ProgressBar hHz;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        al(getView());
    }

    private void al(View view) {
        this.hHA = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.hHs = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.hHt = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.hHu = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.hHv = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.hHw = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.hHx = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.hHz = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.hHy = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.hHB = view.findViewById(R.id.ala_person_center_level_layout);
        getView().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_person_center_list_head_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    /* renamed from: b */
    public void a(f fVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData = fVar.getPersonCenterData();
        if (personCenterData != null && personCenterData.ciV() != null) {
            this.hHC = fVar;
            if (personCenterData.ciV().live_status != 1 && !personCenterData.isHost()) {
                this.hHB.setVisibility(8);
                this.hHv.setVisibility(8);
                this.hHw.setVisibility(8);
            } else {
                this.hHB.setVisibility(0);
                this.hHv.setVisibility(0);
                this.hHw.setVisibility(0);
            }
            int i = personCenterData.ciV().level_id;
            if (i > 40) {
                i = 40;
            }
            this.hHs.setText("Lv" + Integer.toString(i));
            this.hHt.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.hHu.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.hHu.setVisibility(8);
            }
            if (i <= 10) {
                this.hHx.setBackgroundResource(R.drawable.icon_live_level_1);
                this.hHs.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.hHx.setBackgroundResource(R.drawable.icon_live_level_2);
                this.hHs.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.hHx.setBackgroundResource(R.drawable.icon_live_level_3);
                this.hHs.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.hHx.setBackgroundResource(R.drawable.icon_live_level_4);
                this.hHs.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.hHs.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.hHx.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.hHz.setMax(personCenterData.ciV().next_exp);
            this.hHz.setProgress(personCenterData.ciV().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.ciV().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.ciV().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.CAM_X0111)), length, sb.length(), 33);
            this.hHv.setText(spannableString);
            if (i >= 40) {
                this.hHw.setText("");
            } else {
                this.hHw.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.ciV().next_exp - personCenterData.ciV().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.hHA, R.drawable.bg_live_mine);
        ap.setBackgroundResource(this.hHy, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.hHt.setAlpha(0.7f);
            this.hHu.setAlpha(0.7f);
            this.hHw.setAlpha(0.7f);
            this.hHv.setAlpha(0.7f);
            this.hHz.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cnv() != null) {
            cnv().a(view, this.hHC);
        }
    }
}
