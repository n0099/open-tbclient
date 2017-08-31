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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.play.e;
import com.baidu.tieba.play.i;
import com.baidu.tieba.play.m;
/* loaded from: classes.dex */
public class a implements e {
    private i bKE;
    private m bKr;
    private c bML;
    private String bMM;
    private bj bgI;
    private AlaVideoContainer blx;
    private String mForumName;
    private boolean bKC = false;
    private i.a bKN = new i.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.i.a
        public void XO() {
            a.this.XI();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.blx = alaVideoContainer;
        if (this.blx != null) {
            this.bKE = new i();
            this.bKE.setPlayer(this.blx.getVideoView());
            this.bKE.a(this.bKN);
            if (this.blx.getVideoView() != null) {
                this.bKr = new m(this.blx.getVideoView().getContext());
                this.blx.getVideoView().setBusiness(this.bKr);
            }
        }
    }

    public void a(bj bjVar, String str, String str2, boolean z) {
        this.bMM = str2;
        this.mForumName = str;
        if (bjVar != null) {
            this.bgI = bjVar;
            if (this.blx != null && this.bgI.rT() != null) {
                this.bML = this.bgI.rT();
                this.blx.setVideoThumbnail(this.bML.cover);
                if (this.bKr != null && this.bKr.bfF() != null) {
                    this.bKr.bfF().b(this.bML);
                }
                if (z) {
                    this.blx.setTitle(this.bgI.getTitle());
                } else {
                    this.blx.setTitle("");
                }
            }
        }
    }

    public void Ya() {
        if (this.bML != null) {
            if (this.bML.live_status == 1) {
                this.blx.Z(d.g.btn_icon_play_live, 0);
                this.blx.setLivingLogLeftDrawable(d.g.icon_video_direct_seeding);
                this.blx.setLivingLogText(d.l.live_in);
                return;
            }
            this.blx.Z(d.g.icon_play_video, 0);
            this.blx.setLivingLogLeftDrawable(d.g.icon_video_direct_seeding_replay);
            this.blx.setLivingLogText(d.l.ala_live_card_view_record_label);
        }
    }

    public void bo(Context context) {
        if (context != null && this.bgI != null && this.bML != null) {
            if (!com.baidu.adp.lib.util.i.hi()) {
                k.showToast(context, d.l.no_network_guide);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            if (this.bgI.rs() != null) {
                str = this.bgI.rs();
            }
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (this.bgI.rG().equals(this.mForumName)) {
                    TiebaStatic.log(new ak("c11843").ad(SapiAccountManager.SESSION_UID, currentAccount).f("fid", this.bgI.getFid()));
                } else {
                    TiebaStatic.log(new ak("c11845").ad(SapiAccountManager.SESSION_UID, currentAccount).f("fid", this.bgI.getFid()));
                }
            }
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && this.bgI.getAuthor() != null) {
                z = TextUtils.equals(this.bgI.getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bML);
            if (this.bML.Uu != null) {
                alaLiveInfoCoreData.setUserName(this.bML.Uu.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.bKC;
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
        if (this.blx != null && this.blx.getVideoView() != null) {
            this.blx.getVideoView().stopPlayback();
            this.blx.XZ();
            if (this.bKE != null) {
                this.bKE.stop();
            }
        }
        this.bKC = false;
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.blx != null) {
            return this.blx.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.bgI == null || this.bgI.rS() == null) {
            return null;
        }
        return this.bgI.rS().video_url;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.blx == null || this.blx.getVideoView() == null) {
            return 0;
        }
        return this.blx.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XI() {
        if (this.bgI == null || this.bgI.rS() == null) {
        }
    }
}
