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
    public TextView grA;
    public EntelechyUserLikeButton grB;
    private ao grC;
    public HeadImageView gry;
    public TextView grz;
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
                if (u.this.grC != null && !com.baidu.tbadk.core.util.aq.isEmpty(u.this.grC.metaData.getUserName()) && !com.baidu.tbadk.core.util.aq.isEmpty(u.this.grC.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(u.this.getView().getContext(), u.this.grC.metaData.getUserId(), u.this.grC.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.gry = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.gry.setPageId(this.mPageId);
        this.gry.setIsRound(true);
        this.grz = (TextView) view.findViewById(R.id.rec_user_name);
        this.grA = (TextView) view.findViewById(R.id.rec_user_describe);
        this.grB = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.NB = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.grB);
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
            this.grC = (ao) cVar;
            if (!StringUtils.isNull(this.grC.metaData.getUserId())) {
                this.gry.startLoad(this.grC.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.grC.metaData.getUserName(), 5);
                this.grA.setText(com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.grC.metaData.getGodUserData().getIntro(), 6));
                this.grz.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.NB.a(this.grC.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.grz, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.grA, (int) R.color.cp_cont_d);
            this.grB.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
