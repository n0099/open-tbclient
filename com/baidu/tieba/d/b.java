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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
    bh ajq;
    private ShareReportModel anH;
    private ViewStub cbc;
    private ViewGroup cbd;
    private View cbe;
    private TextView cbf;
    private TextView cbg;
    private com.baidu.tbadk.core.view.a cbh;
    private Animation cbi;
    private Animation cbj;
    private Runnable cbk = new Runnable() { // from class: com.baidu.tieba.d.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.abG();
        }
    };
    private Animation.AnimationListener cbl = new Animation.AnimationListener() { // from class: com.baidu.tieba.d.b.2
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.cbd.setVisibility(8);
            b.this.cbd.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private final com.baidu.adp.framework.listener.a cbm = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.d.b.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.this.VG();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                b.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                b.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private Activity mActivity;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;

    public b(TbPageContext tbPageContext, ViewStub viewStub) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.cbc = viewStub;
        this.cbm.setTag(tbPageContext.getUniqueId());
        this.cbm.getHttpMessageListener().setSelfListener(true);
        this.cbm.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.cbm);
    }

    public void a(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.cbc != null) {
            this.postId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                if (this.cbi == null) {
                    this.cbi = AnimationUtils.loadAnimation(this.mActivity, d.a.in_from_top);
                    this.cbj = AnimationUtils.loadAnimation(this.mActivity, d.a.out_to_top);
                    this.cbj.setAnimationListener(this.cbl);
                }
                if (this.cbd == null) {
                    this.cbd = (ViewGroup) this.cbc.inflate();
                    this.cbe = this.cbd.findViewById(d.g.status_bar_fill);
                    this.cbf = (TextView) this.cbd.findViewById(d.g.write_thread_success_tips);
                    this.cbg = (TextView) this.cbd.findViewById(d.g.share_icon);
                }
                if (UtilHelper.canUseStyleImmersiveSticky() && this.cbe.getLayoutParams() != null) {
                    this.cbe.getLayoutParams().height = UtilHelper.getStatusBarHeight();
                }
                StatusBarUtil.from(this.mActivity).setTransparentStatusbar(true).setLightStatusBar(false).process();
                this.cbd.setVisibility(0);
                aj.k(this.cbd, d.C0080d.cp_link_tip_a_alpha95);
                aj.i(this.cbf, d.C0080d.cp_cont_i);
                aj.i(this.cbg, d.C0080d.cp_cont_i);
                aj.j(this.cbg, d.f.share_now_bg);
                this.cbg.setOnClickListener(this);
                abF();
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.removeCallbacks(this.cbk);
                this.mHandler.postDelayed(this.cbk, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    private void abF() {
        this.cbd.startAnimation(this.cbi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abG() {
        StatusBarUtil.from(this.mActivity).setTransparentStatusbar(true).setLightStatusBar(true).process();
        this.mHandler.removeCallbacks(this.cbk);
        this.cbd.startAnimation(this.cbj);
    }

    private void showLoadingDialog() {
        if (this.cbh == null) {
            this.cbh = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.cbh.aE(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VG() {
        if (this.cbh != null) {
            this.cbh.aE(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int ac = l.ac(TbadkCoreApplication.getInst());
        int ae = l.ae(TbadkCoreApplication.getInst());
        float f = this.mActivity.getResources().getDisplayMetrics().density;
        int i = 1;
        if (an.vs().vu()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
        requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, ac, ae, f, i);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        showLoadingDialog();
        abG();
        wF();
    }

    private void wF() {
        TiebaStatic.log(new ak("c12386").f("tid", this.threadId).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).r("obj_locate", 7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(d.j.neterror);
            return;
        }
        this.ajq = new bh();
        this.ajq.a(getMyPostResIdl.data.thread_info);
        wG();
    }

    private void wG() {
        if (this.ajq != null && this.mActivity != null) {
            final String valueOf = String.valueOf(this.ajq.getFid());
            String rz = this.ajq.rz();
            String title = this.ajq.getTitle();
            final String tid = this.ajq.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.ajq);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.ajq.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(d.j.share_content_tpl), title, str2);
            final com.baidu.tbadk.coreExtra.d.d dVar = new com.baidu.tbadk.coreExtra.d.d();
            dVar.title = title;
            dVar.content = format;
            dVar.atU = str2;
            dVar.linkUrl = str;
            dVar.atO = 5;
            dVar.extData = tid;
            dVar.atX = 3;
            dVar.fid = valueOf;
            dVar.atP = rz;
            dVar.Xl = tid;
            dVar.atL = true;
            dVar.atW = getShareObjSource();
            dVar.atY = b(this.ajq);
            if (parse != null) {
                dVar.atR = parse;
            }
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.atX);
            bundle.putInt("obj_type", dVar.atY);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.Xl);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.atO);
            dVar.e(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.mActivity, dVar, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(d.j.forum_friend, d.f.icon_unite_share_baf, new View.OnClickListener() { // from class: com.baidu.tieba.d.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectFriendActivityConfig(b.this.mActivity, 23007)));
                    TiebaStatic.log(new ak("c10125").ac("tid", tid).ac(ImageViewerConfig.FORUM_ID, valueOf).r("obj_type", 1).r("obj_param1", 3).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, b.this.getShareObjSource()));
                    b.this.wH();
                }
            });
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.d.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dVar.linkUrl = e.ai(dVar.linkUrl, dVar.Xl);
                    com.baidu.adp.lib.util.a.aw(dVar.linkUrl);
                    l.showToast(b.this.mActivity, view.getResources().getString(d.j.copy_pb_url_success));
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
        if (bhVar == null || bhVar.rE() == null) {
            return null;
        }
        ArrayList<MediaData> rE = bhVar.rE();
        int size = rE.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = rE.get(i);
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
            if (bhVar.rw()) {
                return 4;
            }
            if (bhVar.rq() == 1) {
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
            if (this.anH == null) {
                this.anH = new ShareReportModel(this.mPageContext);
            }
            this.anH.j(shareItem.fid, shareItem.Xl, shareItem.atO);
        }
    }

    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.cbk);
        }
    }
}
