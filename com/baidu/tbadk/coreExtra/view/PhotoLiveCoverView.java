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
    private RelativeLayout awE;
    private TbImageView awF;
    private TextView awG;
    private TextView awH;
    private TextView awI;
    private int awO;
    private ArrayList<Integer> awP;
    private boolean awT;
    private boolean awe;
    private boolean awf;
    private int axa;
    private int axb;
    private int axc;
    private int axd;
    private int axe;
    private int axf;
    private int axg;
    private int axh;
    private int axi;
    private int axj;
    private int axk;
    private Context context;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.awO = 0;
        this.awe = true;
        this.awf = true;
        this.awT = true;
        this.awP = new ArrayList<>();
        this.context = context;
        this.axa = (int) context.getResources().getDimension(d.f.ds80);
        this.axb = (int) context.getResources().getDimension(d.f.ds280);
        this.axc = (int) context.getResources().getDimension(d.f.ds170);
        this.axd = (int) context.getResources().getDimension(d.f.ds320);
        this.axe = (int) context.getResources().getDimension(d.f.ds200);
        this.axf = (int) context.getResources().getDimension(d.f.ds60);
        this.axg = (int) context.getResources().getDimension(d.f.ds120);
        this.axh = (int) context.getResources().getDimension(d.f.ds160);
        this.axi = (int) context.getResources().getDimension(d.f.ds220);
        this.axj = (int) context.getResources().getDimension(d.f.ds240);
        this.axk = (int) context.getResources().getDimension(d.f.ds180);
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
        this.awE = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.j.photo_live_card_cover_and_expression, this).findViewById(d.h.photo_live_card_cover_and_expression);
        Br();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.awe, this.awf, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.awT) {
                this.awE.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.awE != null) {
                this.awE.setVisibility(8);
            }
        }
    }

    private void Br() {
        if (this.awE != null) {
            this.awF = (TbImageView) this.awE.findViewById(d.h.live_cover);
            this.awF.setGifIconSupport(false);
            Bs();
        }
    }

    private void Bs() {
        if (this.awE != null) {
            this.awG = (TextView) this.awE.findViewById(d.h.first_style_first_expression);
            this.awH = (TextView) this.awE.findViewById(d.h.first_style_second_expression);
            this.awI = (TextView) this.awE.findViewById(d.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.awP.clear();
        Bu();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Bt();
        }
    }

    private void Bu() {
        this.awG.setText("");
        this.awH.setText("");
        this.awI.setText("");
        if (this.awG.getVisibility() == 8) {
            this.awG.setVisibility(0);
        }
        if (this.awH.getVisibility() == 8) {
            this.awH.setVisibility(0);
        }
        if (this.awI.getVisibility() == 8) {
            this.awI.setVisibility(0);
        }
        this.awP.add(Integer.valueOf(this.awG.getId()));
        this.awP.add(Integer.valueOf(this.awH.getId()));
        this.awP.add(Integer.valueOf(this.awI.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.ai(eVar.getLabelName(), String.valueOf(eVar.Bg())));
            el(textView.getId());
        }
    }

    private void a(int i, ArrayList<e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.awO) {
                case 0:
                    a(this.axa, this.axb, this.awG);
                    a(this.axc, this.axd, this.awH);
                    a(this.axe, this.axf, this.awI);
                    break;
                case 1:
                    a(this.axf, this.axg, this.awG);
                    a(this.axh, this.axf, this.awH);
                    a(this.axi, this.axd, this.awI);
                    break;
                case 2:
                    a(this.axf, this.axj, this.awG);
                    a(this.axk, this.axf, this.awH);
                    a(this.axi, this.axd, this.awI);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.awG);
            } else if (i == 1) {
                a(arrayList.get(i2), this.awH);
            } else if (i == 2) {
                a(arrayList.get(i2), this.awI);
            }
        }
    }

    private void setCover(String str) {
        this.awF.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.awF.c(str, 10, false);
        } else {
            this.awF.c(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void Bt() {
        if (this.awP.size() != 0) {
            int size = this.awP.size();
            for (int i = 0; i < size; i++) {
                if (this.awP.get(i).intValue() == this.awG.getId()) {
                    this.awG.setVisibility(8);
                } else if (this.awP.get(i).intValue() == this.awH.getId()) {
                    this.awH.setVisibility(8);
                } else if (this.awP.get(i).intValue() == this.awI.getId()) {
                    this.awI.setVisibility(8);
                }
            }
        }
    }

    private void el(int i) {
        if (this.awP.size() != 0) {
            int size = this.awP.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.awP.get(i2).intValue() == i) {
                    this.awP.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.awf = z;
    }

    public void setShowImage(boolean z) {
        this.awT = z;
    }

    public void setChooseStyle(int i) {
        this.awO = i;
    }
}
