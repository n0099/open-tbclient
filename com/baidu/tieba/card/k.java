package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private TbPageContext cfl;
    public ClickableHeaderImageView eMr;
    public TextView eMs;
    public EntelechyUserLikeButton eMt;
    private com.baidu.tbadk.core.view.userLike.c eMu;
    private com.baidu.tieba.card.data.i eMv;
    public TextView ewr;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private BdUniqueId uniqueId;

    public k(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (k.this.eMv != null && k.this.eMv.ccm != null && !StringUtils.isNull(k.this.eMv.ccm.getName_show()) && !StringUtils.isNull(k.this.eMv.ccm.getUserId())) {
                    if (k.this.czV != null) {
                        k.this.czV.onClick(view2);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(k.this.cfl.getPageActivity(), k.this.eMv.ccm.getUserId(), k.this.eMv.ccm.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
                }
            }
        };
        this.cfl = tbPageContext;
        this.eMr = (ClickableHeaderImageView) view.findViewById(R.id.rec_god_item_header);
        this.eMr.setGodIconMargin(R.dimen.ds6);
        this.ewr = (TextView) view.findViewById(R.id.rec_god_item_user_name);
        this.eMs = (TextView) view.findViewById(R.id.rec_god_item_user_describe);
        this.eMt = (EntelechyUserLikeButton) view.findViewById(R.id.rec_god_item_user_like_btn);
        this.eMu = new com.baidu.tbadk.core.view.userLike.c(this.cfl, this.eMt);
        this.eMu.mX("0");
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public com.baidu.tieba.horizonalList.widget.e bB(View view) {
        k kVar = new k(view, this.cfl);
        kVar.eMu.j(this.uniqueId);
        return kVar;
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void a(com.baidu.tieba.horizonalList.widget.c cVar) {
        if (cVar instanceof com.baidu.tieba.card.data.i) {
            this.eMv = (com.baidu.tieba.card.data.i) cVar;
            if (this.eMv.ccm != null) {
                getView().setTag(R.id.rec_god_item_root, this.eMv.ccm.getUserId());
                this.eMr.setTag(R.id.rec_god_item_root, this.eMv.ccm.getUserId());
                this.eMt.setTag(this.eMv.ccm);
                this.eMr.setData(this.eMv.ccm);
                this.eMr.setAfterClickListener(this.czV);
                this.ewr.setText(aq.cutStringWithEllipsis(this.eMv.ccm.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.eMv.ccm.getGodUserData() != null) {
                    this.eMs.setText(aq.cutStringWithEllipsis(this.eMv.ccm.getGodUserData().getIntro(), 6));
                }
                this.eMu.a(this.eMv.ccm);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.e
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.ewr, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eMs, (int) R.color.cp_cont_d);
            if (this.eMt != null) {
                this.eMt.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
