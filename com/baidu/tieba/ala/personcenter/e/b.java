package com.baidu.tieba.ala.personcenter.e;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.c.e;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.b<e> {
    private TextView gKF;
    private TextView gKG;
    private TextView gKH;
    private TextView gKI;
    private TextView gKJ;
    private ImageView gKK;
    private ImageView gKL;
    private ProgressBar gKM;
    private FrameLayout gKN;
    private View gKO;
    private e gKP;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        aj(getView());
    }

    private void aj(View view) {
        this.gKN = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.gKF = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.gKG = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.gKH = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.gKI = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.gKJ = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.gKK = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.gKM = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.gKL = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.gKO = view.findViewById(R.id.ala_person_center_level_layout);
        getView().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_person_center_list_head_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    /* renamed from: b */
    public void a(e eVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData = eVar.getPersonCenterData();
        if (personCenterData != null && personCenterData.bOD() != null) {
            this.gKP = eVar;
            if (personCenterData.bOD().live_status != 1 && !personCenterData.isHost()) {
                this.gKO.setVisibility(8);
                this.gKI.setVisibility(8);
                this.gKJ.setVisibility(8);
            } else {
                this.gKO.setVisibility(0);
                this.gKI.setVisibility(0);
                this.gKJ.setVisibility(0);
            }
            int i = personCenterData.bOD().level_id;
            if (i > 40) {
                i = 40;
            }
            this.gKF.setText("Lv" + Integer.toString(i));
            this.gKG.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.gKH.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.gKH.setVisibility(8);
            }
            if (i <= 10) {
                this.gKK.setBackgroundResource(R.drawable.icon_live_level_1);
                this.gKF.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.gKK.setBackgroundResource(R.drawable.icon_live_level_2);
                this.gKF.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.gKK.setBackgroundResource(R.drawable.icon_live_level_3);
                this.gKF.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.gKK.setBackgroundResource(R.drawable.icon_live_level_4);
                this.gKF.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.gKF.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.gKK.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.gKM.setMax(personCenterData.bOD().next_exp);
            this.gKM.setProgress(personCenterData.bOD().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.bOD().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.bOD().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.cp_cont_g)), length, sb.length(), 33);
            this.gKI.setText(spannableString);
            if (i >= 40) {
                this.gKJ.setText(R.string.ala_level_max_tips);
            } else {
                this.gKJ.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.bOD().next_exp - personCenterData.bOD().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundResource(this.gKN, R.drawable.bg_live_mine);
        ao.setBackgroundResource(this.gKL, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.gKG.setAlpha(0.7f);
            this.gKH.setAlpha(0.7f);
            this.gKJ.setAlpha(0.7f);
            this.gKI.setAlpha(0.7f);
            this.gKM.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bRn() != null) {
            bRn().a(view, this.gKP);
        }
    }
}
