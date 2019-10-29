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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.b.c;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
/* loaded from: classes6.dex */
public class b {
    private int Qd;
    private FrameLayout bEW;
    private g.b cUp;
    private QuickVideoView.b cUt;
    private TbPageContext<?> cfl;
    private g.f ddL;
    private int dwA;
    private int dwB;
    private int dwC;
    private int dwD;
    private String dwE;
    private a dwF;
    private int dwG;
    private boolean dwp;
    private c dws;
    private final float dwv;
    private AlaSquareLiveVideoMask dww;
    private QuickVideoView dwx;
    private j dwy;
    private n dwz;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes6.dex */
    public interface a {
        void J(bh bhVar);

        void K(bh bhVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.dwv = 0.0f;
        this.cfl = null;
        this.dwE = "";
        this.dwp = false;
        this.cUt = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                b.this.aJf();
            }
        };
        this.cUp = new g.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                b.this.gB(false);
                return true;
            }
        };
        this.ddL = new g.f() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(false);
                    gVar.setVolume(0.0f, 0.0f);
                    if (b.this.dws != null && b.this.dws.cry != null) {
                        if (b.this.dwp) {
                            if (b.this.dwF != null) {
                                b.this.dwF.K(b.this.dws.cry);
                            }
                        } else {
                            an anVar = new an("c12646");
                            if (b.this.dws.dvJ != 0) {
                                if (b.this.dws.dvJ == 1) {
                                    anVar.O("obj_type", 2);
                                }
                            } else {
                                anVar.O("obj_type", 1);
                            }
                            anVar.bS("tid", b.this.dws.cry.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                    b.this.aL(gVar.getVideoHeight(), gVar.getVideoWidth());
                    b.this.dww.aIZ();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.dws != null && b.this.dws.cry != null) {
                    if (b.this.dwF != null) {
                        b.this.dwF.J(b.this.dws.cry);
                    }
                    b.this.a(b.this.cfl, b.this.dws.cry);
                }
            }
        };
        this.cfl = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.dwp = z;
        this.dww.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.cfl != null) {
            this.bEW = (FrameLayout) LayoutInflater.from(this.cfl.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.dwA = l.getEquipmentWidth(this.cfl.getPageActivity());
            this.dwB = l.getEquipmentHeight(this.cfl.getPageActivity());
            this.dwC = (int) ((this.dwA / 16.0d) * 9.0d);
            this.dwD = (int) ((this.dwA / 4.0d) * 3.0d);
            this.dwG = (int) ((this.dwB / 3.0d) - (this.dwD / 2.0d));
            this.dww = (AlaSquareLiveVideoMask) this.bEW.findViewById(R.id.video_mask);
            this.bEW.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.dwF = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.cry != null && cVar.cry.aiZ() != null) {
            if (this.dws == null || (this.dws.cry != null && !this.dws.cry.getTid().equals(cVar.cry.getTid()))) {
                me(cVar.cry.aiZ().screen_direction);
            }
            this.dws = cVar;
            this.Qd = this.dws.cry.aiZ().screen_direction;
            this.dww.setData(this.dws.cry);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(int i, int i2) {
        int i3;
        int i4;
        if (this.Qd == 1 && this.dwx != null && this.dwx.getParent() != null) {
            float f = i / i2;
            float f2 = (this.dwA * i) / this.dwB;
            if (f2 < i2) {
                i3 = (int) (this.dwB / f);
                i4 = this.dwB;
            } else if (f2 > i2) {
                i3 = this.dwA;
                i4 = (int) (f * this.dwA);
            } else {
                i3 = this.dwA;
                i4 = this.dwB;
            }
            if (this.dwx.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dwx.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.dwx.setLayoutParams(layoutParams);
                return;
            }
            this.dwx.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void md(int i) {
        if (this.dwx != null) {
            if (i == 1) {
                if (this.dwx.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dwx.getLayoutParams();
                    layoutParams.width = this.dwA;
                    layoutParams.height = this.dwB;
                    layoutParams.topMargin = -this.dwG;
                    this.dwx.setLayoutParams(layoutParams);
                    return;
                }
                this.dwx.setLayoutParams(new FrameLayout.LayoutParams(this.dwA, this.dwB));
            } else if (this.dwx.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.dwx.getLayoutParams();
                layoutParams2.width = this.dwA;
                layoutParams2.height = this.dwC;
                this.dwx.setLayoutParams(layoutParams2);
            } else {
                this.dwx.setLayoutParams(new FrameLayout.LayoutParams(this.dwA, this.dwC));
            }
        }
    }

    private void me(int i) {
        if (i == 1) {
            if (this.dwp) {
                if (this.bEW.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bEW.getLayoutParams();
                    layoutParams.width = this.dwA;
                    layoutParams.height = this.dwD;
                    this.bEW.setLayoutParams(layoutParams);
                    return;
                }
                this.bEW.setLayoutParams(new FrameLayout.LayoutParams(this.dwA, this.dwD));
                return;
            } else if (this.bEW.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.bEW.getLayoutParams();
                layoutParams2.width = this.dwA;
                layoutParams2.height = this.dwA;
                this.bEW.setLayoutParams(layoutParams2);
                return;
            } else {
                this.bEW.setLayoutParams(new AbsListView.LayoutParams(this.dwA, this.dwA));
                return;
            }
        }
        this.Qd = 2;
        if (this.dwp) {
            if (this.bEW.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.bEW.getLayoutParams();
                layoutParams3.width = this.dwA;
                layoutParams3.height = this.dwC;
                this.bEW.setLayoutParams(layoutParams3);
                return;
            }
            this.bEW.setLayoutParams(new AbsListView.LayoutParams(this.dwA, this.dwC));
        } else if (this.bEW.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.bEW.getLayoutParams();
            layoutParams4.width = this.dwA;
            layoutParams4.height = this.dwC;
            this.bEW.setLayoutParams(layoutParams4);
        } else {
            this.bEW.setLayoutParams(new AbsListView.LayoutParams(this.dwA, this.dwC));
        }
    }

    public void aJe() {
        this.dwA = l.getEquipmentWidth(this.cfl.getPageActivity());
        this.dwB = l.getEquipmentHeight(this.cfl.getPageActivity());
        this.dwC = (int) ((this.dwA / 16.0d) * 9.0d);
        this.dwD = (int) ((this.dwA / 4.0d) * 3.0d);
        this.dwG = (int) ((this.dwB / 3.0d) - (this.dwD / 2.0d));
        if (this.dws != null) {
            boolean isPlaying = this.dwx == null ? false : this.dwx.isPlaying();
            me(this.dws.cry.aiZ().screen_direction);
            md(this.dws.cry.aiZ().screen_direction);
            aJf();
            if (isPlaying) {
                startPlay(this.dwE);
            }
        }
    }

    public void aJf() {
        gB(true);
    }

    public void gB(boolean z) {
        if (z) {
            aJg();
        }
        if (this.dwx != null) {
            this.dwx.stopPlayback();
        }
        this.dww.aJa();
        this.dww.aJb();
    }

    private void aJg() {
        if (this.dwz != null) {
            if (this.dwz.cch() != null) {
                this.dwz.cch().setPlayer(null);
                this.dwz.cch().stop();
            }
            this.dwz = null;
        }
        if (this.dwy != null) {
            this.dwy.setPlayer(null);
            this.dwy.stop();
            this.dwy = null;
        }
        if (this.dwx != null) {
            this.dwx.stopPlayback();
            this.dwx.setOnPreparedListener(null);
            this.dwx.setOnErrorListener(null);
            this.dwx.setOnSurfaceDestroyedListener(null);
            this.dwx.setBusiness(null);
            if (this.dwx.getParent() != null) {
                ((ViewGroup) this.dwx.getParent()).removeView(this.dwx);
            }
            this.dwx = null;
        }
    }

    private void aJh() {
        if (this.dws != null && this.dws.cry != null && this.dws.cry.aiZ() != null) {
            if (this.dwx != null && this.dwx.getParent() != null) {
                aJg();
            }
            this.dwz = new n(this.cfl.getPageActivity());
            this.dwy = new j();
            this.dwx = new QuickVideoView(this.cfl.getPageActivity());
            this.dwx.setOnPreparedListener(this.ddL);
            this.dwx.setOnErrorListener(this.cUp);
            this.dwx.setOnSurfaceDestroyedListener(this.cUt);
            this.dwx.setBusiness(this.dwz);
            this.dwx.setVolume(0.0f, 0.0f);
            this.dwy.setPlayer(this.dwx);
            this.dwy.a(new j.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.j.c
                public void aJi() {
                }
            });
            if (this.dwx.getParent() == null) {
                this.bEW.addView(this.dwx, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            md(this.dws.cry.aiZ().screen_direction);
        }
    }

    public void startPlay(String str) {
        if (!StringUtils.isNull(str) && this.dws != null && this.dws.cry != null && this.dws.cry.aiZ() != null) {
            if (!str.equals(this.dwE) || (this.dwx != null && !this.dwx.isPlaying())) {
                this.dwE = str;
                aJf();
            }
            if (this.dwx == null) {
                aJh();
            }
            if (this.dwx != null && !this.dwx.isPlaying()) {
                if (this.dwz != null) {
                    z zVar = new z();
                    zVar.mLocate = "9";
                    zVar.ePT = String.valueOf(this.dws.cry.getFid());
                    zVar.cmS = this.dws.cry.getTid();
                    this.dwz.setVideoStatsData(zVar);
                    if (this.dwz.ccy() != null) {
                        this.dwz.ccy().b(this.dws.cry.aiZ());
                    }
                }
                if (this.dwx != null) {
                    this.dwx.setVideoPath(this.dws.cry.aiZ().hls_url);
                }
                if (this.dwx != null) {
                    this.dwx.start();
                }
                if (this.dwy != null) {
                    this.dwy.start();
                }
            }
        }
    }

    public View getView() {
        return this.bEW;
    }

    public void onDestroy() {
        aJg();
        if (this.dww != null) {
            this.dww.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.dww != null) {
            this.dww.asm();
        }
        am.setBackgroundColor(this.dwx, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bh bhVar) {
        String str;
        if (tbPageContext != null && bhVar != null && bhVar.aiG() != null && bhVar.aiZ() != null) {
            if (this.dws != null && this.dws.cry != null && !this.dwp) {
                an anVar = new an("c12645");
                if (this.dws.dvJ == 0) {
                    anVar.O("obj_type", 1);
                } else if (this.dws.dvJ == 1) {
                    anVar.O("obj_type", 2);
                }
                anVar.bS("tid", this.dws.cry.getTid());
                TiebaStatic.log(anVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bhVar.aiG().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.dwp) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bhVar.aiZ());
            alaLiveInfoCoreData.userName = bhVar.aiZ().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
