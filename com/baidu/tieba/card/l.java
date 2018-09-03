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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class l extends com.baidu.tieba.horizonalList.widget.e {
    public TextView bSQ;
    public ClickableHeaderImageView cyn;
    public TextView cyo;
    public EntelechyUserLikeButton cyp;
    private com.baidu.tbadk.core.view.userLike.c cyq;
    private com.baidu.tieba.card.data.i cyr;
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
                if (l.this.cyr != null && l.this.cyr.aib != null && !StringUtils.isNull(l.this.cyr.aib.getName_show()) && !StringUtils.isNull(l.this.cyr.aib.getUserId())) {
                    if (l.this.aGT != null) {
                        l.this.aGT.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(l.this.mContext.getPageActivity(), l.this.cyr.aib.getUserId(), l.this.cyr.aib.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.cyn = (ClickableHeaderImageView) view.findViewById(f.g.rec_god_item_header);
        this.cyn.setGodIconMargin(f.e.ds6);
        this.bSQ = (TextView) view.findViewById(f.g.rec_god_item_user_name);
        this.cyo = (TextView) view.findViewById(f.g.rec_god_item_user_describe);
        this.cyp = (EntelechyUserLikeButton) view.findViewById(f.g.rec_god_item_user_like_btn);
        this.cyq = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.cyp);
        this.cyq.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ai(View view) {
        l lVar = new l(view, this.mContext);
        lVar.cyq.h(this.uniqueId);
        return lVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.cyr = (com.baidu.tieba.card.data.i) cVar;
            if (this.cyr.aib != null) {
                getView().setTag(f.g.rec_god_item_root, this.cyr.aib.getUserId());
                this.cyn.setTag(f.g.rec_god_item_root, this.cyr.aib.getUserId());
                this.cyp.setTag(this.cyr.aib);
                this.cyn.setData(this.cyr.aib);
                this.cyn.setAfterClickListener(this.aGT);
                this.bSQ.setText(ap.t(this.cyr.aib.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.cyr.aib.getGodUserData() != null) {
                    this.cyo.setText(ap.t(this.cyr.aib.getGodUserData().getIntro(), 6));
                }
                this.cyq.a(this.cyr.aib);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.h(this.bSQ, f.d.cp_cont_b);
            am.h(this.cyo, f.d.cp_cont_d);
            if (this.cyp != null) {
                this.cyp.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
