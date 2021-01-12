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
import com.baidu.tieba.horizonalList.widget.ItemViewHolder;
/* loaded from: classes2.dex */
public class FrsSchoolRecommendItemView extends ItemViewHolder {
    private com.baidu.tbadk.core.view.userLike.c akK;
    public HeadImageView jeC;
    public TextView jeD;
    public TextView jeE;
    public EntelechyUserLikeButton jeF;
    private ay jeG;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private int mSkinType;

    public FrsSchoolRecommendItemView(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsSchoolRecommendItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (FrsSchoolRecommendItemView.this.jeG != null && !com.baidu.tbadk.core.util.at.isEmpty(FrsSchoolRecommendItemView.this.jeG.metaData.getUserName()) && !com.baidu.tbadk.core.util.at.isEmpty(FrsSchoolRecommendItemView.this.jeG.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(FrsSchoolRecommendItemView.this.getView().getContext(), FrsSchoolRecommendItemView.this.jeG.metaData.getUserId(), FrsSchoolRecommendItemView.this.jeG.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.jeC = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.jeC.setPageId(this.mPageId);
        this.jeC.setIsRound(true);
        this.jeD = (TextView) view.findViewById(R.id.rec_user_name);
        this.jeE = (TextView) view.findViewById(R.id.rec_user_describe);
        this.jeF = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.akK = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.jeF);
        this.akK.zP("1");
        this.akK.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder cK(View view) {
        return new FrsSchoolRecommendItemView(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof ay) {
            this.jeG = (ay) cVar;
            if (!StringUtils.isNull(this.jeG.metaData.getUserId())) {
                this.jeC.startLoad(this.jeG.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.at.cutStringWithEllipsis(this.jeG.metaData.getUserName(), 5);
                this.jeE.setText(com.baidu.tbadk.core.util.at.cutStringWithEllipsis(this.jeG.metaData.getGodUserData().getIntro(), 6));
                this.jeD.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.akK.a(this.jeG.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.jeD, R.color.CAM_X0105);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.jeE, R.color.CAM_X0109);
            this.jeF.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
