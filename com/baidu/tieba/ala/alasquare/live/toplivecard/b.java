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
    private g.b eBv;
    private QuickVideoView.b eBz;
    private g.f eKx;
    private boolean fbP;
    private c fbS;
    private final float fbV;
    private AlaSquareLiveVideoMask fbW;
    private QuickVideoView fbX;
    private j fbY;
    private n fbZ;
    private int fca;
    private int fcb;
    private int fcc;
    private int fcd;
    private String fce;
    private a fcf;
    private int fcg;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void R(bk bkVar);

        void S(bk bkVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.fbV = 0.0f;
        this.dIF = null;
        this.fce = "";
        this.fbP = false;
        this.eBz = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                b.this.bqG();
            }
        };
        this.eBv = new g.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                b.this.jk(false);
                return true;
            }
        };
        this.eKx = new g.f() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(false);
                    gVar.setVolume(0.0f, 0.0f);
                    if (b.this.fbS != null && b.this.fbS.ahg != null) {
                        if (b.this.fbP) {
                            if (b.this.fcf != null) {
                                b.this.fcf.S(b.this.fbS.ahg);
                            }
                        } else {
                            an anVar = new an("c12646");
                            if (b.this.fbS.fbj != 0) {
                                if (b.this.fbS.fbj == 1) {
                                    anVar.ag("obj_type", 2);
                                }
                            } else {
                                anVar.ag("obj_type", 1);
                            }
                            anVar.dh("tid", b.this.fbS.ahg.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                    b.this.bm(gVar.getVideoHeight(), gVar.getVideoWidth());
                    b.this.fbW.bqA();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.fbS != null && b.this.fbS.ahg != null) {
                    if (b.this.fcf != null) {
                        b.this.fcf.R(b.this.fbS.ahg);
                    }
                    b.this.a(b.this.dIF, b.this.fbS.ahg);
                }
            }
        };
        this.dIF = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.fbP = z;
        this.fbW.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.dIF != null) {
            this.ddl = (FrameLayout) LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.fca = l.getEquipmentWidth(this.dIF.getPageActivity());
            this.fcb = l.getEquipmentHeight(this.dIF.getPageActivity());
            this.fcc = (int) ((this.fca / 16.0d) * 9.0d);
            this.fcd = (int) ((this.fca / 4.0d) * 3.0d);
            this.fcg = (int) ((this.fcb / 3.0d) - (this.fcd / 2.0d));
            this.fbW = (AlaSquareLiveVideoMask) this.ddl.findViewById(R.id.video_mask);
            this.ddl.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.fcf = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.ahg != null && cVar.ahg.aQS() != null) {
            if (this.fbS == null || (this.fbS.ahg != null && !this.fbS.ahg.getTid().equals(cVar.ahg.getTid()))) {
                pB(cVar.ahg.aQS().screen_direction);
            }
            this.fbS = cVar;
            this.avY = this.fbS.ahg.aQS().screen_direction;
            this.fbW.setData(this.fbS.ahg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(int i, int i2) {
        int i3;
        int i4;
        if (this.avY == 1 && this.fbX != null && this.fbX.getParent() != null) {
            float f = i / i2;
            float f2 = (this.fca * i) / this.fcb;
            if (f2 < i2) {
                i3 = (int) (this.fcb / f);
                i4 = this.fcb;
            } else if (f2 > i2) {
                i3 = this.fca;
                i4 = (int) (f * this.fca);
            } else {
                i3 = this.fca;
                i4 = this.fcb;
            }
            if (this.fbX.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fbX.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.fbX.setLayoutParams(layoutParams);
                return;
            }
            this.fbX.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void pA(int i) {
        if (this.fbX != null) {
            if (i == 1) {
                if (this.fbX.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fbX.getLayoutParams();
                    layoutParams.width = this.fca;
                    layoutParams.height = this.fcb;
                    layoutParams.topMargin = -this.fcg;
                    this.fbX.setLayoutParams(layoutParams);
                    return;
                }
                this.fbX.setLayoutParams(new FrameLayout.LayoutParams(this.fca, this.fcb));
            } else if (this.fbX.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fbX.getLayoutParams();
                layoutParams2.width = this.fca;
                layoutParams2.height = this.fcc;
                this.fbX.setLayoutParams(layoutParams2);
            } else {
                this.fbX.setLayoutParams(new FrameLayout.LayoutParams(this.fca, this.fcc));
            }
        }
    }

    private void pB(int i) {
        if (i == 1) {
            if (this.fbP) {
                if (this.ddl.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ddl.getLayoutParams();
                    layoutParams.width = this.fca;
                    layoutParams.height = this.fcd;
                    this.ddl.setLayoutParams(layoutParams);
                    return;
                }
                this.ddl.setLayoutParams(new FrameLayout.LayoutParams(this.fca, this.fcd));
                return;
            } else if (this.ddl.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ddl.getLayoutParams();
                layoutParams2.width = this.fca;
                layoutParams2.height = this.fca;
                this.ddl.setLayoutParams(layoutParams2);
                return;
            } else {
                this.ddl.setLayoutParams(new AbsListView.LayoutParams(this.fca, this.fca));
                return;
            }
        }
        this.avY = 2;
        if (this.fbP) {
            if (this.ddl.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.ddl.getLayoutParams();
                layoutParams3.width = this.fca;
                layoutParams3.height = this.fcc;
                this.ddl.setLayoutParams(layoutParams3);
                return;
            }
            this.ddl.setLayoutParams(new AbsListView.LayoutParams(this.fca, this.fcc));
        } else if (this.ddl.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.ddl.getLayoutParams();
            layoutParams4.width = this.fca;
            layoutParams4.height = this.fcc;
            this.ddl.setLayoutParams(layoutParams4);
        } else {
            this.ddl.setLayoutParams(new AbsListView.LayoutParams(this.fca, this.fcc));
        }
    }

    public void bqF() {
        this.fca = l.getEquipmentWidth(this.dIF.getPageActivity());
        this.fcb = l.getEquipmentHeight(this.dIF.getPageActivity());
        this.fcc = (int) ((this.fca / 16.0d) * 9.0d);
        this.fcd = (int) ((this.fca / 4.0d) * 3.0d);
        this.fcg = (int) ((this.fcb / 3.0d) - (this.fcd / 2.0d));
        if (this.fbS != null) {
            boolean isPlaying = this.fbX == null ? false : this.fbX.isPlaying();
            pB(this.fbS.ahg.aQS().screen_direction);
            pA(this.fbS.ahg.aQS().screen_direction);
            bqG();
            if (isPlaying) {
                AW(this.fce);
            }
        }
    }

    public void bqG() {
        jk(true);
    }

    public void jk(boolean z) {
        if (z) {
            bqH();
        }
        if (this.fbX != null) {
            this.fbX.stopPlayback();
        }
        this.fbW.bqB();
        this.fbW.bqC();
    }

    private void bqH() {
        if (this.fbZ != null) {
            if (this.fbZ.cQQ() != null) {
                this.fbZ.cQQ().setPlayer(null);
                this.fbZ.cQQ().stop();
            }
            this.fbZ = null;
        }
        if (this.fbY != null) {
            this.fbY.setPlayer(null);
            this.fbY.stop();
            this.fbY = null;
        }
        if (this.fbX != null) {
            this.fbX.stopPlayback();
            this.fbX.setOnPreparedListener(null);
            this.fbX.setOnErrorListener(null);
            this.fbX.setOnSurfaceDestroyedListener(null);
            this.fbX.setBusiness(null);
            if (this.fbX.getParent() != null) {
                ((ViewGroup) this.fbX.getParent()).removeView(this.fbX);
            }
            this.fbX = null;
        }
    }

    private void bqI() {
        if (this.fbS != null && this.fbS.ahg != null && this.fbS.ahg.aQS() != null) {
            if (this.fbX != null && this.fbX.getParent() != null) {
                bqH();
            }
            this.fbZ = new n(this.dIF.getPageActivity());
            this.fbY = new j();
            this.fbX = new QuickVideoView(this.dIF.getPageActivity());
            this.fbX.setOnPreparedListener(this.eKx);
            this.fbX.setOnErrorListener(this.eBv);
            this.fbX.setOnSurfaceDestroyedListener(this.eBz);
            this.fbX.setBusiness(this.fbZ);
            this.fbX.setVolume(0.0f, 0.0f);
            this.fbY.setPlayer(this.fbX);
            this.fbY.a(new j.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.j.c
                public void bqJ() {
                }
            });
            if (this.fbX.getParent() == null) {
                this.ddl.addView(this.fbX, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            pA(this.fbS.ahg.aQS().screen_direction);
        }
    }

    public void AW(String str) {
        if (!StringUtils.isNull(str) && this.fbS != null && this.fbS.ahg != null && this.fbS.ahg.aQS() != null) {
            if (!str.equals(this.fce) || (this.fbX != null && !this.fbX.isPlaying())) {
                this.fce = str;
                bqG();
            }
            if (this.fbX == null) {
                bqI();
            }
            if (this.fbX != null && !this.fbX.isPlaying()) {
                if (this.fbZ != null) {
                    y yVar = new y();
                    yVar.mLocate = "9";
                    yVar.evm = String.valueOf(this.fbS.ahg.getFid());
                    yVar.ais = this.fbS.ahg.getTid();
                    this.fbZ.setVideoStatsData(yVar);
                    if (this.fbZ.cRl() != null) {
                        this.fbZ.cRl().c(this.fbS.ahg.aQS());
                    }
                }
                if (this.fbX != null) {
                    this.fbX.setVideoPath(this.fbS.ahg.aQS().hls_url);
                }
                if (this.fbX != null) {
                    this.fbX.start();
                }
                if (this.fbY != null) {
                    this.fbY.start();
                }
            }
        }
    }

    public View getView() {
        return this.ddl;
    }

    public void onDestroy() {
        bqH();
        if (this.fbW != null) {
            this.fbW.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.fbW != null) {
            this.fbW.bbm();
        }
        am.setBackgroundColor(this.fbX, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bk bkVar) {
        String str;
        if (tbPageContext != null && bkVar != null && bkVar.aQx() != null && bkVar.aQS() != null) {
            if (this.fbS != null && this.fbS.ahg != null && !this.fbP) {
                an anVar = new an("c12645");
                if (this.fbS.fbj == 0) {
                    anVar.ag("obj_type", 1);
                } else if (this.fbS.fbj == 1) {
                    anVar.ag("obj_type", 2);
                }
                anVar.dh("tid", this.fbS.ahg.getTid());
                TiebaStatic.log(anVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bkVar.aQx().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.fbP) {
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
