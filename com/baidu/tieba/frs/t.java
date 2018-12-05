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
    private com.baidu.tbadk.core.view.userLike.c cUn;
    public HeadImageView dKV;
    public TextView dKW;
    public TextView dKX;
    public EntelechyUserLikeButton dKY;
    private ap dKZ;
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
                if (t.this.dKZ != null && !com.baidu.tbadk.core.util.ao.isEmpty(t.this.dKZ.metaData.getUserName()) && !com.baidu.tbadk.core.util.ao.isEmpty(t.this.dKZ.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(t.this.getView().getContext(), t.this.dKZ.metaData.getUserId(), t.this.dKZ.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.dKV = (HeadImageView) view.findViewById(e.g.rec_usr_header);
        this.dKV.setPageId(this.mPageId);
        this.dKV.setIsRound(true);
        this.dKW = (TextView) view.findViewById(e.g.rec_user_name);
        this.dKX = (TextView) view.findViewById(e.g.rec_user_describe);
        this.dKY = (EntelechyUserLikeButton) view.findViewById(e.g.rec_user_like);
        this.cUn = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dKY);
        this.cUn.setFromType("1");
        this.cUn.h(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ay(View view) {
        return new t(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof ap) {
            this.dKZ = (ap) cVar;
            if (!StringUtils.isNull(this.dKZ.metaData.getUserId())) {
                this.dKV.startLoad(this.dKZ.metaData.getPortrait(), 28, false);
                String z = com.baidu.tbadk.core.util.ao.z(this.dKZ.metaData.getUserName(), 5);
                this.dKX.setText(com.baidu.tbadk.core.util.ao.z(this.dKZ.metaData.getGodUserData().getIntro(), 6));
                this.dKW.setText(z);
                getView().setOnClickListener(this.mOnClickListener);
                this.cUn.a(this.dKZ.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.h(this.dKW, e.d.cp_cont_b);
            com.baidu.tbadk.core.util.al.h(this.dKX, e.d.cp_cont_d);
            this.dKY.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
