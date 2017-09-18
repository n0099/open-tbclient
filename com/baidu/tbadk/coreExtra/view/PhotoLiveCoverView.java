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
    private boolean awF;
    private boolean awG;
    private int axB;
    private int axC;
    private int axD;
    private int axE;
    private int axF;
    private int axG;
    private int axH;
    private int axI;
    private int axJ;
    private int axK;
    private int axL;
    private RelativeLayout axf;
    private TbImageView axg;
    private TextView axh;
    private TextView axi;
    private TextView axj;
    private int axp;
    private ArrayList<Integer> axq;
    private boolean axu;
    private Context context;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.axp = 0;
        this.awF = true;
        this.awG = true;
        this.axu = true;
        this.axq = new ArrayList<>();
        this.context = context;
        this.axB = (int) context.getResources().getDimension(d.f.ds80);
        this.axC = (int) context.getResources().getDimension(d.f.ds280);
        this.axD = (int) context.getResources().getDimension(d.f.ds170);
        this.axE = (int) context.getResources().getDimension(d.f.ds320);
        this.axF = (int) context.getResources().getDimension(d.f.ds200);
        this.axG = (int) context.getResources().getDimension(d.f.ds60);
        this.axH = (int) context.getResources().getDimension(d.f.ds120);
        this.axI = (int) context.getResources().getDimension(d.f.ds160);
        this.axJ = (int) context.getResources().getDimension(d.f.ds220);
        this.axK = (int) context.getResources().getDimension(d.f.ds240);
        this.axL = (int) context.getResources().getDimension(d.f.ds180);
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
        this.axf = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.j.photo_live_card_cover_and_expression, this).findViewById(d.h.photo_live_card_cover_and_expression);
        Bu();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.awF, this.awG, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.axu) {
                this.axf.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.axf != null) {
                this.axf.setVisibility(8);
            }
        }
    }

    private void Bu() {
        if (this.axf != null) {
            this.axg = (TbImageView) this.axf.findViewById(d.h.live_cover);
            this.axg.setGifIconSupport(false);
            Bv();
        }
    }

    private void Bv() {
        if (this.axf != null) {
            this.axh = (TextView) this.axf.findViewById(d.h.first_style_first_expression);
            this.axi = (TextView) this.axf.findViewById(d.h.first_style_second_expression);
            this.axj = (TextView) this.axf.findViewById(d.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.axq.clear();
        Bx();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Bw();
        }
    }

    private void Bx() {
        this.axh.setText("");
        this.axi.setText("");
        this.axj.setText("");
        if (this.axh.getVisibility() == 8) {
            this.axh.setVisibility(0);
        }
        if (this.axi.getVisibility() == 8) {
            this.axi.setVisibility(0);
        }
        if (this.axj.getVisibility() == 8) {
            this.axj.setVisibility(0);
        }
        this.axq.add(Integer.valueOf(this.axh.getId()));
        this.axq.add(Integer.valueOf(this.axi.getId()));
        this.axq.add(Integer.valueOf(this.axj.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.al(eVar.getLabelName(), String.valueOf(eVar.Bj())));
            em(textView.getId());
        }
    }

    private void a(int i, ArrayList<e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.axp) {
                case 0:
                    a(this.axB, this.axC, this.axh);
                    a(this.axD, this.axE, this.axi);
                    a(this.axF, this.axG, this.axj);
                    break;
                case 1:
                    a(this.axG, this.axH, this.axh);
                    a(this.axI, this.axG, this.axi);
                    a(this.axJ, this.axE, this.axj);
                    break;
                case 2:
                    a(this.axG, this.axK, this.axh);
                    a(this.axL, this.axG, this.axi);
                    a(this.axJ, this.axE, this.axj);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.axh);
            } else if (i == 1) {
                a(arrayList.get(i2), this.axi);
            } else if (i == 2) {
                a(arrayList.get(i2), this.axj);
            }
        }
    }

    private void setCover(String str) {
        this.axg.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.axg.c(str, 10, false);
        } else {
            this.axg.c(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void Bw() {
        if (this.axq.size() != 0) {
            int size = this.axq.size();
            for (int i = 0; i < size; i++) {
                if (this.axq.get(i).intValue() == this.axh.getId()) {
                    this.axh.setVisibility(8);
                } else if (this.axq.get(i).intValue() == this.axi.getId()) {
                    this.axi.setVisibility(8);
                } else if (this.axq.get(i).intValue() == this.axj.getId()) {
                    this.axj.setVisibility(8);
                }
            }
        }
    }

    private void em(int i) {
        if (this.axq.size() != 0) {
            int size = this.axq.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.axq.get(i2).intValue() == i) {
                    this.axq.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.awG = z;
    }

    public void setShowImage(boolean z) {
        this.axu = z;
    }

    public void setChooseStyle(int i) {
        this.axp = i;
    }
}
