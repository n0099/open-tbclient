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
    private int aKx;
    private FrameLayout aii;
    private TbPageContext<?> eIc;
    private CyberPlayerManager.OnPreparedListener eog;
    private CyberPlayerManager.OnErrorListener eoh;
    private TbCyberVideoView.a fFI;
    private boolean giV;
    private c giY;
    private final float gjb;
    private AlaSquareLiveVideoMask gjc;
    private TbCyberVideoView gjd;
    private f gje;
    private int gjf;
    private int gjg;
    private int gjh;
    private int gji;
    private String gjj;
    private a gjk;
    private int gjl;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes4.dex */
    public interface a {
        void Q(bw bwVar);

        void R(bw bwVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.gjb = 0.0f;
        this.eIc = null;
        this.gjj = "";
        this.giV = false;
        this.fFI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                b.this.bOR();
            }
        };
        this.eoh = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                b.this.lC(false);
                return true;
            }
        };
        this.eog = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (b.this.gjd != null) {
                    b.this.gjd.setLooping(false);
                    b.this.gjd.setVolume(0.0f, 0.0f);
                    if (b.this.giY != null && b.this.giY.akq != null) {
                        if (b.this.giV) {
                            if (b.this.gjk != null) {
                                b.this.gjk.R(b.this.giY.akq);
                            }
                        } else {
                            aq aqVar = new aq("c12646");
                            if (b.this.giY.gip != 0) {
                                if (b.this.giY.gip == 1) {
                                    aqVar.al("obj_type", 2);
                                }
                            } else {
                                aqVar.al("obj_type", 1);
                            }
                            aqVar.dR("tid", b.this.giY.akq.getTid());
                            TiebaStatic.log(aqVar);
                        }
                    }
                    if (b.this.gjd.getCyberPlayer() != null) {
                        b.this.bD(b.this.gjd.getCyberPlayer().getVideoHeight(), b.this.gjd.getCyberPlayer().getVideoWidth());
                    }
                    if (b.this.gjc != null) {
                        b.this.gjc.bOL();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.giY != null && b.this.giY.akq != null) {
                    if (b.this.gjk != null) {
                        b.this.gjk.Q(b.this.giY.akq);
                    }
                    b.this.a(b.this.eIc, b.this.giY.akq);
                }
            }
        };
        this.eIc = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.giV = z;
        this.gjc.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.eIc != null) {
            this.aii = (FrameLayout) LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.gjf = l.getEquipmentWidth(this.eIc.getPageActivity());
            this.gjg = l.getEquipmentHeight(this.eIc.getPageActivity());
            this.gjh = (int) ((this.gjf / 16.0d) * 9.0d);
            this.gji = (int) ((this.gjf / 4.0d) * 3.0d);
            this.gjl = (int) ((this.gjg / 3.0d) - (this.gji / 2.0d));
            this.gjc = (AlaSquareLiveVideoMask) this.aii.findViewById(R.id.video_mask);
            this.aii.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.gjk = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.akq != null && cVar.akq.bmU() != null) {
            if (this.giY == null || (this.giY.akq != null && !this.giY.akq.getTid().equals(cVar.akq.getTid()))) {
                tU(cVar.akq.bmU().screen_direction);
            }
            this.giY = cVar;
            this.aKx = this.giY.akq.bmU().screen_direction;
            this.gjc.setData(this.giY.akq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(int i, int i2) {
        int i3;
        int i4;
        if (this.aKx == 1 && this.gjd != null && this.gjd.getParent() != null) {
            float f = i / i2;
            float f2 = (this.gjf * i) / this.gjg;
            if (f2 < i2) {
                i3 = (int) (this.gjg / f);
                i4 = this.gjg;
            } else if (f2 > i2) {
                i3 = this.gjf;
                i4 = (int) (f * this.gjf);
            } else {
                i3 = this.gjf;
                i4 = this.gjg;
            }
            if (this.gjd.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gjd.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.gjd.setLayoutParams(layoutParams);
                return;
            }
            this.gjd.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void tT(int i) {
        if (this.gjd != null) {
            if (i == 1) {
                if (this.gjd.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gjd.getLayoutParams();
                    layoutParams.width = this.gjf;
                    layoutParams.height = this.gjg;
                    layoutParams.topMargin = -this.gjl;
                    this.gjd.setLayoutParams(layoutParams);
                    return;
                }
                this.gjd.setLayoutParams(new FrameLayout.LayoutParams(this.gjf, this.gjg));
            } else if (this.gjd.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gjd.getLayoutParams();
                layoutParams2.width = this.gjf;
                layoutParams2.height = this.gjh;
                this.gjd.setLayoutParams(layoutParams2);
            } else {
                this.gjd.setLayoutParams(new FrameLayout.LayoutParams(this.gjf, this.gjh));
            }
        }
    }

    private void tU(int i) {
        if (i == 1) {
            if (this.giV) {
                if (this.aii.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aii.getLayoutParams();
                    layoutParams.width = this.gjf;
                    layoutParams.height = this.gji;
                    this.aii.setLayoutParams(layoutParams);
                    return;
                }
                this.aii.setLayoutParams(new FrameLayout.LayoutParams(this.gjf, this.gji));
                return;
            } else if (this.aii.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aii.getLayoutParams();
                layoutParams2.width = this.gjf;
                layoutParams2.height = this.gjf;
                this.aii.setLayoutParams(layoutParams2);
                return;
            } else {
                this.aii.setLayoutParams(new AbsListView.LayoutParams(this.gjf, this.gjf));
                return;
            }
        }
        this.aKx = 2;
        if (this.giV) {
            if (this.aii.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.aii.getLayoutParams();
                layoutParams3.width = this.gjf;
                layoutParams3.height = this.gjh;
                this.aii.setLayoutParams(layoutParams3);
                return;
            }
            this.aii.setLayoutParams(new AbsListView.LayoutParams(this.gjf, this.gjh));
        } else if (this.aii.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.aii.getLayoutParams();
            layoutParams4.width = this.gjf;
            layoutParams4.height = this.gjh;
            this.aii.setLayoutParams(layoutParams4);
        } else {
            this.aii.setLayoutParams(new AbsListView.LayoutParams(this.gjf, this.gjh));
        }
    }

    public void bOQ() {
        this.gjf = l.getEquipmentWidth(this.eIc.getPageActivity());
        this.gjg = l.getEquipmentHeight(this.eIc.getPageActivity());
        this.gjh = (int) ((this.gjf / 16.0d) * 9.0d);
        this.gji = (int) ((this.gjf / 4.0d) * 3.0d);
        this.gjl = (int) ((this.gjg / 3.0d) - (this.gji / 2.0d));
        if (this.giY != null) {
            boolean isPlaying = this.gjd == null ? false : this.gjd.isPlaying();
            tU(this.giY.akq.bmU().screen_direction);
            tT(this.giY.akq.bmU().screen_direction);
            bOR();
            if (isPlaying) {
                Gx(this.gjj);
            }
        }
    }

    public void bOR() {
        lC(true);
    }

    public void lC(boolean z) {
        if (z) {
            bOS();
        }
        if (this.gjd != null) {
            this.gjd.stopPlayback();
        }
        this.gjc.bOM();
        this.gjc.bON();
    }

    private void bOS() {
        if (this.gje != null) {
            this.gje.setPlayer(null);
            this.gje.stop();
            this.gje = null;
        }
        if (this.gjd != null) {
            this.gjd.stopPlayback();
            this.gjd.dxs();
            if (this.gjd.getMediaProgressObserver() != null) {
                this.gjd.getMediaProgressObserver().setPlayer(null);
                this.gjd.getMediaProgressObserver().stop();
            }
            this.gjd = null;
        }
    }

    private void bOT() {
        if (this.giY != null && this.giY.akq != null && this.giY.akq.bmU() != null) {
            if (this.gjd != null && this.gjd.getParent() != null) {
                bOS();
            }
            this.gje = new f();
            this.gjd = new TbCyberVideoView(this.eIc.getPageActivity());
            this.gjd.setOnPreparedListener(this.eog);
            this.gjd.setOnErrorListener(this.eoh);
            this.gjd.setOnSurfaceDestroyedListener(this.fFI);
            this.gjd.setVolume(0.0f, 0.0f);
            this.gjd.setStageType(null);
            this.gje.setPlayer(this.gjd);
            this.gje.a(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.f.c
                public void bOU() {
                }
            });
            if (this.gjd.getParent() == null) {
                this.aii.addView(this.gjd, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            tT(this.giY.akq.bmU().screen_direction);
        }
    }

    public void Gx(String str) {
        if (!StringUtils.isNull(str) && this.giY != null && this.giY.akq != null && this.giY.akq.bmU() != null) {
            if (!str.equals(this.gjj) || (this.gjd != null && !this.gjd.isPlaying())) {
                this.gjj = str;
                bOR();
            }
            if (this.gjd == null) {
                bOT();
            }
            if (this.gjd != null && !this.gjd.isPlaying()) {
                o oVar = new o();
                oVar.mLocate = "9";
                oVar.fyR = String.valueOf(this.giY.akq.getFid());
                oVar.alT = this.giY.akq.getTid();
                this.gjd.setVideoStatData(oVar);
                if (this.gjd != null) {
                    this.gjd.setVideoPath(this.giY.akq.bmU().hls_url);
                }
                if (this.gjd != null) {
                    this.gjd.start();
                }
                if (this.gje != null) {
                    this.gje.start();
                }
            }
        }
    }

    public View getView() {
        return this.aii;
    }

    public void onDestroy() {
        bOS();
        if (this.gjc != null) {
            this.gjc.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.gjc != null) {
            this.gjc.bxE();
        }
        ap.setBackgroundColor(this.gjd, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bw bwVar) {
        String str;
        if (tbPageContext != null && bwVar != null && bwVar.bmA() != null && bwVar.bmU() != null) {
            if (this.giY != null && this.giY.akq != null && !this.giV) {
                aq aqVar = new aq("c12645");
                if (this.giY.gip == 0) {
                    aqVar.al("obj_type", 1);
                } else if (this.giY.gip == 1) {
                    aqVar.al("obj_type", 2);
                }
                aqVar.dR("tid", this.giY.akq.getTid());
                TiebaStatic.log(aqVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.bmA().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.giV) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.bmU());
            alaLiveInfoCoreData.userName = bwVar.bmU().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
