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
    private i bHK;
    private m bHx;
    private c bJT;
    private String bJU;
    private bl bgG;
    private AlaVideoContainer blc;
    private String mForumName;
    private boolean bHI = false;
    private i.a bHT = new i.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.i.a
        public void WK() {
            a.this.WX();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.blc = alaVideoContainer;
        if (this.blc != null) {
            this.bHK = new i();
            this.bHK.setPlayer(this.blc.getVideoView());
            this.bHK.a(this.bHT);
            if (this.blc.getVideoView() != null) {
                this.bHx = new m(this.blc.getVideoView().getContext());
                this.blc.getVideoView().setBusiness(this.bHx);
            }
        }
    }

    public void a(bl blVar, String str, String str2, boolean z) {
        this.bJU = str2;
        this.mForumName = str;
        if (blVar != null) {
            this.bgG = blVar;
            if (this.blc != null && this.bgG.rY() != null) {
                this.bJT = this.bgG.rY();
                this.blc.setVideoThumbnail(this.bJT.cover);
                if (this.bHx != null && this.bHx.bgp() != null) {
                    this.bHx.bgp().b(this.bJT);
                }
                if (z) {
                    this.blc.setTitle(this.bgG.getTitle());
                } else {
                    this.blc.setTitle("");
                }
            }
        }
    }

    public void WW() {
        if (this.bJT != null) {
            if (this.bJT.live_status == 1) {
                this.blc.aa(d.g.btn_icon_play_live, 0);
                this.blc.setLivingLogLeftDrawable(d.g.icon_video_direct_seeding);
                this.blc.setLivingLogText(d.l.ala_live_card_view_live_label);
                return;
            }
            this.blc.aa(d.g.icon_play_video, 0);
            this.blc.setLivingLogLeftDrawable(d.g.icon_video_direct_seeding_replay);
            this.blc.setLivingLogText(d.l.ala_live_card_view_record_label);
        }
    }

    public void bi(Context context) {
        if (context != null && this.bgG != null && this.bJT != null) {
            if (!com.baidu.adp.lib.util.i.hr()) {
                k.showToast(context, d.l.no_network_guide);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            if (this.bgG.rx() != null) {
                str = this.bgG.rx();
            }
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (this.bgG.rL().equals(this.mForumName)) {
                    TiebaStatic.log(new aj("c11843").aa(SapiAccountManager.SESSION_UID, currentAccount).g("fid", this.bgG.getFid()));
                } else {
                    TiebaStatic.log(new aj("c11845").aa(SapiAccountManager.SESSION_UID, currentAccount).g("fid", this.bgG.getFid()));
                }
            }
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && this.bgG.getAuthor() != null) {
                z = TextUtils.equals(this.bgG.getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bJT);
            if (this.bJT.Vt != null) {
                alaLiveInfoCoreData.setUserName(this.bJT.Vt.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.bHI;
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
        if (this.blc != null && this.blc.getVideoView() != null) {
            this.blc.getVideoView().stopPlayback();
            this.blc.WV();
            if (this.bHK != null) {
                this.bHK.stop();
            }
        }
        this.bHI = false;
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.blc != null) {
            return this.blc.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.bgG == null || this.bgG.rX() == null) {
            return null;
        }
        return this.bgG.rX().video_url;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.blc == null || this.blc.getVideoView() == null) {
            return 0;
        }
        return this.blc.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WX() {
        if (this.bgG == null || this.bgG.rX() == null) {
        }
    }
}
