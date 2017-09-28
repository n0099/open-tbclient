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
    bh ajg;
    private ShareReportModel any;
    private ViewStub bTI;
    private ViewGroup bTJ;
    private View bTK;
    private TextView bTL;
    private TextView bTM;
    private Animation bTN;
    private Animation bTO;
    private Runnable bTP = new Runnable() { // from class: com.baidu.tieba.d.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.ZB();
        }
    };
    private Animation.AnimationListener bTQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.d.b.2
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.bTJ.setVisibility(8);
            b.this.bTJ.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private final com.baidu.adp.framework.listener.a bTR = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.d.b.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.this.Sv();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                b.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                b.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private com.baidu.tbadk.core.view.a bra;
    private Activity mActivity;
    private TbPageContext mG;
    private Handler mHandler;
    private long postId;
    private long threadId;

    public b(TbPageContext tbPageContext, ViewStub viewStub) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mG = tbPageContext;
        this.bTI = viewStub;
        this.bTR.setTag(tbPageContext.getUniqueId());
        this.bTR.getHttpMessageListener().setSelfListener(true);
        this.bTR.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.bTR);
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.bTI != null) {
            this.postId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                if (this.bTN == null) {
                    this.bTN = AnimationUtils.loadAnimation(this.mActivity, d.a.in_from_top);
                    this.bTO = AnimationUtils.loadAnimation(this.mActivity, d.a.out_to_top);
                    this.bTO.setAnimationListener(this.bTQ);
                }
                if (this.bTJ == null) {
                    this.bTJ = (ViewGroup) this.bTI.inflate();
                    this.bTK = this.bTJ.findViewById(d.h.status_bar_fill);
                    this.bTL = (TextView) this.bTJ.findViewById(d.h.write_thread_success_tips);
                    this.bTM = (TextView) this.bTJ.findViewById(d.h.share_icon);
                }
                if (UtilHelper.canUseStyleImmersiveSticky() && this.bTK.getLayoutParams() != null) {
                    this.bTK.getLayoutParams().height = UtilHelper.getStatusBarHeight();
                }
                StatusBarUtil.from(this.mActivity).setTransparentStatusbar(true).setLightStatusBar(false).process();
                this.bTJ.setVisibility(0);
                aj.k(this.bTJ, d.e.cp_link_tip_a_alpha95);
                aj.i(this.bTL, d.e.cp_cont_i);
                aj.i(this.bTM, d.e.cp_cont_i);
                aj.j(this.bTM, d.g.share_now_bg);
                this.bTM.setOnClickListener(this);
                ZA();
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.removeCallbacks(this.bTP);
                this.mHandler.postDelayed(this.bTP, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    private void ZA() {
        this.bTJ.startAnimation(this.bTN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZB() {
        StatusBarUtil.from(this.mActivity).setTransparentStatusbar(true).setLightStatusBar(true).process();
        this.mHandler.removeCallbacks(this.bTP);
        this.bTJ.startAnimation(this.bTO);
    }

    private void showLoadingDialog() {
        if (this.bra == null) {
            this.bra = new com.baidu.tbadk.core.view.a(this.mG);
        }
        this.bra.aH(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sv() {
        if (this.bra != null) {
            this.bra.aH(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int ad = l.ad(TbadkCoreApplication.getInst());
        int af = l.af(TbadkCoreApplication.getInst());
        float f = this.mActivity.getResources().getDisplayMetrics().density;
        int i = 1;
        if (an.vs().vu()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.mG.getUniqueId());
        requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, ad, af, f, i);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        showLoadingDialog();
        ZB();
        wF();
    }

    private void wF() {
        TiebaStatic.log(new ak("c12386").f("tid", this.threadId).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).r("obj_locate", 7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mG.showToast(d.l.neterror);
            return;
        }
        this.ajg = new bh();
        this.ajg.a(getMyPostResIdl.data.thread_info);
        wG();
    }

    private void wG() {
        if (this.ajg != null && this.mActivity != null) {
            final String valueOf = String.valueOf(this.ajg.getFid());
            String rA = this.ajg.rA();
            String title = this.ajg.getTitle();
            final String tid = this.ajg.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.ajg);
            Uri parse = a == null ? null : Uri.parse(a);
            String rD = this.ajg.rD();
            String format = MessageFormat.format(this.mActivity.getResources().getString(d.l.share_content_tpl), title, rD);
            final com.baidu.tbadk.coreExtra.d.d dVar = new com.baidu.tbadk.coreExtra.d.d();
            dVar.title = title;
            dVar.content = format;
            dVar.atK = rD;
            dVar.linkUrl = str;
            dVar.atE = 5;
            dVar.extData = tid;
            dVar.atN = 3;
            dVar.fid = valueOf;
            dVar.atF = rA;
            dVar.Xf = tid;
            dVar.atB = true;
            dVar.atM = getShareObjSource();
            dVar.atO = b(this.ajg);
            if (parse != null) {
                dVar.atH = parse;
            }
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.atN);
            bundle.putInt("obj_type", dVar.atO);
            bundle.putString("fid", dVar.fid);
            bundle.putString("tid", dVar.Xf);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.atE);
            dVar.e(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.mActivity, dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(d.l.forum_friend, d.g.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.d.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(b.this.mActivity, 23007)));
                    TiebaStatic.log(new ak("c10125").ad("tid", tid).ad("fid", valueOf).r("obj_type", 1).r("obj_param1", 3).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, b.this.getShareObjSource()));
                    b.this.wH();
                }
            });
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dVar.linkUrl = e.ak(dVar.linkUrl, dVar.Xf);
                    com.baidu.adp.lib.util.a.aw(dVar.linkUrl);
                    l.showToast(b.this.mActivity, view.getResources().getString(d.l.copy_pb_url_success));
                    b.this.wH();
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
        if (bhVar == null || bhVar.rF() == null) {
            return null;
        }
        ArrayList<MediaData> rF = bhVar.rF();
        int size = rF.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = rF.get(i);
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
            if (bhVar.rx()) {
                return 4;
            }
            if (bhVar.rs() == 1) {
                return 3;
            }
            return bhVar.sB() ? 2 : 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wH() {
        com.baidu.tbadk.coreExtra.d.d shareItem = TbadkCoreApplication.getInst().getShareItem();
        if (shareItem != null) {
            if (this.any == null) {
                this.any = new ShareReportModel(this.mG);
            }
            this.any.j(shareItem.fid, shareItem.Xf, shareItem.atE);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.bTP);
        }
    }
}
