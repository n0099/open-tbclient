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
    private com.baidu.tbadk.core.view.userLike.c cyt;
    public HeadImageView dpk;
    public TextView dpl;
    public TextView dpm;
    public EntelechyUserLikeButton dpn;
    private ap dpo;
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
                if (t.this.dpo != null && !com.baidu.tbadk.core.util.ap.isEmpty(t.this.dpo.metaData.getUserName()) && !com.baidu.tbadk.core.util.ap.isEmpty(t.this.dpo.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(t.this.getView().getContext(), t.this.dpo.metaData.getUserId(), t.this.dpo.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.dpk = (HeadImageView) view.findViewById(d.g.rec_usr_header);
        this.dpk.setPageId(this.mPageId);
        this.dpk.setIsRound(true);
        this.dpl = (TextView) view.findViewById(d.g.rec_user_name);
        this.dpm = (TextView) view.findViewById(d.g.rec_user_describe);
        this.dpn = (EntelechyUserLikeButton) view.findViewById(d.g.rec_user_like);
        this.cyt = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dpn);
        this.cyt.setFromType("1");
        this.cyt.h(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ai(View view) {
        return new t(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof ap) {
            this.dpo = (ap) cVar;
            if (!StringUtils.isNull(this.dpo.metaData.getUserId())) {
                this.dpk.startLoad(this.dpo.metaData.getPortrait(), 28, false);
                String t = com.baidu.tbadk.core.util.ap.t(this.dpo.metaData.getUserName(), 5);
                this.dpm.setText(com.baidu.tbadk.core.util.ap.t(this.dpo.metaData.getGodUserData().getIntro(), 6));
                this.dpl.setText(t);
                getView().setOnClickListener(this.mOnClickListener);
                this.cyt.a(this.dpo.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.h(this.dpl, d.C0140d.cp_cont_b);
            com.baidu.tbadk.core.util.am.h(this.dpm, d.C0140d.cp_cont_d);
            this.dpn.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
