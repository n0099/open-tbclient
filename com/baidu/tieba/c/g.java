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
    bj adJ;
    private NavigationBarCoverTip gvA;
    private View gvB;
    private TextView gvC;
    private TextView gvD;
    private com.baidu.tbadk.core.view.a gvE;
    private boolean gvF = false;
    private boolean gvG = false;
    private final com.baidu.adp.framework.listener.a gvH = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.g.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g.this.bzS();
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
        this.gvA = navigationBarCoverTip;
        this.gvH.setTag(tbPageContext.getUniqueId());
        this.gvH.getHttpMessageListener().setSelfListener(true);
        this.gvH.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.gvH);
    }

    public void lF(boolean z) {
        this.gvF = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.gvA != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.gvG = false;
                if (this.gvB == null) {
                    this.gvB = View.inflate(this.mActivity, R.layout.write_thread_share_guide, null);
                    this.gvC = (TextView) this.gvB.findViewById(R.id.write_thread_success_tips);
                    this.gvD = (TextView) this.gvB.findViewById(R.id.share_icon);
                }
                am.setViewTextColor(this.gvC, (int) R.color.cp_cont_a);
                am.setViewTextColor(this.gvD, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.gvD, R.drawable.share_now_bg);
                am.setBackgroundColor(this.gvA, R.color.cp_link_tip_a_alpha95);
                this.gvD.setOnClickListener(this);
                this.gvA.a(this.mActivity, this.gvB, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.gvE == null) {
            this.gvE = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.gvE.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzS() {
        if (this.gvE != null) {
            this.gvE.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.gvG) {
            this.gvG = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.gvA.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = ar.aOS().aOT() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.gvA.hideTip();
            aQy();
        }
    }

    private void aQy() {
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        anVar.t("tid", this.threadId);
        anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.af("obj_locate", 7);
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.adJ = new bj();
        this.adJ.a(getMyPostResIdl.data.thread_info);
        aQA();
    }

    private void aQA() {
        if (this.adJ != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.adJ.getFid());
            String aKH = this.adJ.aKH();
            String title = this.adJ.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.adJ.getAbstract();
            }
            String tid = this.adJ.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String z = z(this.adJ);
            Uri parse = z == null ? null : Uri.parse(z);
            String str2 = this.adJ.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.readCount = 0L;
            shareItem.dQA = str2;
            shareItem.linkUrl = str;
            shareItem.due = 5;
            shareItem.dQv = this.gvF;
            shareItem.extData = tid;
            shareItem.dQD = 3;
            shareItem.fid = valueOf;
            shareItem.fName = aKH;
            shareItem.tid = tid;
            shareItem.dQq = true;
            shareItem.dQC = getShareObjSource();
            shareItem.dQH = A(this.adJ);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.dQK = OriginalThreadInfo.ShareInfo.generateShareInfo(this.adJ);
            shareItem.dQL = ShareItem.ForwardInfo.generateForwardInfo(this.adJ);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.dQR = this.adJ.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dQD);
            bundle.putInt("obj_type", shareItem.dQH);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.due);
            shareItem.Y(bundle);
            e.bGd().b(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
        }
    }

    private int getShareObjSource() {
        return 15;
    }

    private String z(bj bjVar) {
        if (bjVar == null || bjVar.aKM() == null) {
            return null;
        }
        ArrayList<MediaData> aKM = bjVar.aKM();
        int size = aKM.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aKM.get(i);
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
            if (bjVar.aKE()) {
                return 4;
            }
            if (bjVar.aKz() == 1) {
                return 3;
            }
            return bjVar.aLR() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.gvA != null) {
            this.gvA.onDestroy();
        }
    }
}
