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
    private TextView hRb;
    private TextView hRc;
    private TextView hRd;
    private TextView hRe;
    private TextView hRf;
    private ImageView hRg;
    private ImageView hRh;
    private ProgressBar hRi;
    private FrameLayout hRj;
    private View hRk;
    private f hRl;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        an(getView());
    }

    private void an(View view) {
        this.hRj = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.hRb = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.hRc = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.hRd = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.hRe = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.hRf = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.hRg = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.hRi = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.hRh = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.hRk = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.cmQ() != null) {
            this.hRl = fVar;
            if (personCenterData.cmQ().live_status != 1 && !personCenterData.isHost()) {
                this.hRk.setVisibility(8);
                this.hRe.setVisibility(8);
                this.hRf.setVisibility(8);
            } else {
                this.hRk.setVisibility(0);
                this.hRe.setVisibility(0);
                this.hRf.setVisibility(0);
            }
            int i = personCenterData.cmQ().level_id;
            if (i > 40) {
                i = 40;
            }
            this.hRb.setText("Lv" + Integer.toString(i));
            this.hRc.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.hRd.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.hRd.setVisibility(8);
            }
            if (i <= 10) {
                this.hRg.setBackgroundResource(R.drawable.icon_live_level_1);
                this.hRb.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.hRg.setBackgroundResource(R.drawable.icon_live_level_2);
                this.hRb.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.hRg.setBackgroundResource(R.drawable.icon_live_level_3);
                this.hRb.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.hRg.setBackgroundResource(R.drawable.icon_live_level_4);
                this.hRb.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.hRb.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.hRg.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.hRi.setMax(personCenterData.cmQ().next_exp);
            this.hRi.setProgress(personCenterData.cmQ().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.cmQ().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.cmQ().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.CAM_X0111)), length, sb.length(), 33);
            this.hRe.setText(spannableString);
            if (i >= 40) {
                this.hRf.setText("");
            } else {
                this.hRf.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.cmQ().next_exp - personCenterData.cmQ().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.hRj, R.drawable.bg_live_mine);
        ap.setBackgroundResource(this.hRh, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.hRc.setAlpha(0.7f);
            this.hRd.setAlpha(0.7f);
            this.hRf.setAlpha(0.7f);
            this.hRe.setAlpha(0.7f);
            this.hRi.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crJ() != null) {
            crJ().a(view, this.hRl);
        }
    }
}
