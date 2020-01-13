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
import com.baidu.live.r.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.liveroom.h.c;
/* loaded from: classes2.dex */
public class AlaLiveMultiBeautyView extends ILiveMultiBeautyView implements View.OnClickListener {
    private LinearLayout fjA;
    private Button fjB;
    private Button fjC;
    private Button fjD;
    private View fjE;
    private GridView fjF;
    private boolean fjG;
    private com.baidu.tieba.ala.liveroom.data.d fjH;
    private SeekBar fjI;
    private SeekBar fjJ;
    private SeekBar fjK;
    private SeekBar fjL;
    private SeekBar fjM;
    private com.baidu.live.ar.e fjN;
    private BdPageContext fjO;
    private HListView fjx;
    private com.baidu.tieba.ala.liveroom.h.c fjy;
    private LinearLayout fjz;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.fjG = true;
        this.fjH = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fjG = true;
        this.fjH = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fjG = true;
        this.fjH = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    protected void initViews() {
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
        this.fjx = (HListView) findViewById(a.g.filter_list_view);
        if (this.fjx != null) {
            this.fjy = new com.baidu.tieba.ala.liveroom.h.c(this.fjx);
            this.fjy.pO(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.fjx.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.fjx.setAdapter((ListAdapter) this.fjy);
            this.fjx.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fjF = (GridView) findViewById(a.g.filter_grid_view);
        if (this.fjF != null) {
            this.fjy = new com.baidu.tieba.ala.liveroom.h.c(this.fjF);
            this.fjF.setAdapter((ListAdapter) this.fjy);
        }
        this.fjy.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.h.c.b
            public void onItemSelected(int i) {
                AlaLiveMultiBeautyView.this.fjH.mFilterName = AlaLiveMultiBeautyView.this.fjy.eWa[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.fjN != null) {
                    AlaLiveMultiBeautyView.this.fjN.onFilterSelected(AlaLiveMultiBeautyView.this.fjy.eWa[i].mFilterName);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.g.beauty_title_text);
        this.fjD = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.fjD.setOnClickListener(this);
        this.fjB = (Button) findViewById(a.g.btn_choose_filter);
        this.fjB.setOnClickListener(this);
        this.fjC = (Button) findViewById(a.g.btn_choose_face_shape);
        this.fjC.setOnClickListener(this);
        this.fjz = (LinearLayout) findViewById(a.g.live_face_shape);
        this.fjA = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.fjI = (SeekBar) findViewById(a.g.face_level_white_seekbar);
        this.fjI.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fjH.eWD = i;
                if (AlaLiveMultiBeautyView.this.fjN != null) {
                    AlaLiveMultiBeautyView.this.fjN.n(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fjJ = (SeekBar) findViewById(a.g.face_level_red_seekbar);
        this.fjJ.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fjH.eWE = i;
                if (AlaLiveMultiBeautyView.this.fjN != null) {
                    AlaLiveMultiBeautyView.this.fjN.q(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fjK = (SeekBar) findViewById(a.g.face_level_skin_seekbar);
        this.fjK.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fjH.eWF = i;
                if (AlaLiveMultiBeautyView.this.fjN != null) {
                    AlaLiveMultiBeautyView.this.fjN.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fjL = (SeekBar) findViewById(a.g.face_shape_thin_level_seekbar);
        this.fjL.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fjH.eWH = i;
                if (AlaLiveMultiBeautyView.this.fjN != null) {
                    AlaLiveMultiBeautyView.this.fjN.o(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fjM = (SeekBar) findViewById(a.g.face_shape_eye_level_seekbar);
        this.fjM.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fjH.eWG = i;
                if (AlaLiveMultiBeautyView.this.fjN != null) {
                    AlaLiveMultiBeautyView.this.fjN.p(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fjE = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.oR();
                if (AlaLiveMultiBeautyView.this.fjN != null) {
                    AlaLiveMultiBeautyView.this.fjN.oS();
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
    public void oQ() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void oR() {
        if (this.fjH != null) {
            com.baidu.live.c.oJ().putString("ala_beauty_5.4_config_str", this.fjH.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(com.baidu.live.ar.c cVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.fjO = bdPageContext;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.fjG && this.fjB.getWidth() != 0) {
            f(this.fjB, false);
            this.fjG = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fjB) {
            f(this.fjB, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fjB);
            if (this.fjx != null) {
                setEffectFilterBeautyChooseBlock(this.fjx);
            } else if (this.fjF != null) {
                setEffectFilterBeautyChooseBlock(this.fjF);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
        } else if (view == this.fjC) {
            f(this.fjC, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fjC);
            setEffectFilterBeautyChooseBlock(this.fjz);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.fjD) {
            f(this.fjD, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fjD);
            setEffectFilterBeautyChooseBlock(this.fjA);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.fjx != null) {
            this.fjx.setVisibility(4);
        }
        if (this.fjF != null) {
            this.fjF.setVisibility(4);
        }
        this.fjz.setVisibility(4);
        this.fjA.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.fjB.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fjC.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fjD.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(com.baidu.live.ar.e eVar) {
        this.fjN = eVar;
    }

    private void f(View view, boolean z) {
        this.fjE.clearAnimation();
        int width = (this.fjE.getWidth() / 2) + this.fjE.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fjE.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.fjE.getWidth() / 2);
        this.fjE.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.fjE.startAnimation(translateAnimation);
        }
    }

    public void setViewData(com.baidu.live.ar.d dVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (dVar != null && alaLiveVideoConfig != null) {
            com.baidu.tieba.ala.liveroom.data.d dVar2 = (com.baidu.tieba.ala.liveroom.data.d) dVar;
            this.fjI.setProgress(dVar2.eWD);
            this.fjJ.setProgress(dVar2.eWE);
            this.fjK.setProgress(dVar2.eWF);
            this.fjL.setProgress(dVar2.eWH);
            this.fjM.setProgress(dVar2.eWG);
            this.fjy.yz(dVar2.mFilterName);
            this.fjy.notifyDataSetChanged();
            this.fjH = dVar2;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.fjC.setVisibility(0);
            } else {
                this.fjC.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
