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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.play.aj;
import com.baidu.tieba.play.u;
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public class j implements u {
    private bj aRF;
    private y aRY;
    private aj aRZ;
    private a aSq;
    private com.baidu.tbadk.core.data.c buQ;
    private String buR;
    private String mForumName;
    private boolean aRX = false;
    private y.a aSb = new k(this);

    public j(a aVar) {
        this.aSq = aVar;
        if (this.aSq != null) {
            this.aRY = new y();
            this.aRY.setPlayer(this.aSq.KG());
            this.aRY.a(this.aSb);
            if (this.aSq.KG() != null) {
                this.aRZ = new aj(this.aSq.KG().getContext());
                this.aSq.KG().setBusiness(this.aRZ);
            }
        }
    }

    public void a(bj bjVar, String str, String str2, boolean z) {
        this.buR = str2;
        this.mForumName = str;
        if (bjVar != null) {
            this.aRF = bjVar;
            if (this.aSq != null && this.aRF.si() != null) {
                this.buQ = this.aRF.si();
                this.aSq.gx(this.buQ.cover);
                if (this.aRZ != null && this.aRZ.aXS() != null) {
                    this.aRZ.aXS().a(this.buQ);
                }
                if (z) {
                    this.aSq.setTitle(this.aRF.getTitle());
                } else {
                    this.aSq.setTitle("");
                }
            }
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.aRF != null && this.buQ != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            if (this.aRF.rH() != null) {
                str = this.aRF.rH();
            }
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (this.aRF.rV().equals(this.mForumName)) {
                    TiebaStatic.log(new as("c11843").Z(SapiAccountManager.SESSION_UID, currentAccount).g("fid", this.aRF.getFid()));
                } else {
                    TiebaStatic.log(new as("c11845").Z(SapiAccountManager.SESSION_UID, currentAccount).g("fid", this.aRF.getFid()));
                }
            }
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && this.aRF.getAuthor() != null) {
                z = TextUtils.equals(this.aRF.getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.setLiveID(this.buQ.live_id);
            alaLiveInfoCoreData.setGroupID(this.buQ.group_id);
            alaLiveInfoCoreData.setHslUrl(this.buQ.hls_url);
            alaLiveInfoCoreData.setLiveCover(this.buQ.cover);
            alaLiveInfoCoreData.setLiveTitle(this.buQ.description);
            alaLiveInfoCoreData.setRtmpUrl(this.buQ.rtmp_url);
            alaLiveInfoCoreData.setSessionID(this.buQ.session_id);
            if (this.buQ.Ug != null) {
                alaLiveInfoCoreData.setUserName(this.buQ.Ug.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, "", z)));
        }
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlayStarted() {
        return this.aRX;
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
        if (this.aSq != null && this.aSq.KG() != null) {
            this.aSq.KG().stopPlayback();
            this.aSq.KH();
            if (this.aRY != null) {
                this.aRY.stop();
            }
        }
        this.aRX = false;
    }

    @Override // com.baidu.tieba.play.u
    public View getVideoContainer() {
        if (this.aSq != null) {
            return this.aSq.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.u
    public String getPlayUrl() {
        if (this.aRF == null || this.aRF.sh() == null) {
            return null;
        }
        return this.aRF.sh().video_url;
    }

    @Override // com.baidu.tieba.play.u
    public int getCurrentPosition() {
        if (this.aSq == null || this.aSq.KG() == null) {
            return 0;
        }
        return this.aSq.KG().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kg() {
        if (this.aRF == null || this.aRF.sh() == null) {
        }
    }
}
