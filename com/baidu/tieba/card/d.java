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
    private LinearLayout iuG;
    private TextView iuH;
    private RelativeLayout iuI;
    private TbImageView iuJ;
    private ImageView iuK;
    private TextView iuL;
    private RelativeLayout iuM;
    private ClickableHeaderImageView iuN;
    private TextView iuO;
    private TextView iuP;
    private TextView iuQ;
    private View iuR;
    private com.baidu.tieba.e.a iuS;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.iuG = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.iuH = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.iuI = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.iuJ = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.iuK = (ImageView) view.findViewById(R.id.img_play);
        this.iuL = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.iuM = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.iuN = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.iuO = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.iuP = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.iuQ = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.iuR = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.iuJ.setDefaultBgResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iuI.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.iuI.setLayoutParams(layoutParams);
        this.iuQ.setOnClickListener(this);
        this.iuN.setDefaultResource(17170445);
        this.iuN.setDefaultBgResource(R.color.CAM_X0205);
        this.iuN.setIsRound(true);
        this.iuN.setDrawBorder(true);
        this.iuN.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.iuN.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void E(int i, int i2, int i3, int i4) {
        if (this.iuG != null) {
            this.iuG.setPadding(i, i2, i3, i4);
        }
    }

    public void wX(int i) {
        if (this.iuM != null) {
            this.iuM.setVisibility(i);
        }
    }

    public void wY(int i) {
        if (this.iuR != null) {
            this.iuR.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.CAM_X0201);
            ap.setBackgroundResource(this.iuR, R.color.CAM_X0204);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.TA(this.iuS.bln().getId())) {
                ap.setViewTextColor(this.iuH, R.color.CAM_X0108, 1);
            } else {
                ap.setViewTextColor(this.iuH, R.color.CAM_X0105, 1);
            }
            ap.setViewTextColor(this.iuO, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.iuP, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.iuQ, R.color.CAM_X0304, 1);
            ap.setViewTextColor(this.iuL, R.color.CAM_X0101, 1);
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
        if (aVar != null && aVar.bln() != null) {
            this.iuS = aVar;
            String str = null;
            if (aVar.bln().bmv()) {
                this.iuK.setVisibility(0);
                this.iuL.setVisibility(0);
                if (aVar.bln().boh() != null) {
                    this.iuL.setText(au.stringForVideoTime(aVar.bln().boh().video_duration.intValue() * 1000));
                    str = aVar.bln().boh().thumbnail_url;
                }
            } else {
                this.iuK.setVisibility(8);
                this.iuL.setVisibility(4);
                if (aVar.bln().bnZ() != null && aVar.bln().bnZ().size() >= 1) {
                    str = aVar.bln().bnZ().get(0).origin_pic;
                }
            }
            this.iuJ.startLoad(str, 10, false);
            this.iuH.setText(aVar.bln().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.TA(aVar.bln().getId())) {
                ap.setViewTextColor(this.iuH, R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.iuH, R.color.CAM_X0105);
            }
            this.iuN.setData(aVar.bln(), false);
            i(aVar.bln());
            this.iuP.setText(au.getFormatTimeShort(aVar.bln().bnz()));
            if ("guide".equals(aVar.bln().bnF())) {
                this.iuQ.setVisibility(0);
            } else {
                this.iuQ.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iuQ) {
            TiebaStatic.log(new ar("c13047").ap("obj_locate", 4).dR("fid", this.mForumId));
            FrsGameStrategyActivity.w(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (crV() != null) {
            crV().a(getView(), this.iuS);
        }
    }

    private void i(cb cbVar) {
        if (this.iuO != null && cbVar != null && !StringUtils.isNull(cbVar.bnQ().getName_show())) {
            this.iuO.setText(BF(cbVar.bnQ().getName_show()));
        }
    }

    protected String BF(String str) {
        return au.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
