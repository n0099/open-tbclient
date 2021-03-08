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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes2.dex */
public class d extends b<com.baidu.tieba.e.a> {
    private LinearLayout iwD;
    private TextView iwE;
    private RelativeLayout iwF;
    private TbImageView iwG;
    private ImageView iwH;
    private TextView iwI;
    private RelativeLayout iwJ;
    private ClickableHeaderImageView iwK;
    private TextView iwL;
    private TextView iwM;
    private TextView iwN;
    private View iwO;
    private com.baidu.tieba.e.a iwP;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.iwD = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.iwE = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.iwF = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.iwG = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.iwH = (ImageView) view.findViewById(R.id.img_play);
        this.iwI = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.iwJ = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.iwK = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.iwL = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.iwM = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.iwN = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.iwO = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.iwG.setDefaultBgResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iwF.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.iwF.setLayoutParams(layoutParams);
        this.iwN.setOnClickListener(this);
        this.iwK.setDefaultResource(17170445);
        this.iwK.setDefaultBgResource(R.color.CAM_X0205);
        this.iwK.setIsRound(true);
        this.iwK.setDrawBorder(true);
        this.iwK.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.iwK.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void E(int i, int i2, int i3, int i4) {
        if (this.iwD != null) {
            this.iwD.setPadding(i, i2, i3, i4);
        }
    }

    public void wY(int i) {
        if (this.iwJ != null) {
            this.iwJ.setVisibility(i);
        }
    }

    public void wZ(int i) {
        if (this.iwO != null) {
            this.iwO.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.CAM_X0201);
            ap.setBackgroundResource(this.iwO, R.color.CAM_X0204);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.TT(this.iwP.blp().getId())) {
                ap.setViewTextColor(this.iwE, R.color.CAM_X0108, 1);
            } else {
                ap.setViewTextColor(this.iwE, R.color.CAM_X0105, 1);
            }
            ap.setViewTextColor(this.iwL, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.iwM, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.iwN, R.color.CAM_X0304, 1);
            ap.setViewTextColor(this.iwI, R.color.CAM_X0101, 1);
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
        if (aVar != null && aVar.blp() != null) {
            this.iwP = aVar;
            String str = null;
            if (aVar.blp().bmx()) {
                this.iwH.setVisibility(0);
                this.iwI.setVisibility(0);
                if (aVar.blp().boj() != null) {
                    this.iwI.setText(au.stringForVideoTime(aVar.blp().boj().video_duration.intValue() * 1000));
                    str = aVar.blp().boj().thumbnail_url;
                }
            } else {
                this.iwH.setVisibility(8);
                this.iwI.setVisibility(4);
                if (aVar.blp().bob() != null && aVar.blp().bob().size() >= 1) {
                    str = aVar.blp().bob().get(0).origin_pic;
                }
            }
            this.iwG.startLoad(str, 10, false);
            this.iwE.setText(aVar.blp().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.TT(aVar.blp().getId())) {
                ap.setViewTextColor(this.iwE, R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.iwE, R.color.CAM_X0105);
            }
            this.iwK.setData(aVar.blp(), false);
            i(aVar.blp());
            this.iwM.setText(au.getFormatTimeShort(aVar.blp().bnB()));
            if ("guide".equals(aVar.blp().bnH())) {
                this.iwN.setVisibility(0);
            } else {
                this.iwN.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iwN) {
            TiebaStatic.log(new ar("c13047").aq("obj_locate", 4).dR("fid", this.mForumId));
            FrsGameStrategyActivity.w(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (csi() != null) {
            csi().a(getView(), this.iwP);
        }
    }

    private void i(cb cbVar) {
        if (this.iwL != null && cbVar != null && !StringUtils.isNull(cbVar.bnS().getName_show())) {
            this.iwL.setText(BM(cbVar.bnS().getName_show()));
        }
    }

    protected String BM(String str) {
        return au.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
