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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes21.dex */
public class e extends b<com.baidu.tieba.f.a> {
    private View hWA;
    private com.baidu.tieba.f.a hWB;
    private LinearLayout hWp;
    private TextView hWq;
    private RelativeLayout hWr;
    private TbImageView hWs;
    private ImageView hWt;
    private TextView hWu;
    private RelativeLayout hWv;
    private ClickableHeaderImageView hWw;
    private TextView hWx;
    private TextView hWy;
    private TextView hWz;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.hWp = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.hWq = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.hWr = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.hWs = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.hWt = (ImageView) view.findViewById(R.id.img_play);
        this.hWu = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.hWv = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.hWw = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.hWx = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.hWy = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.hWz = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.hWA = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.hWs.setDefaultBgResource(R.drawable.icon_morenpic);
        this.hWs.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hWr.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.hWr.setLayoutParams(layoutParams);
        this.hWz.setOnClickListener(this);
        this.hWw.setDefaultResource(17170445);
        this.hWw.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hWw.setDefaultBgResource(R.color.CAM_X0205);
        this.hWw.setIsRound(true);
        this.hWw.setDrawBorder(true);
        this.hWw.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hWw.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void z(int i, int i2, int i3, int i4) {
        if (this.hWp != null) {
            this.hWp.setPadding(i, i2, i3, i4);
        }
    }

    public void xA(int i) {
        if (this.hWv != null) {
            this.hWv.setVisibility(i);
        }
    }

    public void xB(int i) {
        if (this.hWA != null) {
            this.hWA.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.CAM_X0201);
            ap.setBackgroundResource(this.hWA, R.color.CAM_X0204);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.SM(this.hWB.bjd().getId())) {
                ap.setViewTextColor(this.hWq, R.color.CAM_X0108, 1);
            } else {
                ap.setViewTextColor(this.hWq, R.color.CAM_X0105, 1);
            }
            ap.setViewTextColor(this.hWx, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.hWy, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.hWz, R.color.CAM_X0304, 1);
            ap.setViewTextColor(this.hWu, R.color.CAM_X0101, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_common_big_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.f.a aVar) {
        if (aVar != null && aVar.bjd() != null) {
            this.hWB = aVar;
            String str = null;
            if (aVar.bjd().bki()) {
                this.hWt.setVisibility(0);
                this.hWu.setVisibility(0);
                if (aVar.bjd().blU() != null) {
                    this.hWu.setText(au.stringForVideoTime(aVar.bjd().blU().video_duration.intValue() * 1000));
                    str = aVar.bjd().blU().thumbnail_url;
                }
            } else {
                this.hWt.setVisibility(8);
                this.hWu.setVisibility(4);
                if (aVar.bjd().blL() != null && aVar.bjd().blL().size() >= 1) {
                    str = aVar.bjd().blL().get(0).origin_pic;
                }
            }
            this.hWs.startLoad(str, 10, false);
            this.hWq.setText(aVar.bjd().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.SM(aVar.bjd().getId())) {
                ap.setViewTextColor(this.hWq, (int) R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.hWq, (int) R.color.CAM_X0105);
            }
            this.hWw.setData(aVar.bjd(), false);
            i(aVar.bjd());
            this.hWy.setText(au.getFormatTimeShort(aVar.bjd().bll()));
            if ("guide".equals(aVar.bjd().blr())) {
                this.hWz.setVisibility(0);
            } else {
                this.hWz.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hWz) {
            TiebaStatic.log(new ar("c13047").ak("obj_locate", 4).dR("fid", this.mForumId));
            FrsGameStrategyActivity.v(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (cnv() != null) {
            cnv().a(getView(), this.hWB);
        }
    }

    private void i(bx bxVar) {
        if (this.hWx != null && bxVar != null && !StringUtils.isNull(bxVar.blC().getName_show())) {
            this.hWx.setText(BU(bxVar.blC().getName_show()));
        }
    }

    protected String BU(String str) {
        return au.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
