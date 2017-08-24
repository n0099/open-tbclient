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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCoverView extends RelativeLayout {
    private RelativeLayout axX;
    private TbImageView axY;
    private TextView axZ;
    private boolean axx;
    private boolean axy;
    private int ayA;
    private int ayB;
    private int ayC;
    private int ayD;
    private TextView aya;
    private TextView ayb;
    private int ayh;
    private ArrayList<Integer> ayi;
    private boolean aym;
    private int ayt;
    private int ayu;
    private int ayv;
    private int ayw;
    private int ayx;
    private int ayy;
    private int ayz;
    private Context context;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ayh = 0;
        this.axx = true;
        this.axy = true;
        this.aym = true;
        this.ayi = new ArrayList<>();
        this.context = context;
        this.ayt = (int) context.getResources().getDimension(d.f.ds80);
        this.ayu = (int) context.getResources().getDimension(d.f.ds280);
        this.ayv = (int) context.getResources().getDimension(d.f.ds170);
        this.ayw = (int) context.getResources().getDimension(d.f.ds320);
        this.ayx = (int) context.getResources().getDimension(d.f.ds200);
        this.ayy = (int) context.getResources().getDimension(d.f.ds60);
        this.ayz = (int) context.getResources().getDimension(d.f.ds120);
        this.ayA = (int) context.getResources().getDimension(d.f.ds160);
        this.ayB = (int) context.getResources().getDimension(d.f.ds220);
        this.ayC = (int) context.getResources().getDimension(d.f.ds240);
        this.ayD = (int) context.getResources().getDimension(d.f.ds180);
        this.size = (int) context.getResources().getDimension(d.f.ds8);
        init(context);
    }

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCoverView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        this.axX = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.j.photo_live_card_cover_and_expression, this).findViewById(d.h.photo_live_card_cover_and_expression);
        Bz();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.axx, this.axy, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.aym) {
                this.axX.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.axX != null) {
                this.axX.setVisibility(8);
            }
        }
    }

    private void Bz() {
        if (this.axX != null) {
            this.axY = (TbImageView) this.axX.findViewById(d.h.live_cover);
            this.axY.setGifIconSupport(false);
            BA();
        }
    }

    private void BA() {
        if (this.axX != null) {
            this.axZ = (TextView) this.axX.findViewById(d.h.first_style_first_expression);
            this.aya = (TextView) this.axX.findViewById(d.h.first_style_second_expression);
            this.ayb = (TextView) this.axX.findViewById(d.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.ayi.clear();
        BC();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            BB();
        }
    }

    private void BC() {
        this.axZ.setText("");
        this.aya.setText("");
        this.ayb.setText("");
        if (this.axZ.getVisibility() == 8) {
            this.axZ.setVisibility(0);
        }
        if (this.aya.getVisibility() == 8) {
            this.aya.setVisibility(0);
        }
        if (this.ayb.getVisibility() == 8) {
            this.ayb.setVisibility(0);
        }
        this.ayi.add(Integer.valueOf(this.axZ.getId()));
        this.ayi.add(Integer.valueOf(this.aya.getId()));
        this.ayi.add(Integer.valueOf(this.ayb.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.ai(eVar.getLabelName(), String.valueOf(eVar.Bo())));
            en(textView.getId());
        }
    }

    private void a(int i, ArrayList<e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.ayh) {
                case 0:
                    a(this.ayt, this.ayu, this.axZ);
                    a(this.ayv, this.ayw, this.aya);
                    a(this.ayx, this.ayy, this.ayb);
                    break;
                case 1:
                    a(this.ayy, this.ayz, this.axZ);
                    a(this.ayA, this.ayy, this.aya);
                    a(this.ayB, this.ayw, this.ayb);
                    break;
                case 2:
                    a(this.ayy, this.ayC, this.axZ);
                    a(this.ayD, this.ayy, this.aya);
                    a(this.ayB, this.ayw, this.ayb);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.axZ);
            } else if (i == 1) {
                a(arrayList.get(i2), this.aya);
            } else if (i == 2) {
                a(arrayList.get(i2), this.ayb);
            }
        }
    }

    private void setCover(String str) {
        this.axY.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.axY.c(str, 10, false);
        } else {
            this.axY.c(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void BB() {
        if (this.ayi.size() != 0) {
            int size = this.ayi.size();
            for (int i = 0; i < size; i++) {
                if (this.ayi.get(i).intValue() == this.axZ.getId()) {
                    this.axZ.setVisibility(8);
                } else if (this.ayi.get(i).intValue() == this.aya.getId()) {
                    this.aya.setVisibility(8);
                } else if (this.ayi.get(i).intValue() == this.ayb.getId()) {
                    this.ayb.setVisibility(8);
                }
            }
        }
    }

    private void en(int i) {
        if (this.ayi.size() != 0) {
            int size = this.ayi.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.ayi.get(i2).intValue() == i) {
                    this.ayi.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.axy = z;
    }

    public void setShowImage(boolean z) {
        this.aym = z;
    }

    public void setChooseStyle(int i) {
        this.ayh = i;
    }
}
