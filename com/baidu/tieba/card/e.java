package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends a<com.baidu.tieba.e.b> {
    private TbImageView dSg;
    private LinearLayout eJN;
    private RelativeLayout eJP;
    private ImageView eJR;
    private ClickableHeaderImageView eJU;
    private View eJY;
    private TextView eKa;
    private TextView eKb;
    private TextView eKc;
    private TextView eKd;
    private com.baidu.tieba.e.b eKe;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.eJN = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.eJP = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.dSg = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.eJR = (ImageView) view.findViewById(R.id.img_play);
        this.eKa = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.eKb = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.eJU = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.eKc = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.eKd = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.eJY = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.dSg.setDefaultBgResource(R.drawable.icon_morenpic);
        this.dSg.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eJP.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.eJP.setLayoutParams(layoutParams);
        this.eJU.setDefaultResource(17170445);
        this.eJU.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eJU.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eJU.setIsRound(true);
        this.eJU.setDrawBorder(true);
        this.eJU.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eJU.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void oI(int i) {
        if (this.eJY != null) {
            this.eJY.setVisibility(i);
        }
    }

    public void s(int i, int i2, int i3, int i4) {
        if (this.eJN != null) {
            this.eJN.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.eJY, R.color.cp_bg_line_c);
            am.setViewTextColor(this.eKa, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ec(this.eKe.agG().getId())) {
                am.setViewTextColor(this.eKb, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.eKb, (int) R.color.cp_cont_b);
            }
            am.setViewTextColor(this.eKc, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.eKd, R.color.cp_cont_d, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_common_small_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.b bVar) {
        if (bVar != null && bVar.agG() != null) {
            this.eKe = bVar;
            String str = null;
            if (bVar.agG().ajy()) {
                this.eJR.setVisibility(0);
                this.eKa.setVisibility(0);
                if (bVar.agG().aiV() != null) {
                    this.eKa.setText(aq.stringForVideoTime(bVar.agG().aiV().video_duration.intValue() * 1000));
                    str = bVar.agG().aiV().thumbnail_url;
                }
            } else {
                this.eJR.setVisibility(8);
                this.eKa.setVisibility(8);
                if (bVar.agG().aiO() != null && bVar.agG().aiO().size() >= 1) {
                    str = bVar.agG().aiO().get(0).origin_pic;
                }
            }
            this.dSg.startLoad(str, 10, false);
            this.eKb.setText(bVar.agG().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ec(bVar.agG().getId())) {
                am.setViewTextColor(this.eKb, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.eKb, (int) R.color.cp_cont_b);
            }
            this.eJU.setData(bVar.agG(), false);
            this.eKd.setText(aq.getFormatTimeShort(bVar.agG().aio()));
            if ("news".equals(bVar.agG().ait())) {
                this.eJU.setVisibility(8);
                this.eKc.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, aq.numberUniformFormat(bVar.agG().aiw())));
                return;
            }
            this.eJU.setVisibility(0);
            g(bVar.agG());
        }
    }

    private void g(bh bhVar) {
        if (this.eKc != null && bhVar != null) {
            this.eKc.setVisibility(0);
            if (!StringUtils.isNull(bhVar.aiE().getName_show())) {
                this.eKc.setText(oA(bhVar.aiE().getName_show()));
            }
        }
    }

    protected String oA(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void oJ(int i) {
        this.eJU.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZV() != null) {
            aZV().a(getView(), this.eKe);
        }
    }
}
