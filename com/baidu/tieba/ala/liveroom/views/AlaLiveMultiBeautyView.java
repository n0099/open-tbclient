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
    private BdPageContext bgf;
    private LinearLayout fED;
    private Button fEH;
    private Button fEI;
    private Button fEJ;
    private View fEK;
    private boolean fEL;
    private j fEN;
    private HListView gOM;
    private com.baidu.tieba.ala.liveroom.h.c gON;
    private LinearLayout gOO;
    private GridView gOP;
    private com.baidu.tieba.ala.liveroom.data.d gOQ;
    private SeekBar gOR;
    private SeekBar gOS;
    private SeekBar gOT;
    private SeekBar gOU;
    private SeekBar gOV;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.fEL = true;
        this.gOQ = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fEL = true;
        this.gOQ = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fEL = true;
        this.gOQ = new com.baidu.tieba.ala.liveroom.data.d();
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
        this.gOM = (HListView) findViewById(a.g.filter_list_view);
        if (this.gOM != null) {
            this.gON = new com.baidu.tieba.ala.liveroom.h.c(this.gOM);
            this.gON.sP(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.gOM.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.gOM.setAdapter((ListAdapter) this.gON);
            this.gOM.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.gOP = (GridView) findViewById(a.g.filter_grid_view);
        if (this.gOP != null) {
            this.gON = new com.baidu.tieba.ala.liveroom.h.c(this.gOP);
            this.gOP.setAdapter((ListAdapter) this.gON);
        }
        this.gON.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.h.c.b
            public void onItemSelected(int i) {
                AlaLiveMultiBeautyView.this.gOQ.mFilterName = AlaLiveMultiBeautyView.this.gON.gAh[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.fEN != null) {
                    AlaLiveMultiBeautyView.this.fEN.onFilterSelected(AlaLiveMultiBeautyView.this.gON.gAh[i].mShowName, AlaLiveMultiBeautyView.this.gON.gAh[i].mFilterName, 0.0f);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.g.beauty_title_text);
        this.fEJ = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.fEJ.setOnClickListener(this);
        this.fEH = (Button) findViewById(a.g.btn_choose_filter);
        this.fEH.setOnClickListener(this);
        this.fEI = (Button) findViewById(a.g.btn_choose_face_shape);
        this.fEI.setOnClickListener(this);
        this.gOO = (LinearLayout) findViewById(a.g.live_face_shape);
        this.fED = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.gOR = (SeekBar) findViewById(a.g.face_level_white_seekbar);
        this.gOR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gOQ.gAE = i;
                if (AlaLiveMultiBeautyView.this.fEN != null) {
                    AlaLiveMultiBeautyView.this.fEN.s(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gOS = (SeekBar) findViewById(a.g.face_level_red_seekbar);
        this.gOS.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gOQ.gAF = i;
                if (AlaLiveMultiBeautyView.this.fEN != null) {
                    AlaLiveMultiBeautyView.this.fEN.v(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gOT = (SeekBar) findViewById(a.g.face_level_skin_seekbar);
        this.gOT.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gOQ.gAG = i;
                if (AlaLiveMultiBeautyView.this.fEN != null) {
                    AlaLiveMultiBeautyView.this.fEN.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gOU = (SeekBar) findViewById(a.g.face_shape_thin_level_seekbar);
        this.gOU.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gOQ.gAI = i;
                if (AlaLiveMultiBeautyView.this.fEN != null) {
                    AlaLiveMultiBeautyView.this.fEN.t(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gOV = (SeekBar) findViewById(a.g.face_shape_eye_level_seekbar);
        this.gOV.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gOQ.gAH = i;
                if (AlaLiveMultiBeautyView.this.fEN != null) {
                    AlaLiveMultiBeautyView.this.fEN.u(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fEK = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.Bk();
                if (AlaLiveMultiBeautyView.this.fEN != null) {
                    AlaLiveMultiBeautyView.this.fEN.Bl();
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
    public void Bj() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void Bk() {
        if (this.gOQ != null) {
            com.baidu.live.c.AR().putString("ala_beauty_5.4_config_str", this.gOQ.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(h hVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bgf = bdPageContext;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.fEL && this.fEH.getWidth() != 0) {
            g(this.fEH, false);
            this.fEL = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fEH) {
            g(this.fEH, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fEH);
            if (this.gOM != null) {
                setEffectFilterBeautyChooseBlock(this.gOM);
            } else if (this.gOP != null) {
                setEffectFilterBeautyChooseBlock(this.gOP);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
        } else if (view == this.fEI) {
            g(this.fEI, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fEI);
            setEffectFilterBeautyChooseBlock(this.gOO);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.fEJ) {
            g(this.fEJ, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fEJ);
            setEffectFilterBeautyChooseBlock(this.fED);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.gOM != null) {
            this.gOM.setVisibility(4);
        }
        if (this.gOP != null) {
            this.gOP.setVisibility(4);
        }
        this.gOO.setVisibility(4);
        this.fED.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.fEH.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fEI.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fEJ.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(j jVar) {
        this.fEN = jVar;
    }

    private void g(View view, boolean z) {
        this.fEK.clearAnimation();
        int width = (this.fEK.getWidth() / 2) + this.fEK.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fEK.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.fEK.getWidth() / 2);
        this.fEK.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.fEK.startAnimation(translateAnimation);
        }
    }

    public void setViewData(i iVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (iVar != null && alaLiveVideoConfig != null) {
            com.baidu.tieba.ala.liveroom.data.d dVar = (com.baidu.tieba.ala.liveroom.data.d) iVar;
            this.gOR.setProgress(dVar.gAE);
            this.gOS.setProgress(dVar.gAF);
            this.gOT.setProgress(dVar.gAG);
            this.gOU.setProgress(dVar.gAI);
            this.gOV.setProgress(dVar.gAH);
            this.gON.EQ(dVar.mFilterName);
            this.gON.notifyDataSetChanged();
            this.gOQ = dVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.fEI.setVisibility(0);
            } else {
                this.fEI.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
