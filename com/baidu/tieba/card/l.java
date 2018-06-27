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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class l extends com.baidu.tieba.horizonalList.widget.e {
    public TextView bRW;
    public ClickableHeaderImageView cvO;
    public TextView cvP;
    public EntelechyUserLikeButton cvQ;
    private com.baidu.tbadk.core.view.userLike.c cvR;
    private com.baidu.tieba.card.data.i cvS;
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
                if (l.this.cvS != null && l.this.cvS.aiE != null && !StringUtils.isNull(l.this.cvS.aiE.getName_show()) && !StringUtils.isNull(l.this.cvS.aiE.getUserId())) {
                    if (l.this.aGU != null) {
                        l.this.aGU.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(l.this.mContext.getPageActivity(), l.this.cvS.aiE.getUserId(), l.this.cvS.aiE.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.cvO = (ClickableHeaderImageView) view.findViewById(d.g.rec_god_item_header);
        this.cvO.setGodIconMargin(d.e.ds6);
        this.bRW = (TextView) view.findViewById(d.g.rec_god_item_user_name);
        this.cvP = (TextView) view.findViewById(d.g.rec_god_item_user_describe);
        this.cvQ = (EntelechyUserLikeButton) view.findViewById(d.g.rec_god_item_user_like_btn);
        this.cvR = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.cvQ);
        this.cvR.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e af(View view) {
        l lVar = new l(view, this.mContext);
        lVar.cvR.h(this.uniqueId);
        return lVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.cvS = (com.baidu.tieba.card.data.i) cVar;
            if (this.cvS.aiE != null) {
                getView().setTag(d.g.rec_god_item_root, this.cvS.aiE.getUserId());
                this.cvO.setTag(d.g.rec_god_item_root, this.cvS.aiE.getUserId());
                this.cvQ.setTag(this.cvS.aiE);
                this.cvO.setData(this.cvS.aiE);
                this.cvO.setAfterClickListener(this.aGU);
                this.bRW.setText(ap.t(this.cvS.aiE.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.cvS.aiE.getGodUserData() != null) {
                    this.cvP.setText(ap.t(this.cvS.aiE.getGodUserData().getIntro(), 6));
                }
                this.cvR.a(this.cvS.aiE);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.h(this.bRW, d.C0142d.cp_cont_b);
            am.h(this.cvP, d.C0142d.cp_cont_d);
            if (this.cvQ != null) {
                this.cvQ.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
