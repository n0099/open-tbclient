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
    private RelativeLayout aqA;
    private TbImageView aqB;
    private TextView aqC;
    private TextView aqD;
    private TextView aqE;
    private int aqK;
    private ArrayList<Integer> aqL;
    private boolean aqP;
    private int aqW;
    private int aqX;
    private int aqY;
    private int aqZ;
    private boolean aqb;
    private boolean aqc;
    private int ara;
    private int arb;
    private int arc;
    private int ard;
    private int are;
    private int arf;
    private int arg;
    private Context context;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aqK = 0;
        this.aqb = true;
        this.aqc = true;
        this.aqP = true;
        this.aqL = new ArrayList<>();
        this.context = context;
        this.aqW = (int) context.getResources().getDimension(r.e.ds80);
        this.aqX = (int) context.getResources().getDimension(r.e.ds280);
        this.aqY = (int) context.getResources().getDimension(r.e.ds170);
        this.aqZ = (int) context.getResources().getDimension(r.e.ds320);
        this.ara = (int) context.getResources().getDimension(r.e.ds200);
        this.arb = (int) context.getResources().getDimension(r.e.ds60);
        this.arc = (int) context.getResources().getDimension(r.e.ds120);
        this.ard = (int) context.getResources().getDimension(r.e.ds160);
        this.are = (int) context.getResources().getDimension(r.e.ds220);
        this.arf = (int) context.getResources().getDimension(r.e.ds240);
        this.arg = (int) context.getResources().getDimension(r.e.ds180);
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
        this.aqA = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(r.h.photo_live_card_cover_and_expression, this).findViewById(r.g.photo_live_card_cover_and_expression);
        Bh();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.aqb, this.aqc, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.aqP) {
                this.aqA.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.aqA != null) {
                this.aqA.setVisibility(8);
            }
        }
    }

    private void Bh() {
        if (this.aqA != null) {
            this.aqB = (TbImageView) this.aqA.findViewById(r.g.live_cover);
            this.aqB.setGifIconSupport(false);
            Bj();
        }
    }

    private void Bj() {
        if (this.aqA != null) {
            this.aqC = (TextView) this.aqA.findViewById(r.g.first_style_first_expression);
            this.aqD = (TextView) this.aqA.findViewById(r.g.first_style_second_expression);
            this.aqE = (TextView) this.aqA.findViewById(r.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.aqL.clear();
        Bl();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Bk();
        }
    }

    private void Bl() {
        this.aqC.setText("");
        this.aqD.setText("");
        this.aqE.setText("");
        if (this.aqC.getVisibility() == 8) {
            this.aqC.setVisibility(0);
        }
        if (this.aqD.getVisibility() == 8) {
            this.aqD.setVisibility(0);
        }
        if (this.aqE.getVisibility() == 8) {
            this.aqE.setVisibility(0);
        }
        this.aqL.add(Integer.valueOf(this.aqC.getId()));
        this.aqL.add(Integer.valueOf(this.aqD.getId()));
        this.aqL.add(Integer.valueOf(this.aqE.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.ak(nVar.getLabelName(), String.valueOf(nVar.AW())));
            ei(textView.getId());
        }
    }

    private void a(int i, ArrayList<n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.aqK) {
                case 0:
                    a(this.aqW, this.aqX, this.aqC);
                    a(this.aqY, this.aqZ, this.aqD);
                    a(this.ara, this.arb, this.aqE);
                    break;
                case 1:
                    a(this.arb, this.arc, this.aqC);
                    a(this.ard, this.arb, this.aqD);
                    a(this.are, this.aqZ, this.aqE);
                    break;
                case 2:
                    a(this.arb, this.arf, this.aqC);
                    a(this.arg, this.arb, this.aqD);
                    a(this.are, this.aqZ, this.aqE);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.aqC);
            } else if (i == 1) {
                a(arrayList.get(i2), this.aqD);
            } else if (i == 2) {
                a(arrayList.get(i2), this.aqE);
            }
        }
    }

    private void setCover(String str) {
        this.aqB.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.aqB.c(str, 10, false);
        } else {
            this.aqB.c(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void Bk() {
        if (this.aqL.size() != 0) {
            int size = this.aqL.size();
            for (int i = 0; i < size; i++) {
                if (this.aqL.get(i).intValue() == this.aqC.getId()) {
                    this.aqC.setVisibility(8);
                } else if (this.aqL.get(i).intValue() == this.aqD.getId()) {
                    this.aqD.setVisibility(8);
                } else if (this.aqL.get(i).intValue() == this.aqE.getId()) {
                    this.aqE.setVisibility(8);
                }
            }
        }
    }

    private void ei(int i) {
        if (this.aqL.size() != 0) {
            int size = this.aqL.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.aqL.get(i2).intValue() == i) {
                    this.aqL.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.aqc = z;
    }

    public void setShowImage(boolean z) {
        this.aqP = z;
    }

    public void setChooseStyle(int i) {
        this.aqK = i;
    }
}
