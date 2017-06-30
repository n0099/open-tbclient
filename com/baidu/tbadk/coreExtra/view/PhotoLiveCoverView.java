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
    private RelativeLayout avM;
    private TbImageView avN;
    private TextView avO;
    private TextView avP;
    private TextView avQ;
    private int avW;
    private ArrayList<Integer> avX;
    private boolean avm;
    private boolean avn;
    private boolean awb;
    private int awi;
    private int awj;
    private int awk;
    private int awl;
    private int awm;
    private int awn;
    private int awo;
    private int awp;
    private int awq;
    private int awr;
    private int aws;
    private Context context;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.avW = 0;
        this.avm = true;
        this.avn = true;
        this.awb = true;
        this.avX = new ArrayList<>();
        this.context = context;
        this.awi = (int) context.getResources().getDimension(w.f.ds80);
        this.awj = (int) context.getResources().getDimension(w.f.ds280);
        this.awk = (int) context.getResources().getDimension(w.f.ds170);
        this.awl = (int) context.getResources().getDimension(w.f.ds320);
        this.awm = (int) context.getResources().getDimension(w.f.ds200);
        this.awn = (int) context.getResources().getDimension(w.f.ds60);
        this.awo = (int) context.getResources().getDimension(w.f.ds120);
        this.awp = (int) context.getResources().getDimension(w.f.ds160);
        this.awq = (int) context.getResources().getDimension(w.f.ds220);
        this.awr = (int) context.getResources().getDimension(w.f.ds240);
        this.aws = (int) context.getResources().getDimension(w.f.ds180);
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
        this.avM = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(w.j.photo_live_card_cover_and_expression, this).findViewById(w.h.photo_live_card_cover_and_expression);
        Bg();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.avm, this.avn, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.awb) {
                this.avM.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.avM != null) {
                this.avM.setVisibility(8);
            }
        }
    }

    private void Bg() {
        if (this.avM != null) {
            this.avN = (TbImageView) this.avM.findViewById(w.h.live_cover);
            this.avN.setGifIconSupport(false);
            Bh();
        }
    }

    private void Bh() {
        if (this.avM != null) {
            this.avO = (TextView) this.avM.findViewById(w.h.first_style_first_expression);
            this.avP = (TextView) this.avM.findViewById(w.h.first_style_second_expression);
            this.avQ = (TextView) this.avM.findViewById(w.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.avX.clear();
        Bj();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Bi();
        }
    }

    private void Bj() {
        this.avO.setText("");
        this.avP.setText("");
        this.avQ.setText("");
        if (this.avO.getVisibility() == 8) {
            this.avO.setVisibility(0);
        }
        if (this.avP.getVisibility() == 8) {
            this.avP.setVisibility(0);
        }
        if (this.avQ.getVisibility() == 8) {
            this.avQ.setVisibility(0);
        }
        this.avX.add(Integer.valueOf(this.avO.getId()));
        this.avX.add(Integer.valueOf(this.avP.getId()));
        this.avX.add(Integer.valueOf(this.avQ.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.ai(nVar.getLabelName(), String.valueOf(nVar.AV())));
            ej(textView.getId());
        }
    }

    private void a(int i, ArrayList<n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.avW) {
                case 0:
                    a(this.awi, this.awj, this.avO);
                    a(this.awk, this.awl, this.avP);
                    a(this.awm, this.awn, this.avQ);
                    break;
                case 1:
                    a(this.awn, this.awo, this.avO);
                    a(this.awp, this.awn, this.avP);
                    a(this.awq, this.awl, this.avQ);
                    break;
                case 2:
                    a(this.awn, this.awr, this.avO);
                    a(this.aws, this.awn, this.avP);
                    a(this.awq, this.awl, this.avQ);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.avO);
            } else if (i == 1) {
                a(arrayList.get(i2), this.avP);
            } else if (i == 2) {
                a(arrayList.get(i2), this.avQ);
            }
        }
    }

    private void setCover(String str) {
        this.avN.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.avN.c(str, 10, false);
        } else {
            this.avN.c(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void Bi() {
        if (this.avX.size() != 0) {
            int size = this.avX.size();
            for (int i = 0; i < size; i++) {
                if (this.avX.get(i).intValue() == this.avO.getId()) {
                    this.avO.setVisibility(8);
                } else if (this.avX.get(i).intValue() == this.avP.getId()) {
                    this.avP.setVisibility(8);
                } else if (this.avX.get(i).intValue() == this.avQ.getId()) {
                    this.avQ.setVisibility(8);
                }
            }
        }
    }

    private void ej(int i) {
        if (this.avX.size() != 0) {
            int size = this.avX.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.avX.get(i2).intValue() == i) {
                    this.avX.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.avn = z;
    }

    public void setShowImage(boolean z) {
        this.awb = z;
    }

    public void setChooseStyle(int i) {
        this.avW = i;
    }
}
