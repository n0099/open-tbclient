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
    private boolean bnC;
    private boolean bnD;
    private int boA;
    private int boB;
    private int boC;
    private int boD;
    private int boE;
    private int boF;
    private int boG;
    private int boH;
    private RelativeLayout bob;
    private TbImageView boc;
    private TextView bod;
    private TextView boe;
    private TextView bof;
    private int bol;
    private ArrayList<Integer> bom;
    private boolean boq;
    private int box;
    private int boy;
    private int boz;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bol = 0;
        this.bnC = true;
        this.bnD = true;
        this.boq = true;
        this.bom = new ArrayList<>();
        this.box = (int) context.getResources().getDimension(d.e.ds80);
        this.boy = (int) context.getResources().getDimension(d.e.ds280);
        this.boz = (int) context.getResources().getDimension(d.e.ds170);
        this.boA = (int) context.getResources().getDimension(d.e.ds320);
        this.boB = (int) context.getResources().getDimension(d.e.ds200);
        this.boC = (int) context.getResources().getDimension(d.e.ds60);
        this.boD = (int) context.getResources().getDimension(d.e.ds120);
        this.boE = (int) context.getResources().getDimension(d.e.ds160);
        this.boF = (int) context.getResources().getDimension(d.e.ds220);
        this.boG = (int) context.getResources().getDimension(d.e.ds240);
        this.boH = (int) context.getResources().getDimension(d.e.ds180);
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
        this.bob = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.h.photo_live_card_cover_and_expression, this).findViewById(d.g.photo_live_card_cover_and_expression);
        Jr();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.bnC, this.bnD, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.boq) {
                this.bob.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.bob != null) {
                this.bob.setVisibility(8);
            }
        }
    }

    private void Jr() {
        if (this.bob != null) {
            this.boc = (TbImageView) this.bob.findViewById(d.g.live_cover);
            this.boc.setGifIconSupport(false);
            Js();
        }
    }

    private void Js() {
        if (this.bob != null) {
            this.bod = (TextView) this.bob.findViewById(d.g.first_style_first_expression);
            this.boe = (TextView) this.bob.findViewById(d.g.first_style_second_expression);
            this.bof = (TextView) this.bob.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.bom.clear();
        Ju();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Jt();
        }
    }

    private void Ju() {
        this.bod.setText("");
        this.boe.setText("");
        this.bof.setText("");
        if (this.bod.getVisibility() == 8) {
            this.bod.setVisibility(0);
        }
        if (this.boe.getVisibility() == 8) {
            this.boe.setVisibility(0);
        }
        if (this.bof.getVisibility() == 8) {
            this.bof.setVisibility(0);
        }
        this.bom.add(Integer.valueOf(this.bod.getId()));
        this.bom.add(Integer.valueOf(this.boe.getId()));
        this.bom.add(Integer.valueOf(this.bof.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.ak(eVar.getLabelName(), String.valueOf(eVar.Jk())));
            hq(textView.getId());
        }
    }

    private void a(int i, ArrayList<e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.bol) {
                case 0:
                    a(this.box, this.boy, this.bod);
                    a(this.boz, this.boA, this.boe);
                    a(this.boB, this.boC, this.bof);
                    break;
                case 1:
                    a(this.boC, this.boD, this.bod);
                    a(this.boE, this.boC, this.boe);
                    a(this.boF, this.boA, this.bof);
                    break;
                case 2:
                    a(this.boC, this.boG, this.bod);
                    a(this.boH, this.boC, this.boe);
                    a(this.boF, this.boA, this.bof);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.bod);
            } else if (i == 1) {
                a(arrayList.get(i2), this.boe);
            } else if (i == 2) {
                a(arrayList.get(i2), this.bof);
            }
        }
    }

    private void setCover(String str) {
        this.boc.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.boc.startLoad(str, 10, false);
        } else {
            this.boc.startLoad(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void Jt() {
        if (this.bom.size() != 0) {
            int size = this.bom.size();
            for (int i = 0; i < size; i++) {
                if (this.bom.get(i).intValue() == this.bod.getId()) {
                    this.bod.setVisibility(8);
                } else if (this.bom.get(i).intValue() == this.boe.getId()) {
                    this.boe.setVisibility(8);
                } else if (this.bom.get(i).intValue() == this.bof.getId()) {
                    this.bof.setVisibility(8);
                }
            }
        }
    }

    private void hq(int i) {
        if (this.bom.size() != 0) {
            int size = this.bom.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.bom.get(i2).intValue() == i) {
                    this.bom.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.bnD = z;
    }

    public void setShowImage(boolean z) {
        this.boq = z;
    }

    public void setChooseStyle(int i) {
        this.bol = i;
    }
}
