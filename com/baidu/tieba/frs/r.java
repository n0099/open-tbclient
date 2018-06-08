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
    private com.baidu.tbadk.core.view.userLike.c cxK;
    public HeadImageView dkl;
    public TextView dkm;
    public TextView dkn;
    public EntelechyUserLikeButton dko;
    private an dkp;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private int mSkinType;

    public r(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (r.this.dkp != null && !com.baidu.tbadk.core.util.ao.isEmpty(r.this.dkp.metaData.getUserName()) && !com.baidu.tbadk.core.util.ao.isEmpty(r.this.dkp.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(r.this.getView().getContext(), r.this.dkp.metaData.getUserId(), r.this.dkp.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.dkl = (HeadImageView) view.findViewById(d.g.rec_usr_header);
        this.dkl.setPageId(this.mPageId);
        this.dkl.setIsRound(true);
        this.dkm = (TextView) view.findViewById(d.g.rec_user_name);
        this.dkn = (TextView) view.findViewById(d.g.rec_user_describe);
        this.dko = (EntelechyUserLikeButton) view.findViewById(d.g.rec_user_like);
        this.cxK = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dko);
        this.cxK.setFromType("1");
        this.cxK.h(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ad(View view) {
        return new r(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof an) {
            this.dkp = (an) cVar;
            if (!StringUtils.isNull(this.dkp.metaData.getUserId())) {
                this.dkl.startLoad(this.dkp.metaData.getPortrait(), 28, false);
                String t = com.baidu.tbadk.core.util.ao.t(this.dkp.metaData.getUserName(), 5);
                this.dkn.setText(com.baidu.tbadk.core.util.ao.t(this.dkp.metaData.getGodUserData().getIntro(), 6));
                this.dkm.setText(t);
                getView().setOnClickListener(this.mOnClickListener);
                this.cxK.a(this.dkp.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.h(this.dkm, d.C0141d.cp_cont_b);
            com.baidu.tbadk.core.util.al.h(this.dkn, d.C0141d.cp_cont_d);
            this.dko.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
