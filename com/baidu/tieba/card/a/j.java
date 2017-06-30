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
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.play.ak;
import com.baidu.tieba.play.u;
import com.baidu.tieba.play.y;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j implements u {
    private y bBJ;
    private ak bBw;
    private com.baidu.tbadk.core.data.c bDN;
    private String bDO;
    private bm bdI;
    private a bgD;
    private String mForumName;
    private boolean bBH = false;
    private y.a bBS = new k(this);

    public j(a aVar) {
        this.bgD = aVar;
        if (this.bgD != null) {
            this.bBJ = new y();
            this.bBJ.setPlayer(this.bgD.VP());
            this.bBJ.a(this.bBS);
            if (this.bgD.VP() != null) {
                this.bBw = new ak(this.bgD.VP().getContext());
                this.bgD.VP().setBusiness(this.bBw);
            }
        }
    }

    public void a(bm bmVar, String str, String str2, boolean z) {
        this.bDO = str2;
        this.mForumName = str;
        if (bmVar != null) {
            this.bdI = bmVar;
            if (this.bgD != null && this.bdI.rJ() != null) {
                this.bDN = this.bdI.rJ();
                this.bgD.iM(this.bDN.cover);
                if (this.bBw != null && this.bBw.bcd() != null) {
                    this.bBw.bcd().a(this.bDN);
                }
                if (z) {
                    this.bgD.setTitle(this.bdI.getTitle());
                } else {
                    this.bgD.setTitle("");
                }
            }
        }
    }

    public void h(TbPageContext<?> tbPageContext) {
        if (tbPageContext != null && this.bdI != null && this.bDN != null) {
            if (!com.baidu.adp.lib.util.i.hj()) {
                com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), w.l.no_network_guide);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            if (this.bdI.ri() != null) {
                str = this.bdI.ri();
            }
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (this.bdI.rw().equals(this.mForumName)) {
                    TiebaStatic.log(new au("c11843").Z(SapiAccountManager.SESSION_UID, currentAccount).f("fid", this.bdI.getFid()));
                } else {
                    TiebaStatic.log(new au("c11845").Z(SapiAccountManager.SESSION_UID, currentAccount).f("fid", this.bdI.getFid()));
                }
            }
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && this.bdI.getAuthor() != null) {
                z = TextUtils.equals(this.bdI.getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bDN);
            if (this.bDN.TB != null) {
                alaLiveInfoCoreData.setUserName(this.bDN.TB.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    @Override // com.baidu.tieba.play.u
    public boolean isPlayStarted() {
        return this.bBH;
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
        if (this.bgD != null && this.bgD.VP() != null) {
            this.bgD.VP().stopPlayback();
            this.bgD.VQ();
            if (this.bBJ != null) {
                this.bBJ.stop();
            }
        }
        this.bBH = false;
    }

    @Override // com.baidu.tieba.play.u
    public View getVideoContainer() {
        if (this.bgD != null) {
            return this.bgD.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.u
    public String getPlayUrl() {
        if (this.bdI == null || this.bdI.rI() == null) {
            return null;
        }
        return this.bdI.rI().video_url;
    }

    @Override // com.baidu.tieba.play.u
    public int getCurrentPosition() {
        if (this.bgD == null || this.bgD.VP() == null) {
            return 0;
        }
        return this.bgD.VP().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VR() {
        if (this.bdI == null || this.bdI.rI() == null) {
        }
    }
}
