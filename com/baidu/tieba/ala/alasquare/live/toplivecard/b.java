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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.b.c;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.o;
/* loaded from: classes10.dex */
public class b {
    private int aKb;
    private FrameLayout aiT;
    private CyberPlayerManager.OnPreparedListener eAA;
    private CyberPlayerManager.OnErrorListener eAB;
    private TbPageContext<?> eUY;
    private TbCyberVideoView.a fUi;
    private boolean gAd;
    private c gAg;
    private final float gAj;
    private AlaSquareLiveVideoMask gAk;
    private TbCyberVideoView gAl;
    private f gAm;
    private int gAn;
    private int gAo;
    private int gAp;
    private int gAq;
    private String gAr;
    private a gAs;
    private int gAt;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes10.dex */
    public interface a {
        void U(cb cbVar);

        void V(cb cbVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.gAj = 0.0f;
        this.eUY = null;
        this.gAr = "";
        this.gAd = false;
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                b.this.bRs();
            }
        };
        this.eAB = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                b.this.mv(false);
                return true;
            }
        };
        this.eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (b.this.gAl != null) {
                    b.this.gAl.setLooping(false);
                    b.this.gAl.setVolume(0.0f, 0.0f);
                    if (b.this.gAg != null && b.this.gAg.akU != null) {
                        if (b.this.gAd) {
                            if (b.this.gAs != null) {
                                b.this.gAs.V(b.this.gAg.akU);
                            }
                        } else {
                            ar arVar = new ar("c12646");
                            if (b.this.gAg.gzx != 0) {
                                if (b.this.gAg.gzx == 1) {
                                    arVar.ap("obj_type", 2);
                                }
                            } else {
                                arVar.ap("obj_type", 1);
                            }
                            arVar.dR("tid", b.this.gAg.akU.getTid());
                            TiebaStatic.log(arVar);
                        }
                    }
                    if (b.this.gAl.getCyberPlayer() != null) {
                        b.this.bB(b.this.gAl.getCyberPlayer().getVideoHeight(), b.this.gAl.getCyberPlayer().getVideoWidth());
                    }
                    if (b.this.gAk != null) {
                        b.this.gAk.bRm();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gAg != null && b.this.gAg.akU != null) {
                    if (b.this.gAs != null) {
                        b.this.gAs.U(b.this.gAg.akU);
                    }
                    b.this.a(b.this.eUY, b.this.gAg.akU);
                }
            }
        };
        this.eUY = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.gAd = z;
        this.gAk.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.eUY != null) {
            this.aiT = (FrameLayout) LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.gAn = l.getEquipmentWidth(this.eUY.getPageActivity());
            this.gAo = l.getEquipmentHeight(this.eUY.getPageActivity());
            this.gAp = (int) ((this.gAn / 16.0d) * 9.0d);
            this.gAq = (int) ((this.gAn / 4.0d) * 3.0d);
            this.gAt = (int) ((this.gAo / 3.0d) - (this.gAq / 2.0d));
            this.gAk = (AlaSquareLiveVideoMask) this.aiT.findViewById(R.id.video_mask);
            this.aiT.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.gAs = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.akU != null && cVar.akU.boj() != null) {
            if (this.gAg == null || (this.gAg.akU != null && !this.gAg.akU.getTid().equals(cVar.akU.getTid()))) {
                tI(cVar.akU.boj().screen_direction);
            }
            this.gAg = cVar;
            this.aKb = this.gAg.akU.boj().screen_direction;
            this.gAk.setData(this.gAg.akU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(int i, int i2) {
        int i3;
        int i4;
        if (this.aKb == 1 && this.gAl != null && this.gAl.getParent() != null) {
            float f = i / i2;
            float f2 = (this.gAn * i) / this.gAo;
            if (f2 < i2) {
                i3 = (int) (this.gAo / f);
                i4 = this.gAo;
            } else if (f2 > i2) {
                i3 = this.gAn;
                i4 = (int) (f * this.gAn);
            } else {
                i3 = this.gAn;
                i4 = this.gAo;
            }
            if (this.gAl.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gAl.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.gAl.setLayoutParams(layoutParams);
                return;
            }
            this.gAl.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void tH(int i) {
        if (this.gAl != null) {
            if (i == 1) {
                if (this.gAl.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gAl.getLayoutParams();
                    layoutParams.width = this.gAn;
                    layoutParams.height = this.gAo;
                    layoutParams.topMargin = -this.gAt;
                    this.gAl.setLayoutParams(layoutParams);
                    return;
                }
                this.gAl.setLayoutParams(new FrameLayout.LayoutParams(this.gAn, this.gAo));
            } else if (this.gAl.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gAl.getLayoutParams();
                layoutParams2.width = this.gAn;
                layoutParams2.height = this.gAp;
                this.gAl.setLayoutParams(layoutParams2);
            } else {
                this.gAl.setLayoutParams(new FrameLayout.LayoutParams(this.gAn, this.gAp));
            }
        }
    }

    private void tI(int i) {
        if (i == 1) {
            if (this.gAd) {
                if (this.aiT.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aiT.getLayoutParams();
                    layoutParams.width = this.gAn;
                    layoutParams.height = this.gAq;
                    this.aiT.setLayoutParams(layoutParams);
                    return;
                }
                this.aiT.setLayoutParams(new FrameLayout.LayoutParams(this.gAn, this.gAq));
                return;
            } else if (this.aiT.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aiT.getLayoutParams();
                layoutParams2.width = this.gAn;
                layoutParams2.height = this.gAn;
                this.aiT.setLayoutParams(layoutParams2);
                return;
            } else {
                this.aiT.setLayoutParams(new AbsListView.LayoutParams(this.gAn, this.gAn));
                return;
            }
        }
        this.aKb = 2;
        if (this.gAd) {
            if (this.aiT.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.aiT.getLayoutParams();
                layoutParams3.width = this.gAn;
                layoutParams3.height = this.gAp;
                this.aiT.setLayoutParams(layoutParams3);
                return;
            }
            this.aiT.setLayoutParams(new AbsListView.LayoutParams(this.gAn, this.gAp));
        } else if (this.aiT.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.aiT.getLayoutParams();
            layoutParams4.width = this.gAn;
            layoutParams4.height = this.gAp;
            this.aiT.setLayoutParams(layoutParams4);
        } else {
            this.aiT.setLayoutParams(new AbsListView.LayoutParams(this.gAn, this.gAp));
        }
    }

    public void bRr() {
        this.gAn = l.getEquipmentWidth(this.eUY.getPageActivity());
        this.gAo = l.getEquipmentHeight(this.eUY.getPageActivity());
        this.gAp = (int) ((this.gAn / 16.0d) * 9.0d);
        this.gAq = (int) ((this.gAn / 4.0d) * 3.0d);
        this.gAt = (int) ((this.gAo / 3.0d) - (this.gAq / 2.0d));
        if (this.gAg != null) {
            boolean isPlaying = this.gAl == null ? false : this.gAl.isPlaying();
            tI(this.gAg.akU.boj().screen_direction);
            tH(this.gAg.akU.boj().screen_direction);
            bRs();
            if (isPlaying) {
                FX(this.gAr);
            }
        }
    }

    public void bRs() {
        mv(true);
    }

    public void mv(boolean z) {
        if (z) {
            bRt();
        }
        if (this.gAl != null) {
            this.gAl.stopPlayback();
        }
        this.gAk.bRn();
        this.gAk.bRo();
    }

    private void bRt() {
        if (this.gAm != null) {
            this.gAm.setPlayer(null);
            this.gAm.stop();
            this.gAm = null;
        }
        if (this.gAl != null) {
            this.gAl.stopPlayback();
            this.gAl.dAy();
            if (this.gAl.getMediaProgressObserver() != null) {
                this.gAl.getMediaProgressObserver().setPlayer(null);
                this.gAl.getMediaProgressObserver().stop();
            }
            this.gAl = null;
        }
    }

    private void bRu() {
        if (this.gAg != null && this.gAg.akU != null && this.gAg.akU.boj() != null) {
            if (this.gAl != null && this.gAl.getParent() != null) {
                bRt();
            }
            this.gAm = new f();
            this.gAl = new TbCyberVideoView(this.eUY.getPageActivity());
            this.gAl.setOnPreparedListener(this.eAA);
            this.gAl.setOnErrorListener(this.eAB);
            this.gAl.setOnSurfaceDestroyedListener(this.fUi);
            this.gAl.setVolume(0.0f, 0.0f);
            this.gAl.setStageType(null);
            this.gAm.setPlayer(this.gAl);
            this.gAm.a(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.f.c
                public void bRv() {
                }
            });
            if (this.gAl.getParent() == null) {
                this.aiT.addView(this.gAl, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            tH(this.gAg.akU.boj().screen_direction);
        }
    }

    public void FX(String str) {
        if (!StringUtils.isNull(str) && this.gAg != null && this.gAg.akU != null && this.gAg.akU.boj() != null) {
            if (!str.equals(this.gAr) || (this.gAl != null && !this.gAl.isPlaying())) {
                this.gAr = str;
                bRs();
            }
            if (this.gAl == null) {
                bRu();
            }
            if (this.gAl != null && !this.gAl.isPlaying()) {
                o oVar = new o();
                oVar.mLocate = "9";
                oVar.fNd = String.valueOf(this.gAg.akU.getFid());
                oVar.amC = this.gAg.akU.getTid();
                this.gAl.setVideoStatData(oVar);
                if (this.gAl != null) {
                    this.gAl.setVideoPath(this.gAg.akU.boj().hls_url);
                }
                if (this.gAl != null) {
                    this.gAl.start();
                }
                if (this.gAm != null) {
                    this.gAm.start();
                }
            }
        }
    }

    public View getView() {
        return this.aiT;
    }

    public void onDestroy() {
        bRt();
        if (this.gAk != null) {
            this.gAk.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.gAk != null) {
            this.gAk.bzn();
        }
        ap.setBackgroundColor(this.gAl, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, cb cbVar) {
        String str;
        if (tbPageContext != null && cbVar != null && cbVar.bnQ() != null && cbVar.boj() != null) {
            if (this.gAg != null && this.gAg.akU != null && !this.gAd) {
                ar arVar = new ar("c12645");
                if (this.gAg.gzx == 0) {
                    arVar.ap("obj_type", 1);
                } else if (this.gAg.gzx == 1) {
                    arVar.ap("obj_type", 2);
                }
                arVar.dR("tid", this.gAg.akU.getTid());
                TiebaStatic.log(arVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = cbVar.bnQ().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.gAd) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(cbVar.boj());
            alaLiveInfoCoreData.userName = cbVar.boj().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
