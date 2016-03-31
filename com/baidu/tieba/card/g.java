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
public class g extends a<com.baidu.tieba.card.a.g> {
    private com.baidu.tieba.tbadkCore.w MY;
    private String aGe;
    private String aGf;
    private BarImageView aRP;
    private TextView aRQ;
    private TextView aRR;
    private TextView aRS;
    private TextView aRT;
    private TextView aRU;
    private com.baidu.tieba.card.a.g aRV;
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

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLikeForumListener = new h(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.mUnlikeForumListener = new i(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        P(getView());
    }

    private void P(View view) {
        this.mRootView = view.findViewById(t.g.view_root);
        this.aRQ = (TextView) view.findViewById(t.g.forum_name);
        this.aRR = (TextView) view.findViewById(t.g.forum_follows_count);
        this.aRS = (TextView) view.findViewById(t.g.forum_thread_count);
        this.aRT = (TextView) view.findViewById(t.g.forum_intro);
        this.aRP = (BarImageView) view.findViewById(t.g.forum_avatar);
        this.aRU = (TextView) view.findViewById(t.g.tv_add_love);
        this.mRootView.setOnClickListener(this);
        this.aRU.setOnClickListener(this);
        Lb().registerListener(this.mLikeForumListener);
        Lb().registerListener(this.mUnlikeForumListener);
        if (getTag() != null) {
            this.mLikeForumListener.setTag(getTag());
            this.mUnlikeForumListener.setTag(getTag());
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x002b: IGET  (r3v7 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.card.a.g : 0x0029: IGET  (r3v6 com.baidu.tieba.card.a.g A[REMOVE]) = (r6v0 'this' com.baidu.tieba.card.g A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.card.g.aRV com.baidu.tieba.card.a.g)
     com.baidu.tieba.card.a.g.mForumId long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00a0: IGET  (r3v3 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.card.a.g : 0x009e: IGET  (r3v2 com.baidu.tieba.card.a.g A[REMOVE]) = (r6v0 'this' com.baidu.tieba.card.g A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.card.g.aRV com.baidu.tieba.card.a.g)
     com.baidu.tieba.card.a.g.mForumId long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00d7: IGET  (r3v1 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.card.a.g : 0x00d5: IGET  (r3v0 com.baidu.tieba.card.a.g A[REMOVE]) = (r6v0 'this' com.baidu.tieba.card.g A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.card.g.aRV com.baidu.tieba.card.a.g)
     com.baidu.tieba.card.a.g.mForumId long)] */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            if (this.aRV != null && !TextUtils.isEmpty(this.aRV.mForumName)) {
                if (!TextUtils.isEmpty(this.aGf)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw(this.aGf).ac("fid", new StringBuilder().append(this.aRV.mForumId).toString()));
                }
                Lb().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(Lb().getPageActivity()).createNormalCfg(this.aRV.mForumName, getFrom())));
            }
        } else if (view == this.aRU && com.baidu.tbadk.core.util.bl.ad(getContext()) && this.aRV != null && !TextUtils.isEmpty(this.aRV.mForumName)) {
            if (!TextUtils.isEmpty(this.aGe)) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw(this.aGe).r("obj_type", 1).ac("fid", new StringBuilder().append(this.aRV.mForumId).toString()));
            }
            if (this.MY == null) {
                this.MY = new com.baidu.tieba.tbadkCore.w(Lb());
            }
            this.MY.setLoadDataCallBack(new j(this));
            this.MY.bC(this.aRV.mForumName, new StringBuilder().append(this.aRV.mForumId).toString());
        }
    }

    @Override // com.baidu.tieba.card.a
    public int Le() {
        return t.h.card_info_fourm_item;
    }

    public void a(com.baidu.tieba.card.a.g gVar) {
        if (gVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.aRV = gVar;
        this.mRootView.setVisibility(0);
        this.aRQ.setText(gVar.mForumName);
        if (gVar.aVG != null) {
            this.aRR.setText(gVar.aVG);
            this.aRR.setVisibility(0);
        } else {
            this.aRR.setVisibility(8);
        }
        if (gVar.aVH != null) {
            this.aRS.setText(gVar.aVH);
            this.aRS.setVisibility(0);
        } else {
            this.aRS.setVisibility(8);
        }
        if (gVar.aVI != null) {
            this.aRT.setText(gVar.aVI);
        } else {
            this.aRT.setText(gVar.aVF);
        }
        if (!StringUtils.isNULL(gVar.aVB)) {
            this.aRP.c(gVar.aVB, 10, false);
        }
        fK(gVar.aVC);
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
        if (this.aRV != null) {
            fK(this.aRV.aVC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, boolean z) {
        if (this.aRV != null) {
            int i = z ? 1 : 0;
            if (j == this.aRV.mForumId) {
                this.aRV.aVC = i;
                fK(i);
            }
        }
    }

    private void fK(int i) {
        if (i == 1) {
            this.aRU.setEnabled(false);
            com.baidu.tbadk.core.util.at.b(this.aRU, t.d.cp_cont_d, 1);
            this.aRU.setText(TbadkCoreApplication.m411getInst().getString(t.j.relate_forum_is_followed));
            this.aRU.setBackgroundDrawable(null);
            return;
        }
        com.baidu.tbadk.core.util.at.b(this.aRU, t.d.cp_cont_i, 1);
        this.aRU.setText(TbadkCoreApplication.m411getInst().getString(t.j.forum_list_attention_tv));
        com.baidu.tbadk.core.util.at.k(this.aRU, t.f.btn_appdownload);
        this.aRU.setEnabled(true);
    }
}
