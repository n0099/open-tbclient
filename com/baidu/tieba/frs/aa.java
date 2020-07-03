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
/* loaded from: classes9.dex */
public class aa extends com.baidu.tieba.horizonalList.widget.e {
    private com.baidu.tbadk.core.view.userLike.c ahX;
    public TextView hDA;
    public TextView hDB;
    public EntelechyUserLikeButton hDC;
    private az hDD;
    public HeadImageView hDz;
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
                if (aa.this.hDD != null && !com.baidu.tbadk.core.util.ar.isEmpty(aa.this.hDD.metaData.getUserName()) && !com.baidu.tbadk.core.util.ar.isEmpty(aa.this.hDD.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(aa.this.getView().getContext(), aa.this.hDD.metaData.getUserId(), aa.this.hDD.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.hDz = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.hDz.setPageId(this.mPageId);
        this.hDz.setIsRound(true);
        this.hDA = (TextView) view.findViewById(R.id.rec_user_name);
        this.hDB = (TextView) view.findViewById(R.id.rec_user_describe);
        this.hDC = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.ahX = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.hDC);
        this.ahX.vQ("1");
        this.ahX.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bL(View view) {
        return new aa(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof az) {
            this.hDD = (az) cVar;
            if (!StringUtils.isNull(this.hDD.metaData.getUserId())) {
                this.hDz.startLoad(this.hDD.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.ar.cutStringWithEllipsis(this.hDD.metaData.getUserName(), 5);
                this.hDB.setText(com.baidu.tbadk.core.util.ar.cutStringWithEllipsis(this.hDD.metaData.getGodUserData().getIntro(), 6));
                this.hDA.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.ahX.a(this.hDD.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.an.setViewTextColor(this.hDA, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.an.setViewTextColor(this.hDB, (int) R.color.cp_cont_d);
            this.hDC.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
