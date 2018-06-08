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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class l extends com.baidu.tieba.horizonalList.widget.e {
    public TextView bPN;
    public ClickableHeaderImageView cxH;
    public TextView cxI;
    public EntelechyUserLikeButton cxJ;
    private com.baidu.tbadk.core.view.userLike.c cxK;
    private com.baidu.tieba.card.data.i cxL;
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
                if (l.this.cxL != null && l.this.cxL.aik != null && !StringUtils.isNull(l.this.cxL.aik.getName_show()) && !StringUtils.isNull(l.this.cxL.aik.getUserId())) {
                    if (l.this.aGc != null) {
                        l.this.aGc.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(l.this.mContext.getPageActivity(), l.this.cxL.aik.getUserId(), l.this.cxL.aik.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.cxH = (ClickableHeaderImageView) view.findViewById(d.g.rec_god_item_header);
        this.cxH.setGodIconMargin(d.e.ds6);
        this.bPN = (TextView) view.findViewById(d.g.rec_god_item_user_name);
        this.cxI = (TextView) view.findViewById(d.g.rec_god_item_user_describe);
        this.cxJ = (EntelechyUserLikeButton) view.findViewById(d.g.rec_god_item_user_like_btn);
        this.cxK = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.cxJ);
        this.cxK.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ad(View view) {
        l lVar = new l(view, this.mContext);
        lVar.cxK.h(this.uniqueId);
        return lVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.cxL = (com.baidu.tieba.card.data.i) cVar;
            if (this.cxL.aik != null) {
                getView().setTag(d.g.rec_god_item_root, this.cxL.aik.getUserId());
                this.cxH.setTag(d.g.rec_god_item_root, this.cxL.aik.getUserId());
                this.cxJ.setTag(this.cxL.aik);
                this.cxH.setData(this.cxL.aik);
                this.cxH.setAfterClickListener(this.aGc);
                this.bPN.setText(ao.t(this.cxL.aik.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.cxL.aik.getGodUserData() != null) {
                    this.cxI.setText(ao.t(this.cxL.aik.getGodUserData().getIntro(), 6));
                }
                this.cxK.a(this.cxL.aik);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.bPN, d.C0141d.cp_cont_b);
            al.h(this.cxI, d.C0141d.cp_cont_d);
            if (this.cxJ != null) {
                this.cxJ.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
