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
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCoverView extends RelativeLayout {
    private RelativeLayout auJ;
    private TbImageView auK;
    private TextView auL;
    private TextView auM;
    private TextView auN;
    private int auT;
    private ArrayList<Integer> auU;
    private boolean auY;
    private boolean auj;
    private boolean auk;
    private int avf;
    private int avg;
    private int avh;
    private int avi;
    private int avj;
    private int avk;
    private int avl;
    private int avm;
    private int avn;
    private int avo;
    private int avp;
    private Context context;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auT = 0;
        this.auj = true;
        this.auk = true;
        this.auY = true;
        this.auU = new ArrayList<>();
        this.context = context;
        this.avf = (int) context.getResources().getDimension(w.f.ds80);
        this.avg = (int) context.getResources().getDimension(w.f.ds280);
        this.avh = (int) context.getResources().getDimension(w.f.ds170);
        this.avi = (int) context.getResources().getDimension(w.f.ds320);
        this.avj = (int) context.getResources().getDimension(w.f.ds200);
        this.avk = (int) context.getResources().getDimension(w.f.ds60);
        this.avl = (int) context.getResources().getDimension(w.f.ds120);
        this.avm = (int) context.getResources().getDimension(w.f.ds160);
        this.avn = (int) context.getResources().getDimension(w.f.ds220);
        this.avo = (int) context.getResources().getDimension(w.f.ds240);
        this.avp = (int) context.getResources().getDimension(w.f.ds180);
        this.size = (int) context.getResources().getDimension(w.f.ds8);
        init(context);
    }

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCoverView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        this.auJ = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(w.j.photo_live_card_cover_and_expression, this).findViewById(w.h.photo_live_card_cover_and_expression);
        AL();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.auj, this.auk, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.auY) {
                this.auJ.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.auJ != null) {
                this.auJ.setVisibility(8);
            }
        }
    }

    private void AL() {
        if (this.auJ != null) {
            this.auK = (TbImageView) this.auJ.findViewById(w.h.live_cover);
            this.auK.setGifIconSupport(false);
            AM();
        }
    }

    private void AM() {
        if (this.auJ != null) {
            this.auL = (TextView) this.auJ.findViewById(w.h.first_style_first_expression);
            this.auM = (TextView) this.auJ.findViewById(w.h.first_style_second_expression);
            this.auN = (TextView) this.auJ.findViewById(w.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.auU.clear();
        AO();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            AN();
        }
    }

    private void AO() {
        this.auL.setText("");
        this.auM.setText("");
        this.auN.setText("");
        if (this.auL.getVisibility() == 8) {
            this.auL.setVisibility(0);
        }
        if (this.auM.getVisibility() == 8) {
            this.auM.setVisibility(0);
        }
        if (this.auN.getVisibility() == 8) {
            this.auN.setVisibility(0);
        }
        this.auU.add(Integer.valueOf(this.auL.getId()));
        this.auU.add(Integer.valueOf(this.auM.getId()));
        this.auU.add(Integer.valueOf(this.auN.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.ai(nVar.getLabelName(), String.valueOf(nVar.AA())));
            eh(textView.getId());
        }
    }

    private void a(int i, ArrayList<n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.auT) {
                case 0:
                    a(this.avf, this.avg, this.auL);
                    a(this.avh, this.avi, this.auM);
                    a(this.avj, this.avk, this.auN);
                    break;
                case 1:
                    a(this.avk, this.avl, this.auL);
                    a(this.avm, this.avk, this.auM);
                    a(this.avn, this.avi, this.auN);
                    break;
                case 2:
                    a(this.avk, this.avo, this.auL);
                    a(this.avp, this.avk, this.auM);
                    a(this.avn, this.avi, this.auN);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.auL);
            } else if (i == 1) {
                a(arrayList.get(i2), this.auM);
            } else if (i == 2) {
                a(arrayList.get(i2), this.auN);
            }
        }
    }

    private void setCover(String str) {
        this.auK.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.auK.c(str, 10, false);
        } else {
            this.auK.c(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void AN() {
        if (this.auU.size() != 0) {
            int size = this.auU.size();
            for (int i = 0; i < size; i++) {
                if (this.auU.get(i).intValue() == this.auL.getId()) {
                    this.auL.setVisibility(8);
                } else if (this.auU.get(i).intValue() == this.auM.getId()) {
                    this.auM.setVisibility(8);
                } else if (this.auU.get(i).intValue() == this.auN.getId()) {
                    this.auN.setVisibility(8);
                }
            }
        }
    }

    private void eh(int i) {
        if (this.auU.size() != 0) {
            int size = this.auU.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.auU.get(i2).intValue() == i) {
                    this.auU.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.auk = z;
    }

    public void setShowImage(boolean z) {
        this.auY = z;
    }

    public void setChooseStyle(int i) {
        this.auT = i;
    }
}
