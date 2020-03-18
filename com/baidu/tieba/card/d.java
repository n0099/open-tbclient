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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes9.dex */
public class d extends a<com.baidu.tieba.e.a> {
    private View fIA;
    private com.baidu.tieba.e.a fIB;
    private LinearLayout fIp;
    private TextView fIq;
    private RelativeLayout fIr;
    private TbImageView fIs;
    private ImageView fIt;
    private TextView fIu;
    private RelativeLayout fIv;
    private ClickableHeaderImageView fIw;
    private TextView fIx;
    private TextView fIy;
    private TextView fIz;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.fIp = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.fIq = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.fIr = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.fIs = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.fIt = (ImageView) view.findViewById(R.id.img_play);
        this.fIu = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.fIv = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.fIw = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.fIx = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.fIy = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.fIz = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.fIA = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.fIs.setDefaultBgResource(R.drawable.icon_morenpic);
        this.fIs.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fIr.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.fIr.setLayoutParams(layoutParams);
        this.fIz.setOnClickListener(this);
        this.fIw.setDefaultResource(17170445);
        this.fIw.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fIw.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fIw.setIsRound(true);
        this.fIw.setDrawBorder(true);
        this.fIw.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fIw.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void v(int i, int i2, int i3, int i4) {
        if (this.fIp != null) {
            this.fIp.setPadding(i, i2, i3, i4);
        }
    }

    public void ro(int i) {
        if (this.fIv != null) {
            this.fIv.setVisibility(i);
        }
    }

    public void rp(int i) {
        if (this.fIA != null) {
            this.fIA.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.fIA, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jo(this.fIB.aAj().getId())) {
                am.setViewTextColor(this.fIq, R.color.cp_cont_c, 1);
            } else {
                am.setViewTextColor(this.fIq, R.color.cp_cont_b, 1);
            }
            am.setViewTextColor(this.fIx, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fIy, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fIz, R.color.cp_link_tip_c, 1);
            am.setViewTextColor(this.fIu, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_common_big_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.a aVar) {
        if (aVar != null && aVar.aAj() != null) {
            this.fIB = aVar;
            String str = null;
            if (aVar.aAj().aBe()) {
                this.fIt.setVisibility(0);
                this.fIu.setVisibility(0);
                if (aVar.aAj().aCI() != null) {
                    this.fIu.setText(aq.stringForVideoTime(aVar.aAj().aCI().video_duration.intValue() * 1000));
                    str = aVar.aAj().aCI().thumbnail_url;
                }
            } else {
                this.fIt.setVisibility(8);
                this.fIu.setVisibility(4);
                if (aVar.aAj().aCB() != null && aVar.aAj().aCB().size() >= 1) {
                    str = aVar.aAj().aCB().get(0).origin_pic;
                }
            }
            this.fIs.startLoad(str, 10, false);
            this.fIq.setText(aVar.aAj().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jo(aVar.aAj().getId())) {
                am.setViewTextColor(this.fIq, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.fIq, (int) R.color.cp_cont_b);
            }
            this.fIw.setData(aVar.aAj(), false);
            h(aVar.aAj());
            this.fIy.setText(aq.getFormatTimeShort(aVar.aAj().aCa()));
            if ("guide".equals(aVar.aAj().aCg())) {
                this.fIz.setVisibility(0);
            } else {
                this.fIz.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fIz) {
            TiebaStatic.log(new an("c13047").X("obj_locate", 4).cx("fid", this.mForumId));
            FrsGameStrategyActivity.s(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (buM() != null) {
            buM().a(getView(), this.fIB);
        }
    }

    private void h(bj bjVar) {
        if (this.fIx != null && bjVar != null && !StringUtils.isNull(bjVar.aCr().getName_show())) {
            this.fIx.setText(tY(bjVar.aCr().getName_show()));
        }
    }

    protected String tY(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
