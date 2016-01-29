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
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class k extends a<com.baidu.tieba.card.a.h> {
    private com.baidu.tieba.tbadkCore.w MS;
    private String aEJ;
    private String aEK;
    private BarImageView aOZ;
    private TextView aPa;
    private TextView aPd;
    private TextView aPh;
    private com.baidu.tieba.card.a.h aPi;
    private CustomMessageListener mLikeForumListener;
    private View mRootView;
    private CustomMessageListener mUnlikeForumListener;

    public void an(String str, String str2) {
        this.aEJ = str;
        this.aEK = str2;
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
        L(getView());
    }

    private void L(View view) {
        this.mRootView = view.findViewById(t.g.forum_root);
        this.aPa = (TextView) view.findViewById(t.g.forum_name);
        this.aPd = (TextView) view.findViewById(t.g.forum_intro);
        this.aOZ = (BarImageView) view.findViewById(t.g.forum_avatar);
        this.aPh = (TextView) view.findViewById(t.g.forum_follow);
        this.mRootView.setOnClickListener(this);
        this.aPh.setOnClickListener(this);
        JK().registerListener(this.mLikeForumListener);
        JK().registerListener(this.mUnlikeForumListener);
        if (getTag() != null) {
            this.mLikeForumListener.setTag(getTag());
            this.mUnlikeForumListener.setTag(getTag());
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x002b: IGET  (r3v7 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.card.a.h : 0x0029: IGET  (r3v6 com.baidu.tieba.card.a.h A[REMOVE]) = (r6v0 'this' com.baidu.tieba.card.k A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.card.k.aPi com.baidu.tieba.card.a.h)
     com.baidu.tieba.card.a.h.mId long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00a0: IGET  (r3v3 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.card.a.h : 0x009e: IGET  (r3v2 com.baidu.tieba.card.a.h A[REMOVE]) = (r6v0 'this' com.baidu.tieba.card.k A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.card.k.aPi com.baidu.tieba.card.a.h)
     com.baidu.tieba.card.a.h.mId long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00d7: IGET  (r3v1 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.card.a.h : 0x00d5: IGET  (r3v0 com.baidu.tieba.card.a.h A[REMOVE]) = (r6v0 'this' com.baidu.tieba.card.k A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.card.k.aPi com.baidu.tieba.card.a.h)
     com.baidu.tieba.card.a.h.mId long)] */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            if (this.aPi != null && !TextUtils.isEmpty(this.aPi.mName)) {
                if (!TextUtils.isEmpty(this.aEK)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.au(this.aEK).aa(ImageViewerConfig.FORUM_ID, new StringBuilder().append(this.aPi.mId).toString()));
                }
                JK().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(JK().getPageActivity()).createNormalCfg(this.aPi.mName, getFrom())));
            }
        } else if (view == this.aPh && bi.ah(getContext()) && this.aPi != null && !TextUtils.isEmpty(this.aPi.mName)) {
            if (!TextUtils.isEmpty(this.aEJ)) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au(this.aEJ).r("obj_type", 1).aa(ImageViewerConfig.FORUM_ID, new StringBuilder().append(this.aPi.mId).toString()));
            }
            if (this.MS == null) {
                this.MS = new com.baidu.tieba.tbadkCore.w(JK());
            }
            this.MS.setLoadDataCallBack(new n(this));
            this.MS.bl(this.aPi.mName, new StringBuilder().append(this.aPi.mId).toString());
        }
    }

    @Override // com.baidu.tieba.card.a
    public int JM() {
        return t.h.card_fourm_simple_item;
    }

    public void a(com.baidu.tieba.card.a.h hVar) {
        if (hVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.aPi = hVar;
        this.mRootView.setVisibility(0);
        this.aPa.setText(hVar.mName);
        this.aPd.setText(hVar.aRY);
        if (!StringUtils.isNULL(hVar.aRU)) {
            this.aOZ.d(hVar.aRU, 10, false);
        }
        fx(hVar.aRV);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.mRootView);
            JO();
            com.baidu.tbadk.core.util.ar.k(this.mRootView, t.f.addresslist_item_bg);
            this.aOZ.invalidate();
        }
        this.mSkinType = i;
    }

    private void JO() {
        if (this.aPi != null) {
            fx(this.aPi.aRV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, boolean z) {
        if (this.aPi != null) {
            int i = z ? 1 : 0;
            if (j == this.aPi.mId) {
                this.aPi.aRV = i;
                fx(i);
            }
        }
    }

    private void fx(int i) {
        if (i == 1) {
            this.aPh.setEnabled(false);
            com.baidu.tbadk.core.util.ar.b(this.aPh, t.d.cp_cont_d, 1);
            this.aPh.setText(TbadkCoreApplication.m411getInst().getString(t.j.relate_forum_is_followed));
            this.aPh.setBackgroundDrawable(null);
            return;
        }
        com.baidu.tbadk.core.util.ar.b(this.aPh, t.d.cp_cont_i, 1);
        this.aPh.setText(TbadkCoreApplication.m411getInst().getString(t.j.forum_list_attention_tv));
        com.baidu.tbadk.core.util.ar.k(this.aPh, t.f.btn_appdownload);
        this.aPh.setEnabled(true);
    }
}
