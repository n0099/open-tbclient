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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class t extends com.baidu.tieba.horizonalList.widget.e {
    private com.baidu.tbadk.core.view.userLike.c cyq;
    public HeadImageView dpi;
    public TextView dpj;
    public TextView dpk;
    public EntelechyUserLikeButton dpl;
    private ap dpm;
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
                if (t.this.dpm != null && !com.baidu.tbadk.core.util.ap.isEmpty(t.this.dpm.metaData.getUserName()) && !com.baidu.tbadk.core.util.ap.isEmpty(t.this.dpm.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(t.this.getView().getContext(), t.this.dpm.metaData.getUserId(), t.this.dpm.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.dpi = (HeadImageView) view.findViewById(f.g.rec_usr_header);
        this.dpi.setPageId(this.mPageId);
        this.dpi.setIsRound(true);
        this.dpj = (TextView) view.findViewById(f.g.rec_user_name);
        this.dpk = (TextView) view.findViewById(f.g.rec_user_describe);
        this.dpl = (EntelechyUserLikeButton) view.findViewById(f.g.rec_user_like);
        this.cyq = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dpl);
        this.cyq.setFromType("1");
        this.cyq.h(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ai(View view) {
        return new t(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof ap) {
            this.dpm = (ap) cVar;
            if (!StringUtils.isNull(this.dpm.metaData.getUserId())) {
                this.dpi.startLoad(this.dpm.metaData.getPortrait(), 28, false);
                String t = com.baidu.tbadk.core.util.ap.t(this.dpm.metaData.getUserName(), 5);
                this.dpk.setText(com.baidu.tbadk.core.util.ap.t(this.dpm.metaData.getGodUserData().getIntro(), 6));
                this.dpj.setText(t);
                getView().setOnClickListener(this.mOnClickListener);
                this.cyq.a(this.dpm.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.am.h(this.dpj, f.d.cp_cont_b);
            com.baidu.tbadk.core.util.am.h(this.dpk, f.d.cp_cont_d);
            this.dpl.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
