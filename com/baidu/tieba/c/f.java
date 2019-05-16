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
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
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
    bg VK;
    private NavigationBarCoverTip eHr;
    private View eHs;
    private TextView eHt;
    private TextView eHu;
    private com.baidu.tbadk.core.view.b eHv;
    private boolean eHw = false;
    private boolean eHx = false;
    private final com.baidu.adp.framework.listener.a eHy = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.c.f.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            f.this.aSD();
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
        this.eHr = navigationBarCoverTip;
        this.eHy.setTag(tbPageContext.getUniqueId());
        this.eHy.getHttpMessageListener().setSelfListener(true);
        this.eHy.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.eHy);
    }

    public void iJ(boolean z) {
        this.eHw = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.eHr != null) {
            this.postId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.eHx = false;
                if (this.eHs == null) {
                    this.eHs = View.inflate(this.mActivity, R.layout.write_thread_share_guide, null);
                    this.eHt = (TextView) this.eHs.findViewById(R.id.write_thread_success_tips);
                    this.eHu = (TextView) this.eHs.findViewById(R.id.share_icon);
                }
                al.j(this.eHt, R.color.cp_btn_a);
                al.j(this.eHu, R.color.cp_btn_a);
                al.k(this.eHu, R.drawable.share_now_bg);
                al.l(this.eHr, R.color.cp_link_tip_a_alpha95);
                this.eHu.setOnClickListener(this);
                this.eHr.a(this.mActivity, this.eHs, UIMsg.m_AppUI.MSG_APP_GPS);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.eHv == null) {
            this.eHv = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.eHv.ef(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSD() {
        if (this.eHv != null) {
            this.eHv.ef(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.eHx) {
            this.eHx = true;
            if (!j.jS()) {
                this.mPageContext.showToast(R.string.neterror);
                this.eHr.hideTip();
                return;
            }
            int af = l.af(TbadkCoreApplication.getInst());
            int ah = l.ah(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = ar.ail().ain() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, af, ah, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.eHr.hideTip();
            ajR();
        }
    }

    private void ajR() {
        am amVar = new am("c12386");
        amVar.l("tid", this.threadId);
        amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.P("obj_locate", 7);
        if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(amVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.VK = new bg();
        this.VK.a(getMyPostResIdl.data.thread_info);
        ajT();
    }

    private void ajT() {
        if (this.VK != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.VK.getFid());
            String adA = this.VK.adA();
            String title = this.VK.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.VK.getAbstract();
            }
            String tid = this.VK.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String r = r(this.VK);
            Uri parse = r == null ? null : Uri.parse(r);
            String str2 = this.VK.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = title;
            eVar.content = format;
            eVar.cjC = str2;
            eVar.linkUrl = str;
            eVar.bLs = 5;
            eVar.cjt = this.eHw;
            eVar.extData = tid;
            eVar.cjF = 3;
            eVar.fid = valueOf;
            eVar.cjw = adA;
            eVar.tid = tid;
            eVar.cjp = true;
            eVar.cjE = getShareObjSource();
            eVar.cjJ = s(this.VK);
            if (parse != null) {
                eVar.imageUri = parse;
            }
            eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.VK);
            TbadkCoreApplication.getInst().setShareItem(eVar);
            eVar.cjT = this.VK.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", eVar.cjF);
            bundle.putInt("obj_type", eVar.cjJ);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bLs);
            eVar.E(bundle);
            e.aZz().a(new ShareDialogConfig((Context) this.mActivity, eVar, true, true));
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String r(bg bgVar) {
        if (bgVar == null || bgVar.adF() == null) {
            return null;
        }
        ArrayList<MediaData> adF = bgVar.adF();
        int size = adF.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = adF.get(i);
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

    private int s(bg bgVar) {
        if (bgVar != null) {
            if (bgVar.adx()) {
                return 4;
            }
            if (bgVar.ads() == 1) {
                return 3;
            }
            return bgVar.aeH() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.eHr != null) {
            this.eHr.onDestroy();
        }
    }
}
