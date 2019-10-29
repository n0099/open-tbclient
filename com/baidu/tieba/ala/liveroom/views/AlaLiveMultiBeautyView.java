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
import com.baidu.ala.liveRecorder.video.AlaLiveVideoConfig;
import com.baidu.live.k.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.liveroom.g.b;
import com.baidu.tieba.ala.liveroom.g.c;
/* loaded from: classes6.dex */
public class AlaLiveMultiBeautyView extends LinearLayout implements View.OnClickListener {
    private HListView eqJ;
    private com.baidu.tieba.ala.liveroom.g.c eqK;
    private LinearLayout eqL;
    private LinearLayout eqM;
    private Button eqN;
    private Button eqO;
    private Button eqP;
    private View eqQ;
    private GridView eqR;
    private boolean eqS;
    private com.baidu.tieba.ala.liveroom.data.c eqT;
    private SeekBar eqU;
    private SeekBar eqV;
    private SeekBar eqW;
    private SeekBar eqX;
    private SeekBar eqY;
    private b.a eqZ;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.eqS = true;
        this.eqT = new com.baidu.tieba.ala.liveroom.data.c();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eqS = true;
        this.eqT = new com.baidu.tieba.ala.liveroom.data.c();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eqS = true;
        this.eqT = new com.baidu.tieba.ala.liveroom.data.c();
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
        this.eqJ = (HListView) findViewById(a.g.filter_list_view);
        if (this.eqJ != null) {
            this.eqK = new com.baidu.tieba.ala.liveroom.g.c(this.eqJ);
            this.eqK.nw(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.eqJ.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.eqJ.setAdapter((ListAdapter) this.eqK);
            this.eqJ.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.eqR = (GridView) findViewById(a.g.filter_grid_view);
        if (this.eqR != null) {
            this.eqK = new com.baidu.tieba.ala.liveroom.g.c(this.eqR);
            this.eqR.setAdapter((ListAdapter) this.eqK);
        }
        this.eqK.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.g.c.b
            public void li(int i) {
                AlaLiveMultiBeautyView.this.eqT.mFilterName = AlaLiveMultiBeautyView.this.eqK.efj[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.eqZ != null) {
                    AlaLiveMultiBeautyView.this.eqZ.onFilterSelected(AlaLiveMultiBeautyView.this.eqK.efj[i].mFilterName);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.g.beauty_title_text);
        this.eqP = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.eqP.setOnClickListener(this);
        this.eqN = (Button) findViewById(a.g.btn_choose_filter);
        this.eqN.setOnClickListener(this);
        this.eqO = (Button) findViewById(a.g.btn_choose_face_shape);
        this.eqO.setOnClickListener(this);
        this.eqL = (LinearLayout) findViewById(a.g.live_face_shape);
        this.eqM = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.eqU = (SeekBar) findViewById(a.g.face_level_white_seekbar);
        this.eqU.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.eqT.efK = i;
                if (AlaLiveMultiBeautyView.this.eqZ != null) {
                    AlaLiveMultiBeautyView.this.eqZ.aY(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eqV = (SeekBar) findViewById(a.g.face_level_red_seekbar);
        this.eqV.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.eqT.efL = i;
                if (AlaLiveMultiBeautyView.this.eqZ != null) {
                    AlaLiveMultiBeautyView.this.eqZ.bb(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eqW = (SeekBar) findViewById(a.g.face_level_skin_seekbar);
        this.eqW.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.eqT.efM = i;
                if (AlaLiveMultiBeautyView.this.eqZ != null) {
                    AlaLiveMultiBeautyView.this.eqZ.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eqX = (SeekBar) findViewById(a.g.face_shape_thin_level_seekbar);
        this.eqX.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.eqT.efO = i;
                if (AlaLiveMultiBeautyView.this.eqZ != null) {
                    AlaLiveMultiBeautyView.this.eqZ.aZ(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eqY = (SeekBar) findViewById(a.g.face_shape_eye_level_seekbar);
        this.eqY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.eqT.efN = i;
                if (AlaLiveMultiBeautyView.this.eqZ != null) {
                    AlaLiveMultiBeautyView.this.eqZ.ba(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eqQ = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.aWx();
                if (AlaLiveMultiBeautyView.this.eqZ != null) {
                    AlaLiveMultiBeautyView.this.eqZ.aRy();
                    return true;
                }
                return true;
            }
        });
    }

    public void aWx() {
        if (this.eqT != null) {
            com.baidu.live.c.np().putString("ala_beauty_5.4_config_str", this.eqT.toJsonString());
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.eqS && this.eqN.getWidth() != 0) {
            f(this.eqN, false);
            this.eqS = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eqN) {
            f(this.eqN, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eqN);
            if (this.eqJ != null) {
                setEffectFilterBeautyChooseBlock(this.eqJ);
            } else if (this.eqR != null) {
                setEffectFilterBeautyChooseBlock(this.eqR);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
        } else if (view == this.eqO) {
            f(this.eqO, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eqO);
            setEffectFilterBeautyChooseBlock(this.eqL);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.eqP) {
            f(this.eqP, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eqP);
            setEffectFilterBeautyChooseBlock(this.eqM);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.eqJ != null) {
            this.eqJ.setVisibility(4);
        }
        if (this.eqR != null) {
            this.eqR.setVisibility(4);
        }
        this.eqL.setVisibility(4);
        this.eqM.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.eqN.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.eqO.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.eqP.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    public void setOnEffectSelectedListener(b.a aVar) {
        this.eqZ = aVar;
    }

    private void f(View view, boolean z) {
        this.eqQ.clearAnimation();
        int width = (this.eqQ.getWidth() / 2) + this.eqQ.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eqQ.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.eqQ.getWidth() / 2);
        this.eqQ.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.eqQ.startAnimation(translateAnimation);
        }
    }

    public void setViewData(com.baidu.tieba.ala.liveroom.data.c cVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (cVar != null && alaLiveVideoConfig != null) {
            this.eqU.setProgress(cVar.efK);
            this.eqV.setProgress(cVar.efL);
            this.eqW.setProgress(cVar.efM);
            this.eqX.setProgress(cVar.efO);
            this.eqY.setProgress(cVar.efN);
            this.eqK.tG(cVar.mFilterName);
            this.eqK.notifyDataSetChanged();
            this.eqT = cVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.eqO.setVisibility(0);
            } else {
                this.eqO.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
