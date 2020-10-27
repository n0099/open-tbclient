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
import com.baidu.live.ar.i;
import com.baidu.live.ar.j;
import com.baidu.live.ar.k;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.liveroom.h.c;
/* loaded from: classes4.dex */
public class AlaLiveMultiBeautyView extends ILiveMultiBeautyView implements View.OnClickListener {
    private BdPageContext blq;
    private boolean fZT;
    private k fZV;
    private com.baidu.tieba.ala.liveroom.h.c hpA;
    private LinearLayout hpB;
    private LinearLayout hpC;
    private Button hpD;
    private Button hpE;
    private Button hpF;
    private Button hpG;
    private View hpH;
    private GridView hpI;
    private com.baidu.tieba.ala.liveroom.data.d hpJ;
    private SeekBar hpK;
    private SeekBar hpL;
    private SeekBar hpM;
    private SeekBar hpN;
    private SeekBar hpO;
    private HListView hpz;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.fZT = true;
        this.hpJ = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fZT = true;
        this.hpJ = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fZT = true;
        this.hpJ = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    private void initViews() {
        if (getContext() instanceof Activity) {
            if (((Activity) getContext()).getApplication().getResources().getConfiguration().orientation == 1) {
                View.inflate(getContext(), a.h.ala_live_beauty_new_hor_layout, this);
            } else {
                View.inflate(getContext(), a.h.ala_live_beauty_new_ver_layout, this);
            }
        } else if (getResources().getConfiguration().orientation == 1) {
            View.inflate(getContext(), a.h.ala_live_beauty_new_hor_layout, this);
        } else {
            View.inflate(getContext(), a.h.ala_live_beauty_new_ver_layout, this);
        }
        this.hpz = (HListView) findViewById(a.g.filter_list_view);
        if (this.hpz != null) {
            this.hpA = new com.baidu.tieba.ala.liveroom.h.c(this.hpz);
            this.hpA.ty(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.hpz.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.hpz.setAdapter((ListAdapter) this.hpA);
            this.hpz.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.hpI = (GridView) findViewById(a.g.filter_grid_view);
        if (this.hpI != null) {
            this.hpA = new com.baidu.tieba.ala.liveroom.h.c(this.hpI);
            this.hpI.setAdapter((ListAdapter) this.hpA);
        }
        this.hpA.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.h.c.b
            public void onItemSelected(int i) {
                AlaLiveMultiBeautyView.this.hpJ.mFilterName = AlaLiveMultiBeautyView.this.hpA.hao[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.fZV != null) {
                    AlaLiveMultiBeautyView.this.fZV.onFilterSelected(AlaLiveMultiBeautyView.this.hpA.hao[i].mShowName, AlaLiveMultiBeautyView.this.hpA.hao[i].mFilterName, 0.0f);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.g.beauty_title_text);
        this.hpF = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.hpF.setOnClickListener(this);
        this.hpG.setOnClickListener(this);
        this.hpD = (Button) findViewById(a.g.btn_choose_filter);
        this.hpD.setOnClickListener(this);
        this.hpE = (Button) findViewById(a.g.btn_choose_face_shape);
        this.hpE.setOnClickListener(this);
        this.hpB = (LinearLayout) findViewById(a.g.live_face_shape);
        this.hpC = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.hpK = (SeekBar) findViewById(a.g.face_level_white_seekbar);
        this.hpK.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hpJ.haL = i;
                if (AlaLiveMultiBeautyView.this.fZV != null) {
                    AlaLiveMultiBeautyView.this.fZV.s(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hpL = (SeekBar) findViewById(a.g.face_level_red_seekbar);
        this.hpL.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hpJ.haM = i;
                if (AlaLiveMultiBeautyView.this.fZV != null) {
                    AlaLiveMultiBeautyView.this.fZV.v(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hpM = (SeekBar) findViewById(a.g.face_level_skin_seekbar);
        this.hpM.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hpJ.haN = i;
                if (AlaLiveMultiBeautyView.this.fZV != null) {
                    AlaLiveMultiBeautyView.this.fZV.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hpN = (SeekBar) findViewById(a.g.face_shape_thin_level_seekbar);
        this.hpN.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hpJ.haP = i;
                if (AlaLiveMultiBeautyView.this.fZV != null) {
                    AlaLiveMultiBeautyView.this.fZV.t(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hpO = (SeekBar) findViewById(a.g.face_shape_eye_level_seekbar);
        this.hpO.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hpJ.haO = i;
                if (AlaLiveMultiBeautyView.this.fZV != null) {
                    AlaLiveMultiBeautyView.this.fZV.u(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hpH = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.Ci();
                if (AlaLiveMultiBeautyView.this.fZV != null) {
                    AlaLiveMultiBeautyView.this.fZV.Cj();
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
    public void Ch() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void Ci() {
        if (this.hpJ != null) {
            com.baidu.live.d.AZ().putString("ala_beauty_5.4_config_str", this.hpJ.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(i iVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.blq = bdPageContext;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setAlaLiveShowData(w wVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void b(short s) {
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.fZT && this.hpD.getWidth() != 0) {
            h(this.hpD, false);
            this.fZT = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hpD) {
            h(this.hpD, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hpD);
            if (this.hpz != null) {
                setEffectFilterBeautyChooseBlock(this.hpz);
            } else if (this.hpI != null) {
                setEffectFilterBeautyChooseBlock(this.hpI);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
        } else if (view == this.hpE) {
            h(this.hpE, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hpE);
            setEffectFilterBeautyChooseBlock(this.hpB);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.hpF) {
            h(this.hpF, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hpF);
            setEffectFilterBeautyChooseBlock(this.hpC);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
        } else if (view == this.hpG) {
            h(this.hpG, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hpG);
            setEffectFilterBeautyChooseBlock(this.hpC);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.hpz != null) {
            this.hpz.setVisibility(4);
        }
        if (this.hpI != null) {
            this.hpI.setVisibility(4);
        }
        this.hpB.setVisibility(4);
        this.hpC.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.hpD.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.hpE.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.hpF.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(k kVar) {
        this.fZV = kVar;
    }

    private void h(View view, boolean z) {
        this.hpH.clearAnimation();
        int width = (this.hpH.getWidth() / 2) + this.hpH.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hpH.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.hpH.getWidth() / 2);
        this.hpH.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.hpH.startAnimation(translateAnimation);
        }
    }

    public void setViewData(j jVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (jVar != null && alaLiveVideoConfig != null) {
            com.baidu.tieba.ala.liveroom.data.d dVar = (com.baidu.tieba.ala.liveroom.data.d) jVar;
            this.hpK.setProgress(dVar.haL);
            this.hpL.setProgress(dVar.haM);
            this.hpM.setProgress(dVar.haN);
            this.hpN.setProgress(dVar.haP);
            this.hpO.setProgress(dVar.haO);
            this.hpA.HE(dVar.mFilterName);
            this.hpA.notifyDataSetChanged();
            this.hpJ = dVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.hpE.setVisibility(0);
            } else {
                this.hpE.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
