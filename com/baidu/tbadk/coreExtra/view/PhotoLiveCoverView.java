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
    private RelativeLayout blN;
    private TbImageView blO;
    private TextView blP;
    private TextView blQ;
    private TextView blR;
    private int blX;
    private ArrayList<Integer> blY;
    private boolean bln;
    private boolean blo;
    private boolean bmc;
    private int bmj;
    private int bmk;
    private int bml;
    private int bmm;
    private int bmn;
    private int bmo;
    private int bmp;
    private int bmq;
    private int bmr;
    private int bms;
    private int bmt;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.blX = 0;
        this.bln = true;
        this.blo = true;
        this.bmc = true;
        this.blY = new ArrayList<>();
        this.bmj = (int) context.getResources().getDimension(d.e.ds80);
        this.bmk = (int) context.getResources().getDimension(d.e.ds280);
        this.bml = (int) context.getResources().getDimension(d.e.ds170);
        this.bmm = (int) context.getResources().getDimension(d.e.ds320);
        this.bmn = (int) context.getResources().getDimension(d.e.ds200);
        this.bmo = (int) context.getResources().getDimension(d.e.ds60);
        this.bmp = (int) context.getResources().getDimension(d.e.ds120);
        this.bmq = (int) context.getResources().getDimension(d.e.ds160);
        this.bmr = (int) context.getResources().getDimension(d.e.ds220);
        this.bms = (int) context.getResources().getDimension(d.e.ds240);
        this.bmt = (int) context.getResources().getDimension(d.e.ds180);
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
        this.blN = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.h.photo_live_card_cover_and_expression, this).findViewById(d.g.photo_live_card_cover_and_expression);
        IL();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.bln, this.blo, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.bmc) {
                this.blN.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.blN != null) {
                this.blN.setVisibility(8);
            }
        }
    }

    private void IL() {
        if (this.blN != null) {
            this.blO = (TbImageView) this.blN.findViewById(d.g.live_cover);
            this.blO.setGifIconSupport(false);
            IM();
        }
    }

    private void IM() {
        if (this.blN != null) {
            this.blP = (TextView) this.blN.findViewById(d.g.first_style_first_expression);
            this.blQ = (TextView) this.blN.findViewById(d.g.first_style_second_expression);
            this.blR = (TextView) this.blN.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.blY.clear();
        IO();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            IN();
        }
    }

    private void IO() {
        this.blP.setText("");
        this.blQ.setText("");
        this.blR.setText("");
        if (this.blP.getVisibility() == 8) {
            this.blP.setVisibility(0);
        }
        if (this.blQ.getVisibility() == 8) {
            this.blQ.setVisibility(0);
        }
        if (this.blR.getVisibility() == 8) {
            this.blR.setVisibility(0);
        }
        this.blY.add(Integer.valueOf(this.blP.getId()));
        this.blY.add(Integer.valueOf(this.blQ.getId()));
        this.blY.add(Integer.valueOf(this.blR.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.aj(eVar.getLabelName(), String.valueOf(eVar.IE())));
            hr(textView.getId());
        }
    }

    private void a(int i, ArrayList<e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.blX) {
                case 0:
                    a(this.bmj, this.bmk, this.blP);
                    a(this.bml, this.bmm, this.blQ);
                    a(this.bmn, this.bmo, this.blR);
                    break;
                case 1:
                    a(this.bmo, this.bmp, this.blP);
                    a(this.bmq, this.bmo, this.blQ);
                    a(this.bmr, this.bmm, this.blR);
                    break;
                case 2:
                    a(this.bmo, this.bms, this.blP);
                    a(this.bmt, this.bmo, this.blQ);
                    a(this.bmr, this.bmm, this.blR);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.blP);
            } else if (i == 1) {
                a(arrayList.get(i2), this.blQ);
            } else if (i == 2) {
                a(arrayList.get(i2), this.blR);
            }
        }
    }

    private void setCover(String str) {
        this.blO.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.blO.startLoad(str, 10, false);
        } else {
            this.blO.startLoad(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void IN() {
        if (this.blY.size() != 0) {
            int size = this.blY.size();
            for (int i = 0; i < size; i++) {
                if (this.blY.get(i).intValue() == this.blP.getId()) {
                    this.blP.setVisibility(8);
                } else if (this.blY.get(i).intValue() == this.blQ.getId()) {
                    this.blQ.setVisibility(8);
                } else if (this.blY.get(i).intValue() == this.blR.getId()) {
                    this.blR.setVisibility(8);
                }
            }
        }
    }

    private void hr(int i) {
        if (this.blY.size() != 0) {
            int size = this.blY.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.blY.get(i2).intValue() == i) {
                    this.blY.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.blo = z;
    }

    public void setShowImage(boolean z) {
        this.bmc = z;
    }

    public void setChooseStyle(int i) {
        this.blX = i;
    }
}
