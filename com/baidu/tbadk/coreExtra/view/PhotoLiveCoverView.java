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
    private boolean awR;
    private boolean awS;
    private int axB;
    private ArrayList<Integer> axC;
    private boolean axG;
    private int axN;
    private int axO;
    private int axP;
    private int axQ;
    private int axR;
    private int axS;
    private int axT;
    private int axU;
    private int axV;
    private int axW;
    private int axX;
    private RelativeLayout axr;
    private TbImageView axs;
    private TextView axt;
    private TextView axu;
    private TextView axv;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.axB = 0;
        this.awR = true;
        this.awS = true;
        this.axG = true;
        this.axC = new ArrayList<>();
        this.axN = (int) context.getResources().getDimension(d.e.ds80);
        this.axO = (int) context.getResources().getDimension(d.e.ds280);
        this.axP = (int) context.getResources().getDimension(d.e.ds170);
        this.axQ = (int) context.getResources().getDimension(d.e.ds320);
        this.axR = (int) context.getResources().getDimension(d.e.ds200);
        this.axS = (int) context.getResources().getDimension(d.e.ds60);
        this.axT = (int) context.getResources().getDimension(d.e.ds120);
        this.axU = (int) context.getResources().getDimension(d.e.ds160);
        this.axV = (int) context.getResources().getDimension(d.e.ds220);
        this.axW = (int) context.getResources().getDimension(d.e.ds240);
        this.axX = (int) context.getResources().getDimension(d.e.ds180);
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
        this.axr = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.h.photo_live_card_cover_and_expression, this).findViewById(d.g.photo_live_card_cover_and_expression);
        Bs();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.awR, this.awS, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.axG) {
                this.axr.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.axr != null) {
                this.axr.setVisibility(8);
            }
        }
    }

    private void Bs() {
        if (this.axr != null) {
            this.axs = (TbImageView) this.axr.findViewById(d.g.live_cover);
            this.axs.setGifIconSupport(false);
            Bt();
        }
    }

    private void Bt() {
        if (this.axr != null) {
            this.axt = (TextView) this.axr.findViewById(d.g.first_style_first_expression);
            this.axu = (TextView) this.axr.findViewById(d.g.first_style_second_expression);
            this.axv = (TextView) this.axr.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.axC.clear();
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
        this.axt.setText("");
        this.axu.setText("");
        this.axv.setText("");
        if (this.axt.getVisibility() == 8) {
            this.axt.setVisibility(0);
        }
        if (this.axu.getVisibility() == 8) {
            this.axu.setVisibility(0);
        }
        if (this.axv.getVisibility() == 8) {
            this.axv.setVisibility(0);
        }
        this.axC.add(Integer.valueOf(this.axt.getId()));
        this.axC.add(Integer.valueOf(this.axu.getId()));
        this.axC.add(Integer.valueOf(this.axv.getId()));
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
            switch (this.axB) {
                case 0:
                    a(this.axN, this.axO, this.axt);
                    a(this.axP, this.axQ, this.axu);
                    a(this.axR, this.axS, this.axv);
                    break;
                case 1:
                    a(this.axS, this.axT, this.axt);
                    a(this.axU, this.axS, this.axu);
                    a(this.axV, this.axQ, this.axv);
                    break;
                case 2:
                    a(this.axS, this.axW, this.axt);
                    a(this.axX, this.axS, this.axu);
                    a(this.axV, this.axQ, this.axv);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.axt);
            } else if (i == 1) {
                a(arrayList.get(i2), this.axu);
            } else if (i == 2) {
                a(arrayList.get(i2), this.axv);
            }
        }
    }

    private void setCover(String str) {
        this.axs.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.axs.startLoad(str, 10, false);
        } else {
            this.axs.startLoad(null, 10, false);
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
        if (this.axC.size() != 0) {
            int size = this.axC.size();
            for (int i = 0; i < size; i++) {
                if (this.axC.get(i).intValue() == this.axt.getId()) {
                    this.axt.setVisibility(8);
                } else if (this.axC.get(i).intValue() == this.axu.getId()) {
                    this.axu.setVisibility(8);
                } else if (this.axC.get(i).intValue() == this.axv.getId()) {
                    this.axv.setVisibility(8);
                }
            }
        }
    }

    private void ex(int i) {
        if (this.axC.size() != 0) {
            int size = this.axC.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.axC.get(i2).intValue() == i) {
                    this.axC.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.awS = z;
    }

    public void setShowImage(boolean z) {
        this.axG = z;
    }

    public void setChooseStyle(int i) {
        this.axB = i;
    }
}
