package com.baidu.tieba.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
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
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes.dex */
public class g extends a<com.baidu.tieba.a.a.e> {
    private x Ml;
    private String aCl;
    private String aCm;
    private BarImageView aLX;
    private TextView aLY;
    private TextView aMb;
    private TextView aMf;
    private com.baidu.tieba.a.a.e aMg;
    private CustomMessageListener mLikeForumListener;
    private View mRootView;
    private CustomMessageListener mUnlikeForumListener;

    public void ao(String str, String str2) {
        this.aCl = str;
        this.aCm = str2;
    }

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLikeForumListener = new h(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.mUnlikeForumListener = new i(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        z(getView());
    }

    private void z(View view) {
        this.mRootView = view.findViewById(n.f.forum_root);
        this.aLY = (TextView) view.findViewById(n.f.forum_name);
        this.aMb = (TextView) view.findViewById(n.f.forum_intro);
        this.aLX = (BarImageView) view.findViewById(n.f.forum_avatar);
        this.aMf = (TextView) view.findViewById(n.f.forum_follow);
        this.mRootView.setOnClickListener(this);
        this.aMf.setOnClickListener(this);
        Io().registerListener(this.mLikeForumListener);
        Io().registerListener(this.mUnlikeForumListener);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x002b: IGET  (r3v7 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.a.a.e : 0x0029: IGET  (r3v6 com.baidu.tieba.a.a.e A[REMOVE]) = (r6v0 'this' com.baidu.tieba.a.g A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.a.g.aMg com.baidu.tieba.a.a.e)
     com.baidu.tieba.a.a.e.mId long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00a0: IGET  (r3v3 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.a.a.e : 0x009e: IGET  (r3v2 com.baidu.tieba.a.a.e A[REMOVE]) = (r6v0 'this' com.baidu.tieba.a.g A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.a.g.aMg com.baidu.tieba.a.a.e)
     com.baidu.tieba.a.a.e.mId long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00d7: IGET  (r3v1 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.a.a.e : 0x00d5: IGET  (r3v0 com.baidu.tieba.a.a.e A[REMOVE]) = (r6v0 'this' com.baidu.tieba.a.g A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.a.g.aMg com.baidu.tieba.a.a.e)
     com.baidu.tieba.a.a.e.mId long)] */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            if (this.aMg != null && !TextUtils.isEmpty(this.aMg.mName)) {
                if (TextUtils.isEmpty(this.aCm)) {
                    TiebaStatic.log(new av(this.aCm).ab(ImageViewerConfig.FORUM_ID, new StringBuilder().append(this.aMg.mId).toString()));
                }
                Io().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(Io().getPageActivity()).createNormalCfg(this.aMg.mName, getFrom())));
            }
        } else if (view == this.aMf && bj.ah(getContext()) && this.aMg != null && !TextUtils.isEmpty(this.aMg.mName)) {
            if (!TextUtils.isEmpty(this.aCl)) {
                TiebaStatic.log(new av(this.aCl).r("obj_type", 1).ab(ImageViewerConfig.FORUM_ID, new StringBuilder().append(this.aMg.mId).toString()));
            }
            if (this.Ml == null) {
                this.Ml = new x(Io());
            }
            this.Ml.setLoadDataCallBack(new j(this));
            this.Ml.bg(this.aMg.mName, new StringBuilder().append(this.aMg.mId).toString());
        }
    }

    @Override // com.baidu.tieba.a.a
    public int Ip() {
        return n.g.card_fourm_simple_item;
    }

    public void a(com.baidu.tieba.a.a.e eVar) {
        if (eVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.aMg = eVar;
        this.mRootView.setVisibility(0);
        this.aLY.setText(eVar.mName);
        this.aMb.setText(eVar.aMR);
        if (!StringUtils.isNULL(eVar.aMN)) {
            this.aLX.d(eVar.aMN, 10, false);
        }
        fg(eVar.aMO);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.mRootView);
            Ir();
            as.i(this.mRootView, n.e.addresslist_item_bg);
            this.aLX.invalidate();
        }
        this.mSkinType = i;
    }

    private void Ir() {
        if (this.aMg != null) {
            fg(this.aMg.aMO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, boolean z) {
        if (this.aMg != null) {
            int i = z ? 1 : 0;
            if (j == this.aMg.mId) {
                this.aMg.aMO = i;
                fg(i);
            }
        }
    }

    private void fg(int i) {
        if (i == 1) {
            this.aMf.setEnabled(false);
            as.b(this.aMf, n.c.cp_cont_d, 1);
            this.aMf.setText(TbadkCoreApplication.m411getInst().getString(n.i.relate_forum_is_followed));
            this.aMf.setBackgroundDrawable(null);
            return;
        }
        as.b(this.aMf, n.c.cp_cont_i, 1);
        this.aMf.setText(TbadkCoreApplication.m411getInst().getString(n.i.forum_list_attention_tv));
        as.i((View) this.aMf, n.e.btn_appdownload);
        this.aMf.setEnabled(true);
    }
}
