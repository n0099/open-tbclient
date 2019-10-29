package com.baidu.tieba.ala.personcenter.d;

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
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<d> {
    private TextView eBA;
    private ImageView eBB;
    private ImageView eBC;
    private ProgressBar eBD;
    private FrameLayout eBE;
    private View eBF;
    private d eBG;
    private TextView eBw;
    private TextView eBx;
    private TextView eBy;
    private TextView eBz;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        W(getView());
    }

    private void W(View view) {
        this.eBE = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.eBw = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.eBx = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.eBy = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.eBz = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.eBA = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.eBB = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.eBD = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.eBC = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.eBF = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.aXE() != null) {
            this.eBG = dVar;
            if (personCenterData.aXE().live_status != 1 && !personCenterData.isHost()) {
                this.eBF.setVisibility(8);
                this.eBz.setVisibility(8);
                this.eBA.setVisibility(8);
            } else {
                this.eBF.setVisibility(0);
                this.eBz.setVisibility(0);
                this.eBA.setVisibility(0);
            }
            int i = personCenterData.aXE().level_id;
            if (i > 40) {
                i = 40;
            }
            this.eBw.setText("Lv" + Integer.toString(i));
            this.eBx.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.eBy.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.eBy.setVisibility(8);
            }
            if (i <= 10) {
                this.eBB.setBackgroundResource(R.drawable.icon_live_level_1);
                this.eBw.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.eBB.setBackgroundResource(R.drawable.icon_live_level_2);
                this.eBw.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.eBB.setBackgroundResource(R.drawable.icon_live_level_3);
                this.eBw.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.eBB.setBackgroundResource(R.drawable.icon_live_level_4);
                this.eBw.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.eBw.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.eBB.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.eBD.setMax(personCenterData.aXE().next_exp);
            this.eBD.setProgress(personCenterData.aXE().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.aXE().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.aXE().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.cp_cont_g)), length, sb.length(), 33);
            this.eBz.setText(spannableString);
            if (i >= 40) {
                this.eBA.setText(R.string.ala_level_max_tips);
            } else {
                this.eBA.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.aXE().next_exp - personCenterData.aXE().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.eBE, R.drawable.bg_live_mine);
        am.setBackgroundResource(this.eBC, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.eBx.setAlpha(0.7f);
            this.eBy.setAlpha(0.7f);
            this.eBA.setAlpha(0.7f);
            this.eBz.setAlpha(0.7f);
            this.eBD.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZX() != null) {
            aZX().a(view, this.eBG);
        }
    }
}
