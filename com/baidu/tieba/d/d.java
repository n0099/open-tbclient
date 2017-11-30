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
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.text.MessageFormat;
import java.util.ArrayList;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    bd ajM;
    private c anT;
    private ViewStub cjR;
    private ViewGroup cjS;
    private View cjT;
    private TextView cjU;
    private TextView cjV;
    private com.baidu.tbadk.core.view.a cjW;
    private Animation cjX;
    private Animation cjY;
    private boolean cjZ = false;
    private boolean cka = false;
    private Runnable ckb = new Runnable() { // from class: com.baidu.tieba.d.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.adE();
        }
    };
    private Animation.AnimationListener ckc = new Animation.AnimationListener() { // from class: com.baidu.tieba.d.d.2
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            d.this.cjS.setVisibility(8);
            d.this.cjS.clearAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private final com.baidu.adp.framework.listener.a ckd = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.d.d.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.this.XB();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                d.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                d.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private Activity mActivity;
    private Handler mHandler;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;

    public d(TbPageContext tbPageContext, ViewStub viewStub) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.cjR = viewStub;
        this.ckd.setTag(tbPageContext.getUniqueId());
        this.ckd.getHttpMessageListener().setSelfListener(true);
        this.ckd.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.ckd);
        this.anT = new c(this.mPageContext);
    }

    public void eg(boolean z) {
        this.cjZ = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.cjR != null) {
            this.postId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.cka = false;
                if (this.cjX == null) {
                    this.cjX = AnimationUtils.loadAnimation(this.mActivity, d.a.in_from_top);
                    this.cjY = AnimationUtils.loadAnimation(this.mActivity, d.a.out_to_top);
                    this.cjY.setAnimationListener(this.ckc);
                }
                if (this.cjS == null) {
                    this.cjS = (ViewGroup) this.cjR.inflate();
                    this.cjT = this.cjS.findViewById(d.g.status_bar_fill);
                    this.cjU = (TextView) this.cjS.findViewById(d.g.write_thread_success_tips);
                    this.cjV = (TextView) this.cjS.findViewById(d.g.share_icon);
                }
                if (UtilHelper.canUseStyleImmersiveSticky() && this.cjT.getLayoutParams() != null) {
                    this.cjT.getLayoutParams().height = UtilHelper.getStatusBarHeight();
                }
                StatusBarUtil.from(this.mActivity).setTransparentStatusbar(true).setLightStatusBar(false).process();
                this.cjS.setVisibility(0);
                aj.k(this.cjS, d.C0082d.cp_link_tip_a_alpha95);
                aj.i(this.cjU, d.C0082d.cp_cont_i);
                aj.i(this.cjV, d.C0082d.cp_cont_i);
                aj.j(this.cjV, d.f.share_now_bg);
                this.cjV.setOnClickListener(this);
                adD();
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.removeCallbacks(this.ckb);
                this.mHandler.postDelayed(this.ckb, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    private void adD() {
        this.cjS.startAnimation(this.cjX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adE() {
        StatusBarUtil.from(this.mActivity).setTransparentStatusbar(true).setLightStatusBar(true).process();
        this.mHandler.removeCallbacks(this.ckb);
        this.cjS.startAnimation(this.cjY);
    }

    private void showLoadingDialog() {
        if (this.cjW == null) {
            this.cjW = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.cjW.aE(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XB() {
        if (this.cjW != null) {
            this.cjW.aE(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.cka) {
            this.cka = true;
            if (!j.hh()) {
                this.mPageContext.showToast(d.j.neterror);
                adE();
                return;
            }
            int ac = l.ac(TbadkCoreApplication.getInst());
            int ae = l.ae(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = an.vv().vx() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, ac, ae, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            adE();
            wI();
        }
    }

    private void wI() {
        TiebaStatic.log(new ak("c12386").f("tid", this.threadId).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).r("obj_locate", 7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(d.j.neterror);
            return;
        }
        this.ajM = new bd();
        this.ajM.a(getMyPostResIdl.data.thread_info);
        wJ();
    }

    private void wJ() {
        if (this.ajM != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.ajM.getFid());
            String rD = this.ajM.rD();
            String title = this.ajM.getTitle();
            String tid = this.ajM.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.ajM);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.ajM.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.auC = str2;
            dVar.linkUrl = str;
            dVar.aaM = 5;
            dVar.auv = this.cjZ;
            dVar.extData = tid;
            dVar.auF = 3;
            dVar.fid = valueOf;
            dVar.aux = rD;
            dVar.tid = tid;
            dVar.auu = true;
            dVar.auE = getShareObjSource();
            dVar.auG = b(this.ajM);
            if (parse != null) {
                dVar.auz = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.ajM);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.auF);
            bundle.putInt("obj_type", dVar.auG);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aaM);
            dVar.e(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.mActivity, dVar, true, true);
            if (this.anT == null) {
                this.anT = new c(this.mPageContext);
            }
            this.anT.a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String a(bd bdVar) {
        if (bdVar == null || bdVar.rI() == null) {
            return null;
        }
        ArrayList<MediaData> rI = bdVar.rI();
        int size = rI.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = rI.get(i);
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

    private int b(bd bdVar) {
        if (bdVar != null) {
            if (bdVar.rA()) {
                return 4;
            }
            if (bdVar.ru() == 1) {
                return 3;
            }
            return bdVar.sE() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.ckb);
        }
    }
}
