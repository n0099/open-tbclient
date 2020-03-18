package com.baidu.tieba.godSquare.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.h;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.a<h> {
    private c NC;
    public ClickableHeaderImageView gSI;
    public CommonUserLikeButton gWA;
    private TextView gWC;
    private TextView gWD;
    private MetaData gWF;
    private h gWG;
    private TextView gWH;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.gSI = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.gSI.setGodIconMargin(R.dimen.ds6);
        this.gSI.setAfterClickListener(this);
        this.gWC = (TextView) getView().findViewById(R.id.god_name);
        this.gWD = (TextView) getView().findViewById(R.id.god_describe);
        this.gWH = (TextView) getView().findViewById(R.id.rec_reason);
        this.gWA = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.NC = new c(tbPageContext, this.gWA);
        this.gWA.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.gWC, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gWD, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.gWH, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_god_square_rec_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(h hVar) {
        if (hVar != null && hVar.cSB != null && hVar.cSB.getGodUserData() != null) {
            this.gWG = hVar;
            this.gWF = hVar.cSB;
            this.gSI.setData(hVar.cSB);
            this.gWC.setText(hVar.cSB.getName_show());
            this.gWD.setText(hVar.cSB.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = hVar.cSB.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.gWH.setText("");
            } else {
                this.gWH.setText(String.format(string, recommendReason));
            }
            this.NC.a(hVar.cSB);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buM() != null) {
            buM().a(view, this.gWG);
        }
        if (view == getView() && this.gWF != null && !StringUtils.isNull(this.gWF.getName_show()) && !StringUtils.isNull(this.gWF.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.gWF.getUserId(), this.gWF.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
