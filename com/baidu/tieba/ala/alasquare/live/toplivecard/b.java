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
/* loaded from: classes2.dex */
public class b {
    private int WM;
    private TbPageContext<?> cRe;
    private FrameLayout coW;
    private g.b dIa;
    private QuickVideoView.b dIe;
    private g.f dQX;
    private boolean egK;
    private c egN;
    private final float egQ;
    private AlaSquareLiveVideoMask egR;
    private QuickVideoView egS;
    private j egT;
    private n egU;
    private int egV;
    private int egW;
    private int egX;
    private int egY;
    private String egZ;
    private a eha;
    private int ehb;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes2.dex */
    public interface a {
        void O(bj bjVar);

        void P(bj bjVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.egQ = 0.0f;
        this.cRe = null;
        this.egZ = "";
        this.egK = false;
        this.dIe = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                b.this.aZW();
            }
        };
        this.dIa = new g.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                b.this.hL(false);
                return true;
            }
        };
        this.dQX = new g.f() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(false);
                    gVar.setVolume(0.0f, 0.0f);
                    if (b.this.egN != null && b.this.egN.Np != null) {
                        if (b.this.egK) {
                            if (b.this.eha != null) {
                                b.this.eha.P(b.this.egN.Np);
                            }
                        } else {
                            an anVar = new an("c12646");
                            if (b.this.egN.ege != 0) {
                                if (b.this.egN.ege == 1) {
                                    anVar.Z("obj_type", 2);
                                }
                            } else {
                                anVar.Z("obj_type", 1);
                            }
                            anVar.cp("tid", b.this.egN.Np.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                    b.this.bd(gVar.getVideoHeight(), gVar.getVideoWidth());
                    b.this.egR.aZQ();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.egN != null && b.this.egN.Np != null) {
                    if (b.this.eha != null) {
                        b.this.eha.O(b.this.egN.Np);
                    }
                    b.this.a(b.this.cRe, b.this.egN.Np);
                }
            }
        };
        this.cRe = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.egK = z;
        this.egR.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.cRe != null) {
            this.coW = (FrameLayout) LayoutInflater.from(this.cRe.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.egV = l.getEquipmentWidth(this.cRe.getPageActivity());
            this.egW = l.getEquipmentHeight(this.cRe.getPageActivity());
            this.egX = (int) ((this.egV / 16.0d) * 9.0d);
            this.egY = (int) ((this.egV / 4.0d) * 3.0d);
            this.ehb = (int) ((this.egW / 3.0d) - (this.egY / 2.0d));
            this.egR = (AlaSquareLiveVideoMask) this.coW.findViewById(R.id.video_mask);
            this.coW.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.eha = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.Np != null && cVar.Np.aAq() != null) {
            if (this.egN == null || (this.egN.Np != null && !this.egN.Np.getTid().equals(cVar.Np.getTid()))) {
                om(cVar.Np.aAq().screen_direction);
            }
            this.egN = cVar;
            this.WM = this.egN.Np.aAq().screen_direction;
            this.egR.setData(this.egN.Np);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(int i, int i2) {
        int i3;
        int i4;
        if (this.WM == 1 && this.egS != null && this.egS.getParent() != null) {
            float f = i / i2;
            float f2 = (this.egV * i) / this.egW;
            if (f2 < i2) {
                i3 = (int) (this.egW / f);
                i4 = this.egW;
            } else if (f2 > i2) {
                i3 = this.egV;
                i4 = (int) (f * this.egV);
            } else {
                i3 = this.egV;
                i4 = this.egW;
            }
            if (this.egS.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.egS.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.egS.setLayoutParams(layoutParams);
                return;
            }
            this.egS.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void ol(int i) {
        if (this.egS != null) {
            if (i == 1) {
                if (this.egS.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.egS.getLayoutParams();
                    layoutParams.width = this.egV;
                    layoutParams.height = this.egW;
                    layoutParams.topMargin = -this.ehb;
                    this.egS.setLayoutParams(layoutParams);
                    return;
                }
                this.egS.setLayoutParams(new FrameLayout.LayoutParams(this.egV, this.egW));
            } else if (this.egS.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.egS.getLayoutParams();
                layoutParams2.width = this.egV;
                layoutParams2.height = this.egX;
                this.egS.setLayoutParams(layoutParams2);
            } else {
                this.egS.setLayoutParams(new FrameLayout.LayoutParams(this.egV, this.egX));
            }
        }
    }

    private void om(int i) {
        if (i == 1) {
            if (this.egK) {
                if (this.coW.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.coW.getLayoutParams();
                    layoutParams.width = this.egV;
                    layoutParams.height = this.egY;
                    this.coW.setLayoutParams(layoutParams);
                    return;
                }
                this.coW.setLayoutParams(new FrameLayout.LayoutParams(this.egV, this.egY));
                return;
            } else if (this.coW.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.coW.getLayoutParams();
                layoutParams2.width = this.egV;
                layoutParams2.height = this.egV;
                this.coW.setLayoutParams(layoutParams2);
                return;
            } else {
                this.coW.setLayoutParams(new AbsListView.LayoutParams(this.egV, this.egV));
                return;
            }
        }
        this.WM = 2;
        if (this.egK) {
            if (this.coW.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.coW.getLayoutParams();
                layoutParams3.width = this.egV;
                layoutParams3.height = this.egX;
                this.coW.setLayoutParams(layoutParams3);
                return;
            }
            this.coW.setLayoutParams(new AbsListView.LayoutParams(this.egV, this.egX));
        } else if (this.coW.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.coW.getLayoutParams();
            layoutParams4.width = this.egV;
            layoutParams4.height = this.egX;
            this.coW.setLayoutParams(layoutParams4);
        } else {
            this.coW.setLayoutParams(new AbsListView.LayoutParams(this.egV, this.egX));
        }
    }

    public void aZV() {
        this.egV = l.getEquipmentWidth(this.cRe.getPageActivity());
        this.egW = l.getEquipmentHeight(this.cRe.getPageActivity());
        this.egX = (int) ((this.egV / 16.0d) * 9.0d);
        this.egY = (int) ((this.egV / 4.0d) * 3.0d);
        this.ehb = (int) ((this.egW / 3.0d) - (this.egY / 2.0d));
        if (this.egN != null) {
            boolean isPlaying = this.egS == null ? false : this.egS.isPlaying();
            om(this.egN.Np.aAq().screen_direction);
            ol(this.egN.Np.aAq().screen_direction);
            aZW();
            if (isPlaying) {
                startPlay(this.egZ);
            }
        }
    }

    public void aZW() {
        hL(true);
    }

    public void hL(boolean z) {
        if (z) {
            aZX();
        }
        if (this.egS != null) {
            this.egS.stopPlayback();
        }
        this.egR.aZR();
        this.egR.aZS();
    }

    private void aZX() {
        if (this.egU != null) {
            if (this.egU.cxh() != null) {
                this.egU.cxh().setPlayer(null);
                this.egU.cxh().stop();
            }
            this.egU = null;
        }
        if (this.egT != null) {
            this.egT.setPlayer(null);
            this.egT.stop();
            this.egT = null;
        }
        if (this.egS != null) {
            this.egS.stopPlayback();
            this.egS.setOnPreparedListener(null);
            this.egS.setOnErrorListener(null);
            this.egS.setOnSurfaceDestroyedListener(null);
            this.egS.setBusiness(null);
            if (this.egS.getParent() != null) {
                ((ViewGroup) this.egS.getParent()).removeView(this.egS);
            }
            this.egS = null;
        }
    }

    private void aZY() {
        if (this.egN != null && this.egN.Np != null && this.egN.Np.aAq() != null) {
            if (this.egS != null && this.egS.getParent() != null) {
                aZX();
            }
            this.egU = new n(this.cRe.getPageActivity());
            this.egT = new j();
            this.egS = new QuickVideoView(this.cRe.getPageActivity());
            this.egS.setOnPreparedListener(this.dQX);
            this.egS.setOnErrorListener(this.dIa);
            this.egS.setOnSurfaceDestroyedListener(this.dIe);
            this.egS.setBusiness(this.egU);
            this.egS.setVolume(0.0f, 0.0f);
            this.egT.setPlayer(this.egS);
            this.egT.a(new j.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.j.c
                public void aZZ() {
                }
            });
            if (this.egS.getParent() == null) {
                this.coW.addView(this.egS, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            ol(this.egN.Np.aAq().screen_direction);
        }
    }

    public void startPlay(String str) {
        if (!StringUtils.isNull(str) && this.egN != null && this.egN.Np != null && this.egN.Np.aAq() != null) {
            if (!str.equals(this.egZ) || (this.egS != null && !this.egS.isPlaying())) {
                this.egZ = str;
                aZW();
            }
            if (this.egS == null) {
                aZY();
            }
            if (this.egS != null && !this.egS.isPlaying()) {
                if (this.egU != null) {
                    y yVar = new y();
                    yVar.mLocate = "9";
                    yVar.fKa = String.valueOf(this.egN.Np.getFid());
                    yVar.OG = this.egN.Np.getTid();
                    this.egU.setVideoStatsData(yVar);
                    if (this.egU.cxB() != null) {
                        this.egU.cxB().b(this.egN.Np.aAq());
                    }
                }
                if (this.egS != null) {
                    this.egS.setVideoPath(this.egN.Np.aAq().hls_url);
                }
                if (this.egS != null) {
                    this.egS.start();
                }
                if (this.egT != null) {
                    this.egT.start();
                }
            }
        }
    }

    public View getView() {
        return this.coW;
    }

    public void onDestroy() {
        aZX();
        if (this.egR != null) {
            this.egR.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.egR != null) {
            this.egR.aKd();
        }
        am.setBackgroundColor(this.egS, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar) {
        String str;
        if (tbPageContext != null && bjVar != null && bjVar.azX() != null && bjVar.aAq() != null) {
            if (this.egN != null && this.egN.Np != null && !this.egK) {
                an anVar = new an("c12645");
                if (this.egN.ege == 0) {
                    anVar.Z("obj_type", 1);
                } else if (this.egN.ege == 1) {
                    anVar.Z("obj_type", 2);
                }
                anVar.cp("tid", this.egN.Np.getTid());
                TiebaStatic.log(anVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.azX().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.egK) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aAq());
            alaLiveInfoCoreData.userName = bjVar.aAq().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
