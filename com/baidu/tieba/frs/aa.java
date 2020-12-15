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
    public HeadImageView iWX;
    public TextView iWY;
    public TextView iWZ;
    public EntelechyUserLikeButton iXa;
    private bb iXb;
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
                if (aa.this.iXb != null && !com.baidu.tbadk.core.util.au.isEmpty(aa.this.iXb.metaData.getUserName()) && !com.baidu.tbadk.core.util.au.isEmpty(aa.this.iXb.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(aa.this.getView().getContext(), aa.this.iXb.metaData.getUserId(), aa.this.iXb.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.iWX = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.iWX.setPageId(this.mPageId);
        this.iWX.setIsRound(true);
        this.iWY = (TextView) view.findViewById(R.id.rec_user_name);
        this.iWZ = (TextView) view.findViewById(R.id.rec_user_describe);
        this.iXa = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.akZ = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.iXa);
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
            this.iXb = (bb) cVar;
            if (!StringUtils.isNull(this.iXb.metaData.getUserId())) {
                this.iWX.startLoad(this.iXb.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.au.cutStringWithEllipsis(this.iXb.metaData.getUserName(), 5);
                this.iWZ.setText(com.baidu.tbadk.core.util.au.cutStringWithEllipsis(this.iXb.metaData.getGodUserData().getIntro(), 6));
                this.iWY.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.akZ.a(this.iXb.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.iWY, (int) R.color.CAM_X0105);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.iWZ, (int) R.color.CAM_X0109);
            this.iXa.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
