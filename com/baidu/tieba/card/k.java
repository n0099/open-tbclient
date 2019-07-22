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
    public ClickableHeaderImageView eBU;
    public TextView eBV;
    public EntelechyUserLikeButton eBW;
    private com.baidu.tbadk.core.view.userLike.c eBX;
    private com.baidu.tieba.card.data.i eBY;
    public TextView euc;
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
                if (k.this.eBY != null && k.this.eBY.bKb != null && !StringUtils.isNull(k.this.eBY.bKb.getName_show()) && !StringUtils.isNull(k.this.eBY.bKb.getUserId())) {
                    if (k.this.clU != null) {
                        k.this.clU.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(k.this.mContext.getPageActivity(), k.this.eBY.bKb.getUserId(), k.this.eBY.bKb.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.eBU = (ClickableHeaderImageView) view.findViewById(R.id.rec_god_item_header);
        this.eBU.setGodIconMargin(R.dimen.ds6);
        this.euc = (TextView) view.findViewById(R.id.rec_god_item_user_name);
        this.eBV = (TextView) view.findViewById(R.id.rec_god_item_user_describe);
        this.eBW = (EntelechyUserLikeButton) view.findViewById(R.id.rec_god_item_user_like_btn);
        this.eBX = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.eBW);
        this.eBX.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bE(View view) {
        k kVar = new k(view, this.mContext);
        kVar.eBX.j(this.uniqueId);
        return kVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.eBY = (com.baidu.tieba.card.data.i) cVar;
            if (this.eBY.bKb != null) {
                getView().setTag(R.id.rec_god_item_root, this.eBY.bKb.getUserId());
                this.eBU.setTag(R.id.rec_god_item_root, this.eBY.bKb.getUserId());
                this.eBW.setTag(this.eBY.bKb);
                this.eBU.setData(this.eBY.bKb);
                this.eBU.setAfterClickListener(this.clU);
                this.euc.setText(aq.R(this.eBY.bKb.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.eBY.bKb.getGodUserData() != null) {
                    this.eBV.setText(aq.R(this.eBY.bKb.getGodUserData().getIntro(), 6));
                }
                this.eBX.a(this.eBY.bKb);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.j(this.euc, R.color.cp_cont_b);
            am.j(this.eBV, R.color.cp_cont_d);
            if (this.eBW != null) {
                this.eBW.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
