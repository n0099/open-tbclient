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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.b.c;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.o;
/* loaded from: classes4.dex */
public class b {
    private int aIM;
    private FrameLayout ail;
    private TbPageContext<?> eGu;
    private CyberPlayerManager.OnPreparedListener emw;
    private CyberPlayerManager.OnErrorListener emx;
    private TbCyberVideoView.a fFk;
    private boolean giC;
    private c giF;
    private final float giI;
    private AlaSquareLiveVideoMask giJ;
    private TbCyberVideoView giK;
    private f giL;
    private int giM;
    private int giN;
    private int giO;
    private int giP;
    private String giQ;
    private a giR;
    private int giS;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes4.dex */
    public interface a {
        void S(bx bxVar);

        void T(bx bxVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.giI = 0.0f;
        this.eGu = null;
        this.giQ = "";
        this.giC = false;
        this.fFk = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                b.this.bOk();
            }
        };
        this.emx = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                b.this.lD(false);
                return true;
            }
        };
        this.emw = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (b.this.giK != null) {
                    b.this.giK.setLooping(false);
                    b.this.giK.setVolume(0.0f, 0.0f);
                    if (b.this.giF != null && b.this.giF.akt != null) {
                        if (b.this.giC) {
                            if (b.this.giR != null) {
                                b.this.giR.T(b.this.giF.akt);
                            }
                        } else {
                            ar arVar = new ar("c12646");
                            if (b.this.giF.ghV != 0) {
                                if (b.this.giF.ghV == 1) {
                                    arVar.ak("obj_type", 2);
                                }
                            } else {
                                arVar.ak("obj_type", 1);
                            }
                            arVar.dR("tid", b.this.giF.akt.getTid());
                            TiebaStatic.log(arVar);
                        }
                    }
                    if (b.this.giK.getCyberPlayer() != null) {
                        b.this.bD(b.this.giK.getCyberPlayer().getVideoHeight(), b.this.giK.getCyberPlayer().getVideoWidth());
                    }
                    if (b.this.giJ != null) {
                        b.this.giJ.bOe();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.giF != null && b.this.giF.akt != null) {
                    if (b.this.giR != null) {
                        b.this.giR.S(b.this.giF.akt);
                    }
                    b.this.a(b.this.eGu, b.this.giF.akt);
                }
            }
        };
        this.eGu = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.giC = z;
        this.giJ.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.eGu != null) {
            this.ail = (FrameLayout) LayoutInflater.from(this.eGu.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.giM = l.getEquipmentWidth(this.eGu.getPageActivity());
            this.giN = l.getEquipmentHeight(this.eGu.getPageActivity());
            this.giO = (int) ((this.giM / 16.0d) * 9.0d);
            this.giP = (int) ((this.giM / 4.0d) * 3.0d);
            this.giS = (int) ((this.giN / 3.0d) - (this.giP / 2.0d));
            this.giJ = (AlaSquareLiveVideoMask) this.ail.findViewById(R.id.video_mask);
            this.ail.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.giR = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.akt != null && cVar.akt.blW() != null) {
            if (this.giF == null || (this.giF.akt != null && !this.giF.akt.getTid().equals(cVar.akt.getTid()))) {
                us(cVar.akt.blW().screen_direction);
            }
            this.giF = cVar;
            this.aIM = this.giF.akt.blW().screen_direction;
            this.giJ.setData(this.giF.akt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(int i, int i2) {
        int i3;
        int i4;
        if (this.aIM == 1 && this.giK != null && this.giK.getParent() != null) {
            float f = i / i2;
            float f2 = (this.giM * i) / this.giN;
            if (f2 < i2) {
                i3 = (int) (this.giN / f);
                i4 = this.giN;
            } else if (f2 > i2) {
                i3 = this.giM;
                i4 = (int) (f * this.giM);
            } else {
                i3 = this.giM;
                i4 = this.giN;
            }
            if (this.giK.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.giK.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.giK.setLayoutParams(layoutParams);
                return;
            }
            this.giK.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void ur(int i) {
        if (this.giK != null) {
            if (i == 1) {
                if (this.giK.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.giK.getLayoutParams();
                    layoutParams.width = this.giM;
                    layoutParams.height = this.giN;
                    layoutParams.topMargin = -this.giS;
                    this.giK.setLayoutParams(layoutParams);
                    return;
                }
                this.giK.setLayoutParams(new FrameLayout.LayoutParams(this.giM, this.giN));
            } else if (this.giK.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.giK.getLayoutParams();
                layoutParams2.width = this.giM;
                layoutParams2.height = this.giO;
                this.giK.setLayoutParams(layoutParams2);
            } else {
                this.giK.setLayoutParams(new FrameLayout.LayoutParams(this.giM, this.giO));
            }
        }
    }

    private void us(int i) {
        if (i == 1) {
            if (this.giC) {
                if (this.ail.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ail.getLayoutParams();
                    layoutParams.width = this.giM;
                    layoutParams.height = this.giP;
                    this.ail.setLayoutParams(layoutParams);
                    return;
                }
                this.ail.setLayoutParams(new FrameLayout.LayoutParams(this.giM, this.giP));
                return;
            } else if (this.ail.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ail.getLayoutParams();
                layoutParams2.width = this.giM;
                layoutParams2.height = this.giM;
                this.ail.setLayoutParams(layoutParams2);
                return;
            } else {
                this.ail.setLayoutParams(new AbsListView.LayoutParams(this.giM, this.giM));
                return;
            }
        }
        this.aIM = 2;
        if (this.giC) {
            if (this.ail.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.ail.getLayoutParams();
                layoutParams3.width = this.giM;
                layoutParams3.height = this.giO;
                this.ail.setLayoutParams(layoutParams3);
                return;
            }
            this.ail.setLayoutParams(new AbsListView.LayoutParams(this.giM, this.giO));
        } else if (this.ail.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.ail.getLayoutParams();
            layoutParams4.width = this.giM;
            layoutParams4.height = this.giO;
            this.ail.setLayoutParams(layoutParams4);
        } else {
            this.ail.setLayoutParams(new AbsListView.LayoutParams(this.giM, this.giO));
        }
    }

    public void bOj() {
        this.giM = l.getEquipmentWidth(this.eGu.getPageActivity());
        this.giN = l.getEquipmentHeight(this.eGu.getPageActivity());
        this.giO = (int) ((this.giM / 16.0d) * 9.0d);
        this.giP = (int) ((this.giM / 4.0d) * 3.0d);
        this.giS = (int) ((this.giN / 3.0d) - (this.giP / 2.0d));
        if (this.giF != null) {
            boolean isPlaying = this.giK == null ? false : this.giK.isPlaying();
            us(this.giF.akt.blW().screen_direction);
            ur(this.giF.akt.blW().screen_direction);
            bOk();
            if (isPlaying) {
                FY(this.giQ);
            }
        }
    }

    public void bOk() {
        lD(true);
    }

    public void lD(boolean z) {
        if (z) {
            bOl();
        }
        if (this.giK != null) {
            this.giK.stopPlayback();
        }
        this.giJ.bOf();
        this.giJ.bOg();
    }

    private void bOl() {
        if (this.giL != null) {
            this.giL.setPlayer(null);
            this.giL.stop();
            this.giL = null;
        }
        if (this.giK != null) {
            this.giK.stopPlayback();
            this.giK.dwS();
            if (this.giK.getMediaProgressObserver() != null) {
                this.giK.getMediaProgressObserver().setPlayer(null);
                this.giK.getMediaProgressObserver().stop();
            }
            this.giK = null;
        }
    }

    private void bOm() {
        if (this.giF != null && this.giF.akt != null && this.giF.akt.blW() != null) {
            if (this.giK != null && this.giK.getParent() != null) {
                bOl();
            }
            this.giL = new f();
            this.giK = new TbCyberVideoView(this.eGu.getPageActivity());
            this.giK.setOnPreparedListener(this.emw);
            this.giK.setOnErrorListener(this.emx);
            this.giK.setOnSurfaceDestroyedListener(this.fFk);
            this.giK.setVolume(0.0f, 0.0f);
            this.giK.setStageType(null);
            this.giL.setPlayer(this.giK);
            this.giL.a(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.f.c
                public void bOn() {
                }
            });
            if (this.giK.getParent() == null) {
                this.ail.addView(this.giK, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            ur(this.giF.akt.blW().screen_direction);
        }
    }

    public void FY(String str) {
        if (!StringUtils.isNull(str) && this.giF != null && this.giF.akt != null && this.giF.akt.blW() != null) {
            if (!str.equals(this.giQ) || (this.giK != null && !this.giK.isPlaying())) {
                this.giQ = str;
                bOk();
            }
            if (this.giK == null) {
                bOm();
            }
            if (this.giK != null && !this.giK.isPlaying()) {
                o oVar = new o();
                oVar.mLocate = "9";
                oVar.fyg = String.valueOf(this.giF.akt.getFid());
                oVar.alZ = this.giF.akt.getTid();
                this.giK.setVideoStatData(oVar);
                if (this.giK != null) {
                    this.giK.setVideoPath(this.giF.akt.blW().hls_url);
                }
                if (this.giK != null) {
                    this.giK.start();
                }
                if (this.giL != null) {
                    this.giL.start();
                }
            }
        }
    }

    public View getView() {
        return this.ail;
    }

    public void onDestroy() {
        bOl();
        if (this.giJ != null) {
            this.giJ.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.giJ != null) {
            this.giJ.bwU();
        }
        ap.setBackgroundColor(this.giK, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bx bxVar) {
        String str;
        if (tbPageContext != null && bxVar != null && bxVar.blC() != null && bxVar.blW() != null) {
            if (this.giF != null && this.giF.akt != null && !this.giC) {
                ar arVar = new ar("c12645");
                if (this.giF.ghV == 0) {
                    arVar.ak("obj_type", 1);
                } else if (this.giF.ghV == 1) {
                    arVar.ak("obj_type", 2);
                }
                arVar.dR("tid", this.giF.akt.getTid());
                TiebaStatic.log(arVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bxVar.blC().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.giC) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bxVar.blW());
            alaLiveInfoCoreData.userName = bxVar.blW().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
