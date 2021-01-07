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
/* loaded from: classes10.dex */
public class b {
    private int aMj;
    private FrameLayout ajW;
    private CyberPlayerManager.OnPreparedListener eDf;
    private CyberPlayerManager.OnErrorListener eDg;
    private TbPageContext<?> eXu;
    private TbCyberVideoView.a fWA;
    private boolean gBM;
    private c gBP;
    private final float gBS;
    private AlaSquareLiveVideoMask gBT;
    private TbCyberVideoView gBU;
    private f gBV;
    private int gBW;
    private int gBX;
    private int gBY;
    private int gBZ;
    private String gCa;
    private a gCb;
    private int gCc;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes10.dex */
    public interface a {
        void T(bz bzVar);

        void U(bz bzVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.gBS = 0.0f;
        this.eXu = null;
        this.gCa = "";
        this.gBM = false;
        this.fWA = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                b.this.bUz();
            }
        };
        this.eDg = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                b.this.mv(false);
                return true;
            }
        };
        this.eDf = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (b.this.gBU != null) {
                    b.this.gBU.setLooping(false);
                    b.this.gBU.setVolume(0.0f, 0.0f);
                    if (b.this.gBP != null && b.this.gBP.alW != null) {
                        if (b.this.gBM) {
                            if (b.this.gCb != null) {
                                b.this.gCb.U(b.this.gBP.alW);
                            }
                        } else {
                            aq aqVar = new aq("c12646");
                            if (b.this.gBP.gBg != 0) {
                                if (b.this.gBP.gBg == 1) {
                                    aqVar.an("obj_type", 2);
                                }
                            } else {
                                aqVar.an("obj_type", 1);
                            }
                            aqVar.dX("tid", b.this.gBP.alW.getTid());
                            TiebaStatic.log(aqVar);
                        }
                    }
                    if (b.this.gBU.getCyberPlayer() != null) {
                        b.this.bD(b.this.gBU.getCyberPlayer().getVideoHeight(), b.this.gBU.getCyberPlayer().getVideoWidth());
                    }
                    if (b.this.gBT != null) {
                        b.this.gBT.bUt();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gBP != null && b.this.gBP.alW != null) {
                    if (b.this.gCb != null) {
                        b.this.gCb.T(b.this.gBP.alW);
                    }
                    b.this.a(b.this.eXu, b.this.gBP.alW);
                }
            }
        };
        this.eXu = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.gBM = z;
        this.gBT.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.eXu != null) {
            this.ajW = (FrameLayout) LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.gBW = l.getEquipmentWidth(this.eXu.getPageActivity());
            this.gBX = l.getEquipmentHeight(this.eXu.getPageActivity());
            this.gBY = (int) ((this.gBW / 16.0d) * 9.0d);
            this.gBZ = (int) ((this.gBW / 4.0d) * 3.0d);
            this.gCc = (int) ((this.gBX / 3.0d) - (this.gBZ / 2.0d));
            this.gBT = (AlaSquareLiveVideoMask) this.ajW.findViewById(R.id.video_mask);
            this.ajW.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.gCb = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.alW != null && cVar.alW.brK() != null) {
            if (this.gBP == null || (this.gBP.alW != null && !this.gBP.alW.getTid().equals(cVar.alW.getTid()))) {
                vi(cVar.alW.brK().screen_direction);
            }
            this.gBP = cVar;
            this.aMj = this.gBP.alW.brK().screen_direction;
            this.gBT.setData(this.gBP.alW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(int i, int i2) {
        int i3;
        int i4;
        if (this.aMj == 1 && this.gBU != null && this.gBU.getParent() != null) {
            float f = i / i2;
            float f2 = (this.gBW * i) / this.gBX;
            if (f2 < i2) {
                i3 = (int) (this.gBX / f);
                i4 = this.gBX;
            } else if (f2 > i2) {
                i3 = this.gBW;
                i4 = (int) (f * this.gBW);
            } else {
                i3 = this.gBW;
                i4 = this.gBX;
            }
            if (this.gBU.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gBU.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.gBU.setLayoutParams(layoutParams);
                return;
            }
            this.gBU.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void vh(int i) {
        if (this.gBU != null) {
            if (i == 1) {
                if (this.gBU.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gBU.getLayoutParams();
                    layoutParams.width = this.gBW;
                    layoutParams.height = this.gBX;
                    layoutParams.topMargin = -this.gCc;
                    this.gBU.setLayoutParams(layoutParams);
                    return;
                }
                this.gBU.setLayoutParams(new FrameLayout.LayoutParams(this.gBW, this.gBX));
            } else if (this.gBU.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gBU.getLayoutParams();
                layoutParams2.width = this.gBW;
                layoutParams2.height = this.gBY;
                this.gBU.setLayoutParams(layoutParams2);
            } else {
                this.gBU.setLayoutParams(new FrameLayout.LayoutParams(this.gBW, this.gBY));
            }
        }
    }

    private void vi(int i) {
        if (i == 1) {
            if (this.gBM) {
                if (this.ajW.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ajW.getLayoutParams();
                    layoutParams.width = this.gBW;
                    layoutParams.height = this.gBZ;
                    this.ajW.setLayoutParams(layoutParams);
                    return;
                }
                this.ajW.setLayoutParams(new FrameLayout.LayoutParams(this.gBW, this.gBZ));
                return;
            } else if (this.ajW.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ajW.getLayoutParams();
                layoutParams2.width = this.gBW;
                layoutParams2.height = this.gBW;
                this.ajW.setLayoutParams(layoutParams2);
                return;
            } else {
                this.ajW.setLayoutParams(new AbsListView.LayoutParams(this.gBW, this.gBW));
                return;
            }
        }
        this.aMj = 2;
        if (this.gBM) {
            if (this.ajW.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.ajW.getLayoutParams();
                layoutParams3.width = this.gBW;
                layoutParams3.height = this.gBY;
                this.ajW.setLayoutParams(layoutParams3);
                return;
            }
            this.ajW.setLayoutParams(new AbsListView.LayoutParams(this.gBW, this.gBY));
        } else if (this.ajW.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.ajW.getLayoutParams();
            layoutParams4.width = this.gBW;
            layoutParams4.height = this.gBY;
            this.ajW.setLayoutParams(layoutParams4);
        } else {
            this.ajW.setLayoutParams(new AbsListView.LayoutParams(this.gBW, this.gBY));
        }
    }

    public void bUy() {
        this.gBW = l.getEquipmentWidth(this.eXu.getPageActivity());
        this.gBX = l.getEquipmentHeight(this.eXu.getPageActivity());
        this.gBY = (int) ((this.gBW / 16.0d) * 9.0d);
        this.gBZ = (int) ((this.gBW / 4.0d) * 3.0d);
        this.gCc = (int) ((this.gBX / 3.0d) - (this.gBZ / 2.0d));
        if (this.gBP != null) {
            boolean isPlaying = this.gBU == null ? false : this.gBU.isPlaying();
            vi(this.gBP.alW.brK().screen_direction);
            vh(this.gBP.alW.brK().screen_direction);
            bUz();
            if (isPlaying) {
                GJ(this.gCa);
            }
        }
    }

    public void bUz() {
        mv(true);
    }

    public void mv(boolean z) {
        if (z) {
            bUA();
        }
        if (this.gBU != null) {
            this.gBU.stopPlayback();
        }
        this.gBT.bUu();
        this.gBT.bUv();
    }

    private void bUA() {
        if (this.gBV != null) {
            this.gBV.setPlayer(null);
            this.gBV.stop();
            this.gBV = null;
        }
        if (this.gBU != null) {
            this.gBU.stopPlayback();
            this.gBU.dCb();
            if (this.gBU.getMediaProgressObserver() != null) {
                this.gBU.getMediaProgressObserver().setPlayer(null);
                this.gBU.getMediaProgressObserver().stop();
            }
            this.gBU = null;
        }
    }

    private void bUB() {
        if (this.gBP != null && this.gBP.alW != null && this.gBP.alW.brK() != null) {
            if (this.gBU != null && this.gBU.getParent() != null) {
                bUA();
            }
            this.gBV = new f();
            this.gBU = new TbCyberVideoView(this.eXu.getPageActivity());
            this.gBU.setOnPreparedListener(this.eDf);
            this.gBU.setOnErrorListener(this.eDg);
            this.gBU.setOnSurfaceDestroyedListener(this.fWA);
            this.gBU.setVolume(0.0f, 0.0f);
            this.gBU.setStageType(null);
            this.gBV.setPlayer(this.gBU);
            this.gBV.a(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.f.c
                public void bUC() {
                }
            });
            if (this.gBU.getParent() == null) {
                this.ajW.addView(this.gBU, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            vh(this.gBP.alW.brK().screen_direction);
        }
    }

    public void GJ(String str) {
        if (!StringUtils.isNull(str) && this.gBP != null && this.gBP.alW != null && this.gBP.alW.brK() != null) {
            if (!str.equals(this.gCa) || (this.gBU != null && !this.gBU.isPlaying())) {
                this.gCa = str;
                bUz();
            }
            if (this.gBU == null) {
                bUB();
            }
            if (this.gBU != null && !this.gBU.isPlaying()) {
                o oVar = new o();
                oVar.mLocate = "9";
                oVar.fPy = String.valueOf(this.gBP.alW.getFid());
                oVar.anD = this.gBP.alW.getTid();
                this.gBU.setVideoStatData(oVar);
                if (this.gBU != null) {
                    this.gBU.setVideoPath(this.gBP.alW.brK().hls_url);
                }
                if (this.gBU != null) {
                    this.gBU.start();
                }
                if (this.gBV != null) {
                    this.gBV.start();
                }
            }
        }
    }

    public View getView() {
        return this.ajW;
    }

    public void onDestroy() {
        bUA();
        if (this.gBT != null) {
            this.gBT.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.gBT != null) {
            this.gBT.bCP();
        }
        ao.setBackgroundColor(this.gBU, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bz bzVar) {
        String str;
        if (tbPageContext != null && bzVar != null && bzVar.brr() != null && bzVar.brK() != null) {
            if (this.gBP != null && this.gBP.alW != null && !this.gBM) {
                aq aqVar = new aq("c12645");
                if (this.gBP.gBg == 0) {
                    aqVar.an("obj_type", 1);
                } else if (this.gBP.gBg == 1) {
                    aqVar.an("obj_type", 2);
                }
                aqVar.dX("tid", this.gBP.alW.getTid());
                TiebaStatic.log(aqVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bzVar.brr().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.gBM) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bzVar.brK());
            alaLiveInfoCoreData.userName = bzVar.brK().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
