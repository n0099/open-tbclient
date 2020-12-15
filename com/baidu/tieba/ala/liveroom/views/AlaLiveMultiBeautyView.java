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
    private boolean gnB;
    private l gnD;
    private HListView hEJ;
    private com.baidu.tieba.ala.liveroom.h.c hEK;
    private LinearLayout hEL;
    private LinearLayout hEM;
    private Button hEN;
    private Button hEO;
    private Button hEP;
    private Button hEQ;
    private View hER;
    private GridView hES;
    private com.baidu.live.ar.e hET;
    private SeekBar hEU;
    private SeekBar hEV;
    private SeekBar hEW;
    private SeekBar hEX;
    private SeekBar hEY;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.gnB = true;
        this.hET = new com.baidu.live.ar.e();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gnB = true;
        this.hET = new com.baidu.live.ar.e();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gnB = true;
        this.hET = new com.baidu.live.ar.e();
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
        this.hEJ = (HListView) findViewById(a.f.filter_list_view);
        if (this.hEJ != null) {
            this.hEK = new com.baidu.tieba.ala.liveroom.h.c(this.hEJ);
            this.hEK.uK(getResources().getDimensionPixelSize(a.d.sdk_ds34));
            this.hEJ.setDividerWidth(getResources().getDimensionPixelSize(a.d.sdk_ds34));
            this.hEJ.setAdapter((ListAdapter) this.hEK);
            this.hEJ.setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        }
        this.hES = (GridView) findViewById(a.f.filter_grid_view);
        if (this.hES != null) {
            this.hEK = new com.baidu.tieba.ala.liveroom.h.c(this.hES);
            this.hES.setAdapter((ListAdapter) this.hEK);
        }
        this.hEK.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.h.c.b
            public void onItemSelected(int i) {
                AlaLiveMultiBeautyView.this.hET.mFilterName = AlaLiveMultiBeautyView.this.hEK.hpG[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.gnD != null) {
                    AlaLiveMultiBeautyView.this.gnD.onFilterSelected(AlaLiveMultiBeautyView.this.hEK.hpG[i].gof, AlaLiveMultiBeautyView.this.hEK.hpG[i].mFilterName, 0.0f);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.f.beauty_title_text);
        this.hEP = (Button) findViewById(a.f.btn_choose_beauty_level);
        this.hEP.setOnClickListener(this);
        this.hEQ.setOnClickListener(this);
        this.hEN = (Button) findViewById(a.f.btn_choose_filter);
        this.hEN.setOnClickListener(this);
        this.hEO = (Button) findViewById(a.f.btn_choose_face_shape);
        this.hEO.setOnClickListener(this);
        this.hEL = (LinearLayout) findViewById(a.f.live_face_shape);
        this.hEM = (LinearLayout) findViewById(a.f.face_beauty_level_select_layout);
        this.hEU = (SeekBar) findViewById(a.f.face_level_white_seekbar);
        this.hEU.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hET.aFw = i;
                if (AlaLiveMultiBeautyView.this.gnD != null) {
                    AlaLiveMultiBeautyView.this.gnD.t(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hEV = (SeekBar) findViewById(a.f.face_level_red_seekbar);
        this.hEV.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hET.aFx = i;
                if (AlaLiveMultiBeautyView.this.gnD != null) {
                    AlaLiveMultiBeautyView.this.gnD.w(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hEW = (SeekBar) findViewById(a.f.face_level_skin_seekbar);
        this.hEW.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hET.aFy = i;
                if (AlaLiveMultiBeautyView.this.gnD != null) {
                    AlaLiveMultiBeautyView.this.gnD.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hEX = (SeekBar) findViewById(a.f.face_shape_thin_level_seekbar);
        this.hEX.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hET.aFA = i;
                if (AlaLiveMultiBeautyView.this.gnD != null) {
                    AlaLiveMultiBeautyView.this.gnD.u(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hEY = (SeekBar) findViewById(a.f.face_shape_eye_level_seekbar);
        this.hEY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hET.aFz = i;
                if (AlaLiveMultiBeautyView.this.gnD != null) {
                    AlaLiveMultiBeautyView.this.gnD.v(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hER = findViewById(a.f.ala_live_new_beauty_nav_view);
        findViewById(a.f.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.DB();
                if (AlaLiveMultiBeautyView.this.gnD != null) {
                    AlaLiveMultiBeautyView.this.gnD.DC();
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
        if (this.hET != null) {
            com.baidu.live.d.BM().putString("ala_beauty_5.4_config_str", this.hET.toJsonString());
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
        if (this.gnB && this.hEN.getWidth() != 0) {
            j(this.hEN, false);
            this.gnB = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hEN) {
            j(this.hEN, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hEN);
            if (this.hEJ != null) {
                setEffectFilterBeautyChooseBlock(this.hEJ);
            } else if (this.hES != null) {
                setEffectFilterBeautyChooseBlock(this.hES);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_filter));
            }
        } else if (view == this.hEO) {
            j(this.hEO, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hEO);
            setEffectFilterBeautyChooseBlock(this.hEL);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.hEP) {
            j(this.hEP, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hEP);
            setEffectFilterBeautyChooseBlock(this.hEM);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_beauty));
            }
        } else if (view == this.hEQ) {
            j(this.hEQ, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hEQ);
            setEffectFilterBeautyChooseBlock(this.hEM);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.hEJ != null) {
            this.hEJ.setVisibility(4);
        }
        if (this.hES != null) {
            this.hES.setVisibility(4);
        }
        this.hEL.setVisibility(4);
        this.hEM.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.hEN.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.hEO.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.hEP.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(l lVar) {
        this.gnD = lVar;
    }

    private void j(View view, boolean z) {
        this.hER.clearAnimation();
        int width = (this.hER.getWidth() / 2) + this.hER.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hER.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.hER.getWidth() / 2);
        this.hER.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.hER.startAnimation(translateAnimation);
        }
    }

    public void setViewData(k kVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (kVar != null && alaLiveVideoConfig != null) {
            com.baidu.live.ar.e eVar = (com.baidu.live.ar.e) kVar;
            this.hEU.setProgress(eVar.aFw);
            this.hEV.setProgress(eVar.aFx);
            this.hEW.setProgress(eVar.aFy);
            this.hEX.setProgress(eVar.aFA);
            this.hEY.setProgress(eVar.aFz);
            this.hEK.Im(eVar.mFilterName);
            this.hEK.notifyDataSetChanged();
            this.hET = eVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.hEO.setVisibility(0);
            } else {
                this.hEO.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
