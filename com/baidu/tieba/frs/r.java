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
    private com.baidu.tbadk.core.view.userLike.c cpg;
    public HeadImageView daV;
    public TextView daW;
    public TextView daX;
    public EntelechyUserLikeButton daY;
    private an daZ;
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
                if (r.this.daZ != null && !com.baidu.tbadk.core.util.an.isEmpty(r.this.daZ.metaData.getUserName()) && !com.baidu.tbadk.core.util.an.isEmpty(r.this.daZ.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(r.this.getView().getContext(), r.this.daZ.metaData.getUserId(), r.this.daZ.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.daV = (HeadImageView) view2.findViewById(d.g.rec_usr_header);
        this.daV.setPageId(this.mPageId);
        this.daV.setIsRound(true);
        this.daW = (TextView) view2.findViewById(d.g.rec_user_name);
        this.daX = (TextView) view2.findViewById(d.g.rec_user_describe);
        this.daY = (EntelechyUserLikeButton) view2.findViewById(d.g.rec_user_like);
        this.cpg = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.daY);
        this.cpg.setFromType("1");
        this.cpg.h(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ad(View view2) {
        return new r(view2, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof an) {
            this.daZ = (an) cVar;
            if (!StringUtils.isNull(this.daZ.metaData.getUserId())) {
                this.daV.startLoad(this.daZ.metaData.getPortrait(), 28, false);
                String t = com.baidu.tbadk.core.util.an.t(this.daZ.metaData.getUserName(), 5);
                this.daX.setText(com.baidu.tbadk.core.util.an.t(this.daZ.metaData.getGodUserData().getIntro(), 6));
                this.daW.setText(t);
                getView().setOnClickListener(this.mOnClickListener);
                this.cpg.a(this.daZ.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ak.h(this.daW, d.C0126d.cp_cont_b);
            com.baidu.tbadk.core.util.ak.h(this.daX, d.C0126d.cp_cont_d);
            this.daY.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
