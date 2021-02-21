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
    private LinearLayout iuU;
    private TextView iuV;
    private RelativeLayout iuW;
    private TbImageView iuX;
    private ImageView iuY;
    private TextView iuZ;
    private RelativeLayout iva;
    private ClickableHeaderImageView ivb;
    private TextView ivc;
    private TextView ivd;
    private TextView ive;
    private View ivf;
    private com.baidu.tieba.e.a ivg;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.iuU = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.iuV = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.iuW = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.iuX = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.iuY = (ImageView) view.findViewById(R.id.img_play);
        this.iuZ = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.iva = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.ivb = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.ivc = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.ivd = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.ive = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.ivf = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.iuX.setDefaultBgResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iuW.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.iuW.setLayoutParams(layoutParams);
        this.ive.setOnClickListener(this);
        this.ivb.setDefaultResource(17170445);
        this.ivb.setDefaultBgResource(R.color.CAM_X0205);
        this.ivb.setIsRound(true);
        this.ivb.setDrawBorder(true);
        this.ivb.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.ivb.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void E(int i, int i2, int i3, int i4) {
        if (this.iuU != null) {
            this.iuU.setPadding(i, i2, i3, i4);
        }
    }

    public void wX(int i) {
        if (this.iva != null) {
            this.iva.setVisibility(i);
        }
    }

    public void wY(int i) {
        if (this.ivf != null) {
            this.ivf.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.CAM_X0201);
            ap.setBackgroundResource(this.ivf, R.color.CAM_X0204);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.TM(this.ivg.bln().getId())) {
                ap.setViewTextColor(this.iuV, R.color.CAM_X0108, 1);
            } else {
                ap.setViewTextColor(this.iuV, R.color.CAM_X0105, 1);
            }
            ap.setViewTextColor(this.ivc, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.ivd, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.ive, R.color.CAM_X0304, 1);
            ap.setViewTextColor(this.iuZ, R.color.CAM_X0101, 1);
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
            this.ivg = aVar;
            String str = null;
            if (aVar.bln().bmv()) {
                this.iuY.setVisibility(0);
                this.iuZ.setVisibility(0);
                if (aVar.bln().boh() != null) {
                    this.iuZ.setText(au.stringForVideoTime(aVar.bln().boh().video_duration.intValue() * 1000));
                    str = aVar.bln().boh().thumbnail_url;
                }
            } else {
                this.iuY.setVisibility(8);
                this.iuZ.setVisibility(4);
                if (aVar.bln().bnZ() != null && aVar.bln().bnZ().size() >= 1) {
                    str = aVar.bln().bnZ().get(0).origin_pic;
                }
            }
            this.iuX.startLoad(str, 10, false);
            this.iuV.setText(aVar.bln().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.TM(aVar.bln().getId())) {
                ap.setViewTextColor(this.iuV, R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.iuV, R.color.CAM_X0105);
            }
            this.ivb.setData(aVar.bln(), false);
            i(aVar.bln());
            this.ivd.setText(au.getFormatTimeShort(aVar.bln().bnz()));
            if ("guide".equals(aVar.bln().bnF())) {
                this.ive.setVisibility(0);
            } else {
                this.ive.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ive) {
            TiebaStatic.log(new ar("c13047").ap("obj_locate", 4).dR("fid", this.mForumId));
            FrsGameStrategyActivity.w(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (csc() != null) {
            csc().a(getView(), this.ivg);
        }
    }

    private void i(cb cbVar) {
        if (this.ivc != null && cbVar != null && !StringUtils.isNull(cbVar.bnQ().getName_show())) {
            this.ivc.setText(BF(cbVar.bnQ().getName_show()));
        }
    }

    protected String BF(String str) {
        return au.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
