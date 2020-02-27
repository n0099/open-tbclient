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
import com.baidu.tbadk.core.data.bj;
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
    private int Yy;
    private TbPageContext<?> cVg;
    private FrameLayout csX;
    private g.b dMf;
    private QuickVideoView.b dMj;
    private g.f dVc;
    private boolean ekO;
    private c ekR;
    private final float ekU;
    private AlaSquareLiveVideoMask ekV;
    private QuickVideoView ekW;
    private j ekX;
    private n ekY;
    private int ekZ;
    private int ela;
    private int elb;
    private int elc;
    private String eld;
    private a ele;
    private int elf;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void P(bj bjVar);

        void Q(bj bjVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.ekU = 0.0f;
        this.cVg = null;
        this.eld = "";
        this.ekO = false;
        this.dMj = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                b.this.bcm();
            }
        };
        this.dMf = new g.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                b.this.hS(false);
                return true;
            }
        };
        this.dVc = new g.f() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(false);
                    gVar.setVolume(0.0f, 0.0f);
                    if (b.this.ekR != null && b.this.ekR.NQ != null) {
                        if (b.this.ekO) {
                            if (b.this.ele != null) {
                                b.this.ele.Q(b.this.ekR.NQ);
                            }
                        } else {
                            an anVar = new an("c12646");
                            if (b.this.ekR.eki != 0) {
                                if (b.this.ekR.eki == 1) {
                                    anVar.X("obj_type", 2);
                                }
                            } else {
                                anVar.X("obj_type", 1);
                            }
                            anVar.cy("tid", b.this.ekR.NQ.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                    b.this.bd(gVar.getVideoHeight(), gVar.getVideoWidth());
                    b.this.ekV.bcg();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.ekR != null && b.this.ekR.NQ != null) {
                    if (b.this.ele != null) {
                        b.this.ele.P(b.this.ekR.NQ);
                    }
                    b.this.a(b.this.cVg, b.this.ekR.NQ);
                }
            }
        };
        this.cVg = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.ekO = z;
        this.ekV.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.cVg != null) {
            this.csX = (FrameLayout) LayoutInflater.from(this.cVg.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.ekZ = l.getEquipmentWidth(this.cVg.getPageActivity());
            this.ela = l.getEquipmentHeight(this.cVg.getPageActivity());
            this.elb = (int) ((this.ekZ / 16.0d) * 9.0d);
            this.elc = (int) ((this.ekZ / 4.0d) * 3.0d);
            this.elf = (int) ((this.ela / 3.0d) - (this.elc / 2.0d));
            this.ekV = (AlaSquareLiveVideoMask) this.csX.findViewById(R.id.video_mask);
            this.csX.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.ele = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.NQ != null && cVar.NQ.aCF() != null) {
            if (this.ekR == null || (this.ekR.NQ != null && !this.ekR.NQ.getTid().equals(cVar.NQ.getTid()))) {
                oD(cVar.NQ.aCF().screen_direction);
            }
            this.ekR = cVar;
            this.Yy = this.ekR.NQ.aCF().screen_direction;
            this.ekV.setData(this.ekR.NQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(int i, int i2) {
        int i3;
        int i4;
        if (this.Yy == 1 && this.ekW != null && this.ekW.getParent() != null) {
            float f = i / i2;
            float f2 = (this.ekZ * i) / this.ela;
            if (f2 < i2) {
                i3 = (int) (this.ela / f);
                i4 = this.ela;
            } else if (f2 > i2) {
                i3 = this.ekZ;
                i4 = (int) (f * this.ekZ);
            } else {
                i3 = this.ekZ;
                i4 = this.ela;
            }
            if (this.ekW.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ekW.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.ekW.setLayoutParams(layoutParams);
                return;
            }
            this.ekW.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void oC(int i) {
        if (this.ekW != null) {
            if (i == 1) {
                if (this.ekW.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ekW.getLayoutParams();
                    layoutParams.width = this.ekZ;
                    layoutParams.height = this.ela;
                    layoutParams.topMargin = -this.elf;
                    this.ekW.setLayoutParams(layoutParams);
                    return;
                }
                this.ekW.setLayoutParams(new FrameLayout.LayoutParams(this.ekZ, this.ela));
            } else if (this.ekW.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ekW.getLayoutParams();
                layoutParams2.width = this.ekZ;
                layoutParams2.height = this.elb;
                this.ekW.setLayoutParams(layoutParams2);
            } else {
                this.ekW.setLayoutParams(new FrameLayout.LayoutParams(this.ekZ, this.elb));
            }
        }
    }

    private void oD(int i) {
        if (i == 1) {
            if (this.ekO) {
                if (this.csX.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.csX.getLayoutParams();
                    layoutParams.width = this.ekZ;
                    layoutParams.height = this.elc;
                    this.csX.setLayoutParams(layoutParams);
                    return;
                }
                this.csX.setLayoutParams(new FrameLayout.LayoutParams(this.ekZ, this.elc));
                return;
            } else if (this.csX.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.csX.getLayoutParams();
                layoutParams2.width = this.ekZ;
                layoutParams2.height = this.ekZ;
                this.csX.setLayoutParams(layoutParams2);
                return;
            } else {
                this.csX.setLayoutParams(new AbsListView.LayoutParams(this.ekZ, this.ekZ));
                return;
            }
        }
        this.Yy = 2;
        if (this.ekO) {
            if (this.csX.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.csX.getLayoutParams();
                layoutParams3.width = this.ekZ;
                layoutParams3.height = this.elb;
                this.csX.setLayoutParams(layoutParams3);
                return;
            }
            this.csX.setLayoutParams(new AbsListView.LayoutParams(this.ekZ, this.elb));
        } else if (this.csX.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.csX.getLayoutParams();
            layoutParams4.width = this.ekZ;
            layoutParams4.height = this.elb;
            this.csX.setLayoutParams(layoutParams4);
        } else {
            this.csX.setLayoutParams(new AbsListView.LayoutParams(this.ekZ, this.elb));
        }
    }

    public void bcl() {
        this.ekZ = l.getEquipmentWidth(this.cVg.getPageActivity());
        this.ela = l.getEquipmentHeight(this.cVg.getPageActivity());
        this.elb = (int) ((this.ekZ / 16.0d) * 9.0d);
        this.elc = (int) ((this.ekZ / 4.0d) * 3.0d);
        this.elf = (int) ((this.ela / 3.0d) - (this.elc / 2.0d));
        if (this.ekR != null) {
            boolean isPlaying = this.ekW == null ? false : this.ekW.isPlaying();
            oD(this.ekR.NQ.aCF().screen_direction);
            oC(this.ekR.NQ.aCF().screen_direction);
            bcm();
            if (isPlaying) {
                startPlay(this.eld);
            }
        }
    }

    public void bcm() {
        hS(true);
    }

    public void hS(boolean z) {
        if (z) {
            bcn();
        }
        if (this.ekW != null) {
            this.ekW.stopPlayback();
        }
        this.ekV.bch();
        this.ekV.bci();
    }

    private void bcn() {
        if (this.ekY != null) {
            if (this.ekY.cyC() != null) {
                this.ekY.cyC().setPlayer(null);
                this.ekY.cyC().stop();
            }
            this.ekY = null;
        }
        if (this.ekX != null) {
            this.ekX.setPlayer(null);
            this.ekX.stop();
            this.ekX = null;
        }
        if (this.ekW != null) {
            this.ekW.stopPlayback();
            this.ekW.setOnPreparedListener(null);
            this.ekW.setOnErrorListener(null);
            this.ekW.setOnSurfaceDestroyedListener(null);
            this.ekW.setBusiness(null);
            if (this.ekW.getParent() != null) {
                ((ViewGroup) this.ekW.getParent()).removeView(this.ekW);
            }
            this.ekW = null;
        }
    }

    private void bco() {
        if (this.ekR != null && this.ekR.NQ != null && this.ekR.NQ.aCF() != null) {
            if (this.ekW != null && this.ekW.getParent() != null) {
                bcn();
            }
            this.ekY = new n(this.cVg.getPageActivity());
            this.ekX = new j();
            this.ekW = new QuickVideoView(this.cVg.getPageActivity());
            this.ekW.setOnPreparedListener(this.dVc);
            this.ekW.setOnErrorListener(this.dMf);
            this.ekW.setOnSurfaceDestroyedListener(this.dMj);
            this.ekW.setBusiness(this.ekY);
            this.ekW.setVolume(0.0f, 0.0f);
            this.ekX.setPlayer(this.ekW);
            this.ekX.a(new j.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.j.c
                public void bcp() {
                }
            });
            if (this.ekW.getParent() == null) {
                this.csX.addView(this.ekW, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            oC(this.ekR.NQ.aCF().screen_direction);
        }
    }

    public void startPlay(String str) {
        if (!StringUtils.isNull(str) && this.ekR != null && this.ekR.NQ != null && this.ekR.NQ.aCF() != null) {
            if (!str.equals(this.eld) || (this.ekW != null && !this.ekW.isPlaying())) {
                this.eld = str;
                bcm();
            }
            if (this.ekW == null) {
                bco();
            }
            if (this.ekW != null && !this.ekW.isPlaying()) {
                if (this.ekY != null) {
                    y yVar = new y();
                    yVar.mLocate = "9";
                    yVar.ema = String.valueOf(this.ekR.NQ.getFid());
                    yVar.Pj = this.ekR.NQ.getTid();
                    this.ekY.setVideoStatsData(yVar);
                    if (this.ekY.cyX() != null) {
                        this.ekY.cyX().b(this.ekR.NQ.aCF());
                    }
                }
                if (this.ekW != null) {
                    this.ekW.setVideoPath(this.ekR.NQ.aCF().hls_url);
                }
                if (this.ekW != null) {
                    this.ekW.start();
                }
                if (this.ekX != null) {
                    this.ekX.start();
                }
            }
        }
    }

    public View getView() {
        return this.csX;
    }

    public void onDestroy() {
        bcn();
        if (this.ekV != null) {
            this.ekV.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.ekV != null) {
            this.ekV.aMz();
        }
        am.setBackgroundColor(this.ekW, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar) {
        String str;
        if (tbPageContext != null && bjVar != null && bjVar.aCm() != null && bjVar.aCF() != null) {
            if (this.ekR != null && this.ekR.NQ != null && !this.ekO) {
                an anVar = new an("c12645");
                if (this.ekR.eki == 0) {
                    anVar.X("obj_type", 1);
                } else if (this.ekR.eki == 1) {
                    anVar.X("obj_type", 2);
                }
                anVar.cy("tid", this.ekR.NQ.getTid());
                TiebaStatic.log(anVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aCm().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.ekO) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aCF());
            alaLiveInfoCoreData.userName = bjVar.aCF().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
