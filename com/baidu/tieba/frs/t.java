package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class t extends com.baidu.tieba.horizonalList.widget.e {
    private com.baidu.tbadk.core.view.userLike.c eMu;
    public HeadImageView fyG;
    public TextView fyH;
    public TextView fyI;
    public EntelechyUserLikeButton fyJ;
    private an fyK;
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
                if (t.this.fyK != null && !com.baidu.tbadk.core.util.aq.isEmpty(t.this.fyK.metaData.getUserName()) && !com.baidu.tbadk.core.util.aq.isEmpty(t.this.fyK.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(t.this.getView().getContext(), t.this.fyK.metaData.getUserId(), t.this.fyK.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.fyG = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.fyG.setPageId(this.mPageId);
        this.fyG.setIsRound(true);
        this.fyH = (TextView) view.findViewById(R.id.rec_user_name);
        this.fyI = (TextView) view.findViewById(R.id.rec_user_describe);
        this.fyJ = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.eMu = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.fyJ);
        this.eMu.mX("1");
        this.eMu.j(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bB(View view) {
        return new t(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof an) {
            this.fyK = (an) cVar;
            if (!StringUtils.isNull(this.fyK.metaData.getUserId())) {
                this.fyG.startLoad(this.fyK.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.fyK.metaData.getUserName(), 5);
                this.fyI.setText(com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.fyK.metaData.getGodUserData().getIntro(), 6));
                this.fyH.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.eMu.a(this.fyK.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.fyH, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.fyI, (int) R.color.cp_cont_d);
            this.fyJ.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
