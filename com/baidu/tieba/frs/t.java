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
    private com.baidu.tbadk.core.view.userLike.c cNG;
    private ap dEA;
    public HeadImageView dEw;
    public TextView dEx;
    public TextView dEy;
    public EntelechyUserLikeButton dEz;
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
                if (t.this.dEA != null && !com.baidu.tbadk.core.util.ao.isEmpty(t.this.dEA.metaData.getUserName()) && !com.baidu.tbadk.core.util.ao.isEmpty(t.this.dEA.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(t.this.getView().getContext(), t.this.dEA.metaData.getUserId(), t.this.dEA.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.dEw = (HeadImageView) view.findViewById(e.g.rec_usr_header);
        this.dEw.setPageId(this.mPageId);
        this.dEw.setIsRound(true);
        this.dEx = (TextView) view.findViewById(e.g.rec_user_name);
        this.dEy = (TextView) view.findViewById(e.g.rec_user_describe);
        this.dEz = (EntelechyUserLikeButton) view.findViewById(e.g.rec_user_like);
        this.cNG = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dEz);
        this.cNG.setFromType("1");
        this.cNG.h(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ay(View view) {
        return new t(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof ap) {
            this.dEA = (ap) cVar;
            if (!StringUtils.isNull(this.dEA.metaData.getUserId())) {
                this.dEw.startLoad(this.dEA.metaData.getPortrait(), 28, false);
                String z = com.baidu.tbadk.core.util.ao.z(this.dEA.metaData.getUserName(), 5);
                this.dEy.setText(com.baidu.tbadk.core.util.ao.z(this.dEA.metaData.getGodUserData().getIntro(), 6));
                this.dEx.setText(z);
                getView().setOnClickListener(this.mOnClickListener);
                this.cNG.a(this.dEA.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.h(this.dEx, e.d.cp_cont_b);
            com.baidu.tbadk.core.util.al.h(this.dEy, e.d.cp_cont_d);
            this.dEz.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
