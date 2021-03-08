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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.b.c;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.o;
/* loaded from: classes9.dex */
public class b {
    private int aLB;
    private FrameLayout akl;
    private CyberPlayerManager.OnPreparedListener eCb;
    private CyberPlayerManager.OnErrorListener eCc;
    private TbPageContext<?> eWx;
    private TbCyberVideoView.a fVI;
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

    /* loaded from: classes9.dex */
    public interface a {
        void U(cb cbVar);

        void V(cb cbVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.gBS = 0.0f;
        this.eWx = null;
        this.gCa = "";
        this.gBM = false;
        this.fVI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                b.this.bRy();
            }
        };
        this.eCc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                b.this.mv(false);
                return true;
            }
        };
        this.eCb = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (b.this.gBU != null) {
                    b.this.gBU.setLooping(false);
                    b.this.gBU.setVolume(0.0f, 0.0f);
                    if (b.this.gBP != null && b.this.gBP.amn != null) {
                        if (b.this.gBM) {
                            if (b.this.gCb != null) {
                                b.this.gCb.V(b.this.gBP.amn);
                            }
                        } else {
                            ar arVar = new ar("c12646");
                            if (b.this.gBP.gBg != 0) {
                                if (b.this.gBP.gBg == 1) {
                                    arVar.aq("obj_type", 2);
                                }
                            } else {
                                arVar.aq("obj_type", 1);
                            }
                            arVar.dR("tid", b.this.gBP.amn.getTid());
                            TiebaStatic.log(arVar);
                        }
                    }
                    if (b.this.gBU.getCyberPlayer() != null) {
                        b.this.bB(b.this.gBU.getCyberPlayer().getVideoHeight(), b.this.gBU.getCyberPlayer().getVideoWidth());
                    }
                    if (b.this.gBT != null) {
                        b.this.gBT.bRs();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gBP != null && b.this.gBP.amn != null) {
                    if (b.this.gCb != null) {
                        b.this.gCb.U(b.this.gBP.amn);
                    }
                    b.this.a(b.this.eWx, b.this.gBP.amn);
                }
            }
        };
        this.eWx = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.gBM = z;
        this.gBT.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.eWx != null) {
            this.akl = (FrameLayout) LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.gBW = l.getEquipmentWidth(this.eWx.getPageActivity());
            this.gBX = l.getEquipmentHeight(this.eWx.getPageActivity());
            this.gBY = (int) ((this.gBW / 16.0d) * 9.0d);
            this.gBZ = (int) ((this.gBW / 4.0d) * 3.0d);
            this.gCc = (int) ((this.gBX / 3.0d) - (this.gBZ / 2.0d));
            this.gBT = (AlaSquareLiveVideoMask) this.akl.findViewById(R.id.video_mask);
            this.akl.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.gCb = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.amn != null && cVar.amn.bol() != null) {
            if (this.gBP == null || (this.gBP.amn != null && !this.gBP.amn.getTid().equals(cVar.amn.getTid()))) {
                tK(cVar.amn.bol().screen_direction);
            }
            this.gBP = cVar;
            this.aLB = this.gBP.amn.bol().screen_direction;
            this.gBT.setData(this.gBP.amn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(int i, int i2) {
        int i3;
        int i4;
        if (this.aLB == 1 && this.gBU != null && this.gBU.getParent() != null) {
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

    private void tJ(int i) {
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

    private void tK(int i) {
        if (i == 1) {
            if (this.gBM) {
                if (this.akl.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.akl.getLayoutParams();
                    layoutParams.width = this.gBW;
                    layoutParams.height = this.gBZ;
                    this.akl.setLayoutParams(layoutParams);
                    return;
                }
                this.akl.setLayoutParams(new FrameLayout.LayoutParams(this.gBW, this.gBZ));
                return;
            } else if (this.akl.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.akl.getLayoutParams();
                layoutParams2.width = this.gBW;
                layoutParams2.height = this.gBW;
                this.akl.setLayoutParams(layoutParams2);
                return;
            } else {
                this.akl.setLayoutParams(new AbsListView.LayoutParams(this.gBW, this.gBW));
                return;
            }
        }
        this.aLB = 2;
        if (this.gBM) {
            if (this.akl.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.akl.getLayoutParams();
                layoutParams3.width = this.gBW;
                layoutParams3.height = this.gBY;
                this.akl.setLayoutParams(layoutParams3);
                return;
            }
            this.akl.setLayoutParams(new AbsListView.LayoutParams(this.gBW, this.gBY));
        } else if (this.akl.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.akl.getLayoutParams();
            layoutParams4.width = this.gBW;
            layoutParams4.height = this.gBY;
            this.akl.setLayoutParams(layoutParams4);
        } else {
            this.akl.setLayoutParams(new AbsListView.LayoutParams(this.gBW, this.gBY));
        }
    }

    public void bRx() {
        this.gBW = l.getEquipmentWidth(this.eWx.getPageActivity());
        this.gBX = l.getEquipmentHeight(this.eWx.getPageActivity());
        this.gBY = (int) ((this.gBW / 16.0d) * 9.0d);
        this.gBZ = (int) ((this.gBW / 4.0d) * 3.0d);
        this.gCc = (int) ((this.gBX / 3.0d) - (this.gBZ / 2.0d));
        if (this.gBP != null) {
            boolean isPlaying = this.gBU == null ? false : this.gBU.isPlaying();
            tK(this.gBP.amn.bol().screen_direction);
            tJ(this.gBP.amn.bol().screen_direction);
            bRy();
            if (isPlaying) {
                Gg(this.gCa);
            }
        }
    }

    public void bRy() {
        mv(true);
    }

    public void mv(boolean z) {
        if (z) {
            bRz();
        }
        if (this.gBU != null) {
            this.gBU.stopPlayback();
        }
        this.gBT.bRt();
        this.gBT.bRu();
    }

    private void bRz() {
        if (this.gBV != null) {
            this.gBV.setPlayer(null);
            this.gBV.stop();
            this.gBV = null;
        }
        if (this.gBU != null) {
            this.gBU.stopPlayback();
            this.gBU.dAG();
            if (this.gBU.getMediaProgressObserver() != null) {
                this.gBU.getMediaProgressObserver().setPlayer(null);
                this.gBU.getMediaProgressObserver().stop();
            }
            this.gBU = null;
        }
    }

    private void bRA() {
        if (this.gBP != null && this.gBP.amn != null && this.gBP.amn.bol() != null) {
            if (this.gBU != null && this.gBU.getParent() != null) {
                bRz();
            }
            this.gBV = new f();
            this.gBU = new TbCyberVideoView(this.eWx.getPageActivity());
            this.gBU.setOnPreparedListener(this.eCb);
            this.gBU.setOnErrorListener(this.eCc);
            this.gBU.setOnSurfaceDestroyedListener(this.fVI);
            this.gBU.setVolume(0.0f, 0.0f);
            this.gBU.setStageType(null);
            this.gBV.setPlayer(this.gBU);
            this.gBV.a(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.f.c
                public void bRB() {
                }
            });
            if (this.gBU.getParent() == null) {
                this.akl.addView(this.gBU, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            tJ(this.gBP.amn.bol().screen_direction);
        }
    }

    public void Gg(String str) {
        if (!StringUtils.isNull(str) && this.gBP != null && this.gBP.amn != null && this.gBP.amn.bol() != null) {
            if (!str.equals(this.gCa) || (this.gBU != null && !this.gBU.isPlaying())) {
                this.gCa = str;
                bRy();
            }
            if (this.gBU == null) {
                bRA();
            }
            if (this.gBU != null && !this.gBU.isPlaying()) {
                o oVar = new o();
                oVar.mLocate = "9";
                oVar.fOD = String.valueOf(this.gBP.amn.getFid());
                oVar.anU = this.gBP.amn.getTid();
                this.gBU.setVideoStatData(oVar);
                if (this.gBU != null) {
                    this.gBU.setVideoPath(this.gBP.amn.bol().hls_url);
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
        return this.akl;
    }

    public void onDestroy() {
        bRz();
        if (this.gBT != null) {
            this.gBT.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.gBT != null) {
            this.gBT.bzq();
        }
        ap.setBackgroundColor(this.gBU, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, cb cbVar) {
        String str;
        if (tbPageContext != null && cbVar != null && cbVar.bnS() != null && cbVar.bol() != null) {
            if (this.gBP != null && this.gBP.amn != null && !this.gBM) {
                ar arVar = new ar("c12645");
                if (this.gBP.gBg == 0) {
                    arVar.aq("obj_type", 1);
                } else if (this.gBP.gBg == 1) {
                    arVar.aq("obj_type", 2);
                }
                arVar.dR("tid", this.gBP.amn.getTid());
                TiebaStatic.log(arVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = cbVar.bnS().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.gBM) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(cbVar.bol());
            alaLiveInfoCoreData.userName = cbVar.bol().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
