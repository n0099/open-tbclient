package com.baidu.tieba.godSquare.b;

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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.h;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.card.a<h> {
    private c agp;
    public ClickableHeaderImageView hCD;
    private TextView hGA;
    private Drawable hGB;
    private MetaData hGC;
    private h hGD;
    public CommonUserLikeButton hGx;
    private TextView hGy;
    private TextView hGz;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.hCD = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.hCD.setGodIconMargin(R.dimen.ds4);
        this.hCD.setAfterClickListener(this);
        this.hGz = (TextView) getView().findViewById(R.id.god_name);
        this.hGA = (TextView) getView().findViewById(R.id.god_describe);
        this.hGx = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.agp = new c(tbPageContext, this.hGx);
        this.hGx.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.hGy = (TextView) getView().findViewById(R.id.god_rank);
        this.hGB = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.hGz, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hGA, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            am.setViewTextColor(this.hGy, (int) R.color.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_god_square_hot_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(h hVar) {
        if (hVar != null && hVar.drO != null && hVar.drO.getGodUserData() != null) {
            this.hGD = hVar;
            this.hGC = hVar.drO;
            vz(hVar.rank);
            this.hCD.setData(hVar.drO);
            this.hGz.setText(hVar.drO.getName_show());
            this.hGA.setText(hVar.drO.getGodUserData().getIntro());
            this.agp.a(hVar.drO);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void vz(int i) {
        String str;
        switch (i) {
            case 1:
                this.hGy.setText("");
                am.setBackgroundResource(this.hGy, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.hGy.setText("");
                am.setBackgroundResource(this.hGy, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.hGy.setText("");
                am.setBackgroundResource(this.hGy, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.hGy.setBackgroundDrawable(this.hGB);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.hGy.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bEx() != null) {
            bEx().a(view, this.hGD);
        }
        if (view == getView() && this.hGC != null && !StringUtils.isNull(this.hGC.getName_show()) && !StringUtils.isNull(this.hGC.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.hGC.getUserId(), 0L), false, this.hGC.isBigV())));
        }
    }
}
