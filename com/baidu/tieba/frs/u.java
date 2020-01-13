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
/* loaded from: classes7.dex */
public class u extends com.baidu.tieba.horizonalList.widget.e {
    private com.baidu.tbadk.core.view.userLike.c Nb;
    public HeadImageView gpv;
    public TextView gpw;
    public TextView gpx;
    public EntelechyUserLikeButton gpy;
    private ao gpz;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private int mSkinType;

    public u(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.u.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (u.this.gpz != null && !com.baidu.tbadk.core.util.aq.isEmpty(u.this.gpz.metaData.getUserName()) && !com.baidu.tbadk.core.util.aq.isEmpty(u.this.gpz.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(u.this.getView().getContext(), u.this.gpz.metaData.getUserId(), u.this.gpz.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.gpv = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.gpv.setPageId(this.mPageId);
        this.gpv.setIsRound(true);
        this.gpw = (TextView) view.findViewById(R.id.rec_user_name);
        this.gpx = (TextView) view.findViewById(R.id.rec_user_describe);
        this.gpy = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.Nb = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.gpy);
        this.Nb.sn("1");
        this.Nb.j(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bD(View view) {
        return new u(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof ao) {
            this.gpz = (ao) cVar;
            if (!StringUtils.isNull(this.gpz.metaData.getUserId())) {
                this.gpv.startLoad(this.gpz.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.gpz.metaData.getUserName(), 5);
                this.gpx.setText(com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.gpz.metaData.getGodUserData().getIntro(), 6));
                this.gpw.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.Nb.a(this.gpz.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gpw, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gpx, (int) R.color.cp_cont_d);
            this.gpy.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
