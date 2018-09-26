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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class t extends com.baidu.tieba.horizonalList.widget.e {
    private com.baidu.tbadk.core.view.userLike.c cEg;
    public HeadImageView dvf;
    public TextView dvg;
    public TextView dvh;
    public EntelechyUserLikeButton dvi;
    private ap dvj;
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
                if (t.this.dvj != null && !com.baidu.tbadk.core.util.ao.isEmpty(t.this.dvj.metaData.getUserName()) && !com.baidu.tbadk.core.util.ao.isEmpty(t.this.dvj.metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(t.this.getView().getContext(), t.this.dvj.metaData.getUserId(), t.this.dvj.metaData.getUserName(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mPageId = bdUniqueId;
        this.mPageContext = tbPageContext;
        this.dvf = (HeadImageView) view.findViewById(e.g.rec_usr_header);
        this.dvf.setPageId(this.mPageId);
        this.dvf.setIsRound(true);
        this.dvg = (TextView) view.findViewById(e.g.rec_user_name);
        this.dvh = (TextView) view.findViewById(e.g.rec_user_describe);
        this.dvi = (EntelechyUserLikeButton) view.findViewById(e.g.rec_user_like);
        this.cEg = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dvi);
        this.cEg.setFromType("1");
        this.cEg.h(bdUniqueId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e aw(View view) {
        return new t(view, this.mPageContext, this.mPageId);
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof ap) {
            this.dvj = (ap) cVar;
            if (!StringUtils.isNull(this.dvj.metaData.getUserId())) {
                this.dvf.startLoad(this.dvj.metaData.getPortrait(), 28, false);
                String y = com.baidu.tbadk.core.util.ao.y(this.dvj.metaData.getUserName(), 5);
                this.dvh.setText(com.baidu.tbadk.core.util.ao.y(this.dvj.metaData.getGodUserData().getIntro(), 6));
                this.dvg.setText(y);
                getView().setOnClickListener(this.mOnClickListener);
                this.cEg.a(this.dvj.metaData);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.al.h(this.dvg, e.d.cp_cont_b);
            com.baidu.tbadk.core.util.al.h(this.dvh, e.d.cp_cont_d);
            this.dvi.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }
}
