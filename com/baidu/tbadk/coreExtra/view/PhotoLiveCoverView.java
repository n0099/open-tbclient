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
    private boolean apD;
    private boolean apE;
    private int aqA;
    private int aqB;
    private int aqC;
    private int aqD;
    private int aqE;
    private int aqF;
    private int aqG;
    private int aqH;
    private int aqI;
    private int aqJ;
    private RelativeLayout aqd;
    private TbImageView aqe;
    private TextView aqf;
    private TextView aqg;
    private TextView aqh;
    private int aqn;
    private ArrayList<Integer> aqo;
    private boolean aqs;
    private int aqz;
    private Context context;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aqn = 0;
        this.apD = true;
        this.apE = true;
        this.aqs = true;
        this.aqo = new ArrayList<>();
        this.context = context;
        this.aqz = (int) context.getResources().getDimension(r.e.ds80);
        this.aqA = (int) context.getResources().getDimension(r.e.ds280);
        this.aqB = (int) context.getResources().getDimension(r.e.ds170);
        this.aqC = (int) context.getResources().getDimension(r.e.ds320);
        this.aqD = (int) context.getResources().getDimension(r.e.ds200);
        this.aqE = (int) context.getResources().getDimension(r.e.ds60);
        this.aqF = (int) context.getResources().getDimension(r.e.ds120);
        this.aqG = (int) context.getResources().getDimension(r.e.ds160);
        this.aqH = (int) context.getResources().getDimension(r.e.ds220);
        this.aqI = (int) context.getResources().getDimension(r.e.ds240);
        this.aqJ = (int) context.getResources().getDimension(r.e.ds180);
        this.size = (int) context.getResources().getDimension(r.e.ds8);
        init(context);
    }

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCoverView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        this.aqd = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(r.h.photo_live_card_cover_and_expression, this).findViewById(r.g.photo_live_card_cover_and_expression);
        AU();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.apD, this.apE, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.aqs) {
                this.aqd.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.aqd != null) {
                this.aqd.setVisibility(8);
            }
        }
    }

    private void AU() {
        if (this.aqd != null) {
            this.aqe = (TbImageView) this.aqd.findViewById(r.g.live_cover);
            this.aqe.setGifIconSupport(false);
            AW();
        }
    }

    private void AW() {
        if (this.aqd != null) {
            this.aqf = (TextView) this.aqd.findViewById(r.g.first_style_first_expression);
            this.aqg = (TextView) this.aqd.findViewById(r.g.first_style_second_expression);
            this.aqh = (TextView) this.aqd.findViewById(r.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.aqo.clear();
        AY();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            AX();
        }
    }

    private void AY() {
        this.aqf.setText("");
        this.aqg.setText("");
        this.aqh.setText("");
        if (this.aqf.getVisibility() == 8) {
            this.aqf.setVisibility(0);
        }
        if (this.aqg.getVisibility() == 8) {
            this.aqg.setVisibility(0);
        }
        if (this.aqh.getVisibility() == 8) {
            this.aqh.setVisibility(0);
        }
        this.aqo.add(Integer.valueOf(this.aqf.getId()));
        this.aqo.add(Integer.valueOf(this.aqg.getId()));
        this.aqo.add(Integer.valueOf(this.aqh.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.ak(nVar.getLabelName(), String.valueOf(nVar.AJ())));
            ej(textView.getId());
        }
    }

    private void a(int i, ArrayList<n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.aqn) {
                case 0:
                    a(this.aqz, this.aqA, this.aqf);
                    a(this.aqB, this.aqC, this.aqg);
                    a(this.aqD, this.aqE, this.aqh);
                    break;
                case 1:
                    a(this.aqE, this.aqF, this.aqf);
                    a(this.aqG, this.aqE, this.aqg);
                    a(this.aqH, this.aqC, this.aqh);
                    break;
                case 2:
                    a(this.aqE, this.aqI, this.aqf);
                    a(this.aqJ, this.aqE, this.aqg);
                    a(this.aqH, this.aqC, this.aqh);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.aqf);
            } else if (i == 1) {
                a(arrayList.get(i2), this.aqg);
            } else if (i == 2) {
                a(arrayList.get(i2), this.aqh);
            }
        }
    }

    private void setCover(String str) {
        this.aqe.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.aqe.c(str, 10, false);
        } else {
            this.aqe.c(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void AX() {
        if (this.aqo.size() != 0) {
            int size = this.aqo.size();
            for (int i = 0; i < size; i++) {
                if (this.aqo.get(i).intValue() == this.aqf.getId()) {
                    this.aqf.setVisibility(8);
                } else if (this.aqo.get(i).intValue() == this.aqg.getId()) {
                    this.aqg.setVisibility(8);
                } else if (this.aqo.get(i).intValue() == this.aqh.getId()) {
                    this.aqh.setVisibility(8);
                }
            }
        }
    }

    private void ej(int i) {
        if (this.aqo.size() != 0) {
            int size = this.aqo.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.aqo.get(i2).intValue() == i) {
                    this.aqo.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.apE = z;
    }

    public void setShowImage(boolean z) {
        this.aqs = z;
    }

    public void setChooseStyle(int i) {
        this.aqn = i;
    }
}
