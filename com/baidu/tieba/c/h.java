package com.baidu.tieba.c;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.ShadowLinearLayout;
import java.text.MessageFormat;
import java.util.ArrayList;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    cb ahi;
    private NavigationBarCoverTip iDP;
    private ShadowLinearLayout iDQ;
    private TextView iDR;
    private TextView iDS;
    private TBSpecificationBtn iDT;
    private com.baidu.tbadk.core.view.a iDU;
    private boolean iDV = false;
    private boolean iDW = false;
    private final com.baidu.adp.framework.listener.a iDX = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.h.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            h.this.ckx();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                h.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                h.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private Activity mActivity;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;

    public h(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.iDP = navigationBarCoverTip;
        this.iDX.setTag(tbPageContext.getUniqueId());
        this.iDX.getHttpMessageListener().setSelfListener(true);
        this.iDX.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.iDX);
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.iDP != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.iDW = false;
                if (this.iDQ == null) {
                    this.iDQ = (ShadowLinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
                    this.iDR = (TextView) this.iDQ.findViewById(R.id.tb_top_toast_title);
                    this.iDS = (TextView) this.iDQ.findViewById(R.id.tb_top_toast_content);
                    this.iDT = (TBSpecificationBtn) this.iDQ.findViewById(R.id.tb_top_toast_btn);
                    this.iDR.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_title));
                    this.iDS.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_content));
                    this.iDT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
                    this.iDT.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
                }
                ap.setViewTextColor(this.iDR, R.color.CAM_X0302);
                ap.setViewTextColor(this.iDS, R.color.CAM_X0302);
                this.iDT.bup();
                this.iDQ.onChangeSkinType();
                this.iDT.setOnClickListener(this);
                this.iDP.setBackgroundColor(0);
                this.iDP.a(this.mActivity, this.iDQ, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.iDU == null) {
            this.iDU = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.iDU.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckx() {
        if (this.iDU != null) {
            this.iDU.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.iDW) {
            this.iDW = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.iDP.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = av.bsS().bsT() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.iDP.hideTip();
            buD();
        }
    }

    private void buD() {
        ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        arVar.v("tid", this.threadId);
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.ap("obj_locate", 7);
        if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.ahi = new cb();
        this.ahi.a(getMyPostResIdl.data.thread_info);
        buF();
    }

    private void buF() {
        if (this.ahi != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.ahi.getFid());
            String bnU = this.ahi.bnU();
            String title = this.ahi.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.ahi.getAbstract();
            }
            String tid = this.ahi.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.ahi);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.ahi.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.readCount = 0L;
            shareItem.fuV = str2;
            shareItem.linkUrl = str;
            shareItem.eUk = 5;
            shareItem.fuQ = this.iDV;
            shareItem.extData = tid;
            shareItem.fuY = 3;
            shareItem.fid = valueOf;
            shareItem.fName = bnU;
            shareItem.tid = tid;
            shareItem.fuK = true;
            shareItem.fuX = getShareObjSource();
            shareItem.fvc = getStateThreadType(this.ahi);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.fvf = OriginalThreadInfo.ShareInfo.generateShareInfo(this.ahi);
            shareItem.fvg = ShareItem.ForwardInfo.generateForwardInfo(this.ahi);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.fvm = this.ahi.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fuY);
            bundle.putInt("obj_type", shareItem.fvc);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eUk);
            shareItem.ae(bundle);
            f.ctG().b(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
        }
    }

    private int getShareObjSource() {
        return 15;
    }

    private String getShareImageUrl(cb cbVar) {
        if (cbVar == null || cbVar.bnZ() == null) {
            return null;
        }
        ArrayList<MediaData> bnZ = cbVar.bnZ();
        int size = bnZ.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = bnZ.get(i);
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

    private int getStateThreadType(cb cbVar) {
        if (cbVar != null) {
            if (cbVar.bnS()) {
                return 4;
            }
            if (cbVar.bnN() == 1) {
                return 3;
            }
            return cbVar.bpk() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.iDP != null) {
            this.iDP.onDestroy();
        }
    }
}
