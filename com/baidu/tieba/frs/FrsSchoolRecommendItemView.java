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
    private com.baidu.tbadk.core.view.userLike.c alS;
    public HeadImageView jmg;
    public TextView jmh;
    public TextView jmi;
    public EntelechyUserLikeButton jmj;
    private ay jmk;
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
                if (FrsSchoolRecommendItemView.this.jmk != null && !com.baidu.tbadk.core.util.au.isEmpty(FrsSchoolRecommendItemView.this.jmk.metaData.getUserName()) && !com.baidu.tbadk.core.util.au.isEmpty(FrsSchoolRecommendItemView.this.jmk.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(FrsSchoolRecommendItemView.this.getView().getContext(), FrsSchoolRecommendItemView.this.jmk.metaData.getUserId(), FrsSchoolRecommendItemView.this.jmk.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.jmg = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.jmg.setPageId(this.mPageId);
        this.jmg.setIsRound(true);
        this.jmh = (TextView) view.findViewById(R.id.rec_user_name);
        this.jmi = (TextView) view.findViewById(R.id.rec_user_describe);
        this.jmj = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.alS = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.jmj);
        this.alS.An("1");
        this.alS.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public ItemViewHolder cI(View view) {
        return new FrsSchoolRecommendItemView(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof ay) {
            this.jmk = (ay) cVar;
            if (!StringUtils.isNull(this.jmk.metaData.getUserId())) {
                this.jmg.startLoad(this.jmk.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.au.cutStringWithEllipsis(this.jmk.metaData.getUserName(), 5);
                this.jmi.setText(com.baidu.tbadk.core.util.au.cutStringWithEllipsis(this.jmk.metaData.getGodUserData().getIntro(), 6));
                this.jmh.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.alS.a(this.jmk.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.ItemViewHolder
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jmh, R.color.CAM_X0105);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jmi, R.color.CAM_X0109);
            this.jmj.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
