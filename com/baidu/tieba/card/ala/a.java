package com.baidu.tieba.card.ala;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
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
    private bd bkq;
    private j blm;
    private n bln;
    private AlaVideoContainer bvG;
    private AlaInfoData cdt;
    private String cdu;
    private String mForumName;
    private boolean cau = false;
    private j.a caF = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void abI() {
            a.this.abB();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.bvG = alaVideoContainer;
        if (this.bvG != null) {
            this.blm = new j();
            this.blm.setPlayer(this.bvG.getVideoView());
            this.blm.a(this.caF);
            if (this.bvG.getVideoView() != null) {
                this.bln = new n(this.bvG.getVideoView().getContext());
                this.bvG.getVideoView().setBusiness(this.bln);
            }
        }
    }

    public void a(bd bdVar, String str, String str2, boolean z) {
        this.cdu = str2;
        this.mForumName = str;
        if (bdVar != null) {
            this.bkq = bdVar;
            if (this.bvG != null && this.bkq.rO() != null) {
                this.cdt = this.bkq.rO();
                this.bvG.setVideoThumbnail(this.cdt.cover);
                if (this.bln != null && this.bln.bjx() != null) {
                    this.bln.bjx().b(this.cdt);
                }
                if (z) {
                    this.bvG.setTitle(this.bkq.getTitle());
                } else {
                    this.bvG.setTitle("");
                }
                this.bvG.setPlayCount(String.format(this.bvG.getVideoView().getContext().getResources().getString(d.j.ala_audience_count_prefix), am.A(this.bkq.rO().audience_count)));
            }
        }
    }

    public void bp(Context context) {
        if (context != null && this.bkq != null && this.cdt != null) {
            if (!com.baidu.adp.lib.util.j.hh()) {
                l.showToast(context, d.j.no_network_guide);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            if (this.bkq.rl() != null) {
                str = this.bkq.rl();
            }
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (this.bkq.rB().equals(this.mForumName)) {
                    TiebaStatic.log(new ak("c11843").ac("uid", currentAccount).f(ImageViewerConfig.FORUM_ID, this.bkq.getFid()));
                } else {
                    TiebaStatic.log(new ak("c11845").ac("uid", currentAccount).f(ImageViewerConfig.FORUM_ID, this.bkq.getFid()));
                }
            }
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && this.bkq.rv() != null) {
                z = TextUtils.equals(this.bkq.rv().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cdt);
            if (this.cdt.user_info != null) {
                alaLiveInfoCoreData.userName = this.cdt.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cau;
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
        if (this.bvG != null && this.bvG.getVideoView() != null) {
            this.bvG.getVideoView().stopPlayback();
            this.bvG.OQ();
            if (this.blm != null) {
                this.blm.stop();
            }
        }
        this.cau = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.bvG != null) {
            return this.bvG.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bkq == null || this.bkq.rN() == null) {
            return null;
        }
        return this.bkq.rN().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.bvG == null || this.bvG.getVideoView() == null) {
            return 0;
        }
        return this.bvG.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abB() {
        if (this.bkq == null || this.bkq.rN() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.bvG != null) {
            this.bvG.startPlayAnimation();
        }
    }
}
