package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class t extends com.baidu.tieba.horizonalList.widget.e {
    private com.baidu.tbadk.core.view.userLike.c cXd;
    public HeadImageView dNJ;
    public TextView dNK;
    public TextView dNL;
    public EntelechyUserLikeButton dNM;
    private ap dNN;
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
                if (t.this.dNN != null && !com.baidu.tbadk.core.util.ao.isEmpty(t.this.dNN.metaData.getUserName()) && !com.baidu.tbadk.core.util.ao.isEmpty(t.this.dNN.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(t.this.getView().getContext(), t.this.dNN.metaData.getUserId(), t.this.dNN.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.dNJ = (HeadImageView) view.findViewById(e.g.rec_usr_header);
        this.dNJ.setPageId(this.mPageId);
        this.dNJ.setIsRound(true);
        this.dNK = (TextView) view.findViewById(e.g.rec_user_name);
        this.dNL = (TextView) view.findViewById(e.g.rec_user_describe);
        this.dNM = (EntelechyUserLikeButton) view.findViewById(e.g.rec_user_like);
        this.cXd = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dNM);
        this.cXd.setFromType("1");
        this.cXd.h(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e aB(View view) {
        return new t(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof ap) {
            this.dNN = (ap) cVar;
            if (!StringUtils.isNull(this.dNN.metaData.getUserId())) {
                this.dNJ.startLoad(this.dNN.metaData.getPortrait(), 28, false);
                String z = com.baidu.tbadk.core.util.ao.z(this.dNN.metaData.getUserName(), 5);
                this.dNL.setText(com.baidu.tbadk.core.util.ao.z(this.dNN.metaData.getGodUserData().getIntro(), 6));
                this.dNK.setText(z);
                getView().setOnClickListener(this.mOnClickListener);
                this.cXd.a(this.dNN.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.h(this.dNK, e.d.cp_cont_b);
            com.baidu.tbadk.core.util.al.h(this.dNL, e.d.cp_cont_d);
            this.dNM.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
