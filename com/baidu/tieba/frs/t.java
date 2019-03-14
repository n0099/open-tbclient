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
/* loaded from: classes4.dex */
public class t extends com.baidu.tieba.horizonalList.widget.e {
    private com.baidu.tbadk.core.view.userLike.c ehx;
    public HeadImageView fci;
    public TextView fcj;
    public TextView fck;
    public EntelechyUserLikeButton fcl;
    private an fcm;
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
                if (t.this.fcm != null && !com.baidu.tbadk.core.util.ap.isEmpty(t.this.fcm.metaData.getUserName()) && !com.baidu.tbadk.core.util.ap.isEmpty(t.this.fcm.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(t.this.getView().getContext(), t.this.fcm.metaData.getUserId(), t.this.fcm.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.fci = (HeadImageView) view.findViewById(d.g.rec_usr_header);
        this.fci.setPageId(this.mPageId);
        this.fci.setIsRound(true);
        this.fcj = (TextView) view.findViewById(d.g.rec_user_name);
        this.fck = (TextView) view.findViewById(d.g.rec_user_describe);
        this.fcl = (EntelechyUserLikeButton) view.findViewById(d.g.rec_user_like);
        this.ehx = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.fcl);
        this.ehx.setFromType("1");
        this.ehx.i(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bv(View view) {
        return new t(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof an) {
            this.fcm = (an) cVar;
            if (!StringUtils.isNull(this.fcm.metaData.getUserId())) {
                this.fci.startLoad(this.fcm.metaData.getPortrait(), 28, false);
                String V = com.baidu.tbadk.core.util.ap.V(this.fcm.metaData.getUserName(), 5);
                this.fck.setText(com.baidu.tbadk.core.util.ap.V(this.fcm.metaData.getGodUserData().getIntro(), 6));
                this.fcj.setText(V);
                getView().setOnClickListener(this.mOnClickListener);
                this.ehx.a(this.fcm.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.j(this.fcj, d.C0277d.cp_cont_b);
            com.baidu.tbadk.core.util.al.j(this.fck, d.C0277d.cp_cont_d);
            this.fcl.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
