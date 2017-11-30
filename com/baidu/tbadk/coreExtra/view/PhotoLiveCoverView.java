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
    private boolean awJ;
    private boolean awK;
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
    private int axP;
    private RelativeLayout axj;
    private TbImageView axk;
    private TextView axl;
    private TextView axm;
    private TextView axn;
    private int axt;
    private ArrayList<Integer> axu;
    private boolean axy;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.axt = 0;
        this.awJ = true;
        this.awK = true;
        this.axy = true;
        this.axu = new ArrayList<>();
        this.axF = (int) context.getResources().getDimension(d.e.ds80);
        this.axG = (int) context.getResources().getDimension(d.e.ds280);
        this.axH = (int) context.getResources().getDimension(d.e.ds170);
        this.axI = (int) context.getResources().getDimension(d.e.ds320);
        this.axJ = (int) context.getResources().getDimension(d.e.ds200);
        this.axK = (int) context.getResources().getDimension(d.e.ds60);
        this.axL = (int) context.getResources().getDimension(d.e.ds120);
        this.axM = (int) context.getResources().getDimension(d.e.ds160);
        this.axN = (int) context.getResources().getDimension(d.e.ds220);
        this.axO = (int) context.getResources().getDimension(d.e.ds240);
        this.axP = (int) context.getResources().getDimension(d.e.ds180);
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
        this.axj = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.h.photo_live_card_cover_and_expression, this).findViewById(d.g.photo_live_card_cover_and_expression);
        Br();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.awJ, this.awK, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.axy) {
                this.axj.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.axj != null) {
                this.axj.setVisibility(8);
            }
        }
    }

    private void Br() {
        if (this.axj != null) {
            this.axk = (TbImageView) this.axj.findViewById(d.g.live_cover);
            this.axk.setGifIconSupport(false);
            Bs();
        }
    }

    private void Bs() {
        if (this.axj != null) {
            this.axl = (TextView) this.axj.findViewById(d.g.first_style_first_expression);
            this.axm = (TextView) this.axj.findViewById(d.g.first_style_second_expression);
            this.axn = (TextView) this.axj.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.axu.clear();
        Bu();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Bt();
        }
    }

    private void Bu() {
        this.axl.setText("");
        this.axm.setText("");
        this.axn.setText("");
        if (this.axl.getVisibility() == 8) {
            this.axl.setVisibility(0);
        }
        if (this.axm.getVisibility() == 8) {
            this.axm.setVisibility(0);
        }
        if (this.axn.getVisibility() == 8) {
            this.axn.setVisibility(0);
        }
        this.axu.add(Integer.valueOf(this.axl.getId()));
        this.axu.add(Integer.valueOf(this.axm.getId()));
        this.axu.add(Integer.valueOf(this.axn.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.al(eVar.getLabelName(), String.valueOf(eVar.Bg())));
            ex(textView.getId());
        }
    }

    private void a(int i, ArrayList<e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.axt) {
                case 0:
                    a(this.axF, this.axG, this.axl);
                    a(this.axH, this.axI, this.axm);
                    a(this.axJ, this.axK, this.axn);
                    break;
                case 1:
                    a(this.axK, this.axL, this.axl);
                    a(this.axM, this.axK, this.axm);
                    a(this.axN, this.axI, this.axn);
                    break;
                case 2:
                    a(this.axK, this.axO, this.axl);
                    a(this.axP, this.axK, this.axm);
                    a(this.axN, this.axI, this.axn);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.axl);
            } else if (i == 1) {
                a(arrayList.get(i2), this.axm);
            } else if (i == 2) {
                a(arrayList.get(i2), this.axn);
            }
        }
    }

    private void setCover(String str) {
        this.axk.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.axk.startLoad(str, 10, false);
        } else {
            this.axk.startLoad(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void Bt() {
        if (this.axu.size() != 0) {
            int size = this.axu.size();
            for (int i = 0; i < size; i++) {
                if (this.axu.get(i).intValue() == this.axl.getId()) {
                    this.axl.setVisibility(8);
                } else if (this.axu.get(i).intValue() == this.axm.getId()) {
                    this.axm.setVisibility(8);
                } else if (this.axu.get(i).intValue() == this.axn.getId()) {
                    this.axn.setVisibility(8);
                }
            }
        }
    }

    private void ex(int i) {
        if (this.axu.size() != 0) {
            int size = this.axu.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.axu.get(i2).intValue() == i) {
                    this.axu.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.awK = z;
    }

    public void setShowImage(boolean z) {
        this.axy = z;
    }

    public void setChooseStyle(int i) {
        this.axt = i;
    }
}
