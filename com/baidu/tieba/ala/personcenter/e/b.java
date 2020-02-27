package com.baidu.tieba.ala.personcenter.e;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.c.d;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<d> {
    private TextView fxQ;
    private TextView fxR;
    private TextView fxS;
    private TextView fxT;
    private TextView fxU;
    private ImageView fxV;
    private ImageView fxW;
    private ProgressBar fxX;
    private FrameLayout fxY;
    private View fxZ;
    private d fya;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView(getView());
    }

    private void initView(View view) {
        this.fxY = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.fxQ = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.fxR = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.fxS = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.fxT = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.fxU = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.fxV = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.fxX = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.fxW = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.fxZ = view.findViewById(R.id.ala_person_center_level_layout);
        getView().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_person_center_list_head_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: b */
    public void a(d dVar) {
        com.baidu.tieba.ala.personcenter.c.b personCenterData = dVar.getPersonCenterData();
        if (personCenterData != null && personCenterData.bsf() != null) {
            this.fya = dVar;
            if (personCenterData.bsf().live_status != 1 && !personCenterData.isHost()) {
                this.fxZ.setVisibility(8);
                this.fxT.setVisibility(8);
                this.fxU.setVisibility(8);
            } else {
                this.fxZ.setVisibility(0);
                this.fxT.setVisibility(0);
                this.fxU.setVisibility(0);
            }
            int i = personCenterData.bsf().level_id;
            if (i > 40) {
                i = 40;
            }
            this.fxQ.setText("Lv" + Integer.toString(i));
            this.fxR.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.fxS.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.fxS.setVisibility(8);
            }
            if (i <= 10) {
                this.fxV.setBackgroundResource(R.drawable.icon_live_level_1);
                this.fxQ.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.fxV.setBackgroundResource(R.drawable.icon_live_level_2);
                this.fxQ.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.fxV.setBackgroundResource(R.drawable.icon_live_level_3);
                this.fxQ.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.fxV.setBackgroundResource(R.drawable.icon_live_level_4);
                this.fxQ.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.fxQ.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.fxV.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.fxX.setMax(personCenterData.bsf().next_exp);
            this.fxX.setProgress(personCenterData.bsf().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.bsf().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.bsf().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.cp_cont_g)), length, sb.length(), 33);
            this.fxT.setText(spannableString);
            if (i >= 40) {
                this.fxU.setText(R.string.ala_level_max_tips);
            } else {
                this.fxU.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.bsf().next_exp - personCenterData.bsf().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.fxY, R.drawable.bg_live_mine);
        am.setBackgroundResource(this.fxW, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.fxR.setAlpha(0.7f);
            this.fxS.setAlpha(0.7f);
            this.fxU.setAlpha(0.7f);
            this.fxT.setAlpha(0.7f);
            this.fxX.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buE() != null) {
            buE().a(view, this.fya);
        }
    }
}
