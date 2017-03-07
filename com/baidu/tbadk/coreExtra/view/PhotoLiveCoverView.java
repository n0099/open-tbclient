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
    private RelativeLayout auD;
    private TbImageView auE;
    private TextView auF;
    private TextView auG;
    private TextView auH;
    private int auN;
    private ArrayList<Integer> auO;
    private boolean auS;
    private int auZ;
    private boolean aud;
    private boolean aue;
    private int ava;
    private int avb;
    private int avc;
    private int avd;
    private int ave;
    private int avf;
    private int avg;
    private int avh;
    private int avi;
    private int avj;
    private Context context;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auN = 0;
        this.aud = true;
        this.aue = true;
        this.auS = true;
        this.auO = new ArrayList<>();
        this.context = context;
        this.auZ = (int) context.getResources().getDimension(w.f.ds80);
        this.ava = (int) context.getResources().getDimension(w.f.ds280);
        this.avb = (int) context.getResources().getDimension(w.f.ds170);
        this.avc = (int) context.getResources().getDimension(w.f.ds320);
        this.avd = (int) context.getResources().getDimension(w.f.ds200);
        this.ave = (int) context.getResources().getDimension(w.f.ds60);
        this.avf = (int) context.getResources().getDimension(w.f.ds120);
        this.avg = (int) context.getResources().getDimension(w.f.ds160);
        this.avh = (int) context.getResources().getDimension(w.f.ds220);
        this.avi = (int) context.getResources().getDimension(w.f.ds240);
        this.avj = (int) context.getResources().getDimension(w.f.ds180);
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
        this.auD = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(w.j.photo_live_card_cover_and_expression, this).findViewById(w.h.photo_live_card_cover_and_expression);
        Bi();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.aud, this.aue, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.auS) {
                this.auD.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.auD != null) {
                this.auD.setVisibility(8);
            }
        }
    }

    private void Bi() {
        if (this.auD != null) {
            this.auE = (TbImageView) this.auD.findViewById(w.h.live_cover);
            this.auE.setGifIconSupport(false);
            Bk();
        }
    }

    private void Bk() {
        if (this.auD != null) {
            this.auF = (TextView) this.auD.findViewById(w.h.first_style_first_expression);
            this.auG = (TextView) this.auD.findViewById(w.h.first_style_second_expression);
            this.auH = (TextView) this.auD.findViewById(w.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.auO.clear();
        Bm();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Bl();
        }
    }

    private void Bm() {
        this.auF.setText("");
        this.auG.setText("");
        this.auH.setText("");
        if (this.auF.getVisibility() == 8) {
            this.auF.setVisibility(0);
        }
        if (this.auG.getVisibility() == 8) {
            this.auG.setVisibility(0);
        }
        if (this.auH.getVisibility() == 8) {
            this.auH.setVisibility(0);
        }
        this.auO.add(Integer.valueOf(this.auF.getId()));
        this.auO.add(Integer.valueOf(this.auG.getId()));
        this.auO.add(Integer.valueOf(this.auH.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.ai(nVar.getLabelName(), String.valueOf(nVar.AX())));
            ef(textView.getId());
        }
    }

    private void a(int i, ArrayList<n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.auN) {
                case 0:
                    a(this.auZ, this.ava, this.auF);
                    a(this.avb, this.avc, this.auG);
                    a(this.avd, this.ave, this.auH);
                    break;
                case 1:
                    a(this.ave, this.avf, this.auF);
                    a(this.avg, this.ave, this.auG);
                    a(this.avh, this.avc, this.auH);
                    break;
                case 2:
                    a(this.ave, this.avi, this.auF);
                    a(this.avj, this.ave, this.auG);
                    a(this.avh, this.avc, this.auH);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.auF);
            } else if (i == 1) {
                a(arrayList.get(i2), this.auG);
            } else if (i == 2) {
                a(arrayList.get(i2), this.auH);
            }
        }
    }

    private void setCover(String str) {
        this.auE.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.auE.c(str, 10, false);
        } else {
            this.auE.c(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void Bl() {
        if (this.auO.size() != 0) {
            int size = this.auO.size();
            for (int i = 0; i < size; i++) {
                if (this.auO.get(i).intValue() == this.auF.getId()) {
                    this.auF.setVisibility(8);
                } else if (this.auO.get(i).intValue() == this.auG.getId()) {
                    this.auG.setVisibility(8);
                } else if (this.auO.get(i).intValue() == this.auH.getId()) {
                    this.auH.setVisibility(8);
                }
            }
        }
    }

    private void ef(int i) {
        if (this.auO.size() != 0) {
            int size = this.auO.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.auO.get(i2).intValue() == i) {
                    this.auO.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.aue = z;
    }

    public void setShowImage(boolean z) {
        this.auS = z;
    }

    public void setChooseStyle(int i) {
        this.auN = i;
    }
}
