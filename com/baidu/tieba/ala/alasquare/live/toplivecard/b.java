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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.b.c;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.j;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
/* loaded from: classes3.dex */
public class b {
    private FrameLayout agu;
    private int ayg;
    private TbPageContext<?> dPv;
    private g.b eLe;
    private QuickVideoView.b eLi;
    private g.f eUJ;
    private boolean fmZ;
    private c fnc;
    private final float fnf;
    private AlaSquareLiveVideoMask fng;
    private QuickVideoView fnh;
    private j fni;
    private n fnj;
    private int fnk;
    private int fnl;
    private int fnm;
    private int fnn;
    private String fno;
    private a fnp;
    private int fnq;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes3.dex */
    public interface a {
        void S(bu buVar);

        void T(bu buVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.fnf = 0.0f;
        this.dPv = null;
        this.fno = "";
        this.fmZ = false;
        this.eLi = new QuickVideoView.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                b.this.btD();
            }
        };
        this.eLe = new g.b() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                b.this.jx(false);
                return true;
            }
        };
        this.eUJ = new g.f() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(false);
                    gVar.setVolume(0.0f, 0.0f);
                    if (b.this.fnc != null && b.this.fnc.aiq != null) {
                        if (b.this.fmZ) {
                            if (b.this.fnp != null) {
                                b.this.fnp.T(b.this.fnc.aiq);
                            }
                        } else {
                            ao aoVar = new ao("c12646");
                            if (b.this.fnc.fmt != 0) {
                                if (b.this.fnc.fmt == 1) {
                                    aoVar.ag("obj_type", 2);
                                }
                            } else {
                                aoVar.ag("obj_type", 1);
                            }
                            aoVar.dk("tid", b.this.fnc.aiq.getTid());
                            TiebaStatic.log(aoVar);
                        }
                    }
                    b.this.bq(gVar.getVideoHeight(), gVar.getVideoWidth());
                    b.this.fng.btx();
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.fnc != null && b.this.fnc.aiq != null) {
                    if (b.this.fnp != null) {
                        b.this.fnp.S(b.this.fnc.aiq);
                    }
                    b.this.a(b.this.dPv, b.this.fnc.aiq);
                }
            }
        };
        this.dPv = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.fmZ = z;
        this.fng.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.dPv != null) {
            this.agu = (FrameLayout) LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.fnk = l.getEquipmentWidth(this.dPv.getPageActivity());
            this.fnl = l.getEquipmentHeight(this.dPv.getPageActivity());
            this.fnm = (int) ((this.fnk / 16.0d) * 9.0d);
            this.fnn = (int) ((this.fnk / 4.0d) * 3.0d);
            this.fnq = (int) ((this.fnl / 3.0d) - (this.fnn / 2.0d));
            this.fng = (AlaSquareLiveVideoMask) this.agu.findViewById(R.id.video_mask);
            this.agu.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.fnp = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.aiq != null && cVar.aiq.aSJ() != null) {
            if (this.fnc == null || (this.fnc.aiq != null && !this.fnc.aiq.getTid().equals(cVar.aiq.getTid()))) {
                qa(cVar.aiq.aSJ().screen_direction);
            }
            this.fnc = cVar;
            this.ayg = this.fnc.aiq.aSJ().screen_direction;
            this.fng.setData(this.fnc.aiq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(int i, int i2) {
        int i3;
        int i4;
        if (this.ayg == 1 && this.fnh != null && this.fnh.getParent() != null) {
            float f = i / i2;
            float f2 = (this.fnk * i) / this.fnl;
            if (f2 < i2) {
                i3 = (int) (this.fnl / f);
                i4 = this.fnl;
            } else if (f2 > i2) {
                i3 = this.fnk;
                i4 = (int) (f * this.fnk);
            } else {
                i3 = this.fnk;
                i4 = this.fnl;
            }
            if (this.fnh.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fnh.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.fnh.setLayoutParams(layoutParams);
                return;
            }
            this.fnh.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void pZ(int i) {
        if (this.fnh != null) {
            if (i == 1) {
                if (this.fnh.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fnh.getLayoutParams();
                    layoutParams.width = this.fnk;
                    layoutParams.height = this.fnl;
                    layoutParams.topMargin = -this.fnq;
                    this.fnh.setLayoutParams(layoutParams);
                    return;
                }
                this.fnh.setLayoutParams(new FrameLayout.LayoutParams(this.fnk, this.fnl));
            } else if (this.fnh.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fnh.getLayoutParams();
                layoutParams2.width = this.fnk;
                layoutParams2.height = this.fnm;
                this.fnh.setLayoutParams(layoutParams2);
            } else {
                this.fnh.setLayoutParams(new FrameLayout.LayoutParams(this.fnk, this.fnm));
            }
        }
    }

    private void qa(int i) {
        if (i == 1) {
            if (this.fmZ) {
                if (this.agu.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.agu.getLayoutParams();
                    layoutParams.width = this.fnk;
                    layoutParams.height = this.fnn;
                    this.agu.setLayoutParams(layoutParams);
                    return;
                }
                this.agu.setLayoutParams(new FrameLayout.LayoutParams(this.fnk, this.fnn));
                return;
            } else if (this.agu.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.agu.getLayoutParams();
                layoutParams2.width = this.fnk;
                layoutParams2.height = this.fnk;
                this.agu.setLayoutParams(layoutParams2);
                return;
            } else {
                this.agu.setLayoutParams(new AbsListView.LayoutParams(this.fnk, this.fnk));
                return;
            }
        }
        this.ayg = 2;
        if (this.fmZ) {
            if (this.agu.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.agu.getLayoutParams();
                layoutParams3.width = this.fnk;
                layoutParams3.height = this.fnm;
                this.agu.setLayoutParams(layoutParams3);
                return;
            }
            this.agu.setLayoutParams(new AbsListView.LayoutParams(this.fnk, this.fnm));
        } else if (this.agu.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.agu.getLayoutParams();
            layoutParams4.width = this.fnk;
            layoutParams4.height = this.fnm;
            this.agu.setLayoutParams(layoutParams4);
        } else {
            this.agu.setLayoutParams(new AbsListView.LayoutParams(this.fnk, this.fnm));
        }
    }

    public void btC() {
        this.fnk = l.getEquipmentWidth(this.dPv.getPageActivity());
        this.fnl = l.getEquipmentHeight(this.dPv.getPageActivity());
        this.fnm = (int) ((this.fnk / 16.0d) * 9.0d);
        this.fnn = (int) ((this.fnk / 4.0d) * 3.0d);
        this.fnq = (int) ((this.fnl / 3.0d) - (this.fnn / 2.0d));
        if (this.fnc != null) {
            boolean isPlaying = this.fnh == null ? false : this.fnh.isPlaying();
            qa(this.fnc.aiq.aSJ().screen_direction);
            pZ(this.fnc.aiq.aSJ().screen_direction);
            btD();
            if (isPlaying) {
                Bv(this.fno);
            }
        }
    }

    public void btD() {
        jx(true);
    }

    public void jx(boolean z) {
        if (z) {
            btE();
        }
        if (this.fnh != null) {
            this.fnh.stopPlayback();
        }
        this.fng.bty();
        this.fng.btz();
    }

    private void btE() {
        if (this.fnj != null) {
            if (this.fnj.cVh() != null) {
                this.fnj.cVh().setPlayer(null);
                this.fnj.cVh().stop();
            }
            this.fnj = null;
        }
        if (this.fni != null) {
            this.fni.setPlayer(null);
            this.fni.stop();
            this.fni = null;
        }
        if (this.fnh != null) {
            this.fnh.stopPlayback();
            this.fnh.setOnPreparedListener(null);
            this.fnh.setOnErrorListener(null);
            this.fnh.setOnSurfaceDestroyedListener(null);
            this.fnh.setBusiness(null);
            if (this.fnh.getParent() != null) {
                ((ViewGroup) this.fnh.getParent()).removeView(this.fnh);
            }
            this.fnh = null;
        }
    }

    private void btF() {
        if (this.fnc != null && this.fnc.aiq != null && this.fnc.aiq.aSJ() != null) {
            if (this.fnh != null && this.fnh.getParent() != null) {
                btE();
            }
            this.fnj = new n(this.dPv.getPageActivity());
            this.fni = new j();
            this.fnh = new QuickVideoView(this.dPv.getPageActivity());
            this.fnh.setOnPreparedListener(this.eUJ);
            this.fnh.setOnErrorListener(this.eLe);
            this.fnh.setOnSurfaceDestroyedListener(this.eLi);
            this.fnh.setBusiness(this.fnj);
            this.fnh.setVolume(0.0f, 0.0f);
            this.fni.setPlayer(this.fnh);
            this.fni.a(new j.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.j.c
                public void btG() {
                }
            });
            if (this.fnh.getParent() == null) {
                this.agu.addView(this.fnh, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            pZ(this.fnc.aiq.aSJ().screen_direction);
        }
    }

    public void Bv(String str) {
        if (!StringUtils.isNull(str) && this.fnc != null && this.fnc.aiq != null && this.fnc.aiq.aSJ() != null) {
            if (!str.equals(this.fno) || (this.fnh != null && !this.fnh.isPlaying())) {
                this.fno = str;
                btD();
            }
            if (this.fnh == null) {
                btF();
            }
            if (this.fnh != null && !this.fnh.isPlaying()) {
                if (this.fnj != null) {
                    y yVar = new y();
                    yVar.mLocate = "9";
                    yVar.eEs = String.valueOf(this.fnc.aiq.getFid());
                    yVar.ajO = this.fnc.aiq.getTid();
                    this.fnj.setVideoStatsData(yVar);
                    if (this.fnj.cVC() != null) {
                        this.fnj.cVC().c(this.fnc.aiq.aSJ());
                    }
                }
                if (this.fnh != null) {
                    this.fnh.setVideoPath(this.fnc.aiq.aSJ().hls_url);
                }
                if (this.fnh != null) {
                    this.fnh.start();
                }
                if (this.fni != null) {
                    this.fni.start();
                }
            }
        }
    }

    public View getView() {
        return this.agu;
    }

    public void onDestroy() {
        btE();
        if (this.fng != null) {
            this.fng.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.fng != null) {
            this.fng.bdo();
        }
        an.setBackgroundColor(this.fnh, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, bu buVar) {
        String str;
        if (tbPageContext != null && buVar != null && buVar.aSp() != null && buVar.aSJ() != null) {
            if (this.fnc != null && this.fnc.aiq != null && !this.fmZ) {
                ao aoVar = new ao("c12645");
                if (this.fnc.fmt == 0) {
                    aoVar.ag("obj_type", 1);
                } else if (this.fnc.fmt == 1) {
                    aoVar.ag("obj_type", 2);
                }
                aoVar.dk("tid", this.fnc.aiq.getTid());
                TiebaStatic.log(aoVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = buVar.aSp().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.fmZ) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(buVar.aSJ());
            alaLiveInfoCoreData.userName = buVar.aSJ().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
