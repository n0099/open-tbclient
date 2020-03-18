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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class e extends a<com.baidu.tieba.e.b> {
    private TbImageView eNB;
    private View fIA;
    private TextView fIC;
    private TextView fID;
    private TextView fIE;
    private TextView fIF;
    private com.baidu.tieba.e.b fIG;
    private LinearLayout fIp;
    private RelativeLayout fIr;
    private ImageView fIt;
    private ClickableHeaderImageView fIw;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.fIp = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.fIr = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.eNB = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.fIt = (ImageView) view.findViewById(R.id.img_play);
        this.fIC = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.fID = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.fIw = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.fIE = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.fIF = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.fIA = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.eNB.setDefaultBgResource(R.drawable.icon_morenpic);
        this.eNB.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fIr.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.fIr.setLayoutParams(layoutParams);
        this.fIw.setDefaultResource(17170445);
        this.fIw.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fIw.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fIw.setIsRound(true);
        this.fIw.setDrawBorder(true);
        this.fIw.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fIw.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void rp(int i) {
        if (this.fIA != null) {
            this.fIA.setVisibility(i);
        }
    }

    public void w(int i, int i2, int i3, int i4) {
        if (this.fIp != null) {
            this.fIp.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.fIA, R.color.cp_bg_line_c);
            am.setViewTextColor(this.fIC, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jo(this.fIG.aAj().getId())) {
                am.setViewTextColor(this.fID, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.fID, (int) R.color.cp_cont_b);
            }
            am.setViewTextColor(this.fIE, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fIF, R.color.cp_cont_d, 1);
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
        if (bVar != null && bVar.aAj() != null) {
            this.fIG = bVar;
            String str = null;
            if (bVar.aAj().aBe()) {
                this.fIt.setVisibility(0);
                this.fIC.setVisibility(0);
                if (bVar.aAj().aCI() != null) {
                    this.fIC.setText(aq.stringForVideoTime(bVar.aAj().aCI().video_duration.intValue() * 1000));
                    str = bVar.aAj().aCI().thumbnail_url;
                }
            } else {
                this.fIt.setVisibility(8);
                this.fIC.setVisibility(8);
                if (bVar.aAj().aCB() != null && bVar.aAj().aCB().size() >= 1) {
                    str = bVar.aAj().aCB().get(0).origin_pic;
                }
            }
            this.eNB.startLoad(str, 10, false);
            this.fID.setText(bVar.aAj().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jo(bVar.aAj().getId())) {
                am.setViewTextColor(this.fID, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.fID, (int) R.color.cp_cont_b);
            }
            this.fIw.setData(bVar.aAj(), false);
            this.fIF.setText(aq.getFormatTimeShort(bVar.aAj().aCa()));
            if ("news".equals(bVar.aAj().aCg())) {
                this.fIw.setVisibility(8);
                this.fIE.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, aq.numberUniformFormat(bVar.aAj().aCj())));
                return;
            }
            this.fIw.setVisibility(0);
            h(bVar.aAj());
        }
    }

    private void h(bj bjVar) {
        if (this.fIE != null && bjVar != null) {
            this.fIE.setVisibility(0);
            if (!StringUtils.isNull(bjVar.aCr().getName_show())) {
                this.fIE.setText(tY(bjVar.aCr().getName_show()));
            }
        }
    }

    protected String tY(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void rq(int i) {
        this.fIw.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buM() != null) {
            buM().a(getView(), this.fIG);
        }
    }
}
