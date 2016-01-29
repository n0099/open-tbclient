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
public class g extends a<com.baidu.tieba.card.a.g> {
    private com.baidu.tieba.tbadkCore.w MS;
    private String aEJ;
    private String aEK;
    private BarImageView aOZ;
    private TextView aPa;
    private TextView aPb;
    private TextView aPc;
    private TextView aPd;
    private TextView aPe;
    private com.baidu.tieba.card.a.g aPf;
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

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLikeForumListener = new h(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.mUnlikeForumListener = new i(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        L(getView());
    }

    private void L(View view) {
        this.mRootView = view.findViewById(t.g.view_root);
        this.aPa = (TextView) view.findViewById(t.g.forum_name);
        this.aPb = (TextView) view.findViewById(t.g.forum_follows_count);
        this.aPc = (TextView) view.findViewById(t.g.forum_thread_count);
        this.aPd = (TextView) view.findViewById(t.g.forum_intro);
        this.aOZ = (BarImageView) view.findViewById(t.g.forum_avatar);
        this.aPe = (TextView) view.findViewById(t.g.tv_add_love);
        this.mRootView.setOnClickListener(this);
        this.aPe.setOnClickListener(this);
        JK().registerListener(this.mLikeForumListener);
        JK().registerListener(this.mUnlikeForumListener);
        if (getTag() != null) {
            this.mLikeForumListener.setTag(getTag());
            this.mUnlikeForumListener.setTag(getTag());
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x002b: IGET  (r3v7 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.card.a.g : 0x0029: IGET  (r3v6 com.baidu.tieba.card.a.g A[REMOVE]) = (r6v0 'this' com.baidu.tieba.card.g A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.card.g.aPf com.baidu.tieba.card.a.g)
     com.baidu.tieba.card.a.g.mForumId long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00a0: IGET  (r3v3 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.card.a.g : 0x009e: IGET  (r3v2 com.baidu.tieba.card.a.g A[REMOVE]) = (r6v0 'this' com.baidu.tieba.card.g A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.card.g.aPf com.baidu.tieba.card.a.g)
     com.baidu.tieba.card.a.g.mForumId long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00d7: IGET  (r3v1 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.card.a.g : 0x00d5: IGET  (r3v0 com.baidu.tieba.card.a.g A[REMOVE]) = (r6v0 'this' com.baidu.tieba.card.g A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.card.g.aPf com.baidu.tieba.card.a.g)
     com.baidu.tieba.card.a.g.mForumId long)] */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            if (this.aPf != null && !TextUtils.isEmpty(this.aPf.mForumName)) {
                if (!TextUtils.isEmpty(this.aEK)) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.au(this.aEK).aa(ImageViewerConfig.FORUM_ID, new StringBuilder().append(this.aPf.mForumId).toString()));
                }
                JK().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(JK().getPageActivity()).createNormalCfg(this.aPf.mForumName, getFrom())));
            }
        } else if (view == this.aPe && bi.ah(getContext()) && this.aPf != null && !TextUtils.isEmpty(this.aPf.mForumName)) {
            if (!TextUtils.isEmpty(this.aEJ)) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au(this.aEJ).r("obj_type", 1).aa(ImageViewerConfig.FORUM_ID, new StringBuilder().append(this.aPf.mForumId).toString()));
            }
            if (this.MS == null) {
                this.MS = new com.baidu.tieba.tbadkCore.w(JK());
            }
            this.MS.setLoadDataCallBack(new j(this));
            this.MS.bl(this.aPf.mForumName, new StringBuilder().append(this.aPf.mForumId).toString());
        }
    }

    @Override // com.baidu.tieba.card.a
    public int JM() {
        return t.h.card_info_fourm_item;
    }

    public void a(com.baidu.tieba.card.a.g gVar) {
        if (gVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.aPf = gVar;
        this.mRootView.setVisibility(0);
        this.aPa.setText(gVar.mForumName);
        if (gVar.aRZ != null) {
            this.aPb.setText(gVar.aRZ);
            this.aPb.setVisibility(0);
        } else {
            this.aPb.setVisibility(8);
        }
        if (gVar.aSa != null) {
            this.aPc.setText(gVar.aSa);
            this.aPc.setVisibility(0);
        } else {
            this.aPc.setVisibility(8);
        }
        if (gVar.aSb != null) {
            this.aPd.setText(gVar.aSb);
        } else {
            this.aPd.setText(gVar.aRY);
        }
        if (!StringUtils.isNULL(gVar.aRU)) {
            this.aOZ.d(gVar.aRU, 10, false);
        }
        fx(gVar.aRV);
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
        if (this.aPf != null) {
            fx(this.aPf.aRV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, boolean z) {
        if (this.aPf != null) {
            int i = z ? 1 : 0;
            if (j == this.aPf.mForumId) {
                this.aPf.aRV = i;
                fx(i);
            }
        }
    }

    private void fx(int i) {
        if (i == 1) {
            this.aPe.setEnabled(false);
            com.baidu.tbadk.core.util.ar.b(this.aPe, t.d.cp_cont_d, 1);
            this.aPe.setText(TbadkCoreApplication.m411getInst().getString(t.j.relate_forum_is_followed));
            this.aPe.setBackgroundDrawable(null);
            return;
        }
        com.baidu.tbadk.core.util.ar.b(this.aPe, t.d.cp_cont_i, 1);
        this.aPe.setText(TbadkCoreApplication.m411getInst().getString(t.j.forum_list_attention_tv));
        com.baidu.tbadk.core.util.ar.k(this.aPe, t.f.btn_appdownload);
        this.aPe.setEnabled(true);
    }
}
