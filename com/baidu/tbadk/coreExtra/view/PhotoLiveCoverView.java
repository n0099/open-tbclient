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
    private boolean avP;
    private boolean avQ;
    private ArrayList<Integer> awA;
    private boolean awE;
    private int awL;
    private int awM;
    private int awN;
    private int awO;
    private int awP;
    private int awQ;
    private int awR;
    private int awS;
    private int awT;
    private int awU;
    private int awV;
    private RelativeLayout awp;
    private TbImageView awq;
    private TextView awr;
    private TextView aws;
    private TextView awt;
    private int awz;
    private Context context;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.awz = 0;
        this.avP = true;
        this.avQ = true;
        this.awE = true;
        this.awA = new ArrayList<>();
        this.context = context;
        this.awL = (int) context.getResources().getDimension(d.f.ds80);
        this.awM = (int) context.getResources().getDimension(d.f.ds280);
        this.awN = (int) context.getResources().getDimension(d.f.ds170);
        this.awO = (int) context.getResources().getDimension(d.f.ds320);
        this.awP = (int) context.getResources().getDimension(d.f.ds200);
        this.awQ = (int) context.getResources().getDimension(d.f.ds60);
        this.awR = (int) context.getResources().getDimension(d.f.ds120);
        this.awS = (int) context.getResources().getDimension(d.f.ds160);
        this.awT = (int) context.getResources().getDimension(d.f.ds220);
        this.awU = (int) context.getResources().getDimension(d.f.ds240);
        this.awV = (int) context.getResources().getDimension(d.f.ds180);
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
        this.awp = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.j.photo_live_card_cover_and_expression, this).findViewById(d.h.photo_live_card_cover_and_expression);
        AS();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.avP, this.avQ, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.awE) {
                this.awp.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.awp != null) {
                this.awp.setVisibility(8);
            }
        }
    }

    private void AS() {
        if (this.awp != null) {
            this.awq = (TbImageView) this.awp.findViewById(d.h.live_cover);
            this.awq.setGifIconSupport(false);
            AT();
        }
    }

    private void AT() {
        if (this.awp != null) {
            this.awr = (TextView) this.awp.findViewById(d.h.first_style_first_expression);
            this.aws = (TextView) this.awp.findViewById(d.h.first_style_second_expression);
            this.awt = (TextView) this.awp.findViewById(d.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.awA.clear();
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
        this.awr.setText("");
        this.aws.setText("");
        this.awt.setText("");
        if (this.awr.getVisibility() == 8) {
            this.awr.setVisibility(0);
        }
        if (this.aws.getVisibility() == 8) {
            this.aws.setVisibility(0);
        }
        if (this.awt.getVisibility() == 8) {
            this.awt.setVisibility(0);
        }
        this.awA.add(Integer.valueOf(this.awr.getId()));
        this.awA.add(Integer.valueOf(this.aws.getId()));
        this.awA.add(Integer.valueOf(this.awt.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.am(eVar.getLabelName(), String.valueOf(eVar.AH())));
            ex(textView.getId());
        }
    }

    private void a(int i, ArrayList<e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.awz) {
                case 0:
                    a(this.awL, this.awM, this.awr);
                    a(this.awN, this.awO, this.aws);
                    a(this.awP, this.awQ, this.awt);
                    break;
                case 1:
                    a(this.awQ, this.awR, this.awr);
                    a(this.awS, this.awQ, this.aws);
                    a(this.awT, this.awO, this.awt);
                    break;
                case 2:
                    a(this.awQ, this.awU, this.awr);
                    a(this.awV, this.awQ, this.aws);
                    a(this.awT, this.awO, this.awt);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.awr);
            } else if (i == 1) {
                a(arrayList.get(i2), this.aws);
            } else if (i == 2) {
                a(arrayList.get(i2), this.awt);
            }
        }
    }

    private void setCover(String str) {
        this.awq.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.awq.c(str, 10, false);
        } else {
            this.awq.c(null, 10, false);
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
        if (this.awA.size() != 0) {
            int size = this.awA.size();
            for (int i = 0; i < size; i++) {
                if (this.awA.get(i).intValue() == this.awr.getId()) {
                    this.awr.setVisibility(8);
                } else if (this.awA.get(i).intValue() == this.aws.getId()) {
                    this.aws.setVisibility(8);
                } else if (this.awA.get(i).intValue() == this.awt.getId()) {
                    this.awt.setVisibility(8);
                }
            }
        }
    }

    private void ex(int i) {
        if (this.awA.size() != 0) {
            int size = this.awA.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.awA.get(i2).intValue() == i) {
                    this.awA.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.avQ = z;
    }

    public void setShowImage(boolean z) {
        this.awE = z;
    }

    public void setChooseStyle(int i) {
        this.awz = i;
    }
}
