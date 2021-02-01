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
    private int gAa;
    private int gAb;
    private int gAc;
    private String gAd;
    private a gAe;
    private int gAf;
    private boolean gzP;
    private c gzS;
    private final float gzV;
    private AlaSquareLiveVideoMask gzW;
    private TbCyberVideoView gzX;
    private f gzY;
    private int gzZ;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes10.dex */
    public interface a {
        void U(cb cbVar);

        void V(cb cbVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.gzV = 0.0f;
        this.eUY = null;
        this.gAd = "";
        this.gzP = false;
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                b.this.bRl();
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
                if (b.this.gzX != null) {
                    b.this.gzX.setLooping(false);
                    b.this.gzX.setVolume(0.0f, 0.0f);
                    if (b.this.gzS != null && b.this.gzS.akU != null) {
                        if (b.this.gzP) {
                            if (b.this.gAe != null) {
                                b.this.gAe.V(b.this.gzS.akU);
                            }
                        } else {
                            ar arVar = new ar("c12646");
                            if (b.this.gzS.gzj != 0) {
                                if (b.this.gzS.gzj == 1) {
                                    arVar.ap("obj_type", 2);
                                }
                            } else {
                                arVar.ap("obj_type", 1);
                            }
                            arVar.dR("tid", b.this.gzS.akU.getTid());
                            TiebaStatic.log(arVar);
                        }
                    }
                    if (b.this.gzX.getCyberPlayer() != null) {
                        b.this.bA(b.this.gzX.getCyberPlayer().getVideoHeight(), b.this.gzX.getCyberPlayer().getVideoWidth());
                    }
                    if (b.this.gzW != null) {
                        b.this.gzW.bRf();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gzS != null && b.this.gzS.akU != null) {
                    if (b.this.gAe != null) {
                        b.this.gAe.U(b.this.gzS.akU);
                    }
                    b.this.a(b.this.eUY, b.this.gzS.akU);
                }
            }
        };
        this.eUY = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.gzP = z;
        this.gzW.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.eUY != null) {
            this.aiT = (FrameLayout) LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.gzZ = l.getEquipmentWidth(this.eUY.getPageActivity());
            this.gAa = l.getEquipmentHeight(this.eUY.getPageActivity());
            this.gAb = (int) ((this.gzZ / 16.0d) * 9.0d);
            this.gAc = (int) ((this.gzZ / 4.0d) * 3.0d);
            this.gAf = (int) ((this.gAa / 3.0d) - (this.gAc / 2.0d));
            this.gzW = (AlaSquareLiveVideoMask) this.aiT.findViewById(R.id.video_mask);
            this.aiT.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.gAe = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.akU != null && cVar.akU.boj() != null) {
            if (this.gzS == null || (this.gzS.akU != null && !this.gzS.akU.getTid().equals(cVar.akU.getTid()))) {
                tI(cVar.akU.boj().screen_direction);
            }
            this.gzS = cVar;
            this.aKb = this.gzS.akU.boj().screen_direction;
            this.gzW.setData(this.gzS.akU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(int i, int i2) {
        int i3;
        int i4;
        if (this.aKb == 1 && this.gzX != null && this.gzX.getParent() != null) {
            float f = i / i2;
            float f2 = (this.gzZ * i) / this.gAa;
            if (f2 < i2) {
                i3 = (int) (this.gAa / f);
                i4 = this.gAa;
            } else if (f2 > i2) {
                i3 = this.gzZ;
                i4 = (int) (f * this.gzZ);
            } else {
                i3 = this.gzZ;
                i4 = this.gAa;
            }
            if (this.gzX.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gzX.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.gzX.setLayoutParams(layoutParams);
                return;
            }
            this.gzX.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void tH(int i) {
        if (this.gzX != null) {
            if (i == 1) {
                if (this.gzX.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gzX.getLayoutParams();
                    layoutParams.width = this.gzZ;
                    layoutParams.height = this.gAa;
                    layoutParams.topMargin = -this.gAf;
                    this.gzX.setLayoutParams(layoutParams);
                    return;
                }
                this.gzX.setLayoutParams(new FrameLayout.LayoutParams(this.gzZ, this.gAa));
            } else if (this.gzX.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gzX.getLayoutParams();
                layoutParams2.width = this.gzZ;
                layoutParams2.height = this.gAb;
                this.gzX.setLayoutParams(layoutParams2);
            } else {
                this.gzX.setLayoutParams(new FrameLayout.LayoutParams(this.gzZ, this.gAb));
            }
        }
    }

    private void tI(int i) {
        if (i == 1) {
            if (this.gzP) {
                if (this.aiT.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aiT.getLayoutParams();
                    layoutParams.width = this.gzZ;
                    layoutParams.height = this.gAc;
                    this.aiT.setLayoutParams(layoutParams);
                    return;
                }
                this.aiT.setLayoutParams(new FrameLayout.LayoutParams(this.gzZ, this.gAc));
                return;
            } else if (this.aiT.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aiT.getLayoutParams();
                layoutParams2.width = this.gzZ;
                layoutParams2.height = this.gzZ;
                this.aiT.setLayoutParams(layoutParams2);
                return;
            } else {
                this.aiT.setLayoutParams(new AbsListView.LayoutParams(this.gzZ, this.gzZ));
                return;
            }
        }
        this.aKb = 2;
        if (this.gzP) {
            if (this.aiT.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.aiT.getLayoutParams();
                layoutParams3.width = this.gzZ;
                layoutParams3.height = this.gAb;
                this.aiT.setLayoutParams(layoutParams3);
                return;
            }
            this.aiT.setLayoutParams(new AbsListView.LayoutParams(this.gzZ, this.gAb));
        } else if (this.aiT.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.aiT.getLayoutParams();
            layoutParams4.width = this.gzZ;
            layoutParams4.height = this.gAb;
            this.aiT.setLayoutParams(layoutParams4);
        } else {
            this.aiT.setLayoutParams(new AbsListView.LayoutParams(this.gzZ, this.gAb));
        }
    }

    public void bRk() {
        this.gzZ = l.getEquipmentWidth(this.eUY.getPageActivity());
        this.gAa = l.getEquipmentHeight(this.eUY.getPageActivity());
        this.gAb = (int) ((this.gzZ / 16.0d) * 9.0d);
        this.gAc = (int) ((this.gzZ / 4.0d) * 3.0d);
        this.gAf = (int) ((this.gAa / 3.0d) - (this.gAc / 2.0d));
        if (this.gzS != null) {
            boolean isPlaying = this.gzX == null ? false : this.gzX.isPlaying();
            tI(this.gzS.akU.boj().screen_direction);
            tH(this.gzS.akU.boj().screen_direction);
            bRl();
            if (isPlaying) {
                FW(this.gAd);
            }
        }
    }

    public void bRl() {
        mv(true);
    }

    public void mv(boolean z) {
        if (z) {
            bRm();
        }
        if (this.gzX != null) {
            this.gzX.stopPlayback();
        }
        this.gzW.bRg();
        this.gzW.bRh();
    }

    private void bRm() {
        if (this.gzY != null) {
            this.gzY.setPlayer(null);
            this.gzY.stop();
            this.gzY = null;
        }
        if (this.gzX != null) {
            this.gzX.stopPlayback();
            this.gzX.dAr();
            if (this.gzX.getMediaProgressObserver() != null) {
                this.gzX.getMediaProgressObserver().setPlayer(null);
                this.gzX.getMediaProgressObserver().stop();
            }
            this.gzX = null;
        }
    }

    private void bRn() {
        if (this.gzS != null && this.gzS.akU != null && this.gzS.akU.boj() != null) {
            if (this.gzX != null && this.gzX.getParent() != null) {
                bRm();
            }
            this.gzY = new f();
            this.gzX = new TbCyberVideoView(this.eUY.getPageActivity());
            this.gzX.setOnPreparedListener(this.eAA);
            this.gzX.setOnErrorListener(this.eAB);
            this.gzX.setOnSurfaceDestroyedListener(this.fUi);
            this.gzX.setVolume(0.0f, 0.0f);
            this.gzX.setStageType(null);
            this.gzY.setPlayer(this.gzX);
            this.gzY.a(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.f.c
                public void bRo() {
                }
            });
            if (this.gzX.getParent() == null) {
                this.aiT.addView(this.gzX, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            tH(this.gzS.akU.boj().screen_direction);
        }
    }

    public void FW(String str) {
        if (!StringUtils.isNull(str) && this.gzS != null && this.gzS.akU != null && this.gzS.akU.boj() != null) {
            if (!str.equals(this.gAd) || (this.gzX != null && !this.gzX.isPlaying())) {
                this.gAd = str;
                bRl();
            }
            if (this.gzX == null) {
                bRn();
            }
            if (this.gzX != null && !this.gzX.isPlaying()) {
                o oVar = new o();
                oVar.mLocate = "9";
                oVar.fNd = String.valueOf(this.gzS.akU.getFid());
                oVar.amC = this.gzS.akU.getTid();
                this.gzX.setVideoStatData(oVar);
                if (this.gzX != null) {
                    this.gzX.setVideoPath(this.gzS.akU.boj().hls_url);
                }
                if (this.gzX != null) {
                    this.gzX.start();
                }
                if (this.gzY != null) {
                    this.gzY.start();
                }
            }
        }
    }

    public View getView() {
        return this.aiT;
    }

    public void onDestroy() {
        bRm();
        if (this.gzW != null) {
            this.gzW.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.gzW != null) {
            this.gzW.bzn();
        }
        ap.setBackgroundColor(this.gzX, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, cb cbVar) {
        String str;
        if (tbPageContext != null && cbVar != null && cbVar.bnQ() != null && cbVar.boj() != null) {
            if (this.gzS != null && this.gzS.akU != null && !this.gzP) {
                ar arVar = new ar("c12645");
                if (this.gzS.gzj == 0) {
                    arVar.ap("obj_type", 1);
                } else if (this.gzS.gzj == 1) {
                    arVar.ap("obj_type", 2);
                }
                arVar.dR("tid", this.gzS.akU.getTid());
                TiebaStatic.log(arVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = cbVar.bnQ().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.gzP) {
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
