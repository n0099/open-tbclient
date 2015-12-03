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
public class c extends a<com.baidu.tieba.a.a.d> {
    private x Ml;
    private String aCl;
    private String aCm;
    private BarImageView aLX;
    private TextView aLY;
    private TextView aLZ;
    private TextView aMa;
    private TextView aMb;
    private TextView aMc;
    private com.baidu.tieba.a.a.d aMd;
    private CustomMessageListener mLikeForumListener;
    private View mRootView;
    private CustomMessageListener mUnlikeForumListener;

    public void ao(String str, String str2) {
        this.aCl = str;
        this.aCm = str2;
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLikeForumListener = new d(this, CmdConfigCustom.CMD_LIKE_FORUM);
        this.mUnlikeForumListener = new e(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
        z(getView());
    }

    private void z(View view) {
        this.mRootView = view.findViewById(n.f.view_root);
        this.aLY = (TextView) view.findViewById(n.f.forum_name);
        this.aLZ = (TextView) view.findViewById(n.f.forum_follows_count);
        this.aMa = (TextView) view.findViewById(n.f.forum_thread_count);
        this.aMb = (TextView) view.findViewById(n.f.forum_intro);
        this.aLX = (BarImageView) view.findViewById(n.f.forum_avatar);
        this.aMc = (TextView) view.findViewById(n.f.tv_add_love);
        this.mRootView.setOnClickListener(this);
        this.aMc.setOnClickListener(this);
        Io().registerListener(this.mLikeForumListener);
        Io().registerListener(this.mUnlikeForumListener);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x002b: IGET  (r3v7 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.a.a.d : 0x0029: IGET  (r3v6 com.baidu.tieba.a.a.d A[REMOVE]) = (r6v0 'this' com.baidu.tieba.a.c A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.a.c.aMd com.baidu.tieba.a.a.d)
     com.baidu.tieba.a.a.d.mForumId long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00a0: IGET  (r3v3 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.a.a.d : 0x009e: IGET  (r3v2 com.baidu.tieba.a.a.d A[REMOVE]) = (r6v0 'this' com.baidu.tieba.a.c A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.a.c.aMd com.baidu.tieba.a.a.d)
     com.baidu.tieba.a.a.d.mForumId long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00d7: IGET  (r3v1 long A[REMOVE]) = 
      (wrap: com.baidu.tieba.a.a.d : 0x00d5: IGET  (r3v0 com.baidu.tieba.a.a.d A[REMOVE]) = (r6v0 'this' com.baidu.tieba.a.c A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.a.c.aMd com.baidu.tieba.a.a.d)
     com.baidu.tieba.a.a.d.mForumId long)] */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mRootView) {
            if (this.aMd != null && !TextUtils.isEmpty(this.aMd.mForumName)) {
                if (TextUtils.isEmpty(this.aCm)) {
                    TiebaStatic.log(new av(this.aCm).ab(ImageViewerConfig.FORUM_ID, new StringBuilder().append(this.aMd.mForumId).toString()));
                }
                Io().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(Io().getPageActivity()).createNormalCfg(this.aMd.mForumName, getFrom())));
            }
        } else if (view == this.aMc && bj.ah(getContext()) && this.aMd != null && !TextUtils.isEmpty(this.aMd.mForumName)) {
            if (!TextUtils.isEmpty(this.aCl)) {
                TiebaStatic.log(new av(this.aCl).r("obj_type", 1).ab(ImageViewerConfig.FORUM_ID, new StringBuilder().append(this.aMd.mForumId).toString()));
            }
            if (this.Ml == null) {
                this.Ml = new x(Io());
            }
            this.Ml.setLoadDataCallBack(new f(this));
            this.Ml.bg(this.aMd.mForumName, new StringBuilder().append(this.aMd.mForumId).toString());
        }
    }

    @Override // com.baidu.tieba.a.a
    public int Ip() {
        return n.g.card_info_fourm_item;
    }

    public void a(com.baidu.tieba.a.a.d dVar) {
        if (dVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.aMd = dVar;
        this.mRootView.setVisibility(0);
        this.aLY.setText(dVar.mForumName);
        if (dVar.aMS != null) {
            this.aLZ.setText(dVar.aMS);
            this.aLZ.setVisibility(0);
        } else {
            this.aLZ.setVisibility(8);
        }
        if (dVar.aMT != null) {
            this.aMa.setText(dVar.aMT);
            this.aMa.setVisibility(0);
        } else {
            this.aMa.setVisibility(8);
        }
        if (dVar.aMU != null) {
            this.aMb.setText(dVar.aMU);
        } else {
            this.aMb.setText(dVar.aMR);
        }
        if (!StringUtils.isNULL(dVar.aMN)) {
            this.aLX.d(dVar.aMN, 10, false);
        }
        fg(dVar.aMO);
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
        if (this.aMd != null) {
            fg(this.aMd.aMO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, boolean z) {
        if (this.aMd != null) {
            int i = z ? 1 : 0;
            if (j == this.aMd.mForumId) {
                this.aMd.aMO = i;
                fg(i);
            }
        }
    }

    private void fg(int i) {
        if (i == 1) {
            this.aMc.setEnabled(false);
            as.b(this.aMc, n.c.cp_cont_d, 1);
            this.aMc.setText(TbadkCoreApplication.m411getInst().getString(n.i.relate_forum_is_followed));
            this.aMc.setBackgroundDrawable(null);
            return;
        }
        as.b(this.aMc, n.c.cp_cont_i, 1);
        this.aMc.setText(TbadkCoreApplication.m411getInst().getString(n.i.forum_list_attention_tv));
        as.i((View) this.aMc, n.e.btn_appdownload);
        this.aMc.setEnabled(true);
    }
}
