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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
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
    bw agf;
    private NavigationBarCoverTip hxa;
    private ShadowLinearLayout hxb;
    private TextView hxc;
    private TextView hxd;
    private TBSpecificationBtn hxe;
    private com.baidu.tbadk.core.view.a hxf;
    private boolean hxg = false;
    private boolean hxh = false;
    private final com.baidu.adp.framework.listener.a hxi = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.h.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            h.this.bXZ();
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
        this.hxa = navigationBarCoverTip;
        this.hxi.setTag(tbPageContext.getUniqueId());
        this.hxi.getHttpMessageListener().setSelfListener(true);
        this.hxi.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.hxi);
    }

    public void nD(boolean z) {
        this.hxg = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.hxa != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.hxh = false;
                if (this.hxb == null) {
                    this.hxb = (ShadowLinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
                    this.hxc = (TextView) this.hxb.findViewById(R.id.tb_top_toast_title);
                    this.hxd = (TextView) this.hxb.findViewById(R.id.tb_top_toast_content);
                    this.hxe = (TBSpecificationBtn) this.hxb.findViewById(R.id.tb_top_toast_btn);
                    this.hxc.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_title));
                    this.hxd.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_content));
                    this.hxe.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
                    this.hxe.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
                }
                ap.setViewTextColor(this.hxc, R.color.cp_link_tip_a);
                ap.setViewTextColor(this.hxd, R.color.cp_link_tip_a);
                this.hxe.blA();
                this.hxb.onChangeSkinType();
                this.hxe.setOnClickListener(this);
                this.hxa.setBackgroundColor(0);
                this.hxa.a(this.mActivity, this.hxb, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.hxf == null) {
            this.hxf = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.hxf.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXZ() {
        if (this.hxf != null) {
            this.hxf.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.hxh) {
            this.hxh = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.hxa.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = au.bkm().bkn() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.hxa.hideTip();
            blO();
        }
    }

    private void blO() {
        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        aqVar.u("tid", this.threadId);
        aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.ai("obj_locate", 7);
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dF("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.agf = new bw();
        this.agf.a(getMyPostResIdl.data.thread_info);
        blQ();
    }

    private void blQ() {
        if (this.agf != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.agf.getFid());
            String bfC = this.agf.bfC();
            String title = this.agf.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.agf.getAbstract();
            }
            String tid = this.agf.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.agf);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.agf.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.readCount = 0L;
            shareItem.eGA = str2;
            shareItem.linkUrl = str;
            shareItem.egT = 5;
            shareItem.eGv = this.hxg;
            shareItem.extData = tid;
            shareItem.eGD = 3;
            shareItem.fid = valueOf;
            shareItem.fName = bfC;
            shareItem.tid = tid;
            shareItem.eGp = true;
            shareItem.eGC = getShareObjSource();
            shareItem.eGH = getStateThreadType(this.agf);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.eGK = OriginalThreadInfo.ShareInfo.generateShareInfo(this.agf);
            shareItem.eGL = ShareItem.ForwardInfo.generateForwardInfo(this.agf);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.eGR = this.agf.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eGD);
            bundle.putInt("obj_type", shareItem.eGH);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.egT);
            shareItem.ae(bundle);
            f.cgr().b(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
        }
    }

    private int getShareObjSource() {
        return 15;
    }

    private String getShareImageUrl(bw bwVar) {
        if (bwVar == null || bwVar.bfH() == null) {
            return null;
        }
        ArrayList<MediaData> bfH = bwVar.bfH();
        int size = bfH.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = bfH.get(i);
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

    private int getStateThreadType(bw bwVar) {
        if (bwVar != null) {
            if (bwVar.bfA()) {
                return 4;
            }
            if (bwVar.bfv() == 1) {
                return 3;
            }
            return bwVar.bgQ() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.hxa != null) {
            this.hxa.onDestroy();
        }
    }
}
