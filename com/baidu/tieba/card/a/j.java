package com.baidu.tieba.card.a;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.play.ak;
import com.baidu.tieba.play.u;
import com.baidu.tieba.play.y;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j implements u {
    private ak bAD;
    private y bAQ;
    private com.baidu.tbadk.core.data.c bCU;
    private String bCV;
    private bl bbF;
    private a bdG;
    private String mForumName;
    private boolean bAO = false;
    private y.a bAZ = new k(this);

    public j(a aVar) {
        this.bdG = aVar;
        if (this.bdG != null) {
            this.bAQ = new y();
            this.bAQ.setPlayer(this.bdG.Uy());
            this.bAQ.a(this.bAZ);
            if (this.bdG.Uy() != null) {
                this.bAD = new ak(this.bdG.Uy().getContext());
                this.bdG.Uy().setBusiness(this.bAD);
            }
        }
    }

    public void a(bl blVar, String str, String str2, boolean z) {
        this.bCV = str2;
        this.mForumName = str;
        if (blVar != null) {
            this.bbF = blVar;
            if (this.bdG != null && this.bbF.rM() != null) {
                this.bCU = this.bbF.rM();
                this.bdG.m13if(this.bCU.cover);
                if (this.bAD != null && this.bAD.aXS() != null) {
                    this.bAD.aXS().a(this.bCU);
                }
                if (z) {
                    this.bdG.setTitle(this.bbF.getTitle());
                } else {
                    this.bdG.setTitle("");
                }
            }
        }
    }

    public void h(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.bbF != null && this.bCU != null) {
            if (!com.baidu.adp.lib.util.i.hk()) {
                com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), w.l.no_network_guide);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            if (this.bbF.rl() != null) {
                str = this.bbF.rl();
            }
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (this.bbF.rz().equals(this.mForumName)) {
                    TiebaStatic.log(new as("c11843").Z(SapiAccountManager.SESSION_UID, currentAccount).f("fid", this.bbF.getFid()));
                } else {
                    TiebaStatic.log(new as("c11845").Z(SapiAccountManager.SESSION_UID, currentAccount).f("fid", this.bbF.getFid()));
                }
            }
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && this.bbF.getAuthor() != null) {
                z = TextUtils.equals(this.bbF.getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.setLiveID(this.bCU.live_id);
            alaLiveInfoCoreData.setGroupID(this.bCU.group_id);
            alaLiveInfoCoreData.setHslUrl(this.bCU.hls_url);
            alaLiveInfoCoreData.setLiveCover(this.bCU.cover);
            alaLiveInfoCoreData.setLiveTitle(this.bCU.description);
            alaLiveInfoCoreData.setRtmpUrl(this.bCU.rtmp_url);
            alaLiveInfoCoreData.setSessionID(this.bCU.session_id);
            if (this.bCU.TG != null) {
                alaLiveInfoCoreData.setUserName(this.bCU.TG.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlayStarted() {
        return this.bAO;
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlaying() {
        return false;
    }

    @Override // com.baidu.tieba.play.u
    public void startPlay() {
    }

    @Override // com.baidu.tieba.play.u
    public void stopPlay() {
        if (this.bdG != null && this.bdG.Uy() != null) {
            this.bdG.Uy().stopPlayback();
            this.bdG.Uz();
            if (this.bAQ != null) {
                this.bAQ.stop();
            }
        }
        this.bAO = false;
    }

    @Override // com.baidu.tieba.play.u
    public View getVideoContainer() {
        if (this.bdG != null) {
            return this.bdG.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.u
    public String getPlayUrl() {
        if (this.bbF == null || this.bbF.rL() == null) {
            return null;
        }
        return this.bbF.rL().video_url;
    }

    @Override // com.baidu.tieba.play.u
    public int getCurrentPosition() {
        if (this.bdG == null || this.bdG.Uy() == null) {
            return 0;
        }
        return this.bdG.Uy().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UA() {
        if (this.bbF == null || this.bbF.rL() == null) {
        }
    }
}
