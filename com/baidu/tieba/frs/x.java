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
public class x extends com.baidu.tieba.horizonalList.widget.e {
    private com.baidu.tbadk.core.view.userLike.c agS;
    public HeadImageView hqB;
    public TextView hqC;
    public TextView hqD;
    public EntelechyUserLikeButton hqE;
    private at hqF;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private int mSkinType;

    public x(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.x.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (x.this.hqF != null && !com.baidu.tbadk.core.util.aq.isEmpty(x.this.hqF.metaData.getUserName()) && !com.baidu.tbadk.core.util.aq.isEmpty(x.this.hqF.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(x.this.getView().getContext(), x.this.hqF.metaData.getUserId(), x.this.hqF.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.hqB = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.hqB.setPageId(this.mPageId);
        this.hqB.setIsRound(true);
        this.hqC = (TextView) view.findViewById(R.id.rec_user_name);
        this.hqD = (TextView) view.findViewById(R.id.rec_user_describe);
        this.hqE = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.agS = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.hqE);
        this.agS.vA("1");
        this.agS.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bH(View view) {
        return new x(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof at) {
            this.hqF = (at) cVar;
            if (!StringUtils.isNull(this.hqF.metaData.getUserId())) {
                this.hqB.startLoad(this.hqF.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.hqF.metaData.getUserName(), 5);
                this.hqD.setText(com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.hqF.metaData.getGodUserData().getIntro(), 6));
                this.hqC.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.agS.a(this.hqF.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hqC, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hqD, (int) R.color.cp_cont_d);
            this.hqE.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
