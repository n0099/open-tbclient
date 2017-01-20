package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCoverView extends RelativeLayout {
    private boolean aoI;
    private boolean aoJ;
    private int apF;
    private int apG;
    private int apH;
    private int apI;
    private int apJ;
    private int apK;
    private int apL;
    private int apM;
    private int apN;
    private int apO;
    private int apP;
    private RelativeLayout api;
    private TbImageView apj;
    private TextView apk;
    private TextView apl;
    private TextView apm;
    private int apt;
    private ArrayList<Integer> apu;
    private boolean apy;
    private Context context;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apt = 0;
        this.aoI = true;
        this.aoJ = true;
        this.apy = true;
        this.apu = new ArrayList<>();
        this.context = context;
        this.apF = (int) context.getResources().getDimension(r.f.ds80);
        this.apG = (int) context.getResources().getDimension(r.f.ds280);
        this.apH = (int) context.getResources().getDimension(r.f.ds170);
        this.apI = (int) context.getResources().getDimension(r.f.ds320);
        this.apJ = (int) context.getResources().getDimension(r.f.ds200);
        this.apK = (int) context.getResources().getDimension(r.f.ds60);
        this.apL = (int) context.getResources().getDimension(r.f.ds120);
        this.apM = (int) context.getResources().getDimension(r.f.ds160);
        this.apN = (int) context.getResources().getDimension(r.f.ds220);
        this.apO = (int) context.getResources().getDimension(r.f.ds240);
        this.apP = (int) context.getResources().getDimension(r.f.ds180);
        this.size = (int) context.getResources().getDimension(r.f.ds8);
        init(context);
    }

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCoverView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        this.api = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(r.j.photo_live_card_cover_and_expression, this).findViewById(r.h.photo_live_card_cover_and_expression);
        AP();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.aoI, this.aoJ, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.apy) {
                this.api.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.api != null) {
                this.api.setVisibility(8);
            }
        }
    }

    private void AP() {
        if (this.api != null) {
            this.apj = (TbImageView) this.api.findViewById(r.h.live_cover);
            this.apj.setGifIconSupport(false);
            AR();
        }
    }

    private void AR() {
        if (this.api != null) {
            this.apk = (TextView) this.api.findViewById(r.h.first_style_first_expression);
            this.apl = (TextView) this.api.findViewById(r.h.first_style_second_expression);
            this.apm = (TextView) this.api.findViewById(r.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.apu.clear();
        AT();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            AS();
        }
    }

    private void AT() {
        this.apk.setText("");
        this.apl.setText("");
        this.apm.setText("");
        if (this.apk.getVisibility() == 8) {
            this.apk.setVisibility(0);
        }
        if (this.apl.getVisibility() == 8) {
            this.apl.setVisibility(0);
        }
        if (this.apm.getVisibility() == 8) {
            this.apm.setVisibility(0);
        }
        this.apu.add(Integer.valueOf(this.apk.getId()));
        this.apu.add(Integer.valueOf(this.apl.getId()));
        this.apu.add(Integer.valueOf(this.apm.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.ak(nVar.getLabelName(), String.valueOf(nVar.AE())));
            ek(textView.getId());
        }
    }

    private void a(int i, ArrayList<n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.apt) {
                case 0:
                    a(this.apF, this.apG, this.apk);
                    a(this.apH, this.apI, this.apl);
                    a(this.apJ, this.apK, this.apm);
                    break;
                case 1:
                    a(this.apK, this.apL, this.apk);
                    a(this.apM, this.apK, this.apl);
                    a(this.apN, this.apI, this.apm);
                    break;
                case 2:
                    a(this.apK, this.apO, this.apk);
                    a(this.apP, this.apK, this.apl);
                    a(this.apN, this.apI, this.apm);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.apk);
            } else if (i == 1) {
                a(arrayList.get(i2), this.apl);
            } else if (i == 2) {
                a(arrayList.get(i2), this.apm);
            }
        }
    }

    private void setCover(String str) {
        this.apj.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.apj.c(str, 10, false);
        } else {
            this.apj.c(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void AS() {
        if (this.apu.size() != 0) {
            int size = this.apu.size();
            for (int i = 0; i < size; i++) {
                if (this.apu.get(i).intValue() == this.apk.getId()) {
                    this.apk.setVisibility(8);
                } else if (this.apu.get(i).intValue() == this.apl.getId()) {
                    this.apl.setVisibility(8);
                } else if (this.apu.get(i).intValue() == this.apm.getId()) {
                    this.apm.setVisibility(8);
                }
            }
        }
    }

    private void ek(int i) {
        if (this.apu.size() != 0) {
            int size = this.apu.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.apu.get(i2).intValue() == i) {
                    this.apu.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.aoJ = z;
    }

    public void setShowImage(boolean z) {
        this.apy = z;
    }

    public void setChooseStyle(int i) {
        this.apt = i;
    }
}
