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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.play.aj;
import com.baidu.tieba.play.u;
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public class j implements u {
    private bh aLS;
    private a aMD;
    private y aMl;
    private aj aMm;
    private com.baidu.tbadk.core.data.d bnU;
    private String bnV;
    private String mForumName;
    private boolean aMk = false;
    private y.a aMo = new k(this);

    public j(a aVar) {
        this.aMD = aVar;
        if (this.aMD != null) {
            this.aMl = new y();
            this.aMl.setPlayer(this.aMD.Kb());
            this.aMl.a(this.aMo);
            if (this.aMD.Kb() != null) {
                this.aMm = new aj(this.aMD.Kb().getContext());
                this.aMD.Kb().setBusiness(this.aMm);
            }
        }
    }

    public void a(bh bhVar, String str, String str2, boolean z) {
        this.bnV = str2;
        this.mForumName = str;
        if (bhVar != null) {
            this.aLS = bhVar;
            if (this.aMD != null && this.aLS.rO() != null) {
                this.bnU = this.aLS.rO();
                this.aMD.gI(this.bnU.cover);
                if (this.aMm != null && this.aMm.aYn() != null) {
                    this.aMm.aYn().a(this.bnU);
                }
                if (z) {
                    this.aMD.setTitle(this.aLS.getTitle());
                } else {
                    this.aMD.setTitle("");
                }
            }
        }
    }

    public void j(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.aLS != null && this.bnU != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            if (!TextUtils.isEmpty(this.mForumName)) {
                if (this.aLS.rB().equals(this.mForumName)) {
                    TiebaStatic.log(new ar("c11843").ab(SapiAccountManager.SESSION_UID, currentAccount).g("fid", this.aLS.getFid()));
                } else {
                    TiebaStatic.log(new ar("c11845").ab(SapiAccountManager.SESSION_UID, currentAccount).g("fid", this.aLS.getFid()));
                }
                str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY;
            }
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && this.aLS.getAuthor() != null) {
                z = TextUtils.equals(this.aLS.getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.setLiveID(this.bnU.live_id);
            alaLiveInfoCoreData.setGroupID(this.bnU.group_id);
            alaLiveInfoCoreData.setHslUrl(this.bnU.hls_url);
            alaLiveInfoCoreData.setLiveCover(this.bnU.cover);
            alaLiveInfoCoreData.setLiveTitle(this.bnU.description);
            alaLiveInfoCoreData.setRtmpUrl(this.bnU.rtmp_url);
            alaLiveInfoCoreData.setSessionID(this.bnU.session_id);
            if (this.bnU.Pe != null) {
                alaLiveInfoCoreData.setUserName(this.bnU.Pe.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, "", z)));
        }
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlayStarted() {
        return this.aMk;
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
        if (this.aMD != null && this.aMD.Kb() != null) {
            this.aMD.Kb().stopPlayback();
            this.aMD.Kc();
            if (this.aMl != null) {
                this.aMl.stop();
            }
        }
        this.aMk = false;
    }

    @Override // com.baidu.tieba.play.u
    public View getVideoContainer() {
        if (this.aMD != null) {
            return this.aMD.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.u
    public String getPlayUrl() {
        if (this.aLS == null || this.aLS.rN() == null) {
            return null;
        }
        return this.aLS.rN().video_url;
    }

    @Override // com.baidu.tieba.play.u
    public int getCurrentPosition() {
        if (this.aMD == null || this.aMD.Kb() == null) {
            return 0;
        }
        return this.aMD.Kb().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JB() {
        if (this.aLS == null || this.aLS.rN() == null) {
        }
    }
}
