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
    private m bLi;
    private i bLv;
    private c bNC;
    private String bND;
    private bj bgF;
    private AlaVideoContainer blw;
    private String mForumName;
    private boolean bLt = false;
    private i.a bLE = new i.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.i.a
        public void XZ() {
            a.this.XT();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.blw = alaVideoContainer;
        if (this.blw != null) {
            this.bLv = new i();
            this.bLv.setPlayer(this.blw.getVideoView());
            this.bLv.a(this.bLE);
            if (this.blw.getVideoView() != null) {
                this.bLi = new m(this.blw.getVideoView().getContext());
                this.blw.getVideoView().setBusiness(this.bLi);
            }
        }
    }

    public void a(bj bjVar, String str, String str2, boolean z) {
        this.bND = str2;
        this.mForumName = str;
        if (bjVar != null) {
            this.bgF = bjVar;
            if (this.blw != null && this.bgF.rT() != null) {
                this.bNC = this.bgF.rT();
                this.blw.setVideoThumbnail(this.bNC.cover);
                if (this.bLi != null && this.bLi.bfQ() != null) {
                    this.bLi.bfQ().b(this.bNC);
                }
                if (z) {
                    this.blw.setTitle(this.bgF.getTitle());
                } else {
                    this.blw.setTitle("");
                }
            }
        }
    }

    public void Yl() {
        if (this.bNC != null) {
            if (this.bNC.live_status == 1) {
                this.blw.ad(d.g.btn_icon_play_live, 0);
                this.blw.setLivingLogLeftDrawable(d.g.icon_video_direct_seeding);
                this.blw.setLivingLogText(d.l.live_in);
                return;
            }
            this.blw.ad(d.g.icon_play_video, 0);
            this.blw.setLivingLogLeftDrawable(d.g.icon_video_direct_seeding_replay);
            this.blw.setLivingLogText(d.l.ala_live_card_view_record_label);
        }
    }

    public void bp(Context context) {
        if (context != null && this.bgF != null && this.bNC != null) {
            if (!com.baidu.adp.lib.util.i.hi()) {
                k.showToast(context, d.l.no_network_guide);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            if (this.bgF.rs() != null) {
                str = this.bgF.rs();
            }
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (this.bgF.rG().equals(this.mForumName)) {
                    TiebaStatic.log(new ak("c11843").ad(SapiAccountManager.SESSION_UID, currentAccount).f("fid", this.bgF.getFid()));
                } else {
                    TiebaStatic.log(new ak("c11845").ad(SapiAccountManager.SESSION_UID, currentAccount).f("fid", this.bgF.getFid()));
                }
            }
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && this.bgF.getAuthor() != null) {
                z = TextUtils.equals(this.bgF.getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bNC);
            if (this.bNC.Uu != null) {
                alaLiveInfoCoreData.setUserName(this.bNC.Uu.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    @Override // com.baidu.tieba.play.e
    public boolean isPlayStarted() {
        return this.bLt;
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
        if (this.blw != null && this.blw.getVideoView() != null) {
            this.blw.getVideoView().stopPlayback();
            this.blw.Yk();
            if (this.bLv != null) {
                this.bLv.stop();
            }
        }
        this.bLt = false;
    }

    @Override // com.baidu.tieba.play.e
    public View getVideoContainer() {
        if (this.blw != null) {
            return this.blw.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.e
    public String getPlayUrl() {
        if (this.bgF == null || this.bgF.rS() == null) {
            return null;
        }
        return this.bgF.rS().video_url;
    }

    @Override // com.baidu.tieba.play.e
    public int getCurrentPosition() {
        if (this.blw == null || this.blw.getVideoView() == null) {
            return 0;
        }
        return this.blw.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XT() {
        if (this.bgF == null || this.bgF.rS() == null) {
        }
    }
}
