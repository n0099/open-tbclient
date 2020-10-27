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
public class ab extends com.baidu.tieba.horizonalList.widget.e {
    private com.baidu.tbadk.core.view.userLike.c ajW;
    public HeadImageView iFu;
    public TextView iFv;
    public TextView iFw;
    public EntelechyUserLikeButton iFx;
    private bb iFy;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private int mSkinType;

    public ab(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.ab.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ab.this.iFy != null && !com.baidu.tbadk.core.util.at.isEmpty(ab.this.iFy.metaData.getUserName()) && !com.baidu.tbadk.core.util.at.isEmpty(ab.this.iFy.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ab.this.getView().getContext(), ab.this.iFy.metaData.getUserId(), ab.this.iFy.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.iFu = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.iFu.setPageId(this.mPageId);
        this.iFu.setIsRound(true);
        this.iFv = (TextView) view.findViewById(R.id.rec_user_name);
        this.iFw = (TextView) view.findViewById(R.id.rec_user_describe);
        this.iFx = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.ajW = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.iFx);
        this.ajW.AM("1");
        this.ajW.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ck(View view) {
        return new ab(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof bb) {
            this.iFy = (bb) cVar;
            if (!StringUtils.isNull(this.iFy.metaData.getUserId())) {
                this.iFu.startLoad(this.iFy.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.at.cutStringWithEllipsis(this.iFy.metaData.getUserName(), 5);
                this.iFw.setText(com.baidu.tbadk.core.util.at.cutStringWithEllipsis(this.iFy.metaData.getGodUserData().getIntro(), 6));
                this.iFv.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.ajW.a(this.iFy.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.iFv, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.iFw, (int) R.color.cp_cont_d);
            this.iFx.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
