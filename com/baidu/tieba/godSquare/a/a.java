package com.baidu.tieba.godSquare.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.h;
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.card.b<h> {
    private c alS;
    public ClickableHeaderImageView jUu;
    public CommonUserLikeButton jZZ;
    private TextView kaa;
    private TextView kab;
    private TextView kac;
    private Drawable kad;
    private MetaData kae;
    private h kaf;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.jUu = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.jUu.setGodIconMargin(R.dimen.ds4);
        this.jUu.setAfterClickListener(this);
        this.kab = (TextView) getView().findViewById(R.id.god_name);
        this.kac = (TextView) getView().findViewById(R.id.god_describe);
        this.jZZ = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.alS = new c(tbPageContext, this.jZZ);
        this.jZZ.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.kaa = (TextView) getView().findViewById(R.id.god_rank);
        this.kad = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.kab, R.color.CAM_X0105);
            ap.setViewTextColor(this.kac, R.color.CAM_X0109);
            ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
            ap.setViewTextColor(this.kaa, R.color.CAM_X0109);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_god_square_hot_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(h hVar) {
        if (hVar != null && hVar.eTa != null && hVar.eTa.getGodUserData() != null) {
            this.kaf = hVar;
            this.kae = hVar.eTa;
            Bv(hVar.rank);
            this.jUu.setData(hVar.eTa);
            this.kab.setText(hVar.eTa.getName_show());
            this.kac.setText(hVar.eTa.getGodUserData().getIntro());
            this.alS.a(hVar.eTa);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void Bv(int i) {
        String str;
        switch (i) {
            case 1:
                this.kaa.setText("");
                ap.setBackgroundResource(this.kaa, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.kaa.setText("");
                ap.setBackgroundResource(this.kaa, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.kaa.setText("");
                ap.setBackgroundResource(this.kaa, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.kaa.setBackgroundDrawable(this.kad);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.kaa.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (csi() != null) {
            csi().a(view, this.kaf);
        }
        if (view == getView() && this.kae != null && !StringUtils.isNull(this.kae.getName_show()) && !StringUtils.isNull(this.kae.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.kae.getUserId(), 0L), false, this.kae.isBigV())));
        }
    }
}
