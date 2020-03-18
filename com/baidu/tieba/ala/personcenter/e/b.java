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
    private TextView fyK;
    private TextView fyL;
    private TextView fyM;
    private TextView fyN;
    private TextView fyO;
    private ImageView fyP;
    private ImageView fyQ;
    private ProgressBar fyR;
    private FrameLayout fyS;
    private View fyT;
    private d fyU;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView(getView());
    }

    private void initView(View view) {
        this.fyS = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.fyK = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.fyL = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.fyM = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.fyN = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.fyO = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.fyP = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.fyR = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.fyQ = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.fyT = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.bso() != null) {
            this.fyU = dVar;
            if (personCenterData.bso().live_status != 1 && !personCenterData.isHost()) {
                this.fyT.setVisibility(8);
                this.fyN.setVisibility(8);
                this.fyO.setVisibility(8);
            } else {
                this.fyT.setVisibility(0);
                this.fyN.setVisibility(0);
                this.fyO.setVisibility(0);
            }
            int i = personCenterData.bso().level_id;
            if (i > 40) {
                i = 40;
            }
            this.fyK.setText("Lv" + Integer.toString(i));
            this.fyL.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.fyM.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.fyM.setVisibility(8);
            }
            if (i <= 10) {
                this.fyP.setBackgroundResource(R.drawable.icon_live_level_1);
                this.fyK.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.fyP.setBackgroundResource(R.drawable.icon_live_level_2);
                this.fyK.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.fyP.setBackgroundResource(R.drawable.icon_live_level_3);
                this.fyK.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.fyP.setBackgroundResource(R.drawable.icon_live_level_4);
                this.fyK.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.fyK.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.fyP.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.fyR.setMax(personCenterData.bso().next_exp);
            this.fyR.setProgress(personCenterData.bso().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.bso().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.bso().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.cp_cont_g)), length, sb.length(), 33);
            this.fyN.setText(spannableString);
            if (i >= 40) {
                this.fyO.setText(R.string.ala_level_max_tips);
            } else {
                this.fyO.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.bso().next_exp - personCenterData.bso().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.fyS, R.drawable.bg_live_mine);
        am.setBackgroundResource(this.fyQ, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.fyL.setAlpha(0.7f);
            this.fyM.setAlpha(0.7f);
            this.fyO.setAlpha(0.7f);
            this.fyN.setAlpha(0.7f);
            this.fyR.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buM() != null) {
            buM().a(view, this.fyU);
        }
    }
}
