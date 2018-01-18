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
    private RelativeLayout blF;
    private TbImageView blG;
    private TextView blH;
    private TextView blI;
    private TextView blJ;
    private int blP;
    private ArrayList<Integer> blQ;
    private boolean blU;
    private boolean blf;
    private boolean blg;
    private int bmb;
    private int bmc;
    private int bmd;
    private int bme;
    private int bmf;
    private int bmg;
    private int bmh;
    private int bmi;
    private int bmj;
    private int bmk;
    private int bml;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.blP = 0;
        this.blf = true;
        this.blg = true;
        this.blU = true;
        this.blQ = new ArrayList<>();
        this.bmb = (int) context.getResources().getDimension(d.e.ds80);
        this.bmc = (int) context.getResources().getDimension(d.e.ds280);
        this.bmd = (int) context.getResources().getDimension(d.e.ds170);
        this.bme = (int) context.getResources().getDimension(d.e.ds320);
        this.bmf = (int) context.getResources().getDimension(d.e.ds200);
        this.bmg = (int) context.getResources().getDimension(d.e.ds60);
        this.bmh = (int) context.getResources().getDimension(d.e.ds120);
        this.bmi = (int) context.getResources().getDimension(d.e.ds160);
        this.bmj = (int) context.getResources().getDimension(d.e.ds220);
        this.bmk = (int) context.getResources().getDimension(d.e.ds240);
        this.bml = (int) context.getResources().getDimension(d.e.ds180);
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
        this.blF = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.h.photo_live_card_cover_and_expression, this).findViewById(d.g.photo_live_card_cover_and_expression);
        IJ();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.blf, this.blg, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.blU) {
                this.blF.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.blF != null) {
                this.blF.setVisibility(8);
            }
        }
    }

    private void IJ() {
        if (this.blF != null) {
            this.blG = (TbImageView) this.blF.findViewById(d.g.live_cover);
            this.blG.setGifIconSupport(false);
            IK();
        }
    }

    private void IK() {
        if (this.blF != null) {
            this.blH = (TextView) this.blF.findViewById(d.g.first_style_first_expression);
            this.blI = (TextView) this.blF.findViewById(d.g.first_style_second_expression);
            this.blJ = (TextView) this.blF.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.blQ.clear();
        IM();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            IL();
        }
    }

    private void IM() {
        this.blH.setText("");
        this.blI.setText("");
        this.blJ.setText("");
        if (this.blH.getVisibility() == 8) {
            this.blH.setVisibility(0);
        }
        if (this.blI.getVisibility() == 8) {
            this.blI.setVisibility(0);
        }
        if (this.blJ.getVisibility() == 8) {
            this.blJ.setVisibility(0);
        }
        this.blQ.add(Integer.valueOf(this.blH.getId()));
        this.blQ.add(Integer.valueOf(this.blI.getId()));
        this.blQ.add(Integer.valueOf(this.blJ.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.ak(eVar.getLabelName(), String.valueOf(eVar.IC())));
            hr(textView.getId());
        }
    }

    private void a(int i, ArrayList<e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.blP) {
                case 0:
                    a(this.bmb, this.bmc, this.blH);
                    a(this.bmd, this.bme, this.blI);
                    a(this.bmf, this.bmg, this.blJ);
                    break;
                case 1:
                    a(this.bmg, this.bmh, this.blH);
                    a(this.bmi, this.bmg, this.blI);
                    a(this.bmj, this.bme, this.blJ);
                    break;
                case 2:
                    a(this.bmg, this.bmk, this.blH);
                    a(this.bml, this.bmg, this.blI);
                    a(this.bmj, this.bme, this.blJ);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.blH);
            } else if (i == 1) {
                a(arrayList.get(i2), this.blI);
            } else if (i == 2) {
                a(arrayList.get(i2), this.blJ);
            }
        }
    }

    private void setCover(String str) {
        this.blG.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.blG.startLoad(str, 10, false);
        } else {
            this.blG.startLoad(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void IL() {
        if (this.blQ.size() != 0) {
            int size = this.blQ.size();
            for (int i = 0; i < size; i++) {
                if (this.blQ.get(i).intValue() == this.blH.getId()) {
                    this.blH.setVisibility(8);
                } else if (this.blQ.get(i).intValue() == this.blI.getId()) {
                    this.blI.setVisibility(8);
                } else if (this.blQ.get(i).intValue() == this.blJ.getId()) {
                    this.blJ.setVisibility(8);
                }
            }
        }
    }

    private void hr(int i) {
        if (this.blQ.size() != 0) {
            int size = this.blQ.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.blQ.get(i2).intValue() == i) {
                    this.blQ.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.blg = z;
    }

    public void setShowImage(boolean z) {
        this.blU = z;
    }

    public void setChooseStyle(int i) {
        this.blP = i;
    }
}
