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
    private int aqY;
    private FrameLayout cSk;
    private TbPageContext<?> duK;
    private boolean eOX;
    private c ePa;
    private final float ePd;
    private AlaSquareLiveVideoMask ePe;
    private QuickVideoView ePf;
    private j ePg;
    private n ePh;
    private int ePi;
    private int ePj;
    private int ePk;
    private int ePl;
    private String ePm;
    private a ePn;
    private int ePo;
    private g.b emF;
    private QuickVideoView.b emJ;
    private g.f evK;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void Q(bj bjVar);

        void R(bj bjVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.ePd = 0.0f;
        this.duK = null;
        this.ePm = "";
        this.eOX = false;
        this.emJ = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                b.this.bli();
            }
        };
        this.emF = new g.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                b.this.iS(false);
                return true;
            }
        };
        this.evK = new g.f() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(false);
                    gVar.setVolume(0.0f, 0.0f);
                    if (b.this.ePa != null && b.this.ePa.agC != null) {
                        if (b.this.eOX) {
                            if (b.this.ePn != null) {
                                b.this.ePn.R(b.this.ePa.agC);
                            }
                        } else {
                            an anVar = new an("c12646");
                            if (b.this.ePa.eOr != 0) {
                                if (b.this.ePa.eOr == 1) {
                                    anVar.af("obj_type", 2);
                                }
                            } else {
                                anVar.af("obj_type", 1);
                            }
                            anVar.cI("tid", b.this.ePa.agC.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                    b.this.bj(gVar.getVideoHeight(), gVar.getVideoWidth());
                    b.this.ePe.blc();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.ePa != null && b.this.ePa.agC != null) {
                    if (b.this.ePn != null) {
                        b.this.ePn.Q(b.this.ePa.agC);
                    }
                    b.this.a(b.this.duK, b.this.ePa.agC);
                }
            }
        };
        this.duK = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.eOX = z;
        this.ePe.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.duK != null) {
            this.cSk = (FrameLayout) LayoutInflater.from(this.duK.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.ePi = l.getEquipmentWidth(this.duK.getPageActivity());
            this.ePj = l.getEquipmentHeight(this.duK.getPageActivity());
            this.ePk = (int) ((this.ePi / 16.0d) * 9.0d);
            this.ePl = (int) ((this.ePi / 4.0d) * 3.0d);
            this.ePo = (int) ((this.ePj / 3.0d) - (this.ePl / 2.0d));
            this.ePe = (AlaSquareLiveVideoMask) this.cSk.findViewById(R.id.video_mask);
            this.cSk.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.ePn = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.agC != null && cVar.agC.aKV() != null) {
            if (this.ePa == null || (this.ePa.agC != null && !this.ePa.agC.getTid().equals(cVar.agC.getTid()))) {
                oY(cVar.agC.aKV().screen_direction);
            }
            this.ePa = cVar;
            this.aqY = this.ePa.agC.aKV().screen_direction;
            this.ePe.setData(this.ePa.agC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(int i, int i2) {
        int i3;
        int i4;
        if (this.aqY == 1 && this.ePf != null && this.ePf.getParent() != null) {
            float f = i / i2;
            float f2 = (this.ePi * i) / this.ePj;
            if (f2 < i2) {
                i3 = (int) (this.ePj / f);
                i4 = this.ePj;
            } else if (f2 > i2) {
                i3 = this.ePi;
                i4 = (int) (f * this.ePi);
            } else {
                i3 = this.ePi;
                i4 = this.ePj;
            }
            if (this.ePf.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ePf.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.ePf.setLayoutParams(layoutParams);
                return;
            }
            this.ePf.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void oX(int i) {
        if (this.ePf != null) {
            if (i == 1) {
                if (this.ePf.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ePf.getLayoutParams();
                    layoutParams.width = this.ePi;
                    layoutParams.height = this.ePj;
                    layoutParams.topMargin = -this.ePo;
                    this.ePf.setLayoutParams(layoutParams);
                    return;
                }
                this.ePf.setLayoutParams(new FrameLayout.LayoutParams(this.ePi, this.ePj));
            } else if (this.ePf.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ePf.getLayoutParams();
                layoutParams2.width = this.ePi;
                layoutParams2.height = this.ePk;
                this.ePf.setLayoutParams(layoutParams2);
            } else {
                this.ePf.setLayoutParams(new FrameLayout.LayoutParams(this.ePi, this.ePk));
            }
        }
    }

    private void oY(int i) {
        if (i == 1) {
            if (this.eOX) {
                if (this.cSk.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cSk.getLayoutParams();
                    layoutParams.width = this.ePi;
                    layoutParams.height = this.ePl;
                    this.cSk.setLayoutParams(layoutParams);
                    return;
                }
                this.cSk.setLayoutParams(new FrameLayout.LayoutParams(this.ePi, this.ePl));
                return;
            } else if (this.cSk.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.cSk.getLayoutParams();
                layoutParams2.width = this.ePi;
                layoutParams2.height = this.ePi;
                this.cSk.setLayoutParams(layoutParams2);
                return;
            } else {
                this.cSk.setLayoutParams(new AbsListView.LayoutParams(this.ePi, this.ePi));
                return;
            }
        }
        this.aqY = 2;
        if (this.eOX) {
            if (this.cSk.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.cSk.getLayoutParams();
                layoutParams3.width = this.ePi;
                layoutParams3.height = this.ePk;
                this.cSk.setLayoutParams(layoutParams3);
                return;
            }
            this.cSk.setLayoutParams(new AbsListView.LayoutParams(this.ePi, this.ePk));
        } else if (this.cSk.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.cSk.getLayoutParams();
            layoutParams4.width = this.ePi;
            layoutParams4.height = this.ePk;
            this.cSk.setLayoutParams(layoutParams4);
        } else {
            this.cSk.setLayoutParams(new AbsListView.LayoutParams(this.ePi, this.ePk));
        }
    }

    public void blh() {
        this.ePi = l.getEquipmentWidth(this.duK.getPageActivity());
        this.ePj = l.getEquipmentHeight(this.duK.getPageActivity());
        this.ePk = (int) ((this.ePi / 16.0d) * 9.0d);
        this.ePl = (int) ((this.ePi / 4.0d) * 3.0d);
        this.ePo = (int) ((this.ePj / 3.0d) - (this.ePl / 2.0d));
        if (this.ePa != null) {
            boolean isPlaying = this.ePf == null ? false : this.ePf.isPlaying();
            oY(this.ePa.agC.aKV().screen_direction);
            oX(this.ePa.agC.aKV().screen_direction);
            bli();
            if (isPlaying) {
                zq(this.ePm);
            }
        }
    }

    public void bli() {
        iS(true);
    }

    public void iS(boolean z) {
        if (z) {
            blj();
        }
        if (this.ePf != null) {
            this.ePf.stopPlayback();
        }
        this.ePe.bld();
        this.ePe.ble();
    }

    private void blj() {
        if (this.ePh != null) {
            if (this.ePh.cJA() != null) {
                this.ePh.cJA().setPlayer(null);
                this.ePh.cJA().stop();
            }
            this.ePh = null;
        }
        if (this.ePg != null) {
            this.ePg.setPlayer(null);
            this.ePg.stop();
            this.ePg = null;
        }
        if (this.ePf != null) {
            this.ePf.stopPlayback();
            this.ePf.setOnPreparedListener(null);
            this.ePf.setOnErrorListener(null);
            this.ePf.setOnSurfaceDestroyedListener(null);
            this.ePf.setBusiness(null);
            if (this.ePf.getParent() != null) {
                ((ViewGroup) this.ePf.getParent()).removeView(this.ePf);
            }
            this.ePf = null;
        }
    }

    private void blk() {
        if (this.ePa != null && this.ePa.agC != null && this.ePa.agC.aKV() != null) {
            if (this.ePf != null && this.ePf.getParent() != null) {
                blj();
            }
            this.ePh = new n(this.duK.getPageActivity());
            this.ePg = new j();
            this.ePf = new QuickVideoView(this.duK.getPageActivity());
            this.ePf.setOnPreparedListener(this.evK);
            this.ePf.setOnErrorListener(this.emF);
            this.ePf.setOnSurfaceDestroyedListener(this.emJ);
            this.ePf.setBusiness(this.ePh);
            this.ePf.setVolume(0.0f, 0.0f);
            this.ePg.setPlayer(this.ePf);
            this.ePg.a(new j.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.j.c
                public void bll() {
                }
            });
            if (this.ePf.getParent() == null) {
                this.cSk.addView(this.ePf, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            oX(this.ePa.agC.aKV().screen_direction);
        }
    }

    public void zq(String str) {
        if (!StringUtils.isNull(str) && this.ePa != null && this.ePa.agC != null && this.ePa.agC.aKV() != null) {
            if (!str.equals(this.ePm) || (this.ePf != null && !this.ePf.isPlaying())) {
                this.ePm = str;
                bli();
            }
            if (this.ePf == null) {
                blk();
            }
            if (this.ePf != null && !this.ePf.isPlaying()) {
                if (this.ePh != null) {
                    y yVar = new y();
                    yVar.mLocate = "9";
                    yVar.eQk = String.valueOf(this.ePa.agC.getFid());
                    yVar.ahO = this.ePa.agC.getTid();
                    this.ePh.setVideoStatsData(yVar);
                    if (this.ePh.cJV() != null) {
                        this.ePh.cJV().b(this.ePa.agC.aKV());
                    }
                }
                if (this.ePf != null) {
                    this.ePf.setVideoPath(this.ePa.agC.aKV().hls_url);
                }
                if (this.ePf != null) {
                    this.ePf.start();
                }
                if (this.ePg != null) {
                    this.ePg.start();
                }
            }
        }
    }

    public View getView() {
        return this.cSk;
    }

    public void onDestroy() {
        blj();
        if (this.ePe != null) {
            this.ePe.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.ePe != null) {
            this.ePe.aVb();
        }
        am.setBackgroundColor(this.ePf, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar) {
        String str;
        if (tbPageContext != null && bjVar != null && bjVar.aKC() != null && bjVar.aKV() != null) {
            if (this.ePa != null && this.ePa.agC != null && !this.eOX) {
                an anVar = new an("c12645");
                if (this.ePa.eOr == 0) {
                    anVar.af("obj_type", 1);
                } else if (this.ePa.eOr == 1) {
                    anVar.af("obj_type", 2);
                }
                anVar.cI("tid", this.ePa.agC.getTid());
                TiebaStatic.log(anVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aKC().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.eOX) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aKV());
            alaLiveInfoCoreData.userName = bjVar.aKV().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
