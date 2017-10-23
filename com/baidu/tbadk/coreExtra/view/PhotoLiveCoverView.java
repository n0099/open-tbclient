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
    private boolean avD;
    private boolean avE;
    private int awA;
    private int awB;
    private int awC;
    private int awD;
    private int awE;
    private int awF;
    private int awG;
    private int awH;
    private int awI;
    private int awJ;
    private RelativeLayout awd;
    private TbImageView awe;
    private TextView awf;
    private TextView awg;
    private TextView awh;
    private int awn;
    private ArrayList<Integer> awo;
    private boolean aws;
    private int awz;
    private Context context;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.awn = 0;
        this.avD = true;
        this.avE = true;
        this.aws = true;
        this.awo = new ArrayList<>();
        this.context = context;
        this.awz = (int) context.getResources().getDimension(d.f.ds80);
        this.awA = (int) context.getResources().getDimension(d.f.ds280);
        this.awB = (int) context.getResources().getDimension(d.f.ds170);
        this.awC = (int) context.getResources().getDimension(d.f.ds320);
        this.awD = (int) context.getResources().getDimension(d.f.ds200);
        this.awE = (int) context.getResources().getDimension(d.f.ds60);
        this.awF = (int) context.getResources().getDimension(d.f.ds120);
        this.awG = (int) context.getResources().getDimension(d.f.ds160);
        this.awH = (int) context.getResources().getDimension(d.f.ds220);
        this.awI = (int) context.getResources().getDimension(d.f.ds240);
        this.awJ = (int) context.getResources().getDimension(d.f.ds180);
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
        this.awd = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.j.photo_live_card_cover_and_expression, this).findViewById(d.h.photo_live_card_cover_and_expression);
        AM();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.avD, this.avE, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.aws) {
                this.awd.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.awd != null) {
                this.awd.setVisibility(8);
            }
        }
    }

    private void AM() {
        if (this.awd != null) {
            this.awe = (TbImageView) this.awd.findViewById(d.h.live_cover);
            this.awe.setGifIconSupport(false);
            AN();
        }
    }

    private void AN() {
        if (this.awd != null) {
            this.awf = (TextView) this.awd.findViewById(d.h.first_style_first_expression);
            this.awg = (TextView) this.awd.findViewById(d.h.first_style_second_expression);
            this.awh = (TextView) this.awd.findViewById(d.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.awo.clear();
        AP();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            AO();
        }
    }

    private void AP() {
        this.awf.setText("");
        this.awg.setText("");
        this.awh.setText("");
        if (this.awf.getVisibility() == 8) {
            this.awf.setVisibility(0);
        }
        if (this.awg.getVisibility() == 8) {
            this.awg.setVisibility(0);
        }
        if (this.awh.getVisibility() == 8) {
            this.awh.setVisibility(0);
        }
        this.awo.add(Integer.valueOf(this.awf.getId()));
        this.awo.add(Integer.valueOf(this.awg.getId()));
        this.awo.add(Integer.valueOf(this.awh.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.al(eVar.getLabelName(), String.valueOf(eVar.AB())));
            ew(textView.getId());
        }
    }

    private void a(int i, ArrayList<e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.awn) {
                case 0:
                    a(this.awz, this.awA, this.awf);
                    a(this.awB, this.awC, this.awg);
                    a(this.awD, this.awE, this.awh);
                    break;
                case 1:
                    a(this.awE, this.awF, this.awf);
                    a(this.awG, this.awE, this.awg);
                    a(this.awH, this.awC, this.awh);
                    break;
                case 2:
                    a(this.awE, this.awI, this.awf);
                    a(this.awJ, this.awE, this.awg);
                    a(this.awH, this.awC, this.awh);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.awf);
            } else if (i == 1) {
                a(arrayList.get(i2), this.awg);
            } else if (i == 2) {
                a(arrayList.get(i2), this.awh);
            }
        }
    }

    private void setCover(String str) {
        this.awe.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.awe.c(str, 10, false);
        } else {
            this.awe.c(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void AO() {
        if (this.awo.size() != 0) {
            int size = this.awo.size();
            for (int i = 0; i < size; i++) {
                if (this.awo.get(i).intValue() == this.awf.getId()) {
                    this.awf.setVisibility(8);
                } else if (this.awo.get(i).intValue() == this.awg.getId()) {
                    this.awg.setVisibility(8);
                } else if (this.awo.get(i).intValue() == this.awh.getId()) {
                    this.awh.setVisibility(8);
                }
            }
        }
    }

    private void ew(int i) {
        if (this.awo.size() != 0) {
            int size = this.awo.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.awo.get(i2).intValue() == i) {
                    this.awo.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.avE = z;
    }

    public void setShowImage(boolean z) {
        this.aws = z;
    }

    public void setChooseStyle(int i) {
        this.awn = i;
    }
}
