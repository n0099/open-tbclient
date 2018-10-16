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
    private com.baidu.tbadk.core.view.userLike.c cMA;
    public HeadImageView dDg;
    public TextView dDh;
    public TextView dDi;
    public EntelechyUserLikeButton dDj;
    private ap dDk;
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
                if (t.this.dDk != null && !com.baidu.tbadk.core.util.ao.isEmpty(t.this.dDk.metaData.getUserName()) && !com.baidu.tbadk.core.util.ao.isEmpty(t.this.dDk.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(t.this.getView().getContext(), t.this.dDk.metaData.getUserId(), t.this.dDk.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.dDg = (HeadImageView) view.findViewById(e.g.rec_usr_header);
        this.dDg.setPageId(this.mPageId);
        this.dDg.setIsRound(true);
        this.dDh = (TextView) view.findViewById(e.g.rec_user_name);
        this.dDi = (TextView) view.findViewById(e.g.rec_user_describe);
        this.dDj = (EntelechyUserLikeButton) view.findViewById(e.g.rec_user_like);
        this.cMA = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dDj);
        this.cMA.setFromType("1");
        this.cMA.h(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e aw(View view) {
        return new t(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof ap) {
            this.dDk = (ap) cVar;
            if (!StringUtils.isNull(this.dDk.metaData.getUserId())) {
                this.dDg.startLoad(this.dDk.metaData.getPortrait(), 28, false);
                String z = com.baidu.tbadk.core.util.ao.z(this.dDk.metaData.getUserName(), 5);
                this.dDi.setText(com.baidu.tbadk.core.util.ao.z(this.dDk.metaData.getGodUserData().getIntro(), 6));
                this.dDh.setText(z);
                getView().setOnClickListener(this.mOnClickListener);
                this.cMA.a(this.dDk.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.h(this.dDh, e.d.cp_cont_b);
            com.baidu.tbadk.core.util.al.h(this.dDi, e.d.cp_cont_d);
            this.dDj.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
