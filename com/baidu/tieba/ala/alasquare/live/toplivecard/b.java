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
    private boolean gqN;
    private c gqQ;
    private final float gqT;
    private AlaSquareLiveVideoMask gqU;
    private TbCyberVideoView gqV;
    private f gqW;
    private int gqX;
    private int gqY;
    private int gqZ;
    private int gra;
    private String grb;
    private a grc;
    private int grd;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes6.dex */
    public interface a {
        void S(by byVar);

        void T(by byVar);
    }

    public b(TbPageContext<?> tbPageContext) {
        this.gqT = 0.0f;
        this.eNx = null;
        this.grb = "";
        this.gqN = false;
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.1
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                b.this.bRW();
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
                if (b.this.gqV != null) {
                    b.this.gqV.setLooping(false);
                    b.this.gqV.setVolume(0.0f, 0.0f);
                    if (b.this.gqQ != null && b.this.gqQ.alu != null) {
                        if (b.this.gqN) {
                            if (b.this.grc != null) {
                                b.this.grc.T(b.this.gqQ.alu);
                            }
                        } else {
                            ar arVar = new ar("c12646");
                            if (b.this.gqQ.gqh != 0) {
                                if (b.this.gqQ.gqh == 1) {
                                    arVar.al("obj_type", 2);
                                }
                            } else {
                                arVar.al("obj_type", 1);
                            }
                            arVar.dY("tid", b.this.gqQ.alu.getTid());
                            TiebaStatic.log(arVar);
                        }
                    }
                    if (b.this.gqV.getCyberPlayer() != null) {
                        b.this.bF(b.this.gqV.getCyberPlayer().getVideoHeight(), b.this.gqV.getCyberPlayer().getVideoWidth());
                    }
                    if (b.this.gqU != null) {
                        b.this.gqU.bRQ();
                    }
                }
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.gqQ != null && b.this.gqQ.alu != null) {
                    if (b.this.grc != null) {
                        b.this.grc.S(b.this.gqQ.alu);
                    }
                    b.this.a(b.this.eNx, b.this.gqQ.alu);
                }
            }
        };
        this.eNx = tbPageContext;
        initUI();
    }

    public b(TbPageContext<?> tbPageContext, boolean z) {
        this(tbPageContext);
        this.gqN = z;
        this.gqU.setFromSpecialForum(z);
    }

    private void initUI() {
        if (this.eNx != null) {
            this.ajk = (FrameLayout) LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.new_square_top_live_card, (ViewGroup) null);
            this.gqX = l.getEquipmentWidth(this.eNx.getPageActivity());
            this.gqY = l.getEquipmentHeight(this.eNx.getPageActivity());
            this.gqZ = (int) ((this.gqX / 16.0d) * 9.0d);
            this.gra = (int) ((this.gqX / 4.0d) * 3.0d);
            this.grd = (int) ((this.gqY / 3.0d) - (this.gra / 2.0d));
            this.gqU = (AlaSquareLiveVideoMask) this.ajk.findViewById(R.id.video_mask);
            this.ajk.setOnClickListener(this.mOnClickListener);
            onChangeSkinType();
        }
    }

    public void a(a aVar) {
        this.grc = aVar;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.alu != null && cVar.alu.bpj() != null) {
            if (this.gqQ == null || (this.gqQ.alu != null && !this.gqQ.alu.getTid().equals(cVar.alu.getTid()))) {
                uW(cVar.alu.bpj().screen_direction);
            }
            this.gqQ = cVar;
            this.aLF = this.gqQ.alu.bpj().screen_direction;
            this.gqU.setData(this.gqQ.alu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(int i, int i2) {
        int i3;
        int i4;
        if (this.aLF == 1 && this.gqV != null && this.gqV.getParent() != null) {
            float f = i / i2;
            float f2 = (this.gqX * i) / this.gqY;
            if (f2 < i2) {
                i3 = (int) (this.gqY / f);
                i4 = this.gqY;
            } else if (f2 > i2) {
                i3 = this.gqX;
                i4 = (int) (f * this.gqX);
            } else {
                i3 = this.gqX;
                i4 = this.gqY;
            }
            if (this.gqV.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gqV.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = i4;
                this.gqV.setLayoutParams(layoutParams);
                return;
            }
            this.gqV.setLayoutParams(new FrameLayout.LayoutParams(i3, i4));
        }
    }

    private void uV(int i) {
        if (this.gqV != null) {
            if (i == 1) {
                if (this.gqV.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gqV.getLayoutParams();
                    layoutParams.width = this.gqX;
                    layoutParams.height = this.gqY;
                    layoutParams.topMargin = -this.grd;
                    this.gqV.setLayoutParams(layoutParams);
                    return;
                }
                this.gqV.setLayoutParams(new FrameLayout.LayoutParams(this.gqX, this.gqY));
            } else if (this.gqV.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gqV.getLayoutParams();
                layoutParams2.width = this.gqX;
                layoutParams2.height = this.gqZ;
                this.gqV.setLayoutParams(layoutParams2);
            } else {
                this.gqV.setLayoutParams(new FrameLayout.LayoutParams(this.gqX, this.gqZ));
            }
        }
    }

    private void uW(int i) {
        if (i == 1) {
            if (this.gqN) {
                if (this.ajk.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ajk.getLayoutParams();
                    layoutParams.width = this.gqX;
                    layoutParams.height = this.gra;
                    this.ajk.setLayoutParams(layoutParams);
                    return;
                }
                this.ajk.setLayoutParams(new FrameLayout.LayoutParams(this.gqX, this.gra));
                return;
            } else if (this.ajk.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.ajk.getLayoutParams();
                layoutParams2.width = this.gqX;
                layoutParams2.height = this.gqX;
                this.ajk.setLayoutParams(layoutParams2);
                return;
            } else {
                this.ajk.setLayoutParams(new AbsListView.LayoutParams(this.gqX, this.gqX));
                return;
            }
        }
        this.aLF = 2;
        if (this.gqN) {
            if (this.ajk.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.ajk.getLayoutParams();
                layoutParams3.width = this.gqX;
                layoutParams3.height = this.gqZ;
                this.ajk.setLayoutParams(layoutParams3);
                return;
            }
            this.ajk.setLayoutParams(new AbsListView.LayoutParams(this.gqX, this.gqZ));
        } else if (this.ajk.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams4 = (AbsListView.LayoutParams) this.ajk.getLayoutParams();
            layoutParams4.width = this.gqX;
            layoutParams4.height = this.gqZ;
            this.ajk.setLayoutParams(layoutParams4);
        } else {
            this.ajk.setLayoutParams(new AbsListView.LayoutParams(this.gqX, this.gqZ));
        }
    }

    public void bRV() {
        this.gqX = l.getEquipmentWidth(this.eNx.getPageActivity());
        this.gqY = l.getEquipmentHeight(this.eNx.getPageActivity());
        this.gqZ = (int) ((this.gqX / 16.0d) * 9.0d);
        this.gra = (int) ((this.gqX / 4.0d) * 3.0d);
        this.grd = (int) ((this.gqY / 3.0d) - (this.gra / 2.0d));
        if (this.gqQ != null) {
            boolean isPlaying = this.gqV == null ? false : this.gqV.isPlaying();
            uW(this.gqQ.alu.bpj().screen_direction);
            uV(this.gqQ.alu.bpj().screen_direction);
            bRW();
            if (isPlaying) {
                GM(this.grb);
            }
        }
    }

    public void bRW() {
        lY(true);
    }

    public void lY(boolean z) {
        if (z) {
            bRX();
        }
        if (this.gqV != null) {
            this.gqV.stopPlayback();
        }
        this.gqU.bRR();
        this.gqU.bRS();
    }

    private void bRX() {
        if (this.gqW != null) {
            this.gqW.setPlayer(null);
            this.gqW.stop();
            this.gqW = null;
        }
        if (this.gqV != null) {
            this.gqV.stopPlayback();
            this.gqV.dCl();
            if (this.gqV.getMediaProgressObserver() != null) {
                this.gqV.getMediaProgressObserver().setPlayer(null);
                this.gqV.getMediaProgressObserver().stop();
            }
            this.gqV = null;
        }
    }

    private void bRY() {
        if (this.gqQ != null && this.gqQ.alu != null && this.gqQ.alu.bpj() != null) {
            if (this.gqV != null && this.gqV.getParent() != null) {
                bRX();
            }
            this.gqW = new f();
            this.gqV = new TbCyberVideoView(this.eNx.getPageActivity());
            this.gqV.setOnPreparedListener(this.ety);
            this.gqV.setOnErrorListener(this.etz);
            this.gqV.setOnSurfaceDestroyedListener(this.fMW);
            this.gqV.setVolume(0.0f, 0.0f);
            this.gqV.setStageType(null);
            this.gqW.setPlayer(this.gqV);
            this.gqW.a(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.toplivecard.b.4
                @Override // com.baidu.tieba.play.f.c
                public void bRZ() {
                }
            });
            if (this.gqV.getParent() == null) {
                this.ajk.addView(this.gqV, 0, new FrameLayout.LayoutParams(-1, -1));
            }
            uV(this.gqQ.alu.bpj().screen_direction);
        }
    }

    public void GM(String str) {
        if (!StringUtils.isNull(str) && this.gqQ != null && this.gqQ.alu != null && this.gqQ.alu.bpj() != null) {
            if (!str.equals(this.grb) || (this.gqV != null && !this.gqV.isPlaying())) {
                this.grb = str;
                bRW();
            }
            if (this.gqV == null) {
                bRY();
            }
            if (this.gqV != null && !this.gqV.isPlaying()) {
                o oVar = new o();
                oVar.mLocate = PublishType.TYPE_VIDEO_SHARE;
                oVar.fFV = String.valueOf(this.gqQ.alu.getFid());
                oVar.amY = this.gqQ.alu.getTid();
                this.gqV.setVideoStatData(oVar);
                if (this.gqV != null) {
                    this.gqV.setVideoPath(this.gqQ.alu.bpj().hls_url);
                }
                if (this.gqV != null) {
                    this.gqV.start();
                }
                if (this.gqW != null) {
                    this.gqW.start();
                }
            }
        }
    }

    public View getView() {
        return this.ajk;
    }

    public void onDestroy() {
        bRX();
        if (this.gqU != null) {
            this.gqU.onDestroy();
        }
    }

    public void onChangeSkinType() {
        if (this.gqU != null) {
            this.gqU.bAu();
        }
        ap.setBackgroundColor(this.gqV, R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbPageContext<?> tbPageContext, by byVar) {
        String str;
        if (tbPageContext != null && byVar != null && byVar.boP() != null && byVar.bpj() != null) {
            if (this.gqQ != null && this.gqQ.alu != null && !this.gqN) {
                ar arVar = new ar("c12645");
                if (this.gqQ.gqh == 0) {
                    arVar.al("obj_type", 1);
                } else if (this.gqQ.gqh == 1) {
                    arVar.al("obj_type", 2);
                }
                arVar.dY("tid", this.gqQ.alu.getTid());
                TiebaStatic.log(arVar);
            }
            boolean z = false;
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = byVar.boP().getUserId();
                str2 = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str2);
            }
            if (this.gqN) {
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
