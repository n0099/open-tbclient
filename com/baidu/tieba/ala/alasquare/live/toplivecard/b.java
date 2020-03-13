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
    private TbPageContext<?> cVi;
    private FrameLayout csZ;
    private g.b dMt;
    private QuickVideoView.b dMx;
    private g.f dVq;
    private boolean elc;
    private c elf;
    private final float eli;
    private AlaSquareLiveVideoMask elj;
    private QuickVideoView elk;
    private j ell;
    private n elm;
    private int eln;
    private int elo;
    private int elp;
    private int elq;
    private String elr;
    private a els;
    private int elt;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void P(bj bjVar);

        void Q(bj bjVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.eli = 0.0f;
        this.cVi = null;
        this.elr = "";
        this.elc = false;
        this.dMx = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                b.this.bcp();
            }
        };
        this.dMt = new g.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                b.this.hS(false);
                return true;
            }
        };
        this.dVq = new g.f() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(false);
                    gVar.setVolume(0.0f, 0.0f);
                    if (b.this.elf != null && b.this.elf.NQ != null) {
                        if (b.this.elc) {
                            if (b.this.els != null) {
                                b.this.els.Q(b.this.elf.NQ);
                            }
                        } else {
                            an anVar = new an("c12646");
                            if (b.this.elf.ekw != 0) {
                                if (b.this.elf.ekw == 1) {
                                    anVar.X("obj_type", 2);
                                }
                            } else {
                                anVar.X("obj_type", 1);
                            }
                            anVar.cy("tid", b.this.elf.NQ.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                    b.this.bd(gVar.getVideoHeight(), gVar.getVideoWidth());
                    b.this.elj.bcj();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.elf != null && b.this.elf.NQ != null) {
                    if (b.this.els != null) {
                        b.this.els.P(b.this.elf.NQ);
                    }
                    b.this.a(b.this.cVi, b.this.elf.NQ);
                }
            }
        };
        this.cVi = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.elc = z;
        this.elj.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.cVi != null) {
            this.csZ = (FrameLayout) LayoutInflater.from(this.cVi.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.eln = l.getEquipmentWidth(this.cVi.getPageActivity());
            this.elo = l.getEquipmentHeight(this.cVi.getPageActivity());
            this.elp = (int) ((this.eln / 16.0d) * 9.0d);
            this.elq = (int) ((this.eln / 4.0d) * 3.0d);
            this.elt = (int) ((this.elo / 3.0d) - (this.elq / 2.0d));
            this.elj = (AlaSquareLiveVideoMask) this.csZ.findViewById(R.id.video_mask);
            this.csZ.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.els = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.NQ != null && cVar.NQ.aCH() != null) {
            if (this.elf == null || (this.elf.NQ != null && !this.elf.NQ.getTid().equals(cVar.NQ.getTid()))) {
                oD(cVar.NQ.aCH().screen_direction);
            }
            this.elf = cVar;
            this.Yy = this.elf.NQ.aCH().screen_direction;
            this.elj.setData(this.elf.NQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(int i, int i2) {
        int i3;
        int i4;
        if (this.Yy == 1 && this.elk != null && this.elk.getParent() != null) {
            float f = i / i2;
            float f2 = (this.eln * i) / this.elo;
            if (f2 < i2) {
                i3 = (int) (this.elo / f);
                i4 = this.elo;
            } else if (f2 > i2) {
                i3 = this.eln;
                i4 = (int) (f * this.eln);
            } else {
                i3 = this.eln;
                i4 = this.elo;
            }
            if (this.elk.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.elk.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.elk.setLayoutParams(layoutParams);
                return;
            }
            this.elk.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void oC(int i) {
        if (this.elk != null) {
            if (i == 1) {
                if (this.elk.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.elk.getLayoutParams();
                    layoutParams.width = this.eln;
                    layoutParams.height = this.elo;
                    layoutParams.topMargin = -this.elt;
                    this.elk.setLayoutParams(layoutParams);
                    return;
                }
                this.elk.setLayoutParams(new FrameLayout.LayoutParams(this.eln, this.elo));
            } else if (this.elk.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.elk.getLayoutParams();
                layoutParams2.width = this.eln;
                layoutParams2.height = this.elp;
                this.elk.setLayoutParams(layoutParams2);
            } else {
                this.elk.setLayoutParams(new FrameLayout.LayoutParams(this.eln, this.elp));
            }
        }
    }

    private void oD(int i) {
        if (i == 1) {
            if (this.elc) {
                if (this.csZ.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.csZ.getLayoutParams();
                    layoutParams.width = this.eln;
                    layoutParams.height = this.elq;
                    this.csZ.setLayoutParams(layoutParams);
                    return;
                }
                this.csZ.setLayoutParams(new FrameLayout.LayoutParams(this.eln, this.elq));
                return;
            } else if (this.csZ.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.csZ.getLayoutParams();
                layoutParams2.width = this.eln;
                layoutParams2.height = this.eln;
                this.csZ.setLayoutParams(layoutParams2);
                return;
            } else {
                this.csZ.setLayoutParams(new AbsListView.LayoutParams(this.eln, this.eln));
                return;
            }
        }
        this.Yy = 2;
        if (this.elc) {
            if (this.csZ.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.csZ.getLayoutParams();
                layoutParams3.width = this.eln;
                layoutParams3.height = this.elp;
                this.csZ.setLayoutParams(layoutParams3);
                return;
            }
            this.csZ.setLayoutParams(new AbsListView.LayoutParams(this.eln, this.elp));
        } else if (this.csZ.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.csZ.getLayoutParams();
            layoutParams4.width = this.eln;
            layoutParams4.height = this.elp;
            this.csZ.setLayoutParams(layoutParams4);
        } else {
            this.csZ.setLayoutParams(new AbsListView.LayoutParams(this.eln, this.elp));
        }
    }

    public void bco() {
        this.eln = l.getEquipmentWidth(this.cVi.getPageActivity());
        this.elo = l.getEquipmentHeight(this.cVi.getPageActivity());
        this.elp = (int) ((this.eln / 16.0d) * 9.0d);
        this.elq = (int) ((this.eln / 4.0d) * 3.0d);
        this.elt = (int) ((this.elo / 3.0d) - (this.elq / 2.0d));
        if (this.elf != null) {
            boolean isPlaying = this.elk == null ? false : this.elk.isPlaying();
            oD(this.elf.NQ.aCH().screen_direction);
            oC(this.elf.NQ.aCH().screen_direction);
            bcp();
            if (isPlaying) {
                startPlay(this.elr);
            }
        }
    }

    public void bcp() {
        hS(true);
    }

    public void hS(boolean z) {
        if (z) {
            bcq();
        }
        if (this.elk != null) {
            this.elk.stopPlayback();
        }
        this.elj.bck();
        this.elj.bcl();
    }

    private void bcq() {
        if (this.elm != null) {
            if (this.elm.cyF() != null) {
                this.elm.cyF().setPlayer(null);
                this.elm.cyF().stop();
            }
            this.elm = null;
        }
        if (this.ell != null) {
            this.ell.setPlayer(null);
            this.ell.stop();
            this.ell = null;
        }
        if (this.elk != null) {
            this.elk.stopPlayback();
            this.elk.setOnPreparedListener(null);
            this.elk.setOnErrorListener(null);
            this.elk.setOnSurfaceDestroyedListener(null);
            this.elk.setBusiness(null);
            if (this.elk.getParent() != null) {
                ((ViewGroup) this.elk.getParent()).removeView(this.elk);
            }
            this.elk = null;
        }
    }

    private void bcr() {
        if (this.elf != null && this.elf.NQ != null && this.elf.NQ.aCH() != null) {
            if (this.elk != null && this.elk.getParent() != null) {
                bcq();
            }
            this.elm = new n(this.cVi.getPageActivity());
            this.ell = new j();
            this.elk = new QuickVideoView(this.cVi.getPageActivity());
            this.elk.setOnPreparedListener(this.dVq);
            this.elk.setOnErrorListener(this.dMt);
            this.elk.setOnSurfaceDestroyedListener(this.dMx);
            this.elk.setBusiness(this.elm);
            this.elk.setVolume(0.0f, 0.0f);
            this.ell.setPlayer(this.elk);
            this.ell.a(new j.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.j.c
                public void bcs() {
                }
            });
            if (this.elk.getParent() == null) {
                this.csZ.addView(this.elk, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            oC(this.elf.NQ.aCH().screen_direction);
        }
    }

    public void startPlay(String str) {
        if (!StringUtils.isNull(str) && this.elf != null && this.elf.NQ != null && this.elf.NQ.aCH() != null) {
            if (!str.equals(this.elr) || (this.elk != null && !this.elk.isPlaying())) {
                this.elr = str;
                bcp();
            }
            if (this.elk == null) {
                bcr();
            }
            if (this.elk != null && !this.elk.isPlaying()) {
                if (this.elm != null) {
                    y yVar = new y();
                    yVar.mLocate = "9";
                    yVar.emo = String.valueOf(this.elf.NQ.getFid());
                    yVar.Pj = this.elf.NQ.getTid();
                    this.elm.setVideoStatsData(yVar);
                    if (this.elm.cza() != null) {
                        this.elm.cza().b(this.elf.NQ.aCH());
                    }
                }
                if (this.elk != null) {
                    this.elk.setVideoPath(this.elf.NQ.aCH().hls_url);
                }
                if (this.elk != null) {
                    this.elk.start();
                }
                if (this.ell != null) {
                    this.ell.start();
                }
            }
        }
    }

    public View getView() {
        return this.csZ;
    }

    public void onDestroy() {
        bcq();
        if (this.elj != null) {
            this.elj.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.elj != null) {
            this.elj.aMC();
        }
        am.setBackgroundColor(this.elk, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar) {
        String str;
        if (tbPageContext != null && bjVar != null && bjVar.aCo() != null && bjVar.aCH() != null) {
            if (this.elf != null && this.elf.NQ != null && !this.elc) {
                an anVar = new an("c12645");
                if (this.elf.ekw == 0) {
                    anVar.X("obj_type", 1);
                } else if (this.elf.ekw == 1) {
                    anVar.X("obj_type", 2);
                }
                anVar.cy("tid", this.elf.NQ.getTid());
                TiebaStatic.log(anVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aCo().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.elc) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aCH());
            alaLiveInfoCoreData.userName = bjVar.aCH().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
