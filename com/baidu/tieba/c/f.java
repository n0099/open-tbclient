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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
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
public class f implements View.OnClickListener {
    bh Fs;
    private NavigationBarCoverTip eVC;
    private View eVD;
    private TextView eVE;
    private TextView eVF;
    private com.baidu.tbadk.core.view.b eVG;
    private boolean eVH = false;
    private boolean eVI = false;
    private final com.baidu.adp.framework.listener.a eVJ = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.f.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            f.this.aVU();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                f.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                f.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private Activity mActivity;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;

    public f(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.eVC = navigationBarCoverTip;
        this.eVJ.setTag(tbPageContext.getUniqueId());
        this.eVJ.getHttpMessageListener().setSelfListener(true);
        this.eVJ.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.eVJ);
    }

    public void iY(boolean z) {
        this.eVH = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.eVC != null) {
            this.postId = com.baidu.adp.lib.g.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.eVI = false;
                if (this.eVD == null) {
                    this.eVD = View.inflate(this.mActivity, R.layout.write_thread_share_guide, null);
                    this.eVE = (TextView) this.eVD.findViewById(R.id.write_thread_success_tips);
                    this.eVF = (TextView) this.eVD.findViewById(R.id.share_icon);
                }
                am.setViewTextColor(this.eVE, (int) R.color.cp_cont_a);
                am.setViewTextColor(this.eVF, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.eVF, R.drawable.share_now_bg);
                am.setBackgroundColor(this.eVC, R.color.cp_link_tip_a_alpha95);
                this.eVF.setOnClickListener(this);
                this.eVC.a(this.mActivity, this.eVD, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.eVG == null) {
            this.eVG = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.eVG.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVU() {
        if (this.eVG != null) {
            this.eVG.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.eVI) {
            this.eVI = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.eVC.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = ar.amM().isFrsShowBigImage() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.eVC.hideTip();
            anW();
        }
    }

    private void anW() {
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        anVar.p("tid", this.threadId);
        anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.O("obj_locate", 7);
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.bS("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.Fs = new bh();
        this.Fs.a(getMyPostResIdl.data.thread_info);
        anY();
    }

    private void anY() {
        if (this.Fs != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.Fs.getFid());
            String aiJ = this.Fs.aiJ();
            String title = this.Fs.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.Fs.getAbstract();
            }
            String tid = this.Fs.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String t = t(this.Fs);
            Uri parse = t == null ? null : Uri.parse(t);
            String str2 = this.Fs.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = title;
            eVar.content = format;
            eVar.cxT = str2;
            eVar.linkUrl = str;
            eVar.cdP = 5;
            eVar.cxK = this.eVH;
            eVar.extData = tid;
            eVar.cxW = 3;
            eVar.fid = valueOf;
            eVar.cxN = aiJ;
            eVar.tid = tid;
            eVar.cxG = true;
            eVar.cxV = getShareObjSource();
            eVar.cya = u(this.Fs);
            if (parse != null) {
                eVar.imageUri = parse;
            }
            eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.Fs);
            TbadkCoreApplication.getInst().setShareItem(eVar);
            eVar.cyk = this.Fs.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", eVar.cxW);
            bundle.putInt("obj_type", eVar.cya);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt("obj_source", eVar.cdP);
            eVar.E(bundle);
            e.bch().a(new ShareDialogConfig((Context) this.mActivity, eVar, true, true));
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String t(bh bhVar) {
        if (bhVar == null || bhVar.aiO() == null) {
            return null;
        }
        ArrayList<MediaData> aiO = bhVar.aiO();
        int size = aiO.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aiO.get(i);
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

    private int u(bh bhVar) {
        if (bhVar != null) {
            if (bhVar.aiG()) {
                return 4;
            }
            if (bhVar.aiB() == 1) {
                return 3;
            }
            return bhVar.ajP() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.eVC != null) {
            this.eVC.onDestroy();
        }
    }
}
