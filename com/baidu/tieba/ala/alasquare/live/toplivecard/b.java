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
    private int aqS;
    private FrameLayout cSf;
    private TbPageContext<?> duG;
    private boolean eOS;
    private c eOV;
    private final float eOY;
    private AlaSquareLiveVideoMask eOZ;
    private QuickVideoView ePa;
    private j ePb;
    private n ePc;
    private int ePd;
    private int ePe;
    private int ePf;
    private int ePg;
    private String ePh;
    private a ePi;
    private int ePj;
    private g.b emA;
    private QuickVideoView.b emE;
    private g.f evF;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void Q(bj bjVar);

        void R(bj bjVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.eOY = 0.0f;
        this.duG = null;
        this.ePh = "";
        this.eOS = false;
        this.emE = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                b.this.blk();
            }
        };
        this.emA = new g.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                b.this.iS(false);
                return true;
            }
        };
        this.evF = new g.f() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(false);
                    gVar.setVolume(0.0f, 0.0f);
                    if (b.this.eOV != null && b.this.eOV.agz != null) {
                        if (b.this.eOS) {
                            if (b.this.ePi != null) {
                                b.this.ePi.R(b.this.eOV.agz);
                            }
                        } else {
                            an anVar = new an("c12646");
                            if (b.this.eOV.eOm != 0) {
                                if (b.this.eOV.eOm == 1) {
                                    anVar.af("obj_type", 2);
                                }
                            } else {
                                anVar.af("obj_type", 1);
                            }
                            anVar.cI("tid", b.this.eOV.agz.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                    b.this.bj(gVar.getVideoHeight(), gVar.getVideoWidth());
                    b.this.eOZ.ble();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.eOV != null && b.this.eOV.agz != null) {
                    if (b.this.ePi != null) {
                        b.this.ePi.Q(b.this.eOV.agz);
                    }
                    b.this.a(b.this.duG, b.this.eOV.agz);
                }
            }
        };
        this.duG = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.eOS = z;
        this.eOZ.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.duG != null) {
            this.cSf = (FrameLayout) LayoutInflater.from(this.duG.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.ePd = l.getEquipmentWidth(this.duG.getPageActivity());
            this.ePe = l.getEquipmentHeight(this.duG.getPageActivity());
            this.ePf = (int) ((this.ePd / 16.0d) * 9.0d);
            this.ePg = (int) ((this.ePd / 4.0d) * 3.0d);
            this.ePj = (int) ((this.ePe / 3.0d) - (this.ePg / 2.0d));
            this.eOZ = (AlaSquareLiveVideoMask) this.cSf.findViewById(R.id.video_mask);
            this.cSf.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.ePi = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.agz != null && cVar.agz.aKX() != null) {
            if (this.eOV == null || (this.eOV.agz != null && !this.eOV.agz.getTid().equals(cVar.agz.getTid()))) {
                oY(cVar.agz.aKX().screen_direction);
            }
            this.eOV = cVar;
            this.aqS = this.eOV.agz.aKX().screen_direction;
            this.eOZ.setData(this.eOV.agz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(int i, int i2) {
        int i3;
        int i4;
        if (this.aqS == 1 && this.ePa != null && this.ePa.getParent() != null) {
            float f = i / i2;
            float f2 = (this.ePd * i) / this.ePe;
            if (f2 < i2) {
                i3 = (int) (this.ePe / f);
                i4 = this.ePe;
            } else if (f2 > i2) {
                i3 = this.ePd;
                i4 = (int) (f * this.ePd);
            } else {
                i3 = this.ePd;
                i4 = this.ePe;
            }
            if (this.ePa.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ePa.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.ePa.setLayoutParams(layoutParams);
                return;
            }
            this.ePa.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void oX(int i) {
        if (this.ePa != null) {
            if (i == 1) {
                if (this.ePa.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ePa.getLayoutParams();
                    layoutParams.width = this.ePd;
                    layoutParams.height = this.ePe;
                    layoutParams.topMargin = -this.ePj;
                    this.ePa.setLayoutParams(layoutParams);
                    return;
                }
                this.ePa.setLayoutParams(new FrameLayout.LayoutParams(this.ePd, this.ePe));
            } else if (this.ePa.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ePa.getLayoutParams();
                layoutParams2.width = this.ePd;
                layoutParams2.height = this.ePf;
                this.ePa.setLayoutParams(layoutParams2);
            } else {
                this.ePa.setLayoutParams(new FrameLayout.LayoutParams(this.ePd, this.ePf));
            }
        }
    }

    private void oY(int i) {
        if (i == 1) {
            if (this.eOS) {
                if (this.cSf.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cSf.getLayoutParams();
                    layoutParams.width = this.ePd;
                    layoutParams.height = this.ePg;
                    this.cSf.setLayoutParams(layoutParams);
                    return;
                }
                this.cSf.setLayoutParams(new FrameLayout.LayoutParams(this.ePd, this.ePg));
                return;
            } else if (this.cSf.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.cSf.getLayoutParams();
                layoutParams2.width = this.ePd;
                layoutParams2.height = this.ePd;
                this.cSf.setLayoutParams(layoutParams2);
                return;
            } else {
                this.cSf.setLayoutParams(new AbsListView.LayoutParams(this.ePd, this.ePd));
                return;
            }
        }
        this.aqS = 2;
        if (this.eOS) {
            if (this.cSf.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.cSf.getLayoutParams();
                layoutParams3.width = this.ePd;
                layoutParams3.height = this.ePf;
                this.cSf.setLayoutParams(layoutParams3);
                return;
            }
            this.cSf.setLayoutParams(new AbsListView.LayoutParams(this.ePd, this.ePf));
        } else if (this.cSf.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.cSf.getLayoutParams();
            layoutParams4.width = this.ePd;
            layoutParams4.height = this.ePf;
            this.cSf.setLayoutParams(layoutParams4);
        } else {
            this.cSf.setLayoutParams(new AbsListView.LayoutParams(this.ePd, this.ePf));
        }
    }

    public void blj() {
        this.ePd = l.getEquipmentWidth(this.duG.getPageActivity());
        this.ePe = l.getEquipmentHeight(this.duG.getPageActivity());
        this.ePf = (int) ((this.ePd / 16.0d) * 9.0d);
        this.ePg = (int) ((this.ePd / 4.0d) * 3.0d);
        this.ePj = (int) ((this.ePe / 3.0d) - (this.ePg / 2.0d));
        if (this.eOV != null) {
            boolean isPlaying = this.ePa == null ? false : this.ePa.isPlaying();
            oY(this.eOV.agz.aKX().screen_direction);
            oX(this.eOV.agz.aKX().screen_direction);
            blk();
            if (isPlaying) {
                zn(this.ePh);
            }
        }
    }

    public void blk() {
        iS(true);
    }

    public void iS(boolean z) {
        if (z) {
            bll();
        }
        if (this.ePa != null) {
            this.ePa.stopPlayback();
        }
        this.eOZ.blf();
        this.eOZ.blg();
    }

    private void bll() {
        if (this.ePc != null) {
            if (this.ePc.cJD() != null) {
                this.ePc.cJD().setPlayer(null);
                this.ePc.cJD().stop();
            }
            this.ePc = null;
        }
        if (this.ePb != null) {
            this.ePb.setPlayer(null);
            this.ePb.stop();
            this.ePb = null;
        }
        if (this.ePa != null) {
            this.ePa.stopPlayback();
            this.ePa.setOnPreparedListener(null);
            this.ePa.setOnErrorListener(null);
            this.ePa.setOnSurfaceDestroyedListener(null);
            this.ePa.setBusiness(null);
            if (this.ePa.getParent() != null) {
                ((ViewGroup) this.ePa.getParent()).removeView(this.ePa);
            }
            this.ePa = null;
        }
    }

    private void blm() {
        if (this.eOV != null && this.eOV.agz != null && this.eOV.agz.aKX() != null) {
            if (this.ePa != null && this.ePa.getParent() != null) {
                bll();
            }
            this.ePc = new n(this.duG.getPageActivity());
            this.ePb = new j();
            this.ePa = new QuickVideoView(this.duG.getPageActivity());
            this.ePa.setOnPreparedListener(this.evF);
            this.ePa.setOnErrorListener(this.emA);
            this.ePa.setOnSurfaceDestroyedListener(this.emE);
            this.ePa.setBusiness(this.ePc);
            this.ePa.setVolume(0.0f, 0.0f);
            this.ePb.setPlayer(this.ePa);
            this.ePb.a(new j.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.j.c
                public void bln() {
                }
            });
            if (this.ePa.getParent() == null) {
                this.cSf.addView(this.ePa, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            oX(this.eOV.agz.aKX().screen_direction);
        }
    }

    public void zn(String str) {
        if (!StringUtils.isNull(str) && this.eOV != null && this.eOV.agz != null && this.eOV.agz.aKX() != null) {
            if (!str.equals(this.ePh) || (this.ePa != null && !this.ePa.isPlaying())) {
                this.ePh = str;
                blk();
            }
            if (this.ePa == null) {
                blm();
            }
            if (this.ePa != null && !this.ePa.isPlaying()) {
                if (this.ePc != null) {
                    y yVar = new y();
                    yVar.mLocate = "9";
                    yVar.eQf = String.valueOf(this.eOV.agz.getFid());
                    yVar.ahL = this.eOV.agz.getTid();
                    this.ePc.setVideoStatsData(yVar);
                    if (this.ePc.cJY() != null) {
                        this.ePc.cJY().b(this.eOV.agz.aKX());
                    }
                }
                if (this.ePa != null) {
                    this.ePa.setVideoPath(this.eOV.agz.aKX().hls_url);
                }
                if (this.ePa != null) {
                    this.ePa.start();
                }
                if (this.ePb != null) {
                    this.ePb.start();
                }
            }
        }
    }

    public View getView() {
        return this.cSf;
    }

    public void onDestroy() {
        bll();
        if (this.eOZ != null) {
            this.eOZ.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.eOZ != null) {
            this.eOZ.aVd();
        }
        am.setBackgroundColor(this.ePa, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar) {
        String str;
        if (tbPageContext != null && bjVar != null && bjVar.aKE() != null && bjVar.aKX() != null) {
            if (this.eOV != null && this.eOV.agz != null && !this.eOS) {
                an anVar = new an("c12645");
                if (this.eOV.eOm == 0) {
                    anVar.af("obj_type", 1);
                } else if (this.eOV.eOm == 1) {
                    anVar.af("obj_type", 2);
                }
                anVar.cI("tid", this.eOV.agz.getTid());
                TiebaStatic.log(anVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aKE().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.eOS) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aKX());
            alaLiveInfoCoreData.userName = bjVar.aKX().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
