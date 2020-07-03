package com.baidu.tieba.ala.personcenter.e;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.c.e;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.b<e> {
    private TextView gFi;
    private TextView gFj;
    private TextView gFk;
    private TextView gFl;
    private TextView gFm;
    private ImageView gFn;
    private ImageView gFo;
    private ProgressBar gFp;
    private FrameLayout gFq;
    private View gFr;
    private e gFs;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ag(getView());
    }

    private void ag(View view) {
        this.gFq = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.gFi = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.gFj = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.gFk = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.gFl = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.gFm = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.gFn = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.gFp = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.gFo = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.gFr = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.bLu() != null) {
            this.gFs = eVar;
            if (personCenterData.bLu().live_status != 1 && !personCenterData.isHost()) {
                this.gFr.setVisibility(8);
                this.gFl.setVisibility(8);
                this.gFm.setVisibility(8);
            } else {
                this.gFr.setVisibility(0);
                this.gFl.setVisibility(0);
                this.gFm.setVisibility(0);
            }
            int i = personCenterData.bLu().level_id;
            if (i > 40) {
                i = 40;
            }
            this.gFi.setText("Lv" + Integer.toString(i));
            this.gFj.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.gFk.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.gFk.setVisibility(8);
            }
            if (i <= 10) {
                this.gFn.setBackgroundResource(R.drawable.icon_live_level_1);
                this.gFi.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.gFn.setBackgroundResource(R.drawable.icon_live_level_2);
                this.gFi.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.gFn.setBackgroundResource(R.drawable.icon_live_level_3);
                this.gFi.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.gFn.setBackgroundResource(R.drawable.icon_live_level_4);
                this.gFi.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.gFi.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.gFn.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.gFp.setMax(personCenterData.bLu().next_exp);
            this.gFp.setProgress(personCenterData.bLu().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.bLu().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.bLu().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.cp_cont_g)), length, sb.length(), 33);
            this.gFl.setText(spannableString);
            if (i >= 40) {
                this.gFm.setText(R.string.ala_level_max_tips);
            } else {
                this.gFm.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.bLu().next_exp - personCenterData.bLu().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        an.setBackgroundResource(this.gFq, R.drawable.bg_live_mine);
        an.setBackgroundResource(this.gFo, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.gFj.setAlpha(0.7f);
            this.gFk.setAlpha(0.7f);
            this.gFm.setAlpha(0.7f);
            this.gFl.setAlpha(0.7f);
            this.gFp.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bOc() != null) {
            bOc().a(view, this.gFs);
        }
    }
}
