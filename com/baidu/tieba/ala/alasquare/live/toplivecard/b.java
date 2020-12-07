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
import com.baidu.searchbox.ugc.model.PublishType;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live.b.c;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.o;
/* loaded from: classes6.dex */
public class b {
    private int aLF;
    private FrameLayout ajk;
    private TbPageContext<?> eNx;
    private CyberPlayerManager.OnPreparedListener ety;
    private CyberPlayerManager.OnErrorListener etz;
    private TbCyberVideoView.a fMW;
    private boolean gqL;
    private c gqO;
    private final float gqR;
    private AlaSquareLiveVideoMask gqS;
    private TbCyberVideoView gqT;
    private f gqU;
    private int gqV;
    private int gqW;
    private int gqX;
    private int gqY;
    private String gqZ;
    private a gra;
    private int grb;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes6.dex */
    public interface a {
        void S(by byVar);

        void T(by byVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.gqR = 0.0f;
        this.eNx = null;
        this.gqZ = "";
        this.gqL = false;
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                b.this.bRV();
            }
        };
        this.etz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.2
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                b.this.lY(false);
                return true;
            }
        };
        this.ety = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (b.this.gqT != null) {
                    b.this.gqT.setLooping(false);
                    b.this.gqT.setVolume(0.0f, 0.0f);
                    if (b.this.gqO != null && b.this.gqO.alu != null) {
                        if (b.this.gqL) {
                            if (b.this.gra != null) {
                                b.this.gra.T(b.this.gqO.alu);
                            }
                        } else {
                            ar arVar = new ar("c12646");
                            if (b.this.gqO.gqf != 0) {
                                if (b.this.gqO.gqf == 1) {
                                    arVar.al("obj_type", 2);
                                }
                            } else {
                                arVar.al("obj_type", 1);
                            }
                            arVar.dY("tid", b.this.gqO.alu.getTid());
                            TiebaStatic.log(arVar);
                        }
                    }
                    if (b.this.gqT.getCyberPlayer() != null) {
                        b.this.bF(b.this.gqT.getCyberPlayer().getVideoHeight(), b.this.gqT.getCyberPlayer().getVideoWidth());
                    }
                    if (b.this.gqS != null) {
                        b.this.gqS.bRP();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gqO != null && b.this.gqO.alu != null) {
                    if (b.this.gra != null) {
                        b.this.gra.S(b.this.gqO.alu);
                    }
                    b.this.a(b.this.eNx, b.this.gqO.alu);
                }
            }
        };
        this.eNx = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.gqL = z;
        this.gqS.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.eNx != null) {
            this.ajk = (FrameLayout) LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.gqV = l.getEquipmentWidth(this.eNx.getPageActivity());
            this.gqW = l.getEquipmentHeight(this.eNx.getPageActivity());
            this.gqX = (int) ((this.gqV / 16.0d) * 9.0d);
            this.gqY = (int) ((this.gqV / 4.0d) * 3.0d);
            this.grb = (int) ((this.gqW / 3.0d) - (this.gqY / 2.0d));
            this.gqS = (AlaSquareLiveVideoMask) this.ajk.findViewById(R.id.video_mask);
            this.ajk.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.gra = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.alu != null && cVar.alu.bpj() != null) {
            if (this.gqO == null || (this.gqO.alu != null && !this.gqO.alu.getTid().equals(cVar.alu.getTid()))) {
                uW(cVar.alu.bpj().screen_direction);
            }
            this.gqO = cVar;
            this.aLF = this.gqO.alu.bpj().screen_direction;
            this.gqS.setData(this.gqO.alu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(int i, int i2) {
        int i3;
        int i4;
        if (this.aLF == 1 && this.gqT != null && this.gqT.getParent() != null) {
            float f = i / i2;
            float f2 = (this.gqV * i) / this.gqW;
            if (f2 < i2) {
                i3 = (int) (this.gqW / f);
                i4 = this.gqW;
            } else if (f2 > i2) {
                i3 = this.gqV;
                i4 = (int) (f * this.gqV);
            } else {
                i3 = this.gqV;
                i4 = this.gqW;
            }
            if (this.gqT.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gqT.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.gqT.setLayoutParams(layoutParams);
                return;
            }
            this.gqT.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void uV(int i) {
        if (this.gqT != null) {
            if (i == 1) {
                if (this.gqT.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gqT.getLayoutParams();
                    layoutParams.width = this.gqV;
                    layoutParams.height = this.gqW;
                    layoutParams.topMargin = -this.grb;
                    this.gqT.setLayoutParams(layoutParams);
                    return;
                }
                this.gqT.setLayoutParams(new FrameLayout.LayoutParams(this.gqV, this.gqW));
            } else if (this.gqT.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gqT.getLayoutParams();
                layoutParams2.width = this.gqV;
                layoutParams2.height = this.gqX;
                this.gqT.setLayoutParams(layoutParams2);
            } else {
                this.gqT.setLayoutParams(new FrameLayout.LayoutParams(this.gqV, this.gqX));
            }
        }
    }

    private void uW(int i) {
        if (i == 1) {
            if (this.gqL) {
                if (this.ajk.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ajk.getLayoutParams();
                    layoutParams.width = this.gqV;
                    layoutParams.height = this.gqY;
                    this.ajk.setLayoutParams(layoutParams);
                    return;
                }
                this.ajk.setLayoutParams(new FrameLayout.LayoutParams(this.gqV, this.gqY));
                return;
            } else if (this.ajk.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ajk.getLayoutParams();
                layoutParams2.width = this.gqV;
                layoutParams2.height = this.gqV;
                this.ajk.setLayoutParams(layoutParams2);
                return;
            } else {
                this.ajk.setLayoutParams(new AbsListView.LayoutParams(this.gqV, this.gqV));
                return;
            }
        }
        this.aLF = 2;
        if (this.gqL) {
            if (this.ajk.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.ajk.getLayoutParams();
                layoutParams3.width = this.gqV;
                layoutParams3.height = this.gqX;
                this.ajk.setLayoutParams(layoutParams3);
                return;
            }
            this.ajk.setLayoutParams(new AbsListView.LayoutParams(this.gqV, this.gqX));
        } else if (this.ajk.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.ajk.getLayoutParams();
            layoutParams4.width = this.gqV;
            layoutParams4.height = this.gqX;
            this.ajk.setLayoutParams(layoutParams4);
        } else {
            this.ajk.setLayoutParams(new AbsListView.LayoutParams(this.gqV, this.gqX));
        }
    }

    public void bRU() {
        this.gqV = l.getEquipmentWidth(this.eNx.getPageActivity());
        this.gqW = l.getEquipmentHeight(this.eNx.getPageActivity());
        this.gqX = (int) ((this.gqV / 16.0d) * 9.0d);
        this.gqY = (int) ((this.gqV / 4.0d) * 3.0d);
        this.grb = (int) ((this.gqW / 3.0d) - (this.gqY / 2.0d));
        if (this.gqO != null) {
            boolean isPlaying = this.gqT == null ? false : this.gqT.isPlaying();
            uW(this.gqO.alu.bpj().screen_direction);
            uV(this.gqO.alu.bpj().screen_direction);
            bRV();
            if (isPlaying) {
                GM(this.gqZ);
            }
        }
    }

    public void bRV() {
        lY(true);
    }

    public void lY(boolean z) {
        if (z) {
            bRW();
        }
        if (this.gqT != null) {
            this.gqT.stopPlayback();
        }
        this.gqS.bRQ();
        this.gqS.bRR();
    }

    private void bRW() {
        if (this.gqU != null) {
            this.gqU.setPlayer(null);
            this.gqU.stop();
            this.gqU = null;
        }
        if (this.gqT != null) {
            this.gqT.stopPlayback();
            this.gqT.dCk();
            if (this.gqT.getMediaProgressObserver() != null) {
                this.gqT.getMediaProgressObserver().setPlayer(null);
                this.gqT.getMediaProgressObserver().stop();
            }
            this.gqT = null;
        }
    }

    private void bRX() {
        if (this.gqO != null && this.gqO.alu != null && this.gqO.alu.bpj() != null) {
            if (this.gqT != null && this.gqT.getParent() != null) {
                bRW();
            }
            this.gqU = new f();
            this.gqT = new TbCyberVideoView(this.eNx.getPageActivity());
            this.gqT.setOnPreparedListener(this.ety);
            this.gqT.setOnErrorListener(this.etz);
            this.gqT.setOnSurfaceDestroyedListener(this.fMW);
            this.gqT.setVolume(0.0f, 0.0f);
            this.gqT.setStageType(null);
            this.gqU.setPlayer(this.gqT);
            this.gqU.a(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.f.c
                public void bRY() {
                }
            });
            if (this.gqT.getParent() == null) {
                this.ajk.addView(this.gqT, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            uV(this.gqO.alu.bpj().screen_direction);
        }
    }

    public void GM(String str) {
        if (!StringUtils.isNull(str) && this.gqO != null && this.gqO.alu != null && this.gqO.alu.bpj() != null) {
            if (!str.equals(this.gqZ) || (this.gqT != null && !this.gqT.isPlaying())) {
                this.gqZ = str;
                bRV();
            }
            if (this.gqT == null) {
                bRX();
            }
            if (this.gqT != null && !this.gqT.isPlaying()) {
                o oVar = new o();
                oVar.mLocate = PublishType.TYPE_VIDEO_SHARE;
                oVar.fFV = String.valueOf(this.gqO.alu.getFid());
                oVar.amY = this.gqO.alu.getTid();
                this.gqT.setVideoStatData(oVar);
                if (this.gqT != null) {
                    this.gqT.setVideoPath(this.gqO.alu.bpj().hls_url);
                }
                if (this.gqT != null) {
                    this.gqT.start();
                }
                if (this.gqU != null) {
                    this.gqU.start();
                }
            }
        }
    }

    public View getView() {
        return this.ajk;
    }

    public void onDestroy() {
        bRW();
        if (this.gqS != null) {
            this.gqS.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.gqS != null) {
            this.gqS.bAu();
        }
        ap.setBackgroundColor(this.gqT, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, by byVar) {
        String str;
        if (tbPageContext != null && byVar != null && byVar.boP() != null && byVar.bpj() != null) {
            if (this.gqO != null && this.gqO.alu != null && !this.gqL) {
                ar arVar = new ar("c12645");
                if (this.gqO.gqf == 0) {
                    arVar.al("obj_type", 1);
                } else if (this.gqO.gqf == 1) {
                    arVar.al("obj_type", 2);
                }
                arVar.dY("tid", this.gqO.alu.getTid());
                TiebaStatic.log(arVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = byVar.boP().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.gqL) {
                str = "frs_live_tab_headview";
            } else {
                str = "square_recommend_top_card";
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(byVar.bpj());
            alaLiveInfoCoreData.userName = byVar.bpj().user_info.user_name;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, str, str2, z, "")));
        }
    }
}
