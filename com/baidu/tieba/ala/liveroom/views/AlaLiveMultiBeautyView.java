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
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.g.c;
/* loaded from: classes3.dex */
public class AlaLiveMultiBeautyView extends ILiveMultiBeautyView implements View.OnClickListener {
    private GridView fmA;
    private boolean fmB;
    private com.baidu.tieba.ala.liveroom.data.d fmC;
    private SeekBar fmD;
    private SeekBar fmE;
    private SeekBar fmF;
    private SeekBar fmG;
    private SeekBar fmH;
    private com.baidu.live.ar.e fmI;
    private BdPageContext fmJ;
    private HListView fms;
    private com.baidu.tieba.ala.liveroom.g.c fmt;
    private LinearLayout fmu;
    private LinearLayout fmv;
    private Button fmw;
    private Button fmx;
    private Button fmy;
    private View fmz;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.fmB = true;
        this.fmC = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmB = true;
        this.fmC = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fmB = true;
        this.fmC = new com.baidu.tieba.ala.liveroom.data.d();
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
        this.fms = (HListView) findViewById(a.g.filter_list_view);
        if (this.fms != null) {
            this.fmt = new com.baidu.tieba.ala.liveroom.g.c(this.fms);
            this.fmt.pW(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.fms.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.fms.setAdapter((ListAdapter) this.fmt);
            this.fms.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fmA = (GridView) findViewById(a.g.filter_grid_view);
        if (this.fmA != null) {
            this.fmt = new com.baidu.tieba.ala.liveroom.g.c(this.fmA);
            this.fmA.setAdapter((ListAdapter) this.fmt);
        }
        this.fmt.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.g.c.b
            public void onItemSelected(int i) {
                AlaLiveMultiBeautyView.this.fmC.mFilterName = AlaLiveMultiBeautyView.this.fmt.eZR[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.fmI != null) {
                    AlaLiveMultiBeautyView.this.fmI.onFilterSelected(AlaLiveMultiBeautyView.this.fmt.eZR[i].mFilterName);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.g.beauty_title_text);
        this.fmy = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.fmy.setOnClickListener(this);
        this.fmw = (Button) findViewById(a.g.btn_choose_filter);
        this.fmw.setOnClickListener(this);
        this.fmx = (Button) findViewById(a.g.btn_choose_face_shape);
        this.fmx.setOnClickListener(this);
        this.fmu = (LinearLayout) findViewById(a.g.live_face_shape);
        this.fmv = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.fmD = (SeekBar) findViewById(a.g.face_level_white_seekbar);
        this.fmD.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fmC.fat = i;
                if (AlaLiveMultiBeautyView.this.fmI != null) {
                    AlaLiveMultiBeautyView.this.fmI.o(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fmE = (SeekBar) findViewById(a.g.face_level_red_seekbar);
        this.fmE.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fmC.fau = i;
                if (AlaLiveMultiBeautyView.this.fmI != null) {
                    AlaLiveMultiBeautyView.this.fmI.r(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fmF = (SeekBar) findViewById(a.g.face_level_skin_seekbar);
        this.fmF.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fmC.fav = i;
                if (AlaLiveMultiBeautyView.this.fmI != null) {
                    AlaLiveMultiBeautyView.this.fmI.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fmG = (SeekBar) findViewById(a.g.face_shape_thin_level_seekbar);
        this.fmG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fmC.fax = i;
                if (AlaLiveMultiBeautyView.this.fmI != null) {
                    AlaLiveMultiBeautyView.this.fmI.p(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fmH = (SeekBar) findViewById(a.g.face_shape_eye_level_seekbar);
        this.fmH.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fmC.faw = i;
                if (AlaLiveMultiBeautyView.this.fmI != null) {
                    AlaLiveMultiBeautyView.this.fmI.q(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fmz = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.pC();
                if (AlaLiveMultiBeautyView.this.fmI != null) {
                    AlaLiveMultiBeautyView.this.fmI.pD();
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
    public void pB() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void pC() {
        if (this.fmC != null) {
            com.baidu.live.c.pr().putString("ala_beauty_5.4_config_str", this.fmC.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(com.baidu.live.ar.c cVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.fmJ = bdPageContext;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.fmB && this.fmw.getWidth() != 0) {
            f(this.fmw, false);
            this.fmB = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fmw) {
            f(this.fmw, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fmw);
            if (this.fms != null) {
                setEffectFilterBeautyChooseBlock(this.fms);
            } else if (this.fmA != null) {
                setEffectFilterBeautyChooseBlock(this.fmA);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
        } else if (view == this.fmx) {
            f(this.fmx, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fmx);
            setEffectFilterBeautyChooseBlock(this.fmu);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.fmy) {
            f(this.fmy, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fmy);
            setEffectFilterBeautyChooseBlock(this.fmv);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.fms != null) {
            this.fms.setVisibility(4);
        }
        if (this.fmA != null) {
            this.fmA.setVisibility(4);
        }
        this.fmu.setVisibility(4);
        this.fmv.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.fmw.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fmx.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fmy.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(com.baidu.live.ar.e eVar) {
        this.fmI = eVar;
    }

    private void f(View view, boolean z) {
        this.fmz.clearAnimation();
        int width = (this.fmz.getWidth() / 2) + this.fmz.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fmz.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.fmz.getWidth() / 2);
        this.fmz.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.fmz.startAnimation(translateAnimation);
        }
    }

    public void setViewData(com.baidu.live.ar.d dVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (dVar != null && alaLiveVideoConfig != null) {
            com.baidu.tieba.ala.liveroom.data.d dVar2 = (com.baidu.tieba.ala.liveroom.data.d) dVar;
            this.fmD.setProgress(dVar2.fat);
            this.fmE.setProgress(dVar2.fau);
            this.fmF.setProgress(dVar2.fav);
            this.fmG.setProgress(dVar2.fax);
            this.fmH.setProgress(dVar2.faw);
            this.fmt.yT(dVar2.mFilterName);
            this.fmt.notifyDataSetChanged();
            this.fmC = dVar2;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.fmx.setVisibility(0);
            } else {
                this.fmx.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
