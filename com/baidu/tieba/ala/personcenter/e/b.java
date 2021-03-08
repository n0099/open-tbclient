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
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.b<f> {
    private TextView ifl;
    private TextView ifm;
    private TextView ifn;
    private TextView ifo;
    private TextView ifp;
    private ImageView ifq;
    private ImageView ifr;
    private ProgressBar ifs;
    private FrameLayout ift;
    private View ifu;
    private f ifv;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        am(getView());
    }

    private void am(View view) {
        this.ift = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.ifl = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.ifm = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.ifn = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.ifo = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.ifp = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.ifq = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.ifs = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.ifr = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.ifu = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.cnc() != null) {
            this.ifv = fVar;
            if (personCenterData.cnc().live_status != 1 && !personCenterData.isHost()) {
                this.ifu.setVisibility(8);
                this.ifo.setVisibility(8);
                this.ifp.setVisibility(8);
            } else {
                this.ifu.setVisibility(0);
                this.ifo.setVisibility(0);
                this.ifp.setVisibility(0);
            }
            int i = personCenterData.cnc().level_id;
            if (i > 40) {
                i = 40;
            }
            this.ifl.setText("Lv" + Integer.toString(i));
            this.ifm.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.ifn.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.ifn.setVisibility(8);
            }
            if (i <= 10) {
                this.ifq.setBackgroundResource(R.drawable.icon_live_level_1);
                this.ifl.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.ifq.setBackgroundResource(R.drawable.icon_live_level_2);
                this.ifl.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.ifq.setBackgroundResource(R.drawable.icon_live_level_3);
                this.ifl.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.ifq.setBackgroundResource(R.drawable.icon_live_level_4);
                this.ifl.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.ifl.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.ifq.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.ifs.setMax(personCenterData.cnc().next_exp);
            this.ifs.setProgress(personCenterData.cnc().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.cnc().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.cnc().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.CAM_X0111)), length, sb.length(), 33);
            this.ifo.setText(spannableString);
            if (i >= 40) {
                this.ifp.setText("");
            } else {
                this.ifp.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.cnc().next_exp - personCenterData.cnc().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.ift, R.drawable.bg_live_mine);
        ap.setBackgroundResource(this.ifr, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.ifm.setAlpha(0.7f);
            this.ifn.setAlpha(0.7f);
            this.ifp.setAlpha(0.7f);
            this.ifo.setAlpha(0.7f);
            this.ifs.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (csi() != null) {
            csi().a(view, this.ifv);
        }
    }
}
