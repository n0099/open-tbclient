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
public class ab extends com.baidu.tieba.horizonalList.widget.e {
    private com.baidu.tbadk.core.view.userLike.c aje;
    public HeadImageView hWX;
    public TextView hWY;
    public TextView hWZ;
    public EntelechyUserLikeButton hXa;
    private bb hXb;
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
                if (ab.this.hXb != null && !com.baidu.tbadk.core.util.at.isEmpty(ab.this.hXb.metaData.getUserName()) && !com.baidu.tbadk.core.util.at.isEmpty(ab.this.hXb.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ab.this.getView().getContext(), ab.this.hXb.metaData.getUserId(), ab.this.hXb.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.hWX = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.hWX.setPageId(this.mPageId);
        this.hWX.setIsRound(true);
        this.hWY = (TextView) view.findViewById(R.id.rec_user_name);
        this.hWZ = (TextView) view.findViewById(R.id.rec_user_describe);
        this.hXa = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.aje = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.hXa);
        this.aje.zm("1");
        this.aje.m(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bT(View view) {
        return new ab(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof bb) {
            this.hXb = (bb) cVar;
            if (!StringUtils.isNull(this.hXb.metaData.getUserId())) {
                this.hWX.startLoad(this.hXb.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.at.cutStringWithEllipsis(this.hXb.metaData.getUserName(), 5);
                this.hWZ.setText(com.baidu.tbadk.core.util.at.cutStringWithEllipsis(this.hXb.metaData.getGodUserData().getIntro(), 6));
                this.hWY.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.aje.a(this.hXb.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.hWY, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.hWZ, (int) R.color.cp_cont_d);
            this.hXa.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
