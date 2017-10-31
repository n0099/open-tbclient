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
    private RelativeLayout awA;
    private TbImageView awB;
    private TextView awC;
    private TextView awD;
    private TextView awE;
    private int awK;
    private ArrayList<Integer> awL;
    private boolean awP;
    private int awW;
    private int awX;
    private int awY;
    private int awZ;
    private boolean awa;
    private boolean awb;
    private int axa;
    private int axb;
    private int axc;
    private int axd;
    private int axe;
    private int axf;
    private int axg;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.awK = 0;
        this.awa = true;
        this.awb = true;
        this.awP = true;
        this.awL = new ArrayList<>();
        this.awW = (int) context.getResources().getDimension(d.e.ds80);
        this.awX = (int) context.getResources().getDimension(d.e.ds280);
        this.awY = (int) context.getResources().getDimension(d.e.ds170);
        this.awZ = (int) context.getResources().getDimension(d.e.ds320);
        this.axa = (int) context.getResources().getDimension(d.e.ds200);
        this.axb = (int) context.getResources().getDimension(d.e.ds60);
        this.axc = (int) context.getResources().getDimension(d.e.ds120);
        this.axd = (int) context.getResources().getDimension(d.e.ds160);
        this.axe = (int) context.getResources().getDimension(d.e.ds220);
        this.axf = (int) context.getResources().getDimension(d.e.ds240);
        this.axg = (int) context.getResources().getDimension(d.e.ds180);
        this.size = (int) context.getResources().getDimension(d.e.ds8);
        init(context);
    }

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCoverView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        this.awA = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.h.photo_live_card_cover_and_expression, this).findViewById(d.g.photo_live_card_cover_and_expression);
        AV();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.awa, this.awb, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.awP) {
                this.awA.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.awA != null) {
                this.awA.setVisibility(8);
            }
        }
    }

    private void AV() {
        if (this.awA != null) {
            this.awB = (TbImageView) this.awA.findViewById(d.g.live_cover);
            this.awB.setGifIconSupport(false);
            AW();
        }
    }

    private void AW() {
        if (this.awA != null) {
            this.awC = (TextView) this.awA.findViewById(d.g.first_style_first_expression);
            this.awD = (TextView) this.awA.findViewById(d.g.first_style_second_expression);
            this.awE = (TextView) this.awA.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.awL.clear();
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
        this.awC.setText("");
        this.awD.setText("");
        this.awE.setText("");
        if (this.awC.getVisibility() == 8) {
            this.awC.setVisibility(0);
        }
        if (this.awD.getVisibility() == 8) {
            this.awD.setVisibility(0);
        }
        if (this.awE.getVisibility() == 8) {
            this.awE.setVisibility(0);
        }
        this.awL.add(Integer.valueOf(this.awC.getId()));
        this.awL.add(Integer.valueOf(this.awD.getId()));
        this.awL.add(Integer.valueOf(this.awE.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.ak(eVar.getLabelName(), String.valueOf(eVar.AK())));
            ex(textView.getId());
        }
    }

    private void a(int i, ArrayList<e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.awK) {
                case 0:
                    a(this.awW, this.awX, this.awC);
                    a(this.awY, this.awZ, this.awD);
                    a(this.axa, this.axb, this.awE);
                    break;
                case 1:
                    a(this.axb, this.axc, this.awC);
                    a(this.axd, this.axb, this.awD);
                    a(this.axe, this.awZ, this.awE);
                    break;
                case 2:
                    a(this.axb, this.axf, this.awC);
                    a(this.axg, this.axb, this.awD);
                    a(this.axe, this.awZ, this.awE);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.awC);
            } else if (i == 1) {
                a(arrayList.get(i2), this.awD);
            } else if (i == 2) {
                a(arrayList.get(i2), this.awE);
            }
        }
    }

    private void setCover(String str) {
        this.awB.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.awB.startLoad(str, 10, false);
        } else {
            this.awB.startLoad(null, 10, false);
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
        if (this.awL.size() != 0) {
            int size = this.awL.size();
            for (int i = 0; i < size; i++) {
                if (this.awL.get(i).intValue() == this.awC.getId()) {
                    this.awC.setVisibility(8);
                } else if (this.awL.get(i).intValue() == this.awD.getId()) {
                    this.awD.setVisibility(8);
                } else if (this.awL.get(i).intValue() == this.awE.getId()) {
                    this.awE.setVisibility(8);
                }
            }
        }
    }

    private void ex(int i) {
        if (this.awL.size() != 0) {
            int size = this.awL.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.awL.get(i2).intValue() == i) {
                    this.awL.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.awb = z;
    }

    public void setShowImage(boolean z) {
        this.awP = z;
    }

    public void setChooseStyle(int i) {
        this.awK = i;
    }
}
