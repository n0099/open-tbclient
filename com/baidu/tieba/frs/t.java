package com.baidu.tieba.frs;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class t extends com.baidu.tieba.horizonalList.widget.e {
    private com.baidu.tbadk.core.view.userLike.c cvR;
    public HeadImageView dms;
    public TextView dmt;
    public TextView dmu;
    public EntelechyUserLikeButton dmv;
    private ap dmw;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private BdUniqueId mPageId;
    private int mSkinType;

    public t(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.t.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (t.this.dmw != null && !com.baidu.tbadk.core.util.ap.isEmpty(t.this.dmw.metaData.getUserName()) && !com.baidu.tbadk.core.util.ap.isEmpty(t.this.dmw.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(t.this.getView().getContext(), t.this.dmw.metaData.getUserId(), t.this.dmw.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.dms = (HeadImageView) view.findViewById(d.g.rec_usr_header);
        this.dms.setPageId(this.mPageId);
        this.dms.setIsRound(true);
        this.dmt = (TextView) view.findViewById(d.g.rec_user_name);
        this.dmu = (TextView) view.findViewById(d.g.rec_user_describe);
        this.dmv = (EntelechyUserLikeButton) view.findViewById(d.g.rec_user_like);
        this.cvR = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dmv);
        this.cvR.setFromType("1");
        this.cvR.h(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e af(View view) {
        return new t(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof ap) {
            this.dmw = (ap) cVar;
            if (!StringUtils.isNull(this.dmw.metaData.getUserId())) {
                this.dms.startLoad(this.dmw.metaData.getPortrait(), 28, false);
                String t = com.baidu.tbadk.core.util.ap.t(this.dmw.metaData.getUserName(), 5);
                this.dmu.setText(com.baidu.tbadk.core.util.ap.t(this.dmw.metaData.getGodUserData().getIntro(), 6));
                this.dmt.setText(t);
                getView().setOnClickListener(this.mOnClickListener);
                this.cvR.a(this.dmw.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.h(this.dmt, d.C0142d.cp_cont_b);
            com.baidu.tbadk.core.util.am.h(this.dmu, d.C0142d.cp_cont_d);
            this.dmv.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
