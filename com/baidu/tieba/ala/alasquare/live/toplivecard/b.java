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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.b.c;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.o;
/* loaded from: classes4.dex */
public class b {
    private FrameLayout agl;
    private int azt;
    private CyberPlayerManager.OnPreparedListener dCx;
    private CyberPlayerManager.OnErrorListener dCy;
    private TbPageContext<?> dVN;
    private TbCyberVideoView.a eRD;
    private boolean fsj;
    private c fsm;
    private final float fsp;
    private AlaSquareLiveVideoMask fsq;
    private TbCyberVideoView fsr;
    private f fss;
    private int fst;
    private int fsu;
    private int fsv;
    private int fsw;
    private String fsx;
    private a fsy;
    private int fsz;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes4.dex */
    public interface a {
        void P(bv bvVar);

        void Q(bv bvVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.fsp = 0.0f;
        this.dVN = null;
        this.fsx = "";
        this.fsj = false;
        this.eRD = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                b.this.bwN();
            }
        };
        this.dCy = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                b.this.kb(false);
                return true;
            }
        };
        this.dCx = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (b.this.fsr != null) {
                    b.this.fsr.setLooping(false);
                    b.this.fsr.setVolume(0.0f, 0.0f);
                    if (b.this.fsm != null && b.this.fsm.aii != null) {
                        if (b.this.fsj) {
                            if (b.this.fsy != null) {
                                b.this.fsy.Q(b.this.fsm.aii);
                            }
                        } else {
                            ap apVar = new ap("c12646");
                            if (b.this.fsm.frD != 0) {
                                if (b.this.fsm.frD == 1) {
                                    apVar.ah("obj_type", 2);
                                }
                            } else {
                                apVar.ah("obj_type", 1);
                            }
                            apVar.dn("tid", b.this.fsm.aii.getTid());
                            TiebaStatic.log(apVar);
                        }
                    }
                    if (b.this.fsr.getCyberPlayer() != null) {
                        b.this.bt(b.this.fsr.getCyberPlayer().getVideoHeight(), b.this.fsr.getCyberPlayer().getVideoWidth());
                    }
                    if (b.this.fsq != null) {
                        b.this.fsq.bwH();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.fsm != null && b.this.fsm.aii != null) {
                    if (b.this.fsy != null) {
                        b.this.fsy.P(b.this.fsm.aii);
                    }
                    b.this.a(b.this.dVN, b.this.fsm.aii);
                }
            }
        };
        this.dVN = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.fsj = z;
        this.fsq.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.dVN != null) {
            this.agl = (FrameLayout) LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.fst = l.getEquipmentWidth(this.dVN.getPageActivity());
            this.fsu = l.getEquipmentHeight(this.dVN.getPageActivity());
            this.fsv = (int) ((this.fst / 16.0d) * 9.0d);
            this.fsw = (int) ((this.fst / 4.0d) * 3.0d);
            this.fsz = (int) ((this.fsu / 3.0d) - (this.fsw / 2.0d));
            this.fsq = (AlaSquareLiveVideoMask) this.agl.findViewById(R.id.video_mask);
            this.agl.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.fsy = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.aii != null && cVar.aii.aWF() != null) {
            if (this.fsm == null || (this.fsm.aii != null && !this.fsm.aii.getTid().equals(cVar.aii.getTid()))) {
                qp(cVar.aii.aWF().screen_direction);
            }
            this.fsm = cVar;
            this.azt = this.fsm.aii.aWF().screen_direction;
            this.fsq.setData(this.fsm.aii);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(int i, int i2) {
        int i3;
        int i4;
        if (this.azt == 1 && this.fsr != null && this.fsr.getParent() != null) {
            float f = i / i2;
            float f2 = (this.fst * i) / this.fsu;
            if (f2 < i2) {
                i3 = (int) (this.fsu / f);
                i4 = this.fsu;
            } else if (f2 > i2) {
                i3 = this.fst;
                i4 = (int) (f * this.fst);
            } else {
                i3 = this.fst;
                i4 = this.fsu;
            }
            if (this.fsr.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fsr.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.fsr.setLayoutParams(layoutParams);
                return;
            }
            this.fsr.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void qo(int i) {
        if (this.fsr != null) {
            if (i == 1) {
                if (this.fsr.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fsr.getLayoutParams();
                    layoutParams.width = this.fst;
                    layoutParams.height = this.fsu;
                    layoutParams.topMargin = -this.fsz;
                    this.fsr.setLayoutParams(layoutParams);
                    return;
                }
                this.fsr.setLayoutParams(new FrameLayout.LayoutParams(this.fst, this.fsu));
            } else if (this.fsr.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fsr.getLayoutParams();
                layoutParams2.width = this.fst;
                layoutParams2.height = this.fsv;
                this.fsr.setLayoutParams(layoutParams2);
            } else {
                this.fsr.setLayoutParams(new FrameLayout.LayoutParams(this.fst, this.fsv));
            }
        }
    }

    private void qp(int i) {
        if (i == 1) {
            if (this.fsj) {
                if (this.agl.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.agl.getLayoutParams();
                    layoutParams.width = this.fst;
                    layoutParams.height = this.fsw;
                    this.agl.setLayoutParams(layoutParams);
                    return;
                }
                this.agl.setLayoutParams(new FrameLayout.LayoutParams(this.fst, this.fsw));
                return;
            } else if (this.agl.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.agl.getLayoutParams();
                layoutParams2.width = this.fst;
                layoutParams2.height = this.fst;
                this.agl.setLayoutParams(layoutParams2);
                return;
            } else {
                this.agl.setLayoutParams(new AbsListView.LayoutParams(this.fst, this.fst));
                return;
            }
        }
        this.azt = 2;
        if (this.fsj) {
            if (this.agl.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.agl.getLayoutParams();
                layoutParams3.width = this.fst;
                layoutParams3.height = this.fsv;
                this.agl.setLayoutParams(layoutParams3);
                return;
            }
            this.agl.setLayoutParams(new AbsListView.LayoutParams(this.fst, this.fsv));
        } else if (this.agl.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.agl.getLayoutParams();
            layoutParams4.width = this.fst;
            layoutParams4.height = this.fsv;
            this.agl.setLayoutParams(layoutParams4);
        } else {
            this.agl.setLayoutParams(new AbsListView.LayoutParams(this.fst, this.fsv));
        }
    }

    public void bwM() {
        this.fst = l.getEquipmentWidth(this.dVN.getPageActivity());
        this.fsu = l.getEquipmentHeight(this.dVN.getPageActivity());
        this.fsv = (int) ((this.fst / 16.0d) * 9.0d);
        this.fsw = (int) ((this.fst / 4.0d) * 3.0d);
        this.fsz = (int) ((this.fsu / 3.0d) - (this.fsw / 2.0d));
        if (this.fsm != null) {
            boolean isPlaying = this.fsr == null ? false : this.fsr.isPlaying();
            qp(this.fsm.aii.aWF().screen_direction);
            qo(this.fsm.aii.aWF().screen_direction);
            bwN();
            if (isPlaying) {
                Cg(this.fsx);
            }
        }
    }

    public void bwN() {
        kb(true);
    }

    public void kb(boolean z) {
        if (z) {
            bwO();
        }
        if (this.fsr != null) {
            this.fsr.stopPlayback();
        }
        this.fsq.bwI();
        this.fsq.bwJ();
    }

    private void bwO() {
        if (this.fss != null) {
            this.fss.setPlayer(null);
            this.fss.stop();
            this.fss = null;
        }
        if (this.fsr != null) {
            this.fsr.stopPlayback();
            this.fsr.cZk();
            if (this.fsr.getMediaProgressObserver() != null) {
                this.fsr.getMediaProgressObserver().setPlayer(null);
                this.fsr.getMediaProgressObserver().stop();
            }
            this.fsr = null;
        }
    }

    private void bwP() {
        if (this.fsm != null && this.fsm.aii != null && this.fsm.aii.aWF() != null) {
            if (this.fsr != null && this.fsr.getParent() != null) {
                bwO();
            }
            this.fss = new f();
            this.fsr = new TbCyberVideoView(this.dVN.getPageActivity());
            this.fsr.setOnPreparedListener(this.dCx);
            this.fsr.setOnErrorListener(this.dCy);
            this.fsr.setOnSurfaceDestroyedListener(this.eRD);
            this.fsr.setVolume(0.0f, 0.0f);
            this.fss.setPlayer(this.fsr);
            this.fss.a(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.f.c
                public void bwQ() {
                }
            });
            if (this.fsr.getParent() == null) {
                this.agl.addView(this.fsr, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            qo(this.fsm.aii.aWF().screen_direction);
        }
    }

    public void Cg(String str) {
        if (!StringUtils.isNull(str) && this.fsm != null && this.fsm.aii != null && this.fsm.aii.aWF() != null) {
            if (!str.equals(this.fsx) || (this.fsr != null && !this.fsr.isPlaying())) {
                this.fsx = str;
                bwN();
            }
            if (this.fsr == null) {
                bwP();
            }
            if (this.fsr != null && !this.fsr.isPlaying()) {
                o oVar = new o();
                oVar.mLocate = "9";
                oVar.eKO = String.valueOf(this.fsm.aii.getFid());
                oVar.ajJ = this.fsm.aii.getTid();
                this.fsr.setVideoStatData(oVar);
                if (this.fsr != null) {
                    this.fsr.setVideoPath(this.fsm.aii.aWF().hls_url);
                }
                if (this.fsr != null) {
                    this.fsr.start();
                }
                if (this.fss != null) {
                    this.fss.start();
                }
            }
        }
    }

    public View getView() {
        return this.agl;
    }

    public void onDestroy() {
        bwO();
        if (this.fsq != null) {
            this.fsq.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.fsq != null) {
            this.fsq.bgV();
        }
        ao.setBackgroundColor(this.fsr, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bv bvVar) {
        String str;
        if (tbPageContext != null && bvVar != null && bvVar.aWl() != null && bvVar.aWF() != null) {
            if (this.fsm != null && this.fsm.aii != null && !this.fsj) {
                ap apVar = new ap("c12645");
                if (this.fsm.frD == 0) {
                    apVar.ah("obj_type", 1);
                } else if (this.fsm.frD == 1) {
                    apVar.ah("obj_type", 2);
                }
                apVar.dn("tid", this.fsm.aii.getTid());
                TiebaStatic.log(apVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bvVar.aWl().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.fsj) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bvVar.aWF());
            alaLiveInfoCoreData.userName = bvVar.aWF().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
