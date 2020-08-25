package com.baidu.tieba.ala.alasquare.live.toplivecard;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.b.c;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.o;
/* loaded from: classes4.dex */
public class b {
    private int aEE;
    private FrameLayout aht;
    private CyberPlayerManager.OnPreparedListener dLH;
    private CyberPlayerManager.OnErrorListener dLI;
    private TbPageContext<?> efn;
    private boolean fDD;
    private c fDG;
    private final float fDJ;
    private AlaSquareLiveVideoMask fDK;
    private TbCyberVideoView fDL;
    private f fDM;
    private int fDN;
    private int fDO;
    private int fDP;
    private int fDQ;
    private String fDR;
    private a fDS;
    private int fDT;
    private TbCyberVideoView.a fcj;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes4.dex */
    public interface a {
        void P(bw bwVar);

        void Q(bw bwVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.fDJ = 0.0f;
        this.efn = null;
        this.fDR = "";
        this.fDD = false;
        this.fcj = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                b.this.bFM();
            }
        };
        this.dLI = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                b.this.kz(false);
                return true;
            }
        };
        this.dLH = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (b.this.fDL != null) {
                    b.this.fDL.setLooping(false);
                    b.this.fDL.setVolume(0.0f, 0.0f);
                    if (b.this.fDG != null && b.this.fDG.ajx != null) {
                        if (b.this.fDD) {
                            if (b.this.fDS != null) {
                                b.this.fDS.Q(b.this.fDG.ajx);
                            }
                        } else {
                            aq aqVar = new aq("c12646");
                            if (b.this.fDG.fCX != 0) {
                                if (b.this.fDG.fCX == 1) {
                                    aqVar.ai("obj_type", 2);
                                }
                            } else {
                                aqVar.ai("obj_type", 1);
                            }
                            aqVar.dD("tid", b.this.fDG.ajx.getTid());
                            TiebaStatic.log(aqVar);
                        }
                    }
                    if (b.this.fDL.getCyberPlayer() != null) {
                        b.this.bC(b.this.fDL.getCyberPlayer().getVideoHeight(), b.this.fDL.getCyberPlayer().getVideoWidth());
                    }
                    if (b.this.fDK != null) {
                        b.this.fDK.bFG();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.fDG != null && b.this.fDG.ajx != null) {
                    if (b.this.fDS != null) {
                        b.this.fDS.P(b.this.fDG.ajx);
                    }
                    b.this.a(b.this.efn, b.this.fDG.ajx);
                }
            }
        };
        this.efn = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.fDD = z;
        this.fDK.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.efn != null) {
            this.aht = (FrameLayout) LayoutInflater.from(this.efn.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.fDN = l.getEquipmentWidth(this.efn.getPageActivity());
            this.fDO = l.getEquipmentHeight(this.efn.getPageActivity());
            this.fDP = (int) ((this.fDN / 16.0d) * 9.0d);
            this.fDQ = (int) ((this.fDN / 4.0d) * 3.0d);
            this.fDT = (int) ((this.fDO / 3.0d) - (this.fDQ / 2.0d));
            this.fDK = (AlaSquareLiveVideoMask) this.aht.findViewById(R.id.video_mask);
            this.aht.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.fDS = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.ajx != null && cVar.ajx.beY() != null) {
            if (this.fDG == null || (this.fDG.ajx != null && !this.fDG.ajx.getTid().equals(cVar.ajx.getTid()))) {
                sB(cVar.ajx.beY().screen_direction);
            }
            this.fDG = cVar;
            this.aEE = this.fDG.ajx.beY().screen_direction;
            this.fDK.setData(this.fDG.ajx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(int i, int i2) {
        int i3;
        int i4;
        if (this.aEE == 1 && this.fDL != null && this.fDL.getParent() != null) {
            float f = i / i2;
            float f2 = (this.fDN * i) / this.fDO;
            if (f2 < i2) {
                i3 = (int) (this.fDO / f);
                i4 = this.fDO;
            } else if (f2 > i2) {
                i3 = this.fDN;
                i4 = (int) (f * this.fDN);
            } else {
                i3 = this.fDN;
                i4 = this.fDO;
            }
            if (this.fDL.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fDL.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.fDL.setLayoutParams(layoutParams);
                return;
            }
            this.fDL.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void sA(int i) {
        if (this.fDL != null) {
            if (i == 1) {
                if (this.fDL.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fDL.getLayoutParams();
                    layoutParams.width = this.fDN;
                    layoutParams.height = this.fDO;
                    layoutParams.topMargin = -this.fDT;
                    this.fDL.setLayoutParams(layoutParams);
                    return;
                }
                this.fDL.setLayoutParams(new FrameLayout.LayoutParams(this.fDN, this.fDO));
            } else if (this.fDL.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fDL.getLayoutParams();
                layoutParams2.width = this.fDN;
                layoutParams2.height = this.fDP;
                this.fDL.setLayoutParams(layoutParams2);
            } else {
                this.fDL.setLayoutParams(new FrameLayout.LayoutParams(this.fDN, this.fDP));
            }
        }
    }

    private void sB(int i) {
        if (i == 1) {
            if (this.fDD) {
                if (this.aht.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aht.getLayoutParams();
                    layoutParams.width = this.fDN;
                    layoutParams.height = this.fDQ;
                    this.aht.setLayoutParams(layoutParams);
                    return;
                }
                this.aht.setLayoutParams(new FrameLayout.LayoutParams(this.fDN, this.fDQ));
                return;
            } else if (this.aht.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aht.getLayoutParams();
                layoutParams2.width = this.fDN;
                layoutParams2.height = this.fDN;
                this.aht.setLayoutParams(layoutParams2);
                return;
            } else {
                this.aht.setLayoutParams(new AbsListView.LayoutParams(this.fDN, this.fDN));
                return;
            }
        }
        this.aEE = 2;
        if (this.fDD) {
            if (this.aht.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.aht.getLayoutParams();
                layoutParams3.width = this.fDN;
                layoutParams3.height = this.fDP;
                this.aht.setLayoutParams(layoutParams3);
                return;
            }
            this.aht.setLayoutParams(new AbsListView.LayoutParams(this.fDN, this.fDP));
        } else if (this.aht.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.aht.getLayoutParams();
            layoutParams4.width = this.fDN;
            layoutParams4.height = this.fDP;
            this.aht.setLayoutParams(layoutParams4);
        } else {
            this.aht.setLayoutParams(new AbsListView.LayoutParams(this.fDN, this.fDP));
        }
    }

    public void bFL() {
        this.fDN = l.getEquipmentWidth(this.efn.getPageActivity());
        this.fDO = l.getEquipmentHeight(this.efn.getPageActivity());
        this.fDP = (int) ((this.fDN / 16.0d) * 9.0d);
        this.fDQ = (int) ((this.fDN / 4.0d) * 3.0d);
        this.fDT = (int) ((this.fDO / 3.0d) - (this.fDQ / 2.0d));
        if (this.fDG != null) {
            boolean isPlaying = this.fDL == null ? false : this.fDL.isPlaying();
            sB(this.fDG.ajx.beY().screen_direction);
            sA(this.fDG.ajx.beY().screen_direction);
            bFM();
            if (isPlaying) {
                EA(this.fDR);
            }
        }
    }

    public void bFM() {
        kz(true);
    }

    public void kz(boolean z) {
        if (z) {
            bFN();
        }
        if (this.fDL != null) {
            this.fDL.stopPlayback();
        }
        this.fDK.bFH();
        this.fDK.bFI();
    }

    private void bFN() {
        if (this.fDM != null) {
            this.fDM.setPlayer(null);
            this.fDM.stop();
            this.fDM = null;
        }
        if (this.fDL != null) {
            this.fDL.stopPlayback();
            this.fDL.dko();
            if (this.fDL.getMediaProgressObserver() != null) {
                this.fDL.getMediaProgressObserver().setPlayer(null);
                this.fDL.getMediaProgressObserver().stop();
            }
            this.fDL = null;
        }
    }

    private void bFO() {
        if (this.fDG != null && this.fDG.ajx != null && this.fDG.ajx.beY() != null) {
            if (this.fDL != null && this.fDL.getParent() != null) {
                bFN();
            }
            this.fDM = new f();
            this.fDL = new TbCyberVideoView(this.efn.getPageActivity());
            this.fDL.setOnPreparedListener(this.dLH);
            this.fDL.setOnErrorListener(this.dLI);
            this.fDL.setOnSurfaceDestroyedListener(this.fcj);
            this.fDL.setVolume(0.0f, 0.0f);
            this.fDL.setStageType(null);
            this.fDM.setPlayer(this.fDL);
            this.fDM.a(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.f.c
                public void bFP() {
                }
            });
            if (this.fDL.getParent() == null) {
                this.aht.addView(this.fDL, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            sA(this.fDG.ajx.beY().screen_direction);
        }
    }

    public void EA(String str) {
        if (!StringUtils.isNull(str) && this.fDG != null && this.fDG.ajx != null && this.fDG.ajx.beY() != null) {
            if (!str.equals(this.fDR) || (this.fDL != null && !this.fDL.isPlaying())) {
                this.fDR = str;
                bFM();
            }
            if (this.fDL == null) {
                bFO();
            }
            if (this.fDL != null && !this.fDL.isPlaying()) {
                o oVar = new o();
                oVar.mLocate = "9";
                oVar.eVt = String.valueOf(this.fDG.ajx.getFid());
                oVar.akY = this.fDG.ajx.getTid();
                this.fDL.setVideoStatData(oVar);
                if (this.fDL != null) {
                    this.fDL.setVideoPath(this.fDG.ajx.beY().hls_url);
                }
                if (this.fDL != null) {
                    this.fDL.start();
                }
                if (this.fDM != null) {
                    this.fDM.start();
                }
            }
        }
    }

    public View getView() {
        return this.aht;
    }

    public void onDestroy() {
        bFN();
        if (this.fDK != null) {
            this.fDK.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.fDK != null) {
            this.fDK.bpH();
        }
        ap.setBackgroundColor(this.fDL, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bw bwVar) {
        String str;
        if (tbPageContext != null && bwVar != null && bwVar.beE() != null && bwVar.beY() != null) {
            if (this.fDG != null && this.fDG.ajx != null && !this.fDD) {
                aq aqVar = new aq("c12645");
                if (this.fDG.fCX == 0) {
                    aqVar.ai("obj_type", 1);
                } else if (this.fDG.fCX == 1) {
                    aqVar.ai("obj_type", 2);
                }
                aqVar.dD("tid", this.fDG.ajx.getTid());
                TiebaStatic.log(aqVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.beE().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.fDD) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.beY());
            alaLiveInfoCoreData.userName = bwVar.beY().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
