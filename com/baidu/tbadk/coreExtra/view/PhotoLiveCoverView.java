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
    private RelativeLayout axV;
    private TbImageView axW;
    private TextView axX;
    private TextView axY;
    private TextView axZ;
    private boolean axv;
    private boolean axw;
    private int ayA;
    private int ayB;
    private int ayf;
    private ArrayList<Integer> ayg;
    private boolean ayk;
    private int ayr;
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
        this.ayf = 0;
        this.axv = true;
        this.axw = true;
        this.ayk = true;
        this.ayg = new ArrayList<>();
        this.context = context;
        this.ayr = (int) context.getResources().getDimension(d.f.ds80);
        this.ays = (int) context.getResources().getDimension(d.f.ds280);
        this.ayt = (int) context.getResources().getDimension(d.f.ds170);
        this.ayu = (int) context.getResources().getDimension(d.f.ds320);
        this.ayv = (int) context.getResources().getDimension(d.f.ds200);
        this.ayw = (int) context.getResources().getDimension(d.f.ds60);
        this.ayx = (int) context.getResources().getDimension(d.f.ds120);
        this.ayy = (int) context.getResources().getDimension(d.f.ds160);
        this.ayz = (int) context.getResources().getDimension(d.f.ds220);
        this.ayA = (int) context.getResources().getDimension(d.f.ds240);
        this.ayB = (int) context.getResources().getDimension(d.f.ds180);
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
        this.axV = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.j.photo_live_card_cover_and_expression, this).findViewById(d.h.photo_live_card_cover_and_expression);
        Bz();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.axv, this.axw, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.ayk) {
                this.axV.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.axV != null) {
                this.axV.setVisibility(8);
            }
        }
    }

    private void Bz() {
        if (this.axV != null) {
            this.axW = (TbImageView) this.axV.findViewById(d.h.live_cover);
            this.axW.setGifIconSupport(false);
            BA();
        }
    }

    private void BA() {
        if (this.axV != null) {
            this.axX = (TextView) this.axV.findViewById(d.h.first_style_first_expression);
            this.axY = (TextView) this.axV.findViewById(d.h.first_style_second_expression);
            this.axZ = (TextView) this.axV.findViewById(d.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.ayg.clear();
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
        this.axX.setText("");
        this.axY.setText("");
        this.axZ.setText("");
        if (this.axX.getVisibility() == 8) {
            this.axX.setVisibility(0);
        }
        if (this.axY.getVisibility() == 8) {
            this.axY.setVisibility(0);
        }
        if (this.axZ.getVisibility() == 8) {
            this.axZ.setVisibility(0);
        }
        this.ayg.add(Integer.valueOf(this.axX.getId()));
        this.ayg.add(Integer.valueOf(this.axY.getId()));
        this.ayg.add(Integer.valueOf(this.axZ.getId()));
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
            switch (this.ayf) {
                case 0:
                    a(this.ayr, this.ays, this.axX);
                    a(this.ayt, this.ayu, this.axY);
                    a(this.ayv, this.ayw, this.axZ);
                    break;
                case 1:
                    a(this.ayw, this.ayx, this.axX);
                    a(this.ayy, this.ayw, this.axY);
                    a(this.ayz, this.ayu, this.axZ);
                    break;
                case 2:
                    a(this.ayw, this.ayA, this.axX);
                    a(this.ayB, this.ayw, this.axY);
                    a(this.ayz, this.ayu, this.axZ);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.axX);
            } else if (i == 1) {
                a(arrayList.get(i2), this.axY);
            } else if (i == 2) {
                a(arrayList.get(i2), this.axZ);
            }
        }
    }

    private void setCover(String str) {
        this.axW.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.axW.c(str, 10, false);
        } else {
            this.axW.c(null, 10, false);
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
        if (this.ayg.size() != 0) {
            int size = this.ayg.size();
            for (int i = 0; i < size; i++) {
                if (this.ayg.get(i).intValue() == this.axX.getId()) {
                    this.axX.setVisibility(8);
                } else if (this.ayg.get(i).intValue() == this.axY.getId()) {
                    this.axY.setVisibility(8);
                } else if (this.ayg.get(i).intValue() == this.axZ.getId()) {
                    this.axZ.setVisibility(8);
                }
            }
        }
    }

    private void en(int i) {
        if (this.ayg.size() != 0) {
            int size = this.ayg.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.ayg.get(i2).intValue() == i) {
                    this.ayg.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.axw = z;
    }

    public void setShowImage(boolean z) {
        this.ayk = z;
    }

    public void setChooseStyle(int i) {
        this.ayf = i;
    }
}
