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
    private com.baidu.tbadk.core.view.userLike.c ehj;
    public HeadImageView fbV;
    public TextView fbW;
    public TextView fbX;
    public EntelechyUserLikeButton fbY;
    private an fbZ;
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
                if (t.this.fbZ != null && !com.baidu.tbadk.core.util.ap.isEmpty(t.this.fbZ.metaData.getUserName()) && !com.baidu.tbadk.core.util.ap.isEmpty(t.this.fbZ.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(t.this.getView().getContext(), t.this.fbZ.metaData.getUserId(), t.this.fbZ.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.fbV = (HeadImageView) view.findViewById(d.g.rec_usr_header);
        this.fbV.setPageId(this.mPageId);
        this.fbV.setIsRound(true);
        this.fbW = (TextView) view.findViewById(d.g.rec_user_name);
        this.fbX = (TextView) view.findViewById(d.g.rec_user_describe);
        this.fbY = (EntelechyUserLikeButton) view.findViewById(d.g.rec_user_like);
        this.ehj = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.fbY);
        this.ehj.setFromType("1");
        this.ehj.i(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bv(View view) {
        return new t(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof an) {
            this.fbZ = (an) cVar;
            if (!StringUtils.isNull(this.fbZ.metaData.getUserId())) {
                this.fbV.startLoad(this.fbZ.metaData.getPortrait(), 28, false);
                String V = com.baidu.tbadk.core.util.ap.V(this.fbZ.metaData.getUserName(), 5);
                this.fbX.setText(com.baidu.tbadk.core.util.ap.V(this.fbZ.metaData.getGodUserData().getIntro(), 6));
                this.fbW.setText(V);
                getView().setOnClickListener(this.mOnClickListener);
                this.ehj.a(this.fbZ.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.j(this.fbW, d.C0277d.cp_cont_b);
            com.baidu.tbadk.core.util.al.j(this.fbX, d.C0277d.cp_cont_d);
            this.fbY.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
