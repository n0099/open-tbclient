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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class k extends com.baidu.tieba.horizonalList.widget.e {
    public ClickableHeaderImageView eDK;
    public TextView eDL;
    public EntelechyUserLikeButton eDM;
    private com.baidu.tbadk.core.view.userLike.c eDN;
    private com.baidu.tieba.card.data.i eDO;
    public TextView evT;
    private TbPageContext mContext;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public k(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.eDO != null && k.this.eDO.bKE != null && !StringUtils.isNull(k.this.eDO.bKE.getName_show()) && !StringUtils.isNull(k.this.eDO.bKE.getUserId())) {
                    if (k.this.cmX != null) {
                        k.this.cmX.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(k.this.mContext.getPageActivity(), k.this.eDO.bKE.getUserId(), k.this.eDO.bKE.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.eDK = (ClickableHeaderImageView) view.findViewById(R.id.rec_god_item_header);
        this.eDK.setGodIconMargin(R.dimen.ds6);
        this.evT = (TextView) view.findViewById(R.id.rec_god_item_user_name);
        this.eDL = (TextView) view.findViewById(R.id.rec_god_item_user_describe);
        this.eDM = (EntelechyUserLikeButton) view.findViewById(R.id.rec_god_item_user_like_btn);
        this.eDN = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.eDM);
        this.eDN.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bE(View view) {
        k kVar = new k(view, this.mContext);
        kVar.eDN.j(this.uniqueId);
        return kVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.eDO = (com.baidu.tieba.card.data.i) cVar;
            if (this.eDO.bKE != null) {
                getView().setTag(R.id.rec_god_item_root, this.eDO.bKE.getUserId());
                this.eDK.setTag(R.id.rec_god_item_root, this.eDO.bKE.getUserId());
                this.eDM.setTag(this.eDO.bKE);
                this.eDK.setData(this.eDO.bKE);
                this.eDK.setAfterClickListener(this.cmX);
                this.evT.setText(aq.R(this.eDO.bKE.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.eDO.bKE.getGodUserData() != null) {
                    this.eDL.setText(aq.R(this.eDO.bKE.getGodUserData().getIntro(), 6));
                }
                this.eDN.a(this.eDO.bKE);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.j(this.evT, R.color.cp_cont_b);
            am.j(this.eDL, R.color.cp_cont_d);
            if (this.eDM != null) {
                this.eDM.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
