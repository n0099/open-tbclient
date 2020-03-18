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
    private int YI;
    private TbPageContext<?> cVv;
    private FrameLayout ctk;
    private g.b dMJ;
    private QuickVideoView.b dMN;
    private g.f dVG;
    private QuickVideoView elA;
    private j elB;
    private n elC;
    private int elD;
    private int elE;
    private int elF;
    private int elG;
    private String elH;
    private a elI;
    private int elJ;
    private boolean els;
    private c elv;
    private final float ely;
    private AlaSquareLiveVideoMask elz;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void Q(bj bjVar);

        void R(bj bjVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.ely = 0.0f;
        this.cVv = null;
        this.elH = "";
        this.els = false;
        this.dMN = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                b.this.bct();
            }
        };
        this.dMJ = new g.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                b.this.hT(false);
                return true;
            }
        };
        this.dVG = new g.f() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(false);
                    gVar.setVolume(0.0f, 0.0f);
                    if (b.this.elv != null && b.this.elv.NR != null) {
                        if (b.this.els) {
                            if (b.this.elI != null) {
                                b.this.elI.R(b.this.elv.NR);
                            }
                        } else {
                            an anVar = new an("c12646");
                            if (b.this.elv.ekM != 0) {
                                if (b.this.elv.ekM == 1) {
                                    anVar.X("obj_type", 2);
                                }
                            } else {
                                anVar.X("obj_type", 1);
                            }
                            anVar.cx("tid", b.this.elv.NR.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                    b.this.be(gVar.getVideoHeight(), gVar.getVideoWidth());
                    b.this.elz.bcn();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.elv != null && b.this.elv.NR != null) {
                    if (b.this.elI != null) {
                        b.this.elI.Q(b.this.elv.NR);
                    }
                    b.this.a(b.this.cVv, b.this.elv.NR);
                }
            }
        };
        this.cVv = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.els = z;
        this.elz.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.cVv != null) {
            this.ctk = (FrameLayout) LayoutInflater.from(this.cVv.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.elD = l.getEquipmentWidth(this.cVv.getPageActivity());
            this.elE = l.getEquipmentHeight(this.cVv.getPageActivity());
            this.elF = (int) ((this.elD / 16.0d) * 9.0d);
            this.elG = (int) ((this.elD / 4.0d) * 3.0d);
            this.elJ = (int) ((this.elE / 3.0d) - (this.elG / 2.0d));
            this.elz = (AlaSquareLiveVideoMask) this.ctk.findViewById(R.id.video_mask);
            this.ctk.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.elI = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.NR != null && cVar.NR.aCK() != null) {
            if (this.elv == null || (this.elv.NR != null && !this.elv.NR.getTid().equals(cVar.NR.getTid()))) {
                oF(cVar.NR.aCK().screen_direction);
            }
            this.elv = cVar;
            this.YI = this.elv.NR.aCK().screen_direction;
            this.elz.setData(this.elv.NR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(int i, int i2) {
        int i3;
        int i4;
        if (this.YI == 1 && this.elA != null && this.elA.getParent() != null) {
            float f = i / i2;
            float f2 = (this.elD * i) / this.elE;
            if (f2 < i2) {
                i3 = (int) (this.elE / f);
                i4 = this.elE;
            } else if (f2 > i2) {
                i3 = this.elD;
                i4 = (int) (f * this.elD);
            } else {
                i3 = this.elD;
                i4 = this.elE;
            }
            if (this.elA.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.elA.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.elA.setLayoutParams(layoutParams);
                return;
            }
            this.elA.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void oE(int i) {
        if (this.elA != null) {
            if (i == 1) {
                if (this.elA.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.elA.getLayoutParams();
                    layoutParams.width = this.elD;
                    layoutParams.height = this.elE;
                    layoutParams.topMargin = -this.elJ;
                    this.elA.setLayoutParams(layoutParams);
                    return;
                }
                this.elA.setLayoutParams(new FrameLayout.LayoutParams(this.elD, this.elE));
            } else if (this.elA.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.elA.getLayoutParams();
                layoutParams2.width = this.elD;
                layoutParams2.height = this.elF;
                this.elA.setLayoutParams(layoutParams2);
            } else {
                this.elA.setLayoutParams(new FrameLayout.LayoutParams(this.elD, this.elF));
            }
        }
    }

    private void oF(int i) {
        if (i == 1) {
            if (this.els) {
                if (this.ctk.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ctk.getLayoutParams();
                    layoutParams.width = this.elD;
                    layoutParams.height = this.elG;
                    this.ctk.setLayoutParams(layoutParams);
                    return;
                }
                this.ctk.setLayoutParams(new FrameLayout.LayoutParams(this.elD, this.elG));
                return;
            } else if (this.ctk.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ctk.getLayoutParams();
                layoutParams2.width = this.elD;
                layoutParams2.height = this.elD;
                this.ctk.setLayoutParams(layoutParams2);
                return;
            } else {
                this.ctk.setLayoutParams(new AbsListView.LayoutParams(this.elD, this.elD));
                return;
            }
        }
        this.YI = 2;
        if (this.els) {
            if (this.ctk.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.ctk.getLayoutParams();
                layoutParams3.width = this.elD;
                layoutParams3.height = this.elF;
                this.ctk.setLayoutParams(layoutParams3);
                return;
            }
            this.ctk.setLayoutParams(new AbsListView.LayoutParams(this.elD, this.elF));
        } else if (this.ctk.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.ctk.getLayoutParams();
            layoutParams4.width = this.elD;
            layoutParams4.height = this.elF;
            this.ctk.setLayoutParams(layoutParams4);
        } else {
            this.ctk.setLayoutParams(new AbsListView.LayoutParams(this.elD, this.elF));
        }
    }

    public void bcs() {
        this.elD = l.getEquipmentWidth(this.cVv.getPageActivity());
        this.elE = l.getEquipmentHeight(this.cVv.getPageActivity());
        this.elF = (int) ((this.elD / 16.0d) * 9.0d);
        this.elG = (int) ((this.elD / 4.0d) * 3.0d);
        this.elJ = (int) ((this.elE / 3.0d) - (this.elG / 2.0d));
        if (this.elv != null) {
            boolean isPlaying = this.elA == null ? false : this.elA.isPlaying();
            oF(this.elv.NR.aCK().screen_direction);
            oE(this.elv.NR.aCK().screen_direction);
            bct();
            if (isPlaying) {
                startPlay(this.elH);
            }
        }
    }

    public void bct() {
        hT(true);
    }

    public void hT(boolean z) {
        if (z) {
            bcu();
        }
        if (this.elA != null) {
            this.elA.stopPlayback();
        }
        this.elz.bco();
        this.elz.bcp();
    }

    private void bcu() {
        if (this.elC != null) {
            if (this.elC.cyY() != null) {
                this.elC.cyY().setPlayer(null);
                this.elC.cyY().stop();
            }
            this.elC = null;
        }
        if (this.elB != null) {
            this.elB.setPlayer(null);
            this.elB.stop();
            this.elB = null;
        }
        if (this.elA != null) {
            this.elA.stopPlayback();
            this.elA.setOnPreparedListener(null);
            this.elA.setOnErrorListener(null);
            this.elA.setOnSurfaceDestroyedListener(null);
            this.elA.setBusiness(null);
            if (this.elA.getParent() != null) {
                ((ViewGroup) this.elA.getParent()).removeView(this.elA);
            }
            this.elA = null;
        }
    }

    private void bcv() {
        if (this.elv != null && this.elv.NR != null && this.elv.NR.aCK() != null) {
            if (this.elA != null && this.elA.getParent() != null) {
                bcu();
            }
            this.elC = new n(this.cVv.getPageActivity());
            this.elB = new j();
            this.elA = new QuickVideoView(this.cVv.getPageActivity());
            this.elA.setOnPreparedListener(this.dVG);
            this.elA.setOnErrorListener(this.dMJ);
            this.elA.setOnSurfaceDestroyedListener(this.dMN);
            this.elA.setBusiness(this.elC);
            this.elA.setVolume(0.0f, 0.0f);
            this.elB.setPlayer(this.elA);
            this.elB.a(new j.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.j.c
                public void bcw() {
                }
            });
            if (this.elA.getParent() == null) {
                this.ctk.addView(this.elA, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            oE(this.elv.NR.aCK().screen_direction);
        }
    }

    public void startPlay(String str) {
        if (!StringUtils.isNull(str) && this.elv != null && this.elv.NR != null && this.elv.NR.aCK() != null) {
            if (!str.equals(this.elH) || (this.elA != null && !this.elA.isPlaying())) {
                this.elH = str;
                bct();
            }
            if (this.elA == null) {
                bcv();
            }
            if (this.elA != null && !this.elA.isPlaying()) {
                if (this.elC != null) {
                    y yVar = new y();
                    yVar.mLocate = "9";
                    yVar.emF = String.valueOf(this.elv.NR.getFid());
                    yVar.Pk = this.elv.NR.getTid();
                    this.elC.setVideoStatsData(yVar);
                    if (this.elC.czt() != null) {
                        this.elC.czt().b(this.elv.NR.aCK());
                    }
                }
                if (this.elA != null) {
                    this.elA.setVideoPath(this.elv.NR.aCK().hls_url);
                }
                if (this.elA != null) {
                    this.elA.start();
                }
                if (this.elB != null) {
                    this.elB.start();
                }
            }
        }
    }

    public View getView() {
        return this.ctk;
    }

    public void onDestroy() {
        bcu();
        if (this.elz != null) {
            this.elz.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.elz != null) {
            this.elz.aMG();
        }
        am.setBackgroundColor(this.elA, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar) {
        String str;
        if (tbPageContext != null && bjVar != null && bjVar.aCr() != null && bjVar.aCK() != null) {
            if (this.elv != null && this.elv.NR != null && !this.els) {
                an anVar = new an("c12645");
                if (this.elv.ekM == 0) {
                    anVar.X("obj_type", 1);
                } else if (this.elv.ekM == 1) {
                    anVar.X("obj_type", 2);
                }
                anVar.cx("tid", this.elv.NR.getTid());
                TiebaStatic.log(anVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aCr().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.els) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aCK());
            alaLiveInfoCoreData.userName = bjVar.aCK().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
