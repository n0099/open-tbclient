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
    private boolean bkW;
    private boolean bkX;
    private TextView blA;
    private int blG;
    private ArrayList<Integer> blH;
    private boolean blL;
    private int blS;
    private int blT;
    private int blU;
    private int blV;
    private int blW;
    private int blX;
    private int blY;
    private int blZ;
    private RelativeLayout blw;
    private TbImageView blx;
    private TextView bly;
    private TextView blz;
    private int bma;
    private int bmb;
    private int bmc;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.blG = 0;
        this.bkW = true;
        this.bkX = true;
        this.blL = true;
        this.blH = new ArrayList<>();
        this.blS = (int) context.getResources().getDimension(d.e.ds80);
        this.blT = (int) context.getResources().getDimension(d.e.ds280);
        this.blU = (int) context.getResources().getDimension(d.e.ds170);
        this.blV = (int) context.getResources().getDimension(d.e.ds320);
        this.blW = (int) context.getResources().getDimension(d.e.ds200);
        this.blX = (int) context.getResources().getDimension(d.e.ds60);
        this.blY = (int) context.getResources().getDimension(d.e.ds120);
        this.blZ = (int) context.getResources().getDimension(d.e.ds160);
        this.bma = (int) context.getResources().getDimension(d.e.ds220);
        this.bmb = (int) context.getResources().getDimension(d.e.ds240);
        this.bmc = (int) context.getResources().getDimension(d.e.ds180);
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
        this.blw = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.h.photo_live_card_cover_and_expression, this).findViewById(d.g.photo_live_card_cover_and_expression);
        IU();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.bkW, this.bkX, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.blL) {
                this.blw.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.blw != null) {
                this.blw.setVisibility(8);
            }
        }
    }

    private void IU() {
        if (this.blw != null) {
            this.blx = (TbImageView) this.blw.findViewById(d.g.live_cover);
            this.blx.setGifIconSupport(false);
            IV();
        }
    }

    private void IV() {
        if (this.blw != null) {
            this.bly = (TextView) this.blw.findViewById(d.g.first_style_first_expression);
            this.blz = (TextView) this.blw.findViewById(d.g.first_style_second_expression);
            this.blA = (TextView) this.blw.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.blH.clear();
        IX();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            IW();
        }
    }

    private void IX() {
        this.bly.setText("");
        this.blz.setText("");
        this.blA.setText("");
        if (this.bly.getVisibility() == 8) {
            this.bly.setVisibility(0);
        }
        if (this.blz.getVisibility() == 8) {
            this.blz.setVisibility(0);
        }
        if (this.blA.getVisibility() == 8) {
            this.blA.setVisibility(0);
        }
        this.blH.add(Integer.valueOf(this.bly.getId()));
        this.blH.add(Integer.valueOf(this.blz.getId()));
        this.blH.add(Integer.valueOf(this.blA.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.ak(eVar.getLabelName(), String.valueOf(eVar.IJ())));
            hv(textView.getId());
        }
    }

    private void a(int i, ArrayList<e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.blG) {
                case 0:
                    a(this.blS, this.blT, this.bly);
                    a(this.blU, this.blV, this.blz);
                    a(this.blW, this.blX, this.blA);
                    break;
                case 1:
                    a(this.blX, this.blY, this.bly);
                    a(this.blZ, this.blX, this.blz);
                    a(this.bma, this.blV, this.blA);
                    break;
                case 2:
                    a(this.blX, this.bmb, this.bly);
                    a(this.bmc, this.blX, this.blz);
                    a(this.bma, this.blV, this.blA);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.bly);
            } else if (i == 1) {
                a(arrayList.get(i2), this.blz);
            } else if (i == 2) {
                a(arrayList.get(i2), this.blA);
            }
        }
    }

    private void setCover(String str) {
        this.blx.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.blx.startLoad(str, 10, false);
        } else {
            this.blx.startLoad(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void IW() {
        if (this.blH.size() != 0) {
            int size = this.blH.size();
            for (int i = 0; i < size; i++) {
                if (this.blH.get(i).intValue() == this.bly.getId()) {
                    this.bly.setVisibility(8);
                } else if (this.blH.get(i).intValue() == this.blz.getId()) {
                    this.blz.setVisibility(8);
                } else if (this.blH.get(i).intValue() == this.blA.getId()) {
                    this.blA.setVisibility(8);
                }
            }
        }
    }

    private void hv(int i) {
        if (this.blH.size() != 0) {
            int size = this.blH.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.blH.get(i2).intValue() == i) {
                    this.blH.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.bkX = z;
    }

    public void setShowImage(boolean z) {
        this.blL = z;
    }

    public void setChooseStyle(int i) {
        this.blG = i;
    }
}
