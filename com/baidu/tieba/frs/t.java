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
    private com.baidu.tbadk.core.view.userLike.c ewX;
    public HeadImageView fsj;
    public TextView fsk;
    public TextView fsl;
    public EntelechyUserLikeButton fsm;
    private an fsn;
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
                if (t.this.fsn != null && !com.baidu.tbadk.core.util.ap.isEmpty(t.this.fsn.metaData.getUserName()) && !com.baidu.tbadk.core.util.ap.isEmpty(t.this.fsn.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(t.this.getView().getContext(), t.this.fsn.metaData.getUserId(), t.this.fsn.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.fsj = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.fsj.setPageId(this.mPageId);
        this.fsj.setIsRound(true);
        this.fsk = (TextView) view.findViewById(R.id.rec_user_name);
        this.fsl = (TextView) view.findViewById(R.id.rec_user_describe);
        this.fsm = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.ewX = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.fsm);
        this.ewX.setFromType("1");
        this.ewX.i(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bC(View view) {
        return new t(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof an) {
            this.fsn = (an) cVar;
            if (!StringUtils.isNull(this.fsn.metaData.getUserId())) {
                this.fsj.startLoad(this.fsn.metaData.getPortrait(), 28, false);
                String R = com.baidu.tbadk.core.util.ap.R(this.fsn.metaData.getUserName(), 5);
                this.fsl.setText(com.baidu.tbadk.core.util.ap.R(this.fsn.metaData.getGodUserData().getIntro(), 6));
                this.fsk.setText(R);
                getView().setOnClickListener(this.mOnClickListener);
                this.ewX.a(this.fsn.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.j(this.fsk, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.al.j(this.fsl, R.color.cp_cont_d);
            this.fsm.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
