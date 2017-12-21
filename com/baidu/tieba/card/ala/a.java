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
    private bd bku;
    private j blq;
    private n blr;
    private AlaVideoContainer bvK;
    private AlaInfoData cdx;
    private String cdy;
    private String mForumName;
    private boolean cay = false;
    private j.a caJ = new j.a() { // from class: com.baidu.tieba.card.ala.a.1
        @Override // com.baidu.tieba.play.j.a
        public void abI() {
            a.this.abB();
        }
    };

    public a(AlaVideoContainer alaVideoContainer) {
        this.bvK = alaVideoContainer;
        if (this.bvK != null) {
            this.blq = new j();
            this.blq.setPlayer(this.bvK.getVideoView());
            this.blq.a(this.caJ);
            if (this.bvK.getVideoView() != null) {
                this.blr = new n(this.bvK.getVideoView().getContext());
                this.bvK.getVideoView().setBusiness(this.blr);
            }
        }
    }

    public void a(bd bdVar, String str, String str2, boolean z) {
        this.cdy = str2;
        this.mForumName = str;
        if (bdVar != null) {
            this.bku = bdVar;
            if (this.bvK != null && this.bku.rO() != null) {
                this.cdx = this.bku.rO();
                this.bvK.setVideoThumbnail(this.cdx.cover);
                if (this.blr != null && this.blr.bjy() != null) {
                    this.blr.bjy().b(this.cdx);
                }
                if (z) {
                    this.bvK.setTitle(this.bku.getTitle());
                } else {
                    this.bvK.setTitle("");
                }
                this.bvK.setPlayCount(String.format(this.bvK.getVideoView().getContext().getResources().getString(d.j.ala_audience_count_prefix), am.A(this.bku.rO().audience_count)));
            }
        }
    }

    public void bp(Context context) {
        if (context != null && this.bku != null && this.cdx != null) {
            if (!com.baidu.adp.lib.util.j.hh()) {
                l.showToast(context, d.j.no_network_guide);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            if (this.bku.rl() != null) {
                str = this.bku.rl();
            }
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (this.bku.rB().equals(this.mForumName)) {
                    TiebaStatic.log(new ak("c11843").ac("uid", currentAccount).f(ImageViewerConfig.FORUM_ID, this.bku.getFid()));
                } else {
                    TiebaStatic.log(new ak("c11845").ac("uid", currentAccount).f(ImageViewerConfig.FORUM_ID, this.bku.getFid()));
                }
            }
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && this.bku.rv() != null) {
                z = TextUtils.equals(this.bku.rv().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.cdx);
            if (this.cdx.user_info != null) {
                alaLiveInfoCoreData.userName = this.cdx.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    @Override // com.baidu.tieba.play.f
    public boolean isPlayStarted() {
        return this.cay;
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
        if (this.bvK != null && this.bvK.getVideoView() != null) {
            this.bvK.getVideoView().stopPlayback();
            this.bvK.OQ();
            if (this.blq != null) {
                this.blq.stop();
            }
        }
        this.cay = false;
    }

    @Override // com.baidu.tieba.play.f
    public View getVideoContainer() {
        if (this.bvK != null) {
            return this.bvK.getView();
        }
        return null;
    }

    @Override // com.baidu.tieba.play.f
    public String getPlayUrl() {
        if (this.bku == null || this.bku.rN() == null) {
            return null;
        }
        return this.bku.rN().video_url;
    }

    @Override // com.baidu.tieba.play.f
    public int getCurrentPosition() {
        if (this.bvK == null || this.bvK.getVideoView() == null) {
            return 0;
        }
        return this.bvK.getVideoView().getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abB() {
        if (this.bku == null || this.bku.rN() == null) {
        }
    }

    public void startPlayAnimation() {
        if (this.bvK != null) {
            this.bvK.startPlayAnimation();
        }
    }
}
