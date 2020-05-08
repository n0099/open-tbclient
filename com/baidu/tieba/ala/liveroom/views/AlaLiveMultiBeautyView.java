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
    private BdPageContext aOl;
    private LinearLayout eNa;
    private Button eNb;
    private Button eNc;
    private Button eNd;
    private View eNe;
    private boolean eNf;
    private h eNh;
    private HListView fRG;
    private com.baidu.tieba.ala.liveroom.g.c fRH;
    private LinearLayout fRI;
    private GridView fRJ;
    private com.baidu.tieba.ala.liveroom.data.d fRK;
    private SeekBar fRL;
    private SeekBar fRM;
    private SeekBar fRN;
    private SeekBar fRO;
    private SeekBar fRP;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.eNf = true;
        this.fRK = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eNf = true;
        this.fRK = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eNf = true;
        this.fRK = new com.baidu.tieba.ala.liveroom.data.d();
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
        this.fRG = (HListView) findViewById(a.g.filter_list_view);
        if (this.fRG != null) {
            this.fRH = new com.baidu.tieba.ala.liveroom.g.c(this.fRG);
            this.fRH.oV(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.fRG.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.fRG.setAdapter((ListAdapter) this.fRH);
            this.fRG.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.fRJ = (GridView) findViewById(a.g.filter_grid_view);
        if (this.fRJ != null) {
            this.fRH = new com.baidu.tieba.ala.liveroom.g.c(this.fRJ);
            this.fRJ.setAdapter((ListAdapter) this.fRH);
        }
        this.fRH.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.g.c.b
            public void onItemSelected(int i) {
                AlaLiveMultiBeautyView.this.fRK.mFilterName = AlaLiveMultiBeautyView.this.fRH.fEU[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.eNh != null) {
                    AlaLiveMultiBeautyView.this.eNh.onFilterSelected(AlaLiveMultiBeautyView.this.fRH.fEU[i].mFilterName, 0.0f);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.g.beauty_title_text);
        this.eNd = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.eNd.setOnClickListener(this);
        this.eNb = (Button) findViewById(a.g.btn_choose_filter);
        this.eNb.setOnClickListener(this);
        this.eNc = (Button) findViewById(a.g.btn_choose_face_shape);
        this.eNc.setOnClickListener(this);
        this.fRI = (LinearLayout) findViewById(a.g.live_face_shape);
        this.eNa = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.fRL = (SeekBar) findViewById(a.g.face_level_white_seekbar);
        this.fRL.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fRK.fFs = i;
                if (AlaLiveMultiBeautyView.this.eNh != null) {
                    AlaLiveMultiBeautyView.this.eNh.n(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fRM = (SeekBar) findViewById(a.g.face_level_red_seekbar);
        this.fRM.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fRK.fFt = i;
                if (AlaLiveMultiBeautyView.this.eNh != null) {
                    AlaLiveMultiBeautyView.this.eNh.q(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fRN = (SeekBar) findViewById(a.g.face_level_skin_seekbar);
        this.fRN.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fRK.fFu = i;
                if (AlaLiveMultiBeautyView.this.eNh != null) {
                    AlaLiveMultiBeautyView.this.eNh.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fRO = (SeekBar) findViewById(a.g.face_shape_thin_level_seekbar);
        this.fRO.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fRK.fFw = i;
                if (AlaLiveMultiBeautyView.this.eNh != null) {
                    AlaLiveMultiBeautyView.this.eNh.o(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fRP = (SeekBar) findViewById(a.g.face_shape_eye_level_seekbar);
        this.fRP.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.fRK.fFv = i;
                if (AlaLiveMultiBeautyView.this.eNh != null) {
                    AlaLiveMultiBeautyView.this.eNh.p(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eNe = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.tV();
                if (AlaLiveMultiBeautyView.this.eNh != null) {
                    AlaLiveMultiBeautyView.this.eNh.tW();
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
    public void tU() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void tV() {
        if (this.fRK != null) {
            com.baidu.live.c.tG().putString("ala_beauty_5.4_config_str", this.fRK.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(f fVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.aOl = bdPageContext;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.eNf && this.eNb.getWidth() != 0) {
            e(this.eNb, false);
            this.eNf = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eNb) {
            e(this.eNb, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eNb);
            if (this.fRG != null) {
                setEffectFilterBeautyChooseBlock(this.fRG);
            } else if (this.fRJ != null) {
                setEffectFilterBeautyChooseBlock(this.fRJ);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
        } else if (view == this.eNc) {
            e(this.eNc, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eNc);
            setEffectFilterBeautyChooseBlock(this.fRI);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.eNd) {
            e(this.eNd, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eNd);
            setEffectFilterBeautyChooseBlock(this.eNa);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.fRG != null) {
            this.fRG.setVisibility(4);
        }
        if (this.fRJ != null) {
            this.fRJ.setVisibility(4);
        }
        this.fRI.setVisibility(4);
        this.eNa.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.eNb.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.eNc.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.eNd.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(h hVar) {
        this.eNh = hVar;
    }

    private void e(View view, boolean z) {
        this.eNe.clearAnimation();
        int width = (this.eNe.getWidth() / 2) + this.eNe.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNe.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.eNe.getWidth() / 2);
        this.eNe.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.eNe.startAnimation(translateAnimation);
        }
    }

    public void setViewData(g gVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (gVar != null && alaLiveVideoConfig != null) {
            com.baidu.tieba.ala.liveroom.data.d dVar = (com.baidu.tieba.ala.liveroom.data.d) gVar;
            this.fRL.setProgress(dVar.fFs);
            this.fRM.setProgress(dVar.fFt);
            this.fRN.setProgress(dVar.fFu);
            this.fRO.setProgress(dVar.fFw);
            this.fRP.setProgress(dVar.fFv);
            this.fRH.zn(dVar.mFilterName);
            this.fRH.notifyDataSetChanged();
            this.fRK = dVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.eNc.setVisibility(0);
            } else {
                this.eNc.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
