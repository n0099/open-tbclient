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
    private com.baidu.tbadk.core.view.userLike.c cXP;
    public HeadImageView dOt;
    public TextView dOu;
    public TextView dOv;
    public EntelechyUserLikeButton dOw;
    private ap dOx;
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
                if (t.this.dOx != null && !com.baidu.tbadk.core.util.ao.isEmpty(t.this.dOx.metaData.getUserName()) && !com.baidu.tbadk.core.util.ao.isEmpty(t.this.dOx.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(t.this.getView().getContext(), t.this.dOx.metaData.getUserId(), t.this.dOx.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.dOt = (HeadImageView) view.findViewById(e.g.rec_usr_header);
        this.dOt.setPageId(this.mPageId);
        this.dOt.setIsRound(true);
        this.dOu = (TextView) view.findViewById(e.g.rec_user_name);
        this.dOv = (TextView) view.findViewById(e.g.rec_user_describe);
        this.dOw = (EntelechyUserLikeButton) view.findViewById(e.g.rec_user_like);
        this.cXP = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dOw);
        this.cXP.setFromType("1");
        this.cXP.h(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e aB(View view) {
        return new t(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof ap) {
            this.dOx = (ap) cVar;
            if (!StringUtils.isNull(this.dOx.metaData.getUserId())) {
                this.dOt.startLoad(this.dOx.metaData.getPortrait(), 28, false);
                String A = com.baidu.tbadk.core.util.ao.A(this.dOx.metaData.getUserName(), 5);
                this.dOv.setText(com.baidu.tbadk.core.util.ao.A(this.dOx.metaData.getGodUserData().getIntro(), 6));
                this.dOu.setText(A);
                getView().setOnClickListener(this.mOnClickListener);
                this.cXP.a(this.dOx.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.h(this.dOu, e.d.cp_cont_b);
            com.baidu.tbadk.core.util.al.h(this.dOv, e.d.cp_cont_d);
            this.dOw.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
