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
    private NavigationBarCoverTip gKl;
    private View gKm;
    private TextView gKn;
    private TextView gKo;
    private com.baidu.tbadk.core.view.a gKp;
    private boolean gKq = false;
    private boolean gKr = false;
    private final com.baidu.adp.framework.listener.a gKs = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.g.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g.this.bGf();
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
        this.gKl = navigationBarCoverTip;
        this.gKs.setTag(tbPageContext.getUniqueId());
        this.gKs.getHttpMessageListener().setSelfListener(true);
        this.gKs.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.gKs);
    }

    public void mb(boolean z) {
        this.gKq = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.gKl != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.gKr = false;
                if (this.gKm == null) {
                    this.gKm = View.inflate(this.mActivity, R.layout.write_thread_share_guide, null);
                    this.gKn = (TextView) this.gKm.findViewById(R.id.write_thread_success_tips);
                    this.gKo = (TextView) this.gKm.findViewById(R.id.share_icon);
                }
                am.setViewTextColor(this.gKn, (int) R.color.cp_cont_a);
                am.setViewTextColor(this.gKo, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.gKo, R.drawable.share_now_bg);
                am.setBackgroundColor(this.gKl, R.color.cp_link_tip_a_alpha95);
                this.gKo.setOnClickListener(this);
                this.gKl.a(this.mActivity, this.gKm, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.gKp == null) {
            this.gKp = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.gKp.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGf() {
        if (this.gKp != null) {
            this.gKp.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.gKr) {
            this.gKr = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.gKl.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = ar.aUW().aUX() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.gKl.hideTip();
            aWG();
        }
    }

    private void aWG() {
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
        aWI();
    }

    private void aWI() {
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
            shareItem.eeO = this.gKq;
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
            e.bMw().b(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
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
        if (this.gKl != null) {
            this.gKl.onDestroy();
        }
    }
}
