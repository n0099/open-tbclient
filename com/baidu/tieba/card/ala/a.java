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
    private n bRX;
    private j bSk;
    private c bUy;
    private String bUz;
    private bh biQ;
    private AlaVideoContainer boB;
    private String mForumName;
    private boolean bSi = false;
    private j.a bSv = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void ZL() {
            a.this.ZF();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.boB = alaVideoContainer;
        if (this.boB != null) {
            this.bSk = new j();
            this.bSk.setPlayer(this.boB.getVideoView());
            this.bSk.a(this.bSv);
            if (this.boB.getVideoView() != null) {
                this.bRX = new n(this.boB.getVideoView().getContext());
                this.boB.getVideoView().setBusiness(this.bRX);
            }
        }
    }

    public void a(bh bhVar, String str, String str2, boolean z) {
        this.bUz = str2;
        this.mForumName = str;
        if (bhVar != null) {
            this.biQ = bhVar;
            if (this.boB != null && this.biQ.rM() != null) {
                this.bUy = this.biQ.rM();
                this.boB.setVideoThumbnail(this.bUy.cover);
                if (this.bRX != null && this.bRX.bhy() != null) {
                    this.bRX.bhy().b(this.bUy);
                }
                if (z) {
                    this.boB.setTitle(this.biQ.getTitle());
                } else {
                    this.boB.setTitle("");
                }
                this.boB.setPlayCount(String.format(this.boB.getVideoView().getContext().getResources().getString(d.j.ala_audience_count_prefix), am.A(this.biQ.rM().audience_count)));
            }
        }
    }

    public void bn(Context context) {
        if (context != null && this.biQ != null && this.bUy != null) {
            if (!com.baidu.adp.lib.util.j.hh()) {
                l.showToast(context, d.j.no_network_guide);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            if (this.biQ.rj() != null) {
                str = this.biQ.rj();
            }
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (this.biQ.rz().equals(this.mForumName)) {
                    TiebaStatic.log(new ak("c11843").ac(SapiAccountManager.SESSION_UID, currentAccount).f(ImageViewerConfig.FORUM_ID, this.biQ.getFid()));
                } else {
                    TiebaStatic.log(new ak("c11845").ac(SapiAccountManager.SESSION_UID, currentAccount).f(ImageViewerConfig.FORUM_ID, this.biQ.getFid()));
                }
            }
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && this.biQ.rt() != null) {
                z = TextUtils.equals(this.biQ.rt().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bUy);
            if (this.bUy.UQ != null) {
                alaLiveInfoCoreData.userName = this.bUy.UQ.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.bSi;
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
        if (this.boB != null && this.boB.getVideoView() != null) {
            this.boB.getVideoView().stopPlayback();
            this.boB.ZY();
            if (this.bSk != null) {
                this.bSk.stop();
            }
        }
        this.bSi = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.boB != null) {
            return this.boB.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.biQ == null || this.biQ.rL() == null) {
            return null;
        }
        return this.biQ.rL().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.boB == null || this.boB.getVideoView() == null) {
            return 0;
        }
        return this.boB.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZF() {
        if (this.biQ == null || this.biQ.rL() == null) {
        }
    }

    public void ZZ() {
        if (this.boB != null) {
            this.boB.ZZ();
        }
    }
}
