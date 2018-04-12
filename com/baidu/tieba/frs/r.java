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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class r extends com.baidu.tieba.horizonalList.widget.e {
    public HeadImageView cZP;
    public TextView cZQ;
    public TextView cZR;
    public EntelechyUserLikeButton cZS;
    private an cZT;
    private com.baidu.tbadk.core.view.userLike.c coa;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private int mSkinType;

    public r(View view2, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view2);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (r.this.cZT != null && !com.baidu.tbadk.core.util.an.isEmpty(r.this.cZT.metaData.getUserName()) && !com.baidu.tbadk.core.util.an.isEmpty(r.this.cZT.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(r.this.getView().getContext(), r.this.cZT.metaData.getUserId(), r.this.cZT.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.cZP = (HeadImageView) view2.findViewById(d.g.rec_usr_header);
        this.cZP.setPageId(this.mPageId);
        this.cZP.setIsRound(true);
        this.cZQ = (TextView) view2.findViewById(d.g.rec_user_name);
        this.cZR = (TextView) view2.findViewById(d.g.rec_user_describe);
        this.cZS = (EntelechyUserLikeButton) view2.findViewById(d.g.rec_user_like);
        this.coa = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.cZS);
        this.coa.setFromType("1");
        this.coa.h(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ad(View view2) {
        return new r(view2, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof an) {
            this.cZT = (an) cVar;
            if (!StringUtils.isNull(this.cZT.metaData.getUserId())) {
                this.cZP.startLoad(this.cZT.metaData.getPortrait(), 28, false);
                String t = com.baidu.tbadk.core.util.an.t(this.cZT.metaData.getUserName(), 5);
                this.cZR.setText(com.baidu.tbadk.core.util.an.t(this.cZT.metaData.getGodUserData().getIntro(), 6));
                this.cZQ.setText(t);
                getView().setOnClickListener(this.mOnClickListener);
                this.coa.a(this.cZT.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ak.h(this.cZQ, d.C0126d.cp_cont_b);
            com.baidu.tbadk.core.util.ak.h(this.cZR, d.C0126d.cp_cont_d);
            this.cZS.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
