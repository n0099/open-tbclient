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
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCoverView extends RelativeLayout {
    private boolean auA;
    private RelativeLayout auZ;
    private boolean auz;
    private int avA;
    private int avB;
    private int avC;
    private int avD;
    private int avE;
    private int avF;
    private TbImageView ava;
    private TextView avb;
    private TextView avc;
    private TextView avd;
    private int avj;
    private ArrayList<Integer> avk;
    private boolean avo;
    private int avv;
    private int avw;
    private int avx;
    private int avy;
    private int avz;
    private Context context;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.avj = 0;
        this.auz = true;
        this.auA = true;
        this.avo = true;
        this.avk = new ArrayList<>();
        this.context = context;
        this.avv = (int) context.getResources().getDimension(w.f.ds80);
        this.avw = (int) context.getResources().getDimension(w.f.ds280);
        this.avx = (int) context.getResources().getDimension(w.f.ds170);
        this.avy = (int) context.getResources().getDimension(w.f.ds320);
        this.avz = (int) context.getResources().getDimension(w.f.ds200);
        this.avA = (int) context.getResources().getDimension(w.f.ds60);
        this.avB = (int) context.getResources().getDimension(w.f.ds120);
        this.avC = (int) context.getResources().getDimension(w.f.ds160);
        this.avD = (int) context.getResources().getDimension(w.f.ds220);
        this.avE = (int) context.getResources().getDimension(w.f.ds240);
        this.avF = (int) context.getResources().getDimension(w.f.ds180);
        this.size = (int) context.getResources().getDimension(w.f.ds8);
        init(context);
    }

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCoverView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        this.auZ = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(w.j.photo_live_card_cover_and_expression, this).findViewById(w.h.photo_live_card_cover_and_expression);
        AS();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.auz, this.auA, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.avo) {
                this.auZ.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.auZ != null) {
                this.auZ.setVisibility(8);
            }
        }
    }

    private void AS() {
        if (this.auZ != null) {
            this.ava = (TbImageView) this.auZ.findViewById(w.h.live_cover);
            this.ava.setGifIconSupport(false);
            AT();
        }
    }

    private void AT() {
        if (this.auZ != null) {
            this.avb = (TextView) this.auZ.findViewById(w.h.first_style_first_expression);
            this.avc = (TextView) this.auZ.findViewById(w.h.first_style_second_expression);
            this.avd = (TextView) this.auZ.findViewById(w.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.avk.clear();
        AV();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            AU();
        }
    }

    private void AV() {
        this.avb.setText("");
        this.avc.setText("");
        this.avd.setText("");
        if (this.avb.getVisibility() == 8) {
            this.avb.setVisibility(0);
        }
        if (this.avc.getVisibility() == 8) {
            this.avc.setVisibility(0);
        }
        if (this.avd.getVisibility() == 8) {
            this.avd.setVisibility(0);
        }
        this.avk.add(Integer.valueOf(this.avb.getId()));
        this.avk.add(Integer.valueOf(this.avc.getId()));
        this.avk.add(Integer.valueOf(this.avd.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.aj(nVar.getLabelName(), String.valueOf(nVar.AH())));
            eg(textView.getId());
        }
    }

    private void a(int i, ArrayList<n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.avj) {
                case 0:
                    a(this.avv, this.avw, this.avb);
                    a(this.avx, this.avy, this.avc);
                    a(this.avz, this.avA, this.avd);
                    break;
                case 1:
                    a(this.avA, this.avB, this.avb);
                    a(this.avC, this.avA, this.avc);
                    a(this.avD, this.avy, this.avd);
                    break;
                case 2:
                    a(this.avA, this.avE, this.avb);
                    a(this.avF, this.avA, this.avc);
                    a(this.avD, this.avy, this.avd);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.avb);
            } else if (i == 1) {
                a(arrayList.get(i2), this.avc);
            } else if (i == 2) {
                a(arrayList.get(i2), this.avd);
            }
        }
    }

    private void setCover(String str) {
        this.ava.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.ava.c(str, 10, false);
        } else {
            this.ava.c(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void AU() {
        if (this.avk.size() != 0) {
            int size = this.avk.size();
            for (int i = 0; i < size; i++) {
                if (this.avk.get(i).intValue() == this.avb.getId()) {
                    this.avb.setVisibility(8);
                } else if (this.avk.get(i).intValue() == this.avc.getId()) {
                    this.avc.setVisibility(8);
                } else if (this.avk.get(i).intValue() == this.avd.getId()) {
                    this.avd.setVisibility(8);
                }
            }
        }
    }

    private void eg(int i) {
        if (this.avk.size() != 0) {
            int size = this.avk.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.avk.get(i2).intValue() == i) {
                    this.avk.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.auA = z;
    }

    public void setShowImage(boolean z) {
        this.avo = z;
    }

    public void setChooseStyle(int i) {
        this.avj = i;
    }
}
