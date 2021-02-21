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
/* loaded from: classes10.dex */
public class b extends com.baidu.tieba.card.b<f> {
    private TextView idC;
    private TextView idD;
    private TextView idE;
    private TextView idF;
    private TextView idG;
    private ImageView idH;
    private ImageView idI;
    private ProgressBar idJ;
    private FrameLayout idK;
    private View idL;
    private f idM;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        am(getView());
    }

    private void am(View view) {
        this.idK = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.idC = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.idD = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.idE = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.idF = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.idG = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.idH = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.idJ = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.idI = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.idL = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.cmW() != null) {
            this.idM = fVar;
            if (personCenterData.cmW().live_status != 1 && !personCenterData.isHost()) {
                this.idL.setVisibility(8);
                this.idF.setVisibility(8);
                this.idG.setVisibility(8);
            } else {
                this.idL.setVisibility(0);
                this.idF.setVisibility(0);
                this.idG.setVisibility(0);
            }
            int i = personCenterData.cmW().level_id;
            if (i > 40) {
                i = 40;
            }
            this.idC.setText("Lv" + Integer.toString(i));
            this.idD.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.idE.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.idE.setVisibility(8);
            }
            if (i <= 10) {
                this.idH.setBackgroundResource(R.drawable.icon_live_level_1);
                this.idC.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.idH.setBackgroundResource(R.drawable.icon_live_level_2);
                this.idC.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.idH.setBackgroundResource(R.drawable.icon_live_level_3);
                this.idC.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.idH.setBackgroundResource(R.drawable.icon_live_level_4);
                this.idC.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.idC.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.idH.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.idJ.setMax(personCenterData.cmW().next_exp);
            this.idJ.setProgress(personCenterData.cmW().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.cmW().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.cmW().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.CAM_X0111)), length, sb.length(), 33);
            this.idF.setText(spannableString);
            if (i >= 40) {
                this.idG.setText("");
            } else {
                this.idG.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.cmW().next_exp - personCenterData.cmW().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.idK, R.drawable.bg_live_mine);
        ap.setBackgroundResource(this.idI, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.idD.setAlpha(0.7f);
            this.idE.setAlpha(0.7f);
            this.idG.setAlpha(0.7f);
            this.idF.setAlpha(0.7f);
            this.idJ.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (csc() != null) {
            csc().a(view, this.idM);
        }
    }
}
