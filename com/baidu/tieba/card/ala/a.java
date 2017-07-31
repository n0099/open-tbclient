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
    private m bGN;
    private i bHa;
    private c bJj;
    private String bJk;
    private bl bgF;
    private AlaVideoContainer bkX;
    private String mForumName;
    private boolean bGY = false;
    private i.a bHj = new i.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.i.a
        public void Wr() {
            a.this.WE();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.bkX = alaVideoContainer;
        if (this.bkX != null) {
            this.bHa = new i();
            this.bHa.setPlayer(this.bkX.getVideoView());
            this.bHa.a(this.bHj);
            if (this.bkX.getVideoView() != null) {
                this.bGN = new m(this.bkX.getVideoView().getContext());
                this.bkX.getVideoView().setBusiness(this.bGN);
            }
        }
    }

    public void a(bl blVar, String str, String str2, boolean z) {
        this.bJk = str2;
        this.mForumName = str;
        if (blVar != null) {
            this.bgF = blVar;
            if (this.bkX != null && this.bgF.rX() != null) {
                this.bJj = this.bgF.rX();
                this.bkX.setVideoThumbnail(this.bJj.cover);
                if (this.bGN != null && this.bGN.bfO() != null) {
                    this.bGN.bfO().b(this.bJj);
                }
                if (z) {
                    this.bkX.setTitle(this.bgF.getTitle());
                } else {
                    this.bkX.setTitle("");
                }
            }
        }
    }

    public void WD() {
        if (this.bJj != null) {
            if (this.bJj.live_status == 1) {
                this.bkX.aa(d.g.btn_icon_play_live, 0);
                this.bkX.setLivingLogLeftDrawable(d.g.icon_video_direct_seeding);
                this.bkX.setLivingLogText(d.l.ala_live_card_view_live_label);
                return;
            }
            this.bkX.aa(d.g.icon_play_video, 0);
            this.bkX.setLivingLogLeftDrawable(d.g.icon_video_direct_seeding_replay);
            this.bkX.setLivingLogText(d.l.ala_live_card_view_record_label);
        }
    }

    public void bi(Context context) {
        if (context != null && this.bgF != null && this.bJj != null) {
            if (!com.baidu.adp.lib.util.i.hr()) {
                k.showToast(context, d.l.no_network_guide);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            if (this.bgF.rw() != null) {
                str = this.bgF.rw();
            }
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (this.bgF.rK().equals(this.mForumName)) {
                    TiebaStatic.log(new aj("c11843").aa(SapiAccountManager.SESSION_UID, currentAccount).g("fid", this.bgF.getFid()));
                } else {
                    TiebaStatic.log(new aj("c11845").aa(SapiAccountManager.SESSION_UID, currentAccount).g("fid", this.bgF.getFid()));
                }
            }
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && this.bgF.getAuthor() != null) {
                z = TextUtils.equals(this.bgF.getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bJj);
            if (this.bJj.Vq != null) {
                alaLiveInfoCoreData.setUserName(this.bJj.Vq.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.bGY;
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
        if (this.bkX != null && this.bkX.getVideoView() != null) {
            this.bkX.getVideoView().stopPlayback();
            this.bkX.WC();
            if (this.bHa != null) {
                this.bHa.stop();
            }
        }
        this.bGY = false;
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.bkX != null) {
            return this.bkX.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.bgF == null || this.bgF.rW() == null) {
            return null;
        }
        return this.bgF.rW().video_url;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.bkX == null || this.bkX.getVideoView() == null) {
            return 0;
        }
        return this.bkX.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WE() {
        if (this.bgF == null || this.bgF.rW() == null) {
        }
    }
}
