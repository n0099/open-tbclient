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
    bw agx;
    private NavigationBarCoverTip hYs;
    private ShadowLinearLayout hYt;
    private TextView hYu;
    private TextView hYv;
    private TBSpecificationBtn hYw;
    private com.baidu.tbadk.core.view.a hYx;
    private Activity mActivity;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;
    private boolean hYy = false;
    private boolean hYz = false;
    private final com.baidu.adp.framework.listener.a hYA = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.h.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            h.this.ceD();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                h.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                h.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };

    public h(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.hYs = navigationBarCoverTip;
        this.hYA.setTag(tbPageContext.getUniqueId());
        this.hYA.getHttpMessageListener().setSelfListener(true);
        this.hYA.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.hYA);
    }

    public void oA(boolean z) {
        this.hYy = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.hYs != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.hYz = false;
                if (this.hYt == null) {
                    this.hYt = (ShadowLinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
                    this.hYu = (TextView) this.hYt.findViewById(R.id.tb_top_toast_title);
                    this.hYv = (TextView) this.hYt.findViewById(R.id.tb_top_toast_content);
                    this.hYw = (TBSpecificationBtn) this.hYt.findViewById(R.id.tb_top_toast_btn);
                    this.hYu.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_title));
                    this.hYv.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_content));
                    this.hYw.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
                    this.hYw.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
                }
                ap.setViewTextColor(this.hYu, R.color.cp_link_tip_a);
                ap.setViewTextColor(this.hYv, R.color.cp_link_tip_a);
                this.hYw.bqd();
                this.hYt.onChangeSkinType();
                this.hYw.setOnClickListener(this);
                this.hYs.setBackgroundColor(0);
                this.hYs.a(this.mActivity, this.hYt, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.hYx == null) {
            this.hYx = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.hYx.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceD() {
        if (this.hYx != null) {
            this.hYx.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.hYz) {
            this.hYz = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.hYs.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = au.boO().boP() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.hYs.hideTip();
            bqr();
        }
    }

    private void bqr() {
        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        aqVar.w("tid", this.threadId);
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.aj("obj_locate", 7);
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.agx = new bw();
        this.agx.a(getMyPostResIdl.data.thread_info);
        bqt();
    }

    private void bqt() {
        if (this.agx != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.agx.getFid());
            String bke = this.agx.bke();
            String title = this.agx.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.agx.getAbstract();
            }
            String tid = this.agx.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.agx);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.agx.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.readCount = 0L;
            shareItem.fbd = str2;
            shareItem.linkUrl = str;
            shareItem.eBz = 5;
            shareItem.faY = this.hYy;
            shareItem.extData = tid;
            shareItem.fbg = 3;
            shareItem.fid = valueOf;
            shareItem.fName = bke;
            shareItem.tid = tid;
            shareItem.faS = true;
            shareItem.fbf = getShareObjSource();
            shareItem.fbk = getStateThreadType(this.agx);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.fbn = OriginalThreadInfo.ShareInfo.generateShareInfo(this.agx);
            shareItem.fbo = ShareItem.ForwardInfo.generateForwardInfo(this.agx);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.fbu = this.agx.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fbg);
            bundle.putInt("obj_type", shareItem.fbk);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eBz);
            shareItem.ae(bundle);
            f.cmU().b(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
        }
    }

    private int getShareObjSource() {
        return 15;
    }

    private String getShareImageUrl(bw bwVar) {
        if (bwVar == null || bwVar.bkj() == null) {
            return null;
        }
        ArrayList<MediaData> bkj = bwVar.bkj();
        int size = bkj.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = bkj.get(i);
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
            if (bwVar.bkc()) {
                return 4;
            }
            if (bwVar.bjX() == 1) {
                return 3;
            }
            return bwVar.bls() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.hYs != null) {
            this.hYs.onDestroy();
        }
    }
}
