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
    private TextView fsg;
    private TextView fsh;
    private TextView fsi;
    private TextView fsj;
    private TextView fsk;
    private ImageView fsl;
    private ImageView fsm;
    private ProgressBar fsn;
    private FrameLayout fso;
    private View fsp;
    private d fsq;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView(getView());
    }

    private void initView(View view) {
        this.fso = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.fsg = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.fsh = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.fsi = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.fsj = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.fsk = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.fsl = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.fsn = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.fsm = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.fsp = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.bpA() != null) {
            this.fsq = dVar;
            if (personCenterData.bpA().live_status != 1 && !personCenterData.isHost()) {
                this.fsp.setVisibility(8);
                this.fsj.setVisibility(8);
                this.fsk.setVisibility(8);
            } else {
                this.fsp.setVisibility(0);
                this.fsj.setVisibility(0);
                this.fsk.setVisibility(0);
            }
            int i = personCenterData.bpA().level_id;
            if (i > 40) {
                i = 40;
            }
            this.fsg.setText("Lv" + Integer.toString(i));
            this.fsh.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.fsi.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.fsi.setVisibility(8);
            }
            if (i <= 10) {
                this.fsl.setBackgroundResource(R.drawable.icon_live_level_1);
                this.fsg.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.fsl.setBackgroundResource(R.drawable.icon_live_level_2);
                this.fsg.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.fsl.setBackgroundResource(R.drawable.icon_live_level_3);
                this.fsg.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.fsl.setBackgroundResource(R.drawable.icon_live_level_4);
                this.fsg.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.fsg.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.fsl.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.fsn.setMax(personCenterData.bpA().next_exp);
            this.fsn.setProgress(personCenterData.bpA().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.bpA().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.bpA().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.cp_cont_g)), length, sb.length(), 33);
            this.fsj.setText(spannableString);
            if (i >= 40) {
                this.fsk.setText(R.string.ala_level_max_tips);
            } else {
                this.fsk.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.bpA().next_exp - personCenterData.bpA().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.fso, R.drawable.bg_live_mine);
        am.setBackgroundResource(this.fsm, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.fsh.setAlpha(0.7f);
            this.fsi.setAlpha(0.7f);
            this.fsk.setAlpha(0.7f);
            this.fsj.setAlpha(0.7f);
            this.fsn.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (brY() != null) {
            brY().a(view, this.fsq);
        }
    }
}
