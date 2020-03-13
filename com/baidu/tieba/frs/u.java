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
/* loaded from: classes9.dex */
public class u extends com.baidu.tieba.horizonalList.widget.e {
    private com.baidu.tbadk.core.view.userLike.c NB;
    public HeadImageView grL;
    public TextView grM;
    public TextView grN;
    public EntelechyUserLikeButton grO;
    private ao grP;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private int mSkinType;

    public u(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.u.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.grP != null && !com.baidu.tbadk.core.util.aq.isEmpty(u.this.grP.metaData.getUserName()) && !com.baidu.tbadk.core.util.aq.isEmpty(u.this.grP.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(u.this.getView().getContext(), u.this.grP.metaData.getUserId(), u.this.grP.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.grL = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.grL.setPageId(this.mPageId);
        this.grL.setIsRound(true);
        this.grM = (TextView) view.findViewById(R.id.rec_user_name);
        this.grN = (TextView) view.findViewById(R.id.rec_user_describe);
        this.grO = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.NB = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.grO);
        this.NB.sE("1");
        this.NB.j(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bD(View view) {
        return new u(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof ao) {
            this.grP = (ao) cVar;
            if (!StringUtils.isNull(this.grP.metaData.getUserId())) {
                this.grL.startLoad(this.grP.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.grP.metaData.getUserName(), 5);
                this.grN.setText(com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.grP.metaData.getGodUserData().getIntro(), 6));
                this.grM.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.NB.a(this.grP.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.grM, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.grN, (int) R.color.cp_cont_d);
            this.grO.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
