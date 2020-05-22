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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.b.c;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
/* loaded from: classes3.dex */
public class b {
    private int avY;
    private TbPageContext<?> dIF;
    private FrameLayout ddl;
    private g.b eBk;
    private QuickVideoView.b eBo;
    private g.f eKm;
    private boolean fbE;
    private c fbH;
    private final float fbK;
    private AlaSquareLiveVideoMask fbL;
    private QuickVideoView fbM;
    private j fbN;
    private n fbO;
    private int fbP;
    private int fbQ;
    private int fbR;
    private int fbS;
    private String fbT;
    private a fbU;
    private int fbV;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void R(bk bkVar);

        void S(bk bkVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.fbK = 0.0f;
        this.dIF = null;
        this.fbT = "";
        this.fbE = false;
        this.eBo = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                b.this.bqE();
            }
        };
        this.eBk = new g.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                b.this.jk(false);
                return true;
            }
        };
        this.eKm = new g.f() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(false);
                    gVar.setVolume(0.0f, 0.0f);
                    if (b.this.fbH != null && b.this.fbH.ahg != null) {
                        if (b.this.fbE) {
                            if (b.this.fbU != null) {
                                b.this.fbU.S(b.this.fbH.ahg);
                            }
                        } else {
                            an anVar = new an("c12646");
                            if (b.this.fbH.faY != 0) {
                                if (b.this.fbH.faY == 1) {
                                    anVar.ag("obj_type", 2);
                                }
                            } else {
                                anVar.ag("obj_type", 1);
                            }
                            anVar.dh("tid", b.this.fbH.ahg.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                    b.this.bm(gVar.getVideoHeight(), gVar.getVideoWidth());
                    b.this.fbL.bqy();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.fbH != null && b.this.fbH.ahg != null) {
                    if (b.this.fbU != null) {
                        b.this.fbU.R(b.this.fbH.ahg);
                    }
                    b.this.a(b.this.dIF, b.this.fbH.ahg);
                }
            }
        };
        this.dIF = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.fbE = z;
        this.fbL.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.dIF != null) {
            this.ddl = (FrameLayout) LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.fbP = l.getEquipmentWidth(this.dIF.getPageActivity());
            this.fbQ = l.getEquipmentHeight(this.dIF.getPageActivity());
            this.fbR = (int) ((this.fbP / 16.0d) * 9.0d);
            this.fbS = (int) ((this.fbP / 4.0d) * 3.0d);
            this.fbV = (int) ((this.fbQ / 3.0d) - (this.fbS / 2.0d));
            this.fbL = (AlaSquareLiveVideoMask) this.ddl.findViewById(R.id.video_mask);
            this.ddl.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.fbU = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.ahg != null && cVar.ahg.aQS() != null) {
            if (this.fbH == null || (this.fbH.ahg != null && !this.fbH.ahg.getTid().equals(cVar.ahg.getTid()))) {
                pz(cVar.ahg.aQS().screen_direction);
            }
            this.fbH = cVar;
            this.avY = this.fbH.ahg.aQS().screen_direction;
            this.fbL.setData(this.fbH.ahg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(int i, int i2) {
        int i3;
        int i4;
        if (this.avY == 1 && this.fbM != null && this.fbM.getParent() != null) {
            float f = i / i2;
            float f2 = (this.fbP * i) / this.fbQ;
            if (f2 < i2) {
                i3 = (int) (this.fbQ / f);
                i4 = this.fbQ;
            } else if (f2 > i2) {
                i3 = this.fbP;
                i4 = (int) (f * this.fbP);
            } else {
                i3 = this.fbP;
                i4 = this.fbQ;
            }
            if (this.fbM.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fbM.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.fbM.setLayoutParams(layoutParams);
                return;
            }
            this.fbM.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void py(int i) {
        if (this.fbM != null) {
            if (i == 1) {
                if (this.fbM.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fbM.getLayoutParams();
                    layoutParams.width = this.fbP;
                    layoutParams.height = this.fbQ;
                    layoutParams.topMargin = -this.fbV;
                    this.fbM.setLayoutParams(layoutParams);
                    return;
                }
                this.fbM.setLayoutParams(new FrameLayout.LayoutParams(this.fbP, this.fbQ));
            } else if (this.fbM.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fbM.getLayoutParams();
                layoutParams2.width = this.fbP;
                layoutParams2.height = this.fbR;
                this.fbM.setLayoutParams(layoutParams2);
            } else {
                this.fbM.setLayoutParams(new FrameLayout.LayoutParams(this.fbP, this.fbR));
            }
        }
    }

    private void pz(int i) {
        if (i == 1) {
            if (this.fbE) {
                if (this.ddl.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ddl.getLayoutParams();
                    layoutParams.width = this.fbP;
                    layoutParams.height = this.fbS;
                    this.ddl.setLayoutParams(layoutParams);
                    return;
                }
                this.ddl.setLayoutParams(new FrameLayout.LayoutParams(this.fbP, this.fbS));
                return;
            } else if (this.ddl.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ddl.getLayoutParams();
                layoutParams2.width = this.fbP;
                layoutParams2.height = this.fbP;
                this.ddl.setLayoutParams(layoutParams2);
                return;
            } else {
                this.ddl.setLayoutParams(new AbsListView.LayoutParams(this.fbP, this.fbP));
                return;
            }
        }
        this.avY = 2;
        if (this.fbE) {
            if (this.ddl.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.ddl.getLayoutParams();
                layoutParams3.width = this.fbP;
                layoutParams3.height = this.fbR;
                this.ddl.setLayoutParams(layoutParams3);
                return;
            }
            this.ddl.setLayoutParams(new AbsListView.LayoutParams(this.fbP, this.fbR));
        } else if (this.ddl.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.ddl.getLayoutParams();
            layoutParams4.width = this.fbP;
            layoutParams4.height = this.fbR;
            this.ddl.setLayoutParams(layoutParams4);
        } else {
            this.ddl.setLayoutParams(new AbsListView.LayoutParams(this.fbP, this.fbR));
        }
    }

    public void bqD() {
        this.fbP = l.getEquipmentWidth(this.dIF.getPageActivity());
        this.fbQ = l.getEquipmentHeight(this.dIF.getPageActivity());
        this.fbR = (int) ((this.fbP / 16.0d) * 9.0d);
        this.fbS = (int) ((this.fbP / 4.0d) * 3.0d);
        this.fbV = (int) ((this.fbQ / 3.0d) - (this.fbS / 2.0d));
        if (this.fbH != null) {
            boolean isPlaying = this.fbM == null ? false : this.fbM.isPlaying();
            pz(this.fbH.ahg.aQS().screen_direction);
            py(this.fbH.ahg.aQS().screen_direction);
            bqE();
            if (isPlaying) {
                AW(this.fbT);
            }
        }
    }

    public void bqE() {
        jk(true);
    }

    public void jk(boolean z) {
        if (z) {
            bqF();
        }
        if (this.fbM != null) {
            this.fbM.stopPlayback();
        }
        this.fbL.bqz();
        this.fbL.bqA();
    }

    private void bqF() {
        if (this.fbO != null) {
            if (this.fbO.cQA() != null) {
                this.fbO.cQA().setPlayer(null);
                this.fbO.cQA().stop();
            }
            this.fbO = null;
        }
        if (this.fbN != null) {
            this.fbN.setPlayer(null);
            this.fbN.stop();
            this.fbN = null;
        }
        if (this.fbM != null) {
            this.fbM.stopPlayback();
            this.fbM.setOnPreparedListener(null);
            this.fbM.setOnErrorListener(null);
            this.fbM.setOnSurfaceDestroyedListener(null);
            this.fbM.setBusiness(null);
            if (this.fbM.getParent() != null) {
                ((ViewGroup) this.fbM.getParent()).removeView(this.fbM);
            }
            this.fbM = null;
        }
    }

    private void bqG() {
        if (this.fbH != null && this.fbH.ahg != null && this.fbH.ahg.aQS() != null) {
            if (this.fbM != null && this.fbM.getParent() != null) {
                bqF();
            }
            this.fbO = new n(this.dIF.getPageActivity());
            this.fbN = new j();
            this.fbM = new QuickVideoView(this.dIF.getPageActivity());
            this.fbM.setOnPreparedListener(this.eKm);
            this.fbM.setOnErrorListener(this.eBk);
            this.fbM.setOnSurfaceDestroyedListener(this.eBo);
            this.fbM.setBusiness(this.fbO);
            this.fbM.setVolume(0.0f, 0.0f);
            this.fbN.setPlayer(this.fbM);
            this.fbN.a(new j.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.j.c
                public void bqH() {
                }
            });
            if (this.fbM.getParent() == null) {
                this.ddl.addView(this.fbM, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            py(this.fbH.ahg.aQS().screen_direction);
        }
    }

    public void AW(String str) {
        if (!StringUtils.isNull(str) && this.fbH != null && this.fbH.ahg != null && this.fbH.ahg.aQS() != null) {
            if (!str.equals(this.fbT) || (this.fbM != null && !this.fbM.isPlaying())) {
                this.fbT = str;
                bqE();
            }
            if (this.fbM == null) {
                bqG();
            }
            if (this.fbM != null && !this.fbM.isPlaying()) {
                if (this.fbO != null) {
                    y yVar = new y();
                    yVar.mLocate = "9";
                    yVar.evm = String.valueOf(this.fbH.ahg.getFid());
                    yVar.ais = this.fbH.ahg.getTid();
                    this.fbO.setVideoStatsData(yVar);
                    if (this.fbO.cQV() != null) {
                        this.fbO.cQV().c(this.fbH.ahg.aQS());
                    }
                }
                if (this.fbM != null) {
                    this.fbM.setVideoPath(this.fbH.ahg.aQS().hls_url);
                }
                if (this.fbM != null) {
                    this.fbM.start();
                }
                if (this.fbN != null) {
                    this.fbN.start();
                }
            }
        }
    }

    public View getView() {
        return this.ddl;
    }

    public void onDestroy() {
        bqF();
        if (this.fbL != null) {
            this.fbL.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.fbL != null) {
            this.fbL.bbl();
        }
        am.setBackgroundColor(this.fbM, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bk bkVar) {
        String str;
        if (tbPageContext != null && bkVar != null && bkVar.aQx() != null && bkVar.aQS() != null) {
            if (this.fbH != null && this.fbH.ahg != null && !this.fbE) {
                an anVar = new an("c12645");
                if (this.fbH.faY == 0) {
                    anVar.ag("obj_type", 1);
                } else if (this.fbH.faY == 1) {
                    anVar.ag("obj_type", 2);
                }
                anVar.dh("tid", this.fbH.ahg.getTid());
                TiebaStatic.log(anVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bkVar.aQx().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.fbE) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bkVar.aQS());
            alaLiveInfoCoreData.userName = bkVar.aQS().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
