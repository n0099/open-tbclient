package com.baidu.tieba.d;

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
import com.baidu.tbadk.core.data.by;
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
    by ahA;
    private NavigationBarCoverTip iqe;
    private ShadowLinearLayout iqf;
    private TextView iqg;
    private TextView iqh;
    private TBSpecificationBtn iqi;
    private com.baidu.tbadk.core.view.a iqj;
    private boolean iqk = false;
    private boolean iql = false;
    private final com.baidu.adp.framework.listener.a iqm = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.d.h.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            h.this.cku();
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
        this.iqe = navigationBarCoverTip;
        this.iqm.setTag(tbPageContext.getUniqueId());
        this.iqm.getHttpMessageListener().setSelfListener(true);
        this.iqm.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.iqm);
    }

    public void pi(boolean z) {
        this.iqk = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.iqe != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.iql = false;
                if (this.iqf == null) {
                    this.iqf = (ShadowLinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
                    this.iqg = (TextView) this.iqf.findViewById(R.id.tb_top_toast_title);
                    this.iqh = (TextView) this.iqf.findViewById(R.id.tb_top_toast_content);
                    this.iqi = (TBSpecificationBtn) this.iqf.findViewById(R.id.tb_top_toast_btn);
                    this.iqg.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_title));
                    this.iqh.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_content));
                    this.iqi.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
                    this.iqi.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
                }
                ap.setViewTextColor(this.iqg, R.color.CAM_X0302);
                ap.setViewTextColor(this.iqh, R.color.CAM_X0302);
                this.iqi.bvt();
                this.iqf.onChangeSkinType();
                this.iqi.setOnClickListener(this);
                this.iqe.setBackgroundColor(0);
                this.iqe.a(this.mActivity, this.iqf, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.iqj == null) {
            this.iqj = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.iqj.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cku() {
        if (this.iqj != null) {
            this.iqj.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.iql) {
            this.iql = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.iqe.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = av.btX().btY() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.iqe.hideTip();
            bvH();
        }
    }

    private void bvH() {
        ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        arVar.w("tid", this.threadId);
        arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.al("obj_locate", 7);
        if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            arVar.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.ahA = new by();
        this.ahA.a(getMyPostResIdl.data.thread_info);
        bvJ();
    }

    private void bvJ() {
        if (this.ahA != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.ahA.getFid());
            String boT = this.ahA.boT();
            String title = this.ahA.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.ahA.getAbstract();
            }
            String tid = this.ahA.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.ahA);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.ahA.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.readCount = 0L;
            shareItem.fnC = str2;
            shareItem.linkUrl = str;
            shareItem.eMJ = 5;
            shareItem.fnx = this.iqk;
            shareItem.extData = tid;
            shareItem.fnF = 3;
            shareItem.fid = valueOf;
            shareItem.fName = boT;
            shareItem.tid = tid;
            shareItem.fnr = true;
            shareItem.fnE = getShareObjSource();
            shareItem.fnJ = getStateThreadType(this.ahA);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.fnM = OriginalThreadInfo.ShareInfo.generateShareInfo(this.ahA);
            shareItem.fnN = ShareItem.ForwardInfo.generateForwardInfo(this.ahA);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.fnT = this.ahA.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fnF);
            bundle.putInt("obj_type", shareItem.fnJ);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eMJ);
            shareItem.ae(bundle);
            f.ctl().b(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
        }
    }

    private int getShareObjSource() {
        return 15;
    }

    private String getShareImageUrl(by byVar) {
        if (byVar == null || byVar.boY() == null) {
            return null;
        }
        ArrayList<MediaData> boY = byVar.boY();
        int size = boY.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = boY.get(i);
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

    private int getStateThreadType(by byVar) {
        if (byVar != null) {
            if (byVar.boR()) {
                return 4;
            }
            if (byVar.boM() == 1) {
                return 3;
            }
            return byVar.bqj() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.iqe != null) {
            this.iqe.onDestroy();
        }
    }
}
