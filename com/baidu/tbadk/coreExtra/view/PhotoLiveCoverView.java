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
    private boolean awO;
    private boolean awP;
    private boolean axD;
    private int axK;
    private int axL;
    private int axM;
    private int axN;
    private int axO;
    private int axP;
    private int axQ;
    private int axR;
    private int axS;
    private int axT;
    private int axU;
    private RelativeLayout axo;
    private TbImageView axp;
    private TextView axq;
    private TextView axr;
    private TextView axs;
    private int axy;
    private ArrayList<Integer> axz;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.axy = 0;
        this.awO = true;
        this.awP = true;
        this.axD = true;
        this.axz = new ArrayList<>();
        this.axK = (int) context.getResources().getDimension(d.e.ds80);
        this.axL = (int) context.getResources().getDimension(d.e.ds280);
        this.axM = (int) context.getResources().getDimension(d.e.ds170);
        this.axN = (int) context.getResources().getDimension(d.e.ds320);
        this.axO = (int) context.getResources().getDimension(d.e.ds200);
        this.axP = (int) context.getResources().getDimension(d.e.ds60);
        this.axQ = (int) context.getResources().getDimension(d.e.ds120);
        this.axR = (int) context.getResources().getDimension(d.e.ds160);
        this.axS = (int) context.getResources().getDimension(d.e.ds220);
        this.axT = (int) context.getResources().getDimension(d.e.ds240);
        this.axU = (int) context.getResources().getDimension(d.e.ds180);
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
        this.axo = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.h.photo_live_card_cover_and_expression, this).findViewById(d.g.photo_live_card_cover_and_expression);
        Bs();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.awO, this.awP, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.axD) {
                this.axo.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.axo != null) {
                this.axo.setVisibility(8);
            }
        }
    }

    private void Bs() {
        if (this.axo != null) {
            this.axp = (TbImageView) this.axo.findViewById(d.g.live_cover);
            this.axp.setGifIconSupport(false);
            Bt();
        }
    }

    private void Bt() {
        if (this.axo != null) {
            this.axq = (TextView) this.axo.findViewById(d.g.first_style_first_expression);
            this.axr = (TextView) this.axo.findViewById(d.g.first_style_second_expression);
            this.axs = (TextView) this.axo.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.axz.clear();
        Bv();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Bu();
        }
    }

    private void Bv() {
        this.axq.setText("");
        this.axr.setText("");
        this.axs.setText("");
        if (this.axq.getVisibility() == 8) {
            this.axq.setVisibility(0);
        }
        if (this.axr.getVisibility() == 8) {
            this.axr.setVisibility(0);
        }
        if (this.axs.getVisibility() == 8) {
            this.axs.setVisibility(0);
        }
        this.axz.add(Integer.valueOf(this.axq.getId()));
        this.axz.add(Integer.valueOf(this.axr.getId()));
        this.axz.add(Integer.valueOf(this.axs.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.al(eVar.getLabelName(), String.valueOf(eVar.Bh())));
            ex(textView.getId());
        }
    }

    private void a(int i, ArrayList<e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.axy) {
                case 0:
                    a(this.axK, this.axL, this.axq);
                    a(this.axM, this.axN, this.axr);
                    a(this.axO, this.axP, this.axs);
                    break;
                case 1:
                    a(this.axP, this.axQ, this.axq);
                    a(this.axR, this.axP, this.axr);
                    a(this.axS, this.axN, this.axs);
                    break;
                case 2:
                    a(this.axP, this.axT, this.axq);
                    a(this.axU, this.axP, this.axr);
                    a(this.axS, this.axN, this.axs);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.axq);
            } else if (i == 1) {
                a(arrayList.get(i2), this.axr);
            } else if (i == 2) {
                a(arrayList.get(i2), this.axs);
            }
        }
    }

    private void setCover(String str) {
        this.axp.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.axp.startLoad(str, 10, false);
        } else {
            this.axp.startLoad(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void Bu() {
        if (this.axz.size() != 0) {
            int size = this.axz.size();
            for (int i = 0; i < size; i++) {
                if (this.axz.get(i).intValue() == this.axq.getId()) {
                    this.axq.setVisibility(8);
                } else if (this.axz.get(i).intValue() == this.axr.getId()) {
                    this.axr.setVisibility(8);
                } else if (this.axz.get(i).intValue() == this.axs.getId()) {
                    this.axs.setVisibility(8);
                }
            }
        }
    }

    private void ex(int i) {
        if (this.axz.size() != 0) {
            int size = this.axz.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.axz.get(i2).intValue() == i) {
                    this.axz.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.awP = z;
    }

    public void setShowImage(boolean z) {
        this.axD = z;
    }

    public void setChooseStyle(int i) {
        this.axy = i;
    }
}
