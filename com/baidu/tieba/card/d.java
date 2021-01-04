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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes2.dex */
public class d extends b<com.baidu.tieba.e.a> {
    private LinearLayout itJ;
    private TextView itK;
    private RelativeLayout itL;
    private TbImageView itM;
    private ImageView itN;
    private TextView itO;
    private RelativeLayout itP;
    private ClickableHeaderImageView itQ;
    private TextView itR;
    private TextView itS;
    private TextView itT;
    private View itU;
    private com.baidu.tieba.e.a itV;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.itJ = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.itK = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.itL = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.itM = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.itN = (ImageView) view.findViewById(R.id.img_play);
        this.itO = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.itP = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.itQ = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.itR = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.itS = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.itT = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.itU = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.itM.setDefaultBgResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.itL.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.itL.setLayoutParams(layoutParams);
        this.itT.setOnClickListener(this);
        this.itQ.setDefaultResource(17170445);
        this.itQ.setDefaultBgResource(R.color.CAM_X0205);
        this.itQ.setIsRound(true);
        this.itQ.setDrawBorder(true);
        this.itQ.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.itQ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void E(int i, int i2, int i3, int i4) {
        if (this.itJ != null) {
            this.itJ.setPadding(i, i2, i3, i4);
        }
    }

    public void yu(int i) {
        if (this.itP != null) {
            this.itP.setVisibility(i);
        }
    }

    public void yv(int i) {
        if (this.itU != null) {
            this.itU.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.color.CAM_X0201);
            ao.setBackgroundResource(this.itU, R.color.CAM_X0204);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.TL(this.itV.boO().getId())) {
                ao.setViewTextColor(this.itK, R.color.CAM_X0108, 1);
            } else {
                ao.setViewTextColor(this.itK, R.color.CAM_X0105, 1);
            }
            ao.setViewTextColor(this.itR, R.color.CAM_X0109, 1);
            ao.setViewTextColor(this.itS, R.color.CAM_X0109, 1);
            ao.setViewTextColor(this.itT, R.color.CAM_X0304, 1);
            ao.setViewTextColor(this.itO, R.color.CAM_X0101, 1);
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
        if (aVar != null && aVar.boO() != null) {
            this.itV = aVar;
            String str = null;
            if (aVar.boO().bpV()) {
                this.itN.setVisibility(0);
                this.itO.setVisibility(0);
                if (aVar.boO().brH() != null) {
                    this.itO.setText(at.stringForVideoTime(aVar.boO().brH().video_duration.intValue() * 1000));
                    str = aVar.boO().brH().thumbnail_url;
                }
            } else {
                this.itN.setVisibility(8);
                this.itO.setVisibility(4);
                if (aVar.boO().brz() != null && aVar.boO().brz().size() >= 1) {
                    str = aVar.boO().brz().get(0).origin_pic;
                }
            }
            this.itM.startLoad(str, 10, false);
            this.itK.setText(aVar.boO().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.TL(aVar.boO().getId())) {
                ao.setViewTextColor(this.itK, R.color.CAM_X0108);
            } else {
                ao.setViewTextColor(this.itK, R.color.CAM_X0105);
            }
            this.itQ.setData(aVar.boO(), false);
            i(aVar.boO());
            this.itS.setText(at.getFormatTimeShort(aVar.boO().bqZ()));
            if ("guide".equals(aVar.boO().brf())) {
                this.itT.setVisibility(0);
            } else {
                this.itT.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.itT) {
            TiebaStatic.log(new aq("c13047").an("obj_locate", 4).dX("fid", this.mForumId));
            FrsGameStrategyActivity.w(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (cuC() != null) {
            cuC().a(getView(), this.itV);
        }
    }

    private void i(bz bzVar) {
        if (this.itR != null && bzVar != null && !StringUtils.isNull(bzVar.brq().getName_show())) {
            this.itR.setText(CA(bzVar.brq().getName_show()));
        }
    }

    protected String CA(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
