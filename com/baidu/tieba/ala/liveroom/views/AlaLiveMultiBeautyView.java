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
import com.baidu.live.ar.h;
import com.baidu.live.ar.i;
import com.baidu.live.ar.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.liveroom.h.c;
/* loaded from: classes4.dex */
public class AlaLiveMultiBeautyView extends ILiveMultiBeautyView implements View.OnClickListener {
    private BdPageContext bjV;
    private LinearLayout fQM;
    private Button fQQ;
    private Button fQR;
    private Button fQS;
    private View fQT;
    private boolean fQU;
    private j fQW;
    private HListView hdJ;
    private com.baidu.tieba.ala.liveroom.h.c hdK;
    private LinearLayout hdL;
    private GridView hdM;
    private com.baidu.tieba.ala.liveroom.data.d hdN;
    private SeekBar hdO;
    private SeekBar hdP;
    private SeekBar hdQ;
    private SeekBar hdR;
    private SeekBar hdS;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.fQU = true;
        this.hdN = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fQU = true;
        this.hdN = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fQU = true;
        this.hdN = new com.baidu.tieba.ala.liveroom.data.d();
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
        this.hdJ = (HListView) findViewById(a.g.filter_list_view);
        if (this.hdJ != null) {
            this.hdK = new com.baidu.tieba.ala.liveroom.h.c(this.hdJ);
            this.hdK.tn(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.hdJ.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.hdJ.setAdapter((ListAdapter) this.hdK);
            this.hdJ.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.hdM = (GridView) findViewById(a.g.filter_grid_view);
        if (this.hdM != null) {
            this.hdK = new com.baidu.tieba.ala.liveroom.h.c(this.hdM);
            this.hdM.setAdapter((ListAdapter) this.hdK);
        }
        this.hdK.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.h.c.b
            public void onItemSelected(int i) {
                AlaLiveMultiBeautyView.this.hdN.mFilterName = AlaLiveMultiBeautyView.this.hdK.gOA[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.fQW != null) {
                    AlaLiveMultiBeautyView.this.fQW.onFilterSelected(AlaLiveMultiBeautyView.this.hdK.gOA[i].mShowName, AlaLiveMultiBeautyView.this.hdK.gOA[i].mFilterName, 0.0f);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.g.beauty_title_text);
        this.fQS = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.fQS.setOnClickListener(this);
        this.fQQ = (Button) findViewById(a.g.btn_choose_filter);
        this.fQQ.setOnClickListener(this);
        this.fQR = (Button) findViewById(a.g.btn_choose_face_shape);
        this.fQR.setOnClickListener(this);
        this.hdL = (LinearLayout) findViewById(a.g.live_face_shape);
        this.fQM = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.hdO = (SeekBar) findViewById(a.g.face_level_white_seekbar);
        this.hdO.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hdN.gOX = i;
                if (AlaLiveMultiBeautyView.this.fQW != null) {
                    AlaLiveMultiBeautyView.this.fQW.s(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hdP = (SeekBar) findViewById(a.g.face_level_red_seekbar);
        this.hdP.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hdN.gOY = i;
                if (AlaLiveMultiBeautyView.this.fQW != null) {
                    AlaLiveMultiBeautyView.this.fQW.v(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hdQ = (SeekBar) findViewById(a.g.face_level_skin_seekbar);
        this.hdQ.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hdN.gOZ = i;
                if (AlaLiveMultiBeautyView.this.fQW != null) {
                    AlaLiveMultiBeautyView.this.fQW.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hdR = (SeekBar) findViewById(a.g.face_shape_thin_level_seekbar);
        this.hdR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hdN.gPb = i;
                if (AlaLiveMultiBeautyView.this.fQW != null) {
                    AlaLiveMultiBeautyView.this.fQW.t(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hdS = (SeekBar) findViewById(a.g.face_shape_eye_level_seekbar);
        this.hdS.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hdN.gPa = i;
                if (AlaLiveMultiBeautyView.this.fQW != null) {
                    AlaLiveMultiBeautyView.this.fQW.u(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fQT = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.Ch();
                if (AlaLiveMultiBeautyView.this.fQW != null) {
                    AlaLiveMultiBeautyView.this.fQW.Ci();
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
    public void Cg() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void Ch() {
        if (this.hdN != null) {
            com.baidu.live.c.AZ().putString("ala_beauty_5.4_config_str", this.hdN.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(h hVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bjV = bdPageContext;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.fQU && this.fQQ.getWidth() != 0) {
            g(this.fQQ, false);
            this.fQU = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fQQ) {
            g(this.fQQ, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fQQ);
            if (this.hdJ != null) {
                setEffectFilterBeautyChooseBlock(this.hdJ);
            } else if (this.hdM != null) {
                setEffectFilterBeautyChooseBlock(this.hdM);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
        } else if (view == this.fQR) {
            g(this.fQR, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fQR);
            setEffectFilterBeautyChooseBlock(this.hdL);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.fQS) {
            g(this.fQS, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fQS);
            setEffectFilterBeautyChooseBlock(this.fQM);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.hdJ != null) {
            this.hdJ.setVisibility(4);
        }
        if (this.hdM != null) {
            this.hdM.setVisibility(4);
        }
        this.hdL.setVisibility(4);
        this.fQM.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.fQQ.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fQR.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fQS.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(j jVar) {
        this.fQW = jVar;
    }

    private void g(View view, boolean z) {
        this.fQT.clearAnimation();
        int width = (this.fQT.getWidth() / 2) + this.fQT.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fQT.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.fQT.getWidth() / 2);
        this.fQT.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.fQT.startAnimation(translateAnimation);
        }
    }

    public void setViewData(i iVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (iVar != null && alaLiveVideoConfig != null) {
            com.baidu.tieba.ala.liveroom.data.d dVar = (com.baidu.tieba.ala.liveroom.data.d) iVar;
            this.hdO.setProgress(dVar.gOX);
            this.hdP.setProgress(dVar.gOY);
            this.hdQ.setProgress(dVar.gOZ);
            this.hdR.setProgress(dVar.gPb);
            this.hdS.setProgress(dVar.gPa);
            this.hdK.FB(dVar.mFilterName);
            this.hdK.notifyDataSetChanged();
            this.hdN = dVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.fQR.setVisibility(0);
            } else {
                this.fQR.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
