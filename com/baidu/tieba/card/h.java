package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class h extends a<com.baidu.tieba.card.a.g> {
    private com.baidu.tieba.tbadkCore.x MB;
    private String aDT;
    private String aDU;
    private TextView aNC;
    private TextView aNG;
    private com.baidu.tieba.card.a.g aNH;
    private BarImageView aNy;
    private TextView aNz;
    private CustomMessageListener mLikeForumListener;
    private View mRootView;
    private CustomMessageListener mUnlikeForumListener;

    public void an(String str, String str2) {
        this.aDT = str;
        this.aDU = str2;
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        super.setTag(bdUniqueId);
        if (getTag() != null) {
            if (this.mLikeForumListener != null) {
                this.mLikeForumListener.setTag(getTag());
            }
            if (this.mUnlikeForumListener != null) {
                this.mUnlikeForumListener.setTag(getTag());
            }
        }
    }

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLikeForumListener = new i(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.mUnlikeForumListener = new j(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        z(getView());
    }

    private void z(View view) {
        this.mRootView = view.findViewById(n.g.forum_root);
        this.aNz = (TextView) view.findViewById(n.g.forum_name);
        this.aNC = (TextView) view.findViewById(n.g.forum_intro);
        this.aNy = (BarImageView) view.findViewById(n.g.forum_avatar);
        this.aNG = (TextView) view.findViewById(n.g.forum_follow);
        this.mRootView.setOnClickListener(this);
        this.aNG.setOnClickListener(this);
        Ie().registerListener(this.mLikeForumListener);
        Ie().registerListener(this.mUnlikeForumListener);
        if (getTag() != null) {
            this.mLikeForumListener.setTag(getTag());
            this.mUnlikeForumListener.setTag(getTag());
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x002b: IGET  (r3v7 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.card.a.g : 0x0029: IGET  (r3v6 com.baidu.tieba.card.a.g A[REMOVE]) = (r6v0 'this' com.baidu.tieba.card.h A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.card.h.aNH com.baidu.tieba.card.a.g)
     com.baidu.tieba.card.a.g.mId long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00a0: IGET  (r3v3 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.card.a.g : 0x009e: IGET  (r3v2 com.baidu.tieba.card.a.g A[REMOVE]) = (r6v0 'this' com.baidu.tieba.card.h A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.card.h.aNH com.baidu.tieba.card.a.g)
     com.baidu.tieba.card.a.g.mId long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00d7: IGET  (r3v1 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.card.a.g : 0x00d5: IGET  (r3v0 com.baidu.tieba.card.a.g A[REMOVE]) = (r6v0 'this' com.baidu.tieba.card.h A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.card.h.aNH com.baidu.tieba.card.a.g)
     com.baidu.tieba.card.a.g.mId long)] */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            if (this.aNH != null && !TextUtils.isEmpty(this.aNH.mName)) {
                if (!TextUtils.isEmpty(this.aDU)) {
                    TiebaStatic.log(new av(this.aDU).aa(ImageViewerConfig.FORUM_ID, new StringBuilder().append(this.aNH.mId).toString()));
                }
                Ie().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(Ie().getPageActivity()).createNormalCfg(this.aNH.mName, getFrom())));
            }
        } else if (view == this.aNG && bj.ah(getContext()) && this.aNH != null && !TextUtils.isEmpty(this.aNH.mName)) {
            if (!TextUtils.isEmpty(this.aDT)) {
                TiebaStatic.log(new av(this.aDT).r("obj_type", 1).aa(ImageViewerConfig.FORUM_ID, new StringBuilder().append(this.aNH.mId).toString()));
            }
            if (this.MB == null) {
                this.MB = new com.baidu.tieba.tbadkCore.x(Ie());
            }
            this.MB.setLoadDataCallBack(new k(this));
            this.MB.bc(this.aNH.mName, new StringBuilder().append(this.aNH.mId).toString());
        }
    }

    @Override // com.baidu.tieba.card.a
    public int Ig() {
        return n.h.card_fourm_simple_item;
    }

    public void a(com.baidu.tieba.card.a.g gVar) {
        if (gVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.aNH = gVar;
        this.mRootView.setVisibility(0);
        this.aNz.setText(gVar.mName);
        this.aNC.setText(gVar.aPV);
        if (!StringUtils.isNULL(gVar.aPR)) {
            this.aNy.d(gVar.aPR, 10, false);
        }
        fa(gVar.aPS);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.mRootView);
            Ii();
            as.i(this.mRootView, n.f.addresslist_item_bg);
            this.aNy.invalidate();
        }
        this.mSkinType = i;
    }

    private void Ii() {
        if (this.aNH != null) {
            fa(this.aNH.aPS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, boolean z) {
        if (this.aNH != null) {
            int i = z ? 1 : 0;
            if (j == this.aNH.mId) {
                this.aNH.aPS = i;
                fa(i);
            }
        }
    }

    private void fa(int i) {
        if (i == 1) {
            this.aNG.setEnabled(false);
            as.b(this.aNG, n.d.cp_cont_d, 1);
            this.aNG.setText(TbadkCoreApplication.m411getInst().getString(n.j.relate_forum_is_followed));
            this.aNG.setBackgroundDrawable(null);
            return;
        }
        as.b(this.aNG, n.d.cp_cont_i, 1);
        this.aNG.setText(TbadkCoreApplication.m411getInst().getString(n.j.forum_list_attention_tv));
        as.i((View) this.aNG, n.f.btn_appdownload);
        this.aNG.setEnabled(true);
    }
}
