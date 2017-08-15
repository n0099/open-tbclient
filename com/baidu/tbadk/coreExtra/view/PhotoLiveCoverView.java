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
    private RelativeLayout axW;
    private TbImageView axX;
    private TextView axY;
    private TextView axZ;
    private boolean axw;
    private boolean axx;
    private int ayA;
    private int ayB;
    private int ayC;
    private TextView aya;
    private int ayg;
    private ArrayList<Integer> ayh;
    private boolean ayl;
    private int ays;
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
        this.ayg = 0;
        this.axw = true;
        this.axx = true;
        this.ayl = true;
        this.ayh = new ArrayList<>();
        this.context = context;
        this.ays = (int) context.getResources().getDimension(d.f.ds80);
        this.ayt = (int) context.getResources().getDimension(d.f.ds280);
        this.ayu = (int) context.getResources().getDimension(d.f.ds170);
        this.ayv = (int) context.getResources().getDimension(d.f.ds320);
        this.ayw = (int) context.getResources().getDimension(d.f.ds200);
        this.ayx = (int) context.getResources().getDimension(d.f.ds60);
        this.ayy = (int) context.getResources().getDimension(d.f.ds120);
        this.ayz = (int) context.getResources().getDimension(d.f.ds160);
        this.ayA = (int) context.getResources().getDimension(d.f.ds220);
        this.ayB = (int) context.getResources().getDimension(d.f.ds240);
        this.ayC = (int) context.getResources().getDimension(d.f.ds180);
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
        this.axW = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.j.photo_live_card_cover_and_expression, this).findViewById(d.h.photo_live_card_cover_and_expression);
        Bz();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.axw, this.axx, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.ayl) {
                this.axW.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.axW != null) {
                this.axW.setVisibility(8);
            }
        }
    }

    private void Bz() {
        if (this.axW != null) {
            this.axX = (TbImageView) this.axW.findViewById(d.h.live_cover);
            this.axX.setGifIconSupport(false);
            BA();
        }
    }

    private void BA() {
        if (this.axW != null) {
            this.axY = (TextView) this.axW.findViewById(d.h.first_style_first_expression);
            this.axZ = (TextView) this.axW.findViewById(d.h.first_style_second_expression);
            this.aya = (TextView) this.axW.findViewById(d.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.ayh.clear();
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
        this.axY.setText("");
        this.axZ.setText("");
        this.aya.setText("");
        if (this.axY.getVisibility() == 8) {
            this.axY.setVisibility(0);
        }
        if (this.axZ.getVisibility() == 8) {
            this.axZ.setVisibility(0);
        }
        if (this.aya.getVisibility() == 8) {
            this.aya.setVisibility(0);
        }
        this.ayh.add(Integer.valueOf(this.axY.getId()));
        this.ayh.add(Integer.valueOf(this.axZ.getId()));
        this.ayh.add(Integer.valueOf(this.aya.getId()));
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
            switch (this.ayg) {
                case 0:
                    a(this.ays, this.ayt, this.axY);
                    a(this.ayu, this.ayv, this.axZ);
                    a(this.ayw, this.ayx, this.aya);
                    break;
                case 1:
                    a(this.ayx, this.ayy, this.axY);
                    a(this.ayz, this.ayx, this.axZ);
                    a(this.ayA, this.ayv, this.aya);
                    break;
                case 2:
                    a(this.ayx, this.ayB, this.axY);
                    a(this.ayC, this.ayx, this.axZ);
                    a(this.ayA, this.ayv, this.aya);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.axY);
            } else if (i == 1) {
                a(arrayList.get(i2), this.axZ);
            } else if (i == 2) {
                a(arrayList.get(i2), this.aya);
            }
        }
    }

    private void setCover(String str) {
        this.axX.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.axX.c(str, 10, false);
        } else {
            this.axX.c(null, 10, false);
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
        if (this.ayh.size() != 0) {
            int size = this.ayh.size();
            for (int i = 0; i < size; i++) {
                if (this.ayh.get(i).intValue() == this.axY.getId()) {
                    this.axY.setVisibility(8);
                } else if (this.ayh.get(i).intValue() == this.axZ.getId()) {
                    this.axZ.setVisibility(8);
                } else if (this.ayh.get(i).intValue() == this.aya.getId()) {
                    this.aya.setVisibility(8);
                }
            }
        }
    }

    private void en(int i) {
        if (this.ayh.size() != 0) {
            int size = this.ayh.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.ayh.get(i2).intValue() == i) {
                    this.ayh.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.axx = z;
    }

    public void setShowImage(boolean z) {
        this.ayl = z;
    }

    public void setChooseStyle(int i) {
        this.ayg = i;
    }
}
