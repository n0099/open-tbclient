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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes22.dex */
public class e extends b<com.baidu.tieba.e.a> {
    private ImageView hDA;
    private TextView hDB;
    private RelativeLayout hDC;
    private ClickableHeaderImageView hDD;
    private TextView hDE;
    private TextView hDF;
    private TextView hDG;
    private View hDH;
    private com.baidu.tieba.e.a hDI;
    private LinearLayout hDw;
    private TextView hDx;
    private RelativeLayout hDy;
    private TbImageView hDz;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.hDw = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.hDx = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.hDy = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.hDz = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.hDA = (ImageView) view.findViewById(R.id.img_play);
        this.hDB = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.hDC = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.hDD = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.hDE = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.hDF = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.hDG = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.hDH = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.hDz.setDefaultBgResource(R.drawable.icon_morenpic);
        this.hDz.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hDy.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.hDy.setLayoutParams(layoutParams);
        this.hDG.setOnClickListener(this);
        this.hDD.setDefaultResource(17170445);
        this.hDD.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hDD.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hDD.setIsRound(true);
        this.hDD.setDrawBorder(true);
        this.hDD.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hDD.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void x(int i, int i2, int i3, int i4) {
        if (this.hDw != null) {
            this.hDw.setPadding(i, i2, i3, i4);
        }
    }

    public void ww(int i) {
        if (this.hDC != null) {
            this.hDC.setVisibility(i);
        }
    }

    public void wx(int i) {
        if (this.hDH != null) {
            this.hDH.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.hDH, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Sl(this.hDI.bfG().getId())) {
                ap.setViewTextColor(this.hDx, R.color.cp_cont_c, 1);
            } else {
                ap.setViewTextColor(this.hDx, R.color.cp_cont_b, 1);
            }
            ap.setViewTextColor(this.hDE, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hDF, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hDG, R.color.cp_link_tip_c, 1);
            ap.setViewTextColor(this.hDB, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_common_big_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.a aVar) {
        if (aVar != null && aVar.bfG() != null) {
            this.hDI = aVar;
            String str = null;
            if (aVar.bfG().bgN()) {
                this.hDA.setVisibility(0);
                this.hDB.setVisibility(0);
                if (aVar.bfG().biz() != null) {
                    this.hDB.setText(at.stringForVideoTime(aVar.bfG().biz().video_duration.intValue() * 1000));
                    str = aVar.bfG().biz().thumbnail_url;
                }
            } else {
                this.hDA.setVisibility(8);
                this.hDB.setVisibility(4);
                if (aVar.bfG().biq() != null && aVar.bfG().biq().size() >= 1) {
                    str = aVar.bfG().biq().get(0).origin_pic;
                }
            }
            this.hDz.startLoad(str, 10, false);
            this.hDx.setText(aVar.bfG().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Sl(aVar.bfG().getId())) {
                ap.setViewTextColor(this.hDx, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.hDx, (int) R.color.cp_cont_b);
            }
            this.hDD.setData(aVar.bfG(), false);
            i(aVar.bfG());
            this.hDF.setText(at.getFormatTimeShort(aVar.bfG().bhQ()));
            if ("guide".equals(aVar.bfG().bhW())) {
                this.hDG.setVisibility(0);
            } else {
                this.hDG.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hDG) {
            TiebaStatic.log(new aq("c13047").aj("obj_locate", 4).dK("fid", this.mForumId));
            FrsGameStrategyActivity.v(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (cil() != null) {
            cil().a(getView(), this.hDI);
        }
    }

    private void i(bw bwVar) {
        if (this.hDE != null && bwVar != null && !StringUtils.isNull(bwVar.bih().getName_show())) {
            this.hDE.setText(BO(bwVar.bih().getName_show()));
        }
    }

    protected String BO(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
