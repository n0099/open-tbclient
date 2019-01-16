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
    private com.baidu.tbadk.core.view.userLike.c cXO;
    public HeadImageView dOs;
    public TextView dOt;
    public TextView dOu;
    public EntelechyUserLikeButton dOv;
    private ap dOw;
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
                if (t.this.dOw != null && !com.baidu.tbadk.core.util.ao.isEmpty(t.this.dOw.metaData.getUserName()) && !com.baidu.tbadk.core.util.ao.isEmpty(t.this.dOw.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(t.this.getView().getContext(), t.this.dOw.metaData.getUserId(), t.this.dOw.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.dOs = (HeadImageView) view.findViewById(e.g.rec_usr_header);
        this.dOs.setPageId(this.mPageId);
        this.dOs.setIsRound(true);
        this.dOt = (TextView) view.findViewById(e.g.rec_user_name);
        this.dOu = (TextView) view.findViewById(e.g.rec_user_describe);
        this.dOv = (EntelechyUserLikeButton) view.findViewById(e.g.rec_user_like);
        this.cXO = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dOv);
        this.cXO.setFromType("1");
        this.cXO.h(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e aB(View view) {
        return new t(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof ap) {
            this.dOw = (ap) cVar;
            if (!StringUtils.isNull(this.dOw.metaData.getUserId())) {
                this.dOs.startLoad(this.dOw.metaData.getPortrait(), 28, false);
                String A = com.baidu.tbadk.core.util.ao.A(this.dOw.metaData.getUserName(), 5);
                this.dOu.setText(com.baidu.tbadk.core.util.ao.A(this.dOw.metaData.getGodUserData().getIntro(), 6));
                this.dOt.setText(A);
                getView().setOnClickListener(this.mOnClickListener);
                this.cXO.a(this.dOw.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.h(this.dOt, e.d.cp_cont_b);
            com.baidu.tbadk.core.util.al.h(this.dOu, e.d.cp_cont_d);
            this.dOv.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
