package com.baidu.tieba.card.ala;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
/* loaded from: classes.dex */
public class a implements f {
    private j bKE;
    private n bKr;
    private c bMU;
    private String bMV;
    private bh bie;
    private AlaVideoContainer bmT;
    private String mForumName;
    private boolean bKC = false;
    private j.a bKO = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void XB() {
            a.this.Xv();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.bmT = alaVideoContainer;
        if (this.bmT != null) {
            this.bKE = new j();
            this.bKE.setPlayer(this.bmT.getVideoView());
            this.bKE.a(this.bKO);
            if (this.bmT.getVideoView() != null) {
                this.bKr = new n(this.bmT.getVideoView().getContext());
                this.bmT.getVideoView().setBusiness(this.bKr);
            }
        }
    }

    public void a(bh bhVar, String str, String str2, boolean z) {
        this.bMV = str2;
        this.mForumName = str;
        if (bhVar != null) {
            this.bie = bhVar;
            if (this.bmT != null && this.bie.rG() != null) {
                this.bMU = this.bie.rG();
                this.bmT.setVideoThumbnail(this.bMU.cover);
                if (this.bKr != null && this.bKr.ben() != null) {
                    this.bKr.ben().b(this.bMU);
                }
                if (z) {
                    this.bmT.setTitle(this.bie.getTitle());
                } else {
                    this.bmT.setTitle("");
                }
                this.bmT.setPlayCount(String.format(this.bmT.getVideoView().getContext().getResources().getString(d.l.ala_audience_count_prefix), am.A(this.bie.rG().audience_count)));
            }
        }
    }

    public void bn(Context context) {
        if (context != null && this.bie != null && this.bMU != null) {
            if (!com.baidu.adp.lib.util.j.hh()) {
                l.showToast(context, d.l.no_network_guide);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            if (this.bie.rf() != null) {
                str = this.bie.rf();
            }
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (this.bie.rt().equals(this.mForumName)) {
                    TiebaStatic.log(new ak("c11843").ac(SapiAccountManager.SESSION_UID, currentAccount).f("fid", this.bie.getFid()));
                } else {
                    TiebaStatic.log(new ak("c11845").ac(SapiAccountManager.SESSION_UID, currentAccount).f("fid", this.bie.getFid()));
                }
            }
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && this.bie.getAuthor() != null) {
                z = TextUtils.equals(this.bie.getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bMU);
            if (this.bMU.Uw != null) {
                alaLiveInfoCoreData.setUserName(this.bMU.Uw.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.bKC;
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlaying() {
        return false;
    }

    @Override // com.baidu.tieba.play.f
    public void startPlay() {
    }

    @Override // com.baidu.tieba.play.f
    public void stopPlay() {
        if (this.bmT != null && this.bmT.getVideoView() != null) {
            this.bmT.getVideoView().stopPlayback();
            this.bmT.XO();
            if (this.bKE != null) {
                this.bKE.stop();
            }
        }
        this.bKC = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.bmT != null) {
            return this.bmT.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bie == null || this.bie.rF() == null) {
            return null;
        }
        return this.bie.rF().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.bmT == null || this.bmT.getVideoView() == null) {
            return 0;
        }
        return this.bmT.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xv() {
        if (this.bie == null || this.bie.rF() == null) {
        }
    }

    public void XP() {
        if (this.bmT != null) {
            this.bmT.XP();
        }
    }
}
