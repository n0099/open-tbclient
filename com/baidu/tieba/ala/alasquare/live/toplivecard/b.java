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
    private TbPageContext<?> cVh;
    private FrameLayout csY;
    private g.b dMg;
    private QuickVideoView.b dMk;
    private g.f dVd;
    private boolean ekP;
    private c ekS;
    private final float ekV;
    private AlaSquareLiveVideoMask ekW;
    private QuickVideoView ekX;
    private j ekY;
    private n ekZ;
    private int ela;
    private int elb;
    private int elc;
    private int eld;
    private String ele;
    private a elf;
    private int elg;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void P(bj bjVar);

        void Q(bj bjVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.ekV = 0.0f;
        this.cVh = null;
        this.ele = "";
        this.ekP = false;
        this.dMk = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                b.this.bco();
            }
        };
        this.dMg = new g.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                b.this.hS(false);
                return true;
            }
        };
        this.dVd = new g.f() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(false);
                    gVar.setVolume(0.0f, 0.0f);
                    if (b.this.ekS != null && b.this.ekS.NQ != null) {
                        if (b.this.ekP) {
                            if (b.this.elf != null) {
                                b.this.elf.Q(b.this.ekS.NQ);
                            }
                        } else {
                            an anVar = new an("c12646");
                            if (b.this.ekS.ekj != 0) {
                                if (b.this.ekS.ekj == 1) {
                                    anVar.X("obj_type", 2);
                                }
                            } else {
                                anVar.X("obj_type", 1);
                            }
                            anVar.cy("tid", b.this.ekS.NQ.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                    b.this.bd(gVar.getVideoHeight(), gVar.getVideoWidth());
                    b.this.ekW.bci();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.ekS != null && b.this.ekS.NQ != null) {
                    if (b.this.elf != null) {
                        b.this.elf.P(b.this.ekS.NQ);
                    }
                    b.this.a(b.this.cVh, b.this.ekS.NQ);
                }
            }
        };
        this.cVh = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.ekP = z;
        this.ekW.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.cVh != null) {
            this.csY = (FrameLayout) LayoutInflater.from(this.cVh.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.ela = l.getEquipmentWidth(this.cVh.getPageActivity());
            this.elb = l.getEquipmentHeight(this.cVh.getPageActivity());
            this.elc = (int) ((this.ela / 16.0d) * 9.0d);
            this.eld = (int) ((this.ela / 4.0d) * 3.0d);
            this.elg = (int) ((this.elb / 3.0d) - (this.eld / 2.0d));
            this.ekW = (AlaSquareLiveVideoMask) this.csY.findViewById(R.id.video_mask);
            this.csY.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.elf = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.NQ != null && cVar.NQ.aCH() != null) {
            if (this.ekS == null || (this.ekS.NQ != null && !this.ekS.NQ.getTid().equals(cVar.NQ.getTid()))) {
                oD(cVar.NQ.aCH().screen_direction);
            }
            this.ekS = cVar;
            this.Yy = this.ekS.NQ.aCH().screen_direction;
            this.ekW.setData(this.ekS.NQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(int i, int i2) {
        int i3;
        int i4;
        if (this.Yy == 1 && this.ekX != null && this.ekX.getParent() != null) {
            float f = i / i2;
            float f2 = (this.ela * i) / this.elb;
            if (f2 < i2) {
                i3 = (int) (this.elb / f);
                i4 = this.elb;
            } else if (f2 > i2) {
                i3 = this.ela;
                i4 = (int) (f * this.ela);
            } else {
                i3 = this.ela;
                i4 = this.elb;
            }
            if (this.ekX.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ekX.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.ekX.setLayoutParams(layoutParams);
                return;
            }
            this.ekX.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void oC(int i) {
        if (this.ekX != null) {
            if (i == 1) {
                if (this.ekX.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ekX.getLayoutParams();
                    layoutParams.width = this.ela;
                    layoutParams.height = this.elb;
                    layoutParams.topMargin = -this.elg;
                    this.ekX.setLayoutParams(layoutParams);
                    return;
                }
                this.ekX.setLayoutParams(new FrameLayout.LayoutParams(this.ela, this.elb));
            } else if (this.ekX.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ekX.getLayoutParams();
                layoutParams2.width = this.ela;
                layoutParams2.height = this.elc;
                this.ekX.setLayoutParams(layoutParams2);
            } else {
                this.ekX.setLayoutParams(new FrameLayout.LayoutParams(this.ela, this.elc));
            }
        }
    }

    private void oD(int i) {
        if (i == 1) {
            if (this.ekP) {
                if (this.csY.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.csY.getLayoutParams();
                    layoutParams.width = this.ela;
                    layoutParams.height = this.eld;
                    this.csY.setLayoutParams(layoutParams);
                    return;
                }
                this.csY.setLayoutParams(new FrameLayout.LayoutParams(this.ela, this.eld));
                return;
            } else if (this.csY.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.csY.getLayoutParams();
                layoutParams2.width = this.ela;
                layoutParams2.height = this.ela;
                this.csY.setLayoutParams(layoutParams2);
                return;
            } else {
                this.csY.setLayoutParams(new AbsListView.LayoutParams(this.ela, this.ela));
                return;
            }
        }
        this.Yy = 2;
        if (this.ekP) {
            if (this.csY.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.csY.getLayoutParams();
                layoutParams3.width = this.ela;
                layoutParams3.height = this.elc;
                this.csY.setLayoutParams(layoutParams3);
                return;
            }
            this.csY.setLayoutParams(new AbsListView.LayoutParams(this.ela, this.elc));
        } else if (this.csY.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.csY.getLayoutParams();
            layoutParams4.width = this.ela;
            layoutParams4.height = this.elc;
            this.csY.setLayoutParams(layoutParams4);
        } else {
            this.csY.setLayoutParams(new AbsListView.LayoutParams(this.ela, this.elc));
        }
    }

    public void bcn() {
        this.ela = l.getEquipmentWidth(this.cVh.getPageActivity());
        this.elb = l.getEquipmentHeight(this.cVh.getPageActivity());
        this.elc = (int) ((this.ela / 16.0d) * 9.0d);
        this.eld = (int) ((this.ela / 4.0d) * 3.0d);
        this.elg = (int) ((this.elb / 3.0d) - (this.eld / 2.0d));
        if (this.ekS != null) {
            boolean isPlaying = this.ekX == null ? false : this.ekX.isPlaying();
            oD(this.ekS.NQ.aCH().screen_direction);
            oC(this.ekS.NQ.aCH().screen_direction);
            bco();
            if (isPlaying) {
                startPlay(this.ele);
            }
        }
    }

    public void bco() {
        hS(true);
    }

    public void hS(boolean z) {
        if (z) {
            bcp();
        }
        if (this.ekX != null) {
            this.ekX.stopPlayback();
        }
        this.ekW.bcj();
        this.ekW.bck();
    }

    private void bcp() {
        if (this.ekZ != null) {
            if (this.ekZ.cyE() != null) {
                this.ekZ.cyE().setPlayer(null);
                this.ekZ.cyE().stop();
            }
            this.ekZ = null;
        }
        if (this.ekY != null) {
            this.ekY.setPlayer(null);
            this.ekY.stop();
            this.ekY = null;
        }
        if (this.ekX != null) {
            this.ekX.stopPlayback();
            this.ekX.setOnPreparedListener(null);
            this.ekX.setOnErrorListener(null);
            this.ekX.setOnSurfaceDestroyedListener(null);
            this.ekX.setBusiness(null);
            if (this.ekX.getParent() != null) {
                ((ViewGroup) this.ekX.getParent()).removeView(this.ekX);
            }
            this.ekX = null;
        }
    }

    private void bcq() {
        if (this.ekS != null && this.ekS.NQ != null && this.ekS.NQ.aCH() != null) {
            if (this.ekX != null && this.ekX.getParent() != null) {
                bcp();
            }
            this.ekZ = new n(this.cVh.getPageActivity());
            this.ekY = new j();
            this.ekX = new QuickVideoView(this.cVh.getPageActivity());
            this.ekX.setOnPreparedListener(this.dVd);
            this.ekX.setOnErrorListener(this.dMg);
            this.ekX.setOnSurfaceDestroyedListener(this.dMk);
            this.ekX.setBusiness(this.ekZ);
            this.ekX.setVolume(0.0f, 0.0f);
            this.ekY.setPlayer(this.ekX);
            this.ekY.a(new j.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.j.c
                public void bcr() {
                }
            });
            if (this.ekX.getParent() == null) {
                this.csY.addView(this.ekX, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            oC(this.ekS.NQ.aCH().screen_direction);
        }
    }

    public void startPlay(String str) {
        if (!StringUtils.isNull(str) && this.ekS != null && this.ekS.NQ != null && this.ekS.NQ.aCH() != null) {
            if (!str.equals(this.ele) || (this.ekX != null && !this.ekX.isPlaying())) {
                this.ele = str;
                bco();
            }
            if (this.ekX == null) {
                bcq();
            }
            if (this.ekX != null && !this.ekX.isPlaying()) {
                if (this.ekZ != null) {
                    y yVar = new y();
                    yVar.mLocate = "9";
                    yVar.emb = String.valueOf(this.ekS.NQ.getFid());
                    yVar.Pj = this.ekS.NQ.getTid();
                    this.ekZ.setVideoStatsData(yVar);
                    if (this.ekZ.cyZ() != null) {
                        this.ekZ.cyZ().b(this.ekS.NQ.aCH());
                    }
                }
                if (this.ekX != null) {
                    this.ekX.setVideoPath(this.ekS.NQ.aCH().hls_url);
                }
                if (this.ekX != null) {
                    this.ekX.start();
                }
                if (this.ekY != null) {
                    this.ekY.start();
                }
            }
        }
    }

    public View getView() {
        return this.csY;
    }

    public void onDestroy() {
        bcp();
        if (this.ekW != null) {
            this.ekW.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.ekW != null) {
            this.ekW.aMB();
        }
        am.setBackgroundColor(this.ekX, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar) {
        String str;
        if (tbPageContext != null && bjVar != null && bjVar.aCo() != null && bjVar.aCH() != null) {
            if (this.ekS != null && this.ekS.NQ != null && !this.ekP) {
                an anVar = new an("c12645");
                if (this.ekS.ekj == 0) {
                    anVar.X("obj_type", 1);
                } else if (this.ekS.ekj == 1) {
                    anVar.X("obj_type", 2);
                }
                anVar.cy("tid", this.ekS.NQ.getTid());
                TiebaStatic.log(anVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aCo().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.ekP) {
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
