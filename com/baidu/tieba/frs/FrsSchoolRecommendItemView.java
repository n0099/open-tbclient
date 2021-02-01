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
    private com.baidu.tbadk.core.view.userLike.c akz;
    public HeadImageView jkj;
    public TextView jkk;
    public TextView jkl;
    public EntelechyUserLikeButton jkm;
    private ay jkn;
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
                if (FrsSchoolRecommendItemView.this.jkn != null && !com.baidu.tbadk.core.util.au.isEmpty(FrsSchoolRecommendItemView.this.jkn.metaData.getUserName()) && !com.baidu.tbadk.core.util.au.isEmpty(FrsSchoolRecommendItemView.this.jkn.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(FrsSchoolRecommendItemView.this.getView().getContext(), FrsSchoolRecommendItemView.this.jkn.metaData.getUserId(), FrsSchoolRecommendItemView.this.jkn.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.jkj = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.jkj.setPageId(this.mPageId);
        this.jkj.setIsRound(true);
        this.jkk = (TextView) view.findViewById(R.id.rec_user_name);
        this.jkl = (TextView) view.findViewById(R.id.rec_user_describe);
        this.jkm = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.akz = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.jkm);
        this.akz.Ag("1");
        this.akz.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder cI(View view) {
        return new FrsSchoolRecommendItemView(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof ay) {
            this.jkn = (ay) cVar;
            if (!StringUtils.isNull(this.jkn.metaData.getUserId())) {
                this.jkj.startLoad(this.jkn.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.au.cutStringWithEllipsis(this.jkn.metaData.getUserName(), 5);
                this.jkl.setText(com.baidu.tbadk.core.util.au.cutStringWithEllipsis(this.jkn.metaData.getGodUserData().getIntro(), 6));
                this.jkk.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.akz.a(this.jkn.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jkk, R.color.CAM_X0105);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jkl, R.color.CAM_X0109);
            this.jkm.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
