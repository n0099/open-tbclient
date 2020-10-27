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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.b.c;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.o;
/* loaded from: classes4.dex */
public class b {
    private int aJx;
    private FrameLayout aii;
    private TbPageContext<?> eCn;
    private CyberPlayerManager.OnPreparedListener eim;
    private CyberPlayerManager.OnErrorListener ein;
    private TbCyberVideoView.a fzS;
    private boolean gdf;
    private c gdi;
    private final float gdl;
    private AlaSquareLiveVideoMask gdm;
    private TbCyberVideoView gdn;
    private f gdo;
    private int gdp;
    private int gdq;
    private int gdr;
    private int gds;
    private String gdt;
    private a gdu;
    private int gdv;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes4.dex */
    public interface a {
        void Q(bw bwVar);

        void R(bw bwVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.gdl = 0.0f;
        this.eCn = null;
        this.gdt = "";
        this.gdf = false;
        this.fzS = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                b.this.bMr();
            }
        };
        this.ein = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                b.this.lt(false);
                return true;
            }
        };
        this.eim = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (b.this.gdn != null) {
                    b.this.gdn.setLooping(false);
                    b.this.gdn.setVolume(0.0f, 0.0f);
                    if (b.this.gdi != null && b.this.gdi.akq != null) {
                        if (b.this.gdf) {
                            if (b.this.gdu != null) {
                                b.this.gdu.R(b.this.gdi.akq);
                            }
                        } else {
                            aq aqVar = new aq("c12646");
                            if (b.this.gdi.gcz != 0) {
                                if (b.this.gdi.gcz == 1) {
                                    aqVar.aj("obj_type", 2);
                                }
                            } else {
                                aqVar.aj("obj_type", 1);
                            }
                            aqVar.dR("tid", b.this.gdi.akq.getTid());
                            TiebaStatic.log(aqVar);
                        }
                    }
                    if (b.this.gdn.getCyberPlayer() != null) {
                        b.this.bD(b.this.gdn.getCyberPlayer().getVideoHeight(), b.this.gdn.getCyberPlayer().getVideoWidth());
                    }
                    if (b.this.gdm != null) {
                        b.this.gdm.bMl();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gdi != null && b.this.gdi.akq != null) {
                    if (b.this.gdu != null) {
                        b.this.gdu.Q(b.this.gdi.akq);
                    }
                    b.this.a(b.this.eCn, b.this.gdi.akq);
                }
            }
        };
        this.eCn = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.gdf = z;
        this.gdm.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.eCn != null) {
            this.aii = (FrameLayout) LayoutInflater.from(this.eCn.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.gdp = l.getEquipmentWidth(this.eCn.getPageActivity());
            this.gdq = l.getEquipmentHeight(this.eCn.getPageActivity());
            this.gdr = (int) ((this.gdp / 16.0d) * 9.0d);
            this.gds = (int) ((this.gdp / 4.0d) * 3.0d);
            this.gdv = (int) ((this.gdq / 3.0d) - (this.gds / 2.0d));
            this.gdm = (AlaSquareLiveVideoMask) this.aii.findViewById(R.id.video_mask);
            this.aii.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.gdu = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.akq != null && cVar.akq.bku() != null) {
            if (this.gdi == null || (this.gdi.akq != null && !this.gdi.akq.getTid().equals(cVar.akq.getTid()))) {
                tK(cVar.akq.bku().screen_direction);
            }
            this.gdi = cVar;
            this.aJx = this.gdi.akq.bku().screen_direction;
            this.gdm.setData(this.gdi.akq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(int i, int i2) {
        int i3;
        int i4;
        if (this.aJx == 1 && this.gdn != null && this.gdn.getParent() != null) {
            float f = i / i2;
            float f2 = (this.gdp * i) / this.gdq;
            if (f2 < i2) {
                i3 = (int) (this.gdq / f);
                i4 = this.gdq;
            } else if (f2 > i2) {
                i3 = this.gdp;
                i4 = (int) (f * this.gdp);
            } else {
                i3 = this.gdp;
                i4 = this.gdq;
            }
            if (this.gdn.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gdn.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.gdn.setLayoutParams(layoutParams);
                return;
            }
            this.gdn.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void tJ(int i) {
        if (this.gdn != null) {
            if (i == 1) {
                if (this.gdn.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gdn.getLayoutParams();
                    layoutParams.width = this.gdp;
                    layoutParams.height = this.gdq;
                    layoutParams.topMargin = -this.gdv;
                    this.gdn.setLayoutParams(layoutParams);
                    return;
                }
                this.gdn.setLayoutParams(new FrameLayout.LayoutParams(this.gdp, this.gdq));
            } else if (this.gdn.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gdn.getLayoutParams();
                layoutParams2.width = this.gdp;
                layoutParams2.height = this.gdr;
                this.gdn.setLayoutParams(layoutParams2);
            } else {
                this.gdn.setLayoutParams(new FrameLayout.LayoutParams(this.gdp, this.gdr));
            }
        }
    }

    private void tK(int i) {
        if (i == 1) {
            if (this.gdf) {
                if (this.aii.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aii.getLayoutParams();
                    layoutParams.width = this.gdp;
                    layoutParams.height = this.gds;
                    this.aii.setLayoutParams(layoutParams);
                    return;
                }
                this.aii.setLayoutParams(new FrameLayout.LayoutParams(this.gdp, this.gds));
                return;
            } else if (this.aii.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aii.getLayoutParams();
                layoutParams2.width = this.gdp;
                layoutParams2.height = this.gdp;
                this.aii.setLayoutParams(layoutParams2);
                return;
            } else {
                this.aii.setLayoutParams(new AbsListView.LayoutParams(this.gdp, this.gdp));
                return;
            }
        }
        this.aJx = 2;
        if (this.gdf) {
            if (this.aii.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.aii.getLayoutParams();
                layoutParams3.width = this.gdp;
                layoutParams3.height = this.gdr;
                this.aii.setLayoutParams(layoutParams3);
                return;
            }
            this.aii.setLayoutParams(new AbsListView.LayoutParams(this.gdp, this.gdr));
        } else if (this.aii.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.aii.getLayoutParams();
            layoutParams4.width = this.gdp;
            layoutParams4.height = this.gdr;
            this.aii.setLayoutParams(layoutParams4);
        } else {
            this.aii.setLayoutParams(new AbsListView.LayoutParams(this.gdp, this.gdr));
        }
    }

    public void bMq() {
        this.gdp = l.getEquipmentWidth(this.eCn.getPageActivity());
        this.gdq = l.getEquipmentHeight(this.eCn.getPageActivity());
        this.gdr = (int) ((this.gdp / 16.0d) * 9.0d);
        this.gds = (int) ((this.gdp / 4.0d) * 3.0d);
        this.gdv = (int) ((this.gdq / 3.0d) - (this.gds / 2.0d));
        if (this.gdi != null) {
            boolean isPlaying = this.gdn == null ? false : this.gdn.isPlaying();
            tK(this.gdi.akq.bku().screen_direction);
            tJ(this.gdi.akq.bku().screen_direction);
            bMr();
            if (isPlaying) {
                Gj(this.gdt);
            }
        }
    }

    public void bMr() {
        lt(true);
    }

    public void lt(boolean z) {
        if (z) {
            bMs();
        }
        if (this.gdn != null) {
            this.gdn.stopPlayback();
        }
        this.gdm.bMm();
        this.gdm.bMn();
    }

    private void bMs() {
        if (this.gdo != null) {
            this.gdo.setPlayer(null);
            this.gdo.stop();
            this.gdo = null;
        }
        if (this.gdn != null) {
            this.gdn.stopPlayback();
            this.gdn.duQ();
            if (this.gdn.getMediaProgressObserver() != null) {
                this.gdn.getMediaProgressObserver().setPlayer(null);
                this.gdn.getMediaProgressObserver().stop();
            }
            this.gdn = null;
        }
    }

    private void bMt() {
        if (this.gdi != null && this.gdi.akq != null && this.gdi.akq.bku() != null) {
            if (this.gdn != null && this.gdn.getParent() != null) {
                bMs();
            }
            this.gdo = new f();
            this.gdn = new TbCyberVideoView(this.eCn.getPageActivity());
            this.gdn.setOnPreparedListener(this.eim);
            this.gdn.setOnErrorListener(this.ein);
            this.gdn.setOnSurfaceDestroyedListener(this.fzS);
            this.gdn.setVolume(0.0f, 0.0f);
            this.gdn.setStageType(null);
            this.gdo.setPlayer(this.gdn);
            this.gdo.a(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.f.c
                public void bMu() {
                }
            });
            if (this.gdn.getParent() == null) {
                this.aii.addView(this.gdn, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            tJ(this.gdi.akq.bku().screen_direction);
        }
    }

    public void Gj(String str) {
        if (!StringUtils.isNull(str) && this.gdi != null && this.gdi.akq != null && this.gdi.akq.bku() != null) {
            if (!str.equals(this.gdt) || (this.gdn != null && !this.gdn.isPlaying())) {
                this.gdt = str;
                bMr();
            }
            if (this.gdn == null) {
                bMt();
            }
            if (this.gdn != null && !this.gdn.isPlaying()) {
                o oVar = new o();
                oVar.mLocate = "9";
                oVar.fsZ = String.valueOf(this.gdi.akq.getFid());
                oVar.alT = this.gdi.akq.getTid();
                this.gdn.setVideoStatData(oVar);
                if (this.gdn != null) {
                    this.gdn.setVideoPath(this.gdi.akq.bku().hls_url);
                }
                if (this.gdn != null) {
                    this.gdn.start();
                }
                if (this.gdo != null) {
                    this.gdo.start();
                }
            }
        }
    }

    public View getView() {
        return this.aii;
    }

    public void onDestroy() {
        bMs();
        if (this.gdm != null) {
            this.gdm.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.gdm != null) {
            this.gdm.bvf();
        }
        ap.setBackgroundColor(this.gdn, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bw bwVar) {
        String str;
        if (tbPageContext != null && bwVar != null && bwVar.bka() != null && bwVar.bku() != null) {
            if (this.gdi != null && this.gdi.akq != null && !this.gdf) {
                aq aqVar = new aq("c12645");
                if (this.gdi.gcz == 0) {
                    aqVar.aj("obj_type", 1);
                } else if (this.gdi.gcz == 1) {
                    aqVar.aj("obj_type", 2);
                }
                aqVar.dR("tid", this.gdi.akq.getTid());
                TiebaStatic.log(aqVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.bka().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.gdf) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.bku());
            alaLiveInfoCoreData.userName = bwVar.bku().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
