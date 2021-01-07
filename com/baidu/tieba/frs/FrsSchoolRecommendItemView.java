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
    private com.baidu.tbadk.core.view.userLike.c alC;
    public HeadImageView jjk;
    public TextView jjl;
    public TextView jjm;
    public EntelechyUserLikeButton jjn;
    private ay jjo;
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
                if (FrsSchoolRecommendItemView.this.jjo != null && !com.baidu.tbadk.core.util.at.isEmpty(FrsSchoolRecommendItemView.this.jjo.metaData.getUserName()) && !com.baidu.tbadk.core.util.at.isEmpty(FrsSchoolRecommendItemView.this.jjo.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(FrsSchoolRecommendItemView.this.getView().getContext(), FrsSchoolRecommendItemView.this.jjo.metaData.getUserId(), FrsSchoolRecommendItemView.this.jjo.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.jjk = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.jjk.setPageId(this.mPageId);
        this.jjk.setIsRound(true);
        this.jjl = (TextView) view.findViewById(R.id.rec_user_name);
        this.jjm = (TextView) view.findViewById(R.id.rec_user_describe);
        this.jjn = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.alC = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.jjn);
        this.alC.Ba("1");
        this.alC.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder cK(View view) {
        return new FrsSchoolRecommendItemView(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof ay) {
            this.jjo = (ay) cVar;
            if (!StringUtils.isNull(this.jjo.metaData.getUserId())) {
                this.jjk.startLoad(this.jjo.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.at.cutStringWithEllipsis(this.jjo.metaData.getUserName(), 5);
                this.jjm.setText(com.baidu.tbadk.core.util.at.cutStringWithEllipsis(this.jjo.metaData.getGodUserData().getIntro(), 6));
                this.jjl.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.alC.a(this.jjo.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.jjl, R.color.CAM_X0105);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.jjm, R.color.CAM_X0109);
            this.jjn.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
