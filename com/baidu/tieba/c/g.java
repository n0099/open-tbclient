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
import com.baidu.tbadk.core.data.bk;
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
    bk aee;
    private com.baidu.tbadk.core.view.a gKA;
    private boolean gKB = false;
    private boolean gKC = false;
    private final com.baidu.adp.framework.listener.a gKD = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.g.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g.this.bGh();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                g.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                g.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private NavigationBarCoverTip gKw;
    private View gKx;
    private TextView gKy;
    private TextView gKz;
    private Activity mActivity;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;

    public g(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.gKw = navigationBarCoverTip;
        this.gKD.setTag(tbPageContext.getUniqueId());
        this.gKD.getHttpMessageListener().setSelfListener(true);
        this.gKD.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.gKD);
    }

    public void mb(boolean z) {
        this.gKB = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.gKw != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.gKC = false;
                if (this.gKx == null) {
                    this.gKx = View.inflate(this.mActivity, R.layout.write_thread_share_guide, null);
                    this.gKy = (TextView) this.gKx.findViewById(R.id.write_thread_success_tips);
                    this.gKz = (TextView) this.gKx.findViewById(R.id.share_icon);
                }
                am.setViewTextColor(this.gKy, (int) R.color.cp_cont_a);
                am.setViewTextColor(this.gKz, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.gKz, R.drawable.share_now_bg);
                am.setBackgroundColor(this.gKw, R.color.cp_link_tip_a_alpha95);
                this.gKz.setOnClickListener(this);
                this.gKw.a(this.mActivity, this.gKx, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.gKA == null) {
            this.gKA = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.gKA.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGh() {
        if (this.gKA != null) {
            this.gKA.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.gKC) {
            this.gKC = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.gKw.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = ar.aUX().aUY() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.gKw.hideTip();
            aWH();
        }
    }

    private void aWH() {
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        anVar.s("tid", this.threadId);
        anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.ag("obj_locate", 7);
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.aee = new bk();
        this.aee.a(getMyPostResIdl.data.thread_info);
        aWJ();
    }

    private void aWJ() {
        if (this.aee != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.aee.getFid());
            String aQC = this.aee.aQC();
            String title = this.aee.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.aee.getAbstract();
            }
            String tid = this.aee.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String A = A(this.aee);
            Uri parse = A == null ? null : Uri.parse(A);
            String str2 = this.aee.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.readCount = 0L;
            shareItem.eeT = str2;
            shareItem.linkUrl = str;
            shareItem.dHZ = 5;
            shareItem.eeO = this.gKB;
            shareItem.extData = tid;
            shareItem.eeW = 3;
            shareItem.fid = valueOf;
            shareItem.fName = aQC;
            shareItem.tid = tid;
            shareItem.eeK = true;
            shareItem.eeV = getShareObjSource();
            shareItem.efa = B(this.aee);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.efd = OriginalThreadInfo.ShareInfo.generateShareInfo(this.aee);
            shareItem.efe = ShareItem.ForwardInfo.generateForwardInfo(this.aee);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.efk = this.aee.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eeW);
            bundle.putInt("obj_type", shareItem.efa);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.dHZ);
            shareItem.ae(bundle);
            e.bMy().b(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
        }
    }

    private int getShareObjSource() {
        return 15;
    }

    private String A(bk bkVar) {
        if (bkVar == null || bkVar.aQH() == null) {
            return null;
        }
        ArrayList<MediaData> aQH = bkVar.aQH();
        int size = aQH.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aQH.get(i);
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

    private int B(bk bkVar) {
        if (bkVar != null) {
            if (bkVar.aQz()) {
                return 4;
            }
            if (bkVar.aQu() == 1) {
                return 3;
            }
            return bkVar.aRQ() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.gKw != null) {
            this.gKw.onDestroy();
        }
    }
}
