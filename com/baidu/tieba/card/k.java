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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class k extends com.baidu.tieba.horizonalList.widget.e {
    public TextView dAX;
    public ClickableHeaderImageView ehu;
    public TextView ehv;
    public EntelechyUserLikeButton ehw;
    private com.baidu.tbadk.core.view.userLike.c ehx;
    private com.baidu.tieba.card.data.i ehy;
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
                if (k.this.ehy != null && k.this.ehy.bBG != null && !StringUtils.isNull(k.this.ehy.bBG.getName_show()) && !StringUtils.isNull(k.this.ehy.bBG.getUserId())) {
                    if (k.this.ccA != null) {
                        k.this.ccA.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(k.this.mContext.getPageActivity(), k.this.ehy.bBG.getUserId(), k.this.ehy.bBG.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.ehu = (ClickableHeaderImageView) view.findViewById(d.g.rec_god_item_header);
        this.ehu.setGodIconMargin(d.e.ds6);
        this.dAX = (TextView) view.findViewById(d.g.rec_god_item_user_name);
        this.ehv = (TextView) view.findViewById(d.g.rec_god_item_user_describe);
        this.ehw = (EntelechyUserLikeButton) view.findViewById(d.g.rec_god_item_user_like_btn);
        this.ehx = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.ehw);
        this.ehx.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bv(View view) {
        k kVar = new k(view, this.mContext);
        kVar.ehx.i(this.uniqueId);
        return kVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.ehy = (com.baidu.tieba.card.data.i) cVar;
            if (this.ehy.bBG != null) {
                getView().setTag(d.g.rec_god_item_root, this.ehy.bBG.getUserId());
                this.ehu.setTag(d.g.rec_god_item_root, this.ehy.bBG.getUserId());
                this.ehw.setTag(this.ehy.bBG);
                this.ehu.setData(this.ehy.bBG);
                this.ehu.setAfterClickListener(this.ccA);
                this.dAX.setText(ap.V(this.ehy.bBG.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.ehy.bBG.getGodUserData() != null) {
                    this.ehv.setText(ap.V(this.ehy.bBG.getGodUserData().getIntro(), 6));
                }
                this.ehx.a(this.ehy.bBG);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(this.dAX, d.C0277d.cp_cont_b);
            al.j(this.ehv, d.C0277d.cp_cont_d);
            if (this.ehw != null) {
                this.ehw.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
