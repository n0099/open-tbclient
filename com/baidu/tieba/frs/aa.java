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
/* loaded from: classes22.dex */
public class aa extends com.baidu.tieba.horizonalList.widget.e {
    private com.baidu.tbadk.core.view.userLike.c akZ;
    public HeadImageView iWV;
    public TextView iWW;
    public TextView iWX;
    public EntelechyUserLikeButton iWY;
    private bb iWZ;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private int mSkinType;

    public aa(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.aa.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aa.this.iWZ != null && !com.baidu.tbadk.core.util.au.isEmpty(aa.this.iWZ.metaData.getUserName()) && !com.baidu.tbadk.core.util.au.isEmpty(aa.this.iWZ.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(aa.this.getView().getContext(), aa.this.iWZ.metaData.getUserId(), aa.this.iWZ.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.iWV = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.iWV.setPageId(this.mPageId);
        this.iWV.setIsRound(true);
        this.iWW = (TextView) view.findViewById(R.id.rec_user_name);
        this.iWX = (TextView) view.findViewById(R.id.rec_user_describe);
        this.iWY = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.akZ = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.iWY);
        this.akZ.Bc("1");
        this.akZ.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e cA(View view) {
        return new aa(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof bb) {
            this.iWZ = (bb) cVar;
            if (!StringUtils.isNull(this.iWZ.metaData.getUserId())) {
                this.iWV.startLoad(this.iWZ.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.au.cutStringWithEllipsis(this.iWZ.metaData.getUserName(), 5);
                this.iWX.setText(com.baidu.tbadk.core.util.au.cutStringWithEllipsis(this.iWZ.metaData.getGodUserData().getIntro(), 6));
                this.iWW.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.akZ.a(this.iWZ.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.iWW, (int) R.color.CAM_X0105);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.iWX, (int) R.color.CAM_X0109);
            this.iWY.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
