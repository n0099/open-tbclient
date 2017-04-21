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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.play.aj;
import com.baidu.tieba.play.u;
import com.baidu.tieba.play.y;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j implements u {
    private bi aRX;
    private a aSI;
    private y aSq;
    private aj aSr;
    private com.baidu.tbadk.core.data.c bwZ;
    private String bxa;
    private String mForumName;
    private boolean aSp = false;
    private y.a aSt = new k(this);

    public j(a aVar) {
        this.aSI = aVar;
        if (this.aSI != null) {
            this.aSq = new y();
            this.aSq.setPlayer(this.aSI.Lg());
            this.aSq.a(this.aSt);
            if (this.aSI.Lg() != null) {
                this.aSr = new aj(this.aSI.Lg().getContext());
                this.aSI.Lg().setBusiness(this.aSr);
            }
        }
    }

    public void a(bi biVar, String str, String str2, boolean z) {
        this.bxa = str2;
        this.mForumName = str;
        if (biVar != null) {
            this.aRX = biVar;
            if (this.aSI != null && this.aRX.sG() != null) {
                this.bwZ = this.aRX.sG();
                this.aSI.gD(this.bwZ.cover);
                if (this.aSr != null && this.aSr.aZc() != null) {
                    this.aSr.aZc().a(this.bwZ);
                }
                if (z) {
                    this.aSI.setTitle(this.aRX.getTitle());
                } else {
                    this.aSI.setTitle("");
                }
            }
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.aRX != null && this.bwZ != null) {
            if (!com.baidu.adp.lib.util.i.hk()) {
                com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), w.l.no_network_guide);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            if (this.aRX.sf() != null) {
                str = this.aRX.sf();
            }
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (this.aRX.st().equals(this.mForumName)) {
                    TiebaStatic.log(new as("c11843").aa(SapiAccountManager.SESSION_UID, currentAccount).g("fid", this.aRX.getFid()));
                } else {
                    TiebaStatic.log(new as("c11845").aa(SapiAccountManager.SESSION_UID, currentAccount).g("fid", this.aRX.getFid()));
                }
            }
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && this.aRX.getAuthor() != null) {
                z = TextUtils.equals(this.aRX.getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.setLiveID(this.bwZ.live_id);
            alaLiveInfoCoreData.setGroupID(this.bwZ.group_id);
            alaLiveInfoCoreData.setHslUrl(this.bwZ.hls_url);
            alaLiveInfoCoreData.setLiveCover(this.bwZ.cover);
            alaLiveInfoCoreData.setLiveTitle(this.bwZ.description);
            alaLiveInfoCoreData.setRtmpUrl(this.bwZ.rtmp_url);
            alaLiveInfoCoreData.setSessionID(this.bwZ.session_id);
            if (this.bwZ.UC != null) {
                alaLiveInfoCoreData.setUserName(this.bwZ.UC.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, "", z)));
        }
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlayStarted() {
        return this.aSp;
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
        if (this.aSI != null && this.aSI.Lg() != null) {
            this.aSI.Lg().stopPlayback();
            this.aSI.Lh();
            if (this.aSq != null) {
                this.aSq.stop();
            }
        }
        this.aSp = false;
    }

    @Override // com.baidu.tieba.play.u
    public View getVideoContainer() {
        if (this.aSI != null) {
            return this.aSI.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.u
    public String getPlayUrl() {
        if (this.aRX == null || this.aRX.sF() == null) {
            return null;
        }
        return this.aRX.sF().video_url;
    }

    @Override // com.baidu.tieba.play.u
    public int getCurrentPosition() {
        if (this.aSI == null || this.aSI.Lg() == null) {
            return 0;
        }
        return this.aSI.Lg().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KG() {
        if (this.aRX == null || this.aRX.sF() == null) {
        }
    }
}
