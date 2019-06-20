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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class k extends com.baidu.tieba.horizonalList.widget.e {
    public TextView epe;
    public ClickableHeaderImageView ewV;
    public TextView ewW;
    public EntelechyUserLikeButton ewX;
    private com.baidu.tbadk.core.view.userLike.c ewY;
    private com.baidu.tieba.card.data.i ewZ;
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
                if (k.this.ewZ != null && k.this.ewZ.bJb != null && !StringUtils.isNull(k.this.ewZ.bJb.getName_show()) && !StringUtils.isNull(k.this.ewZ.bJb.getUserId())) {
                    if (k.this.ckI != null) {
                        k.this.ckI.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(k.this.mContext.getPageActivity(), k.this.ewZ.bJb.getUserId(), k.this.ewZ.bJb.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.ewV = (ClickableHeaderImageView) view.findViewById(R.id.rec_god_item_header);
        this.ewV.setGodIconMargin(R.dimen.ds6);
        this.epe = (TextView) view.findViewById(R.id.rec_god_item_user_name);
        this.ewW = (TextView) view.findViewById(R.id.rec_god_item_user_describe);
        this.ewX = (EntelechyUserLikeButton) view.findViewById(R.id.rec_god_item_user_like_btn);
        this.ewY = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.ewX);
        this.ewY.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bC(View view) {
        k kVar = new k(view, this.mContext);
        kVar.ewY.i(this.uniqueId);
        return kVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.ewZ = (com.baidu.tieba.card.data.i) cVar;
            if (this.ewZ.bJb != null) {
                getView().setTag(R.id.rec_god_item_root, this.ewZ.bJb.getUserId());
                this.ewV.setTag(R.id.rec_god_item_root, this.ewZ.bJb.getUserId());
                this.ewX.setTag(this.ewZ.bJb);
                this.ewV.setData(this.ewZ.bJb);
                this.ewV.setAfterClickListener(this.ckI);
                this.epe.setText(ap.R(this.ewZ.bJb.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.ewZ.bJb.getGodUserData() != null) {
                    this.ewW.setText(ap.R(this.ewZ.bJb.getGodUserData().getIntro(), 6));
                }
                this.ewY.a(this.ewZ.bJb);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(this.epe, R.color.cp_cont_b);
            al.j(this.ewW, R.color.cp_cont_d);
            if (this.ewX != null) {
                this.ewX.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
