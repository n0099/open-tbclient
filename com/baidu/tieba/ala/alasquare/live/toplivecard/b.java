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
    private int Px;
    private FrameLayout bEf;
    private QuickVideoView.b cTC;
    private g.b cTy;
    private TbPageContext<?> ceu;
    private g.f dcT;
    private c dvB;
    private final float dvE;
    private AlaSquareLiveVideoMask dvF;
    private QuickVideoView dvG;
    private j dvH;
    private n dvI;
    private int dvJ;
    private int dvK;
    private int dvL;
    private int dvM;
    private String dvN;
    private a dvO;
    private int dvP;
    private boolean dvy;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes6.dex */
    public interface a {
        void J(bh bhVar);

        void K(bh bhVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.dvE = 0.0f;
        this.ceu = null;
        this.dvN = "";
        this.dvy = false;
        this.cTC = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                b.this.aJd();
            }
        };
        this.cTy = new g.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                b.this.gB(false);
                return true;
            }
        };
        this.dcT = new g.f() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(false);
                    gVar.setVolume(0.0f, 0.0f);
                    if (b.this.dvB != null && b.this.dvB.cqG != null) {
                        if (b.this.dvy) {
                            if (b.this.dvO != null) {
                                b.this.dvO.K(b.this.dvB.cqG);
                            }
                        } else {
                            an anVar = new an("c12646");
                            if (b.this.dvB.duS != 0) {
                                if (b.this.dvB.duS == 1) {
                                    anVar.O("obj_type", 2);
                                }
                            } else {
                                anVar.O("obj_type", 1);
                            }
                            anVar.bS("tid", b.this.dvB.cqG.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                    b.this.aJ(gVar.getVideoHeight(), gVar.getVideoWidth());
                    b.this.dvF.aIX();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.dvB != null && b.this.dvB.cqG != null) {
                    if (b.this.dvO != null) {
                        b.this.dvO.J(b.this.dvB.cqG);
                    }
                    b.this.a(b.this.ceu, b.this.dvB.cqG);
                }
            }
        };
        this.ceu = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.dvy = z;
        this.dvF.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.ceu != null) {
            this.bEf = (FrameLayout) LayoutInflater.from(this.ceu.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.dvJ = l.getEquipmentWidth(this.ceu.getPageActivity());
            this.dvK = l.getEquipmentHeight(this.ceu.getPageActivity());
            this.dvL = (int) ((this.dvJ / 16.0d) * 9.0d);
            this.dvM = (int) ((this.dvJ / 4.0d) * 3.0d);
            this.dvP = (int) ((this.dvK / 3.0d) - (this.dvM / 2.0d));
            this.dvF = (AlaSquareLiveVideoMask) this.bEf.findViewById(R.id.video_mask);
            this.bEf.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.dvO = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.cqG != null && cVar.cqG.aiX() != null) {
            if (this.dvB == null || (this.dvB.cqG != null && !this.dvB.cqG.getTid().equals(cVar.cqG.getTid()))) {
                md(cVar.cqG.aiX().screen_direction);
            }
            this.dvB = cVar;
            this.Px = this.dvB.cqG.aiX().screen_direction;
            this.dvF.setData(this.dvB.cqG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(int i, int i2) {
        int i3;
        int i4;
        if (this.Px == 1 && this.dvG != null && this.dvG.getParent() != null) {
            float f = i / i2;
            float f2 = (this.dvJ * i) / this.dvK;
            if (f2 < i2) {
                i3 = (int) (this.dvK / f);
                i4 = this.dvK;
            } else if (f2 > i2) {
                i3 = this.dvJ;
                i4 = (int) (f * this.dvJ);
            } else {
                i3 = this.dvJ;
                i4 = this.dvK;
            }
            if (this.dvG.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dvG.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.dvG.setLayoutParams(layoutParams);
                return;
            }
            this.dvG.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void mc(int i) {
        if (this.dvG != null) {
            if (i == 1) {
                if (this.dvG.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dvG.getLayoutParams();
                    layoutParams.width = this.dvJ;
                    layoutParams.height = this.dvK;
                    layoutParams.topMargin = -this.dvP;
                    this.dvG.setLayoutParams(layoutParams);
                    return;
                }
                this.dvG.setLayoutParams(new FrameLayout.LayoutParams(this.dvJ, this.dvK));
            } else if (this.dvG.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.dvG.getLayoutParams();
                layoutParams2.width = this.dvJ;
                layoutParams2.height = this.dvL;
                this.dvG.setLayoutParams(layoutParams2);
            } else {
                this.dvG.setLayoutParams(new FrameLayout.LayoutParams(this.dvJ, this.dvL));
            }
        }
    }

    private void md(int i) {
        if (i == 1) {
            if (this.dvy) {
                if (this.bEf.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bEf.getLayoutParams();
                    layoutParams.width = this.dvJ;
                    layoutParams.height = this.dvM;
                    this.bEf.setLayoutParams(layoutParams);
                    return;
                }
                this.bEf.setLayoutParams(new FrameLayout.LayoutParams(this.dvJ, this.dvM));
                return;
            } else if (this.bEf.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.bEf.getLayoutParams();
                layoutParams2.width = this.dvJ;
                layoutParams2.height = this.dvJ;
                this.bEf.setLayoutParams(layoutParams2);
                return;
            } else {
                this.bEf.setLayoutParams(new AbsListView.LayoutParams(this.dvJ, this.dvJ));
                return;
            }
        }
        this.Px = 2;
        if (this.dvy) {
            if (this.bEf.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.bEf.getLayoutParams();
                layoutParams3.width = this.dvJ;
                layoutParams3.height = this.dvL;
                this.bEf.setLayoutParams(layoutParams3);
                return;
            }
            this.bEf.setLayoutParams(new AbsListView.LayoutParams(this.dvJ, this.dvL));
        } else if (this.bEf.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.bEf.getLayoutParams();
            layoutParams4.width = this.dvJ;
            layoutParams4.height = this.dvL;
            this.bEf.setLayoutParams(layoutParams4);
        } else {
            this.bEf.setLayoutParams(new AbsListView.LayoutParams(this.dvJ, this.dvL));
        }
    }

    public void aJc() {
        this.dvJ = l.getEquipmentWidth(this.ceu.getPageActivity());
        this.dvK = l.getEquipmentHeight(this.ceu.getPageActivity());
        this.dvL = (int) ((this.dvJ / 16.0d) * 9.0d);
        this.dvM = (int) ((this.dvJ / 4.0d) * 3.0d);
        this.dvP = (int) ((this.dvK / 3.0d) - (this.dvM / 2.0d));
        if (this.dvB != null) {
            boolean isPlaying = this.dvG == null ? false : this.dvG.isPlaying();
            md(this.dvB.cqG.aiX().screen_direction);
            mc(this.dvB.cqG.aiX().screen_direction);
            aJd();
            if (isPlaying) {
                startPlay(this.dvN);
            }
        }
    }

    public void aJd() {
        gB(true);
    }

    public void gB(boolean z) {
        if (z) {
            aJe();
        }
        if (this.dvG != null) {
            this.dvG.stopPlayback();
        }
        this.dvF.aIY();
        this.dvF.aIZ();
    }

    private void aJe() {
        if (this.dvI != null) {
            if (this.dvI.ccf() != null) {
                this.dvI.ccf().setPlayer(null);
                this.dvI.ccf().stop();
            }
            this.dvI = null;
        }
        if (this.dvH != null) {
            this.dvH.setPlayer(null);
            this.dvH.stop();
            this.dvH = null;
        }
        if (this.dvG != null) {
            this.dvG.stopPlayback();
            this.dvG.setOnPreparedListener(null);
            this.dvG.setOnErrorListener(null);
            this.dvG.setOnSurfaceDestroyedListener(null);
            this.dvG.setBusiness(null);
            if (this.dvG.getParent() != null) {
                ((ViewGroup) this.dvG.getParent()).removeView(this.dvG);
            }
            this.dvG = null;
        }
    }

    private void aJf() {
        if (this.dvB != null && this.dvB.cqG != null && this.dvB.cqG.aiX() != null) {
            if (this.dvG != null && this.dvG.getParent() != null) {
                aJe();
            }
            this.dvI = new n(this.ceu.getPageActivity());
            this.dvH = new j();
            this.dvG = new QuickVideoView(this.ceu.getPageActivity());
            this.dvG.setOnPreparedListener(this.dcT);
            this.dvG.setOnErrorListener(this.cTy);
            this.dvG.setOnSurfaceDestroyedListener(this.cTC);
            this.dvG.setBusiness(this.dvI);
            this.dvG.setVolume(0.0f, 0.0f);
            this.dvH.setPlayer(this.dvG);
            this.dvH.a(new j.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.j.c
                public void aJg() {
                }
            });
            if (this.dvG.getParent() == null) {
                this.bEf.addView(this.dvG, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            mc(this.dvB.cqG.aiX().screen_direction);
        }
    }

    public void startPlay(String str) {
        if (!StringUtils.isNull(str) && this.dvB != null && this.dvB.cqG != null && this.dvB.cqG.aiX() != null) {
            if (!str.equals(this.dvN) || (this.dvG != null && !this.dvG.isPlaying())) {
                this.dvN = str;
                aJd();
            }
            if (this.dvG == null) {
                aJf();
            }
            if (this.dvG != null && !this.dvG.isPlaying()) {
                if (this.dvI != null) {
                    z zVar = new z();
                    zVar.mLocate = "9";
                    zVar.ePc = String.valueOf(this.dvB.cqG.getFid());
                    zVar.cma = this.dvB.cqG.getTid();
                    this.dvI.setVideoStatsData(zVar);
                    if (this.dvI.ccw() != null) {
                        this.dvI.ccw().b(this.dvB.cqG.aiX());
                    }
                }
                if (this.dvG != null) {
                    this.dvG.setVideoPath(this.dvB.cqG.aiX().hls_url);
                }
                if (this.dvG != null) {
                    this.dvG.start();
                }
                if (this.dvH != null) {
                    this.dvH.start();
                }
            }
        }
    }

    public View getView() {
        return this.bEf;
    }

    public void onDestroy() {
        aJe();
        if (this.dvF != null) {
            this.dvF.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.dvF != null) {
            this.dvF.ask();
        }
        am.setBackgroundColor(this.dvG, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bh bhVar) {
        String str;
        if (tbPageContext != null && bhVar != null && bhVar.aiE() != null && bhVar.aiX() != null) {
            if (this.dvB != null && this.dvB.cqG != null && !this.dvy) {
                an anVar = new an("c12645");
                if (this.dvB.duS == 0) {
                    anVar.O("obj_type", 1);
                } else if (this.dvB.duS == 1) {
                    anVar.O("obj_type", 2);
                }
                anVar.bS("tid", this.dvB.cqG.getTid());
                TiebaStatic.log(anVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bhVar.aiE().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.dvy) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bhVar.aiX());
            alaLiveInfoCoreData.userName = bhVar.aiX().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
