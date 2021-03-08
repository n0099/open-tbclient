package com.baidu.tieba.ala.liveroom.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.ar.ILiveMultiBeautyView;
import com.baidu.live.ar.f;
import com.baidu.live.ar.k;
import com.baidu.live.ar.l;
import com.baidu.live.ar.m;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.liveroom.g.c;
/* loaded from: classes10.dex */
public class AlaLiveMultiBeautyView extends ILiveMultiBeautyView implements View.OnClickListener {
    private BdPageContext bsg;
    private boolean gxY;
    private m gya;
    private Button hSA;
    private Button hSB;
    private View hSC;
    private GridView hSD;
    private f hSE;
    private SeekBar hSF;
    private SeekBar hSG;
    private SeekBar hSH;
    private SeekBar hSI;
    private SeekBar hSJ;
    private HListView hSu;
    private com.baidu.tieba.ala.liveroom.g.c hSv;
    private LinearLayout hSw;
    private LinearLayout hSx;
    private Button hSy;
    private Button hSz;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.gxY = true;
        this.hSE = new f();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gxY = true;
        this.hSE = new f();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gxY = true;
        this.hSE = new f();
        initViews();
    }

    private void initViews() {
        if (getContext() instanceof Activity) {
            if (((Activity) getContext()).getApplication().getResources().getConfiguration().orientation == 1) {
                View.inflate(getContext(), a.g.ala_live_beauty_new_hor_layout, this);
            } else {
                View.inflate(getContext(), a.g.ala_live_beauty_new_ver_layout, this);
            }
        } else if (getResources().getConfiguration().orientation == 1) {
            View.inflate(getContext(), a.g.ala_live_beauty_new_hor_layout, this);
        } else {
            View.inflate(getContext(), a.g.ala_live_beauty_new_ver_layout, this);
        }
        this.hSu = (HListView) findViewById(a.f.filter_list_view);
        if (this.hSu != null) {
            this.hSv = new com.baidu.tieba.ala.liveroom.g.c(this.hSu);
            this.hSv.ty(getResources().getDimensionPixelSize(a.d.sdk_ds34));
            this.hSu.setDividerWidth(getResources().getDimensionPixelSize(a.d.sdk_ds34));
            this.hSu.setAdapter((ListAdapter) this.hSv);
            this.hSu.setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        }
        this.hSD = (GridView) findViewById(a.f.filter_grid_view);
        if (this.hSD != null) {
            this.hSv = new com.baidu.tieba.ala.liveroom.g.c(this.hSD);
            this.hSD.setAdapter((ListAdapter) this.hSv);
        }
        this.hSv.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.g.c.b
            public void sI(int i) {
                AlaLiveMultiBeautyView.this.hSE.mFilterName = AlaLiveMultiBeautyView.this.hSv.hDd[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.gya != null) {
                    AlaLiveMultiBeautyView.this.gya.onFilterSelected(AlaLiveMultiBeautyView.this.hSv.hDd[i].gyC, AlaLiveMultiBeautyView.this.hSv.hDd[i].mFilterName, 0.0f);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.f.beauty_title_text);
        this.hSA = (Button) findViewById(a.f.btn_choose_beauty_level);
        this.hSA.setOnClickListener(this);
        this.hSB.setOnClickListener(this);
        this.hSy = (Button) findViewById(a.f.btn_choose_filter);
        this.hSy.setOnClickListener(this);
        this.hSz = (Button) findViewById(a.f.btn_choose_face_shape);
        this.hSz.setOnClickListener(this);
        this.hSw = (LinearLayout) findViewById(a.f.live_face_shape);
        this.hSx = (LinearLayout) findViewById(a.f.face_beauty_level_select_layout);
        this.hSF = (SeekBar) findViewById(a.f.face_level_white_seekbar);
        this.hSF.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hSE.aEg = i;
                if (AlaLiveMultiBeautyView.this.gya != null) {
                    AlaLiveMultiBeautyView.this.gya.t(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hSG = (SeekBar) findViewById(a.f.face_level_red_seekbar);
        this.hSG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hSE.aEh = i;
                if (AlaLiveMultiBeautyView.this.gya != null) {
                    AlaLiveMultiBeautyView.this.gya.w(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hSH = (SeekBar) findViewById(a.f.face_level_skin_seekbar);
        this.hSH.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hSE.aEi = i;
                if (AlaLiveMultiBeautyView.this.gya != null) {
                    AlaLiveMultiBeautyView.this.gya.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hSI = (SeekBar) findViewById(a.f.face_shape_thin_level_seekbar);
        this.hSI.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hSE.aEk = i;
                if (AlaLiveMultiBeautyView.this.gya != null) {
                    AlaLiveMultiBeautyView.this.gya.u(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hSJ = (SeekBar) findViewById(a.f.face_shape_eye_level_seekbar);
        this.hSJ.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hSE.aEj = i;
                if (AlaLiveMultiBeautyView.this.gya != null) {
                    AlaLiveMultiBeautyView.this.gya.v(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hSC = findViewById(a.f.ala_live_new_beauty_nav_view);
        findViewById(a.f.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.zG();
                if (AlaLiveMultiBeautyView.this.gya != null) {
                    AlaLiveMultiBeautyView.this.gya.onClosed();
                    return true;
                }
                return true;
            }
        });
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void zF() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void zG() {
        if (this.hSE != null) {
            com.baidu.live.d.xf().putString("ala_beauty_5.4_config_str", this.hSE.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(k kVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bsg = bdPageContext;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setAlaLiveShowData(ab abVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void b(short s) {
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.gxY && this.hSy.getWidth() != 0) {
            i(this.hSy, false);
            this.gxY = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hSy) {
            i(this.hSy, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hSy);
            if (this.hSu != null) {
                setEffectFilterBeautyChooseBlock(this.hSu);
            } else if (this.hSD != null) {
                setEffectFilterBeautyChooseBlock(this.hSD);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_filter));
            }
        } else if (view == this.hSz) {
            i(this.hSz, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hSz);
            setEffectFilterBeautyChooseBlock(this.hSw);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.hSA) {
            i(this.hSA, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hSA);
            setEffectFilterBeautyChooseBlock(this.hSx);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_beauty));
            }
        } else if (view == this.hSB) {
            i(this.hSB, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hSB);
            setEffectFilterBeautyChooseBlock(this.hSx);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.hSu != null) {
            this.hSu.setVisibility(4);
        }
        if (this.hSD != null) {
            this.hSD.setVisibility(4);
        }
        this.hSw.setVisibility(4);
        this.hSx.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.hSy.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.hSz.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.hSA.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(m mVar) {
        this.gya = mVar;
    }

    private void i(View view, boolean z) {
        this.hSC.clearAnimation();
        int width = (this.hSC.getWidth() / 2) + this.hSC.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hSC.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.hSC.getWidth() / 2);
        this.hSC.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.hSC.startAnimation(translateAnimation);
        }
    }

    public void setViewData(l lVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (lVar != null && alaLiveVideoConfig != null) {
            f fVar = (f) lVar;
            this.hSF.setProgress(fVar.aEg);
            this.hSG.setProgress(fVar.aEh);
            this.hSH.setProgress(fVar.aEi);
            this.hSI.setProgress(fVar.aEk);
            this.hSJ.setProgress(fVar.aEj);
            this.hSv.HQ(fVar.mFilterName);
            this.hSv.notifyDataSetChanged();
            this.hSE = fVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.hSz.setVisibility(0);
            } else {
                this.hSz.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
