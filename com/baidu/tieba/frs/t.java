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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class t extends com.baidu.tieba.horizonalList.widget.e {
    private com.baidu.tbadk.core.view.userLike.c eCe;
    public HeadImageView fxF;
    public TextView fxG;
    public TextView fxH;
    public EntelechyUserLikeButton fxI;
    private an fxJ;
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
                if (t.this.fxJ != null && !com.baidu.tbadk.core.util.aq.isEmpty(t.this.fxJ.metaData.getUserName()) && !com.baidu.tbadk.core.util.aq.isEmpty(t.this.fxJ.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(t.this.getView().getContext(), t.this.fxJ.metaData.getUserId(), t.this.fxJ.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.fxF = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.fxF.setPageId(this.mPageId);
        this.fxF.setIsRound(true);
        this.fxG = (TextView) view.findViewById(R.id.rec_user_name);
        this.fxH = (TextView) view.findViewById(R.id.rec_user_describe);
        this.fxI = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.eCe = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.fxI);
        this.eCe.setFromType("1");
        this.eCe.j(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bE(View view) {
        return new t(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof an) {
            this.fxJ = (an) cVar;
            if (!StringUtils.isNull(this.fxJ.metaData.getUserId())) {
                this.fxF.startLoad(this.fxJ.metaData.getPortrait(), 28, false);
                String R = com.baidu.tbadk.core.util.aq.R(this.fxJ.metaData.getUserName(), 5);
                this.fxH.setText(com.baidu.tbadk.core.util.aq.R(this.fxJ.metaData.getGodUserData().getIntro(), 6));
                this.fxG.setText(R);
                getView().setOnClickListener(this.mOnClickListener);
                this.eCe.a(this.fxJ.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.j(this.fxG, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.am.j(this.fxH, R.color.cp_cont_d);
            this.fxI.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
