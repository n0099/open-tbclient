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
    private boolean awI;
    private boolean awJ;
    private int axE;
    private int axF;
    private int axG;
    private int axH;
    private int axI;
    private int axJ;
    private int axK;
    private int axL;
    private int axM;
    private int axN;
    private int axO;
    private RelativeLayout axi;
    private TbImageView axj;
    private TextView axk;
    private TextView axl;
    private TextView axm;
    private int axs;
    private ArrayList<Integer> axt;
    private boolean axx;
    private Context context;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.axs = 0;
        this.awI = true;
        this.awJ = true;
        this.axx = true;
        this.axt = new ArrayList<>();
        this.context = context;
        this.axE = (int) context.getResources().getDimension(d.f.ds80);
        this.axF = (int) context.getResources().getDimension(d.f.ds280);
        this.axG = (int) context.getResources().getDimension(d.f.ds170);
        this.axH = (int) context.getResources().getDimension(d.f.ds320);
        this.axI = (int) context.getResources().getDimension(d.f.ds200);
        this.axJ = (int) context.getResources().getDimension(d.f.ds60);
        this.axK = (int) context.getResources().getDimension(d.f.ds120);
        this.axL = (int) context.getResources().getDimension(d.f.ds160);
        this.axM = (int) context.getResources().getDimension(d.f.ds220);
        this.axN = (int) context.getResources().getDimension(d.f.ds240);
        this.axO = (int) context.getResources().getDimension(d.f.ds180);
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
        this.axi = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.j.photo_live_card_cover_and_expression, this).findViewById(d.h.photo_live_card_cover_and_expression);
        Bu();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.awI, this.awJ, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.axx) {
                this.axi.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.axi != null) {
                this.axi.setVisibility(8);
            }
        }
    }

    private void Bu() {
        if (this.axi != null) {
            this.axj = (TbImageView) this.axi.findViewById(d.h.live_cover);
            this.axj.setGifIconSupport(false);
            Bv();
        }
    }

    private void Bv() {
        if (this.axi != null) {
            this.axk = (TextView) this.axi.findViewById(d.h.first_style_first_expression);
            this.axl = (TextView) this.axi.findViewById(d.h.first_style_second_expression);
            this.axm = (TextView) this.axi.findViewById(d.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.axt.clear();
        Bx();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Bw();
        }
    }

    private void Bx() {
        this.axk.setText("");
        this.axl.setText("");
        this.axm.setText("");
        if (this.axk.getVisibility() == 8) {
            this.axk.setVisibility(0);
        }
        if (this.axl.getVisibility() == 8) {
            this.axl.setVisibility(0);
        }
        if (this.axm.getVisibility() == 8) {
            this.axm.setVisibility(0);
        }
        this.axt.add(Integer.valueOf(this.axk.getId()));
        this.axt.add(Integer.valueOf(this.axl.getId()));
        this.axt.add(Integer.valueOf(this.axm.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.al(eVar.getLabelName(), String.valueOf(eVar.Bj())));
            em(textView.getId());
        }
    }

    private void a(int i, ArrayList<e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.axs) {
                case 0:
                    a(this.axE, this.axF, this.axk);
                    a(this.axG, this.axH, this.axl);
                    a(this.axI, this.axJ, this.axm);
                    break;
                case 1:
                    a(this.axJ, this.axK, this.axk);
                    a(this.axL, this.axJ, this.axl);
                    a(this.axM, this.axH, this.axm);
                    break;
                case 2:
                    a(this.axJ, this.axN, this.axk);
                    a(this.axO, this.axJ, this.axl);
                    a(this.axM, this.axH, this.axm);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.axk);
            } else if (i == 1) {
                a(arrayList.get(i2), this.axl);
            } else if (i == 2) {
                a(arrayList.get(i2), this.axm);
            }
        }
    }

    private void setCover(String str) {
        this.axj.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.axj.c(str, 10, false);
        } else {
            this.axj.c(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void Bw() {
        if (this.axt.size() != 0) {
            int size = this.axt.size();
            for (int i = 0; i < size; i++) {
                if (this.axt.get(i).intValue() == this.axk.getId()) {
                    this.axk.setVisibility(8);
                } else if (this.axt.get(i).intValue() == this.axl.getId()) {
                    this.axl.setVisibility(8);
                } else if (this.axt.get(i).intValue() == this.axm.getId()) {
                    this.axm.setVisibility(8);
                }
            }
        }
    }

    private void em(int i) {
        if (this.axt.size() != 0) {
            int size = this.axt.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.axt.get(i2).intValue() == i) {
                    this.axt.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.awJ = z;
    }

    public void setShowImage(boolean z) {
        this.axx = z;
    }

    public void setChooseStyle(int i) {
        this.axs = i;
    }
}
