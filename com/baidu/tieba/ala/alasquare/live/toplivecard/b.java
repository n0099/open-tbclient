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
import com.baidu.searchbox.ugc.model.PublishType;
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
    private int Wt;
    private TbPageContext<?> cQU;
    private FrameLayout coJ;
    private g.b dHR;
    private QuickVideoView.b dHV;
    private g.f dQO;
    private boolean egA;
    private c egD;
    private final float egG;
    private AlaSquareLiveVideoMask egH;
    private QuickVideoView egI;
    private j egJ;
    private n egK;
    private int egL;
    private int egM;
    private int egN;
    private int egO;
    private String egP;
    private a egQ;
    private int egR;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes2.dex */
    public interface a {
        void N(bj bjVar);

        void O(bj bjVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.egG = 0.0f;
        this.cQU = null;
        this.egP = "";
        this.egA = false;
        this.dHV = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                b.this.aZB();
            }
        };
        this.dHR = new g.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                b.this.hG(false);
                return true;
            }
        };
        this.dQO = new g.f() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(false);
                    gVar.setVolume(0.0f, 0.0f);
                    if (b.this.egD != null && b.this.egD.Nl != null) {
                        if (b.this.egA) {
                            if (b.this.egQ != null) {
                                b.this.egQ.O(b.this.egD.Nl);
                            }
                        } else {
                            an anVar = new an("c12646");
                            if (b.this.egD.efU != 0) {
                                if (b.this.egD.efU == 1) {
                                    anVar.Z("obj_type", 2);
                                }
                            } else {
                                anVar.Z("obj_type", 1);
                            }
                            anVar.cp("tid", b.this.egD.Nl.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                    b.this.aZ(gVar.getVideoHeight(), gVar.getVideoWidth());
                    b.this.egH.aZv();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.egD != null && b.this.egD.Nl != null) {
                    if (b.this.egQ != null) {
                        b.this.egQ.N(b.this.egD.Nl);
                    }
                    b.this.a(b.this.cQU, b.this.egD.Nl);
                }
            }
        };
        this.cQU = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.egA = z;
        this.egH.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.cQU != null) {
            this.coJ = (FrameLayout) LayoutInflater.from(this.cQU.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.egL = l.getEquipmentWidth(this.cQU.getPageActivity());
            this.egM = l.getEquipmentHeight(this.cQU.getPageActivity());
            this.egN = (int) ((this.egL / 16.0d) * 9.0d);
            this.egO = (int) ((this.egL / 4.0d) * 3.0d);
            this.egR = (int) ((this.egM / 3.0d) - (this.egO / 2.0d));
            this.egH = (AlaSquareLiveVideoMask) this.coJ.findViewById(R.id.video_mask);
            this.coJ.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.egQ = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.Nl != null && cVar.Nl.azX() != null) {
            if (this.egD == null || (this.egD.Nl != null && !this.egD.Nl.getTid().equals(cVar.Nl.getTid()))) {
                om(cVar.Nl.azX().screen_direction);
            }
            this.egD = cVar;
            this.Wt = this.egD.Nl.azX().screen_direction;
            this.egH.setData(this.egD.Nl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(int i, int i2) {
        int i3;
        int i4;
        if (this.Wt == 1 && this.egI != null && this.egI.getParent() != null) {
            float f = i / i2;
            float f2 = (this.egL * i) / this.egM;
            if (f2 < i2) {
                i3 = (int) (this.egM / f);
                i4 = this.egM;
            } else if (f2 > i2) {
                i3 = this.egL;
                i4 = (int) (f * this.egL);
            } else {
                i3 = this.egL;
                i4 = this.egM;
            }
            if (this.egI.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.egI.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.egI.setLayoutParams(layoutParams);
                return;
            }
            this.egI.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void ol(int i) {
        if (this.egI != null) {
            if (i == 1) {
                if (this.egI.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.egI.getLayoutParams();
                    layoutParams.width = this.egL;
                    layoutParams.height = this.egM;
                    layoutParams.topMargin = -this.egR;
                    this.egI.setLayoutParams(layoutParams);
                    return;
                }
                this.egI.setLayoutParams(new FrameLayout.LayoutParams(this.egL, this.egM));
            } else if (this.egI.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.egI.getLayoutParams();
                layoutParams2.width = this.egL;
                layoutParams2.height = this.egN;
                this.egI.setLayoutParams(layoutParams2);
            } else {
                this.egI.setLayoutParams(new FrameLayout.LayoutParams(this.egL, this.egN));
            }
        }
    }

    private void om(int i) {
        if (i == 1) {
            if (this.egA) {
                if (this.coJ.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.coJ.getLayoutParams();
                    layoutParams.width = this.egL;
                    layoutParams.height = this.egO;
                    this.coJ.setLayoutParams(layoutParams);
                    return;
                }
                this.coJ.setLayoutParams(new FrameLayout.LayoutParams(this.egL, this.egO));
                return;
            } else if (this.coJ.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.coJ.getLayoutParams();
                layoutParams2.width = this.egL;
                layoutParams2.height = this.egL;
                this.coJ.setLayoutParams(layoutParams2);
                return;
            } else {
                this.coJ.setLayoutParams(new AbsListView.LayoutParams(this.egL, this.egL));
                return;
            }
        }
        this.Wt = 2;
        if (this.egA) {
            if (this.coJ.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.coJ.getLayoutParams();
                layoutParams3.width = this.egL;
                layoutParams3.height = this.egN;
                this.coJ.setLayoutParams(layoutParams3);
                return;
            }
            this.coJ.setLayoutParams(new AbsListView.LayoutParams(this.egL, this.egN));
        } else if (this.coJ.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.coJ.getLayoutParams();
            layoutParams4.width = this.egL;
            layoutParams4.height = this.egN;
            this.coJ.setLayoutParams(layoutParams4);
        } else {
            this.coJ.setLayoutParams(new AbsListView.LayoutParams(this.egL, this.egN));
        }
    }

    public void aZA() {
        this.egL = l.getEquipmentWidth(this.cQU.getPageActivity());
        this.egM = l.getEquipmentHeight(this.cQU.getPageActivity());
        this.egN = (int) ((this.egL / 16.0d) * 9.0d);
        this.egO = (int) ((this.egL / 4.0d) * 3.0d);
        this.egR = (int) ((this.egM / 3.0d) - (this.egO / 2.0d));
        if (this.egD != null) {
            boolean isPlaying = this.egI == null ? false : this.egI.isPlaying();
            om(this.egD.Nl.azX().screen_direction);
            ol(this.egD.Nl.azX().screen_direction);
            aZB();
            if (isPlaying) {
                startPlay(this.egP);
            }
        }
    }

    public void aZB() {
        hG(true);
    }

    public void hG(boolean z) {
        if (z) {
            aZC();
        }
        if (this.egI != null) {
            this.egI.stopPlayback();
        }
        this.egH.aZw();
        this.egH.aZx();
    }

    private void aZC() {
        if (this.egK != null) {
            if (this.egK.cwa() != null) {
                this.egK.cwa().setPlayer(null);
                this.egK.cwa().stop();
            }
            this.egK = null;
        }
        if (this.egJ != null) {
            this.egJ.setPlayer(null);
            this.egJ.stop();
            this.egJ = null;
        }
        if (this.egI != null) {
            this.egI.stopPlayback();
            this.egI.setOnPreparedListener(null);
            this.egI.setOnErrorListener(null);
            this.egI.setOnSurfaceDestroyedListener(null);
            this.egI.setBusiness(null);
            if (this.egI.getParent() != null) {
                ((ViewGroup) this.egI.getParent()).removeView(this.egI);
            }
            this.egI = null;
        }
    }

    private void aZD() {
        if (this.egD != null && this.egD.Nl != null && this.egD.Nl.azX() != null) {
            if (this.egI != null && this.egI.getParent() != null) {
                aZC();
            }
            this.egK = new n(this.cQU.getPageActivity());
            this.egJ = new j();
            this.egI = new QuickVideoView(this.cQU.getPageActivity());
            this.egI.setOnPreparedListener(this.dQO);
            this.egI.setOnErrorListener(this.dHR);
            this.egI.setOnSurfaceDestroyedListener(this.dHV);
            this.egI.setBusiness(this.egK);
            this.egI.setVolume(0.0f, 0.0f);
            this.egJ.setPlayer(this.egI);
            this.egJ.a(new j.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.j.c
                public void aZE() {
                }
            });
            if (this.egI.getParent() == null) {
                this.coJ.addView(this.egI, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            ol(this.egD.Nl.azX().screen_direction);
        }
    }

    public void startPlay(String str) {
        if (!StringUtils.isNull(str) && this.egD != null && this.egD.Nl != null && this.egD.Nl.azX() != null) {
            if (!str.equals(this.egP) || (this.egI != null && !this.egI.isPlaying())) {
                this.egP = str;
                aZB();
            }
            if (this.egI == null) {
                aZD();
            }
            if (this.egI != null && !this.egI.isPlaying()) {
                if (this.egK != null) {
                    y yVar = new y();
                    yVar.mLocate = PublishType.TYPE_VIDEO_SHARE;
                    yVar.fGQ = String.valueOf(this.egD.Nl.getFid());
                    yVar.OC = this.egD.Nl.getTid();
                    this.egK.setVideoStatsData(yVar);
                    if (this.egK.cwu() != null) {
                        this.egK.cwu().b(this.egD.Nl.azX());
                    }
                }
                if (this.egI != null) {
                    this.egI.setVideoPath(this.egD.Nl.azX().hls_url);
                }
                if (this.egI != null) {
                    this.egI.start();
                }
                if (this.egJ != null) {
                    this.egJ.start();
                }
            }
        }
    }

    public View getView() {
        return this.coJ;
    }

    public void onDestroy() {
        aZC();
        if (this.egH != null) {
            this.egH.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.egH != null) {
            this.egH.aJJ();
        }
        am.setBackgroundColor(this.egI, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bj bjVar) {
        String str;
        if (tbPageContext != null && bjVar != null && bjVar.azE() != null && bjVar.azX() != null) {
            if (this.egD != null && this.egD.Nl != null && !this.egA) {
                an anVar = new an("c12645");
                if (this.egD.efU == 0) {
                    anVar.Z("obj_type", 1);
                } else if (this.egD.efU == 1) {
                    anVar.Z("obj_type", 2);
                }
                anVar.cp("tid", this.egD.Nl.getTid());
                TiebaStatic.log(anVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.azE().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.egA) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.azX());
            alaLiveInfoCoreData.userName = bjVar.azX().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
