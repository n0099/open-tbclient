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
    private com.baidu.tbadk.core.view.userLike.c cWa;
    public HeadImageView dGW;
    public TextView dGX;
    public TextView dGY;
    public EntelechyUserLikeButton dGZ;
    private ar dHa;
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
                if (v.this.dHa != null && !com.baidu.tbadk.core.util.am.isEmpty(v.this.dHa.metaData.getUserName()) && !com.baidu.tbadk.core.util.am.isEmpty(v.this.dHa.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(v.this.getView().getContext(), v.this.dHa.metaData.getUserId(), v.this.dHa.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.dGW = (HeadImageView) view.findViewById(d.g.rec_usr_header);
        this.dGW.setPageId(this.mPageId);
        this.dGW.setIsRound(true);
        this.dGX = (TextView) view.findViewById(d.g.rec_user_name);
        this.dGY = (TextView) view.findViewById(d.g.rec_user_describe);
        this.dGZ = (EntelechyUserLikeButton) view.findViewById(d.g.rec_user_like);
        this.cWa = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dGZ);
        this.cWa.setFromType("1");
        this.cWa.h(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f bz(View view) {
        return new v(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof ar) {
            this.dHa = (ar) dVar;
            if (!StringUtils.isNull(this.dHa.metaData.getUserId())) {
                this.dGW.startLoad(this.dHa.metaData.getPortrait(), 28, false);
                String t = com.baidu.tbadk.core.util.am.t(this.dHa.metaData.getUserName(), 5);
                this.dGY.setText(com.baidu.tbadk.core.util.am.t(this.dHa.metaData.getGodUserData().getIntro(), 6));
                this.dGX.setText(t);
                getView().setOnClickListener(this.mOnClickListener);
                this.cWa.a(this.dHa.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aj.r(this.dGX, d.C0141d.cp_cont_b);
            com.baidu.tbadk.core.util.aj.r(this.dGY, d.C0141d.cp_cont_d);
            this.dGZ.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
