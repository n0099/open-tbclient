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
    private BdPageContext bkZ;
    private boolean gfr;
    private l gft;
    private HListView hve;
    private com.baidu.tieba.ala.liveroom.h.c hvf;
    private LinearLayout hvg;
    private LinearLayout hvh;
    private Button hvi;
    private Button hvj;
    private Button hvk;
    private Button hvl;
    private View hvm;
    private GridView hvn;
    private com.baidu.live.ar.e hvo;
    private SeekBar hvp;
    private SeekBar hvq;
    private SeekBar hvr;
    private SeekBar hvs;
    private SeekBar hvt;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.gfr = true;
        this.hvo = new com.baidu.live.ar.e();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gfr = true;
        this.hvo = new com.baidu.live.ar.e();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gfr = true;
        this.hvo = new com.baidu.live.ar.e();
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
        this.hve = (HListView) findViewById(a.f.filter_list_view);
        if (this.hve != null) {
            this.hvf = new com.baidu.tieba.ala.liveroom.h.c(this.hve);
            this.hvf.ug(getResources().getDimensionPixelSize(a.d.sdk_ds34));
            this.hve.setDividerWidth(getResources().getDimensionPixelSize(a.d.sdk_ds34));
            this.hve.setAdapter((ListAdapter) this.hvf);
            this.hve.setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        }
        this.hvn = (GridView) findViewById(a.f.filter_grid_view);
        if (this.hvn != null) {
            this.hvf = new com.baidu.tieba.ala.liveroom.h.c(this.hvn);
            this.hvn.setAdapter((ListAdapter) this.hvf);
        }
        this.hvf.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.h.c.b
            public void onItemSelected(int i) {
                AlaLiveMultiBeautyView.this.hvo.mFilterName = AlaLiveMultiBeautyView.this.hvf.hfX[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.gft != null) {
                    AlaLiveMultiBeautyView.this.gft.onFilterSelected(AlaLiveMultiBeautyView.this.hvf.hfX[i].mShowName, AlaLiveMultiBeautyView.this.hvf.hfX[i].mFilterName, 0.0f);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.f.beauty_title_text);
        this.hvk = (Button) findViewById(a.f.btn_choose_beauty_level);
        this.hvk.setOnClickListener(this);
        this.hvl.setOnClickListener(this);
        this.hvi = (Button) findViewById(a.f.btn_choose_filter);
        this.hvi.setOnClickListener(this);
        this.hvj = (Button) findViewById(a.f.btn_choose_face_shape);
        this.hvj.setOnClickListener(this);
        this.hvg = (LinearLayout) findViewById(a.f.live_face_shape);
        this.hvh = (LinearLayout) findViewById(a.f.face_beauty_level_select_layout);
        this.hvp = (SeekBar) findViewById(a.f.face_level_white_seekbar);
        this.hvp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hvo.aCQ = i;
                if (AlaLiveMultiBeautyView.this.gft != null) {
                    AlaLiveMultiBeautyView.this.gft.s(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hvq = (SeekBar) findViewById(a.f.face_level_red_seekbar);
        this.hvq.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hvo.aCR = i;
                if (AlaLiveMultiBeautyView.this.gft != null) {
                    AlaLiveMultiBeautyView.this.gft.v(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hvr = (SeekBar) findViewById(a.f.face_level_skin_seekbar);
        this.hvr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hvo.aCS = i;
                if (AlaLiveMultiBeautyView.this.gft != null) {
                    AlaLiveMultiBeautyView.this.gft.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hvs = (SeekBar) findViewById(a.f.face_shape_thin_level_seekbar);
        this.hvs.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hvo.aCU = i;
                if (AlaLiveMultiBeautyView.this.gft != null) {
                    AlaLiveMultiBeautyView.this.gft.t(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hvt = (SeekBar) findViewById(a.f.face_shape_eye_level_seekbar);
        this.hvt.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hvo.aCT = i;
                if (AlaLiveMultiBeautyView.this.gft != null) {
                    AlaLiveMultiBeautyView.this.gft.u(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hvm = findViewById(a.f.ala_live_new_beauty_nav_view);
        findViewById(a.f.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.BR();
                if (AlaLiveMultiBeautyView.this.gft != null) {
                    AlaLiveMultiBeautyView.this.gft.BS();
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
    public void BQ() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void BR() {
        if (this.hvo != null) {
            com.baidu.live.d.Aq().putString("ala_beauty_5.4_config_str", this.hvo.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(j jVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bkZ = bdPageContext;
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
        if (this.gfr && this.hvi.getWidth() != 0) {
            j(this.hvi, false);
            this.gfr = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hvi) {
            j(this.hvi, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hvi);
            if (this.hve != null) {
                setEffectFilterBeautyChooseBlock(this.hve);
            } else if (this.hvn != null) {
                setEffectFilterBeautyChooseBlock(this.hvn);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_filter));
            }
        } else if (view == this.hvj) {
            j(this.hvj, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hvj);
            setEffectFilterBeautyChooseBlock(this.hvg);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.hvk) {
            j(this.hvk, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hvk);
            setEffectFilterBeautyChooseBlock(this.hvh);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_beauty));
            }
        } else if (view == this.hvl) {
            j(this.hvl, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hvl);
            setEffectFilterBeautyChooseBlock(this.hvh);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.hve != null) {
            this.hve.setVisibility(4);
        }
        if (this.hvn != null) {
            this.hvn.setVisibility(4);
        }
        this.hvg.setVisibility(4);
        this.hvh.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.hvi.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.hvj.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.hvk.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(l lVar) {
        this.gft = lVar;
    }

    private void j(View view, boolean z) {
        this.hvm.clearAnimation();
        int width = (this.hvm.getWidth() / 2) + this.hvm.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hvm.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.hvm.getWidth() / 2);
        this.hvm.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.hvm.startAnimation(translateAnimation);
        }
    }

    public void setViewData(k kVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (kVar != null && alaLiveVideoConfig != null) {
            com.baidu.live.ar.e eVar = (com.baidu.live.ar.e) kVar;
            this.hvp.setProgress(eVar.aCQ);
            this.hvq.setProgress(eVar.aCR);
            this.hvr.setProgress(eVar.aCS);
            this.hvs.setProgress(eVar.aCU);
            this.hvt.setProgress(eVar.aCT);
            this.hvf.Hx(eVar.mFilterName);
            this.hvf.notifyDataSetChanged();
            this.hvo = eVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.hvj.setVisibility(0);
            } else {
                this.hvj.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
