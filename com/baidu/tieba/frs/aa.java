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
/* loaded from: classes16.dex */
public class aa extends com.baidu.tieba.horizonalList.widget.e {
    private com.baidu.tbadk.core.view.userLike.c ahO;
    public EntelechyUserLikeButton hJA;
    private az hJB;
    public HeadImageView hJx;
    public TextView hJy;
    public TextView hJz;
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
                if (aa.this.hJB != null && !com.baidu.tbadk.core.util.as.isEmpty(aa.this.hJB.metaData.getUserName()) && !com.baidu.tbadk.core.util.as.isEmpty(aa.this.hJB.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(aa.this.getView().getContext(), aa.this.hJB.metaData.getUserId(), aa.this.hJB.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.hJx = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.hJx.setPageId(this.mPageId);
        this.hJx.setIsRound(true);
        this.hJy = (TextView) view.findViewById(R.id.rec_user_name);
        this.hJz = (TextView) view.findViewById(R.id.rec_user_describe);
        this.hJA = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.ahO = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.hJA);
        this.ahO.wX("1");
        this.ahO.m(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bR(View view) {
        return new aa(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof az) {
            this.hJB = (az) cVar;
            if (!StringUtils.isNull(this.hJB.metaData.getUserId())) {
                this.hJx.startLoad(this.hJB.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.as.cutStringWithEllipsis(this.hJB.metaData.getUserName(), 5);
                this.hJz.setText(com.baidu.tbadk.core.util.as.cutStringWithEllipsis(this.hJB.metaData.getGodUserData().getIntro(), 6));
                this.hJy.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.ahO.a(this.hJB.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.hJy, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.hJz, R.color.cp_cont_d);
            this.hJA.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
