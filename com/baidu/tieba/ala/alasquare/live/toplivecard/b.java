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
    private int aFR;
    private FrameLayout ahP;
    private CyberPlayerManager.OnPreparedListener dNO;
    private CyberPlayerManager.OnErrorListener dNP;
    private TbPageContext<?> ehG;
    private boolean fGT;
    private c fGW;
    private final float fGZ;
    private AlaSquareLiveVideoMask fHa;
    private TbCyberVideoView fHb;
    private f fHc;
    private int fHd;
    private int fHe;
    private int fHf;
    private int fHg;
    private String fHh;
    private a fHi;
    private int fHj;
    private TbCyberVideoView.a ffg;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes4.dex */
    public interface a {
        void Q(bw bwVar);

        void R(bw bwVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.fGZ = 0.0f;
        this.ehG = null;
        this.fHh = "";
        this.fGT = false;
        this.ffg = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                b.this.bHd();
            }
        };
        this.dNP = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                b.this.kD(false);
                return true;
            }
        };
        this.dNO = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (b.this.fHb != null) {
                    b.this.fHb.setLooping(false);
                    b.this.fHb.setVolume(0.0f, 0.0f);
                    if (b.this.fGW != null && b.this.fGW.ajX != null) {
                        if (b.this.fGT) {
                            if (b.this.fHi != null) {
                                b.this.fHi.R(b.this.fGW.ajX);
                            }
                        } else {
                            aq aqVar = new aq("c12646");
                            if (b.this.fGW.fGn != 0) {
                                if (b.this.fGW.fGn == 1) {
                                    aqVar.ai("obj_type", 2);
                                }
                            } else {
                                aqVar.ai("obj_type", 1);
                            }
                            aqVar.dF("tid", b.this.fGW.ajX.getTid());
                            TiebaStatic.log(aqVar);
                        }
                    }
                    if (b.this.fHb.getCyberPlayer() != null) {
                        b.this.bC(b.this.fHb.getCyberPlayer().getVideoHeight(), b.this.fHb.getCyberPlayer().getVideoWidth());
                    }
                    if (b.this.fHa != null) {
                        b.this.fHa.bGX();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.fGW != null && b.this.fGW.ajX != null) {
                    if (b.this.fHi != null) {
                        b.this.fHi.Q(b.this.fGW.ajX);
                    }
                    b.this.a(b.this.ehG, b.this.fGW.ajX);
                }
            }
        };
        this.ehG = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.fGT = z;
        this.fHa.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.ehG != null) {
            this.ahP = (FrameLayout) LayoutInflater.from(this.ehG.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.fHd = l.getEquipmentWidth(this.ehG.getPageActivity());
            this.fHe = l.getEquipmentHeight(this.ehG.getPageActivity());
            this.fHf = (int) ((this.fHd / 16.0d) * 9.0d);
            this.fHg = (int) ((this.fHd / 4.0d) * 3.0d);
            this.fHj = (int) ((this.fHe / 3.0d) - (this.fHg / 2.0d));
            this.fHa = (AlaSquareLiveVideoMask) this.ahP.findViewById(R.id.video_mask);
            this.ahP.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.fHi = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.ajX != null && cVar.ajX.bfS() != null) {
            if (this.fGW == null || (this.fGW.ajX != null && !this.fGW.ajX.getTid().equals(cVar.ajX.getTid()))) {
                sT(cVar.ajX.bfS().screen_direction);
            }
            this.fGW = cVar;
            this.aFR = this.fGW.ajX.bfS().screen_direction;
            this.fHa.setData(this.fGW.ajX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(int i, int i2) {
        int i3;
        int i4;
        if (this.aFR == 1 && this.fHb != null && this.fHb.getParent() != null) {
            float f = i / i2;
            float f2 = (this.fHd * i) / this.fHe;
            if (f2 < i2) {
                i3 = (int) (this.fHe / f);
                i4 = this.fHe;
            } else if (f2 > i2) {
                i3 = this.fHd;
                i4 = (int) (f * this.fHd);
            } else {
                i3 = this.fHd;
                i4 = this.fHe;
            }
            if (this.fHb.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fHb.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.fHb.setLayoutParams(layoutParams);
                return;
            }
            this.fHb.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void sS(int i) {
        if (this.fHb != null) {
            if (i == 1) {
                if (this.fHb.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fHb.getLayoutParams();
                    layoutParams.width = this.fHd;
                    layoutParams.height = this.fHe;
                    layoutParams.topMargin = -this.fHj;
                    this.fHb.setLayoutParams(layoutParams);
                    return;
                }
                this.fHb.setLayoutParams(new FrameLayout.LayoutParams(this.fHd, this.fHe));
            } else if (this.fHb.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fHb.getLayoutParams();
                layoutParams2.width = this.fHd;
                layoutParams2.height = this.fHf;
                this.fHb.setLayoutParams(layoutParams2);
            } else {
                this.fHb.setLayoutParams(new FrameLayout.LayoutParams(this.fHd, this.fHf));
            }
        }
    }

    private void sT(int i) {
        if (i == 1) {
            if (this.fGT) {
                if (this.ahP.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ahP.getLayoutParams();
                    layoutParams.width = this.fHd;
                    layoutParams.height = this.fHg;
                    this.ahP.setLayoutParams(layoutParams);
                    return;
                }
                this.ahP.setLayoutParams(new FrameLayout.LayoutParams(this.fHd, this.fHg));
                return;
            } else if (this.ahP.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ahP.getLayoutParams();
                layoutParams2.width = this.fHd;
                layoutParams2.height = this.fHd;
                this.ahP.setLayoutParams(layoutParams2);
                return;
            } else {
                this.ahP.setLayoutParams(new AbsListView.LayoutParams(this.fHd, this.fHd));
                return;
            }
        }
        this.aFR = 2;
        if (this.fGT) {
            if (this.ahP.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.ahP.getLayoutParams();
                layoutParams3.width = this.fHd;
                layoutParams3.height = this.fHf;
                this.ahP.setLayoutParams(layoutParams3);
                return;
            }
            this.ahP.setLayoutParams(new AbsListView.LayoutParams(this.fHd, this.fHf));
        } else if (this.ahP.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.ahP.getLayoutParams();
            layoutParams4.width = this.fHd;
            layoutParams4.height = this.fHf;
            this.ahP.setLayoutParams(layoutParams4);
        } else {
            this.ahP.setLayoutParams(new AbsListView.LayoutParams(this.fHd, this.fHf));
        }
    }

    public void bHc() {
        this.fHd = l.getEquipmentWidth(this.ehG.getPageActivity());
        this.fHe = l.getEquipmentHeight(this.ehG.getPageActivity());
        this.fHf = (int) ((this.fHd / 16.0d) * 9.0d);
        this.fHg = (int) ((this.fHd / 4.0d) * 3.0d);
        this.fHj = (int) ((this.fHe / 3.0d) - (this.fHg / 2.0d));
        if (this.fGW != null) {
            boolean isPlaying = this.fHb == null ? false : this.fHb.isPlaying();
            sT(this.fGW.ajX.bfS().screen_direction);
            sS(this.fGW.ajX.bfS().screen_direction);
            bHd();
            if (isPlaying) {
                EZ(this.fHh);
            }
        }
    }

    public void bHd() {
        kD(true);
    }

    public void kD(boolean z) {
        if (z) {
            bHe();
        }
        if (this.fHb != null) {
            this.fHb.stopPlayback();
        }
        this.fHa.bGY();
        this.fHa.bGZ();
    }

    private void bHe() {
        if (this.fHc != null) {
            this.fHc.setPlayer(null);
            this.fHc.stop();
            this.fHc = null;
        }
        if (this.fHb != null) {
            this.fHb.stopPlayback();
            this.fHb.dnY();
            if (this.fHb.getMediaProgressObserver() != null) {
                this.fHb.getMediaProgressObserver().setPlayer(null);
                this.fHb.getMediaProgressObserver().stop();
            }
            this.fHb = null;
        }
    }

    private void bHf() {
        if (this.fGW != null && this.fGW.ajX != null && this.fGW.ajX.bfS() != null) {
            if (this.fHb != null && this.fHb.getParent() != null) {
                bHe();
            }
            this.fHc = new f();
            this.fHb = new TbCyberVideoView(this.ehG.getPageActivity());
            this.fHb.setOnPreparedListener(this.dNO);
            this.fHb.setOnErrorListener(this.dNP);
            this.fHb.setOnSurfaceDestroyedListener(this.ffg);
            this.fHb.setVolume(0.0f, 0.0f);
            this.fHb.setStageType(null);
            this.fHc.setPlayer(this.fHb);
            this.fHc.a(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.f.c
                public void bHg() {
                }
            });
            if (this.fHb.getParent() == null) {
                this.ahP.addView(this.fHb, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            sS(this.fGW.ajX.bfS().screen_direction);
        }
    }

    public void EZ(String str) {
        if (!StringUtils.isNull(str) && this.fGW != null && this.fGW.ajX != null && this.fGW.ajX.bfS() != null) {
            if (!str.equals(this.fHh) || (this.fHb != null && !this.fHb.isPlaying())) {
                this.fHh = str;
                bHd();
            }
            if (this.fHb == null) {
                bHf();
            }
            if (this.fHb != null && !this.fHb.isPlaying()) {
                o oVar = new o();
                oVar.mLocate = "9";
                oVar.eYo = String.valueOf(this.fGW.ajX.getFid());
                oVar.alA = this.fGW.ajX.getTid();
                this.fHb.setVideoStatData(oVar);
                if (this.fHb != null) {
                    this.fHb.setVideoPath(this.fGW.ajX.bfS().hls_url);
                }
                if (this.fHb != null) {
                    this.fHb.start();
                }
                if (this.fHc != null) {
                    this.fHc.start();
                }
            }
        }
    }

    public View getView() {
        return this.ahP;
    }

    public void onDestroy() {
        bHe();
        if (this.fHa != null) {
            this.fHa.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.fHa != null) {
            this.fHa.bqC();
        }
        ap.setBackgroundColor(this.fHb, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bw bwVar) {
        String str;
        if (tbPageContext != null && bwVar != null && bwVar.bfy() != null && bwVar.bfS() != null) {
            if (this.fGW != null && this.fGW.ajX != null && !this.fGT) {
                aq aqVar = new aq("c12645");
                if (this.fGW.fGn == 0) {
                    aqVar.ai("obj_type", 1);
                } else if (this.fGW.fGn == 1) {
                    aqVar.ai("obj_type", 2);
                }
                aqVar.dF("tid", this.fGW.ajX.getTid());
                TiebaStatic.log(aqVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.bfy().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.fGT) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.bfS());
            alaLiveInfoCoreData.userName = bwVar.bfS().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
