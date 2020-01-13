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
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.a<d> {
    private TextView fvp;
    private TextView fvq;
    private TextView fvr;
    private TextView fvs;
    private TextView fvt;
    private ImageView fvu;
    private ImageView fvv;
    private ProgressBar fvw;
    private FrameLayout fvx;
    private View fvy;
    private d fvz;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView(getView());
    }

    private void initView(View view) {
        this.fvx = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.fvp = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.fvq = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.fvr = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.fvs = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.fvt = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.fvu = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.fvw = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.fvv = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.fvy = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.bqB() != null) {
            this.fvz = dVar;
            if (personCenterData.bqB().live_status != 1 && !personCenterData.isHost()) {
                this.fvy.setVisibility(8);
                this.fvs.setVisibility(8);
                this.fvt.setVisibility(8);
            } else {
                this.fvy.setVisibility(0);
                this.fvs.setVisibility(0);
                this.fvt.setVisibility(0);
            }
            int i = personCenterData.bqB().level_id;
            if (i > 40) {
                i = 40;
            }
            this.fvp.setText("Lv" + Integer.toString(i));
            this.fvq.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.fvr.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.fvr.setVisibility(8);
            }
            if (i <= 10) {
                this.fvu.setBackgroundResource(R.drawable.icon_live_level_1);
                this.fvp.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.fvu.setBackgroundResource(R.drawable.icon_live_level_2);
                this.fvp.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.fvu.setBackgroundResource(R.drawable.icon_live_level_3);
                this.fvp.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.fvu.setBackgroundResource(R.drawable.icon_live_level_4);
                this.fvp.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.fvp.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.fvu.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.fvw.setMax(personCenterData.bqB().next_exp);
            this.fvw.setProgress(personCenterData.bqB().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.bqB().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.bqB().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.cp_cont_g)), length, sb.length(), 33);
            this.fvs.setText(spannableString);
            if (i >= 40) {
                this.fvt.setText(R.string.ala_level_max_tips);
            } else {
                this.fvt.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.bqB().next_exp - personCenterData.bqB().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.fvx, R.drawable.bg_live_mine);
        am.setBackgroundResource(this.fvv, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.fvq.setAlpha(0.7f);
            this.fvr.setAlpha(0.7f);
            this.fvt.setAlpha(0.7f);
            this.fvs.setAlpha(0.7f);
            this.fvw.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bta() != null) {
            bta().a(view, this.fvz);
        }
    }
}
