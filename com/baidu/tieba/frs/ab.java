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
/* loaded from: classes21.dex */
public class ab extends com.baidu.tieba.horizonalList.widget.e {
    private com.baidu.tbadk.core.view.userLike.c ajZ;
    public HeadImageView iMe;
    public TextView iMf;
    public TextView iMg;
    public EntelechyUserLikeButton iMh;
    private bb iMi;
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
                if (ab.this.iMi != null && !com.baidu.tbadk.core.util.au.isEmpty(ab.this.iMi.metaData.getUserName()) && !com.baidu.tbadk.core.util.au.isEmpty(ab.this.iMi.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ab.this.getView().getContext(), ab.this.iMi.metaData.getUserId(), ab.this.iMi.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.iMe = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.iMe.setPageId(this.mPageId);
        this.iMe.setIsRound(true);
        this.iMf = (TextView) view.findViewById(R.id.rec_user_name);
        this.iMg = (TextView) view.findViewById(R.id.rec_user_describe);
        this.iMh = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.ajZ = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.iMh);
        this.ajZ.Av("1");
        this.ajZ.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ct(View view) {
        return new ab(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof bb) {
            this.iMi = (bb) cVar;
            if (!StringUtils.isNull(this.iMi.metaData.getUserId())) {
                this.iMe.startLoad(this.iMi.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.au.cutStringWithEllipsis(this.iMi.metaData.getUserName(), 5);
                this.iMg.setText(com.baidu.tbadk.core.util.au.cutStringWithEllipsis(this.iMi.metaData.getGodUserData().getIntro(), 6));
                this.iMf.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.ajZ.a(this.iMi.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.iMf, (int) R.color.CAM_X0105);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.iMg, (int) R.color.CAM_X0109);
            this.iMh.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
