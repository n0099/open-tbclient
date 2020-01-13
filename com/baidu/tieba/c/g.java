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
    bj Kn;
    private NavigationBarCoverTip fNu;
    private View fNv;
    private TextView fNw;
    private TextView fNx;
    private com.baidu.tbadk.core.view.a fNy;
    private Activity mActivity;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;
    private boolean fNz = false;
    private boolean fNA = false;
    private final com.baidu.adp.framework.listener.a fNB = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.g.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g.this.boJ();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                g.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                g.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };

    public g(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.fNu = navigationBarCoverTip;
        this.fNB.setTag(tbPageContext.getUniqueId());
        this.fNB.getHttpMessageListener().setSelfListener(true);
        this.fNB.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.fNB);
    }

    public void kv(boolean z) {
        this.fNz = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.fNu != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.fNA = false;
                if (this.fNv == null) {
                    this.fNv = View.inflate(this.mActivity, R.layout.write_thread_share_guide, null);
                    this.fNw = (TextView) this.fNv.findViewById(R.id.write_thread_success_tips);
                    this.fNx = (TextView) this.fNv.findViewById(R.id.share_icon);
                }
                am.setViewTextColor(this.fNw, (int) R.color.cp_cont_a);
                am.setViewTextColor(this.fNx, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.fNx, R.drawable.share_now_bg);
                am.setBackgroundColor(this.fNu, R.color.cp_link_tip_a_alpha95);
                this.fNx.setOnClickListener(this);
                this.fNu.a(this.mActivity, this.fNv, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.fNy == null) {
            this.fNy = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.fNy.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boJ() {
        if (this.fNy != null) {
            this.fNy.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.fNA) {
            this.fNA = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.fNu.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = ar.aEq().aEr() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.fNu.hideTip();
            aFJ();
        }
    }

    private void aFJ() {
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        anVar.s("tid", this.threadId);
        anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.Z("obj_locate", 7);
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.Kn = new bj();
        this.Kn.a(getMyPostResIdl.data.thread_info);
        aFL();
    }

    private void aFL() {
        if (this.Kn != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.Kn.getFid());
            String aAc = this.Kn.aAc();
            String title = this.Kn.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.Kn.getAbstract();
            }
            String tid = this.Kn.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String x = x(this.Kn);
            Uri parse = x == null ? null : Uri.parse(x);
            String str2 = this.Kn.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.dlS = str2;
            shareItem.linkUrl = str;
            shareItem.cQy = 5;
            shareItem.dlN = this.fNz;
            shareItem.extData = tid;
            shareItem.dlV = 3;
            shareItem.fid = valueOf;
            shareItem.fName = aAc;
            shareItem.tid = tid;
            shareItem.dlJ = true;
            shareItem.dlU = getShareObjSource();
            shareItem.dlZ = y(this.Kn);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.dmc = OriginalThreadInfo.ShareInfo.generateShareInfo(this.Kn);
            shareItem.dmd = ShareItem.ForwardInfo.generateForwardInfo(this.Kn);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.dmj = this.Kn.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dlV);
            bundle.putInt("obj_type", shareItem.dlZ);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.cQy);
            shareItem.Y(bundle);
            e.buG().b(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String x(bj bjVar) {
        if (bjVar == null || bjVar.aAh() == null) {
            return null;
        }
        ArrayList<MediaData> aAh = bjVar.aAh();
        int size = aAh.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aAh.get(i);
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

    private int y(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.azZ()) {
                return 4;
            }
            if (bjVar.azU() == 1) {
                return 3;
            }
            return bjVar.aBm() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.fNu != null) {
            this.fNu.onDestroy();
        }
    }
}
