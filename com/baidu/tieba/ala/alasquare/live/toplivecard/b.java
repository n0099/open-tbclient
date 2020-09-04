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
    private int aEG;
    private FrameLayout ahv;
    private CyberPlayerManager.OnPreparedListener dLL;
    private CyberPlayerManager.OnErrorListener dLM;
    private TbPageContext<?> efr;
    private boolean fDH;
    private c fDK;
    private final float fDN;
    private AlaSquareLiveVideoMask fDO;
    private TbCyberVideoView fDP;
    private f fDQ;
    private int fDR;
    private int fDS;
    private int fDT;
    private int fDU;
    private String fDV;
    private a fDW;
    private int fDX;
    private TbCyberVideoView.a fcn;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes4.dex */
    public interface a {
        void P(bw bwVar);

        void Q(bw bwVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.fDN = 0.0f;
        this.efr = null;
        this.fDV = "";
        this.fDH = false;
        this.fcn = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                b.this.bFN();
            }
        };
        this.dLM = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                b.this.kB(false);
                return true;
            }
        };
        this.dLL = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (b.this.fDP != null) {
                    b.this.fDP.setLooping(false);
                    b.this.fDP.setVolume(0.0f, 0.0f);
                    if (b.this.fDK != null && b.this.fDK.ajz != null) {
                        if (b.this.fDH) {
                            if (b.this.fDW != null) {
                                b.this.fDW.Q(b.this.fDK.ajz);
                            }
                        } else {
                            aq aqVar = new aq("c12646");
                            if (b.this.fDK.fDb != 0) {
                                if (b.this.fDK.fDb == 1) {
                                    aqVar.ai("obj_type", 2);
                                }
                            } else {
                                aqVar.ai("obj_type", 1);
                            }
                            aqVar.dD("tid", b.this.fDK.ajz.getTid());
                            TiebaStatic.log(aqVar);
                        }
                    }
                    if (b.this.fDP.getCyberPlayer() != null) {
                        b.this.bC(b.this.fDP.getCyberPlayer().getVideoHeight(), b.this.fDP.getCyberPlayer().getVideoWidth());
                    }
                    if (b.this.fDO != null) {
                        b.this.fDO.bFH();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.fDK != null && b.this.fDK.ajz != null) {
                    if (b.this.fDW != null) {
                        b.this.fDW.P(b.this.fDK.ajz);
                    }
                    b.this.a(b.this.efr, b.this.fDK.ajz);
                }
            }
        };
        this.efr = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.fDH = z;
        this.fDO.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.efr != null) {
            this.ahv = (FrameLayout) LayoutInflater.from(this.efr.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.fDR = l.getEquipmentWidth(this.efr.getPageActivity());
            this.fDS = l.getEquipmentHeight(this.efr.getPageActivity());
            this.fDT = (int) ((this.fDR / 16.0d) * 9.0d);
            this.fDU = (int) ((this.fDR / 4.0d) * 3.0d);
            this.fDX = (int) ((this.fDS / 3.0d) - (this.fDU / 2.0d));
            this.fDO = (AlaSquareLiveVideoMask) this.ahv.findViewById(R.id.video_mask);
            this.ahv.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.fDW = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.ajz != null && cVar.ajz.beY() != null) {
            if (this.fDK == null || (this.fDK.ajz != null && !this.fDK.ajz.getTid().equals(cVar.ajz.getTid()))) {
                sB(cVar.ajz.beY().screen_direction);
            }
            this.fDK = cVar;
            this.aEG = this.fDK.ajz.beY().screen_direction;
            this.fDO.setData(this.fDK.ajz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(int i, int i2) {
        int i3;
        int i4;
        if (this.aEG == 1 && this.fDP != null && this.fDP.getParent() != null) {
            float f = i / i2;
            float f2 = (this.fDR * i) / this.fDS;
            if (f2 < i2) {
                i3 = (int) (this.fDS / f);
                i4 = this.fDS;
            } else if (f2 > i2) {
                i3 = this.fDR;
                i4 = (int) (f * this.fDR);
            } else {
                i3 = this.fDR;
                i4 = this.fDS;
            }
            if (this.fDP.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fDP.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.fDP.setLayoutParams(layoutParams);
                return;
            }
            this.fDP.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void sA(int i) {
        if (this.fDP != null) {
            if (i == 1) {
                if (this.fDP.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fDP.getLayoutParams();
                    layoutParams.width = this.fDR;
                    layoutParams.height = this.fDS;
                    layoutParams.topMargin = -this.fDX;
                    this.fDP.setLayoutParams(layoutParams);
                    return;
                }
                this.fDP.setLayoutParams(new FrameLayout.LayoutParams(this.fDR, this.fDS));
            } else if (this.fDP.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fDP.getLayoutParams();
                layoutParams2.width = this.fDR;
                layoutParams2.height = this.fDT;
                this.fDP.setLayoutParams(layoutParams2);
            } else {
                this.fDP.setLayoutParams(new FrameLayout.LayoutParams(this.fDR, this.fDT));
            }
        }
    }

    private void sB(int i) {
        if (i == 1) {
            if (this.fDH) {
                if (this.ahv.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ahv.getLayoutParams();
                    layoutParams.width = this.fDR;
                    layoutParams.height = this.fDU;
                    this.ahv.setLayoutParams(layoutParams);
                    return;
                }
                this.ahv.setLayoutParams(new FrameLayout.LayoutParams(this.fDR, this.fDU));
                return;
            } else if (this.ahv.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ahv.getLayoutParams();
                layoutParams2.width = this.fDR;
                layoutParams2.height = this.fDR;
                this.ahv.setLayoutParams(layoutParams2);
                return;
            } else {
                this.ahv.setLayoutParams(new AbsListView.LayoutParams(this.fDR, this.fDR));
                return;
            }
        }
        this.aEG = 2;
        if (this.fDH) {
            if (this.ahv.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.ahv.getLayoutParams();
                layoutParams3.width = this.fDR;
                layoutParams3.height = this.fDT;
                this.ahv.setLayoutParams(layoutParams3);
                return;
            }
            this.ahv.setLayoutParams(new AbsListView.LayoutParams(this.fDR, this.fDT));
        } else if (this.ahv.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.ahv.getLayoutParams();
            layoutParams4.width = this.fDR;
            layoutParams4.height = this.fDT;
            this.ahv.setLayoutParams(layoutParams4);
        } else {
            this.ahv.setLayoutParams(new AbsListView.LayoutParams(this.fDR, this.fDT));
        }
    }

    public void bFM() {
        this.fDR = l.getEquipmentWidth(this.efr.getPageActivity());
        this.fDS = l.getEquipmentHeight(this.efr.getPageActivity());
        this.fDT = (int) ((this.fDR / 16.0d) * 9.0d);
        this.fDU = (int) ((this.fDR / 4.0d) * 3.0d);
        this.fDX = (int) ((this.fDS / 3.0d) - (this.fDU / 2.0d));
        if (this.fDK != null) {
            boolean isPlaying = this.fDP == null ? false : this.fDP.isPlaying();
            sB(this.fDK.ajz.beY().screen_direction);
            sA(this.fDK.ajz.beY().screen_direction);
            bFN();
            if (isPlaying) {
                EB(this.fDV);
            }
        }
    }

    public void bFN() {
        kB(true);
    }

    public void kB(boolean z) {
        if (z) {
            bFO();
        }
        if (this.fDP != null) {
            this.fDP.stopPlayback();
        }
        this.fDO.bFI();
        this.fDO.bFJ();
    }

    private void bFO() {
        if (this.fDQ != null) {
            this.fDQ.setPlayer(null);
            this.fDQ.stop();
            this.fDQ = null;
        }
        if (this.fDP != null) {
            this.fDP.stopPlayback();
            this.fDP.dkr();
            if (this.fDP.getMediaProgressObserver() != null) {
                this.fDP.getMediaProgressObserver().setPlayer(null);
                this.fDP.getMediaProgressObserver().stop();
            }
            this.fDP = null;
        }
    }

    private void bFP() {
        if (this.fDK != null && this.fDK.ajz != null && this.fDK.ajz.beY() != null) {
            if (this.fDP != null && this.fDP.getParent() != null) {
                bFO();
            }
            this.fDQ = new f();
            this.fDP = new TbCyberVideoView(this.efr.getPageActivity());
            this.fDP.setOnPreparedListener(this.dLL);
            this.fDP.setOnErrorListener(this.dLM);
            this.fDP.setOnSurfaceDestroyedListener(this.fcn);
            this.fDP.setVolume(0.0f, 0.0f);
            this.fDP.setStageType(null);
            this.fDQ.setPlayer(this.fDP);
            this.fDQ.a(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.f.c
                public void bFQ() {
                }
            });
            if (this.fDP.getParent() == null) {
                this.ahv.addView(this.fDP, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            sA(this.fDK.ajz.beY().screen_direction);
        }
    }

    public void EB(String str) {
        if (!StringUtils.isNull(str) && this.fDK != null && this.fDK.ajz != null && this.fDK.ajz.beY() != null) {
            if (!str.equals(this.fDV) || (this.fDP != null && !this.fDP.isPlaying())) {
                this.fDV = str;
                bFN();
            }
            if (this.fDP == null) {
                bFP();
            }
            if (this.fDP != null && !this.fDP.isPlaying()) {
                o oVar = new o();
                oVar.mLocate = "9";
                oVar.eVx = String.valueOf(this.fDK.ajz.getFid());
                oVar.ala = this.fDK.ajz.getTid();
                this.fDP.setVideoStatData(oVar);
                if (this.fDP != null) {
                    this.fDP.setVideoPath(this.fDK.ajz.beY().hls_url);
                }
                if (this.fDP != null) {
                    this.fDP.start();
                }
                if (this.fDQ != null) {
                    this.fDQ.start();
                }
            }
        }
    }

    public View getView() {
        return this.ahv;
    }

    public void onDestroy() {
        bFO();
        if (this.fDO != null) {
            this.fDO.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.fDO != null) {
            this.fDO.bpI();
        }
        ap.setBackgroundColor(this.fDP, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bw bwVar) {
        String str;
        if (tbPageContext != null && bwVar != null && bwVar.beE() != null && bwVar.beY() != null) {
            if (this.fDK != null && this.fDK.ajz != null && !this.fDH) {
                aq aqVar = new aq("c12645");
                if (this.fDK.fDb == 0) {
                    aqVar.ai("obj_type", 1);
                } else if (this.fDK.fDb == 1) {
                    aqVar.ai("obj_type", 2);
                }
                aqVar.dD("tid", this.fDK.ajz.getTid());
                TiebaStatic.log(aqVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.beE().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.fDH) {
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
