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
    public TextView epd;
    public ClickableHeaderImageView ewU;
    public TextView ewV;
    public EntelechyUserLikeButton ewW;
    private com.baidu.tbadk.core.view.userLike.c ewX;
    private com.baidu.tieba.card.data.i ewY;
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
                if (k.this.ewY != null && k.this.ewY.bJa != null && !StringUtils.isNull(k.this.ewY.bJa.getName_show()) && !StringUtils.isNull(k.this.ewY.bJa.getUserId())) {
                    if (k.this.ckH != null) {
                        k.this.ckH.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(k.this.mContext.getPageActivity(), k.this.ewY.bJa.getUserId(), k.this.ewY.bJa.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.ewU = (ClickableHeaderImageView) view.findViewById(R.id.rec_god_item_header);
        this.ewU.setGodIconMargin(R.dimen.ds6);
        this.epd = (TextView) view.findViewById(R.id.rec_god_item_user_name);
        this.ewV = (TextView) view.findViewById(R.id.rec_god_item_user_describe);
        this.ewW = (EntelechyUserLikeButton) view.findViewById(R.id.rec_god_item_user_like_btn);
        this.ewX = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.ewW);
        this.ewX.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bC(View view) {
        k kVar = new k(view, this.mContext);
        kVar.ewX.i(this.uniqueId);
        return kVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.ewY = (com.baidu.tieba.card.data.i) cVar;
            if (this.ewY.bJa != null) {
                getView().setTag(R.id.rec_god_item_root, this.ewY.bJa.getUserId());
                this.ewU.setTag(R.id.rec_god_item_root, this.ewY.bJa.getUserId());
                this.ewW.setTag(this.ewY.bJa);
                this.ewU.setData(this.ewY.bJa);
                this.ewU.setAfterClickListener(this.ckH);
                this.epd.setText(ap.R(this.ewY.bJa.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.ewY.bJa.getGodUserData() != null) {
                    this.ewV.setText(ap.R(this.ewY.bJa.getGodUserData().getIntro(), 6));
                }
                this.ewX.a(this.ewY.bJa);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(this.epd, R.color.cp_cont_b);
            al.j(this.ewV, R.color.cp_cont_d);
            if (this.ewW != null) {
                this.ewW.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
