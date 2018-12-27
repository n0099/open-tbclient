package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes3.dex */
public class e extends a<com.baidu.tieba.e.a> {
    private LinearLayout cVm;
    private TextView cVn;
    private RelativeLayout cVo;
    private TbImageView cVp;
    private ImageView cVq;
    private TextView cVr;
    private RelativeLayout cVs;
    private ClickableHeaderImageView cVt;
    private TextView cVu;
    private TextView cVv;
    private TextView cVw;
    private View cVx;
    private com.baidu.tieba.e.a cVy;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.cVm = (LinearLayout) view.findViewById(e.g.card_frs_game_thread_layout);
        this.cVn = (TextView) view.findViewById(e.g.card_frs_game_thread_title);
        this.cVo = (RelativeLayout) view.findViewById(e.g.card_frs_game_thread_content);
        this.cVp = (TbImageView) view.findViewById(e.g.card_frs_game_thread_bg);
        this.cVq = (ImageView) view.findViewById(e.g.img_play);
        this.cVr = (TextView) view.findViewById(e.g.card_frs_game_thread_video_time);
        this.cVs = (RelativeLayout) view.findViewById(e.g.card_frs_game_user_content);
        this.cVt = (ClickableHeaderImageView) view.findViewById(e.g.card_frs_game_user_icon);
        this.cVu = (TextView) view.findViewById(e.g.card_frs_game_user_name);
        this.cVv = (TextView) view.findViewById(e.g.card_frs_game_thread_time);
        this.cVw = (TextView) view.findViewById(e.g.card_frs_game_thread_more_article);
        this.cVx = view.findViewById(e.g.card_frs_game_bottom_divider);
        this.cVp.setDefaultBgResource(e.f.icon_morenpic);
        this.cVp.setDefaultErrorResource(e.f.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.aS(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cVo.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.cVo.setLayoutParams(layoutParams);
        this.cVw.setOnClickListener(this);
        this.cVt.setDefaultResource(17170445);
        this.cVt.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cVt.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cVt.setIsRound(true);
        this.cVt.setDrawBorder(true);
        this.cVt.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cVt.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds1));
        getView().setOnClickListener(this);
    }

    public void m(int i, int i2, int i3, int i4) {
        if (this.cVm != null) {
            this.cVm.setPadding(i, i2, i3, i4);
        }
    }

    public void kI(int i) {
        if (this.cVs != null) {
            this.cVs.setVisibility(i);
        }
    }

    public void kJ(int i) {
        if (this.cVx != null) {
            this.cVx.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.d.cp_bg_line_d);
            al.i(this.cVx, e.d.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.vU(this.cVy.ZT().getId())) {
                al.c(this.cVn, e.d.cp_cont_c, 1);
            } else {
                al.c(this.cVn, e.d.cp_cont_b, 1);
            }
            al.c(this.cVu, e.d.cp_cont_d, 1);
            al.c(this.cVv, e.d.cp_cont_d, 1);
            al.c(this.cVw, e.d.cp_link_tip_c, 1);
            al.c(this.cVr, e.d.cp_cont_i, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_frs_game_common_big_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.a aVar) {
        if (aVar != null && aVar.ZT() != null) {
            this.cVy = aVar;
            String str = null;
            if (aVar.ZT().Au()) {
                this.cVq.setVisibility(0);
                this.cVr.setVisibility(0);
                if (aVar.ZT().zY() != null) {
                    this.cVr.setText(ao.dV(aVar.ZT().zY().video_duration.intValue() * 1000));
                    str = aVar.ZT().zY().thumbnail_url;
                }
            } else {
                this.cVq.setVisibility(8);
                this.cVr.setVisibility(4);
                if (aVar.ZT().zR() != null && aVar.ZT().zR().size() >= 1) {
                    str = aVar.ZT().zR().get(0).origin_pic;
                }
            }
            this.cVp.startLoad(str, 10, false);
            this.cVn.setText(aVar.ZT().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.vU(aVar.ZT().getId())) {
                al.h(this.cVn, e.d.cp_cont_c);
            } else {
                al.h(this.cVn, e.d.cp_cont_b);
            }
            this.cVt.setData(aVar.ZT(), false);
            p(aVar.ZT());
            this.cVv.setText(ao.O(aVar.ZT().zr()));
            if ("guide".equals(aVar.ZT().zw())) {
                this.cVw.setVisibility(0);
            } else {
                this.cVw.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cVw) {
            TiebaStatic.log(new am("c13047").x("obj_locate", 4).aA(ImageViewerConfig.FORUM_ID, this.mForumId));
            FrsGameStrategyActivity.k(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (apS() != null) {
            apS().a(getView(), this.cVy);
        }
    }

    private void p(bb bbVar) {
        if (this.cVu != null && bbVar != null && !StringUtils.isNull(bbVar.zG().getName_show())) {
            this.cVu.setText(gt(bbVar.zG().getName_show()));
        }
    }

    protected String gt(String str) {
        return ao.d(str, 14, "...");
    }
}
