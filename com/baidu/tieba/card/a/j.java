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
/* loaded from: classes.dex */
public class j implements u {
    private bi aRV;
    private a aSG;
    private y aSo;
    private aj aSp;
    private com.baidu.tbadk.core.data.c buI;
    private String buJ;
    private String mForumName;
    private boolean aSn = false;
    private y.a aSr = new k(this);

    public j(a aVar) {
        this.aSG = aVar;
        if (this.aSG != null) {
            this.aSo = new y();
            this.aSo.setPlayer(this.aSG.Lg());
            this.aSo.a(this.aSr);
            if (this.aSG.Lg() != null) {
                this.aSp = new aj(this.aSG.Lg().getContext());
                this.aSG.Lg().setBusiness(this.aSp);
            }
        }
    }

    public void a(bi biVar, String str, String str2, boolean z) {
        this.buJ = str2;
        this.mForumName = str;
        if (biVar != null) {
            this.aRV = biVar;
            if (this.aSG != null && this.aRV.sG() != null) {
                this.buI = this.aRV.sG();
                this.aSG.gD(this.buI.cover);
                if (this.aSp != null && this.aSp.aYb() != null) {
                    this.aSp.aYb().a(this.buI);
                }
                if (z) {
                    this.aSG.setTitle(this.aRV.getTitle());
                } else {
                    this.aSG.setTitle("");
                }
            }
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.aRV != null && this.buI != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            if (this.aRV.sf() != null) {
                str = this.aRV.sf();
            }
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (this.aRV.st().equals(this.mForumName)) {
                    TiebaStatic.log(new as("c11843").aa(SapiAccountManager.SESSION_UID, currentAccount).g("fid", this.aRV.getFid()));
                } else {
                    TiebaStatic.log(new as("c11845").aa(SapiAccountManager.SESSION_UID, currentAccount).g("fid", this.aRV.getFid()));
                }
            }
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && this.aRV.getAuthor() != null) {
                z = TextUtils.equals(this.aRV.getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.setLiveID(this.buI.live_id);
            alaLiveInfoCoreData.setGroupID(this.buI.group_id);
            alaLiveInfoCoreData.setHslUrl(this.buI.hls_url);
            alaLiveInfoCoreData.setLiveCover(this.buI.cover);
            alaLiveInfoCoreData.setLiveTitle(this.buI.description);
            alaLiveInfoCoreData.setRtmpUrl(this.buI.rtmp_url);
            alaLiveInfoCoreData.setSessionID(this.buI.session_id);
            if (this.buI.Uz != null) {
                alaLiveInfoCoreData.setUserName(this.buI.Uz.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, "", z)));
        }
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlayStarted() {
        return this.aSn;
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
        if (this.aSG != null && this.aSG.Lg() != null) {
            this.aSG.Lg().stopPlayback();
            this.aSG.Lh();
            if (this.aSo != null) {
                this.aSo.stop();
            }
        }
        this.aSn = false;
    }

    @Override // com.baidu.tieba.play.u
    public View getVideoContainer() {
        if (this.aSG != null) {
            return this.aSG.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.u
    public String getPlayUrl() {
        if (this.aRV == null || this.aRV.sF() == null) {
            return null;
        }
        return this.aRV.sF().video_url;
    }

    @Override // com.baidu.tieba.play.u
    public int getCurrentPosition() {
        if (this.aSG == null || this.aSG.Lg() == null) {
            return 0;
        }
        return this.aSG.Lg().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KG() {
        if (this.aRV == null || this.aRV.sF() == null) {
        }
    }
}
