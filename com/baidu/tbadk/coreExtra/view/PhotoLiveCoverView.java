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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCoverView extends RelativeLayout {
    private boolean apA;
    private RelativeLayout apY;
    private TbImageView apZ;
    private boolean apz;
    private int aqA;
    private int aqB;
    private int aqC;
    private int aqD;
    private int aqE;
    private TextView aqa;
    private TextView aqb;
    private TextView aqc;
    private int aqi;
    private ArrayList<Integer> aqj;
    private boolean aqn;
    private int aqu;
    private int aqv;
    private int aqw;
    private int aqx;
    private int aqy;
    private int aqz;
    private Context context;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aqi = 0;
        this.apz = true;
        this.apA = true;
        this.aqn = true;
        this.aqj = new ArrayList<>();
        this.context = context;
        this.aqu = (int) context.getResources().getDimension(t.e.ds80);
        this.aqv = (int) context.getResources().getDimension(t.e.ds280);
        this.aqw = (int) context.getResources().getDimension(t.e.ds170);
        this.aqx = (int) context.getResources().getDimension(t.e.ds320);
        this.aqy = (int) context.getResources().getDimension(t.e.ds200);
        this.aqz = (int) context.getResources().getDimension(t.e.ds60);
        this.aqA = (int) context.getResources().getDimension(t.e.ds120);
        this.aqB = (int) context.getResources().getDimension(t.e.ds160);
        this.aqC = (int) context.getResources().getDimension(t.e.ds220);
        this.aqD = (int) context.getResources().getDimension(t.e.ds240);
        this.aqE = (int) context.getResources().getDimension(t.e.ds180);
        this.size = (int) context.getResources().getDimension(t.e.ds8);
        init(context);
    }

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCoverView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        this.apY = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(t.h.photo_live_card_cover_and_expression, this).findViewById(t.g.photo_live_card_cover_and_expression);
        AX();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.apz, this.apA, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.aqn) {
                this.apY.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.apY != null) {
                this.apY.setVisibility(8);
            }
        }
    }

    private void AX() {
        if (this.apY != null) {
            this.apZ = (TbImageView) this.apY.findViewById(t.g.live_cover);
            this.apZ.setGifIconSupport(false);
            AZ();
        }
    }

    private void AZ() {
        if (this.apY != null) {
            this.aqa = (TextView) this.apY.findViewById(t.g.first_style_first_expression);
            this.aqb = (TextView) this.apY.findViewById(t.g.first_style_second_expression);
            this.aqc = (TextView) this.apY.findViewById(t.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.aqj.clear();
        Bb();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Ba();
        }
    }

    private void Bb() {
        this.aqa.setText("");
        this.aqb.setText("");
        this.aqc.setText("");
        if (this.aqa.getVisibility() == 8) {
            this.aqa.setVisibility(0);
        }
        if (this.aqb.getVisibility() == 8) {
            this.aqb.setVisibility(0);
        }
        if (this.aqc.getVisibility() == 8) {
            this.aqc.setVisibility(0);
        }
        this.aqj.add(Integer.valueOf(this.aqa.getId()));
        this.aqj.add(Integer.valueOf(this.aqb.getId()));
        this.aqj.add(Integer.valueOf(this.aqc.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.aj(nVar.getLabelName(), String.valueOf(nVar.AM())));
            eg(textView.getId());
        }
    }

    private void a(int i, ArrayList<n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.aqi) {
                case 0:
                    a(this.aqu, this.aqv, this.aqa);
                    a(this.aqw, this.aqx, this.aqb);
                    a(this.aqy, this.aqz, this.aqc);
                    break;
                case 1:
                    a(this.aqz, this.aqA, this.aqa);
                    a(this.aqB, this.aqz, this.aqb);
                    a(this.aqC, this.aqx, this.aqc);
                    break;
                case 2:
                    a(this.aqz, this.aqD, this.aqa);
                    a(this.aqE, this.aqz, this.aqb);
                    a(this.aqC, this.aqx, this.aqc);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.aqa);
            } else if (i == 1) {
                a(arrayList.get(i2), this.aqb);
            } else if (i == 2) {
                a(arrayList.get(i2), this.aqc);
            }
        }
    }

    private void setCover(String str) {
        this.apZ.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.apZ.c(str, 10, false);
        } else {
            this.apZ.c(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void Ba() {
        if (this.aqj.size() != 0) {
            int size = this.aqj.size();
            for (int i = 0; i < size; i++) {
                if (this.aqj.get(i).intValue() == this.aqa.getId()) {
                    this.aqa.setVisibility(8);
                } else if (this.aqj.get(i).intValue() == this.aqb.getId()) {
                    this.aqb.setVisibility(8);
                } else if (this.aqj.get(i).intValue() == this.aqc.getId()) {
                    this.aqc.setVisibility(8);
                }
            }
        }
    }

    private void eg(int i) {
        if (this.aqj.size() != 0) {
            int size = this.aqj.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.aqj.get(i2).intValue() == i) {
                    this.aqj.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.apA = z;
    }

    public void setShowImage(boolean z) {
        this.aqn = z;
    }

    public void setChooseStyle(int i) {
        this.aqi = i;
    }
}
