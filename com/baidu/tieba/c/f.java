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
    bh FT;
    private NavigationBarCoverTip eWt;
    private View eWu;
    private TextView eWv;
    private TextView eWw;
    private com.baidu.tbadk.core.view.b eWx;
    private Activity mActivity;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;
    private boolean eWy = false;
    private boolean eWz = false;
    private final com.baidu.adp.framework.listener.a eWA = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.f.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            f.this.aVW();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                f.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                f.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };

    public f(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.eWt = navigationBarCoverTip;
        this.eWA.setTag(tbPageContext.getUniqueId());
        this.eWA.getHttpMessageListener().setSelfListener(true);
        this.eWA.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.eWA);
    }

    public void iY(boolean z) {
        this.eWy = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.eWt != null) {
            this.postId = com.baidu.adp.lib.g.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.eWz = false;
                if (this.eWu == null) {
                    this.eWu = View.inflate(this.mActivity, R.layout.write_thread_share_guide, null);
                    this.eWv = (TextView) this.eWu.findViewById(R.id.write_thread_success_tips);
                    this.eWw = (TextView) this.eWu.findViewById(R.id.share_icon);
                }
                am.setViewTextColor(this.eWv, (int) R.color.cp_cont_a);
                am.setViewTextColor(this.eWw, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.eWw, R.drawable.share_now_bg);
                am.setBackgroundColor(this.eWt, R.color.cp_link_tip_a_alpha95);
                this.eWw.setOnClickListener(this);
                this.eWt.a(this.mActivity, this.eWu, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.eWx == null) {
            this.eWx = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.eWx.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVW() {
        if (this.eWx != null) {
            this.eWx.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.eWz) {
            this.eWz = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.eWt.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = ar.amO().isFrsShowBigImage() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.eWt.hideTip();
            anY();
        }
    }

    private void anY() {
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
        this.FT = new bh();
        this.FT.a(getMyPostResIdl.data.thread_info);
        aoa();
    }

    private void aoa() {
        if (this.FT != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.FT.getFid());
            String aiL = this.FT.aiL();
            String title = this.FT.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.FT.getAbstract();
            }
            String tid = this.FT.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String t = t(this.FT);
            Uri parse = t == null ? null : Uri.parse(t);
            String str2 = this.FT.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = title;
            eVar.content = format;
            eVar.cyK = str2;
            eVar.linkUrl = str;
            eVar.ceG = 5;
            eVar.cyB = this.eWy;
            eVar.extData = tid;
            eVar.cyN = 3;
            eVar.fid = valueOf;
            eVar.cyE = aiL;
            eVar.tid = tid;
            eVar.cyx = true;
            eVar.cyM = getShareObjSource();
            eVar.cyR = u(this.FT);
            if (parse != null) {
                eVar.imageUri = parse;
            }
            eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.FT);
            TbadkCoreApplication.getInst().setShareItem(eVar);
            eVar.czb = this.FT.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", eVar.cyN);
            bundle.putInt("obj_type", eVar.cyR);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt("obj_source", eVar.ceG);
            eVar.E(bundle);
            e.bcj().a(new ShareDialogConfig((Context) this.mActivity, eVar, true, true));
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String t(bh bhVar) {
        if (bhVar == null || bhVar.aiQ() == null) {
            return null;
        }
        ArrayList<MediaData> aiQ = bhVar.aiQ();
        int size = aiQ.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aiQ.get(i);
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
            if (bhVar.aiI()) {
                return 4;
            }
            if (bhVar.aiD() == 1) {
                return 3;
            }
            return bhVar.ajR() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.eWt != null) {
            this.eWt.onDestroy();
        }
    }
}
