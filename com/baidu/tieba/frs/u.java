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
/* loaded from: classes6.dex */
public class u extends com.baidu.tieba.horizonalList.widget.e {
    private com.baidu.tbadk.core.view.userLike.c MX;
    public HeadImageView gmm;
    public TextView gmn;
    public TextView gmo;
    public EntelechyUserLikeButton gmp;
    private ao gmq;
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
                if (u.this.gmq != null && !com.baidu.tbadk.core.util.aq.isEmpty(u.this.gmq.metaData.getUserName()) && !com.baidu.tbadk.core.util.aq.isEmpty(u.this.gmq.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(u.this.getView().getContext(), u.this.gmq.metaData.getUserId(), u.this.gmq.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.gmm = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.gmm.setPageId(this.mPageId);
        this.gmm.setIsRound(true);
        this.gmn = (TextView) view.findViewById(R.id.rec_user_name);
        this.gmo = (TextView) view.findViewById(R.id.rec_user_describe);
        this.gmp = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.MX = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.gmp);
        this.MX.sk("1");
        this.MX.j(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e by(View view) {
        return new u(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof ao) {
            this.gmq = (ao) cVar;
            if (!StringUtils.isNull(this.gmq.metaData.getUserId())) {
                this.gmm.startLoad(this.gmq.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.gmq.metaData.getUserName(), 5);
                this.gmo.setText(com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.gmq.metaData.getGodUserData().getIntro(), 6));
                this.gmn.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.MX.a(this.gmq.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gmn, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gmo, (int) R.color.cp_cont_d);
            this.gmp.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
