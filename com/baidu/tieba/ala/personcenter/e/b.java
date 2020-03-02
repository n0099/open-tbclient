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
    private TextView fxR;
    private TextView fxS;
    private TextView fxT;
    private TextView fxU;
    private TextView fxV;
    private ImageView fxW;
    private ImageView fxX;
    private ProgressBar fxY;
    private FrameLayout fxZ;
    private View fya;
    private d fyb;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView(getView());
    }

    private void initView(View view) {
        this.fxZ = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.fxR = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.fxS = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.fxT = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.fxU = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.fxV = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.fxW = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.fxY = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.fxX = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.fya = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.bsh() != null) {
            this.fyb = dVar;
            if (personCenterData.bsh().live_status != 1 && !personCenterData.isHost()) {
                this.fya.setVisibility(8);
                this.fxU.setVisibility(8);
                this.fxV.setVisibility(8);
            } else {
                this.fya.setVisibility(0);
                this.fxU.setVisibility(0);
                this.fxV.setVisibility(0);
            }
            int i = personCenterData.bsh().level_id;
            if (i > 40) {
                i = 40;
            }
            this.fxR.setText("Lv" + Integer.toString(i));
            this.fxS.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.fxT.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.fxT.setVisibility(8);
            }
            if (i <= 10) {
                this.fxW.setBackgroundResource(R.drawable.icon_live_level_1);
                this.fxR.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.fxW.setBackgroundResource(R.drawable.icon_live_level_2);
                this.fxR.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.fxW.setBackgroundResource(R.drawable.icon_live_level_3);
                this.fxR.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.fxW.setBackgroundResource(R.drawable.icon_live_level_4);
                this.fxR.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.fxR.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.fxW.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.fxY.setMax(personCenterData.bsh().next_exp);
            this.fxY.setProgress(personCenterData.bsh().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.bsh().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.bsh().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.cp_cont_g)), length, sb.length(), 33);
            this.fxU.setText(spannableString);
            if (i >= 40) {
                this.fxV.setText(R.string.ala_level_max_tips);
            } else {
                this.fxV.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.bsh().next_exp - personCenterData.bsh().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.fxZ, R.drawable.bg_live_mine);
        am.setBackgroundResource(this.fxX, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.fxS.setAlpha(0.7f);
            this.fxT.setAlpha(0.7f);
            this.fxV.setAlpha(0.7f);
            this.fxU.setAlpha(0.7f);
            this.fxY.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buG() != null) {
            buG().a(view, this.fyb);
        }
    }
}
