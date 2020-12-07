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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes22.dex */
public class e extends b<com.baidu.tieba.f.a> {
    private LinearLayout ihm;
    private TextView ihn;
    private RelativeLayout iho;
    private TbImageView ihp;
    private ImageView ihq;
    private TextView ihr;
    private RelativeLayout ihs;
    private ClickableHeaderImageView iht;
    private TextView ihu;
    private TextView ihv;
    private TextView ihw;
    private View ihx;
    private com.baidu.tieba.f.a ihy;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.ihm = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.ihn = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.iho = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.ihp = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.ihq = (ImageView) view.findViewById(R.id.img_play);
        this.ihr = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.ihs = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.iht = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.ihu = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.ihv = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.ihw = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.ihx = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.ihp.setDefaultBgResource(R.drawable.icon_morenpic);
        this.ihp.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iho.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.iho.setLayoutParams(layoutParams);
        this.ihw.setOnClickListener(this);
        this.iht.setDefaultResource(17170445);
        this.iht.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iht.setDefaultBgResource(R.color.CAM_X0205);
        this.iht.setIsRound(true);
        this.iht.setDrawBorder(true);
        this.iht.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.iht.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void D(int i, int i2, int i3, int i4) {
        if (this.ihm != null) {
            this.ihm.setPadding(i, i2, i3, i4);
        }
    }

    public void yg(int i) {
        if (this.ihs != null) {
            this.ihs.setVisibility(i);
        }
    }

    public void yh(int i) {
        if (this.ihx != null) {
            this.ihx.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.CAM_X0201);
            ap.setBackgroundResource(this.ihx, R.color.CAM_X0204);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ub(this.ihy.bmn().getId())) {
                ap.setViewTextColor(this.ihn, R.color.CAM_X0108, 1);
            } else {
                ap.setViewTextColor(this.ihn, R.color.CAM_X0105, 1);
            }
            ap.setViewTextColor(this.ihu, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.ihv, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.ihw, R.color.CAM_X0304, 1);
            ap.setViewTextColor(this.ihr, R.color.CAM_X0101, 1);
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
        if (aVar != null && aVar.bmn() != null) {
            this.ihy = aVar;
            String str = null;
            if (aVar.bmn().bnv()) {
                this.ihq.setVisibility(0);
                this.ihr.setVisibility(0);
                if (aVar.bmn().bph() != null) {
                    this.ihr.setText(au.stringForVideoTime(aVar.bmn().bph().video_duration.intValue() * 1000));
                    str = aVar.bmn().bph().thumbnail_url;
                }
            } else {
                this.ihq.setVisibility(8);
                this.ihr.setVisibility(4);
                if (aVar.bmn().boY() != null && aVar.bmn().boY().size() >= 1) {
                    str = aVar.bmn().boY().get(0).origin_pic;
                }
            }
            this.ihp.startLoad(str, 10, false);
            this.ihn.setText(aVar.bmn().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ub(aVar.bmn().getId())) {
                ap.setViewTextColor(this.ihn, (int) R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.ihn, (int) R.color.CAM_X0105);
            }
            this.iht.setData(aVar.bmn(), false);
            i(aVar.bmn());
            this.ihv.setText(au.getFormatTimeShort(aVar.bmn().boy()));
            if ("guide".equals(aVar.bmn().boE())) {
                this.ihw.setVisibility(0);
            } else {
                this.ihw.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ihw) {
            TiebaStatic.log(new ar("c13047").al("obj_locate", 4).dY("fid", this.mForumId));
            FrsGameStrategyActivity.w(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (crI() != null) {
            crI().a(getView(), this.ihy);
        }
    }

    private void i(by byVar) {
        if (this.ihu != null && byVar != null && !StringUtils.isNull(byVar.boP().getName_show())) {
            this.ihu.setText(CC(byVar.boP().getName_show()));
        }
    }

    protected String CC(String str) {
        return au.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
