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
public class v extends com.baidu.tieba.horizonalList.widget.f {
    private com.baidu.tbadk.core.view.userLike.c cVX;
    public HeadImageView dGR;
    public TextView dGS;
    public TextView dGT;
    public EntelechyUserLikeButton dGU;
    private ar dGV;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private int mSkinType;

    public v(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.dGV != null && !com.baidu.tbadk.core.util.am.isEmpty(v.this.dGV.metaData.getUserName()) && !com.baidu.tbadk.core.util.am.isEmpty(v.this.dGV.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(v.this.getView().getContext(), v.this.dGV.metaData.getUserId(), v.this.dGV.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.dGR = (HeadImageView) view.findViewById(d.g.rec_usr_header);
        this.dGR.setPageId(this.mPageId);
        this.dGR.setIsRound(true);
        this.dGS = (TextView) view.findViewById(d.g.rec_user_name);
        this.dGT = (TextView) view.findViewById(d.g.rec_user_describe);
        this.dGU = (EntelechyUserLikeButton) view.findViewById(d.g.rec_user_like);
        this.cVX = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dGU);
        this.cVX.setFromType("1");
        this.cVX.h(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f bz(View view) {
        return new v(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof ar) {
            this.dGV = (ar) dVar;
            if (!StringUtils.isNull(this.dGV.metaData.getUserId())) {
                this.dGR.startLoad(this.dGV.metaData.getPortrait(), 28, false);
                String t = com.baidu.tbadk.core.util.am.t(this.dGV.metaData.getUserName(), 5);
                this.dGT.setText(com.baidu.tbadk.core.util.am.t(this.dGV.metaData.getGodUserData().getIntro(), 6));
                this.dGS.setText(t);
                getView().setOnClickListener(this.mOnClickListener);
                this.cVX.a(this.dGV.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aj.r(this.dGS, d.C0141d.cp_cont_b);
            com.baidu.tbadk.core.util.aj.r(this.dGT, d.C0141d.cp_cont_d);
            this.dGU.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
