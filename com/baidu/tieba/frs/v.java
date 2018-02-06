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
    private com.baidu.tbadk.core.view.userLike.c cWj;
    public HeadImageView dHd;
    public TextView dHe;
    public TextView dHf;
    public EntelechyUserLikeButton dHg;
    private ar dHh;
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
                if (v.this.dHh != null && !com.baidu.tbadk.core.util.am.isEmpty(v.this.dHh.metaData.getUserName()) && !com.baidu.tbadk.core.util.am.isEmpty(v.this.dHh.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(v.this.getView().getContext(), v.this.dHh.metaData.getUserId(), v.this.dHh.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.dHd = (HeadImageView) view.findViewById(d.g.rec_usr_header);
        this.dHd.setPageId(this.mPageId);
        this.dHd.setIsRound(true);
        this.dHe = (TextView) view.findViewById(d.g.rec_user_name);
        this.dHf = (TextView) view.findViewById(d.g.rec_user_describe);
        this.dHg = (EntelechyUserLikeButton) view.findViewById(d.g.rec_user_like);
        this.cWj = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dHg);
        this.cWj.setFromType("1");
        this.cWj.h(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public com.baidu.tieba.horizonalList.widget.f bz(View view) {
        return new v(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void a(com.baidu.tieba.horizonalList.widget.d dVar) {
        if (dVar instanceof ar) {
            this.dHh = (ar) dVar;
            if (!StringUtils.isNull(this.dHh.metaData.getUserId())) {
                this.dHd.startLoad(this.dHh.metaData.getPortrait(), 28, false);
                String t = com.baidu.tbadk.core.util.am.t(this.dHh.metaData.getUserName(), 5);
                this.dHf.setText(com.baidu.tbadk.core.util.am.t(this.dHh.metaData.getGodUserData().getIntro(), 6));
                this.dHe.setText(t);
                getView().setOnClickListener(this.mOnClickListener);
                this.cWj.a(this.dHh.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.f
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aj.r(this.dHe, d.C0140d.cp_cont_b);
            com.baidu.tbadk.core.util.aj.r(this.dHf, d.C0140d.cp_cont_d);
            this.dHg.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
