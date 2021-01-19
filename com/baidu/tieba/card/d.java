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
    private LinearLayout ipc;
    private TextView ipd;
    private RelativeLayout ipe;
    private TbImageView ipf;
    private ImageView ipg;
    private TextView iph;
    private RelativeLayout ipi;
    private ClickableHeaderImageView ipj;
    private TextView ipk;
    private TextView ipl;
    private TextView ipm;
    private View ipn;
    private com.baidu.tieba.e.a ipo;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.ipc = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.ipd = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.ipe = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.ipf = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.ipg = (ImageView) view.findViewById(R.id.img_play);
        this.iph = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.ipi = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.ipj = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.ipk = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.ipl = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.ipm = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.ipn = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.ipf.setDefaultBgResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ipe.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.ipe.setLayoutParams(layoutParams);
        this.ipm.setOnClickListener(this);
        this.ipj.setDefaultResource(17170445);
        this.ipj.setDefaultBgResource(R.color.CAM_X0205);
        this.ipj.setIsRound(true);
        this.ipj.setDrawBorder(true);
        this.ipj.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.ipj.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void E(int i, int i2, int i3, int i4) {
        if (this.ipc != null) {
            this.ipc.setPadding(i, i2, i3, i4);
        }
    }

    public void wN(int i) {
        if (this.ipi != null) {
            this.ipi.setVisibility(i);
        }
    }

    public void wO(int i) {
        if (this.ipn != null) {
            this.ipn.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.color.CAM_X0201);
            ao.setBackgroundResource(this.ipn, R.color.CAM_X0204);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.SD(this.ipo.bkV().getId())) {
                ao.setViewTextColor(this.ipd, R.color.CAM_X0108, 1);
            } else {
                ao.setViewTextColor(this.ipd, R.color.CAM_X0105, 1);
            }
            ao.setViewTextColor(this.ipk, R.color.CAM_X0109, 1);
            ao.setViewTextColor(this.ipl, R.color.CAM_X0109, 1);
            ao.setViewTextColor(this.ipm, R.color.CAM_X0304, 1);
            ao.setViewTextColor(this.iph, R.color.CAM_X0101, 1);
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
        if (aVar != null && aVar.bkV() != null) {
            this.ipo = aVar;
            String str = null;
            if (aVar.bkV().bmc()) {
                this.ipg.setVisibility(0);
                this.iph.setVisibility(0);
                if (aVar.bkV().bnO() != null) {
                    this.iph.setText(at.stringForVideoTime(aVar.bkV().bnO().video_duration.intValue() * 1000));
                    str = aVar.bkV().bnO().thumbnail_url;
                }
            } else {
                this.ipg.setVisibility(8);
                this.iph.setVisibility(4);
                if (aVar.bkV().bnG() != null && aVar.bkV().bnG().size() >= 1) {
                    str = aVar.bkV().bnG().get(0).origin_pic;
                }
            }
            this.ipf.startLoad(str, 10, false);
            this.ipd.setText(aVar.bkV().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.SD(aVar.bkV().getId())) {
                ao.setViewTextColor(this.ipd, R.color.CAM_X0108);
            } else {
                ao.setViewTextColor(this.ipd, R.color.CAM_X0105);
            }
            this.ipj.setData(aVar.bkV(), false);
            i(aVar.bkV());
            this.ipl.setText(at.getFormatTimeShort(aVar.bkV().bng()));
            if ("guide".equals(aVar.bkV().bnm())) {
                this.ipm.setVisibility(0);
            } else {
                this.ipm.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ipm) {
            TiebaStatic.log(new aq("c13047").an("obj_locate", 4).dW("fid", this.mForumId));
            FrsGameStrategyActivity.w(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (cqL() != null) {
            cqL().a(getView(), this.ipo);
        }
    }

    private void i(bz bzVar) {
        if (this.ipk != null && bzVar != null && !StringUtils.isNull(bzVar.bnx().getName_show())) {
            this.ipk.setText(Bo(bzVar.bnx().getName_show()));
        }
    }

    protected String Bo(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
