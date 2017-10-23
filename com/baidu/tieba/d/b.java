package com.baidu.tieba.d;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.d.e;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.model.ShareReportModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.text.MessageFormat;
import java.util.ArrayList;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    bh aiU;
    private ShareReportModel anm;
    private TextView bTA;
    private Animation bTB;
    private Animation bTC;
    private Runnable bTD = new Runnable() { // from class: com.baidu.tieba.d.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.Zx();
        }
    };
    private Animation.AnimationListener bTE = new Animation.AnimationListener() { // from class: com.baidu.tieba.d.b.2
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.bTx.setVisibility(8);
            b.this.bTx.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private final com.baidu.adp.framework.listener.a bTF = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.d.b.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.this.Sr();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                b.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                b.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private ViewStub bTw;
    private ViewGroup bTx;
    private View bTy;
    private TextView bTz;
    private com.baidu.tbadk.core.view.a bqO;
    private Activity mActivity;
    private TbPageContext mH;
    private Handler mHandler;
    private long postId;
    private long threadId;

    public b(TbPageContext tbPageContext, ViewStub viewStub) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mH = tbPageContext;
        this.bTw = viewStub;
        this.bTF.setTag(tbPageContext.getUniqueId());
        this.bTF.getHttpMessageListener().setSelfListener(true);
        this.bTF.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.bTF);
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.bTw != null) {
            this.postId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                if (this.bTB == null) {
                    this.bTB = AnimationUtils.loadAnimation(this.mActivity, d.a.in_from_top);
                    this.bTC = AnimationUtils.loadAnimation(this.mActivity, d.a.out_to_top);
                    this.bTC.setAnimationListener(this.bTE);
                }
                if (this.bTx == null) {
                    this.bTx = (ViewGroup) this.bTw.inflate();
                    this.bTy = this.bTx.findViewById(d.h.status_bar_fill);
                    this.bTz = (TextView) this.bTx.findViewById(d.h.write_thread_success_tips);
                    this.bTA = (TextView) this.bTx.findViewById(d.h.share_icon);
                }
                if (UtilHelper.canUseStyleImmersiveSticky() && this.bTy.getLayoutParams() != null) {
                    this.bTy.getLayoutParams().height = UtilHelper.getStatusBarHeight();
                }
                StatusBarUtil.from(this.mActivity).setTransparentStatusbar(true).setLightStatusBar(false).process();
                this.bTx.setVisibility(0);
                aj.k(this.bTx, d.e.cp_link_tip_a_alpha95);
                aj.i(this.bTz, d.e.cp_cont_i);
                aj.i(this.bTA, d.e.cp_cont_i);
                aj.j(this.bTA, d.g.share_now_bg);
                this.bTA.setOnClickListener(this);
                Zw();
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.removeCallbacks(this.bTD);
                this.mHandler.postDelayed(this.bTD, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    private void Zw() {
        this.bTx.startAnimation(this.bTB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zx() {
        StatusBarUtil.from(this.mActivity).setTransparentStatusbar(true).setLightStatusBar(true).process();
        this.mHandler.removeCallbacks(this.bTD);
        this.bTx.startAnimation(this.bTC);
    }

    private void showLoadingDialog() {
        if (this.bqO == null) {
            this.bqO = new com.baidu.tbadk.core.view.a(this.mH);
        }
        this.bqO.aG(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sr() {
        if (this.bqO != null) {
            this.bqO.aG(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int ad = l.ad(TbadkCoreApplication.getInst());
        int af = l.af(TbadkCoreApplication.getInst());
        float f = this.mActivity.getResources().getDisplayMetrics().density;
        int i = 1;
        if (an.vl().vn()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.mH.getUniqueId());
        requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, ad, af, f, i);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        showLoadingDialog();
        Zx();
        wy();
    }

    private void wy() {
        TiebaStatic.log(new ak("c12386").f("tid", this.threadId).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).r("obj_locate", 7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mH.showToast(d.l.neterror);
            return;
        }
        this.aiU = new bh();
        this.aiU.a(getMyPostResIdl.data.thread_info);
        wz();
    }

    private void wz() {
        if (this.aiU != null && this.mActivity != null) {
            final String valueOf = String.valueOf(this.aiU.getFid());
            String rt = this.aiU.rt();
            String title = this.aiU.getTitle();
            final String tid = this.aiU.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.aiU);
            Uri parse = a == null ? null : Uri.parse(a);
            String rw = this.aiU.rw();
            String format = MessageFormat.format(this.mActivity.getResources().getString(d.l.share_content_tpl), title, rw);
            final com.baidu.tbadk.coreExtra.d.d dVar = new com.baidu.tbadk.coreExtra.d.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aty = rw;
            dVar.linkUrl = str;
            dVar.ats = 5;
            dVar.extData = tid;
            dVar.atB = 3;
            dVar.fid = valueOf;
            dVar.att = rt;
            dVar.WT = tid;
            dVar.atp = true;
            dVar.atA = getShareObjSource();
            dVar.atC = b(this.aiU);
            if (parse != null) {
                dVar.atv = parse;
            }
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.atB);
            bundle.putInt("obj_type", dVar.atC);
            bundle.putString("fid", dVar.fid);
            bundle.putString("tid", dVar.WT);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.ats);
            dVar.e(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.mActivity, dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(d.l.forum_friend, d.g.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.d.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(b.this.mActivity, 23007)));
                    TiebaStatic.log(new ak("c10125").ac("tid", tid).ac("fid", valueOf).r("obj_type", 1).r("obj_param1", 3).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, b.this.getShareObjSource()));
                    b.this.wA();
                }
            });
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dVar.linkUrl = e.aj(dVar.linkUrl, dVar.WT);
                    com.baidu.adp.lib.util.a.aw(dVar.linkUrl);
                    l.showToast(b.this.mActivity, view.getResources().getString(d.l.copy_pb_url_success));
                    b.this.wA();
                }
            });
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getShareObjSource() {
        return 7;
    }

    private String a(bh bhVar) {
        if (bhVar == null || bhVar.ry() == null) {
            return null;
        }
        ArrayList<MediaData> ry = bhVar.ry();
        int size = ry.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = ry.get(i);
            if (mediaData != null && mediaData.getType() == 3) {
                if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                    return mediaData.getThumbnails_url();
                }
                if (!StringUtils.isNull(mediaData.getPicUrl())) {
                    return mediaData.getPicUrl();
                }
            }
        }
        return null;
    }

    private int b(bh bhVar) {
        if (bhVar != null) {
            if (bhVar.rq()) {
                return 4;
            }
            if (bhVar.rl() == 1) {
                return 3;
            }
            return bhVar.su() ? 2 : 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wA() {
        com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem != null) {
            if (this.anm == null) {
                this.anm = new ShareReportModel(this.mH);
            }
            this.anm.j(shareItem.fid, shareItem.WT, shareItem.ats);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bTD);
        }
    }
}
