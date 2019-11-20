package com.baidu.tieba.frs;

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
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class t extends com.baidu.tieba.horizonalList.widget.e {
    private com.baidu.tbadk.core.view.userLike.c eLD;
    public HeadImageView fxP;
    public TextView fxQ;
    public TextView fxR;
    public EntelechyUserLikeButton fxS;
    private an fxT;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private int mSkinType;

    public t(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.fxT != null && !com.baidu.tbadk.core.util.aq.isEmpty(t.this.fxT.metaData.getUserName()) && !com.baidu.tbadk.core.util.aq.isEmpty(t.this.fxT.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(t.this.getView().getContext(), t.this.fxT.metaData.getUserId(), t.this.fxT.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.fxP = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.fxP.setPageId(this.mPageId);
        this.fxP.setIsRound(true);
        this.fxQ = (TextView) view.findViewById(R.id.rec_user_name);
        this.fxR = (TextView) view.findViewById(R.id.rec_user_describe);
        this.fxS = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.eLD = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.fxS);
        this.eLD.mX("1");
        this.eLD.j(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bB(View view) {
        return new t(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof an) {
            this.fxT = (an) cVar;
            if (!StringUtils.isNull(this.fxT.metaData.getUserId())) {
                this.fxP.startLoad(this.fxT.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.fxT.metaData.getUserName(), 5);
                this.fxR.setText(com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.fxT.metaData.getGodUserData().getIntro(), 6));
                this.fxQ.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.eLD.a(this.fxT.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.fxQ, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.fxR, (int) R.color.cp_cont_d);
            this.fxS.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
