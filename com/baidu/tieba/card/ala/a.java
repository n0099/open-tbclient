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
    private n bKD;
    private j bKQ;
    private c bNg;
    private String bNh;
    private bh bit;
    private AlaVideoContainer bnh;
    private String mForumName;
    private boolean bKO = false;
    private j.a bLa = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void XF() {
            a.this.Xz();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.bnh = alaVideoContainer;
        if (this.bnh != null) {
            this.bKQ = new j();
            this.bKQ.setPlayer(this.bnh.getVideoView());
            this.bKQ.a(this.bLa);
            if (this.bnh.getVideoView() != null) {
                this.bKD = new n(this.bnh.getVideoView().getContext());
                this.bnh.getVideoView().setBusiness(this.bKD);
            }
        }
    }

    public void a(bh bhVar, String str, String str2, boolean z) {
        this.bNh = str2;
        this.mForumName = str;
        if (bhVar != null) {
            this.bit = bhVar;
            if (this.bnh != null && this.bit.rN() != null) {
                this.bNg = this.bit.rN();
                this.bnh.setVideoThumbnail(this.bNg.cover);
                if (this.bKD != null && this.bKD.bet() != null) {
                    this.bKD.bet().b(this.bNg);
                }
                if (z) {
                    this.bnh.setTitle(this.bit.getTitle());
                } else {
                    this.bnh.setTitle("");
                }
                this.bnh.setPlayCount(String.format(this.bnh.getVideoView().getContext().getResources().getString(d.l.ala_audience_count_prefix), am.z(this.bit.rN().audience_count)));
            }
        }
    }

    public void bo(Context context) {
        if (context != null && this.bit != null && this.bNg != null) {
            if (!com.baidu.adp.lib.util.j.hh()) {
                l.showToast(context, d.l.no_network_guide);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            if (this.bit.rm() != null) {
                str = this.bit.rm();
            }
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (this.bit.rA().equals(this.mForumName)) {
                    TiebaStatic.log(new ak("c11843").ad(SapiAccountManager.SESSION_UID, currentAccount).f("fid", this.bit.getFid()));
                } else {
                    TiebaStatic.log(new ak("c11845").ad(SapiAccountManager.SESSION_UID, currentAccount).f("fid", this.bit.getFid()));
                }
            }
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && this.bit.getAuthor() != null) {
                z = TextUtils.equals(this.bit.getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bNg);
            if (this.bNg.UJ != null) {
                alaLiveInfoCoreData.setUserName(this.bNg.UJ.user_name);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.bKO;
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
        if (this.bnh != null && this.bnh.getVideoView() != null) {
            this.bnh.getVideoView().stopPlayback();
            this.bnh.XS();
            if (this.bKQ != null) {
                this.bKQ.stop();
            }
        }
        this.bKO = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.bnh != null) {
            return this.bnh.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bit == null || this.bit.rM() == null) {
            return null;
        }
        return this.bit.rM().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.bnh == null || this.bnh.getVideoView() == null) {
            return 0;
        }
        return this.bnh.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xz() {
        if (this.bit == null || this.bit.rM() == null) {
        }
    }

    public void XT() {
        if (this.bnh != null) {
            this.bnh.XT();
        }
    }
}
