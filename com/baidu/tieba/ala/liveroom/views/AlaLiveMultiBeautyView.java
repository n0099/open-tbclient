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
import com.baidu.live.ar.j;
import com.baidu.live.ar.k;
import com.baidu.live.ar.l;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.liveroom.h.c;
/* loaded from: classes4.dex */
public class AlaLiveMultiBeautyView extends ILiveMultiBeautyView implements View.OnClickListener {
    private BdPageContext bmK;
    private boolean gfK;
    private l gfM;
    private LinearLayout hvA;
    private Button hvB;
    private Button hvC;
    private Button hvD;
    private Button hvE;
    private View hvF;
    private GridView hvG;
    private com.baidu.live.ar.e hvH;
    private SeekBar hvI;
    private SeekBar hvJ;
    private SeekBar hvK;
    private SeekBar hvL;
    private SeekBar hvM;
    private HListView hvx;
    private com.baidu.tieba.ala.liveroom.h.c hvy;
    private LinearLayout hvz;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.gfK = true;
        this.hvH = new com.baidu.live.ar.e();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gfK = true;
        this.hvH = new com.baidu.live.ar.e();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gfK = true;
        this.hvH = new com.baidu.live.ar.e();
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
        this.hvx = (HListView) findViewById(a.f.filter_list_view);
        if (this.hvx != null) {
            this.hvy = new com.baidu.tieba.ala.liveroom.h.c(this.hvx);
            this.hvy.tI(getResources().getDimensionPixelSize(a.d.sdk_ds34));
            this.hvx.setDividerWidth(getResources().getDimensionPixelSize(a.d.sdk_ds34));
            this.hvx.setAdapter((ListAdapter) this.hvy);
            this.hvx.setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        }
        this.hvG = (GridView) findViewById(a.f.filter_grid_view);
        if (this.hvG != null) {
            this.hvy = new com.baidu.tieba.ala.liveroom.h.c(this.hvG);
            this.hvG.setAdapter((ListAdapter) this.hvy);
        }
        this.hvy.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.h.c.b
            public void onItemSelected(int i) {
                AlaLiveMultiBeautyView.this.hvH.mFilterName = AlaLiveMultiBeautyView.this.hvy.hgq[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.gfM != null) {
                    AlaLiveMultiBeautyView.this.gfM.onFilterSelected(AlaLiveMultiBeautyView.this.hvy.hgq[i].mShowName, AlaLiveMultiBeautyView.this.hvy.hgq[i].mFilterName, 0.0f);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.f.beauty_title_text);
        this.hvD = (Button) findViewById(a.f.btn_choose_beauty_level);
        this.hvD.setOnClickListener(this);
        this.hvE.setOnClickListener(this);
        this.hvB = (Button) findViewById(a.f.btn_choose_filter);
        this.hvB.setOnClickListener(this);
        this.hvC = (Button) findViewById(a.f.btn_choose_face_shape);
        this.hvC.setOnClickListener(this);
        this.hvz = (LinearLayout) findViewById(a.f.live_face_shape);
        this.hvA = (LinearLayout) findViewById(a.f.face_beauty_level_select_layout);
        this.hvI = (SeekBar) findViewById(a.f.face_level_white_seekbar);
        this.hvI.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hvH.aEB = i;
                if (AlaLiveMultiBeautyView.this.gfM != null) {
                    AlaLiveMultiBeautyView.this.gfM.s(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hvJ = (SeekBar) findViewById(a.f.face_level_red_seekbar);
        this.hvJ.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hvH.aEC = i;
                if (AlaLiveMultiBeautyView.this.gfM != null) {
                    AlaLiveMultiBeautyView.this.gfM.v(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hvK = (SeekBar) findViewById(a.f.face_level_skin_seekbar);
        this.hvK.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hvH.aED = i;
                if (AlaLiveMultiBeautyView.this.gfM != null) {
                    AlaLiveMultiBeautyView.this.gfM.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hvL = (SeekBar) findViewById(a.f.face_shape_thin_level_seekbar);
        this.hvL.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hvH.aEF = i;
                if (AlaLiveMultiBeautyView.this.gfM != null) {
                    AlaLiveMultiBeautyView.this.gfM.t(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hvM = (SeekBar) findViewById(a.f.face_shape_eye_level_seekbar);
        this.hvM.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hvH.aEE = i;
                if (AlaLiveMultiBeautyView.this.gfM != null) {
                    AlaLiveMultiBeautyView.this.gfM.u(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hvF = findViewById(a.f.ala_live_new_beauty_nav_view);
        findViewById(a.f.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.CA();
                if (AlaLiveMultiBeautyView.this.gfM != null) {
                    AlaLiveMultiBeautyView.this.gfM.CB();
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
    public void Cz() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void CA() {
        if (this.hvH != null) {
            com.baidu.live.d.AZ().putString("ala_beauty_5.4_config_str", this.hvH.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(j jVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bmK = bdPageContext;
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
        if (this.gfK && this.hvB.getWidth() != 0) {
            i(this.hvB, false);
            this.gfK = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hvB) {
            i(this.hvB, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hvB);
            if (this.hvx != null) {
                setEffectFilterBeautyChooseBlock(this.hvx);
            } else if (this.hvG != null) {
                setEffectFilterBeautyChooseBlock(this.hvG);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_filter));
            }
        } else if (view == this.hvC) {
            i(this.hvC, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hvC);
            setEffectFilterBeautyChooseBlock(this.hvz);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.hvD) {
            i(this.hvD, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hvD);
            setEffectFilterBeautyChooseBlock(this.hvA);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_beauty));
            }
        } else if (view == this.hvE) {
            i(this.hvE, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hvE);
            setEffectFilterBeautyChooseBlock(this.hvA);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.hvx != null) {
            this.hvx.setVisibility(4);
        }
        if (this.hvG != null) {
            this.hvG.setVisibility(4);
        }
        this.hvz.setVisibility(4);
        this.hvA.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.hvB.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.hvC.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.hvD.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(l lVar) {
        this.gfM = lVar;
    }

    private void i(View view, boolean z) {
        this.hvF.clearAnimation();
        int width = (this.hvF.getWidth() / 2) + this.hvF.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hvF.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.hvF.getWidth() / 2);
        this.hvF.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.hvF.startAnimation(translateAnimation);
        }
    }

    public void setViewData(k kVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (kVar != null && alaLiveVideoConfig != null) {
            com.baidu.live.ar.e eVar = (com.baidu.live.ar.e) kVar;
            this.hvI.setProgress(eVar.aEB);
            this.hvJ.setProgress(eVar.aEC);
            this.hvK.setProgress(eVar.aED);
            this.hvL.setProgress(eVar.aEF);
            this.hvM.setProgress(eVar.aEE);
            this.hvy.HW(eVar.mFilterName);
            this.hvy.notifyDataSetChanged();
            this.hvH = eVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.hvC.setVisibility(0);
            } else {
                this.hvC.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
