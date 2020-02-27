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
    private ao grA;
    public HeadImageView grw;
    public TextView grx;
    public TextView gry;
    public EntelechyUserLikeButton grz;
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
                if (u.this.grA != null && !com.baidu.tbadk.core.util.aq.isEmpty(u.this.grA.metaData.getUserName()) && !com.baidu.tbadk.core.util.aq.isEmpty(u.this.grA.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(u.this.getView().getContext(), u.this.grA.metaData.getUserId(), u.this.grA.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.grw = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.grw.setPageId(this.mPageId);
        this.grw.setIsRound(true);
        this.grx = (TextView) view.findViewById(R.id.rec_user_name);
        this.gry = (TextView) view.findViewById(R.id.rec_user_describe);
        this.grz = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.NB = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.grz);
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
            this.grA = (ao) cVar;
            if (!StringUtils.isNull(this.grA.metaData.getUserId())) {
                this.grw.startLoad(this.grA.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.grA.metaData.getUserName(), 5);
                this.gry.setText(com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.grA.metaData.getGodUserData().getIntro(), 6));
                this.grx.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.NB.a(this.grA.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.grx, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gry, (int) R.color.cp_cont_d);
            this.grz.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
