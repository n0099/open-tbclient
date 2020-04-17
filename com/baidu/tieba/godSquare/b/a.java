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
    private c agm;
    public ClickableHeaderImageView hCx;
    public CommonUserLikeButton hGr;
    private TextView hGs;
    private TextView hGt;
    private TextView hGu;
    private Drawable hGv;
    private MetaData hGw;
    private h hGx;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.hCx = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.hCx.setGodIconMargin(R.dimen.ds4);
        this.hCx.setAfterClickListener(this);
        this.hGt = (TextView) getView().findViewById(R.id.god_name);
        this.hGu = (TextView) getView().findViewById(R.id.god_describe);
        this.hGr = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.agm = new c(tbPageContext, this.hGr);
        this.hGr.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.hGs = (TextView) getView().findViewById(R.id.god_rank);
        this.hGv = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.hGt, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hGu, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            am.setViewTextColor(this.hGs, (int) R.color.cp_cont_d);
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
        if (hVar != null && hVar.drK != null && hVar.drK.getGodUserData() != null) {
            this.hGx = hVar;
            this.hGw = hVar.drK;
            vz(hVar.rank);
            this.hCx.setData(hVar.drK);
            this.hGt.setText(hVar.drK.getName_show());
            this.hGu.setText(hVar.drK.getGodUserData().getIntro());
            this.agm.a(hVar.drK);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void vz(int i) {
        String str;
        switch (i) {
            case 1:
                this.hGs.setText("");
                am.setBackgroundResource(this.hGs, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.hGs.setText("");
                am.setBackgroundResource(this.hGs, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.hGs.setText("");
                am.setBackgroundResource(this.hGs, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.hGs.setBackgroundDrawable(this.hGv);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.hGs.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bEy() != null) {
            bEy().a(view, this.hGx);
        }
        if (view == getView() && this.hGw != null && !StringUtils.isNull(this.hGw.getName_show()) && !StringUtils.isNull(this.hGw.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.hGw.getUserId(), 0L), false, this.hGw.isBigV())));
        }
    }
}
