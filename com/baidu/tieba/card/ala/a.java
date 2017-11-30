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
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bd;
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
    private bd bkp;
    private j bll;
    private n blm;
    private AlaVideoContainer bvF;
    private AlaInfoData cdf;
    private String cdg;
    private String mForumName;
    private boolean caq = false;
    private j.a caB = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void abG() {
            a.this.abA();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.bvF = alaVideoContainer;
        if (this.bvF != null) {
            this.bll = new j();
            this.bll.setPlayer(this.bvF.getVideoView());
            this.bll.a(this.caB);
            if (this.bvF.getVideoView() != null) {
                this.blm = new n(this.bvF.getVideoView().getContext());
                this.bvF.getVideoView().setBusiness(this.blm);
            }
        }
    }

    public void a(bd bdVar, String str, String str2, boolean z) {
        this.cdg = str2;
        this.mForumName = str;
        if (bdVar != null) {
            this.bkp = bdVar;
            if (this.bvF != null && this.bkp.rQ() != null) {
                this.cdf = this.bkp.rQ();
                this.bvF.setVideoThumbnail(this.cdf.cover);
                if (this.blm != null && this.blm.bjq() != null) {
                    this.blm.bjq().b(this.cdf);
                }
                if (z) {
                    this.bvF.setTitle(this.bkp.getTitle());
                } else {
                    this.bvF.setTitle("");
                }
                this.bvF.setPlayCount(String.format(this.bvF.getVideoView().getContext().getResources().getString(d.j.ala_audience_count_prefix), am.A(this.bkp.rQ().audience_count)));
            }
        }
    }

    public void bs(Context context) {
        if (context != null && this.bkp != null && this.cdf != null) {
            if (!com.baidu.adp.lib.util.j.hh()) {
                l.showToast(context, d.j.no_network_guide);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            if (this.bkp.rn() != null) {
                str = this.bkp.rn();
            }
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (this.bkp.rD().equals(this.mForumName)) {
                    TiebaStatic.log(new ak("c11843").ac(SapiAccountManager.SESSION_UID, currentAccount).f(ImageViewerConfig.FORUM_ID, this.bkp.getFid()));
                } else {
                    TiebaStatic.log(new ak("c11845").ac(SapiAccountManager.SESSION_UID, currentAccount).f(ImageViewerConfig.FORUM_ID, this.bkp.getFid()));
                }
            }
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && this.bkp.rx() != null) {
                z = TextUtils.equals(this.bkp.rx().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cdf);
            if (this.cdf.user_info != null) {
                alaLiveInfoCoreData.userName = this.cdf.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.caq;
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
        if (this.bvF != null && this.bvF.getVideoView() != null) {
            this.bvF.getVideoView().stopPlayback();
            this.bvF.OQ();
            if (this.bll != null) {
                this.bll.stop();
            }
        }
        this.caq = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.bvF != null) {
            return this.bvF.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bkp == null || this.bkp.rP() == null) {
            return null;
        }
        return this.bkp.rP().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.bvF == null || this.bvF.getVideoView() == null) {
            return 0;
        }
        return this.bvF.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abA() {
        if (this.bkp == null || this.bkp.rP() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.bvF != null) {
            this.bvF.startPlayAnimation();
        }
    }
}
