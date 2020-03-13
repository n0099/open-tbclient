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
    private c NB;
    public ClickableHeaderImageView gRB;
    public CommonUserLikeButton gVt;
    private TextView gVu;
    private TextView gVv;
    private TextView gVw;
    private Drawable gVx;
    private MetaData gVy;
    private h gVz;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.gRB = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.gRB.setGodIconMargin(R.dimen.ds4);
        this.gRB.setAfterClickListener(this);
        this.gVv = (TextView) getView().findViewById(R.id.god_name);
        this.gVw = (TextView) getView().findViewById(R.id.god_describe);
        this.gVt = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.NB = new c(tbPageContext, this.gVt);
        this.gVt.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.gVu = (TextView) getView().findViewById(R.id.god_rank);
        this.gVx = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.gVv, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gVw, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            am.setViewTextColor(this.gVu, (int) R.color.cp_cont_d);
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
        if (hVar != null && hVar.cSo != null && hVar.cSo.getGodUserData() != null) {
            this.gVz = hVar;
            this.gVy = hVar.cSo;
            uU(hVar.rank);
            this.gRB.setData(hVar.cSo);
            this.gVv.setText(hVar.cSo.getName_show());
            this.gVw.setText(hVar.cSo.getGodUserData().getIntro());
            this.NB.a(hVar.cSo);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void uU(int i) {
        String str;
        switch (i) {
            case 1:
                this.gVu.setText("");
                am.setBackgroundResource(this.gVu, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.gVu.setText("");
                am.setBackgroundResource(this.gVu, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.gVu.setText("");
                am.setBackgroundResource(this.gVu, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.gVu.setBackgroundDrawable(this.gVx);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.gVu.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buH() != null) {
            buH().a(view, this.gVz);
        }
        if (view == getView() && this.gVy != null && !StringUtils.isNull(this.gVy.getName_show()) && !StringUtils.isNull(this.gVy.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.gVy.getUserId(), 0L), false, this.gVy.isBigV())));
        }
    }
}
