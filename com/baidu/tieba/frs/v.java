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
public class v extends com.baidu.tieba.horizonalList.widget.e {
    private com.baidu.tbadk.core.view.userLike.c NC;
    public HeadImageView gsv;
    public TextView gsw;
    public TextView gsx;
    public EntelechyUserLikeButton gsy;
    private ap gsz;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private int mSkinType;

    public v(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.v.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (v.this.gsz != null && !com.baidu.tbadk.core.util.aq.isEmpty(v.this.gsz.metaData.getUserName()) && !com.baidu.tbadk.core.util.aq.isEmpty(v.this.gsz.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(v.this.getView().getContext(), v.this.gsz.metaData.getUserId(), v.this.gsz.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.gsv = (HeadImageView) view.findViewById(R.id.rec_usr_header);
        this.gsv.setPageId(this.mPageId);
        this.gsv.setIsRound(true);
        this.gsw = (TextView) view.findViewById(R.id.rec_user_name);
        this.gsx = (TextView) view.findViewById(R.id.rec_user_describe);
        this.gsy = (EntelechyUserLikeButton) view.findViewById(R.id.rec_user_like);
        this.NC = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.gsy);
        this.NC.sE("1");
        this.NC.j(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bD(View view) {
        return new v(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof ap) {
            this.gsz = (ap) cVar;
            if (!StringUtils.isNull(this.gsz.metaData.getUserId())) {
                this.gsv.startLoad(this.gsz.metaData.getPortrait(), 28, false);
                String cutStringWithEllipsis = com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.gsz.metaData.getUserName(), 5);
                this.gsx.setText(com.baidu.tbadk.core.util.aq.cutStringWithEllipsis(this.gsz.metaData.getGodUserData().getIntro(), 6));
                this.gsw.setText(cutStringWithEllipsis);
                getView().setOnClickListener(this.mOnClickListener);
                this.NC.a(this.gsz.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gsw, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gsx, (int) R.color.cp_cont_d);
            this.gsy.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
