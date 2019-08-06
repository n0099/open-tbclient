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
    public ClickableHeaderImageView eCb;
    public TextView eCc;
    public EntelechyUserLikeButton eCd;
    private com.baidu.tbadk.core.view.userLike.c eCe;
    private com.baidu.tieba.card.data.i eCf;
    public TextView euj;
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
                if (k.this.eCf != null && k.this.eCf.bKg != null && !StringUtils.isNull(k.this.eCf.bKg.getName_show()) && !StringUtils.isNull(k.this.eCf.bKg.getUserId())) {
                    if (k.this.cmb != null) {
                        k.this.cmb.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(k.this.mContext.getPageActivity(), k.this.eCf.bKg.getUserId(), k.this.eCf.bKg.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.eCb = (ClickableHeaderImageView) view.findViewById(R.id.rec_god_item_header);
        this.eCb.setGodIconMargin(R.dimen.ds6);
        this.euj = (TextView) view.findViewById(R.id.rec_god_item_user_name);
        this.eCc = (TextView) view.findViewById(R.id.rec_god_item_user_describe);
        this.eCd = (EntelechyUserLikeButton) view.findViewById(R.id.rec_god_item_user_like_btn);
        this.eCe = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.eCd);
        this.eCe.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bE(View view) {
        k kVar = new k(view, this.mContext);
        kVar.eCe.j(this.uniqueId);
        return kVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.eCf = (com.baidu.tieba.card.data.i) cVar;
            if (this.eCf.bKg != null) {
                getView().setTag(R.id.rec_god_item_root, this.eCf.bKg.getUserId());
                this.eCb.setTag(R.id.rec_god_item_root, this.eCf.bKg.getUserId());
                this.eCd.setTag(this.eCf.bKg);
                this.eCb.setData(this.eCf.bKg);
                this.eCb.setAfterClickListener(this.cmb);
                this.euj.setText(aq.R(this.eCf.bKg.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.eCf.bKg.getGodUserData() != null) {
                    this.eCc.setText(aq.R(this.eCf.bKg.getGodUserData().getIntro(), 6));
                }
                this.eCe.a(this.eCf.bKg);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.j(this.euj, R.color.cp_cont_b);
            am.j(this.eCc, R.color.cp_cont_d);
            if (this.eCd != null) {
                this.eCd.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
