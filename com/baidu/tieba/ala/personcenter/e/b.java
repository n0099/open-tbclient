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
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.b<f> {
    private TextView hQZ;
    private TextView hRa;
    private TextView hRb;
    private TextView hRc;
    private TextView hRd;
    private ImageView hRe;
    private ImageView hRf;
    private ProgressBar hRg;
    private FrameLayout hRh;
    private View hRi;
    private f hRj;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        an(getView());
    }

    private void an(View view) {
        this.hRh = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.hQZ = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.hRa = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.hRb = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.hRc = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.hRd = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.hRe = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.hRg = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.hRf = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.hRi = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.cmP() != null) {
            this.hRj = fVar;
            if (personCenterData.cmP().live_status != 1 && !personCenterData.isHost()) {
                this.hRi.setVisibility(8);
                this.hRc.setVisibility(8);
                this.hRd.setVisibility(8);
            } else {
                this.hRi.setVisibility(0);
                this.hRc.setVisibility(0);
                this.hRd.setVisibility(0);
            }
            int i = personCenterData.cmP().level_id;
            if (i > 40) {
                i = 40;
            }
            this.hQZ.setText("Lv" + Integer.toString(i));
            this.hRa.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.hRb.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.hRb.setVisibility(8);
            }
            if (i <= 10) {
                this.hRe.setBackgroundResource(R.drawable.icon_live_level_1);
                this.hQZ.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.hRe.setBackgroundResource(R.drawable.icon_live_level_2);
                this.hQZ.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.hRe.setBackgroundResource(R.drawable.icon_live_level_3);
                this.hQZ.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.hRe.setBackgroundResource(R.drawable.icon_live_level_4);
                this.hQZ.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.hQZ.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.hRe.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.hRg.setMax(personCenterData.cmP().next_exp);
            this.hRg.setProgress(personCenterData.cmP().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.cmP().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.cmP().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.CAM_X0111)), length, sb.length(), 33);
            this.hRc.setText(spannableString);
            if (i >= 40) {
                this.hRd.setText("");
            } else {
                this.hRd.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.cmP().next_exp - personCenterData.cmP().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.hRh, R.drawable.bg_live_mine);
        ap.setBackgroundResource(this.hRf, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.hRa.setAlpha(0.7f);
            this.hRb.setAlpha(0.7f);
            this.hRd.setAlpha(0.7f);
            this.hRc.setAlpha(0.7f);
            this.hRg.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crI() != null) {
            crI().a(view, this.hRj);
        }
    }
}
