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
    private RelativeLayout bnO;
    private TbImageView bnP;
    private TextView bnQ;
    private TextView bnR;
    private TextView bnS;
    private int bnY;
    private ArrayList<Integer> bnZ;
    private boolean bnp;
    private boolean bnq;
    private boolean bod;
    private int bok;
    private int bol;
    private int bom;
    private int bon;
    private int boo;
    private int bop;
    private int boq;
    private int bor;
    private int bos;
    private int bot;
    private int bou;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bnY = 0;
        this.bnp = true;
        this.bnq = true;
        this.bod = true;
        this.bnZ = new ArrayList<>();
        this.bok = (int) context.getResources().getDimension(d.e.ds80);
        this.bol = (int) context.getResources().getDimension(d.e.ds280);
        this.bom = (int) context.getResources().getDimension(d.e.ds170);
        this.bon = (int) context.getResources().getDimension(d.e.ds320);
        this.boo = (int) context.getResources().getDimension(d.e.ds200);
        this.bop = (int) context.getResources().getDimension(d.e.ds60);
        this.boq = (int) context.getResources().getDimension(d.e.ds120);
        this.bor = (int) context.getResources().getDimension(d.e.ds160);
        this.bos = (int) context.getResources().getDimension(d.e.ds220);
        this.bot = (int) context.getResources().getDimension(d.e.ds240);
        this.bou = (int) context.getResources().getDimension(d.e.ds180);
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
        this.bnO = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.h.photo_live_card_cover_and_expression, this).findViewById(d.g.photo_live_card_cover_and_expression);
        Jq();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.bnp, this.bnq, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.bod) {
                this.bnO.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.bnO != null) {
                this.bnO.setVisibility(8);
            }
        }
    }

    private void Jq() {
        if (this.bnO != null) {
            this.bnP = (TbImageView) this.bnO.findViewById(d.g.live_cover);
            this.bnP.setGifIconSupport(false);
            Jr();
        }
    }

    private void Jr() {
        if (this.bnO != null) {
            this.bnQ = (TextView) this.bnO.findViewById(d.g.first_style_first_expression);
            this.bnR = (TextView) this.bnO.findViewById(d.g.first_style_second_expression);
            this.bnS = (TextView) this.bnO.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.bnZ.clear();
        Jt();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Js();
        }
    }

    private void Jt() {
        this.bnQ.setText("");
        this.bnR.setText("");
        this.bnS.setText("");
        if (this.bnQ.getVisibility() == 8) {
            this.bnQ.setVisibility(0);
        }
        if (this.bnR.getVisibility() == 8) {
            this.bnR.setVisibility(0);
        }
        if (this.bnS.getVisibility() == 8) {
            this.bnS.setVisibility(0);
        }
        this.bnZ.add(Integer.valueOf(this.bnQ.getId()));
        this.bnZ.add(Integer.valueOf(this.bnR.getId()));
        this.bnZ.add(Integer.valueOf(this.bnS.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.ak(eVar.getLabelName(), String.valueOf(eVar.Jj())));
            hq(textView.getId());
        }
    }

    private void a(int i, ArrayList<e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.bnY) {
                case 0:
                    a(this.bok, this.bol, this.bnQ);
                    a(this.bom, this.bon, this.bnR);
                    a(this.boo, this.bop, this.bnS);
                    break;
                case 1:
                    a(this.bop, this.boq, this.bnQ);
                    a(this.bor, this.bop, this.bnR);
                    a(this.bos, this.bon, this.bnS);
                    break;
                case 2:
                    a(this.bop, this.bot, this.bnQ);
                    a(this.bou, this.bop, this.bnR);
                    a(this.bos, this.bon, this.bnS);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.bnQ);
            } else if (i == 1) {
                a(arrayList.get(i2), this.bnR);
            } else if (i == 2) {
                a(arrayList.get(i2), this.bnS);
            }
        }
    }

    private void setCover(String str) {
        this.bnP.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.bnP.startLoad(str, 10, false);
        } else {
            this.bnP.startLoad(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void Js() {
        if (this.bnZ.size() != 0) {
            int size = this.bnZ.size();
            for (int i = 0; i < size; i++) {
                if (this.bnZ.get(i).intValue() == this.bnQ.getId()) {
                    this.bnQ.setVisibility(8);
                } else if (this.bnZ.get(i).intValue() == this.bnR.getId()) {
                    this.bnR.setVisibility(8);
                } else if (this.bnZ.get(i).intValue() == this.bnS.getId()) {
                    this.bnS.setVisibility(8);
                }
            }
        }
    }

    private void hq(int i) {
        if (this.bnZ.size() != 0) {
            int size = this.bnZ.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.bnZ.get(i2).intValue() == i) {
                    this.bnZ.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.bnq = z;
    }

    public void setShowImage(boolean z) {
        this.bod = z;
    }

    public void setChooseStyle(int i) {
        this.bnY = i;
    }
}
