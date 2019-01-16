package com.baidu.tieba.card;

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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class l extends com.baidu.tieba.horizonalList.widget.e {
    public ClickableHeaderImageView cXL;
    public TextView cXM;
    public EntelechyUserLikeButton cXN;
    private com.baidu.tbadk.core.view.userLike.c cXO;
    private com.baidu.tieba.card.data.i cXP;
    public TextView clZ;
    private TbPageContext mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public l(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (l.this.cXP != null && l.this.cXP.aum != null && !StringUtils.isNull(l.this.cXP.aum.getName_show()) && !StringUtils.isNull(l.this.cXP.aum.getUserId())) {
                    if (l.this.aTI != null) {
                        l.this.aTI.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(l.this.mContext.getPageActivity(), l.this.cXP.aum.getUserId(), l.this.cXP.aum.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.cXL = (ClickableHeaderImageView) view.findViewById(e.g.rec_god_item_header);
        this.cXL.setGodIconMargin(e.C0210e.ds6);
        this.clZ = (TextView) view.findViewById(e.g.rec_god_item_user_name);
        this.cXM = (TextView) view.findViewById(e.g.rec_god_item_user_describe);
        this.cXN = (EntelechyUserLikeButton) view.findViewById(e.g.rec_god_item_user_like_btn);
        this.cXO = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.cXN);
        this.cXO.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e aB(View view) {
        l lVar = new l(view, this.mContext);
        lVar.cXO.h(this.uniqueId);
        return lVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.cXP = (com.baidu.tieba.card.data.i) cVar;
            if (this.cXP.aum != null) {
                getView().setTag(e.g.rec_god_item_root, this.cXP.aum.getUserId());
                this.cXL.setTag(e.g.rec_god_item_root, this.cXP.aum.getUserId());
                this.cXN.setTag(this.cXP.aum);
                this.cXL.setData(this.cXP.aum);
                this.cXL.setAfterClickListener(this.aTI);
                this.clZ.setText(ao.A(this.cXP.aum.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.cXP.aum.getGodUserData() != null) {
                    this.cXM.setText(ao.A(this.cXP.aum.getGodUserData().getIntro(), 6));
                }
                this.cXO.a(this.cXP.aum);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.clZ, e.d.cp_cont_b);
            al.h(this.cXM, e.d.cp_cont_d);
            if (this.cXN != null) {
                this.cXN.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
