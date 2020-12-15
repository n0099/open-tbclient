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
    private com.baidu.tieba.f.a ihA;
    private LinearLayout iho;
    private TextView ihp;
    private RelativeLayout ihq;
    private TbImageView ihr;
    private ImageView ihs;
    private TextView iht;
    private RelativeLayout ihu;
    private ClickableHeaderImageView ihv;
    private TextView ihw;
    private TextView ihx;
    private TextView ihy;
    private View ihz;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.iho = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.ihp = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.ihq = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.ihr = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.ihs = (ImageView) view.findViewById(R.id.img_play);
        this.iht = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.ihu = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.ihv = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.ihw = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.ihx = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.ihy = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.ihz = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.ihr.setDefaultBgResource(R.drawable.icon_morenpic);
        this.ihr.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ihq.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.ihq.setLayoutParams(layoutParams);
        this.ihy.setOnClickListener(this);
        this.ihv.setDefaultResource(17170445);
        this.ihv.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.ihv.setDefaultBgResource(R.color.CAM_X0205);
        this.ihv.setIsRound(true);
        this.ihv.setDrawBorder(true);
        this.ihv.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.ihv.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void D(int i, int i2, int i3, int i4) {
        if (this.iho != null) {
            this.iho.setPadding(i, i2, i3, i4);
        }
    }

    public void yg(int i) {
        if (this.ihu != null) {
            this.ihu.setVisibility(i);
        }
    }

    public void yh(int i) {
        if (this.ihz != null) {
            this.ihz.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.CAM_X0201);
            ap.setBackgroundResource(this.ihz, R.color.CAM_X0204);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ub(this.ihA.bmn().getId())) {
                ap.setViewTextColor(this.ihp, R.color.CAM_X0108, 1);
            } else {
                ap.setViewTextColor(this.ihp, R.color.CAM_X0105, 1);
            }
            ap.setViewTextColor(this.ihw, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.ihx, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.ihy, R.color.CAM_X0304, 1);
            ap.setViewTextColor(this.iht, R.color.CAM_X0101, 1);
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
            this.ihA = aVar;
            String str = null;
            if (aVar.bmn().bnv()) {
                this.ihs.setVisibility(0);
                this.iht.setVisibility(0);
                if (aVar.bmn().bph() != null) {
                    this.iht.setText(au.stringForVideoTime(aVar.bmn().bph().video_duration.intValue() * 1000));
                    str = aVar.bmn().bph().thumbnail_url;
                }
            } else {
                this.ihs.setVisibility(8);
                this.iht.setVisibility(4);
                if (aVar.bmn().boY() != null && aVar.bmn().boY().size() >= 1) {
                    str = aVar.bmn().boY().get(0).origin_pic;
                }
            }
            this.ihr.startLoad(str, 10, false);
            this.ihp.setText(aVar.bmn().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ub(aVar.bmn().getId())) {
                ap.setViewTextColor(this.ihp, (int) R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.ihp, (int) R.color.CAM_X0105);
            }
            this.ihv.setData(aVar.bmn(), false);
            i(aVar.bmn());
            this.ihx.setText(au.getFormatTimeShort(aVar.bmn().boy()));
            if ("guide".equals(aVar.bmn().boE())) {
                this.ihy.setVisibility(0);
            } else {
                this.ihy.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ihy) {
            TiebaStatic.log(new ar("c13047").al("obj_locate", 4).dY("fid", this.mForumId));
            FrsGameStrategyActivity.w(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (crJ() != null) {
            crJ().a(getView(), this.ihA);
        }
    }

    private void i(by byVar) {
        if (this.ihw != null && byVar != null && !StringUtils.isNull(byVar.boP().getName_show())) {
            this.ihw.setText(CC(byVar.boP().getName_show()));
        }
    }

    protected String CC(String str) {
        return au.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
