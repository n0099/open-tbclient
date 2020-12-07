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
    private BdPageContext bqi;
    private l gnB;
    private boolean gnz;
    private HListView hEH;
    private com.baidu.tieba.ala.liveroom.h.c hEI;
    private LinearLayout hEJ;
    private LinearLayout hEK;
    private Button hEL;
    private Button hEM;
    private Button hEN;
    private Button hEO;
    private View hEP;
    private GridView hEQ;
    private com.baidu.live.ar.e hER;
    private SeekBar hES;
    private SeekBar hET;
    private SeekBar hEU;
    private SeekBar hEV;
    private SeekBar hEW;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.gnz = true;
        this.hER = new com.baidu.live.ar.e();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gnz = true;
        this.hER = new com.baidu.live.ar.e();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gnz = true;
        this.hER = new com.baidu.live.ar.e();
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
        this.hEH = (HListView) findViewById(a.f.filter_list_view);
        if (this.hEH != null) {
            this.hEI = new com.baidu.tieba.ala.liveroom.h.c(this.hEH);
            this.hEI.uK(getResources().getDimensionPixelSize(a.d.sdk_ds34));
            this.hEH.setDividerWidth(getResources().getDimensionPixelSize(a.d.sdk_ds34));
            this.hEH.setAdapter((ListAdapter) this.hEI);
            this.hEH.setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        }
        this.hEQ = (GridView) findViewById(a.f.filter_grid_view);
        if (this.hEQ != null) {
            this.hEI = new com.baidu.tieba.ala.liveroom.h.c(this.hEQ);
            this.hEQ.setAdapter((ListAdapter) this.hEI);
        }
        this.hEI.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.h.c.b
            public void onItemSelected(int i) {
                AlaLiveMultiBeautyView.this.hER.mFilterName = AlaLiveMultiBeautyView.this.hEI.hpE[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.gnB != null) {
                    AlaLiveMultiBeautyView.this.gnB.onFilterSelected(AlaLiveMultiBeautyView.this.hEI.hpE[i].god, AlaLiveMultiBeautyView.this.hEI.hpE[i].mFilterName, 0.0f);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.f.beauty_title_text);
        this.hEN = (Button) findViewById(a.f.btn_choose_beauty_level);
        this.hEN.setOnClickListener(this);
        this.hEO.setOnClickListener(this);
        this.hEL = (Button) findViewById(a.f.btn_choose_filter);
        this.hEL.setOnClickListener(this);
        this.hEM = (Button) findViewById(a.f.btn_choose_face_shape);
        this.hEM.setOnClickListener(this);
        this.hEJ = (LinearLayout) findViewById(a.f.live_face_shape);
        this.hEK = (LinearLayout) findViewById(a.f.face_beauty_level_select_layout);
        this.hES = (SeekBar) findViewById(a.f.face_level_white_seekbar);
        this.hES.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hER.aFw = i;
                if (AlaLiveMultiBeautyView.this.gnB != null) {
                    AlaLiveMultiBeautyView.this.gnB.t(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hET = (SeekBar) findViewById(a.f.face_level_red_seekbar);
        this.hET.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hER.aFx = i;
                if (AlaLiveMultiBeautyView.this.gnB != null) {
                    AlaLiveMultiBeautyView.this.gnB.w(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hEU = (SeekBar) findViewById(a.f.face_level_skin_seekbar);
        this.hEU.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hER.aFy = i;
                if (AlaLiveMultiBeautyView.this.gnB != null) {
                    AlaLiveMultiBeautyView.this.gnB.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hEV = (SeekBar) findViewById(a.f.face_shape_thin_level_seekbar);
        this.hEV.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hER.aFA = i;
                if (AlaLiveMultiBeautyView.this.gnB != null) {
                    AlaLiveMultiBeautyView.this.gnB.u(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hEW = (SeekBar) findViewById(a.f.face_shape_eye_level_seekbar);
        this.hEW.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hER.aFz = i;
                if (AlaLiveMultiBeautyView.this.gnB != null) {
                    AlaLiveMultiBeautyView.this.gnB.v(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hEP = findViewById(a.f.ala_live_new_beauty_nav_view);
        findViewById(a.f.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.DB();
                if (AlaLiveMultiBeautyView.this.gnB != null) {
                    AlaLiveMultiBeautyView.this.gnB.DC();
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
    public void DA() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void DB() {
        if (this.hER != null) {
            com.baidu.live.d.BM().putString("ala_beauty_5.4_config_str", this.hER.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(j jVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bqi = bdPageContext;
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
        if (this.gnz && this.hEL.getWidth() != 0) {
            j(this.hEL, false);
            this.gnz = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hEL) {
            j(this.hEL, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hEL);
            if (this.hEH != null) {
                setEffectFilterBeautyChooseBlock(this.hEH);
            } else if (this.hEQ != null) {
                setEffectFilterBeautyChooseBlock(this.hEQ);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_filter));
            }
        } else if (view == this.hEM) {
            j(this.hEM, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hEM);
            setEffectFilterBeautyChooseBlock(this.hEJ);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.hEN) {
            j(this.hEN, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hEN);
            setEffectFilterBeautyChooseBlock(this.hEK);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_beauty));
            }
        } else if (view == this.hEO) {
            j(this.hEO, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hEO);
            setEffectFilterBeautyChooseBlock(this.hEK);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.hEH != null) {
            this.hEH.setVisibility(4);
        }
        if (this.hEQ != null) {
            this.hEQ.setVisibility(4);
        }
        this.hEJ.setVisibility(4);
        this.hEK.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.hEL.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.hEM.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.hEN.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(l lVar) {
        this.gnB = lVar;
    }

    private void j(View view, boolean z) {
        this.hEP.clearAnimation();
        int width = (this.hEP.getWidth() / 2) + this.hEP.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hEP.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.hEP.getWidth() / 2);
        this.hEP.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.hEP.startAnimation(translateAnimation);
        }
    }

    public void setViewData(k kVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (kVar != null && alaLiveVideoConfig != null) {
            com.baidu.live.ar.e eVar = (com.baidu.live.ar.e) kVar;
            this.hES.setProgress(eVar.aFw);
            this.hET.setProgress(eVar.aFx);
            this.hEU.setProgress(eVar.aFy);
            this.hEV.setProgress(eVar.aFA);
            this.hEW.setProgress(eVar.aFz);
            this.hEI.Im(eVar.mFilterName);
            this.hEI.notifyDataSetChanged();
            this.hER = eVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.hEM.setVisibility(0);
            } else {
                this.hEM.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
