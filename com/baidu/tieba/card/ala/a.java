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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
    private n bSk;
    private j bSx;
    private c bUL;
    private String bUM;
    private bh biZ;
    private AlaVideoContainer boK;
    private String mForumName;
    private boolean bSv = false;
    private j.a bSI = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void ZX() {
            a.this.ZR();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.boK = alaVideoContainer;
        if (this.boK != null) {
            this.bSx = new j();
            this.bSx.setPlayer(this.boK.getVideoView());
            this.bSx.a(this.bSI);
            if (this.boK.getVideoView() != null) {
                this.bSk = new n(this.boK.getVideoView().getContext());
                this.boK.getVideoView().setBusiness(this.bSk);
            }
        }
    }

    public void a(bh bhVar, String str, String str2, boolean z) {
        this.bUM = str2;
        this.mForumName = str;
        if (bhVar != null) {
            this.biZ = bhVar;
            if (this.boK != null && this.biZ.rM() != null) {
                this.bUL = this.biZ.rM();
                this.boK.setVideoThumbnail(this.bUL.cover);
                if (this.bSk != null && this.bSk.bhG() != null) {
                    this.bSk.bhG().b(this.bUL);
                }
                if (z) {
                    this.boK.setTitle(this.biZ.getTitle());
                } else {
                    this.boK.setTitle("");
                }
                this.boK.setPlayCount(String.format(this.boK.getVideoView().getContext().getResources().getString(d.j.ala_audience_count_prefix), am.A(this.biZ.rM().audience_count)));
            }
        }
    }

    public void bn(Context context) {
        if (context != null && this.biZ != null && this.bUL != null) {
            if (!com.baidu.adp.lib.util.j.hh()) {
                l.showToast(context, d.j.no_network_guide);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            if (this.biZ.rj() != null) {
                str = this.biZ.rj();
            }
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (this.biZ.rz().equals(this.mForumName)) {
                    TiebaStatic.log(new ak("c11843").ac(SapiAccountManager.SESSION_UID, currentAccount).f(ImageViewerConfig.FORUM_ID, this.biZ.getFid()));
                } else {
                    TiebaStatic.log(new ak("c11845").ac(SapiAccountManager.SESSION_UID, currentAccount).f(ImageViewerConfig.FORUM_ID, this.biZ.getFid()));
                }
            }
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && this.biZ.rt() != null) {
                z = TextUtils.equals(this.biZ.rt().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bUL);
            if (this.bUL.UQ != null) {
                alaLiveInfoCoreData.userName = this.bUL.UQ.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.bSv;
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
        if (this.boK != null && this.boK.getVideoView() != null) {
            this.boK.getVideoView().stopPlayback();
            this.boK.aak();
            if (this.bSx != null) {
                this.bSx.stop();
            }
        }
        this.bSv = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.boK != null) {
            return this.boK.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.biZ == null || this.biZ.rL() == null) {
            return null;
        }
        return this.biZ.rL().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.boK == null || this.boK.getVideoView() == null) {
            return 0;
        }
        return this.boK.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZR() {
        if (this.biZ == null || this.biZ.rL() == null) {
        }
    }

    public void aal() {
        if (this.boK != null) {
            this.boK.aal();
        }
    }
}
