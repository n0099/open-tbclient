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
import com.baidu.live.ar.g;
import com.baidu.live.ar.h;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.g.c;
/* loaded from: classes3.dex */
public class AlaLiveMultiBeautyView extends ILiveMultiBeautyView implements View.OnClickListener {
    private BdPageContext aOf;
    private LinearLayout eMV;
    private Button eMW;
    private Button eMX;
    private Button eMY;
    private View eMZ;
    private boolean eNa;
    private h eNc;
    private HListView fRB;
    private com.baidu.tieba.ala.liveroom.g.c fRC;
    private LinearLayout fRD;
    private GridView fRE;
    private com.baidu.tieba.ala.liveroom.data.d fRF;
    private SeekBar fRG;
    private SeekBar fRH;
    private SeekBar fRI;
    private SeekBar fRJ;
    private SeekBar fRK;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.eNa = true;
        this.fRF = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eNa = true;
        this.fRF = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eNa = true;
        this.fRF = new com.baidu.tieba.ala.liveroom.data.d();
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
        this.fRB = (HListView) findViewById(a.g.filter_list_view);
        if (this.fRB != null) {
            this.fRC = new com.baidu.tieba.ala.liveroom.g.c(this.fRB);
            this.fRC.oV(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.fRB.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.fRB.setAdapter((ListAdapter) this.fRC);
            this.fRB.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fRE = (GridView) findViewById(a.g.filter_grid_view);
        if (this.fRE != null) {
            this.fRC = new com.baidu.tieba.ala.liveroom.g.c(this.fRE);
            this.fRE.setAdapter((ListAdapter) this.fRC);
        }
        this.fRC.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.g.c.b
            public void onItemSelected(int i) {
                AlaLiveMultiBeautyView.this.fRF.mFilterName = AlaLiveMultiBeautyView.this.fRC.fEP[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.eNc != null) {
                    AlaLiveMultiBeautyView.this.eNc.onFilterSelected(AlaLiveMultiBeautyView.this.fRC.fEP[i].mFilterName, 0.0f);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.g.beauty_title_text);
        this.eMY = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.eMY.setOnClickListener(this);
        this.eMW = (Button) findViewById(a.g.btn_choose_filter);
        this.eMW.setOnClickListener(this);
        this.eMX = (Button) findViewById(a.g.btn_choose_face_shape);
        this.eMX.setOnClickListener(this);
        this.fRD = (LinearLayout) findViewById(a.g.live_face_shape);
        this.eMV = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.fRG = (SeekBar) findViewById(a.g.face_level_white_seekbar);
        this.fRG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fRF.fFn = i;
                if (AlaLiveMultiBeautyView.this.eNc != null) {
                    AlaLiveMultiBeautyView.this.eNc.n(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fRH = (SeekBar) findViewById(a.g.face_level_red_seekbar);
        this.fRH.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fRF.fFo = i;
                if (AlaLiveMultiBeautyView.this.eNc != null) {
                    AlaLiveMultiBeautyView.this.eNc.q(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fRI = (SeekBar) findViewById(a.g.face_level_skin_seekbar);
        this.fRI.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fRF.fFp = i;
                if (AlaLiveMultiBeautyView.this.eNc != null) {
                    AlaLiveMultiBeautyView.this.eNc.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fRJ = (SeekBar) findViewById(a.g.face_shape_thin_level_seekbar);
        this.fRJ.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fRF.fFr = i;
                if (AlaLiveMultiBeautyView.this.eNc != null) {
                    AlaLiveMultiBeautyView.this.eNc.o(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fRK = (SeekBar) findViewById(a.g.face_shape_eye_level_seekbar);
        this.fRK.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fRF.fFq = i;
                if (AlaLiveMultiBeautyView.this.eNc != null) {
                    AlaLiveMultiBeautyView.this.eNc.p(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eMZ = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.tW();
                if (AlaLiveMultiBeautyView.this.eNc != null) {
                    AlaLiveMultiBeautyView.this.eNc.tX();
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
    public void tV() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void tW() {
        if (this.fRF != null) {
            com.baidu.live.c.tH().putString("ala_beauty_5.4_config_str", this.fRF.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(f fVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.aOf = bdPageContext;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.eNa && this.eMW.getWidth() != 0) {
            e(this.eMW, false);
            this.eNa = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eMW) {
            e(this.eMW, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eMW);
            if (this.fRB != null) {
                setEffectFilterBeautyChooseBlock(this.fRB);
            } else if (this.fRE != null) {
                setEffectFilterBeautyChooseBlock(this.fRE);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
        } else if (view == this.eMX) {
            e(this.eMX, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eMX);
            setEffectFilterBeautyChooseBlock(this.fRD);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.eMY) {
            e(this.eMY, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eMY);
            setEffectFilterBeautyChooseBlock(this.eMV);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.fRB != null) {
            this.fRB.setVisibility(4);
        }
        if (this.fRE != null) {
            this.fRE.setVisibility(4);
        }
        this.fRD.setVisibility(4);
        this.eMV.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.eMW.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.eMX.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.eMY.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(h hVar) {
        this.eNc = hVar;
    }

    private void e(View view, boolean z) {
        this.eMZ.clearAnimation();
        int width = (this.eMZ.getWidth() / 2) + this.eMZ.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eMZ.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.eMZ.getWidth() / 2);
        this.eMZ.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.eMZ.startAnimation(translateAnimation);
        }
    }

    public void setViewData(g gVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (gVar != null && alaLiveVideoConfig != null) {
            com.baidu.tieba.ala.liveroom.data.d dVar = (com.baidu.tieba.ala.liveroom.data.d) gVar;
            this.fRG.setProgress(dVar.fFn);
            this.fRH.setProgress(dVar.fFo);
            this.fRI.setProgress(dVar.fFp);
            this.fRJ.setProgress(dVar.fFr);
            this.fRK.setProgress(dVar.fFq);
            this.fRC.zk(dVar.mFilterName);
            this.fRC.notifyDataSetChanged();
            this.fRF = dVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.eMX.setVisibility(0);
            } else {
                this.eMX.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
