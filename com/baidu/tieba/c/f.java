package com.baidu.tieba.c;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
import com.baidu.tieba.d;
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
    bg XT;
    private NavigationBarCoverTip erL;
    private View erM;
    private TextView erN;
    private TextView erO;
    private com.baidu.tbadk.core.view.b erP;
    private boolean erQ = false;
    private boolean erR = false;
    private final com.baidu.adp.framework.listener.a erS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.c.f.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            f.this.aMt();
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
        this.erL = navigationBarCoverTip;
        this.erS.setTag(tbPageContext.getUniqueId());
        this.erS.getHttpMessageListener().setSelfListener(true);
        this.erS.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.erS);
    }

    public void ie(boolean z) {
        this.erQ = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.erL != null) {
            this.postId = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.erR = false;
                if (this.erM == null) {
                    this.erM = View.inflate(this.mActivity, d.h.write_thread_share_guide, null);
                    this.erN = (TextView) this.erM.findViewById(d.g.write_thread_success_tips);
                    this.erO = (TextView) this.erM.findViewById(d.g.share_icon);
                }
                al.j(this.erN, d.C0277d.cp_btn_a);
                al.j(this.erO, d.C0277d.cp_btn_a);
                al.k(this.erO, d.f.share_now_bg);
                al.l(this.erL, d.C0277d.cp_link_tip_a_alpha95);
                this.erO.setOnClickListener(this);
                this.erL.a(this.mActivity, this.erM, UIMsg.m_AppUI.MSG_APP_GPS);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.erP == null) {
            this.erP = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.erP.dJ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMt() {
        if (this.erP != null) {
            this.erP.dJ(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.erR) {
            this.erR = true;
            if (!j.kY()) {
                this.mPageContext.showToast(d.j.neterror);
                this.erL.hideTip();
                return;
            }
            int aO = l.aO(TbadkCoreApplication.getInst());
            int aQ = l.aQ(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = ar.adm().ado() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, aO, aQ, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.erL.hideTip();
            aeS();
        }
    }

    private void aeS() {
        am amVar = new am("c12386");
        amVar.k("tid", this.threadId);
        amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.T("obj_locate", 7);
        if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(amVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(d.j.neterror);
            return;
        }
        this.XT = new bg();
        this.XT.a(getMyPostResIdl.data.thread_info);
        aeU();
    }

    private void aeU() {
        if (this.XT != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.XT.getFid());
            String YT = this.XT.YT();
            String title = this.XT.getTitle();
            String tid = this.XT.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String r = r(this.XT);
            Uri parse = r == null ? null : Uri.parse(r);
            String str2 = this.XT.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.cbB = str2;
            dVar.linkUrl = str;
            dVar.bDZ = 5;
            dVar.cbt = this.erQ;
            dVar.extData = tid;
            dVar.cbE = 3;
            dVar.fid = valueOf;
            dVar.cbv = YT;
            dVar.tid = tid;
            dVar.cbp = true;
            dVar.cbD = getShareObjSource();
            dVar.cbI = s(this.XT);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.XT);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.cbE);
            bundle.putInt("obj_type", dVar.cbI);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.bDZ);
            dVar.D(bundle);
            e.aSr().a(new ShareDialogConfig((Context) this.mActivity, dVar, true, true));
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String r(bg bgVar) {
        if (bgVar == null || bgVar.YY() == null) {
            return null;
        }
        ArrayList<MediaData> YY = bgVar.YY();
        int size = YY.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = YY.get(i);
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
            if (bgVar.YQ()) {
                return 4;
            }
            if (bgVar.YL() == 1) {
                return 3;
            }
            return bgVar.aaa() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.erL != null) {
            this.erL.onDestroy();
        }
    }
}
