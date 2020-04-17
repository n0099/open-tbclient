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
    private com.baidu.tbadk.core.view.userLike.c agm;
    public HeadImageView hbH;
    public TextView hbI;
    public TextView hbJ;
    public EntelechyUserLikeButton hbK;
    private at hbL;
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
                if (x.this.hbL != null && !com.baidu.tbadk.core.util.aq.isEmpty(x.this.hbL.metaData.getUserName()) && !com.baidu.tbadk.core.util.aq.isEmpty(x.this.hbL.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(x.this.getView().getContext(), x.this.hbL.metaData.getUserId(), x.this.hbL.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.hbH = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.hbH.setPageId(this.mPageId);
        this.hbH.setIsRound(true);
        this.hbI = (TextView) view.findViewById(R.id.rec_user_name);
        this.hbJ = (TextView) view.findViewById(R.id.rec_user_describe);
        this.hbK = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.agm = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.hbK);
        this.agm.tR("1");
        this.agm.j(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bI(View view) {
        return new x(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof at) {
            this.hbL = (at) cVar;
            if (!StringUtils.isNull(this.hbL.metaData.getUserId())) {
                this.hbH.startLoad(this.hbL.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.hbL.metaData.getUserName(), 5);
                this.hbJ.setText(com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.hbL.metaData.getGodUserData().getIntro(), 6));
                this.hbI.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.agm.a(this.hbL.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hbI, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hbJ, (int) R.color.cp_cont_d);
            this.hbK.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
