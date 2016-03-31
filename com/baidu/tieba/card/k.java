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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class k extends a<com.baidu.tieba.card.a.h> {
    private com.baidu.tieba.tbadkCore.w MY;
    private String aGe;
    private String aGf;
    private BarImageView aRP;
    private TextView aRQ;
    private TextView aRT;
    private TextView aRX;
    private com.baidu.tieba.card.a.h aRY;
    private CustomMessageListener mLikeForumListener;
    private View mRootView;
    private CustomMessageListener mUnlikeForumListener;

    public void at(String str, String str2) {
        this.aGe = str;
        this.aGf = str2;
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

    public k(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLikeForumListener = new l(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.mUnlikeForumListener = new m(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        P(getView());
    }

    private void P(View view) {
        this.mRootView = view.findViewById(t.g.forum_root);
        this.aRQ = (TextView) view.findViewById(t.g.forum_name);
        this.aRT = (TextView) view.findViewById(t.g.forum_intro);
        this.aRP = (BarImageView) view.findViewById(t.g.forum_avatar);
        this.aRX = (TextView) view.findViewById(t.g.forum_follow);
        this.mRootView.setOnClickListener(this);
        this.aRX.setOnClickListener(this);
        Lb().registerListener(this.mLikeForumListener);
        Lb().registerListener(this.mUnlikeForumListener);
        if (getTag() != null) {
            this.mLikeForumListener.setTag(getTag());
            this.mUnlikeForumListener.setTag(getTag());
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x002b: IGET  (r3v7 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.card.a.h : 0x0029: IGET  (r3v6 com.baidu.tieba.card.a.h A[REMOVE]) = (r6v0 'this' com.baidu.tieba.card.k A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.card.k.aRY com.baidu.tieba.card.a.h)
     com.baidu.tieba.card.a.h.mId long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00a0: IGET  (r3v3 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.card.a.h : 0x009e: IGET  (r3v2 com.baidu.tieba.card.a.h A[REMOVE]) = (r6v0 'this' com.baidu.tieba.card.k A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.card.k.aRY com.baidu.tieba.card.a.h)
     com.baidu.tieba.card.a.h.mId long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00d7: IGET  (r3v1 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.card.a.h : 0x00d5: IGET  (r3v0 com.baidu.tieba.card.a.h A[REMOVE]) = (r6v0 'this' com.baidu.tieba.card.k A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.card.k.aRY com.baidu.tieba.card.a.h)
     com.baidu.tieba.card.a.h.mId long)] */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            if (this.aRY != null && !TextUtils.isEmpty(this.aRY.mName)) {
                if (!TextUtils.isEmpty(this.aGf)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw(this.aGf).ac("fid", new StringBuilder().append(this.aRY.mId).toString()));
                }
                Lb().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(Lb().getPageActivity()).createNormalCfg(this.aRY.mName, getFrom())));
            }
        } else if (view == this.aRX && com.baidu.tbadk.core.util.bl.ad(getContext()) && this.aRY != null && !TextUtils.isEmpty(this.aRY.mName)) {
            if (!TextUtils.isEmpty(this.aGe)) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw(this.aGe).r("obj_type", 1).ac("fid", new StringBuilder().append(this.aRY.mId).toString()));
            }
            if (this.MY == null) {
                this.MY = new com.baidu.tieba.tbadkCore.w(Lb());
            }
            this.MY.setLoadDataCallBack(new n(this));
            this.MY.bC(this.aRY.mName, new StringBuilder().append(this.aRY.mId).toString());
        }
    }

    @Override // com.baidu.tieba.card.a
    public int Le() {
        return t.h.card_fourm_simple_item;
    }

    public void a(com.baidu.tieba.card.a.h hVar) {
        if (hVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.aRY = hVar;
        this.mRootView.setVisibility(0);
        this.aRQ.setText(hVar.mName);
        this.aRT.setText(hVar.aVF);
        if (!StringUtils.isNULL(hVar.aVB)) {
            this.aRP.c(hVar.aVB, 10, false);
        }
        fK(hVar.aVC);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.mRootView);
            Lg();
            com.baidu.tbadk.core.util.at.k(this.mRootView, t.f.addresslist_item_bg);
            this.aRP.invalidate();
        }
        this.mSkinType = i;
    }

    private void Lg() {
        if (this.aRY != null) {
            fK(this.aRY.aVC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, boolean z) {
        if (this.aRY != null) {
            int i = z ? 1 : 0;
            if (j == this.aRY.mId) {
                this.aRY.aVC = i;
                fK(i);
            }
        }
    }

    private void fK(int i) {
        if (i == 1) {
            this.aRX.setEnabled(false);
            com.baidu.tbadk.core.util.at.b(this.aRX, t.d.cp_cont_d, 1);
            this.aRX.setText(TbadkCoreApplication.m411getInst().getString(t.j.relate_forum_is_followed));
            this.aRX.setBackgroundDrawable(null);
            return;
        }
        com.baidu.tbadk.core.util.at.b(this.aRX, t.d.cp_cont_i, 1);
        this.aRX.setText(TbadkCoreApplication.m411getInst().getString(t.j.forum_list_attention_tv));
        com.baidu.tbadk.core.util.at.k(this.aRX, t.f.btn_appdownload);
        this.aRX.setEnabled(true);
    }
}
