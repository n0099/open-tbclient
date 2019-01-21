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
    public ClickableHeaderImageView cXM;
    public TextView cXN;
    public EntelechyUserLikeButton cXO;
    private com.baidu.tbadk.core.view.userLike.c cXP;
    private com.baidu.tieba.card.data.i cXQ;
    public TextView cma;
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
                if (l.this.cXQ != null && l.this.cXQ.aun != null && !StringUtils.isNull(l.this.cXQ.aun.getName_show()) && !StringUtils.isNull(l.this.cXQ.aun.getUserId())) {
                    if (l.this.aTJ != null) {
                        l.this.aTJ.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(l.this.mContext.getPageActivity(), l.this.cXQ.aun.getUserId(), l.this.cXQ.aun.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.cXM = (ClickableHeaderImageView) view.findViewById(e.g.rec_god_item_header);
        this.cXM.setGodIconMargin(e.C0210e.ds6);
        this.cma = (TextView) view.findViewById(e.g.rec_god_item_user_name);
        this.cXN = (TextView) view.findViewById(e.g.rec_god_item_user_describe);
        this.cXO = (EntelechyUserLikeButton) view.findViewById(e.g.rec_god_item_user_like_btn);
        this.cXP = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.cXO);
        this.cXP.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e aB(View view) {
        l lVar = new l(view, this.mContext);
        lVar.cXP.h(this.uniqueId);
        return lVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.cXQ = (com.baidu.tieba.card.data.i) cVar;
            if (this.cXQ.aun != null) {
                getView().setTag(e.g.rec_god_item_root, this.cXQ.aun.getUserId());
                this.cXM.setTag(e.g.rec_god_item_root, this.cXQ.aun.getUserId());
                this.cXO.setTag(this.cXQ.aun);
                this.cXM.setData(this.cXQ.aun);
                this.cXM.setAfterClickListener(this.aTJ);
                this.cma.setText(ao.A(this.cXQ.aun.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.cXQ.aun.getGodUserData() != null) {
                    this.cXN.setText(ao.A(this.cXQ.aun.getGodUserData().getIntro(), 6));
                }
                this.cXP.a(this.cXQ.aun);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.cma, e.d.cp_cont_b);
            al.h(this.cXN, e.d.cp_cont_d);
            if (this.cXO != null) {
                this.cXO.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
