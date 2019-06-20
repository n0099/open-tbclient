package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends a<com.baidu.tieba.e.b> {
    private LinearLayout evh;
    private RelativeLayout evj;
    private ImageView evl;
    private ClickableHeaderImageView evo;
    private View evs;
    private TextView evu;
    private TextView evv;
    private TextView evw;
    private TextView evx;
    private com.baidu.tieba.e.b evy;
    private TbImageView imgThumbnail;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.evh = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.evj = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.imgThumbnail = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.evl = (ImageView) view.findViewById(R.id.img_play);
        this.evu = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.evv = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.evo = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.evw = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.evx = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.evs = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.imgThumbnail.setDefaultBgResource(R.drawable.icon_morenpic);
        this.imgThumbnail.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.evj.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.evj.setLayoutParams(layoutParams);
        this.evo.setDefaultResource(17170445);
        this.evo.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.evo.setDefaultBgResource(R.color.cp_bg_line_e);
        this.evo.setIsRound(true);
        this.evo.setDrawBorder(true);
        this.evo.setBorderColor(al.getColor(R.color.common_color_10043));
        this.evo.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void pl(int i) {
        if (this.evs != null) {
            this.evs.setVisibility(i);
        }
    }

    public void r(int i, int i2, int i3, int i4) {
        if (this.evh != null) {
            this.evh.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), R.color.cp_bg_line_d);
            al.k(this.evs, R.color.cp_bg_line_c);
            al.f(this.evu, R.color.cp_btn_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ek(this.evy.abv().getId())) {
                al.j(this.evv, R.color.cp_cont_c);
            } else {
                al.j(this.evv, R.color.cp_cont_b);
            }
            al.f(this.evw, R.color.cp_cont_d, 1);
            al.f(this.evx, R.color.cp_cont_d, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_common_small_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.b bVar) {
        if (bVar != null && bVar.abv() != null) {
            this.evy = bVar;
            String str = null;
            if (bVar.abv().aep()) {
                this.evl.setVisibility(0);
                this.evu.setVisibility(0);
                if (bVar.abv().adM() != null) {
                    this.evu.setText(ap.im(bVar.abv().adM().video_duration.intValue() * 1000));
                    str = bVar.abv().adM().thumbnail_url;
                }
            } else {
                this.evl.setVisibility(8);
                this.evu.setVisibility(8);
                if (bVar.abv().adF() != null && bVar.abv().adF().size() >= 1) {
                    str = bVar.abv().adF().get(0).origin_pic;
                }
            }
            this.imgThumbnail.startLoad(str, 10, false);
            this.evv.setText(bVar.abv().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ek(bVar.abv().getId())) {
                al.j(this.evv, R.color.cp_cont_c);
            } else {
                al.j(this.evv, R.color.cp_cont_b);
            }
            this.evo.setData(bVar.abv(), false);
            this.evx.setText(ap.aE(bVar.abv().adf()));
            if ("news".equals(bVar.abv().adk())) {
                this.evo.setVisibility(8);
                this.evw.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, ap.aG(bVar.abv().adn())));
                return;
            }
            this.evo.setVisibility(0);
            f(bVar.abv());
        }
    }

    private void f(bg bgVar) {
        if (this.evw != null && bgVar != null) {
            this.evw.setVisibility(0);
            if (!StringUtils.isNull(bgVar.adv().getName_show())) {
                this.evw.setText(oC(bgVar.adv().getName_show()));
            }
        }
    }

    protected String oC(String str) {
        return ap.j(str, 14, "...");
    }

    public void pm(int i) {
        this.evo.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aXr() != null) {
            aXr().a(getView(), this.evy);
        }
    }
}
