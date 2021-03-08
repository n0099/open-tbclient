package com.baidu.tieba.godSquare.a;

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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.h;
/* loaded from: classes7.dex */
public class b extends com.baidu.tieba.card.b<h> {
    private c alS;
    public ClickableHeaderImageView jUu;
    public CommonUserLikeButton jZZ;
    private TextView kab;
    private TextView kac;
    private MetaData kae;
    private h kaf;
    private TextView kag;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.jUu = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.jUu.setGodIconMargin(R.dimen.ds6);
        this.jUu.setAfterClickListener(this);
        this.kab = (TextView) getView().findViewById(R.id.god_name);
        this.kac = (TextView) getView().findViewById(R.id.god_describe);
        this.kag = (TextView) getView().findViewById(R.id.rec_reason);
        this.jZZ = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.alS = new c(tbPageContext, this.jZZ);
        this.jZZ.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
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
            ap.setViewTextColor(this.kag, R.color.CAM_X0109);
            ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_god_square_rec_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(h hVar) {
        if (hVar != null && hVar.eTa != null && hVar.eTa.getGodUserData() != null) {
            this.kaf = hVar;
            this.kae = hVar.eTa;
            this.jUu.setData(hVar.eTa);
            this.kab.setText(hVar.eTa.getName_show());
            this.kac.setText(hVar.eTa.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = hVar.eTa.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.kag.setText("");
            } else {
                this.kag.setText(String.format(string, recommendReason));
            }
            this.alS.a(hVar.eTa);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (csi() != null) {
            csi().a(view, this.kaf);
        }
        if (view == getView() && this.kae != null && !StringUtils.isNull(this.kae.getName_show()) && !StringUtils.isNull(this.kae.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.kae.getUserId(), this.kae.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
