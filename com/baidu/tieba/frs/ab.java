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
    private com.baidu.tbadk.core.view.userLike.c ajD;
    public HeadImageView ieb;
    public TextView iec;
    public TextView ied;
    public EntelechyUserLikeButton iee;
    private bb ief;
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
                if (ab.this.ief != null && !com.baidu.tbadk.core.util.at.isEmpty(ab.this.ief.metaData.getUserName()) && !com.baidu.tbadk.core.util.at.isEmpty(ab.this.ief.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ab.this.getView().getContext(), ab.this.ief.metaData.getUserId(), ab.this.ief.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.ieb = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.ieb.setPageId(this.mPageId);
        this.ieb.setIsRound(true);
        this.iec = (TextView) view.findViewById(R.id.rec_user_name);
        this.ied = (TextView) view.findViewById(R.id.rec_user_describe);
        this.iee = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.ajD = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.iee);
        this.ajD.zH("1");
        this.ajD.l(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e cc(View view) {
        return new ab(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof bb) {
            this.ief = (bb) cVar;
            if (!StringUtils.isNull(this.ief.metaData.getUserId())) {
                this.ieb.startLoad(this.ief.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.at.cutStringWithEllipsis(this.ief.metaData.getUserName(), 5);
                this.ied.setText(com.baidu.tbadk.core.util.at.cutStringWithEllipsis(this.ief.metaData.getGodUserData().getIntro(), 6));
                this.iec.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.ajD.a(this.ief.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.iec, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.ied, (int) R.color.cp_cont_d);
            this.iee.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
