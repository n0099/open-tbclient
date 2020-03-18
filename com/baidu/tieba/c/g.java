package com.baidu.tieba.c;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.text.MessageFormat;
import java.util.ArrayList;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    bj KJ;
    private NavigationBarCoverTip fQM;
    private View fQN;
    private TextView fQO;
    private TextView fQP;
    private com.baidu.tbadk.core.view.a fQQ;
    private boolean fQR = false;
    private boolean fQS = false;
    private final com.baidu.adp.framework.listener.a fQT = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.g.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g.this.bqx();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                g.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                g.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private Activity mActivity;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;

    public g(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.fQM = navigationBarCoverTip;
        this.fQT.setTag(tbPageContext.getUniqueId());
        this.fQT.getHttpMessageListener().setSelfListener(true);
        this.fQT.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.fQT);
    }

    public void kC(boolean z) {
        this.fQR = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.fQM != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.fQS = false;
                if (this.fQN == null) {
                    this.fQN = View.inflate(this.mActivity, R.layout.write_thread_share_guide, null);
                    this.fQO = (TextView) this.fQN.findViewById(R.id.write_thread_success_tips);
                    this.fQP = (TextView) this.fQN.findViewById(R.id.share_icon);
                }
                am.setViewTextColor(this.fQO, (int) R.color.cp_cont_a);
                am.setViewTextColor(this.fQP, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.fQP, R.drawable.share_now_bg);
                am.setBackgroundColor(this.fQM, R.color.cp_link_tip_a_alpha95);
                this.fQP.setOnClickListener(this);
                this.fQM.a(this.mActivity, this.fQN, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.fQQ == null) {
            this.fQQ = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.fQQ.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqx() {
        if (this.fQQ != null) {
            this.fQQ.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.fQS) {
            this.fQS = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.fQM.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = ar.aGH().aGI() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.fQM.hideTip();
            aIf();
        }
    }

    private void aIf() {
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        anVar.s("tid", this.threadId);
        anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.X("obj_locate", 7);
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cx("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.KJ = new bj();
        this.KJ.a(getMyPostResIdl.data.thread_info);
        aIh();
    }

    private void aIh() {
        if (this.KJ != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.KJ.getFid());
            String aCw = this.KJ.aCw();
            String title = this.KJ.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.KJ.getAbstract();
            }
            String tid = this.KJ.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String z = z(this.KJ);
            Uri parse = z == null ? null : Uri.parse(z);
            String str2 = this.KJ.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.readCount = 0L;
            shareItem.dqC = str2;
            shareItem.linkUrl = str;
            shareItem.cUP = 5;
            shareItem.dqx = this.fQR;
            shareItem.extData = tid;
            shareItem.dqF = 3;
            shareItem.fid = valueOf;
            shareItem.fName = aCw;
            shareItem.tid = tid;
            shareItem.dqs = true;
            shareItem.dqE = getShareObjSource();
            shareItem.dqJ = A(this.KJ);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.dqM = OriginalThreadInfo.ShareInfo.generateShareInfo(this.KJ);
            shareItem.dqN = ShareItem.ForwardInfo.generateForwardInfo(this.KJ);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.dqT = this.KJ.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dqF);
            bundle.putInt("obj_type", shareItem.dqJ);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.cUP);
            shareItem.Y(bundle);
            e.bws().b(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
        }
    }

    private int getShareObjSource() {
        return 15;
    }

    private String z(bj bjVar) {
        if (bjVar == null || bjVar.aCB() == null) {
            return null;
        }
        ArrayList<MediaData> aCB = bjVar.aCB();
        int size = aCB.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aCB.get(i);
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

    private int A(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.aCt()) {
                return 4;
            }
            if (bjVar.aCo() == 1) {
                return 3;
            }
            return bjVar.aDF() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.fQM != null) {
            this.fQM.onDestroy();
        }
    }
}
