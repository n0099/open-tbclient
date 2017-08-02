package com.baidu.tieba.card.ala;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.play.e;
import com.baidu.tieba.play.i;
import com.baidu.tieba.play.m;
/* loaded from: classes.dex */
public class a implements e {
    private m bFD;
    private i bFQ;
    private c bHZ;
    private String bIa;
    private bl bfu;
    private AlaVideoContainer bjN;
    private String mForumName;
    private boolean bFO = false;
    private i.a bFZ = new i.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.i.a
        public void Wm() {
            a.this.Wz();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.bjN = alaVideoContainer;
        if (this.bjN != null) {
            this.bFQ = new i();
            this.bFQ.setPlayer(this.bjN.getVideoView());
            this.bFQ.a(this.bFZ);
            if (this.bjN.getVideoView() != null) {
                this.bFD = new m(this.bjN.getVideoView().getContext());
                this.bjN.getVideoView().setBusiness(this.bFD);
            }
        }
    }

    public void a(bl blVar, String str, String str2, boolean z) {
        this.bIa = str2;
        this.mForumName = str;
        if (blVar != null) {
            this.bfu = blVar;
            if (this.bjN != null && this.bfu.rN() != null) {
                this.bHZ = this.bfu.rN();
                this.bjN.setVideoThumbnail(this.bHZ.cover);
                if (this.bFD != null && this.bFD.bfE() != null) {
                    this.bFD.bfE().b(this.bHZ);
                }
                if (z) {
                    this.bjN.setTitle(this.bfu.getTitle());
                } else {
                    this.bjN.setTitle("");
                }
            }
        }
    }

    public void Wy() {
        if (this.bHZ != null) {
            if (this.bHZ.live_status == 1) {
                this.bjN.Z(d.g.btn_icon_play_live, 0);
                this.bjN.setLivingLogLeftDrawable(d.g.icon_video_direct_seeding);
                this.bjN.setLivingLogText(d.l.ala_live_card_view_live_label);
                return;
            }
            this.bjN.Z(d.g.icon_play_video, 0);
            this.bjN.setLivingLogLeftDrawable(d.g.icon_video_direct_seeding_replay);
            this.bjN.setLivingLogText(d.l.ala_live_card_view_record_label);
        }
    }

    public void bi(Context context) {
        if (context != null && this.bfu != null && this.bHZ != null) {
            if (!com.baidu.adp.lib.util.i.hh()) {
                k.showToast(context, d.l.no_network_guide);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            if (this.bfu.rm() != null) {
                str = this.bfu.rm();
            }
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (this.bfu.rA().equals(this.mForumName)) {
                    TiebaStatic.log(new aj("c11843").aa(SapiAccountManager.SESSION_UID, currentAccount).f("fid", this.bfu.getFid()));
                } else {
                    TiebaStatic.log(new aj("c11845").aa(SapiAccountManager.SESSION_UID, currentAccount).f("fid", this.bfu.getFid()));
                }
            }
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && this.bfu.getAuthor() != null) {
                z = TextUtils.equals(this.bfu.getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bHZ);
            if (this.bHZ.TR != null) {
                alaLiveInfoCoreData.setUserName(this.bHZ.TR.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.bFO;
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlaying() {
        return false;
    }

    @Override // com.baidu.tieba.play.e
    public void startPlay() {
    }

    @Override // com.baidu.tieba.play.e
    public void stopPlay() {
        if (this.bjN != null && this.bjN.getVideoView() != null) {
            this.bjN.getVideoView().stopPlayback();
            this.bjN.Wx();
            if (this.bFQ != null) {
                this.bFQ.stop();
            }
        }
        this.bFO = false;
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.bjN != null) {
            return this.bjN.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.bfu == null || this.bfu.rM() == null) {
            return null;
        }
        return this.bfu.rM().video_url;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.bjN == null || this.bjN.getVideoView() == null) {
            return 0;
        }
        return this.bjN.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wz() {
        if (this.bfu == null || this.bfu.rM() == null) {
        }
    }
}
