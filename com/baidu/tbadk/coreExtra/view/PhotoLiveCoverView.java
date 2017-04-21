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
    private RelativeLayout auV;
    private TbImageView auW;
    private TextView auX;
    private TextView auY;
    private TextView auZ;
    private boolean auv;
    private boolean auw;
    private int avA;
    private int avB;
    private int avf;
    private ArrayList<Integer> avg;
    private boolean avk;
    private int avr;
    private int avs;
    private int avt;
    private int avu;
    private int avv;
    private int avw;
    private int avx;
    private int avy;
    private int avz;
    private Context context;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.avf = 0;
        this.auv = true;
        this.auw = true;
        this.avk = true;
        this.avg = new ArrayList<>();
        this.context = context;
        this.avr = (int) context.getResources().getDimension(w.f.ds80);
        this.avs = (int) context.getResources().getDimension(w.f.ds280);
        this.avt = (int) context.getResources().getDimension(w.f.ds170);
        this.avu = (int) context.getResources().getDimension(w.f.ds320);
        this.avv = (int) context.getResources().getDimension(w.f.ds200);
        this.avw = (int) context.getResources().getDimension(w.f.ds60);
        this.avx = (int) context.getResources().getDimension(w.f.ds120);
        this.avy = (int) context.getResources().getDimension(w.f.ds160);
        this.avz = (int) context.getResources().getDimension(w.f.ds220);
        this.avA = (int) context.getResources().getDimension(w.f.ds240);
        this.avB = (int) context.getResources().getDimension(w.f.ds180);
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
        this.auV = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(w.j.photo_live_card_cover_and_expression, this).findViewById(w.h.photo_live_card_cover_and_expression);
        BH();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.auv, this.auw, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.avk) {
                this.auV.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.auV != null) {
                this.auV.setVisibility(8);
            }
        }
    }

    private void BH() {
        if (this.auV != null) {
            this.auW = (TbImageView) this.auV.findViewById(w.h.live_cover);
            this.auW.setGifIconSupport(false);
            BI();
        }
    }

    private void BI() {
        if (this.auV != null) {
            this.auX = (TextView) this.auV.findViewById(w.h.first_style_first_expression);
            this.auY = (TextView) this.auV.findViewById(w.h.first_style_second_expression);
            this.auZ = (TextView) this.auV.findViewById(w.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.avg.clear();
        BK();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            BJ();
        }
    }

    private void BK() {
        this.auX.setText("");
        this.auY.setText("");
        this.auZ.setText("");
        if (this.auX.getVisibility() == 8) {
            this.auX.setVisibility(0);
        }
        if (this.auY.getVisibility() == 8) {
            this.auY.setVisibility(0);
        }
        if (this.auZ.getVisibility() == 8) {
            this.auZ.setVisibility(0);
        }
        this.avg.add(Integer.valueOf(this.auX.getId()));
        this.avg.add(Integer.valueOf(this.auY.getId()));
        this.avg.add(Integer.valueOf(this.auZ.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.aj(nVar.getLabelName(), String.valueOf(nVar.Bw())));
            ei(textView.getId());
        }
    }

    private void a(int i, ArrayList<n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.avf) {
                case 0:
                    a(this.avr, this.avs, this.auX);
                    a(this.avt, this.avu, this.auY);
                    a(this.avv, this.avw, this.auZ);
                    break;
                case 1:
                    a(this.avw, this.avx, this.auX);
                    a(this.avy, this.avw, this.auY);
                    a(this.avz, this.avu, this.auZ);
                    break;
                case 2:
                    a(this.avw, this.avA, this.auX);
                    a(this.avB, this.avw, this.auY);
                    a(this.avz, this.avu, this.auZ);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.auX);
            } else if (i == 1) {
                a(arrayList.get(i2), this.auY);
            } else if (i == 2) {
                a(arrayList.get(i2), this.auZ);
            }
        }
    }

    private void setCover(String str) {
        this.auW.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.auW.c(str, 10, false);
        } else {
            this.auW.c(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void BJ() {
        if (this.avg.size() != 0) {
            int size = this.avg.size();
            for (int i = 0; i < size; i++) {
                if (this.avg.get(i).intValue() == this.auX.getId()) {
                    this.auX.setVisibility(8);
                } else if (this.avg.get(i).intValue() == this.auY.getId()) {
                    this.auY.setVisibility(8);
                } else if (this.avg.get(i).intValue() == this.auZ.getId()) {
                    this.auZ.setVisibility(8);
                }
            }
        }
    }

    private void ei(int i) {
        if (this.avg.size() != 0) {
            int size = this.avg.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.avg.get(i2).intValue() == i) {
                    this.avg.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.auw = z;
    }

    public void setShowImage(boolean z) {
        this.avk = z;
    }

    public void setChooseStyle(int i) {
        this.avf = i;
    }
}
