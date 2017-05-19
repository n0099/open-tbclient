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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.play.aj;
import com.baidu.tieba.play.u;
import com.baidu.tieba.play.y;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j implements u {
    private y aSL;
    private aj aSM;
    private bk aSs;
    private a aTd;
    private com.baidu.tbadk.core.data.c bwX;
    private String bwY;
    private String mForumName;
    private boolean aSK = false;
    private y.a aSO = new k(this);

    public j(a aVar) {
        this.aTd = aVar;
        if (this.aTd != null) {
            this.aSL = new y();
            this.aSL.setPlayer(this.aTd.Ku());
            this.aSL.a(this.aSO);
            if (this.aTd.Ku() != null) {
                this.aSM = new aj(this.aTd.Ku().getContext());
                this.aTd.Ku().setBusiness(this.aSM);
            }
        }
    }

    public void a(bk bkVar, String str, String str2, boolean z) {
        this.bwY = str2;
        this.mForumName = str;
        if (bkVar != null) {
            this.aSs = bkVar;
            if (this.aTd != null && this.aSs.rQ() != null) {
                this.bwX = this.aSs.rQ();
                this.aTd.gB(this.bwX.cover);
                if (this.aSM != null && this.aSM.aWB() != null) {
                    this.aSM.aWB().a(this.bwX);
                }
                if (z) {
                    this.aTd.setTitle(this.aSs.getTitle());
                } else {
                    this.aTd.setTitle("");
                }
            }
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.aSs != null && this.bwX != null) {
            if (!com.baidu.adp.lib.util.i.hk()) {
                com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), w.l.no_network_guide);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            if (this.aSs.rp() != null) {
                str = this.aSs.rp();
            }
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (this.aSs.rD().equals(this.mForumName)) {
                    TiebaStatic.log(new as("c11843").aa(SapiAccountManager.SESSION_UID, currentAccount).g("fid", this.aSs.getFid()));
                } else {
                    TiebaStatic.log(new as("c11845").aa(SapiAccountManager.SESSION_UID, currentAccount).g("fid", this.aSs.getFid()));
                }
            }
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && this.aSs.getAuthor() != null) {
                z = TextUtils.equals(this.aSs.getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.setLiveID(this.bwX.live_id);
            alaLiveInfoCoreData.setGroupID(this.bwX.group_id);
            alaLiveInfoCoreData.setHslUrl(this.bwX.hls_url);
            alaLiveInfoCoreData.setLiveCover(this.bwX.cover);
            alaLiveInfoCoreData.setLiveTitle(this.bwX.description);
            alaLiveInfoCoreData.setRtmpUrl(this.bwX.rtmp_url);
            alaLiveInfoCoreData.setSessionID(this.bwX.session_id);
            if (this.bwX.TU != null) {
                alaLiveInfoCoreData.setUserName(this.bwX.TU.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlayStarted() {
        return this.aSK;
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
        if (this.aTd != null && this.aTd.Ku() != null) {
            this.aTd.Ku().stopPlayback();
            this.aTd.Kv();
            if (this.aSL != null) {
                this.aSL.stop();
            }
        }
        this.aSK = false;
    }

    @Override // com.baidu.tieba.play.u
    public View getVideoContainer() {
        if (this.aTd != null) {
            return this.aTd.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.u
    public String getPlayUrl() {
        if (this.aSs == null || this.aSs.rP() == null) {
            return null;
        }
        return this.aSs.rP().video_url;
    }

    @Override // com.baidu.tieba.play.u
    public int getCurrentPosition() {
        if (this.aTd == null || this.aTd.Ku() == null) {
            return 0;
        }
        return this.aTd.Ku().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JU() {
        if (this.aSs == null || this.aSs.rP() == null) {
        }
    }
}
