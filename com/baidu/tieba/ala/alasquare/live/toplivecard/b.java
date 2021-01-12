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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.b.c;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.o;
/* loaded from: classes9.dex */
public class b {
    private int aHw;
    private FrameLayout ajf;
    private TbPageContext<?> eSJ;
    private CyberPlayerManager.OnPreparedListener eyt;
    private CyberPlayerManager.OnErrorListener eyu;
    private TbCyberVideoView.a fRT;
    private boolean gxf;
    private c gxi;
    private final float gxl;
    private AlaSquareLiveVideoMask gxm;
    private TbCyberVideoView gxn;
    private f gxo;
    private int gxp;
    private int gxq;
    private int gxr;
    private int gxs;
    private String gxt;
    private a gxu;
    private int gxv;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes9.dex */
    public interface a {
        void T(bz bzVar);

        void U(bz bzVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.gxl = 0.0f;
        this.eSJ = null;
        this.gxt = "";
        this.gxf = false;
        this.fRT = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                b.this.bQH();
            }
        };
        this.eyu = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                b.this.mr(false);
                return true;
            }
        };
        this.eyt = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (b.this.gxn != null) {
                    b.this.gxn.setLooping(false);
                    b.this.gxn.setVolume(0.0f, 0.0f);
                    if (b.this.gxi != null && b.this.gxi.ale != null) {
                        if (b.this.gxf) {
                            if (b.this.gxu != null) {
                                b.this.gxu.U(b.this.gxi.ale);
                            }
                        } else {
                            aq aqVar = new aq("c12646");
                            if (b.this.gxi.gwz != 0) {
                                if (b.this.gxi.gwz == 1) {
                                    aqVar.an("obj_type", 2);
                                }
                            } else {
                                aqVar.an("obj_type", 1);
                            }
                            aqVar.dW("tid", b.this.gxi.ale.getTid());
                            TiebaStatic.log(aqVar);
                        }
                    }
                    if (b.this.gxn.getCyberPlayer() != null) {
                        b.this.bD(b.this.gxn.getCyberPlayer().getVideoHeight(), b.this.gxn.getCyberPlayer().getVideoWidth());
                    }
                    if (b.this.gxm != null) {
                        b.this.gxm.bQB();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gxi != null && b.this.gxi.ale != null) {
                    if (b.this.gxu != null) {
                        b.this.gxu.T(b.this.gxi.ale);
                    }
                    b.this.a(b.this.eSJ, b.this.gxi.ale);
                }
            }
        };
        this.eSJ = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.gxf = z;
        this.gxm.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.eSJ != null) {
            this.ajf = (FrameLayout) LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.gxp = l.getEquipmentWidth(this.eSJ.getPageActivity());
            this.gxq = l.getEquipmentHeight(this.eSJ.getPageActivity());
            this.gxr = (int) ((this.gxp / 16.0d) * 9.0d);
            this.gxs = (int) ((this.gxp / 4.0d) * 3.0d);
            this.gxv = (int) ((this.gxq / 3.0d) - (this.gxs / 2.0d));
            this.gxm = (AlaSquareLiveVideoMask) this.ajf.findViewById(R.id.video_mask);
            this.ajf.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.gxu = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.ale != null && cVar.ale.bnQ() != null) {
            if (this.gxi == null || (this.gxi.ale != null && !this.gxi.ale.getTid().equals(cVar.ale.getTid()))) {
                tC(cVar.ale.bnQ().screen_direction);
            }
            this.gxi = cVar;
            this.aHw = this.gxi.ale.bnQ().screen_direction;
            this.gxm.setData(this.gxi.ale);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(int i, int i2) {
        int i3;
        int i4;
        if (this.aHw == 1 && this.gxn != null && this.gxn.getParent() != null) {
            float f = i / i2;
            float f2 = (this.gxp * i) / this.gxq;
            if (f2 < i2) {
                i3 = (int) (this.gxq / f);
                i4 = this.gxq;
            } else if (f2 > i2) {
                i3 = this.gxp;
                i4 = (int) (f * this.gxp);
            } else {
                i3 = this.gxp;
                i4 = this.gxq;
            }
            if (this.gxn.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gxn.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.gxn.setLayoutParams(layoutParams);
                return;
            }
            this.gxn.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void tB(int i) {
        if (this.gxn != null) {
            if (i == 1) {
                if (this.gxn.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gxn.getLayoutParams();
                    layoutParams.width = this.gxp;
                    layoutParams.height = this.gxq;
                    layoutParams.topMargin = -this.gxv;
                    this.gxn.setLayoutParams(layoutParams);
                    return;
                }
                this.gxn.setLayoutParams(new FrameLayout.LayoutParams(this.gxp, this.gxq));
            } else if (this.gxn.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gxn.getLayoutParams();
                layoutParams2.width = this.gxp;
                layoutParams2.height = this.gxr;
                this.gxn.setLayoutParams(layoutParams2);
            } else {
                this.gxn.setLayoutParams(new FrameLayout.LayoutParams(this.gxp, this.gxr));
            }
        }
    }

    private void tC(int i) {
        if (i == 1) {
            if (this.gxf) {
                if (this.ajf.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ajf.getLayoutParams();
                    layoutParams.width = this.gxp;
                    layoutParams.height = this.gxs;
                    this.ajf.setLayoutParams(layoutParams);
                    return;
                }
                this.ajf.setLayoutParams(new FrameLayout.LayoutParams(this.gxp, this.gxs));
                return;
            } else if (this.ajf.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ajf.getLayoutParams();
                layoutParams2.width = this.gxp;
                layoutParams2.height = this.gxp;
                this.ajf.setLayoutParams(layoutParams2);
                return;
            } else {
                this.ajf.setLayoutParams(new AbsListView.LayoutParams(this.gxp, this.gxp));
                return;
            }
        }
        this.aHw = 2;
        if (this.gxf) {
            if (this.ajf.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.ajf.getLayoutParams();
                layoutParams3.width = this.gxp;
                layoutParams3.height = this.gxr;
                this.ajf.setLayoutParams(layoutParams3);
                return;
            }
            this.ajf.setLayoutParams(new AbsListView.LayoutParams(this.gxp, this.gxr));
        } else if (this.ajf.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.ajf.getLayoutParams();
            layoutParams4.width = this.gxp;
            layoutParams4.height = this.gxr;
            this.ajf.setLayoutParams(layoutParams4);
        } else {
            this.ajf.setLayoutParams(new AbsListView.LayoutParams(this.gxp, this.gxr));
        }
    }

    public void bQG() {
        this.gxp = l.getEquipmentWidth(this.eSJ.getPageActivity());
        this.gxq = l.getEquipmentHeight(this.eSJ.getPageActivity());
        this.gxr = (int) ((this.gxp / 16.0d) * 9.0d);
        this.gxs = (int) ((this.gxp / 4.0d) * 3.0d);
        this.gxv = (int) ((this.gxq / 3.0d) - (this.gxs / 2.0d));
        if (this.gxi != null) {
            boolean isPlaying = this.gxn == null ? false : this.gxn.isPlaying();
            tC(this.gxi.ale.bnQ().screen_direction);
            tB(this.gxi.ale.bnQ().screen_direction);
            bQH();
            if (isPlaying) {
                Fy(this.gxt);
            }
        }
    }

    public void bQH() {
        mr(true);
    }

    public void mr(boolean z) {
        if (z) {
            bQI();
        }
        if (this.gxn != null) {
            this.gxn.stopPlayback();
        }
        this.gxm.bQC();
        this.gxm.bQD();
    }

    private void bQI() {
        if (this.gxo != null) {
            this.gxo.setPlayer(null);
            this.gxo.stop();
            this.gxo = null;
        }
        if (this.gxn != null) {
            this.gxn.stopPlayback();
            this.gxn.dyj();
            if (this.gxn.getMediaProgressObserver() != null) {
                this.gxn.getMediaProgressObserver().setPlayer(null);
                this.gxn.getMediaProgressObserver().stop();
            }
            this.gxn = null;
        }
    }

    private void bQJ() {
        if (this.gxi != null && this.gxi.ale != null && this.gxi.ale.bnQ() != null) {
            if (this.gxn != null && this.gxn.getParent() != null) {
                bQI();
            }
            this.gxo = new f();
            this.gxn = new TbCyberVideoView(this.eSJ.getPageActivity());
            this.gxn.setOnPreparedListener(this.eyt);
            this.gxn.setOnErrorListener(this.eyu);
            this.gxn.setOnSurfaceDestroyedListener(this.fRT);
            this.gxn.setVolume(0.0f, 0.0f);
            this.gxn.setStageType(null);
            this.gxo.setPlayer(this.gxn);
            this.gxo.a(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.f.c
                public void bQK() {
                }
            });
            if (this.gxn.getParent() == null) {
                this.ajf.addView(this.gxn, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            tB(this.gxi.ale.bnQ().screen_direction);
        }
    }

    public void Fy(String str) {
        if (!StringUtils.isNull(str) && this.gxi != null && this.gxi.ale != null && this.gxi.ale.bnQ() != null) {
            if (!str.equals(this.gxt) || (this.gxn != null && !this.gxn.isPlaying())) {
                this.gxt = str;
                bQH();
            }
            if (this.gxn == null) {
                bQJ();
            }
            if (this.gxn != null && !this.gxn.isPlaying()) {
                o oVar = new o();
                oVar.mLocate = "9";
                oVar.fKR = String.valueOf(this.gxi.ale.getFid());
                oVar.amM = this.gxi.ale.getTid();
                this.gxn.setVideoStatData(oVar);
                if (this.gxn != null) {
                    this.gxn.setVideoPath(this.gxi.ale.bnQ().hls_url);
                }
                if (this.gxn != null) {
                    this.gxn.start();
                }
                if (this.gxo != null) {
                    this.gxo.start();
                }
            }
        }
    }

    public View getView() {
        return this.ajf;
    }

    public void onDestroy() {
        bQI();
        if (this.gxm != null) {
            this.gxm.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.gxm != null) {
            this.gxm.byV();
        }
        ao.setBackgroundColor(this.gxn, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bz bzVar) {
        String str;
        if (tbPageContext != null && bzVar != null && bzVar.bnx() != null && bzVar.bnQ() != null) {
            if (this.gxi != null && this.gxi.ale != null && !this.gxf) {
                aq aqVar = new aq("c12645");
                if (this.gxi.gwz == 0) {
                    aqVar.an("obj_type", 1);
                } else if (this.gxi.gwz == 1) {
                    aqVar.an("obj_type", 2);
                }
                aqVar.dW("tid", this.gxi.ale.getTid());
                TiebaStatic.log(aqVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bzVar.bnx().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.gxf) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bzVar.bnQ());
            alaLiveInfoCoreData.userName = bzVar.bnQ().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
