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
    private RelativeLayout auT;
    private TbImageView auU;
    private TextView auV;
    private TextView auW;
    private TextView auX;
    private boolean aut;
    private boolean auu;
    private int avd;
    private ArrayList<Integer> ave;
    private boolean avi;
    private int avp;
    private int avq;
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
        this.avd = 0;
        this.aut = true;
        this.auu = true;
        this.avi = true;
        this.ave = new ArrayList<>();
        this.context = context;
        this.avp = (int) context.getResources().getDimension(w.f.ds80);
        this.avq = (int) context.getResources().getDimension(w.f.ds280);
        this.avr = (int) context.getResources().getDimension(w.f.ds170);
        this.avs = (int) context.getResources().getDimension(w.f.ds320);
        this.avt = (int) context.getResources().getDimension(w.f.ds200);
        this.avu = (int) context.getResources().getDimension(w.f.ds60);
        this.avv = (int) context.getResources().getDimension(w.f.ds120);
        this.avw = (int) context.getResources().getDimension(w.f.ds160);
        this.avx = (int) context.getResources().getDimension(w.f.ds220);
        this.avy = (int) context.getResources().getDimension(w.f.ds240);
        this.avz = (int) context.getResources().getDimension(w.f.ds180);
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
        this.auT = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(w.j.photo_live_card_cover_and_expression, this).findViewById(w.h.photo_live_card_cover_and_expression);
        BH();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.aut, this.auu, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.avi) {
                this.auT.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.auT != null) {
                this.auT.setVisibility(8);
            }
        }
    }

    private void BH() {
        if (this.auT != null) {
            this.auU = (TbImageView) this.auT.findViewById(w.h.live_cover);
            this.auU.setGifIconSupport(false);
            BI();
        }
    }

    private void BI() {
        if (this.auT != null) {
            this.auV = (TextView) this.auT.findViewById(w.h.first_style_first_expression);
            this.auW = (TextView) this.auT.findViewById(w.h.first_style_second_expression);
            this.auX = (TextView) this.auT.findViewById(w.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.ave.clear();
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
        this.auV.setText("");
        this.auW.setText("");
        this.auX.setText("");
        if (this.auV.getVisibility() == 8) {
            this.auV.setVisibility(0);
        }
        if (this.auW.getVisibility() == 8) {
            this.auW.setVisibility(0);
        }
        if (this.auX.getVisibility() == 8) {
            this.auX.setVisibility(0);
        }
        this.ave.add(Integer.valueOf(this.auV.getId()));
        this.ave.add(Integer.valueOf(this.auW.getId()));
        this.ave.add(Integer.valueOf(this.auX.getId()));
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
            switch (this.avd) {
                case 0:
                    a(this.avp, this.avq, this.auV);
                    a(this.avr, this.avs, this.auW);
                    a(this.avt, this.avu, this.auX);
                    break;
                case 1:
                    a(this.avu, this.avv, this.auV);
                    a(this.avw, this.avu, this.auW);
                    a(this.avx, this.avs, this.auX);
                    break;
                case 2:
                    a(this.avu, this.avy, this.auV);
                    a(this.avz, this.avu, this.auW);
                    a(this.avx, this.avs, this.auX);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.auV);
            } else if (i == 1) {
                a(arrayList.get(i2), this.auW);
            } else if (i == 2) {
                a(arrayList.get(i2), this.auX);
            }
        }
    }

    private void setCover(String str) {
        this.auU.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.auU.c(str, 10, false);
        } else {
            this.auU.c(null, 10, false);
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
        if (this.ave.size() != 0) {
            int size = this.ave.size();
            for (int i = 0; i < size; i++) {
                if (this.ave.get(i).intValue() == this.auV.getId()) {
                    this.auV.setVisibility(8);
                } else if (this.ave.get(i).intValue() == this.auW.getId()) {
                    this.auW.setVisibility(8);
                } else if (this.ave.get(i).intValue() == this.auX.getId()) {
                    this.auX.setVisibility(8);
                }
            }
        }
    }

    private void ei(int i) {
        if (this.ave.size() != 0) {
            int size = this.ave.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.ave.get(i2).intValue() == i) {
                    this.ave.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.auu = z;
    }

    public void setShowImage(boolean z) {
        this.avi = z;
    }

    public void setChooseStyle(int i) {
        this.avd = i;
    }
}
