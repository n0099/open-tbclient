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
    private RelativeLayout awI;
    private TbImageView awJ;
    private TextView awK;
    private TextView awL;
    private TextView awM;
    private int awS;
    private ArrayList<Integer> awT;
    private boolean awX;
    private boolean awi;
    private boolean awj;
    private int axe;
    private int axf;
    private int axg;
    private int axh;
    private int axi;
    private int axj;
    private int axk;
    private int axl;
    private int axm;
    private int axn;
    private int axo;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.awS = 0;
        this.awi = true;
        this.awj = true;
        this.awX = true;
        this.awT = new ArrayList<>();
        this.axe = (int) context.getResources().getDimension(d.e.ds80);
        this.axf = (int) context.getResources().getDimension(d.e.ds280);
        this.axg = (int) context.getResources().getDimension(d.e.ds170);
        this.axh = (int) context.getResources().getDimension(d.e.ds320);
        this.axi = (int) context.getResources().getDimension(d.e.ds200);
        this.axj = (int) context.getResources().getDimension(d.e.ds60);
        this.axk = (int) context.getResources().getDimension(d.e.ds120);
        this.axl = (int) context.getResources().getDimension(d.e.ds160);
        this.axm = (int) context.getResources().getDimension(d.e.ds220);
        this.axn = (int) context.getResources().getDimension(d.e.ds240);
        this.axo = (int) context.getResources().getDimension(d.e.ds180);
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
        this.awI = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.h.photo_live_card_cover_and_expression, this).findViewById(d.g.photo_live_card_cover_and_expression);
        Bh();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.awi, this.awj, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.awX) {
                this.awI.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.awI != null) {
                this.awI.setVisibility(8);
            }
        }
    }

    private void Bh() {
        if (this.awI != null) {
            this.awJ = (TbImageView) this.awI.findViewById(d.g.live_cover);
            this.awJ.setGifIconSupport(false);
            Bi();
        }
    }

    private void Bi() {
        if (this.awI != null) {
            this.awK = (TextView) this.awI.findViewById(d.g.first_style_first_expression);
            this.awL = (TextView) this.awI.findViewById(d.g.first_style_second_expression);
            this.awM = (TextView) this.awI.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.awT.clear();
        Bk();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Bj();
        }
    }

    private void Bk() {
        this.awK.setText("");
        this.awL.setText("");
        this.awM.setText("");
        if (this.awK.getVisibility() == 8) {
            this.awK.setVisibility(0);
        }
        if (this.awL.getVisibility() == 8) {
            this.awL.setVisibility(0);
        }
        if (this.awM.getVisibility() == 8) {
            this.awM.setVisibility(0);
        }
        this.awT.add(Integer.valueOf(this.awK.getId()));
        this.awT.add(Integer.valueOf(this.awL.getId()));
        this.awT.add(Integer.valueOf(this.awM.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.ak(eVar.getLabelName(), String.valueOf(eVar.AW())));
            ew(textView.getId());
        }
    }

    private void a(int i, ArrayList<e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.awS) {
                case 0:
                    a(this.axe, this.axf, this.awK);
                    a(this.axg, this.axh, this.awL);
                    a(this.axi, this.axj, this.awM);
                    break;
                case 1:
                    a(this.axj, this.axk, this.awK);
                    a(this.axl, this.axj, this.awL);
                    a(this.axm, this.axh, this.awM);
                    break;
                case 2:
                    a(this.axj, this.axn, this.awK);
                    a(this.axo, this.axj, this.awL);
                    a(this.axm, this.axh, this.awM);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.awK);
            } else if (i == 1) {
                a(arrayList.get(i2), this.awL);
            } else if (i == 2) {
                a(arrayList.get(i2), this.awM);
            }
        }
    }

    private void setCover(String str) {
        this.awJ.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.awJ.startLoad(str, 10, false);
        } else {
            this.awJ.startLoad(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void Bj() {
        if (this.awT.size() != 0) {
            int size = this.awT.size();
            for (int i = 0; i < size; i++) {
                if (this.awT.get(i).intValue() == this.awK.getId()) {
                    this.awK.setVisibility(8);
                } else if (this.awT.get(i).intValue() == this.awL.getId()) {
                    this.awL.setVisibility(8);
                } else if (this.awT.get(i).intValue() == this.awM.getId()) {
                    this.awM.setVisibility(8);
                }
            }
        }
    }

    private void ew(int i) {
        if (this.awT.size() != 0) {
            int size = this.awT.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.awT.get(i2).intValue() == i) {
                    this.awT.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.awj = z;
    }

    public void setShowImage(boolean z) {
        this.awX = z;
    }

    public void setChooseStyle(int i) {
        this.awS = i;
    }
}
