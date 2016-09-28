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
    private RelativeLayout apG;
    private TbImageView apH;
    private TextView apI;
    private TextView apJ;
    private TextView apK;
    private int apQ;
    private ArrayList<Integer> apR;
    private boolean apV;
    private boolean apg;
    private boolean aph;
    private int aqc;
    private int aqd;
    private int aqe;
    private int aqf;
    private int aqg;
    private int aqh;
    private int aqi;
    private int aqj;
    private int aqk;
    private int aql;
    private int aqm;
    private Context context;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apQ = 0;
        this.apg = true;
        this.aph = true;
        this.apV = true;
        this.apR = new ArrayList<>();
        this.context = context;
        this.aqc = (int) context.getResources().getDimension(r.e.ds80);
        this.aqd = (int) context.getResources().getDimension(r.e.ds280);
        this.aqe = (int) context.getResources().getDimension(r.e.ds170);
        this.aqf = (int) context.getResources().getDimension(r.e.ds320);
        this.aqg = (int) context.getResources().getDimension(r.e.ds200);
        this.aqh = (int) context.getResources().getDimension(r.e.ds60);
        this.aqi = (int) context.getResources().getDimension(r.e.ds120);
        this.aqj = (int) context.getResources().getDimension(r.e.ds160);
        this.aqk = (int) context.getResources().getDimension(r.e.ds220);
        this.aql = (int) context.getResources().getDimension(r.e.ds240);
        this.aqm = (int) context.getResources().getDimension(r.e.ds180);
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
        this.apG = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(r.h.photo_live_card_cover_and_expression, this).findViewById(r.g.photo_live_card_cover_and_expression);
        Ba();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.apg, this.aph, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.apV) {
                this.apG.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.apG != null) {
                this.apG.setVisibility(8);
            }
        }
    }

    private void Ba() {
        if (this.apG != null) {
            this.apH = (TbImageView) this.apG.findViewById(r.g.live_cover);
            this.apH.setGifIconSupport(false);
            Bc();
        }
    }

    private void Bc() {
        if (this.apG != null) {
            this.apI = (TextView) this.apG.findViewById(r.g.first_style_first_expression);
            this.apJ = (TextView) this.apG.findViewById(r.g.first_style_second_expression);
            this.apK = (TextView) this.apG.findViewById(r.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.apR.clear();
        Be();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Bd();
        }
    }

    private void Be() {
        this.apI.setText("");
        this.apJ.setText("");
        this.apK.setText("");
        if (this.apI.getVisibility() == 8) {
            this.apI.setVisibility(0);
        }
        if (this.apJ.getVisibility() == 8) {
            this.apJ.setVisibility(0);
        }
        if (this.apK.getVisibility() == 8) {
            this.apK.setVisibility(0);
        }
        this.apR.add(Integer.valueOf(this.apI.getId()));
        this.apR.add(Integer.valueOf(this.apJ.getId()));
        this.apR.add(Integer.valueOf(this.apK.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.aj(nVar.getLabelName(), String.valueOf(nVar.AP())));
            eg(textView.getId());
        }
    }

    private void a(int i, ArrayList<n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.apQ) {
                case 0:
                    a(this.aqc, this.aqd, this.apI);
                    a(this.aqe, this.aqf, this.apJ);
                    a(this.aqg, this.aqh, this.apK);
                    break;
                case 1:
                    a(this.aqh, this.aqi, this.apI);
                    a(this.aqj, this.aqh, this.apJ);
                    a(this.aqk, this.aqf, this.apK);
                    break;
                case 2:
                    a(this.aqh, this.aql, this.apI);
                    a(this.aqm, this.aqh, this.apJ);
                    a(this.aqk, this.aqf, this.apK);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.apI);
            } else if (i == 1) {
                a(arrayList.get(i2), this.apJ);
            } else if (i == 2) {
                a(arrayList.get(i2), this.apK);
            }
        }
    }

    private void setCover(String str) {
        this.apH.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.apH.c(str, 10, false);
        } else {
            this.apH.c(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void Bd() {
        if (this.apR.size() != 0) {
            int size = this.apR.size();
            for (int i = 0; i < size; i++) {
                if (this.apR.get(i).intValue() == this.apI.getId()) {
                    this.apI.setVisibility(8);
                } else if (this.apR.get(i).intValue() == this.apJ.getId()) {
                    this.apJ.setVisibility(8);
                } else if (this.apR.get(i).intValue() == this.apK.getId()) {
                    this.apK.setVisibility(8);
                }
            }
        }
    }

    private void eg(int i) {
        if (this.apR.size() != 0) {
            int size = this.apR.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.apR.get(i2).intValue() == i) {
                    this.apR.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.aph = z;
    }

    public void setShowImage(boolean z) {
        this.apV = z;
    }

    public void setChooseStyle(int i) {
        this.apQ = i;
    }
}
