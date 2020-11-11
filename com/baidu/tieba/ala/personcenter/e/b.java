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
    private TextView hHL;
    private TextView hHM;
    private TextView hHN;
    private TextView hHO;
    private TextView hHP;
    private ImageView hHQ;
    private ImageView hHR;
    private ProgressBar hHS;
    private FrameLayout hHT;
    private View hHU;
    private f hHV;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        al(getView());
    }

    private void al(View view) {
        this.hHT = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.hHL = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.hHM = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.hHN = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.hHO = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.hHP = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.hHQ = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.hHS = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.hHR = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.hHU = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.cjC() != null) {
            this.hHV = fVar;
            if (personCenterData.cjC().live_status != 1 && !personCenterData.isHost()) {
                this.hHU.setVisibility(8);
                this.hHO.setVisibility(8);
                this.hHP.setVisibility(8);
            } else {
                this.hHU.setVisibility(0);
                this.hHO.setVisibility(0);
                this.hHP.setVisibility(0);
            }
            int i = personCenterData.cjC().level_id;
            if (i > 40) {
                i = 40;
            }
            this.hHL.setText("Lv" + Integer.toString(i));
            this.hHM.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.hHN.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.hHN.setVisibility(8);
            }
            if (i <= 10) {
                this.hHQ.setBackgroundResource(R.drawable.icon_live_level_1);
                this.hHL.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.hHQ.setBackgroundResource(R.drawable.icon_live_level_2);
                this.hHL.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.hHQ.setBackgroundResource(R.drawable.icon_live_level_3);
                this.hHL.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.hHQ.setBackgroundResource(R.drawable.icon_live_level_4);
                this.hHL.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.hHL.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.hHQ.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.hHS.setMax(personCenterData.cjC().next_exp);
            this.hHS.setProgress(personCenterData.cjC().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.cjC().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.cjC().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.cp_cont_g)), length, sb.length(), 33);
            this.hHO.setText(spannableString);
            if (i >= 40) {
                this.hHP.setText(R.string.ala_level_max_tips);
            } else {
                this.hHP.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.cjC().next_exp - personCenterData.cjC().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.hHT, R.drawable.bg_live_mine);
        ap.setBackgroundResource(this.hHR, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.hHM.setAlpha(0.7f);
            this.hHN.setAlpha(0.7f);
            this.hHP.setAlpha(0.7f);
            this.hHO.setAlpha(0.7f);
            this.hHS.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cnT() != null) {
            cnT().a(view, this.hHV);
        }
    }
}
