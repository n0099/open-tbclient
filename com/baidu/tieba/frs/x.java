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
    private com.baidu.tbadk.core.view.userLike.c agp;
    public HeadImageView hbN;
    public TextView hbO;
    public TextView hbP;
    public EntelechyUserLikeButton hbQ;
    private at hbR;
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
                if (x.this.hbR != null && !com.baidu.tbadk.core.util.aq.isEmpty(x.this.hbR.metaData.getUserName()) && !com.baidu.tbadk.core.util.aq.isEmpty(x.this.hbR.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(x.this.getView().getContext(), x.this.hbR.metaData.getUserId(), x.this.hbR.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.hbN = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.hbN.setPageId(this.mPageId);
        this.hbN.setIsRound(true);
        this.hbO = (TextView) view.findViewById(R.id.rec_user_name);
        this.hbP = (TextView) view.findViewById(R.id.rec_user_describe);
        this.hbQ = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.agp = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.hbQ);
        this.agp.tU("1");
        this.agp.j(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bI(View view) {
        return new x(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof at) {
            this.hbR = (at) cVar;
            if (!StringUtils.isNull(this.hbR.metaData.getUserId())) {
                this.hbN.startLoad(this.hbR.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.hbR.metaData.getUserName(), 5);
                this.hbP.setText(com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.hbR.metaData.getGodUserData().getIntro(), 6));
                this.hbO.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.agp.a(this.hbR.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hbO, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hbP, (int) R.color.cp_cont_d);
            this.hbQ.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
