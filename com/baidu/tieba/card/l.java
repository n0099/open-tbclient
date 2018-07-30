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
    public TextView bSR;
    public ClickableHeaderImageView cyq;
    public TextView cyr;
    public EntelechyUserLikeButton cys;
    private com.baidu.tbadk.core.view.userLike.c cyt;
    private com.baidu.tieba.card.data.i cyu;
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
                if (l.this.cyu != null && l.this.cyu.aib != null && !StringUtils.isNull(l.this.cyu.aib.getName_show()) && !StringUtils.isNull(l.this.cyu.aib.getUserId())) {
                    if (l.this.aGU != null) {
                        l.this.aGU.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(l.this.mContext.getPageActivity(), l.this.cyu.aib.getUserId(), l.this.cyu.aib.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.mContext = tbPageContext;
        this.cyq = (ClickableHeaderImageView) view.findViewById(d.g.rec_god_item_header);
        this.cyq.setGodIconMargin(d.e.ds6);
        this.bSR = (TextView) view.findViewById(d.g.rec_god_item_user_name);
        this.cyr = (TextView) view.findViewById(d.g.rec_god_item_user_describe);
        this.cys = (EntelechyUserLikeButton) view.findViewById(d.g.rec_god_item_user_like_btn);
        this.cyt = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.cys);
        this.cyt.setFromType("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e ai(View view) {
        l lVar = new l(view, this.mContext);
        lVar.cyt.h(this.uniqueId);
        return lVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.cyu = (com.baidu.tieba.card.data.i) cVar;
            if (this.cyu.aib != null) {
                getView().setTag(d.g.rec_god_item_root, this.cyu.aib.getUserId());
                this.cyq.setTag(d.g.rec_god_item_root, this.cyu.aib.getUserId());
                this.cys.setTag(this.cyu.aib);
                this.cyq.setData(this.cyu.aib);
                this.cyq.setAfterClickListener(this.aGU);
                this.bSR.setText(ap.t(this.cyu.aib.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.cyu.aib.getGodUserData() != null) {
                    this.cyr.setText(ap.t(this.cyu.aib.getGodUserData().getIntro(), 6));
                }
                this.cyt.a(this.cyu.aib);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.h(this.bSR, d.C0140d.cp_cont_b);
            am.h(this.cyr, d.C0140d.cp_cont_d);
            if (this.cys != null) {
                this.cys.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
