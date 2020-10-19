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
    private int aIV;
    private FrameLayout aih;
    private CyberPlayerManager.OnPreparedListener dZP;
    private CyberPlayerManager.OnErrorListener dZQ;
    private TbPageContext<?> etO;
    private boolean fTc;
    private c fTf;
    private final float fTi;
    private AlaSquareLiveVideoMask fTj;
    private TbCyberVideoView fTk;
    private f fTl;
    private int fTm;
    private int fTn;
    private int fTo;
    private int fTp;
    private String fTq;
    private a fTr;
    private int fTs;
    private TbCyberVideoView.a frv;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes4.dex */
    public interface a {
        void Q(bw bwVar);

        void R(bw bwVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.fTi = 0.0f;
        this.etO = null;
        this.fTq = "";
        this.fTc = false;
        this.frv = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                b.this.bJP();
            }
        };
        this.dZQ = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                b.this.lb(false);
                return true;
            }
        };
        this.dZP = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (b.this.fTk != null) {
                    b.this.fTk.setLooping(false);
                    b.this.fTk.setVolume(0.0f, 0.0f);
                    if (b.this.fTf != null && b.this.fTf.akp != null) {
                        if (b.this.fTc) {
                            if (b.this.fTr != null) {
                                b.this.fTr.R(b.this.fTf.akp);
                            }
                        } else {
                            aq aqVar = new aq("c12646");
                            if (b.this.fTf.fSw != 0) {
                                if (b.this.fTf.fSw == 1) {
                                    aqVar.aj("obj_type", 2);
                                }
                            } else {
                                aqVar.aj("obj_type", 1);
                            }
                            aqVar.dK("tid", b.this.fTf.akp.getTid());
                            TiebaStatic.log(aqVar);
                        }
                    }
                    if (b.this.fTk.getCyberPlayer() != null) {
                        b.this.bB(b.this.fTk.getCyberPlayer().getVideoHeight(), b.this.fTk.getCyberPlayer().getVideoWidth());
                    }
                    if (b.this.fTj != null) {
                        b.this.fTj.bJJ();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.fTf != null && b.this.fTf.akp != null) {
                    if (b.this.fTr != null) {
                        b.this.fTr.Q(b.this.fTf.akp);
                    }
                    b.this.a(b.this.etO, b.this.fTf.akp);
                }
            }
        };
        this.etO = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.fTc = z;
        this.fTj.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.etO != null) {
            this.aih = (FrameLayout) LayoutInflater.from(this.etO.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.fTm = l.getEquipmentWidth(this.etO.getPageActivity());
            this.fTn = l.getEquipmentHeight(this.etO.getPageActivity());
            this.fTo = (int) ((this.fTm / 16.0d) * 9.0d);
            this.fTp = (int) ((this.fTm / 4.0d) * 3.0d);
            this.fTs = (int) ((this.fTn / 3.0d) - (this.fTp / 2.0d));
            this.fTj = (AlaSquareLiveVideoMask) this.aih.findViewById(R.id.video_mask);
            this.aih.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.fTr = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.akp != null && cVar.akp.biB() != null) {
            if (this.fTf == null || (this.fTf.akp != null && !this.fTf.akp.getTid().equals(cVar.akp.getTid()))) {
                tr(cVar.akp.biB().screen_direction);
            }
            this.fTf = cVar;
            this.aIV = this.fTf.akp.biB().screen_direction;
            this.fTj.setData(this.fTf.akp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(int i, int i2) {
        int i3;
        int i4;
        if (this.aIV == 1 && this.fTk != null && this.fTk.getParent() != null) {
            float f = i / i2;
            float f2 = (this.fTm * i) / this.fTn;
            if (f2 < i2) {
                i3 = (int) (this.fTn / f);
                i4 = this.fTn;
            } else if (f2 > i2) {
                i3 = this.fTm;
                i4 = (int) (f * this.fTm);
            } else {
                i3 = this.fTm;
                i4 = this.fTn;
            }
            if (this.fTk.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fTk.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.fTk.setLayoutParams(layoutParams);
                return;
            }
            this.fTk.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void tq(int i) {
        if (this.fTk != null) {
            if (i == 1) {
                if (this.fTk.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fTk.getLayoutParams();
                    layoutParams.width = this.fTm;
                    layoutParams.height = this.fTn;
                    layoutParams.topMargin = -this.fTs;
                    this.fTk.setLayoutParams(layoutParams);
                    return;
                }
                this.fTk.setLayoutParams(new FrameLayout.LayoutParams(this.fTm, this.fTn));
            } else if (this.fTk.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fTk.getLayoutParams();
                layoutParams2.width = this.fTm;
                layoutParams2.height = this.fTo;
                this.fTk.setLayoutParams(layoutParams2);
            } else {
                this.fTk.setLayoutParams(new FrameLayout.LayoutParams(this.fTm, this.fTo));
            }
        }
    }

    private void tr(int i) {
        if (i == 1) {
            if (this.fTc) {
                if (this.aih.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aih.getLayoutParams();
                    layoutParams.width = this.fTm;
                    layoutParams.height = this.fTp;
                    this.aih.setLayoutParams(layoutParams);
                    return;
                }
                this.aih.setLayoutParams(new FrameLayout.LayoutParams(this.fTm, this.fTp));
                return;
            } else if (this.aih.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.aih.getLayoutParams();
                layoutParams2.width = this.fTm;
                layoutParams2.height = this.fTm;
                this.aih.setLayoutParams(layoutParams2);
                return;
            } else {
                this.aih.setLayoutParams(new AbsListView.LayoutParams(this.fTm, this.fTm));
                return;
            }
        }
        this.aIV = 2;
        if (this.fTc) {
            if (this.aih.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.aih.getLayoutParams();
                layoutParams3.width = this.fTm;
                layoutParams3.height = this.fTo;
                this.aih.setLayoutParams(layoutParams3);
                return;
            }
            this.aih.setLayoutParams(new AbsListView.LayoutParams(this.fTm, this.fTo));
        } else if (this.aih.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.aih.getLayoutParams();
            layoutParams4.width = this.fTm;
            layoutParams4.height = this.fTo;
            this.aih.setLayoutParams(layoutParams4);
        } else {
            this.aih.setLayoutParams(new AbsListView.LayoutParams(this.fTm, this.fTo));
        }
    }

    public void bJO() {
        this.fTm = l.getEquipmentWidth(this.etO.getPageActivity());
        this.fTn = l.getEquipmentHeight(this.etO.getPageActivity());
        this.fTo = (int) ((this.fTm / 16.0d) * 9.0d);
        this.fTp = (int) ((this.fTm / 4.0d) * 3.0d);
        this.fTs = (int) ((this.fTn / 3.0d) - (this.fTp / 2.0d));
        if (this.fTf != null) {
            boolean isPlaying = this.fTk == null ? false : this.fTk.isPlaying();
            tr(this.fTf.akp.biB().screen_direction);
            tq(this.fTf.akp.biB().screen_direction);
            bJP();
            if (isPlaying) {
                FK(this.fTq);
            }
        }
    }

    public void bJP() {
        lb(true);
    }

    public void lb(boolean z) {
        if (z) {
            bJQ();
        }
        if (this.fTk != null) {
            this.fTk.stopPlayback();
        }
        this.fTj.bJK();
        this.fTj.bJL();
    }

    private void bJQ() {
        if (this.fTl != null) {
            this.fTl.setPlayer(null);
            this.fTl.stop();
            this.fTl = null;
        }
        if (this.fTk != null) {
            this.fTk.stopPlayback();
            this.fTk.drJ();
            if (this.fTk.getMediaProgressObserver() != null) {
                this.fTk.getMediaProgressObserver().setPlayer(null);
                this.fTk.getMediaProgressObserver().stop();
            }
            this.fTk = null;
        }
    }

    private void bJR() {
        if (this.fTf != null && this.fTf.akp != null && this.fTf.akp.biB() != null) {
            if (this.fTk != null && this.fTk.getParent() != null) {
                bJQ();
            }
            this.fTl = new f();
            this.fTk = new TbCyberVideoView(this.etO.getPageActivity());
            this.fTk.setOnPreparedListener(this.dZP);
            this.fTk.setOnErrorListener(this.dZQ);
            this.fTk.setOnSurfaceDestroyedListener(this.frv);
            this.fTk.setVolume(0.0f, 0.0f);
            this.fTk.setStageType(null);
            this.fTl.setPlayer(this.fTk);
            this.fTl.a(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.f.c
                public void bJS() {
                }
            });
            if (this.fTk.getParent() == null) {
                this.aih.addView(this.fTk, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            tq(this.fTf.akp.biB().screen_direction);
        }
    }

    public void FK(String str) {
        if (!StringUtils.isNull(str) && this.fTf != null && this.fTf.akp != null && this.fTf.akp.biB() != null) {
            if (!str.equals(this.fTq) || (this.fTk != null && !this.fTk.isPlaying())) {
                this.fTq = str;
                bJP();
            }
            if (this.fTk == null) {
                bJR();
            }
            if (this.fTk != null && !this.fTk.isPlaying()) {
                o oVar = new o();
                oVar.mLocate = "9";
                oVar.fkA = String.valueOf(this.fTf.akp.getFid());
                oVar.alS = this.fTf.akp.getTid();
                this.fTk.setVideoStatData(oVar);
                if (this.fTk != null) {
                    this.fTk.setVideoPath(this.fTf.akp.biB().hls_url);
                }
                if (this.fTk != null) {
                    this.fTk.start();
                }
                if (this.fTl != null) {
                    this.fTl.start();
                }
            }
        }
    }

    public View getView() {
        return this.aih;
    }

    public void onDestroy() {
        bJQ();
        if (this.fTj != null) {
            this.fTj.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.fTj != null) {
            this.fTj.btm();
        }
        ap.setBackgroundColor(this.fTk, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bw bwVar) {
        String str;
        if (tbPageContext != null && bwVar != null && bwVar.bih() != null && bwVar.biB() != null) {
            if (this.fTf != null && this.fTf.akp != null && !this.fTc) {
                aq aqVar = new aq("c12645");
                if (this.fTf.fSw == 0) {
                    aqVar.aj("obj_type", 1);
                } else if (this.fTf.fSw == 1) {
                    aqVar.aj("obj_type", 2);
                }
                aqVar.dK("tid", this.fTf.akp.getTid());
                TiebaStatic.log(aqVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.bih().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.fTc) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.biB());
            alaLiveInfoCoreData.userName = bwVar.biB().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
